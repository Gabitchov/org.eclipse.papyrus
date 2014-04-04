/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.composite.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLElementTypes {
	/**
	 * @generated
	 */
	private UMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;
	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;
	/**
	 * @generated
	 */
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Package_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Activity_2060 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Activity_2060"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Interaction_2061 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Interaction_2061"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProtocolStateMachine_2062 = getElementType("org.eclipse.papyrus.uml.diagram.composite.ProtocolStateMachine_2062"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StateMachine_2063 = getElementType("org.eclipse.papyrus.uml.diagram.composite.StateMachine_2063"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FunctionBehavior_2064 = getElementType("org.eclipse.papyrus.uml.diagram.composite.FunctionBehavior_2064"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OpaqueBehavior_2065 = getElementType("org.eclipse.papyrus.uml.diagram.composite.OpaqueBehavior_2065"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Component_2069 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Component_2069"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Device_2070 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Device_2070"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ExecutionEnvironment_2071 = getElementType("org.eclipse.papyrus.uml.diagram.composite.ExecutionEnvironment_2071"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Node_2072 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Node_2072"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Class_2073 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Class_2073"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Collaboration_2075 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Collaboration_2075"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Interface_2076 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Interface_2076"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PrimitiveType_2066 = getElementType("org.eclipse.papyrus.uml.diagram.composite.PrimitiveType_2066"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Enumeration_2067 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Enumeration_2067"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataType_2068 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DataType_2068"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Actor_2077 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Actor_2077"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DeploymentSpecification_2078 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DeploymentSpecification_2078"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Artifact_2079 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Artifact_2079"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InformationItem_2080 = getElementType("org.eclipse.papyrus.uml.diagram.composite.InformationItem_2080"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Signal_2081 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Signal_2081"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCase_2082 = getElementType("org.eclipse.papyrus.uml.diagram.composite.UseCase_2082"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SignalEvent_2083 = getElementType("org.eclipse.papyrus.uml.diagram.composite.SignalEvent_2083"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CallEvent_2084 = getElementType("org.eclipse.papyrus.uml.diagram.composite.CallEvent_2084"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AnyReceiveEvent_2085 = getElementType("org.eclipse.papyrus.uml.diagram.composite.AnyReceiveEvent_2085"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ChangeEvent_2088 = getElementType("org.eclipse.papyrus.uml.diagram.composite.ChangeEvent_2088"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TimeEvent_2089 = getElementType("org.eclipse.papyrus.uml.diagram.composite.TimeEvent_2089"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DurationObservation_2093 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DurationObservation_2093"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TimeObservation_2094 = getElementType("org.eclipse.papyrus.uml.diagram.composite.TimeObservation_2094"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LiteralBoolean_2095 = getElementType("org.eclipse.papyrus.uml.diagram.composite.LiteralBoolean_2095"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LiteralInteger_2096 = getElementType("org.eclipse.papyrus.uml.diagram.composite.LiteralInteger_2096"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LiteralNull_2097 = getElementType("org.eclipse.papyrus.uml.diagram.composite.LiteralNull_2097"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LiteralString_2098 = getElementType("org.eclipse.papyrus.uml.diagram.composite.LiteralString_2098"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LiteralUnlimitedNatural_2099 = getElementType("org.eclipse.papyrus.uml.diagram.composite.LiteralUnlimitedNatural_2099"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StringExpression_2100 = getElementType("org.eclipse.papyrus.uml.diagram.composite.StringExpression_2100"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OpaqueExpression_2101 = getElementType("org.eclipse.papyrus.uml.diagram.composite.OpaqueExpression_2101"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TimeExpression_2102 = getElementType("org.eclipse.papyrus.uml.diagram.composite.TimeExpression_2102"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Expression_2103 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Expression_2103"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Duration_2104 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Duration_2104"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TimeInterval_2105 = getElementType("org.eclipse.papyrus.uml.diagram.composite.TimeInterval_2105"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DurationInterval_2106 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DurationInterval_2106"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Interval_2107 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Interval_2107"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InstanceValue_2108 = getElementType("org.eclipse.papyrus.uml.diagram.composite.InstanceValue_2108"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Comment_2109 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Comment_2109"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_2110 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DurationConstraint_2110"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TimeConstraint_2111 = getElementType("org.eclipse.papyrus.uml.diagram.composite.TimeConstraint_2111"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IntervalConstraint_2112 = getElementType("org.eclipse.papyrus.uml.diagram.composite.IntervalConstraint_2112"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InteractionConstraint_2113 = getElementType("org.eclipse.papyrus.uml.diagram.composite.InteractionConstraint_2113"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Constraint_2114 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Constraint_2114"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Node_3121 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Node_3121"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Port_3069 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Port_3069"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Parameter_3088 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Parameter_3088"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Property_3070 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Property_3070"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConnectableElement_3115 = getElementType("org.eclipse.papyrus.uml.diagram.composite.prototype.CollaborationRole_3115"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CollaborationUse_3071 = getElementType("org.eclipse.papyrus.uml.diagram.composite.CollaborationUse_3071"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Activity_3072 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Activity_3072"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Interaction_3073 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Interaction_3073"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProtocolStateMachine_3074 = getElementType("org.eclipse.papyrus.uml.diagram.composite.ProtocolStateMachine_3074"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StateMachine_3075 = getElementType("org.eclipse.papyrus.uml.diagram.composite.StateMachine_3075"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FunctionBehavior_3076 = getElementType("org.eclipse.papyrus.uml.diagram.composite.FunctionBehavior_3076"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OpaqueBehavior_3077 = getElementType("org.eclipse.papyrus.uml.diagram.composite.OpaqueBehavior_3077"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Component_3081 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Component_3081"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Device_3082 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Device_3082"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ExecutionEnvironment_3083 = getElementType("org.eclipse.papyrus.uml.diagram.composite.ExecutionEnvironment_3083"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Node_3084 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Node_3084"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Class_3085 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Class_3085"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Collaboration_3086 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Collaboration_3086"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Interface_3087 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Interface_3087"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PrimitiveType_3078 = getElementType("org.eclipse.papyrus.uml.diagram.composite.PrimitiveType_3078"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Enumeration_3079 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Enumeration_3079"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataType_3080 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DataType_3080"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Actor_3091 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Actor_3091"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DeploymentSpecification_3092 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DeploymentSpecification_3092"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Artifact_3093 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Artifact_3093"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InformationItem_3094 = getElementType("org.eclipse.papyrus.uml.diagram.composite.InformationItem_3094"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Signal_3095 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Signal_3095"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCase_3096 = getElementType("org.eclipse.papyrus.uml.diagram.composite.UseCase_3096"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Comment_3097 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Comment_3097"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_3116 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DurationConstraint_3116"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TimeConstraint_3117 = getElementType("org.eclipse.papyrus.uml.diagram.composite.TimeConstraint_3117"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType IntervalConstraint_3118 = getElementType("org.eclipse.papyrus.uml.diagram.composite.IntervalConstraint_3118"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InteractionConstraint_3119 = getElementType("org.eclipse.papyrus.uml.diagram.composite.InteractionConstraint_3119"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Constraint_3120 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Constraint_3120"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Property_3101 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Property_3101"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Operation_3102 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Operation_3102"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EnumerationLiteral_3066 = getElementType("org.eclipse.papyrus.uml.diagram.composite.EnumerationLiteral_3066"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Link_4022 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Link_4022"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Link_4001 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Link_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4002 = getElementType("org.eclipse.papyrus.uml.diagram.composite.CommentAnnotatedElement_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4003 = getElementType("org.eclipse.papyrus.uml.diagram.composite.ConstraintConstrainedElement_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ComponentRealization_4004 = getElementType("org.eclipse.papyrus.uml.diagram.composite.ComponentRealization_4004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InterfaceRealization_4005 = getElementType("org.eclipse.papyrus.uml.diagram.composite.InterfaceRealization_4005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Substitution_4011 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Substitution_4011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Realization_4006 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Realization_4006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Manifestation_4012 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Manifestation_4012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Abstraction_4007 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Abstraction_4007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Usage_4008 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Usage_4008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Deployment_4009 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Deployment_4009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Dependency_4017 = getElementType("org.eclipse.papyrus.uml.diagram.composite.RoleBinding_4017"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Dependency_4010 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Dependency_4010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Connector_4013 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Connector_4013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Generalization_4015 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Generalization_4015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TimeObservationEvent_4018 = getElementType("org.eclipse.papyrus.uml.diagram.composite.TimeObservationEvent_4018"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DurationObservationEvent_4019 = getElementType("org.eclipse.papyrus.uml.diagram.composite.DurationObservationEvent_4019"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InformationItemRepresented_4020 = getElementType("org.eclipse.papyrus.uml.diagram.composite.Representation_4020"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InformationFlow_4021 = getElementType("org.eclipse.papyrus.uml.diagram.composite.InformationFlow_4021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static synchronized ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();
			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());
			elements.put(Activity_2060, UMLPackage.eINSTANCE.getActivity());
			elements.put(Interaction_2061, UMLPackage.eINSTANCE.getInteraction());
			elements.put(ProtocolStateMachine_2062, UMLPackage.eINSTANCE.getProtocolStateMachine());
			elements.put(StateMachine_2063, UMLPackage.eINSTANCE.getStateMachine());
			elements.put(FunctionBehavior_2064, UMLPackage.eINSTANCE.getFunctionBehavior());
			elements.put(OpaqueBehavior_2065, UMLPackage.eINSTANCE.getOpaqueBehavior());
			elements.put(Component_2069, UMLPackage.eINSTANCE.getComponent());
			elements.put(Device_2070, UMLPackage.eINSTANCE.getDevice());
			elements.put(ExecutionEnvironment_2071, UMLPackage.eINSTANCE.getExecutionEnvironment());
			elements.put(Node_2072, UMLPackage.eINSTANCE.getNode());
			elements.put(Class_2073, UMLPackage.eINSTANCE.getClass_());
			elements.put(Collaboration_2075, UMLPackage.eINSTANCE.getCollaboration());
			elements.put(Interface_2076, UMLPackage.eINSTANCE.getInterface());
			elements.put(PrimitiveType_2066, UMLPackage.eINSTANCE.getPrimitiveType());
			elements.put(Enumeration_2067, UMLPackage.eINSTANCE.getEnumeration());
			elements.put(DataType_2068, UMLPackage.eINSTANCE.getDataType());
			elements.put(Actor_2077, UMLPackage.eINSTANCE.getActor());
			elements.put(DeploymentSpecification_2078, UMLPackage.eINSTANCE.getDeploymentSpecification());
			elements.put(Artifact_2079, UMLPackage.eINSTANCE.getArtifact());
			elements.put(InformationItem_2080, UMLPackage.eINSTANCE.getInformationItem());
			elements.put(Signal_2081, UMLPackage.eINSTANCE.getSignal());
			elements.put(UseCase_2082, UMLPackage.eINSTANCE.getUseCase());
			elements.put(SignalEvent_2083, UMLPackage.eINSTANCE.getSignalEvent());
			elements.put(CallEvent_2084, UMLPackage.eINSTANCE.getCallEvent());
			elements.put(AnyReceiveEvent_2085, UMLPackage.eINSTANCE.getAnyReceiveEvent());
			elements.put(ChangeEvent_2088, UMLPackage.eINSTANCE.getChangeEvent());
			elements.put(TimeEvent_2089, UMLPackage.eINSTANCE.getTimeEvent());
			elements.put(DurationObservation_2093, UMLPackage.eINSTANCE.getDurationObservation());
			elements.put(TimeObservation_2094, UMLPackage.eINSTANCE.getTimeObservation());
			elements.put(LiteralBoolean_2095, UMLPackage.eINSTANCE.getLiteralBoolean());
			elements.put(LiteralInteger_2096, UMLPackage.eINSTANCE.getLiteralInteger());
			elements.put(LiteralNull_2097, UMLPackage.eINSTANCE.getLiteralNull());
			elements.put(LiteralString_2098, UMLPackage.eINSTANCE.getLiteralString());
			elements.put(LiteralUnlimitedNatural_2099, UMLPackage.eINSTANCE.getLiteralUnlimitedNatural());
			elements.put(StringExpression_2100, UMLPackage.eINSTANCE.getStringExpression());
			elements.put(OpaqueExpression_2101, UMLPackage.eINSTANCE.getOpaqueExpression());
			elements.put(TimeExpression_2102, UMLPackage.eINSTANCE.getTimeExpression());
			elements.put(Expression_2103, UMLPackage.eINSTANCE.getExpression());
			elements.put(Duration_2104, UMLPackage.eINSTANCE.getDuration());
			elements.put(TimeInterval_2105, UMLPackage.eINSTANCE.getTimeInterval());
			elements.put(DurationInterval_2106, UMLPackage.eINSTANCE.getDurationInterval());
			elements.put(Interval_2107, UMLPackage.eINSTANCE.getInterval());
			elements.put(InstanceValue_2108, UMLPackage.eINSTANCE.getInstanceValue());
			elements.put(Comment_2109, UMLPackage.eINSTANCE.getComment());
			elements.put(DurationConstraint_2110, UMLPackage.eINSTANCE.getDurationConstraint());
			elements.put(TimeConstraint_2111, UMLPackage.eINSTANCE.getTimeConstraint());
			elements.put(IntervalConstraint_2112, UMLPackage.eINSTANCE.getIntervalConstraint());
			elements.put(InteractionConstraint_2113, UMLPackage.eINSTANCE.getInteractionConstraint());
			elements.put(Constraint_2114, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Port_3069, UMLPackage.eINSTANCE.getPort());
			elements.put(Parameter_3088, UMLPackage.eINSTANCE.getParameter());
			elements.put(Property_3070, UMLPackage.eINSTANCE.getProperty());
			elements.put(ConnectableElement_3115, UMLPackage.eINSTANCE.getConnectableElement());
			elements.put(CollaborationUse_3071, UMLPackage.eINSTANCE.getCollaborationUse());
			elements.put(Activity_3072, UMLPackage.eINSTANCE.getActivity());
			elements.put(Interaction_3073, UMLPackage.eINSTANCE.getInteraction());
			elements.put(ProtocolStateMachine_3074, UMLPackage.eINSTANCE.getProtocolStateMachine());
			elements.put(StateMachine_3075, UMLPackage.eINSTANCE.getStateMachine());
			elements.put(FunctionBehavior_3076, UMLPackage.eINSTANCE.getFunctionBehavior());
			elements.put(OpaqueBehavior_3077, UMLPackage.eINSTANCE.getOpaqueBehavior());
			elements.put(Component_3081, UMLPackage.eINSTANCE.getComponent());
			elements.put(Device_3082, UMLPackage.eINSTANCE.getDevice());
			elements.put(ExecutionEnvironment_3083, UMLPackage.eINSTANCE.getExecutionEnvironment());
			elements.put(Node_3084, UMLPackage.eINSTANCE.getNode());
			elements.put(Class_3085, UMLPackage.eINSTANCE.getClass_());
			elements.put(Collaboration_3086, UMLPackage.eINSTANCE.getCollaboration());
			elements.put(Interface_3087, UMLPackage.eINSTANCE.getInterface());
			elements.put(PrimitiveType_3078, UMLPackage.eINSTANCE.getPrimitiveType());
			elements.put(Enumeration_3079, UMLPackage.eINSTANCE.getEnumeration());
			elements.put(DataType_3080, UMLPackage.eINSTANCE.getDataType());
			elements.put(Actor_3091, UMLPackage.eINSTANCE.getActor());
			elements.put(DeploymentSpecification_3092, UMLPackage.eINSTANCE.getDeploymentSpecification());
			elements.put(Artifact_3093, UMLPackage.eINSTANCE.getArtifact());
			elements.put(InformationItem_3094, UMLPackage.eINSTANCE.getInformationItem());
			elements.put(Signal_3095, UMLPackage.eINSTANCE.getSignal());
			elements.put(UseCase_3096, UMLPackage.eINSTANCE.getUseCase());
			elements.put(Comment_3097, UMLPackage.eINSTANCE.getComment());
			elements.put(DurationConstraint_3116, UMLPackage.eINSTANCE.getDurationConstraint());
			elements.put(TimeConstraint_3117, UMLPackage.eINSTANCE.getTimeConstraint());
			elements.put(IntervalConstraint_3118, UMLPackage.eINSTANCE.getIntervalConstraint());
			elements.put(InteractionConstraint_3119, UMLPackage.eINSTANCE.getInteractionConstraint());
			elements.put(Constraint_3120, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Property_3101, UMLPackage.eINSTANCE.getProperty());
			elements.put(Operation_3102, UMLPackage.eINSTANCE.getOperation());
			elements.put(EnumerationLiteral_3066, UMLPackage.eINSTANCE.getEnumerationLiteral());
			elements.put(CommentAnnotatedElement_4002, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
			elements.put(ConstraintConstrainedElement_4003, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
			elements.put(ComponentRealization_4004, UMLPackage.eINSTANCE.getComponentRealization());
			elements.put(InterfaceRealization_4005, UMLPackage.eINSTANCE.getInterfaceRealization());
			elements.put(Substitution_4011, UMLPackage.eINSTANCE.getSubstitution());
			elements.put(Realization_4006, UMLPackage.eINSTANCE.getRealization());
			elements.put(Manifestation_4012, UMLPackage.eINSTANCE.getManifestation());
			elements.put(Abstraction_4007, UMLPackage.eINSTANCE.getAbstraction());
			elements.put(Usage_4008, UMLPackage.eINSTANCE.getUsage());
			elements.put(Deployment_4009, UMLPackage.eINSTANCE.getDeployment());
			elements.put(Dependency_4017, UMLPackage.eINSTANCE.getDependency());
			elements.put(Dependency_4010, UMLPackage.eINSTANCE.getDependency());
			elements.put(Connector_4013, UMLPackage.eINSTANCE.getConnector());
			elements.put(Generalization_4015, UMLPackage.eINSTANCE.getGeneralization());
			elements.put(TimeObservationEvent_4018, UMLPackage.eINSTANCE.getTimeObservation_Event());
			elements.put(DurationObservationEvent_4019, UMLPackage.eINSTANCE.getDurationObservation_Event());
			elements.put(InformationItemRepresented_4020, UMLPackage.eINSTANCE.getInformationItem_Represented());
			elements.put(InformationFlow_4021, UMLPackage.eINSTANCE.getInformationFlow());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static synchronized boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Activity_2060);
			KNOWN_ELEMENT_TYPES.add(Interaction_2061);
			KNOWN_ELEMENT_TYPES.add(ProtocolStateMachine_2062);
			KNOWN_ELEMENT_TYPES.add(StateMachine_2063);
			KNOWN_ELEMENT_TYPES.add(FunctionBehavior_2064);
			KNOWN_ELEMENT_TYPES.add(OpaqueBehavior_2065);
			KNOWN_ELEMENT_TYPES.add(Component_2069);
			KNOWN_ELEMENT_TYPES.add(Device_2070);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_2071);
			KNOWN_ELEMENT_TYPES.add(Node_2072);
			KNOWN_ELEMENT_TYPES.add(Class_2073);
			KNOWN_ELEMENT_TYPES.add(Collaboration_2075);
			KNOWN_ELEMENT_TYPES.add(Interface_2076);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_2066);
			KNOWN_ELEMENT_TYPES.add(Enumeration_2067);
			KNOWN_ELEMENT_TYPES.add(DataType_2068);
			KNOWN_ELEMENT_TYPES.add(Actor_2077);
			KNOWN_ELEMENT_TYPES.add(DeploymentSpecification_2078);
			KNOWN_ELEMENT_TYPES.add(Artifact_2079);
			KNOWN_ELEMENT_TYPES.add(InformationItem_2080);
			KNOWN_ELEMENT_TYPES.add(Signal_2081);
			KNOWN_ELEMENT_TYPES.add(UseCase_2082);
			KNOWN_ELEMENT_TYPES.add(SignalEvent_2083);
			KNOWN_ELEMENT_TYPES.add(CallEvent_2084);
			KNOWN_ELEMENT_TYPES.add(AnyReceiveEvent_2085);
			KNOWN_ELEMENT_TYPES.add(ChangeEvent_2088);
			KNOWN_ELEMENT_TYPES.add(TimeEvent_2089);
			KNOWN_ELEMENT_TYPES.add(DurationObservation_2093);
			KNOWN_ELEMENT_TYPES.add(TimeObservation_2094);
			KNOWN_ELEMENT_TYPES.add(LiteralBoolean_2095);
			KNOWN_ELEMENT_TYPES.add(LiteralInteger_2096);
			KNOWN_ELEMENT_TYPES.add(LiteralNull_2097);
			KNOWN_ELEMENT_TYPES.add(LiteralString_2098);
			KNOWN_ELEMENT_TYPES.add(LiteralUnlimitedNatural_2099);
			KNOWN_ELEMENT_TYPES.add(StringExpression_2100);
			KNOWN_ELEMENT_TYPES.add(OpaqueExpression_2101);
			KNOWN_ELEMENT_TYPES.add(TimeExpression_2102);
			KNOWN_ELEMENT_TYPES.add(Expression_2103);
			KNOWN_ELEMENT_TYPES.add(Duration_2104);
			KNOWN_ELEMENT_TYPES.add(TimeInterval_2105);
			KNOWN_ELEMENT_TYPES.add(DurationInterval_2106);
			KNOWN_ELEMENT_TYPES.add(Interval_2107);
			KNOWN_ELEMENT_TYPES.add(InstanceValue_2108);
			KNOWN_ELEMENT_TYPES.add(Comment_2109);
			KNOWN_ELEMENT_TYPES.add(DurationConstraint_2110);
			KNOWN_ELEMENT_TYPES.add(TimeConstraint_2111);
			KNOWN_ELEMENT_TYPES.add(IntervalConstraint_2112);
			KNOWN_ELEMENT_TYPES.add(InteractionConstraint_2113);
			KNOWN_ELEMENT_TYPES.add(Constraint_2114);
			KNOWN_ELEMENT_TYPES.add(Node_3121);
			KNOWN_ELEMENT_TYPES.add(Port_3069);
			KNOWN_ELEMENT_TYPES.add(Parameter_3088);
			KNOWN_ELEMENT_TYPES.add(Property_3070);
			KNOWN_ELEMENT_TYPES.add(ConnectableElement_3115);
			KNOWN_ELEMENT_TYPES.add(CollaborationUse_3071);
			KNOWN_ELEMENT_TYPES.add(Activity_3072);
			KNOWN_ELEMENT_TYPES.add(Interaction_3073);
			KNOWN_ELEMENT_TYPES.add(ProtocolStateMachine_3074);
			KNOWN_ELEMENT_TYPES.add(StateMachine_3075);
			KNOWN_ELEMENT_TYPES.add(FunctionBehavior_3076);
			KNOWN_ELEMENT_TYPES.add(OpaqueBehavior_3077);
			KNOWN_ELEMENT_TYPES.add(Component_3081);
			KNOWN_ELEMENT_TYPES.add(Device_3082);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_3083);
			KNOWN_ELEMENT_TYPES.add(Node_3084);
			KNOWN_ELEMENT_TYPES.add(Class_3085);
			KNOWN_ELEMENT_TYPES.add(Collaboration_3086);
			KNOWN_ELEMENT_TYPES.add(Interface_3087);
			KNOWN_ELEMENT_TYPES.add(PrimitiveType_3078);
			KNOWN_ELEMENT_TYPES.add(Enumeration_3079);
			KNOWN_ELEMENT_TYPES.add(DataType_3080);
			KNOWN_ELEMENT_TYPES.add(Actor_3091);
			KNOWN_ELEMENT_TYPES.add(DeploymentSpecification_3092);
			KNOWN_ELEMENT_TYPES.add(Artifact_3093);
			KNOWN_ELEMENT_TYPES.add(InformationItem_3094);
			KNOWN_ELEMENT_TYPES.add(Signal_3095);
			KNOWN_ELEMENT_TYPES.add(UseCase_3096);
			KNOWN_ELEMENT_TYPES.add(Comment_3097);
			KNOWN_ELEMENT_TYPES.add(DurationConstraint_3116);
			KNOWN_ELEMENT_TYPES.add(TimeConstraint_3117);
			KNOWN_ELEMENT_TYPES.add(IntervalConstraint_3118);
			KNOWN_ELEMENT_TYPES.add(InteractionConstraint_3119);
			KNOWN_ELEMENT_TYPES.add(Constraint_3120);
			KNOWN_ELEMENT_TYPES.add(Property_3101);
			KNOWN_ELEMENT_TYPES.add(Operation_3102);
			KNOWN_ELEMENT_TYPES.add(EnumerationLiteral_3066);
			KNOWN_ELEMENT_TYPES.add(Link_4022);
			KNOWN_ELEMENT_TYPES.add(Link_4001);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4002);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4003);
			KNOWN_ELEMENT_TYPES.add(ComponentRealization_4004);
			KNOWN_ELEMENT_TYPES.add(InterfaceRealization_4005);
			KNOWN_ELEMENT_TYPES.add(Substitution_4011);
			KNOWN_ELEMENT_TYPES.add(Realization_4006);
			KNOWN_ELEMENT_TYPES.add(Manifestation_4012);
			KNOWN_ELEMENT_TYPES.add(Abstraction_4007);
			KNOWN_ELEMENT_TYPES.add(Usage_4008);
			KNOWN_ELEMENT_TYPES.add(Deployment_4009);
			KNOWN_ELEMENT_TYPES.add(Dependency_4017);
			KNOWN_ELEMENT_TYPES.add(Dependency_4010);
			KNOWN_ELEMENT_TYPES.add(Connector_4013);
			KNOWN_ELEMENT_TYPES.add(Generalization_4015);
			KNOWN_ELEMENT_TYPES.add(TimeObservationEvent_4018);
			KNOWN_ELEMENT_TYPES.add(DurationObservationEvent_4019);
			KNOWN_ELEMENT_TYPES.add(InformationItemRepresented_4020);
			KNOWN_ELEMENT_TYPES.add(InformationFlow_4021);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case CompositeStructureDiagramEditPart.VISUAL_ID:
			return Package_1000;
		case ActivityCompositeEditPart.VISUAL_ID:
			return Activity_2060;
		case InteractionCompositeEditPart.VISUAL_ID:
			return Interaction_2061;
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			return ProtocolStateMachine_2062;
		case StateMachineCompositeEditPart.VISUAL_ID:
			return StateMachine_2063;
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			return FunctionBehavior_2064;
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			return OpaqueBehavior_2065;
		case ComponentCompositeEditPart.VISUAL_ID:
			return Component_2069;
		case DeviceCompositeEditPart.VISUAL_ID:
			return Device_2070;
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			return ExecutionEnvironment_2071;
		case NodeCompositeEditPart.VISUAL_ID:
			return Node_2072;
		case ClassCompositeEditPart.VISUAL_ID:
			return Class_2073;
		case CollaborationCompositeEditPart.VISUAL_ID:
			return Collaboration_2075;
		case InterfaceEditPart.VISUAL_ID:
			return Interface_2076;
		case PrimitiveTypeEditPart.VISUAL_ID:
			return PrimitiveType_2066;
		case EnumerationEditPart.VISUAL_ID:
			return Enumeration_2067;
		case DataTypeEditPart.VISUAL_ID:
			return DataType_2068;
		case ActorEditPart.VISUAL_ID:
			return Actor_2077;
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return DeploymentSpecification_2078;
		case ArtifactEditPart.VISUAL_ID:
			return Artifact_2079;
		case InformationItemEditPart.VISUAL_ID:
			return InformationItem_2080;
		case SignalEditPart.VISUAL_ID:
			return Signal_2081;
		case UseCaseEditPart.VISUAL_ID:
			return UseCase_2082;
		case SignalEventEditPart.VISUAL_ID:
			return SignalEvent_2083;
		case CallEventEditPart.VISUAL_ID:
			return CallEvent_2084;
		case AnyReceiveEventEditPart.VISUAL_ID:
			return AnyReceiveEvent_2085;
		case ChangeEventEditPart.VISUAL_ID:
			return ChangeEvent_2088;
		case TimeEventEditPart.VISUAL_ID:
			return TimeEvent_2089;
		case DurationObservationEditPart.VISUAL_ID:
			return DurationObservation_2093;
		case TimeObservationEditPart.VISUAL_ID:
			return TimeObservation_2094;
		case LiteralBooleanEditPart.VISUAL_ID:
			return LiteralBoolean_2095;
		case LiteralIntegerEditPart.VISUAL_ID:
			return LiteralInteger_2096;
		case LiteralNullEditPart.VISUAL_ID:
			return LiteralNull_2097;
		case LiteralStringEditPart.VISUAL_ID:
			return LiteralString_2098;
		case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
			return LiteralUnlimitedNatural_2099;
		case StringExpressionEditPart.VISUAL_ID:
			return StringExpression_2100;
		case OpaqueExpressionEditPart.VISUAL_ID:
			return OpaqueExpression_2101;
		case TimeExpressionEditPart.VISUAL_ID:
			return TimeExpression_2102;
		case ExpressionEditPart.VISUAL_ID:
			return Expression_2103;
		case DurationEditPart.VISUAL_ID:
			return Duration_2104;
		case TimeIntervalEditPart.VISUAL_ID:
			return TimeInterval_2105;
		case DurationIntervalEditPart.VISUAL_ID:
			return DurationInterval_2106;
		case IntervalEditPart.VISUAL_ID:
			return Interval_2107;
		case InstanceValueEditPart.VISUAL_ID:
			return InstanceValue_2108;
		case CommentEditPart.VISUAL_ID:
			return Comment_2109;
		case DurationConstraintEditPart.VISUAL_ID:
			return DurationConstraint_2110;
		case TimeConstraintEditPart.VISUAL_ID:
			return TimeConstraint_2111;
		case IntervalConstraintEditPart.VISUAL_ID:
			return IntervalConstraint_2112;
		case InteractionConstraintEditPart.VISUAL_ID:
			return InteractionConstraint_2113;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_2114;
		case BehaviorPortEditPart.VISUAL_ID:
			return Node_3121;
		case PortEditPart.VISUAL_ID:
			return Port_3069;
		case ParameterEditPart.VISUAL_ID:
			return Parameter_3088;
		case PropertyPartEditPartCN.VISUAL_ID:
			return Property_3070;
		case CollaborationRoleEditPartCN.VISUAL_ID:
			return ConnectableElement_3115;
		case CollaborationUseEditPartCN.VISUAL_ID:
			return CollaborationUse_3071;
		case ActivityCompositeEditPartCN.VISUAL_ID:
			return Activity_3072;
		case InteractionCompositeEditPartCN.VISUAL_ID:
			return Interaction_3073;
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			return ProtocolStateMachine_3074;
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			return StateMachine_3075;
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			return FunctionBehavior_3076;
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			return OpaqueBehavior_3077;
		case ComponentCompositeEditPartCN.VISUAL_ID:
			return Component_3081;
		case DeviceCompositeEditPartCN.VISUAL_ID:
			return Device_3082;
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			return ExecutionEnvironment_3083;
		case NodeCompositeEditPartCN.VISUAL_ID:
			return Node_3084;
		case ClassCompositeEditPartCN.VISUAL_ID:
			return Class_3085;
		case CollaborationCompositeEditPartCN.VISUAL_ID:
			return Collaboration_3086;
		case InterfaceEditPartCN.VISUAL_ID:
			return Interface_3087;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return PrimitiveType_3078;
		case EnumerationEditPartCN.VISUAL_ID:
			return Enumeration_3079;
		case DataTypeEditPartCN.VISUAL_ID:
			return DataType_3080;
		case ActorEditPartCN.VISUAL_ID:
			return Actor_3091;
		case DeploymentSpecificationEditPartCN.VISUAL_ID:
			return DeploymentSpecification_3092;
		case ArtifactEditPartCN.VISUAL_ID:
			return Artifact_3093;
		case InformationItemEditPartCN.VISUAL_ID:
			return InformationItem_3094;
		case SignalEditPartCN.VISUAL_ID:
			return Signal_3095;
		case UseCaseEditPartCN.VISUAL_ID:
			return UseCase_3096;
		case CommentEditPartCN.VISUAL_ID:
			return Comment_3097;
		case DurationConstraintEditPartCN.VISUAL_ID:
			return DurationConstraint_3116;
		case TimeConstraintEditPartCN.VISUAL_ID:
			return TimeConstraint_3117;
		case IntervalConstraintEditPartCN.VISUAL_ID:
			return IntervalConstraint_3118;
		case InteractionConstraintEditPartCN.VISUAL_ID:
			return InteractionConstraint_3119;
		case ConstraintEditPartCN.VISUAL_ID:
			return Constraint_3120;
		case PropertyEditPartCLN.VISUAL_ID:
			return Property_3101;
		case OperationEditPartCLN.VISUAL_ID:
			return Operation_3102;
		case EnumerationLiteralEditPartCLN.VISUAL_ID:
			return EnumerationLiteral_3066;
		case BehaviorPortLinkEditPart.VISUAL_ID:
			return Link_4022;
		case LinkDescriptorEditPart.VISUAL_ID:
			return Link_4001;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4002;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4003;
		case ComponentRealizationEditPart.VISUAL_ID:
			return ComponentRealization_4004;
		case InterfaceRealizationEditPart.VISUAL_ID:
			return InterfaceRealization_4005;
		case SubstitutionEditPart.VISUAL_ID:
			return Substitution_4011;
		case RealizationEditPart.VISUAL_ID:
			return Realization_4006;
		case ManifestationEditPart.VISUAL_ID:
			return Manifestation_4012;
		case AbstractionEditPart.VISUAL_ID:
			return Abstraction_4007;
		case UsageEditPart.VISUAL_ID:
			return Usage_4008;
		case DeploymentEditPart.VISUAL_ID:
			return Deployment_4009;
		case RoleBindingEditPart.VISUAL_ID:
			return Dependency_4017;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4010;
		case ConnectorEditPart.VISUAL_ID:
			return Connector_4013;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4015;
		case TimeObservationEventEditPart.VISUAL_ID:
			return TimeObservationEvent_4018;
		case DurationObservationEventEditPart.VISUAL_ID:
			return DurationObservationEvent_4019;
		case RepresentationEditPart.VISUAL_ID:
			return InformationItemRepresented_4020;
		case InformationFlowEditPart.VISUAL_ID:
			return InformationFlow_4021;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {
		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.getElement(elementTypeAdapter);
		}
	};
}
