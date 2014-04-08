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
package org.eclipse.papyrus.uml.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateEntryPointCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateExitPointCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.RegionCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class StateMachineCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public StateMachineCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.StateMachine_2000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Region_3000 == requestElementType) {
			return getGEFWrapper(new RegionCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_16000 == requestElementType) {
			return getGEFWrapper(new PseudostateEntryPointCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_17000 == requestElementType) {
			return getGEFWrapper(new PseudostateExitPointCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
