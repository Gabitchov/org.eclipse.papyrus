/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.preferences.ui;

import javax.swing.text.StyleConstants.ColorConstants;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.jface.preference.FontFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;


// TODO: Auto-generated Javadoc
/**
 * The Class FontGroupComposite.
 */
public class FontGroupComposite extends AbstractGroupComposite {

	/** The FON t_ groupbo x_ label. */
	protected String FONT_GROUPBOX_LABEL = null;



	/**
	 * Gets the font field editor.
	 * 
	 * @return the fontFieldEditor
	 */
	protected FontFieldEditor getFontFieldEditor() {
		return fontFieldEditor;
	}


	/**
	 * Sets the font field editor.
	 * 
	 * @param fontFieldEditor the fontFieldEditor to set
	 */
	protected void setFontFieldEditor(FontFieldEditor fontFieldEditor) {
		this.fontFieldEditor = fontFieldEditor;
	}


	/**
	 * Gets the font group box label.
	 * 
	 * @return the fONT_GROUPBOX_LABEL
	 */
	protected String getFontGroupBoxLabel() {
		return FONT_GROUPBOX_LABEL;
	}

	/**
	 * Sets the font group box label.
	 * 
	 * @param fontGroupLabel the font group label
	 * 
	 * @return the fONT_GROUPBOX_LABEL
	 */
	protected void setFontGroupBoxLabel(String fontGroupLabel) {
		this.FONT_GROUPBOX_LABEL=fontGroupLabel;
	}

	/** The font field editor. */
	protected FontFieldEditor fontFieldEditor;

	/**
	 * Instantiates a new font group composite.
	 * 
	 * @param parent the parent
	 * @param style the style
	 * @param fontGroupLabel the font group label
	 * @param title the title
	 */
	public FontGroupComposite(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
		setFontGroupBoxLabel(Messages.AbstractPapyrusElementPreferencePage_Font);
		createContent(parent);
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent the parent
	 */
	protected void  createContent(Composite parent){
		Group fontGroup = new Group(parent, SWT.SHADOW_NONE);
		fontGroup.setLayout(new GridLayout(1, true));
		fontGroup.setText(FONT_GROUPBOX_LABEL);
		fontFieldEditor = new FontFieldEditor(PreferenceConstantHelper.getElementConstant(getTitle(),
				PreferenceConstantHelper.FONT), fontGroup);
	}
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		super.setPreferenceStore(preferenceStore);
		fontFieldEditor.setPreferenceStore(preferenceStore);
	}

	public void load(){
		fontFieldEditor.load();
	}

	public void storePreferences() {
		fontFieldEditor.store();
	}


	@Override
	public void loadDefault() {
		fontFieldEditor.loadDefault();
	}
}
