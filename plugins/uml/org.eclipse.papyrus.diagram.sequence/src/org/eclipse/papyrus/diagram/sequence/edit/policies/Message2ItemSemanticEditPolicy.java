package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * @generated
 */
public class Message2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public Message2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Message_4004);
	}

	/**
	 * the added code to delete the messageoccurencespecification when the message is deleted
	 * 
	 * @generated-not
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);

		Message message = null;

		if (getHost().getModel() instanceof Edge) {
			EObject obj = ((Edge) getHost().getModel()).getElement();

			if (obj instanceof Message) {
				message = (Message) obj;

				MessageEnd messageEnd = message.getReceiveEvent(); // get the
				// messageoccurencespecification
				// start
				MessageEnd messageStart = message.getSendEvent(); // get the
				// messageoccurencespecification
				// end

				if (messageEnd != null && messageStart != null) {
					DestroyElementRequest r = new DestroyElementRequest(messageEnd, false);
					DestroyElementRequest r1 = new DestroyElementRequest(messageStart, false);
					cmd.add(new DestroyElementCommand(r));
					cmd.add(new DestroyElementCommand(r1));
					cmd.add(new DestroyElementCommand(req));
				}
			}

		}
		return getGEFWrapper(cmd);

	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_4004 == req.getElementType()) {
			return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_4004 == req.getElementType()) {
			return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain
	 * model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));
		case Message2EditPart.VISUAL_ID:
			return getGEFWrapper(new Message2ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
