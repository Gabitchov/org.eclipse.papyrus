/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.itemsemantic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.command.CustomConnectorCreateCommand;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConnectorEditPart;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;

/**
 * <pre>
 * This class provides a custom edit policy used to replace the SEMANTIC_ROLE 
 * generated for the Property element (when used as Composite Part)
 * 
 * TODO : This should probably also manage Port clean removal (semantic deletion causes issues)
 * </pre>
 */
public class PropertyPartItemSemanticEditPolicyCN extends org.eclipse.papyrus.uml.diagram.component.edit.policies.PropertyItemSemanticEditPolicy {
	/**
	 * <pre>
	 * Calls a custom creation command to allow the creation of a Port on a Property. 
	 * The Property has to be typed by a StructuredClassifier. 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.uml.diagram.component.custom.command.CustomPortCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * <pre>
	 * Forbid direct destruction of Property in case the graphical parent is not
	 * the semantic parent.  
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject graphicalParent = ((GraphicalEditPart) getHost().getParent()).resolveSemanticElement();
		EObject semanticParent = req.getElementToDestroy().eContainer();
		if (graphicalParent != semanticParent) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getDestroyElementCommand(req);
	}

	/**
	 * <pre>
	 * Calls a custom creation command to allow the creation of a Connector connected to a Property
	 * on its source end. 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Connector_4019 == req.getElementType()) {
			req.setParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_GRAPHICAL, getHost());
			return getGEFWrapper(new CustomConnectorCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}

	/**
	 * <pre>
	 * Calls a custom creation command to allow the creation of a Connector connected to a Property
	 * on its target end. 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Connector_4019 == req.getElementType()) {
			req.setParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_GRAPHICAL, getHost());
			return getGEFWrapper(new CustomConnectorCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ConnectorEditPart.VISUAL_ID:
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(req.getRelationship());
			if (provider == null) {
				return UnexecutableCommand.INSTANCE;
			}
			// Add graphical new end View in request parameters
			View targetView = (View) getHost().getModel();
			req.setParameter(RequestParameterConstants.EDGE_REORIENT_REQUEST_END_VIEW, targetView);
			// Retrieve re-orient command from the Element Edit service
			ICommand reorientCommand = provider.getEditCommand(req);
			if (reorientCommand == null) {
				return UnexecutableCommand.INSTANCE;
			}
			return getGEFWrapper(reorientCommand.reduce());
		}
		return super.getReorientRelationshipCommand(req);
	}
}
