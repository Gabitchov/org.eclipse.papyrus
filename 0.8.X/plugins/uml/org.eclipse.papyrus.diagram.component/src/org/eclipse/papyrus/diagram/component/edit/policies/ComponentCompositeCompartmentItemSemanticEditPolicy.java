package org.eclipse.papyrus.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.component.edit.commands.ComponentCreateCommandCN;
import org.eclipse.papyrus.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentCompositeCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentCompositeCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Component_2002);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Component_3070 == req.getElementType()) {
			return getGEFWrapper(new ComponentCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
