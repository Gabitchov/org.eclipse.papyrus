/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

public class RoundedRectangleDashedShadowBorder extends RectangularShadowBorder {

	/** the width of the rounded corner */
	protected int cornerWidth;

	/** the height of the rounded corner */
	protected int cornerHeight;

	/**
	 * Creates an instance of this class with the given arc width and arc height
	 * in pixels
	 * 
	 * @param borderwidth
	 *        the width of the border line
	 * @param color
	 *        the color or the line
	 * @param arcWidth
	 *        the width of the corner arc
	 * @param arcHeight
	 *        the height of the corner arc
	 */
	public RoundedRectangleDashedShadowBorder(int borderwidth, Color color, int arcWidth, int arcHeight) {
		super(borderwidth, color);
		cornerWidth = arcWidth;
		cornerHeight = arcHeight;
		setWidth(1);
	}

	/**
	 * @see org.eclipse.draw2d.Border#paint(IFigure, Graphics, Insets)
	 */
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.setLineStyle(SWT.LINE_DASH);
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
		graphics.drawRoundRectangle(tempRect, cornerWidth, cornerHeight);

		// draw the shadow
		// first expand the clip rectangle
		Rectangle newRect = new Rectangle(tempRect);
		newRect.width = newRect.width + borderwidth;
		newRect.height = newRect.height + borderwidth;
		graphics.setClip(newRect);
		// paint the shadow, a nice rectangular one with soft corners
		PointList plt = new PointList();
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + cornerHeight / 2);
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + tempRect.height - cornerHeight / 2);
		plt.addPoint(tempRect.x + tempRect.width - cornerWidth / 2, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + cornerWidth / 2, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + cornerWidth, tempRect.y + tempRect.height + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + tempRect.height + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + cornerHeight);
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + cornerHeight / 2);
		if(getColor() != null) {
			graphics.setBackgroundColor(getColor());
		} else {
			graphics.setBackgroundColor(ColorConstants.black);
		}
		graphics.fillPolygon(plt);
		graphics.popState();
	}

}
