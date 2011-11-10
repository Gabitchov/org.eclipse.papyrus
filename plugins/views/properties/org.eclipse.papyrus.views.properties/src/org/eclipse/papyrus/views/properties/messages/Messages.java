/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.messages;

import org.eclipse.osgi.util.NLS;

/**
 * String externalisation for plug-in org.eclipse.papyrus.views.properties
 * 
 * @author Camille Letavernier
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.views.properties.messages.messages"; //$NON-NLS-1$

	public static String EcorePropertyEditorFactory_CreateANew;

	public static String EditionDialog_CreateANewElement;

	public static String Preferences_ConflictWarning1;

	public static String Preferences_ConflictWarning2;

	public static String Preferences_ConflictWarningTitle;

	public static String Preferences_Contexts;

	public static String Preferences_Custom;

	public static String Preferences_Plugin;

	public static String PropertyEditorFactory_CreateANewElement;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
