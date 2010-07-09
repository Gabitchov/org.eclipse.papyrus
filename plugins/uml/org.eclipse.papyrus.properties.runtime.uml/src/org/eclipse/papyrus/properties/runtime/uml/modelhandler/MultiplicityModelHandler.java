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
package org.eclipse.papyrus.properties.runtime.uml.modelhandler;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.EMFUtils;
import org.eclipse.papyrus.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.properties.runtime.uml.Activator;
import org.eclipse.papyrus.umlutils.MultiplicityElementUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Model Handler for the Multiplicity of {@link MultiplicityElement}
 */
public class MultiplicityModelHandler implements IEMFModelHandler {

	/** list of available values */
	private final List<String> availableValues;

	/** id of this model handler */
	public final static String ID = "Multiplicity";

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
			Activator.log.warn("the new value for the multiplicity model handler was no a String");
			return;
		}

		String value = (String)newValue;
		try {
			int[] values = MultiplicityElementUtil.parseMultiplicity(value);
			if(values.length == 2) {
				int lower = values[0];
				int upper = values[1];

				EStructuralFeature lowerFeature = EMFUtils.getFeatureByName(objectToEdit, "lower");
				EStructuralFeature upperFeature = EMFUtils.getFeatureByName(objectToEdit, "upper");

				if(lowerFeature != null && upperFeature != null) {
					objectToEdit.eSet(lowerFeature, lower);
					objectToEdit.eSet(upperFeature, upper);
				}
			}
		} catch (NumberFormatException e) {
			Activator.log.error("Error during multiplicity parsing", e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<EObject> objectToEdit) {
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(getAvailableValues(null));
		} else {
			Activator.log.warn(descriptor + "could not be completed.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValueToEdit(EObject objectToEdit) {
		if(objectToEdit instanceof MultiplicityElement) {
			return MultiplicityElementUtil.getMultiplicityAsStringWithoutSquareBrackets((MultiplicityElement)objectToEdit);
		}
		return "NaN";
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isChangeable(List<EObject> objectsToEdit) {
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
		return "MultiplicityHandler";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/MultiplicityHandler.gif");
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
	public void handleNotifyChange(Notification notification, List<EObject> objects, Adapter adapter) {
		// if one element is added to the feature, should also add this as a listener
		// if one element is removed from the feature, should also remove this as a listener
		// in other case, except removing adapters, should refresh
		if(Notification.ADD == notification.getEventType()) {
			// check which feature has been modified
			Object o = notification.getFeature();
			if(o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) || o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue())) {
				((EObject)notification.getNewValue()).eAdapters().add(adapter);
			}
		} else if(Notification.ADD_MANY == notification.getEventType()) {
			Object o = notification.getFeature();
			if(o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) || o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue())) {
				for(EObject newValue : ((List<EObject>)notification.getNewValue())) {
					newValue.eAdapters().add(adapter);
				}
			}
		} else if(Notification.REMOVE == notification.getEventType()) {
			// check which feature has been modified
			Object o = notification.getFeature();
			if(o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) || o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue())) {
				((EObject)notification.getOldValue()).eAdapters().remove(this);
			}
		} else if(Notification.REMOVE_MANY == notification.getEventType()) {
			Object o = notification.getFeature();
			if(o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()) || o.equals(UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue())) {
				for(EObject newValue : ((List<EObject>)notification.getOldValue())) {
					newValue.eAdapters().remove(adapter);
				}
			}
		}

	}
}
