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

import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Utility class for {@link ValueSpecification}
 */
public class ValueSpecificationUtil {

	/** The * KeyWord to represent an unlimited integer (infinite)*/
	private static final String UNLIMITED_KEYWORD = "*";

	/**
	 * Get a string representing of a ValueSpecification
	 * 
	 * @param specification
	 */
	// @unused
	public static String getSpecificationValue(ValueSpecification specification) {
		String value = ""; //$NON-NLS-1$

		switch(specification.eClass().getClassifierID()) {
		case UMLPackage.LITERAL_STRING:
			value = ((LiteralString)specification).getValue();
			break;
		case UMLPackage.LITERAL_BOOLEAN:
			value = Boolean.toString(((LiteralBoolean)specification).booleanValue());
			break;
		case UMLPackage.LITERAL_INTEGER:
			value = Integer.toString(((LiteralInteger)specification).getValue());
			break;
		case UMLPackage.LITERAL_UNLIMITED_NATURAL:
			value = Integer.toString(((LiteralUnlimitedNatural)specification).getValue());
			if("-1".equals(value)) { //$NON-NLS-1$
				value = UNLIMITED_KEYWORD; //$NON-NLS-1$
			}
			break;
		case UMLPackage.LITERAL_NULL:
			break;
		case UMLPackage.OPAQUE_EXPRESSION:
			value = OpaqueExpressionUtil.getBodyForLanguage((OpaqueExpression)specification, "UML"); //$NON-NLS-1$
			break;
		case UMLPackage.INSTANCE_VALUE:
			value = ((InstanceValue)specification).getInstance().getName();
			break;
		case UMLPackage.EXPRESSION:
			// TODO
			break;
		case UMLPackage.TIME_EXPRESSION:
			// TODO
			break;
		default:
		{
			break;
		}
		}
		return value;
	}

	/**
	 * Sets the value of a specification, using a string value
	 * 
	 * @param specification
	 *        the value specification to update
	 * @param value
	 *        the value to set
	 */
	// @unused
	public static void restoreSpecificationValue(ValueSpecification specification, String value) {
		if(value == null) {
			return;
		}

		switch(specification.eClass().getClassifierID()) {
		case UMLPackage.LITERAL_STRING:
			restoreLiteralString((LiteralString)specification, value);
			break;
		case UMLPackage.LITERAL_BOOLEAN:
			restoreLiteralBoolean((LiteralBoolean)specification, value);
			break;
		case UMLPackage.LITERAL_INTEGER:
			restoreLiteralInteger((LiteralInteger)specification, value);
			break;
		case UMLPackage.LITERAL_UNLIMITED_NATURAL:
			restoreLiteralUnlimitedNatural((LiteralUnlimitedNatural)specification, value);
			break;
		case UMLPackage.LITERAL_NULL:
			restoreLiteralNull((LiteralNull)specification, value);
			break;
		case UMLPackage.OPAQUE_EXPRESSION:
			restoreOpaqueExpression((org.eclipse.uml2.uml.OpaqueExpression)specification, value);
			break;
		default:
		{
			break;
		}
		}
	}

	/**
	 * Sets the value of a literal string, using a string value
	 * 
	 * @param specification
	 *        the literal string to update
	 * @param value
	 *        the new value
	 */
	public static void restoreLiteralString(LiteralString specification, String value) {
		specification.setValue(value);
	}

	/**
	 * Sets the value of a literal, using a string value
	 * 
	 * @param specification
	 *        the literal integer to update
	 * @param value
	 *        the new value
	 */
	public static void restoreLiteralInteger(LiteralInteger specification, String value) {
		int intValue = 0;
		try {
			intValue = Integer.decode(value);
		} catch (NumberFormatException e) {
			// Do nothing, this was not a number. 0 will be the default value
		}
		specification.setValue(intValue);
	}

	/**
	 * Sets the value of a literal boolean, using a string value
	 * 
	 * @param specification
	 *        the literal boolean to update
	 * @param value
	 *        the new value
	 */
	public static void restoreLiteralBoolean(LiteralBoolean specification, String value) {
		if("true".equals(value) || "1".equals(value)) {
			specification.setValue(true);
		} else {
			specification.setValue(false);
		}
	}

	/**
	 * Sets the value of a literal unlimited natural, using a string value
	 * 
	 * @param specification
	 *        the literal unlimited natural to update
	 * @param value
	 *        the new value
	 */
	public static void restoreLiteralUnlimitedNatural(LiteralUnlimitedNatural specification, String value) {
		int intValue = 0;
		try {
			intValue = Integer.decode(value);
		} catch (NumberFormatException e) {
			// Do nothing, this was not a number. 0 will be the default value
		}
		// Handle the special unlimited value separately
		if(UNLIMITED_KEYWORD.equals(value)) {
			intValue = -1;
		}
		specification.setValue(intValue);
	}

	/**
	 * Sets the value of a literal null, using a string value
	 * 
	 * @param specification
	 *        the literal null to update
	 * @param value
	 *        the new value
	 */
	public static void restoreLiteralNull(LiteralNull specification, String value) {
		// nothing to set
	}

	/**
	 * Sets the value of an opaque expression, using a string value
	 * 
	 * @param specification
	 *        the opaque expression to update
	 * @param value
	 *        the new value
	 */
	public static void restoreOpaqueExpression(org.eclipse.uml2.uml.OpaqueExpression specification, String value) {
		// save in "UML" language, but should be desactivable
		OpaqueExpressionUtil.setBodyForLanguage(specification, "UML", value);

	}

}
