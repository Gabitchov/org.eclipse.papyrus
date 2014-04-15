/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;

/**
 * Fixes a bug in GMF RoundedRectangleBorder: when lineWidth is 1 then the
 * border is not shown entirely. See paint method.
 * 
 * @author David
 * 
 */
public class RoundedBorder extends RoundedRectangleBorder {

	public RoundedBorder(int arcWidth, int arcHeight) {
		super(arcWidth, arcHeight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		tempRect.setBounds(getPaintRectangle(figure, insets));

		// bug fix when lineWidth is 1
		if(getWidth() % 2 != 0) {
			tempRect.width--;
			tempRect.height--;
		}

		// Shrink to accommodate for the line width
		tempRect.shrink(getWidth() / 2, getWidth() / 2);

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
