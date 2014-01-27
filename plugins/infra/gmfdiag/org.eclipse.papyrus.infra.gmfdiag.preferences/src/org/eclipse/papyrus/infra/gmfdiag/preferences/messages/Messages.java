/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.preferences.messages.messages"; //$NON-NLS-1$

	public static String ApplyValueOnPreferenceKeyDialog_DIAGRAM;

	public static String ApplyValueOnPreferenceKeyDialog_ELEMENT;

	public static String LabelGroup_Labels_To_Display;

	public static String RulersAndGridGroup_GridColor;

	public static String RulersAndGridGroup_GridInFront;

	public static String RulersAndGridGroup_GridStyle;
	
	

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
