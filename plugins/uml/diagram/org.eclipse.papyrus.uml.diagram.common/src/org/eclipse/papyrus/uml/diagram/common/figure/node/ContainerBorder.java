/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * Construct a border with a line at the top, and margin on the other sides.
 * 
 * @author dumoulin
 */
public class ContainerBorder extends AbstractBorder {

	/**
	 * 
	 */
	private int lineWidth = 1;

	/**
	 * 
	 */
	private Color color;

	/**
	 * This border's insets. Used for Margin
	 */
	protected Insets insets;

	/**
	 * Constructs a LineBorder with the specified color and of the specified
	 * width.
	 * 
	 * @param lineWidth
	 *        The width of the line in pixels.
	 * @param color
	 *        The color of the border.
	 * @param marginInsets
	 *        The width of the margin in pixels.
	 * 
	 * @since 2.0
	 */
	public ContainerBorder(Color color, int lineWidth, Insets marginInsets) {
		setColor(color);
		setLineWidth(lineWidth);
		this.insets = marginInsets;
		// this.insets = new Insets(marginInsets);
		insets.top += lineWidth;
	}

	/**
	 * to adapt the color of the border.
	 * 
	 * @param color
	 */
	public void setBorder(Color color) {
		this.setColor(color);
	}

	/**
	 * Constructs a LineBorder with the specified color and of the specified
	 * width.
	 * 
	 * @param allMargin
	 *        The width of the margin in pixels.
	 * @param lineWidth
	 *        The width of the line in pixels.
	 * @param color
	 *        The color of the border.
	 * 
	 * @since 2.0
	 */
	public ContainerBorder(Color color, int lineWidth, int allMargin) {
		this(color, lineWidth, new Insets(allMargin));
	}

	/**
	 * Constructs a LineBorder with the specified color and of the specified
	 * width.
	 * 
	 * @param lineWidth
	 *        The width of the line in pixels.
	 * @param color
	 *        The color of the border.
	 * @param r
	 *        magin at rigth
	 * @param t
	 *        margin at top
	 * @param l
	 *        margin at left
	 * @param b
	 *        margin at bottom
	 * 
	 * @since 2.0
	 */
	public ContainerBorder(Color color, int lineWidth, int t, int l, int b, int r) {
		this(color, lineWidth, new Insets(t, l, b, r));
	}

	/**
	 * Constructs a LineBorder with the specified color and a width of 1 pixel.
	 * 
	 * @param color
	 *        The color of the border.
	 * 
	 * @since 2.0
	 */
	// @unused
	public ContainerBorder(Color color) {
		this(color, 1, 1);
	}

	/**
	 * Constructs a black LineBorder with the specified width.
	 * 
	 * @param width
	 *        The width of the border in pixels.
	 * 
	 * @since 2.0
	 */
	// @unused
	public ContainerBorder(int width) {
		this(null, width, width);
	}

	/**
	 * Constructs a default black LineBorder with a width of one pixel.
	 * 
	 * @since 2.0
	 */
	// @unused
	public ContainerBorder() {
	}

	/**
	 * Returns the line color of this border.
	 * 
	 * @return The line color of this border
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Returns the space used by the border for the figure provided as input. In
	 * this border all sides always have equal width.
	 * 
	 * @param figure
	 *        The figure this border belongs to
	 * 
	 * @return This border's insets
	 */
	public Insets getInsets(IFigure figure) {
		return insets;
	}

	/**
	 * Returns the line width of this border.
	 * 
	 * @return The line width of this border
	 */
	public int getLineWidth() {
		return lineWidth;
	}

	/**
	 * Returns <code>true</code> since this border is opaque. Being opaque it is
	 * responsible to fill in the area within its boundaries.
	 * 
	 * @return <code>true</code> since this border is opaque
	 */
	@Override
	public boolean isOpaque() {
		return true;
	}

	/**
	 * 
	 * 
	 * @param graphics
	 * @param figure
	 * @param insets
	 * 
	 * @see org.eclipse.draw2d.Border#paint(IFigure, Graphics, Insets)
	 */
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.pushState();
		Rectangle bounds = figure.getBounds();
		graphics.setLineWidth(getLineWidth());
		if(getColor() != null) {
			graphics.setForegroundColor(getColor());
		}
		// graphics.drawLine(tempRect.getTopLeft(), tempRect.getTopRight());
		graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight());
		graphics.popState();
	}

	/**
	 * Sets the line color for this border.
	 * 
	 * @param color
	 *        The line color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Sets the line width for this border.
	 * 
	 * @param width
	 *        The line width
	 */
	public void setLineWidth(int width) {
		this.lineWidth = width;
	}
}
