package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ComponentAttributeCompartment2ItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentAttributeCompartment2ItemSemanticEditPolicy() {
		super(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.PropertyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
