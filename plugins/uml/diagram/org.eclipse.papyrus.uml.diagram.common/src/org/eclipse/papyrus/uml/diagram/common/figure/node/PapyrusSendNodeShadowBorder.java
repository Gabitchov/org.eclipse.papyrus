/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.swt.graphics.Color;

public class PapyrusSendNodeShadowBorder extends RectangularShadowBorder {

	/** the width of the widthArrow */
	protected int widthArrow;

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
	public PapyrusSendNodeShadowBorder(int borderwidth, Color color, int corner) {
		super(borderwidth, color);
		this.widthArrow = corner;
		setWidth(1);
	}

	/**
	 * @see org.eclipse.draw2d.Border#paint(IFigure, Graphics, Insets)
	 */
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.pushState();
		// draw the normal line border
		tempRect.setBounds(getPaintRectangle(figure, insets));

		PointList ptList= new PointList();
		ptList.addPoint(tempRect.getLocation());
		ptList.addPoint(tempRect.x+tempRect.width-widthArrow, tempRect.y);
		ptList.addPoint(tempRect.x+tempRect.width, tempRect.y+(tempRect.height/2));
		ptList.addPoint(tempRect.x+tempRect.width-widthArrow, tempRect.y+(tempRect.height));
		ptList.addPoint(tempRect.getBottomLeft());
		if(getColor() != null) {
			graphics.setBackgroundColor(getColor());
		} else {
			graphics.setBackgroundColor(ColorConstants.black);
		}
		graphics.drawPolygon(ptList);
		graphics.popState();
	}

}
