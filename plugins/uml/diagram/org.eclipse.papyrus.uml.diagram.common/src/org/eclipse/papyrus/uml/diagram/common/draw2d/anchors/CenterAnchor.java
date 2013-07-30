/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.draw2d.anchors;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * An anchor at the center of the figure.
 */
public class CenterAnchor extends AbstractConnectionAnchor {

	public CenterAnchor(IFigure owner) {
		super(owner);
	}

	/**
	 * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
	 */
	public Point getLocation(Point reference) {

		if(getOwner() == null) {
			return null;
		}
		// Get the rectangle
		Rectangle r = getOwner().getBounds();

		// Get the center point
		Point p = r.getCenter();

		// Translate the point to absolute
		getOwner().translateToAbsolute(p);

		return p;
	}

	/**
	 * Overrides to disable the reference point
	 * 
	 * @see org.eclipse.draw2d.AbstractConnectionAnchor#getReferencePoint()
	 */
	@Override
	public Point getReferencePoint() {
		return getLocation(null);
	}

}
