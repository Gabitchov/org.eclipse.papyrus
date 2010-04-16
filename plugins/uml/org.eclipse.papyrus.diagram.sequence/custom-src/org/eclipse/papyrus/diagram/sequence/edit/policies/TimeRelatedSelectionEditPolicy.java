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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
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
			//bounds.translate(getHostFigure().getParent().getBounds().getLocation().getCopy().negate());
			Point location = bounds.getCenter();
			EditPart lifelinePart = getHost().getParent();
			if(lifelinePart instanceof LifelineEditPart) {
				for(Object conn : ((LifelineEditPart)lifelinePart).getTargetConnections()) {
					if(conn instanceof ConnectionNodeEditPart) {
						EObject message = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
						if(message instanceof Message) {
							// finish events of the message
							MessageEnd event = ((Message)message).getReceiveEvent();
							if(isEventLinked(event)) {
								Command reconnect = lifelinePart.getCommand(makeReconnectRequest((ConnectionNodeEditPart)conn, false, location));
								return reconnect.chain(command);
							}
						}
					}
				}
				for(Object conn : ((LifelineEditPart)lifelinePart).getSourceConnections()) {
					if(conn instanceof ConnectionNodeEditPart) {
						EObject message = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
						if(message instanceof Message) {
							// start events of the message
							MessageEnd event = ((Message)message).getSendEvent();
							if(isEventLinked(event)) {
								Command reconnect = lifelinePart.getCommand(makeReconnectRequest((ConnectionNodeEditPart)conn, true, location));
								return reconnect.chain(command);
							}
						}
					}
				}
			}
		}
		return command;
	}

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

	private boolean isEventLinked(MessageEnd event) {
		if(getHost() instanceof GraphicalEditPart) {
			EObject timeElement = ((GraphicalEditPart)getHost()).resolveSemanticElement();
			if(timeElement instanceof TimeObservation) {
				return event.equals(((TimeObservation)timeElement).getEvent());
			} else if(timeElement instanceof TimeConstraint) {
				return ((TimeConstraint)timeElement).getConstrainedElements().contains(event);
			}
		}
		return false;
	}
}
