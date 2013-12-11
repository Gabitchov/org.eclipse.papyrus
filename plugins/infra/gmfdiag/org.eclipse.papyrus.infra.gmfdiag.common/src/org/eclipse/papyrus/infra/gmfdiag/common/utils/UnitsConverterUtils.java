/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import java.text.ParseException;

import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.swt.widgets.Display;

import com.ibm.icu.text.NumberFormat;

/**
 * 
 * This class allows to convert easily units (Centimeters, Pixels and Inches)
 * 
 */
public class UnitsConverterUtils {

	private UnitsConverterUtils() {
		//to avoid instanciation
	}

	/**
	 * 
	 * @param fromUnits
	 *        the initial unity
	 * @param toUnits
	 *        the new unity
	 * @param valueStr
	 *        the value to convert
	 * @return
	 *         the new String
	 */
	public static final String convertUnits(final int fromUnits, final int toUnits, final String valueStr) {
		//		String valueStr = gridSpacing.getStringValue();
		if(fromUnits == toUnits) {
			return valueStr;
		}

		//Double value = Double.valueOf( valueStr );
		NumberFormat numberFormatter = NumberFormat.getInstance();
		Double value = new Double(0.125);
		try {
			value = forceDouble(numberFormatter.parse(valueStr));
		} catch (ParseException e) {
			// Use the default
		}
		double pixelValue = 0;

		Display display = Display.getDefault();

		switch(fromUnits) {
		case RulerProvider.UNIT_INCHES:
			pixelValue = value.doubleValue() * display.getDPI().x;
			break;
		case RulerProvider.UNIT_CENTIMETERS:
			pixelValue = value.doubleValue() * display.getDPI().x / UnitsConstants.INCH2CM;
			break;
		case RulerProvider.UNIT_PIXELS:
			pixelValue = value.intValue();
			break;
		default:
			break;
		}

		double returnValue = 0;
		switch(toUnits) {
		case RulerProvider.UNIT_INCHES:
			returnValue = pixelValue / display.getDPI().x;
			break;
		case RulerProvider.UNIT_CENTIMETERS:
			returnValue = pixelValue * UnitsConstants.INCH2CM / display.getDPI().x;
			break;
		case RulerProvider.UNIT_PIXELS:
			returnValue = pixelValue;
			break;
		default:
			break;
		}

		return numberFormatter.format(returnValue);
	}

	/**
	 * 
	 * @param number
	 *        a number
	 * @return
	 *         a double
	 */
	private static final Double forceDouble(final Number number) {
		if(!(number instanceof Double)) {
			return new Double(number.doubleValue());
		}
		return (Double)number;
	}
}
