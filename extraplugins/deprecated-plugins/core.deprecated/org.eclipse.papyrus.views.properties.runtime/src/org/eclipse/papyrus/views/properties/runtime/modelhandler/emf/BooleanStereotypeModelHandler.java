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
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;


/**
 * Model Handler for Boolean-typed stereotype properties
 */
public class BooleanStereotypeModelHandler extends EnumerationStereotypeModelHandler {

	/**
	 * Creates a new BooleanStereotypeModelHandler.
	 * 
	 * @param stereotypeName
	 *        the name of the stereotype
	 * @param featureName
	 *        the name of the feature
	 */
	public BooleanStereotypeModelHandler(String stereotypeName, String featureName) {
		super(stereotypeName, featureName);
	}

	/** identifier for this model handler */
	public static final String ID = "BooleanStereotype";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueToEdit(EObject objectToEdit) {
		if(!(objectToEdit instanceof Element)) {
			Activator.log.warn("the element selected is not a UML element: " + objectToEdit);
			return null;
		}
		Element elementToEdit = (Element)objectToEdit;
		Stereotype stereotype = retrieveStereotype(elementToEdit);
		if(stereotype == null) {
			Activator.log.warn("Impossible to find the stereotype " + getStereotypeName() + " for the given element" + elementToEdit);
			return null;
		}
		Object value = elementToEdit.getValue(stereotype, getFeatureName());

		// should perhaps take into account default values in case the feature is not set...
		return (value instanceof Boolean) ? ((Boolean)value).toString() : value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		if(!(objectToEdit instanceof Element)) {
			Activator.log.warn("the element selected is not a UML element: " + objectToEdit);
			return;
		}
		Element elementToEdit = (Element)objectToEdit;
		Stereotype stereotype = retrieveStereotype(elementToEdit);
		if(stereotype == null) {
			Activator.log.warn("Impossible to find the stereotype " + getStereotypeName() + " for the given element" + elementToEdit);
			return;
		}

		// remove value if result of the editor is empty
		if(newValue == null || newValue.equals("")) {
			elementToEdit.setValue(stereotype, getFeatureName(), null);
		} else if(newValue instanceof String) {
			elementToEdit.setValue(stereotype, getFeatureName(), Boolean.parseBoolean((String)newValue));
		} else if(newValue instanceof Boolean) {
			elementToEdit.setValue(stereotype, getFeatureName(), (Boolean)newValue);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {
		Element elementToEdit = retrieveElement(objectToEdit);
		if(elementToEdit == null) {
			return;
		}
		Stereotype stereotype = retrieveStereotype(elementToEdit);

		if(stereotype == null) {
			Activator.log.warn("Impossible to find stereotype: " + getStereotypeName() + " for element: " + elementToEdit);
			return;
		}

		StructuralFeature featureToEdit = retrieveStructuralFeature(elementToEdit, stereotype);

		// test enumeration, reference, etc.
		List<String> values = new ArrayList<String>();

		// check if there is an empty string at the beginning. there is one if the lower bound of the feature to edit equal 0 
		if(featureToEdit.getLower() == 0) {
			values.add("");
		}

		values.add("true");
		values.add("false");
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(values);
		} else {
			Activator.log.error("Warning: " + descriptor + "could not be completed.", null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return ID;
	}
}
