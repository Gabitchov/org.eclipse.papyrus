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

import java.util.Arrays;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.CompartmentSemanticEditPolicy;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateActorPartWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateConstraintPropertyWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreatePartWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateReferenceWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateValueWithTypeConfigureCommandFactory;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * Semantic edit policy for {@link Block} structure compartment.
 */
public class StructureCompartmentSemanticEditPolicy extends CompartmentSemanticEditPolicy {

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
			} else if(superTypes.contains(SysMLElementTypes.REFERENCE_PROPERTY)) {
				baseType = SysMLElementTypes.REFERENCE_PROPERTY;
			} else if(superTypes.contains(SysMLElementTypes.ACTOR_PART_PROPERTY)) {
				baseType = SysMLElementTypes.ACTOR_PART_PROPERTY;
			} else if(superTypes.contains(SysMLElementTypes.VALUE_PROPERTY)) {
				baseType = SysMLElementTypes.VALUE_PROPERTY;
			} else if(superTypes.contains(SysMLElementTypes.CONSTRAINT_PROPERTY)) {
				baseType = SysMLElementTypes.CONSTRAINT_PROPERTY;
			}
		}
		
		if(SysMLElementTypes.PART_PROPERTY == baseType) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreatePartWithTypeConfigureCommandFactory());
		}

		if(SysMLElementTypes.REFERENCE_PROPERTY == baseType) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateReferenceWithTypeConfigureCommandFactory());
		}

		if(SysMLElementTypes.ACTOR_PART_PROPERTY == baseType) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateActorPartWithTypeConfigureCommandFactory());
		}

		if(SysMLElementTypes.VALUE_PROPERTY == baseType) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateValueWithTypeConfigureCommandFactory());
		}

		if(SysMLElementTypes.CONSTRAINT_PROPERTY == baseType) {
			req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateConstraintPropertyWithTypeConfigureCommandFactory());
		}

		return super.getCreateCommand(req);
	}
}
