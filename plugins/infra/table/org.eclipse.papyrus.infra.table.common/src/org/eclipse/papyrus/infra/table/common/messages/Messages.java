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
package org.eclipse.papyrus.infra.table.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.table.common.messages.messages"; //$NON-NLS-1$

	public static String AbstractCreateNattableEditorCommand_CreateNewTableDialog_TableDescriptionMessage;

	public static String AbstractCreateNattableEditorCommand_CreateNewTableDialog_TableNameMessage;

	public static String AbstractCreateNattableEditorCommand_CreateNewTableDialogTitle;

	public static String NatTableEditor_TableContextLabel;

	public static String NatTableEditor_TableContextTollTip;

	public static String NatTableEditor_TableDescriptionToolTip;

	public static String NatTableEditor_TaleDescriptionLabel;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
