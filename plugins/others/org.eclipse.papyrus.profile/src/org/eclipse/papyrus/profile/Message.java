/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
public class Message {

	/**
	 * The Constant KEY_TITLE.
	 */
	private static final String KEY_TITLE = "Papyrus profile message";
	
	/**
	 * Print error on screen.
	 * 
	 * @param msg the msg
	 */
	public static void error(String msg) {
		Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, msg));
		new Exception(msg).printStackTrace();
	}
	
	/**
	 * Print warning on screen.
	 * 
	 * @param msg the msg
	 */
	public static void warning(String msg) {
		Shell shell = new Shell();
		MessageDialog.openWarning(
				shell,
				KEY_TITLE,
				msg);
	}
}
