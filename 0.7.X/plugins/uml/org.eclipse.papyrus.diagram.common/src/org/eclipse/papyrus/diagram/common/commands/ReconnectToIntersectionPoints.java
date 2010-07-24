/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;

// TODO: Auto-generated Javadoc
/**
 * The Class ReconnectToIntersectionPoints.
 * 
 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a>
 */
// @unused
public class ReconnectToIntersectionPoints extends Command {

	/** The create request. */
	CreateConnectionViewAndElementRequest createRequest = null;

	/** The compound cmd. */
	CompoundCommand compoundCmd;

	// GraphicalEditPart parentEditPart = null;

	/**
	 * Instantiates a new reconnect to intersection points.
	 * 
	 * @param request
	 *        the request
	 */
	// @unused
	public ReconnectToIntersectionPoints(CreateConnectionViewAndElementRequest request) {
		this.createRequest = request;

		compoundCmd = new CompoundCommand();
		compoundCmd.setLabel("Anchor ends at intersection points");
		compoundCmd.setDebugLabel("Debug: Anchor ends at intersection points");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return (super.canExecute() && createRequest != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.execute();

		// Obtain the descriptor
		ViewDescriptor viewDescriptor = createRequest.getConnectionViewDescriptor();

		// Get the View
		View view = (View)viewDescriptor.getAdapter(View.class);
		if(view == null) {
			return;
		}

		// Get the viewer
		EditPartViewer viewer = createRequest.getSourceEditPart().getViewer();

		// Obtain the EditPart
		ConnectionEditPart connEP = (ConnectionEditPart)viewer.getEditPartRegistry().get(view);

		connEP.getFigure().getUpdateManager().performUpdate();

		// Create the source reconnect request
		ReconnectRequest sourceRequest = buildReconnectRequest(connEP, true);

		// Create the target reconnect request
		ReconnectRequest targetRequest = buildReconnectRequest(connEP, false);

		// Obtain the commands
		compoundCmd.add(getCommand(sourceRequest, (GraphicalEditPart)connEP.getSource()));
		compoundCmd.add(getCommand(targetRequest, (GraphicalEditPart)connEP.getTarget()));

		// Execute the commands
		if(compoundCmd.size() > 0) {
			compoundCmd.execute();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		super.undo();
		if(compoundCmd.size() > 0) {
			compoundCmd.undo();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		super.redo();
		if(compoundCmd.size() > 0) {
			compoundCmd.redo();
		}
	}

	/**
	 * Builds the reconnect request.
	 * 
	 * @param connEP
	 *        the conn ep
	 * @param isSource
	 *        the is source
	 * 
	 * @return the reconnect request
	 */
	public static ReconnectRequest buildReconnectRequest(ConnectionEditPart connEP, boolean isSource) {

		// Obtain the intersection point
		Point p = getIntersectionPoint(connEP, isSource);

		// Obtain the target edit part
		EditPart targetEP;
		String type;
		if(isSource) {
			type = RequestConstants.REQ_RECONNECT_SOURCE;
			targetEP = connEP.getSource();
		} else {
			type = RequestConstants.REQ_RECONNECT_TARGET;
			targetEP = connEP.getTarget();
		}

		// Create and set the properties of the request
		ReconnectRequest reconnReq = new ReconnectRequest();
		reconnReq.setConnectionEditPart(connEP);
		reconnReq.setLocation(p);
		reconnReq.setTargetEditPart(targetEP);
		reconnReq.setType(type);

		// Return the request
		return reconnReq;
	}

	/**
	 * Gets the intersection point.
	 * 
	 * @param connEP
	 *        the conn ep
	 * @param source
	 *        the source
	 * 
	 * @return the intersection point
	 */
	public static Point getIntersectionPoint(ConnectionEditPart connEP, boolean source) {

		ConnectionAnchor sourceAnchor;
		ConnectionAnchor targetAnchor;

		NodeEditPart sourceEP = (NodeEditPart)connEP.getSource();
		NodeEditPart targetEP = (NodeEditPart)connEP.getTarget();

		Point endLocation;

		sourceAnchor = sourceEP.getSourceConnectionAnchor(connEP);
		targetAnchor = targetEP.getTargetConnectionAnchor(connEP);

		if(source) {
			endLocation = sourceAnchor.getLocation(targetAnchor.getReferencePoint()).getCopy();
		} else {
			endLocation = targetAnchor.getLocation(sourceAnchor.getReferencePoint()).getCopy();
		}

		return endLocation;
	}

	/**
	 * Gets the command.
	 * 
	 * @param request
	 *        the request
	 * @param graphicalEP
	 *        the graphical ep
	 * 
	 * @return the command
	 */
	public static Command getCommand(Request request, GraphicalEditPart graphicalEP) {
		return graphicalEP.getEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE).getCommand(request);
	}

	/**
	 * Modify location.
	 * 
	 * @param reconnectRequest
	 *        the reconnect request
	 */
	// @unused
	public static void modifyLocation(ReconnectRequest reconnectRequest) {
		ShapeNodeEditPart sourceEP;
		ShapeNodeEditPart targetEP;

		ConnectionAnchor sourceAnchor;
		ConnectionAnchor targetAnchor;

		Point endLocation;

		sourceEP = (ShapeNodeEditPart)reconnectRequest.getConnectionEditPart().getSource();
		targetEP = (ShapeNodeEditPart)reconnectRequest.getConnectionEditPart().getTarget();

		if(reconnectRequest.isMovingStartAnchor()) {
			// Update the corresponding EditPart
			sourceEP = (ShapeNodeEditPart)reconnectRequest.getTarget();

			sourceAnchor = sourceEP.getSourceConnectionAnchor(reconnectRequest);
			targetAnchor = targetEP.getTargetConnectionAnchor(reconnectRequest.getConnectionEditPart());
			endLocation = sourceAnchor.getLocation(targetAnchor.getReferencePoint()).getCopy();
		} else {
			// Update the corresponding EditPart
			targetEP = (ShapeNodeEditPart)reconnectRequest.getTarget();

			sourceAnchor = sourceEP.getSourceConnectionAnchor(reconnectRequest.getConnectionEditPart());
			targetAnchor = targetEP.getTargetConnectionAnchor(reconnectRequest);
			endLocation = targetAnchor.getLocation(sourceAnchor.getReferencePoint()).getCopy();
		}
		reconnectRequest.setLocation(endLocation);
	}
}
