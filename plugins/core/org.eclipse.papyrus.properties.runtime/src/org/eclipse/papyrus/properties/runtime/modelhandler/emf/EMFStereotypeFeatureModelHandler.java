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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;


/**
 * Abstract Model handler for stereotype properties
 */
public abstract class EMFStereotypeFeatureModelHandler extends EMFFeatureModelHandler {

	/** name of the stereotype to edit */
	private final String stereotypeName;

	/**
	 * Creates a new EMFStereotypeFeatureModelHandler.
	 * 
	 * @param featureName
	 *        he name of the feature to edit
	 */
	public EMFStereotypeFeatureModelHandler(String stereotypeName, String featureName) {
		super(featureName);
		this.stereotypeName = stereotypeName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueToEdit(EObject objectToEdit) {
		if(!(objectToEdit instanceof Element)) {
			Activator.log.warn("the object to edit is not a UML2 Element: " + objectToEdit);
			return null;
		}
		Element elementToEdit = (Element)objectToEdit;
		Stereotype stereotype = retrieveStereotype(elementToEdit);
		if(stereotype != null) {
			return getValueForElement(elementToEdit, stereotype);
		} else {
			Activator.log.warn("Impossible to set value to the stereotype: " + stereotypeName + " on the element: " + elementToEdit);
		}
		return null;
	}

	/**
	 * Returns the value for the given element
	 * 
	 * @param elementToEdit
	 *        the element being edited
	 * @param stereotype
	 *        the stereotype to edit
	 */
	protected Object getValueForElement(Element elementToEdit, Stereotype stereotype) {
		return elementToEdit.getValue(stereotype, getFeatureName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		if(!(objectToEdit instanceof Element)) {
			Activator.log.warn("the object to edit is not a UML2 Element: " + objectToEdit);
			return;
		}
		Element elementToEdit = (Element)objectToEdit;
		Stereotype stereotype = retrieveStereotype(elementToEdit);
		if(stereotype != null) {
			setValueForElement(elementToEdit, stereotype, newValue);
		} else {
			Activator.log.warn("Impossible to set value to the stereotype: " + stereotypeName + " on the element: " + elementToEdit);
		}
	}

	/**
	 * Sets the given value to the stereotype of the element
	 * 
	 * @param elementToEdit
	 *        the element to modify
	 * @param stereotype
	 *        the stereotype that contains the feature to modify
	 * @param newValue
	 *        the new value for the feature
	 */
	protected void setValueForElement(Element elementToEdit, Stereotype stereotype, Object newValue) {
		elementToEdit.setValue(stereotype, getFeatureName(), newValue);
	}

	/**
	 * Retrieve the stereotype given its qualified name
	 * 
	 * @param elementToEdit
	 *        the element being edited
	 * @return the stereotype found or <code>null</code> if no stereotype was found
	 */
	protected Stereotype retrieveStereotype(Element elementToEdit) {
		return elementToEdit.getAppliedStereotype(getStereotypeName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<EObject> objectToEdit) {

	}

	/**
	 * Returns the name of the stereotype to edit
	 * 
	 * @return the name of the stereotype to edit
	 */
	public String getStereotypeName() {
		return stereotypeName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isChangeable(List<EObject> objectsToEdit) {
		if(objectsToEdit.size() < 1) {
			return false;
		}

		Element element = retrieveElement(objectsToEdit);
		if(element == null) {
			return false;
		}

		// retrieve the feature
		Stereotype stereotype = retrieveStereotype(element);
		if(stereotype == null) {
			return false;
		}

		StructuralFeature feature = retrieveStructuralFeature(element, stereotype);
		return (feature != null) ? !feature.isReadOnly() : false;
	}

	/**
	 * Retrieve the element to edit
	 * 
	 * @param objectToEdit
	 *        the list of objects selected
	 * @return the element or null
	 */
	protected Element retrieveElement(List<EObject> objectToEdit) {
		if(objectToEdit.size() < 1) {
			return null;
		}

		EObject firstObject = objectToEdit.get(0);
		if(!(firstObject instanceof Element)) {
			Activator.log.warn("Object to edit should be a UML2 element: " + firstObject);
			return null;
		}

		Element elementToEdit = (Element)firstObject;
		return elementToEdit;
	}

	/**
	 * Retrieves the structural feature
	 * 
	 * @return the structural feature
	 */
	protected StructuralFeature retrieveStructuralFeature(Element elementToEdit, Stereotype stereotype) {
		for(Property property : stereotype.getAllAttributes()) {
			if(getFeatureName().equals(property.getName())) {
				return property;
			}
		}
		Activator.log.warn("No feature fond with name:" + getFeatureName() + " for stereotype " + stereotypeName);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IEMFModelHandlerState createState(boolean readOnly) {
		return new EMFStereotypeFeatureModelHandlerState(this, readOnly);
	}
}
