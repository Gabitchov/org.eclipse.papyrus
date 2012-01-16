/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.hyperlink.util.messages"; //$NON-NLS-1$

	public static String HyperLinkHelpersRegistrationUtil_ICantCreateTheClassForAnHelper;

	public static String HyperLinkHelpersRegistrationUtil_TheHelperWillBeIgnored;

	public static String HyperLinkTabRegistrationUtil_ICantCreateTheTab;

	public static String HyperLinkTabRegistrationUtil_tabWillBeIgnored;
	
	public static String HyperLinkTabRegistrationUtil_NotAnInstanceOf;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
