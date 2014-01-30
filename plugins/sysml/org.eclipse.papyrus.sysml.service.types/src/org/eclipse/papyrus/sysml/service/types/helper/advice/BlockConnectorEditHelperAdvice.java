/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.service.types.command.SetNestedPathCommand;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;

/**
 * <pre>
 * This HelperAdvice completes {@link Block} edit commands with SysML 
 * specific {@link Connector} related actions:
 * - Block::isEncapsulated management
 * - NestedPropertyEnd management
 * </pre>
 */
public class BlockConnectorEditHelperAdvice extends AbstractEditHelperAdvice {

	private ConnectorUtils utils = new ConnectorUtils();
	
	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		
		EObject source = request.getSource();
		EObject target = request.getTarget();
		View sourceView = RequestParameterUtils.getSourceView(request);
		View targetView = RequestParameterUtils.getTargetView(request);

		// Restrict this advice action to the end of Connector creation gesture (before clicking on target)
		// in order to add SysML specific constraint 
		if((request.getElementType() == UMLElementTypes.CONNECTOR) 
			&& (request.getSource() != null) && (request.getTarget() != null) && (request.getContainer() != null)) {
		
			// Restrict action to SysML Connector (meaning owned by Block)
			if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(request.getContainer())) {

				// If the source or target view is enclosed in a structure encapsulated view, forbid creation.			
				if(utils.isCrossingEncapsulation(sourceView, targetView) 
					|| utils.isCrossingEncapsulation(targetView, sourceView)) {
					return UnexecutableCommand.INSTANCE;
				}
				if (ConnectorUtils.canCreate(source, target, sourceView, targetView)) {
					request.setParameter( org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants.UML_STRICT, false);
				}
			}
		}
		
		return super.getBeforeCreateRelationshipCommand(request);
	}
	
	@Override
	protected ICommand getAfterCreateRelationshipCommand(CreateRelationshipRequest request) {
		
		ICommand defaultCommand = super.getAfterCreateRelationshipCommand(request);
		
		View sourceView = RequestParameterUtils.getSourceView(request);
		View targetView = RequestParameterUtils.getTargetView(request);

		// Restrict this advice action to the end of Connector creation gesture (before clicking on target)
		// in order to add SysML specific constraint 
		if((request.getElementType() == UMLElementTypes.CONNECTOR) 
			&& (request.getSource() != null) && (request.getTarget() != null) && (request.getContainer() != null)) {
		
			// Restrict action to SysML Connector (meaning owned by Block)
			if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(request.getContainer())) {
				
				// Check if source view is nested
				if(utils.isNestedConnectableElement(sourceView, targetView)){
					List<Property> nestedPath = utils.getNestedPropertyPath(sourceView, targetView);
					defaultCommand = CompositeCommand.compose(defaultCommand, new SetNestedPathCommand("Set connector nested source path", request.getNewElement(), request, nestedPath, SetNestedPathCommand.NESTED_SOURCE)); //$NON-NLS-0$
				}

				// Check if target view is nested
				if(utils.isNestedConnectableElement(targetView, sourceView)){
					List<Property> nestedPath = utils.getNestedPropertyPath(targetView, sourceView);
					defaultCommand = CompositeCommand.compose(defaultCommand, new SetNestedPathCommand("Set connector nested source path", request.getNewElement(), request, nestedPath, SetNestedPathCommand.NESTED_TARGET)); //$NON-NLS-0$
				}
			}
		}
		
		return defaultCommand;
	}
}
