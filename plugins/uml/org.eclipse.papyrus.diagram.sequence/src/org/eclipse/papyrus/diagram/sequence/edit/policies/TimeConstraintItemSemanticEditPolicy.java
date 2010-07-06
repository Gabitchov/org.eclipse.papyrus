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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message3CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message3ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message4CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message4ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message5CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message5ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message6CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message6ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message7CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message7ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class TimeConstraintItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TimeConstraintItemSemanticEditPolicy() {
		super(UMLElementTypes.TimeConstraint_3019);
	}


	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);


		for(Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge)it.next();
			switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
			case CommentAnnotatedElementEditPart.VISUAL_ID:
			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(destroyRefReq));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				break;
			case MessageEditPart.VISUAL_ID:
			case Message2EditPart.VISUAL_ID:
			case Message3EditPart.VISUAL_ID:
			case Message4EditPart.VISUAL_ID:
			case Message5EditPart.VISUAL_ID:
			case Message6EditPart.VISUAL_ID:
			case Message7EditPart.VISUAL_ID:
				DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(destroyEltReq));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				break;
			}
		}

		for(Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge)it.next();
			switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(destroyRefReq));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				break;
			case MessageEditPart.VISUAL_ID:
			case Message2EditPart.VISUAL_ID:
			case Message3EditPart.VISUAL_ID:
			case Message4EditPart.VISUAL_ID:
			case Message5EditPart.VISUAL_ID:
			case Message6EditPart.VISUAL_ID:
			case Message7EditPart.VISUAL_ID:
				DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(destroyEltReq));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				break;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if(annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
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
		if(UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4005 == req.getElementType()) {
			return getGEFWrapper(new Message3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4006 == req.getElementType()) {
			return getGEFWrapper(new Message4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4007 == req.getElementType()) {
			return getGEFWrapper(new Message5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4008 == req.getElementType()) {
			return getGEFWrapper(new Message6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4009 == req.getElementType()) {
			return getGEFWrapper(new Message7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4010 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4005 == req.getElementType()) {
			return getGEFWrapper(new Message3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4006 == req.getElementType()) {
			return getGEFWrapper(new Message4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4007 == req.getElementType()) {
			return getGEFWrapper(new Message5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4008 == req.getElementType()) {
			return getGEFWrapper(new Message6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4009 == req.getElementType()) {
			return getGEFWrapper(new Message7CreateCommand(req, req.getSource(), req.getTarget()));
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
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
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
