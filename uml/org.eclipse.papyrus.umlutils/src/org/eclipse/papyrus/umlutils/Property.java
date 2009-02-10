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
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * 
 * 
 * 
 * This class encapsulates an <code>org.eclipse.uml2.uml.Property</code> object.
 */
public class Property extends NamedElement {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Property uml2Property;

	/**
	 * 
	 */
	public final static String UNDEFINED_TYPE_NAME = "<Undefined>";

	/**
	 * 
	 */
	protected final static String PUBLIC_STRING = "+";

	/**
	 * 
	 */
	protected final static String PROTECTED_STRING = "#";

	/**
	 * 
	 */
	protected final static String PRIVATE_STRING = "-";

	/**
	 * 
	 */
	protected final static String PACKAGE_STRING = "~";

	/**
	 * 
	 * 
	 * @param property
	 */
	public Property(org.eclipse.uml2.uml.Property property) {
		super(property);
		uml2Property = property;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public org.eclipse.uml2.uml.Property getUml2Property() {
		return uml2Property;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public org.eclipse.papyrus.umlutils.VisibilityKind getVisibility() {
		return (new org.eclipse.papyrus.umlutils.VisibilityKind(uml2Property.getVisibility()));
	}

	/**
	 * Gives the full name of the attribute (ie the name prefixed vith the visibility).
	 * 
	 * @return
	 */
	@Override
	public String getFullName() {

		String visibilityString;
		switch (uml2Property.getVisibility().getValue()) {
		case VisibilityKind.PRIVATE:
			visibilityString = "private_";
			break;
		case VisibilityKind.PROTECTED:
			visibilityString = "protected_";
			break;
		default:
			visibilityString = "";
			break;
		}

		return visibilityString + getName();
	}

	/**
	 * Gives the type of the attribute.
	 * 
	 * @return
	 */
	public Type getType() {
		Type attributeType;
		if (uml2Property.getType() != null) {
			attributeType = new Type(uml2Property.getType());
		} else {
			attributeType = new Type();
		}
		return attributeType;
	}

	/**
	 * Gives the qualifiers of the attribute.
	 * 
	 * @return
	 */
	public String getQualifiers() {
		String qualifiers = "";
		// qualifiers
		if (this.hasStereotype("register")) {
			qualifiers += "register ";
		}
		if (this.hasStereotype("const")) {
			qualifiers += "const ";
		}
		if (this.hasStereotype("volatile")) {
			qualifiers += "volatile ";
		}
		if (this.hasStereotype("restrict")) {
			qualifiers += "restrict ";
		}
		if (this.hasStereotype("auto")) {
			qualifiers += "auto ";
		}

		return qualifiers;
	}

	/**
	 * Tells if the attribute is static.
	 * 
	 * @return
	 */
	public boolean isStatic() {
		return uml2Property.isStatic();
	}

	/**
	 * Tells some code must be generated for this attribute.
	 * 
	 * @return
	 */
	public boolean hasCode() {
		return !hasStereotype("nocode") && !hasStereotype("dynamicDependency");
	}

	/**
	 * Tells if the current attribute has a default value.
	 * 
	 * @return
	 */
	public boolean hasDefaultValue() {
		return (uml2Property.getDefault() != null) && !uml2Property.getDefault().equals("");
	}

	/**
	 * Get the default value of the attribute as a string.
	 * 
	 * @return A string representing the default value of the atribute.
	 */
	public String getDefaultValue() {
		return uml2Property.getDefault();
	}

	/**
	 * Tells if the attribute is an instance of a class with the stereotype dynamicInstanciation.
	 * 
	 * @return
	 */
	public boolean isDynamicClass() {
		boolean dynamicClass = false;
		Type attributeType = getType();
		if (attributeType.isClass()) {
			dynamicClass = attributeType.getTypeClass().hasStereotype("dynamicInstanciation");
		}
		return dynamicClass;
	}

	/**
	 * Tells if the attribute is of type string.
	 * 
	 * @return
	 */
	public boolean isString() {
		boolean string = false;
		Type type = getType();
		if (type != null) {
			string = type.isTextType();
		}
		return string;
	}

	/**
	 * Tells if the attribute must be implemented with a GString.
	 * 
	 * @return
	 */
	public boolean isGstring() {
		boolean gstring = isString();
		Class parent = new Class((org.eclipse.uml2.uml.Class) uml2Property.getOwner());
		gstring = gstring && parent.useGlib();
		gstring = gstring && parent.isDynamic();
		return gstring;
	}

	/**
	 * Gives the owner class of the attribute.
	 * 
	 * @return The com.cea.papyrus.umlutils.Class that owns the attribute.
	 */
	public Class getOwner() {
		Class parent = new Class((org.eclipse.uml2.uml.Class) uml2Property.getOwner());
		return parent;
	}

	/**
	 * Gives the upper value of the attribute's multiplicity.
	 * 
	 * @return An integer representing the upper value of the multiplicity. -1 means infinite
	 */
	public int getUpperMultiplicity() {
		int multiplicity;
		multiplicity = uml2Property.getUpper();
		if (hasStereotype("limitMultiplicity")) {
			Object up = getTaggedValue("limitMultiplicity", "arraySize");
			if (up instanceof Integer) {
				multiplicity = ((Integer) up).intValue();
			}
		}
		return multiplicity;
	}

	/**
	 * Gives the upper value of the attribute's multiplicity.
	 * 
	 * @return An integer representing the upper value of the multiplicity. -1 means infinite
	 */
	public int getLowerMultiplicity() {
		int multiplicity;
		multiplicity = uml2Property.getLower();
		if (hasStereotype("limitMultiplicity")) {
			Object up = getTaggedValue("limitMultiplicity", "arraySize");
			if (up instanceof Integer) {
				multiplicity = ((Integer) up).intValue();
			}
		}
		return multiplicity;
	}

	/**
	 * Tells if this property with a multiplicity > 1 can contain more than once each element.
	 * 
	 * @return
	 */
	public boolean isUnique() {
		return uml2Property.isUnique();
	}

	/**
	 * Tells if this property with a multiplicity > 1 has to order the elements or not.
	 * 
	 * @return
	 */
	public boolean isOrdered() {
		return uml2Property.isOrdered();
	}

	/**
	 * Tells if the property has a multiplicity > 1.
	 * 
	 * @return
	 */
	public boolean isMultiple() {
		boolean multiple = getUpperMultiplicity() == -1;
		multiple = multiple || (getUpperMultiplicity() > 1);
		return multiple;
	}

	/**
	 * Tells if the property is a composition.
	 * 
	 * @return boolean
	 */
	public boolean isComposition() {
		boolean comp = false;
		if (isAssociation()) {
			if (uml2Property.getAggregation().equals(AggregationKind.COMPOSITE_LITERAL)) {
				comp = true;
			}
		}

		return comp;
	}

	/**
	 * Tells if the property is an aggregation.
	 * 
	 * @return boolean
	 */
	public boolean isAggregation() {
		boolean comp = false;
		if (isAssociation() && !isComposition()) {
			comp = true;
		}

		return comp;
	}

	/**
	 * Tells if the property is an association or a nested property.
	 * 
	 * @return boolean
	 */
	public boolean isAssociation() {
		boolean comp = false;
		if (getUml2Property().getAssociation() != null) {
			comp = true;
		}

		return comp;
	}

	/**
	 * Tells if the property has an infinite multiplicity.
	 * 
	 * @return
	 */
	public boolean hasInfiniteMultiplicity() {
		return getUpperMultiplicity() == -1;
	}

	/**
	 * Get all properties that can be subsetted by this Property checks the type and the multiplicity.
	 * 
	 * @return all properties that can be subsetted
	 */
	@SuppressWarnings("unchecked")
	public List<org.eclipse.papyrus.umlutils.Property> getSubsettablesProperties() {
		List<org.eclipse.papyrus.umlutils.Property> list = new ArrayList<Property>();

		// subsettable properties:
		Iterator<org.eclipse.uml2.uml.NamedElement> it = uml2Property.getClass_().getMembers().iterator();
		while (it.hasNext()) {
			org.eclipse.uml2.uml.NamedElement element = it.next();
			if (element instanceof org.eclipse.uml2.uml.Property) {
				boolean isValid = true;
				org.eclipse.uml2.uml.Property subsettableProperty = (org.eclipse.uml2.uml.Property) element;

				// check it is not itself....
				if (subsettableProperty.equals(uml2Property)) {
					isValid = false;
				}

				// check types conformity
				if (uml2Property.getType() != null && subsettableProperty.getType() != null) {
					if (!uml2Property.getType().conformsTo(subsettableProperty.getType())) {
						isValid = false;
					}
				} else {
					isValid = false;
				}

				// NB: only upper bound has an OCL rule
				/*
				 * if( uml2Property.getLower() < subsettableProperty.getLower()) { isValid = false; } else
				 */
				// check multiplicity
				if ((subsettableProperty.getUpper() != -1) && (uml2Property.getUpper() > subsettableProperty.getUpper())) {
					isValid = false;
				}

				if (isValid) {
					list.add(new org.eclipse.papyrus.umlutils.Property(subsettableProperty));
				}
			}

		}
		return list;
	}

	/**
	 * Get all properties that can be redefined by this Property.
	 * 
	 * @return all properties that can be redefined
	 */
	@SuppressWarnings("unchecked")
	public List<org.eclipse.papyrus.umlutils.Property> getRedefinableProperties() {
		List<org.eclipse.papyrus.umlutils.Property> list = new ArrayList<Property>();

		// subsettable properties:
		Iterator<org.eclipse.uml2.uml.NamedElement> it = uml2Property.getClass_().getMembers().iterator();
		while (it.hasNext()) {
			org.eclipse.uml2.uml.NamedElement element = it.next();
			if (element instanceof org.eclipse.uml2.uml.Property) {
				boolean isValid = true;
				org.eclipse.uml2.uml.Property redefinableProperty = (org.eclipse.uml2.uml.Property) element;
				// check it is not itself....
				if (redefinableProperty.equals(uml2Property)) {
					isValid = false;
				}

				if (isValid) {
					list.add(new org.eclipse.papyrus.umlutils.Property(redefinableProperty));
				}
			}

		}

		return list;
	}

	/**
	 * return a simplified label of the property, given UML2 specification.
	 * 
	 * @param withVisibility
	 * 
	 * @return a string simplified compared to the full label of the property
	 */
	public String getShortLabel(boolean withVisibility) {
		StringBuffer buffer = new StringBuffer();

		if (withVisibility) {
			// visibility
			buffer.append(" ");
			buffer.append(this.getVisibilityAsSign());
		}

		// derived property
		if (uml2Property.isDerived()) {
			buffer.append("/ ");
		}

		// name
		buffer.append(this.getName());

		// type
		if (uml2Property.getType() != null) {
			buffer.append(": " + uml2Property.getType().getName());
		} else {
			buffer.append(": " + UNDEFINED_TYPE_NAME);
		}

		// multiplicity
		String multiplicity = this.getMultiplicityAsString();
		if (!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}
		return buffer.toString();
	}

	/**
	 * return the full label of the property, given UML2 specification.
	 * 
	 * @return the string corresponding to the label of the property
	 */
	public String getLabel() {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		buffer.append(this.getVisibilityAsSign());

		// derived property
		if (uml2Property.isDerived()) {
			buffer.append("/");
		}

		// name
		buffer.append(" ");
		buffer.append(this.getName());

		// type
		if (uml2Property.getType() != null) {
			buffer.append(": " + uml2Property.getType().getName());
		} else {
			buffer.append(": " + UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = this.getMultiplicityAsString();
		if (!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}

		// default value
		if (uml2Property.getDefault() != null) {
			buffer.append(" = ");
			buffer.append(uml2Property.getDefault());
		}

		// property modifiers
		String modifiers = this.getModifiersAsString();
		if (!modifiers.equals("")) {
			buffer.append(" {");
			buffer.append(modifiers);
			buffer.append("}");
		}
		return buffer.toString();
	}

	/**
	 * return the custom label of the property, given UML2 specification and a custom style.
	 * 
	 * @param style
	 *            the integer representing the style of the label
	 * 
	 * @return the string corresponding to the label of the property
	 */
	public String getCustomLabel(int style) {
		StringBuffer buffer = new StringBuffer();
		// visibility

		buffer.append(" ");
		if ((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
			buffer.append(this.getVisibilityAsSign());
		}

		// derived property
		if ((style & ICustomAppearence.DISP_DERIVE) != 0) {
			if (uml2Property.isDerived()) {
				buffer.append("/");
			}
		}
		// name
		if ((style & ICustomAppearence.DISP_NAME) != 0) {
			buffer.append(" ");
			buffer.append(this.getName());
		}

		if ((style & ICustomAppearence.DISP_TYPE) != 0) {
			// type
			if (uml2Property.getType() != null) {
				buffer.append(": " + uml2Property.getType().getName());
			} else {
				buffer.append(": " + UNDEFINED_TYPE_NAME);
			}
		}

		if ((style & ICustomAppearence.DISP_MULTIPLICITY) != 0) {
			// multiplicity -> do not display [1]
			String multiplicity = this.getMultiplicityAsString();
			// if(!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
			// }
		}

		if ((style & ICustomAppearence.DISP_DFLT_VALUE) != 0) {
			// default value
			if (uml2Property.getDefault() != null) {
				buffer.append(" = ");
				buffer.append(uml2Property.getDefault());
			}
		}

		if ((style & ICustomAppearence.DISP_MOFIFIERS) != 0) {
			boolean multiLine = ((style & ICustomAppearence.DISP_MULTI_LINE) != 0);
			// property modifiers
			String modifiers = this.getModifiersAsString(multiLine);
			if (!modifiers.equals("")) {
				if (multiLine) {
					buffer.append("\n");
				}
				buffer.append(" {");
				buffer.append(modifiers);
				buffer.append("}");
			}
		}
		return buffer.toString();
	}

	/**
	 * Return the multiplicity of the element "[x..y]"
	 * 
	 * @return the string representing the multiplicity
	 */
	public String getMultiplicityAsString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" [");
		buffer.append(getMultiplicityAsStringWithoutSquareBrackets());
		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * Returns the String corresponding to the multiplicity without square brackets
	 * 
	 * @return the string representing the multiplicity, without square brackets
	 */
	public String getMultiplicityAsStringWithoutSquareBrackets() {
		StringBuffer buffer = new StringBuffer();
		// special case for [1] and [*]
		int lower = uml2Property.getLower();
		int upper = uml2Property.getUpper();

		if (lower == upper) {
			buffer.append(lower);
		} else if ((lower == 0) && (upper == -1)) {
			buffer.append("*");
		} else if (upper == -1) {
			buffer.append(lower);
			buffer.append("..*");
		} else {
			buffer.append(lower);
			buffer.append("..");
			buffer.append(upper);
		}
		return buffer.toString();
	}

	/**
	 * return the modifiers of the property, separated by a comma, as a single line string.
	 * 
	 * @return a string giving all modifiers for the property
	 */
	public String getModifiersAsString() {
		return getModifiersAsString(false);
	}

	/**
	 * Returns the modifier of the property, separated by a comma, as as single line if <code>multiline</code> is <code>false</code> or as a multiline string if <code>multiline</code> is
	 * <code>false</code>.
	 * 
	 * @param multiLine
	 *            boolean that indiacates if the string should have several lines when set to <code>true</code> or only one line when set to <code>false</code>.
	 * 
	 * @return a string giving all modifiers for the property
	 */
	public String getModifiersAsString(boolean multiLine) {
		StringBuffer buffer = new StringBuffer();
		boolean needsComma = false;
		String NL = (multiLine) ? "\n" : "";

		// Return property modifiers
		if (uml2Property.isReadOnly()) {
			buffer.append("readOnly");
			needsComma = true;
		}
		if (uml2Property.isDerivedUnion()) {
			if (needsComma) {
				buffer.append(",");
				buffer.append(NL);
			}
			buffer.append("union");
			needsComma = true;
		}
		if (uml2Property.isOrdered()) {
			if (needsComma) {
				buffer.append(",");
				buffer.append(NL);
			}
			buffer.append("ordered");
			needsComma = true;
		}
		if (uml2Property.isUnique()) {
			if (needsComma) {
				buffer.append(",");
				buffer.append(NL);
			}
			buffer.append("unique");
			needsComma = true;
		}

		// is the property redefining another property ?
		Iterator<org.eclipse.uml2.uml.Property> it = uml2Property.getRedefinedProperties().iterator();
		while (it.hasNext()) {
			org.eclipse.uml2.uml.Property property = it.next();
			if (needsComma) {
				buffer.append(",");
				buffer.append(NL);
			}
			buffer.append("redefines ");
			buffer.append(property.getName());
			needsComma = true;
		}

		// is the property subsetting another property ?
		Iterator<org.eclipse.uml2.uml.Property> it2 = uml2Property.getSubsettedProperties().iterator();
		while (it2.hasNext()) {
			org.eclipse.uml2.uml.Property property = it2.next();
			if (needsComma) {
				buffer.append(",");
				buffer.append(NL);
			}
			buffer.append("subsets ");
			buffer.append(property.getName());
			needsComma = true;
		}

		return buffer.toString();
	}

	/**
	 * Sets if the uml Property is static or not
	 * 
	 * @param b
	 *            <code>true</code> if this property is static.
	 */
	public void setIsStatic(boolean b) {
		getUml2Property().setIsStatic(b);
	}
}
