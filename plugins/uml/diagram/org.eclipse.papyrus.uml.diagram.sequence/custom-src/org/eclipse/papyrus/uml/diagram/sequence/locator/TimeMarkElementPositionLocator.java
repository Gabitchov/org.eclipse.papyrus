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
package org.eclipse.papyrus.uml.diagram.sequence.locator;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.locator.AdvancedBorderItemLocator;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomDurationConstraintEditPart.CustomDurationConstraintFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomTimeConstraintEditPart.TimeConstraintFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomTimeObservationEditPart.TimeObservationFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineDotLineCustomFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * This class is used to constrain the position of a Time/Duration related object on a Lifeline.
 */
public class TimeMarkElementPositionLocator extends AdvancedBorderItemLocator {

	/**
	 * The edit part which figure is located.
	 * Used to know the horizontal gap or whether the occurrence specifies a destruction event.
	 */
	private EditPart editPart = null;

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

	/** Set the edit part which figure is placed by this locator */
	public void setEditPart(EditPart part) {
		editPart = part;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		int side = findClosestSideOfParent(realLocation, getParentBorder());
		Point newTopLeft = locateOnBorder(realLocation.getTopLeft(), side, 0, borderItem);
		// correct in case the figure is linked to a destruction event
		if(timeElementPointsDestructionEvent()) {
			Point destr = getDestructionEventCenter();
			if(destr != null) {
				if(editPart instanceof DurationConstraintEditPart) {
					// bottom is at the destruction event y
					realLocation.height = destr.y - newTopLeft.y;
				} else if(editPart instanceof TimeObservationEditPart || editPart instanceof TimeConstraintEditPart) {
					// center is at the destruction event y
					newTopLeft.y = destr.y - realLocation.height / 2;
				}
			}
		}
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
	@Override
	protected Point locateOnBorder(Point suggestedLocation, int suggestedSide, int circuitCount, IFigure borderItem) {
		Point recommendedLocation = locateOnParent(suggestedLocation, suggestedSide, borderItem);
		IFigure conflictingBorderItem = getConflictingBorderItemFigure(recommendedLocation, borderItem);
		// max circuit count of 2 allows to try other side, then go back to original side if occupied
		if(circuitCount < 2 && conflictingBorderItem != null) {
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
	@Override
	protected Point locateOnParent(Point suggestedLocation, int suggestedSide, IFigure borderItem) {
		int[] horizontalGap = getHorizontalGap();
		Rectangle bounds = getParentDotLineBorder();
		int parentFigureXCenter = bounds.getCenter().x;
		int parentFigureHeight = bounds.height;
		int parentFigureY = bounds.y;
		Dimension borderItemSize = getCorrectSize(borderItem);
		int newX = suggestedLocation.x;
		int newY = suggestedLocation.y;
		int westX = parentFigureXCenter - borderItemSize.width + horizontalGap[0];
		int eastX = parentFigureXCenter + horizontalGap[1];
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
	 * Get the center of the destruction event figure (relative)
	 * 
	 * @return the destruction center or null
	 */
	private Point getDestructionEventCenter() {
		LifelineEditPart lifeline = SequenceUtil.getParentLifelinePart(editPart);
		if(lifeline != null) {
			for(Object child : lifeline.getChildren()) {
				if(child instanceof DestructionOccurrenceSpecificationEditPart) {
					return ((DestructionOccurrenceSpecificationEditPart)child).getFigure().getBounds().getCenter();
				}
			}
		}
		return null;
	}

	/**
	 * Know whether the figure must be located all down because its element references a destruction event
	 * 
	 * @return true if destruction event is referenced
	 */
	private boolean timeElementPointsDestructionEvent() {
		if(editPart instanceof GraphicalEditPart) {
			// get event occurrence(s)
			EObject element = ((GraphicalEditPart)editPart).resolveSemanticElement();
			List<? extends Element> occurrences = Collections.emptyList();
			if(element instanceof TimeObservation) {
				NamedElement occurence = ((TimeObservation)element).getEvent();
				occurrences = Collections.singletonList(occurence);
			} else if(element instanceof TimeConstraint || element instanceof DurationConstraint) {
				occurrences = ((IntervalConstraint)element).getConstrainedElements();
			}
			for(Element occurrence : occurrences) {
				if(occurrence instanceof DestructionOccurrenceSpecificationEditPart) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get the gaps to know how the figure must be translated from the center of the lifeline, taking in account executions.
	 * 
	 * @return a size 2 array with left translation at index 0 et right at index 1
	 */
	private int[] getHorizontalGap() {
		int[] horizontalGap = new int[]{ 0, 0 };
		if(editPart instanceof GraphicalEditPart) {
			// get event occurrence(s)
			LifelineEditPart lifeline = SequenceUtil.getParentLifelinePart(editPart);
			EObject element = ((GraphicalEditPart)editPart).resolveSemanticElement();
			List<? extends Element> occurrences = Collections.emptyList();
			if(element instanceof TimeObservation) {
				NamedElement occurence = ((TimeObservation)element).getEvent();
				occurrences = Collections.singletonList(occurence);
			} else if(element instanceof TimeConstraint || element instanceof DurationConstraint) {
				occurrences = ((IntervalConstraint)element).getConstrainedElements();
			}
			boolean horizontalGapSet = false;
			// check bounds of event's execution
			for(Element occurrence : occurrences) {
				if(occurrence instanceof OccurrenceSpecification) {
					EditPart part = SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occurrence);
					if(part instanceof ConnectionEditPart && occurrence instanceof MessageOccurrenceSpecification) {
						// get the bounds of the execution on which the connection is connected
						ConnectionEditPart conn = (ConnectionEditPart)part;
						Message message = ((MessageOccurrenceSpecification)occurrence).getMessage();
						if(message != null) {
							boolean start = message.getSendEvent() != null && message.getSendEvent().equals(occurrence);
							if(start) {
								part = conn.getSource();
							} else {
								part = conn.getTarget();
							}
						}
					}
					if(part instanceof ShapeNodeEditPart && !lifeline.equals(part)) {
						Rectangle execBounds = ((ShapeNodeEditPart)part).getFigure().getBounds();
						Rectangle parentBounds = getParentBorder();
						int leftGap = execBounds.getLeft().x - parentBounds.getCenter().x;
						int rightGap = execBounds.getRight().x - parentBounds.getCenter().x;
						if(part instanceof DestructionOccurrenceSpecificationEditPart) {
							// center of destruction event is considered
							leftGap = 0;
							rightGap = 0;
						}
						if(!horizontalGapSet) {
							horizontalGap[0] = leftGap;
							horizontalGap[1] = rightGap;
							horizontalGapSet = true;
						} else {
							// take the more exterior gap of all events
							horizontalGap[0] = Math.min(horizontalGap[0], leftGap);
							horizontalGap[1] = Math.max(horizontalGap[1], rightGap);
						}
					}
				}
			}
		}
		return horizontalGap;
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
	 * @see org.eclipse.papyrus.uml.diagram.common.locator.AdvancedBorderItemLocator#relocate(org.eclipse.draw2d.IFigure)
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
		if(timeElementPointsDestructionEvent() && editPart instanceof DurationConstraintEditPart) {
			// except when duration constraint is reduced ...
			int w = getConstraint().getSize().width;
			getConstraint().setSize(w, validLocation.height);
		}
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
			if(child instanceof TimeConstraintFigure) {
				((TimeConstraintFigure)child).setCurrentSideOfFigure(getCurrentSideOfParent(), location);
			} else if(child instanceof TimeObservationFigure) {
				((TimeObservationFigure)child).setCurrentSideOfFigure(getCurrentSideOfParent(), location);
			} else if(child instanceof CustomDurationConstraintFigure) {
				((CustomDurationConstraintFigure)child).updateArrow(location.width, location.height);
			} else if(child instanceof DefaultSizeNodeFigure) {
				redrawTimeMarks((IFigure)child, location);
			}
		}
	}
}
