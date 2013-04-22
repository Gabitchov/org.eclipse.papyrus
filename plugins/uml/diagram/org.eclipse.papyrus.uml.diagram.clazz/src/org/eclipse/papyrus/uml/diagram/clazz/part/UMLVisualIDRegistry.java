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
package org.eclipse.papyrus.uml.diagram.clazz.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.*;
import org.eclipse.uml2.uml.Package;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.uml.diagram.clazz/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(ModelEditPart.MODEL_ID.equals(view.getType())) {
				return ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package)domainElement)) {
			return ModelEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ModelEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case ModelEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
				return DependencyNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
				return AssociationClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
				return AssociationNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecificationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return SignalEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return ModelEditPartTN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return PackageEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())) {
				return InformationItemEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return ClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataTypeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			if(NotationPackage.eINSTANCE.getDiagram().isSuperTypeOf(domainElement.eClass())) {
				return ShortCutDiagramEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationObservation().isSuperTypeOf(domainElement.eClass())) {
				return DurationObservationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeObservation().isSuperTypeOf(domainElement.eClass())) {
				return TimeObservationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNamedElement().isSuperTypeOf(domainElement.eClass())) {
				return DefaultNamedElementEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNamedElement().isSuperTypeOf(domainElement.eClass())) {
				return ShapeNamedElementEditPart.VISUAL_ID;
			}
			break;
		case ComponentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case SignalEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ModelEditPartTN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return TemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return TemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case DataTypeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ComponentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case SignalEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case InterfaceEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ModelEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return TemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return TemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ClassEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case DataTypeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ClassAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForClassEditPart.VISUAL_ID;
			}
			break;
		case ClassOperationCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return ReceptionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForClassEditPart.VISUAL_ID;
			}
			break;
		case ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return NestedClassForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return NestedInterfaceForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return NestedEnumerationForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return NestedPrimitiveTypeForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return NestedDataTypeForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return NestedSignalForClassEditPart.VISUAL_ID;
			}
			break;
		case ComponentAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForComponentEditPart.VISUAL_ID;
			}
			break;
		case ComponentOperationCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return ReceptionEditPart.VISUAL_ID;
			}
			break;
		case ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return NestedClassForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return NestedInterfaceForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return NestedEnumerationForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return NestedPrimitiveTypeForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return NestedDataTypeForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return NestedSignalForComponentEditPart.VISUAL_ID;
			}
			break;
		case SignalAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForSignalEditPart.VISUAL_ID;
			}
			break;
		case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForInterfaceEditPart.VISUAL_ID;
			}
			break;
		case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForInterfaceEditpart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return ReceptionInInterfaceEditPart.VISUAL_ID;
			}
			break;
		case InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return NestedClassForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return NestedInterfaceForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return NestedEnumerationForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return NestedPrimitiveTypeForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return NestedDataTypeForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return NestedSignalForInterfaceEditPart.VISUAL_ID;
			}
			break;
		case PrimitiveTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyforPrimitiveTypeEditPart.VISUAL_ID;
			}
			break;
		case PrimitiveTypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForPrimitiveTypeEditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyforDataTypeEditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForDataTypeEditPart.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return ClassEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return ClassEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass())) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForClassEditPart.VISUAL_ID;
			}
			break;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return ReceptionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForClassEditPart.VISUAL_ID;
			}
			break;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return NestedClassForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return NestedInterfaceForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return NestedEnumerationForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return NestedPrimitiveTypeForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return NestedDataTypeForClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return NestedSignalForClassEditPart.VISUAL_ID;
			}
			break;
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForComponentEditPart.VISUAL_ID;
			}
			break;
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return ReceptionEditPart.VISUAL_ID;
			}
			break;
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return NestedClassForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return NestedInterfaceForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return NestedEnumerationForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return NestedPrimitiveTypeForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return NestedDataTypeForComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return NestedSignalForComponentEditPart.VISUAL_ID;
			}
			break;
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForInterfaceEditPart.VISUAL_ID;
			}
			break;
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForInterfaceEditpart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
				return ReceptionInInterfaceEditPart.VISUAL_ID;
			}
			break;
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return NestedClassForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return NestedInterfaceForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return NestedEnumerationForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return NestedPrimitiveTypeForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return NestedDataTypeForInterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return NestedSignalForInterfaceEditPart.VISUAL_ID;
			}
			break;
		case PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyforPrimitiveTypeEditPart.VISUAL_ID;
			}
			break;
		case PrimitiveTypeOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForPrimitiveTypeEditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyforDataTypeEditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForDataTypeEditPart.VISUAL_ID;
			}
			break;
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForComponentEditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass())) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
				return PropertyForSignalEditPart.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return ClassEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
				return InstanceSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return ClassEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case AssociationClassOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return OperationForComponentEditPart.VISUAL_ID;
			}
			break;
		case AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return NestedClassForComponentEditPart.VISUAL_ID;
			}
			break;
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClassifierTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return ClassifierTemplateParameterEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConnectableElementTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return ConnectableElementTemplateParameterEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOperationTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return OperationTemplateParameterEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return TemplateParameterEditPart.VISUAL_ID;
			}
			break;
		case TemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClassifierTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return ClassifierTemplateParameterEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOperationTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return OperationTemplateParameterEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTemplateParameter().isSuperTypeOf(domainElement.eClass())) {
				return TemplateParameterEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ModelEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case ModelEditPart.VISUAL_ID:
			if(DependencyNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InstanceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartTN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ShortCutDiagramEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationObservationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeObservationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DefaultNamedElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ShapeNamedElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyNodeEditPart.VISUAL_ID:
			if(MultiDependencyLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassEditPart.VISUAL_ID:
			if(AssociationClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationClassAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationClassOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationEditPart.VISUAL_ID:
			if(InstanceSpecificationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentEditPart.VISUAL_ID:
			if(ComponentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalEditPart.VISUAL_ID:
			if(SignalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if(InterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPartTN.VISUAL_ID:
			if(ModelNameEditPartTN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelPackageableElementCompartmentEditPartTN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
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
		case PackageEditPart.VISUAL_ID:
			if(PackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackagePackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InformationItemEditPart.VISUAL_ID:
			if(InformationItemNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if(ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassNestedClassifierCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ContainmentCircleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeEditPart.VISUAL_ID:
			if(PrimitiveTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
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
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if(ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if(CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ShortCutDiagramEditPart.VISUAL_ID:
			if(DiagramNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationObservationEditPart.VISUAL_ID:
			if(DurationObservationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationObservationStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeObservationEditPart.VISUAL_ID:
			if(TimeObservationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeObservationStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DefaultNamedElementEditPart.VISUAL_ID:
			if(DefaultNamedElementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ShapeNamedElementEditPart.VISUAL_ID:
			if(ShapeNamedElementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			if(RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateSignatureEditPart.VISUAL_ID:
			if(TemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationEditPartCN.VISUAL_ID:
			if(InstanceSpecificationNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentEditPartCN.VISUAL_ID:
			if(ComponentNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentAttributeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentOperationCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalEditPartCN.VISUAL_ID:
			if(SignalNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalAttributeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPartCN.VISUAL_ID:
			if(InterfaceNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceAttributeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceOperationCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
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
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
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
		case PackageEditPartCN.VISUAL_ID:
			if(PackageNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackagePackageableElementCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InformationItemEditPartCN.VISUAL_ID:
			if(InformationItemNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassEditPartCN.VISUAL_ID:
			if(ClassNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassAttributeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassOperationCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			if(PrimitiveTypeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeAttributeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeOperationCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
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
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPartCN.VISUAL_ID:
			if(CommentBodyEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPartCN.VISUAL_ID:
			if(ConstraintNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintBodyEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationCompartmentEditPartCN.VISUAL_ID:
			if(ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OperationForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			if(NestedClassForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedInterfaceForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedEnumerationForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedPrimitiveTypeForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDataTypeForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedSignalForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentAttributeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentOperationCompartmentEditPartCN.VISUAL_ID:
			if(OperationForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			if(NestedClassForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedInterfaceForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedEnumerationForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedPrimitiveTypeForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDataTypeForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedSignalForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalAttributeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyForSignalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
			if(OperationForInterfaceEditpart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReceptionInInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			if(NestedClassForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedInterfaceForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedEnumerationForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedPrimitiveTypeForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDataTypeForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedSignalForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyforPrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(OperationForPrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyforDataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(OperationForDataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(InstanceSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(InstanceSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			if(EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID:
			if(SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			if(ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OperationForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(NestedClassForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedInterfaceForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedEnumerationForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedPrimitiveTypeForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDataTypeForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedSignalForClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			if(OperationForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(NestedClassForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedInterfaceForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedEnumerationForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedPrimitiveTypeForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDataTypeForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedSignalForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			if(OperationForInterfaceEditpart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReceptionInInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(NestedClassForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedInterfaceForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedEnumerationForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedPrimitiveTypeForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDataTypeForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedSignalForInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyforPrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeOperationCompartmentEditPart.VISUAL_ID:
			if(OperationForPrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyforDataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if(OperationForDataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			if(SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyForSignalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
			if(InstanceSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(InstanceSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if(EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassOperationCompartmentEditPart.VISUAL_ID:
			if(OperationForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(NestedClassForComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if(ClassifierTemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConnectableElementTemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OperationTemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if(ClassifierTemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OperationTemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassLinkEditPart.VISUAL_ID:
			if(AssociationClassRoleSourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationClassRoleTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationEditPart.VISUAL_ID:
			if(AppliedStereotypeAssociationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationTargetNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationSourceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationMultiplicitySourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationMultiplicityTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationBranchEditPart.VISUAL_ID:
			if(AssociationBranchRoleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationBranchMutliplicityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationEditPart.VISUAL_ID:
			if(AppliedStereotyperGeneralizationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceRealizationEditPart.VISUAL_ID:
			if(AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceRealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubstitutionEditPart.VISUAL_ID:
			if(AppliedStereotypeSubstitutionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SubstitutionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RealizationEditPart.VISUAL_ID:
			if(AppliedStereotypeRealizationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractionEditPart.VISUAL_ID:
			if(AbstractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AppliedStereotypeAbstractionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UsageEditPart.VISUAL_ID:
			if(UsageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AppliedStereotypeUsageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyEditPart.VISUAL_ID:
			if(DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AppliedStereotypeDependencyEditPart.VISUAL_ID == nodeVisualID) {
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
			if(AppliedStereotypePackageImportEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageMergeEditPart.VISUAL_ID:
			if(AppliedStereotypePackageMergeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateBindingEditPart.VISUAL_ID:
			if(BindingSubstitutionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AppliedStereotypeTemplateBindingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationSetEditPart.VISUAL_ID:
			if(ConstraintLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AppliedStereotypeGeneralizationSetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationLinkEditPart.VISUAL_ID:
			if(SourceISLinkLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TargetISLinkLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InformationFlowEditPart.VISUAL_ID:
			if(InformationFlowConveyedLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationFlowAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
		if(UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())) {
			return AssociationClassLinkEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return AssociationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return AssociationBranchEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getInterfaceRealization().isSuperTypeOf(domainElement.eClass())) {
			return InterfaceRealizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getSubstitution().isSuperTypeOf(domainElement.eClass())) {
			return SubstitutionEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getRealization().isSuperTypeOf(domainElement.eClass())) {
			return RealizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAbstraction().isSuperTypeOf(domainElement.eClass())) {
			return AbstractionEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(domainElement.eClass())) {
			return UsageEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return DependencyEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return DependencyBranchEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getElementImport().isSuperTypeOf(domainElement.eClass())) {
			return ElementImportEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getPackageImport().isSuperTypeOf(domainElement.eClass())) {
			return PackageImportEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getPackageMerge().isSuperTypeOf(domainElement.eClass())) {
			return PackageMergeEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getProfileApplication().isSuperTypeOf(domainElement.eClass())) {
			return ProfileApplicationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getTemplateBinding().isSuperTypeOf(domainElement.eClass())) {
			return TemplateBindingEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralizationSet().isSuperTypeOf(domainElement.eClass())) {
			return GeneralizationSetEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())) {
			return InstanceSpecificationLinkEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getInformationFlow().isSuperTypeOf(domainElement.eClass())) {
			return InformationFlowEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * "User can change implementation of this method to handle some specific\n""situations not covered by default logic.\n"
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if(candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch(visualID) {
		case ClassAttributeCompartmentEditPartCN.VISUAL_ID:
		case ClassOperationCompartmentEditPartCN.VISUAL_ID:
		case ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID:
		case ComponentAttributeCompartmentEditPartCN.VISUAL_ID:
		case ComponentOperationCompartmentEditPartCN.VISUAL_ID:
		case ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID:
		case SignalAttributeCompartmentEditPartCN.VISUAL_ID:
		case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
		case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
		case InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID:
		case PrimitiveTypeAttributeCompartmentEditPartCN.VISUAL_ID:
		case PrimitiveTypeOperationCompartmentEditPartCN.VISUAL_ID:
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
		case InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID:
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
		case ClassOperationCompartmentEditPart.VISUAL_ID:
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
		case PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID:
		case PrimitiveTypeOperationCompartmentEditPart.VISUAL_ID:
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
		case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
		case AssociationClassOperationCompartmentEditPart.VISUAL_ID:
		case AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID:
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
		case TemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch(visualID) {
		case ModelEditPart.VISUAL_ID:
			return false;
		case ConstraintEditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case DependencyNodeEditPart.VISUAL_ID:
		case AssociationNodeEditPart.VISUAL_ID:
		case ShortCutDiagramEditPart.VISUAL_ID:
		case DurationObservationEditPart.VISUAL_ID:
		case TimeObservationEditPart.VISUAL_ID:
		case DefaultNamedElementEditPart.VISUAL_ID:
		case ShapeNamedElementEditPart.VISUAL_ID:
		case InformationItemEditPart.VISUAL_ID:
		case PropertyForComponentEditPart.VISUAL_ID:
		case OperationForComponentEditPart.VISUAL_ID:
		case NestedClassForComponentEditPart.VISUAL_ID:
		case PropertyForSignalEditPart.VISUAL_ID:
		case PropertyForInterfaceEditPart.VISUAL_ID:
		case OperationForInterfaceEditpart.VISUAL_ID:
		case NestedClassForInterfaceEditPart.VISUAL_ID:
		case ReceptionEditPart.VISUAL_ID:
		case PropertyForClassEditPart.VISUAL_ID:
		case OperationForClassEditPart.VISUAL_ID:
		case NestedClassForClassEditPart.VISUAL_ID:
		case TemplateParameterEditPart.VISUAL_ID:
		case EnumerationLiteralEditPart.VISUAL_ID:
		case PropertyforDataTypeEditPart.VISUAL_ID:
		case OperationForDataTypeEditPart.VISUAL_ID:
		case CommentEditPartCN.VISUAL_ID:
		case ConstraintEditPartCN.VISUAL_ID:
		case SlotEditPart.VISUAL_ID:
		case ClassifierTemplateParameterEditPart.VISUAL_ID:
		case ContainmentCircleEditPart.VISUAL_ID:
		case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
		case OperationTemplateParameterEditPart.VISUAL_ID:
		case NestedInterfaceForClassEditPart.VISUAL_ID:
		case NestedInterfaceForComponentEditPart.VISUAL_ID:
		case NestedInterfaceForInterfaceEditPart.VISUAL_ID:
		case ReceptionInInterfaceEditPart.VISUAL_ID:
		case InformationItemEditPartCN.VISUAL_ID:
		case PropertyforPrimitiveTypeEditPart.VISUAL_ID:
		case OperationForPrimitiveTypeEditPart.VISUAL_ID:
		case NestedDataTypeForInterfaceEditPart.VISUAL_ID:
		case NestedDataTypeForClassEditPart.VISUAL_ID:
		case NestedDataTypeForComponentEditPart.VISUAL_ID:
		case NestedPrimitiveTypeForComponentEditPart.VISUAL_ID:
		case NestedPrimitiveTypeForClassEditPart.VISUAL_ID:
		case NestedPrimitiveTypeForInterfaceEditPart.VISUAL_ID:
		case NestedSignalForInterfaceEditPart.VISUAL_ID:
		case NestedSignalForClassEditPart.VISUAL_ID:
		case NestedSignalForComponentEditPart.VISUAL_ID:
		case NestedEnumerationForClassEditPart.VISUAL_ID:
		case NestedEnumerationForComponentEditPart.VISUAL_ID:
		case NestedEnumerationForInterfaceEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {

		/**
		 * @generated
		 */
		public int getVisualID(View view) {
			return org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		public String getModelID(View view) {
			return org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};
}
