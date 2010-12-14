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
 * 
 * 		Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.element;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/** Convenient utility class listing IElementType declared in plugin.xml */
public class UMLElementTypes extends AbstractElementTypeEnumerator {

	/** IElementType for UML Abstraction */
	public static final IHintedType ABSTRACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Abstraction"); //$NON-NLS-1$
	
	/** IElementType for UML AcceptCallAction */
	public static final IHintedType ACCEPT_CALL_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.AcceptCallAction"); //$NON-NLS-1$
	
	/** IElementType for UML AcceptEventAction */
	public static final IHintedType ACCEPT_EVENT_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.AcceptEventAction"); //$NON-NLS-1$
	
	/** IElementType for UML Action */
	public static final IHintedType ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Action"); //$NON-NLS-1$
	
	/** IElementType for UML ActionExecutionSpecification */
	public static final IHintedType ACTION_EXECUTION_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActionExecutionSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML ActionInputPin */
	public static final IHintedType ACTION_INPUT_PIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActionInputPin"); //$NON-NLS-1$
	
	/** IElementType for UML Activity */
	public static final IHintedType ACTIVITY = (IHintedType)getElementType("org.eclipse.papyrus.uml.Activity"); //$NON-NLS-1$
	
	/** IElementType for UML ActivityEdge */
	public static final IHintedType ACTIVITY_EDGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityEdge"); //$NON-NLS-1$
	
	/** IElementType for UML ActivityFinalNode */
	public static final IHintedType ACTIVITY_FINAL_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityFinalNode"); //$NON-NLS-1$
	
	/** IElementType for UML ActivityGroup */
	public static final IHintedType ACTIVITY_GROUP = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityGroup"); //$NON-NLS-1$
	
	/** IElementType for UML ActivityNode */
	public static final IHintedType ACTIVITY_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityNode"); //$NON-NLS-1$
	
	/** IElementType for UML ActivityParameterNode */
	public static final IHintedType ACTIVITY_PARAMETER_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityParameterNode"); //$NON-NLS-1$
	
	/** IElementType for UML ActivityPartition */
	public static final IHintedType ACTIVITY_PARTITION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityPartition"); //$NON-NLS-1$
	
	/** IElementType for UML Actor */
	public static final IHintedType ACTOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.Actor"); //$NON-NLS-1$
	
	/** IElementType for UML AddStructuralFeatureValueAction */
	public static final IHintedType ADD_STRUCTURAL_FEATURE_VALUE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.AddStructuralFeatureValueAction"); //$NON-NLS-1$
	
	/** IElementType for UML AddVariableValueAction */
	public static final IHintedType ADD_VARIABLE_VALUE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.AddVariableValueAction"); //$NON-NLS-1$
	
	/** IElementType for UML AnyReceiveEvent */
	public static final IHintedType ANY_RECEIVE_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.AnyReceiveEvent"); //$NON-NLS-1$
	
	/** IElementType for UML Artifact */
	public static final IHintedType ARTIFACT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Artifact"); //$NON-NLS-1$
	
	/** IElementType for UML Association */
	public static final IHintedType ASSOCIATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Association"); //$NON-NLS-1$
	
	/** IElementType for UML AssociationClass */
	public static final IHintedType ASSOCIATION_CLASS = (IHintedType)getElementType("org.eclipse.papyrus.uml.AssociationClass"); //$NON-NLS-1$
	
	/** IElementType for UML Behavior */
	public static final IHintedType BEHAVIOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.Behavior"); //$NON-NLS-1$
	
	/** IElementType for UML BehaviorExecutionSpecification */
	public static final IHintedType BEHAVIOR_EXECUTION_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.BehaviorExecutionSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML BehavioralFeature */
	public static final IHintedType BEHAVIORAL_FEATURE = (IHintedType)getElementType("org.eclipse.papyrus.uml.BehavioralFeature"); //$NON-NLS-1$
	
	/** IElementType for UML BehavioredClassifier */
	public static final IHintedType BEHAVIORED_CLASSIFIER = (IHintedType)getElementType("org.eclipse.papyrus.uml.BehavioredClassifier"); //$NON-NLS-1$
	
	/** IElementType for UML BroadcastSignalAction */
	public static final IHintedType BROADCAST_SIGNAL_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.BroadcastSignalAction"); //$NON-NLS-1$
	
	/** IElementType for UML CallAction */
	public static final IHintedType CALL_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CallAction"); //$NON-NLS-1$
	
	/** IElementType for UML CallBehaviorAction */
	public static final IHintedType CALL_BEHAVIOR_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CallBehaviorAction"); //$NON-NLS-1$
	
	/** IElementType for UML CallEvent */
	public static final IHintedType CALL_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.CallEvent"); //$NON-NLS-1$
	
	/** IElementType for UML CallOperationAction */
	public static final IHintedType CALL_OPERATION_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CallOperationAction"); //$NON-NLS-1$
	
	/** IElementType for UML CentralBufferNode */
	public static final IHintedType CENTRAL_BUFFER_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.CentralBufferNode"); //$NON-NLS-1$
	
	/** IElementType for UML ChangeEvent */
	public static final IHintedType CHANGE_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ChangeEvent"); //$NON-NLS-1$
	
	/** IElementType for UML Class */
	public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.uml.Class"); //$NON-NLS-1$
	
	/** IElementType for UML Classifier */
	public static final IHintedType CLASSIFIER = (IHintedType)getElementType("org.eclipse.papyrus.uml.Classifier"); //$NON-NLS-1$
	
	/** IElementType for UML ClassifierTemplateParameter */
	public static final IHintedType CLASSIFIER_TEMPLATE_PARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.ClassifierTemplateParameter"); //$NON-NLS-1$
	
	/** IElementType for UML Clause */
	public static final IHintedType CLAUSE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Clause"); //$NON-NLS-1$
	
	/** IElementType for UML ClearAssociationAction */
	public static final IHintedType CLEAR_ASSOCIATION_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ClearAssociationAction"); //$NON-NLS-1$
	
	/** IElementType for UML ClearStructuralFeatureAction */
	public static final IHintedType CLEAR_STRUCTURAL_FEATURE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ClearStructuralFeatureAction"); //$NON-NLS-1$
	
	/** IElementType for UML ClearVariableAction */
	public static final IHintedType CLEAR_VARIABLE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ClearVariableAction"); //$NON-NLS-1$
	
	/** IElementType for UML Collaboration */
	public static final IHintedType COLLABORATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Collaboration"); //$NON-NLS-1$
	
	/** IElementType for UML CollaborationUse */
	public static final IHintedType COLLABORATION_USE = (IHintedType)getElementType("org.eclipse.papyrus.uml.CollaborationUse"); //$NON-NLS-1$
	
	/** IElementType for UML CombinedFragment */
	public static final IHintedType COMBINED_FRAGMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.CombinedFragment"); //$NON-NLS-1$
	
	/** IElementType for UML Comment */
	public static final IHintedType COMMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Comment"); //$NON-NLS-1$
	
	/** IElementType for UML CommunicationPath */
	public static final IHintedType COMMUNICATION_PATH = (IHintedType)getElementType("org.eclipse.papyrus.uml.CommunicationPath"); //$NON-NLS-1$
	
	/** IElementType for UML Component */
	public static final IHintedType COMPONENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Component"); //$NON-NLS-1$
	
	/** IElementType for UML ComponentRealization */
	public static final IHintedType COMPONENT_REALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ComponentRealization"); //$NON-NLS-1$
	
	/** IElementType for UML ConditionalNode */
	public static final IHintedType CONDITIONAL_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConditionalNode"); //$NON-NLS-1$
	
	/** IElementType for UML ConnectableElement */
	public static final IHintedType CONNECTABLE_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConnectableElement"); //$NON-NLS-1$
	
	/** IElementType for UML ConnectableElementTemplateParameter */
	public static final IHintedType CONNECTABLE_ELEMENT_TEMPLATE_PARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConnectableElementTemplateParameter"); //$NON-NLS-1$
	
	/** IElementType for UML ConnectionPointReference */
	public static final IHintedType CONNECTION_POINT_REFERENCE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConnectionPointReference"); //$NON-NLS-1$
	
	/** IElementType for UML Connector */
	public static final IHintedType CONNECTOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.Connector"); //$NON-NLS-1$
	
	/** IElementType for UML ConnectorEnd */
	public static final IHintedType CONNECTOR_END = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConnectorEnd"); //$NON-NLS-1$
	
	/** IElementType for UML ConsiderIgnoreFragment */
	public static final IHintedType CONSIDER_IGNORE_FRAGMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConsiderIgnoreFragment"); //$NON-NLS-1$
	
	/** IElementType for UML Constraint */
	public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Constraint"); //$NON-NLS-1$
	
	/** IElementType for UML Continuation */
	public static final IHintedType CONTINUATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Continuation"); //$NON-NLS-1$
	
	/** IElementType for UML ControlFlow */
	public static final IHintedType CONTROL_FLOW = (IHintedType)getElementType("org.eclipse.papyrus.uml.ControlFlow"); //$NON-NLS-1$
	
	/** IElementType for UML ControlNode */
	public static final IHintedType CONTROL_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ControlNode"); //$NON-NLS-1$
	
	/** IElementType for UML CreateLinkAction */
	public static final IHintedType CREATE_LINK_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CreateLinkAction"); //$NON-NLS-1$
	
	/** IElementType for UML CreateLinkObjectAction */
	public static final IHintedType CREATE_LINK_OBJECT_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CreateLinkObjectAction"); //$NON-NLS-1$
	
	/** IElementType for UML CreateObjectAction */
	public static final IHintedType CREATE_OBJECT_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CreateObjectAction"); //$NON-NLS-1$
	
	/** IElementType for UML CreationEvent */
	public static final IHintedType CREATION_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.CreationEvent"); //$NON-NLS-1$
	
	/** IElementType for UML DataStoreNode */
	public static final IHintedType DATA_STORE_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.DataStoreNode"); //$NON-NLS-1$
	
	/** IElementType for UML DataType */
	public static final IHintedType DATA_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.DataType"); //$NON-NLS-1$
	
	/** IElementType for UML DecisionNode */
	public static final IHintedType DECISION_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.DecisionNode"); //$NON-NLS-1$
	
	/** IElementType for UML Dependency */
	public static final IHintedType DEPENDENCY = (IHintedType)getElementType("org.eclipse.papyrus.uml.Dependency"); //$NON-NLS-1$
	
	/** IElementType for UML DeployedArtifact */
	public static final IHintedType DEPLOYED_ARTIFACT = (IHintedType)getElementType("org.eclipse.papyrus.uml.DeployedArtifact"); //$NON-NLS-1$
	
	/** IElementType for UML Deployment */
	public static final IHintedType DEPLOYMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Deployment"); //$NON-NLS-1$
	
	/** IElementType for UML DeploymentSpecification */
	public static final IHintedType DEPLOYMENT_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.DeploymentSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML DeploymentTarget */
	public static final IHintedType DEPLOYMENT_TARGET = (IHintedType)getElementType("org.eclipse.papyrus.uml.DeploymentTarget"); //$NON-NLS-1$
	
	/** IElementType for UML DestroyLinkAction */
	public static final IHintedType DESTROY_LINK_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.DestroyLinkAction"); //$NON-NLS-1$
	
	/** IElementType for UML DestroyObjectAction */
	public static final IHintedType DESTROY_OBJECT_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.DestroyObjectAction"); //$NON-NLS-1$
	
	/** IElementType for UML DestructionEvent */
	public static final IHintedType DESTRUCTION_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.DestructionEvent"); //$NON-NLS-1$
	
	/** IElementType for UML Device */
	public static final IHintedType DEVICE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Device"); //$NON-NLS-1$
	
	/** IElementType for UML DirectedRelationship */
	public static final IHintedType DIRECTED_RELATIONSHIP = (IHintedType)getElementType("org.eclipse.papyrus.uml.DirectedRelationship"); //$NON-NLS-1$
	
	/** IElementType for UML Duration */
	public static final IHintedType DURATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Duration"); //$NON-NLS-1$
	
	/** IElementType for UML DurationConstraint */
	public static final IHintedType DURATION_CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.DurationConstraint"); //$NON-NLS-1$
	
	/** IElementType for UML DurationInterval */
	public static final IHintedType DURATION_INTERVAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.DurationInterval"); //$NON-NLS-1$
	
	/** IElementType for UML DurationObservation */
	public static final IHintedType DURATION_OBSERVATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.DurationObservation"); //$NON-NLS-1$
	
	/** IElementType for UML Element */
	public static final IHintedType ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Element"); //$NON-NLS-1$
	
	/** IElementType for UML ElementImport */
	public static final IHintedType ELEMENT_IMPORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ElementImport"); //$NON-NLS-1$
	
	/** IElementType for UML EncapsulatedClassifier */
	public static final IHintedType ENCAPSULATED_CLASSIFIER = (IHintedType)getElementType("org.eclipse.papyrus.uml.EncapsulatedClassifier"); //$NON-NLS-1$
	
	/** IElementType for UML Enumeration */
	public static final IHintedType ENUMERATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Enumeration"); //$NON-NLS-1$
	
	/** IElementType for UML EnumerationLiteral */
	public static final IHintedType ENUMERATION_LITERAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.EnumerationLiteral"); //$NON-NLS-1$
	
	/** IElementType for UML Event */
	public static final IHintedType EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Event"); //$NON-NLS-1$
	
	/** IElementType for UML ExceptionHandler */
	public static final IHintedType EXCEPTION_HANDLER = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExceptionHandler"); //$NON-NLS-1$
	
	/** IElementType for UML ExecutableNode */
	public static final IHintedType EXECUTABLE_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExecutableNode"); //$NON-NLS-1$
	
	/** IElementType for UML ExecutionEnvironment */
	public static final IHintedType EXECUTION_ENVIRONMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExecutionEnvironment"); //$NON-NLS-1$
	
	/** IElementType for UML ExecutionEvent */
	public static final IHintedType EXECUTION_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExecutionEvent"); //$NON-NLS-1$
	
	/** IElementType for UML ExecutionOccurrenceSpecification */
	public static final IHintedType EXECUTION_OCCURRENCE_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExecutionOccurrenceSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML ExecutionSpecification */
	public static final IHintedType EXECUTION_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExecutionSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML ExpansionNode */
	public static final IHintedType EXPANSION_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExpansionNode"); //$NON-NLS-1$
	
	/** IElementType for UML ExpansionRegion */
	public static final IHintedType EXPANSION_REGION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExpansionRegion"); //$NON-NLS-1$
	
	/** IElementType for UML Expression */
	public static final IHintedType EXPRESSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Expression"); //$NON-NLS-1$
	
	/** IElementType for UML Extend */
	public static final IHintedType EXTEND = (IHintedType)getElementType("org.eclipse.papyrus.uml.Extend"); //$NON-NLS-1$
	
	/** IElementType for UML Extension */
	public static final IHintedType EXTENSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Extension"); //$NON-NLS-1$
	
	/** IElementType for UML ExtensionEnd */
	public static final IHintedType EXTENSION_END = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExtensionEnd"); //$NON-NLS-1$
	
	/** IElementType for UML ExtensionPoint */
	public static final IHintedType EXTENSION_POINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExtensionPoint"); //$NON-NLS-1$
	
	/** IElementType for UML Feature */
	public static final IHintedType FEATURE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Feature"); //$NON-NLS-1$
	
	/** IElementType for UML FinalNode */
	public static final IHintedType FINAL_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.FinalNode"); //$NON-NLS-1$
	
	/** IElementType for UML FinalState */
	public static final IHintedType FINAL_STATE = (IHintedType)getElementType("org.eclipse.papyrus.uml.FinalState"); //$NON-NLS-1$
	
	/** IElementType for UML FlowFinalNode */
	public static final IHintedType FLOW_FINAL_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.FlowFinalNode"); //$NON-NLS-1$
	
	/** IElementType for UML ForkNode */
	public static final IHintedType FORK_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ForkNode"); //$NON-NLS-1$
	
	/** IElementType for UML FunctionBehavior */
	public static final IHintedType FUNCTION_BEHAVIOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.FunctionBehavior"); //$NON-NLS-1$
	
	/** IElementType for UML Gate */
	public static final IHintedType GATE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Gate"); //$NON-NLS-1$
	
	/** IElementType for UML GeneralOrdering */
	public static final IHintedType GENERAL_ORDERING = (IHintedType)getElementType("org.eclipse.papyrus.uml.GeneralOrdering"); //$NON-NLS-1$
	
	/** IElementType for UML Generalization */
	public static final IHintedType GENERALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Generalization"); //$NON-NLS-1$
	
	/** IElementType for UML GeneralizationSet */
	public static final IHintedType GENERALIZATION_SET = (IHintedType)getElementType("org.eclipse.papyrus.uml.GeneralizationSet"); //$NON-NLS-1$
	
	/** IElementType for UML Image */
	public static final IHintedType IMAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Image"); //$NON-NLS-1$
	
	/** IElementType for UML Include */
	public static final IHintedType INCLUDE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Include"); //$NON-NLS-1$
	
	/** IElementType for UML InformationFlow */
	public static final IHintedType INFORMATION_FLOW = (IHintedType)getElementType("org.eclipse.papyrus.uml.InformationFlow"); //$NON-NLS-1$
	
	/** IElementType for UML InformationItem */
	public static final IHintedType INFORMATION_ITEM = (IHintedType)getElementType("org.eclipse.papyrus.uml.InformationItem"); //$NON-NLS-1$
	
	/** IElementType for UML InitialNode */
	public static final IHintedType INITIAL_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.InitialNode"); //$NON-NLS-1$
	
	/** IElementType for UML InputPin */
	public static final IHintedType INPUT_PIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.InputPin"); //$NON-NLS-1$
	
	/** IElementType for UML InstanceSpecification */
	public static final IHintedType INSTANCE_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.InstanceSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML InstanceValue */
	public static final IHintedType INSTANCE_VALUE = (IHintedType)getElementType("org.eclipse.papyrus.uml.InstanceValue"); //$NON-NLS-1$
	
	/** IElementType for UML Interaction */
	public static final IHintedType INTERACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Interaction"); //$NON-NLS-1$
	
	/** IElementType for UML InteractionConstraint */
	public static final IHintedType INTERACTION_CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.InteractionConstraint"); //$NON-NLS-1$
	
	/** IElementType for UML InteractionFragment */
	public static final IHintedType INTERACTION_FRAGMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.InteractionFragment"); //$NON-NLS-1$
	
	/** IElementType for UML InteractionOperand */
	public static final IHintedType INTERACTION_OPERAND = (IHintedType)getElementType("org.eclipse.papyrus.uml.InteractionOperand"); //$NON-NLS-1$
	
	/** IElementType for UML InteractionUse */
	public static final IHintedType INTERACTION_USE = (IHintedType)getElementType("org.eclipse.papyrus.uml.InteractionUse"); //$NON-NLS-1$
	
	/** IElementType for UML Interface */
	public static final IHintedType INTERFACE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Interface"); //$NON-NLS-1$
	
	/** IElementType for UML InterfaceRealization */
	public static final IHintedType INTERFACE_REALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.InterfaceRealization"); //$NON-NLS-1$
	
	/** IElementType for UML InterruptibleActivityRegion */
	public static final IHintedType INTERRUPTIBLE_ACTIVITY_REGION = (IHintedType)getElementType("org.eclipse.papyrus.uml.InterruptibleActivityRegion"); //$NON-NLS-1$
	
	/** IElementType for UML Interval */
	public static final IHintedType INTERVAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.Interval"); //$NON-NLS-1$
	
	/** IElementType for UML IntervalConstraint */
	public static final IHintedType INTERVAL_CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.IntervalConstraint"); //$NON-NLS-1$
	
	/** IElementType for UML InvocationAction */
	public static final IHintedType INVOCATION_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.InvocationAction"); //$NON-NLS-1$
	
	/** IElementType for UML JoinNode */
	public static final IHintedType JOIN_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.JoinNode"); //$NON-NLS-1$
	
	/** IElementType for UML Lifeline */
	public static final IHintedType LIFELINE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Lifeline"); //$NON-NLS-1$
	
	/** IElementType for UML LinkAction */
	public static final IHintedType LINK_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.LinkAction"); //$NON-NLS-1$
	
	/** IElementType for UML LinkEndCreationData */
	public static final IHintedType LINK_END_CREATION_DATA = (IHintedType)getElementType("org.eclipse.papyrus.uml.LinkEndCreationData"); //$NON-NLS-1$
	
	/** IElementType for UML LinkEndData */
	public static final IHintedType LINK_END_DATA = (IHintedType)getElementType("org.eclipse.papyrus.uml.LinkEndData"); //$NON-NLS-1$
	
	/** IElementType for UML LinkEndDestructionData */
	public static final IHintedType LINK_END_DESTRUCTION_DATA = (IHintedType)getElementType("org.eclipse.papyrus.uml.LinkEndDestructionData"); //$NON-NLS-1$
	
	/** IElementType for UML LiteralBoolean */
	public static final IHintedType LITERAL_BOOLEAN = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralBoolean"); //$NON-NLS-1$
	
	/** IElementType for UML LiteralInteger */
	public static final IHintedType LITERAL_INTEGER = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralInteger"); //$NON-NLS-1$
	
	/** IElementType for UML LiteralNull */
	public static final IHintedType LITERAL_NULL = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralNull"); //$NON-NLS-1$
	
	/** IElementType for UML LiteralSpecification */
	public static final IHintedType LITERAL_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML LiteralString */
	public static final IHintedType LITERAL_STRING = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralString"); //$NON-NLS-1$
	
	/** IElementType for UML LiteralUnlimitedNatural */
	public static final IHintedType LITERAL_UNLIMITED_NATURAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralUnlimitedNatural"); //$NON-NLS-1$
	
	/** IElementType for UML LoopNode */
	public static final IHintedType LOOP_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.LoopNode"); //$NON-NLS-1$
	
	/** IElementType for UML Manifestation */
	public static final IHintedType MANIFESTATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Manifestation"); //$NON-NLS-1$
	
	/** IElementType for UML MergeNode */
	public static final IHintedType MERGE_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.MergeNode"); //$NON-NLS-1$
	
	/** IElementType for UML Message */
	public static final IHintedType MESSAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Message"); //$NON-NLS-1$
	
	/** IElementType for UML MessageEnd */
	public static final IHintedType MESSAGE_END = (IHintedType)getElementType("org.eclipse.papyrus.uml.MessageEnd"); //$NON-NLS-1$
	
	/** IElementType for UML MessageEvent */
	public static final IHintedType MESSAGE_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.MessageEvent"); //$NON-NLS-1$
	
	/** IElementType for UML MessageOccurrenceSpecification */
	public static final IHintedType MESSAGE_OCCURRENCE_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.MessageOccurrenceSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML Model */
	public static final IHintedType MODEL = (IHintedType)getElementType("org.eclipse.papyrus.uml.Model"); //$NON-NLS-1$
	
	/** IElementType for UML MultiplicityElement */
	public static final IHintedType MULTIPLICITY_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.MultiplicityElement"); //$NON-NLS-1$
	
	/** IElementType for UML NamedElement */
	public static final IHintedType NAMED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.NamedElement"); //$NON-NLS-1$
	
	/** IElementType for UML Namespace */
	public static final IHintedType NAMESPACE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Namespace"); //$NON-NLS-1$
	
	/** IElementType for UML Node */
	public static final IHintedType NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Node"); //$NON-NLS-1$
	
	/** IElementType for UML ObjectFlow */
	public static final IHintedType OBJECT_FLOW = (IHintedType)getElementType("org.eclipse.papyrus.uml.ObjectFlow"); //$NON-NLS-1$
	
	/** IElementType for UML ObjectNode */
	public static final IHintedType OBJECT_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ObjectNode"); //$NON-NLS-1$
	
	/** IElementType for UML Observation */
	public static final IHintedType OBSERVATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Observation"); //$NON-NLS-1$
	
	/** IElementType for UML OccurrenceSpecification */
	public static final IHintedType OCCURRENCE_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.OccurrenceSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML OpaqueAction */
	public static final IHintedType OPAQUE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.OpaqueAction"); //$NON-NLS-1$
	
	/** IElementType for UML OpaqueBehavior */
	public static final IHintedType OPAQUE_BEHAVIOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.OpaqueBehavior"); //$NON-NLS-1$
	
	/** IElementType for UML OpaqueExpression */
	public static final IHintedType OPAQUE_EXPRESSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.OpaqueExpression"); //$NON-NLS-1$
	
	/** IElementType for UML Operation */
	public static final IHintedType OPERATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Operation"); //$NON-NLS-1$
	
	/** IElementType for UML OperationTemplateParameter */
	public static final IHintedType OPERATION_TEMPLATE_PARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.OperationTemplateParameter"); //$NON-NLS-1$
	
	/** IElementType for UML OutputPin */
	public static final IHintedType OUTPUT_PIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.OutputPin"); //$NON-NLS-1$
	
	/** IElementType for UML Package */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Package"); //$NON-NLS-1$
	
	/** IElementType for UML PackageImport */
	public static final IHintedType PACKAGE_IMPORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.PackageImport"); //$NON-NLS-1$
	
	/** IElementType for UML PackageMerge */
	public static final IHintedType PACKAGE_MERGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.PackageMerge"); //$NON-NLS-1$
	
	/** IElementType for UML PackageableElement */
	public static final IHintedType PACKAGEABLE_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.PackageableElement"); //$NON-NLS-1$
	
	/** IElementType for UML Parameter */
	public static final IHintedType PARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.Parameter"); //$NON-NLS-1$
	
	/** IElementType for UML ParameterSet */
	public static final IHintedType PARAMETER_SET = (IHintedType)getElementType("org.eclipse.papyrus.uml.ParameterSet"); //$NON-NLS-1$
	
	/** IElementType for UML ParameterableElement */
	public static final IHintedType PARAMETERABLE_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ParameterableElement"); //$NON-NLS-1$
	
	/** IElementType for UML PartDecomposition */
	public static final IHintedType PART_DECOMPOSITION = (IHintedType)getElementType("org.eclipse.papyrus.uml.PartDecomposition"); //$NON-NLS-1$
	
	/** IElementType for UML Pin */
	public static final IHintedType PIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.Pin"); //$NON-NLS-1$
	
	/** IElementType for UML Port */
	public static final IHintedType PORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Port"); //$NON-NLS-1$
	
	/** IElementType for UML PrimitiveType */
	public static final IHintedType PRIMITIVE_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.PrimitiveType"); //$NON-NLS-1$
	
	/** IElementType for UML Profile */
	public static final IHintedType PROFILE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Profile"); //$NON-NLS-1$
	
	/** IElementType for UML ProfileApplication */
	public static final IHintedType PROFILE_APPLICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ProfileApplication"); //$NON-NLS-1$
	
	/** IElementType for UML Property */
	public static final IHintedType PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.uml.Property"); //$NON-NLS-1$
	
	/** IElementType for UML ProtocolConformance */
	public static final IHintedType PROTOCOL_CONFORMANCE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ProtocolConformance"); //$NON-NLS-1$
	
	/** IElementType for UML ProtocolStateMachine */
	public static final IHintedType PROTOCOL_STATE_MACHINE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ProtocolStateMachine"); //$NON-NLS-1$
	
	/** IElementType for UML ProtocolTransition */
	public static final IHintedType PROTOCOL_TRANSITION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ProtocolTransition"); //$NON-NLS-1$
	
	/** IElementType for UML Pseudostate */
	public static final IHintedType PSEUDOSTATE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Pseudostate"); //$NON-NLS-1$
	
	/** IElementType for UML QualifierValue */
	public static final IHintedType QUALIFIER_VALUE = (IHintedType)getElementType("org.eclipse.papyrus.uml.QualifierValue"); //$NON-NLS-1$
	
	/** IElementType for UML RaiseExceptionAction */
	public static final IHintedType RAISE_EXCEPTION_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.RaiseExceptionAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReadExtentAction */
	public static final IHintedType READ_EXTENT_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadExtentAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReadIsClassifiedObjectAction */
	public static final IHintedType READ_IS_CLASSIFIED_OBJECT_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadIsClassifiedObjectAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReadLinkAction */
	public static final IHintedType READ_LINK_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadLinkAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReadLinkObjectEndAction */
	public static final IHintedType READ_LINK_OBJECT_END_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadLinkObjectEndAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReadLinkObjectEndQualifierAction */
	public static final IHintedType READ_LINK_OBJECT_END_QUALIFIER_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadLinkObjectEndQualifierAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReadSelfAction */
	public static final IHintedType READ_SELF_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadSelfAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReadStructuralFeatureAction */
	public static final IHintedType READ_STRUCTURAL_FEATURE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadStructuralFeatureAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReadVariableAction */
	public static final IHintedType READ_VARIABLE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadVariableAction"); //$NON-NLS-1$
	
	/** IElementType for UML Realization */
	public static final IHintedType REALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Realization"); //$NON-NLS-1$
	
	/** IElementType for UML ReceiveOperationEvent */
	public static final IHintedType RECEIVE_OPERATION_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReceiveOperationEvent"); //$NON-NLS-1$
	
	/** IElementType for UML ReceiveSignalEvent */
	public static final IHintedType RECEIVE_SIGNAL_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReceiveSignalEvent"); //$NON-NLS-1$
	
	/** IElementType for UML Reception */
	public static final IHintedType RECEPTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Reception"); //$NON-NLS-1$
	
	/** IElementType for UML ReclassifyObjectAction */
	public static final IHintedType RECLASSIFY_OBJECT_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReclassifyObjectAction"); //$NON-NLS-1$
	
	/** IElementType for UML RedefinableElement */
	public static final IHintedType REDEFINABLE_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.RedefinableElement"); //$NON-NLS-1$
	
	/** IElementType for UML RedefinableTemplateSignature */
	public static final IHintedType REDEFINABLE_TEMPLATE_SIGNATURE = (IHintedType)getElementType("org.eclipse.papyrus.uml.RedefinableTemplateSignature"); //$NON-NLS-1$
	
	/** IElementType for UML ReduceAction */
	public static final IHintedType REDUCE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReduceAction"); //$NON-NLS-1$
	
	/** IElementType for UML Region */
	public static final IHintedType REGION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Region"); //$NON-NLS-1$
	
	/** IElementType for UML Relationship */
	public static final IHintedType RELATIONSHIP = (IHintedType)getElementType("org.eclipse.papyrus.uml.Relationship"); //$NON-NLS-1$
	
	/** IElementType for UML RemoveStructuralFeatureValueAction */
	public static final IHintedType REMOVE_STRUCTURAL_FEATURE_VALUE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.RemoveStructuralFeatureValueAction"); //$NON-NLS-1$
	
	/** IElementType for UML RemoveVariableValueAction */
	public static final IHintedType REMOVE_VARIABLE_VALUE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.RemoveVariableValueAction"); //$NON-NLS-1$
	
	/** IElementType for UML ReplyAction */
	public static final IHintedType REPLY_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReplyAction"); //$NON-NLS-1$
	
	/** IElementType for UML SendObjectAction */
	public static final IHintedType SEND_OBJECT_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.SendObjectAction"); //$NON-NLS-1$
	
	/** IElementType for UML SendOperationEvent */
	public static final IHintedType SEND_OPERATION_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.SendOperationEvent"); //$NON-NLS-1$
	
	/** IElementType for UML SendSignalAction */
	public static final IHintedType SEND_SIGNAL_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.SendSignalAction"); //$NON-NLS-1$
	
	/** IElementType for UML SendSignalEvent */
	public static final IHintedType SEND_SIGNAL_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.SendSignalEvent"); //$NON-NLS-1$
	
	/** IElementType for UML SequenceNode */
	public static final IHintedType SEQUENCE_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.SequenceNode"); //$NON-NLS-1$
	
	/** IElementType for UML Signal */
	public static final IHintedType SIGNAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.Signal"); //$NON-NLS-1$
	
	/** IElementType for UML SignalEvent */
	public static final IHintedType SIGNAL_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.SignalEvent"); //$NON-NLS-1$
	
	/** IElementType for UML Slot */
	public static final IHintedType SLOT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Slot"); //$NON-NLS-1$
	
	/** IElementType for UML StartClassifierBehaviorAction */
	public static final IHintedType START_CLASSIFIER_BEHAVIOR_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.StartClassifierBehaviorAction"); //$NON-NLS-1$
	
	/** IElementType for UML StartObjectBehaviorAction */
	public static final IHintedType START_OBJECT_BEHAVIOR_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.StartObjectBehaviorAction"); //$NON-NLS-1$
	
	/** IElementType for UML State */
	public static final IHintedType STATE = (IHintedType)getElementType("org.eclipse.papyrus.uml.State"); //$NON-NLS-1$
	
	/** IElementType for UML StateInvariant */
	public static final IHintedType STATE_INVARIANT = (IHintedType)getElementType("org.eclipse.papyrus.uml.StateInvariant"); //$NON-NLS-1$
	
	/** IElementType for UML StateMachine */
	public static final IHintedType STATE_MACHINE = (IHintedType)getElementType("org.eclipse.papyrus.uml.StateMachine"); //$NON-NLS-1$
	
	/** IElementType for UML Stereotype */
	public static final IHintedType STEREOTYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Stereotype"); //$NON-NLS-1$
	
	/** IElementType for UML StringExpression */
	public static final IHintedType STRING_EXPRESSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.StringExpression"); //$NON-NLS-1$
	
	/** IElementType for UML StructuralFeature */
	public static final IHintedType STRUCTURAL_FEATURE = (IHintedType)getElementType("org.eclipse.papyrus.uml.StructuralFeature"); //$NON-NLS-1$
	
	/** IElementType for UML StructuralFeatureAction */
	public static final IHintedType STRUCTURAL_FEATURE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.StructuralFeatureAction"); //$NON-NLS-1$
	
	/** IElementType for UML StructuredActivityNode */
	public static final IHintedType STRUCTURED_ACTIVITY_NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.StructuredActivityNode"); //$NON-NLS-1$
	
	/** IElementType for UML StructuredClassifier */
	public static final IHintedType STRUCTURED_CLASSIFIER = (IHintedType)getElementType("org.eclipse.papyrus.uml.StructuredClassifier"); //$NON-NLS-1$
	
	/** IElementType for UML Substitution */
	public static final IHintedType SUBSTITUTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Substitution"); //$NON-NLS-1$
	
	/** IElementType for UML TemplateBinding */
	public static final IHintedType TEMPLATE_BINDING = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateBinding"); //$NON-NLS-1$
	
	/** IElementType for UML TemplateParameter */
	public static final IHintedType TEMPLATE_PARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateParameter"); //$NON-NLS-1$
	
	/** IElementType for UML TemplateParameterSubstitution */
	public static final IHintedType TEMPLATE_PARAMETER_SUBSTITUTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateParameterSubstitution"); //$NON-NLS-1$
	
	/** IElementType for UML TemplateSignature */
	public static final IHintedType TEMPLATE_SIGNATURE = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateSignature"); //$NON-NLS-1$
	
	/** IElementType for UML TemplateableElement */
	public static final IHintedType TEMPLATEABLE_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateableElement"); //$NON-NLS-1$
	
	/** IElementType for UML TestIdentityAction */
	public static final IHintedType TEST_IDENTITY_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.TestIdentityAction"); //$NON-NLS-1$
	
	/** IElementType for UML TimeConstraint */
	public static final IHintedType TIME_CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeConstraint"); //$NON-NLS-1$
	
	/** IElementType for UML TimeEvent */
	public static final IHintedType TIME_EVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeEvent"); //$NON-NLS-1$
	
	/** IElementType for UML TimeExpression */
	public static final IHintedType TIME_EXPRESSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeExpression"); //$NON-NLS-1$
	
	/** IElementType for UML TimeInterval */
	public static final IHintedType TIME_INTERVAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeInterval"); //$NON-NLS-1$
	
	/** IElementType for UML TimeObservation */
	public static final IHintedType TIME_OBSERVATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeObservation"); //$NON-NLS-1$
	
	/** IElementType for UML Transition */
	public static final IHintedType TRANSITION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Transition"); //$NON-NLS-1$
	
	/** IElementType for UML Trigger */
	public static final IHintedType TRIGGER = (IHintedType)getElementType("org.eclipse.papyrus.uml.Trigger"); //$NON-NLS-1$
	
	/** IElementType for UML Type */
	public static final IHintedType TYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Type"); //$NON-NLS-1$
	
	/** IElementType for UML TypedElement */
	public static final IHintedType TYPED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.TypedElement"); //$NON-NLS-1$
	
	/** IElementType for UML UnmarshallAction */
	public static final IHintedType UNMARSHALL_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.UnmarshallAction"); //$NON-NLS-1$
	
	/** IElementType for UML Usage */
	public static final IHintedType USAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Usage"); //$NON-NLS-1$
	
	/** IElementType for UML UseCase */
	public static final IHintedType USE_CASE = (IHintedType)getElementType("org.eclipse.papyrus.uml.UseCase"); //$NON-NLS-1$
	
	/** IElementType for UML ValuePin */
	public static final IHintedType VALUE_PIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.ValuePin"); //$NON-NLS-1$
	
	/** IElementType for UML ValueSpecification */
	public static final IHintedType VALUE_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ValueSpecification"); //$NON-NLS-1$
	
	/** IElementType for UML ValueSpecificationAction */
	public static final IHintedType VALUE_SPECIFICATION_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ValueSpecificationAction"); //$NON-NLS-1$
	
	/** IElementType for UML Variable */
	public static final IHintedType VARIABLE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Variable"); //$NON-NLS-1$
	
	/** IElementType for UML VariableAction */
	public static final IHintedType VARIABLE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.VariableAction"); //$NON-NLS-1$
	
	/** IElementType for UML Vertex */
	public static final IHintedType VERTEX = (IHintedType)getElementType("org.eclipse.papyrus.uml.Vertex"); //$NON-NLS-1$
	
	/** IElementType for UML WriteLinkAction */
	public static final IHintedType WRITE_LINK_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.WriteLinkAction"); //$NON-NLS-1$
	
	/** IElementType for UML WriteStructuralFeatureAction */
	public static final IHintedType WRITE_STRUCTURAL_FEATURE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.WriteStructuralFeatureAction"); //$NON-NLS-1$
	
	/** IElementType for UML WriteVariableAction */
	public static final IHintedType WRITE_VARIABLE_ACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.WriteVariableAction"); //$NON-NLS-1$
	
}
