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

import org.eclipse.papyrus.infra.gmfdiag.common.messages.Messages;

/**
 * 
 * This class provides useful constants for Units
 * 
 */
public class UnitsConstants {

	private UnitsConstants() {
		//to prevent instanciation
	}

	/**
	 * 1 inch is equivalent to 2.54 centimeters
	 */
	public static final double INCH2CM = 2.54;

	/**
	 * the string Inches
	 */
	public static final String INCHES = Messages.UnitsUtils_Inches;

	/**
	 * the string millimeters
	 */
	public static final String CENTIMETERS = Messages.UnitsUtils_Centimeters;

	/**
	 * the string pixels
	 */
	public static final String PIXELS = Messages.UnitsUtils_Pixels;
}
