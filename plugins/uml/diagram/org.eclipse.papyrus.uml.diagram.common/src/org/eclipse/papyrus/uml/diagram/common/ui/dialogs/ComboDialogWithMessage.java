/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * this class provides a combo, with a warning message when the list is empty
 */
public class ComboDialogWithMessage extends ComboInputDialog {

	/**
	 * Error message label widget.
	 */
	private CLabel warningMessageText;

	/**
	 * Error message string.
	 */
	private String warningMessage;

	/**
	 * the warning icon
	 */
	private static final String ICON_WARNING = "/icons/warning.gif"; //$NON-NLS-1$

	protected ComboDialogWithMessage(Shell parentShell, String title, String message, String initialValue, String[] elementsList, String warningMessage) {
		super(parentShell, title, message, initialValue, elementsList);
		this.warningMessage = warningMessage;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.ui.dialogs.InputDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// create composite
		Composite composite = (Composite)super.createDialogArea(parent);
		if(getElementList() == null || (getElementList().length == 1 && getElementList()[0].equals(""))) { //$NON-NLS-1$
			warningMessageText = new CLabel(composite, SWT.READ_ONLY | SWT.WRAP);
			warningMessageText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			warningMessageText.setBackground(warningMessageText.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			// Set the error message text
			// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=66292
			setWarningMessage(warningMessage);
		}
		applyDialogFont(composite);
		return composite;
	}

	/**
	 * Set the warning message
	 * 
	 * @param warningMessage
	 */
	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
		if((warningMessageText != null) && !warningMessageText.isDisposed()) {
			Image errorImage = Activator.getPluginIconImage(Activator.ID, ICON_WARNING);
			warningMessageText.setImage(warningMessage == null ? null : errorImage);
			warningMessageText.setText(warningMessage == null ? "" : warningMessage); //$NON-NLS-1$
			warningMessageText.getParent().update();
			// Access the ok button by id, in case clients have overridden
			// button creation.
			// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=113643

			Control button = getButton(IDialogConstants.OK_ID);
			if(button != null) {
				button.setEnabled(warningMessage == null);
			}
		}
	}

	/**
	 * Returns the style bits that should be used for the input text field.
	 * Defaults to a single line entry. Subclasses may override.
	 * 
	 * @return the integer style bits that should be used when creating the
	 *         input text
	 * 
	 * @since 3.4
	 */
	protected int getInputTextStyle() {
		return SWT.SINGLE | SWT.BORDER;
	}

}
