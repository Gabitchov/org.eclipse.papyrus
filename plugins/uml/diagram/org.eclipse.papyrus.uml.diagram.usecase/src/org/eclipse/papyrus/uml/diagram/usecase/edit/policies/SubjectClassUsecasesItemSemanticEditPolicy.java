package org.eclipse.papyrus.uml.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.usecase.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.commands.ConstraintInComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.usecase.edit.commands.UseCaseInComponentCreateCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class SubjectClassUsecasesItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SubjectClassUsecasesItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2020);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.UseCase_3009 == req.getElementType()) {
			return getGEFWrapper(new UseCaseInComponentCreateCommand(req));
		}
		if (UMLElementTypes.Comment_3015 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		if (UMLElementTypes.Constraint_3017 == req.getElementType()) {
			return getGEFWrapper(new ConstraintInComponentCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
