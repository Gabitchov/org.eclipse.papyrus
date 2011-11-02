package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.activity.edit.commands.ConstraintInActivityAsPrecondCreateCommand;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */
public class ActivityCNPreConditionsCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActivityCNPreConditionsCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Activity_3083);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Constraint_3002 == req.getElementType()) {
			return getGEFWrapper(new ConstraintInActivityAsPrecondCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
