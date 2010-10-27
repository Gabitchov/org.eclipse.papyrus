/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.diagram.clazz.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.commands.AbstractionCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.AbstractionReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.AddedLinkCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.AddedLinkReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConnectorDurationObservationCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConnectorDurationObservationReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConnectorTimeObservationCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConnectorTimeObservationReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Dependency2ReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Dependency3CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.DependencyCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.DependencyReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ElementImportCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ElementImportReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PackageImportCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PackageImportReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PackageMergeCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PackageMergeReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ProfileApplicationCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ProfileApplicationReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.RealizationCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.RealizationReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.RedefinableTemplateSignatureCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.TemplateBindingCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.TemplateBindingReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.TemplateSignatureCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.UsageCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.UsageReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClass2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConnectorDurationObservationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConnectorTimeObservationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ProfileApplicationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateSignatureEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Package_3009);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.RedefinableTemplateSignature_3015 == req.getElementType()) {
			return getGEFWrapper(new RedefinableTemplateSignatureCreateCommand(req));
		}
		if(UMLElementTypes.TemplateSignature_3033 == req.getElementType()) {
			return getGEFWrapper(new TemplateSignatureCreateCommand(req));
		}
		return super.getCreateCommand(req);
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
		if(UMLElementTypes.Realization_4005 == req.getElementType()) {
			return getGEFWrapper(new RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Abstraction_4006 == req.getElementType()) {
			return getGEFWrapper(new AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Usage_4007 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Dependency_4008 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Dependency_4018 == req.getElementType()) {
			return getGEFWrapper(new Dependency3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ElementImport_4009 == req.getElementType()) {
			return getGEFWrapper(new ElementImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.PackageImport_4010 == req.getElementType()) {
			return getGEFWrapper(new PackageImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.PackageMerge_4011 == req.getElementType()) {
			return getGEFWrapper(new PackageMergeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ProfileApplication_4012 == req.getElementType()) {
			return getGEFWrapper(new ProfileApplicationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4013 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4014 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return getGEFWrapper(new TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Dependency_4022 == req.getElementType()) {
			return getGEFWrapper(new AddedLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.TimeObservationEvent_4024 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.DurationObservationEvent_4025 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Realization_4005 == req.getElementType()) {
			return getGEFWrapper(new RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Abstraction_4006 == req.getElementType()) {
			return getGEFWrapper(new AbstractionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Usage_4007 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Dependency_4008 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Dependency_4018 == req.getElementType()) {
			return getGEFWrapper(new Dependency3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ElementImport_4009 == req.getElementType()) {
			return getGEFWrapper(new ElementImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.PackageImport_4010 == req.getElementType()) {
			return getGEFWrapper(new PackageImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.PackageMerge_4011 == req.getElementType()) {
			return getGEFWrapper(new PackageMergeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ProfileApplication_4012 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.CommentAnnotatedElement_4013 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4014 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return getGEFWrapper(new TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Dependency_4022 == req.getElementType()) {
			return getGEFWrapper(new AddedLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.TimeObservationEvent_4024 == req.getElementType()) {
			return getGEFWrapper(new ConnectorTimeObservationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.DurationObservationEvent_4025 == req.getElementType()) {
			return getGEFWrapper(new ConnectorDurationObservationCreateCommand(req, req.getSource(), req.getTarget()));
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
		case RealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new RealizationReorientCommand(req));
		case AbstractionEditPart.VISUAL_ID:
			return getGEFWrapper(new AbstractionReorientCommand(req));
		case UsageEditPart.VISUAL_ID:
			return getGEFWrapper(new UsageReorientCommand(req));
		case DependencyEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyReorientCommand(req));
		case DependencyBranchEditPart.VISUAL_ID:
			return getGEFWrapper(new Dependency2ReorientCommand(req));
		case ElementImportEditPart.VISUAL_ID:
			return getGEFWrapper(new ElementImportReorientCommand(req));
		case PackageImportEditPart.VISUAL_ID:
			return getGEFWrapper(new PackageImportReorientCommand(req));
		case PackageMergeEditPart.VISUAL_ID:
			return getGEFWrapper(new PackageMergeReorientCommand(req));
		case ProfileApplicationEditPart.VISUAL_ID:
			return getGEFWrapper(new ProfileApplicationReorientCommand(req));
		case TemplateBindingEditPart.VISUAL_ID:
			return getGEFWrapper(new TemplateBindingReorientCommand(req));
		case AddedLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new AddedLinkReorientCommand(req));
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
		case ConnectorTimeObservationEditPart.VISUAL_ID:
			return getGEFWrapper(new ConnectorTimeObservationReorientCommand(req));
		case ConnectorDurationObservationEditPart.VISUAL_ID:
			return getGEFWrapper(new ConnectorDurationObservationReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
