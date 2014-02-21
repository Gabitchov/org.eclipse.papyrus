/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.common.sdk.core.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.emf.facet.common.sdk.core.internal.messages"; //$NON-NLS-1$
	public static String ProjectUtils_createEMFFacetProject;
	public static String ProjectUtils_createPluginProject;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
