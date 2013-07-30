/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.Comparator;

/**
 * A String comparator
 * 
 * 
 * 
 */
public class StringComparator implements Comparator<String> {

	/** ignore the case */
	public static final int IGNORE_CASE = 1;

	/** don't ignore the case */
	public static final int NO_IGNORE_CASE = IGNORE_CASE + 1;

	/**
	 * The comparator mode
	 */
	private int mode = IGNORE_CASE;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public StringComparator() {
		this.mode = IGNORE_CASE;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param mode
	 *        the mode used to do the comparison
	 */
	public StringComparator(int mode) {
		this.mode = (mode == NO_IGNORE_CASE) ? NO_IGNORE_CASE : IGNORE_CASE;
	}

	/**
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public int compare(String o1, String o2) {
		if(IGNORE_CASE == this.mode) {
			return o1.toLowerCase().compareToIgnoreCase(o2.toLowerCase());
		}
		return o1.toLowerCase().compareTo(o2.toLowerCase());
	}

}
