/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
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
import org.eclipse.papyrus.diagram.clazz.edit.commands.UsageCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.UsageReorientCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataType2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Enumeration2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecification2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Model3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Package2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ProfileApplicationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.RedefinableTemplateSignature_3015 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getTemplateableElement_OwnedTemplateSignature());
			}
			return getGEFWrapper(new RedefinableTemplateSignatureCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
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
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (UMLVisualIDRegistry.getVisualID(node)) {
			case RedefinableTemplateSignatureEditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (UMLVisualIDRegistry.getVisualID(cnode)) {
					case InstanceSpecification2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case ComponentEditPartCN.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case SignalEditPartCN.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case InterfaceEditPartCN.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case Model3EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case EnumerationEditPartCN.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case Package2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case ClassEditPartCN.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case PrimitiveTypeEditPartCN.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case DataTypeEditPartCN.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case Comment2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case Constraint2EditPart.VISUAL_ID:
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
			return getGEFWrapper(new ElementImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PackageImport_4010 == req.getElementType()) {
			return getGEFWrapper(new PackageImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PackageMerge_4011 == req.getElementType()) {
			return getGEFWrapper(new PackageMergeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ProfileApplication_4012 == req.getElementType()) {
			return getGEFWrapper(new ProfileApplicationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.CommentAnnotatedElement_4013 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4014 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.TemplateBinding_4015 == req.getElementType()) {
			return getGEFWrapper(new TemplateBindingCreateCommand(req, req.getSource(), req.getTarget()));
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
		if (UMLElementTypes.PackageImport_4010 == req.getElementType()) {
			return getGEFWrapper(new PackageImportCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.PackageMerge_4011 == req.getElementType()) {
			return getGEFWrapper(new PackageMergeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ProfileApplication_4012 == req.getElementType()) {
			return null;
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
		case PackageImportEditPart.VISUAL_ID:
			return getGEFWrapper(new PackageImportReorientCommand(req));
		case PackageMergeEditPart.VISUAL_ID:
			return getGEFWrapper(new PackageMergeReorientCommand(req));
		case ProfileApplicationEditPart.VISUAL_ID:
			return getGEFWrapper(new ProfileApplicationReorientCommand(req));
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
