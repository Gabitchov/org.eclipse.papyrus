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

import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Utility class for {@link org.eclipse.uml2.uml.Constraint} element
 */
public class Constraint extends Element {

	public static String getCustomLabel(org.eclipse.uml2.uml.Constraint constraint, int style) {
		StringBuffer buffer = new StringBuffer();
		// check constraint is not null
		if (!isValidConstraint(constraint)) {
			return "{}";
		}

		buffer.append("{"); // adds at the beginning a " " to display correctly the label

		// display Name ?!
		if ((style & ICustomAppearence.DISP_NAME) != 0) {
			final String name = constraint.getName();
			if (name != null) {
				buffer.append(name);
				buffer.append(": ");
			}
		}

		if ((style & ICustomAppearence.DISP_BODY) != 0) {
			ValueSpecification specification = constraint.getSpecification();
			if (specification != null) {
				buffer.append(specification.stringValue());
			}
		}
		buffer.append("}");
		return buffer.toString();
	}

	public static boolean isValidConstraint(org.eclipse.uml2.uml.Constraint constraint) {
		return (constraint != null);
	}
}
