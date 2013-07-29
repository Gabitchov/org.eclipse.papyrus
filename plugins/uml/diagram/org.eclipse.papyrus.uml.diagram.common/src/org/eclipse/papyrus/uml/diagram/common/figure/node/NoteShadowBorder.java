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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.NoteFigure.NoteFigureBorder;
import org.eclipse.swt.graphics.Color;

/**
 * this class is used to test the shadow for a a note figure
 * 
 */

public class NoteShadowBorder extends RectangularShadowBorder {

	protected Dimension cornerDim;

	private NoteFigureBorder noteBorder;

	public NoteShadowBorder(int borderwidth, Color color, Dimension cornerDim, NoteFigureBorder noteBorder) {
		super(borderwidth, color);
		this.cornerDim = cornerDim;
		this.noteBorder = noteBorder;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns margin for this border
	 * 
	 * @return margin as Insets
	 */
	public Insets getMargin() {
		return noteBorder.getMargin();
	}

	public Insets getInsets(IFigure figure) {
		return noteBorder.getInsets(figure);
	}

	/**
	 * @see org.eclipse.draw2d.Border#paint(IFigure, Graphics, Insets)
	 */
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.pushState();
		noteBorder.paint(figure, graphics, insets);

		// draw the shadow
		// first expand the clip rectangle
		Rectangle newRect = new Rectangle(figure.getBounds());
		Rectangle figureRect = new Rectangle(figure.getBounds());
		newRect.width = newRect.width + borderwidth;
		newRect.height = newRect.height + borderwidth;
		graphics.setClip(newRect);
		// paint the shadow
		PointList plt = new PointList();
		plt.addPoint(figureRect.x + figureRect.width, figureRect.y + borderwidth + cornerDim.height);
		plt.addPoint(figureRect.x + figureRect.width, figureRect.y + figureRect.height);
		plt.addPoint(figureRect.x + borderwidth, figureRect.y + figureRect.height);
		plt.addPoint(figureRect.x + borderwidth, figureRect.y + figureRect.height + borderwidth);
		plt.addPoint(figureRect.x + figureRect.width + borderwidth, figureRect.y + figureRect.height + borderwidth);
		plt.addPoint(figureRect.x + figureRect.width + borderwidth, figureRect.y + borderwidth + cornerDim.height + borderwidth);
		plt.addPoint(figureRect.x + figureRect.width, figureRect.y + borderwidth + cornerDim.height);
		if(getColor() != null) {
			graphics.setBackgroundColor(getColor());
		} else {
			graphics.setBackgroundColor(ColorConstants.black);
		}
		graphics.fillPolygon(plt);
		graphics.popState();
	}
}
