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
package org.eclipse.papyrus.diagram.statemachine.custom.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.papyrus.diagram.statemachine.custom.helpers.Zone;

/**
 * This class is used to constrain the position of ExternalNodeLabel.
 * The locator let the external node label be freely located by used anywhere around the
 * parent figure.
 */
public class CustomRegionExternalLabelPositionLocator implements IBorderItemLocator {

	/** the figure around which this label appears */
	protected IFigure parentFigure = null;

	/** the position constraint */
	protected Rectangle constraint = null;
	
	protected Rectangle regionRectangle= null;

	 String zone = null;
	/**
	 * get the location constraint
	 * 
	 * @return the constraint
	 */
	public Rectangle getConstraint() {
		return constraint;
	}

	/** Constructor **/
	public CustomRegionExternalLabelPositionLocator(IFigure parentFigure, Rectangle rectangle) {
		this.parentFigure = parentFigure;
		this.constraint = rectangle;
		this.regionRectangle=rectangle;
		int i = 0;
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
		//return new Rectangle(proposedLocation);
		Rectangle realLocation = new Rectangle(proposedLocation);
		Point regionPointBottom= regionRectangle.getBottom();
		Point regionPointTop = regionRectangle.getTop();
 
	
		if(realLocation.x < 0) {
			realLocation.x = 0;
		}

		if(realLocation.x > regionRectangle.width) {
			realLocation.x = regionRectangle.width;
		}

		if(realLocation.y > regionRectangle.height){
			realLocation.y = regionRectangle.height  ;
		}
		
		if(realLocation.y < 0){
			realLocation.y =0;
		} 


		return realLocation;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#setConstraint(org.eclipse.draw2d.geometry.Rectangle)
	 * 
	 * @param constraint
	 */
/*	public void setConstraint(Rectangle constraint) {
		this.constraint = constraint;

	}*/

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getCurrentSideOfParent()
	 * 
	 * @return current side of parent
	 */
	public int getCurrentSideOfParent() {
		// Not used.
		return PositionConstants.ALWAYS_LEFT;
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

	public void setConstraint(Rectangle constraint) {
		this.constraint=constraint;

		// TODO Auto-generated method stub
		
	}
}
