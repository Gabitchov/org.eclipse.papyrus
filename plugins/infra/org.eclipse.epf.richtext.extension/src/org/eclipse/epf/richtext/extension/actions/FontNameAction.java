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
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.extension.RichTextResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class FontNameAction extends RichTextComboAction {

	public FontNameAction(final IRichText richText) {
		super(richText);
		setToolTipText(RichTextResources.fontNameAction_toolTipText);

		SortedSet<String> fontSet = new TreeSet<String>();
		FontData[] fonts = Display.getCurrent().getFontList(null, true);
		for(int i = 0; i < fonts.length; i++) {
			fontSet.add(fonts[i].getName());
		}
		this.input = new ArrayList<String>();
		this.input.add(RichTextResources.fontNameAction_DefaultFontName);
		for(Iterator<String> iter = fontSet.iterator(); iter.hasNext();) {
			String fontName = (String)iter.next();
			this.input.add(fontName);
		}

		richText.addListener(SWT.SELECTED, new Listener() {

			public void handleEvent(Event event) {

				if(!changed) {
					setNotifyListeners(false);
					getCCombo().select(getFontNameIndex());
					setNotifyListeners(true);
				}

				// After combo selection, the SWT.SELECTION event launched 2 times!, only update combo if i == 2
				if(changed)
					i++;

				if(i == 2) {
					changed = false;
					i = 0;
				}



			}
		});
	}

	protected int getFontNameIndex() {
		String fontName = richText.getSelected().getFontName();

		if((fontName.equals(RichTextResources.fontNameAction_CSS_Default)) || (fontName.equals(RichTextResources.fontNameAction_CSS_Default_Mozilla)) || (fontName.equals("default"))) {
			fontName = RichTextResources.fontNameAction_DefaultFontName;
		}
		return findFontNameInItems(fontName);
	}

	private int findFontNameInItems(String fontName) {
		int index = 0;
		String[] elements = fontName.split(",");
		for(Iterator<String> iter = this.input.iterator(); iter.hasNext(); index++) {
			String font = (String)iter.next();
			for(String string : elements) {
				if(font.equalsIgnoreCase(string)) {
					return index;
				}
			}
		}
		return index;
	}

	public void execute(IRichText richText) {
		if(richText != null) {
			String selected = getCComboSelection();
			if(selected.equals(RichTextResources.fontNameAction_DefaultFontName))
				richText.executeCommand("setFontName", "");
			else
				richText.executeCommand("setFontName", selected);
		}
	}

	public Collection<String> getInput() {
		return this.input;
	}
}
