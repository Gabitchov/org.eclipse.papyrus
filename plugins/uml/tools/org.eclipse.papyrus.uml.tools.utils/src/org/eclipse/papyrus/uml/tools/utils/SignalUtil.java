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
 *  Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.util.Collection;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;

/**
 * Utility class for <code>org.eclipse.uml2.uml.Signal</code><BR>
 */
public class SignalUtil {

	/**
	 * return the custom label of the signal, given UML2 specification and a custom style.
	 *
	 * @param style
	 *        the integer representing the style of the label
	 *
	 * @return the string corresponding to the label of the signal
	 */
	public static String getCustomLabel(Signal signal, Collection<String> maskValues) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" "); // adds " " first for correct display considerations

		// visibility
		if(maskValues.contains(ICustomAppearance.DISP_VISIBILITY)) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(signal));
		}

		// name
		if(maskValues.contains(ICustomAppearance.DISP_NAME)) {
			buffer.append(" ");
			buffer.append(signal.getName());
		}

		//
		// parameters : '(' parameter-list ')'
		buffer.append("(");
		buffer.append(getPropertiesAsString(signal, maskValues));
		buffer.append(")");

		return buffer.toString();
	}

	/**
	 * Returns signal properties as a string, the label is customized using a bit mask
	 *
	 * @return a string containing all properties separated by commas
	 */
	private static String getPropertiesAsString(Signal signal, Collection<String> maskValues) {
		StringBuffer propertiesString = new StringBuffer();
		boolean firstProperty = true;
		for(Property property : signal.getOwnedAttributes()) {
			// get the label for this property
			String propertyString = PropertyUtil.getCustomLabel(property, maskValues);
			if(!propertyString.trim().equals("")) {
				if(!firstProperty) {
					propertiesString.append(", ");
				}
				propertiesString.append(propertyString);
				firstProperty = false;
			}
		}
		return propertiesString.toString();
	}
}
