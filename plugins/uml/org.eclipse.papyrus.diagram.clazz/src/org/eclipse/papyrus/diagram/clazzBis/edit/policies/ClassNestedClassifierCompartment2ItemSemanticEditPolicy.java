package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ClassNestedClassifierCompartment2ItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassNestedClassifierCompartment2ItemSemanticEditPolicy() {
		super(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2023 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Class5CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
