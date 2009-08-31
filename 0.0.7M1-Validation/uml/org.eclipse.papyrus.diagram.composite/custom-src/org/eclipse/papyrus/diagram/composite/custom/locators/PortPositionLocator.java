/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.locators;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.locator.AdvancedBorderItemLocator;

/**
 * This class is used to constrain the position of Port when they are added on a Property or a
 * StructuredClassifier
 * 
 * <pre>
 * FIXME : The position on creation is not correct (should match the mouse position) 
 * TODO  : The port is not re-sizable
 * </pre>
 */
public class PortPositionLocator extends AdvancedBorderItemLocator {

	/** Constructor **/
	public PortPositionLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/** Constructor **/
	public PortPositionLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/** Constructor **/
	public PortPositionLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	/**
	 * Creates a new CompositeFigure.
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
	 * {@inheritDoc}
	 * 
	 * </pre>
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {

		// Initialize port location with proposed location
		// and resolve the bounds of it graphical parent
		Rectangle realLocation = new Rectangle(proposedLocation);
		Rectangle parentRec = getParentFigure().getBounds().getCopy();

		// Calculate Max position around the graphical parent (1/2 size or the port around
		// the graphical parent bounds.
		int xMin = parentRec.x - borderItem.getBounds().width / 2;
		int xMax = parentRec.x - borderItem.getBounds().width / 2 + parentRec.width;
		int yMin = parentRec.y - borderItem.getBounds().height / 2;
		int yMax = parentRec.y - borderItem.getBounds().height / 2 + parentRec.height;

		// Modify Port location if MAX X or Y are exceeded
		if (realLocation.x < xMin) {
			realLocation.x = xMin;
		}

		if (realLocation.x > xMax) {
			realLocation.x = xMax;
		}

		if (realLocation.y < yMin) {
			realLocation.y = yMin;
		}

		if (realLocation.y > yMax) {
			realLocation.y = yMax;
		}

		// Ensure the port is positioned on its parent borders and not in the middle.
		// Modify position if needed.
		if ((realLocation.y != yMin) && (realLocation.y != yMax)) {
			if ((realLocation.x != xMin) && (realLocation.x != xMax)) {

				if (realLocation.x <= (xMin + parentRec.width / 2)) {
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