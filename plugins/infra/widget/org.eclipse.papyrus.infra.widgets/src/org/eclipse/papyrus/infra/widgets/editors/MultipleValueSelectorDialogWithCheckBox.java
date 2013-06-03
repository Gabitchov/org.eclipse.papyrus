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
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * This dialog adds a checkbox at the end of the {@link MultipleValueSelectorDialog}
 * 
 * @author vl222926
 * 
 */
public class MultipleValueSelectorDialogWithCheckBox extends MultipleValueSelectorDialog {

	/** boolean indicating if the checkbox is checked */
	protected boolean isChecked;

	/** The text to display for the checkbox */
	protected String text;

	/** the tooltip to display for the checkbox */
	protected String tooltip;

	/** indicates if the checkbox must be displayed or not */
	protected boolean displayCheckBox = true;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 * @param unique
	 */
	public MultipleValueSelectorDialogWithCheckBox(Shell parentShell, IElementSelector selector, boolean unique) {
		super(parentShell, selector, unique);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 * @param title
	 * @param unique
	 * @param ordered
	 * @param upperBound
	 */
	public MultipleValueSelectorDialogWithCheckBox(Shell parentShell, IElementSelector selector, String title, boolean unique, boolean ordered, int upperBound) {
		super(parentShell, selector, title, unique, ordered, upperBound);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 * @param title
	 * @param unique
	 * @param ordered
	 */
	public MultipleValueSelectorDialogWithCheckBox(Shell parentShell, IElementSelector selector, String title, boolean unique, boolean ordered) {
		super(parentShell, selector, title, unique, ordered);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 * @param title
	 */
	public MultipleValueSelectorDialogWithCheckBox(Shell parentShell, IElementSelector selector, String title) {
		super(parentShell, selector, title);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param selector
	 */
	public MultipleValueSelectorDialogWithCheckBox(Shell parentShell, IElementSelector selector) {
		super(parentShell, selector);
	}

	/**
	 * 
	 * @param text
	 *        the text to display near the checkbox
	 * @param tooltip
	 *        the tooltip to display for the checkbox
	 * @param isChecked
	 *        the initial state of the checkbox
	 */
	public void setCheckBoxValues(final String text, final String tooltip, final boolean isChecked) {
		this.text = text;
		this.tooltip = tooltip;
		this.isChecked = isChecked;
	}

	/**
	 * this method allows to display or hide the checkbox
	 */
	public void setDisplayCheckBox(boolean displayCheckBox) {
		this.displayCheckBox = displayCheckBox;
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if the disalog is displaying the checkbox
	 */
	public boolean isDisplayingCheckBox() {
		return this.displayCheckBox;
	}

	/**
	 * We Add a checkbox at the end of the dialog
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog#createDialogContents()
	 * 
	 */
	@Override
	protected void createDialogContents() {
		super.createDialogContents();
		if(this.displayCheckBox) {
			final Composite parent = getDialogArea();
			final Button button = new Button(parent, SWT.CHECK);
			button.setText(this.text);
			button.setToolTipText(this.tooltip);
			button.setSelection(this.isChecked);
			final SelectionListener listener = new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					isChecked = button.getSelection();
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			};
			button.addSelectionListener(listener);
		}
	}


	/**
	 * 
	 * @return
	 *         the state of the checkbox button
	 */
	public boolean isChecked() {
		return this.isChecked;
	}
}
