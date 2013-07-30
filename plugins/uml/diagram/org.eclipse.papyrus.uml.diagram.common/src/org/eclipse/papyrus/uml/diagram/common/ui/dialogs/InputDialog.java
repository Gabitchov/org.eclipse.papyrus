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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * This class provides a Window with :
 * <ul>
 * <li>a title</li>
 * <li>a message</li>
 * <li>an OK button</li>
 * <li>a Cancel button</li>
 * </ul>
 */
public class InputDialog extends Dialog {

	/** The title of the dialog. */

	private final String title;

	/** The message to display, or <code>null</code> if none. */

	private final String message;

	/** The initial value. */

	protected String initialValue = ""; //$NON-NLS-1$

	private String value = ""; //$NON-NLS-1$

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param initialValue
	 */
	public InputDialog(Shell parentShell, String title, String message, String initialValue) {
		super(parentShell);
		this.title = title;
		this.message = message;
		if(initialValue != null) {

			this.initialValue = initialValue;
			this.value = initialValue;
		}
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		if(title != null) {
			shell.setText(title);
		}
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);

		if(message != null) {
			Label label = new Label(composite, SWT.WRAP);
			label.setText(message);
			GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
			data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
			label.setLayoutData(data);
			label.setFont(parent.getFont());
		}
		return composite;
	}

	/**
	 * Set the value
	 * 
	 * @param newValue
	 */
	protected void setValue(String newValue) {
		this.value = newValue;
	}
}
