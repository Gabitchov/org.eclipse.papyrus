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

import java.lang.reflect.Field;
import java.util.Iterator;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.command.AnnotatedLinkEditCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AnnotatedLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.EllipseDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.uml2.uml.NamedElement;

/**
 * An editpolicy for handling connections end from Comment, Constraint and Observations.
 * 
 * The semantic element of the Host should be a instance of {@link NamedElement}.
 * 
 * @see AnnotatedLinkStartEditPolicy
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class AnnotatedLinkEndEditPolicy extends GraphicalNodeEditPolicy {

	public static final String ANNOTATED_LINK_END_ROLE = "Annotated Link End Edit Policy";

	public static final String REQ_ANNOTATED_LINK_END = "annotated link end";

	public static final String REQ_ANNOTATED_LINK_REORIENT_END = "annotated link reorient end";

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(REQ_ANNOTATED_LINK_END.equals(request.getType()) || REQ_ANNOTATED_LINK_REORIENT_END.equals(request.getType())) {
			Point location = ((DropRequest)request).getLocation();
			EditPart host = getHost();
			if(isEnterAnchorArea(host, location)) {
				return host;
			}
		}
		return null;
	}

	private boolean isEnterAnchorArea(EditPart editPart, Point location) {
		Point p = location.getCopy();
		if(editPart instanceof InteractionEditPart || editPart instanceof CombinedFragmentEditPart || editPart instanceof InteractionOperandEditPart) {
			IFigure figure = ((AbstractGraphicalEditPart)editPart).getFigure();
			figure.translateToRelative(p);
			// if mouse location is far from border, do not handle connection event 
			Rectangle innerRetangle = figure.getBounds().getCopy().shrink(10, 10);
			if(innerRetangle.contains(p)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Command getCommand(Request request) {
		if(REQ_ANNOTATED_LINK_END.equals(request.getType())) {
			return getConnectionCompleteCommand((CreateConnectionRequest)request);
		} else if(REQ_ANNOTATED_LINK_REORIENT_END.equals(request.getType())) {
			return getReconnectTargetCommand((ReconnectRequest)request);
		}
		return null;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		ICommandProxy c = (ICommandProxy)super.getReconnectTargetCommand(request);
		if(c == null) {
			return null;
		}
		if(request.getConnectionEditPart() instanceof AnnotatedLinkEditPart) {
			CompositeCommand cc = (CompositeCommand)c.getICommand();
			AnnotatedLinkEditCommand ac = new AnnotatedLinkEditCommand(getEditingDomain());
			ac.setAnnotatedLink((AnnotatedLinkEditPart)request.getConnectionEditPart());
			ac.setTarget(getHost());
			cc.add(ac);
			return c;
		}
		return UnexecutableCommand.INSTANCE;
	}

	private TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		ICommandProxy proxy = (ICommandProxy)super.getConnectionCompleteCommand(request);
		if(proxy == null) {
			return null;
		}
		CompositeCommand cc = (CompositeCommand)proxy.getICommand();
		@SuppressWarnings("rawtypes")
		Iterator it = cc.iterator();
		AnnotatedLinkEditCommand command = null;
		while(it.hasNext()) {
			Object next = it.next();
			if(next instanceof AnnotatedLinkEditCommand) {
				command = (AnnotatedLinkEditCommand)next;
				break;
			}
		}
		if(command == null) {
			return UnexecutableCommand.INSTANCE;
		}
		command.setTarget(getHost());
		return proxy;
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if(REQ_ANNOTATED_LINK_END.equals(request.getType())) {
			CreateConnectionRequest connReq = (CreateConnectionRequest)request;
			EditPart sourceEditPart = connReq.getSourceEditPart();
			EditPolicy editPolicy = sourceEditPart.getEditPolicy(AnnotatedLinkStartEditPolicy.ANNOTATED_LINK_START_ROLE);
			PolylineConnection connectionFeedback = (PolylineConnection)getConnectionFeedback(editPolicy);
			if(connectionFeedback != null) {
				connectionFeedback.setTargetDecoration(null);
			}
		}
	}

	@Override
	public void showSourceFeedback(Request request) {
		//do nothing, this is not the primary GraphicalNodeEditPolicy.
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		//do nothing, this is not the primary GraphicalNodeEditPolicy.
	}

	@Override
	public void showTargetFeedback(Request request) {
		if(REQ_ANNOTATED_LINK_END.equals(request.getType())) {
			//Show circle feedback at target anchor
			CreateConnectionRequest connReq = (CreateConnectionRequest)request;
			EditPart sourceEditPart = connReq.getSourceEditPart();
			EditPolicy editPolicy = sourceEditPart.getEditPolicy(AnnotatedLinkStartEditPolicy.ANNOTATED_LINK_START_ROLE);
			editPolicy.showSourceFeedback(request);
			PolylineConnection connectionFeedback = (PolylineConnection)getConnectionFeedback(editPolicy);
			if(connectionFeedback != null) {
				Command command = getHost().getCommand(request);
				if(command != null && command.canExecute()) {
					EllipseDecoration dec = new EllipseDecoration();
					dec.setPreferredSize(10, 10);
					dec.setSize(10, 10);
					dec.setLineWidth(2);
					dec.setAntialias(SWT.ON);
					connectionFeedback.setTargetDecoration(dec);
				} else {
					connectionFeedback.setTargetDecoration(null);
				}
			}
		}
	}

	private Connection getConnectionFeedback(EditPolicy policy) {
		if(policy != null) {
			try {
				Field f = org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy.class.getDeclaredField("connectionFeedback");
				f.setAccessible(true);
				return (Connection)f.get(policy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
