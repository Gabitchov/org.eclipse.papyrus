/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.composite.edit.commands.PortCreateCommand;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.InternalBlockDiagramElementTypes;

public class ClassCompositeItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.composite.edit.policies.ClassCompositeItemSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {
		if(InternalBlockDiagramElementTypes.FLOWPORT_IN == req.getElementType()) {
			return getGEFWrapper(new PortCreateCommand(req));
		}

		return super.getCreateCommand(req);
	}
}
