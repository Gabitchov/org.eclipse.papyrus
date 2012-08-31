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
package org.eclipse.papyrus.dev.project.management.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This Dialog provides 2 texts field. It was created to be used during the table creation.
 * It doesn't provide validator for the second field.
 * 
 * 
 */
//TODO move this class in an upper project
//TODO generalize this class to have several text field
//FIXME : duplicated code from oep.infra.table.common
public class TwoInputDialog extends InputDialog {

	/** widget for the second value */
	private Text text_2;

	/** the second values */
	private String value_2;

	/** the message for the second Text */
	protected String message_2;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        the parent shell
	 * @param dialogTitle
	 *        the dialog title
	 * @param message1
	 *        the first message for the dialog
	 * @param message2
	 *        the second message for the dialog
	 * @param initialValue1
	 *        the first initial value
	 * @param initialValue2
	 *        the second initial value
	 * @param validator
	 *        the validator
	 */
	public TwoInputDialog(final Shell parentShell, final String dialogTitle, final String message1, final String message2, final String initialValue1, final String initialValue2, final IInputValidator validator) {
		super(parentShell, dialogTitle, message1, initialValue1, validator);
		this.message_2 = message2;
		this.value_2 = initialValue2;
	}

	/**
	 * Create the second Text Area
	 * 
	 * @see org.eclipse.jface.dialogs.InputDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite composite = (Composite)super.createDialogArea(parent);
		if(this.message_2 != null) {
			final Label label = new Label(composite, SWT.WRAP);
			label.setText(this.message_2);
			final GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
			data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
			label.setLayoutData(data);
			label.setFont(parent.getFont());
		}
		this.text_2 = new Text(composite, getInputTextStyle());
		this.text_2.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		applyDialogFont(composite);
		return composite;
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.InputDialog#buttonPressed(int)
	 * 
	 * @param buttonId
	 */
	@Override
	protected void buttonPressed(final int buttonId) {
		if(buttonId == IDialogConstants.OK_ID) {
			this.value_2 = this.text_2.getText();
		} else {
			this.value_2 = null;
		}
		super.buttonPressed(buttonId);
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.InputDialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		super.createButtonsForButtonBar(parent);
		if(this.value_2 != null) {
			this.text_2.setText(this.value_2);
		}
	}

	/**
	 * Getter for {@link #value_2}
	 * 
	 * @return
	 *         the description for the table
	 */
	public String getValue_2() {
		return this.value_2;
	}

}
