/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.command.FlowPortCreateCommand;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.command.PortCreateCommand;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;


public class BlockItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	public BlockItemSemanticEditPolicy() {
		super(BlockDefinitionDiagramElementTypes.BLOCK);
	}
	
	protected Command getCreateCommand(CreateElementRequest req) {
		if(BlockDefinitionDiagramElementTypes.FLOW_PORT == req.getElementType()) {
			return getGEFWrapper(new FlowPortCreateCommand(req));
		}
		if(BlockDefinitionDiagramElementTypes.PORT == req.getElementType()) {
			return getGEFWrapper(new PortCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
