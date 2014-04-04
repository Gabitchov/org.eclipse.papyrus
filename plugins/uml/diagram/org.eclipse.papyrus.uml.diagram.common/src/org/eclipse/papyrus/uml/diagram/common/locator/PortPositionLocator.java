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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;

/**
 * 
 * This code comes form composite diagram. I was copied to avoid dependencies
 * This class is used to constrain the position of Port when they are added on a Property or a
 * StructuredClassifier
 * 
 * <pre>
 * 	 +-------------------+
 * 	 |    [Class]        |
 * 	 +-------------------+
 * 	 |                   |
 * 	 |                   |
 * 	 |                  +-+ - Expected position of Port 
 * 	 |                  +-+
 * 	 |                   |
 * 	 +-------------------+
 * 
 * </pre>
 * 
 * <pre>
 * TODO  : The port is not re-sizable
 * </pre>
 */
public class PortPositionLocator implements IBorderItemLocator {

	/** the figure around which this border item appears */
	protected IFigure parentFigure = null;

	/** the width of the area surrounding the parent figure where border item can be put */
	protected int borderItemOffset = 10;

	
	public int getBorderItemOffset() {
		return borderItemOffset;
	}

	
	public void setBorderItemOffset(int borderItemOffset) {
		this.borderItemOffset = borderItemOffset;
	}

	/**
	 * get the parent figure
	 * 
	 * @return the parent figure
	 */
	public IFigure getParentFigure() {
		return parentFigure;
	}

	/** the position constraint */
	protected Rectangle constraint = new Rectangle(0, 0, 0, 0);

	/** Constructor **/
	public PortPositionLocator(IFigure parentFigure, int preferredSide) {
		// The preferredSide parameter is not used, just kept here to ensure compatibility 
		// with GMF generated code.
		this.parentFigure = parentFigure;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getValidLocation(org.eclipse.draw2d.geometry.Rectangle,
	 *      org.eclipse.draw2d.IFigure)
	 * 
	 * @param proposedLocation
	 * @param borderItem
	 * @return a valid location
	 */
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		return getPreferredLocation(proposedLocation);
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
		int xMin = parentRec.x - borderItemOffset;
		int xMax = parentRec.x - borderItemOffset + parentRec.width;
		int yMin = parentRec.y - borderItemOffset;
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

		//commented by V. Lorenzo to allow to create port on the top of a figure
		//replaced by the next block of code
		
		// Ensure the port is positioned on its parent borders and not in the middle.
		// Modify position if needed.
		//		if((realLocation.y != yMin) && (realLocation.y != yMax)) {
		//			if((realLocation.x != xMin) && (realLocation.x != xMax)) {
		//
		//				if(realLocation.x <= (xMin + (parentRec.width / 2))) {
		//					realLocation.x = xMin;
		//				} else {
		//					realLocation.x = xMax;
		//				}
		//			}
		//		}
		
		//this code replaces the previous commented lines
		final Rectangle maxRect = parentRec.getCopy();
		maxRect.shrink(-borderItemOffset, -borderItemOffset);
		while(maxRect.contains(realLocation.getLocation())) {
			maxRect.shrink(1, 1);
		}
		int pos = maxRect.getPosition(realLocation.getLocation());
		switch(pos) {
		case PositionConstants.NORTH:
			realLocation.y = yMin;
			break;
		case PositionConstants.SOUTH:
			realLocation.y = yMax;
			break;
		case PositionConstants.EAST:
			realLocation.x = xMax;
			break;
		case PositionConstants.WEST:
			realLocation.x = xMin;
			break;
		case PositionConstants.NORTH_EAST:
			realLocation.x = xMax;
			realLocation.y = yMin;
			break;
		case PositionConstants.NORTH_WEST:
			realLocation.x = xMin;
			realLocation.y = yMin;
			break;
		case PositionConstants.SOUTH_EAST:
			realLocation.x = xMax;
			realLocation.y = yMax;
			break;
		case PositionConstants.SOUTH_WEST:
			realLocation.x = xMin;
			realLocation.y = yMax;
			break;
		}
		
		// Return constrained location
		return realLocation;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getCurrentSideOfParent()
	 * 
	 * @return
	 *         the position of the port around its parent. This position can be
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
	public int getCurrentSideOfParent() {
		int position = PositionConstants.NONE;

		//we are not on EAST, not on WEST, but we are on the NORTH
		if((constraint.x != parentFigure.getBounds().width - borderItemOffset) && (constraint.x != -this.borderItemOffset) && (constraint.y == -this.borderItemOffset)) {
			position = PositionConstants.NORTH;

			//we are not on the EAST and not on the WEST, but we are on the SOUTH			
		} else if((constraint.x != parentFigure.getBounds().width - borderItemOffset) && (constraint.x != -this.borderItemOffset) && (constraint.y == parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.SOUTH;

			//we are on the EAST, but we are not on the NORTH and not on the SOUTH
		} else if((constraint.x == parentFigure.getBounds().width - borderItemOffset) && (constraint.y != -this.borderItemOffset) && (constraint.y != parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.EAST;

			//we are on the WEST, but we are not on the on the NORTH and not on the SOUTH
		} else if((constraint.x == -this.borderItemOffset) && (constraint.y != -this.borderItemOffset) && (constraint.y != parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.WEST;

			//we are on the NORTH and on the EAST
		} else if((constraint.x == parentFigure.getBounds().width - borderItemOffset) && (constraint.y == -this.borderItemOffset)) {
			position = PositionConstants.NORTH_EAST;

			//we are on the NORTH and on the WEST
		} else if((constraint.x == -this.borderItemOffset) && (constraint.y == -this.borderItemOffset)) {
			position = PositionConstants.NORTH_WEST;

			//we are on the EAST and on the SOUTH
		} else if((constraint.x == parentFigure.getBounds().width - borderItemOffset) && (constraint.y == parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.SOUTH_EAST;

			//we are on the WEST and on the SOUTH
		} else if((constraint.x == -this.borderItemOffset) && (constraint.y == parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.SOUTH_WEST;
		}

		return position;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#setConstraint(org.eclipse.draw2d.geometry.Rectangle)
	 * 
	 * @param constraint
	 */
	public void setConstraint(Rectangle constraint) {
		this.constraint = constraint;

	}

	/**
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param target
	 */
	public void relocate(IFigure target) {

		Rectangle proposedLocation = constraint.getCopy();
		proposedLocation.setLocation(constraint.getLocation().translate(parentFigure.getBounds().getTopLeft()));

		Point validLocation = getValidLocation(proposedLocation, target).getLocation();

		target.setBounds(new Rectangle(validLocation, target.getPreferredSize()));
	}
}
