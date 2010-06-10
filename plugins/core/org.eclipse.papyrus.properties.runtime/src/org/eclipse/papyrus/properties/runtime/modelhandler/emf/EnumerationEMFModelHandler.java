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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;

/**
 * Model Handler for enumeration
 */
public class EnumerationEMFModelHandler extends EMFFeatureModelHandler {

	/**
	 * Creates a new EnumerationEMFModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public EnumerationEMFModelHandler(String featureName) {
		super(featureName);
	}


	/** id of this model handler */
	public static final String ID = "Enumeration";

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
		return (value instanceof Enumerator) ? ((Enumerator)value).getLiteral() : value;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return;
		}
		// remove value if result of the editor is empty
		if(newValue == null || newValue.equals("")) {
			objectToEdit.eUnset(featureToEdit);
		} else {
			// retrieve the real value for the enumeration
			if(newValue instanceof String) {
				EEnum type = (EEnum)featureToEdit.getEType();
				EEnumLiteral literal = type.getEEnumLiteral((String)newValue);
				Enumerator instance = literal.getInstance();
				objectToEdit.eSet(featureToEdit, instance);
			}
		}
	}


	/**
	 * {@inheritDoc}
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<EObject> objectToEdit) {
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
			values.add("");
		}

		if(featureToEdit.getEType() instanceof EEnum) {
			EEnum type = ((EEnum)featureToEdit.getEType());
			for(EEnumLiteral literal : type.getELiterals()) {
				values.add(literal.getLiteral());
			}
		}
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(values);
		} else {
			Activator.log.info("Warning: " + descriptor + "could not be completed.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return ID;
	}
}
