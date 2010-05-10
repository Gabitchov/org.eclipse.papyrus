package org.eclipse.papyrus.diagram.communication.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.communication.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.diagram.communication.edit.commands.DurationObservationCreateCommandCN;
import org.eclipse.papyrus.diagram.communication.edit.commands.LifelineCreateCommandCN;
import org.eclipse.papyrus.diagram.communication.edit.commands.TimeObservationCreateCommandCN;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;

/**
 * @generated
 */
public class InteractionCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InteractionCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Interaction_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Lifeline_3001 == req.getElementType()) {
			return getGEFWrapper(new LifelineCreateCommandCN(req));
		}
		if(UMLElementTypes.Comment_3097 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		if(UMLElementTypes.Constraint_3029 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommandCN(req));
		}
		if(UMLElementTypes.TimeObservation_3004 == req.getElementType()) {
			return getGEFWrapper(new TimeObservationCreateCommandCN(req));
		}
		if(UMLElementTypes.DurationObservation_3005 == req.getElementType()) {
			return getGEFWrapper(new DurationObservationCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
