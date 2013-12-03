/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomContextLinkCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContextLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomLifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomLifelineEditPart.CustomLifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.hamcrest.core.IsInstanceOf;

/**
 * This class is used to manage the the creation of a contextLink
 */
public class CustomInteractionOperandContextLinkSemanticEditPolicy extends CustomInteractionOperandItemSemanticEditPolicy {

	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ConstraintContext_8500 == req.getElementType()) {
			return getGEFWrapper(new CustomContextLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest)request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for(Object obj : relationshipTypes) {
				if(UMLElementTypes.ConstraintContext_8500.equals(obj)) {
					Point location = ((DropRequest)request).getLocation();
					EditPart host = getHost();
					if(isEnterAnchorArea(host, location)) {
						return host;
					}
				}
			}
		}
		if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if(connectionEditPart instanceof ContextLinkEditPart) {
				Point location = ((DropRequest)request).getLocation();
				EditPart host = getHost();
				if(isEnterAnchorArea(host, location)) {
					return host;
				}
			}
		}
		return super.getTargetEditPart(request);
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
}
