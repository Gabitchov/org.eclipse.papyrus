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

import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.service.types.comand.SetNestedPathCommand;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;

/**
 * <pre>
 * This HelperAdvice completes {@link Connector} edit commands with SysML specific actions:
 * - Re-orient with structure encapsulation respect.
 * </pre>
 */
public class ConnectorEditHelperAdvice extends AbstractEditHelperAdvice {
	
	private ConnectorUtils utils = new ConnectorUtils();

	@Override
	protected ICommand getAfterReorientRelationshipCommand(ReorientRelationshipRequest request) {
		ICommand defaultCommand = super.getAfterReorientRelationshipCommand(request);

		int reorientDirection = request.getDirection();
		Edge reorientedEdgeView = RequestParameterUtils.getReconnectedEdge(request);
		View newEndView = RequestParameterUtils.getReconnectedEndView(request);
		View oppositeEndView = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? reorientedEdgeView.getTarget() : reorientedEdgeView.getSource();
		
		// Restrict this advice action to the end of Connector creation gesture (before clicking on target)
		// in order to add SysML specific constraint
		Connector connector = (Connector) request.getRelationship();
			
		// Restrict action to SysML Connector (meaning owned by Block)
		if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(connector.eContainer())) {

			// If the source or target view is enclosed in a structure encapsulated view, forbid creation.
			if(utils.isCrossingEncapsulation(newEndView, oppositeEndView) 
				|| utils.isCrossingEncapsulation(oppositeEndView, newEndView)) {
				return UnexecutableCommand.INSTANCE;
			}
			
			int tmpNestedPathDirection = -1;
			List<Property> tmpNestedPath = Collections.emptyList();
			
			// Check if new end view is nested
			tmpNestedPathDirection = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? SetNestedPathCommand.NESTED_SOURCE : SetNestedPathCommand.NESTED_TARGET;
			tmpNestedPath = utils.getNestedPropertyPath(newEndView, oppositeEndView);
			defaultCommand = CompositeCommand.compose(defaultCommand, new SetNestedPathCommand("Set connector nested source path", request.getRelationship(), request, tmpNestedPath, tmpNestedPathDirection)); //$NON-NLS-0$

			// Check if opposite end view is nested
			tmpNestedPathDirection = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? SetNestedPathCommand.NESTED_TARGET : SetNestedPathCommand.NESTED_SOURCE;
			tmpNestedPath = utils.getNestedPropertyPath(oppositeEndView, newEndView);
			defaultCommand = CompositeCommand.compose(defaultCommand, new SetNestedPathCommand("Set connector nested target path", request.getRelationship(), request, tmpNestedPath, tmpNestedPathDirection)); //$NON-NLS-0$
		}
		
		return defaultCommand;
	}
}
