/*****************************************************************************
 * Copyright (c) 2009 CEA
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CombinedFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConsiderIgnoreFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ContinuationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.InteractionUseCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message2CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message2ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message3CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message3ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message4CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message4ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message5CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message5ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message6CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message6ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message7CreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message7ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.MessageCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.OperandBoundsComputeHelper;

/**
 * @generated
 */
public class InteractionOperandItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InteractionOperandItemSemanticEditPolicy() {
		super(UMLElementTypes.InteractionOperand_3005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.InteractionUse_3002 == req.getElementType()) {
			return getGEFWrapper(new InteractionUseCreateCommand(req));
		}
		if(UMLElementTypes.ConsiderIgnoreFragment_3007 == req.getElementType()) {
			return getGEFWrapper(new ConsiderIgnoreFragmentCreateCommand(req));
		}
		if(UMLElementTypes.CombinedFragment_3004 == req.getElementType()) {
			return getGEFWrapper(new CombinedFragmentCreateCommand(req));
		}
		if(UMLElementTypes.Continuation_3016 == req.getElementType()) {
			return getGEFWrapper(new ContinuationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof ReconnectRequest) {
			EditPart combinedFragment = getHost().getParent().getParent();
			((ReconnectRequest)request).setTargetEditPart(combinedFragment);
			return combinedFragment.getCommand(request);
		}
		return super.getCommand(request);
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);
			if(deleteCommand != null) {
				if(deleteCommand instanceof ICompositeCommand) {
					OperandBoundsComputeHelper.addUpdateBoundsCommandForOperandDelelete(this.getHost(), (ICompositeCommand)deleteCommand);
				}
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated NOT redirect message creation to CF
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_4003 == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart)combinedFragmentPart).resolveSemanticElement();
			if(((IGraphicalEditPart)getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new MessageCreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;//return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart)combinedFragmentPart).resolveSemanticElement();
			if(((IGraphicalEditPart)getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new Message2CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;//return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4005 == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart)combinedFragmentPart).resolveSemanticElement();
			if(((IGraphicalEditPart)getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new Message3CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;//return getGEFWrapper(new Message3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4006 == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart)combinedFragmentPart).resolveSemanticElement();
			if(((IGraphicalEditPart)getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new Message4CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;//return getGEFWrapper(new Message4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4007 == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart)combinedFragmentPart).resolveSemanticElement();
			if(((IGraphicalEditPart)getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new Message5CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;//return getGEFWrapper(new Message5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4008 == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart)combinedFragmentPart).resolveSemanticElement();
			if(((IGraphicalEditPart)getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new Message6CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;//return getGEFWrapper(new Message6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4009 == req.getElementType()) {
			// redirect message creation to CF
			EditPart combinedFragmentPart = getHost().getParent().getParent();
			EObject combinedFragment = ((IGraphicalEditPart)combinedFragmentPart).resolveSemanticElement();
			if(((IGraphicalEditPart)getHost()).resolveSemanticElement().equals(req.getSource())) {
				return getGEFWrapper(new Message7CreateCommand(req, combinedFragment, req.getTarget()));
			}
			return null;//return getGEFWrapper(new Message7CreateCommand(req, req.getSource(), req.getTarget()));
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
	 * @generated NOT let InteractionOperandLayoutEditPolicy redirect messages
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_4003 == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;//return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;//return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4005 == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;//return getGEFWrapper(new Message3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4006 == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;//return getGEFWrapper(new Message4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4007 == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;//return getGEFWrapper(new Message5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4008 == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;//return getGEFWrapper(new Message6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4009 == req.getElementType()) {
			// let InteractionOperandLayoutEditPolicy redirect messages
			return null;//return getGEFWrapper(new Message7CreateCommand(req, req.getSource(), req.getTarget()));
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
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));
		case Message2EditPart.VISUAL_ID:
			return getGEFWrapper(new Message2ReorientCommand(req));
		case Message3EditPart.VISUAL_ID:
			return getGEFWrapper(new Message3ReorientCommand(req));
		case Message4EditPart.VISUAL_ID:
			return getGEFWrapper(new Message4ReorientCommand(req));
		case Message5EditPart.VISUAL_ID:
			return getGEFWrapper(new Message5ReorientCommand(req));
		case Message6EditPart.VISUAL_ID:
			return getGEFWrapper(new Message6ReorientCommand(req));
		case Message7EditPart.VISUAL_ID:
			return getGEFWrapper(new Message7ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}
}
