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
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Messages;
import org.eclipse.papyrus.infra.gmfdiag.preferences.jface.preference.FontFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The Class FontGroupComposite contains a field to manage preference to display a text in a label
 */
public class FontGroup extends AbstractGroup {

	/** The FONT Group label **/
	private static final String FONT_GROUPBOX_LABEL = Messages.AbstractPapyrusElementPreferencePage_Font;

	/** The font field editor. */
	protected FontFieldEditor fontFieldEditor;

	/**
	 * Instantiates a new font group composite.
	 * 
	 * @param parent
	 *        the parent of the composite
	 * @param key
	 *        the key of the preference
	 * @param dialogPage
	 *        to set the page in field editor
	 **/
	public FontGroup(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
		System.out.println("FONT key = " + key);
		createContent(parent);
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *        the parent
	 */
	protected void createContent(Composite parent) {
		Group fontGroup = new Group(parent, SWT.SHADOW_NONE);
		fontGroup.setLayout(new GridLayout(1, true));
		fontGroup.setText(FONT_GROUPBOX_LABEL);
		fontFieldEditor = new FontFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.FONT), fontGroup);

		addFieldEditor(fontFieldEditor);
	}

}
