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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;

/**
 * Model Handler for enumeration
 */
public class BooleanEMFModelHandler extends EnumerationEMFModelHandler {

	/** id of this model handler */
	public static final String ID = "Boolean"; //$NON-NLS-1$

	/**
	 * Creates a new BooleanEMFModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public BooleanEMFModelHandler(String featureName) {
		super(featureName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueToEdit(EObject objectToEdit) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		Object value = objectToEdit.eGet(featureToEdit);

		// should perhaps take into account default values in case the feature is not set...
		return (value instanceof Boolean) ? ((Boolean)value).toString() : value;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return;
		}
		// remove value if result of the editor is empty
		if(newValue == null || newValue.equals("")) { //$NON-NLS-1$
			objectToEdit.eUnset(featureToEdit);
		} else if(newValue instanceof String) {
			objectToEdit.eSet(featureToEdit, Boolean.parseBoolean((String)newValue));
		} else if(newValue instanceof Boolean) {
			objectToEdit.eSet(featureToEdit, newValue);
		} else if(newValue instanceof List<?>) {
			List<Object> newValues = new ArrayList<Object>();
			for(Object value : (List<Object>)newValue) {
				if(value instanceof String) {
					newValues.add(Boolean.parseBoolean((String)value));
				} else if(value instanceof Boolean) {
					newValues.add(value);
				}
			}
			objectToEdit.eSet(featureToEdit, newValues);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {
		if(objectToEdit.size() < 1) {
			return;
		}
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit.get(0));
		if(featureToEdit == null) {
			return;
		}
		// test enumeration, reference, etc.
		List<String> values = new ArrayList<String>();

		// check if there is an empty string at the beginning. there is one if the lower bound of the feature to edit equal 0 
		if(featureToEdit.getLowerBound() == 0) {
			values.add(""); //$NON-NLS-1$
		}

		values.add("true"); //$NON-NLS-1$
		values.add("false"); //$NON-NLS-1$
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(values);
		} else {
			Activator.log.debug("Warning: " + descriptor + "could not be completed."); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return ID;
	}

	/**
	 * 
	 * @param objectToEdit
	 * @param newValue
	 * @return
	 */
	@Override
	public SetRequest[] getSetRequest(TransactionalEditingDomain domain, EObject objectToEdit, Object newValue) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		// remove value if result of the editor is empty
		if(newValue == null || newValue.equals("")) { //$NON-NLS-1$
			return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, featureToEdit.getDefaultValue()) };
		} else if(newValue instanceof String) {
			return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, Boolean.parseBoolean((String)newValue)) };
		} else if(newValue instanceof Boolean) {
			return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, newValue) };
		} else if(newValue instanceof List<?>) {
			List<Object> newValues = new ArrayList<Object>();
			for(Object value : (List<?>)newValue) {
				if(value instanceof String) {
					newValues.add(Boolean.parseBoolean((String)value));
				} else if(value instanceof Boolean) {
					newValues.add(value);
				}
			}
			return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, newValues) };
		}
		return null;
	}
}
