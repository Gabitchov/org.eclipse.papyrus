package org.eclipse.papyrus.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Actor4CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Comment2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Component2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Constraint2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCase3CreateCommand;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentUsecases3ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentUsecases3ItemSemanticEditPolicy() {
		super(UMLElementTypes.Component_3013);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.UseCase_3009 == req.getElementType()) {
			return getGEFWrapper(new UseCase3CreateCommand(req));
		}
		if(UMLElementTypes.Component_3016 == req.getElementType()) {
			return getGEFWrapper(new Component2CreateCommand(req));
		}
		if(UMLElementTypes.Comment_3015 == req.getElementType()) {
			return getGEFWrapper(new Comment2CreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3017 == req.getElementType()) {
			return getGEFWrapper(new Constraint2CreateCommand(req));
		}
		if(UMLElementTypes.Actor_3018 == req.getElementType()) {
			return getGEFWrapper(new Actor4CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
