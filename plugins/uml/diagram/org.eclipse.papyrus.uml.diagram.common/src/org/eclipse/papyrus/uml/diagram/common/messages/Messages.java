/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.common.messages.messages"; //$NON-NLS-1$

	public static String CreateOrShowExistingElementHelper_CreateOrRestoreX;

	public static String CreateOrShowExistingElementHelper_XBetweenTheseElementAlreadyExists;

	public static String CreateOrShowExistingLinkDialog_Create;

	public static String CreateOrShowExistingLinkDialog_Ends;

	public static String CreateOrShowExistingLinkDialog_Name;

	public static String CreateOrShowExistingLinkDialog_RestoreSelection;

	public static String CreateOrShowExistingLinkDialog_ShowOrCreate;

	public static String CreateOrShowExistingLinkDialog_Sources;

	public static String CreateOrShowExistingLinkDialog_Targets;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
