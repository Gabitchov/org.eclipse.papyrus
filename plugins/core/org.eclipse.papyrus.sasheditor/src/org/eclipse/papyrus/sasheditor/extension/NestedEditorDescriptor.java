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
package org.eclipse.papyrus.sasheditor.extension;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.ui.IEditorPart;

/**
 * This descriptor describes a nested diagram. It is used by MultiDiagramEditor to know about the nested diagram. It is fill by an extension.
 */
public class NestedEditorDescriptor {


	/**
	 * Editor factory implementation class.
	 */
	private Class<?> editorFactoryClass;

	/**
	 * Cached factory. Initialized by first call to getXxx
	 */
	private IEditorFactory editorFactory;

	/**
    * 
    */
	protected NestedDiagram editor;

	/**
	 * Constructor.
	 */
	public NestedEditorDescriptor() {

	}

	/**
	 * Get associated editorFactory. The editorFactoryClass should be set, otherwise an error is thrown.
	 * 
	 * @return the associated editor Factory
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
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		}
	}

	/**
	 * Return <code>true</code> if the editor can edit the root object.
	 * 
	 * @param root
	 *            the object to edit
	 * @return <code>true</code>if the editor can edit the specified object
	 */
	public boolean isEditorFor(Object root) {
		return getEditorFactory().isEditorFor(root);
	}

	/**
	 * Create a new editor for the specified root object.
	 * 
	 * @param sharedObjects
	 *            shared objects among several diagrams
	 * @param root
	 *            the root object to edit
	 * @return the created editor
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	public IEditorPart createEditor(MultiDiagramSharedObjects sharedObjects, Object root) {
		return getEditorFactory().createEditorFor(sharedObjects, root);
	}

	/**
	 * Returns the editor factory associated to this editor descriptor.
	 * 
	 * @return the editor factory associated to this editor descriptor.
	 */
	public Class<?> getEditorFactoryClass() {
		return editorFactoryClass;
	}

	/**
	 * Sets the editor factory associated to this editor descriptor.
	 * 
	 * @param editorFactoryClass
	 *            the editor factory to associate to this editor descriptor.
	 */
	public void setEditorFactoryClass(Class<?> editorFactoryClass) {
		this.editorFactoryClass = editorFactoryClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + " factory=" + editorFactory + "\n   ";
	}
}
