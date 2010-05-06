package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class TransitionEditPartItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TransitionEditPartItemSemanticEditPolicy() {
		super(UMLElementTypes.Transition_5000);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
