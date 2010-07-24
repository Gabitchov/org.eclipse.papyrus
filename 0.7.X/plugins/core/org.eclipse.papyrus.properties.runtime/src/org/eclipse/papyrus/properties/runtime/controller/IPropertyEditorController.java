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
package org.eclipse.papyrus.properties.runtime.controller;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;


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
	 */
	public void createPropertyEditor(IPropertyEditorDescriptor descriptor);

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

}
