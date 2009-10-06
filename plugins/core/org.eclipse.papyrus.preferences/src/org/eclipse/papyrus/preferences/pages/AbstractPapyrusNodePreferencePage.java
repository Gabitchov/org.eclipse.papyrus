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
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.preferences.jface.preference.GradientFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;

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
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		createBackgroundColorGroup(parent);
	}

	@Override
	protected void createColorsGroup() {
		super.createColorsGroup();
		Composite fillColorEditorCompo = getEncapsulatedCompo(getToolbar());
		fillColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferenceConstantHelper.COLOR_FILL),
				DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FILL_COLOR), fillColorEditorCompo);
		addEditorFields(fillColorEditor);
	}

	@Override
	protected Layout getToolbarLayout() {
		return new GridLayout(3, false);
	}

	private void createBackgroundColorGroup(Composite parent) {
		Group fillColorGroup = new Group(parent, SWT.SHADOW_NONE);
		fillColorGroup.setLayout(new GridLayout(1, false));
		fillColorGroup.setText(Messages.AbstractPapyrusNodePreferencePage_Gradient);

		Composite useGradientCompo = new Composite(fillColorGroup, SWT.NULL);
		GridLayout gl = new GridLayout(2, false);
		gl.marginHeight = 0;
		useGradientCompo.setLayout(gl);
		

		Label useGradientLabel = new Label(useGradientCompo, SWT.NULL);
		useGradientLabel.setText(Messages.AbstractPapyrusNodePreferencePage_Activate);
		Composite useGradientFillEditorCompo = getEncapsulatedCompo(useGradientCompo);
		useGradientFillEditor = new BooleanFieldEditor(getPreferenceConstant(PreferenceConstantHelper.GRADIENT_POLICY),
				"", useGradientFillEditorCompo); //$NON-NLS-1$

		addEditorFields(useGradientFillEditor);

		Composite gradientFillEditorCompo = getEncapsulatedCompo(fillColorGroup);
		gradientFillEditor = new GradientFieldEditor(getPreferenceConstant(PreferenceConstantHelper.COLOR_GRADIENT),
				gradientFillEditorCompo);
		addEditorFields(gradientFillEditor);
	}

}
