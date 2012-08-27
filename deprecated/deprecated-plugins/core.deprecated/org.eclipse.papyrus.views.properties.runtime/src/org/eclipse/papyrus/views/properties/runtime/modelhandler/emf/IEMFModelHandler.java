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
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.views.properties.runtime.controller.EMFPropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.swt.widgets.Composite;


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

	/**
	 * Returns the operation to create a new value for this property
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @param parent
	 *        the composite parent, needed in case of user interaction
	 * 
	 * @return the operation to create a new value for this property
	 */
	public List<IUndoableOperation> getCreateValueOperations(List<? extends EObject> objectsToEdit, Composite parent);

	/**
	 * Returns <code>true</code> if the controller can create a new value for the property
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @return <code>true</code> if the controller can create a new value for the property
	 */
	public boolean canCreateValueOperations(List<? extends EObject> objectsToEdit);

	/**
	 * Returns the operation to delete a value for this property
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @param parent
	 *        the composite parent, needed in case of user interaction
	 * @param indexes
	 *        list of indexes to delete
	 * @return the operation to delete a value for this property
	 * 
	 */
	public IUndoableOperation getDeleteValueOperation(List<? extends EObject> objectsToEdit, Composite parent, List<Integer> indexes);

	/**
	 * Returns <code>true</code> if the controller can delete a value for the property
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @return <code>true</code> if the controller can delete a value for the property
	 */
	public boolean canCreateDeleteValueOperation(List<? extends EObject> objectsToEdit);

	/**
	 * Returns the operation to edit a value for this property
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @param index
	 *        the index of the value to edit
	 * @param parent
	 *        the parent for the editor
	 * @param value
	 *        the value to set
	 * @return the operation to edit a value for this property
	 */
	public IUndoableOperation getEditValueOperation(List<? extends EObject> objectsToEdit, int index, Composite parent, Object value);

	/**
	 * Returns <code>true</code> if the controller can edit a value for the property
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @return <code>true</code> if the controller can edit a value for the property
	 */
	public boolean canCreateEditValueOperation(List<? extends EObject> objectsToEdit);

	/**
	 * Returns the operation to move a list of values for this property
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @param indexes
	 *        the list of indexes to move
	 * @param parent
	 *        the parent for the editor
	 * @param delta
	 *        the delta applied to all moved objects
	 * @return the operation to edit a value for this property
	 */
	public IUndoableOperation getMoveValueOperation(List<? extends EObject> objectsToEdit, List<Integer> indexes, Composite parent, int delta);

	/**
	 * Returns <code>true</code> if the controller can move a set of values for the property
	 * 
	 * @param objectsToEdit
	 *        the list of object to edit
	 * @param indexes
	 *        the list of indexes to move
	 * @param parent
	 *        the parent for the editor
	 * @param delta
	 *        the delta applied to all moved objects
	 * @return <code>true</code> if the controller can move a set of values for the property
	 */
	public boolean canCreateMoveValueOperation(List<? extends EObject> objectsToEdit, List<Integer> indexes, Composite parent, int delta);



	/**
	 * Returns a list of SetRequest for this object, or <code>null</code> if a request can't be created
	 * 
	 * @param domain
	 *        the transactional editing domain
	 * @param objectToEdit
	 *        the object to edit
	 * @param newValue
	 *        the new value for this object
	 * @return
	 *         a list of SetRequest for this object, or <code>null</code> if a request can't be created
	 */
	public SetRequest[] getSetRequest(TransactionalEditingDomain domain, EObject objectToEdit, Object newValue);
}
