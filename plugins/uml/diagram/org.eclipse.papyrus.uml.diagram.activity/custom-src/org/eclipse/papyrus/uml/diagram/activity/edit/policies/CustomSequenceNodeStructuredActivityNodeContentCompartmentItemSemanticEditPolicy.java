package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

public class CustomSequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy extends SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy {

	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		// handled by CreateActionLocalConditionEditPolicy, return null
		if(CreateActionLocalConditionEditPolicy.LOCAL_CONDITION_TYPES.contains(req.getElementType())) {
			return null;
		}
		return super.getCreateCommand(req);
	}
}
