/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.dialog;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialogWithCheckBox;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This dialog adds a specific action on the okPressed() (opening a dialog)
 * 
 * @author vl222926
 * 
 */
public class DisplayedAxisSelectorDialog extends MultipleValueSelectorDialogWithCheckBox {

	/**
	 * the title of the information dialog
	 */
	private String informationDialogTitle;

	/**
	 * the message of the information dialog
	 */
	private String informationDialogMessage;

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 * @param unique
	 */
	public DisplayedAxisSelectorDialog(Shell parentShell, IElementSelector selector, boolean unique) {
		super(parentShell, selector, unique);
	}

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 * @param title
	 * @param unique
	 * @param ordered
	 * @param upperBound
	 */
	public DisplayedAxisSelectorDialog(Shell parentShell, IElementSelector selector, String title, boolean unique, boolean ordered, int upperBound) {
		super(parentShell, selector, title, unique, ordered, upperBound);
	}

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 * @param title
	 * @param unique
	 * @param ordered
	 */
	public DisplayedAxisSelectorDialog(Shell parentShell, IElementSelector selector, String title, boolean unique, boolean ordered) {
		super(parentShell, selector, title, unique, ordered);
	}

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 * @param title
	 */
	public DisplayedAxisSelectorDialog(Shell parentShell, IElementSelector selector, String title) {
		super(parentShell, selector, title);
	}

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 */
	public DisplayedAxisSelectorDialog(Shell parentShell, IElementSelector selector) {
		super(parentShell, selector);
	}

	/**
	 * 
	 * @param title
	 *        the title for the information dialog
	 * @param message
	 *        the message for the information dialog
	 */
	public void setInformationDialogValues(final String title, final String message) {
		this.informationDialogTitle = title;
		this.informationDialogMessage = message;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {
		boolean mustContinue = true;;
		if(displayCheckBox && !isChecked) {
			mustContinue = MessageDialog.openQuestion(Display.getDefault().getActiveShell(), informationDialogTitle, informationDialogMessage);
		}
		if(mustContinue) {
			super.okPressed();
		}
	}

}
