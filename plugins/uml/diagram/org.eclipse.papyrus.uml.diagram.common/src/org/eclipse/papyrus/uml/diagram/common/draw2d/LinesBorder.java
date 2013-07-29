/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

/**
 * This is a border that draws lines at the given border positions around the
 * shape.
 */
public class LinesBorder extends LineBorder {

	/** The positions where the borders are drawn */
	private int positions = PositionConstants.NONE;
	
	private int leftInset = 0;
	private int rightInset = 0;
	private int topInset = 0;
	private int bottomInset = 0;

	/**
	 * Constructor.
	 */
	public LinesBorder() {
		this(1, PositionConstants.NONE);
	}

	/**
	 * Constructor.
	 * 
	 * @param sides
	 */
	public LinesBorder(int sides) {
		this(1, sides);
	}

	/**
	 * Constructor
	 * 
	 * @param width
	 *        the width of the line in relative coordinates
	 * @param sides
	 *        the sides to draw. The value should be a bitwise composition
	 *        of PositionConstants.NONE, PositionConstants.TOP,
	 *        PositionConstants.BOTTOM, PositionConstants.LEFT,
	 *        PositionConstants.RIGHT
	 */
	public LinesBorder(int width, int sides) {
		super(width);
		this.positions = sides;
	}

	/**
	 * Get drawn sides
	 * 
	 * @return Returns the side positions.
	 */
	public int getSides() {
		return positions;
	}

	/**
	 * Change drawn sides
	 * 
	 * @param sides
	 *        the sides to draw. The value should be a bitwise composition
	 *        of PositionConstants.NONE, PositionConstants.TOP,
	 *        PositionConstants.BOTTOM, PositionConstants.LEFT,
	 *        PositionConstants.RIGHT
	 */
	public void setSides(int sides) {
		this.positions = sides;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Border#getInsets(org.eclipse.draw2d.IFigure)
	 */
	public Insets getInsets(IFigure figure) {
		return new Insets(getTopInset(), getLeftInset(),  getBottomInset(), getRightInset());
	}

	/**
	 * Paints the border based on the inputs given.
	 * 
	 * @param figure
	 *        <code>IFigure</code> for which this is the border.
	 * @param graphics
	 *        <code>Graphics</code> handle for drawing the border.
	 * @param insets
	 *        Space to be taken up by this border.
	 */
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		tempRect.setBounds(getPaintRectangle(figure, insets));

		int one = MapModeUtil.getMapMode(figure).DPtoLP(1);
		int widthInDP = getWidth() / one;

		int halfWidthInLP = MapModeUtil.getMapMode(figure).DPtoLP(widthInDP / 2);

		graphics.setLineWidth(getWidth());
		graphics.setLineStyle(getStyle());
		// adapt tempRect so that borders do not overflow the initial bounds
		tempRect.x += halfWidthInLP;
		tempRect.width -= getWidth();
		tempRect.y += halfWidthInLP;
		tempRect.height -= getWidth();

		if((positions & PositionConstants.TOP) > 0) {
			graphics.drawLine(tempRect.getTopLeft(), tempRect.getTopRight());
		}
		if((positions & PositionConstants.LEFT) > 0) {
			graphics.drawLine(tempRect.getTopLeft(), tempRect.getBottomLeft());
		}
		if((positions & PositionConstants.BOTTOM) > 0) {
			graphics.drawLine(tempRect.getBottomLeft(), tempRect.getBottomRight());
		}
		if((positions & PositionConstants.RIGHT) > 0) {
			graphics.drawLine(tempRect.getTopRight(), tempRect.getBottomRight());
		}
	}

	public int getPositions() {
		return positions;
	}

	public void setPositions(int positions) {
		this.positions = positions;
	}

	public int getLeftInset() {
		if (leftInset < getWidth() && (positions & PositionConstants.LEFT) > 0){
			return getWidth();
		}
		return leftInset;
	}

	public void setLeftInset(int leftInset) {
		this.leftInset = leftInset;
	}

	public int getRightInset() {
		if (rightInset < getWidth() && (positions & PositionConstants.RIGHT) > 0){
			return getWidth();
		}
		return rightInset;
	}

	public void setRightInset(int rightInset) {
		this.rightInset = rightInset;
	}

	public int getTopInset() {
		if (topInset < getWidth() && (positions & PositionConstants.TOP) > 0){
			return getWidth();
		}
		return topInset;
	}

	public void setTopInset(int topInset) {
		this.topInset = topInset;
	}

	public int getBottomInset() {
		if (bottomInset < getWidth() && (positions & PositionConstants.TOP) > 0){
			return getWidth();
		}
		return bottomInset;
	}

	public void setBottomInset(int bottomInset) {
		this.bottomInset = bottomInset;
	}
}
