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
package com.cea.papyrus.profile.ui.dialogs;


import org.eclipse.swt.widgets.Shell;

// TODO: Auto-generated Javadoc
/**
 * The Class ComboSelectionDialog.
 */
public class ComboSelectionDialog extends ChooseDialog {
	
	/**
	 * The index of selection.
	 */
	public int indexOfSelection=0;
	
	/**
	 * The Constructor.
	 * 
	 * @param parentShell the parent shell
	 * @param message the message
	 * @param listofChoice the listof choice
	 * @param initial the initial
	 */
	public ComboSelectionDialog(Shell parentShell, String message, String[] listofChoice, String initial) {
		super(parentShell);
		announce = message;
		elementList = listofChoice;
		initialValue = initial;
	}
	
	/**
	 * Ok pressed.
	 */
	@Override
	protected void okPressed(){
		value=combo.getText();
		indexOfSelection = combo.getSelectionIndex();
		super.okPressed();
	}
}
