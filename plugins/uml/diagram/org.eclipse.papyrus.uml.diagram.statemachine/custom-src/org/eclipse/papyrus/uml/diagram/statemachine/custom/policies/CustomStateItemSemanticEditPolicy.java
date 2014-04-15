/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomConnectionPointReferenceCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomPseudostateEntryPointCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomPseudostateExitPointCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomTransitionReorientCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.policies.StateItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;


public class CustomStateItemSemanticEditPolicy extends StateItemSemanticEditPolicy {

	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Pseudostate_16000 == req.getElementType()) {
			return getGEFWrapper(new CustomPseudostateEntryPointCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Pseudostate_17000 == req.getElementType()) {
			return getGEFWrapper(new CustomPseudostateExitPointCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.ConnectionPointReference_18000 == req.getElementType()) {
			return getGEFWrapper(new CustomConnectionPointReferenceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
	
	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case TransitionEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomTransitionReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}
}
