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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.EMFPropertyEditorController;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.graphics.Image;


/**
 * Abstract class for EMF Model handlers
 */
public abstract class EMFFeatureModelHandler implements IEMFModelHandler {

	/** name of the feature to edit */
	private final String featureName;

	/** factory used by EMF objects */
	protected AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/**
	 * Creates a new EMFFeatureModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public EMFFeatureModelHandler(String featureName) {
		this.featureName = featureName;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValueToEdit(EObject objectToEdit) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		return objectToEdit.eGet(featureToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public abstract void setValueInModel(EObject objectToEdit, Object newValue);

	/**
	 * {@inheritDoc}
	 */
	public abstract void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<EObject> objectToEdit);

	/**
	 * Returns the name of the feature to edit
	 * 
	 * @return the name of the feature to edit
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * Retrieve the main {@link EStructuralFeature} of this model handler
	 * 
	 * @param objectToEdit
	 *        the object being edited
	 * @return the feature found <code>null</code> if not found
	 */
	public EStructuralFeature getFeatureByName(EObject objectToEdit) {
		return EMFUtils.getFeatureByName(objectToEdit, featureName);
	}

	/**
	 * checks if the feature is changeable
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return <code>true</code> if the feature is changeable
	 */
	public boolean isChangeable(List<EObject> objectsToEdit) {
		if(objectsToEdit.size() < 1) {
			return false;
		}
		// retrieve the feature
		EStructuralFeature feature = getFeatureByName(objectsToEdit.get(0));
		return (feature != null) ? feature.isChangeable() : false;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "EMF Handler \"" + getId() + "\" -> " + getFeatureName();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/ModelHandler.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public IEMFModelHandlerState createState(boolean readOnly) {
		return new EMFFeatureModelHandlerState(this, readOnly);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getAvailableValues(EObject eObject) {
		EClass eClass = eObject.eClass();
		if(eClass == null) {
			Activator.log.debug("problems during initialization, looking for availables values");
			return null;
		}
		EStructuralFeature feature = getFeatureByName(eObject);
		if(!(feature instanceof EReference)) {
			Activator.log.debug("feature is not a reference, looking for availables values: " + feature);
			return null;
		}

		IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(eObject, IItemPropertySource.class);
		if(itemPropertySource == null) {
			Activator.log.debug("impossible to find item Property source for " + eObject);
			return null;
		}
		IItemPropertyDescriptor itemPropertyDescriptor = itemPropertySource.getPropertyDescriptor(eObject, feature);
		if(itemPropertyDescriptor == null) {
			Activator.log.debug("impossible to find item Property descriptor for " + eObject + " and " + feature);
			return null;
		}
		return itemPropertyDescriptor.getChoiceOfValues(eObject);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public void handleNotifyChange(Notification notification, List<EObject> objects, Adapter adapter) {
		for(EObject eObject : objects) {
			// if one element is added to the feature, should also add this as a listener
			// if one element is removed from the feature, should also remove this as a listener
			// in other case, except removing adapters, should refresh
			if(Notification.ADD == notification.getEventType()) {
				// check which feature has been modified
				Object o = notification.getFeature();
				EStructuralFeature feature = getFeatureByName(eObject);
				if(o.equals(feature)) {
					((EObject)notification.getNewValue()).eAdapters().add(adapter);
				}
			} else if(Notification.ADD_MANY == notification.getEventType()) {
				Object o = notification.getFeature();
				EStructuralFeature feature = getFeatureByName(eObject);
				if(o.equals(feature)) {
					for(EObject newValue : ((List<EObject>)notification.getNewValue())) {
						newValue.eAdapters().add(adapter);
					}
				}
			} else if(Notification.REMOVE == notification.getEventType()) {
				// check which feature has been modified
				Object o = notification.getFeature();
				EStructuralFeature feature = getFeatureByName(eObject);
				if(o.equals(feature)) {
					((EObject)notification.getOldValue()).eAdapters().remove(this);
				}
			} else if(Notification.REMOVE_MANY == notification.getEventType()) {
				Object o = notification.getFeature();
				EStructuralFeature feature = getFeatureByName(eObject);
				if(o.equals(feature)) {
					for(EObject newValue : ((List<EObject>)notification.getOldValue())) {
						newValue.eAdapters().remove(adapter);
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListenersToModel(List<EObject> objectsToEdit, EMFPropertyEditorController controller) {
		for(EObject object : objectsToEdit) {
			object.eAdapters().add(controller);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListenersFromModel(List<EObject> objectsToEdit, EMFPropertyEditorController controller) {
		for(EObject object : objectsToEdit) {
			object.eAdapters().remove(controller);
		}
	}
}
