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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr 
 *  Thibault Landre (Atos Origin) 
 *****************************************************************************/
package org.eclipse.papyrus.preferences.ui;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.jface.preference.FontFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The Class FontGroupComposite contains a field to manage preference to display a text in a label 
 */
public class FontGroup extends AbstractGroup {

	/** The FONT Group label **/
	protected final String FONT_GROUPBOX_LABEL = Messages.AbstractPapyrusElementPreferencePage_Font;

	/** The font field editor. */
	protected FontFieldEditor fontFieldEditor;

	/**
	 * Instantiates a new font group composite.
	 * 
	 * @param parent
	 *            the parent of the composite
	 * @param String
	 *            the title of the page
	 * @param dialogPage
	 *            to set the page in field editor
	 **/    
	public FontGroup(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *            the parent
	 */
	protected void createContent(Composite parent) {
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

	public void load() {
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
