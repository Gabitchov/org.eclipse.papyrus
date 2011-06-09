/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.gmf.editors;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.papyrus.widgets.editors.AbstractValueEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;

public class FontEditor extends AbstractValueEditor {

	private CCombo fontCombo;

	public FontEditor(Composite parent, int style) {
		super(parent, style);
		fontCombo = factory.createCCombo(this, style | SWT.READ_ONLY
				| SWT.BORDER);
		fontCombo.setLayoutData(getDefaultLayoutData());
		// fontCombo.setEditable(false);

		FontData[] fontDatas = getDisplay().getFontList(null, true);

		Arrays.sort(fontDatas, new Comparator<FontData>() {

			public int compare(FontData font1, FontData font2) {
				return Collator.getInstance().compare(font1.getName(),
						font2.getName());
			}

		});

		Set<String> fonts = new HashSet<String>();
		for (FontData data : fontDatas) {
			if (data.getName() != null) {
				if (fonts.add(data.getName())) {
					fontCombo.add(data.getName());
				}
			}
		}

		setWidgetObservable(WidgetProperties.selection().observe(fontCombo));
	}

	@Override
	public String getValue() {
		int index = fontCombo.getSelectionIndex();
		return fontCombo.getItem(index);
	}

	@Override
	public Object getEditableType() {
		return String.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		fontCombo.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !fontCombo.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		setLabelToolTipText(text);
		fontCombo.setToolTipText(text);
	}

}
