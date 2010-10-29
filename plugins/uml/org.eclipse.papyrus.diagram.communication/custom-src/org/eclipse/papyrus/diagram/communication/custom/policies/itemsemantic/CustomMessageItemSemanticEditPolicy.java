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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.papyrus.diagram.communication.custom.commands.CustomMessageCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorDurationObservationCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorTimeObservationCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Message;

/**
 * this is a specialization to manage creation of Message,
 * CommentAnnotatedElement, ConstraintConstrainedElement,
 * DurationObservationEvent and TimeObservationEvent
 * 
 * This class also manages the deletion a message connector
 */
public class CustomMessageItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.communication.edit.policies.MessageItemSemanticEditPolicy {

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
		return super.getCompleteCreateRelationshipCommand(req);
	}

	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		//System.err.println("getReorientRelationshipCommand VisualID of element to reorient" + getVisualID(req));
		switch(getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));

		}
		return super.getReorientRelationshipCommand(req);
	}

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_8009 == req.getElementType()) {
			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}

	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);


		@SuppressWarnings("unchecked")
		List<EditPart> children = getHost().getChildren();
		List<EObject> elementsToDestroy = new ArrayList<EObject>();

		//A. Find the elements to destroy
		for(EditPart current : children) {
			Object model = current.getModel();

			if(model instanceof DecorationNode) {//if the current object is a label 
				EObject obj = ((DecorationNode)model).getElement();
				if(obj instanceof Message) {
					Message message = (Message)obj;

					//1. Add the message to the list of elements to destroy
					elementsToDestroy.add(message);

				}
			}

		}

		//B. Build the destroy command
		for(EObject selectedEObject : elementsToDestroy) {

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
			if(provider == null) {
				continue;
			}

			// Retrieve delete command from the Element Edit service
			DestroyElementRequest request = new DestroyElementRequest(selectedEObject, false);
			ICommand deleteCommand = provider.getEditCommand(request);

			// Add current EObject destroy command to the global command
			cmd.add(deleteCommand);
		}


		return getGEFWrapper(cmd.reduce());

	}
}
