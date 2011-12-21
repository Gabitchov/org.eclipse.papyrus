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
package org.eclipse.papyrus.uml.properties.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.properties.messages.messages"; //$NON-NLS-1$

	public static String ExpressionLanguageFactory_EditLanguage;

	public static String ExpressionLanguageFactory_LanguageDuplicateError;

	public static String ExpressionLanguageFactory_SetNewLanguage;

	public static String UMLNotationModelElement_DepthFull;

	public static String UMLNotationModelElement_DepthNone;

	public static String ExpressionEditor_BodyLabel;

	public static String ProfileApplicationEditor_ApplyProfile;

	public static String ProfileApplicationEditor_ApplyProfilesDialogDescription;

	public static String ProfileApplicationEditor_ApplyProfilesDialogTitle;

	public static String ProfileApplicationEditor_ApplyRegisteredProfile;

	public static String ProfileApplicationEditor_WaitMessage;

	public static String ProfileApplicationEditor_WaitMessageTitle;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
