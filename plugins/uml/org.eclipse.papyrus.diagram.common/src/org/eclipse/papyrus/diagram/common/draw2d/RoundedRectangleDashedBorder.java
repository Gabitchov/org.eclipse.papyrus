/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.swt.SWT;

/**
 * This class provides a border drawn as a dashed rounded rectangle.
 * 
 * @author vhemery
 */
public class RoundedRectangleDashedBorder extends RoundedRectangleBorder {

	/**
	 * Creates an instance of this class with the given arc width and arc height in pixels
	 * 
	 * @param arcWidth
	 *        The width of the corner arc
	 * @param arcHeight
	 *        The height of the corner arc
	 */
	public RoundedRectangleDashedBorder(int arcWidth, int arcHeight) {
		super(arcWidth, arcHeight);
	}

	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.setLineStyle(SWT.LINE_DASH);

		getPaintRectangle(figure, insets);




		//		// bug fix when lineWidth is 1
		//		if(getWidth() % 2 == 1) {
		//			tempRect.width--;
		//			tempRect.height--;
		//		}
		//
		//		// Shrink to accommodate for the line width
		//		tempRect.shrink(getWidth() / 2, getWidth() / 2);




		// bug fix when lineWidth is 1 : make the 0 rounding in our favor
		// Shrink to accommodate for the line width
		tempRect.x = tempRect.x + getWidth() - getWidth() / 2;
		tempRect.y = tempRect.y + getWidth() - getWidth() / 2;
		tempRect.width = tempRect.width - getWidth();
		tempRect.height = tempRect.height - getWidth();

		graphics.setLineWidth(getWidth());
		graphics.setLineStyle(getStyle());
		// If the color for this border is specified, then use it. 
		// Otherwise, use the figure's foreground color
		if(getColor() != null) {
			graphics.setForegroundColor(getColor());
		} else {
			graphics.setForegroundColor(figure.getForegroundColor());
		}

		graphics.drawRoundRectangle(tempRect, getArcWidth(), getArcHeight());





	}
}
