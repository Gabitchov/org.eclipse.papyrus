package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.activity.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ElementOwnedCommentCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ElementOwnedCommentReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;

/**
 * @generated
 */
public class ControlFlowItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.ElementOwnedComment_3005 == req.getElementType()) {
			return getGEFWrapper(new ElementOwnedCommentCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_3006 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		Diagram diagram = DiagramEditPartsUtil.findDiagramFromEditPart(getHost());
		if (diagram != null) {
			req.getParameters().put(MultiDiagramUtil.BelongToDiagramSource, diagram);
		}
		if (UMLElementTypes.ElementOwnedComment_3005 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.CommentAnnotatedElement_3006 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getGEFWrapper(new ElementOwnedCommentReorientCommand(req));
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
