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

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.usecase.edit.commands.AssociationCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.AssociationReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.DependencyCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.DependencyReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ExtendCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.ExtendReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.GeneralizationCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.GeneralizationReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.IncludeCreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.IncludeReorientCommand;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseExtensionpointsEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class UseCase2ItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (UMLVisualIDRegistry.getVisualID(node)) {
			case UseCaseExtensionpointsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (UMLVisualIDRegistry.getVisualID(cnode)) {
					case ExtensionPoint2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
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
		if (UMLElementTypes.Include_4001 == req.getElementType()) {
			return getGEFWrapper(new IncludeCreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		if (UMLElementTypes.Extend_4002 == req.getElementType()) {
			return getGEFWrapper(new ExtendCreateCommand(req, req.getSource(),
					req.getTarget()));
		}
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
		if (UMLElementTypes.Include_4001 == req.getElementType()) {
			return getGEFWrapper(new IncludeCreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		if (UMLElementTypes.Extend_4002 == req.getElementType()) {
			return getGEFWrapper(new ExtendCreateCommand(req, req.getSource(),
					req.getTarget()));
		}
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
		case IncludeEditPart.VISUAL_ID:
			return getGEFWrapper(new IncludeReorientCommand(req));
		case ExtendEditPart.VISUAL_ID:
			return getGEFWrapper(new ExtendReorientCommand(req));
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
