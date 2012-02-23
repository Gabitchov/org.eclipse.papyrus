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
package org.eclipse.papyrus.infra.gmfdiag.css.helper;

public class StringHelper {

	/**
	 * Compares two strings. Case insensitive. The Strings are trimed.
	 * 
	 * Null strings already return false
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean equals(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return false;
		}

		return s1.trim().toLowerCase().equals(s2.trim().toLowerCase());
	}
}
