/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies), Nicolas Lalevee (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Graphics;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DestructionEventFigure extends org.eclipse.draw2d.Figure {

	/**
	 * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DestructionEventFigure() {
		super();
	}

	/**
	 * The stop is a cross
	 * 
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		graphics.pushState();
		int width = bounds.width;
		int height = bounds.height;
		if(width > height) {
			width = height;
		} else if(width < height) {
			height = width;
		}
		int x = bounds.x + bounds.width / 2 - width / 2;
		int y = bounds.y + bounds.height / 2 - height / 2;
		graphics.setLineWidth(lineWidth);
		graphics.drawLine(x, y, x + width, y + height);
		graphics.drawLine(x + width, y, x, y + height);
		graphics.popState();
	}

	public void setLineWidth(int w) {
		if((lineWidth == w) || (w < 0)) {
			return;
		}
		lineWidth = w;
		repaint();
	}

	private int lineWidth = 1;
}
