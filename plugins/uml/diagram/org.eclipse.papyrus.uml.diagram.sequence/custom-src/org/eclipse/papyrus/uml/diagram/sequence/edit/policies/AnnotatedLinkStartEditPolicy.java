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
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.command.AnnotatedLinkEditCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AnnotatedLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomDurationConstraintEditPart;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * An editpolicy for handling connections start from Comment, Constraint and Observations.
 * 
 * @see AnnotatedLinkEndEditPolicy
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class AnnotatedLinkStartEditPolicy extends GraphicalNodeEditPolicy {

	public static final String ANNOTATED_LINK_START_ROLE = "Annotated Link Start Edit Policy";

	public static final String REQ_ANNOTATED_LINK_START = "annotated link start";

	public static final String REQ_ANNOTATED_LINK_REORIENT_START = "annotated link reorient start";

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(REQ_ANNOTATED_LINK_START.equals(request.getType()) || REQ_ANNOTATED_LINK_REORIENT_START.equals(request.getType())) {
			return getConnectableEditPart();
		}
		return null;
	}

	/**
	 * Get connectable INodeEditPart safely for Constraint Label, Comment body and so on.
	 */
	@Override
	protected INodeEditPart getConnectableEditPart() {
		EditPart host = getHost();
		if(host instanceof INodeEditPart) {
			return (INodeEditPart)host;
		} else {
			IGraphicalEditPart hostGraphical = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
			if(hostGraphical == null) {
				return null;
			}
			EObject element = hostGraphical.resolveSemanticElement();
			if(element == null) {
				return null;
			}
			EditPart parent = host.getParent();
			if(!(parent instanceof INodeEditPart)) {
				return null;
			}
			IGraphicalEditPart parentGraphical = (IGraphicalEditPart)parent.getAdapter(IGraphicalEditPart.class);
			if(parentGraphical != null && element == parentGraphical.resolveSemanticElement()) {
				return (INodeEditPart)parent;
			}
		}
		return null;
	}

	@Override
	public Command getCommand(Request request) {
		if(REQ_ANNOTATED_LINK_START.equals(request.getType())) {
			return getConnectionCreateCommand((CreateConnectionRequest)request);
		} else if(REQ_ANNOTATED_LINK_REORIENT_START.equals(request.getType())) {
			return getReconnectSourceCommand((ReconnectRequest)request);
		}
		return null;
	}

	@Override
	public void showSourceFeedback(Request request) {
		if(AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_END.equals(request.getType())) {
			showCreationFeedback((CreateConnectionRequest)request);
		}
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		if(AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_END.equals(request.getType())) {
			eraseCreationFeedback((CreateConnectionRequest)request);
		}
	}

	@Override
	protected Connection createDummyConnection(Request req) {
		Connection conn = super.createDummyConnection(req);
		conn.setForegroundColor(ColorConstants.black);
		return conn;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		EditPart host = getHost();
		//Quickly failed for TimeObservation, the event of a TimeObservation can only one.
		if(host instanceof GraphicalEditPart) {
			View primaryView = ((GraphicalEditPart)host).getPrimaryView();
			EObject element = ViewUtil.resolveSemanticElement(primaryView);
			if(element instanceof TimeObservation && ((TimeObservation)element).getEvent() != null) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		ICommandProxy c = (ICommandProxy)super.getReconnectSourceCommand(request);
		if(c == null) {
			return null;
		}
		if(request.getConnectionEditPart() instanceof AnnotatedLinkEditPart) {
			if(getHost() instanceof CustomDurationConstraintEditPart && !((CustomDurationConstraintEditPart)getHost()).canCreateLink(request.getLocation())) {
				return UnexecutableCommand.INSTANCE; // only 2 links are allowed, one for each side
			}

			CompositeCommand cc = (CompositeCommand)c.getICommand();
			AnnotatedLinkEditCommand ac = new AnnotatedLinkEditCommand(getEditingDomain());
			ac.setAnnotatedLink((AnnotatedLinkEditPart)request.getConnectionEditPart());
			ac.setSource(getHost());
			cc.add(ac);
			return c;
		}
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		EditPart host = getHost();
		//Quickly failed for TimeObservation, the event of a TimeObservation can only one.
		if(host instanceof GraphicalEditPart) {
			View primaryView = ((GraphicalEditPart)host).getPrimaryView();
			EObject element = ViewUtil.resolveSemanticElement(primaryView);
			if(element instanceof TimeObservation && ((TimeObservation)element).getEvent() != null) {
				return UnexecutableCommand.INSTANCE;
			}
			if(host instanceof CustomDurationConstraintEditPart) {
				boolean can = ((CustomDurationConstraintEditPart)host).canCreateLink(request.getLocation());
				if(!can) {
					return UnexecutableCommand.INSTANCE;
				}
			}
		}
		Command command = super.getConnectionCreateCommand(request);
		if(command instanceof ICommandProxy) {
			CompositeCommand cc = (CompositeCommand)((ICommandProxy)command).getICommand();
			AnnotatedLinkEditCommand operation = new AnnotatedLinkEditCommand(getEditingDomain());
			operation.setSource(getHost());
			cc.add(operation);
		}
		return command;
	}

	private TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}
}
