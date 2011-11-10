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
package org.eclipse.papyrus.uml.properties.runtime.modelhandler;

import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.views.properties.runtime.controller.EMFPropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFUtils;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.uml.properties.runtime.Activator;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Model Handler for the Multiplicity of {@link MultiplicityElement}
 */
public class MultiplicityModelHandler implements IEMFModelHandler {

	/** list of available values */
	private final List<String> availableValues;

	/** id of this model handler */
	public final static String ID = "Multiplicity"; //$NON-NLS-1$

	/**
	 * Creates a new MultiplicityModelHandler.
	 * 
	 * @param availableValues
	 *        the list of predefined multiplicities
	 */
	public MultiplicityModelHandler(List<String> availableValues) {
		super();
		this.availableValues = availableValues;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		// new Value should be a String with specific format: 
		// either m..n with m integer and n unlimited natural (including -1 or *)
		// or n, with n integer (this is a shortcut for n..n) 
		if(!(newValue instanceof String)) {
			Activator.log.warn("the new value for the multiplicity model handler was no a String"); //$NON-NLS-1$
			return;
		}

		String value = (String)newValue;
		try {
			int[] values = MultiplicityElementUtil.parseMultiplicity(value);
			if(values.length == 2) {
				int lower = values[0];
				int upper = values[1];

				EStructuralFeature lowerFeature = EMFUtils.getFeatureByName(objectToEdit, "lower"); //$NON-NLS-1$
				EStructuralFeature upperFeature = EMFUtils.getFeatureByName(objectToEdit, "upper"); //$NON-NLS-1$

				if(lowerFeature != null && upperFeature != null) {
					objectToEdit.eSet(lowerFeature, lower);
					objectToEdit.eSet(upperFeature, upper);
				}
			}
		} catch (NumberFormatException e) {
			Activator.log.error("Error during multiplicity parsing", e); //$NON-NLS-1$
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(getAvailableValues(null));
		} else {
			Activator.log.warn(descriptor + "could not be completed."); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValueToEdit(EObject objectToEdit) {
		if(objectToEdit instanceof MultiplicityElement) {
			return MultiplicityElementUtil.getMultiplicityAsStringWithoutSquareBrackets((MultiplicityElement)objectToEdit);
		}
		return "NaN"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isChangeable(List<? extends EObject> objectsToEdit) {
		// always true for this implementation
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "MultiplicityHandler"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/MultiplicityHandler.gif"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public MultiplicityHandlerState createState(boolean readOnly) {
		return new MultiplicityHandlerState(this, readOnly);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getAvailableValues(EObject objects) {
		return availableValues;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public void handleNotifyChange(Notification notification, List<? extends EObject> objects, EMFPropertyEditorController adapter) {
		// if one element is added to the feature, should also add this as a listener
		// if one element is removed from the feature, should also remove this as a listener
		// in other case, except removing adapters, should refresh
		Object notificationFeature = notification.getFeature();
		if(!(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue().equals(notificationFeature) || UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(notificationFeature))) {
			return;
		}

		switch(notification.getEventType()) {
		case Notification.ADD:
			// check which feature has been modified
			((EObject)notification.getNewValue()).eAdapters().add(adapter);
			// refresh the editors
			adapter.refreshDisplay();
			break;
		case Notification.ADD_MANY:
			// check which feature has been modified
			for(EObject newValue : ((List<EObject>)notification.getNewValue())) {
				newValue.eAdapters().add(adapter);
			}
			// refresh the editors
			adapter.refreshDisplay();
			break;

		case Notification.REMOVE:
			// check which feature has been modified
			((EObject)notification.getOldValue()).eAdapters().remove(this);
			// refresh the editors
			adapter.refreshDisplay();
			break;

		case Notification.REMOVE_MANY:
			for(EObject newValue : ((List<EObject>)notification.getOldValue())) {
				newValue.eAdapters().remove(adapter);
			}
			// refresh the editors
			adapter.refreshDisplay();
			break;
		case Notification.SET:
		case Notification.UNSET:
			adapter.refreshDisplay();
			break;
		}





		// if one element is added to the feature, should also add this as a listener
		// if one element is removed from the feature, should also remove this as a listener
		// in other case, except removing adapters, should refresh
		if(Notification.ADD == notification.getEventType()) {
			// check which feature has been modified
			Object o = notification.getFeature();
			if(o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) || o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue())) {
				((EObject)notification.getNewValue()).eAdapters().add(adapter);
				// refresh the editors
				adapter.refreshDisplay();
			}
		} else if(Notification.ADD_MANY == notification.getEventType()) {
			Object o = notification.getFeature();
			if(o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) || o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue())) {
				for(EObject newValue : ((List<EObject>)notification.getNewValue())) {
					newValue.eAdapters().add(adapter);
				}
				// refresh the editors
				adapter.refreshDisplay();
			}
		} else if(Notification.REMOVE == notification.getEventType()) {
			// check which feature has been modified
			Object o = notification.getFeature();
			if(o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) || o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue())) {
				((EObject)notification.getOldValue()).eAdapters().remove(this);
				// refresh the editors
				adapter.refreshDisplay();
			}
		} else if(Notification.REMOVE_MANY == notification.getEventType()) {
			Object o = notification.getFeature();
			if(o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) || o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue())) {
				for(EObject newValue : ((List<EObject>)notification.getOldValue())) {
					newValue.eAdapters().remove(adapter);
				}
				// refresh the editors
				adapter.refreshDisplay();
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void addListenersToModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller) {
		for(EObject object : objectsToEdit) {
			object.eAdapters().add(controller);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListenersFromModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller) {
		for(EObject object : objectsToEdit) {
			object.eAdapters().remove(controller);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IUndoableOperation> getCreateValueOperations(List<? extends EObject> objectsToEdit, Composite parent) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateValueOperations(List<? extends EObject> objectsToEdit) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getDeleteValueOperation(List<? extends EObject> objectsToEdit, Composite parent, List<Integer> indexes) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateDeleteValueOperation(List<? extends EObject> objectsToEdit) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getEditValueOperation(List<? extends EObject> objectsToEdit, int index, Composite parent, Object value) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateEditValueOperation(List<? extends EObject> objectsToEdit) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getMoveValueOperation(List<? extends EObject> objectsToEdit, List<Integer> indexes, Composite parent, int delta) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateMoveValueOperation(List<? extends EObject> objectsToEdit, List<Integer> indexes, Composite parent, int delta) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler#getSetRequest(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.ecore.EObject, java.lang.Object)
	 * 
	 * @param domain
	 * @param objectToEdit
	 * @param newValue
	 * @return
	 */
	public SetRequest[] getSetRequest(TransactionalEditingDomain domain, EObject objectToEdit, Object newValue) {
		// new Value should be a String with specific format: 
		// either m..n with m integer and n unlimited natural (including -1 or *)
		// or n, with n integer (this is a shortcut for n..n) 
		if(!(newValue instanceof String)) {
			Activator.log.warn("the new value for the multiplicity model handler was no a String"); //$NON-NLS-1$
			return null;
		}

		String value = (String)newValue;
		try {
			int[] values = MultiplicityElementUtil.parseMultiplicity(value);
			if(values.length == 2) {
				int lower = values[0];
				int upper = values[1];

				EStructuralFeature lowerFeature = EMFUtils.getFeatureByName(objectToEdit, "lower"); //$NON-NLS-1$
				EStructuralFeature upperFeature = EMFUtils.getFeatureByName(objectToEdit, "upper"); //$NON-NLS-1$

				if(lowerFeature != null && upperFeature != null) {
					SetRequest req1 = new SetRequest(domain, objectToEdit, lowerFeature, lower);
					SetRequest req2 = new SetRequest(domain, objectToEdit, upperFeature, upper);
					return new SetRequest[]{ req1, req2 };
				}
			}
		} catch (NumberFormatException e) {
			Activator.log.error("Error during multiplicity parsing", e); //$NON-NLS-1$
		}
		return null;
	}
}
