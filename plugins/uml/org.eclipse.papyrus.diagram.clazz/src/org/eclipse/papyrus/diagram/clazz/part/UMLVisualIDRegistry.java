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
package org.eclipse.papyrus.diagram.clazz.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.*;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.clazz/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!ModelEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case AssociationClassEditPart.VISUAL_ID:
			if (AppliedStereotypeAssociationClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationEditPart.VISUAL_ID:
			if (AppliedStereotypeInstanceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentEditPart.VISUAL_ID:
			if (AppliedStereotypeComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalEditPart.VISUAL_ID:
			if (AppliedStereotypeSignalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SignalName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SignalQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SignalAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if (AppliedStereotypeInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Model2EditPart.VISUAL_ID:
			if (AppliedStereotypeModelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelPackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEditPart.VISUAL_ID:
			if (AppliedStereotypeEnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (AppliedStereotypePackageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackagePackageableElementCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if (AppliedStereotypeClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeEditPart.VISUAL_ID:
			if (PrimitiveTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeEditPart.VISUAL_ID:
			if (AppliedStereotypeDataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeQualifiedNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
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
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			if (RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecification2EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodeInstanceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Component2EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodeComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Signal2EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodeSignalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SignalName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SignalQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SignalAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Interface2EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodeInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Model3EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodeModelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelPackageableElementCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Enumeration2EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodeEnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Package2EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodePackageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackagePackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Class4EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodeClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			if (PrimitiveTypeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataType2EditPart.VISUAL_ID:
			if (AppliedStereotypeChildNodeDataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeQualifiedName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
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
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			if (SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			if (OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if (TemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			if (Property2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			if (Property3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			if (Operation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			if (InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Signal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Model3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
			if (SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentAttributeCompartment2EditPart.VISUAL_ID:
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentOperationCompartment2EditPart.VISUAL_ID:
			if (OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalAttributeCompartment2EditPart.VISUAL_ID:
			if (Property2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			if (Property3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceOperationCompartment2EditPart.VISUAL_ID:
			if (Operation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
			if (InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Signal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Model3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			if (EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if (InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Signal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Model3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			if (Property4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			if (ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Operation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (Class5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			if (Property5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartment2EditPart.VISUAL_ID:
			if (Operation4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if (EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			if (InstanceSpecification2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Component2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Signal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Model3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Package2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributeCompartment2EditPart.VISUAL_ID:
			if (Property4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationCompartment2EditPart.VISUAL_ID:
			if (ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Operation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (Class5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if (Property5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if (Operation4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPart.VISUAL_ID:
			if (Dependency2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Association2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InstanceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SignalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Model2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationEditPart.VISUAL_ID:
			if (AppliedStereotypeAssociationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AssociationName6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationEditPart.VISUAL_ID:
			if (AppliedStereotyperGeneralizationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceRealizationEditPart.VISUAL_ID:
			if (AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceRealizationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubstitutionEditPart.VISUAL_ID:
			if (AppliedStereotypeSubstitutionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubstitutionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RealizationEditPart.VISUAL_ID:
			if (AppliedStereotypeRealizationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RealizationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractionEditPart.VISUAL_ID:
			if (AbstractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AppliedStereotypeAbstractionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UsageEditPart.VISUAL_ID:
			if (UsageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AppliedStereotypeUsageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyEditPart.VISUAL_ID:
			if (DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AppliedStereotypeDependencyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Dependency3EditPart.VISUAL_ID:
			if (DependencyName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AppliedStereotypeDependency3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ElementImportEditPart.VISUAL_ID:
			if (ElementImportAliasEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AppliedStereotypeElementImportEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageImportEditPart.VISUAL_ID:
			if (AppliedStereotypePackageImportEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateBindingEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package) domainElement)) {
			return ModelEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
			return AssociationClass2EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return AssociationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return Association3EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getInterfaceRealization().isSuperTypeOf(domainElement.eClass())) {
			return InterfaceRealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getSubstitution().isSuperTypeOf(domainElement.eClass())) {
			return SubstitutionEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getRealization().isSuperTypeOf(domainElement.eClass())) {
			return RealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAbstraction().isSuperTypeOf(domainElement.eClass())) {
			return AbstractionEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(domainElement.eClass())) {
			return UsageEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return DependencyEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return Dependency3EditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getElementImport().isSuperTypeOf(domainElement.eClass())) {
			return ElementImportEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getPackageImport().isSuperTypeOf(domainElement.eClass())) {
			return PackageImportEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getPackageMerge().isSuperTypeOf(domainElement.eClass())) {
			return PackageMergeEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getProfileApplication().isSuperTypeOf(domainElement.eClass())) {
			return ProfileApplicationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getTemplateBinding().isSuperTypeOf(domainElement.eClass())) {
			return TemplateBindingEditPart.VISUAL_ID;
		}
		return -1;
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
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!ModelEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ComponentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case SignalEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Model2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case DataTypeEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Component2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Signal2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Interface2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Model3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Package2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case Class4EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case DataType2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass())) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationEditPart.VISUAL_ID;
			}
			break;
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			break;
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return TemplateParameterEditPart.VISUAL_ID;
			}
			break;
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property2EditPart.VISUAL_ID;
			}
			break;
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property3EditPart.VISUAL_ID;
			}
			break;
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation2EditPart.VISUAL_ID;
			}
			break;
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return Signal2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return Model3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass())) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case ComponentAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case ComponentOperationCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationEditPart.VISUAL_ID;
			}
			break;
		case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			break;
		case SignalAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property2EditPart.VISUAL_ID;
			}
			break;
		case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property3EditPart.VISUAL_ID;
			}
			break;
		case InterfaceOperationCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation2EditPart.VISUAL_ID;
			}
			break;
		case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return Signal2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return Model3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return Signal2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return Model3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property4EditPart.VISUAL_ID;
			}
			break;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return ReceptionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation3EditPart.VISUAL_ID;
			}
			break;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class5EditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property5EditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation4EditPart.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecification2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return Component2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return Signal2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return Model3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return Enumeration2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return Package2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataType2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return Comment2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case ClassAttributeCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property4EditPart.VISUAL_ID;
			}
			break;
		case ClassOperationCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return ReceptionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation3EditPart.VISUAL_ID;
			}
			break;
		case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return Class5EditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return Property5EditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return Operation4EditPart.VISUAL_ID;
			}
			break;
		case ModelEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
				return Dependency2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
				return AssociationClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
				return Association2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecificationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return SignalEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return Model2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return PackageEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return ClassEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataTypeEditPart.VISUAL_ID;
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
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	// test

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
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ModelEditPart.MODEL_ID.equals(view.getType())) {
				return ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(view.getType());
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

		viewInfo = new BaseViewInfo(2014, ViewInfo.Node, "Dependency");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2013, ViewInfo.Node, "AssociationClass");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2015, ViewInfo.Node, "Association");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2001, ViewInfo.Node, "InstanceSpecification");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2002, ViewInfo.Node, "Component");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2003, ViewInfo.Node, "Signal");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2004, ViewInfo.Node, "Interface");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2005, ViewInfo.Node, "Model");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2006, ViewInfo.Node, "Enumeration");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2007, ViewInfo.Node, "Package");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2008, ViewInfo.Node, "Class");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2009, ViewInfo.Node, "PrimitiveType");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2010, ViewInfo.Node, "DataType");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2011, ViewInfo.Node, "Constraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2012, ViewInfo.Node, "Comment");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4016, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4017, ViewInfo.Edge, "AssociationClass");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4001, ViewInfo.Edge, "Association");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6002, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6003, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6004, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6005, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6006, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4019, ViewInfo.Edge, "Association");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4002, ViewInfo.Edge, "Generalization");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6007, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4003, ViewInfo.Edge, "InterfaceRealization");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6008, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6009, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4004, ViewInfo.Edge, "Substitution");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6010, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6011, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4005, ViewInfo.Edge, "Realization");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6012, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6013, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4006, ViewInfo.Edge, "Abstraction");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6014, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6015, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4007, ViewInfo.Edge, "Usage");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6016, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6017, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4008, ViewInfo.Edge, "Dependency");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6026, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6027, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4018, ViewInfo.Edge, "Dependency");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6028, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6029, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4009, ViewInfo.Edge, "ElementImport");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6020, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6021, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4010, ViewInfo.Edge, "PackageImport");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6022, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4011, ViewInfo.Edge, "PackageMerge");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4012, ViewInfo.Edge, "ProfileApplication");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4013, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4014, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4015, ViewInfo.Edge, "TemplateBinding");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6023, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(3002, ViewInfo.Node, "Property");

		root.addNode(2013, viewInfo);

		root.addNode(2002, viewInfo);

		root.addNode(3021, viewInfo);

		viewInfo = new BaseViewInfo(3001, ViewInfo.Node, "Slot");

		root.addNode(2001, viewInfo);

		root.addNode(3020, viewInfo);

		viewInfo = new BaseViewInfo(3003, ViewInfo.Node, "Operation");

		root.addNode(2002, viewInfo);

		root.addNode(3021, viewInfo);

		viewInfo = new BaseViewInfo(3004, ViewInfo.Node, "Class");

		root.addNode(2002, viewInfo);

		root.addNode(3021, viewInfo);

		viewInfo = new BaseViewInfo(3015, ViewInfo.Node, "RedefinableTemplateSignature");

		root.addNode(2002, viewInfo);

		root.addNode(2003, viewInfo);

		root.addNode(2004, viewInfo);

		root.addNode(3021, viewInfo);

		root.addNode(3022, viewInfo);

		root.addNode(3023, viewInfo);

		root.addNode(3010, viewInfo);

		root.addNode(3027, viewInfo);

		root.addNode(3009, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		root.addNode(2008, viewInfo);

		root.addNode(2010, viewInfo);

		viewInfo = new BaseViewInfo(3016, ViewInfo.Node, "TemplateParameter");

		root.addNode(3015, viewInfo);

		viewInfo = new BaseViewInfo(3005, ViewInfo.Node, "Property");

		root.addNode(2003, viewInfo);

		root.addNode(3022, viewInfo);

		viewInfo = new BaseViewInfo(3006, ViewInfo.Node, "Property");

		root.addNode(2004, viewInfo);

		root.addNode(3023, viewInfo);

		viewInfo = new BaseViewInfo(3007, ViewInfo.Node, "Operation");

		root.addNode(2004, viewInfo);

		root.addNode(3023, viewInfo);

		viewInfo = new BaseViewInfo(3008, ViewInfo.Node, "Class");

		root.addNode(2004, viewInfo);

		root.addNode(3023, viewInfo);

		viewInfo = new BaseViewInfo(3020, ViewInfo.Node, "InstanceSpecification");

		root.addNode(2005, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(3009, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3021, ViewInfo.Node, "Component");

		root.addNode(2005, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(3009, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3022, ViewInfo.Node, "Signal");

		root.addNode(2005, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(3009, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3023, ViewInfo.Node, "Interface");

		root.addNode(2005, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(3009, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3024, ViewInfo.Node, "Model");

		root.addNode(3024, viewInfo);

		root.addNode(3009, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3025, ViewInfo.Node, "Enumeration");

		root.addNode(3024, viewInfo);

		root.addNode(3009, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3017, ViewInfo.Node, "EnumerationLiteral");

		root.addNode(3025, viewInfo);

		root.addNode(2006, viewInfo);

		viewInfo = new BaseViewInfo(3009, ViewInfo.Node, "Package");

		root.addNode(3009, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3010, ViewInfo.Node, "Class");

		root.addNode(3009, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3011, ViewInfo.Node, "Reception");

		root.addNode(3010, viewInfo);

		root.addNode(2008, viewInfo);

		viewInfo = new BaseViewInfo(3012, ViewInfo.Node, "Property");

		root.addNode(3010, viewInfo);

		root.addNode(2008, viewInfo);

		viewInfo = new BaseViewInfo(3013, ViewInfo.Node, "Operation");

		root.addNode(3010, viewInfo);

		root.addNode(2008, viewInfo);

		viewInfo = new BaseViewInfo(3014, ViewInfo.Node, "Class");

		root.addNode(3010, viewInfo);

		root.addNode(2008, viewInfo);

		viewInfo = new BaseViewInfo(3026, ViewInfo.Node, "PrimitiveType");

		root.addNode(3009, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3027, ViewInfo.Node, "DataType");

		root.addNode(3009, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3018, ViewInfo.Node, "Property");

		root.addNode(3027, viewInfo);

		root.addNode(2010, viewInfo);

		viewInfo = new BaseViewInfo(3019, ViewInfo.Node, "Operation");

		root.addNode(3027, viewInfo);

		root.addNode(2010, viewInfo);

		viewInfo = new BaseViewInfo(3028, ViewInfo.Node, "Comment");

		root.addNode(3009, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		viewInfo = new BaseViewInfo(3029, ViewInfo.Node, "Constraint");

		root.addNode(3009, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(2005, viewInfo);

		root.addNode(2007, viewInfo);

		return root;
	}
}
