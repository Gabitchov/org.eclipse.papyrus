/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Message {
	
	final Shell _message;
		
	public Message(String title, String text) {
		_message = new Shell(new Shell(), SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
		_message.setText(title);
		_message.setSize(250, 100);

		final Label label = new Label(_message, SWT.NONE);
		label.setText(text);
		label.setBounds(20, 15, 100, 20);
	}
	
	public void open() {
		_message.open();
	}
	
	public void close() {
		_message.close();
	}
}
