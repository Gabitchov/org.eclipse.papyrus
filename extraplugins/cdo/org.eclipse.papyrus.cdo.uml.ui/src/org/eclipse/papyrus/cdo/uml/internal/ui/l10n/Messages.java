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
package org.eclipse.papyrus.cdo.uml.internal.ui.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * This is the Messages type.  Enjoy.
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.cdo.uml.internal.ui.l10n.messages"; //$NON-NLS-1$

	public static String CDOPackageImportSource_0;

	public static String CDOPackageImportSource_1;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
