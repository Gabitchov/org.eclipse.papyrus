/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.usecase.edit.commands.AssociationCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.AssociationReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.DependencyCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.DependencyReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.GeneralizationCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.GeneralizationReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class AssociationItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (UMLElementTypes.Generalization_4003 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Association_4004 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4005 == req
				.getElementType()) {
			return null;
		}
		if (UMLElementTypes.Dependency_4006 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4007 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (UMLElementTypes.Generalization_4003 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Association_4004 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4005 == req
				.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4006 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4007 == req
				.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case GeneralizationEditPart.VISUAL_ID:
			return getGEFWrapper(new GeneralizationReorientCommand(req));
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new AssociationReorientCommand(req));
		case DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(
					req));
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
