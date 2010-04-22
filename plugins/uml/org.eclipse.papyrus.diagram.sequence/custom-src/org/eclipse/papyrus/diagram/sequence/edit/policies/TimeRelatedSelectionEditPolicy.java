/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * Edit policy to restrict border item movement. This edit policy moves the related events when a Time/Duration Observation/Constraint is moved.
 */
public class TimeRelatedSelectionEditPolicy extends BorderItemSelectionEditPolicy {

	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		Command command = super.getMoveCommand(request);
		if(command != null) {
			Rectangle bounds = request.getTransformedRectangle(getHostFigure().getBounds());
			getHostFigure().getParent().translateToAbsolute(bounds);
			LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(getHost());
			if(lifelinePart != null && getHost() instanceof IBorderItemEditPart) {
				IBorderItemEditPart timeElementEditPart = (IBorderItemEditPart)getHost();
				EObject timeElement = timeElementEditPart.resolveSemanticElement();
				List<Element> events = Collections.emptyList();
				if(timeElement instanceof TimeConstraint) {
					events = ((TimeConstraint)timeElement).getConstrainedElements();
				} else if(timeElement instanceof TimeObservation) {
					events = new ArrayList<Element>(1);
					events.add(((TimeObservation)timeElement).getEvent());
				} else if(timeElement instanceof DurationConstraint) {
					events = ((DurationConstraint)timeElement).getConstrainedElements();
				}
				for(Element event : events) {
					if(event instanceof ExecutionOccurrenceSpecification) {
						// execution linked to the event must be resized
						EditPart node = SequenceUtil.getLinkedEditPart(lifelinePart, (OccurrenceSpecification)event);
						if(node instanceof GraphicalEditPart) {
							EObject execution = ((GraphicalEditPart)node).resolveSemanticElement();
							if(execution instanceof ExecutionSpecification) {
								// finish or  start event of the execution
								boolean isStart = event.equals(((ExecutionSpecification)execution).getStart());
								Point location = getLocation(bounds, whereEventIsLinked((OccurrenceSpecification)event));
								if(location != null) {
									Command resize = lifelinePart.getCommand(makeResizeRequest((GraphicalEditPart)node, isStart, location));
									command = command.chain(resize);
								}
							}
						}
					} else if(event instanceof MessageOccurrenceSpecification) {
						// message linked to the event must be reconnected
						EditPart conn = SequenceUtil.getLinkedEditPart(lifelinePart, (OccurrenceSpecification)event);
						if(conn instanceof ConnectionNodeEditPart) {
							EObject message = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
							if(message instanceof Message) {
								// finish or start event of the message
								boolean isStart = event.equals(((Message)message).getSendEvent());
								EditPart linkedPart;
								if(isStart) {
									linkedPart = ((ConnectionNodeEditPart)conn).getSource();
								} else {
									linkedPart = ((ConnectionNodeEditPart)conn).getTarget();
								}
								Point location = getLocation(bounds, whereEventIsLinked((OccurrenceSpecification)event));
								if(location != null) {
									Command reconnect = linkedPart.getCommand(makeReconnectRequest((ConnectionNodeEditPart)conn, isStart, location));
									command = command.chain(reconnect);
								}
							}
						}
					}
				}
			}
		}
		return command;
	}

	/**
	 * Get the location on the bounds
	 * 
	 * @param bounds
	 *        the rectangle bounds
	 * @param position
	 *        one of {@link PositionConstants#TOP}, {@link PositionConstants#CENTER}, {@link PositionConstants#BOTTOM}
	 * @return the point at the given position or null if position is incorrect
	 */
	private Point getLocation(Rectangle bounds, int position) {
		if(position == PositionConstants.TOP) {
			return bounds.getTop();
		} else if(position == PositionConstants.CENTER) {
			return bounds.getCenter();
		} else if(position == PositionConstants.BOTTOM) {
			return bounds.getBottom();
		}
		return null;
	}

	/**
	 * make the request to resize the node
	 * 
	 * @param node
	 *        the node part
	 * @param isStart
	 *        true for moving the top border, false for bottom
	 * @param location
	 *        location on the new border
	 * @return the request
	 */
	private Request makeResizeRequest(GraphicalEditPart node, boolean isStart, Point location) {
		// Create and set the properties of the request
		ChangeBoundsRequest resizeReq = new ChangeBoundsRequest(REQ_RESIZE_CHILDREN);
		IFigure parentFig = node.getFigure().getParent();
		Rectangle oldBounds = node.getFigure().getBounds().getCopy();
		parentFig.translateToAbsolute(oldBounds);
		Rectangle newBounds = new Rectangle();
		if(isStart) {
			newBounds.setLocation(oldBounds.getLocation().x, location.y);
			newBounds.setSize(oldBounds.getSize().width, oldBounds.getBottom().y - location.y);
		} else {
			newBounds.setLocation(oldBounds.getLocation());
			newBounds.setSize(oldBounds.getSize().width, location.y - oldBounds.getTop().y);
		}
		resizeReq.setLocation(location);
		resizeReq.setMoveDelta(newBounds.getLocation().getTranslated(oldBounds.getLocation().getCopy().negate()));
		resizeReq.setSizeDelta(newBounds.getSize().getDifference(oldBounds.getSize()));
		resizeReq.setEditParts(node);
		// add a parameter to bypass the move impact from the reconnect to this element
		resizeReq.getExtendedData().put(SequenceRequestConstant.DO_NOT_MOVE_TIME_ELEMENT, getHost());
		// Return the request
		return resizeReq;
	}

	/**
	 * make the request to reconnect the connection
	 * 
	 * @param connection
	 *        connection part
	 * @param isSource
	 *        true if the source must be reconnect, false for target
	 * @param location
	 *        the location where to reconnect
	 * @return the request
	 */
	private Request makeReconnectRequest(ConnectionNodeEditPart connection, boolean isSource, Point location) {
		// Obtain the target edit part
		EditPart targetEP;
		String type;
		if(isSource) {
			type = RequestConstants.REQ_RECONNECT_SOURCE;
			targetEP = connection.getSource();
		} else {
			type = RequestConstants.REQ_RECONNECT_TARGET;
			targetEP = connection.getTarget();
		}

		// Create and set the properties of the request
		ReconnectRequest reconnReq = new ReconnectRequest();
		reconnReq.setConnectionEditPart(connection);
		reconnReq.setLocation(location);
		reconnReq.setTargetEditPart(targetEP);
		reconnReq.setType(type);
		// add a parameter to bypass the move impact from the reconnect to this element
		reconnReq.getExtendedData().put(SequenceRequestConstant.DO_NOT_MOVE_TIME_ELEMENT, getHost());

		// Return the request
		return reconnReq;
	}

	/**
	 * The position of the host where the event is linked
	 * 
	 * @param event
	 *        the occurence specification
	 * @return one of {@link PositionConstants#TOP}, {@link PositionConstants#CENTER}, {@link PositionConstants#BOTTOM},
	 *         {@link PositionConstants#NONE}
	 */
	private int whereEventIsLinked(OccurrenceSpecification event) {
		if(getHost() instanceof IBorderItemEditPart) {
			return SequenceUtil.positionWhereEventIsLinkedToPart(event, (IBorderItemEditPart)getHost());
		}
		return PositionConstants.NONE;
	}
}
