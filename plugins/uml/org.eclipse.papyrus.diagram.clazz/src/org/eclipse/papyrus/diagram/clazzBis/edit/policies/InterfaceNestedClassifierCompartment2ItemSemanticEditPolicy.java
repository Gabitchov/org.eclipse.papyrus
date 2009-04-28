package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class InterfaceNestedClassifierCompartment2ItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InterfaceNestedClassifierCompartment2ItemSemanticEditPolicy() {
		super(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2010 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Class3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
