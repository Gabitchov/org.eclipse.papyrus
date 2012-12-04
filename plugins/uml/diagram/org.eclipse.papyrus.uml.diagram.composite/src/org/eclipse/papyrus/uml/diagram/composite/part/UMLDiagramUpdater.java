/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.uml.diagram.common.part.ICustomDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.composite.custom.parts.PropertyDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ProtocolStateMachine;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case CompositeStructureDiagramEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		case ActivityCompositeEditPart.VISUAL_ID:
			return getActivity_2060SemanticChildren(view);
		case InteractionCompositeEditPart.VISUAL_ID:
			return getInteraction_2061SemanticChildren(view);
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			return getProtocolStateMachine_2062SemanticChildren(view);
		case StateMachineCompositeEditPart.VISUAL_ID:
			return getStateMachine_2063SemanticChildren(view);
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			return getFunctionBehavior_2064SemanticChildren(view);
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			return getOpaqueBehavior_2065SemanticChildren(view);
		case ComponentCompositeEditPart.VISUAL_ID:
			return getComponent_2069SemanticChildren(view);
		case DeviceCompositeEditPart.VISUAL_ID:
			return getDevice_2070SemanticChildren(view);
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			return getExecutionEnvironment_2071SemanticChildren(view);
		case NodeCompositeEditPart.VISUAL_ID:
			return getNode_2072SemanticChildren(view);
		case ClassCompositeEditPart.VISUAL_ID:
			return getClass_2073SemanticChildren(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2067SemanticChildren(view);
		case PropertyPartEditPartCN.VISUAL_ID:
			return getProperty_3070SemanticChildren(view);
		case ActivityCompositeEditPartCN.VISUAL_ID:
			return getActivity_3072SemanticChildren(view);
		case InteractionCompositeEditPartCN.VISUAL_ID:
			return getInteraction_3073SemanticChildren(view);
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			return getProtocolStateMachine_3074SemanticChildren(view);
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			return getStateMachine_3075SemanticChildren(view);
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			return getFunctionBehavior_3076SemanticChildren(view);
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			return getOpaqueBehavior_3077SemanticChildren(view);
		case ComponentCompositeEditPartCN.VISUAL_ID:
			return getComponent_3081SemanticChildren(view);
		case DeviceCompositeEditPartCN.VISUAL_ID:
			return getDevice_3082SemanticChildren(view);
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_3083SemanticChildren(view);
		case NodeCompositeEditPartCN.VISUAL_ID:
			return getNode_3084SemanticChildren(view);
		case ClassCompositeEditPartCN.VISUAL_ID:
			return getClass_3085SemanticChildren(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3079SemanticChildren(view);
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			return getDataTypeProperties_7033SemanticChildren(view);
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			return getDataTypeOperations_7034SemanticChildren(view);
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			return getDataTypeProperties_7036SemanticChildren(view);
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			return getDataTypeOperations_7037SemanticChildren(view);
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			return getEnumerationLiterals_7048SemanticChildren(view);
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			return getEnumerationLiterals_7049SemanticChildren(view);
		case ActivityCompositeCompartmentEditPartCN.VISUAL_ID:
			return getActivityStructure_7050SemanticChildren(view);
		case InteractionCompositeCompartmentEditPartCN.VISUAL_ID:
			return getInteractionStructure_7051SemanticChildren(view);
		case ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID:
			return getProtocolStateMachineStructure_7052SemanticChildren(view);
		case StateMachineCompositeCompartmentEditPartCN.VISUAL_ID:
			return getStateMachineStructure_7053SemanticChildren(view);
		case FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID:
			return getFunctionBehaviorStructure_7054SemanticChildren(view);
		case OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID:
			return getOpaqueBehaviorStructure_7055SemanticChildren(view);
		case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
			return getComponentStructure_7056SemanticChildren(view);
		case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
			return getDeviceStructure_7057SemanticChildren(view);
		case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
			return getExecutionEnvironmentStructure_7058SemanticChildren(view);
		case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
			return getNodeStructure_7059SemanticChildren(view);
		case ClassCompositeCompartmentEditPartCN.VISUAL_ID:
			return getClassStructure_7060SemanticChildren(view);
		case CollaborationCompositeCompartmentEditPartCN.VISUAL_ID:
			return getCollaborationStructure_7061SemanticChildren(view);
		case ActivityCompositeCompartmentEditPart.VISUAL_ID:
			return getActivityStructure_7063SemanticChildren(view);
		case InteractionCompositeCompartmentEditPart.VISUAL_ID:
			return getInteractionStructure_7064SemanticChildren(view);
		case ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID:
			return getProtocolStateMachineStructure_7065SemanticChildren(view);
		case StateMachineCompositeCompartmentEditPart.VISUAL_ID:
			return getStateMachineStructure_7066SemanticChildren(view);
		case FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID:
			return getFunctionBehaviorStructure_7067SemanticChildren(view);
		case OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID:
			return getOpaqueBehaviorStructure_7068SemanticChildren(view);
		case ComponentCompositeCompartmentEditPart.VISUAL_ID:
			return getComponentStructure_7069SemanticChildren(view);
		case DeviceCompositeCompartmentEditPart.VISUAL_ID:
			return getDeviceStructure_7070SemanticChildren(view);
		case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
			return getExecutionEnvironmentStructure_7071SemanticChildren(view);
		case NodeCompositeCompartmentEditPart.VISUAL_ID:
			return getNodeStructure_7072SemanticChildren(view);
		case ClassCompositeCompartmentEditPart.VISUAL_ID:
			return getClassStructure_7073SemanticChildren(view);
		case CollaborationCompositeCompartmentEditPart.VISUAL_ID:
			return getCollaborationStructure_7075SemanticChildren(view);
		case PropertyPartCompartmentEditPartCN.VISUAL_ID:
			return getPropertyStructure_7077SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackage_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEventEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CallEventEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AnyReceiveEventEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ChangeEventEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeEventEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DurationObservationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeObservationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LiteralBooleanEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LiteralIntegerEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LiteralNullEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LiteralStringEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LiteralUnlimitedNaturalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StringExpressionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueExpressionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeExpressionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpressionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DurationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeIntervalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DurationIntervalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InstanceValueEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getActivity_2060SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInteraction_2061SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interaction modelElement = (Interaction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getProtocolStateMachine_2062SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getStateMachine_2063SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		StateMachine modelElement = (StateMachine)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getFunctionBehavior_2064SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getOpaqueBehavior_2065SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_2069SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDevice_2070SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getExecutionEnvironment_2071SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getNode_2072SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClass_2073SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getEnumeration_2067SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == EnumerationLiteralEditPartCLN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	public static List getProperty_3070SemanticChildren(View view) {
		ICustomDiagramUpdater customUpdater = new PropertyDiagramUpdater();
		return customUpdater.getSemanticChildren(view);
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getActivity_3072SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInteraction_3073SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interaction modelElement = (Interaction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getProtocolStateMachine_3074SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getStateMachine_3075SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		StateMachine modelElement = (StateMachine)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getFunctionBehavior_3076SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getOpaqueBehavior_3077SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_3081SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDevice_3082SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getExecutionEnvironment_3083SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getNode_3084SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClass_3085SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getEnumeration_3079SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == EnumerationLiteralEditPartCLN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataTypeProperties_7033SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		DataType modelElement = (DataType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyEditPartCLN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataTypeOperations_7034SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		DataType modelElement = (DataType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationEditPartCLN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataTypeProperties_7036SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		DataType modelElement = (DataType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyEditPartCLN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataTypeOperations_7037SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		DataType modelElement = (DataType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationEditPartCLN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getEnumerationLiterals_7048SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Enumeration modelElement = (Enumeration)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == EnumerationLiteralEditPartCLN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getEnumerationLiterals_7049SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Enumeration modelElement = (Enumeration)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == EnumerationLiteralEditPartCLN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getActivityStructure_7050SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInteractionStructure_7051SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interaction modelElement = (Interaction)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getProtocolStateMachineStructure_7052SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ProtocolStateMachine modelElement = (ProtocolStateMachine)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getStateMachineStructure_7053SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		StateMachine modelElement = (StateMachine)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getFunctionBehaviorStructure_7054SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		FunctionBehavior modelElement = (FunctionBehavior)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getOpaqueBehaviorStructure_7055SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		OpaqueBehavior modelElement = (OpaqueBehavior)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentStructure_7056SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDeviceStructure_7057SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Device modelElement = (Device)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getExecutionEnvironmentStructure_7058SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ExecutionEnvironment modelElement = (ExecutionEnvironment)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getNodeStructure_7059SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Node modelElement = (Node)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassStructure_7060SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getCollaborationStructure_7061SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Collaboration modelElement = (Collaboration)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getRoles().iterator(); it.hasNext();) {
			ConnectableElement childElement = (ConnectableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationRoleEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getActivityStructure_7063SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInteractionStructure_7064SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interaction modelElement = (Interaction)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getProtocolStateMachineStructure_7065SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ProtocolStateMachine modelElement = (ProtocolStateMachine)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getStateMachineStructure_7066SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		StateMachine modelElement = (StateMachine)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getFunctionBehaviorStructure_7067SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		FunctionBehavior modelElement = (FunctionBehavior)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getOpaqueBehaviorStructure_7068SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		OpaqueBehavior modelElement = (OpaqueBehavior)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentStructure_7069SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDeviceStructure_7070SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Device modelElement = (Device)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getExecutionEnvironmentStructure_7071SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ExecutionEnvironment modelElement = (ExecutionEnvironment)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getNodeStructure_7072SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Node modelElement = (Node)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassStructure_7073SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProtocolStateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StateMachineCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FunctionBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueBehaviorCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CollaborationCompositeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeploymentSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getCollaborationStructure_7075SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Collaboration modelElement = (Collaboration)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyPartEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationUseEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getRoles().iterator(); it.hasNext();) {
			ConnectableElement childElement = (ConnectableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CollaborationRoleEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DurationConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	public static List getPropertyStructure_7077SemanticChildren(View view) {
		ICustomDiagramUpdater customUpdater = new PropertyDiagramUpdater();
		return customUpdater.getSemanticChildren(view);
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case CompositeStructureDiagramEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case ActivityCompositeEditPart.VISUAL_ID:
			return getActivity_2060ContainedLinks(view);
		case InteractionCompositeEditPart.VISUAL_ID:
			return getInteraction_2061ContainedLinks(view);
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			return getProtocolStateMachine_2062ContainedLinks(view);
		case StateMachineCompositeEditPart.VISUAL_ID:
			return getStateMachine_2063ContainedLinks(view);
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			return getFunctionBehavior_2064ContainedLinks(view);
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			return getOpaqueBehavior_2065ContainedLinks(view);
		case ComponentCompositeEditPart.VISUAL_ID:
			return getComponent_2069ContainedLinks(view);
		case DeviceCompositeEditPart.VISUAL_ID:
			return getDevice_2070ContainedLinks(view);
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			return getExecutionEnvironment_2071ContainedLinks(view);
		case NodeCompositeEditPart.VISUAL_ID:
			return getNode_2072ContainedLinks(view);
		case ClassCompositeEditPart.VISUAL_ID:
			return getClass_2073ContainedLinks(view);
		case CollaborationCompositeEditPart.VISUAL_ID:
			return getCollaboration_2075ContainedLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2076ContainedLinks(view);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_2066ContainedLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2067ContainedLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2068ContainedLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2077ContainedLinks(view);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return getDeploymentSpecification_2078ContainedLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_2079ContainedLinks(view);
		case InformationItemEditPart.VISUAL_ID:
			return getInformationItem_2080ContainedLinks(view);
		case SignalEditPart.VISUAL_ID:
			return getSignal_2081ContainedLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2082ContainedLinks(view);
		case SignalEventEditPart.VISUAL_ID:
			return getSignalEvent_2083ContainedLinks(view);
		case CallEventEditPart.VISUAL_ID:
			return getCallEvent_2084ContainedLinks(view);
		case AnyReceiveEventEditPart.VISUAL_ID:
			return getAnyReceiveEvent_2085ContainedLinks(view);
		case ChangeEventEditPart.VISUAL_ID:
			return getChangeEvent_2088ContainedLinks(view);
		case TimeEventEditPart.VISUAL_ID:
			return getTimeEvent_2089ContainedLinks(view);
		case DurationObservationEditPart.VISUAL_ID:
			return getDurationObservation_2093ContainedLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_2094ContainedLinks(view);
		case LiteralBooleanEditPart.VISUAL_ID:
			return getLiteralBoolean_2095ContainedLinks(view);
		case LiteralIntegerEditPart.VISUAL_ID:
			return getLiteralInteger_2096ContainedLinks(view);
		case LiteralNullEditPart.VISUAL_ID:
			return getLiteralNull_2097ContainedLinks(view);
		case LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_2098ContainedLinks(view);
		case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
			return getLiteralUnlimitedNatural_2099ContainedLinks(view);
		case StringExpressionEditPart.VISUAL_ID:
			return getStringExpression_2100ContainedLinks(view);
		case OpaqueExpressionEditPart.VISUAL_ID:
			return getOpaqueExpression_2101ContainedLinks(view);
		case TimeExpressionEditPart.VISUAL_ID:
			return getTimeExpression_2102ContainedLinks(view);
		case ExpressionEditPart.VISUAL_ID:
			return getExpression_2103ContainedLinks(view);
		case DurationEditPart.VISUAL_ID:
			return getDuration_2104ContainedLinks(view);
		case TimeIntervalEditPart.VISUAL_ID:
			return getTimeInterval_2105ContainedLinks(view);
		case DurationIntervalEditPart.VISUAL_ID:
			return getDurationInterval_2106ContainedLinks(view);
		case IntervalEditPart.VISUAL_ID:
			return getInterval_2107ContainedLinks(view);
		case InstanceValueEditPart.VISUAL_ID:
			return getInstanceValue_2108ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2109ContainedLinks(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return getDurationConstraint_2110ContainedLinks(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return getTimeConstraint_2111ContainedLinks(view);
		case IntervalConstraintEditPart.VISUAL_ID:
			return getIntervalConstraint_2112ContainedLinks(view);
		case InteractionConstraintEditPart.VISUAL_ID:
			return getInteractionConstraint_2113ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2114ContainedLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069ContainedLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3088ContainedLinks(view);
		case PropertyPartEditPartCN.VISUAL_ID:
			return getProperty_3070ContainedLinks(view);
		case CollaborationRoleEditPartCN.VISUAL_ID:
			return getConnectableElement_3115ContainedLinks(view);
		case CollaborationUseEditPartCN.VISUAL_ID:
			return getCollaborationUse_3071ContainedLinks(view);
		case ActivityCompositeEditPartCN.VISUAL_ID:
			return getActivity_3072ContainedLinks(view);
		case InteractionCompositeEditPartCN.VISUAL_ID:
			return getInteraction_3073ContainedLinks(view);
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			return getProtocolStateMachine_3074ContainedLinks(view);
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			return getStateMachine_3075ContainedLinks(view);
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			return getFunctionBehavior_3076ContainedLinks(view);
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			return getOpaqueBehavior_3077ContainedLinks(view);
		case ComponentCompositeEditPartCN.VISUAL_ID:
			return getComponent_3081ContainedLinks(view);
		case DeviceCompositeEditPartCN.VISUAL_ID:
			return getDevice_3082ContainedLinks(view);
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_3083ContainedLinks(view);
		case NodeCompositeEditPartCN.VISUAL_ID:
			return getNode_3084ContainedLinks(view);
		case ClassCompositeEditPartCN.VISUAL_ID:
			return getClass_3085ContainedLinks(view);
		case CollaborationCompositeEditPartCN.VISUAL_ID:
			return getCollaboration_3086ContainedLinks(view);
		case InterfaceEditPartCN.VISUAL_ID:
			return getInterface_3087ContainedLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3078ContainedLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3079ContainedLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3080ContainedLinks(view);
		case ActorEditPartCN.VISUAL_ID:
			return getActor_3091ContainedLinks(view);
		case DeploymentSpecificationEditPartCN.VISUAL_ID:
			return getDeploymentSpecification_3092ContainedLinks(view);
		case ArtifactEditPartCN.VISUAL_ID:
			return getArtifact_3093ContainedLinks(view);
		case InformationItemEditPartCN.VISUAL_ID:
			return getInformationItem_3094ContainedLinks(view);
		case SignalEditPartCN.VISUAL_ID:
			return getSignal_3095ContainedLinks(view);
		case UseCaseEditPartCN.VISUAL_ID:
			return getUseCase_3096ContainedLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3097ContainedLinks(view);
		case DurationConstraintEditPartCN.VISUAL_ID:
			return getDurationConstraint_3116ContainedLinks(view);
		case TimeConstraintEditPartCN.VISUAL_ID:
			return getTimeConstraint_3117ContainedLinks(view);
		case IntervalConstraintEditPartCN.VISUAL_ID:
			return getIntervalConstraint_3118ContainedLinks(view);
		case InteractionConstraintEditPartCN.VISUAL_ID:
			return getInteractionConstraint_3119ContainedLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3120ContainedLinks(view);
		case PropertyEditPartCLN.VISUAL_ID:
			return getProperty_3101ContainedLinks(view);
		case OperationEditPartCLN.VISUAL_ID:
			return getOperation_3102ContainedLinks(view);
		case ReceptionEditPartCLN.VISUAL_ID:
			return getReception_3100ContainedLinks(view);
		case EnumerationLiteralEditPartCLN.VISUAL_ID:
			return getEnumerationLiteral_3066ContainedLinks(view);
		case ActivityEditPartCLN.VISUAL_ID:
			return getActivity_3103ContainedLinks(view);
		case InteractionEditPartCLN.VISUAL_ID:
			return getInteraction_3104ContainedLinks(view);
		case ProtocolStateMachineEditPartCLN.VISUAL_ID:
			return getProtocolStateMachine_3105ContainedLinks(view);
		case StateMachineEditPartCLN.VISUAL_ID:
			return getStateMachine_3106ContainedLinks(view);
		case FunctionBehaviorEditPartCLN.VISUAL_ID:
			return getFunctionBehavior_3107ContainedLinks(view);
		case OpaqueBehaviorEditPartCLN.VISUAL_ID:
			return getOpaqueBehavior_3108ContainedLinks(view);
		case CollaborationEditPartCLN.VISUAL_ID:
			return getCollaboration_3109ContainedLinks(view);
		case InterfaceEditPartCLN.VISUAL_ID:
			return getInterface_3110ContainedLinks(view);
		case EnumerationEditPartCLN.VISUAL_ID:
			return getEnumeration_3111ContainedLinks(view);
		case PrimitiveTypeEditPartCLN.VISUAL_ID:
			return getPrimitiveType_3112ContainedLinks(view);
		case DataTypeEditPartCLN.VISUAL_ID:
			return getDataType_3113ContainedLinks(view);
		case ClassEditPartCLN.VISUAL_ID:
			return getClass_3114ContainedLinks(view);
		case ComponentRealizationEditPart.VISUAL_ID:
			return getComponentRealization_4004ContainedLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4005ContainedLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4011ContainedLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4006ContainedLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4012ContainedLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4007ContainedLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4008ContainedLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4009ContainedLinks(view);
		case RoleBindingEditPart.VISUAL_ID:
			return getDependency_4017ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4010ContainedLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4013ContainedLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4015ContainedLinks(view);
		case InformationFlowEditPart.VISUAL_ID:
			return getInformationFlow_4021ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityCompositeEditPart.VISUAL_ID:
			return getActivity_2060IncomingLinks(view);
		case InteractionCompositeEditPart.VISUAL_ID:
			return getInteraction_2061IncomingLinks(view);
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			return getProtocolStateMachine_2062IncomingLinks(view);
		case StateMachineCompositeEditPart.VISUAL_ID:
			return getStateMachine_2063IncomingLinks(view);
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			return getFunctionBehavior_2064IncomingLinks(view);
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			return getOpaqueBehavior_2065IncomingLinks(view);
		case ComponentCompositeEditPart.VISUAL_ID:
			return getComponent_2069IncomingLinks(view);
		case DeviceCompositeEditPart.VISUAL_ID:
			return getDevice_2070IncomingLinks(view);
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			return getExecutionEnvironment_2071IncomingLinks(view);
		case NodeCompositeEditPart.VISUAL_ID:
			return getNode_2072IncomingLinks(view);
		case ClassCompositeEditPart.VISUAL_ID:
			return getClass_2073IncomingLinks(view);
		case CollaborationCompositeEditPart.VISUAL_ID:
			return getCollaboration_2075IncomingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2076IncomingLinks(view);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_2066IncomingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2067IncomingLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2068IncomingLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2077IncomingLinks(view);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return getDeploymentSpecification_2078IncomingLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_2079IncomingLinks(view);
		case InformationItemEditPart.VISUAL_ID:
			return getInformationItem_2080IncomingLinks(view);
		case SignalEditPart.VISUAL_ID:
			return getSignal_2081IncomingLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2082IncomingLinks(view);
		case SignalEventEditPart.VISUAL_ID:
			return getSignalEvent_2083IncomingLinks(view);
		case CallEventEditPart.VISUAL_ID:
			return getCallEvent_2084IncomingLinks(view);
		case AnyReceiveEventEditPart.VISUAL_ID:
			return getAnyReceiveEvent_2085IncomingLinks(view);
		case ChangeEventEditPart.VISUAL_ID:
			return getChangeEvent_2088IncomingLinks(view);
		case TimeEventEditPart.VISUAL_ID:
			return getTimeEvent_2089IncomingLinks(view);
		case DurationObservationEditPart.VISUAL_ID:
			return getDurationObservation_2093IncomingLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_2094IncomingLinks(view);
		case LiteralBooleanEditPart.VISUAL_ID:
			return getLiteralBoolean_2095IncomingLinks(view);
		case LiteralIntegerEditPart.VISUAL_ID:
			return getLiteralInteger_2096IncomingLinks(view);
		case LiteralNullEditPart.VISUAL_ID:
			return getLiteralNull_2097IncomingLinks(view);
		case LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_2098IncomingLinks(view);
		case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
			return getLiteralUnlimitedNatural_2099IncomingLinks(view);
		case StringExpressionEditPart.VISUAL_ID:
			return getStringExpression_2100IncomingLinks(view);
		case OpaqueExpressionEditPart.VISUAL_ID:
			return getOpaqueExpression_2101IncomingLinks(view);
		case TimeExpressionEditPart.VISUAL_ID:
			return getTimeExpression_2102IncomingLinks(view);
		case ExpressionEditPart.VISUAL_ID:
			return getExpression_2103IncomingLinks(view);
		case DurationEditPart.VISUAL_ID:
			return getDuration_2104IncomingLinks(view);
		case TimeIntervalEditPart.VISUAL_ID:
			return getTimeInterval_2105IncomingLinks(view);
		case DurationIntervalEditPart.VISUAL_ID:
			return getDurationInterval_2106IncomingLinks(view);
		case IntervalEditPart.VISUAL_ID:
			return getInterval_2107IncomingLinks(view);
		case InstanceValueEditPart.VISUAL_ID:
			return getInstanceValue_2108IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2109IncomingLinks(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return getDurationConstraint_2110IncomingLinks(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return getTimeConstraint_2111IncomingLinks(view);
		case IntervalConstraintEditPart.VISUAL_ID:
			return getIntervalConstraint_2112IncomingLinks(view);
		case InteractionConstraintEditPart.VISUAL_ID:
			return getInteractionConstraint_2113IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2114IncomingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069IncomingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3088IncomingLinks(view);
		case PropertyPartEditPartCN.VISUAL_ID:
			return getProperty_3070IncomingLinks(view);
		case CollaborationRoleEditPartCN.VISUAL_ID:
			return getConnectableElement_3115IncomingLinks(view);
		case CollaborationUseEditPartCN.VISUAL_ID:
			return getCollaborationUse_3071IncomingLinks(view);
		case ActivityCompositeEditPartCN.VISUAL_ID:
			return getActivity_3072IncomingLinks(view);
		case InteractionCompositeEditPartCN.VISUAL_ID:
			return getInteraction_3073IncomingLinks(view);
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			return getProtocolStateMachine_3074IncomingLinks(view);
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			return getStateMachine_3075IncomingLinks(view);
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			return getFunctionBehavior_3076IncomingLinks(view);
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			return getOpaqueBehavior_3077IncomingLinks(view);
		case ComponentCompositeEditPartCN.VISUAL_ID:
			return getComponent_3081IncomingLinks(view);
		case DeviceCompositeEditPartCN.VISUAL_ID:
			return getDevice_3082IncomingLinks(view);
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_3083IncomingLinks(view);
		case NodeCompositeEditPartCN.VISUAL_ID:
			return getNode_3084IncomingLinks(view);
		case ClassCompositeEditPartCN.VISUAL_ID:
			return getClass_3085IncomingLinks(view);
		case CollaborationCompositeEditPartCN.VISUAL_ID:
			return getCollaboration_3086IncomingLinks(view);
		case InterfaceEditPartCN.VISUAL_ID:
			return getInterface_3087IncomingLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3078IncomingLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3079IncomingLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3080IncomingLinks(view);
		case ActorEditPartCN.VISUAL_ID:
			return getActor_3091IncomingLinks(view);
		case DeploymentSpecificationEditPartCN.VISUAL_ID:
			return getDeploymentSpecification_3092IncomingLinks(view);
		case ArtifactEditPartCN.VISUAL_ID:
			return getArtifact_3093IncomingLinks(view);
		case InformationItemEditPartCN.VISUAL_ID:
			return getInformationItem_3094IncomingLinks(view);
		case SignalEditPartCN.VISUAL_ID:
			return getSignal_3095IncomingLinks(view);
		case UseCaseEditPartCN.VISUAL_ID:
			return getUseCase_3096IncomingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3097IncomingLinks(view);
		case DurationConstraintEditPartCN.VISUAL_ID:
			return getDurationConstraint_3116IncomingLinks(view);
		case TimeConstraintEditPartCN.VISUAL_ID:
			return getTimeConstraint_3117IncomingLinks(view);
		case IntervalConstraintEditPartCN.VISUAL_ID:
			return getIntervalConstraint_3118IncomingLinks(view);
		case InteractionConstraintEditPartCN.VISUAL_ID:
			return getInteractionConstraint_3119IncomingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3120IncomingLinks(view);
		case PropertyEditPartCLN.VISUAL_ID:
			return getProperty_3101IncomingLinks(view);
		case OperationEditPartCLN.VISUAL_ID:
			return getOperation_3102IncomingLinks(view);
		case ReceptionEditPartCLN.VISUAL_ID:
			return getReception_3100IncomingLinks(view);
		case EnumerationLiteralEditPartCLN.VISUAL_ID:
			return getEnumerationLiteral_3066IncomingLinks(view);
		case ActivityEditPartCLN.VISUAL_ID:
			return getActivity_3103IncomingLinks(view);
		case InteractionEditPartCLN.VISUAL_ID:
			return getInteraction_3104IncomingLinks(view);
		case ProtocolStateMachineEditPartCLN.VISUAL_ID:
			return getProtocolStateMachine_3105IncomingLinks(view);
		case StateMachineEditPartCLN.VISUAL_ID:
			return getStateMachine_3106IncomingLinks(view);
		case FunctionBehaviorEditPartCLN.VISUAL_ID:
			return getFunctionBehavior_3107IncomingLinks(view);
		case OpaqueBehaviorEditPartCLN.VISUAL_ID:
			return getOpaqueBehavior_3108IncomingLinks(view);
		case CollaborationEditPartCLN.VISUAL_ID:
			return getCollaboration_3109IncomingLinks(view);
		case InterfaceEditPartCLN.VISUAL_ID:
			return getInterface_3110IncomingLinks(view);
		case EnumerationEditPartCLN.VISUAL_ID:
			return getEnumeration_3111IncomingLinks(view);
		case PrimitiveTypeEditPartCLN.VISUAL_ID:
			return getPrimitiveType_3112IncomingLinks(view);
		case DataTypeEditPartCLN.VISUAL_ID:
			return getDataType_3113IncomingLinks(view);
		case ClassEditPartCLN.VISUAL_ID:
			return getClass_3114IncomingLinks(view);
		case ComponentRealizationEditPart.VISUAL_ID:
			return getComponentRealization_4004IncomingLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4005IncomingLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4011IncomingLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4006IncomingLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4012IncomingLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4007IncomingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4008IncomingLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4009IncomingLinks(view);
		case RoleBindingEditPart.VISUAL_ID:
			return getDependency_4017IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4010IncomingLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4013IncomingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4015IncomingLinks(view);
		case InformationFlowEditPart.VISUAL_ID:
			return getInformationFlow_4021IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityCompositeEditPart.VISUAL_ID:
			return getActivity_2060OutgoingLinks(view);
		case InteractionCompositeEditPart.VISUAL_ID:
			return getInteraction_2061OutgoingLinks(view);
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			return getProtocolStateMachine_2062OutgoingLinks(view);
		case StateMachineCompositeEditPart.VISUAL_ID:
			return getStateMachine_2063OutgoingLinks(view);
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			return getFunctionBehavior_2064OutgoingLinks(view);
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			return getOpaqueBehavior_2065OutgoingLinks(view);
		case ComponentCompositeEditPart.VISUAL_ID:
			return getComponent_2069OutgoingLinks(view);
		case DeviceCompositeEditPart.VISUAL_ID:
			return getDevice_2070OutgoingLinks(view);
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			return getExecutionEnvironment_2071OutgoingLinks(view);
		case NodeCompositeEditPart.VISUAL_ID:
			return getNode_2072OutgoingLinks(view);
		case ClassCompositeEditPart.VISUAL_ID:
			return getClass_2073OutgoingLinks(view);
		case CollaborationCompositeEditPart.VISUAL_ID:
			return getCollaboration_2075OutgoingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2076OutgoingLinks(view);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_2066OutgoingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2067OutgoingLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2068OutgoingLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2077OutgoingLinks(view);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return getDeploymentSpecification_2078OutgoingLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_2079OutgoingLinks(view);
		case InformationItemEditPart.VISUAL_ID:
			return getInformationItem_2080OutgoingLinks(view);
		case SignalEditPart.VISUAL_ID:
			return getSignal_2081OutgoingLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2082OutgoingLinks(view);
		case SignalEventEditPart.VISUAL_ID:
			return getSignalEvent_2083OutgoingLinks(view);
		case CallEventEditPart.VISUAL_ID:
			return getCallEvent_2084OutgoingLinks(view);
		case AnyReceiveEventEditPart.VISUAL_ID:
			return getAnyReceiveEvent_2085OutgoingLinks(view);
		case ChangeEventEditPart.VISUAL_ID:
			return getChangeEvent_2088OutgoingLinks(view);
		case TimeEventEditPart.VISUAL_ID:
			return getTimeEvent_2089OutgoingLinks(view);
		case DurationObservationEditPart.VISUAL_ID:
			return getDurationObservation_2093OutgoingLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_2094OutgoingLinks(view);
		case LiteralBooleanEditPart.VISUAL_ID:
			return getLiteralBoolean_2095OutgoingLinks(view);
		case LiteralIntegerEditPart.VISUAL_ID:
			return getLiteralInteger_2096OutgoingLinks(view);
		case LiteralNullEditPart.VISUAL_ID:
			return getLiteralNull_2097OutgoingLinks(view);
		case LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_2098OutgoingLinks(view);
		case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
			return getLiteralUnlimitedNatural_2099OutgoingLinks(view);
		case StringExpressionEditPart.VISUAL_ID:
			return getStringExpression_2100OutgoingLinks(view);
		case OpaqueExpressionEditPart.VISUAL_ID:
			return getOpaqueExpression_2101OutgoingLinks(view);
		case TimeExpressionEditPart.VISUAL_ID:
			return getTimeExpression_2102OutgoingLinks(view);
		case ExpressionEditPart.VISUAL_ID:
			return getExpression_2103OutgoingLinks(view);
		case DurationEditPart.VISUAL_ID:
			return getDuration_2104OutgoingLinks(view);
		case TimeIntervalEditPart.VISUAL_ID:
			return getTimeInterval_2105OutgoingLinks(view);
		case DurationIntervalEditPart.VISUAL_ID:
			return getDurationInterval_2106OutgoingLinks(view);
		case IntervalEditPart.VISUAL_ID:
			return getInterval_2107OutgoingLinks(view);
		case InstanceValueEditPart.VISUAL_ID:
			return getInstanceValue_2108OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2109OutgoingLinks(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return getDurationConstraint_2110OutgoingLinks(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return getTimeConstraint_2111OutgoingLinks(view);
		case IntervalConstraintEditPart.VISUAL_ID:
			return getIntervalConstraint_2112OutgoingLinks(view);
		case InteractionConstraintEditPart.VISUAL_ID:
			return getInteractionConstraint_2113OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2114OutgoingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069OutgoingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3088OutgoingLinks(view);
		case PropertyPartEditPartCN.VISUAL_ID:
			return getProperty_3070OutgoingLinks(view);
		case CollaborationRoleEditPartCN.VISUAL_ID:
			return getConnectableElement_3115OutgoingLinks(view);
		case CollaborationUseEditPartCN.VISUAL_ID:
			return getCollaborationUse_3071OutgoingLinks(view);
		case ActivityCompositeEditPartCN.VISUAL_ID:
			return getActivity_3072OutgoingLinks(view);
		case InteractionCompositeEditPartCN.VISUAL_ID:
			return getInteraction_3073OutgoingLinks(view);
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			return getProtocolStateMachine_3074OutgoingLinks(view);
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			return getStateMachine_3075OutgoingLinks(view);
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			return getFunctionBehavior_3076OutgoingLinks(view);
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			return getOpaqueBehavior_3077OutgoingLinks(view);
		case ComponentCompositeEditPartCN.VISUAL_ID:
			return getComponent_3081OutgoingLinks(view);
		case DeviceCompositeEditPartCN.VISUAL_ID:
			return getDevice_3082OutgoingLinks(view);
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_3083OutgoingLinks(view);
		case NodeCompositeEditPartCN.VISUAL_ID:
			return getNode_3084OutgoingLinks(view);
		case ClassCompositeEditPartCN.VISUAL_ID:
			return getClass_3085OutgoingLinks(view);
		case CollaborationCompositeEditPartCN.VISUAL_ID:
			return getCollaboration_3086OutgoingLinks(view);
		case InterfaceEditPartCN.VISUAL_ID:
			return getInterface_3087OutgoingLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3078OutgoingLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3079OutgoingLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3080OutgoingLinks(view);
		case ActorEditPartCN.VISUAL_ID:
			return getActor_3091OutgoingLinks(view);
		case DeploymentSpecificationEditPartCN.VISUAL_ID:
			return getDeploymentSpecification_3092OutgoingLinks(view);
		case ArtifactEditPartCN.VISUAL_ID:
			return getArtifact_3093OutgoingLinks(view);
		case InformationItemEditPartCN.VISUAL_ID:
			return getInformationItem_3094OutgoingLinks(view);
		case SignalEditPartCN.VISUAL_ID:
			return getSignal_3095OutgoingLinks(view);
		case UseCaseEditPartCN.VISUAL_ID:
			return getUseCase_3096OutgoingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3097OutgoingLinks(view);
		case DurationConstraintEditPartCN.VISUAL_ID:
			return getDurationConstraint_3116OutgoingLinks(view);
		case TimeConstraintEditPartCN.VISUAL_ID:
			return getTimeConstraint_3117OutgoingLinks(view);
		case IntervalConstraintEditPartCN.VISUAL_ID:
			return getIntervalConstraint_3118OutgoingLinks(view);
		case InteractionConstraintEditPartCN.VISUAL_ID:
			return getInteractionConstraint_3119OutgoingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3120OutgoingLinks(view);
		case PropertyEditPartCLN.VISUAL_ID:
			return getProperty_3101OutgoingLinks(view);
		case OperationEditPartCLN.VISUAL_ID:
			return getOperation_3102OutgoingLinks(view);
		case ReceptionEditPartCLN.VISUAL_ID:
			return getReception_3100OutgoingLinks(view);
		case EnumerationLiteralEditPartCLN.VISUAL_ID:
			return getEnumerationLiteral_3066OutgoingLinks(view);
		case ActivityEditPartCLN.VISUAL_ID:
			return getActivity_3103OutgoingLinks(view);
		case InteractionEditPartCLN.VISUAL_ID:
			return getInteraction_3104OutgoingLinks(view);
		case ProtocolStateMachineEditPartCLN.VISUAL_ID:
			return getProtocolStateMachine_3105OutgoingLinks(view);
		case StateMachineEditPartCLN.VISUAL_ID:
			return getStateMachine_3106OutgoingLinks(view);
		case FunctionBehaviorEditPartCLN.VISUAL_ID:
			return getFunctionBehavior_3107OutgoingLinks(view);
		case OpaqueBehaviorEditPartCLN.VISUAL_ID:
			return getOpaqueBehavior_3108OutgoingLinks(view);
		case CollaborationEditPartCLN.VISUAL_ID:
			return getCollaboration_3109OutgoingLinks(view);
		case InterfaceEditPartCLN.VISUAL_ID:
			return getInterface_3110OutgoingLinks(view);
		case EnumerationEditPartCLN.VISUAL_ID:
			return getEnumeration_3111OutgoingLinks(view);
		case PrimitiveTypeEditPartCLN.VISUAL_ID:
			return getPrimitiveType_3112OutgoingLinks(view);
		case DataTypeEditPartCLN.VISUAL_ID:
			return getDataType_3113OutgoingLinks(view);
		case ClassEditPartCLN.VISUAL_ID:
			return getClass_3114OutgoingLinks(view);
		case ComponentRealizationEditPart.VISUAL_ID:
			return getComponentRealization_4004OutgoingLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4005OutgoingLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4011OutgoingLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4006OutgoingLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4012OutgoingLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4007OutgoingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4008OutgoingLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4009OutgoingLinks(view);
		case RoleBindingEditPart.VISUAL_ID:
			return getDependency_4017OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4010OutgoingLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4013OutgoingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4015OutgoingLinks(view);
		case InformationFlowEditPart.VISUAL_ID:
			return getInformationFlow_4021OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_2060ContainedLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_2061ContainedLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_2062ContainedLinks(View view) {
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_2063ContainedLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_2064ContainedLinks(View view) {
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_2065ContainedLinks(View view) {
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2069ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_2070ContainedLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_2071ContainedLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_2072ContainedLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_2073ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_2075ContainedLinks(View view) {
		Collaboration modelElement = (Collaboration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2076ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_2066ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_2067ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_2068ContainedLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_2077ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeploymentSpecification_2078ContainedLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_2079ContainedLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_2080ContainedLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_2081ContainedLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_2082ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignalEvent_2083ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallEvent_2084ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAnyReceiveEvent_2085ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getChangeEvent_2088ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeEvent_2089ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationObservation_2093ContainedLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeObservation_2094ContainedLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralBoolean_2095ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralInteger_2096ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralNull_2097ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralString_2098ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralUnlimitedNatural_2099ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStringExpression_2100ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueExpression_2101ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeExpression_2102ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpression_2103ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDuration_2104ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeInterval_2105ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationInterval_2106ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterval_2107ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceValue_2108ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2109ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_2110ContainedLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_2111ContainedLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_2112ContainedLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteractionConstraint_2113ContainedLinks(View view) {
		InteractionConstraint modelElement = (InteractionConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2114ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPort_3069ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getParameter_3088ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3070ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnectableElement_3115ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaborationUse_3071ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3072ContainedLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_3073ContainedLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_3074ContainedLinks(View view) {
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_3075ContainedLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_3076ContainedLinks(View view) {
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_3077ContainedLinks(View view) {
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3081ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_3082ContainedLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_3083ContainedLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_3084ContainedLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3085ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_3086ContainedLinks(View view) {
		Collaboration modelElement = (Collaboration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3087ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3078ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3079ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3080ContainedLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_3091ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeploymentSpecification_3092ContainedLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_3093ContainedLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_3094ContainedLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_3095ContainedLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_3096ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3097ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3116ContainedLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3117ContainedLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3118ContainedLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteractionConstraint_3119ContainedLinks(View view) {
		InteractionConstraint modelElement = (InteractionConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3120ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3101ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3102ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3100ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumerationLiteral_3066ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3103ContainedLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_3104ContainedLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_3105ContainedLinks(View view) {
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_3106ContainedLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_3107ContainedLinks(View view) {
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_3108ContainedLinks(View view) {
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_3109ContainedLinks(View view) {
		Collaboration modelElement = (Collaboration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3110ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3111ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3112ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3113ContainedLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3114ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4011ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4012ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeployment_4009ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnector_4013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationFlow_4021ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_2060IncomingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_2061IncomingLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_2062IncomingLinks(View view) {
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_2063IncomingLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_2064IncomingLinks(View view) {
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_2065IncomingLinks(View view) {
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2069IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_2070IncomingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_2071IncomingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_2072IncomingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_2073IncomingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_2075IncomingLinks(View view) {
		Collaboration modelElement = (Collaboration)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2076IncomingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_2066IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_2067IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_2068IncomingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_2077IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeploymentSpecification_2078IncomingLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_2079IncomingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_2080IncomingLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_2081IncomingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_2082IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignalEvent_2083IncomingLinks(View view) {
		SignalEvent modelElement = (SignalEvent)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallEvent_2084IncomingLinks(View view) {
		CallEvent modelElement = (CallEvent)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAnyReceiveEvent_2085IncomingLinks(View view) {
		AnyReceiveEvent modelElement = (AnyReceiveEvent)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getChangeEvent_2088IncomingLinks(View view) {
		ChangeEvent modelElement = (ChangeEvent)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeEvent_2089IncomingLinks(View view) {
		TimeEvent modelElement = (TimeEvent)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationObservation_2093IncomingLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeObservation_2094IncomingLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralBoolean_2095IncomingLinks(View view) {
		LiteralBoolean modelElement = (LiteralBoolean)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralInteger_2096IncomingLinks(View view) {
		LiteralInteger modelElement = (LiteralInteger)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralNull_2097IncomingLinks(View view) {
		LiteralNull modelElement = (LiteralNull)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralString_2098IncomingLinks(View view) {
		LiteralString modelElement = (LiteralString)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralUnlimitedNatural_2099IncomingLinks(View view) {
		LiteralUnlimitedNatural modelElement = (LiteralUnlimitedNatural)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStringExpression_2100IncomingLinks(View view) {
		StringExpression modelElement = (StringExpression)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueExpression_2101IncomingLinks(View view) {
		OpaqueExpression modelElement = (OpaqueExpression)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeExpression_2102IncomingLinks(View view) {
		TimeExpression modelElement = (TimeExpression)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpression_2103IncomingLinks(View view) {
		Expression modelElement = (Expression)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDuration_2104IncomingLinks(View view) {
		Duration modelElement = (Duration)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeInterval_2105IncomingLinks(View view) {
		TimeInterval modelElement = (TimeInterval)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationInterval_2106IncomingLinks(View view) {
		DurationInterval modelElement = (DurationInterval)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterval_2107IncomingLinks(View view) {
		Interval modelElement = (Interval)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceValue_2108IncomingLinks(View view) {
		InstanceValue modelElement = (InstanceValue)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2109IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_2110IncomingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_2111IncomingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_2112IncomingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteractionConstraint_2113IncomingLinks(View view) {
		InteractionConstraint modelElement = (InteractionConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2114IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPort_3069IncomingLinks(View view) {
		Port modelElement = (Port)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getParameter_3088IncomingLinks(View view) {
		Parameter modelElement = (Parameter)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3070IncomingLinks(View view) {
		Property modelElement = (Property)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnectableElement_3115IncomingLinks(View view) {
		ConnectableElement modelElement = (ConnectableElement)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaborationUse_3071IncomingLinks(View view) {
		CollaborationUse modelElement = (CollaborationUse)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3072IncomingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_3073IncomingLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_3074IncomingLinks(View view) {
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_3075IncomingLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_3076IncomingLinks(View view) {
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_3077IncomingLinks(View view) {
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3081IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_3082IncomingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_3083IncomingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_3084IncomingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3085IncomingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_3086IncomingLinks(View view) {
		Collaboration modelElement = (Collaboration)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3087IncomingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3078IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3079IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3080IncomingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_3091IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeploymentSpecification_3092IncomingLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_3093IncomingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_3094IncomingLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_3095IncomingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_3096IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3097IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3116IncomingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3117IncomingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3118IncomingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteractionConstraint_3119IncomingLinks(View view) {
		InteractionConstraint modelElement = (InteractionConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3120IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3101IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3102IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3100IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumerationLiteral_3066IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3103IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_3104IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_3105IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_3106IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_3107IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_3108IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_3109IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3110IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3111IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3112IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3113IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3114IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4004IncomingLinks(View view) {
		ComponentRealization modelElement = (ComponentRealization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4005IncomingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4011IncomingLinks(View view) {
		Substitution modelElement = (Substitution)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4006IncomingLinks(View view) {
		Realization modelElement = (Realization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4012IncomingLinks(View view) {
		Manifestation modelElement = (Manifestation)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4007IncomingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4008IncomingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeployment_4009IncomingLinks(View view) {
		Deployment modelElement = (Deployment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4017IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnector_4013IncomingLinks(View view) {
		Connector modelElement = (Connector)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4015IncomingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationFlow_4021IncomingLinks(View view) {
		InformationFlow modelElement = (InformationFlow)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4021(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_2060OutgoingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_2061OutgoingLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_2062OutgoingLinks(View view) {
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_2063OutgoingLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_2064OutgoingLinks(View view) {
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_2065OutgoingLinks(View view) {
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2069OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_2070OutgoingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_2071OutgoingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_2072OutgoingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_2073OutgoingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_2075OutgoingLinks(View view) {
		Collaboration modelElement = (Collaboration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2076OutgoingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_2066OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_2067OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_2068OutgoingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_2077OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeploymentSpecification_2078OutgoingLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_2079OutgoingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_2080OutgoingLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_2081OutgoingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_2082OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignalEvent_2083OutgoingLinks(View view) {
		SignalEvent modelElement = (SignalEvent)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallEvent_2084OutgoingLinks(View view) {
		CallEvent modelElement = (CallEvent)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAnyReceiveEvent_2085OutgoingLinks(View view) {
		AnyReceiveEvent modelElement = (AnyReceiveEvent)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getChangeEvent_2088OutgoingLinks(View view) {
		ChangeEvent modelElement = (ChangeEvent)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeEvent_2089OutgoingLinks(View view) {
		TimeEvent modelElement = (TimeEvent)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationObservation_2093OutgoingLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4019(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeObservation_2094OutgoingLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralBoolean_2095OutgoingLinks(View view) {
		LiteralBoolean modelElement = (LiteralBoolean)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralInteger_2096OutgoingLinks(View view) {
		LiteralInteger modelElement = (LiteralInteger)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralNull_2097OutgoingLinks(View view) {
		LiteralNull modelElement = (LiteralNull)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralString_2098OutgoingLinks(View view) {
		LiteralString modelElement = (LiteralString)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLiteralUnlimitedNatural_2099OutgoingLinks(View view) {
		LiteralUnlimitedNatural modelElement = (LiteralUnlimitedNatural)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStringExpression_2100OutgoingLinks(View view) {
		StringExpression modelElement = (StringExpression)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueExpression_2101OutgoingLinks(View view) {
		OpaqueExpression modelElement = (OpaqueExpression)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeExpression_2102OutgoingLinks(View view) {
		TimeExpression modelElement = (TimeExpression)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpression_2103OutgoingLinks(View view) {
		Expression modelElement = (Expression)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDuration_2104OutgoingLinks(View view) {
		Duration modelElement = (Duration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeInterval_2105OutgoingLinks(View view) {
		TimeInterval modelElement = (TimeInterval)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationInterval_2106OutgoingLinks(View view) {
		DurationInterval modelElement = (DurationInterval)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterval_2107OutgoingLinks(View view) {
		Interval modelElement = (Interval)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceValue_2108OutgoingLinks(View view) {
		InstanceValue modelElement = (InstanceValue)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2109OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_2110OutgoingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_2111OutgoingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_2112OutgoingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteractionConstraint_2113OutgoingLinks(View view) {
		InteractionConstraint modelElement = (InteractionConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2114OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPort_3069OutgoingLinks(View view) {
		Port modelElement = (Port)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getParameter_3088OutgoingLinks(View view) {
		Parameter modelElement = (Parameter)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3070OutgoingLinks(View view) {
		Property modelElement = (Property)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnectableElement_3115OutgoingLinks(View view) {
		ConnectableElement modelElement = (ConnectableElement)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaborationUse_3071OutgoingLinks(View view) {
		CollaborationUse modelElement = (CollaborationUse)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3072OutgoingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_3073OutgoingLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_3074OutgoingLinks(View view) {
		ProtocolStateMachine modelElement = (ProtocolStateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_3075OutgoingLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_3076OutgoingLinks(View view) {
		FunctionBehavior modelElement = (FunctionBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_3077OutgoingLinks(View view) {
		OpaqueBehavior modelElement = (OpaqueBehavior)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3081OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_3082OutgoingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_3083OutgoingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_3084OutgoingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3085OutgoingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_3086OutgoingLinks(View view) {
		Collaboration modelElement = (Collaboration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3087OutgoingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3078OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3079OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3080OutgoingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_3091OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeploymentSpecification_3092OutgoingLinks(View view) {
		DeploymentSpecification modelElement = (DeploymentSpecification)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_3093OutgoingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_3094OutgoingLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_InformationItem_Represented_4020(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_3095OutgoingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_3096OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3097OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3116OutgoingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3117OutgoingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3118OutgoingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteractionConstraint_3119OutgoingLinks(View view) {
		InteractionConstraint modelElement = (InteractionConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3120OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3101OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3102OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3100OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumerationLiteral_3066OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3103OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInteraction_3104OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProtocolStateMachine_3105OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStateMachine_3106OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFunctionBehavior_3107OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueBehavior_3108OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCollaboration_3109OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3110OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3111OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3112OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3113OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3114OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4004OutgoingLinks(View view) {
		ComponentRealization modelElement = (ComponentRealization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4005OutgoingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4011OutgoingLinks(View view) {
		Substitution modelElement = (Substitution)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4006OutgoingLinks(View view) {
		Realization modelElement = (Realization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4012OutgoingLinks(View view) {
		Manifestation modelElement = (Manifestation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4007OutgoingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4008OutgoingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeployment_4009OutgoingLinks(View view) {
		Deployment modelElement = (Deployment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4017OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnector_4013OutgoingLinks(View view) {
		Connector modelElement = (Connector)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationFlow_4021OutgoingLinks(View view) {
		InformationFlow modelElement = (InformationFlow)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_ComponentRealization_4004(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization)linkObject;
			if(ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ComponentRealization_4004, ComponentRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InterfaceRealization_4005(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)linkObject;
			if(InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InterfaceRealization_4005, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Substitution_4011(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)linkObject;
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Substitution_4011, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Realization_4006(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Realization) {
				continue;
			}
			Realization link = (Realization)linkObject;
			if(RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Realization_4006, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Manifestation_4012(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation)linkObject;
			if(ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Manifestation_4012, ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Abstraction_4007(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction)linkObject;
			if(AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4007, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Usage_4008(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage)linkObject;
			if(UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4008, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Deployment_4009(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment)linkObject;
			if(DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Deployment_4009, DeploymentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4017(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(RoleBindingEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4017, RoleBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4010(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4010, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Connector_4013(StructuredClassifier container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getOwnedConnectors().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Connector) {
				continue;
			}
			Connector link = (Connector)linkObject;
			if(ConnectorEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getEnds();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof ConnectorEnd) {
				continue;
			}
			ConnectorEnd dst = (ConnectorEnd)theTarget;
			List sources = link.getEnds();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof ConnectorEnd) {
				continue;
			}
			ConnectorEnd src = (ConnectorEnd)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Connector_4013, ConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Generalization_4015(Classifier container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)linkObject;
			if(GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getGeneral();
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Generalization_4015, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InformationFlow_4021(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InformationFlow) {
				continue;
			}
			InformationFlow link = (InformationFlow)linkObject;
			if(InformationFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getInformationTargets();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getInformationSources();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InformationFlow_4021, InformationFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4002, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4003, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_ComponentRealization_4004(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization)setting.getEObject();
			if(ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.ComponentRealization_4004, ComponentRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_InterfaceRealization_4005(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)setting.getEObject();
			if(InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.InterfaceRealization_4005, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Substitution_4011(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)setting.getEObject();
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Substitution_4011, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Realization_4006(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Realization) {
				continue;
			}
			Realization link = (Realization)setting.getEObject();
			if(RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Realization_4006, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Manifestation_4012(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation)setting.getEObject();
			if(ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Manifestation_4012, ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Abstraction_4007(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction)setting.getEObject();
			if(AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Abstraction_4007, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Usage_4008(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Usage) {
				continue;
			}
			Usage link = (Usage)setting.getEObject();
			if(UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Usage_4008, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Deployment_4009(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment)setting.getEObject();
			if(DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Deployment_4009, DeploymentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4017(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)setting.getEObject();
			if(RoleBindingEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4017, RoleBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4010(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)setting.getEObject();
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4010, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Generalization_4015(Classifier target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)setting.getEObject();
			if(GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Generalization_4015, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_TimeObservation_Event_4018(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getTimeObservation_Event()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.TimeObservationEvent_4018, TimeObservationEventEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_DurationObservation_Event_4019(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getDurationObservation_Event()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.DurationObservationEvent_4019, DurationObservationEventEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_InformationItem_Represented_4020(Classifier target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getInformationItem_Represented()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.InformationItemRepresented_4020, RepresentationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_InformationFlow_4021(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInformationFlow_InformationTarget() || false == setting.getEObject() instanceof InformationFlow) {
				continue;
			}
			InformationFlow link = (InformationFlow)setting.getEObject();
			if(InformationFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getInformationSources();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.InformationFlow_4021, InformationFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(Comment source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4002, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(Constraint source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4003, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_ComponentRealization_4004(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization)linkObject;
			if(ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ComponentRealization_4004, ComponentRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_InterfaceRealization_4005(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)linkObject;
			if(InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InterfaceRealization_4005, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Substitution_4011(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)linkObject;
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Substitution_4011, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Realization_4006(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Realization) {
				continue;
			}
			Realization link = (Realization)linkObject;
			if(RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Realization_4006, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Manifestation_4012(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation)linkObject;
			if(ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Manifestation_4012, ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Abstraction_4007(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction)linkObject;
			if(AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4007, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Usage_4008(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage)linkObject;
			if(UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4008, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Deployment_4009(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment)linkObject;
			if(DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Deployment_4009, DeploymentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4017(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(RoleBindingEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4017, RoleBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4010(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4010, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Generalization_4015(Classifier source) {
		Classifier container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Classifier) {
				container = (Classifier)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)linkObject;
			if(GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getGeneral();
			Classifier src = link.getSpecific();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Generalization_4015, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4018(TimeObservation source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		NamedElement destination = source.getEvent();
		if(destination == null) {
			return result;
		}
		result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.TimeObservationEvent_4018, TimeObservationEventEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4019(DurationObservation source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getEvents().iterator(); destinations.hasNext();) {
			NamedElement destination = (NamedElement)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.DurationObservationEvent_4019, DurationObservationEventEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_InformationItem_Represented_4020(InformationItem source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getRepresenteds().iterator(); destinations.hasNext();) {
			Classifier destination = (Classifier)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.InformationItemRepresented_4020, RepresentationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_InformationFlow_4021(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InformationFlow) {
				continue;
			}
			InformationFlow link = (InformationFlow)linkObject;
			if(InformationFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getInformationTargets();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getInformationSources();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InformationFlow_4021, InformationFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {

		/**
		 * @generated
		 */
		public List<UMLNodeDescriptor> getSemanticChildren(View view) {
			return UMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getContainedLinks(View view) {
			return UMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getIncomingLinks(View view) {
			return UMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getOutgoingLinks(View view) {
			return UMLDiagramUpdater.getOutgoingLinks(view);
		}
	};
}
