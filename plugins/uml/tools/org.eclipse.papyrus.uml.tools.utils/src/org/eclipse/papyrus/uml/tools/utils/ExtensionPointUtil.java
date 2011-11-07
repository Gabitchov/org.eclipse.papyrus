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

package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.uml2.uml.ExtensionPoint;

/**
 * Utility class for {@link ExtensionPoint}
 */
// @unused
public class ExtensionPointUtil {

	/**
	 * Returns the explanation for the extension point element
	 * 
	 * @return the string defining explanation for the extension point element
	 */
	// @unused
	public static String getExplanation(ExtensionPoint extensionPoint) {
		String explanation = "";
		final String name = ((extensionPoint.getName() != null) ? extensionPoint.getName() : "");
		int startIndexOfExplanation = name.lastIndexOf(":");
		if((startIndexOfExplanation > 0) && (startIndexOfExplanation != name.length())) {
			explanation = name.substring(startIndexOfExplanation + 1).trim();
		}
		return explanation;
	}
}
