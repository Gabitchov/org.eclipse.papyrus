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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

// TODO: Auto-generated Javadoc
/**
 * The Class ChooseDialog.
 */
public class ChooseDialog extends Dialog {

	/**
	 * The combo.
	 */
	protected Combo combo;

	/**
	 * The element list.
	 */
	protected String[] elementList = { "test", "test1", "test2" };

	/**
	 * The name field.
	 */
	protected Text nameField;

	/**
	 * The announce.
	 */
	protected String announce = "Choose your element";

	/**
	 * The channel.
	 */
	protected int channel = 19;

	/**
	 * The value.
	 */
	protected Object value = null;

	/**
	 * The initial value.
	 */
	protected String initialValue = "";

	/**
	 * The Constructor.
	 * 
	 * @param parentShell
	 *        the parent shell
	 */
	public ChooseDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Creates the dialog area.
	 * 
	 * @param parent
	 *        the parent
	 * 
	 * @return the control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite)super.createDialogArea(parent);

		GridLayout layout = (GridLayout)comp.getLayout();
		layout.numColumns = 2;
		Label elementlabel = new Label(comp, SWT.RIGHT | SWT.SINGLE);
		elementlabel.setText(announce);

		combo = new Combo(comp, SWT.READ_ONLY);
		combo.setItems(elementList);
		combo.setText(initialValue);
		combo.setSize(400, 400);
		return comp;
	}

	/**
	 * Creates the buttons for button bar.
	 * 
	 * @param parent
	 *        the parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);

	}

	/**
	 * Button pressed.
	 * 
	 * @param buttonId
	 *        the button id
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
	}

	/**
	 * Ok pressed.
	 */
	@Override
	protected void okPressed() {

		super.okPressed();
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
}
