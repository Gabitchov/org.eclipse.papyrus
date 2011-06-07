/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.CustomGraphicalTypeRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.GraphicalTypeRegistry;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;

/**
 * <pre>
 * Custom semantic edit policy that replace DefaultSemanticEditPolicy
 * in order to manage Class Diagram specific elements (reference 
 * relationships COMMENT_ANNOTATED_ELEMENT and CONSTRAINT_CONSTRAINED_ELEMENT).
 * </pre>
 */
public class CustomDefaultSemanticEditPolicy extends DefaultSemanticEditPolicy {

	/** Local graphical type registry for graphical elements */
	private IGraphicalTypeRegistry registry = new CustomGraphicalTypeRegistry();
	
	/** Local graphical type registry for inherited graphical elements */
	private IGraphicalTypeRegistry inheritedRegistry = new GraphicalTypeRegistry();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		
		// Explicitly forbid Comment or Constraint creation using ElementType defined in Class Diagram
		// A better implementation should be provided, this one is not subtle but should have minimal side effect
		// (see bug #348550)
		// Correct implementation should not return an unexecutable command here, it is the creation edit policy 
		// that should be modified in order to check if a view can be created before trying to. Such implementation 
		// is proposed for compartment creation edit policy 
		// (see org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultCreationEditPolicy).
		// Some nodes (Classifiers) still use the creation edit policy from Class Diagram (previoulsy in order to 
		// support AssociationClass, but this item have been removed from the diagram).
		if((ElementTypes.COMMENT == req.getElementType()) || (ElementTypes.COMMENT_CN == req.getElementType())) {
			return UnexecutableCommand.INSTANCE;
		}

		if((UMLElementTypes.CONSTRAINT == req.getElementType()) || (ElementTypes.CONSTRAINT == req.getElementType()) || (ElementTypes.CONSTRAINT_CN == req.getElementType())) {
			return UnexecutableCommand.INSTANCE;
		}
		
		return super.getCreateCommand(req);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {

		if(ElementTypes.COMMENT_ANNOTATED_ELEMENT == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}

		if(ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}

		String newEdgeGraphicalType = registry.getEdgeGraphicalType(req.getElementType());

		if(inheritedRegistry.isKnownEdgeType(newEdgeGraphicalType)) {
			return UnexecutableCommand.INSTANCE;
		}

		if(!registry.isKnownEdgeType(newEdgeGraphicalType)) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		View reconnectedView = (View)req.getParameter(RequestParameterConstants.GRAPHICAL_RECONNECTED_EDGE);
		String reconnectedViewType = (reconnectedView != null) ? reconnectedView.getType() : IGraphicalTypeRegistry.UNDEFINED_TYPE;

		if(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint().equals(reconnectedViewType)) {
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}

		if(ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT.getSemanticHint().equals(reconnectedViewType)) {
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		}

		return super.getReorientReferenceRelationshipCommand(req);
	}

}
