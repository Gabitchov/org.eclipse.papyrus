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
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.draw2d.anchors;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;

/**
 * An anchor that is attached to the top or the bottom of a figure.
 * 
 * @author tszadel
 * 
 */
public class FixedAnchor extends SlidableAnchor {

	/** Anchor is at the top of the figure. */
	public static final int TOP = 0;

	/** Anchor is at the bottom of the figure. */
	public static final int BOTTOM = 1;

	/**
	 * Constructor.
	 * 
	 * @param f
	 *        The figure.
	 * @param location
	 *        The location of the anchor ({@link FixedAnchor#TOP} or {@link FixedAnchor#BOTTOM}).
	 */
	public FixedAnchor(IFigure f, int location) {
		super(f, location == TOP ? new PrecisionPoint(0.5, 0.0) : new PrecisionPoint(0.5, 1.0));
	}

	/**
	 * Constructor.
	 * 
	 * @param f
	 *        The figure.
	 */
	public FixedAnchor(IFigure f) {
		super(f);
	}

	/**
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor#isDefaultAnchor()
	 * 
	 * @return
	 */

	@Override
	public boolean isDefaultAnchor() {
		return false;
	}

}
