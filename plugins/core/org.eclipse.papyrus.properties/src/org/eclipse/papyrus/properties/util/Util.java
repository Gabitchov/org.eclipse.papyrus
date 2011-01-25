/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.util;

public class Util {

	public static String firstToUpper(String source) {
		return source.substring(0, 1).toUpperCase() + source.substring(1);
	}

	public static String getLabel(String variableName) {
		return firstToUpper(variableName);
	}
}
