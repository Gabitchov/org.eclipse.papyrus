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
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.locators;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;

/**
 * This class is used to constrain the position of Port when they are added on a Property or a
 * StructuredClassifier
 * 
 * <pre>
 * TODO  : The port is not re-sizable
 * </pre>
 */
public class PortPositionLocator implements IBorderItemLocator {

	/** the figure around which this border item appears */
	protected IFigure parentFigure = null;

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
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {

		// Initialize port location with proposed location
		// and resolve the bounds of it graphical parent
		Rectangle realLocation = new Rectangle(proposedLocation);

		Rectangle parentRec = getParentFigure().getBounds().getCopy();

		// Test if parentRec position differs from (0, 0) before any change in Port realPosition
		if((parentRec.x != 0) && (parentRec.y != 0)) {

			// Calculate Max position around the graphical parent (1/2 size or the port around
			// the graphical parent bounds.
			int xMin = parentRec.x - (borderItem.getBounds().width / 2);
			int xMax = parentRec.x - (borderItem.getBounds().width / 2) + parentRec.width;
			int yMin = parentRec.y - (borderItem.getBounds().height / 2);
			int yMax = parentRec.y - (borderItem.getBounds().height / 2) + parentRec.height;

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
		}

		// Return constrained location
		return realLocation;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getCurrentSideOfParent()
	 * 
	 * @return
	 */
	public int getCurrentSideOfParent() {
		// Currently unused by this locator
		return 0;
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
