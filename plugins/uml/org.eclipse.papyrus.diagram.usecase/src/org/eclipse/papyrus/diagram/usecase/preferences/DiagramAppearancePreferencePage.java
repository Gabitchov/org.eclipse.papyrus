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

import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;

/**
 * @generated NOT
 */
public class DiagramAppearancePreferencePage extends AbstractPapyrusNodePreferencePage {

	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.getInstance().ID;
	}

	@Override
	protected String getFillColorPreferenceName() {
		return IPreferenceConstants.PREF_FILL_COLOR;
	}

	@Override
	protected String getFontColorPreferenceName() {
		return IPreferenceConstants.PREF_FONT_COLOR;
	}

	@Override
	protected String getFontPreferenceName() {
		return IPreferenceConstants.PREF_DEFAULT_FONT;
	}

	@Override
	protected String getLineColorPreferenceName() {
		return IPreferenceConstants.PREF_LINE_COLOR;
	}

	public static void initDefaults(IPreferenceStore store) {
		// TODO Auto-generated method stub
	}
}
