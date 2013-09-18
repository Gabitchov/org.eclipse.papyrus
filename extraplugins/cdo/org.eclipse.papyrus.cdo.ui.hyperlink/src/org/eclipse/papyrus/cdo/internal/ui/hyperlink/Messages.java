/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.hyperlink;

import org.eclipse.osgi.util.NLS;

/**
 * This is the Messages type.  Enjoy.
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.cdo.internal.ui.hyperlink.messages"; //$NON-NLS-1$

	public static String CDOResourceHyperlink_noSuchRepo;

	public static String CDOResourceHyperlink_noSuchResource;

	public static String CDOResourceHyperlink_notConnected;

	public static String CDOResourceHyperlink_openError;

	public static String CDOResourceHyperlinkEditorShell_message;

	public static String CDOResourceHyperlinkEditorShell_title;

	public static String CDOResourceHyperlinkHelper_name;
	public static String CDOResourceHyperlinkLabelProvider_tipAndURI;

	public static String CDOResourceHyperlinkLabelProvider_uriOnly;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
