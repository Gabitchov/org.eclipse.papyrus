/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * 
 * 
 * @author Patrick Tessier
 * @since 20 sept. 06
 * 
 *        this aclass manage all colors of Papyrus. It is forbidden in this
 *        application to create a color. SymbolicName is "R"_"G"_"B" where "R"
 *        "G" "B" are string that represent color (int)
 */
public class ColorManager extends ColorRegistry {

	/**
	 * 
	 */
	private static String separator = "_";

	/**
	 * get Color from a RGB.
	 * 
	 * @param rgb
	 *        the rGB thath wen want
	 * 
	 * @return the color obtaine from the RGB
	 */

	// @unused
	public Color get(RGB rgb) {
		String symbolicName = "" + rgb.red + separator + rgb.green + separator + rgb.blue;
		Color resultColor = super.get(symbolicName);
		if(resultColor == null) {
			super.put(symbolicName, rgb);
			resultColor = super.get(symbolicName);
		}
		return resultColor;
	}

}
