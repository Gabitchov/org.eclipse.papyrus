package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.OperationForClassCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ReceptionCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ClassOperationCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassOperationCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2008);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Reception_3011 == req.getElementType()) {
			return getGEFWrapper(new ReceptionCreateCommand(req));
		}
		if(UMLElementTypes.Operation_3013 == req.getElementType()) {
			return getGEFWrapper(new OperationForClassCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
