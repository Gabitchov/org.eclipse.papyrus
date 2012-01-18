/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.helper;

import org.eclipse.e4.ui.css.core.impl.dom.Measure;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.RGBColor;


public class ConversionHelper {

	public static int getIntColor(RGBColor color) {
		int red = getInt(color.getRed());
		int green = getInt(color.getGreen());
		int blue = getInt(color.getBlue());

		return blue * 256 * 256 + green * 256 + red;
	}

	public static int getInt(CSSPrimitiveValue value) {
		if(value instanceof Measure) {
			Measure measure = (Measure)value;
			return measure.getIntegerValue(CSSValue.CSS_PRIMITIVE_VALUE);
		}
		return (int)value.getFloatValue(CSSValue.CSS_PRIMITIVE_VALUE);
	}

}
