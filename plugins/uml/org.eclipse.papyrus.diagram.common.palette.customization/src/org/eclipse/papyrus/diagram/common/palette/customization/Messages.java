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
package org.eclipse.papyrus.diagram.common.palette.customization;

import org.eclipse.osgi.util.NLS;

/**
 * Messages for the plugin
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.diagram.common.palette.customization"; //$NON-NLS-1$

	public static String BundleIconExplorerDialog_Message;

	public static String BundleIconExplorerDialog_Title;

	public static String BundleIconExplorerDialog_UnknownFileName;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
