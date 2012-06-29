/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.widgets.editors;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorPalettePopup;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;


public class ColorPickerEditor extends AbstractValueEditor implements IChangeListener {

	protected Button colorPicker;

	protected ColorPalettePopup colorPickerPopup;

	protected RGB color;

	protected Rectangle colorBounds;

	protected Image backgroundImage;

	protected int defaultColor = 0;

	public static final Rectangle defaultColorBoundsWithoutImage = new Rectangle(0, 0, 15, 15);

	public static final Rectangle defaultColorBoundsWithImage = new Rectangle(0, 12, 16, 4);

	public ColorPickerEditor(Composite parent, int style) {
		super(parent, style);

		colorPicker = new Button(this, SWT.PUSH);
		doSetColor(0);
		colorPicker.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				ColorPalettePopup colorPickerPopup = new ColorPalettePopup(getShell(), IDialogConstants.BUTTON_BAR_HEIGHT);
				colorPickerPopup.setPreviousColor(getValue());
				Rectangle r = colorPicker.getBounds();
				Point location = colorPicker.getParent().toDisplay(r.x, r.y);
				colorPickerPopup.open(new Point(location.x, location.y + r.height));
				if(colorPickerPopup.getSelectedColor() == null && !colorPickerPopup.useDefaultColor()) {
					return;
				}
				setColor(colorPickerPopup.getSelectedColor());
				commit();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing
			}
		});
	}

	@Override
	protected void doBinding() {
		//We don't do a real databinding here
		if(modelProperty != null) {
			getParent().addDisposeListener(new DisposeListener() {

				public void widgetDisposed(DisposeEvent e) {
					ColorPickerEditor.this.dispose();
				}
			});
			modelProperty.addChangeListener(this);
			handleChange(null);
		}
	}

	@Override
	public void dispose() {
		if(modelProperty != null) {
			modelProperty.removeChangeListener(this);
		}
		super.dispose();
	}

	/** Sets the color & updates the ModelProperty */
	private void setColor(RGB color) {
		int colorValue = color == null ? defaultColor : FigureUtilities.RGBToInteger(color);

		doSetColor(colorValue);

		if(modelProperty != null) {
			modelProperty.setValue(colorValue);
		}
	}

	/** Updates the color without updating the ModelProperty */
	private void doSetColor(int color) {
		this.color = FigureUtilities.integerToRGB(color);
		updateButton();
	}

	/**
	 * Sets the image for a color button (square filled with the color that button represents)
	 * 
	 * @see GradientFieldEditor#setButtonImage(RGB)
	 */
	private void updateButton() {
		// First, dispose the current image, if any
		Image image = colorPicker.getImage();
		if(image != null) {
			image.dispose();
		}

		Display display = colorPicker.getDisplay();
		// Now set the new image based on rgbColor
		Color color = new Color(display, this.color);

		//TODO : Find a way to instantiate a transparent image (Instead of a default-white one)
		image = backgroundImage == null ? new Image(display, 16, 16) : new Image(display, backgroundImage.getBounds());

		GC gc = new GC(image);
		gc.fillRectangle(image.getBounds());

		gc.setBackground(colorPicker.getBackground());
		gc.fillRectangle(image.getBounds());

		gc.setBackground(color);
		gc.setForeground(color);

		if(backgroundImage != null) {
			gc.fillRectangle(defaultColorBoundsWithImage);
			gc.drawImage(backgroundImage, 0, 0);
		} else {
			gc.fillRectangle(defaultColorBoundsWithoutImage);
			gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
			gc.drawRectangle(defaultColorBoundsWithoutImage);
		}

		gc.dispose();
		color.dispose();
		colorPicker.setImage(image);
	}

	public void setImage(Image image) {
		this.backgroundImage = image;
	}

	public void setColorBounds(Rectangle rectangle) {
		this.colorBounds = rectangle;
	}

	@Override
	public Integer getValue() {
		if(color == null) {
			return defaultColor;
		}

		return FigureUtilities.RGBToInteger(color);
	}

	@Override
	public Object getEditableType() {
		return Integer.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		colorPicker.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !colorPicker.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		setLabelToolTipText(text);
	}

	public void handleChange(ChangeEvent event) {
		if(modelProperty != null) {
			Integer value = (Integer)modelProperty.getValue();
			if(value == null) {
				value = 0;
			}

			doSetColor(value);
		}
	}

	@Override
	public void refreshValue() {
		handleChange(null);
	}

	/**
	 * Sets the default color for this Editor. The default color
	 * will be set when the "Default" button is pressed.
	 * 
	 * @param color
	 *        The default color for this editor
	 */
	public void setDefaultColor(int color) {
		this.defaultColor = color;
	}

}
