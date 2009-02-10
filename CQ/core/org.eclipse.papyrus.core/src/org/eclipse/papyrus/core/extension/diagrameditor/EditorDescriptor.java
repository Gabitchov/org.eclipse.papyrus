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

import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.ui.IEditorPart;

/**
 * This descriptor describes a nested diagram. It is used by MultiDiagramEditor to know about the nested diagram. It is fill by an extension.
 * 
 * @author Cedric Dumoulin
 * 
 */
public class EditorDescriptor {

	/**
	 * Editor factory implementation class.
	 */
	private Class<IEditorFactory> editorFactoryClass;

	/**
	 * Context Id used to search the context requested by the editor.
	 */
	private String requestedContextId;

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
	 * to obtain the requestedContextId
	 * 
	 * @return the requestedContextId
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
	 * Create a new editor for the specified root object.
	 * 
	 * @param context
	 *            the context used to init the editor
	 * @param root
	 *            the element to launch the editor (diagram for instance)
	 * @throws BackboneException
	 *             Editor could not be created
	 */
	public IEditorPart createEditorFor(IEditorContext context, Object root) throws BackboneException {
		return getEditorFactory().createEditorFor(context, root);
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
