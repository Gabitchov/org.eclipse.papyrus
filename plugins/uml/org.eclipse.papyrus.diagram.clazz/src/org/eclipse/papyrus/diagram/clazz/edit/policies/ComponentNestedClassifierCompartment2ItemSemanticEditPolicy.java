package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Class2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentNestedClassifierCompartment2ItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentNestedClassifierCompartment2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Component_3021);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Class_3004 == req.getElementType()) {
			return getGEFWrapper(new Class2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
