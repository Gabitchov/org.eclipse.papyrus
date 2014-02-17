/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

/**
 * Utility class for <code>org.eclipse.uml2.uml.Property</code><BR>
 */
public class PropertyUtil {

	/**
	 * Get all properties that can be subset by this {@link Property} checks the type and the
	 * multiplicity.
	 *
	 * @param property
	 *        property for which the list of subsettable properties are made
	 * @param noCheck
	 *        set this parameter to <code>true</code> if multiplicity and type check should be
	 *        made for the computation
	 * @return all properties that can be subset
	 */
	public static List<Property> getSubsettablesProperties(Property property, boolean noCheck) {
		List<Property> list = new ArrayList<Property>();

		// subset properties:
		Iterator<NamedElement> it = property.getClass_().getMembers().iterator();
		while(it.hasNext()) {

			NamedElement element = it.next();
			if(element instanceof Property) {
				boolean isValid = true;
				Property subsettableProperty = (Property)element;

				// check it is not itself....
				if(subsettableProperty.equals(property)) {
					isValid = false;
				}

				// check types conformity
				if(!noCheck) {
					if(property.getType() != null && subsettableProperty.getType() != null) {
						if(!property.getType().conformsTo(subsettableProperty.getType())) {
							isValid = false;
						}
					} else {
						isValid = false;
					}

					// check multiplicity (only upper bound has an OCL rule)
					if((subsettableProperty.getUpper() != -1) && (property.getUpper() > subsettableProperty.getUpper())) {
						isValid = false;
					}
				}

				if(isValid) {
					list.add(subsettableProperty);
				}
			}
		}
		return list;
	}

	/**
	 * Find a subsetted property given its name and a context to find it.
	 *
	 * @param name
	 *        the name of the property
	 * @return the property found or <code>null</code> if the element was not found.
	 */
	// @unused
	public static Property findSusbsettedPropertyByName(String propertyName, Property property, boolean noCheck) {
		Iterator<Property> it = PropertyUtil.getSubsettablesProperties(property, true).iterator();
		while(it.hasNext()) {
			Property tmpProperty = it.next();
			String tmpPropertyName = tmpProperty.getName();
			if(tmpPropertyName != null && propertyName.equals(tmpPropertyName.trim())) {
				return tmpProperty;
			}
		}
		return null;
	}

	/**
	 * Get all properties that can be redefined by this {@link Property}.
	 *
	 * @return all properties that can be redefined
	 */
	public static List<Property> getRedefinableProperties(Property property) {
		List<Property> list = new ArrayList<Property>();

		// redefine-able properties:
		Iterator<NamedElement> it = property.getClass_().getInheritedMembers().iterator();
		while(it.hasNext()) {
			NamedElement element = it.next();
			if(element instanceof Property) {
				list.add((Property)element);
			}
		}

		// adds also already redefined members. In fact, when properties are
		// redefined, they
		// disappear from the inherited members list
		Iterator<Property> it2 = property.getRedefinedProperties().iterator();
		while(it2.hasNext()) {
			Property element = it2.next();
			list.add(element);
		}
		return list;
	}

	/**
	 * Find a redefined property given its name and a context to find it.
	 *
	 * @param name
	 *        the name of the property
	 * @return the property found or <code>null</code> if the element was not found.
	 */
	public static Property findRedefinedPropertyByName(String propertyName, Property property) {
		Iterator<Property> it = PropertyUtil.getRedefinableProperties(property).iterator();
		while(it.hasNext()) {
			Property tmpProperty = it.next();
			String tmpPropertyName = tmpProperty.getName();
			if(tmpPropertyName != null && propertyName.equals(tmpPropertyName.trim())) {
				return tmpProperty;
			}
		}
		return null;
	}

	/**
	 * Get the displayed string for the derived attribute of the property.
	 *
	 * @param property
	 *        the property
	 * @return If the property is derived, return "/". Otherwise return an empty String
	 */
	public static String getDerived(Property property) {
		return property.isDerived() ? "/" : "";
	}

	/**
	 * return the full label of the property, given UML2 specification.
	 *
	 * @return the string corresponding to the label of the property
	 */
	public static String getLabel(Property property) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		buffer.append(NamedElementUtil.getVisibilityAsSign(property));

		// derived property
		buffer.append(getDerived(property));

		// name
		buffer.append(" ");
		buffer.append(getName(property));

		// type
		if(property.getType() != null) {
			buffer.append(" : " + property.getType().getName());
		} else {
			buffer.append(" : " + TypeUtil.UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
		if(!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}

		// default value
		if(property.getDefault() != null) {
			buffer.append(" = ");
			buffer.append(property.getDefault());
		}

		// property modifiers
		buffer.append(PropertyUtil.getModifiersAsString(property, false));

		return buffer.toString();
	}

	public static String getName(Property property) {
		if(property.getName() != null) {
			return property.getName();
		} else {
			return (NamedElementUtil.getDefaultNameWithIncrement(property));
		}
	}

	/**
	 * return the custom label of the property, given UML2 specification and a custom style.
	 *
	 * @param style
	 *        the collection of label fragments to display
	 *
	 * @return the string corresponding to the label of the property
	 */
	public static String getCustomLabel(Property property, Collection<String> style) {
		StringBuffer buffer = new StringBuffer();
		// visibility

		buffer.append(" ");
		if(style.contains(ICustomAppearance.DISP_VISIBILITY)) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(property));
		}

		// derived property
		if(style.contains(ICustomAppearance.DISP_DERIVE)) {
			if(property.isDerived()) {
				buffer.append("/");
			}
		}
		// name
		if(style.contains(ICustomAppearance.DISP_NAME)) {
			buffer.append(" ");
			buffer.append(property.getName());
		}

		if(style.contains(ICustomAppearance.DISP_TYPE)) {
			// type
			if(property.getType() != null) {
				buffer.append(": " + property.getType().getName());
			} else {
				buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
			}
		}

		if(style.contains(ICustomAppearance.DISP_MULTIPLICITY)) {
			// multiplicity -> do not display [1]
			String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
			buffer.append(multiplicity);
		}

		if(style.contains(ICustomAppearance.DISP_DEFAULT_VALUE)) {
			// default value
			if(property.getDefault() != null) {
				buffer.append(" = ");
				buffer.append(property.getDefault());
			}
		}

		if(style.contains(ICustomAppearance.DISP_MODIFIERS)) {
			boolean multiLine = style.contains(ICustomAppearance.DISP_MULTI_LINE);
			// property modifiers
			String modifiers = PropertyUtil.getModifiersAsString(property, multiLine);
			if(!modifiers.equals("")) {
				if(multiLine) {
					buffer.append("\n");
				}

				if(!buffer.toString().endsWith(" ")) {
					buffer.append(" ");
				}

				buffer.append(modifiers);
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns the modifier of the property, separated by a comma, as as single line if <code>multiline</code> is <code>false</code> or as a multiline
	 * string if <code>multiline</code> is <code>false</code>.
	 *
	 * @param multiLine
	 *        boolean that indicates if the string should have several lines when set to <code>true</code> or only one line when set to
	 *        <code>false</code>.
	 *
	 * @return a string giving all modifiers for the property
	 */
	public static String getModifiersAsString(Property property, boolean multiLine) {
		StringBuffer buffer = new StringBuffer();
		boolean needsComma = false;
		String NL = (multiLine) ? "\n" : " ";

		// Return property modifiers
		if(property.isReadOnly()) {
			buffer.append("readOnly");
			needsComma = true;
		}
		if(property.isDerivedUnion()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "union");
		}
		if(property.isOrdered()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "ordered");;
		}
		if(property.isUnique()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "unique");
		}

		// is the property redefining another property ?
		for(Property current : property.getRedefinedProperties()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "redefines ");
			buffer.append(current.getName());
		}

		// is the property subsetting another property ?
		for(Property current : property.getSubsettedProperties()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "subsets ");
			buffer.append(current.getName());
		}

		if(!buffer.toString().equals("")) {
			buffer.insert(0, "{");
			buffer.append("}");
		}

		return buffer.toString();
	}

	/**
	 * Update the modifiers string
	 *
	 * @param buffer
	 *        the existing bufferString to append
	 * @param needsComma
	 *        if it needs coma
	 * @param NL
	 *        if it is multiline
	 * @param message
	 *        the message top
	 * @return true because the modifier string is no more empty
	 */
	private static boolean updateModifiersString(StringBuffer buffer, boolean needsComma, String NL, String message) {
		if(needsComma) {
			buffer.append(",");
			buffer.append(NL);
		}
		buffer.append(message);
		return true;
	}
}
