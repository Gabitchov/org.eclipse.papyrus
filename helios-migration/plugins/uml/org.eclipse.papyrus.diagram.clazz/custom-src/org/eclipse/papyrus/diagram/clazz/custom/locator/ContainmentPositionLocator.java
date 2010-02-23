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
 *  
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.clazz.custom.locator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.diagram.common.locator.AdvancedBorderItemLocator;

/**
 * This class is used to constrain the position of Containment circle when they are added on a class element
 */
public class ContainmentPositionLocator extends AdvancedBorderItemLocator {

	/** Constructor **/
	public ContainmentPositionLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/** Constructor **/
	public ContainmentPositionLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/** Constructor **/
	public ContainmentPositionLocator(IFigure parentFigure, int preferredSide) {
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
	 * 	 |                   +-+ - Expected position of containment circle  
	 * 	 |                   +-+
	 * 	 |                   |
	 * 	 +-------------------+
	 * 
	 * {@inheritDoc}
	 * 
	 * </pre>
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {

		// Initialize containment circle location with proposed location
		// and resolve the bounds of it graphical parent
		Rectangle realLocation = new Rectangle(proposedLocation);
		Rectangle parentRec = getParentFigure().getBounds().getCopy();

		// Calculate Max position around the graphical parent (1/2 size or the port around
		// the graphical parent bounds.

		int xMin = parentRec.x - borderItem.getBounds().width;
		int xMax = parentRec.x - borderItem.getBounds().width / borderItem.getBounds().width + parentRec.width;
		int yMin = parentRec.y - borderItem.getBounds().height;
		int yMax = parentRec.y - borderItem.getBounds().height / borderItem.getBounds().height + parentRec.height;

		// Modify containment circle  location if MAX X or Y are exceeded
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

		// Ensure the containment circle  is positioned on its parent borders and not in the middle.
		// Modify position if needed.
		if((realLocation.y != yMin) && (realLocation.y != yMax)) {
			if((realLocation.x != xMin) && (realLocation.x != xMax)) {
				if(realLocation.x <= (xMin + parentRec.width)) {
					realLocation.x = xMin;
				} else {
					realLocation.x = xMax;
				}
			}
		}
		getPreferredLocation(8, borderItem);
		return realLocation;
	}

}
