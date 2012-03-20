/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.properties.constraints;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.uml.profile.properties.Activator;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class IsAppliedStereotypePropertyConstraint extends AbstractConstraint {

	/**
	 * The "propertyType" property
	 */
	public final static String PROPERTY_TYPE = "propertyType"; //$NON-NLS-1$

	/**
	 * The "multiplicity" property
	 */
	public final static String MULTIPLICITY = "multiplicity"; //$NON-NLS-1$

	private PropertyType type;

	@Override
	protected void setDescriptor(SimpleConstraint descriptor) {
		String propertyType = getValue(PROPERTY_TYPE);
		try {
			type = PropertyType.valueOf(propertyType);
		} catch (Exception ex) {
			Activator.log.error("The property type is invalid : \"" + propertyType + "\"", ex);
		}

		int propertyMultiplicity = 1;

		String multiplicityValue = getValue(MULTIPLICITY);
		if(multiplicityValue != null) {
			try {
				propertyMultiplicity = Integer.parseInt(multiplicityValue);
			} catch (NumberFormatException ex) {
				Activator.log.error("The property multiplicity is invalid : \"" + multiplicityValue + "\"", ex);
			}
		}

		if(propertyMultiplicity != 1) {
			type = getMultivaluedType(type);
		}
	}

	public boolean match(Object selection) {

		AppliedStereotypeProperty property = null;

		if(selection instanceof AppliedStereotypeProperty) {
			property = (AppliedStereotypeProperty)selection;
		}

		if(selection instanceof IAdaptable) {
			Object adapter = ((IAdaptable)selection).getAdapter(AppliedStereotypeProperty.class);
			if(adapter != null) {
				property = (AppliedStereotypeProperty)adapter;
			}
		}

		if(property == null || type == null) {
			return false;
		}

		PropertyType propertyType = findType(property.getStereotypeProperty());

		return type == propertyType;
	}

	protected PropertyType findType(Property property) {
		Type type = property.getType();
		if(type instanceof PrimitiveType) {
			try {
				return PropertyType.valueOf(type.getName());
			} catch (Exception ex) {
				//Unknown primitive type
				return PropertyType.String;
			}
		}

		if(type instanceof Enumeration) {
			return PropertyType.Reference;
		}

		if(type instanceof DataType) {
			return PropertyType.String;
		}

		if(type instanceof Classifier) {
			return PropertyType.Reference;
		}

		return PropertyType.String;
	}

	protected PropertyType getMultivaluedType(PropertyType type) {
		switch(type) {
		case Boolean:
			return PropertyType.MultivaluedBoolean;
		case String:
			return PropertyType.MultivaluedString;
		case Real:
			return PropertyType.MultivaluedReal;
		case Reference:
			return PropertyType.MultivaluedReference;
		case Integer:
			return PropertyType.MultivaluedInteger;
		}

		return type;
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if(!(constraint instanceof IsAppliedStereotypePropertyConstraint)) {
			return false;
		}

		if(type == null) {
			return false;
		}

		PropertyType otherType = ((IsAppliedStereotypePropertyConstraint)constraint).type;
		return type == otherType;
	}

	public static enum PropertyType {
		String, Integer, Real, Boolean, Reference, MultivaluedString, MultivaluedInteger, MultivaluedReal, MultivaluedBoolean, MultivaluedReference
	}
}
