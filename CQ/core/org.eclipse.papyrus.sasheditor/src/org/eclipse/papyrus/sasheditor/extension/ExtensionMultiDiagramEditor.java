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

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.sasheditor.gef.EditorNotFoundException;
import org.eclipse.papyrus.sasheditor.gef.GefMultiPageEditorPart;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

/**
 * MultiDiagram Editor whose nested editors can be declared using the Eclipse extension mechanism.
 * <p>
 * This class add methods to add nested editors from extensions.
 * </p>
 */
public abstract class ExtensionMultiDiagramEditor extends GefMultiPageEditorPart {

	/** shared objects among all diagrams */
	private MultiDiagramSharedObjects sharedObject;

	/** Registry to store editor factories */
	private EditorFactoryRegistry editorRegistry;

	/**
	 * Create a PageEditor for the specified model. Default implementation delegates to pageEditorFactory.createPageEditorFor(model);
	 * 
	 * @param model
	 *            the diagram to be displayed
	 * @return the Graphical Editor that displays the specified diagram
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	protected IEditorPart createPageEditor(Object model) throws EditorNotFoundException {
		return getEditorRegistry().createEditorFor(getSharedObjects(), model);
	}

	/**
	 * Get the EditorRegistry used to create editor instances. This default implementation return the singleton eINSTANCE. This method can be subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 */
	protected EditorFactoryRegistry getEditorRegistry() {
		if (editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should implements this method in order to return the registry associated to the extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 */
	abstract protected EditorFactoryRegistry createEditorRegistry();

	/**
	 * Create shared object. The shared object will be initialized with a call to initSharedObject();
	 * 
	 * @return the created shared object.
	 */
	abstract protected MultiDiagramSharedObjects createSharedObject();

	/**
	 * Get the object sharing all instances needed by the editor.
	 * 
	 * @return the singleton eINSTANCE of MultiDiagramSharedObjects.
	 */
	public MultiDiagramSharedObjects getSharedObjects() {
		if (sharedObject == null) {
			sharedObject = createSharedObject();
			initSharedObject(sharedObject);
		}
		return sharedObject;
	}

	/**
	 * Initialize the newly created shared object.
	 */
	protected void initSharedObject(MultiDiagramSharedObjects sharedObject) {
	}

	/**
	 * Creates actions for this editor. Subclasses should override this method to create and register actions with the {@link ActionRegistry}.
	 */
	protected void createActions() {
		ActionRegistry registry = getActionRegistry();
		IAction action;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IEditorInput input) {
		// Create global actions from the nested editors.
		createActions();
		super.setInput(input);
	}
}
