package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.DoActivityStateBehaviorStateCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.EntryStateBehaviorCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.ExitStateBehaviorCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class StateBehaviorCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateBehaviorCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.State_6000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Behavior_690 == req.getElementType()) {
			return getGEFWrapper(new EntryStateBehaviorCreateCommand(req));
		}
		if(UMLElementTypes.Behavior_691 == req.getElementType()) {
			return getGEFWrapper(new DoActivityStateBehaviorStateCreateCommand(req));
		}
		if(UMLElementTypes.Behavior_692 == req.getElementType()) {
			return getGEFWrapper(new ExitStateBehaviorCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
