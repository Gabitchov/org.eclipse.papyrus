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
package org.eclipse.papyrus.sysml.diagram.parametric.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.infra.services.edit.utils.RequestParameterConstants;
import org.eclipse.papyrus.sysml.diagram.parametric.commands.CustomBindingConnectorReorientCommand;
import org.eclipse.papyrus.sysml.diagram.parametric.commands.ReorientReferenceRelationshipRequestWithGraphical;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.CustomGraphicalTypeRegistry;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.GraphicalTypeRegistry;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.uml.service.types.command.ConnectorReorientCommand;

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
		if(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID.equals(reconnectedViewType)) {
			if (req instanceof ReorientReferenceRelationshipRequestWithGraphical) {
				return getGEFWrapper(new CustomBindingConnectorReorientCommand((ReorientReferenceRelationshipRequestWithGraphical)req));
			}
			else {
				return getGEFWrapper(new ConnectorReorientCommand(req));
			}
		}


		return super.getReorientReferenceRelationshipCommand(req);
	}

}
