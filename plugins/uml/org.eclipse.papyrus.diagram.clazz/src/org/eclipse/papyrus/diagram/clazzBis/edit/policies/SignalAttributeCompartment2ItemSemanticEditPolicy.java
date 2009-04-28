package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class SignalAttributeCompartment2ItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SignalAttributeCompartment2ItemSemanticEditPolicy() {
		super(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2007 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Property2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
