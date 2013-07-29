/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * This code comes form composite diagram. I was copied to avoid dependencies
 
 * <pre>          <---------+
 * 	 +------------+------|  |
 * 	 |    [Class]        | 	|
 * 	 +-------------------+  |
 * 	 |                  +-+ |  - Expected position of template signature 
 * 	 |                  +-+ |
 * 	 |                   |  \/
 * 	 |                   |
 * 	 |                   |
 * 	 +-------------------+
 * 
 * </pre>
 * 
 * <pre>
 * TODO  : The port is not re-sizable
 * </pre>
 */
public class TemplateBorderItemLocator extends PortPositionLocator{
	/**
	 * the width of the area surrounding the parent figure where border item can
	 * be put
	 */
	protected int borderItemOffset = 10;
	
	public TemplateBorderItemLocator(IFigure parentFigure, int preferredSide) {
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

		// Calculate Max position around the graphical parent (1/2 size or the
		// port around
		// the graphical parent bounds.
		int xMin = parentRec.x - borderItemOffset+parentRec.width/2;
		int xMax = parentRec.x - borderItemOffset + parentRec.width;
		int yMin = parentRec.y - borderItemOffset;
		int yMax = parentRec.y - borderItemOffset + parentRec.height/2;

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

		// Ensure the port is positioned on its parent borders and not in the
		// middle.
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
		if(realLocation.x==xMin && (yMin<realLocation.y && realLocation.y<=yMax)){
			realLocation.x=xMax;
		}

		if((xMin<=realLocation.x && realLocation.x<xMax)&& realLocation.y==yMax){
			realLocation.y=yMin;
		}
		// Return constrained location
		return realLocation;
	}

}
