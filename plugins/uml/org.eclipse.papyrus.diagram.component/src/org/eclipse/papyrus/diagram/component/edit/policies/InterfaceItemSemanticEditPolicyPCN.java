package org.eclipse.papyrus.diagram.component.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.component.edit.commands.AbstractionCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.ComponentRealizationCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.DependencyCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.GeneralizationCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.InterfaceRealizationCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.ManifestationCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.SubstitutionCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.UsageCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentRealizationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.component.providers.UMLElementTypes;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

/**
 * @generated
 */
public class InterfaceItemSemanticEditPolicyPCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InterfaceItemSemanticEditPolicyPCN() {
		super(UMLElementTypes.Interface_3072);
	}




	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);

			if(deleteCommand != null) {
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
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
		if(UMLElementTypes.Usage_4001 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.InterfaceRealization_4006 == req.getElementType()) {
			return getGEFWrapper(new InterfaceRealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Generalization_4003 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Substitution_4012 == req.getElementType()) {
			return getGEFWrapper(new SubstitutionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Manifestation_4014 == req.getElementType()) {
			return getGEFWrapper(new ManifestationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ComponentRealization_4007 == req.getElementType()) {
			return getGEFWrapper(new ComponentRealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Abstraction_4013 == req.getElementType()) {
			return getGEFWrapper(new AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4015 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4009 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.Dependency_4010 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Usage_4001 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.InterfaceRealization_4006 == req.getElementType()) {
			return getGEFWrapper(new InterfaceRealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Generalization_4003 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Substitution_4012 == req.getElementType()) {
			return getGEFWrapper(new SubstitutionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Manifestation_4014 == req.getElementType()) {
			return getGEFWrapper(new ManifestationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ComponentRealization_4007 == req.getElementType()) {
			return getGEFWrapper(new ComponentRealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Abstraction_4013 == req.getElementType()) {
			return getGEFWrapper(new AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4015 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4009 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Dependency_4010 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
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
		switch(getVisualID(req)) {
		case UsageEditPart.VISUAL_ID:
		case InterfaceRealizationEditPart.VISUAL_ID:
		case GeneralizationEditPart.VISUAL_ID:
		case SubstitutionEditPart.VISUAL_ID:
		case ManifestationEditPart.VISUAL_ID:
		case ComponentRealizationEditPart.VISUAL_ID:
		case AbstractionEditPart.VISUAL_ID:
		case DependencyEditPart.VISUAL_ID:
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(req.getRelationship());
			if(provider == null) {
				return UnexecutableCommand.INSTANCE;
			}
			// Retrieve re-orient command from the Element Edit service
			ICommand reorientCommand = provider.getEditCommand(req);
			if(reorientCommand == null) {
				return UnexecutableCommand.INSTANCE;
			}
			return getGEFWrapper(reorientCommand.reduce());
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
		switch(getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
