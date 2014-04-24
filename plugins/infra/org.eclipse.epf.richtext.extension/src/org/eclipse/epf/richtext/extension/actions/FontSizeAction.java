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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.Platform;
import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.extension.RichTextResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class FontSizeAction extends RichTextComboAction {

	public FontSizeAction(final IRichText richText) {
		super(richText);
		setToolTipText(RichTextResources.fontSizeAction_toolTipText);
		this.input = new ArrayList<String>();

		this.input.add("Default");
		this.input.add("1");
		this.input.add("2");
		this.input.add("3");
		this.input.add("4");
		this.input.add("5");
		this.input.add("6");
		this.input.add("7");

		richText.addListener(SWT.Show, new Listener() {

			public void handleEvent(Event event) {
				FontSizeAction.this.setNotifyListeners(false);
				FontSizeAction.this.getCCombo().select(getFontSizeIndex());
				FontSizeAction.this.setNotifyListeners(true);
			}
		});

		richText.addListener(SWT.SELECTED, new Listener() {

			public void handleEvent(Event event) {

				if(!changed) {
					setNotifyListeners(false);
					getCCombo().select(getFontSizeIndex());
					setNotifyListeners(true);
				}

				// After combo selection, the SWT.SELECTION event launched 2 times!, only update combo if i == 2
				if(changed)
					i++;

				if((i == 2)) {

					changed = false;
					i = 0;
				}


			}
		});

		if(Platform.getOS().equals("linux")) {
			this.defaultSelected = 2; // Workarround a problem of selection event
		}
	}

	protected int getFontSizeIndex() {
		String fontSize = richText.getSelected().getFontSize();
		int index = 0;
		try {
			index = Integer.parseInt(fontSize);
		} catch (NumberFormatException localNumberFormatException) {
		}
		return index;
	}

	public void execute(IRichText richText) {
		if(richText != null) {
			String selected = getCComboSelection();
			if("Default".equals(selected))
				richText.executeCommand("setFontSize", "");
			else
				richText.executeCommand("setFontSize", selected);
		}
	}

	public Collection<String> getInput() {
		return this.input;
	}
}
