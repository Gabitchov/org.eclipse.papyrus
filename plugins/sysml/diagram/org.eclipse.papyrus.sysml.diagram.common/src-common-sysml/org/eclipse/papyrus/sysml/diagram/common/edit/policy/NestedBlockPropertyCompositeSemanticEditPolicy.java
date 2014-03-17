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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateFlowPortWithFlowSpecificationConfigureCommandFactory;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * Semantic edit policy for Property owned by a Block (Part or Reference especially).
 */
@Deprecated
public class NestedBlockPropertyCompositeSemanticEditPolicy extends DefaultSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		// Port - FlowPort creation is allowed if the semantic element is 
		// a Property typed by a Block, the new Port - FlowPort is created on this Block.
		EObject eObject = req.getContainer();
		if ((eObject != null) && (eObject instanceof Property)) {
			Type type = ((Property) eObject).getType();
			if ((type != null) && (((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(type))) {
				

				IElementType elementTypeToCreate = req.getElementType();
				IElementType baseType = elementTypeToCreate;
				//if extended type, retrieve the sysml closest element element type
				if(elementTypeToCreate instanceof IExtendedHintedElementType) {
					List<IElementType> superTypes = Arrays.asList(elementTypeToCreate.getAllSuperTypes());
					if(superTypes.contains(SysMLElementTypes.FLOW_PORT)) {
						baseType = SysMLElementTypes.FLOW_PORT;
					} else if(superTypes.contains(SysMLElementTypes.FLOW_PORT_IN)) {
						baseType = SysMLElementTypes.FLOW_PORT_IN;
					} else if(superTypes.contains(SysMLElementTypes.FLOW_PORT_OUT)) {
						baseType = SysMLElementTypes.FLOW_PORT_OUT;
					} else if(superTypes.contains(SysMLElementTypes.FLOW_PORT_IN_OUT)) {
						baseType = SysMLElementTypes.FLOW_PORT_IN_OUT;
					} else if(superTypes.contains(SysMLElementTypes.FLOW_PORT_NA)) {
						baseType = SysMLElementTypes.FLOW_PORT_NA;
					}  else if(superTypes.contains(UMLElementTypes.PORT )) {
						baseType = UMLElementTypes.PORT ;
					} 
				}
				
				if((SysMLElementTypes.FLOW_PORT == baseType)
					|| (SysMLElementTypes.FLOW_PORT_IN == baseType)
					|| (SysMLElementTypes.FLOW_PORT_OUT == baseType)
					|| (SysMLElementTypes.FLOW_PORT_IN_OUT == baseType)
					|| (SysMLElementTypes.FLOW_PORT_NA == baseType)
					|| (UMLElementTypes.PORT == baseType)) {
					
					req.setContainer(type);
				}
				
				if(SysMLElementTypes.FLOW_PORT_NA == baseType) {
					req.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateFlowPortWithFlowSpecificationConfigureCommandFactory());
				}
			}
		}
		
		return super.getCreateCommand(req);
	}
}
