/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		Patrick Tessier (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.locators;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.locator.PortPositionLocator;

/**
 *used to place the symbol behavior at the good place (inside the composite). 
 *
 */
public class BehaviorPortLocator extends PortPositionLocator {

	public BehaviorPortLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}
	
	
	/**
	 * 
	 * @param proposedLocation
	 *        the proposed location
	 * @return a possible location on parent figure border
	 */
	public Rectangle getPreferredLocation(Rectangle proposedLocation) {

		// Initialize port location with proposed location
		// and resolve the bounds of it graphical parent
		Rectangle realLocation = new Rectangle(proposedLocation);

		Rectangle parentRec = getParentFigure().getBounds().getCopy();

		// Calculate Max position around the graphical parent (1/2 size or the port around
		// the graphical parent bounds.
		//this is an intra rectangle
		int xMin = parentRec.x + borderItemOffset;
		int xMax = parentRec.x - borderItemOffset + parentRec.width;
		int yMin = parentRec.y + borderItemOffset;
		int yMax = parentRec.y - borderItemOffset + parentRec.height;

		// Modify Port location if MAX X or Y are exceeded
		if(realLocation.x < xMin) {
			realLocation.x = xMin;
		}

		if(realLocation.x > xMax) {
			realLocation.x = xMax;
		}

		if(realLocation.y < yMin) {
			realLocation.y = yMin;
		}

		if(realLocation.y > yMax) {
			realLocation.y = yMax;
		}

		// Ensure the port is positioned on its parent borders and not in the middle.
		// Modify position if needed.
		if((realLocation.y != yMin) && (realLocation.y != yMax)) {
			if((realLocation.x != xMin) && (realLocation.x != xMax)) {

				if(realLocation.x <= (xMin + (parentRec.width / 2))) {
					realLocation.x = xMin;
				} else {
					realLocation.x = xMax;
				}
			}
		}

		// Return constrained location
		return realLocation;
	}
}
