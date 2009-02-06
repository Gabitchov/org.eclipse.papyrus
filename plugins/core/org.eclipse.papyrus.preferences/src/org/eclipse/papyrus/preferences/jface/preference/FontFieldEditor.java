/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.preferences.jface.preference;

import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.properties.internal.l10n.DiagramUIPropertiesImages;
import org.eclipse.gmf.runtime.diagram.ui.properties.internal.l10n.DiagramUIPropertiesMessages;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.preferences.utils.FontHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

/**
 * A field editor for GMF Font preferences. This field editor handles :
 * <ul>
 * <li>Font Style</li>
 * <li>Font Size</li>
 * <li>Bold</li>
 * <li>Italic</li>
 * </ul>
 *This field editor is inspired by the class {@link org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorsAndFontsPropertySection <em>ColorsAndFontsPropertySection</em>}
 * 
 * @author tlandre
 */
public class FontFieldEditor extends FieldEditor {

	private Button fontBoldButton;

	private Button fontItalicButton;

	private Combo fontNameCombo;

	private Combo fontSizeCombo;

	/** value changed string */
	static protected String VALUE_CHANGED_STRING = DiagramUIPropertiesMessages.AbstractPropertySection_UndoIntervalPropertyString;

	/** properties */
	protected static final String FONT_COMMAND_NAME = DiagramUIPropertiesMessages.Font_commandText + StringStatics.SPACE + VALUE_CHANGED_STRING;

	protected static final String FONTS_AND_COLORS_LABEL = DiagramUIPropertiesMessages.FontAndColor_nameLabel;

	private FontData fontData;

	/**
	 * Constructor
	 * 
	 * @param preferenceName
	 *            the preference used for the Font
	 * @param parent
	 *            the parent composite in which this field editor will be placed.
	 */
	public FontFieldEditor(String preferenceName, Composite parent) {
		super(preferenceName, "", parent);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#adjustForNumColumns(int)
	 */
	@Override
	protected void adjustForNumColumns(int numColumns) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#doLoad()
	 */
	@Override
	protected void doLoad() {
		fontData = PreferenceConverter.getFontData(getPreferenceStore(), getPreferenceName());
		initFontData();
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#doLoadDefault()
	 */
	@Override
	protected void doLoadDefault() {
		fontData = PreferenceConverter.getDefaultFontData(getPreferenceStore(), getPreferenceName());
		initFontData();
	}

	private void initFontData() {

		// Name Combo
		fontNameCombo.setText(fontData.getName());
		// Size combo
		fontSizeCombo.setText("" + fontData.getHeight());

		int style = fontData.getStyle();
		// Bold Button
		if ((style & SWT.BOLD) == SWT.BOLD) {
			fontBoldButton.setSelection(true);
		} else {
			fontBoldButton.setSelection(false);
		}
		// Italic Button
		if ((style & SWT.ITALIC) == SWT.ITALIC) {
			fontItalicButton.setSelection(true);
		} else {
			fontItalicButton.setSelection(false);
		}
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditor#doStore()
	 */
	@Override
	protected void doStore() {
		fontData = new FontData();
		fontData.setName(fontNameCombo.getText());
		fontData.setHeight(Integer.parseInt(fontSizeCombo.getText()));
		fontData.setStyle(getStyle());
		PreferenceConverter.setValue(getPreferenceStore(), getPreferenceName(), fontData);

	}

	private int getStyle() {
		int style = SWT.NORMAL;
		if (fontBoldButton.getSelection()) {
			style |= SWT.BOLD;
		}
		if (fontItalicButton.getSelection()) {
			style |= SWT.ITALIC;
		}
		return style;
	}

	@Override
	public void dispose() {
		super.dispose();
		fontBoldButton.dispose();
		fontItalicButton.dispose();
		fontNameCombo.dispose();
		fontSizeCombo.dispose();
	}

	@Override
	public int getNumberOfControls() {
		return 1;
	}

	@Override
	protected void createControl(Composite parent) {
		Composite compo = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout(3, false);
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		compo.setLayout(gl);

		fontNameCombo = new Combo(compo, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
		fontNameCombo.setItems(FontHelper.getFontNames());

		GridData gridData = new GridData(SWT.BEGINNING, SWT.CENTER, true, false);
		gridData.horizontalSpan = 3;

		fontNameCombo.setLayoutData(gridData);

		fontBoldButton = new Button(compo, SWT.TOGGLE);
		fontBoldButton.setImage(DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_BOLD));

		fontItalicButton = new Button(compo, SWT.TOGGLE);
		fontItalicButton.setImage(DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_ITALIC));

		fontSizeCombo = new Combo(compo, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
		fontSizeCombo.setItems(FontHelper.getFontSizes());

		gridData = new GridData(SWT.END, SWT.CENTER, true, false);
		fontSizeCombo.setLayoutData(gridData);

	}

}
