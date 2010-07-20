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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.runtime.controller.EMFPropertyEditorController;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.properties.runtime.view.IConfigurableDescriptor;


/**
 * Interface that manages conversion of values from String (coming from editors) and the model itself
 */
public interface IEMFModelHandler extends IConfigurableDescriptor {

	/**
	 * Returns the value to edit from the model
	 * 
	 * @param objectToEdit
	 *        the object to edit
	 * 
	 * @return the value to edit from the model
	 */
	public Object getValueToEdit(EObject objectToEdit);

	/**
	 * Sets the new Value in the model
	 * 
	 * @param objectToEdit
	 *        the object to edit
	 * @param newValue
	 *        the new value to set
	 */
	public void setValueInModel(EObject objectToEdit, Object newValue);

	/**
	 * Returns the initialization data that will be given to the property editor
	 * 
	 * @param descriptor
	 *        descriptor of the editor managed by the controller linked to this model handler
	 * @param objectToEdit
	 *        list of objects to edit
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit);

	/**
	 * checks if the feature is changeable
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return <code>true</code> if the feature is changeable
	 */
	public boolean isChangeable(List<? extends EObject> objectsToEdit);

	/**
	 * Returns the identifier of this model handler
	 * 
	 * @return the identifier of this model handler
	 */
	public String getId();


	/**
	 * {@inheritDoc}
	 */
	public IEMFModelHandlerState createState(boolean readOnly);

	/**
	 * handle notifications for the model handler
	 * 
	 * @param notification
	 *        the notification to react to
	 * @param objects
	 *        the list of objects on which updates should be performed
	 * @param adapter
	 *        the adapter in charge of notification
	 */
	public void handleNotifyChange(Notification notification, List<? extends EObject> objects, EMFPropertyEditorController adapter);

	/**
	 * Returns available values for the feature managed by the model handler
	 * 
	 * @param object
	 *        the list of available values
	 * @return the list of available values
	 */
	public Object getAvailableValues(EObject object);

	/**
	 * Adds the listeners to the model
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @param controller
	 *        the controller which uses this model handler
	 */
	public void addListenersToModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller);

	/**
	 * Removes the listeners from the model
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @param controller
	 *        the controller which was using this model handler
	 */
	public void removeListenersFromModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller);
}
