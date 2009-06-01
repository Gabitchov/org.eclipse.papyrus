/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBody2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Component2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecases2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecases3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecasesEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Constraint3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendsLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Package2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Package3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseExtensionpointsEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsEditPart;
import org.eclipse.papyrus.diagram.usecase.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.usecase.expressions.UMLOCLFactory;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be created for the corresponding Diagram, Node, ChildNode or Link represented by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.usecase/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Association_4011_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Dependency_4013_Constraint;

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case UseCasePointsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getExtensionPoint().isSuperTypeOf(domainElement.eClass())) {
				return ExtensionPointEditPart.VISUAL_ID;
			}
			break;
		case UseCaseExtensionpointsEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getExtensionPoint().isSuperTypeOf(domainElement.eClass())) {
				return ExtensionPoint2EditPart.VISUAL_ID;
			}
			break;
		case ComponentUsecasesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())) {
				return UseCase3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case UseCasePoints2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getExtensionPoint().isSuperTypeOf(domainElement.eClass())) {
				return ExtensionPointEditPart.VISUAL_ID;
			}
			break;
		case ComponentUsecases2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())) {
				return UseCase3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())) {
				return Actor3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())) {
				return UseCase4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			break;
		case UseCasePoints3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getExtensionPoint().isSuperTypeOf(domainElement.eClass())) {
				return ExtensionPointEditPart.VISUAL_ID;
			}
			break;
		case ComponentUsecases3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())) {
				return UseCase3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())) {
				return Actor3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())) {
				return UseCase4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())) {
				return ActorEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())) {
				return Actor2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())) {
				return UseCaseEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())) {
				return UseCase2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ActorEditPart.VISUAL_ID:
			if (ActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Actor2EditPart.VISUAL_ID:
			if (ActorName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCaseEditPart.VISUAL_ID:
			if (UseCaseNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UseCasePointsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCase2EditPart.VISUAL_ID:
			if (UseCaseName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UseCaseExtensionpointsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentEditPart.VISUAL_ID:
			if (ComponentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentUsecasesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Package2EditPart.VISUAL_ID:
			if (PackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackagePackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if (ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if (CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCase3EditPart.VISUAL_ID:
			if (UseCaseName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UseCasePoints2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Component2EditPart.VISUAL_ID:
			if (ComponentName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentUsecases2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Comment2EditPart.VISUAL_ID:
			if (CommentBody2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Constraint2EditPart.VISUAL_ID:
			if (ConstraintName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Constraint3EditPart.VISUAL_ID:
			if (ConstraintName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Actor3EditPart.VISUAL_ID:
			if (ActorName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCase4EditPart.VISUAL_ID:
			if (UseCaseName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UseCasePoints3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Component3EditPart.VISUAL_ID:
			if (ComponentName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentUsecases3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Package3EditPart.VISUAL_ID:
			if (PackageName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackagePackageableElementCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCasePointsEditPart.VISUAL_ID:
			if (ExtensionPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCaseExtensionpointsEditPart.VISUAL_ID:
			if (ExtensionPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentUsecasesEditPart.VISUAL_ID:
			if (UseCase3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCasePoints2EditPart.VISUAL_ID:
			if (ExtensionPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentUsecases2EditPart.VISUAL_ID:
			if (UseCase3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if (Constraint3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Actor3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UseCase4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCasePoints3EditPart.VISUAL_ID:
			if (ExtensionPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentUsecases3EditPart.VISUAL_ID:
			if (UseCase3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			if (Constraint3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Actor3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UseCase4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Actor2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UseCaseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (UseCase2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IncludeEditPart.VISUAL_ID:
			if (IncludeLink_fixedEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExtendEditPart.VISUAL_ID:
			if (ExtendsLink_fixedEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationEditPart.VISUAL_ID:
			if (AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyEditPart.VISUAL_ID:
			if (DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getInclude().isSuperTypeOf(domainElement.eClass())) {
			return IncludeEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getExtend().isSuperTypeOf(domainElement.eClass())) {
			return ExtendEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass()) && isAssociation_4011((Association) domainElement)) {
			return AssociationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass()) && isDependency_4013((Dependency) domainElement)) {
			return DependencyEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isAssociation_4011(Association domainElement) {
		if (Association_4011_Constraint == null) { // lazy initialization
			Association_4011_Constraint = UMLOCLFactory.getExpression("not self.oclIsTypeOf(uml::AssociationClass)", UMLPackage.eINSTANCE.getAssociation()); //$NON-NLS-1$
		}
		Object result = Association_4011_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDependency_4013(Dependency domainElement) {
		if (Dependency_4013_Constraint == null) { // lazy initialization
			Dependency_4013_Constraint = UMLOCLFactory
					.getExpression(
							"(self.oclIsTypeOf(uml::Dependency) or self.oclIsTypeOf(uml::Abstraction) or self.oclIsTypeOf(uml::Substitution) or self.oclIsTypeOf(uml::Usage)) and self.supplier->size() = 1 and self.client->size() = 1 and self.supplier->forAll(e|not e.oclIsKindOf(uml::Interface))", UMLPackage.eINSTANCE.getDependency()); //$NON-NLS-1$
		}
		Object result = Dependency_4013_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	// test

	/**
	 * @generated
	 */
	private static ViewInfo diagramViewInfo = null;

	/**
	 * @generated
	 */
	public static ViewInfo getDiagramViewInfo() {
		if (diagramViewInfo == null) {
			diagramViewInfo = getPackage_1000ViewInfo();
		}
		return diagramViewInfo;
	}

	/**
	 * @generated
	 */
	protected static ViewInfo getPackage_1000ViewInfo() {
		ViewInfo root = new BaseViewInfo(1000, ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		ViewInfo labelInfo = null;

		viewInfo = new BaseViewInfo(2011, ViewInfo.Node, "Actor");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2012, ViewInfo.Node, "Actor");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2013, ViewInfo.Node, "UseCase");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2014, ViewInfo.Node, "UseCase");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2015, ViewInfo.Node, "Component");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2016, ViewInfo.Node, "Package");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2017, ViewInfo.Node, "Constraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2018, ViewInfo.Node, "Comment");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4008, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6006, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4009, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6007, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4010, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4011, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6008, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4012, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4013, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6010, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4014, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(3007, ViewInfo.Node, "ExtensionPoint");

		root.addNode(7009, viewInfo);

		root.addNode(7012, viewInfo);

		root.addNode(7014, viewInfo);

		viewInfo = new BaseViewInfo(3008, ViewInfo.Node, "ExtensionPoint");

		root.addNode(7010, viewInfo);

		viewInfo = new BaseViewInfo(3009, ViewInfo.Node, "UseCase");

		root.addNode(7011, viewInfo);

		root.addNode(7017, viewInfo);

		root.addNode(7015, viewInfo);

		viewInfo = new BaseViewInfo(3016, ViewInfo.Node, "Component");

		root.addNode(7017, viewInfo);

		root.addNode(7011, viewInfo);

		root.addNode(7015, viewInfo);

		viewInfo = new BaseViewInfo(3015, ViewInfo.Node, "Comment");

		root.addNode(7017, viewInfo);

		root.addNode(7011, viewInfo);

		root.addNode(7015, viewInfo);

		root.addNode(7016, viewInfo);

		root.addNode(7013, viewInfo);

		viewInfo = new BaseViewInfo(3017, ViewInfo.Node, "Constraint");

		root.addNode(7017, viewInfo);

		root.addNode(7011, viewInfo);

		root.addNode(7015, viewInfo);

		viewInfo = new BaseViewInfo(3010, ViewInfo.Node, "Constraint");

		root.addNode(7013, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3011, ViewInfo.Node, "Actor");

		root.addNode(7013, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3012, ViewInfo.Node, "UseCase");

		root.addNode(7013, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3013, ViewInfo.Node, "Component");

		root.addNode(7013, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3014, ViewInfo.Node, "Package");

		root.addNode(7016, viewInfo);

		root.addNode(7013, viewInfo);

		return root;
	}
}
