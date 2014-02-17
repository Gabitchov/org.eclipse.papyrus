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

import java.util.Arrays;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.CompartmentSemanticEditPolicy;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateConstraintPropertyWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreatePartWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * Semantic edit policy for {@link Block} part (Property) compartment.
 */
public class PartCompartmentSemanticEditPolicy extends CompartmentSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		IElementType elementTypeToCreate = req.getElementType();
		IElementType baseType = elementTypeToCreate;
		//if extended type, retrieve the sysml closest element element type
		if(elementTypeToCreate instanceof IExtendedHintedElementType) {
			List<IElementType> superTypes = Arrays.asList(elementTypeToCreate.getAllSuperTypes());
			if(superTypes.contains(SysMLElementTypes.PART_PROPERTY)) {
				baseType = SysMLElementTypes.PART_PROPERTY;
			} else if(superTypes.contains(SysMLElementTypes.CONSTRAINT_PROPERTY)) {
				baseType = SysMLElementTypes.CONSTRAINT_PROPERTY;
			}
		}
		
		
		if(SysMLElementTypes.PART_PROPERTY == baseType) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreatePartWithTypeConfigureCommandFactory());
		}

		if(SysMLElementTypes.CONSTRAINT_PROPERTY == baseType) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateConstraintPropertyWithTypeConfigureCommandFactory());
		}

		return super.getCreateCommand(req);
	}
}
