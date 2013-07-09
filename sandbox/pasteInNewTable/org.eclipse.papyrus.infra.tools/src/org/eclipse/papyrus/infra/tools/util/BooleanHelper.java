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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/

package org.eclipse.papyrus.infra.tools.util;

/**
 * 
 * This class provides an useful methods for boolean
 * 
 */
public class BooleanHelper {

	private BooleanHelper() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param str
	 *        a string
	 * @return
	 *         <code>true</code> if the string represents a boolean value
	 */
	public static final boolean isBoolean(final String str) {
		return "true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
