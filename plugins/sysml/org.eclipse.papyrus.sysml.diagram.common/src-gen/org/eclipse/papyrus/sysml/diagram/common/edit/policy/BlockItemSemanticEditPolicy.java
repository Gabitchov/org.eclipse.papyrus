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
package org.eclipse.papyrus.sysml.diagram.common.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic.CustomClassItemSemanticEditPolicy;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

public class BlockItemSemanticEditPolicy extends CustomClassItemSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {
		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(req.getContainer());
		if(commandService == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if(SysMLElementTypes.FLOW_PORT == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.FLOW_PORT);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(UMLElementTypes.PORT == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.PORT);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		return UnexecutableCommand.INSTANCE;
	}
}
