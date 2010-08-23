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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.papyrus.diagram.sequence.draw2d.routers.MessageHorizontalStickRouter;
import org.eclipse.papyrus.diagram.sequence.draw2d.routers.SelfMessageRouter;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;


/**
 * A specific policy to handle :
 * - Message aspects inherited from {@link SequenceGraphicalNodeEditPolicy}.
 * - Time/duration move when a message end or an execution is moved.
 * - Duration constraint/observation creation feedback.
 * This edit policy is intended to be installed on parts which represent a lifeline or which are contained within a lifeline part.
 */
public class LifelineChildGraphicalNodeEditPolicy extends SequenceGraphicalNodeEditPolicy {

	/** the feedback for creating a duration constraint node */
	private Polyline durationCreationFeedback = null;

	/** the router to use for messages */
	public static ConnectionRouter selfMessageRouter = new SelfMessageRouter();

	public static ConnectionRouter messageHorizontalStickRouter = new MessageHorizontalStickRouter();

	/**
	 * Get the command to reconnect the source and move associated time/duration constraints/observation.
	 * 
	 * @see org.eclipse.papyrus.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 *        the reconnection request
	 * @return the command
	 */
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		Command command = super.getReconnectSourceCommand(request);
		if(command != null) {
			command = chainTimeRelatedElementsMoveCommands(command, request);
		}
		return command;
	}

	/**
	 * Get the command to reconnect the target and move associated time/duration constraints/observation.
	 * 
	 * @see org.eclipse.papyrus.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 *        the reconnection request
	 * @return the command
	 */
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		Command command = super.getReconnectTargetCommand(request);
		if(command != null) {
			command = chainTimeRelatedElementsMoveCommands(command, request);
		}
		return command;
	}

	/**
	 * Chain the commands to move associated time/duration constraints/observation.
	 * 
	 * @param command
	 *        existing command
	 * @param request
	 *        the reconnection request
	 * @return the completed command
	 */
	private Command chainTimeRelatedElementsMoveCommands(Command command, ReconnectRequest request) {
		List<IBorderItemEditPart> notToMoveEditPartList = Collections.emptyList();
		Object editPartNotToMove = request.getExtendedData().get(SequenceRequestConstant.DO_NOT_MOVE_TIME_ELEMENT);
		if(editPartNotToMove instanceof IBorderItemEditPart) {
			notToMoveEditPartList = Collections.singletonList((IBorderItemEditPart)editPartNotToMove);
		}
		// move time related elements linked with the event
		INodeEditPart node = getConnectableEditPart();
		LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(node);
		MessageEnd event = getMessageEndEvent(request);
		if(lifelinePart != null && event instanceof MessageOccurrenceSpecification) {
			Map<IBorderItemEditPart, Rectangle> updatedBounds = new HashMap<IBorderItemEditPart, Rectangle>();
			Command cmdMove = SequenceUtil.getTimeRelatedElementsMoveCommands(lifelinePart, (OccurrenceSpecification)event, request.getLocation(), notToMoveEditPartList, updatedBounds);
			command = command.chain(cmdMove);
		}
		return command;
	}

	/**
	 * Get the message end which correspond to the moved event
	 * 
	 * @param request
	 *        the reconnection request
	 * @return moved MessageEnd or null
	 */
	private MessageEnd getMessageEndEvent(ReconnectRequest request) {
		if(request.getConnectionEditPart() instanceof ConnectionEditPart) {
			EObject message = ((ConnectionEditPart)request.getConnectionEditPart()).resolveSemanticElement();
			if(message instanceof Message) {
				if(REQ_RECONNECT_SOURCE.equals(request.getType())) {
					return ((Message)message).getSendEvent();
				} else if(REQ_RECONNECT_TARGET.equals(request.getType())) {
					return ((Message)message).getReceiveEvent();
				}
			}
		}
		return null;
	}

	/**
	 * Show the feedback for creating a duration constraint from this edit part
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#showSourceFeedback(org.eclipse.gef.Request)
	 * @param request
	 *        creation request
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			Object hintedType = ((CreateUnspecifiedTypeRequest)request).getElementTypes().get(0);
			CreateRequest req = null;
			if(UMLElementTypes.DurationConstraint_3021.equals(hintedType)) {
				req = ((CreateUnspecifiedTypeRequest)request).getRequestForType(UMLElementTypes.DurationConstraint_3021);
			} else if(UMLElementTypes.DurationObservation_3024.equals(hintedType)) {
				req = ((CreateUnspecifiedTypeRequest)request).getRequestForType(UMLElementTypes.DurationObservation_3024);
			}
			if(req != null) {
				Object initLocation = req.getExtendedData().get(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION);
				if(initLocation instanceof Point) {
					Point startPoint = ((Point)initLocation).getCopy();
					Point targetPoint = ((CreateUnspecifiedTypeRequest)request).getLocation().getCopy();
					getFeedbackLayer().translateToRelative(startPoint);
					getFeedbackLayer().translateToRelative(targetPoint);
					if(durationCreationFeedback == null) {
						durationCreationFeedback = new Polyline();
						durationCreationFeedback.setLineWidth(1);
						durationCreationFeedback.setLineStyle(Graphics.LINE_DASHDOT);
						durationCreationFeedback.setForegroundColor(((IGraphicalEditPart)getHost()).getFigure().getLocalForegroundColor());
						addFeedback(durationCreationFeedback);
					}
					durationCreationFeedback.setStart(startPoint);
					durationCreationFeedback.setEnd(targetPoint);
					return;
				}
			}
		}
		super.showSourceFeedback(request);
	}

	/**
	 * Erase the feedback for creating a duration constraint from this edit part
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#eraseSourceFeedback(org.eclipse.gef.Request)
	 * @param request
	 *        creation request
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		super.eraseSourceFeedback(request);
		if(durationCreationFeedback != null)
			removeFeedback(durationCreationFeedback);
		durationCreationFeedback = null;
	}

	/**
	 * Get the replacing connection router for routing messages correctly
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getDummyConnectionRouter(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	@SuppressWarnings("rawtypes")
	protected ConnectionRouter getDummyConnectionRouter(CreateConnectionRequest req) {
		if(req instanceof CreateUnspecifiedTypeConnectionRequest) {
			List types = ((CreateUnspecifiedTypeConnectionRequest)req).getElementTypes();
			if(types.contains(UMLElementTypes.Message_4004)) {
				return messageHorizontalStickRouter;
			}
		}
		return selfMessageRouter;
	}
}
