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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.swt.graphics.Color;

/**
 * Common node figure. In charge of background, font, gradient, foreground,
 * border, shadow
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

	/** Default custom dash values */
	public static final int[] DEFAULT_CUSTOM_DASH = { 5, 5 };

	/** Table used to draw figure border as dashed line. */
	protected int[] customDash = null;

	/** Get custom dash values */
	public int[] getCustomDash() {
		if(customDash == null) {
			// Initialize dash property for dashed border representation.
			customDash = DEFAULT_CUSTOM_DASH;
		}
		return customDash;
	}

	/** Set custom dash values */
	public void setCustomDash(int[] dash) {
		this.customDash = dash;
	}

	protected LineBorder shadowborder;

	public PapyrusNodeFigure() {
		super();
		createCompositeFigureStructure();

		shadowborder = new RectangularShadowBorder(3, getForegroundColor());
		setBorder(getBorderedFigure(), shadowborder);
	}

	/**
	 * Create the composite structure of this figure, by adding it its necessary
	 * children. Children should override and implement this method in case they
	 * have a composite figure, to add children forming the overall structure.
	 */
	protected void createCompositeFigureStructure() {
		// By default, do nothing : the figure is not composite
	}

	/**
	 * Get the figure on which the border must be drawn. Children should
	 * override and implement this method in case the border must not be drawn
	 * on the overall figure. The returned figure shall be created in the method {@link #createCompositeFigureStructure()}.
	 * 
	 * @return the figure to draw the border on
	 * @see #createCompositeFigureStructure()
	 */
	protected IFigure getBorderedFigure() {
		// by default, border is drawn on the overall figure
		return this;
	}

	/**
	 * Sets the border to the bordered figure. This method is not intended to be
	 * overridden. Override {@link #getBorderedFigure()} instead.
	 * 
	 * @param borderedFigure
	 *        the figure on which the border shall be drawn (or null for
	 *        this figure)
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
	 * Get the default non shadow border to use. Children can override and
	 * implement this method if necessary, taking care not to fail if
	 * borderColor is null
	 * 
	 * @param borderColor
	 *        the color of the border to take if possible or null
	 * @return a non shadow border
	 */
	protected Border getDefaultBorder(Color borderColor) {

		// Default border is line border
		LineBorder lineBorder = null;
		if(borderColor != null) {
			lineBorder = new LineBorder(borderColor);
		} else {
			lineBorder = new LineBorder();
		}

		// Set border style and width
		lineBorder.setStyle(getLineStyle());
		lineBorder.setWidth(getLineWidth());

		return lineBorder;
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
	 * Paint the background of the figure. If this figure uses gradient, then it
	 * will paint the background with the gradient informations. Otherwise it
	 * will use the background color.
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
	 * This figure manages the border representation with custom dashes.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void paintBorder(Graphics graphics) {

		if(getLineStyle() == Graphics.LINE_CUSTOM) {
			graphics.setLineDash(getCustomDash());
		}
		super.paintBorder(graphics);
	}

	/**
	 * <pre>
	 * This method propagates the new line style to the border
	 * 
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#setLineStyle(int)
	 * </pre>
	 * 
	 * @param s
	 *        the new line style value
	 */
	@Override
	public void setLineStyle(int s) {
		if((getBorder() != null) && (getBorder() instanceof LineBorder)) {
			((LineBorder)getBorder()).setStyle(s);
		}

		super.setLineStyle(s);
	}

	/**
	 * <pre>
	 * This method propagates the new line width to the border
	 * 
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#setLineWidth(int)
	 * </pre>
	 * 
	 * @param w
	 *        the new line width value
	 */
	@Override
	public void setLineWidth(int w) {
		if((getBorder() != null) && (getBorder() instanceof LineBorder)) {
			((LineBorder)getBorder()).setWidth(w);
		}

		super.setLineWidth(w);
	}
}
