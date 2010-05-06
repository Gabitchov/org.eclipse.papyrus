package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.FinalStateNodeCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.PseudoStateNodeCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.StateNodeCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class RegionCompartmentItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

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
		if (UMLElementTypes.Pseudostate_3004 == req.getElementType()) {
			return getGEFWrapper(new PseudoStateNodeCreateCommand(req));
		}
		if (UMLElementTypes.FinalState_3005 == req.getElementType()) {
			return getGEFWrapper(new FinalStateNodeCreateCommand(req));
		}
		if (UMLElementTypes.State_3006 == req.getElementType()) {
			return getGEFWrapper(new StateNodeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
