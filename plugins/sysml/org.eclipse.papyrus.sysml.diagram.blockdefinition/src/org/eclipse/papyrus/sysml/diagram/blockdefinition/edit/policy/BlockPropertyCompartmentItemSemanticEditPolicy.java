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
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Property4CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;


public class BlockPropertyCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	public BlockPropertyCompartmentItemSemanticEditPolicy() {
		super(BlockDefinitionDiagramElementTypes.BLOCK);
	}

	protected Command getCreateCommand(CreateElementRequest req) {
		if(BlockDefinitionDiagramElementTypes.CLASS_PROPERTY_CLN == req.getElementType()
			|| BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_CLN == req.getElementType()
			|| BlockDefinitionDiagramElementTypes.BLOCK_PART_CLN == req.getElementType()
			|| BlockDefinitionDiagramElementTypes.BLOCK_REFERENCE_CLN == req.getElementType()
//			|| BlockDefinitionDiagramElementTypes.BLOCK_VALUETYPE_CLN == req.getElementType()
		) {
			return getGEFWrapper(new Property4CreateCommand(req));
		}

		return UnexecutableCommand.INSTANCE;
	}
}
