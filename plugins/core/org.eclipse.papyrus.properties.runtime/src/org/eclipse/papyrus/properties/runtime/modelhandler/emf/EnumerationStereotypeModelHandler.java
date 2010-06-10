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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;


/**
 * Model Handler for enumeration-typed stereotype properties
 */
public class EnumerationStereotypeModelHandler extends EMFStereotypeFeatureModelHandler {

	/** identifier fot this model handler */
	public static final String ID = "EnumerationStereotype";

	/**
	 * Creates a new EnumerationStereotypeModelHandler.
	 * 
	 * @param stereotypeName
	 *        name of the stereotype to edit
	 * @param featureName
	 *        name of the feature to edit
	 */
	public EnumerationStereotypeModelHandler(String stereotypeName, String featureName) {
		super(stereotypeName, featureName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValueForElement(Element elementToEdit, Stereotype stereotype, Object newValue) {
		// remove value if result of the editor is empty
		if(newValue == null || newValue.equals("")) {
			// no unset for values ?!
			elementToEdit.setValue(stereotype, getFeatureName(), null);
		} else {
			// retrieve the real value for the enumeration
			if(newValue instanceof String) {
				StructuralFeature featureToEdit = retrieveStructuralFeature(elementToEdit, stereotype);
				Enumeration type = (Enumeration)featureToEdit.getType();
				EnumerationLiteral literal = type.getOwnedLiteral((String)newValue);
				System.err.println(literal);
				elementToEdit.setValue(stereotype, getFeatureName(), literal);
			}
		}
	}

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
		if(value instanceof EnumerationLiteral) {
			return ((EnumerationLiteral)value).getName();
		}
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<EObject> objectToEdit) {
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

		if(featureToEdit.getType() instanceof Enumeration) {
			Enumeration type = ((Enumeration)featureToEdit.getType());
			for(EnumerationLiteral literal : type.getOwnedLiterals()) {
				values.add(literal.getName());
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
