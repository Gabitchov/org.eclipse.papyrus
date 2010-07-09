/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;

/**
 * @generated
 */
public class TimeObservationPreferencePage extends AbstractPapyrusNodePreferencePage {

	/**
	 * @generated
	 */
	public TimeObservationPreferencePage() {
		super();
		setPreferenceKey(ModelEditPart.MODEL_ID + "_TimeObservation");
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
	public static void initDefaults(IPreferenceStore store) {

		String key = ModelEditPart.MODEL_ID + "_TimeObservation";
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.WIDTH), 40);
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.HEIGHT), 40);

		// org.eclipse.jface.preference.PreferenceConverter.setDefault(store,
		// org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName,
		// org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.COLOR_FILL),
		// new org.eclipse.swt.graphics.RGB(255, 255, 255));
		// org.eclipse.jface.preference.PreferenceConverter.setDefault(store,
		// org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName,
		// org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.COLOR_LINE),
		// new org.eclipse.swt.graphics.RGB(0, 0, 0));

		// Set the default for the gradient
		// store.setDefault(org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName,
		// org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.GRADIENT_POLICY),false);
		// org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter
		// gradientPreferenceConverter = new
		// org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter(
		// new org.eclipse.swt.graphics.RGB(255, 255, 255),
		// new org.eclipse.swt.graphics.RGB(0, 0, 0), 0, 0);
		// store.setDefault(org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName,
		// org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper.COLOR_GRADIENT),
		// gradientPreferenceConverter.getPreferenceValue());

	}

}
