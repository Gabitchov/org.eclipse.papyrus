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
package org.eclipse.papyrus.diagram.clazz.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;

/**
 * @generated
 */
public class CommentPreferencePage extends AbstractPapyrusNodePreferencePage {

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
		PreferenceConverter.setDefault(store,
				IPapyrusPreferencesConstant.COMMENT_PREF_FILL_COLOR,
				new org.eclipse.swt.graphics.RGB(255, 255, 255));
		PreferenceConverter.setDefault(store,
				IPapyrusPreferencesConstant.COMMENT_PREF_LINE_COLOR,
				new org.eclipse.swt.graphics.RGB(177, 207, 229));

		// Set the default for the gradient
		store.setDefault(
				IPapyrusPreferencesConstant.COMMENT_PREF_GRADIENT_POLICY, true);
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(
				new org.eclipse.swt.graphics.RGB(255, 255, 255),
				new org.eclipse.swt.graphics.RGB(177, 207, 229), 0, 0);
		store.setDefault(
				IPapyrusPreferencesConstant.COMMENT_PREF_GRADIENT_COLOR,
				gradientPreferenceConverter.getPreferenceValue());

	}

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
		return IPapyrusPreferencesConstant.COMMENT_PREF_FILL_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFillPolicyPreferenceName() {
		return IPapyrusPreferencesConstant.COMMENT_PREF_GRADIENT_POLICY;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontColorPreferenceName() {
		return IPapyrusPreferencesConstant.COMMENT_PREF_FONT_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontPreferenceName() {
		return IPapyrusPreferencesConstant.COMMENT_PREF_FONT;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getGradientColorPreferenceName() {
		return IPapyrusPreferencesConstant.COMMENT_PREF_GRADIENT_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getLineColorPreferenceName() {
		return IPapyrusPreferencesConstant.COMMENT_PREF_LINE_COLOR;
	}

}
