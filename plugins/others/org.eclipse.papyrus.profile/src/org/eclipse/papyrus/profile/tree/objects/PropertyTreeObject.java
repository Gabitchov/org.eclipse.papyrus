/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

import java.util.Iterator;
import java.util.List;

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
 * The Class PropertyTreeObject.
 */
public class PropertyTreeObject extends ParentTreeObject {
	
	/**
	 * The property.
	 */
	private Property property;

	/**
	 * The Constructor.
	 * 
	 * @param property the property
	 * @param parent the parent
	 */
	public PropertyTreeObject(StereotypeTreeObject parent, Property property) {
		super(parent, property);
		this.property = property;
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
	 * Creates the children.
	 */
	@Override
	protected void createChildren() {
		// Retrieve value
		Object value = getValue();
		if (value == null) {
			return;
		}

		if (property.isMultivalued()) {
			List values = (List) value;
			Iterator it = values.iterator();		
			while (it.hasNext()) {
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
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Object getValue() {
		StereotypeTreeObject sTO = (StereotypeTreeObject) getParent();
		RootElementTreeObject rTO= (RootElementTreeObject) sTO.getParent();

		Stereotype st = sTO.getStereotype();
		Element elt   = rTO.getElement();
		return elt.getValue(st, property.getName());
	}

	/**
	 * Creates the value tree object.
	 * 
	 * @param value the value
	 * 
	 * @return the value tree object
	 */
	private ValueTreeObject createValueTreeObject(Object value) {
		Type type = property.getType();
		// Select correct class based on its type
		ValueTreeObject vTO = null;
		
		/** Property type is a PrimitiveType */
		if (type instanceof PrimitiveType) {
			vTO = PrimitiveTypeValueTreeObject.createInstance(this, value);	
			
			/** Property type is a metaclass */
		} else if (Util.isMetaclass(type)) {			
			vTO = new MetaclassValueTreeObject(this, value);
			
			/** Property type is an Enumeration */
		} else if (type instanceof Enumeration) {
			vTO = new EnumerationValueTreeObject(this, value);
			
			/** Property is a dataType */
		} else if (type instanceof DataType) {
			vTO = new DataTypeValueTreeObject(this, value);
			
			/** Property is a stereotype */
		} else if (type instanceof Stereotype) {		
			vTO = new StereotypeValueTreeObject(this, value);

			/** property is a composite class */
		} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isComposite()) {
			vTO = new CompositeValueTreeObject(this, value);
		}
		
		return vTO;
	}
}