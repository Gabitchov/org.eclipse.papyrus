/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram Implementation
 * Thibault Landré (Atos Origin) - Add crossAtEnd and dashLine figure
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

/**
 * The Class LifelineDotLineFigure.
 * 
 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a>
 */
public class LifelineDotLineFigure extends Shape {

	// Attributes

	/** The SOLI d_ size. */
	private final int SOLID_SIZE = 6;

	/** The DASHE d_ size. */
	private final int DASHED_SIZE = 10;

	/** The DashLine figure where elements will be attached */
	private NodeFigure dashLineRectangle;

	// Methods

	/**
	 * Instantiates a new lifeline dot line figure.
	 */
	public LifelineDotLineFigure() {
		super();

		// Init dashLineRectangle
		dashLineRectangle = new NodeFigure();
		dashLineRectangle.setParent(this);

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

		// Create the dash line
		pAux = pStart.getCopy();

		while(pAux.y <= pEnd.y) {
			// The drawing limit is pEnd.y
			int yEnd = pAux.y + SOLID_SIZE;
			if(yEnd > pEnd.y) {
				yEnd = pEnd.y;
			}
			graphics.drawLine(pAux, new Point(pAux.x, yEnd));
			pAux.y = pAux.y + DASHED_SIZE;
		}

		// int pixels = 10;

		// Update the size and the location of the rectangle representing the
		// dash line
		dashLineRectangle.setSize(1, pEnd.y - pStart.y);
		dashLineRectangle.setLocation(pStart);

	}
	
	/**
	 * Set the bounds on the figure and fix bounds for child dash line
	 * 
	 * @param rect
	 *        the new bounds
	 */
	@Override
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
		// set bounds for child dash line to avoid problems during connected
		// edges drawing
		Point pStart = new Point();
		Point pEnd = new Point();

		pStart.x = rect.x + rect.width / 2;
		pStart.y = rect.y + 1;

		pEnd.x = pStart.x;
		pEnd.y = pStart.y + rect.height - 1;

		// Update the size and the location of the rectangle representing the
		// dash line
		dashLineRectangle.setSize(1, pEnd.y - pStart.y);
		dashLineRectangle.setLocation(pStart);
	}

	/**
	 * Create a cross at the end of the figure. The cross will be drawn at the
	 * pEnd - pixels position
	 * 
	 * @param graphics
	 *        the graphics
	 * @param pEnd
	 *        the point used to position the cross
	 * @param pixels
	 *        the height which will be deduce from the pEnd to position the
	 *        cross
	 */
	private void drawCrossAtEnd(Graphics graphics, Point pEnd, int pixels) {
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

		graphics.drawLine(p1Start, p1End);
		graphics.drawLine(p2Start, p2End);
	}

	/**
	 * Get a rectangleFigure representing the dashLine
	 */
	public NodeFigure getDashLineRectangle() {
		return dashLineRectangle;
	}

}
