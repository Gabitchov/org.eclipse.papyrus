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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.EMFTPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.BooleanEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.EnumerationEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.ReferenceEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.StringEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;


/**
 * Controller for {@link EStructuralFeature} property editor controller.
 */
public class EMFTStructuralFeatureController extends EMFTPropertyEditorController implements Adapter {

	/** list of registered model handlers */
	protected final static Map<String, IEMFModelHandler> modelHandlers = new HashMap<String, IEMFModelHandler>();

	/** descriptor that configures this controller */
	private EMFTPropertyEditorControllerDescriptor descriptor;

	public final static String ID = "emftStructuralFeatureController";

	/** model handler to interact with the model for this controller */
	protected IEMFModelHandler modelHandler;

	/** cached feature to edit */
	protected EStructuralFeature featureToEdit = null;

	static {
		// initialize the list of model handlers
		modelHandlers.put(StringEMFModelHandler.ID, new StringEMFModelHandler());
		modelHandlers.put(EnumerationEMFModelHandler.ID, new EnumerationEMFModelHandler());
		modelHandlers.put(BooleanEMFModelHandler.ID, new BooleanEMFModelHandler());
		modelHandlers.put(ReferenceEMFModelHandler.ID, new ReferenceEMFModelHandler());
	}

	/**
	 * Creates a new EMFTStructuralFeatureController.
	 * 
	 * @param descriptor
	 *        descriptor that configures this controller
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
	public IStatus initController(Composite parent, List<Object> objectsToEdit, IPropertyEditorControllerDescriptor descriptor) {
		setParent(parent);
		setObjectsToEdit(objectsToEdit);

		TransactionalEditingDomain editingDomain = null;
		Iterator<Object> it2 = objectsToEdit.iterator();
		while(it2.hasNext() && editingDomain == null) {
			editingDomain = TransactionUtil.getEditingDomain(it2.next());
		}
		if(editingDomain == null) {
			return new Status(IStatus.ERROR, Activator.ID, "impossible to find an editing domain for the controller.");
		}
		setEditingDomain(editingDomain);

		if(descriptor instanceof EMFTPropertyEditorControllerDescriptor) {
			this.descriptor = (EMFTPropertyEditorControllerDescriptor)descriptor;
		} else {
			return new Status(IStatus.ERROR, Activator.ID, "impossible to adapt descriptor to an EMFTPropertyEditorControllerDescriptor");
		}

		this.modelHandler = modelHandlers.get(getDescriptor().getHandlerID());
		if(modelHandler == null) {
			return new Status(IStatus.ERROR, Activator.ID, "impossible to find model handler with ID : " + getDescriptor().getHandlerID());
		}
		return Status.OK_STATUS;
	}

	/**
	 * Returns the structural feature being edited
	 * 
	 * @return the feature to edit
	 */
	protected EStructuralFeature getFeatureToEdit() {
		if(featureToEdit == null) {
			EStructuralFeature descriptorFeature = descriptor.getFeatureToEdit();
			if(descriptorFeature != null) {
				featureToEdit = descriptorFeature;
			} else {
				String featureName = descriptor.getFeatureNameToEdit();
				// retrieve the feature using its name
				featureToEdit = retrieveFeatureFromName(featureName);
				if(featureToEdit == null) {
					Activator.log.error("impossible to retrieve feature " + featureName + " to edit for " + getObjectsToEdit(), null);
				}
			}
		}
		return featureToEdit;
	}

	/**
	 * Retrieve the feature to edit, given its name
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 * @return the feature to edit
	 */
	protected EStructuralFeature retrieveFeatureFromName(String featureName) {
		for(EObject eObject : getObjectsToEdit()) {
			EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureName);
			if(feature != null) {
				return feature;
			}
		}
		return null;
	}

	/**
	 * @{inheritDoc
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
	 * @{inheritDoc
	 */
	@Override
	protected void addListenersToModel() {
		for(EObject object : getObjectsToEdit()) {
			object.eAdapters().add(this);
		}
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected String getDefaultLabel() {
		return getFeatureToEdit().getName();
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected Object getValueToEdit() {
		// when editing multiple objects, the value returned is the value of the first element
		// it has already been asserted in the contructor that the list is not empty. get(0) should never throw an exception 
		EObject object = getObjectsToEdit().get(0);
		return getModelHandler().getValueToEdit(object, getFeatureToEdit(), descriptor);
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected void setValueInModel(Object value) {
		// when editing multiple objects, the value set will be the same for all elements
		// should look for exceptions here perhaps?
		for(EObject object : getObjectsToEdit()) {
			getModelHandler().setValueInModel(object, getFeatureToEdit(), getEditorValue());
		}
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected IStatus initPropertyEditor(IPropertyEditorDescriptor descriptor) {
		// property editor has already been created, but it is not initialized
		getPropertyEditor().setIsReadOnly(!getFeatureToEdit().isChangeable());
		getModelHandler().completeEditorDescriptor(descriptor, getObjectsToEdit(), getFeatureToEdit());
		return getPropertyEditor().init(descriptor);
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected void removeListenersFromModel() {
		for(EObject object : getObjectsToEdit()) {
			object.eAdapters().remove(this);
		}
	}

	/**
	 * @{inheritDoc
	 */
	public Notifier getTarget() {
		// nothing to do here, as there is only one target
		return null;
	}


	/**
	 * @{inheritDoc
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
	 * @{inheritDoc
	 */
	public void notifyChanged(Notification notification) {
		// refresh the editors
		refreshDisplay();
	}

	/**
	 * @{inheritDoc
	 */
	public void setTarget(Notifier newTarget) {
		// nothing to do here, as the adapter already knows the target
	}

}
