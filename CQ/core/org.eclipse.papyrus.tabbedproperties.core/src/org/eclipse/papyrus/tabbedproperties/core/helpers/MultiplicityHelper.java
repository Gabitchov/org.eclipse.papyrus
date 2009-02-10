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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.helpers;

import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * This class provides usefull methods linked to Multiplicity.
 * 
 * @author dumoulin
 * 
 */
public class MultiplicityHelper {

	private String selectableValues[] = { "0..1", "0..1", "0..*", "0..*", "1", "1", "1..*", "1..*", "*", "*" };

	/**
	 * 
	 * @return
	 */
	public String[] getSelectableValues() {
		return selectableValues;
	}

	/**
	 * Set value from the string. String is parsed to retrieve the correct value.
	 * 
	 * @param multiplicity
	 * @param newValue
	 */
	public void setValueAsString(MultiplicityElement multiplicity, String newValue) {
		String res[] = newValue.split("[.{2}?]");
		// System.out.println("split: " + result.length);
		int upperBound = 1;
		int lowerBound = 0;

		try {
			if (res.length == 1) {
				int val = parseBound(res[0]);
				if (val == -1)
					upperBound = -1;
				else {
					lowerBound = val;
					upperBound = -2;
				}
			}
			if (res.length == 3) {
				lowerBound = parseBound(res[0]);
				upperBound = parseBound(res[2]);
			}

		} catch (NumberFormatException e) { // silently fail
		// e.printStackTrace();
		}

		System.out.println("setMultiplicity(" + lowerBound + ".." + upperBound + ")");
		multiplicity.setLower(lowerBound);
		multiplicity.setUpper(upperBound);
	}

	/**
	 * Parse the int value. Return the int value or *;
	 * 
	 * @param value
	 * @return
	 */
	private int parseBound(String value) throws NumberFormatException {
		if ("*".equals(value) || "n".equals(value))
			return -1;
		else {
			return Integer.parseInt(value);
		}
	}

	/**
	 * Get the value as a string.
	 * 
	 * @param multiplicity
	 * @return
	 */
	public String getValueAsString(MultiplicityElement multiplicity) {
		int lower2 = multiplicity.getLower();
		int upper2 = multiplicity.getUpper();

		if (upper2 == -1) {
			return new String(lower2 + "..*");
		} else if (lower2 == upper2) {
			return Integer.toString(upper2);
		} else {
			return new String(lower2 + ".." + upper2);
		}
	}
}
