/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Vincent Lorenzo(CEA-List) vincent.lorenzo@cea.fr - getCurrentSideOfParent()
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * This code comes form composite diagram. I was copied to avoid dependencies
 * This class is used to constrain the position of ConstraintParameter when they are added on a ConstraintProperty
 * 
 * <pre>
 * 	 +-------------------+
 * 	 |   [Constraint]    |
 * 	 +-------------------+
 * 	 |                   |
 * 	 |                   |
 * 	 |                 +-+ - Expected position of ConstraintParameter 
 * 	 |                 +-+
 * 	 |                   |
 * 	 +-------------------+
 * 
 * </pre>
 * 
 * <pre>
 * TODO  : The ConstraintParameter is not re-sizable
 * </pre>
 */
public class ConstraintParameterPositionLocator extends PortPositionLocator {

	/** the width of the area surrounding the parent figure where border item can be put */

	private int constraintParameterSize = 20;
	
	/** Constructor **/
	public ConstraintParameterPositionLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
		borderItemOffset = 0;
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
		int xMin = parentRec.x;
		int xMax = parentRec.x + parentRec.width - constraintParameterSize;
		int yMin = parentRec.y;
		int yMax = parentRec.y + parentRec.height - constraintParameterSize;

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
