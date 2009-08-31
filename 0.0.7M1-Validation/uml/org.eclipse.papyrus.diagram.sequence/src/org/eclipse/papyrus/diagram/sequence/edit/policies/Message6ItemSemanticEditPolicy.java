/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import org.eclipse.papyrus.diagram.sequence.edit.commands.ElementOwnedCommentCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message3ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message4ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message5ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message6ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated NOT
 */
public class Message6ItemSemanticEditPolicy extends
		MessageDestroySemanticEditPolicy {

	/**
	 * @generated NOT
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return super.getDestroyElementCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated not
	 * @author mgil
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		/**
		 * Commented to avoid trying to link a Message from another Message
		 */
		// if (UMLElementTypes.Message_3001 == req.getElementType()) {
		// return getGEFWrapper(new MessageCreateCommand(req, req.getSource(),
		// req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3002 == req.getElementType()) {
		// return getGEFWrapper(new Message2CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3003 == req.getElementType()) {
		// return getGEFWrapper(new Message3CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3004 == req.getElementType()) {
		// return getGEFWrapper(new Message4CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3005 == req.getElementType()) {
		// return getGEFWrapper(new Message5CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3006 == req.getElementType()) {
		// return getGEFWrapper(new Message6CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		if (UMLElementTypes.ElementOwnedComment_3007 == req.getElementType()) {
			return getGEFWrapper(new ElementOwnedCommentCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated not
	 * @author mgil
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		/**
		 * Commented to avoid trying to link a Message from another Message
		 */
		// if (UMLElementTypes.Message_3001 == req.getElementType()) {
		// return getGEFWrapper(new MessageCreateCommand(req, req.getSource(),
		// req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3002 == req.getElementType()) {
		// return getGEFWrapper(new Message2CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3003 == req.getElementType()) {
		// return getGEFWrapper(new Message3CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3004 == req.getElementType()) {
		// return getGEFWrapper(new Message4CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3005 == req.getElementType()) {
		// return getGEFWrapper(new Message5CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		// if (UMLElementTypes.Message_3006 == req.getElementType()) {
		// return getGEFWrapper(new Message6CreateCommand(req,
		// req.getSource(), req.getTarget()));
		// }
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
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
		}
		return super.getReorientRelationshipCommand(req);
	}

}
