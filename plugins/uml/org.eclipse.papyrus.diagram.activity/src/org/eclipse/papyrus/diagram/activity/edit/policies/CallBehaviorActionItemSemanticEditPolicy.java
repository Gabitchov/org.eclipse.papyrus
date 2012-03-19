/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.policies;

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
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionInputPinInCallBeActCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionLocalPostconditionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionLocalPostconditionReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionLocalPreconditionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionLocalPreconditionReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CommentLinkCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CommentLinkReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ControlFlowCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ControlFlowReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExceptionHandlerCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExceptionHandlerReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InputPinInCallBeActCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.OutputPinInCallBeActCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ValuePinInCallBeActCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentLinkEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

/**
 * @generated
 */
public class CallBehaviorActionItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public CallBehaviorActionItemSemanticEditPolicy() {
		super(UMLElementTypes.CallBehaviorAction_3008);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.ValuePin_3017 == req.getElementType()) {
			return getGEFWrapper(new ValuePinInCallBeActCreateCommand(req));
		}
		if(UMLElementTypes.ActionInputPin_3018 == req.getElementType()) {
			return getGEFWrapper(new ActionInputPinInCallBeActCreateCommand(req));
		}
		if(UMLElementTypes.InputPin_3019 == req.getElementType()) {
			return getGEFWrapper(new InputPinInCallBeActCreateCommand(req));
		}
		if(UMLElementTypes.OutputPin_3020 == req.getElementType()) {
			return getGEFWrapper(new OutputPinInCallBeActCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
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
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ActionLocalPrecondition_4001 == req.getElementType()) {
			return getGEFWrapper(new ActionLocalPreconditionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ActionLocalPostcondition_4002 == req.getElementType()) {
			return getGEFWrapper(new ActionLocalPostconditionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ObjectFlow_4003 == req.getElementType()) {
			return getGEFWrapper(new ObjectFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ControlFlow_4004 == req.getElementType()) {
			return getGEFWrapper(new ControlFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ExceptionHandler_4005 == req.getElementType()) {
			return getGEFWrapper(new ExceptionHandlerCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4006 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ActionLocalPrecondition_4001 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ActionLocalPostcondition_4002 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ObjectFlow_4003 == req.getElementType()) {
			return getGEFWrapper(new ObjectFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ControlFlow_4004 == req.getElementType()) {
			return getGEFWrapper(new ControlFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ExceptionHandler_4005 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.CommentAnnotatedElement_4006 == req.getElementType()) {
			return getGEFWrapper(new CommentLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case ObjectFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new ObjectFlowReorientCommand(req));
		case ControlFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new ControlFlowReorientCommand(req));
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getGEFWrapper(new ExceptionHandlerReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or
	 * source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return getGEFWrapper(new ActionLocalPreconditionReorientCommand(req));
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return getGEFWrapper(new ActionLocalPostconditionReorientCommand(req));
		case CommentLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentLinkReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}
}
