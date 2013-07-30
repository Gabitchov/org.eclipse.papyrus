/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * A specific anchor to attach "create message" to the middle of the rectangle
 * representing the header of the lifeline
 * 
 */
public class LifelineAnchor extends AbstractConnectionAnchor {

	public LifelineAnchor(IFigure owner) {
		super(owner);
	}

	/**
	 * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
	 */
	public Point getLocation(Point reference) {

		if(getOwner() == null) {
			return null;
		}

		Rectangle r = getOwner().getBounds();

		Point p = new Point();

		p.y = r.y + r.getSize().height / 2;
		// By default x is set to the left side of the figure
		p.x = r.getLeft().x;

		if(reference != null) {
			// If the reference point is located at the right of the figure
			// means the point should be attached to the right side.
			if(reference.x > r.x) {
				p.x = r.getRight().x;
			}
		}

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
