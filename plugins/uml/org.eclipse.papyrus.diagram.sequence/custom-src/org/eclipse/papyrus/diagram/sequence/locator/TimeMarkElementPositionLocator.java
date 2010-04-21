/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.diagram.sequence.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.locator.AdvancedBorderItemLocator;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart.LifelineFigure;
import org.eclipse.papyrus.diagram.sequence.figures.LifelineDotLineCustomFigure;

/**
 * This class is used to constrain the position of a Time/Duration related object on a Lifeline.
 */
public class TimeMarkElementPositionLocator extends AdvancedBorderItemLocator {

	/** Constructor **/
	public TimeMarkElementPositionLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/** Constructor **/
	public TimeMarkElementPositionLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/** Constructor **/
	public TimeMarkElementPositionLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		int side = findClosestSideOfParent(realLocation, getParentBorder());
		Point newTopLeft = locateOnBorder(realLocation.getTopLeft(), side, 0, borderItem);
		realLocation.setLocation(newTopLeft);
		return realLocation;
	}

	/**
	 * The y location takes precedence on the preferred side or on collision.
	 * 
	 * @param suggestedLocation
	 *        the suggester location (y must be respected)
	 * @param suggestedSide
	 *        the suggested side
	 * @param circuitCount
	 *        recursion count to avoid an infinite loop
	 * @return point
	 */
	protected Point locateOnBorder(Point suggestedLocation, int suggestedSide, int circuitCount, IFigure borderItem) {
		Point recommendedLocation = locateOnParent(suggestedLocation, suggestedSide, borderItem);

		IFigure conflictingBorderItem = getConflictingBorderItemFigure(recommendedLocation, borderItem);

		if(circuitCount == 0 && conflictingBorderItem != null) {
			if(suggestedSide == PositionConstants.WEST) {
				// west is occupied, try east
				return locateOnBorder(recommendedLocation, PositionConstants.EAST, circuitCount + 1, borderItem);
			} else { //EAST
				// east is occupied, try west
				return locateOnBorder(recommendedLocation, PositionConstants.WEST, circuitCount + 1, borderItem);
			}
		}
		return recommendedLocation;
	}


	/**
	 * Utility to calculate the bounds of the dot line to use as parent with consideration for the handle
	 * bounds inset.
	 * 
	 * @return <code>Rectangle</code> that is the bounds of the parent dot line.
	 */
	protected Rectangle getParentDotLineBorder() {
		// get the dot line of the lifeline if available
		for(Object childFig : getParentFigure().getChildren()) {
			if(childFig instanceof LifelineFigure) {
				LifelineDotLineCustomFigure dotline = ((LifelineFigure)childFig).getFigureLifelineDotLineFigure();
				return dotline.getBounds().getCopy();
			}
		}
		return super.getParentBorder();
	}

	/**
	 * Ensure the suggested location actually lies on the parent boundary. The
	 * side takes precedence.
	 * 
	 * @param suggestedLocation
	 * @param suggestedSide
	 * @return point
	 */
	protected Point locateOnParent(Point suggestedLocation, int suggestedSide, IFigure borderItem) {
		Rectangle bounds = getParentDotLineBorder();
		int parentFigureXCenter = bounds.getCenter().x;
		int parentFigureHeight = bounds.height;
		int parentFigureY = bounds.y;
		Dimension borderItemSize = getCorrectSize(borderItem);
		int newX = suggestedLocation.x;
		int newY = suggestedLocation.y;
		int westX = parentFigureXCenter - borderItemSize.width;// + getBorderItemOffset().width;
		int eastX = parentFigureXCenter;// - getBorderItemOffset().width;
		int southY = parentFigureY + parentFigureHeight - getBorderItemOffset().height;
		int northY = parentFigureY + getBorderItemOffset().height;
		if(suggestedSide == PositionConstants.WEST) {
			if(suggestedLocation.x != westX) {
				newX = westX;
			}
			if(suggestedLocation.y < bounds.getTopLeft().y) {
				newY = northY;
			} else if(suggestedLocation.y > bounds.getBottomLeft().y - borderItemSize.height) {
				newY = southY - borderItemSize.height;
			}
		} else { // EAST
			if(suggestedLocation.x != eastX) {
				newX = eastX;
			}
			if(suggestedLocation.y < bounds.getTopLeft().y) {
				newY = northY;
			} else if(suggestedLocation.y > bounds.getBottomLeft().y - borderItemSize.height) {
				newY = southY - borderItemSize.height;
			}
		}
		return new Point(newX, newY);
	}

	/**
	 * Find the closest side when x,y is inside parent.
	 * 
	 * @param proposedLocation
	 * @param parentBorder
	 * @return draw constant
	 */
	public static int findClosestSideOfParent(Rectangle proposedLocation, Rectangle parentBorder) {
		// Rectangle parentBorder = getParentBorder();
		Point parentCenter = parentBorder.getCenter();
		Point childCenter = proposedLocation.getCenter();
		if(childCenter.x < parentCenter.x) // West, North or South.
		{
			return PositionConstants.WEST;
		} else { // EAST, NORTH or SOUTH
			return PositionConstants.EAST;
		}
	}

	/**
	 * Relocate the child border item within the parent
	 * 
	 * @see org.eclipse.papyrus.diagram.common.locator.AdvancedBorderItemLocator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param borderItem
	 *        the item to relocate
	 */
	@Override
	public void relocate(IFigure borderItem) {
		// reset bounds of borderItem
		Dimension size = getCorrectSize(borderItem);
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

		// redraw time mark if necessary
		redrawTimeMarks(borderItem, validLocation);
	}

	/**
	 * Gets the size of the border item figure. Take in account the constraint as a minimum size.
	 * 
	 * @param borderItem
	 * @return the size of the border item figure.
	 */
	protected final Dimension getCorrectSize(IFigure borderItem) {
		Dimension size = getConstraint().getSize();
		if(size.isEmpty()) {
			size.union(borderItem.getPreferredSize(size.width, size.height));
		}
		return size;
	}

	/**
	 * Redraw the time marks
	 * 
	 * @param borderItem
	 *        the relocated border item
	 * @param location
	 *        the new location
	 */
	private void redrawTimeMarks(IFigure borderItem, Rectangle location) {
		for(Object child : borderItem.getChildren()) {
			if(child instanceof TimeConstraintEditPart.TimeMarkElementFigure) {
				((TimeConstraintEditPart.TimeMarkElementFigure)child).setCurrentSideOfFigure(getCurrentSideOfParent(), location);
			} else if(child instanceof TimeObservationEditPart.TimeMarkElementFigure) {
				((TimeObservationEditPart.TimeMarkElementFigure)child).setCurrentSideOfFigure(getCurrentSideOfParent(), location);
			} else if(child instanceof DurationConstraintEditPart.DurationConstraintFigure) {
				((DurationConstraintEditPart.DurationConstraintFigure)child).updateArrow(location.width, location.height);
			}
		}
	}
}
