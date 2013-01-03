/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts.CustomFullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.MessageUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostEditPart;

public class CustomLifelineCompartmentGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	@Override
	protected INodeEditPart getConnectionCompleteEditPart(final Request request) {
		// connect to the Lifeline
		return (INodeEditPart) getHost().getParent();
	}

	@Override
	protected INodeEditPart getConnectableEditPart() {
		// connect to the Lifeline
		return (INodeEditPart) getHost().getParent();
	}

	/**
	 * Let the target anchor of a MessageLost be moved, by storing the desired location in an EAnnotation on the
	 * connector, which will then be used in
	 * {@link CustomFullLifelineEditPartCN#getTargetConnectionAnchor(ConnectionEditPart)}
	 */
	@Override
	protected Command getReconnectTargetCommand(final ReconnectRequest request) {
		final ConnectionEditPart connectionEditPart = request.getConnectionEditPart();
		if (connectionEditPart instanceof MessageLostEditPart) {
			final TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
			final IFigure sourceFigure = ((GraphicalEditPart) connectionEditPart.getSource()).getFigure();
			return MessageUtils.createMoveMessageAnchorCommand(request, connectionEditPart, sourceFigure,
					Messages.CustomLifelineCompartmentGraphicalNodeEditPolicy_SetMessageLostTargetLocation, editingDomain);
		}
		return super.getReconnectTargetCommand(request);
	}

	/**
	 * Let the target anchor of a MessageFound be moved, by storing the desired location in an EAnnotation on the
	 * connector, which will then be used in
	 * {@link CustomFullLifelineEditPartCN#getSourceConnectionAnchor(ConnectionEditPart)}
	 */
	@Override
	protected Command getReconnectSourceCommand(final ReconnectRequest request) {
		final ConnectionEditPart connectionEditPart = request.getConnectionEditPart();
		if (connectionEditPart instanceof MessageFoundEditPart) {
			final TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
			final IFigure targetFigure = ((GraphicalEditPart) connectionEditPart.getTarget()).getFigure();
			return MessageUtils.createMoveMessageAnchorCommand(request, connectionEditPart, targetFigure,
					Messages.CustomLifelineCompartmentGraphicalNodeEditPolicy_SetMessageFoundSourceLocation, editingDomain);
		}
		return super.getReconnectTargetCommand(request);
	}

	/** Returns the anchor for target feedback when creating a lost message */
	@Override
	protected ConnectionAnchor getTargetConnectionAnchor(final CreateConnectionRequest request) {
		return new XYAnchor(new Point(request.getLocation()));
	}

	/** Returns the anchor for source feedback when creating a found message */
	@Override
	protected ConnectionAnchor getSourceConnectionAnchor(final CreateConnectionRequest request) {
		final Point startLocation = MessageUtils.retrieveRequestStartLocation(request);
		if (startLocation != null) {
			return new XYAnchor(new Point(startLocation));
		}
		return super.getSourceConnectionAnchor(request);
	}
}
