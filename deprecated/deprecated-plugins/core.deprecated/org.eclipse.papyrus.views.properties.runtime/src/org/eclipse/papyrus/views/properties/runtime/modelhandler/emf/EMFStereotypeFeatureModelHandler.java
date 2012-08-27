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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.EMFPropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
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
	 * {@inheritDoc}
	 */
	@Override
	public void addListenersToModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller) {
		super.addListenersToModel(objectsToEdit, controller);
		for(EObject object : objectsToEdit) {
			if(object instanceof Element) {
				Iterator<EObject> it = ((Element)object).getStereotypeApplications().iterator();
				while(it.hasNext()) {
					it.next().eAdapters().add(controller);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeListenersFromModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller) {
		super.removeListenersFromModel(objectsToEdit, controller);
		for(EObject object : objectsToEdit) {
			if(object instanceof Element) {
				Iterator<EObject> it = ((Element)object).getStereotypeApplications().iterator();
				while(it.hasNext()) {
					it.next().eAdapters().remove(controller);
				}
			}
		}
	}

	/**
	 * Creates a new EMFStereotypeFeatureModelHandler.
	 * 
	 * @param stereotypeName
	 *        name of the stereotype to which this feature belongs
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
	public EStructuralFeature getFeatureByName(EObject objectToEdit) {
		if(objectToEdit instanceof Element) {
			return EMFUtils.getStereotypeFeatureByName((Element)objectToEdit, retrieveStereotype((Element)objectToEdit), getFeatureName());
		}
		Activator.log.error("Impossible to cast into UML element: " + objectToEdit, null); //$NON-NLS-1$
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getAvailableValues(EObject eObject) {
		EClass eClass = eObject.eClass();
		if(eClass == null) {
			Activator.log.debug("problems during initialization, looking for availables values"); //$NON-NLS-1$
			return null;
		}
		EStructuralFeature feature = getFeatureByName(eObject);
		if(!(feature instanceof EReference)) {
			Activator.log.debug("feature is not a reference, looking for availables values: " + feature); //$NON-NLS-1$
			return null;
		}

		IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(((Element)eObject).getStereotypeApplication(retrieveStereotype((Element)eObject)), IItemPropertySource.class);
		if(itemPropertySource == null) {
			Activator.log.debug("impossible to find item Property source for " + retrieveStereotype((Element)eObject)); //$NON-NLS-1$
			return null;
		}
		IItemPropertyDescriptor itemPropertyDescriptor = itemPropertySource.getPropertyDescriptor(retrieveStereotype((Element)eObject), feature);
		if(itemPropertyDescriptor == null) {
			Activator.log.debug("impossible to find item Property descriptor for " + retrieveStereotype((Element)eObject) + " and " + feature); //$NON-NLS-1$ //$NON-NLS-2$
			return null;
		}
		return itemPropertyDescriptor.getChoiceOfValues(eObject);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueToEdit(EObject objectToEdit) {
		if(!(objectToEdit instanceof Element)) {
			Activator.log.warn("the object to edit is not a UML2 Element: " + objectToEdit); //$NON-NLS-1$
			return null;
		}
		Element elementToEdit = (Element)objectToEdit;
		Stereotype stereotype = retrieveStereotype(elementToEdit);
		if(stereotype != null) {
			return getValueForElement(elementToEdit, stereotype);
		} else {
			Activator.log.warn("Impossible to get the stereotype: " + stereotypeName + " on the element: " + elementToEdit + " for feature " + getFeatureName()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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
	 * @return the value of the stereotype feature
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
			Activator.log.warn("the object to edit is not a UML2 Element: " + objectToEdit); //$NON-NLS-1$
			return;
		}
		Element elementToEdit = (Element)objectToEdit;
		Stereotype stereotype = retrieveStereotype(elementToEdit);
		if(stereotype != null) {
			setValueForElement(elementToEdit, stereotype, newValue);
		} else {
			Activator.log.warn("Impossible to set value to the stereotype: " + stereotypeName + " on the element: " + elementToEdit); //$NON-NLS-1$ //$NON-NLS-2$
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
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {

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
	public boolean isChangeable(List<? extends EObject> objectsToEdit) {
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
	protected Element retrieveElement(List<? extends EObject> objectToEdit) {
		if(objectToEdit.size() < 1) {
			return null;
		}

		EObject firstObject = objectToEdit.get(0);
		if(!(firstObject instanceof Element)) {
			Activator.log.warn("Object to edit should be a UML2 element: " + firstObject); //$NON-NLS-1$
			return null;
		}

		Element elementToEdit = (Element)firstObject;
		return elementToEdit;
	}

	/**
	 * Retrieves the structural feature
	 * 
	 * @param elementToEdit
	 *        the element for wich the structural feature should be retrieved
	 * @param stereotype
	 *        the stereotype for which the structural feature should be retrieved
	 * 
	 * @return the structural feature
	 */
	protected StructuralFeature retrieveStructuralFeature(Element elementToEdit, Stereotype stereotype) {
		for(Property property : stereotype.getAllAttributes()) {
			if(getFeatureName().equals(property.getName())) {
				return property;
			}
		}
		Activator.log.warn("No feature fond with name:" + getFeatureName() + " for stereotype " + stereotypeName); //$NON-NLS-1$ //$NON-NLS-2$
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEMFModelHandlerState createState(boolean readOnly) {
		return new EMFStereotypeFeatureModelHandlerState(this, readOnly);
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
		return null; //TODO
	}

}
