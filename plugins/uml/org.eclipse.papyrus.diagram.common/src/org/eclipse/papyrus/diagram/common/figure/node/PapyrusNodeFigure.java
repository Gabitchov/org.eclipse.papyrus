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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

/**
 * Common node figure. In charge of background, font, gradient, foreground, border, shadow
 */
public class PapyrusNodeFigure extends NodeFigure {

	/**
	 * The border color.
	 */
	private Color borderColor = ColorConstants.black;

	/**
	 * The shadow
	 */
	private boolean shadow = true;

	protected RectangularShadowBorder shadowborder;

	public PapyrusNodeFigure() {
		super();

		shadowborder = new RectangularShadowBorder(3, getForegroundColor());
		setBorder(shadowborder);
	}

	public boolean isShadow() {
		return shadow;
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
		if (shadow == true) {
			this.setBorder(shadowborder);
		} else {
			this.setBorder(new LineBorder());
		}
	}

	/**
	 * Sets the border color.
	 * 
	 * @param borderColor
	 *            the border color
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		super.setBorder(new LineBorder(borderColor));
	}

	/**
	 * Gets the border color.
	 * 
	 * @return the border color
	 */
	public Color getBorderColor() {
		return this.borderColor;
	}

	/**
	 * Paint figure.
	 * 
	 * @param graphics
	 *            the graphics
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);

		paintBackground(graphics, getBounds());

		shadowborder.setColor(getForegroundColor());

	}

	/**
	 * Paint the background of the figure. If this figure uses gradient, then it will paint the
	 * background with the gradient informations. Otherwise it will use the background color.
	 * 
	 * @param graphics
	 *            the graphics
	 * @param rectangle
	 *            the rectangle where the background needs to be fill.
	 */
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		if (isUsingGradient()) {
			applyTransparency(graphics);
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
			graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
			graphics.fillGradient(rectangle, isVertical);
		} else {
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getForegroundColor());
			graphics.fillRectangle(rectangle);
		}
	}

}
