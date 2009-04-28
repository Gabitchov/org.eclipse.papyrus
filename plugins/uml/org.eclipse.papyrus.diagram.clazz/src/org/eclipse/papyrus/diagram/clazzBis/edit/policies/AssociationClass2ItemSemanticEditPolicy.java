package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class AssociationClass2ItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public AssociationClass2ItemSemanticEditPolicy() {
		super(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
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
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationClass2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.InterfaceRealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.SubstitutionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ElementImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.PackageImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017 == req.getElementType()) {
			return null;
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018 == req.getElementType()) {
			return null;
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationClass2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006 == req.getElementType()) {
			return null;
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.SubstitutionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ElementImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014 == req.getElementType()) {
			return null;
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationClassReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Association2ReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.GeneralizationReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.InterfaceRealizationReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.SubstitutionReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.RealizationReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AbstractionReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.UsageReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.DependencyReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Dependency2ReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ElementImportReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.PackageImportReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.TemplateBindingReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.CommentAnnotatedElementReorientCommand(req));
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
