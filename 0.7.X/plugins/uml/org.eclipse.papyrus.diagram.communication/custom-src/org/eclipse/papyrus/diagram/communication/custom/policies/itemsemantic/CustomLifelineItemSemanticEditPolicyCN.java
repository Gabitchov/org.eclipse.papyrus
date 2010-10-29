/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.communication.custom.policies.itemsemantic;

import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.communication.custom.commands.CustomMessageCreateCommand;
import org.eclipse.papyrus.diagram.communication.custom.commands.CustomMessagesReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorDurationObservationCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorTimeObservationCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.policies.LifelineItemSemanticEditPolicyCN;
import org.eclipse.papyrus.diagram.communication.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this is a specialization to manage creation of Message,
 * CommentAnnotatedElement, ConstraintConstrainedElement,
 * DurationObservationEvent and TimeObservationEvent
 */
public class CustomLifelineItemSemanticEditPolicyCN extends LifelineItemSemanticEditPolicyCN {

	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if(UMLElementTypes.Message_8009 == req.getElementType()) {

			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}

		if(UMLElementTypes.CommentAnnotatedElement_8010 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ConstraintConstrainedElement_8011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}

		if(UMLElementTypes.DurationObservationEvent_8012 == req.getElementType()) {
			return getGEFWrapper(new ConnectorDurationObservationCreateCommand(req, req.getSource(), req.getTarget()));
		}

		if(UMLElementTypes.TimeObservationEvent_8013 == req.getElementType()) {
			return getGEFWrapper(new ConnectorTimeObservationCreateCommand(req, req.getSource(), req.getTarget()));
		}

		return null;
	}

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_8009 == req.getElementType()) {
			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}

		return null;
	}

	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		//System.err.println("getReorientRelationshipCommand VisualID of element to reorient :" + getVisualID(req));
		switch(getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:

			//return getGEFWrapper(new CustomMessagesReorientCommand(req));
			View connector = (View)req.getParameter(UMLBaseItemSemanticEditPolicy.GRAPHICAL_RECONNECTED_EDGE);
			Object elementToedit = UMLPackage.eINSTANCE.getMessage();
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToedit);
			if(provider == null) {
				return UnexecutableCommand.INSTANCE;
			}

			ICommand reorientCommand = null;
			//1. add the reorient messages command 
			reorientCommand = CompositeCommand.compose(reorientCommand, new CustomMessagesReorientCommand(req));

			Iterator<?> it = connector.getChildren().iterator();
			while(it.hasNext()) {
				Object object = (Object)it.next();

				if(object instanceof View) {
					View child = (View)object;

					if((child.getElement() != null) && (child.getElement() instanceof Message)) {

						Message messageToReorient = (Message)child.getElement();
						ReorientRequest reorientMessageRequest = new ReorientRelationshipRequest(messageToReorient, req.getNewRelationshipEnd(), req.getOldRelationshipEnd(), req.getDirection());
						reorientMessageRequest.setParameter(UMLBaseItemSemanticEditPolicy.GRAPHICAL_RECONNECTED_EDGE, connector);
						ICommand reorientMessageCommand = provider.getEditCommand(reorientMessageRequest);
						reorientCommand = CompositeCommand.compose(reorientCommand, reorientMessageCommand);
						break;
					}
				}

			}

			if(reorientCommand == null) {
				return UnexecutableCommand.INSTANCE;
			}
			return getGEFWrapper(reorientCommand.reduce());
		}
		return super.getReorientRelationshipCommand(req);
	}


}
