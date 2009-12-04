/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.ids.ReorientLinkIDs;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.ElementOwnedCommentCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.ElementOwnedCommentReorientCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.TransitionCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.TransitionReorientCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * @generated
 */
public class StateItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
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
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if(UMLElementTypes.Transition_3001 == req.getElementType()) {
			return getGEFWrapper(new TransitionCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ElementOwnedComment_3002 == req.getElementType()) {
			return getGEFWrapper(new ElementOwnedCommentCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_3003 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Modified to set correct container when source is an EntryPoint attached
	 * to a StateMachine
	 * 
	 * @generated NOT
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		Diagram diagram = DiagramEditPartsUtil
				.findDiagramFromEditPart(getHost());
		if(diagram != null) {
			req.getParameters().put(MultiDiagramUtil.BelongToDiagramSource,
					diagram);
		}
		if(UMLElementTypes.Transition_3001 == req.getElementType()) {
			EObject sourceEObject = req.getSource();
			EObject targetEObject = req.getTarget();
			if(false == sourceEObject instanceof Vertex
					|| false == targetEObject instanceof Vertex) {
				return UnexecutableCommand.INSTANCE;
			}
			Vertex source = (Vertex)sourceEObject;
			Vertex target = (Vertex)targetEObject;
			Region container = (Region)getRelationshipContainer(source,
					UMLPackage.eINSTANCE.getRegion(), req.getElementType());
			// set correct region when source is an EntryPoint attached to a
			// StateMachine
			if(container == null && source instanceof Pseudostate) {
				Pseudostate pseudoState = (Pseudostate)source;
				if(pseudoState.getKind().equals(
						PseudostateKind.ENTRY_POINT_LITERAL)) {
					container = (Region)getRelationshipContainer(target,
							UMLPackage.eINSTANCE.getRegion(), req
							.getElementType());
					req.setContainer(container);
				}
			}
			// end
			if(container == null) {
				return UnexecutableCommand.INSTANCE;
			}
			if(!UMLBaseItemSemanticEditPolicy.LinkConstraints
					.canCreateTransition_3001(container, source, target)) {
				return UnexecutableCommand.INSTANCE;
			}
			if(req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getRegion_Transition());
			}
			return getGEFWrapper(new TransitionCreateCommand(req, source,
					target));
		}
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

		// add the view element
		req.setParameter(ReorientLinkIDs.nodeEditPart,
				((IGraphicalEditPart)this.getHost()).getNotationView());
		// add the view link
		List list = DiagramEditPartsUtil.getEObjectViews(req.getRelationship());
		if(list.size() > 0) {
			req.setParameter(ReorientLinkIDs.linkEditPart, list.get(0));
		}

		switch(getVisualID(req)) {
		case TransitionEditPart.VISUAL_ID:
			return getGEFWrapper(new TransitionReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or
	 * source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getGEFWrapper(new ElementOwnedCommentReorientCommand(req));
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
