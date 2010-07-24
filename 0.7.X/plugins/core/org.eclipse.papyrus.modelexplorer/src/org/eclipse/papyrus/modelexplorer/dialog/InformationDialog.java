/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * A JFace dialog used to show information to the end user.<br>
 * This dialog is able to store the user choice into a preference store.<br>
 * 
 */
public class InformationDialog extends MessageDialog {

	private IPreferenceStore ps;

	private String preference;

	private Button rememberChoice;

	/**
	 * The Constructor.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param dialogTitle
	 *            the dialog title
	 * @param message
	 *            the message
	 * @param pso
	 *            the preference store
	 * @param preference
	 *            the preference
	 */
	public InformationDialog(Shell parentShell, String dialogTitle,
			String message, IPreferenceStore ps, String preference) {
		this(parentShell, dialogTitle, message, ps, preference, SWT.OK,
				MessageDialog.INFORMATION,
				new String[] { IDialogConstants.OK_LABEL });
	}

	/**
	 * The Constructor.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param dialogTitle
	 *            the dialog title
	 * @param message
	 *            the message
	 * @param ps
	 *            the ps the preference store
	 * @param preference
	 *            the preference string to store the choice
	 * @param style
	 *            the style for buttons : SWT.OK, SWT.YES
	 * @param messageDialogType
	 *            : MessageDialog.INFORMATION, MessageDialog.WARNING
	 * @param labels
	 *            the labels, for example IDialogConstants.OK_LABEL
	 */
	public InformationDialog(Shell parentShell, String dialogTitle,
			String message, IPreferenceStore ps, String preference, int style,
			int messageDialogType, String[] labels) {
		super(parentShell, dialogTitle, null, message, messageDialogType,
				labels, style);
		this.ps = ps;
		this.preference = preference;
	}

	/**
	 * @see org.eclipse.jface.dialogs.MessageDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		if (ps != null && preference != null && preference.length() > 0) {
			rememberChoice = new Button(container, SWT.CHECK);
			rememberChoice.setText("Do not show again");
		}
		return container;
	}

	/**
	 * @see org.eclipse.jface.window.Window#open() return Window.OK if it's
	 *      valid
	 */
	public int open() {
		// Do not open the dialog if the preference is true
		if (ps != null && preference != null && preference.length() > 0) {
			if (ps.getBoolean(preference)) {
				return Window.OK;
			}
		}
		return super.open();
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 */
	protected void buttonPressed(int buttonId) {
		// OK pressed
		if (buttonId == Window.OK && rememberChoice.getSelection()) {
			if (ps != null && preference != null && preference.length() > 0) {
				// Store the preference
				ps.setValue(preference, true);
			}
		}
		super.buttonPressed(buttonId);
	}

}
