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
package org.eclipse.papyrus.diagram.usecase.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;

/**
 * @generated
 */
public class Actor_2002PreferencePage extends AbstractPapyrusNodePreferencePage {

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.getInstance().ID;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFillColorPreferenceName() {
		return IPapyrusPreferencesConstant.ACTOR_2002_PREF_FILL_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontColorPreferenceName() {
		return IPapyrusPreferencesConstant.ACTOR_2002_PREF_FONT_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontPreferenceName() {
		return IPapyrusPreferencesConstant.ACTOR_2002_PREF_FONT;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getLineColorPreferenceName() {
		return IPapyrusPreferencesConstant.ACTOR_2002_PREF_LINE_COLOR;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
		PreferenceConverter.setDefault(store,
				IPapyrusPreferencesConstant.ACTOR_2002_PREF_FILL_COLOR,
				new org.eclipse.swt.graphics.RGB(255, 255, 255));
		PreferenceConverter.setDefault(store,
				IPapyrusPreferencesConstant.ACTOR_2002_PREF_LINE_COLOR,
				new org.eclipse.swt.graphics.RGB(177, 207, 229));

	}

}
