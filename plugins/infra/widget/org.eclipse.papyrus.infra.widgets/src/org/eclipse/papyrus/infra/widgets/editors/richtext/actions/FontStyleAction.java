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
package org.eclipse.papyrus.infra.widgets.editors.richtext.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichTextResources;
import org.eclipse.papyrus.infra.widgets.editors.richtext.actions.FontStyleAction;
import org.eclipse.papyrus.infra.widgets.editors.richtext.actions.RichTextComboAction;
import org.eclipse.epf.richtext.html.FontStyle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class FontStyleAction extends RichTextComboAction {

	public FontStyleAction(final IRichText richText) {
		super(richText);
		setToolTipText(RichTextResources.fontStyleAction_toolTipText);

		this.input = new ArrayList<String>();
		this.input.add(FontStyle.NORMAL.getName());
		this.input.add(FontStyle.SECTION_HEADING.getName());
		this.input.add(FontStyle.SUBSECTION_HEADING.getName());
		this.input.add(FontStyle.SUB_SUBSECTION_HEADING.getName());
		this.input.add(FontStyle.QUOTE.getName());
		this.input.add(FontStyle.CODE_SAMPLE.getName());

		richText.addListener(SWT.SELECTED, new Listener() {

			public void handleEvent(Event event) {

				if(!changed) {
					setNotifyListeners(false);
					getCCombo().select(getFontStyleIndex());
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
	}

	protected int getFontStyleIndex() {
		String blockStyle = richText.getSelected().getBlockStyle();
		String name = FontStyle.getFontStyleName(blockStyle);

		int index = ((FontStyleAction.this.getCCombo())).indexOf(name);
		if(index <= 0) {
			index = 0;
		}
		return index;
	}


	public void execute(IRichText richText) {
		if(richText != null) {
			String selected = getCComboSelection();
			String value = FontStyle.getFontStyleValue(selected);
			richText.executeCommand("setFontStyle", value);
		}
	}

	public Collection<String> getInput() {
		return this.input;
	}
}
