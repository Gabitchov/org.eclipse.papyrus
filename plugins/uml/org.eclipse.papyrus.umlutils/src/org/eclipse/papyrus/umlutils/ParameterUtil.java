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
package org.eclipse.papyrus.umlutils;

import org.eclipse.uml2.uml.Parameter;

/**
 * Utility class for <code>org.eclipse.uml2.uml.Parameter</code><BR>
 */
public class ParameterUtil {

	private static String getPropertiesAsString(Parameter parameter) {
		StringBuffer buffer = new StringBuffer();

		// default : unique and not ordered
		if (parameter.isUnique()) {
			if (parameter.isOrdered()) {
				buffer.append("ordered");
			} else {
				buffer.append("");
			}
		} else {
			if (parameter.isOrdered()) {
				buffer.append("ordered, nonunique");
			} else {
				buffer.append("nonunique");
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns the label for this parameter, customized by the given style
	 * 
	 * @param style
	 *            the style of the label
	 * @return the customized label for this parameter
	 * @see ICustomAppearence
	 */
	public static String getCustomLabel(Parameter parameter, int style) {
		final StringBuffer label = new StringBuffer();

		// direction
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_DIRECTION)) {
			label.append(parameter.getDirection().getLiteral());
			label.append(" ");
		}

		// name
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_NAME)) {
			label.append(parameter.getName());
		}

		// type
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_TYPE)) {
			label.append(TypedElementUtil.getTypeAsString(parameter));
		}

		// multiplicity
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_MULTIPLICITY)) {
			label.append(MultiplicityElementUtil.getMultiplicityAsString(parameter));
		}

		// default
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_DEFAULT)) {
			label.append(ParameterUtil.getDefaultAsString(parameter, true));
		}

		// modifier
		if (hasStyle(style, ICustomAppearence.DISP_PARAMETER_MODIFIERS)) {
			label.append(ParameterUtil.getPropertiesAsString(parameter));
		}

		return label.toString();
	}

	/**
	 * Returns the default value as a String
	 * 
	 * @param equalSign
	 *            boolean set to <code>true</code> if the label must have the
	 *            <code>=</code> sign before the default value
	 * @return the default value as a String
	 */
	private static String getDefaultAsString(Parameter parameter, boolean equalSign) {
		String defaultString = "";
		// default value
		if ((parameter.getDefault() != null) && !parameter.getDefault().equals("")) {
			if (equalSign) {
				defaultString += "= ";
			}
			defaultString += parameter.getDefault();
		}
		return "";
	}

	/**
	 * Returns <code>true</code> if the given style has the given mask
	 * 
	 * @param style
	 *            the style to check
	 * @param mask
	 *            the mask to check
	 * @return <code>true</code> if the style has the bit mask
	 */
	static boolean hasStyle(int style, int mask) {
		return ((style & mask) != 0);
	}
}
