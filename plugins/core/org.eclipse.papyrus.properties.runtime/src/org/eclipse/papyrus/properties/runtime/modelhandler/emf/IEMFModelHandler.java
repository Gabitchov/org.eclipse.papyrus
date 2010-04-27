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
package org.eclipse.papyrus.properties.runtime.modelhandler.emf;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;


/**
 * Interface that manages conversion of values from String (coming from editors) and the model itself
 */
public interface IEMFModelHandler {

	/**
	 * Returns the value to edit from the model
	 * 
	 * @return the value to edit from the model
	 */
	public Object getValueToEdit(EObject objectToEdit);

	/**
	 * Sets the new Value in the model
	 * 
	 * @param newValue
	 *        the new value to set
	 */
	public void setValueInModel(EObject objectToEdit, Object newValue);

	/**
	 * Returns the initialization data that will be given to the property editor
	 * 
	 * @return the initialization data that will be given to the property editor
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<EObject> objectToEdit);

	/**
	 * checks if the feature is changeable
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return <code>true</code> if the feature is changeable
	 */
	public boolean isChangeable(List<EObject> objectsToEdit);

}
