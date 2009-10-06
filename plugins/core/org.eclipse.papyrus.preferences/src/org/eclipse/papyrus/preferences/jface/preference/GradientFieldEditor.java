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

import org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorPalettePopup;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Spinner;

/**
 * A field editor for gradient Preferences. This field editor handles :
 * <ul>
 * <li>Gradient color1</li>
 * <li>Gradient transparency. The value must be contained in [0,100]</li>
 * <li>Gradient style. The value is GradientStyle.HORIZONTAL or GradientStyle.VERTICAL</li>
 * </ul>
 * The second color of the gradient is set by default at RGB{255,255,255}
 * 
 * @author tlandre
 */
public class GradientFieldEditor extends FieldEditor {

	private Button colorButton;

	private Button verticalStyleButton;

	private Button horizontalStyleButton;

	private Spinner transparencyValueSpinner;

	private RGB color1 = new RGB(0, 0, 0);

	private RGB color2 = new RGB(255, 255, 255);

	private int transparency = 0;

	private int style = GradientStyle.HORIZONTAL;

	public GradientFieldEditor(String gradientPreferenceName, Composite parent) {
		super(gradientPreferenceName, "", parent); //$NON-NLS-1$
	}

	@Override
	protected void adjustForNumColumns(int arg0) {

	}

	@Override
	public void load() {
		super.load();
		setButtonImage(color1);
		transparencyValueSpinner.setSelection(transparency);
		if (style == GradientStyle.HORIZONTAL) {
			horizontalStyleButton.setSelection(true);
		} else if (style == GradientStyle.VERTICAL) {
			verticalStyleButton.setSelection(true);
		}
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {

		Composite gradientComposite = new Composite(parent, SWT.NULL);
		gradientComposite.setLayout(new GridLayout(2, false));

		Label colorLabel = new Label(gradientComposite, SWT.NULL);
		colorLabel.setText(Messages.GradientFieldEditor_Color);

		colorButton = new Button(gradientComposite, SWT.PUSH);
		colorButton.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				color1 = changeColor();
			}
		});

		Label styleLabel = new Label(gradientComposite, SWT.NULL);
		styleLabel.setText(Messages.GradientFieldEditor_Style);

		Composite styleComposite = new Composite(gradientComposite, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginWidth = 0;
		styleComposite.setLayout(gl);
		verticalStyleButton = new Button(styleComposite, SWT.RADIO);
		verticalStyleButton.setText(Messages.GradientFieldEditor_Vertical);
		horizontalStyleButton = new Button(styleComposite, SWT.RADIO);
		horizontalStyleButton.setText(Messages.GradientFieldEditor_Horizontal);
		

		SelectionListener selectionListener = new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!((Button) e.widget).getSelection()) {
					// don't react on de-selection
					return;
				}
				if (verticalStyleButton.getSelection()) {
					style = GradientStyle.VERTICAL;
				} else {
					style = GradientStyle.HORIZONTAL;
				}

			}
		};
		horizontalStyleButton.addSelectionListener(selectionListener);
		verticalStyleButton.addSelectionListener(selectionListener);

		Label transparencyLabel = new Label(gradientComposite, SWT.NULL);
		transparencyLabel.setText(Messages.GradientFieldEditor_Transparency);

		// Create the Spinner
		transparencyValueSpinner = new Spinner(gradientComposite, SWT.BORDER);
		transparencyValueSpinner.setMinimum(0);
		transparencyValueSpinner.setMaximum(100);
		transparencyValueSpinner.setIncrement(1);

		transparencyValueSpinner.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				transparency = transparencyValueSpinner.getSelection();
			}
		});
	}

	@Override
	protected void doLoad() {
		String preferenceValue = getPreferenceStore().getString(getPreferenceName());
		loadGradientValues(preferenceValue);

	}

	private void loadGradientValues(String preferenceValue) {
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceValue);
		color1 = gradientPreferenceConverter.getColor1();
		style = gradientPreferenceConverter.getStyle();
		transparency = gradientPreferenceConverter.getTransparency();
	}

	@Override
	protected void doLoadDefault() {
		String preferenceValue = getPreferenceStore().getDefaultString(getPreferenceName());
		loadGradientValues(preferenceValue);
	}

	@Override
	protected void doStore() {
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(color1, color2,
				style, transparency);
		getPreferenceStore().setValue(getPreferenceName(), gradientPreferenceConverter.getPreferenceValue());
	}

	@Override
	public int getNumberOfControls() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#dispose
	 * ()
	 */
	@Override
	public void dispose() {
		disposeButtonImage();
		super.dispose();
	}

	/**
	 * Dispose the image associated with the given button
	 * 
	 * @param btn
	 *            the button that contains the image
	 */
	protected void disposeButtonImage() {
		if (colorButton != null && !colorButton.isDisposed()) {
			Image imageColor1 = colorButton.getImage();
			if (imageColor1 != null && !imageColor1.isDisposed()) {
				imageColor1.dispose();
			}
		}
	}

	/**
	 * Sets the image for a color button (square filled with the color that button represents)
	 */
	protected void setButtonImage(RGB rgb) {
		// First, dispose the current image, if any
		Image image = colorButton.getImage();
		if (image != null) {
			image.dispose();
		}

		Display display = colorButton.getParent().getShell().getDisplay();
		// Now set the new image based on rgbColor
		Color color = new Color(display, rgb);
		image = new Image(display, 16, 16);
		GC gc = new GC(image);
		gc.setBackground(color);
		Rectangle rect = image.getBounds();
		gc.fillRectangle(rect);
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
		gc.drawRectangle(rect.x, rect.y, rect.width - 1, rect.height - 1);
		gc.dispose();
		color.dispose();
		colorButton.setImage(image);
	}

	/**
	 * Allow user to change the color of the given button.
	 * 
	 * @param button
	 *            the button
	 * @return the selected color or null
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorPalettePopup
	 */
	private RGB changeColor() {
		ColorPalettePopup popup = new ColorPalettePopup(colorButton.getParent().getShell(),
				IDialogConstants.BUTTON_BAR_HEIGHT);
		Rectangle r = colorButton.getBounds();
		Point location = colorButton.getParent().toDisplay(r.x, r.y);
		popup.open(new Point(location.x, location.y + r.height));
		if (popup.getSelectedColor() == null && !popup.useDefaultColor()) {
			return null;
		}
		RGB rgb = popup.getSelectedColor();
		setButtonImage(rgb);
		return rgb;
	}

}
