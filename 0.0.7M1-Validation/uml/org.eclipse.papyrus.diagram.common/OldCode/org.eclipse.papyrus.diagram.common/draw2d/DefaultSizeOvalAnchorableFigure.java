/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IOvalAnchorableFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableOvalAnchor;

/**
 * 
 * This figure has advantages of both
 * OvalAnchorableFigure(org.eclipse.gmf.runtime.gef.ui.internal.figures.OvalFigure) and
 * DefaultSizeNodeFigure Figure is created with a specified default size, links are attached to an
 * oval, not to a rectangles.
 * 
 */
public class DefaultSizeOvalAnchorableFigure extends DefaultSizeNodeFigure implements IOvalAnchorableFigure {

	public DefaultSizeOvalAnchorableFigure(int width, int height) {
		super(width, height);
	}

	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		Rectangle ovalRect = getOvalBounds();
		g.fillOval(ovalRect);
		g.drawOval(ovalRect);

	}

	/**
	 * @return Rectangle that bounds the oval that is to be drawn. This may or may not be the same
	 *         as the bounds of the figure itself.
	 */
	public Rectangle getOvalBounds() {
		Rectangle r = getBounds();
		Rectangle ovalRect = new Rectangle(r);

		// not using the full bounds of the rectangle to draw
		// the oval in as it results in the top and the left
		// edge of the oval being chopped off. That is why
		// we are indenting by 1
		ovalRect.setSize(r.width - 1, r.height - 1);
		return ovalRect;
	}

	@Override
	protected ConnectionAnchor createAnchor(PrecisionPoint p) {
		if (p == null) {
			// If the old terminal for the connection anchor cannot be resolved
			// (by SlidableAnchor) a null
			// PrecisionPoint will passed in - this is handled here
			return createDefaultAnchor();
		}
		return new SlidableOvalAnchor(this, p);
	}

	@Override
	protected ConnectionAnchor createDefaultAnchor() {
		return new SlidableOvalAnchor(this);
	}

}
