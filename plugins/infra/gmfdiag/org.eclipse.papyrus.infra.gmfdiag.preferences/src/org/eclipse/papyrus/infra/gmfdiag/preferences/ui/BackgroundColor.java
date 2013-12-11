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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Messages;
import org.eclipse.papyrus.infra.gmfdiag.preferences.jface.preference.GradientFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * The Class BackgroundColorGroup is group that contains all editor to manage the gradient and associated color background
 */
public class BackgroundColor extends AbstractGroup {

	/**
	 * Instantiates a new background color group.
	 * 
	 * @param parent
	 *        the parent of the composite
	 * @param key
	 *        the key of the preference
	 * @param dialogPage
	 *        to set the page in field editor
	 **/
	public BackgroundColor(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
		createContent(parent);
	}

	/** The use gradient fill editor. */
	private BooleanFieldEditor useGradientFillEditor;

	/** The gradient fill editor. */
	private GradientFieldEditor gradientFillEditor;

	/** The title. */

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *        the parent
	 */
	public void createContent(Composite parent) {

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
		useGradientFillEditor = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.GRADIENT_POLICY), "", useGradientFillEditorCompo); //$NON-NLS-1$
		useGradientFillEditor.setPage(dialogPage);

		addFieldEditor(useGradientFillEditor);

		Composite gradientFillEditorCompo = getEncapsulatedCompo(fillColorGroup);
		gradientFillEditor = new GradientFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.COLOR_GRADIENT), gradientFillEditorCompo);
		gradientFillEditor.setPage(dialogPage);
		gradientFillEditor.setEnabled(useGradientFillEditor.getBooleanValue());

		addFieldEditor(gradientFillEditor);
		useGradientFillEditor.setPropertyChangeListener(new IPropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent event) {

				gradientFillEditor.setEnabled(useGradientFillEditor.getBooleanValue());


			}
		});
	}

	@Override
	public void load() {
		super.load();
		gradientFillEditor.setEnabled(useGradientFillEditor.getBooleanValue());
	}
}
