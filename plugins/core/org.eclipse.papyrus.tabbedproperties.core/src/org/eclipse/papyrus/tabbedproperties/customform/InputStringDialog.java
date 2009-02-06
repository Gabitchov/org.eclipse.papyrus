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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.customform;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * open a dialog to write your text
 */
public class InputStringDialog extends Dialog {

	/**
	 * the text
	 */
	protected Text nameField;

	/**
	 * the label
	 */
	protected String announce = "Type a name";

	/**
	 *the value
	 */
	protected String value = "";

	/**
	 * create a dialog withe the label "type a name"
	 * 
	 * @param parentShell
	 */
	public InputStringDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create a dialog with you own label
	 * 
	 * @param parentShell
	 * @param announce
	 *            your own label
	 */
	public InputStringDialog(Shell parentShell, String announce) {
		super(parentShell);
		this.announce = announce;
	}

	/**
	 * Create a dialog with you own label with a default value
	 * 
	 * @param parentShell
	 * @param announce
	 *            your own label
	 * @param initialValue
	 *            the value that you want to display
	 */
	public InputStringDialog(Shell parentShell, String announce, String initialValue) {
		super(parentShell);
		this.announce = announce;
		this.value = initialValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout) comp.getLayout();
		layout.numColumns = 2;
		Label elementlabel = new Label(comp, SWT.RIGHT | SWT.SINGLE);
		elementlabel.setText(announce);
		nameField = new Text(comp, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		nameField.setText(value);
		nameField.setSize(300, 200);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		nameField.setLayoutData(data);
		data.widthHint = 250;
		data.heightHint = 100;
		return comp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		if (nameField.getText() != null) {
			value = nameField.getText();
		}
		super.okPressed();
	}

	/**
	 * get the string the user has put
	 * 
	 * @return the resulting string
	 */
	public String getValue() {
		return value;
	}
}
