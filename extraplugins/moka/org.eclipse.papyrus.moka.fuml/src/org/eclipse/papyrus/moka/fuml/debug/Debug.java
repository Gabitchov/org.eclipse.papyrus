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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.debug;

// TODO Should redirect logging to Papyrus log helper
// TODO but problem with access restriction
// TODO Note: There is no problem with MokaEnvironment...
public class Debug {

	public static void println(String message) {
		System.out.println(message);
	}
}
