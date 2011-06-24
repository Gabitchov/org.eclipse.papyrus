package org.eclipse.papyrus.diagram.statemachine.custom.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CustomConnectionPointReferenceCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CustomPseudostateEntryPointCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CustomPseudostateExitPointCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.StateItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;


public class CustomStateItemSemanticEditPolicy extends StateItemSemanticEditPolicy {
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Pseudostate_16000 == req.getElementType()) {
			return getGEFWrapper(new CustomPseudostateEntryPointCreateCommand(req));
		}
		if (UMLElementTypes.Pseudostate_17000 == req.getElementType()) {
			return getGEFWrapper(new CustomPseudostateExitPointCreateCommand(req));
		}
		if (UMLElementTypes.ConnectionPointReference_18000 == req.getElementType()) {
			return getGEFWrapper(new CustomConnectionPointReferenceCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
