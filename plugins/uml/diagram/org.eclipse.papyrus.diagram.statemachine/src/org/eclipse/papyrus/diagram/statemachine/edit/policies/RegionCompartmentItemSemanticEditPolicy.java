package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.FinalStateCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateChoiceCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateDeepHistoryCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateEntryPointCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateExitPointCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateForkCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateInitialCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateJoinCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateJunctionCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateShallowHistoryCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudostateTerminateCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.StateCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;

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
		if(UMLElementTypes.Pseudostate_8000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateInitialCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_9000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateJoinCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_10000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateForkCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_11000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateChoiceCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_12000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateJunctionCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_13000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateShallowHistoryCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_14000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateDeepHistoryCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_15000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateTerminateCreateCommand(req));
		}
		if(UMLElementTypes.FinalState_5000 == req.getElementType()) {
			return getGEFWrapper(new FinalStateCreateCommand(req));
		}
		if(UMLElementTypes.State_6000 == req.getElementType()) {
			return getGEFWrapper(new StateCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_16000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateEntryPointCreateCommand(req));
		}
		if(UMLElementTypes.Pseudostate_17000 == req.getElementType()) {
			return getGEFWrapper(new PseudostateExitPointCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
