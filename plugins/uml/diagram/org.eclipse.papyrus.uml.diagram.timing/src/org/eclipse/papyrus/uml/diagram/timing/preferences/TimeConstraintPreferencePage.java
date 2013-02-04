/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class TimeConstraintPreferencePage extends AbstractPapyrusNodePreferencePage {

	/**
	 * @generated
	 */
	public TimeConstraintPreferencePage() {
		super();
		setPreferenceKey(TimingDiagramEditPart.MODEL_ID + "_TimeConstraint");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(final IPreferenceStore store) {

		final String key = TimingDiagramEditPart.MODEL_ID + "_TimeConstraint";
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.WIDTH), 40);
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.HEIGHT), 40);

		// org.eclipse.jface.preference.PreferenceConverter.setDefault(store,
		// org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName,
		// org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_FILL), new
		// org.eclipse.swt.graphics.RGB(255, 255, 255));
		// org.eclipse.jface.preference.PreferenceConverter.setDefault(store,
		// org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName,
		// org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_LINE), new
		// org.eclipse.swt.graphics.RGB(0, 0, 0));

		// Set the default for the gradient
		// store.setDefault(org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName,
		// org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.GRADIENT_POLICY),false);
		// org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter gradientPreferenceConverter =
		// new org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter(
		// new org.eclipse.swt.graphics.RGB(255, 255, 255),
		// new org.eclipse.swt.graphics.RGB(0, 0, 0), 0, 0);
		// store.setDefault(org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName,
		// org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_GRADIENT),
		// gradientPreferenceConverter.getPreferenceValue());

	}

}
