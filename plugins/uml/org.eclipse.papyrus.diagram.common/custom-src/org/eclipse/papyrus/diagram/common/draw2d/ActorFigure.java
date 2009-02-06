/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – UseCase Diagram Implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class ActorFigure.
 * 
 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a>
 */
public class ActorFigure extends Shape {

	// Percentages in function of the Y axis.
	/** The HEA d_ p. */
	private static double HEAD_P = 0.3;

	/** The BOD y_ p. */
	private static double BODY_P = 0.35;

	/** The LEG s_ p. */
	private static double LEGS_P = 0.35;

	/**
	 * Instantiates a new actor figure.
	 */
	public ActorFigure() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void fillShape(Graphics graphics) {

		Rectangle r = getBounds();

		// Filling area of the Actor
		// HEAD
		graphics.fillOval(getHeadRectangle());

	}

	/**
	 * Gets the head rectangle.
	 * 
	 * @return the head rectangle
	 */
	protected Rectangle getHeadRectangle() {
		Rectangle r = getBounds();

		double halfEdge = r.height * HEAD_P / 2; // half edge of the square
		// in which the circle in
		// included
		Point headStart = new Point();
		headStart.x = (int) (r.x + r.width / 2 - halfEdge);
		headStart.y = (r.y + 1);

		Point headEnd = new Point();
		headEnd.x = (int) (headStart.x + 2 * halfEdge);
		headEnd.y = (int) (headStart.y + 2 * halfEdge);

		Rectangle headRectangle = new Rectangle(headStart, headEnd);
		return headRectangle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle r = getBounds();

		// HEAD
		double halfEdge = r.height * HEAD_P / 2; // half edge of the square
		// in which the circle in
		// included

		Rectangle headRectangle = getHeadRectangle();
		graphics.drawOval(headRectangle);

		Point headEnd = new Point(headRectangle.getBottomRight());

		// BODY
		Point bodyStart = new Point();
		bodyStart.x = (int) (headEnd.x - halfEdge);
		bodyStart.y = headEnd.y;

		Point bodyEnd = new Point();
		bodyEnd.x = bodyStart.x;
		bodyEnd.y = (int) (bodyStart.y + r.height * BODY_P);

		graphics.drawLine(bodyStart, bodyEnd);

		// ARMS
		Point ArmsStart = new Point();
		double armMargin = r.height * BODY_P;
		ArmsStart.x = (int) ((r.x + r.width / 2) - 1 - armMargin);
		ArmsStart.y = (int) (bodyStart.y + r.height * BODY_P / 2);

		Point ArmsEnd = new Point();
		ArmsEnd.x = (int) ((r.x + r.width / 2) + 1 + armMargin);
		ArmsEnd.y = ArmsStart.y;

		graphics.drawLine(ArmsStart, ArmsEnd);

		// LEFT LEG
		Point leftLegStart = new Point();
		leftLegStart.x = bodyEnd.x;
		leftLegStart.y = bodyEnd.y;

		Point leftLegEnd = new Point();
		leftLegEnd.x = ArmsStart.x;
		leftLegEnd.y = (int) (leftLegStart.y + r.height * LEGS_P);

		graphics.drawLine(leftLegStart, leftLegEnd);

		// RIGHT LEG
		Point rightLegStart = new Point();
		rightLegStart.x = leftLegStart.x;
		rightLegStart.y = leftLegStart.y;

		Point rightLegEnd = new Point();
		rightLegEnd.x = ArmsEnd.x;
		rightLegEnd.y = leftLegEnd.y;

		graphics.drawLine(rightLegStart, rightLegEnd);
	}

}
