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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.PackagePackageableElementCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.CustomGraphicalTypeRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.GraphicalTypeRegistry;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

/**
 * This semantic edit policy allows the creation of Block inside Package
 * compartment. The default behavior is inherited from Class Diagram for
 * elements other than Block (or Block Definition Diagram specific elements)
 * 
 */
public class PackageCompartmentSemanticEditPolicy extends PackagePackageableElementCompartmentItemSemanticEditPolicy {

	/** Local graphical type registry for graphical element containment management */
	private IGraphicalTypeRegistry registry = new CustomGraphicalTypeRegistry();
	private IGraphicalTypeRegistry inheritedRegistry = new GraphicalTypeRegistry();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		String newNodeGraphicalType = registry.getNodeGraphicalType(req.getElementType(), ((View)getHost().getModel()).getType());
		
		if (inheritedRegistry.isKnownNodeType(newNodeGraphicalType)) {
			return super.getCreateCommand(req);
		}
		
		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(UMLElementTypes.PACKAGE);
		if(commandService == null) {
			return UnexecutableCommand.INSTANCE;
		}

		if(!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(newNodeGraphicalType)) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), req.getElementType());
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}

		return UnexecutableCommand.INSTANCE;
	}
}
