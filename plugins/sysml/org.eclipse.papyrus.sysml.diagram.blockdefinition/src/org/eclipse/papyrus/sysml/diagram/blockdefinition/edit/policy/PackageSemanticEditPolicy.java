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
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.clazz.edit.policies.PackageItemSemanticEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.CustomGraphicalTypeRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.GraphicalTypeRegistry;

/**
 * <pre>
 * Custom semantic edit policy for Package and Model edit parts.
 * These edit parts are reused from class diagram but should allow 
 * creation, re-orient of relationship from the Block Definition Diagram.
 * </pre>
 */
public class PackageSemanticEditPolicy extends PackageItemSemanticEditPolicy {

	/** Local graphical type registry for graphical elements */
	private IGraphicalTypeRegistry registry = new CustomGraphicalTypeRegistry();
	
	/** Local graphical type registry for inherited graphical elements */
	private IGraphicalTypeRegistry inheritedRegistry = new GraphicalTypeRegistry();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		String newEdgeGraphicalType = registry.getEdgeGraphicalType(req.getElementType());

		if(inheritedRegistry.isKnownEdgeType(newEdgeGraphicalType)) {			
			return super.getCreateRelationshipCommand(req);
		}

		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(req.getElementType());
		if(commandService == null) {
			return UnexecutableCommand.INSTANCE;
		}

		if(!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(newEdgeGraphicalType)) {
			return new ICommandProxy(commandService.getEditCommand(req));
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		String newEdgeGraphicalType = registry.getEdgeGraphicalType(req.getRelationship());

		if(inheritedRegistry.isKnownEdgeType(newEdgeGraphicalType)) {
			return super.getReorientRelationshipCommand(req);
		}

		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(req.getRelationship());
		if(commandService == null) {
			return UnexecutableCommand.INSTANCE;
		}

		if(!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(newEdgeGraphicalType)) {
			return new ICommandProxy(commandService.getEditCommand(req));
		}

		return UnexecutableCommand.INSTANCE;
	}
}
