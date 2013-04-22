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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.papyrus.uml.diagram.sequence.draw2d.routers.MessageRouter;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineMessageCreateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationMoveHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;

/**
 * A specific policy to handle :
 * - Message aspects inherited from {@link SequenceGraphicalNodeEditPolicy}.
 * - Time/duration move when a message end or an execution is moved.
 * - Duration constraint/observation creation feedback.
 * - Creation of general ordering links.
 * This edit policy is intended to be installed on parts which represent a lifeline or which are contained within a lifeline part.
 */
public class LifelineChildGraphicalNodeEditPolicy extends SequenceGraphicalNodeEditPolicy {

	/** the feedback for creating a duration constraint node */
	private Polyline durationCreationFeedback = null;

	/** the router to use for messages */
	public static ConnectionRouter messageRouter = new MessageRouter();

	@Override
	public Command getCommand(Request request) {
		if(RequestConstants.REQ_CONNECTION_START.equals(request.getType())) {
			if(request instanceof CreateConnectionViewAndElementRequest) {
				return getConnectionAndRelationshipCreateCommand((CreateConnectionViewAndElementRequest)request);
			} else if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
				return getUnspecifiedConnectionCreateCommand((CreateUnspecifiedTypeConnectionRequest)request);
			}
		} else if(RequestConstants.REQ_CONNECTION_END.equals(request.getType())) {
			if(request instanceof CreateConnectionViewAndElementRequest) {
				return getConnectionAndRelationshipCompleteCommand((CreateConnectionViewAndElementRequest)request);
			} else if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
				return getUnspecifiedConnectionCompleteCommand((CreateUnspecifiedTypeConnectionRequest)request);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Gets the command to start the creation of a new connection and
	 * relationship (if applicable) for a unspecified type request. This will
	 * update all the individual requests appropriately.
	 * 
	 * @param request
	 *        the unspecified type request
	 * @return the command
	 */
	private Command getUnspecifiedConnectionCreateCommand(final CreateUnspecifiedTypeConnectionRequest request) {
		if(request.isDirectionReversed()) {
			return new Command() {

				/**
				 * All we know is the target and the possible relationship
				 * types. At this point, there is no way to validate the
				 * commands for this scenario.
				 */
				@Override
				public boolean canExecute() {
					return true;
				}
			};
		} else {
			// Get the start command for each individual request, this will
			// update each request as required.
			final List commands = new ArrayList();
			for(Iterator iter = request.getAllRequests().iterator(); iter.hasNext();) {
				Request individualRequest = (Request)iter.next();
				Command cmd = null;
				if(individualRequest instanceof CreateConnectionViewAndElementRequest) {
					cmd = getConnectionAndRelationshipCreateCommand((CreateConnectionViewAndElementRequest)individualRequest);
				} else if(individualRequest instanceof CreateConnectionViewRequest) {
					cmd = getConnectionCreateCommand((CreateConnectionViewRequest)individualRequest);
				}
				if(cmd != null && cmd.canExecute()) {
					commands.add(cmd);
				}
			}
			if(commands.isEmpty()) {
				// GEF's AbstractConnectionCreationTool expects a null command
				// when the gesture should be disabled.
				return null;
			}
			// return an executable command that does nothing
			return new Command() {/* do nothing */
			};
		}
	}

	/**
	 * Get the command to reconnect the source and move associated time/duration constraints/observation.
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 *        the reconnection request
	 * @return the command
	 */
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		Command command = super.getReconnectSourceCommand(request);
		if(command != null) {
			command = OccurrenceSpecificationMoveHelper.completeReconnectConnectionCommand(command, request, getConnectableEditPart());
			if(request.getConnectionEditPart() instanceof Message4EditPart && request.getTarget() instanceof LifelineEditPart) {
				LifelineEditPart newSource = (LifelineEditPart)request.getTarget();
				LifelineEditPart target = (LifelineEditPart)request.getConnectionEditPart().getTarget();
				command = LifelineMessageCreateHelper.moveLifelineDown(command, target, newSource.getFigure().getBounds().getLocation().getCopy());
			}
		}
		return command;
	}

	/**
	 * Get the command to reconnect the target and move associated time/duration constraints/observation.
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 *        the reconnection request
	 * @return the command
	 */
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		Command command = super.getReconnectTargetCommand(request);
		if(command != null) {
			command = OccurrenceSpecificationMoveHelper.completeReconnectConnectionCommand(command, request, getConnectableEditPart());
			if(request.getConnectionEditPart() instanceof Message4EditPart && request.getTarget() instanceof LifelineEditPart) {
				command = LifelineMessageCreateHelper.reconnectMessageCreateTarget(request, command);
			}
		}
		return command;
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
		if(durationCreationFeedback != null) {
			removeFeedback(durationCreationFeedback);
		}
		durationCreationFeedback = null;
	}

	/**
	 * Get the replacing connection router for routing messages correctly
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getDummyConnectionRouter(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	@Override
	protected ConnectionRouter getDummyConnectionRouter(CreateConnectionRequest req) {
		return messageRouter;
	}
}
