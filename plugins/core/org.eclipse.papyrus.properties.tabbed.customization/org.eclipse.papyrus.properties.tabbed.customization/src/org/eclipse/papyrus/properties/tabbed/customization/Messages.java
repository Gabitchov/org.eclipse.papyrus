/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization;

import org.eclipse.osgi.util.NLS;

/**
 * Messages internationalization.
 */
public class Messages extends NLS {

	/** name of the bundle */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.properties.tabbed.customization.messages"; //$NON-NLS-1$

	public static String CustomizePropertyViewDialog_DialogTitle;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
