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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.diagram.common.layout.LinkRepresentationForLayoutAction;
import org.eclipse.papyrus.wizards.Activator;

/**
 * 
 * This class provides actions to set links vertical or horizontal, moving the anchor on one of its ends
 * 
 */
public class RouteAction {

	/** the routing type */
	private int routing = PositionConstants.NONE;

	/** the selected elements */
	private List<IGraphicalEditPart> selectedElements;

	/** this list owning the link representation for this action */
	private List<LinkRepresentationForLayoutAction> links;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        the routing parameter
	 * @param selectedElements
	 *        the selected elements for this action
	 */
	public RouteAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		this.selectedElements = selectedElements;
		this.routing = getRoutingValue(parameter);
		this.links = new ArrayList<LinkRepresentationForLayoutAction>();
		calculateNewPosition();
	}

	/**
	 * Return the command for this action
	 * This command removes the bendpoints too.
	 * 
	 * @return
	 *         The command for the RouteAction
	 */
	public Command getCommand() {
		CompoundCommand command = new CompoundCommand();
		if(onlyConnectionEditPart(selectedElements) && this.routing != PositionConstants.NONE) {
			for(LinkRepresentationForLayoutAction obj : links) {
				if(onOppositeSides(obj)) {
					Command cmd = obj.getCommand();

					if(cmd != UnexecutableCommand.INSTANCE) {
						command.add(cmd);
						//we want no bendpoint, and keep the current source and target
						Request noBendpoints = new SetAllBendpointRequest(RequestConstants.REQ_SET_ALL_BENDPOINT, new PointList(), null, null);
						command.add(obj.getRepresentedLink().getCommand(noBendpoints));
					}
				}
			}
		}
		return command.canExecute() ? command : UnexecutableCommand.INSTANCE;
	}

	/**
	 * Calculate the new position for anchor of the link
	 * Fill {@link #links} with the representation of the linkss
	 */
	protected void calculateNewPosition() {
		for(Object current : selectedElements) {
			if(current instanceof ConnectionEditPart) {
				LinkRepresentationForLayoutAction link = new LinkRepresentationForLayoutAction((ConnectionEditPart)current);
				EditPart anchorMovesOnEP = getEditPartForMovingAnchor((ConnectionEditPart)current);
				if(anchorMovesOnEP != null) {

					IFigure fig = ((GraphicalEditPart)current).getFigure();
					Assert.isTrue(fig instanceof PolylineConnectionEx);
					PolylineConnectionEx linkFigure = (PolylineConnectionEx)fig;

					Point start = linkFigure.getStart();
					Point end = linkFigure.getEnd();
					linkFigure.translateToAbsolute(start);
					linkFigure.translateToAbsolute(end);

					Point movedAnchor = findMovingAnchor(start, end);
					if(movedAnchor == null) {
						break;//we can not continue
					}
					Point fixedAncher = (movedAnchor == start) ? end : start;
					Point newLocation = getNewLocation(fixedAncher, movedAnchor);

					link.setNewLocationFor(anchorMovesOnEP, newLocation);
					links.add(link);
				}


			}
		}

	}

	/**
	 * Calculate the new Position for the moving anchor
	 * 
	 * @param fixedAnchor
	 *        the fixed anchor of the link
	 * @param movedAnchor
	 *        the moving anchor of the link
	 * @return
	 *         the new location for the moving anchor
	 */
	protected Point getNewLocation(Point fixedAnchor, Point movedAnchor) {
		Point delta = new Point();
		if(routing == PositionConstants.LEFT || routing == PositionConstants.RIGHT) {
			delta.setLocation(0, fixedAnchor.y - movedAnchor.y);
		} else if(routing == PositionConstants.TOP || routing == PositionConstants.BOTTOM) {
			delta.setLocation(fixedAnchor.x - movedAnchor.x, 0);
		}
		return movedAnchor.getTranslated(delta.x, delta.y);
	}

	protected EditPart getEditPartForMovingAnchor(ConnectionEditPart current) {
		EditPart source = current.getSource();
		EditPart target = current.getTarget();

		IFigure fig = current.getFigure();
		Assert.isTrue(fig instanceof PolylineConnectionEx);
		PolylineConnectionEx linkFigure = (PolylineConnectionEx)fig;

		Point start = linkFigure.getStart();
		Point end = linkFigure.getEnd();
		linkFigure.translateToAbsolute(start);
		linkFigure.translateToAbsolute(end);

		Point movedAnchor = findMovingAnchor(start, end);
		if(movedAnchor == null) {
			return null;
		}

		int sideSource = LayoutUtils.getAnchorPosition(source, movedAnchor);
		int sideTarget = LayoutUtils.getAnchorPosition(target, movedAnchor);
		if(sideSource != PositionConstants.NONE) {
			return source;
		} else if(sideTarget != PositionConstants.NONE) {
			return target;
		} else {
			Activator.log.debug("I can't find the EditPart on which moves the anchor"); //$NON-NLS-1$
			return null;
		}
	}

	/**
	 * Return an int representing the wanted routing for this action
	 * 
	 * @param param
	 *        the routing parameter
	 * @return
	 *         an int representing the wanted routing for this action
	 */
	protected int getRoutingValue(String param) {
		if(param.equals(LayoutUtils.LEFT)) {
			return PositionConstants.LEFT;
		} else if(param.equals(LayoutUtils.RIGHT)) {
			return PositionConstants.RIGHT;
		} else if(param.equals(LayoutUtils.TOP)) {
			return PositionConstants.TOP;
		} else if(param.equals(LayoutUtils.BOTTOM)) {
			return PositionConstants.BOTTOM;
		}
		return PositionConstants.NONE;
	}

	/**
	 * Test if the list is composed by {@link #onlyConnectionEditPart(List)}
	 * 
	 * @param elementsToTest
	 *        the elementsToTest
	 * @return
	 *         <ul>
	 *         <li> <code>true</code> if the list contains only {@link ConnectionEditPart}</li>
	 *         <li> <code>false</code> if not</li>
	 *         </ul>
	 */
	protected boolean onlyConnectionEditPart(List<IGraphicalEditPart> elementsToTest) {
		for(IGraphicalEditPart current : elementsToTest) {
			if(!(current instanceof ConnectionEditPart)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return the point (between source and target) which will move with this action
	 * 
	 * @param source
	 *        the point representing the source of the link
	 * @param target
	 *        the point representing the target of the link
	 * @return
	 *         the point (between source and target) which will move with this action
	 */
	protected Point findMovingAnchor(Point source, Point target) {
		Point movingAnchor = null;
		switch(routing) {
		case PositionConstants.LEFT: //the leftmost moves
			if(source.x < target.x) {
				movingAnchor = source;
			} else {
				movingAnchor = target;
			}
			break;
		case PositionConstants.RIGHT: //the rightmost moves
			if(source.x > target.x) {
				movingAnchor = source;
			} else {
				movingAnchor = target;
			}
			break;
		case PositionConstants.TOP: //the highest moves
			if(source.y < target.y) {
				movingAnchor = source;
			} else {
				movingAnchor = target;
			}
			break;
		case PositionConstants.BOTTOM://the lowest moves
			if(source.y > target.y) {
				movingAnchor = source;
			} else {
				movingAnchor = target;
			}
			break;
		default:
			break;
		}
		if(movingAnchor == null) {
			Activator.log.debug("I can't find the moving anchor"); //$NON-NLS-1$
		}
		return movingAnchor;
	}

	/**
	 * Test if the ends of the link are in opposition
	 * 
	 * @param link
	 *        the link to test
	 * @return
	 *         <ul>
	 *         <li> <code>true</code> if the ends of the link are in opposition</li>
	 *         <li> <code>false</code> if not</li>
	 *         </ul>
	 */
	protected boolean onOppositeSides(LinkRepresentationForLayoutAction link) {
		int side1 = link.getSideOnSource();
		int side2 = link.getSideOnTarget();

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



}
