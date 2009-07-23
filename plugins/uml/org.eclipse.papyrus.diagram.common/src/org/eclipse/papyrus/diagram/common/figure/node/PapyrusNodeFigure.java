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
	 * The background color.
	 */
	protected Color backgroundColor = ColorConstants.lightGreen;

	/**
	 * The border color.
	 */
	protected Color borderColor = ColorConstants.black;

	/**
	 * The font.
	 */
	protected Font font = null;

	/**
	 * The font color.
	 */
	protected Color fontColor = ColorConstants.black;

	/**
	 * The font size.
	 */
	protected int fontSize = 10;

	/**
	 * The font string.
	 */
	protected String fontString = "Arial";

	/**
	 * The fore ground color.
	 */
	protected Color foreGroundColor = ColorConstants.black;

	/**
	 * The shadow
	 */
	private boolean shadow = true;

	protected RectangularShadowBorder shadowborder;

	public PapyrusNodeFigure() {
		super();
		FontData[] fontdata = { new FontData(this.fontString, this.fontSize, SWT.NORMAL) };
		this.font = Activator.fontManager.get(fontdata);
		FontData[] fontdata2 = { new FontData("Arial", this.fontSize, SWT.BOLD) };
		Font font2 = Activator.fontManager.get(fontdata2);
		setBackgroundColor(Activator.colorManager.get(new RGB(242, 242, 242)));

		setForegroundColor(Activator.colorManager.get(new RGB(204, 204, 204)));

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
	 * Gets the font color.
	 * 
	 * @return the font color
	 */
	public Color getFontColor() {
		return this.fontColor;
	}

	/**
	 * Sets the font color.
	 * 
	 * @param fontColor
	 *            the font color
	 */
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	/**
	 * Gets the font size.
	 * 
	 * @return the font size
	 */
	public int getFontSize() {
		return this.fontSize;
	}

	/**
	 * Sets the font size.
	 * 
	 * @param fontSize
	 *            the font size
	 */
	public void setFontSize(int fontSize) {

		FontData[] fontdata = { new FontData(this.fontString, fontSize, SWT.NORMAL) };
		this.font = Activator.fontManager.get(fontdata);
		super.setFont(this.font);
		this.fontSize = fontSize;
	}

	/**
	 * Sets the fore ground color.
	 * 
	 * @param foreGroundColor
	 *            the fore ground color
	 */
	public void setForeGroundColor(Color foreGroundColor) {
		this.foreGroundColor = foreGroundColor;
		super.setForegroundColor(foreGroundColor);

	}

	/**
	 * Sets the background color.
	 * 
	 * @param backgroundColor
	 *            the background color
	 */
	@Override
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		super.setBackgroundColor(backgroundColor);
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
			graphics.setForegroundColor(getForeGroundColor());
			graphics.fillRectangle(rectangle);
		}
	}

	/**
	 * Getfigure font.
	 * 
	 * @return the figure font
	 */
	public String getfigureFont() {
		return this.fontString;
	}

	/**
	 * Setfigure font.
	 * 
	 * @param font
	 *            the font
	 */
	public void setfigureFont(String font) {

		this.fontString = font;
		FontData[] fontdata = { new FontData(font, this.fontSize, SWT.NORMAL) };
		this.font = Activator.fontManager.get(fontdata);
		super.setFont(this.font);
	}

	/**
	 * Gets the fore ground color.
	 * 
	 * @return the fore ground color
	 */
	public Color getForeGroundColor() {
		return this.foreGroundColor;
	}

	/**
	 * Gets the background color.
	 * 
	 * @return the background color
	 */
	@Override
	public Color getBackgroundColor() {
		return this.backgroundColor;
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

}
