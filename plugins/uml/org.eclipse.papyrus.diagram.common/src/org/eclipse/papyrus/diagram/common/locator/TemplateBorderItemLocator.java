/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

public class TemplateBorderItemLocator extends AdvancedBorderItemLocator {

	public TemplateBorderItemLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	public TemplateBorderItemLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	public TemplateBorderItemLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		Rectangle parentRec = getParentFigure().getBounds().getCopy();
		// position is constraint in the parent rectangle
		// WEST
		if (realLocation.x < parentRec.x + parentRec.getSize().width - borderItem.getBounds().width) {
			realLocation.x = parentRec.x + parentRec.getSize().width - borderItem.getBounds().width;
		}
		// EAST
		if (realLocation.x > parentRec.x + parentRec.getSize().width - borderItem.getBounds().width / 4) {
			realLocation.x = parentRec.x + parentRec.getSize().width - borderItem.getBounds().width / 4;
		}
		// NORTH
		realLocation.y = parentRec.y + 40 - (borderItem.getBounds().height / 2);
		return realLocation;
	}

}