/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;


/**
 * 
 * @author VL222926
 *         This dialog is used to display paste error status
 */
public class PasteImportStatusDialog extends MessageDialog {

	/**
	 * Message displayed in the paste dialog
	 */
	public static final String HOW_TO_PASTE_MESSAGE = Messages.PasteImportStatusDialog_PasteConfigurationMessage;

	/**
	 * Title for all dialog used by this class
	 */
	public static final String DIALOG_TITLE = Messages.PasteImportStatusDialog_ImportPasteDialogTitle;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        the shell parent to use
	 * @param dialogMessage
	 *        the message to display
	 */
	public PasteImportStatusDialog(final Shell parentShell, final String dialogMessage) {
		super(parentShell, DIALOG_TITLE, getPapyrusIcon(), dialogMessage, MessageDialog.ERROR, new String[]{ IDialogConstants.OK_LABEL }, 0);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        the shell parent to use
	 * @param dialogMessage
	 *        the message to display
	 * @param dialogImageType
	 */
	public PasteImportStatusDialog(final Shell parentShell, final String dialogMessage, final int dialogImageType) {
		super(parentShell, DIALOG_TITLE, getPapyrusIcon(), dialogMessage, dialogImageType, new String[]{ IDialogConstants.OK_LABEL }, 0);
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.MessageDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite comp = (Composite)super.createDialogArea(parent);
		final CLabel label = new CLabel(comp, SWT.NONE);
		label.setText(HOW_TO_PASTE_MESSAGE);
		label.setImage(getInfoImage());
		return comp;
	}


	/**
	 * 
	 * @return
	 *         the papyrus icon
	 */
	private static final Image getPapyrusIcon() {
		return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/papyrus.png"); //$NON-NLS-1$
	}

}
