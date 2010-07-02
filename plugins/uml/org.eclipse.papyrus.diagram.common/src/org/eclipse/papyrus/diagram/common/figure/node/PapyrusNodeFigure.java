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
 *  Atos Origin - Enable extending with a composite figure, by adding overrideable methods.
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.swt.graphics.Color;

/**
 * Common node figure. In charge of background, font, gradient, foreground, border, shadow
 */
public class PapyrusNodeFigure extends NodeFigure implements IPapyrusNodeFigure {

	/**
	 * The border color.
	 */
	private Color borderColor = ColorConstants.black;

	/**
	 * The shadow
	 */
	private boolean shadow = true;

	/**
	 * Table used to draw figure border as dashed line.
	 */
	protected int[] dash = new int[10];

	protected RectangularShadowBorder shadowborder;

	public PapyrusNodeFigure() {
		super();
		createCompositeFigureStructure();

		// Initialize dash property for dashed border representation.
		for(int i = 0; i < 10; i++) {
			dash[i] = 5;
		}

		shadowborder = new RectangularShadowBorder(3, getForegroundColor());
		setBorder(getBorderedFigure(), shadowborder);
	}

	/**
	 * Create the composite structure of this figure, by adding it its necessary children.
	 * Children should override and implement this method in case they have a composite figure, to add children forming the overall structure.
	 */
	protected void createCompositeFigureStructure() {
		// By default, do nothing : the figure is not composite
	}

	/**
	 * Get the figure on which the border must be drawn.
	 * Children should override and implement this method in case the border must not be drawn on the overall figure. The returned figure shall be
	 * created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return the figure to draw the border on
	 * @see #createCompositeFigureStructure()
	 */
	protected IFigure getBorderedFigure() {
		// by default, border is drawn on the overall figure
		return this;
	}

	/**
	 * Sets the border to the bordered figure.
	 * This method is not intended to be overridden. Override {@link #getBorderedFigure()} instead.
	 * 
	 * @param borderedFigure
	 *        the figure on which the border shall be drawn (or null for this figure)
	 * @param border
	 *        The new border
	 * @see IFigure#setBorder(Border)
	 */
	protected void setBorder(IFigure borderedFigure, Border border) {
		if(borderedFigure == null) {
			super.setBorder(border);
		} else {
			borderedFigure.setBorder(border);
		}
	}

	public boolean isShadow() {
		return shadow;
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
		if(shadow == true) {
			setBorder(getBorderedFigure(), shadowborder);
		} else {
			setBorder(getBorderedFigure(), getDefaultBorder(null));
		}
	}

	/**
	 * Sets the border color.
	 * 
	 * @param borderColor
	 *        the border color
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		setBorder(getBorderedFigure(), getDefaultBorder(borderColor));
	}

	/**
	 * Get the default non shadow border to use.
	 * Children can override and implement this method if necessary, taking care not to fail if borderColor is null
	 * 
	 * @param borderColor
	 *        the color of the border to take if possible or null
	 * @return a non shadow border
	 */
	protected Border getDefaultBorder(Color borderColor) {
		// default border is line border
		if(borderColor != null) {
			return new LineBorder(borderColor);
		} else {
			return new LineBorder();
		}
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
	 *        the graphics
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
	 *        the graphics
	 * @param rectangle
	 *        the rectangle where the background needs to be fill.
	 */
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		if(isUsingGradient()) {
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

	/**
	 * <pre>
	 * This figure manages the border representation with dashes Graphics.LINE_DASH is the only
	 * value managed in this implementation (except the default LINE.SOLID of course).
	 * 
	 * Without this {@link NodeFigure} does not manages dashes even if LineStyle is correctly set.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void paintBorder(Graphics graphics) {
		if(getLineStyle() == Graphics.LINE_DASH) {
			graphics.setLineDash(dash);
		}
		super.paintBorder(graphics);
	}

}
