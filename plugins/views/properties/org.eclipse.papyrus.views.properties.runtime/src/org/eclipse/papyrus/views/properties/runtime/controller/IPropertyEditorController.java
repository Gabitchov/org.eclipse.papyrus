/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Interface implemented by all property editor controllers
 */
public interface IPropertyEditorController {

	/**
	 * Sets the objectToEdit
	 * 
	 * @param objectToEdit
	 *        the objectToEdit to set
	 */
	public void setObjectsToEdit(List<? extends Object> objectToEdit);

	/**
	 * Indicates that the list of objects to edit should change. It removes old listeners, and adds new ones
	 * 
	 * @param objectToEdit
	 *        the new list of objects to edit
	 */
	public void changeObjectsToEdit(List<? extends Object> objectToEdit);

	/**
	 * Sets the parent composite for all controls created by the editor
	 * 
	 * @param composite
	 *        the composite to set
	 */
	public void setParent(Composite composite);

	/**
	 * Indicates if the controller manages multi-selection of objects
	 * 
	 * @return <code>true</code> if the controller accepts multi-selection
	 */
	public boolean acceptMultiSelection();

	/**
	 * Creates the property editor, with label on the specified position and the given icon.
	 * 
	 * @param descriptor
	 *        the image descriptor for the property editor
	 * @param widgetFactory
	 *        widget factory used to create the content of the editor
	 */
	public void createPropertyEditor(IPropertyEditorDescriptor descriptor, TabbedPropertySheetWidgetFactory widgetFactory);

	/**
	 * Initialize the controller.
	 * 
	 * @param parent
	 *        the composite parent of the controls created by the editor
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @param descriptor
	 *        the descriptor that realize specific configuration for this controller
	 * @return the status of the initialization
	 */
	public IStatus initController(Composite parent, List<Object> objectsToEdit, IPropertyEditorControllerDescriptor descriptor);

	/**
	 * Refresh the content of the editor, given values in the model.
	 */
	public void refreshDisplay();

	/**
	 * Moves the given list of Objects in the list
	 * 
	 * @param indexes
	 *        the indexes of objects to move
	 * @param move
	 *        the delta for the index (0: stays at the same place, -1: everything move upper, +2: everything moves 2 index further)
	 * @return the operation that moves the elements or <code>null</code>
	 */
	public IUndoableOperation getMoveCurrentValuesOperation(List<Integer> indexes, int move);

	/**
	 * Indicates if the values can be moved in the feature
	 * 
	 * @param indexes
	 *        the indexes of objects to move
	 * @param move
	 *        the delta for the index (0: stays at the same place, -1: everything move upper, +2: everything moves 2 index further)
	 * @return <code>true</code> if the values can be moved, else <code>false</code>
	 */
	public boolean canMoveValues(List<Integer> indexes, int move);

	/**
	 * Returns the operation to create a new value for this property
	 * 
	 * @return the operation to create a new value for this property
	 */
	public List<IUndoableOperation> getCreateValueOperations();

	/**
	 * Returns <code>true</code> if the controller can create a new value for the property
	 * 
	 * @return <code>true</code> if the controller can create a new value for the property
	 */
	public boolean canCreateValueOperations();

	/**
	 * Returns the operation to delete a value for this property
	 * 
	 * @param indexes
	 *        list of indexes for values to delete (not used in case of single valued proeprty)
	 * @return the operation to delete a value for this property
	 */
	public IUndoableOperation getDeleteValueOperation(List<Integer> indexes);

	/**
	 * Returns <code>true</code> if the controller can delete a value for the property
	 * 
	 * @return <code>true</code> if the controller can delete a value for the property
	 */
	public boolean canDeleteValueOperation();

	/**
	 * Returns the operation to edit a value for this property
	 * 
	 * @param index
	 *        the index of the value to set
	 * @param parent
	 *        the composite parent used for user interface
	 * @param value
	 *        the value to set
	 * 
	 * @return the operation to edit a value for this property
	 */
	public IUndoableOperation getEditValueOperation(int index, Composite parent, Object value);

	/**
	 * Returns <code>true</code> if the controller can edit a value for the property
	 * 
	 * @param index
	 *        the index of the value to set
	 * @param parent
	 *        the composite parent used for user interface
	 * @param value
	 *        the value to set
	 * 
	 * @return <code>true</code> if the controller can edit a value for the property
	 */
	public boolean canCreateEditOperation(int index, Composite parent, Object value);

}
