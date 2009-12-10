/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.clazz.custom.command.AddedLinkReorientCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationClassCreateCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ClassItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * this class is used to call our own association class create command
 * 
 */
public class CustomClassItemSemanticEditPolicy extends ClassItemSemanticEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.AssociationClass_4017 == req.getElementType()) {
			return getGEFWrapper(new CAssociationClassCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new CAssociationReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazz.custom.command.CAssociationCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.AssociationClass_4017 == req.getElementType()) {
			return getGEFWrapper(new CAssociationClassCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}
	

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		case AddedLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new AddedLinkReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}
}
