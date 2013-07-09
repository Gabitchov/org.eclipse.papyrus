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

import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * Utility class for <code>org.eclipse.uml2.uml.MultiplicityElement</code><BR>
 */
public class MultiplicityElementUtil {

	/**
	 * Return the multiplicity of the element "[x..y]"
	 * 
	 * @return the string representing the multiplicity
	 */
	public static String getMultiplicityAsString(MultiplicityElement element) {
		StringBuffer buffer = new StringBuffer();
		String multiplicityStr = getMultiplicityAsStringWithoutSquareBrackets(element);
		if(multiplicityStr != null && !"".equals(multiplicityStr)) {
			buffer.append(" [");
			buffer.append(multiplicityStr);
			buffer.append("]");
		}
		return buffer.toString();
	}

	/**
	 * Returns the String corresponding to the multiplicity without square brackets
	 * 
	 * @return the string representing the multiplicity, without square brackets
	 */
	public static String getMultiplicityAsStringWithoutSquareBrackets(MultiplicityElement element) {
		StringBuffer buffer = new StringBuffer();
		// special case for [1] and [*]
		int lower = element.getLower();
		int upper = element.getUpper();

		if(lower == upper) {
			buffer.append(lower);
		} else if((lower == 0) && (upper == -1)) {
			buffer.append("*");
		} else if(upper == -1) {
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
	 * Parses the given String and returns the value of the multiplicity.
	 * <P>
	 * a lower bound with value infinite (<code>*</code>) will be set at <code>-1</code>.
	 * </P>
	 * 
	 * @param value
	 *        the string representing the multiplicity. it can be <code>1</code>, <code>1..2</code> or <code>1..*</code>
	 * @return a 2-size integer table, with the first element corresponding to the lower bound, the second corresponds to the upper bound
	 */
	public static int[] parseMultiplicity(String value) throws NumberFormatException {
		int lower = 0;
		int upper = 0;
		int firstIndex = value.indexOf("..");

		// ".." was not found => this should be an integer, for example a multiplicity ~ [1]
		if(firstIndex == -1) {
			// this should be directly an integer or a star
			if("*".equals(value)) {
				lower = 0;
				upper = -1;
			} else {
				lower = Integer.parseInt(value);
				upper = lower;
			}
		} else {
			String lowerValue = value.substring(0, firstIndex);
			String upperValue = value.substring(firstIndex + "..".length());

			lower = Integer.parseInt(lowerValue);
			upper = -2;
			if("*".equals(upperValue)) {
				upper = -1;
			} else {
				upper = Integer.parseInt(upperValue);
			}
		}
		return new int[]{ lower, upper };
	}

}
