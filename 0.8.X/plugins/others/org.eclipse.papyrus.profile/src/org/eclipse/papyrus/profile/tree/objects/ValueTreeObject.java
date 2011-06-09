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
 *  Ansgar Radermacher (CEA LIST) Ansgar.Radermacher@cea.fr - modification, documentation, clean-up
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * The Class ValueTreeObject. Superclass for stereotype values ("right" side of the stereotype
 * dialog. The attribute value corresponds to the stereotype value. Its type depends on the
 * stereotype, e.g. it might be a Java boolean or the class of another stereotype (an EObject).
 * Each ValueTreeObject provides the ability to edit its value, i.e. to call a dialog in which
 * the user selects a new value.
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
	public ValueTreeObject(AppliedStereotypePropertyTreeObject parent, Object value) {
		super(parent);
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
	 * Move me up: change order of values in case of a stereotype attribute supporting
	 * a set of values. Updates the order on model model level and tree level
	 * 
	 * @param index index of value that should move up
	 */
	public void moveMeUp(int index) {

		Object currentVal = ((AppliedStereotypePropertyTreeObject)getParent()).getValue();
		ArrayList<Object> tempValues = new ArrayList<Object>();

		if (currentVal instanceof EList) {
			@SuppressWarnings("unchecked")
			EList<Object> currentValues = (EList<Object>) currentVal;

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
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)getParent();
		pTO.updateValue (tempValues);
		
		// Refresh - move tree elements
		getParent().moveChildUp(this);
	}

	/**
	 * Move me down: change order of values in case of a stereotype attribute supporting
	 * a set of values. Updates the order on model model level and tree level
	 * 
	 * @param index index of the value that should move down
	 */
	public void moveMeDown(int index) {

		// Stereotype stereotype = ((AppliedStereotypeTreeObject)getParent().getParent()).getStereotype();
		// Element element = ((StereotypedElementTreeObject)getParent().getParent().getParent()).element;

		Object currentVal = ((AppliedStereotypePropertyTreeObject)getParent()).getValue();
		ArrayList<Object> tempValues = new ArrayList <Object>();

		if (currentVal instanceof EList) {
			@SuppressWarnings("unchecked")
			EList<Object> currentValues = (EList<Object>) currentVal;

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
		AppliedStereotypePropertyTreeObject pTO = (AppliedStereotypePropertyTreeObject)getParent();
		pTO.updateValue (tempValues);
		
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
	public static ValueTreeObject createInstance(AppliedStereotypePropertyTreeObject parent, Object newValue) {

		Property property = parent.getProperty();
		Type type = property.getType();
		ValueTreeObject newVTO = null;

			/** primitive type **/
		if(type instanceof PrimitiveType) {
			newVTO = PrimitiveTypeValueTreeObject.createInstance(parent, newValue);
			/** Composite **/
		} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isComposite()) {
			//
			/** Enumeration **/
		} else if(type instanceof Enumeration) {
			newVTO = new EnumerationValueTreeObject(parent, newValue);
			/** DataType **/
		} else if(type instanceof DataType) {
			newVTO = new DataTypeValueTreeObject(parent, newValue);
			/** Stereotype **/
		} else	if(type instanceof Stereotype) {
			newVTO = new StereotypeValueTreeObject(parent, newValue);
			/** Metaclass **/
		} else if(Util.isMetaclass(type)) {
			newVTO = new MetaclassValueTreeObject(parent, newValue);
		}
		
		return newVTO;
	}

	
	/**
	 * Edit me.
	 * Abstract method that must be implemented by heirs. It will open a dialog and provide a selection
	 * of possible stereotype values.
	 * The implementation should update the model with the new stereotype value. However, it does not
	 * need to update the value attribute with the new value entered by the user, this is the responsibility
	 * of the function that has called editMe (can be done by recreating the values from the model via
	 * reInitChilds on the owning property tree object (@see AppliedStereotypePropertyTreeObject).
	 */
	public abstract void editMe();
}
