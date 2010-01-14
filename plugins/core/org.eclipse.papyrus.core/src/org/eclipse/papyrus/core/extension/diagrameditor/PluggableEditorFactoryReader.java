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
package org.eclipse.papyrus.core.extension.diagrameditor;

import static org.eclipse.papyrus.core.Activator.log;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageModelFactoryRegistry;
import org.eclipse.papyrus.core.extension.ExtensionException;
import org.eclipse.papyrus.core.services.ServicesRegistry;

/**
 * This reader is used to read PluggableEditorFactory from the Eclipse extension declarations.
 * It can be used to populate an {@link PageModelFactoryRegistry}.
 */
public class PluggableEditorFactoryReader {

	/** ID of the editor extension (schema filename) */
	public static final String EDITOR_EXTENSION_ID = "papyrusDiagram";

	/** Namespace where to look for the extension points. */
	protected String extensionPointNamespace;

	/** list of editor descriptors */
	protected List<EditorDescriptor> editorDescriptors;

	/** indicates if extension is loaded or not */
	private boolean isExtensionLoaded = false;


	/**
	 * Create a new Registry reading extension from the specified namespace. The namespace is
	 * usually the name of the plugin owning the registry.
	 * 
	 * @param extensionPointNamespace
	 */
	public PluggableEditorFactoryReader(String extensionPointNamespace) {
		super();
		this.extensionPointNamespace = extensionPointNamespace;
		editorDescriptors = new ArrayList<EditorDescriptor>();
	}

	/**
	 * Populate the provided {@link PageModelFactoryRegistry} with {@link IPluggableEditorFactory} read
	 * from Eclipse extension declarations.
	 * For each declared editor, create a proxy encapsulating the real EditorFactory. Then the proxy is
	 * added to the PageModelFactoryRegistry.
	 * 
	 * @param pageModelFactoryRegistry The object to populate
	 * @param serviceRegistry ServiceRegistry provided to newly instantiated {@link IPluggableEditorFactory}.
	 */
	public void populate(PageModelFactoryRegistry pageModelFactoryRegistry, ServicesRegistry serviceRegistry) {

		for(EditorDescriptor desc : getEditorDescriptors()) {

			// Create and add a proxy encapsulating the EditorFactory.
			pageModelFactoryRegistry.add(new EditorFactoryProxy(serviceRegistry, desc));
		}
	}

	/**
	 * Populate the provided {@link PageIconsRegistry} with icons read
	 * from Eclipse extension declarations.
	 * For each declared editor, create a {@link EditorIconFactory}.
	 * 
	 * @param pageModelFactoryRegistry The object to populate
	 * @param serviceRegistry ServiceRegistry provided to newly instantiated {@link IPluggableEditorFactory}.
	 */
	public void populate(PageIconsRegistry registry) {

		for(EditorDescriptor desc : getEditorDescriptors()) {

			// Create and add a proxy encapsulating the EditorFactory.
			registry.add(new EditorIconFactory(desc));
		}
	}



	/**
	 * Get the list of editor descriptor.
	 * 
	 * @return the list of editor descriptor.
	 */
	public List<EditorDescriptor> getEditorDescriptors() {
		if(!isExtensionLoaded) {
			isExtensionLoaded = true;
			initializeEditorDescriptors();
		}
		return editorDescriptors;
	}

	/**
	 * Read editor descriptors from extension points.
	 */
	private void initializeEditorDescriptors() {
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, EDITOR_EXTENSION_ID);

		for(IConfigurationElement ele : configElements) {
			EditorDescriptor desc;
			try {
				if(EditorDescriptorExtensionFactory.EDITOR_DIAGRAM_EXTENSIONPOINT.equals(ele.getName())) {
					desc = EditorDescriptorExtensionFactory.eINSTANCE.createNestedEditorDescriptor(ele);
					editorDescriptors.add(desc);
				}
			} catch (ExtensionException e) {
				log.error("Initialization editor problem ", e);
			}
		}

		if(log.isDebugEnabled()) {
			log.debug("Read " + editorDescriptors.size() + " editor descriptors from Eclipse extensions");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "EditorFactoryRegistry: " + editorDescriptors.toString();
	}

}
