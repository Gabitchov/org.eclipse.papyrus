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

import java.util.Collection;

import org.eclipse.uml2.uml.CollaborationUse;

/**
 * Utility class for <code>org.eclipse.uml2.uml.CollaborationUse</code><BR>
 */
public class CollaborationUseUtil {

	public final static String UNDEFINED_TYPE_NAME = "<Undefined>";

	/**
	 * return the full label of the CollaborationUse, given UML2 specification.
	 *
	 * @return the string corresponding to the label of the CollaborationUse
	 */
	public static String getLabel(CollaborationUse collaborationUse) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		buffer.append(NamedElementUtil.getVisibilityAsSign(collaborationUse));

		// name
		buffer.append(" ");
		buffer.append(collaborationUse.getName());

		// type
		if(collaborationUse.getType() != null) {
			buffer.append(": " + collaborationUse.getType().getName());
		} else {
			buffer.append(": " + UNDEFINED_TYPE_NAME);
		}

		return buffer.toString();
	}

	/**
	 * return the custom label of the CollaborationUse, given UML2 specification and a custom style.
	 *
	 * @param style
	 *        the integer representing the style of the label
	 *
	 * @return the string corresponding to the label of the CollaborationUse
	 */
	public static String getCustomLabel(CollaborationUse collaborationUse, Collection<String> maskValues) {
		StringBuffer buffer = new StringBuffer();
		// visibility

		buffer.append(" ");
		if(maskValues.contains(ICustomAppearance.DISP_VISIBILITY)) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(collaborationUse));
		}

		// name
		if(maskValues.contains(ICustomAppearance.DISP_NAME)) {
			buffer.append(" ");
			buffer.append(collaborationUse.getName());
		}

		if(maskValues.contains(ICustomAppearance.DISP_TYPE)) {
			// type
			if(collaborationUse.getType() != null) {
				buffer.append(": " + collaborationUse.getType().getName());
			} else {
				buffer.append(": " + UNDEFINED_TYPE_NAME);
			}
		}

		return buffer.toString();
	}
}
