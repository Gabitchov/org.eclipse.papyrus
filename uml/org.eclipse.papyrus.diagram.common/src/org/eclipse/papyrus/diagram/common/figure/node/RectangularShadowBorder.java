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
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;

/**
 * Provide shadow border on Rectangular figure
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class RectangularShadowBorder extends LineBorder {

	int borderwidth;

	public RectangularShadowBorder(int borderwidth, Color color) {
		super(color);
		this.borderwidth = borderwidth;
		setWidth(0);
	}

	/**
	 * Method for determining the inset the border will take up on the shape.
	 * 
	 * @param figure
	 *            Figure that will be inset from the border
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
	 * @see org.eclipse.draw2d.Border#paint(IFigure, Graphics, Insets)
	 */
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		// draw the normal line border
		tempRect.setBounds(getPaintRectangle(figure, insets));

		if (getWidth() % 2 == 1) {
			tempRect.width--;
			tempRect.height--;
		}

		tempRect.shrink(getWidth() / 2, getWidth() / 2);
		graphics.setLineWidth(getWidth());
		if (getColor() != null)
			graphics.setForegroundColor(getColor());
		graphics.drawRectangle(tempRect);

		// draw the shadow
		// first expand the clip rectangle
		Rectangle newRect = new Rectangle(tempRect);
		newRect.width = newRect.width + borderwidth;
		newRect.height = newRect.height + borderwidth;
		graphics.setClip(newRect);
		// paint the shadow
		PointList plt = new PointList();
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + borderwidth, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + borderwidth, tempRect.y + tempRect.height + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + tempRect.height + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + borderwidth);
		graphics.setBackgroundColor(getColor());
		graphics.fillPolygon(plt);
	}

}