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
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.FinalStateCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateChoiceCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateDeepHistoryCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateEntryPointCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateExitPointCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateForkCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateInitialCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateJoinCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateJunctionCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateShallowHistoryCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateTerminateCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.StateCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class RegionCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public RegionCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Region_3000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Pseudostate_8000 == requestElementType) {
			return getGEFWrapper(new PseudostateInitialCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_9000 == requestElementType) {
			return getGEFWrapper(new PseudostateJoinCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_10000 == requestElementType) {
			return getGEFWrapper(new PseudostateForkCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_11000 == requestElementType) {
			return getGEFWrapper(new PseudostateChoiceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_12000 == requestElementType) {
			return getGEFWrapper(new PseudostateJunctionCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_13000 == requestElementType) {
			return getGEFWrapper(new PseudostateShallowHistoryCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_14000 == requestElementType) {
			return getGEFWrapper(new PseudostateDeepHistoryCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_15000 == requestElementType) {
			return getGEFWrapper(new PseudostateTerminateCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.FinalState_5000 == requestElementType) {
			return getGEFWrapper(new FinalStateCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.State_6000 == requestElementType) {
			return getGEFWrapper(new StateCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_16000 == requestElementType) {
			return getGEFWrapper(new PseudostateEntryPointCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Pseudostate_17000 == requestElementType) {
			return getGEFWrapper(new PseudostateExitPointCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Comment_666 == requestElementType) {
			return getGEFWrapper(new CommentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Constraint_668 == requestElementType) {
			return getGEFWrapper(new ConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
