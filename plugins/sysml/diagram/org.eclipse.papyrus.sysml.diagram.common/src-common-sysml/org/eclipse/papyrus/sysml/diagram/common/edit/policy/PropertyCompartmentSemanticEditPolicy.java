/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateActorPartWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateFlowPortWithFlowSpecificationConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreatePartWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateReferenceWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateValueWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * Semantic edit policy for {@link Block} property compartment.
 */
public class PropertyCompartmentSemanticEditPolicy extends CompartmentSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		if(SysMLElementTypes.PART_PROPERTY == req.getElementType()) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreatePartWithTypeConfigureCommandFactory());
		}
		if(SysMLElementTypes.REFERENCE_PROPERTY == req.getElementType()) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateReferenceWithTypeConfigureCommandFactory());
		}
		if(SysMLElementTypes.ACTOR_PART_PROPERTY == req.getElementType()) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateActorPartWithTypeConfigureCommandFactory());
		}
		if(SysMLElementTypes.VALUE_PROPERTY == req.getElementType()) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateValueWithTypeConfigureCommandFactory());
		}
		if(SysMLElementTypes.FLOW_PORT_NA == req.getElementType()) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateFlowPortWithFlowSpecificationConfigureCommandFactory());
		}
		
		return super.getCreateCommand(req);
	}
}
