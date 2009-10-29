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
package org.eclipse.papyrus.sasheditor.sash;

/**
 * TODO Remove this class. Just for debug purpose.
 * 
 */
public class Debug {

	private final String buff[] = new String[5];

	private int lastIndex = 0;

	// @unused
	static Debug out = new Debug();;

	void println(String str) {
		// Check if next in sequence
		if (str == buff[lastIndex++]) {
			return;
		}
		// Check if we restart sequence
		if (str == buff[0]) { // restart sequence
			lastIndex = 0;
			return;
		}

		// new sequence
		lastIndex = 0;
		buff[lastIndex] = str;
		println(str);
	}

}
