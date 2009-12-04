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
package org.eclipse.papyrus.profile.tree.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class ValueTreeObject.
 */
public abstract class ValueTreeObject extends ParentTreeObject {

	public AppliedStereotypePropertyTreeObject getThePropertyTreeObjectParent() {
		return thePropertyTreeObjectParent;
	}

	/**
	 * The value.
	 */
	protected Object value;

	protected AppliedStereotypePropertyTreeObject thePropertyTreeObjectParent;

	/**
	 * The Constructor.
	 * 
	 * @param value
	 *        the value
	 * @param parent
	 *        the parent
	 * @param domain
	 *        editing domain used to modify element values
	 */
	public ValueTreeObject(AppliedStereotypePropertyTreeObject parent, Object value, TransactionalEditingDomain domain) {
		super(parent, null, domain);
		thePropertyTreeObjectParent = parent;
		this.value = value;
	}

	/**
	 * Creates the children.
	 */
	@Override
	protected void createChildren() {

	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Removes the me.
	 */
	public void removeMe() {

		Property property = ((AppliedStereotypePropertyTreeObject)getParent()).getProperty();
		Stereotype stereotype = ((AppliedStereotypeTreeObject)getParent().getParent()).getStereotype();
		Element element = ((StereotypedElementTreeObject)getParent().getParent().getParent()).element;
		int lower = property.getLower();
		int upper = property.getUpper();

		// if lower multiplicity is equal to upper multiplicity
		if(lower == upper) {
			Message.warning("Multiplicity of this property is" + lower + ".." + upper + "\n" + "Impossible to remove a value.");
			return;
		}

		Object currentVal = ((AppliedStereotypePropertyTreeObject)getParent()).getValue();
		ArrayList tempValues = new ArrayList();

		if(((lower == 0) && (upper == 1))) {
			if(currentVal != null) {
				tempValues.add(currentVal);
			}

		} else if(upper != 1) {
			EList currentValues = (EList)currentVal;

			for(int i = 0; i < currentValues.size(); i++) {
				tempValues.add(currentValues.get(i));
			}
		}

		if((lower == 0) || (tempValues.size() > lower)) {
			tempValues.remove(value);

			if(property.isMultivalued()) {
				element.setValue(stereotype, property.getName(), tempValues);
			} else {
				element.setValue(stereotype, property.getName(), null);
			}

			// Refresh
			getParent().removeChild(this);
			parent = null;
			// Force model change
			Util.touchModel(element);

		} else {
			Message.warning("Lower multiplicity of " + property.getName() + " is " + lower);
		}
	}

	/**
	 * Move me up.
	 * 
	 * @param index
	 */
	public void moveMeUp(int index) {

		Property property = ((AppliedStereotypePropertyTreeObject)getParent()).getProperty();
		Stereotype stereotype = ((AppliedStereotypeTreeObject)getParent().getParent()).getStereotype();
		Element element = ((StereotypedElementTreeObject)getParent().getParent().getParent()).element;

		Object currentVal = ((AppliedStereotypePropertyTreeObject)getParent()).getValue();
		ArrayList tempValues = new ArrayList();

		if(property.isMultivalued()) {
			EList currentValues = (EList)currentVal;

			for(int i = 0; i < currentValues.size(); i++) {
				tempValues.add(currentValues.get(i));
			}
		} else {
			// Operation should not be called unless it refers to a multivalued property
			return;
		}

		if(index < 1) {
			// Not found of already on top...
			return;
		}
		Object tmp = tempValues.get(index - 1);
		tempValues.set(index - 1, value);
		tempValues.set(index, tmp);

		// Update !!!
		element.setValue(stereotype, property.getName(), tempValues);

		// Refresh - move tree elements
		getParent().moveChildUp(this);
		// Force model change
		Util.touchModel(element);
	}

	/**
	 * Move me down.
	 * 
	 * @param index
	 */
	public void moveMeDown(int index) {

		Property property = ((AppliedStereotypePropertyTreeObject)getParent()).getProperty();
		Stereotype stereotype = ((AppliedStereotypeTreeObject)getParent().getParent()).getStereotype();
		Element element = ((StereotypedElementTreeObject)getParent().getParent().getParent()).element;

		Object currentVal = ((AppliedStereotypePropertyTreeObject)getParent()).getValue();
		ArrayList tempValues = new ArrayList();

		if(property.isMultivalued()) {
			EList currentValues = (EList)currentVal;

			for(int i = 0; i < currentValues.size(); i++) {
				tempValues.add(currentValues.get(i));
			}
		} else {
			// Operation should not be called unless it refers to a multivalued property
			return;
		}

		if((index == -1) || (index >= tempValues.size() - 1)) {
			// Not found or already on top...
			return;
		}
		Object tmp = tempValues.get(index + 1);
		tempValues.set(index + 1, value);
		tempValues.set(index, tmp);

		// Update !!!
		element.setValue(stereotype, property.getName(), tempValues);

		// Refresh - move tree elements
		getParent().moveChildDown(this);
		// Force model change
		Util.touchModel(element);
	}

	/**
	 * Creates the instance.
	 * 
	 * @param newValue
	 *        the new value
	 * @param parent
	 *        the parent
	 * 
	 * @return the value tree object
	 */
	public static ValueTreeObject createInstance(AppliedStereotypePropertyTreeObject parent, Object newValue, TransactionalEditingDomain domain) {

		Property property = parent.getProperty();
		Type type = property.getType();
		ValueTreeObject newVTO = null;

		/** primitive type **/
		if(type instanceof PrimitiveType) {
			newVTO = PrimitiveTypeValueTreeObject.createInstance(parent, newValue, domain);
			/** Composite **/
		} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isComposite()) {
			//
			/** Enumeration **/
		} else if(type instanceof Enumeration) {
			newVTO = new EnumerationValueTreeObject(parent, newValue, domain);
			/** DataType **/
		} else if(type instanceof DataType) {
			newVTO = new DataTypeValueTreeObject(parent, newValue, domain);
			/** Stereotype **/
		} else if(type instanceof Stereotype) {
			newVTO = new StereotypeValueTreeObject(parent, newValue, domain);
			/** Metaclass **/
		} else if(Util.isMetaclass(type)) {
			newVTO = new MetaclassValueTreeObject(parent, newValue, domain);
		}

		return newVTO;
	}

	/**
	 * Update value.
	 * 
	 * @param newValue
	 *        the new value
	 */
	protected void updateValue(final Object newValue) {

		// use domain to update the value
		RecordingCommand command = new RecordingCommand(domain, "Edit Stereotype Property Value") {

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected void doExecute() {
				AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)getParent();
				Stereotype stereotype = ((AppliedStereotypeTreeObject)getParent().getParent()).getStereotype();
				Element element = ((StereotypedElementTreeObject)getParent().getParent().getParent()).getElement();

				Property property = pTO.getProperty();

				if(newValue != null) {
					// Affect newValue in UML model
					if(property.isMultivalued()) {
						List values = new ArrayList();
						values.addAll((List)pTO.getValue());
						List tmpChildren = Arrays.asList(pTO.getChildren());
						int index = tmpChildren.indexOf(this);
						if(index == -1) {
							return;
						}
						// Set newValue in value list
						values.set(index, newValue);
						element.setValue(stereotype, property.getName(), values);
					} else {
						element.setValue(stereotype, property.getName(), newValue);
					}

					// Update TreeObject
					value = newValue;

					// Force model change
					// Util.touchModel(element);
				}
			}
		};
		domain.getCommandStack().execute(command);

	}

	/**
	 * Edits the me.
	 */
	public abstract void editMe();
}
