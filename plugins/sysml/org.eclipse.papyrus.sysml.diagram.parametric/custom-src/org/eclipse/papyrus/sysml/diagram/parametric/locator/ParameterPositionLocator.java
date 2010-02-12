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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.locator.AdvancedBorderItemLocator;

/**
 * The Class ParameterPositionLocator that manages position of property on constraint property
 */
public class ParameterPositionLocator extends AdvancedBorderItemLocator {

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
	 * Re-arrange the location of the border item.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param borderItem
	 */
	@Override
	public void relocate(IFigure borderItem) {
		// reset bounds of borderItem
		Dimension size = getSize(borderItem);
		Rectangle rectSuggested = getConstraint().getCopy();
		if (rectSuggested.getTopLeft().x == 0 && rectSuggested.getTopLeft().y == 0) {
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

}
