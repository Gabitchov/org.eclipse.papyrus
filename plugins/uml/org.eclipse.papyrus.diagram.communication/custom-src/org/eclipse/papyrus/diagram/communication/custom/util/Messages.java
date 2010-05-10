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
 *   Atos Origin - Initial API and implementation
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - adapted from sequence diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.util;

import org.eclipse.osgi.util.NLS;

/**
 * 
 * 
 * 
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.diagram.communication.custom.util.messages"; //$NON-NLS-1$

	/**
 * 
 */
	public static String CommandHelper_PropertySelection;

	/**
 * 
 */
	public static String CommandHelper_SelectProperty;

	/**
 * 
 */
	public static String CommandHelper_SelectSignature;

	/**
 * 
 */
	public static String CommandHelper_signatureslection;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
