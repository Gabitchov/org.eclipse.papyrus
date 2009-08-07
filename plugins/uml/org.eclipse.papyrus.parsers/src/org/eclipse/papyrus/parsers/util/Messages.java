/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.util;

import org.eclipse.osgi.util.NLS;

/**
 * Manages messages and labels for this plugin.
 */
public class Messages extends NLS {

	/** name of the bundle */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.parsers.util.messages"; //$NON-NLS-1$

	public static String NameMissing;

	/** initializer */
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	/**
	 * Default Constructor.
	 */
	private Messages() {
	}
}
