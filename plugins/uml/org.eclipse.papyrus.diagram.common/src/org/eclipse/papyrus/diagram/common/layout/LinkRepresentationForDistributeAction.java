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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.layout;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.diagram.common.actions.DistributeAction;

/**
 * 
 * This class allow to represent easily a link for the {@link DistributeAction}
 * 
 */
public class LinkRepresentationForDistributeAction extends LinkRepresentationForLayoutAction {

	/**
	 * the new location for the moving anchor
	 */
	private PrecisionPoint newLocation;

	/**
	 * distribution for the {@link DistributeAction}
	 */
	private int distribution;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param link
	 *        the represented link
	 * @param anchorMovesOnThisEP
	 *        the node on which we move an anchor
	 */
	public LinkRepresentationForDistributeAction(ConnectionEditPart link, EditPart anchorMovesOnThisEP, int distribution) {
		super(link);
		this.distribution = distribution;
		this.movedEP = anchorMovesOnThisEP;
		init();
	}



	public PrecisionRectangle getAbsolutePosition() {
		PrecisionRectangle rect = new PrecisionRectangle();
		rect.setSize(new Dimension(1, 1));
		rect.setX(getMovingAnchorLocation().x);
		rect.setY(getMovingAnchorLocation().y);
		return rect;
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.layout.LinkRepresentationForLayoutAction#findMovedAnchor(org.eclipse.draw2d.geometry.Point,
	 *      org.eclipse.draw2d.geometry.Point)
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	@Override
	protected Point findMovedAnchor(Point start, Point end) {
		Assert.isNotNull(this.movedEP);
		int position = LayoutUtils.getAnchorPosition(movedEP, start);
		if(position != PositionConstants.NONE) {
			this.movedAnchor = start;
			this.fixedAnchor = end;
		} else {
			position = LayoutUtils.getAnchorPosition(movedEP, end);
			if(position != PositionConstants.NONE) {
				this.movedAnchor = end;
				this.fixedAnchor = start;
			}
		}

		Assert.isLegal(position != PositionConstants.NONE);
		return movedAnchor;
	}


	/**
	 * Calculates the shift between the source and the target following the direction of the action.
	 * 
	 * @return
	 *         the shift between the source and the target following the direction of the action.
	 */
	@Override
	protected Point getDelta() {
		Point delta = new Point();
		//return movedAnchor.getTranslated(this.newLocation.getNegated());
		if(distribution == DistributionConstants.DISTRIBUTE_H_CONTAINER_INT || distribution == DistributionConstants.DISTRIBUTE_H_NODES_INT) {//routing == PositionConstants.LEFT || routing == PositionConstants.RIGHT) {
			delta.setLocation(this.newLocation.x - this.movedAnchor.x, 0);
		} else if(distribution == DistributionConstants.DISTRIBUTE_V_CONTAINER_INT || distribution == DistributionConstants.DISTRIBUTE_V_NODES_INT) {
			delta.setLocation(0, this.newLocation.y - this.movedAnchor.y);
		}
		return delta;
	}

	public Point getMovingAnchorLocation() {
		return this.movedAnchor;
	}

	public void setNewPosition(PrecisionPoint ptLocation) {
		this.newLocation = ptLocation;
	}
}
