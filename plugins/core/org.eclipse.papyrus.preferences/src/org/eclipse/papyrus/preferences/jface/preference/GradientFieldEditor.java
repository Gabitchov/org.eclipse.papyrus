/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.preferences.jface.preference;

import org.eclipse.gmf.runtime.common.ui.dialogs.GradientSelectionDialog;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.papyrus.preferences.jface.preference.dialogs.GradientTransparencySelectionDialog;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A field editor for gradient Preferences. This field editor handles : 
 * <ul>
 * <li>Gradient color1</li>
 * <li>Gradient color2</li>
 * <li>Gradient transparency. The value must be contained in [0,100]</li>
 * <li>Gradient style. The value is GradientStyle.HORIZONTAL or GradientStyle.VERTICAL</li>
 * </ul>
 * @author tlandre
 */
public class GradientFieldEditor extends FieldEditor {

	private Button gradientButton;

	private boolean selectionDialogAlreadyOpened = false;

	private GradientSelectionDialog selectionDialog;

	private RGB color1 = new RGB(0, 0, 0);

	private RGB color2 = new RGB(255, 255, 255);

	private int transparency = 0;

	private int style = GradientStyle.HORIZONTAL;

	public GradientFieldEditor(String name, Composite parent) {
		super(name, "", parent);
	}

	@Override
	protected void adjustForNumColumns(int arg0) {

	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		gradientButton = new Button(parent, SWT.PUSH);
		gradientButton.setSize(16, 16);
		gradientButton.setLayoutData(new GridData());
		gradientButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!selectionDialogAlreadyOpened) {
					selectionDialogAlreadyOpened = true;
					changeGradient(gradientButton);
					selectionDialogAlreadyOpened = false;
				}
			}

		});

	}

	private void changeGradient(Button gradientButton) {
		selectionDialog = new GradientTransparencySelectionDialog(
				gradientButton.getParent().getShell(), 0, color1, color2,
				style, transparency);
		Rectangle r = gradientButton.getBounds();
		Point location = gradientButton.getParent().toDisplay(r.x, r.y);
		if (selectionDialog.open(location) == SWT.OK) {
			color1 = selectionDialog.getGradientColor1();
			color2 = selectionDialog.getGradientColor2();
			style = selectionDialog.getGradientStyle();
			transparency = selectionDialog.getTransparency();
		}
	}

	@Override
	protected void doLoad() {
		String preferenceValue = getPreferenceStore().getString(
				getPreferenceName());
		loadGradientValues(preferenceValue);

	}

	private void loadGradientValues(String preferenceValue) {
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(
				preferenceValue);
		color1 = gradientPreferenceConverter.getColor1();
		color2 = gradientPreferenceConverter.getColor2();
		style = gradientPreferenceConverter.getStyle();
		transparency = gradientPreferenceConverter.getTransparency();

	}

	@Override
	protected void doLoadDefault() {
		String preferenceValue = getPreferenceStore().getDefaultString(
				getPreferenceName());
		loadGradientValues(preferenceValue);
	}

	@Override
	protected void doStore() {
		if (selectionDialog != null) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(
					color1, color2, style, transparency);
			getPreferenceStore().setValue(getPreferenceName(),
					gradientPreferenceConverter.getPreferenceValue());
		}

	}

	@Override
	public int getNumberOfControls() {
		return 1;
	}

}
