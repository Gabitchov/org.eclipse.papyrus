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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.profile.edit.parts.AppliedStereotypeElementImportEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationBranchRoleEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationMultiplicityTargetLabelEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationRoleSourceLabelEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ClassOperationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ClassPropertyEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintNameEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeNameEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeOperationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypePropertyEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DiagramNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ElementImportAliasEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationNameEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassNameEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.MultiDependencyLabelEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageImportAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileApplicationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileNameEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileNameEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeNameEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeNameEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeOperationCompartmentEditPartCN;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.profile/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(ProfileDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return ProfileDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while(view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if(annotation != null) {
				return (String)annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View)view.eContainer();
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
			if(Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
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
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getProfile().isSuperTypeOf(domainElement.eClass()) && isDiagram((Profile)domainElement)) {
			return ProfileDiagramEditPart.VISUAL_ID;
		}

		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ProfileDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ProfileDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ProfileDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case PackageEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProfile().isSuperTypeOf(domainElement.eClass())

			) {
				return ProfileEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProfile().isSuperTypeOf(domainElement.eClass())

			) {
				return ProfileEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			break;
		case ProfilePackageableElementCompartmentEditPartTN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getStereotype().isSuperTypeOf(domainElement.eClass())

			) {
				return StereotypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProfile().isSuperTypeOf(domainElement.eClass())

			) {
				return ProfileEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return MetaclassEditPartCN.VISUAL_ID;
			}
			break;
		case ProfilePackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getStereotype().isSuperTypeOf(domainElement.eClass())

			) {
				return StereotypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProfile().isSuperTypeOf(domainElement.eClass())

			) {
				return ProfileEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return MetaclassEditPartCN.VISUAL_ID;
			}
			break;
		case StereotypeAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassPropertyEditPart.VISUAL_ID;
			}
			break;
		case StereotypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassPropertyEditPart.VISUAL_ID;
			}
			break;
		case StereotypeOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassOperationEditPart.VISUAL_ID;
			}
			break;
		case StereotypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassOperationEditPart.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProfile().isSuperTypeOf(domainElement.eClass())

			) {
				return ProfileEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProfile().isSuperTypeOf(domainElement.eClass())

			) {
				return ProfileEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypePropertyEditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypePropertyEditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeOperationEditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeOperationEditPart.VISUAL_ID;
			}
			break;
		case ProfileDiagramEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())

			) {
				return DependencyNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())

			) {
				return AssociationNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStereotype().isSuperTypeOf(domainElement.eClass())

			) {
				return StereotypeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return MetaclassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartTN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProfile().isSuperTypeOf(domainElement.eClass())

			) {
				return ProfileEditPartTN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPart.VISUAL_ID;
			}
			if(NotationPackage.eINSTANCE.getDiagram().isSuperTypeOf(domainElement.eClass())

			) {
				return ShortCutDiagramEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ProfileDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ProfileDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ProfileDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case DependencyNodeEditPart.VISUAL_ID:
			if(MultiDependencyLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StereotypeEditPart.VISUAL_ID:
			if(StereotypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StereotypeAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StereotypeOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MetaclassEditPart.VISUAL_ID:
			if(MetaclassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if(CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if(ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPartTN.VISUAL_ID:
			if(ModelNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelPackageableElementCompartmentEditPartTN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProfileEditPartTN.VISUAL_ID:
			if(ProfileNameEditPartTN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfilePackageableElementCompartmentEditPartTN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if(PackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackagePackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEditPart.VISUAL_ID:
			if(EnumerationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeEditPart.VISUAL_ID:
			if(DataTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ShortCutDiagramEditPart.VISUAL_ID:
			if(DiagramNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StereotypeEditPartCN.VISUAL_ID:
			if(StereotypeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StereotypeAttributeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StereotypeOperationCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MetaclassEditPartCN.VISUAL_ID:
			if(MetaclassNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPartCN.VISUAL_ID:
			if(CommentBodyEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPartCN.VISUAL_ID:
			if(ModelNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelPackageableElementCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProfileEditPartCN.VISUAL_ID:
			if(ProfileNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfilePackageableElementCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPartCN.VISUAL_ID:
			if(PackageNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackagePackageableElementCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPartCN.VISUAL_ID:
			if(ConstraintNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEditPartCN.VISUAL_ID:
			if(EnumerationNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeEditPartCN.VISUAL_ID:
			if(DataTypeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeAttributeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeOperationCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfileEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfileEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProfilePackageableElementCompartmentEditPartTN.VISUAL_ID:
			if(StereotypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfileEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MetaclassEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProfilePackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(StereotypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfileEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MetaclassEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StereotypeAttributeCompartmentEditPart.VISUAL_ID:
			if(ClassPropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StereotypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(ClassPropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StereotypeOperationCompartmentEditPart.VISUAL_ID:
			if(ClassOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StereotypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(ClassOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfileEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfileEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			if(EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if(EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(DataTypePropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(DataTypePropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if(DataTypeOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(DataTypeOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProfileDiagramEditPart.VISUAL_ID:
			if(DependencyNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MetaclassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartTN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProfileEditPartTN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ShortCutDiagramEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationEditPart.VISUAL_ID:
			if(AssociationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationRoleSourceLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationMultiplicityTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationBranchEditPart.VISUAL_ID:
			if(AssociationBranchRoleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationEditPart.VISUAL_ID:
			if(GeneralizationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyEditPart.VISUAL_ID:
			if(DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DependencyAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ElementImportEditPart.VISUAL_ID:
			if(ElementImportAliasEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AppliedStereotypeElementImportEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageImportEditPart.VISUAL_ID:
			if(PackageImportAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getExtension().isSuperTypeOf(domainElement.eClass())



		) {
			return ExtensionEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())



		) {
			return AssociationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getProfileApplication().isSuperTypeOf(domainElement.eClass())



		) {
			return ProfileApplicationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())



		) {
			return AssociationBranchEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())



		) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())



		) {
			return DependencyEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())



		) {
			return DependencyBranchEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getElementImport().isSuperTypeOf(domainElement.eClass())



		) {
			return ElementImportEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getPackageImport().isSuperTypeOf(domainElement.eClass())



		) {
			return PackageImportEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Profile element) {
		return true;
	}





	/**
	 * @generated
	 */
	private static ViewInfo diagramViewInfo = null;


	/**
	 * @generated
	 */
	public static ViewInfo getDiagramViewInfo() {
		if(diagramViewInfo == null) {
			diagramViewInfo = getProfile_1000ViewInfo();
		}
		return diagramViewInfo;
	}



	/**
	 * @generated
	 */
	protected static ViewInfo getProfile_1000ViewInfo() {
		ViewInfo root = new BaseViewInfo(1000, ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		ViewInfo labelInfo = null;

		viewInfo = new BaseViewInfo(2014, ViewInfo.Node, "Dependency");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2015, ViewInfo.Node, "Association");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(1026, ViewInfo.Node, "Stereotype");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(1031, ViewInfo.Node, "Class");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(1002, ViewInfo.Node, "Comment");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(1014, ViewInfo.Node, "Constraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2005, ViewInfo.Node, "Model");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(1030, ViewInfo.Node, "Profile");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2007, ViewInfo.Node, "Package");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2006, ViewInfo.Node, "Enumeration");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2010, ViewInfo.Node, "DataType");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2016, ViewInfo.Node, "Diagram");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(1013, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4001, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6002, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6003, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6005, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(1045, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4019, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6024, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4002, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6007, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4008, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6026, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6027, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4018, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(1064, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6020, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6021, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(1065, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6022, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(1022, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4014, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(3019, ViewInfo.Node, "Operation");

		root.addNode(1070, viewInfo);

		root.addNode(1068, viewInfo);


		viewInfo = new BaseViewInfo(1037, ViewInfo.Node, "EnumerationLiteral");

		root.addNode(1063, viewInfo);

		root.addNode(1062, viewInfo);


		viewInfo = new BaseViewInfo(3018, ViewInfo.Node, "Property");

		root.addNode(1067, viewInfo);

		root.addNode(1069, viewInfo);


		viewInfo = new BaseViewInfo(3002, ViewInfo.Node, "Property");

		root.addNode(1052, viewInfo);

		root.addNode(1071, viewInfo);


		viewInfo = new BaseViewInfo(3020, ViewInfo.Node, "Operation");

		root.addNode(1053, viewInfo);

		root.addNode(1019, viewInfo);


		viewInfo = new BaseViewInfo(1023, ViewInfo.Node, "Stereotype");

		root.addNode(1051, viewInfo);

		root.addNode(1042, viewInfo);


		viewInfo = new BaseViewInfo(3028, ViewInfo.Node, "Class");

		root.addNode(1042, viewInfo);

		root.addNode(1051, viewInfo);


		viewInfo = new BaseViewInfo(1007, ViewInfo.Node, "Comment");

		root.addNode(1005, viewInfo);

		root.addNode(11, viewInfo);

		root.addNode(1058, viewInfo);

		root.addNode(1042, viewInfo);

		root.addNode(1051, viewInfo);

		root.addNode(1057, viewInfo);


		viewInfo = new BaseViewInfo(1027, ViewInfo.Node, "Model");

		root.addNode(1057, viewInfo);

		root.addNode(1058, viewInfo);

		root.addNode(1042, viewInfo);

		root.addNode(1051, viewInfo);

		root.addNode(1005, viewInfo);

		root.addNode(11, viewInfo);


		viewInfo = new BaseViewInfo(1024, ViewInfo.Node, "Profile");

		root.addNode(11, viewInfo);

		root.addNode(1005, viewInfo);

		root.addNode(1051, viewInfo);

		root.addNode(1042, viewInfo);

		root.addNode(1057, viewInfo);

		root.addNode(1058, viewInfo);


		viewInfo = new BaseViewInfo(1012, ViewInfo.Node, "Package");

		root.addNode(1005, viewInfo);

		root.addNode(11, viewInfo);

		root.addNode(1012, viewInfo);

		root.addNode(1051, viewInfo);

		root.addNode(1042, viewInfo);

		root.addNode(1058, viewInfo);

		root.addNode(1057, viewInfo);


		viewInfo = new BaseViewInfo(1028, ViewInfo.Node, "Constraint");

		root.addNode(1058, viewInfo);

		root.addNode(1057, viewInfo);

		root.addNode(1051, viewInfo);

		root.addNode(1042, viewInfo);

		root.addNode(11, viewInfo);

		root.addNode(1005, viewInfo);


		viewInfo = new BaseViewInfo(3025, ViewInfo.Node, "Enumeration");

		root.addNode(1058, viewInfo);

		root.addNode(1057, viewInfo);

		root.addNode(1051, viewInfo);

		root.addNode(1042, viewInfo);

		root.addNode(11, viewInfo);

		root.addNode(1005, viewInfo);


		viewInfo = new BaseViewInfo(3027, ViewInfo.Node, "DataType");

		root.addNode(1005, viewInfo);

		root.addNode(11, viewInfo);

		root.addNode(1042, viewInfo);

		root.addNode(1051, viewInfo);

		root.addNode(1057, viewInfo);

		root.addNode(1058, viewInfo);

		return root;
	}

}
