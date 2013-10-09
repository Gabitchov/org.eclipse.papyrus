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
 *  Fadoi LAKHAL  Fadoi.Lakhal@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/** Use to create a containment circle figure */
public class ContainmentFigure extends Ellipse {

	/**
	 * Fills the circle.
	 * 
	 * @param graphics
	 *        the graphics
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	protected void fillShape(Graphics graphics) {
		graphics.pushState();
		graphics.setBackgroundColor(ColorConstants.white);
		graphics.fillOval(getBounds());
		graphics.popState();
		Dimension dim = new Dimension(20, 20);
		this.setMaximumSize(dim);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintFigure(Graphics graphics) {
		graphics.setAntialias(SWT.LOW);
		super.paintFigure(graphics);
		graphics.pushState();
		graphics.setBackgroundColor(ColorConstants.black);
		/* Creates the cross in the circle */
		Rectangle rect1 = getBounds().getCopy();
		int scaleFactor_horizontale = rect1.height / 2;
		int scaleFactor_verticale = rect1.width / 2;
		Rectangle rect = getBounds().getCopy();
		graphics.drawLine(rect1.x, rect1.y + scaleFactor_horizontale, rect1.x + (int)Math.floor(rect1.width * (scaleFactor_horizontale)), rect1.y - (1 - scaleFactor_horizontale));
		graphics.drawLine(rect1.x + scaleFactor_verticale, rect1.y, rect1.x - (1 - scaleFactor_verticale), rect1.y + (int)Math.floor(rect1.height * (scaleFactor_verticale)));
		graphics.popState();
	}
}
