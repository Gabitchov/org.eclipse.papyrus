/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.controlmode.umlprofiles;

import org.eclipse.osgi.util.NLS;

/**
 * This class handles messages internationalization.
 * 
 * @author vhemery
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.controlmode.umlprofiles.messages"; //$NON-NLS-1$

	/** Message for switching the loading strategy when controlled package is not loaded */
	public static String switch_loading_strategy;

	/** Error message when controlled package is read-only */
	public static String error_readonly;

	/** Error message when an error occurs during validation */
	public static String error_during_validation;
	
	/** Error message when trying to delete a duplicated profile application*/
	public static String warning_cannot_delete_duplicated;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
