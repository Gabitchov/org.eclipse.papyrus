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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.composite.edit.parts.*;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.composite/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
			return PackageEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case ActivityCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case InteractionCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case StateMachineCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ComponentCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case DeviceCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case NodeCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ClassCompositeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case EnumerationEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationLiteralEditPartCLN.VISUAL_ID;
			}
			break;
		case PropertyPartEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ActivityCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case InteractionCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ComponentCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case DeviceCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case NodeCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ClassCompositeEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case EnumerationEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationLiteralEditPartCLN.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return PropertyEditPartCLN.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return OperationEditPartCLN.VISUAL_ID;
			}
			break;
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return PropertyEditPartCLN.VISUAL_ID;
			}
			break;
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return OperationEditPartCLN.VISUAL_ID;
			}
			break;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return PropertyEditPartCLN.VISUAL_ID;
			}
			break;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())

			) {
				return ReceptionEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return OperationEditPartCLN.VISUAL_ID;
			}
			break;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCLN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassEditPartCLN.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationLiteralEditPartCLN.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getEnumerationLiteral().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationLiteralEditPartCLN.VISUAL_ID;
			}
			break;
		case ActivityCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case InteractionCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case StateMachineCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ClassCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case CollaborationCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConnectableElement().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationRoleEditPartCN.VISUAL_ID;
			}
			break;
		case ActivityCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case InteractionCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case StateMachineCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ComponentCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case DeviceCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case NodeCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case ClassCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case CollaborationCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaborationUse().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationUseEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConnectableElement().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationRoleEditPartCN.VISUAL_ID;
			}
			break;
		case PropertyPartCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass()) && isProperty_3070(containerView, (Property)domainElement)) {
				return PropertyPartEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getProtocolStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return ProtocolStateMachineCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass())

			) {
				return StateMachineCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFunctionBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return FunctionBehaviorCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueBehavior().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueBehaviorCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())

			) {
				return ClassClassifierEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCollaboration().isSuperTypeOf(domainElement.eClass())

			) {
				return CollaborationCompositeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPrimitiveType().isSuperTypeOf(domainElement.eClass())

			) {
				return PrimitiveTypeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())

			) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataType().isSuperTypeOf(domainElement.eClass())

			) {
				return DataTypeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActor().isSuperTypeOf(domainElement.eClass())

			) {
				return ActorEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDeploymentSpecification().isSuperTypeOf(domainElement.eClass())

			) {
				return DeploymentSpecificationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInformationItem().isSuperTypeOf(domainElement.eClass())

			) {
				return InformationItemEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getUseCase().isSuperTypeOf(domainElement.eClass())

			) {
				return UseCaseEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSignalEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return SignalEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return CallEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAnyReceiveEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return AnyReceiveEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return SendSignalEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendOperationEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return SendOperationEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getChangeEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return ChangeEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return TimeEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCreationEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return CreationEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestructionEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return DestructionEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEvent().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEventEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationObservation().isSuperTypeOf(domainElement.eClass())

			) {
				return DurationObservationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeObservation().isSuperTypeOf(domainElement.eClass())

			) {
				return TimeObservationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLiteralBoolean().isSuperTypeOf(domainElement.eClass())

			) {
				return LiteralBooleanEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLiteralInteger().isSuperTypeOf(domainElement.eClass())

			) {
				return LiteralIntegerEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLiteralNull().isSuperTypeOf(domainElement.eClass())

			) {
				return LiteralNullEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLiteralString().isSuperTypeOf(domainElement.eClass())

			) {
				return LiteralStringEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLiteralUnlimitedNatural().isSuperTypeOf(domainElement.eClass())

			) {
				return LiteralUnlimitedNaturalEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStringExpression().isSuperTypeOf(domainElement.eClass())

			) {
				return StringExpressionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueExpression().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueExpressionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeExpression().isSuperTypeOf(domainElement.eClass())

			) {
				return TimeExpressionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpression().isSuperTypeOf(domainElement.eClass())

			) {
				return ExpressionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDuration().isSuperTypeOf(domainElement.eClass())

			) {
				return DurationEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeInterval().isSuperTypeOf(domainElement.eClass())

			) {
				return TimeIntervalEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationInterval().isSuperTypeOf(domainElement.eClass())

			) {
				return DurationIntervalEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterval().isSuperTypeOf(domainElement.eClass())

			) {
				return IntervalEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInstanceValue().isSuperTypeOf(domainElement.eClass())

			) {
				return InstanceValueEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return DurationConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return TimeConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getIntervalConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return IntervalConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteractionConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case ActivityCompositeEditPart.VISUAL_ID:
			if(ActivityCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionCompositeEditPart.VISUAL_ID:
			if(InteractionCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			if(ProtocolStateMachineCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineCompositeEditPart.VISUAL_ID:
			if(StateMachineCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			if(FunctionBehaviorCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			if(OpaqueBehaviorCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentCompositeEditPart.VISUAL_ID:
			if(ComponentCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeviceCompositeEditPart.VISUAL_ID:
			if(DeviceCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			if(ExecutionEnvironmentCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeCompositeEditPart.VISUAL_ID:
			if(NodeCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassCompositeEditPart.VISUAL_ID:
			if(ClassCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassClassifierEditPart.VISUAL_ID:
			if(ClassClassifierNameEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case CollaborationCompositeEditPart.VISUAL_ID:
			if(CollaborationCompositeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if(InterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeEditPart.VISUAL_ID:
			if(PrimitiveTypeNameEditPart.VISUAL_ID == nodeVisualID) {
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
			if(EnumerationLiteralEditPartCLN.VISUAL_ID == nodeVisualID) {
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
		case ActorEditPart.VISUAL_ID:
			if(ActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeploymentSpecificationEditPart.VISUAL_ID:
			if(DeploymentSpecificationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactEditPart.VISUAL_ID:
			if(ArtifactNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InformationItemEditPart.VISUAL_ID:
			if(InformationItemNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalEditPart.VISUAL_ID:
			if(SignalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCaseEditPart.VISUAL_ID:
			if(UseCaseNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalEventEditPart.VISUAL_ID:
			if(SignalEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallEventEditPart.VISUAL_ID:
			if(CallEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AnyReceiveEventEditPart.VISUAL_ID:
			if(AnyReceiveEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendSignalEventEditPart.VISUAL_ID:
			if(SendSignalEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendOperationEventEditPart.VISUAL_ID:
			if(SendOperationEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChangeEventEditPart.VISUAL_ID:
			if(ChangeEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeEventEditPart.VISUAL_ID:
			if(TimeEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CreationEventEditPart.VISUAL_ID:
			if(CreationEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DestructionEventEditPart.VISUAL_ID:
			if(DestructionEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEventEditPart.VISUAL_ID:
			if(ExecutionEventNameEditPart.VISUAL_ID == nodeVisualID) {
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
		case LiteralBooleanEditPart.VISUAL_ID:
			if(LiteralBooleanNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LiteralIntegerEditPart.VISUAL_ID:
			if(LiteralIntegerNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LiteralNullEditPart.VISUAL_ID:
			if(LiteralNullNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LiteralStringEditPart.VISUAL_ID:
			if(LiteralStringNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
			if(LiteralUnlimitedNaturalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StringExpressionEditPart.VISUAL_ID:
			if(StringExpressionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueExpressionEditPart.VISUAL_ID:
			if(OpaqueExpressionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeExpressionEditPart.VISUAL_ID:
			if(TimeExpressionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExpressionEditPart.VISUAL_ID:
			if(ExpressionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationEditPart.VISUAL_ID:
			if(DurationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeIntervalEditPart.VISUAL_ID:
			if(TimeIntervalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationIntervalEditPart.VISUAL_ID:
			if(DurationIntervalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IntervalEditPart.VISUAL_ID:
			if(IntervalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InstanceValueEditPart.VISUAL_ID:
			if(InstanceValueNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if(CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationConstraintEditPart.VISUAL_ID:
			if(DurationConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeConstraintEditPart.VISUAL_ID:
			if(TimeConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IntervalConstraintEditPart.VISUAL_ID:
			if(IntervalConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionConstraintEditPart.VISUAL_ID:
			if(InteractionConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if(ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PortEditPart.VISUAL_ID:
			if(PortNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PropertyPartEditPartCN.VISUAL_ID:
			if(PropertyPartNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PropertyPartCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollaborationRoleEditPartCN.VISUAL_ID:
			if(CollaborationRoleNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollaborationUseEditPartCN.VISUAL_ID:
			if(CollaborationUseNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityCompositeEditPartCN.VISUAL_ID:
			if(ActivityCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionCompositeEditPartCN.VISUAL_ID:
			if(InteractionCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			if(ProtocolStateMachineCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			if(StateMachineCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			if(FunctionBehaviorCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			if(OpaqueBehaviorCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentCompositeEditPartCN.VISUAL_ID:
			if(ComponentCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeviceCompositeEditPartCN.VISUAL_ID:
			if(DeviceCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			if(ExecutionEnvironmentCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeCompositeEditPartCN.VISUAL_ID:
			if(NodeCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassCompositeEditPartCN.VISUAL_ID:
			if(ClassCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollaborationCompositeEditPartCN.VISUAL_ID:
			if(CollaborationCompositeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPartCN.VISUAL_ID:
			if(InterfaceNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			if(PrimitiveTypeNameEditPartCN.VISUAL_ID == nodeVisualID) {
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
			if(EnumerationLiteralEditPartCLN.VISUAL_ID == nodeVisualID) {
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
		case ActorEditPartCN.VISUAL_ID:
			if(ActorNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeploymentSpecificationEditPartCN.VISUAL_ID:
			if(DeploymentSpecificationNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactEditPartCN.VISUAL_ID:
			if(ArtifactNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InformationItemEditPartCN.VISUAL_ID:
			if(InformationItemNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SignalEditPartCN.VISUAL_ID:
			if(SignalNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UseCaseEditPartCN.VISUAL_ID:
			if(UseCaseNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPartCN.VISUAL_ID:
			if(CommentBodyEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			if(OperationEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			if(OperationEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			if(PropertyEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			if(ReceptionEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OperationEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			if(ActivityEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			if(EnumerationLiteralEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			if(EnumerationLiteralEditPartCLN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollaborationCompositeCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationRoleEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeviceCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CollaborationCompositeCompartmentEditPart.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationUseEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationRoleEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PropertyPartCompartmentEditPartCN.VISUAL_ID:
			if(PropertyPartEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if(ActivityCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ProtocolStateMachineCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StateMachineCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FunctionBehaviorCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueBehaviorCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ClassClassifierEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CollaborationCompositeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PrimitiveTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InformationItemEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UseCaseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SignalEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CallEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AnyReceiveEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SendSignalEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SendOperationEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ChangeEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CreationEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestructionEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationObservationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeObservationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LiteralBooleanEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LiteralIntegerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LiteralNullEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LiteralStringEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LiteralUnlimitedNaturalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StringExpressionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueExpressionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeExpressionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExpressionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeIntervalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationIntervalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(IntervalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InstanceValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(IntervalConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentRealizationEditPart.VISUAL_ID:
			if(ComponentRealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceRealizationEditPart.VISUAL_ID:
			if(InterfaceRealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceRealizationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubstitutionEditPart.VISUAL_ID:
			if(SubstitutionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SubstitutionAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RealizationEditPart.VISUAL_ID:
			if(RealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RealizationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ManifestationEditPart.VISUAL_ID:
			if(ManifestationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ManifestationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractionEditPart.VISUAL_ID:
			if(AbstractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AbstractionAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case UsageEditPart.VISUAL_ID:
			if(UsageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(UsageAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeploymentEditPart.VISUAL_ID:
			if(DeploymentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RoleBindingEditPart.VISUAL_ID:
			if(RoleBindingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RoleBindingRoleNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(RoleBindingAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
		case ConnectorEditPart.VISUAL_ID:
			if(ConnectorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConnectorMultiplicitySourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConnectorMultiplicityTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConnectorAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationEditPart.VISUAL_ID:
			if(GeneralizationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
		if(UMLPackage.eINSTANCE.getComponentRealization().isSuperTypeOf(domainElement.eClass())



		) {
			return ComponentRealizationEditPart.VISUAL_ID;
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
		if(UMLPackage.eINSTANCE.getManifestation().isSuperTypeOf(domainElement.eClass())



		) {
			return ManifestationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAbstraction().isSuperTypeOf(domainElement.eClass())



		) {
			return AbstractionEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(domainElement.eClass())



		) {
			return UsageEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDeployment().isSuperTypeOf(domainElement.eClass())



		) {
			return DeploymentEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())

		&& isDependency_4017((Dependency)domainElement)

		) {
			return RoleBindingEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())

		&& isDependency_4010((Dependency)domainElement)

		) {
			return DependencyEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getConnector().isSuperTypeOf(domainElement.eClass())



		) {
			return ConnectorEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())



		) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getInformationFlow().isSuperTypeOf(domainElement.eClass())



		) {
			return InformationFlowEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}



	/**
	 * @generated
	 */

	private static boolean isProperty_3070(View containerView, Property domainElement) {

		// Property / CollaborationRole constraint		
		// Restriction for the case where domainElement owner is a Collaboration
		// If the domainElement is not referenced as one of its owner role
		// then it should be considered as a Property creation on Collaboration,
		// else the test should return false and be considered as a representation of
		// a collaboration role (ConnectableElement).
		if(containerView.getElement() instanceof Collaboration) {
			Collaboration graphicalParent = (Collaboration)containerView.getElement();
			if(graphicalParent.getCollaborationRoles().contains(domainElement)) {
				return false;
			}
		}

		// General case : no restriction
		return true;
	}

	/**
	 * @generated
	 */


	private static boolean isDependency_4017(Dependency domainElement) {


		// Test if the dependency is a RoleBinding
		if(domainElement.getOwner() instanceof CollaborationUse) {
			CollaborationUse owner = (CollaborationUse)domainElement.getOwner();
			if(owner.getRoleBindings().contains(domainElement)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */


	private static boolean isDependency_4010(Dependency domainElement) {


		// Test if the dependency is not a RoleBinding
		if(domainElement.getOwner() instanceof CollaborationUse) {
			CollaborationUse owner = (CollaborationUse)domainElement.getOwner();
			if(owner.getRoleBindings().contains(domainElement)) {
				return false;
			}
		}
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

		viewInfo = new BaseViewInfo(2060, ViewInfo.Node, "Activity");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2061, ViewInfo.Node, "Interaction");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2062, ViewInfo.Node, "ProtocolStateMachine");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2063, ViewInfo.Node, "StateMachine");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2064, ViewInfo.Node, "FunctionBehavior");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2065, ViewInfo.Node, "OpaqueBehavior");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2069, ViewInfo.Node, "Component");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2070, ViewInfo.Node, "Device");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2071, ViewInfo.Node, "ExecutionEnvironment");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2072, ViewInfo.Node, "Node");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2073, ViewInfo.Node, "Class");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2074, ViewInfo.Node, "Class");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2075, ViewInfo.Node, "Collaboration");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2076, ViewInfo.Node, "Interface");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2066, ViewInfo.Node, "PrimitiveType");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2067, ViewInfo.Node, "Enumeration");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2068, ViewInfo.Node, "DataType");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2077, ViewInfo.Node, "Actor");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2078, ViewInfo.Node, "DeploymentSpecification");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2079, ViewInfo.Node, "Artifact");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2080, ViewInfo.Node, "InformationItem");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2081, ViewInfo.Node, "Signal");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2082, ViewInfo.Node, "UseCase");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2083, ViewInfo.Node, "SignalEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2084, ViewInfo.Node, "CallEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2085, ViewInfo.Node, "AnyReceiveEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2086, ViewInfo.Node, "SendSignalEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2087, ViewInfo.Node, "SendOperationEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2088, ViewInfo.Node, "ChangeEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2089, ViewInfo.Node, "TimeEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2090, ViewInfo.Node, "CreationEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2091, ViewInfo.Node, "DestructionEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2092, ViewInfo.Node, "ExecutionEvent");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2093, ViewInfo.Node, "DurationObservation");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2094, ViewInfo.Node, "TimeObservation");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2095, ViewInfo.Node, "LiteralBoolean");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2096, ViewInfo.Node, "LiteralInteger");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2097, ViewInfo.Node, "LiteralNull");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2098, ViewInfo.Node, "LiteralString");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2099, ViewInfo.Node, "LiteralUnlimitedNatural");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2100, ViewInfo.Node, "StringExpression");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2101, ViewInfo.Node, "OpaqueExpression");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2102, ViewInfo.Node, "TimeExpression");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2103, ViewInfo.Node, "Expression");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2104, ViewInfo.Node, "Duration");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2105, ViewInfo.Node, "TimeInterval");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2106, ViewInfo.Node, "DurationInterval");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2107, ViewInfo.Node, "Interval");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2108, ViewInfo.Node, "InstanceValue");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2109, ViewInfo.Node, "Comment");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2110, ViewInfo.Node, "DurationConstraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2111, ViewInfo.Node, "TimeConstraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2112, ViewInfo.Node, "IntervalConstraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2113, ViewInfo.Node, "InteractionConstraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2114, ViewInfo.Node, "Constraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4001, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4002, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4003, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4004, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6015, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4005, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6002, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6016, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4011, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6003, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6017, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4006, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6004, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6018, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4012, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6005, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6019, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4007, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6006, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6020, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4008, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6007, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6021, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4009, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6008, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6022, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4017, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6026, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6027, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6028, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4010, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6009, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6023, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4013, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6010, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6012, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6014, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6025, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4015, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6024, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4016, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4018, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4019, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(3069, ViewInfo.Node, "Port");

		root.addNode(2073, viewInfo);

		root.addNode(3085, viewInfo);

		root.addNode(3070, viewInfo);

		root.addNode(3072, viewInfo);

		root.addNode(2060, viewInfo);

		root.addNode(3073, viewInfo);

		root.addNode(3074, viewInfo);

		root.addNode(3075, viewInfo);

		root.addNode(3076, viewInfo);

		root.addNode(3077, viewInfo);

		root.addNode(2061, viewInfo);

		root.addNode(2062, viewInfo);

		root.addNode(2063, viewInfo);

		root.addNode(2064, viewInfo);

		root.addNode(2065, viewInfo);

		root.addNode(3081, viewInfo);

		root.addNode(3082, viewInfo);

		root.addNode(3083, viewInfo);

		root.addNode(3084, viewInfo);

		root.addNode(2072, viewInfo);

		root.addNode(2071, viewInfo);

		root.addNode(2070, viewInfo);

		root.addNode(2069, viewInfo);


		viewInfo = new BaseViewInfo(3070, ViewInfo.Node, "Property");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7061, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);

		root.addNode(7075, viewInfo);

		root.addNode(7077, viewInfo);


		viewInfo = new BaseViewInfo(3115, ViewInfo.Node, "ConnectableElement");

		root.addNode(7061, viewInfo);

		root.addNode(7075, viewInfo);


		viewInfo = new BaseViewInfo(3071, ViewInfo.Node, "CollaborationUse");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7061, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);

		root.addNode(7075, viewInfo);


		viewInfo = new BaseViewInfo(3072, ViewInfo.Node, "Activity");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3073, ViewInfo.Node, "Interaction");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3074, ViewInfo.Node, "ProtocolStateMachine");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3075, ViewInfo.Node, "StateMachine");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3076, ViewInfo.Node, "FunctionBehavior");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3077, ViewInfo.Node, "OpaqueBehavior");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3081, ViewInfo.Node, "Component");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3082, ViewInfo.Node, "Device");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3083, ViewInfo.Node, "ExecutionEnvironment");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3084, ViewInfo.Node, "Node");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3085, ViewInfo.Node, "Class");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3086, ViewInfo.Node, "Collaboration");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3087, ViewInfo.Node, "Interface");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3078, ViewInfo.Node, "PrimitiveType");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3079, ViewInfo.Node, "Enumeration");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3080, ViewInfo.Node, "DataType");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3091, ViewInfo.Node, "Actor");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3092, ViewInfo.Node, "DeploymentSpecification");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3093, ViewInfo.Node, "Artifact");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3094, ViewInfo.Node, "InformationItem");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3095, ViewInfo.Node, "Signal");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3096, ViewInfo.Node, "UseCase");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);


		viewInfo = new BaseViewInfo(3097, ViewInfo.Node, "Comment");

		root.addNode(7050, viewInfo);

		root.addNode(7051, viewInfo);

		root.addNode(7052, viewInfo);

		root.addNode(7053, viewInfo);

		root.addNode(7054, viewInfo);

		root.addNode(7055, viewInfo);

		root.addNode(7056, viewInfo);

		root.addNode(7057, viewInfo);

		root.addNode(7058, viewInfo);

		root.addNode(7059, viewInfo);

		root.addNode(7060, viewInfo);

		root.addNode(7061, viewInfo);

		root.addNode(7063, viewInfo);

		root.addNode(7064, viewInfo);

		root.addNode(7065, viewInfo);

		root.addNode(7066, viewInfo);

		root.addNode(7067, viewInfo);

		root.addNode(7068, viewInfo);

		root.addNode(7069, viewInfo);

		root.addNode(7070, viewInfo);

		root.addNode(7071, viewInfo);

		root.addNode(7072, viewInfo);

		root.addNode(7073, viewInfo);

		root.addNode(7075, viewInfo);

		root.addNode(7077, viewInfo);


		viewInfo = new BaseViewInfo(3101, ViewInfo.Node, "Property");

		root.addNode(7043, viewInfo);

		root.addNode(7033, viewInfo);

		root.addNode(7036, viewInfo);


		viewInfo = new BaseViewInfo(3102, ViewInfo.Node, "Operation");

		root.addNode(7044, viewInfo);

		root.addNode(7034, viewInfo);

		root.addNode(7037, viewInfo);


		viewInfo = new BaseViewInfo(3100, ViewInfo.Node, "Reception");

		root.addNode(7044, viewInfo);


		viewInfo = new BaseViewInfo(3066, ViewInfo.Node, "EnumerationLiteral");

		root.addNode(2067, viewInfo);

		root.addNode(3079, viewInfo);

		root.addNode(7049, viewInfo);

		root.addNode(7048, viewInfo);


		viewInfo = new BaseViewInfo(3103, ViewInfo.Node, "Activity");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3104, ViewInfo.Node, "Interaction");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3105, ViewInfo.Node, "ProtocolStateMachine");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3106, ViewInfo.Node, "StateMachine");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3107, ViewInfo.Node, "FunctionBehavior");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3108, ViewInfo.Node, "OpaqueBehavior");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3109, ViewInfo.Node, "Collaboration");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3110, ViewInfo.Node, "Interface");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3111, ViewInfo.Node, "Enumeration");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3112, ViewInfo.Node, "PrimitiveType");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3113, ViewInfo.Node, "DataType");

		root.addNode(7045, viewInfo);


		viewInfo = new BaseViewInfo(3114, ViewInfo.Node, "Class");

		root.addNode(7045, viewInfo);

		return root;
	}

}
