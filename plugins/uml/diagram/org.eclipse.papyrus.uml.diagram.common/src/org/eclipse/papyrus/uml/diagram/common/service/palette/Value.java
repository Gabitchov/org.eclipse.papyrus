/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import org.eclipse.core.runtime.Assert;

/**
 * 
 * This class is used to represent a {@link org.eclipse.uml2.uml.Property} value
 * 
 */
public class Value {

	/** the property owned this value */
	private PropertyRepresentation property = null;

	/** the value represented by a string */
	private String value;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param value
	 * 
	 */
	public Value(String value) {
		Assert.isNotNull(value);
		this.value = value;
	}

	/**
	 * 
	 * Constructor. Note : the field {@link PropertyRepresentation} is not
	 * copied
	 * 
	 * @param val
	 *        The {@link Value} used to instantiate a new {@value}
	 */
	public Value(Value val) {
		Assert.isNotNull(val);
		this.value = val.getValue();
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return
	 */
	public String toString() {
		return getValue();
	}

	/**
	 * Getter for {@link #property}
	 * 
	 * @return the property owning this value
	 */
	public PropertyRepresentation getPropertyRepresentation() {
		Assert.isNotNull(property);
		return property;
	}

	/**
	 * Returns the string representing this value
	 * 
	 * @return the string representing this value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the property owned this value (called by {@link PropertyRepresentation#addValue(Value)})
	 * 
	 * @param property
	 */
	public void setPropertyRepresentation(PropertyRepresentation property) {
		this.property = property;
	}

	/**
	 * Set a new value to this value
	 * 
	 * @param newValue
	 */
	public void setValue(String newValue) {
		this.value = newValue;
	}
}
