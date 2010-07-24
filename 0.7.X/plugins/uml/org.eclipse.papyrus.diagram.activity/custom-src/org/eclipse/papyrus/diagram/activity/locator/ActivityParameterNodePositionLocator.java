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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.papyrus.diagram.common.locator.AdvancedBorderItemLocator;

public class ActivityParameterNodePositionLocator extends AdvancedBorderItemLocator implements IBorderItemLocator {

	/** The offset to add to default position. (to avoid corner of rounded rectangles) */
	public static final int EXTRA_BORDER_DEFAULT_OFFSET = 8;

	/** The default size of a pin */
	public static final int DEFAULT_PIN_SIZE = 16;

	protected int borderItemOffset = 10;

	/** Constructor **/
	public ActivityParameterNodePositionLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/** Constructor **/
	public ActivityParameterNodePositionLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/** Constructor **/
	public ActivityParameterNodePositionLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		int side = findClosestSideOfParent(proposedLocation, getParentBorder());
		Point newTopLeft = locateOnBorder(realLocation.getTopLeft(), side, 0, borderItem);
		realLocation.setLocation(newTopLeft);
		return realLocation;
	}

	/**
	 * Find the closest side when x,y is inside parent.
	 * 
	 * @param proposedLocation
	 * @param parentBorder
	 * @return draw constant
	 */
	public static int findClosestSideOfParent(Rectangle proposedLocation, Rectangle parentBorder) {
		int side = AdvancedBorderItemLocator.findClosestSideOfParent(proposedLocation, parentBorder);
		// relocate side for North
		if(side == PositionConstants.NORTH) {
			Point parentCenter = parentBorder.getCenter();
			Point childCenter = proposedLocation.getCenter();
			if(childCenter.x < parentCenter.x) {
				return PositionConstants.WEST;
			} else {
				return PositionConstants.EAST;
			}
		}
		return side;
	}

	/**
	 * Ensure the suggested location actually lies on the parent boundary. The side takes
	 * precedence.
	 * 
	 * @param suggestedLocation
	 * @param suggestedSide
	 * @return point
	 */
	protected Point locateOnParent(Point suggestedLocation, int suggestedSide, IFigure borderItem) {
		Rectangle bounds = getParentBorder();
		int parentFigureWidth = bounds.width;
		int parentFigureHeight = bounds.height;
		int parentFigureX = bounds.x;
		int parentFigureY = bounds.y;
		Dimension borderItemSize = getSize(borderItem);
		int newX = suggestedLocation.x;
		int newY = suggestedLocation.y;
		int westX = parentFigureX + getBorderItemOffset().width;
		int eastX = parentFigureX + parentFigureWidth - getBorderItemOffset().width - borderItemSize.width;
		int southY = parentFigureY + parentFigureHeight - getBorderItemOffset().height - borderItemSize.height;
		int northY = parentFigureY + getBorderItemOffset().height + borderItemSize.height;
		if(suggestedSide == PositionConstants.WEST) {
			if(suggestedLocation.x != westX) {
				newX = westX;
			}
			if(suggestedLocation.y < borderItemSize.height) {
				newY = northY + borderItemSize.height;
			} else if(suggestedLocation.y > bounds.getBottomLeft().y - borderItemSize.height) {
				newY = southY - borderItemSize.height;
			}
		} else if(suggestedSide == PositionConstants.EAST) {
			if(suggestedLocation.x != eastX) {
				newX = eastX;
			}
			if(suggestedLocation.y < borderItemSize.height) {
				newY = northY + borderItemSize.height;
			} else if(suggestedLocation.y > bounds.getBottomLeft().y - borderItemSize.height) {
				newY = southY - borderItemSize.height;
			}
		} else if(suggestedSide == PositionConstants.SOUTH) {
			if(suggestedLocation.y != southY) {
				newY = southY;
			}
			if(suggestedLocation.x < bounds.getBottomLeft().x) {
				newX = westX + borderItemSize.width;
			} else if(suggestedLocation.x > bounds.getBottomRight().x - borderItemSize.width) {
				newX = eastX - borderItemSize.width;
			}
		} else { // NORTH should not be suggested, consider WEST instead
			if(suggestedLocation.x != westX) {
				newX = westX;
			}
			if(suggestedLocation.y < bounds.getTopLeft().y) {
				newY = northY + borderItemSize.height;
			} else if(suggestedLocation.y > bounds.getBottomLeft().y - borderItemSize.height) {
				newY = southY - borderItemSize.height;
			}
		}
		return new Point(newX, newY);
	}

	@Override
	public void relocate(IFigure borderItem) {
		// reset bounds of borderItem
		Dimension size = getSize(borderItem);
		Rectangle rectSuggested = getConstraint().getCopy();
		if(rectSuggested.getTopLeft().x == 0 && rectSuggested.getTopLeft().y == 0) {
			rectSuggested.setLocation(getPreferredLocation(borderItem));
		} else {
			// recovered constraint must be translated with the parent location to be absolute
			rectSuggested.setLocation(rectSuggested.getLocation().translate(getParentBorder().getTopLeft()));
		}
		rectSuggested.setSize(size);
		Rectangle validLocation = getValidLocation(rectSuggested, borderItem);
		// the constraint is not reset, but the item bounds are
		borderItem.setBounds(validLocation);
		// ensure the side property is correctly set
		setCurrentSideOfParent(findClosestSideOfParent(borderItem.getBounds(), getParentBorder()));
	}

	@Override
	protected Point getPreferredLocation(int side, IFigure borderItem) {
		return super.getPreferredLocation(side, borderItem);

		// manage position for in/out parameter
		// Rectangle bounds = getParentBorder();
		// int parentFigureWidth = bounds.width;
		// int parentFigureHeight = bounds.height;
		// int parentFigureX = bounds.x;
		// int parentFigureY = bounds.y;
		// int x = parentFigureX;
		// int y = parentFigureY;
		//
		// Dimension borderItemSize = getSize(borderItem);
		// switch(side) {
		// case PositionConstants.NORTH:
		// x += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().width;
		// y += -borderItemSize.height + getBorderItemOffset().height;
		// break;
		// case PositionConstants.EAST:
		// // take south east extremity to allow following pins placing above
		// x += parentFigureWidth - getBorderItemOffset().width;
		// y += parentFigureHeight - borderItemSize.height - EXTRA_BORDER_DEFAULT_OFFSET -
		// getBorderItemOffset().height;
		// break;
		// case PositionConstants.SOUTH:
		// x += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().width;
		// y += parentFigureHeight - getBorderItemOffset().height;
		// break;
		// case PositionConstants.WEST:
		// default:
		// x += -borderItemSize.width + getBorderItemOffset().width;
		// y += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().height;
		// }
		// return new Point(x, y);
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
