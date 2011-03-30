/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.utils;

import java.util.StringTokenizer;

public class MarteUtils {
	
	public static String getValueFromTuple(String tupleValue, String propertyName) {
		StringTokenizer tupleTokenizer = new StringTokenizer(tupleValue.substring(1,tupleValue.length()-1), ",");
		while(tupleTokenizer.hasMoreTokens()) {
			String currentToken = tupleTokenizer.nextToken();
			StringTokenizer propertyTokenizer = new StringTokenizer(currentToken, "=");
			String nextToken = propertyTokenizer.nextToken().trim();
			if(nextToken.equals(propertyName))
				if(propertyTokenizer.hasMoreTokens())
					return propertyTokenizer.nextToken().trim();
		}
		return null;
	}
	
}
