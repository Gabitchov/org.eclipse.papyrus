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

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowSelectionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowSelectionReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowTransformationCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowTransformationReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */
public class ObjectFlowItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ObjectFlowItemSemanticEditPolicy() {
		super(UMLElementTypes.ObjectFlow_4003);
	}

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
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ObjectFlowSelection_4005 == req.getElementType()) {
			return getGEFWrapper(new ObjectFlowSelectionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ObjectFlowTransformation_4006 == req.getElementType()) {
			return getGEFWrapper(new ObjectFlowTransformationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ObjectFlowSelection_4005 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ObjectFlowTransformation_4006 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case ObjectFlowSelectionEditPart.VISUAL_ID:
			return getGEFWrapper(new ObjectFlowSelectionReorientCommand(req));
		case ObjectFlowTransformationEditPart.VISUAL_ID:
			return getGEFWrapper(new ObjectFlowTransformationReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
