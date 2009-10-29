/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.preferences;

import org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage;
import org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public abstract class IconStylePreferencePage extends AbstractPreferencePage {

	@Override
	protected void addFields(Composite parent) {
		Composite main = new Composite(parent, SWT.NULL);
		main.setLayout(new GridLayout());
		main.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		createIconStyleGroup(main);
	}

	protected void createIconStyleGroup(Composite parent) {
		String[][] choices = new String[][] {
				{ ALTERNATIVE_STYLE_ICON_LABEL, UMLPreferencesConstants.PREF_ICON_STYLE_CHEERFUL },
				{ ECLIPSE_STYLE_ICON_LABEL, UMLPreferencesConstants.PREF_ICON_STYLE_STANDARD } };
		myIconStyleFieldEditor = new RadioGroupFieldEditor(UMLPreferencesConstants.PREF_ICON_STYLE,
				ICONSTYLE_GROUPBOX_LABEL, 1, choices, parent, true);
		addField(myIconStyleFieldEditor);
	}

	// @unused
	public static void initDefaults(IPreferenceStore store) {
		AppearancePreferencePage.initDefaults(store);
		store.setDefault(UMLPreferencesConstants.PREF_ICON_STYLE, UMLPreferencesConstants.PREF_ICON_STYLE_STANDARD);
	}

	private static final String ICONSTYLE_GROUPBOX_LABEL = Messages.IconStylePreferencePage_icon_style_group;

	private static final String ALTERNATIVE_STYLE_ICON_LABEL = Messages.IconStylePreferencePage_cheerful_style;

	private static final String ECLIPSE_STYLE_ICON_LABEL = Messages.IconStylePreferencePage_eclipse_style;

	private RadioGroupFieldEditor myIconStyleFieldEditor;

}
