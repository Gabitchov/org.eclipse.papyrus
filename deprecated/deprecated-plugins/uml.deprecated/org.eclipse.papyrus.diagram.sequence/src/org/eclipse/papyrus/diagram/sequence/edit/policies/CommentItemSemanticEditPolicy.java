package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.papyrus.diagram.common.ids.ReorientLinkIDs;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ElementOwnedCommentCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ElementOwnedCommentReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message3CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message3ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message4CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message4ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message5CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message5ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message6CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message6ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class CommentItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_3001 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		if (UMLElementTypes.Message_3002 == req.getElementType()) {
			return getGEFWrapper(new Message2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_3003 == req.getElementType()) {
			return getGEFWrapper(new Message3CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_3004 == req.getElementType()) {
			return getGEFWrapper(new Message4CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_3005 == req.getElementType()) {
			return getGEFWrapper(new Message5CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_3006 == req.getElementType()) {
			return getGEFWrapper(new Message6CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ElementOwnedComment_3007 == req.getElementType()) {
			return getGEFWrapper(new ElementOwnedCommentCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_3008 == req
				.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {

		Diagram diagram = DiagramEditPartsUtil
				.findDiagramFromEditPart(getHost());
		if (diagram != null) {
			req.getParameters().put(MultiDiagramUtil.BelongToDiagramSource,
					diagram);
		}
		if (UMLElementTypes.Message_3001 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		if (UMLElementTypes.Message_3002 == req.getElementType()) {
			return getGEFWrapper(new Message2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_3003 == req.getElementType()) {
			return getGEFWrapper(new Message3CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_3004 == req.getElementType()) {
			return getGEFWrapper(new Message4CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_3005 == req.getElementType()) {
			return getGEFWrapper(new Message5CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Message_3006 == req.getElementType()) {
			return getGEFWrapper(new Message6CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ElementOwnedComment_3007 == req.getElementType()) {
			return getGEFWrapper(new ElementOwnedCommentCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_3008 == req
				.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {

		// add the view element
		req.setParameter(ReorientLinkIDs.nodeEditPart,
				((IGraphicalEditPart) this.getHost()).getNotationView());
		// add the view link
		List list = DiagramEditPartsUtil.getEObjectViews(req.getRelationship());
		if (list.size() > 0) {
			req.setParameter(ReorientLinkIDs.linkEditPart, list.get(0));
		}

		switch (getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));
		case Message2EditPart.VISUAL_ID:
			return getGEFWrapper(new Message2ReorientCommand(req));
		case Message3EditPart.VISUAL_ID:
			return getGEFWrapper(new Message3ReorientCommand(req));
		case Message4EditPart.VISUAL_ID:
			return getGEFWrapper(new Message4ReorientCommand(req));
		case Message5EditPart.VISUAL_ID:
			return getGEFWrapper(new Message5ReorientCommand(req));
		case Message6EditPart.VISUAL_ID:
			return getGEFWrapper(new Message6ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return getGEFWrapper(new ElementOwnedCommentReorientCommand(req));
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
