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
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.locator.AdvancedBorderItemLocator;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GateLocator extends AdvancedBorderItemLocator {

	/**
	 * Constructor.
	 * 
	 * @param parentFigure
	 */
	public GateLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.locator.AdvancedBorderItemLocator#getValidLocation(org.eclipse.draw2d.geometry.Rectangle,
	 *      org.eclipse.draw2d.IFigure)
	 * 
	 * @param proposedLocation
	 * @param borderItem
	 * @return
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle validLocation = proposedLocation.getCopy();
		Rectangle bounds = getParentBorder();
		int leftOffset = Math.abs(validLocation.x - bounds.x);
		int rightOffset = Math.abs(validLocation.x - bounds.right());
		if(leftOffset < rightOffset) {
			validLocation.x = bounds.x - proposedLocation.width / 2;
		} else {
			validLocation.x = bounds.right() - proposedLocation.width / 2;
		}
		if(validLocation.y < bounds.y) {
			validLocation.y = bounds.y;
		}
		if(validLocation.bottom() > bounds.bottom()) {
			validLocation.y = bounds.bottom() - proposedLocation.height;
		}
		return validLocation;
	}
}
