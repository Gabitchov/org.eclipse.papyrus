/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.tree.objects;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.utils.Util;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * The Class AppliedStereotypePropertyTreeObject. References a stereotype attribute
 * (property)
 */
public class AppliedStereotypePropertyTreeObject extends ParentTreeObject {

	/**
	 * The property.
	 */
	private Property property;

	/**
	 * The Constructor.
	 * 
	 * @param property
	 *        the property
	 * @param parent
	 *        the parent
	 */
	public AppliedStereotypePropertyTreeObject(AppliedStereotypeTreeObject parent, Property property) {
		super(parent);
		this.property = property;
	}

	public Stereotype getParentStereotype() {
		return ((AppliedStereotypeTreeObject)getParent()).getStereotype();
	}

	/**
	 * Gets the property.
	 * 
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * Reinitialize the children from model, useful to reflect model changes in
	 * the value tree.
	 */
	public void reInitChilds() {
		children.clear();
		createChildren();
	}

	/**
	 * Creates the children.
	 */
	@Override
	protected void createChildren() {
		// Retrieve value which is normally either a list of objects or a single object
		Object value = getValue();
		if(value == null) {
			return;
		}

		if(value instanceof EList) {
			@SuppressWarnings("unchecked")
			EList<Object> values = (EList<Object>)value;
			Iterator<Object> it = values.iterator();
			while(it.hasNext()) {
				final Object currentValue = it.next();
				ValueTreeObject vTO = createValueTreeObject(currentValue);
				addChild(vTO);
			}
		} else {
			ValueTreeObject vTO = createValueTreeObject(value);
			addChild(vTO);
		}
	}

	/**
	 * Returns the value of the stereotype attribute
	 * 
	 * @return the value
	 */
	public Object getValue() {
		AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject)getParent();
		StereotypedElementTreeObject rTO = (StereotypedElementTreeObject)sTO.getParent();

		Stereotype st = sTO.getStereotype();
		Element elt = rTO.getElement();
		return elt.getValue(st, property.getName());
	}

	public Element getElement() {
		AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject)getParent();
		StereotypedElementTreeObject rTO = (StereotypedElementTreeObject)sTO.getParent();

		return rTO.getElement();
	}

	public EStructuralFeature getFeature() {
		return getStereotypeApplication().eClass().getEStructuralFeature(property.getName());
	}

	public EObject getStereotypeApplication() {
		return getElement().getStereotypeApplication(getStereotype());
	}

	public Stereotype getStereotype() {
		AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject)getParent();
		return sTO.getStereotype();
	}

	/**
	 * Creates the value tree object.
	 * 
	 * @param value
	 *        the value
	 * 
	 * @return the value tree object
	 */
	private ValueTreeObject createValueTreeObject(Object value) {
		Type type = property.getType();
		// Select correct class based on its type
		ValueTreeObject vTO = null;

		/** Property type is a PrimitiveType */
		if(type instanceof PrimitiveType) {
			vTO = PrimitiveTypeValueTreeObject.createInstance(this, value);

			/** Property type is a metaclass */
		} else if(Util.isMetaclass(type)) {
			vTO = new MetaclassValueTreeObject(this, value);

			/** Property type is an Enumeration */
		} else if(type instanceof Enumeration) {
			vTO = new EnumerationValueTreeObject(this, value);

			/** Property is a dataType */
		} else if(type instanceof DataType) {
			vTO = new DataTypeValueTreeObject(this, value);

			/** Property is a stereotype */
		} else if(type instanceof Stereotype) {
			vTO = new StereotypeValueTreeObject(this, value);

			/** property is a composite class */
		} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isComposite()) {
			vTO = new CompositeValueTreeObject(this, value);
		}

		return vTO;
	}

	/**
	 * This function is used prior to updating the model. It will add the new value to the
	 * list of existing values, in case of a multi-valued property. editMe methods should call
	 * this method before calling update.
	 * 
	 * @param newValue
	 *        a new value for the property (must not be a list itself)
	 * @return a new list which the existing stereotype value and the newValue in case of
	 *         a multi-value property or the newValue, if not multi-valued
	 */
	public Object appendMV(Object newValue) {

		Stereotype stereotype = ((AppliedStereotypeTreeObject)getParent()).getStereotype();
		Element element = ((StereotypedElementTreeObject)getParent().getParent()).getElement();

		if(property.isMultivalued()) {
			// add to existing contents
			Object existingValue = element.getValue(stereotype, property.getName());
			if(existingValue instanceof EList) {
				@SuppressWarnings("unchecked")
				EList<Object> existingValueList = (EList<Object>)existingValue;
				EList<Object> valueList = new BasicEList<Object>();
				valueList.addAll(existingValueList);
				valueList.add(newValue);
				return valueList;
			}
		}
		return newValue;
	}

	/**
	 * Remove elements from the list of proposed stereotype values that have already
	 * selected - except the currently selected element.
	 * 
	 * @param proposalList
	 *        the list of possible stereotype values
	 * @param oldValue
	 *        the currently selected value
	 */
	protected <T extends Object> void removeSelected(List<T> proposalList, T oldValue) {
		if(property.isMultivalued()) {
			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>)getValue();
			if(values != null) {
				proposalList.removeAll(values);
			}
			if(oldValue != null) {
				proposalList.add(oldValue);
			}
		}
	}

	/**
	 * Update value by means of a command that is executed within the Papyrus
	 * editing domain.
	 * 
	 * @param newValue
	 *        the new value
	 */
	public void updateValue(final Object newValue) {

		// use domain to update the value
		TransactionalEditingDomain domain;
		try {
			domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(property);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return;
		}

		RecordingCommand command = new RecordingCommand(domain, "Edit Stereotype Property Value") {

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected void doExecute() {
				Stereotype stereotype = ((AppliedStereotypeTreeObject)getParent()).getStereotype();
				Element element = ((StereotypedElementTreeObject)getParent().getParent()).getElement();

				Property property = getProperty();

				// Affect newValue in UML model
				element.setValue(stereotype, property.getName(), newValue);
			}
		};
		domain.getCommandStack().execute(command);
	}

}
