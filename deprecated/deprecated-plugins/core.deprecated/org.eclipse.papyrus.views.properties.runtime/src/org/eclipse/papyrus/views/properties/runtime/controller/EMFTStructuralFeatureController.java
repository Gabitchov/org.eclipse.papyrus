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
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.EMFTPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.predefined.PredefinedControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFUtils;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;


/**
 * Controller for {@link EStructuralFeature} property editor controller.
 */
public class EMFTStructuralFeatureController extends EMFTPropertyEditorController {

	/** descriptor that configures this controller */
	private EMFTPropertyEditorControllerDescriptor descriptor;

	/** identifier of the controller */
	public final static String ID = "emftStructuralFeatureController"; //$NON-NLS-1$

	/**
	 * Creates a new EMFTStructuralFeatureController.
	 */
	public EMFTStructuralFeatureController() {
		super();
	}

	/**
	 * Initialize the controller.
	 * 
	 * @param parent
	 *        the composite parent of the controls created by the editor
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @param descriptor
	 *        the descriptor that realize specific configuration for this controller
	 */
	@Override
	public IStatus initController(Composite parent, List<Object> objectsToEdit, IPropertyEditorControllerDescriptor descriptor) {
		setParent(parent);
		IPropertyEditorControllerDescriptor realDescriptor = descriptor;
		if(descriptor instanceof PredefinedControllerDescriptor) {
			IPropertyEditorControllerDescriptor predefinedDescriptor = ((PredefinedControllerDescriptor)descriptor).getDescriptor();
			if(predefinedDescriptor instanceof EMFTPropertyEditorControllerDescriptor) {
				realDescriptor = predefinedDescriptor;
			}
		}
		if(realDescriptor instanceof EMFTPropertyEditorControllerDescriptor) {
			this.descriptor = (EMFTPropertyEditorControllerDescriptor)realDescriptor;
		} else {
			return new Status(IStatus.ERROR, Activator.ID, "impossible to adapt descriptor to an EMFTPropertyEditorControllerDescriptor"); //$NON-NLS-1$
		}

		this.modelHandler = this.descriptor.getHandler();
		setObjectsToEdit(objectsToEdit);

		TransactionalEditingDomain editingDomain = EMFUtils.getTransactionalEditingDomain(objectsToEdit);
		if(editingDomain == null && !objectsToEdit.isEmpty()) {
			return new Status(IStatus.ERROR, Activator.ID, "impossible to find an editing domain for the controller."); //$NON-NLS-1$
		}
		setEditingDomain(editingDomain);
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean acceptMultiSelection() {
		return descriptor.acceptMultiSelection();
	}

	/**
	 * Returns the model handler that manages interaction with the model
	 * 
	 * @return the model handler that manages interaction with the model
	 */
	public IEMFModelHandler getModelHandler() {
		return modelHandler;
	}


	/**
	 * Returns the descriptor configuring this controller
	 * 
	 * @return the descriptor configuring this controller
	 */
	public EMFTPropertyEditorControllerDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addListenersToModel() {
		modelHandler.addListenersToModel(getObjectsToEdit(), this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultLabel() {
		return descriptor.getFeatureNameToEdit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getValueToEdit() {
		// when editing multiple objects, the value returned is the value of the first element
		// it has already been asserted in the contructor that the list is not empty. get(0) should never throw an exception 
		if(!getObjectsToEdit().isEmpty()) {
			EObject object = getObjectsToEdit().get(0);
			return getModelHandler().getValueToEdit(object);
		}
		return new Object();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValueInModel(Object value) {
		// when editing multiple objects, the value set will be the same for all elements
		// should look for exceptions here perhaps?
		for(EObject object : getObjectsToEdit()) {
			getModelHandler().setValueInModel(object, value);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus initPropertyEditor(IPropertyEditorDescriptor descriptor) {
		// property editor has already been created, but it is not initialized
		getPropertyEditor().setIsReadOnly(!getModelHandler().isChangeable(getObjectsToEdit()));
		getModelHandler().completeEditorDescriptor(descriptor, getObjectsToEdit());
		return getPropertyEditor().init(descriptor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeListenersFromModel() {
		getModelHandler().removeListenersFromModel(getObjectsToEdit(), this);
	}

	/**
	 * {@inheritDoc}
	 */
	public Notifier getTarget() {
		// nothing to do here, as there is only one target
		return null;
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean isAdapterForType(Object type) {
		for(EObject eObject : getObjectsToEdit()) {
			if(eObject.getClass().equals(type)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		getModelHandler().handleNotifyChange(notification, getObjectsToEdit(), this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTarget(Notifier newTarget) {
		// nothing to do here, as the adapter already knows the target
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getMoveCurrentValuesOperation(List<Integer> indexes, int delta) {
		return getModelHandler().getMoveValueOperation(getObjectsToEdit(), indexes, getComposite(), delta);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canMoveValues(List<Integer> indexes, int delta) {
		return getModelHandler().canCreateMoveValueOperation(getObjectsToEdit(), indexes, getComposite(), delta);
	}

	/**
	 * Retrieves the common metaclass for all selected objects
	 * 
	 * @return the selected metaclass
	 * 
	 */
	protected EClass retrieveEClass() {
		@SuppressWarnings("unchecked")
		List<EObject> eObjects = (List<EObject>)getObjectsToEdit();
		if(eObjects == null) {
			return null;
		} else if(eObjects.size() > 0) {
			return eObjects.get(0).eClass();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IUndoableOperation> getCreateValueOperations() {
		return getModelHandler().getCreateValueOperations(getObjectsToEdit(), getComposite());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateValueOperations() {
		return getModelHandler().canCreateValueOperations(getObjectsToEdit());
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getDeleteValueOperation(List<Integer> indexes) {
		return getModelHandler().getDeleteValueOperation(getObjectsToEdit(), getComposite(), indexes);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canDeleteValueOperation() {
		return getModelHandler().canCreateDeleteValueOperation(getObjectsToEdit());
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getEditValueOperation(int index, Composite parent, Object value) {
		return getModelHandler().getEditValueOperation(getObjectsToEdit(), index, parent, value);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateEditOperation(int index, Composite parent, Object value) {
		return true;
	}

}
