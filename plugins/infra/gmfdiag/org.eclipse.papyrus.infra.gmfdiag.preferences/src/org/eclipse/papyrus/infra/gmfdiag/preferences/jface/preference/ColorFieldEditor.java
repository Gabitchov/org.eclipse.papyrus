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
package org.eclipse.papyrus.infra.gmfdiag.preferences.jface.preference;

import org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorPalettePopup;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * A field editor that display a button and a small rectangle under it to show the color selected.
 * 
 * This field editor is inspired by the class {@link org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorsAndFontsPropertySection
 * <em>ColorsAndFontsPropertySection</em>}
 * 
 * @author tlandre
 */

public class ColorFieldEditor extends FieldEditor {

	private Image buttonImage;

	private Image backgroundImage;

	private ColorPalettePopup colorSelector;

	private Button colorButton;

	/**
	 * Default constructor
	 * 
	 * @param name
	 *        the preference name to use
	 * @param image
	 *        the image to display
	 * @param parent
	 *        the parent composite
	 */
	public ColorFieldEditor(String name, Image image, Composite parent) {
		super(name, "", parent); // $NON-NLS-1$
		backgroundImage = image;
	}

	@Override
	public void load() {
		super.load();

		buttonImage = new ColorOverlayImageDescriptor(backgroundImage.getImageData(), PreferenceConverter.getColor(getPreferenceStore(), getPreferenceName())).createImage();
		colorButton.setImage(buttonImage);
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		colorButton = new Button(parent, SWT.PUSH);
		colorButton.setLayoutData(new GridData());
		colorButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				changeColors(colorButton);
			}
		});

	}

	@Override
	protected void doLoad() {
		doLoadColor(PreferenceConverter.getColor(getPreferenceStore(), getPreferenceName()));
	}

	@Override
	protected void doLoadDefault() {
		doLoadColor(PreferenceConverter.getDefaultColor(getPreferenceStore(), getPreferenceName()));

	}

	private void doLoadColor(RGB rgb) {
		updateButtonImage(rgb);
		if(colorSelector != null) {
			colorSelector.setPreviousColor(FigureUtilities.RGBToInteger(rgb));
		}

	}

	@Override
	protected void doStore() {
		if(colorSelector != null) {
			RGB color = colorSelector.getSelectedColor();
			if(color == null) {
				color = getDefaultColor();
			}
			PreferenceConverter.setValue(getPreferenceStore(), getPreferenceName(), color);
		}
	}

	private RGB getDefaultColor() {
		return PreferenceConverter.getDefaultColor(getPreferenceStore(), getPreferenceName());
	}

	@Override
	public int getNumberOfControls() {
		return 1;
	}

	private void changeColors(Button button) {

		colorSelector = new ColorPalettePopup(colorButton.getParent().getShell(), IDialogConstants.BUTTON_BAR_HEIGHT);

		Rectangle r = button.getBounds();
		Point location = button.getParent().toDisplay(r.x, r.y);
		colorSelector.open(location);

		if(colorSelector.getSelectedColor() == null && !colorSelector.useDefaultColor()) {
			return;
		}

		if(colorSelector.useDefaultColor()) {
			updateButtonImage(getDefaultColor());
		} else {
			updateButtonImage(colorSelector.getSelectedColor());
		}

	}

	private void updateButtonImage(RGB rgb) {
		if(!colorButton.isDisposed() && colorButton.getImage() != null && !colorButton.getImage().isDisposed()) {
			colorButton.getImage().dispose();
			Image overlyedImage = new ColorOverlayImageDescriptor(backgroundImage.getImageData(), rgb).createImage();
			colorButton.setImage(overlyedImage);
		}
	}

	protected static class ColorOverlayImageDescriptor extends CompositeImageDescriptor {

		/** default color icon width */
		private static final Point ICON_SIZE = new Point(16, 16);

		/** the basic icon */
		private ImageData basicImgData;

		/** the color of the thin color bar */
		private RGB rgb;

		/**
		 * Creates a new color menu image descriptor
		 * 
		 * @param basicImgData
		 *        The basic Image data
		 * @param rgb
		 *        The color bar RGB value
		 */
		public ColorOverlayImageDescriptor(ImageData basicImgData, RGB rgb) {
			this.basicImgData = basicImgData;
			this.rgb = rgb;
		}

		/**
		 * @see org.eclipse.jface.resource.CompositeImageDescriptor#drawCompositeImage(int, int)
		 */
		@Override
		protected void drawCompositeImage(int width, int height) {

			// draw the thin color bar underneath
			if(rgb != null) {
				ImageData colorBar = new ImageData(width, height / 5, 1,

				new PaletteData(new RGB[]{ rgb }));
				drawImage(colorBar, 0, height - height / 5);

			}
			// draw the base image
			drawImage(basicImgData, 0, 0);
		}

		/**
		 * @see org.eclipse.jface.resource.CompositeImageDescriptor#getSize()
		 */
		@Override
		protected Point getSize() {
			return ICON_SIZE;
		}
	}
}
