/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram Implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class LifelineDotLineFigure.
 * 
 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a>
 */
public class LifelineDotLineFigure extends Shape {

	// Attributes

	/** The cross at end. */
	private boolean crossAtEnd = false;

	/** The SOLI d_ size. */
	private final int SOLID_SIZE = 6;

	/** The DASHE d_ size. */
	private final int DASHED_SIZE = 10;

	// Methods

	/**
	 * Instantiates a new lifeline dot line figure.
	 */
	public LifelineDotLineFigure() {
		super();
	}

	/**
	 * Sets the cross at end.
	 * 
	 * @param setCross
	 *            the new cross at end
	 */
	public void setCrossAtEnd(boolean setCross) {
		crossAtEnd = setCross;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void fillShape(Graphics graphics) {

		// Filling area
		// Rectangle r = getBounds();
		// graphics.drawRectangle(r);

		// outlineShape(graphics);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle r = getBounds();

		Point pStart = new Point();
		Point pEnd = new Point();
		Point pAux = new Point();

		pStart.x = r.x + r.width / 2;
		pStart.y = r.y + 1;

		pEnd.x = pStart.x;
		pEnd.y = pStart.y + r.height - 1;

		pAux = pStart.getCopy();

		graphics.setLineStyle(Graphics.LINE_SOLID);
		graphics.setForegroundColor(ColorConstants.black);

		while (pAux.y <= pEnd.y) {
			// The drawing limit is pEnd.y
			int yEnd = pAux.y + SOLID_SIZE;
			if (yEnd > pEnd.y) {
				yEnd = pEnd.y;
			}
			graphics.drawLine(pAux, new Point(pAux.x, yEnd));
			pAux.y = pAux.y + DASHED_SIZE;
		}

		// Case the Lifeline has a DestructionEvent
		if (crossAtEnd == true) {
			int pixels = 10;

			Point p1Start = new Point();
			Point p1End = new Point();

			Point p2Start = new Point();
			Point p2End = new Point();

			p1Start.x = pEnd.x - pixels;
			p1Start.y = pEnd.y;

			p1End.x = pEnd.x + pixels;
			p1End.y = pEnd.y - 2 * pixels;

			p2Start.x = pEnd.x + pixels;
			p2Start.y = pEnd.y;

			p2End.x = pEnd.x - pixels;
			p2End.y = pEnd.y - 2 * pixels;

			graphics.setLineStyle(Graphics.LINE_SOLID);
			graphics.setForegroundColor(ColorConstants.black);

			graphics.drawLine(p1Start, p1End);
			graphics.drawLine(p2Start, p2End);
		}
	}

}
