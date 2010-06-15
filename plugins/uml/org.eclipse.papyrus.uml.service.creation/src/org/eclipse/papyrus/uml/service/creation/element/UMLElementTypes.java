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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.creation.element;
import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
	import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/** this class defined all IHintedType of UML**/
public class UMLElementTypes extends AbstractElementTypeEnumerator {
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType COMMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Comment");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Package");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DEPENDENCY = (IHintedType)getElementType("org.eclipse.papyrus.uml.Dependency");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ELEMENTIMPORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ElementImport");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PACKAGEIMPORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.PackageImport");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Constraint");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ASSOCIATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Association");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TEMPLATEBINDING = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateBinding");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TEMPLATESIGNATURE = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateSignature");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TEMPLATEPARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateParameter");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TEMPLATEPARAMETERSUBSTITUTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.TemplateParameterSubstitution");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType GENERALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Generalization");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType GENERALIZATIONSET = (IHintedType)getElementType("org.eclipse.papyrus.uml.GeneralizationSet");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SUBSTITUTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Substitution");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType REALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Realization");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ABSTRACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Abstraction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType OPAQUEEXPRESSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.OpaqueExpression");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.Parameter");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONNECTABLEELEMENTTEMPLATEPARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConnectableElementTemplateParameter");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONNECTOREND = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConnectorEnd");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.uml.Property");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DEPLOYMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Deployment");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DEPLOYMENTSPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.DeploymentSpecification");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ARTIFACT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Artifact");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType MANIFESTATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Manifestation");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType OPERATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Operation");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.uml.Class");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERFACEREALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.InterfaceRealization");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERFACE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Interface");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType RECEPTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Reception");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SIGNAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.Signal");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PROTOCOLSTATEMACHINE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ProtocolStateMachine");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType STATEMACHINE = (IHintedType)getElementType("org.eclipse.papyrus.uml.StateMachine");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType REGION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Region");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TRANSITION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Transition");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TRIGGER = (IHintedType)getElementType("org.eclipse.papyrus.uml.Trigger");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Port");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType STATE = (IHintedType)getElementType("org.eclipse.papyrus.uml.State");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONNECTIONPOINTREFERENCE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConnectionPointReference");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PSEUDOSTATE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Pseudostate");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PROTOCOLCONFORMANCE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ProtocolConformance");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONNECTOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.Connector");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXTENSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Extension");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXTENSIONEND = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExtensionEnd");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType STEREOTYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Stereotype");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType IMAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Image");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PROFILE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Profile");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType MODEL = (IHintedType)getElementType("org.eclipse.papyrus.uml.Model");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PARAMETERSET = (IHintedType)getElementType("org.eclipse.papyrus.uml.ParameterSet");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DATATYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.DataType");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType OPERATIONTEMPLATEPARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.OperationTemplateParameter");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType COLLABORATIONUSE = (IHintedType)getElementType("org.eclipse.papyrus.uml.CollaborationUse");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType COLLABORATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Collaboration");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType USECASE = (IHintedType)getElementType("org.eclipse.papyrus.uml.UseCase");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INCLUDE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Include");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXTEND = (IHintedType)getElementType("org.eclipse.papyrus.uml.Extend");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXTENSIONPOINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExtensionPoint");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType REDEFINABLETEMPLATESIGNATURE = (IHintedType)getElementType("org.eclipse.papyrus.uml.RedefinableTemplateSignature");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CLASSIFIERTEMPLATEPARAMETER = (IHintedType)getElementType("org.eclipse.papyrus.uml.ClassifierTemplateParameter");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType STRINGEXPRESSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.StringExpression");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXPRESSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Expression");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType USAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Usage");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PACKAGEMERGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.PackageMerge");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PROFILEAPPLICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ProfileApplication");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ENUMERATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Enumeration");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ENUMERATIONLITERAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.EnumerationLiteral");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INSTANCESPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.InstanceSpecification");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SLOT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Slot");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PRIMITIVETYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.PrimitiveType");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LITERALINTEGER = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralInteger");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LITERALSTRING = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralString");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LITERALBOOLEAN = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralBoolean");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LITERALNULL = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralNull");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INSTANCEVALUE = (IHintedType)getElementType("org.eclipse.papyrus.uml.InstanceValue");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LITERALUNLIMITEDNATURAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.LiteralUnlimitedNatural");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType OPAQUEBEHAVIOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.OpaqueBehavior");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType FUNCTIONBEHAVIOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.FunctionBehavior");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType OPAQUEACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.OpaqueAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType STRUCTUREDACTIVITYNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.StructuredActivityNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACTIVITY = (IHintedType)getElementType("org.eclipse.papyrus.uml.Activity");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType VARIABLE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Variable");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACTIVITYPARTITION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityPartition");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERRUPTIBLEACTIVITYREGION = (IHintedType)getElementType("org.eclipse.papyrus.uml.InterruptibleActivityRegion");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXCEPTIONHANDLER = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExceptionHandler");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType OUTPUTPIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.OutputPin");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.Pin");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INPUTPIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.InputPin");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SENDSIGNALACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.SendSignalAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CALLOPERATIONACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CallOperationAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CALLBEHAVIORACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CallBehaviorAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SEQUENCENODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.SequenceNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONTROLFLOW = (IHintedType)getElementType("org.eclipse.papyrus.uml.ControlFlow");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INITIALNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.InitialNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACTIVITYPARAMETERNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityParameterNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType VALUEPIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.ValuePin");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType MESSAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Message");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Interaction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LIFELINE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Lifeline");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PARTDECOMPOSITION = (IHintedType)getElementType("org.eclipse.papyrus.uml.PartDecomposition");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERACTIONUSE = (IHintedType)getElementType("org.eclipse.papyrus.uml.InteractionUse");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType GATE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Gate");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType GENERALORDERING = (IHintedType)getElementType("org.eclipse.papyrus.uml.GeneralOrdering");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType OCCURRENCESPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.OccurrenceSpecification");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERACTIONOPERAND = (IHintedType)getElementType("org.eclipse.papyrus.uml.InteractionOperand");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERACTIONCONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.InteractionConstraint");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType STATEINVARIANT = (IHintedType)getElementType("org.eclipse.papyrus.uml.StateInvariant");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACTIONEXECUTIONSPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActionExecutionSpecification");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType BEHAVIOREXECUTIONSPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.BehaviorExecutionSpecification");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXECUTIONEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExecutionEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CREATIONEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.CreationEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DESTRUCTIONEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.DestructionEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SENDOPERATIONEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.SendOperationEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SENDSIGNALEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.SendSignalEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType MESSAGEOCCURRENCESPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.MessageOccurrenceSpecification");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXECUTIONOCCURRENCESPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExecutionOccurrenceSpecification");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType RECEIVEOPERATIONEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReceiveOperationEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType RECEIVESIGNALEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReceiveSignalEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACTOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.Actor");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CALLEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.CallEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CHANGEEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ChangeEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SIGNALEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.SignalEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ANYRECEIVEEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.AnyReceiveEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType FORKNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ForkNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType FLOWFINALNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.FlowFinalNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CENTRALBUFFERNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.CentralBufferNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType MERGENODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.MergeNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DECISIONNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.DecisionNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACTIVITYFINALNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActivityFinalNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType COMPONENTREALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ComponentRealization");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType COMPONENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.Component");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType NODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Node");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DEVICE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Device");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXECUTIONENVIRONMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExecutionEnvironment");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType COMMUNICATIONPATH = (IHintedType)getElementType("org.eclipse.papyrus.uml.CommunicationPath");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType COMBINEDFRAGMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.CombinedFragment");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONTINUATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Continuation");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONSIDERIGNOREFRAGMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConsiderIgnoreFragment");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CREATEOBJECTACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CreateObjectAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DESTROYOBJECTACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.DestroyObjectAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TESTIDENTITYACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.TestIdentityAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType READSELFACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadSelfAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType READSTRUCTURALFEATUREACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadStructuralFeatureAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CLEARSTRUCTURALFEATUREACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ClearStructuralFeatureAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType REMOVESTRUCTURALFEATUREVALUEACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.RemoveStructuralFeatureValueAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ADDSTRUCTURALFEATUREVALUEACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.AddStructuralFeatureValueAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LINKENDDATA = (IHintedType)getElementType("org.eclipse.papyrus.uml.LinkEndData");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType QUALIFIERVALUE = (IHintedType)getElementType("org.eclipse.papyrus.uml.QualifierValue");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType READLINKACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadLinkAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LINKENDCREATIONDATA = (IHintedType)getElementType("org.eclipse.papyrus.uml.LinkEndCreationData");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CREATELINKACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CreateLinkAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DESTROYLINKACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.DestroyLinkAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LINKENDDESTRUCTIONDATA = (IHintedType)getElementType("org.eclipse.papyrus.uml.LinkEndDestructionData");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CLEARASSOCIATIONACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ClearAssociationAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType BROADCASTSIGNALACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.BroadcastSignalAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType SENDOBJECTACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.SendObjectAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType VALUESPECIFICATIONACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ValueSpecificationAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TIMEEXPRESSION = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeExpression");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DURATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.Duration");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DURATIONINTERVAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.DurationInterval");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERVAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.Interval");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TIMECONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeConstraint");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INTERVALCONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.IntervalConstraint");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TIMEINTERVAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeInterval");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DURATIONCONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.DurationConstraint");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TIMEOBSERVATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeObservation");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DURATIONOBSERVATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.DurationObservation");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType FINALSTATE = (IHintedType)getElementType("org.eclipse.papyrus.uml.FinalState");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType TIMEEVENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.TimeEvent");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType READVARIABLEACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadVariableAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CLEARVARIABLEACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ClearVariableAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ADDVARIABLEVALUEACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.AddVariableValueAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType REMOVEVARIABLEVALUEACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.RemoveVariableValueAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType RAISEEXCEPTIONACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.RaiseExceptionAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACTIONINPUTPIN = (IHintedType)getElementType("org.eclipse.papyrus.uml.ActionInputPin");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INFORMATIONITEM = (IHintedType)getElementType("org.eclipse.papyrus.uml.InformationItem");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType INFORMATIONFLOW = (IHintedType)getElementType("org.eclipse.papyrus.uml.InformationFlow");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType READEXTENTACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadExtentAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType RECLASSIFYOBJECTACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReclassifyObjectAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType READISCLASSIFIEDOBJECTACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadIsClassifiedObjectAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType STARTCLASSIFIERBEHAVIORACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.StartClassifierBehaviorAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType READLINKOBJECTENDACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadLinkObjectEndAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType READLINKOBJECTENDQUALIFIERACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReadLinkObjectEndQualifierAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CREATELINKOBJECTACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.CreateLinkObjectAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACCEPTEVENTACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.AcceptEventAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ACCEPTCALLACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.AcceptCallAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType REPLYACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReplyAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType UNMARSHALLACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.UnmarshallAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType REDUCEACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ReduceAction");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType JOINNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.JoinNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType DATASTORENODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.DataStoreNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType OBJECTFLOW = (IHintedType)getElementType("org.eclipse.papyrus.uml.ObjectFlow");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CONDITIONALNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ConditionalNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType CLAUSE = (IHintedType)getElementType("org.eclipse.papyrus.uml.Clause");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType LOOPNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.LoopNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXPANSIONNODE = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExpansionNode");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType EXPANSIONREGION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ExpansionRegion");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType PROTOCOLTRANSITION = (IHintedType)getElementType("org.eclipse.papyrus.uml.ProtocolTransition");
/** IHintedType of UML currentEClass.getName()**/
public static final IHintedType ASSOCIATIONCLASS = (IHintedType)getElementType("org.eclipse.papyrus.uml.AssociationClass");

}
