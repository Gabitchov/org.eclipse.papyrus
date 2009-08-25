package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.SlotCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class InstanceSpecificationSlotCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InstanceSpecificationSlotCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.InstanceSpecification_3020);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Slot_3030 == req.getElementType()) {
			return getGEFWrapper(new SlotCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
