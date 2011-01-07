package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.ConnectionPointReferenceCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.RegionCreateCommand;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class StateCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.State_6000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Region_3000 == req.getElementType()) {
			return getGEFWrapper(new RegionCreateCommand(req));
		}
		if(UMLElementTypes.ConnectionPointReference_18000 == req.getElementType()) {
			return getGEFWrapper(new ConnectionPointReferenceCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
