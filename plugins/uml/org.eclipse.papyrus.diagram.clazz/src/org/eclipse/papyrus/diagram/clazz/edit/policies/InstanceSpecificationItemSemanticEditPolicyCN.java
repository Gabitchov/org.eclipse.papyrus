package org.eclipse.papyrus.diagram.clazz.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.commands.AbstractionCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.AbstractionReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Dependency2ReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Dependency3CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.DependencyCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.DependencyReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ElementImportCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ElementImportReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.RealizationCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.RealizationReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.TemplateBindingCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.TemplateBindingReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.UsageCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.UsageReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class InstanceSpecificationItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
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
			case InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (UMLVisualIDRegistry.getVisualID(cnode)) {
					case SlotEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Realization_4005 == req.getElementType()) {
			return getGEFWrapper(new RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Abstraction_4006 == req.getElementType()) {
			return getGEFWrapper(new AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4007 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4008 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4018 == req.getElementType()) {
			return getGEFWrapper(new Dependency3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ElementImport_4009 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.CommentAnnotatedElement_4013 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4014 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Realization_4005 == req.getElementType()) {
			return getGEFWrapper(new RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Abstraction_4006 == req.getElementType()) {
			return getGEFWrapper(new AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4007 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4008 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Dependency_4018 == req.getElementType()) {
			return getGEFWrapper(new Dependency3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ElementImport_4009 == req.getElementType()) {
			return getGEFWrapper(new ElementImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4013 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4014 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return getGEFWrapper(new TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case RealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new RealizationReorientCommand(req));
		case AbstractionEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractionReorientCommand(req));
		case UsageEditPart.VISUAL_ID:
			return getGEFWrapper(new UsageReorientCommand(req));
		case DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyReorientCommand(req));
		case Dependency3EditPart.VISUAL_ID:
			return getGEFWrapper(new Dependency2ReorientCommand(req));
		case ElementImportEditPart.VISUAL_ID:
			return getGEFWrapper(new ElementImportReorientCommand(req));
		case TemplateBindingEditPart.VISUAL_ID:
			return getGEFWrapper(new TemplateBindingReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
