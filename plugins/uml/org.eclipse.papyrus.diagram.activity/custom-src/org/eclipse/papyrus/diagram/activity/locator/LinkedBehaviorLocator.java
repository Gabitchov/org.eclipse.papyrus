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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.locator.AdvancedBorderItemLocator;

/**
 * This class is used to constrain the position of a linked Behavior
 */
public class LinkedBehaviorLocator extends AdvancedBorderItemLocator {

	/** The margin to leave between the property node and its parent when relocating */
	private static final int MARGIN = 5;

	/** Constructor **/
	public LinkedBehaviorLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/** Constructor **/
	public LinkedBehaviorLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/** Constructor **/
	public LinkedBehaviorLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = proposedLocation.getCopy();
		if(getParentBorder().intersects(proposedLocation)) {
			int heightGap = getParentBorder().y - proposedLocation.y - proposedLocation.height - MARGIN;
			realLocation.translate(0, heightGap);
		}
		return realLocation;
	}

	/**
	 * Re-arrange the location of the border item.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param borderItem
	 */
	@Override
	public void relocate(IFigure borderItem) {
		// reset bounds of borderItem
		Rectangle validLocation = getCorrectItemLocation(borderItem);
		// the constraint is not reset, but the item bounds are
		borderItem.setBounds(validLocation);
		// ensure the side property is correctly set
		setCurrentSideOfParent(findClosestSideOfParent(borderItem.getBounds(), getParentBorder()));
	}

	/**
	 * Get the current location
	 * 
	 * @param borderItem
	 *        the item to get location
	 * @return location of item
	 */
	public Rectangle getCorrectItemLocation(IFigure borderItem) {
		Dimension size = getSize(borderItem);
		Rectangle rectSuggested = getConstraint().getCopy();
		if(rectSuggested.getTopLeft().x == 0 && rectSuggested.getTopLeft().y == 0) {
			rectSuggested.setLocation(getPreferredLocation(borderItem));
		} else {
			// recovered constraint must be translated with the parent location to be absolute
			rectSuggested.setLocation(rectSuggested.getLocation().translate(getParentBorder().getTopLeft()));
		}
		rectSuggested.setSize(size);
		return getValidLocation(rectSuggested, borderItem);
	}
}
