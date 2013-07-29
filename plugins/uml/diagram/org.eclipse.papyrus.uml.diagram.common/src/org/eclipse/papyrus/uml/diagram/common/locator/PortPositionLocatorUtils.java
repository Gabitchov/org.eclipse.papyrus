/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.locator;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * <pre>
 * This class provides convenience methods to manage Port location.
 * 
 * The method are base on the Port and its graphical parent bounds (given as Rectangle), which can either be 
 * based on the figure bounds or the view bounds.
 * </pre>
 */
public class PortPositionLocatorUtils {

	/**
	 * Get the valid border location of the Port with the proposed location on
	 * the parent.
	 * @param parentFigureBounds the parent bounds.
	 * @param proposedFigureBounds the proposed Port bounds.
	 * @param borderItemOffset the overlapping size of the Port over its parent figure. 
	 * @return the allowed bounds for the Port (location relative to parent
	 *         TopLeft point).
	 */
	public static Rectangle getBorderLocation(Rectangle parentFigureBounds, Rectangle proposedFigureBounds, int borderItemOffset) {

		// Initialize port location with proposed location
		// and resolve the bounds of it graphical parent
		Rectangle realLocation = proposedFigureBounds.getCopy();

		Rectangle parentRec = parentFigureBounds.getCopy();

		// Calculate Max position around the graphical parent (1/2 size or the
		// port around
		// the graphical parent bounds.
		int xMin = - borderItemOffset;
		int xMax = - borderItemOffset + parentRec.width;
		int yMin = - borderItemOffset;
		int yMax = - borderItemOffset + parentRec.height;

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

		// Return constrained location
		return realLocation;
	}
	
	/**
	 * Get the current side (on the parent) where the Port is located.
	 * @param parentFigureBounds the parent bounds.
	 * @param proposedFigureBounds the proposed Port bounds.
	 * @param borderItemOffset the overlapping size of the Port over its parent figure. 

	 * @return the position of the port around its parent. This position can be
	 *         <ul>
	 *         <li>{@linkplain PositionConstants#NORTH}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH}</li>
	 *         <li> {@linkplain PositionConstants#EAST}</li>
	 *         <li> {@linkplain PositionConstants#WEST}</li>
	 *         <li> {@linkplain PositionConstants#NORTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#NORTH_WEST}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH_WEST}</li>
	 *         </ul>
	 */
	public static int getCurrentSideOfParent(Rectangle parentFigureBounds, Rectangle figureBounds, int borderItemOffset) {
		int position = PositionConstants.NONE;

		// we are not on EAST, not on WEST, but we are on the NORTH
		if((figureBounds.x != parentFigureBounds.width - borderItemOffset) && (figureBounds.x != -borderItemOffset) && (figureBounds.y == -borderItemOffset)) {
			position = PositionConstants.NORTH;

			// we are not on the EAST and not on the WEST, but we are on the
			// SOUTH
		} else if((figureBounds.x != parentFigureBounds.width - borderItemOffset) && (figureBounds.x != -borderItemOffset) && (figureBounds.y == parentFigureBounds.height - borderItemOffset)) {
			position = PositionConstants.SOUTH;

			// we are on the EAST, but we are not on the NORTH and not on the
			// SOUTH
		} else if((figureBounds.x == parentFigureBounds.width - borderItemOffset) && (figureBounds.y != -borderItemOffset) && (figureBounds.y != parentFigureBounds.height - borderItemOffset)) {
			position = PositionConstants.EAST;

			// we are on the WEST, but we are not on the on the NORTH and not on
			// the SOUTH
		} else if((figureBounds.x == -borderItemOffset) && (figureBounds.y != -borderItemOffset) && (figureBounds.y != parentFigureBounds.height - borderItemOffset)) {
			position = PositionConstants.WEST;

			// we are on the NORTH and on the EAST
		} else if((figureBounds.x == parentFigureBounds.width - borderItemOffset) && (figureBounds.y == -borderItemOffset)) {
			position = PositionConstants.NORTH_EAST;

			// we are on the NORTH and on the WEST
		} else if((figureBounds.x == -borderItemOffset) && (figureBounds.y == -borderItemOffset)) {
			position = PositionConstants.NORTH_WEST;

			// we are on the EAST and on the SOUTH
		} else if((figureBounds.x == parentFigureBounds.width - borderItemOffset) && (figureBounds.y == parentFigureBounds.height - borderItemOffset)) {
			position = PositionConstants.SOUTH_EAST;

			// we are on the WEST and on the SOUTH
		} else if((figureBounds.x == -borderItemOffset) && (figureBounds.y == parentFigureBounds.height - borderItemOffset)) {
			position = PositionConstants.SOUTH_WEST;
		}

		return position;
	}
	
}
