/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.util;

/**
 *
 * This class allows to converter an int into a String like a spreadsheet numerotation and vice-versa. Fox example :
 * <ul>
 * <li>1 <-> A</li>
 * <li>26 <-> Z</li>
 * <li>27 <-> AA</li>
 * <li>28<-> AB</li>
 * </ul>
 *
 *
 *
 *
 */
//adapted code from http://www.developpez.net/forums/d1197058/dotnet/general-dotnet/contribuez/extensions-types-int-string-conversion-format-colonne-excel/
public class IntegerAndSpreadsheetNumberConverter {

	/**
	 *
	 * Constructor.
	 *
	 */
	private IntegerAndSpreadsheetNumberConverter() {
		//to prevent instanciation
	}

	/**
	 *
	 * @param number
	 *        an integer
	 * @return
	 *         the string representing this integer in a spreedsheet
	 */
	public static String toString(int number) {
		if(number <= 0) {
			throw new NumberFormatException();
		}
		int tmp = number;
		String string = ""; //$NON-NLS-1$
		while(tmp > 0) {
			final int r = (tmp - 1) % 26;
			string = (char)('A' + r) + string;
			tmp = (tmp - r) / 26;
		}

		return string;
	}

	/**
	 *
	 * @unused
	 * @param string
	 *        a string
	 * @return
	 *         the number corresponding to the string
	 */
	public static int toInt(String string) {
		if(string == null || string.length() == 0) {
			throw new NumberFormatException();
		}
		string = string.toUpperCase();
		int multiplier = 1;
		int columnNumber = 0;
		for(int i = string.length() - 1; i >= 0; i--) {
			final char c = string.charAt(i);
			if(c < 'A' || c > 'Z') {
				throw new NumberFormatException();
			}
			final int value = (c - 'A' + 1) * multiplier;
			columnNumber += value;
			multiplier *= 26;
		}
		return columnNumber;
	}
}
