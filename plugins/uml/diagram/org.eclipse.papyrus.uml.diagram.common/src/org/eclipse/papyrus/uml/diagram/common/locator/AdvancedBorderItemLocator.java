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
package org.eclipse.papyrus.uml.diagram.common.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

/**
 * this is a border item locator that can be used to place childreen where you
 * want I order to constraint movement and localization, specialize {@link ItemBorderLocagetValidLocation.getValidLocation}
 * 
 * @author Patrick Tessier
 */
public class AdvancedBorderItemLocator extends BorderItemLocator {

	public AdvancedBorderItemLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	public AdvancedBorderItemLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	public AdvancedBorderItemLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		// do nothing to respecialize
		return proposedLocation;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void relocate(IFigure borderItem) {
		Dimension size = getSize(borderItem);
		Rectangle rectSuggested = getConstraint();
		rectSuggested.setSize(size);
		setConstraint(getValidLocation(rectSuggested, borderItem));
		borderItem.setBounds(getConstraint().getCopy());
	}

}
