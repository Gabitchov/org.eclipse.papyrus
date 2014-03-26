/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 392301
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.converters;

import org.eclipse.e4.ui.css.core.css2.CSS2ColorHelper;
import org.eclipse.e4.ui.css.core.dom.properties.converters.AbstractCSSValueConverter;
import org.eclipse.e4.ui.css.core.dom.properties.converters.ICSSValueConverterConfig;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.impl.dom.Measure;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.RGBColor;

/**
 * A Converter for GMF Colors
 * Converts a CSS Color to a GMF-compatible color (RGB Integer)
 * 
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public class ColorToGMFConverter extends AbstractCSSValueConverter {

	/**
	 * The GMF Color type
	 */
	public static final String GMFColor = "GMFColor"; //$NON-NLS-1$

	/**
	 * Constructor
	 */
	public ColorToGMFConverter() {
		super(GMFColor);
	}

	public Object convert(CSSValue value, CSSEngine engine, Object context) throws Exception {
		RGBColor color;
		if(value instanceof RGBColor) {
			color = (RGBColor)value;
		} else if(value instanceof CSSPrimitiveValue) {
			CSSPrimitiveValue cssValue = (CSSPrimitiveValue)value;
			color = CSS2ColorHelper.getRGBColor(cssValue.getStringValue());
		} else {
			throw new IllegalArgumentException("Cannot convert " + value + " to GMF Color");
		}

		return getIntColor(color);
	}

	public String convert(Object value, CSSEngine engine, Object context, ICSSValueConverterConfig config) throws Exception {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a GMF-compatible integer color from a CSS RGBColor object
	 * 
	 * @param color
	 *        The CSS RGBColor to convert
	 * @return
	 *         A GMF-compatible integer color
	 */
	public static int getIntColor(RGBColor color) {
		int red = getInt(color.getRed()) & 0xFF;
		int green = getInt(color.getGreen()) & 0xFF;
		int blue = getInt(color.getBlue()) & 0xFF;

		return (blue << 16) | (green << 8) | red;
	}

	/**
	 * Returns an integer from a CSSPrimitiveValue
	 * 
	 * @param value
	 *        The CSSPrimitiveValue to convert
	 * @return
	 *         A Java integer equivalent to the CSSPrimitiveValue
	 */
	public static int getInt(CSSPrimitiveValue value) {
		if(value instanceof Measure) {
			Measure measure = (Measure)value;
			return measure.getIntegerValue(CSSValue.CSS_PRIMITIVE_VALUE);
		}
		return (int)value.getFloatValue(CSSValue.CSS_PRIMITIVE_VALUE);
	}

	//Unused
	public static int getIntColor(String value, CSSValue cssValue) {
		RGBColor color;
		if(cssValue instanceof RGBColor) {
			//color:rgb(125, 255, 0);
			color = (RGBColor)cssValue;
		} else {
			//color:red; || color:#FFFFFF;
			color = CSS2ColorHelper.getRGBColor(value);
		}

		if(color == null) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				return -1;
			}
		}

		return getIntColor(color);
	}
}
