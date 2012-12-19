/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.contentoutline;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.extension.BadClassNameException;
import org.eclipse.papyrus.infra.core.extension.NotFoundException;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.EditorDescriptorExtensionFactory;
import org.osgi.framework.Bundle;

public class ContentOutlineRegistry {

	/** ID of the editor extension (schema filename) */
	public static final String EDITOR_EXTENSION_ID = "papyrusContentOutline";

	private static String classAttributeName = "class";

	private static String actionBarContributorIdPropertyName = "actionBarContributorId";

	/** Namespace where to look for the extension points. */
	protected String extensionPointNamespace;

	/**
	 * The selected content outline.
	 */
	protected IPapyrusContentOutlinePage contentOutline;

	/**
	 * Associated editor.
	 */
	private IMultiDiagramEditor multiEditor;

	/**
	 * Constructor. defaultContext, input and site are explicitly required in
	 * order be sure that they are initialized. The multiEditor should be
	 * initialized. In particular, getEditorSite(), getEditorInput() and
	 * getDefaultContext() should return initialized values.
	 * 
	 * @param multiEditor
	 * @param defaultContext
	 * @param input
	 * @param site
	 * @param extensionPointNamespace
	 */
	public ContentOutlineRegistry(IMultiDiagramEditor multiEditor, String extensionPointNamespace) {
		this.multiEditor = multiEditor;
		this.extensionPointNamespace = extensionPointNamespace;
	}

	/**
	 * Returns the single instance of the content outline. Creates one if
	 * necessary.
	 * 
	 * @return the contentOutline the single instance of the content outline
	 * @throws BackboneException
	 *         exception thrown when the outline can not be created.
	 */
	public IPapyrusContentOutlinePage getContentOutline() throws BackboneException {
		if(contentOutline == null) {
			createContentOutline();
		}
		return contentOutline;
	}

	/**
	 * Return the {@link ContentOutlineDescriptor} with the highest priority.
	 * 
	 * @return
	 * @throws BackboneException
	 * @throws NotFoundException
	 *         If no ContentOutline can be found in extensions
	 */
	private ContentOutlineDescriptor getContentOutlineDescriptor() throws BackboneException {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, EDITOR_EXTENSION_ID);
		ContentOutlineDescriptor found = null;

		// look for the one with the highest priority
		for(IConfigurationElement ele : configElements) {
			ContentOutlineDescriptor desc = new ContentOutlineDescriptor(ele);
			if(desc.isHigher(found)) {
				found = desc;
			}
		}

		// Instanciate the object
		if(found == null) {
			throw new NotFoundException("No ContentOutline registered.");
		}

		return found;

	}

	/**
	 * Creates the content outline from the selected extension.
	 * 
	 * @throws BackboneException
	 *         exception thrown when the outline can not be created.
	 */
	private void createContentOutline() throws BackboneException {

		ContentOutlineDescriptor found = getContentOutlineDescriptor();
		// Instanciate the object
		if(found != null) {
			contentOutline = found.createContentOutlinePage();
		}
	}

	/**
	 * Inner Descriptor for content outline. This class load data from Eclipse
	 * extension mechanism TODO Change the parent class. It is here just to have
	 * quick code.
	 */
	protected class ContentOutlineDescriptor extends EditorDescriptorExtensionFactory {

		private int priority;

		private String className;

		private String actionBarContributorID;

		private IConfigurationElement element;

		/**
		 * Instance is created when requested.
		 */
		protected IPapyrusContentOutlinePage instance = null;

		/**
		 * Create a descriptor backuped by the config element.
		 */
		protected ContentOutlineDescriptor(IConfigurationElement element) throws BackboneException {
			String tagName = "contentoutline";
			checkTagName(element, tagName);
			this.className = element.getAttribute(classAttributeName);
			this.actionBarContributorID = element.getAttribute(actionBarContributorIdPropertyName);
			try {
				this.priority = Integer.parseInt(element.getAttribute("priority"));
			} catch (NumberFormatException e) {
				this.priority = 0;
			}

			this.element = element;
			// check parameters
			if(className == null) {
				throw new BadClassNameException("Class name must be set", "contentoutline", classAttributeName);
			}

		}

		/**
		 * Compare priority. The highest priority win.
		 */
		public boolean isHigher(ContentOutlineDescriptor found) {
			if(found == null) {
				return true;
			}
			return this.getPriority() > found.getPriority();
		}

		/**
		 * Return the higher value of the descriptor. This value is used to
		 * order the contentOutline. The highest priority win.
		 */
		private int getPriority() {
			return priority;
		}

		/**
		 * @return the actionBarContributorID
		 */
		public String getActionBarContributorID() {
			return actionBarContributorID;
		}

		/**
		 * Returns the content outline page instance (lazy initialization)
		 * 
		 * @return the context outline page
		 * @throws BackboneException
		 *         exception thrown when a problem occurs.
		 */
		protected IPapyrusContentOutlinePage getContentOutline() throws BackboneException {
			if(instance == null) {
				instance = createContentOutlinePage();
			}
			return instance;
		}

		/**
		 * Create the class corresponding to the class attribute.
		 */
		private Class<IPapyrusContentOutlinePage> loadClass() throws BadClassNameException {
			if(className == null || className.length() == 0) {
				throw new BadClassNameException("Classname should be set.", "contentoutline", classAttributeName);
			}
			Class<IPapyrusContentOutlinePage> factoryClass;
			try {
				factoryClass = (Class<IPapyrusContentOutlinePage>)Class.forName(className);
			} catch (ClassNotFoundException e) {
				// try another way
				try {
					String declaringID = element.getContributor().getName();
					Bundle bundle = Platform.getBundle(declaringID);
					factoryClass = (Class<IPapyrusContentOutlinePage>)bundle.loadClass(className);
				} catch (ClassNotFoundException e1) {
					throw new BadClassNameException("", "contentoutline", classAttributeName, e1);
				}
			}
			return factoryClass;
		}

		/**
		 * create the outlinepage by calling constructor without parameter and
		 * then call init method
		 * 
		 * @return the outline.
		 * @throws BackboneException
		 */
		protected IPapyrusContentOutlinePage createContentOutlinePage() throws BackboneException {
			try {
				IPapyrusContentOutlinePage outline = loadClass().newInstance();
				outline.init(multiEditor);
				return outline;

			} catch (SecurityException e) {
				// Lets propagate. This is an implementation problem that should
				// be solved by programmer.
				throw new RuntimeException(e);
			}

			catch (InstantiationException e) {
				// Lets propagate. This is an implementation problem that should
				// be solved by programmer.
				// throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				// Lets propagate. This is an implementation problem that should
				// be solved by programmer.
				throw new RuntimeException(e);
			}
			return null;
		}

	} // end class
}
