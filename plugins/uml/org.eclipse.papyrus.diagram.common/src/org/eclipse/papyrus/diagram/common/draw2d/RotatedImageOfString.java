/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.ImageUtilities;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

public class RotatedImageOfString extends ImageFigure {

	public void setText(String text) {
		this.text = text;
		updateImage();
	}

	public String getText() {
		return this.text;
	}

	@Override
	public void addNotify() {
		updateImage();
		super.addNotify();
	}

	@Override
	public void removeNotify() {
		if (super.getImage() != null) {
			super.getImage().dispose();
		}
		super.removeNotify();
	}

	@Override
	public Image getImage() {
		boolean update = false;
		if (imageFont != getFont()) {
			imageFont = getFont();
			update = true;
		}
		if (foregroundColor == null && getForegroundColor() != null || !foregroundColor.equals(getForegroundColor())) {
			foregroundColor = getForegroundColor();
			update = true;
		}
		if (backgroundColor == null && getBackgroundColor() != null || !backgroundColor.equals(getBackgroundColor())) {
			backgroundColor = getBackgroundColor();
			update = true;
		}

		if (update) {
			return updateImage();
		}
		return super.getImage();
	}

	private Image updateImage() {
		if (super.getImage() != null) {
			super.getImage().dispose();
		}
		if (text == null) {
			return null;
		}
		Image image = ImageUtilities.createRotatedImageOfString(text, getFont(), getForegroundColor(),
				getBackgroundColor());
		super.setImage(image);
		return image;
	}

	private String text;

	private Font imageFont = null;

	private Color foregroundColor = null;

	private Color backgroundColor = null;
}
