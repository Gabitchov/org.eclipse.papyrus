package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ControlFlowCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ControlFlowReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ElementOwnedCommentCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ElementOwnedCommentReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExceptionHandlerCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExceptionHandlerReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InputPin5CreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InputPin6CreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.OutputPin4CreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin5EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin6EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.ids.ReorientLinkIDs;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class CallOperationActionItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		Diagram diagram = DiagramEditPartsUtil.findDiagramFromEditPart(getHost());
		if (diagram != null) {
			req.getParameters().put(MultiDiagramUtil.BelongToDiagramSource, diagram);
		}
		if (UMLElementTypes.OutputPin_2025 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getCallAction_Result());
			}
			return getGEFWrapper(new OutputPin4CreateCommand(req));
		}
		if (UMLElementTypes.InputPin_2026 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getInvocationAction_Argument());
			}
			return getGEFWrapper(new InputPin5CreateCommand(req));
		}
		if (UMLElementTypes.InputPin_2028 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getCallOperationAction_Target());
			}
			return getGEFWrapper(new InputPin6CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (UMLVisualIDRegistry.getVisualID(node)) {
			case OutputPin4EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case InputPin5EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case InputPin6EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			}
		}
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
		if (UMLElementTypes.ControlFlow_3001 == req.getElementType()) {
			return getGEFWrapper(new ControlFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ObjectFlow_3002 == req.getElementType()) {
			return getGEFWrapper(new ObjectFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ExceptionHandler_3004 == req.getElementType()) {
			return getGEFWrapper(new ExceptionHandlerCreateCommand(req, req.getSource(), req.getTarget()));
		}
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
		if (UMLElementTypes.ControlFlow_3001 == req.getElementType()) {
			return getGEFWrapper(new ControlFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ObjectFlow_3002 == req.getElementType()) {
			return getGEFWrapper(new ObjectFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ExceptionHandler_3004 == req.getElementType()) {
			return getGEFWrapper(new ExceptionHandlerCreateCommand(req, req.getSource(), req.getTarget()));
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
	 * Returns command to reorient EClass based link. New link target or source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		// add the view element
		req.setParameter(ReorientLinkIDs.nodeEditPart, ((IGraphicalEditPart) this.getHost()).getNotationView());
		// add the view link
		List list = DiagramEditPartsUtil.getEObjectViews(req.getRelationship());
		if (list.size() > 0) {
			req.setParameter(ReorientLinkIDs.linkEditPart, list.get(0));
		}

		switch (getVisualID(req)) {
		case ControlFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new ControlFlowReorientCommand(req));
		case ObjectFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new ObjectFlowReorientCommand(req));
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getGEFWrapper(new ExceptionHandlerReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
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
