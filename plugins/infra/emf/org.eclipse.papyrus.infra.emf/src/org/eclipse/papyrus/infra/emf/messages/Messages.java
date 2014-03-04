/*
 * Copyright (c) 2012, 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 323802
 *
 */
package org.eclipse.papyrus.infra.emf.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.emf.messages.messages"; //$NON-NLS-1$

	public static String ResourceFilteredLabelProvider_local;

	public static String ResourceFilteredLabelProvider_localExt;

	public static String ResourceFilteredLabelProvider_system;

	public static String ResourceFilteredLabelProvider_systemExt;

	public static String ResourceFilteredLabelProvider_workspace;

	public static String ResourceFilteredLabelProvider_workspaceExt;

	public static String UnsetCommand_UnsetCommand;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
