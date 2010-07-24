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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
 * Pseudo extension of ParentTreeObject (property is always null)
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
	 * Move me up.
	 * 
	 * @param index
	 */
	public void moveMeUp(int index) {

		Property property = ((AppliedStereotypePropertyTreeObject)getParent()).getProperty();

		Object currentVal = ((AppliedStereotypePropertyTreeObject)getParent()).getValue();
		ArrayList<Object> tempValues = new ArrayList<Object>();

		if(property.isMultivalued()) {
			EList currentValues = (EList)currentVal;

			for(int i = 0; i < currentValues.size(); i++) {
				tempValues.add(currentValues.get(i));
			}
		} else {
			// Operation should not be called unless it refers to a multivalued property
			return;
		}

		if ((index < 1) || (index >= tempValues.size ())) {
			// Not found or already on top...
			return;
		}
		// swap elements at index and index-1
		Object tmp = tempValues.get(index - 1);
		tempValues.set(index - 1, value);
		tempValues.set(index, tmp);

		// update
		updateValue (tempValues);

		// Refresh - move tree elements
		getParent().moveChildUp(this);
	}

	/**
	 * Move me down.
	 * 
	 * @param index
	 */
	public void moveMeDown(int index) {

		Property property = ((AppliedStereotypePropertyTreeObject)getParent()).getProperty();
		// Stereotype stereotype = ((AppliedStereotypeTreeObject)getParent().getParent()).getStereotype();
		// Element element = ((StereotypedElementTreeObject)getParent().getParent().getParent()).element;

		Object currentVal = ((AppliedStereotypePropertyTreeObject)getParent()).getValue();
		ArrayList<Object> tempValues = new ArrayList <Object>();

		if(property.isMultivalued()) {
			EList currentValues = (EList) currentVal;

			for(int i = 0; i < currentValues.size(); i++) {
				tempValues.add(currentValues.get(i));
			}
		} else {
			// Operation should not be called unless it refers to a multivalued property
			return;
		}

		if ((index == -1) || (index >= tempValues.size() - 1)) {
			// Not found or already on bottom ...
			return;
		}
		// swap with index and index+1
		Object tmp = tempValues.get(index + 1);
		tempValues.set(index + 1, value);
		tempValues.set(index, tmp);

		// update
		updateValue (tempValues);
		
		// Refresh - move tree elements
		getParent().moveChildDown(this);
		// Force model change
		// Util.touchModel(element);
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
					element.setValue(stereotype, property.getName(), newValue);
					if (!property.isMultivalued()) {
						// update of multi-value is handled in add/remove/up/down/
						// => (no need to do it here)
						value = newValue;
					}
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
