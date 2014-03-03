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
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IOvalAnchorableFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableOvalAnchor;
import org.eclipse.swt.SWT;

/** Use to create a containment circle figure */
public class ContainmentFigure extends DefaultSizeNodeFigure implements IOvalAnchorableFigure {

	public ContainmentFigure() {
		this(20, 20);
	}

	/**
	 * Constructor for StateLineFigure.
	 * 
	 * @param width
	 *            figure width
	 * @param height
	 *            figure height
	 */
	public ContainmentFigure(int width, int height) {
		super(width, height);
	}

	/**
	 * Constructor for StateLineFigure.
	 * 
	 * @param dim
	 *            figure dimensions
	 */
	public ContainmentFigure(Dimension dim) {
		super(dim);
	}

	/**
	 * Constructor for StateLineFigure.
	 * 
	 * @param diameter
	 *            circle diameter
	 */
	public ContainmentFigure(int diameter) {
		this(diameter, diameter);
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics graphics) {
		graphics.setAntialias(SWT.LOW);
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getBounds());
		//
		// draw the circle.
		graphics.fillOval(r);

		r.width--;
		r.height--;
		graphics.drawOval(r);
		graphics.pushState();
		graphics.setBackgroundColor(ColorConstants.black);
		/* Creates the cross in the circle */
		Rectangle rect1 = getBounds().getCopy();
		int scaleFactor_horizontale = rect1.height / 2;
		int scaleFactor_verticale = rect1.width / 2;
		graphics.drawLine(rect1.x, rect1.y + scaleFactor_horizontale, rect1.x + (int) Math.floor(rect1.width * (scaleFactor_horizontale)), rect1.y - (1 - scaleFactor_horizontale));
		graphics.drawLine(rect1.x + scaleFactor_verticale, rect1.y, rect1.x - (1 - scaleFactor_verticale), rect1.y + (int) Math.floor(rect1.height * (scaleFactor_verticale)));
		graphics.popState();
	}

	/** Return <code>getBounds()</code>. */
	public final Rectangle getOvalBounds() {
		return getBounds();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#createAnchor(org.eclipse.draw2d.geometry.PrecisionPoint)
	 */
	protected ConnectionAnchor createAnchor(PrecisionPoint p) {
		if (p == null)
			// If the old terminal for the connection anchor cannot be resolved (by SlidableAnchor) a null
			// PrecisionPoint will passed in - this is handled here
			return createDefaultAnchor();
		return new SlidableOvalAnchor(this, p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#createDefaultAnchor()
	 */
	protected ConnectionAnchor createDefaultAnchor() {
		return new SlidableOvalAnchor(this);
	}

	/**
	 * Fills the circle.
	 * 
	 * @param graphics
	 *            the graphics
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

}
