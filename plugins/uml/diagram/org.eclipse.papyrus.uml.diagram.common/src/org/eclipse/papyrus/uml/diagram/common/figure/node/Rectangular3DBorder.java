/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el-kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;

// TODO: Auto-generated Javadoc
/**
 * Provide 3D Effect on Rectangular figure.
 */
public class Rectangular3DBorder extends LineBorder {

	/** The borderwidth. */
	int borderwidth;

	/**
	 * Instantiates a new rectangular3 d border.
	 *
	 * @param borderwidth the borderwidth
	 * @param color the color
	 */
	public Rectangular3DBorder(int borderwidth, Color color) {
		super(color);
		this.borderwidth = borderwidth;
		setWidth(1);
	}

	/**
	 * Method for determining the inset the border will take up on the shape.
	 * 
	 * @param figure
	 *        Figure that will be inset from the border
	 * @return Insets the Insets for the border on the given figure.
	 */
	@Override
	public Insets getInsets(IFigure figure) {
		Insets insetsNew = super.getInsets(figure);
		insetsNew.top = 0;
		insetsNew.left = 0;
		insetsNew.bottom = MapModeUtil.getMapMode(figure).DPtoLP(insetsNew.bottom + borderwidth);
		insetsNew.right = MapModeUtil.getMapMode(figure).DPtoLP(insetsNew.right + borderwidth);
		return insetsNew;
	}

	/**
	 * Paint.
	 *
	 * @param figure the figure
	 * @param graphics the graphics
	 * @param insets the insets
	 * @see org.eclipse.draw2d.Border#paint(IFigure, Graphics, Insets)
	 */
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.pushState();
		// draw the normal line border
		tempRect.setBounds(getPaintRectangle(figure, insets));

		if(getWidth() % 2 == 1) {
			tempRect.width--;
			tempRect.height--;
		}

		tempRect.shrink(getWidth() / 2, getWidth() / 2);
		graphics.setLineWidth(getWidth());

		if(getColor() != null)
			graphics.setForegroundColor(getColor());
		else
			graphics.setForegroundColor(ColorConstants.black);

		graphics.drawRectangle(tempRect);

		// draw the shadow
		// first expand the clip rectangle
		Rectangle newRect = new Rectangle(tempRect);
		newRect.width = newRect.width + borderwidth;
		newRect.height = newRect.height + borderwidth;
		graphics.setClip(newRect);
		// paint the shadow

		PointList plt = new PointList();
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + tempRect.height + borderwidth);
		plt.addPoint(tempRect.x + borderwidth, tempRect.y + tempRect.height + borderwidth);
		plt.addPoint(tempRect.x, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + tempRect.height);

		if(getColor() != null)
			graphics.setBackgroundColor(getColor());
		else
			graphics.setBackgroundColor(ColorConstants.gray);

		graphics.fillPolygon(plt);
		graphics.popState();
	}

}
