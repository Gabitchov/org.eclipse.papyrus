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
package org.eclipse.papyrus.preferences.pages;

import org.eclipse.gmf.runtime.diagram.ui.properties.internal.l10n.DiagramUIPropertiesImages;
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.preferences.jface.preference.FontFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * An abstract implementation of a Papyrus Preference Page.
 * <p>
 * This class create the default editorFields used in a Papyrus preference page.
 * </p>
 * <ul>
 * The following editor fields are initialized :
 * <li>{@link org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor} <em>ColorFieldEditor</em></li>
 * <li>{@link org.eclipse.papyrus.preferences.jface.preference.FontFieldEditor} <em>FontFieldEditor</em></li>
 * </ul>
 * 
 * <p>
 * Sub-classes have to implement the following method:
 * <ul>
 * <li><code>getFontPreferenceName()</code> to get the preference name (identifier) to use for the font</li>
 * <li><code>getFontColorPreferenceName()</code> to get the preference name (identifier) to use for the font color</li>
 * <li><code>getLineColorPreferenceName()</code> to get the preference name (identifier) to use for the line color</li>
 * </ul>
 * </p>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusElementPreferencePage extends AbstractPapyrusPreferencePage {

	private static final String COLORS_GROUPBOX_LABEL = "Colors";

	private static final String FONT_GROUPBOX_LABEL = "Font";

	private ColorFieldEditor fontColorEditor = null;

	private ColorFieldEditor lineColorEditor = null;

	private FontFieldEditor fontFieldEditor = null;

	private Composite colorsAndFontsGroup;

	private Group toolbar;

	protected void createColorsGroup() {

		toolbar = new Group(colorsAndFontsGroup, SWT.SHADOW_NONE);
		toolbar.setText(COLORS_GROUPBOX_LABEL);
		toolbar.setLayout(new GridLayout(2, false));

		Composite fontColorEditorCompo = getEncapsulatedCompo(toolbar);
		fontColorEditor = new ColorFieldEditor(getFontColorPreferenceName(), DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FONT_COLOR), fontColorEditorCompo);
		addEditorFields(fontColorEditor);

		Composite lineColorEditorCompo = getEncapsulatedCompo(toolbar);
		lineColorEditor = new ColorFieldEditor(getLineColorPreferenceName(), DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_LINE_COLOR), lineColorEditorCompo);
		addEditorFields(lineColorEditor);

	}

	protected Composite getEncapsulatedCompo(Composite parent) {
		Composite compo = new Composite(parent, SWT.NONE);
		compo.setLayout(new GridLayout());
		return compo;
	}

	private void createFontsGroup() {
		Group fontGroup = new Group(colorsAndFontsGroup, SWT.SHADOW_NONE);
		fontGroup.setLayout(new GridLayout(1, true));
		fontGroup.setText(FONT_GROUPBOX_LABEL);
		fontFieldEditor = new FontFieldEditor(getFontPreferenceName(), fontGroup);
		addEditorFields(fontFieldEditor);
	}

	@Override
	protected void createPageContents(Composite parent) {
		colorsAndFontsGroup = new Composite(parent, SWT.NONE);
		colorsAndFontsGroup.setBounds(5, 5, 260, 50);
		GridLayout colorsAndFontsGroupLayout = new GridLayout(1, false);

		colorsAndFontsGroup.setLayout(colorsAndFontsGroupLayout);

		createFontsGroup();
		createColorsGroup();

	}

	/**
	 * Get the preference name (identifier) to use for the font
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getFontPreferenceName();

	/**
	 * Get the preference name (identifier) to use for the font color
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getFontColorPreferenceName();

	/**
	 * Get the preference name (identifier) to use for the line color
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getLineColorPreferenceName();

	protected Group getToolbar() {
		return toolbar;
	}

}
