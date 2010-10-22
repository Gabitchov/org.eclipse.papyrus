package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Operation2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class InterfaceOperationCompartment2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InterfaceOperationCompartment2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Interface_3023);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Operation_3007 == req.getElementType()) {
			return getGEFWrapper(new Operation2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
