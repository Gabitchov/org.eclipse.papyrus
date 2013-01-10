/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.AbstractImageFigure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Display;

public class VerticalLabel extends AbstractImageFigure {

	private Image img;

	private String myText;

	private Font myImageFont;

	private Color myForegroundColor;

	private Color myBackgroundColor;

	@Override
	protected void paintFigure(final Graphics g) {
		final Image image = getImage();
		if(image != null) {
			g.drawImage(image, this.bounds.x, this.bounds.y);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void addNotify() {
		updateImage();
		super.addNotify();
	}

	/** {@inheritDoc} */
	@Override
	public void removeNotify() {
		if(this.img != null) {
			this.img.dispose();
			this.img = null;
		}
		super.removeNotify();
	}

	/** {@inheritDoc} */
	public Image getImage() {
		boolean update = false;
		if(this.myImageFont != getFont()) {
			this.myImageFont = getFont();
			update = true;
		}
		if(needsUpdate(this.myForegroundColor, getForegroundColor())) {
			this.myForegroundColor = getForegroundColor();
			update = true;
		}
		if(needsUpdate(this.myBackgroundColor, getBackgroundColor())) {
			this.myBackgroundColor = getBackgroundColor();
			update = true;
		}

		if(update) {
			updateImage();
		}
		return this.img;
	}

	/**
	 * Updates the image with the string provided.
	 * 
	 * @param text
	 *        to display
	 */
	public void setText(final String text) {
		this.myText = text;
		updateImage();
	}

	public String getText() {
		return this.myText;
	}

	/**
	 * Redraws / creates the image of the rotated String.
	 * 
	 * @return image created
	 */
	public void updateImage() {
		if(this.img != null) {
			this.img.dispose();
			this.img = null;
		}
		if(getText() == null || getFont() == null) {
			return;
		}
		setImage(createRotatedImageOfString(getText(), getFont(), getForegroundColor(), getBackgroundColor(), isOpaque()));
	}

	private void setImage(final Image image) {
		if(this.img == image) {
			return;
		}
		this.img = image;
		revalidate();
		notifyImageChanged();
		repaint();
	}

	public static Image createRotatedImageOfString(final String string, final Font font, final Color foreground, final Color background, final boolean opaque) {
		final Display display = Display.getDefault();

		final FontMetrics metrics = FigureUtilities.getFontMetrics(font);
		final Dimension strSize = FigureUtilities.getStringExtents(string, font);

		final int height = strSize.width;
		final int width = metrics.getAscent() + metrics.getDescent() + metrics.getLeading();

		final ImageData data = new ImageData(width, height, 32, new PaletteData(0x0000ff00, 0x00ff0000, 0xff000000));
		if(!opaque) {
			data.transparentPixel = data.palette.getPixel(background.getRGB());
		}

		final Image image = new Image(display, data);
		final GC gc = new GC(image);
		gc.setFont(font);
		gc.setBackground(background);
		gc.fillRectangle(image.getBounds());
		gc.setForeground(foreground);
		final Transform transform = new Transform(Display.getCurrent());
		transform.translate(0, height);
		transform.rotate(-90);
		gc.setTransform(transform);
		gc.drawString(string, 0, 0, true);
		gc.dispose();
		return image;
	}

	private static final boolean needsUpdate(final Color cachedColor, final Color actualColor) {
		if(cachedColor == null && actualColor == null) {
			return false;
		}
		return cachedColor == null || !cachedColor.equals(actualColor);
	}

	@Override
	public Dimension getPreferredSize(final int wHint, final int hHint) {
		if(this.img != null) {
			return new Rectangle(this.img.getBounds()).getSize();
		}
		return super.getPreferredSize(wHint, hHint);
	}
}
