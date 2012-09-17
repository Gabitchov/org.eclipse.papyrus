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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.CompartmentSemanticEditPolicy;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateFlowPortWithFlowSpecificationConfigureCommandFactory;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * Semantic edit policy for {@link Block} structure compartment.
 */
public class BlockCompositeSemanticEditPolicy extends CompartmentSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		if(SysMLElementTypes.FLOW_PORT_NA == req.getElementType()) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateFlowPortWithFlowSpecificationConfigureCommandFactory());
		}
		
		return super.getCreateCommand(req);
	}
}
