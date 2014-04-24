/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.epf.richtext.extension.actions;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.extension.ui.ButtonContributionItem;
import org.eclipse.swt.SWT;

/**
 * @author Nguyen Viet Hoa
 * 
 */
public abstract class RichTextButtonAction extends ButtonContributionItem {

	protected IRichText richText;


	protected String toolTipText;

	protected boolean enabled = true;

	protected boolean notifyListeners = false;


	/**
	 * Creates a new instance.
	 * 
	 * @param richText
	 *        a rich text control
	 */
	public RichTextButtonAction(IRichText richText) {
		super(SWT.FLAT | SWT.BORDER);
		this.richText = richText;
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param richText
	 *        a rich text control
	 */
	public RichTextButtonAction(IRichText richText, int style) {
		super(SWT.FLAT | SWT.BORDER | style);
		this.richText = richText;
	}


	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *        a rich text control
	 * @param index
	 *        the index of the selected item
	 */
	public abstract void execute(IRichText richText);



	public void init() {

		setNotifyListeners(true);
	}





	/**
	 * Returns the tool tip for the action.
	 * 
	 * @return the tool tip text
	 */
	public String getToolTipText() {
		return toolTipText;
	}

	/**
	 * Sets the tool tip for the action.
	 * 
	 * @param toolTipText
	 *        the tool tip text
	 */
	public void setToolTipText(String toolTipText) {
		this.toolTipText = toolTipText;
	}

	/**
	 * Returns the enabled status of the action.
	 * 
	 * @return <code>true</code> if enabled, <code>false</code> if not
	 */
	public boolean getEnabled() {
		return enabled;
	}

	/**
	 * Enables or disables the action.
	 * 
	 * @param enabled
	 *        if <code>true</code>, enable the action. if <code>false</code>, disable it.
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	protected void performSelectionChanged() {
		if(notifyListeners) {
			execute(richText);
			richText.setFocus();
		}
	}

	public boolean isNotifyListeners() {
		return notifyListeners;
	}

	public void setNotifyListeners(boolean notifyListeners) {
		this.notifyListeners = notifyListeners;
	}
}
