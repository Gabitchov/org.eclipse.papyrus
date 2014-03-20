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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomCommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomDurationConstraintInMessageCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomDurationObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage2CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage2ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage3CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage3ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage4CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage4ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage5CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage5ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage6CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage6ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage7CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessage7ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessageCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomMessageReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionItemSemanticEditPolicy extends InteractionItemSemanticEditPolicy {

	/**
	 * @Override
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.DurationConstraint_3023 == req.getElementType()) {
			return getGEFWrapper(new CustomDurationConstraintInMessageCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.DurationObservation_3024 == req.getElementType()) {
			return getGEFWrapper(new CustomDurationObservationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @Override
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);
			if(deleteCommand != null) {
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @Override
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @Override
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4005 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4006 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4007 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4008 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4009 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4010 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4011 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @Override
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4005 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4006 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4007 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4008 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4009 == req.getElementType()) {
			return getGEFWrapper(new CustomMessage7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4010 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain
	 * model element associated with this node.
	 * 
	 * @Override
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessageReorientCommand(req));
		case Message2EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage2ReorientCommand(req));
		case Message3EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage3ReorientCommand(req));
		case Message4EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage4ReorientCommand(req));
		case Message5EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage5ReorientCommand(req));
		case Message6EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage6ReorientCommand(req));
		case Message7EditPart.VISUAL_ID:
			return getGEFWrapper(new CustomMessage7ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @Override
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomCommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}
}
