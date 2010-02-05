/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.*;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be created for the
 * corresponding Diagram, Node, ChildNode or Link represented by a domain model object.
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
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(ModelEditPart.MODEL_ID.equals(view.getType())) {
				return ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
		String containerModelID = org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ModelEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case ComponentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case SignalEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ModelEditPartTN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return ContainmentCircleEditPart.VISUAL_ID;
			}
			break;
		case DataTypeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ComponentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case SignalEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case InterfaceEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ModelEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case ClassEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case DataTypeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature().isSuperTypeOf(domainElement.eClass())

			) {
				return RedefinableTemplateSignatureEditPart.VISUAL_ID;
			}
			break;
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass())

			) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return OperationEditPart.VISUAL_ID;
			}
			break;
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return Class2EditPart.VISUAL_ID;
			}
			break;
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClassifierTemplateParameter().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassifierTemplateParameterEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTemplateParameter().isSuperTypeOf(domainElement.eClass())

			) {
				return TemplateParameterEditPart.VISUAL_ID;
			}
			break;
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return Property2EditPart.VISUAL_ID;
			}
			break;
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return Property3EditPart.VISUAL_ID;
			}
			break;
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return Operation2EditPart.VISUAL_ID;
			}
			break;
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return InstanceSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return Comment2EditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case ComponentAttributeCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case ComponentOperationCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return OperationEditPart.VISUAL_ID;
			}
			break;
		case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return Class2EditPart.VISUAL_ID;
			}
			break;
		case SignalAttributeCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return Property2EditPart.VISUAL_ID;
			}
			break;
		case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return Property3EditPart.VISUAL_ID;
			}
			break;
		case InterfaceOperationCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return Operation2EditPart.VISUAL_ID;
			}
			break;
		case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return Class3EditPart.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return InstanceSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return Comment2EditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return InstanceSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return Comment2EditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return Property4EditPart.VISUAL_ID;
			}
			break;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())

			) {
				return ReceptionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return Operation3EditPart.VISUAL_ID;
			}
			break;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return Class5EditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return Property5EditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return Operation4EditPart.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationLiteralEditPart.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return InstanceSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return Comment2EditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case ClassAttributeCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return Property4EditPart.VISUAL_ID;
			}
			break;
		case ClassOperationCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())

			) {
				return ReceptionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return Operation3EditPart.VISUAL_ID;
			}
			break;
		case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return Class5EditPart.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return Property5EditPart.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return Operation4EditPart.VISUAL_ID;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getSlot().isSuperTypeOf(domainElement.eClass())

			) {
				return SlotEditPart.VISUAL_ID;
			}
			break;
		case AssociationClassOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return OperationEditPart.VISUAL_ID;
			}
			break;
		case AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return Class2EditPart.VISUAL_ID;
			}
			break;
		case ModelEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())

			) {
				return Dependency2EditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())

			) {
				return AssociationClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())

			) {
				return AssociationNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInstanceSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return InstanceSpecificationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartTN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ModelEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case Dependency2EditPart.VISUAL_ID:
			if(MultiDependencyLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassEditPart.VISUAL_ID:
			if(AssociationClassName2EditPart.VISUAL_ID == nodeVisualID) {
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
			if(ModelPackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
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
			if(PackagePackageableElementCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if(ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
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
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			if(RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ComponentAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
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
			if(SignalAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
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
			if(InterfaceAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID == nodeVisualID) {
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
			if(ModelPackageableElementCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEditPartCN.VISUAL_ID:
			if(EnumerationNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPartCN.VISUAL_ID:
			if(PackageNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackagePackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassEditPartCN.VISUAL_ID:
			if(ClassNameEditPartCN.VISUAL_ID == nodeVisualID) {
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
			break;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			if(PrimitiveTypeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeEditPartCN.VISUAL_ID:
			if(DataTypeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeAttributeCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeOperationCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RedefinableTemplateSignatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Comment2EditPart.VISUAL_ID:
			if(CommentBody2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Constraint2EditPart.VISUAL_ID:
			if(ConstraintName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			if(SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			if(OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			if(ClassifierTemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TemplateParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			if(Property2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			if(Property3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			if(Operation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
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
			if(Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentAttributeCompartment2EditPart.VISUAL_ID:
			if(PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentOperationCompartment2EditPart.VISUAL_ID:
			if(OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			if(Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalAttributeCompartment2EditPart.VISUAL_ID:
			if(Property2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			if(Property3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceOperationCompartment2EditPart.VISUAL_ID:
			if(Operation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			if(Class3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
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
			if(Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			if(EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
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
			if(Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			if(Property4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			if(ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(Operation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(Class5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			if(Property5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartment2EditPart.VISUAL_ID:
			if(Operation4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if(EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
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
			if(Comment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributeCompartment2EditPart.VISUAL_ID:
			if(Property4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationCompartment2EditPart.VISUAL_ID:
			if(ReceptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(Operation3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			if(Class5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(Property5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if(Operation4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID:
			if(SlotEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassOperationCompartmentEditPart.VISUAL_ID:
			if(OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPart.VISUAL_ID:
			if(Dependency2EditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case AssociationClass2EditPart.VISUAL_ID:
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
			if(AssociationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AssociationName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationBranchEditPart.VISUAL_ID:
			if(AssociationBranchRoleEditPart.VISUAL_ID == nodeVisualID) {
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
			if(InterfaceRealizationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubstitutionEditPart.VISUAL_ID:
			if(AppliedStereotypeSubstitutionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SubstitutionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RealizationEditPart.VISUAL_ID:
			if(AppliedStereotypeRealizationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RealizationName2EditPart.VISUAL_ID == nodeVisualID) {
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
			if(WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationSetEditPart.VISUAL_ID:
			if(ConstraintLabelEditPart.VISUAL_ID == nodeVisualID) {
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
		if(UMLPackage.eINSTANCE.getAssociationClass().isSuperTypeOf(domainElement.eClass())

		) {
			return AssociationClass2EditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())

		) {
			return AssociationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())

		) {
			return AssociationBranchEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())

		) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getInterfaceRealization().isSuperTypeOf(domainElement.eClass())

		) {
			return InterfaceRealizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getSubstitution().isSuperTypeOf(domainElement.eClass())

		) {
			return SubstitutionEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getRealization().isSuperTypeOf(domainElement.eClass())

		) {
			return RealizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAbstraction().isSuperTypeOf(domainElement.eClass())

		) {
			return AbstractionEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(domainElement.eClass())

		) {
			return UsageEditPart.VISUAL_ID;
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
		if(UMLPackage.eINSTANCE.getPackageMerge().isSuperTypeOf(domainElement.eClass())

		) {
			return PackageMergeEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getProfileApplication().isSuperTypeOf(domainElement.eClass())

		) {
			return ProfileApplicationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getTemplateBinding().isSuperTypeOf(domainElement.eClass())

		) {
			return TemplateBindingEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralizationSet().isSuperTypeOf(domainElement.eClass())

		) {
			return GeneralizationSetEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())

		) {
			return AddedLinkEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific situations not covered
	 * by default logic.
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
		if(diagramViewInfo == null) {
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

		viewInfo = new BaseViewInfo(2016, ViewInfo.Node, "Diagram");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4016, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4017, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6031, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6032, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

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

		viewInfo = new BaseViewInfo(4019, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6024, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4002, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6007, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4003, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6008, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6009, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4004, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6010, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6011, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4005, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6012, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6013, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4006, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6014, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6015, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4007, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6016, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6017, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4008, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6026, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6027, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4018, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4009, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6020, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6021, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4010, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6022, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4011, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6030, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4012, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4013, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4014, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4015, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6023, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4020, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(5067, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(4021, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4022, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4023, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(3002, ViewInfo.Node, "Property");

		root.addNode(7002, viewInfo);

		root.addNode(7023, viewInfo);

		root.addNode(7034, viewInfo);

		viewInfo = new BaseViewInfo(3003, ViewInfo.Node, "Operation");

		root.addNode(7003, viewInfo);

		root.addNode(7024, viewInfo);

		root.addNode(7036, viewInfo);

		viewInfo = new BaseViewInfo(3004, ViewInfo.Node, "Class");

		root.addNode(7004, viewInfo);

		root.addNode(7025, viewInfo);

		root.addNode(7037, viewInfo);

		viewInfo = new BaseViewInfo(3015, ViewInfo.Node, "RedefinableTemplateSignature");

		root.addNode(2005, viewInfo);

		root.addNode(3010, viewInfo);

		root.addNode(3023, viewInfo);

		root.addNode(3009, viewInfo);

		root.addNode(3022, viewInfo);

		root.addNode(2003, viewInfo);

		root.addNode(2010, viewInfo);

		root.addNode(3021, viewInfo);

		root.addNode(3027, viewInfo);

		root.addNode(2004, viewInfo);

		root.addNode(2007, viewInfo);

		root.addNode(3024, viewInfo);

		root.addNode(2008, viewInfo);

		root.addNode(2002, viewInfo);

		viewInfo = new BaseViewInfo(3031, ViewInfo.Node, "ClassifierTemplateParameter");

		root.addNode(7014, viewInfo);

		viewInfo = new BaseViewInfo(3016, ViewInfo.Node, "TemplateParameter");

		root.addNode(7014, viewInfo);

		viewInfo = new BaseViewInfo(3005, ViewInfo.Node, "Property");

		root.addNode(7026, viewInfo);

		root.addNode(7005, viewInfo);

		viewInfo = new BaseViewInfo(3006, ViewInfo.Node, "Property");

		root.addNode(7027, viewInfo);

		root.addNode(7006, viewInfo);

		viewInfo = new BaseViewInfo(3007, ViewInfo.Node, "Operation");

		root.addNode(7007, viewInfo);

		root.addNode(7028, viewInfo);

		viewInfo = new BaseViewInfo(3008, ViewInfo.Node, "Class");

		root.addNode(7008, viewInfo);

		root.addNode(7029, viewInfo);

		viewInfo = new BaseViewInfo(3020, ViewInfo.Node, "InstanceSpecification");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3021, ViewInfo.Node, "Component");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3022, ViewInfo.Node, "Signal");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3023, ViewInfo.Node, "Interface");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3024, ViewInfo.Node, "Model");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3025, ViewInfo.Node, "Enumeration");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3017, ViewInfo.Node, "EnumerationLiteral");

		root.addNode(7031, viewInfo);

		root.addNode(7015, viewInfo);

		viewInfo = new BaseViewInfo(3009, ViewInfo.Node, "Package");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3010, ViewInfo.Node, "Class");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3011, ViewInfo.Node, "Reception");

		root.addNode(7018, viewInfo);

		root.addNode(7012, viewInfo);

		viewInfo = new BaseViewInfo(3012, ViewInfo.Node, "Property");

		root.addNode(7017, viewInfo);

		root.addNode(7011, viewInfo);

		viewInfo = new BaseViewInfo(3013, ViewInfo.Node, "Operation");

		root.addNode(7018, viewInfo);

		root.addNode(7012, viewInfo);

		viewInfo = new BaseViewInfo(3014, ViewInfo.Node, "Class");

		root.addNode(7013, viewInfo);

		root.addNode(7019, viewInfo);

		viewInfo = new BaseViewInfo(3026, ViewInfo.Node, "PrimitiveType");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3027, ViewInfo.Node, "DataType");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3018, ViewInfo.Node, "Property");

		root.addNode(7020, viewInfo);

		root.addNode(7032, viewInfo);

		viewInfo = new BaseViewInfo(3019, ViewInfo.Node, "Operation");

		root.addNode(7033, viewInfo);

		root.addNode(7021, viewInfo);

		viewInfo = new BaseViewInfo(3028, ViewInfo.Node, "Comment");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3029, ViewInfo.Node, "Constraint");

		root.addNode(7010, viewInfo);

		root.addNode(7009, viewInfo);

		root.addNode(7030, viewInfo);

		root.addNode(7016, viewInfo);

		viewInfo = new BaseViewInfo(3030, ViewInfo.Node, "Slot");

		root.addNode(7001, viewInfo);

		root.addNode(7035, viewInfo);

		viewInfo = new BaseViewInfo(3032, ViewInfo.Node, "Port");

		root.addNode(2008, viewInfo);

		return root;
	}

	// test
}
