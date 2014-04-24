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

import java.util.Collection;

import org.eclipse.epf.richtext.IRichText;

public abstract class RichTextComboAction extends ComboContributionItem {

	protected IRichText richText;

	protected String toolTipText;

	protected boolean enabled = true;

	protected boolean notifyListeners = false;

	protected boolean changed = false;

	protected int i = 0;


	public RichTextComboAction(IRichText richText) {
		super(8390664);
		this.richText = richText;
	}

	public RichTextComboAction(IRichText richText, int style) {
		super(0x800808 | style);
		this.richText = richText;
	}

	public abstract void execute(IRichText paramIRichText);

	public abstract Collection<String> getInput();

	public void init() {
		setInput(getInput());
		setNotifyListeners(true);
	}

	protected String getCComboSelection() {
		if(getCCombo() != null) {
			int index = getSelectionIndex();
			return getCCombo().getItem(index);
		}
		return null;
	}

	public String getToolTipText() {
		return this.toolTipText;
	}

	public void setToolTipText(String toolTipText) {
		this.toolTipText = toolTipText;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	protected void performSelectionChanged() {
		if(this.notifyListeners) {
			changed = true;
			execute(this.richText);
		}
		richText.setFocus();
	}

	public boolean isNotifyListeners() {
		return this.notifyListeners;
	}

	public void setNotifyListeners(boolean notifyListeners) {
		this.notifyListeners = notifyListeners;
	}
}
