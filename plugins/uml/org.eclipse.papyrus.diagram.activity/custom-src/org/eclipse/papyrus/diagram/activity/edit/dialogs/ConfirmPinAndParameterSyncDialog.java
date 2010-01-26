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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.diagram.activity.part.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This class enables to open a dialog to ask the user to confirm he wants to update a Parameter and associated Pins
 * 
 */
public class ConfirmPinAndParameterSyncDialog extends MessageDialog {

	/**
	 * Protected constructor. Use {@link #openConfirmFromParameter(Shell)} or {@link #openConfirmFromPin(Shell)}
	 * 
	 * @param parentShell
	 *        the parent shell
	 * @param dialogMessage
	 *        the message
	 */
	protected ConfirmPinAndParameterSyncDialog(Shell parentShell, String dialogMessage) {
		super(parentShell, Messages.ConfirmPinAndParameterSync_Title, null, dialogMessage, CONFIRM, new String[]{ IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
	}

	/**
	 * Open a confirmation dialog for a modification from a parameter
	 * 
	 * @param parentShell
	 *        the parent shell
	 * @param listOfActions
	 *        the list of impacted actions
	 * @param labelprovider
	 *        the label provider to read actions
	 * @return the user confirmation
	 */
	public static boolean openConfirmFromParameter(Shell parentShell, List<? extends NamedElement> listOfActions, ILabelProvider labelprovider) {
		StringBuffer parsedList = new StringBuffer();
		for(NamedElement element : listOfActions) {
			parsedList.append(labelprovider.getText(element));
			parsedList.append("\n");
		}
		String message = NLS.bind(Messages.ConfirmPinAndParameterSync_FromParameterMsg, parsedList.toString());
		ConfirmPinAndParameterSyncDialog dialog = new ConfirmPinAndParameterSyncDialog(parentShell, message);
		dialog.setShellStyle(dialog.getShellStyle() | SWT.SHEET);
		return dialog.open() == 0;
	}


}
