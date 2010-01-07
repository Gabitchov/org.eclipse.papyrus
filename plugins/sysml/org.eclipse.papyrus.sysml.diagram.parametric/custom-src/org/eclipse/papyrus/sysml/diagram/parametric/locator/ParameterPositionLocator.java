/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.sysml.diagram.parametric.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.locator.AdvancedBorderItemLocator;

public class ParameterPositionLocator extends AdvancedBorderItemLocator {

	/** The offset to add to default position. (to avoid corner of rounded rectangles) */
	private static final int EXTRA_BORDER_DEFAULT_OFFSET = 8;

	/** Constructor **/
	public ParameterPositionLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/** Constructor **/
	public ParameterPositionLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/** Constructor **/
	public ParameterPositionLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		realLocation.width = Math.max(realLocation.width, realLocation.height);
		realLocation.height = realLocation.width;
		int side = findClosestSideOfParent(proposedLocation, getParentBorder());
		Point newTopLeft = locateOnBorder(realLocation.getTopLeft(), side, 0, borderItem);
		realLocation.setLocation(newTopLeft);
		return realLocation;
	}

	/**
	 * Re-arrange the location of the border item, and also the contained arrow.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param borderItem
	 */
	@Override
	public void relocate(IFigure borderItem) {
		// reset bounds of borderItem
		Dimension size = getSize(borderItem);
		Rectangle rectSuggested = getConstraint();
		if (rectSuggested.getTopLeft().x == 0 && rectSuggested.getTopLeft().y == 0) {
			rectSuggested.setLocation(getPreferredLocation(borderItem));
		}
		rectSuggested.setSize(size);
		setConstraint(getValidLocation(rectSuggested, borderItem));
		borderItem.setBounds(getConstraint().getCopy());
		// ensure the side property is correctly set
		setCurrentSideOfParent(findClosestSideOfParent(borderItem.getBounds(), getParentBorder()));

		// refresh the arrow depending on the Pin type and the side on which it is located
		/*
		 * for(Object subfigure : borderItem.getChildren()) { if(subfigure instanceof IFigure) {
		 * for(Object child : ((IFigure)subfigure).getChildren()) {
		 * 
		 * if(child instanceof ParameterDescriptor) { Polyline arrow =
		 * ((ParameterDescriptor)child).getOptionalArrowFigure(); int arrowDirection; int side =
		 * getCurrentSideOfParent(); switch(side) { case PositionConstants.NORTH: arrowDirection =
		 * PositionConstants.SOUTH; break; case PositionConstants.EAST: arrowDirection =
		 * PositionConstants.WEST; break; case PositionConstants.SOUTH: arrowDirection =
		 * PositionConstants.NORTH; break; case PositionConstants.WEST: default: arrowDirection =
		 * PositionConstants.EAST; } ActivityFigureDrawer.redrawPinArrow(arrow,
		 * MapModeUtil.getMapMode(borderItem), size, arrowDirection); } else if(child instanceof
		 * org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinEditPart.PinDescriptor) {
		 * Polyline arrow =
		 * ((org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinEditPart.PinDescriptor
		 * )child).getOptionalArrowFigure(); int arrowDirection; int side =
		 * getCurrentSideOfParent(); switch(side) { case PositionConstants.SOUTH: arrowDirection =
		 * PositionConstants.SOUTH; break; case PositionConstants.WEST: arrowDirection =
		 * PositionConstants.WEST; break; case PositionConstants.NORTH: arrowDirection =
		 * PositionConstants.NORTH; break; case PositionConstants.EAST: default: arrowDirection =
		 * PositionConstants.EAST; } ActivityFigureDrawer.redrawPinArrow(arrow,
		 * MapModeUtil.getMapMode(borderItem), size, arrowDirection); } } } }
		 */
	}

	/**
	 * Get an initial location based on the side. ( appropriate extremity of the side )
	 * 
	 * @param side
	 *            the preferred side of the parent figure on which to place this border item as
	 *            defined in {@link PositionConstants}
	 * @return point
	 */
	protected Point getPreferredLocation(int side, IFigure borderItem) {
		Rectangle bounds = getParentBorder();
		int parentFigureWidth = bounds.width;
		int parentFigureHeight = bounds.height;
		int parentFigureX = bounds.x;
		int parentFigureY = bounds.y;
		int x = parentFigureX;
		int y = parentFigureY;

		Dimension borderItemSize = getSize(borderItem);
		switch (side) {
		case PositionConstants.NORTH:
			x += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().width;
			y += -borderItemSize.height + getBorderItemOffset().height;
			break;
		case PositionConstants.EAST:
			// take south east extremity to allow following pins placing above
			x += parentFigureWidth - getBorderItemOffset().width;
			y += parentFigureHeight - borderItemSize.height - EXTRA_BORDER_DEFAULT_OFFSET
					- getBorderItemOffset().height;
			break;
		case PositionConstants.SOUTH:
			x += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().width;
			y += parentFigureHeight - getBorderItemOffset().height;
			break;
		case PositionConstants.WEST:
		default:
			x += -borderItemSize.width + getBorderItemOffset().width;
			y += EXTRA_BORDER_DEFAULT_OFFSET + getBorderItemOffset().height;
		}
		return new Point(x, y);
	}
}
