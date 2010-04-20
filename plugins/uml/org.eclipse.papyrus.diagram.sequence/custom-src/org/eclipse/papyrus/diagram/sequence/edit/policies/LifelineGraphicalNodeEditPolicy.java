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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;


/**
 * A specific policy to handle time/duration move when a message end is moved
 */
public class LifelineGraphicalNodeEditPolicy extends SequenceGraphicalNodeEditPolicy {

	/** the feedback for creating a duration constraint node */
	private Polyline durationConstraintCreationFeedback = null;

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
		Object editPartNotToMove = request.getExtendedData().get(SequenceRequestConstant.DO_NOT_MOVE_TIME_ELEMENT);
		// move time related elements linked with the event
		INodeEditPart node = getConnectableEditPart();
		MessageEnd event = getMessageEndEvent(request);
		if(node != null && event != null) {
			boolean constraintMoved = false;
			for(Object lifelineChild : node.getChildren()) {
				if(!lifelineChild.equals(editPartNotToMove)) {
					boolean partIsLinked = isChildPartLinkedWithEvent(lifelineChild, event);
					if(partIsLinked && lifelineChild instanceof AbstractBorderItemEditPart) {
						final AbstractBorderItemEditPart part = (AbstractBorderItemEditPart)lifelineChild;
						IFigure parentFigure = ((IGraphicalEditPart)getHost()).getFigure();
						Command resize = getMovePartCommand(parentFigure, part, request.getLocation().getCopy());
						command = command.chain(resize);
						constraintMoved = true;
					}
				}
			}
			if(constraintMoved) {
				Command relayout = getReLayoutCmd(node);
				if(relayout != null) {
					command = command.chain(relayout);
				}
			}
		}
		return command;
	}

	/**
	 * Get the command to move the bordered edit part next to the event
	 * 
	 * @param parentFigure
	 *        the containing figure
	 * @param movedPart
	 *        the border part which must be moved
	 * @param referencePoint
	 *        the point where the event is moved
	 * @return the move command
	 */
	private Command getMovePartCommand(IFigure parentFigure, AbstractBorderItemEditPart movedPart, Point referencePoint) {
		parentFigure.translateToRelative(referencePoint);
		referencePoint.x = movedPart.getLocation().x;
		referencePoint.translate(parentFigure.getBounds().getLocation().getCopy().negate());
		// Get the height of the element
		int newHeight = movedPart.getSize().height;
		// Define the new bounds of the time element
		Rectangle newBounds = new Rectangle(referencePoint.x, referencePoint.y - newHeight / 2, -1, newHeight);
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		// chain the resize command
		ICommandProxy resize = new ICommandProxy(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter((View)movedPart.getModel()), newBounds));
		return resize;
	}

	/**
	 * Know whether lifeline child part is linked with the event
	 * 
	 * @param lifelineChild
	 *        the lifeline child part
	 * @param event
	 *        the message end event
	 * @return true if child is linked with the event
	 */
	private boolean isChildPartLinkedWithEvent(Object lifelineChild, MessageEnd event) {
		if(lifelineChild instanceof TimeObservationEditPart || lifelineChild instanceof TimeConstraintEditPart) {
			final AbstractBorderItemEditPart part = (AbstractBorderItemEditPart)lifelineChild;
			EObject element = part.resolveSemanticElement();
			if(element instanceof TimeObservation) {
				return event.equals(((TimeObservation)element).getEvent());
			} else if(element instanceof TimeConstraint) {
				return ((TimeConstraint)element).getConstrainedElements().contains(event);
			}
		}
		return false;
	}

	/**
	 * Get a command which refreshes the bordered layout of the node.
	 * 
	 * @param node
	 *        the node with bordered items
	 * @return the refresh command or null
	 */
	private Command getReLayoutCmd(INodeEditPart node) {

		// relayout the border container figure so that time elements are refreshed
		IFigure fig = node.getFigure();
		if(fig instanceof BorderedNodeFigure) {
			final IFigure container = ((BorderedNodeFigure)fig).getBorderItemContainer();
			Command cmd = new Command() {

				@Override
				public void execute() {
					container.getLayoutManager().layout(container);
				}
			};
			return cmd;
		}
		return null;
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
			if(UMLElementTypes.DurationConstraint_3021.equals(hintedType)) {
				CreateRequest req = ((CreateUnspecifiedTypeRequest)request).getRequestForType(UMLElementTypes.DurationConstraint_3021);
				Object initLocation = req.getExtendedData().get(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION);
				if(initLocation instanceof Point) {
					Point startPoint = ((Point)initLocation).getCopy();
					Point targetPoint = ((CreateUnspecifiedTypeRequest)request).getLocation().getCopy();
					if(durationConstraintCreationFeedback == null) {
						durationConstraintCreationFeedback = new Polyline();
						durationConstraintCreationFeedback.setLineWidth(1);
						durationConstraintCreationFeedback.setLineStyle(Graphics.LINE_DASHDOT);
						durationConstraintCreationFeedback.setForegroundColor(((IGraphicalEditPart)getHost()).getFigure().getLocalForegroundColor());
						addFeedback(durationConstraintCreationFeedback);
					}
					durationConstraintCreationFeedback.setStart(startPoint);
					durationConstraintCreationFeedback.setEnd(targetPoint);
					return;
				}
			}
		}
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
		if(durationConstraintCreationFeedback != null)
			removeFeedback(durationConstraintCreationFeedback);
		durationConstraintCreationFeedback = null;
	}
}
