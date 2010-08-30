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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.papyrus.diagram.common.actions.RouteAction;

/**
 * 
 * This class allow to represent easily a link for the {@link RouteAction}
 * 
 */
public class LinkRepresentationForRouteAction extends LinkRepresentationForLayoutAction {

	/**
	 * indicate how is done the {@link RouteAction}
	 */
	private int routing;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param link
	 *        the RepresentedConnectionEditPart
	 * @param routing
	 *        the routing for the {@link RouteAction}
	 */
	public LinkRepresentationForRouteAction(ConnectionEditPart link, int routing) {
		super(link);
		this.routing = routing;
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
		if(routing == PositionConstants.LEFT || routing == PositionConstants.RIGHT) {
			delta.setLocation(0, this.fixedAnchor.y - this.movedAnchor.y);
		} else if(routing == PositionConstants.TOP || routing == PositionConstants.BOTTOM) {
			delta.setLocation(this.fixedAnchor.x - this.movedAnchor.x, 0);
		}
		return delta;
	}

	/**
	 * Returns the command to set the line straight.
	 * 
	 * @return
	 *         The command to set the line straight.
	 */
	@Override
	public Command getCommand() {
		Command cmd = super.getCommand();
		if(onOppositeSides()) {
			CompoundCommand command = new CompoundCommand();
			if(cmd.canExecute()) {
				command.add(cmd);
			}
			Request onlyTwoBendpoints = new SetAllBendpointRequest(RequestConstants.REQ_SET_ALL_BENDPOINT, new PointList(), null, null);//we want zero bendpoint, and keep the current source and target	
			command.add(link.getCommand(onlyTwoBendpoints));
			return command.canExecute() ? command : UnexecutableCommand.INSTANCE;
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Tests if the two anchor are opposite.
	 * 
	 * @return
	 *         <ul>
	 *         <li> {@code true}</li> is the two anchors are opposite.
	 *         <li> {@code false}</li> if not
	 *         </ul>
	 */
	public boolean onOppositeSides() {
		Point pt = this.linkFigure.getStart();
		linkFigure.translateToAbsolute(pt);
		int side1 = LayoutUtils.getAnchorPosition(this.link.getSource(), pt);

		pt = this.linkFigure.getEnd();
		linkFigure.translateToAbsolute(pt);
		int side2 = LayoutUtils.getAnchorPosition(this.link.getTarget(), pt);

		if(routing == PositionConstants.RIGHT || routing == PositionConstants.LEFT) {
			if(DistributionConstants.verticalValuesList.contains(side1) && DistributionConstants.verticalValuesList.contains(side2)) {
				return true;
			}
		} else if(routing == PositionConstants.TOP || routing == PositionConstants.BOTTOM) {
			if(DistributionConstants.horizontalValuesList.contains(side1) && DistributionConstants.horizontalValuesList.contains(side2)) {
				return true;
			}
		}
		return false;
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
		Point movedAnchor = null;
		switch(routing) {
		case PositionConstants.LEFT: //the leftmost moves
			if(start.x < end.x) {
				movedAnchor = start;
			} else {
				movedAnchor = end;
			}
			break;
		case PositionConstants.RIGHT: //the rightmost moves
			if(start.x > end.x) {
				movedAnchor = start;
			} else {
				movedAnchor = end;
			}
			break;
		case PositionConstants.TOP: //the hightest moves
			if(start.y < end.y) {
				movedAnchor = start;
			} else {
				movedAnchor = end;
			}
			break;
		case PositionConstants.BOTTOM://the lowert moves
			if(start.y > end.y) {
				movedAnchor = start;
			} else {
				movedAnchor = end;
			}
			break;
		default:
			break;
		}

		return movedAnchor;
	}
}
