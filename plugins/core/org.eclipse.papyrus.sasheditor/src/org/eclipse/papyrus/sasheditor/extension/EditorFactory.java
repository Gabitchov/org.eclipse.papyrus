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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.ui.IEditorPart;

/**
 * Simple implementation of IEditorFactory
 * 
 * @author dumoulin
 * 
 */
public class EditorFactory implements IEditorFactory {

	/**
	 * Expected Class of the diagram to create.
	 */
	private Class<IEditorPart> diagramClass;

	/**
	 * Expected class of the root object.
	 */
	private Class<?> rootExpectedClass;

	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param rootExpectedClass
	 */
	public EditorFactory(Class<IEditorPart> diagramClass, Class<?> rootExpectedClass) {
		assert (diagramClass != null);
		this.diagramClass = diagramClass;
		this.rootExpectedClass = rootExpectedClass;
	}

	/**
	 * Default implementation return whether the root is eINSTANCE of rootExpectedClass.
	 * 
	 * @param root
	 * @return boolean
	 */
	public boolean isEditorFor(Object root) {
		return (rootExpectedClass.isInstance(root));
	}

	/**
	 * Create a new editor for the specified root object.
	 * 
	 * @param sharedObjects
	 *        objects shared among several diagrams
	 * @param root
	 *        the root element to be displayed in the diagram
	 * @return the created editor
	 * @throws RuntimeException
	 *         implementation problem. the backbone infrastructure does not handle the diagram, or an extension point was not resolved.
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	public IEditorPart createEditorFor(MultiDiagramSharedObjects sharedObjects, Object root) {
		IEditorPart editor;

		try {
			Constructor<IEditorPart> c = diagramClass.getConstructor(Object.class, MultiDiagramSharedObjects.class);
			editor = c.newInstance(root, sharedObjects);
			return editor;

		} catch (SecurityException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			// Try with no arg constructor
			return (GraphicalEditor)createEditorNoArgs(sharedObjects, root);
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		}

	}

	/**
	 * Create an editor using its no args constructor. The editor should implements the NestedEdidor interface.
	 * 
	 * @param sharedObjects
	 *        objects shared among several diagrams
	 * @param root
	 *        the root element to be displayed in the diagram
	 * @return the created nested editor
	 * @throws RuntimeException
	 *         implementation problem. the backbone infrastructure does not handle the diagram, or an extension point was not resolved.
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	private NestedDiagram createEditorNoArgs(MultiDiagramSharedObjects sharedObjects, Object root) {
		// TODO Replace with IEditorPart after checking it is possible with Papyrus.
		// Set the shared object only if the NestDiagram interface is implemented.
		NestedDiagram editor;
		// Create editor
		try {
			editor = (NestedDiagram)diagramClass.newInstance();
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		}
		editor.setSharedObjects(sharedObjects);
		editor.setRoot(root);
		return editor;
	}

	/**
	 * Return the java class modeling the diagram
	 * 
	 * @return the type of diagram managed by this factory
	 */
	protected Class<?> getDiagramClass() {
		return diagramClass;
	}

}
