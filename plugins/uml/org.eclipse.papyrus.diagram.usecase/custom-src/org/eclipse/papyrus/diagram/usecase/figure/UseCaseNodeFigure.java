/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IOvalAnchorableFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableOvalAnchor;

/**
 * UseCaseNodeFigure is in charge of managing the anchoring area and the anchor points for Ellipse
 */
public class UseCaseNodeFigure extends DefaultSizeNodeFigure implements IOvalAnchorableFigure {

	/**
	 * Instantiates a new use case node figure.
	 * 
	 * @param defSize the default size
	 */
	public UseCaseNodeFigure(Dimension defSize) {
		super(defSize);
	}

	/**
	 * Instantiates a new use case node figure.
	 * 
	 * @param width the specific width
	 * @param height the specific height
	 */
	public UseCaseNodeFigure(int width, int height) {
		super(width, height);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConnectionAnchor createDefaultAnchor() {
		return new SlidableOvalAnchor(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConnectionAnchor createAnchor(PrecisionPoint p) {
		if (p == null)
			return createDefaultAnchor();
		return new SlidableOvalAnchor(this, p);
	}

	/**
	 * {@inheritDoc}
	 */
	public Rectangle getOvalBounds() {
		return getBounds();
	}

}
