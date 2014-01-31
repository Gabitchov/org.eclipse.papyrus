/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.util.Collection;

import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;


public class PortUtil extends PropertyUtil {

	/**
	 * return the custom label of the property, given UML2 specification and a custom style.
	 * 
	 * @param style
	 *        the integer representing the style of the label
	 * 
	 * @return the string corresponding to the label of the property
	 */
	public static String getCustomLabel(Property property, Collection<String> maskValues) {
		StringBuffer buffer = new StringBuffer();
		// visibility

		buffer.append(" ");
		if(maskValues.contains(ICustomAppearence.DISP_VISIBILITY)) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(property));
		}

		// derived property
		if(maskValues.contains(ICustomAppearence.DISP_DERIVE)) {
			if(property.isDerived()) {
				buffer.append("/");
			}
		}
		// name
		if(maskValues.contains(ICustomAppearence.DISP_NAME)) {
			buffer.append(" ");
			buffer.append(property.getName());
		}

		if(maskValues.contains(ICustomAppearence.DISP_TYPE)) {
			if(maskValues.contains(ICustomAppearence.DISP_CONJUGATED)) {
				if(((Port)property).isConjugated()) {
					buffer.append(": ~");
				} else {
					buffer.append(": ");
				}
			} else {
				buffer.append(": ");
			}
			// type
			if(property.getType() != null) {
				buffer.append(property.getType().getName());
			} else {
				buffer.append(TypeUtil.UNDEFINED_TYPE_NAME);
			}
		}

		if(maskValues.contains(ICustomAppearence.DISP_MULTIPLICITY)) {
			// multiplicity -> do not display [1]
			String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
			buffer.append(multiplicity);
		}

		if(maskValues.contains(ICustomAppearence.DISP_DEFAULT_VALUE)) {
			// default value
			if(property.getDefault() != null) {
				buffer.append(" = ");
				buffer.append(property.getDefault());
			}
		}

		if(maskValues.contains(ICustomAppearence.DISP_MODIFIERS)) {
			boolean multiLine = maskValues.contains(ICustomAppearence.DISP_MULTI_LINE);
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
}
