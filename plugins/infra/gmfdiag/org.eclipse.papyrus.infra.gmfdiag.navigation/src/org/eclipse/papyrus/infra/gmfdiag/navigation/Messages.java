/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.navigation;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.navigation.messages"; //$NON-NLS-1$

	public static String DoubleClickNavigationText;

	public static String Explicit_ImplicitNavigation_Text;

	public static String ExplicitNavigation_Text;

	public static String No_Navigation_Text;

	public static String DecoratorVisibilityText;

	public static String DecoratorDisabled_Text;

	public static String DisplayOnly_Text;

	public static String Everywhere_Text;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
