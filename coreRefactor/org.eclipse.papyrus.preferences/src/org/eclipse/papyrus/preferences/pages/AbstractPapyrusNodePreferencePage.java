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
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.preferences.jface.preference.GradientFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * An abstract implementation of a basic node preference page.
 * <p>
 * This Preference page adds the preference for
 * {@link org.eclipse.gmf.runtime.notation.FillStyle#getFillColor() <em>FillColor</em>}
 * </p>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusNodePreferencePage extends AbstractPapyrusElementPreferencePage {

	private ColorFieldEditor fillColorEditor = null;

	private GradientFieldEditor gradientFillEditor = null;

	private BooleanFieldEditor useGradientFillEditor = null;

	@Override
	protected void createColorsGroup() {
		super.createColorsGroup();

		GridLayout gdLayout = (GridLayout) getToolbar().getLayout();
		gdLayout.numColumns = 3;

		Group fillColorEditorGroup = new Group(getToolbar(), SWT.SHADOW_NONE);
		fillColorEditorGroup.setLayout(new GridLayout(1, false));
		fillColorEditorGroup.setText("Fill : ");

		Composite compo = new Composite(fillColorEditorGroup, SWT.NONE);
		compo.setLayout(new GridLayout(2, false));

		Composite fillColorEditorCompo = getEncapsulatedCompo(compo);
		fillColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferenceConstantHelper.COLOR_FILL),
				DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FILL_COLOR), fillColorEditorCompo);
		addEditorFields(fillColorEditor);

		Composite gradientFillEditorCompo = getEncapsulatedCompo(compo);
		gradientFillEditor = new GradientFieldEditor(getPreferenceConstant(PreferenceConstantHelper.COLOR_GRADIENT),
				gradientFillEditorCompo);
		addEditorFields(gradientFillEditor);

		Composite useGradientFillEditorCompo = getEncapsulatedCompo(fillColorEditorGroup);
		useGradientFillEditor = new BooleanFieldEditor(getPreferenceConstant(PreferenceConstantHelper.GRADIENT_POLICY),
				"use Gradient", useGradientFillEditorCompo);

		addEditorFields(useGradientFillEditor);
	}
}
