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
	public static String getCustomLabel(Property property, int style) {
		StringBuffer buffer = new StringBuffer();
		// visibility

		buffer.append(" ");
		if((style & ICustomAppearence.DISP_VISIBILITY) != 0) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(property));
		}

		// derived property
		if((style & ICustomAppearence.DISP_DERIVE) != 0) {
			if(property.isDerived()) {
				buffer.append("/");
			}
		}
		// name
		if((style & ICustomAppearence.DISP_NAME) != 0) {
			buffer.append(" ");
			buffer.append(property.getName());
		}

		if((style & ICustomAppearence.DISP_TYPE) != 0) {
			if( (style &ICustomAppearence.DISP_CONJUGATED)!=0){
				if( ((Port)property).isConjugated()){
					buffer.append(": ~");
				}
				else{
					buffer.append(": ");
				}
			}
			else{
				buffer.append(": ");
			}
			// type
			if(property.getType() != null) {
				buffer.append( property.getType().getName());
			} else {
				buffer.append( TypeUtil.UNDEFINED_TYPE_NAME);
			}
		}

		if((style & ICustomAppearence.DISP_MULTIPLICITY) != 0) {
			// multiplicity -> do not display [1]
			String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
			buffer.append(multiplicity);
		}

		if((style & ICustomAppearence.DISP_DFLT_VALUE) != 0) {
			// default value
			if(property.getDefault() != null) {
				buffer.append(" = ");
				buffer.append(property.getDefault());
			}
		}

		if((style & ICustomAppearence.DISP_MOFIFIERS) != 0) {
			boolean multiLine = ((style & ICustomAppearence.DISP_MULTI_LINE) != 0);
			// property modifiers
			String modifiers = PropertyUtil.getModifiersAsString(property, multiLine);
			if(!modifiers.equals("")) {
				if(multiLine) {
					buffer.append("\n");
				}

				if (!buffer.toString().endsWith(" ")){					
					buffer.append(" ");
				}

				buffer.append(modifiers);
			}
		}
		return buffer.toString();
	}
}
