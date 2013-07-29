/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;

/**
 * This class is used to constrain the position of ExternalNodeLabel. The
 * locator let the external node label be freely located by used anywhere around
 * the parent figure.
 */
public class ExternalLabelPositionLocator implements IBorderItemLocator {

	/** the figure around which this label appears */
	protected IFigure parentFigure = null;

	/** the position constraint */
	protected Rectangle constraint = new Rectangle(0, 0, 0, 0);

	/**
	 * get the location constraint
	 * 
	 * @return the constraint
	 */
	public Rectangle getConstraint() {
		return constraint;
	}

	/** Constructor **/
	public ExternalLabelPositionLocator(IFigure parentFigure) {
		this.parentFigure = parentFigure;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getValidLocation(org.eclipse.draw2d.geometry.Rectangle,
	 *      org.eclipse.draw2d.IFigure)
	 * 
	 * @param proposedLocation
	 * @param borderItem
	 * @return the valid location
	 */
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		return new Rectangle(proposedLocation);
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
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getCurrentSideOfParent()
	 * 
	 * @return current side of parent
	 */
	public int getCurrentSideOfParent() {
		// Not used.
		return PositionConstants.NONE;
	}

	/**
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param target
	 */
	public void relocate(IFigure target) {

		Rectangle proposedBounds = constraint.getCopy();
		proposedBounds.setLocation(constraint.getLocation().translate(parentFigure.getBounds().getTopLeft()));
		proposedBounds.setSize(target.getPreferredSize());

		target.setBounds(proposedBounds);
	}
}
