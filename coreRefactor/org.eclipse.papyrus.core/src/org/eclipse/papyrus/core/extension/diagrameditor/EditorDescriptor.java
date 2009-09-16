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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
import org.eclipse.ui.IEditorPart;

/**
 * This descriptor describes a nested diagram. It is used by MultiDiagramEditor to know about the nested diagram. It is fill by an extension.
 * 
 * @author Cedric Dumoulin
 * 
 */
public class EditorDescriptor implements IEditorDescriptor {

	/**
	 * Editor factory implementation class.
	 */
	private Class<IEditorFactory> editorFactoryClass;

	/**
	 * Context Id used to search the context requested by the editor.
	 */
	private String requestedContextId;

	/**
	 * EditorActionBarContributor Id used to search the EditorActionBarContributor requested by the editor.
	 */
	private String actionBarContributorId;

	/**
	 * The icon representing the diagram
	 */
	private ImageDescriptor icon;

	/**
	 * Cached factory. Initialized by first call to getXxx
	 */
	private IEditorFactory editorFactory;

	/**
	 * Constructor.
	 */
	public EditorDescriptor() {

	}

	/**
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorDescriptor#getRequestedContextId()
	 * @return
	 * 
	 */
	public String getRequestedContextId() {
		return requestedContextId;
	}

	/**
	 * set the requestedContextId
	 * 
	 * @param requestedContextId
	 *            the requestedContextId to set
	 */
	public void setRequestedContextId(String requestedContextId) {
		this.requestedContextId = requestedContextId;
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setActionBarContributorId(String actionBarContributorId) {
		this.actionBarContributorId = actionBarContributorId;

	}

	/**
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorDescriptor#getActionBarContributorId()
	 * @return
	 * 
	 */
	public String getActionBarContributorId() {
		return actionBarContributorId;
	}

	/**
	 * get the editor icon path
	 * 
	 * @return the editor icon path
	 */
	public ImageDescriptor getIcon() {
		return icon;
	}

	/**
	 * set the editor icon
	 * 
	 * @param icon
	 *            the icon path
	 */
	public void setIcon(ImageDescriptor icon) {
		this.icon = icon;
	}

	/**
	 * Get associated editorFactory. The editorFactoryClass should be set, otherwise an error is thrown.
	 * 
	 * @return the IEditorFactory
	 */
	public IEditorFactory getEditorFactory() {
		if (editorFactory != null)
			return editorFactory;

		if (editorFactoryClass == null) { // error
			throw new IllegalStateException("EditorFactory class should be set.");
		}

		// Create it
		try {
			editorFactory = (IEditorFactory) editorFactoryClass.newInstance();
			// Set the descriptor. USed by the factory to get the ActionBarId and Icon
			editorFactory.init(this );
			return editorFactory;
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be
			// solved by programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be
			// solved by programmer.
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method is used in order to know if the editor associated to this description can edit the root object. example a diagram di2 or notation
	 * 
	 * @param root
	 *            the element that can be edited
	 * @return boolean true if the editor can edit it.
	 */
	public boolean isEditorFor(Object root) {
		return getEditorFactory().isEditorFor(root);
	}

	/**
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorDescriptor#createEditorFor(org.eclipse.papyrus.core.extension.editorcontext.IEditorContext, java.lang.Object)
	 * @param context
	 * @param root
	 * @return
	 * @throws BackboneException
	 * 
	 */
	public IEditorPart createEditorFor(IEditorContext context, Object root) throws BackboneException {
		return getEditorFactory().createEditorFor(context, root);
	}

	/**
	 * Return true if the descriptor is for the specified pageIdentifier.
	 * Delegate to the PageModelFactory s.
	 * 
	 * @param root
	 *            the element that can be edited
	 * @return boolean true if the editor can edit it.
	 */
	public boolean isDescriptorForPage(Object pageIdentifier) {
		return getEditorFactory().isPageModelFactoryFor(pageIdentifier);
	}

	/**
	 * see {@link IPageModelFactory#createIPageModel(Object)}
	 * @param pageIdentifier
	 * @return
	 */
	public IPageModel createIPageModel(Object pageIdentifier, ServicesRegistry servicesRegistry) {
		return getEditorFactory().createIPageModel(pageIdentifier, servicesRegistry);
	}

	/**
	 * get the class of the editor factory
	 * 
	 * @return the class of the editor
	 */
	public Class<IEditorFactory> getEditorFactoryClass() {
		return editorFactoryClass;
	}

	/**
	 * set the editor facoty to this descriptor
	 * 
	 * @param editorFactoryClass
	 *            the class that represents the editor factory
	 */
	public void setEditorFactoryClass(Class<IEditorFactory> editorFactoryClass) {
		this.editorFactoryClass = editorFactoryClass;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String toString() {
		if (editorFactoryClass == null || editorFactoryClass.getName() == null) {
			return "[nestedEditor  editorFactory:" + editorFactoryClass + "(null) requestedContextID:" + requestedContextId + "]";
		}
		return "[nestedEditor  editorFactory:" + editorFactoryClass.getName() + " requestedContextID:" + requestedContextId + "]";
	}

}
