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

import java.util.ArrayList;

import org.eclipse.core.runtime.Assert;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * 
 * This class is used to represent a UML Property
 * 
 */
public class PropertyRepresentation {

	/**
	 * The property ID is used to represent a unique property. It's composed by
	 * : stereotype qualified name + {@link #separator} + {@link #propertyQualifiedName}
	 */
	private String propID;

	/** the values owned by this property */
	private ArrayList<Value> values;

	/** the UML property represented by this class */
	private Property UMLProperty;

	/** Is it a runtime property? */
	private boolean isRuntimeProperty = false;

/**
	 * the {@link StereotypeRepresentation owning this
	 * 
	 * @link PropertyRepresentation}
	 */
	private StereotypeRepresentation stereotype;

	/** the property qualified name */
	private String propertyQualifiedName;

	/** the name of the property */
	private String name;

	/**
	 * separator used in the {@link #propID}. It's not useful, it's only to
	 * facilitate debug!
	 */
	static public String separator = "|";; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param stereotypeQualifiedName
	 *        the stereotype owning this property
	 * @param propertyQualifiedName
	 *        the property represented by this {@link PropertyRepresentation}
	 */
	public PropertyRepresentation(String stereotypeQualifiedName, String propertyQualifiedName) {
		this.propertyQualifiedName = propertyQualifiedName;
		this.propID = stereotypeQualifiedName + separator + propertyQualifiedName;
		values = new ArrayList<Value>();
	}

	/**
	 * 
	 * Constructor. Note : the values aren't not duplicated. The two
	 * PropertyRepresentation share the same instances of the values
	 * 
	 * @param propRep
	 *        the PropertyRepresentation used to instantiate a new
	 *        PropertyRepresentation
	 */
	public PropertyRepresentation(PropertyRepresentation propRep) {
		this.propertyQualifiedName = new String(propRep.getQualifiedName());
		this.propID = new String(propRep.getPropertyId());
		this.setUMLProperty(propRep.getUMLProperty());
		this.setRuntime(propRep.isRuntimeProperty);
		this.values = propRep.getValues();
	}

	/**
	 * Returns the property qualified name
	 * 
	 * @return the property qualified name
	 */
	public String getQualifiedName() {
		return propertyQualifiedName;
	}

	/**
	 * Adds the value to this property
	 * 
	 * @param value
	 *        the value to add to this property
	 */
	public void addValue(Value value) {
		value.setPropertyRepresentation(this);
		values.add(value);
	}

	/**
	 * Returns all the values owned by this property
	 * 
	 * @return all the values owned by this property
	 */
	public ArrayList<Value> getValues() {
		return values;
	}

	/**
	 * Returns the type of the property
	 * 
	 * @return the type of the property
	 */
	public Type getType() {
		Assert.isNotNull(UMLProperty, "The property has not been set!"); //$NON-NLS-1$
		return UMLProperty.getType();
	}

	/**
	 * Setter for {@link #propID}
	 * 
	 * @return {@link #propID}
	 */
	public String getPropertyId() {
		return propID;
	}

	/**
	 * Returns the upper multiplicity
	 * 
	 * @return the upper multiplicity
	 */
	public int getUpperMultiplicity() {
		Assert.isNotNull(UMLProperty, "The property has not been set!"); //$NON-NLS-1$
		return UMLProperty.getUpper();
	}

	/**
	 * Returns the string corresponding to the property multiplicity
	 * 
	 * @return the string corresponding to the property multiplicity
	 */
	protected String getPropertyMultiplicity() {
		Assert.isNotNull(UMLProperty, "The property has not been set!"); //$NON-NLS-1$
		String multiplicity = "[" + UMLProperty.getLower() + ".."; //$NON-NLS-1$ //$NON-NLS-2$
		int upper = UMLProperty.getUpper();
		if(upper == -1) {
			multiplicity += "*"; //$NON-NLS-1$
		} else {
			multiplicity += upper;
		}
		multiplicity += "]"; //$NON-NLS-1$
		return multiplicity;
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return
	 */
	public String toString() {
		return this.propID;
	}

	/**
	 * Returns the string corresponding to the value to display for the property
	 * 
	 * @return the string corresponding to the value to display for the property
	 * 
	 */
	protected String getValueToDisplay() {
		String label = null;
		ArrayList<Value> values = getValues();
		if(!values.isEmpty()) {
			label = values.toString();
		} else if(UMLProperty.isSetDefault()) {
			label = UMLProperty.getDefault();
		} else if(UMLProperty.isMultivalued()) {
			label = "[]"; //$NON-NLS-1$
		}
		return label;
	}

	/**
	 * Setter for the value to {@link #isRuntimeProperty}
	 * 
	 * @param value
	 */
	public void setRuntime(boolean value) {
		isRuntimeProperty = value;
	}

	/**
	 * Getter for {@link #isRuntimeProperty}
	 * 
	 * @return {@link #isRuntimeProperty}
	 */
	public boolean isRuntime() {
		return isRuntimeProperty;
	}

	/**
	 * Setter for {@link #UMLProperty}
	 * 
	 * @param property
	 *        the UML {@link Property}
	 */
	public void setUMLProperty(Property property) {
		this.UMLProperty = property;
		this.name = property.getName();
	}

	/**
	 * Set the stereotype owning this property (often called by {@link StereotypeRepresentation#addProperty(PropertyRepresentation)})
	 * 
	 * @param ste
	 * 
	 */
	public void setStereotype(StereotypeRepresentation ste) {
		this.stereotype = ste;
	}

	/**
	 * 
	 * @param value
	 *        the value to remove
	 */
	public void removeValue(Value value) {
		values.remove(value);
	}

	/**
	 * 
	 * @return <ul>
	 *         <li>{@code true} if the property has values</li>
	 *         <li>{@code false} if not</li>
	 *         </ul>
	 */
	public boolean hasValues() {
		return !values.isEmpty();
	}

	/**
	 * Returns the {@link StereotypeRepresentation} owning this {@link PropertyRepresentation}
	 * 
	 * @return the {@link StereotypeRepresentation} owning this {@link PropertyRepresentation}
	 */
	public StereotypeRepresentation getStereotypeRepresentation() {
		return stereotype;
	}

	/**
	 * Returns the {@link org.eclipse.uml.uml.Property} represented by this {@link PropertyRepresentation}
	 * 
	 * @return the {@link org.eclipse.uml.uml.Property} represented by this {@link PropertyRepresentation}
	 */
	public Property getUMLProperty() {
		Assert.isNotNull(UMLProperty, "The property has not been set!"); //$NON-NLS-1$
		return UMLProperty;
	}

	/**
	 * Returns the string representing this property, with this type and this
	 * value
	 * 
	 * @return the string representing this property, with this type and this
	 *         value
	 */
	public String getLabel() {
		String label = this.name;
		String type = ""; //$NON-NLS-1$
		if(getType() != null) {
			type = getType().getLabel();
		}
		label += ": " + type + getPropertyMultiplicity() + " = " + getValueToDisplay(); //$NON-NLS-1$ //$NON-NLS-2$
		return label;
	}

	/**
	 * Returns the values owned by this {@link PropertyRepresentation},
	 * represented by a string
	 * 
	 * @return the values owned by this {@link PropertyRepresentation},
	 *         represented by a string
	 */
	public ArrayList<String> getStringValue() {
		ArrayList<String> stringValues = new ArrayList<String>();
		for(Value val : values) {
			stringValues.add(val.getValue());
		}
		return stringValues;
	}
}
