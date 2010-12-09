/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ModelItemSemanticEditPolicy;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * This semantic edit policy allows the creation of Block inside Package compartment.
 * The default behavior is inherited from Class Diagram for elements other than Block
 * (or Block Definition Diagram specific elements)
 * 
 * Warning :
 * This edit policy is not perfectly consistent with GMF Runtime as it tends to break
 * the extensible type framework. In other word the creation command is supposed to be provided
 * by the IMetamodelType helper (possibly completed by HelperAdvices in case of a SpecializationType),
 * but should not be provided by the container...
 */
public class BlockDefinitionDiagramItemSemanticEditPolicy extends ModelItemSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {

		if (req.getElementType() == SysMLElementTypes.BLOCK) {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(req.getContainer());
			if(provider == null) {
				return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
			}

			// Retrieve create command from the Element Edit service
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.BLOCK);
			ICommand createGMFCommand = provider.getEditCommand(createRequest);

			return getGEFWrapper(createGMFCommand);
		}

		return super.getCreateCommand(req);
	}
}
