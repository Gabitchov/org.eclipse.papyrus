/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Operation3CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;


public class BlockOperationCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	public BlockOperationCompartmentItemSemanticEditPolicy() {
		super(BlockDefinitionDiagramElementTypes.BLOCK);
	}

	protected Command getCreateCommand(CreateElementRequest req) {
		if(BlockDefinitionDiagramElementTypes.CLASS_OPERATION_CLN == req.getElementType()) {
			return getGEFWrapper(new Operation3CreateCommand(req));
		}

		return UnexecutableCommand.INSTANCE;
	}
}
