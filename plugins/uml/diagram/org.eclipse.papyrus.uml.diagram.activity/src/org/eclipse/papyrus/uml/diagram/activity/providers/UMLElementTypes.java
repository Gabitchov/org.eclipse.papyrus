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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.providers;

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
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
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
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Activity_2001 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Activity_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Parameter_3001 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Parameter_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3002 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Constraint_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3003 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Constraint_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InitialNode_3004 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InitialNode_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActivityFinalNode_3005 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActivityFinalNode_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FlowFinalNode_3006 = getElementType("org.eclipse.papyrus.uml.diagram.activity.FlowFinalNode_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OpaqueAction_3007 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OpaqueAction_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3015 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValuePin_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3016 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionInputPin_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3013 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3014 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallBehaviorAction_3008 = getElementType("org.eclipse.papyrus.uml.diagram.activity.CallBehaviorAction_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3017 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValuePin_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3018 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionInputPin_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3019 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3020 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallOperationAction_3010 = getElementType("org.eclipse.papyrus.uml.diagram.activity.CallOperationAction_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3021 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionInputPin_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3022 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValuePin_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3023 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3024 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3025 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValuePin_3025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3026 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionInputPin_3026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3027 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3011 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Constraint_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3012 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Constraint_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DecisionNode_3038 = getElementType("org.eclipse.papyrus.uml.diagram.activity.DecisionNode_3038"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MergeNode_3039 = getElementType("org.eclipse.papyrus.uml.diagram.activity.MergeNode_3039"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForkNode_3040 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ForkNode_3040"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType JoinNode_3041 = getElementType("org.eclipse.papyrus.uml.diagram.activity.JoinNode_3041"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SendObjectAction_3042 = getElementType("org.eclipse.papyrus.uml.diagram.activity.SendObjectAction_3042"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3046 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValuePin_3046"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3047 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionInputPin_3047"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3048 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3048"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3049 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValuePin_3049"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3050 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionInputPin_3050"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3051 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3051"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SendSignalAction_3052 = getElementType("org.eclipse.papyrus.uml.diagram.activity.SendSignalAction_3052"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3053 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionInputPin_3053"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3054 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValuePin_3054"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3055 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3055"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3060 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValuePin_3060"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3061 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionInputPin_3061"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3062 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3062"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActivityParameterNode_3059 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActivityParameterNode_3059"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AcceptEventAction_3063 = getElementType("org.eclipse.papyrus.uml.diagram.activity.AcceptEventAction_3063"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3064 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3064"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StructuredActivityNode_3065 = getElementType("org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode_3065"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3105 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3105"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActivityPartition_3067 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActivityPartition_3067"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InterruptibleActivityRegion_3068 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InterruptibleActivityRegion_3068"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_3080 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Comment_3080"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ReadSelfAction_3081 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ReadSelfAction_3081"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3084 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3084"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Activity_3083 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Activity_3083"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedElement_3085 = getElementType("org.eclipse.papyrus.uml.diagram.activity.NamedElement_3085"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CreateObjectAction_3086 = getElementType("org.eclipse.papyrus.uml.diagram.activity.CreateObjectAction_3086"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3087 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3087"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ReadStructuralFeatureAction_3088 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ReadStructuralFeatureAction_3088"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3089 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3089"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3090 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3090"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddStructuralFeatureValueAction_3091 = getElementType("org.eclipse.papyrus.uml.diagram.activity.AddStructuralFeatureValueAction_3091"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3092 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3092"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3093 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3093"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3094 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3094"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DestroyObjectAction_3095 = getElementType("org.eclipse.papyrus.uml.diagram.activity.DestroyObjectAction_3095"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3096 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3096"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ReadVariableAction_3097 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ReadVariableAction_3097"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3098 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3098"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddVariableValueAction_3099 = getElementType("org.eclipse.papyrus.uml.diagram.activity.AddVariableValueAction_3099"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3100 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3100"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3101 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3101"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BroadcastSignalAction_3102 = getElementType("org.eclipse.papyrus.uml.diagram.activity.BroadcastSignalAction_3102"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3103 = getElementType("org.eclipse.papyrus.uml.diagram.activity.InputPin_3103"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CentralBufferNode_3104 = getElementType("org.eclipse.papyrus.uml.diagram.activity.CentralBufferNode_3104"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3112 = getElementType("org.eclipse.papyrus.uml.diagram.activity.Constraint_3112"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValueSpecificationAction_3076 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ValueSpecificationAction_3076"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3077 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3077"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataStoreNode_3078 = getElementType("org.eclipse.papyrus.uml.diagram.activity.DataStoreNode_3078"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConditionalNode_3069 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ConditionalNode_3069"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExpansionRegion_3070 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ExpansionRegion_3070"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExpansionNode_3074 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ExpansionNode_3074"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExpansionNode_3075 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ExpansionNode_3075"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoopNode_3071 = getElementType("org.eclipse.papyrus.uml.diagram.activity.LoopNode_3071"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3109 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3109"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3110 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3110"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3111 = getElementType("org.eclipse.papyrus.uml.diagram.activity.OutputPin_3111"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SequenceNode_3073 = getElementType("org.eclipse.papyrus.uml.diagram.activity.SequenceNode_3073"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IntervalConstraint_3032 = getElementType("org.eclipse.papyrus.uml.diagram.activity.IntervalConstraint_3032"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IntervalConstraint_3033 = getElementType("org.eclipse.papyrus.uml.diagram.activity.IntervalConstraint_3033"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_3034 = getElementType("org.eclipse.papyrus.uml.diagram.activity.DurationConstraint_3034"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_3035 = getElementType("org.eclipse.papyrus.uml.diagram.activity.DurationConstraint_3035"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeConstraint_3036 = getElementType("org.eclipse.papyrus.uml.diagram.activity.TimeConstraint_3036"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeConstraint_3037 = getElementType("org.eclipse.papyrus.uml.diagram.activity.TimeConstraint_3037"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionLocalPrecondition_4001 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionLocalPrecondition_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionLocalPostcondition_4002 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ActionLocalPostcondition_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ObjectFlow_4003 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ObjectFlow_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ControlFlow_4004 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ControlFlow_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExceptionHandler_4005 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ExceptionHandler_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4006 = getElementType("org.eclipse.papyrus.uml.diagram.activity.CommentAnnotatedElement_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4007 = getElementType("org.eclipse.papyrus.uml.diagram.activity.ConstraintConstrainedElement_4007"); //$NON-NLS-1$

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
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if(elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();
			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());
			elements.put(Activity_2001, UMLPackage.eINSTANCE.getActivity());
			elements.put(Parameter_3001, UMLPackage.eINSTANCE.getParameter());
			elements.put(Constraint_3002, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Constraint_3003, UMLPackage.eINSTANCE.getConstraint());
			elements.put(InitialNode_3004, UMLPackage.eINSTANCE.getInitialNode());
			elements.put(ActivityFinalNode_3005, UMLPackage.eINSTANCE.getActivityFinalNode());
			elements.put(FlowFinalNode_3006, UMLPackage.eINSTANCE.getFlowFinalNode());
			elements.put(OpaqueAction_3007, UMLPackage.eINSTANCE.getOpaqueAction());
			elements.put(ValuePin_3015, UMLPackage.eINSTANCE.getValuePin());
			elements.put(ActionInputPin_3016, UMLPackage.eINSTANCE.getActionInputPin());
			elements.put(InputPin_3013, UMLPackage.eINSTANCE.getInputPin());
			elements.put(OutputPin_3014, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(CallBehaviorAction_3008, UMLPackage.eINSTANCE.getCallBehaviorAction());
			elements.put(ValuePin_3017, UMLPackage.eINSTANCE.getValuePin());
			elements.put(ActionInputPin_3018, UMLPackage.eINSTANCE.getActionInputPin());
			elements.put(InputPin_3019, UMLPackage.eINSTANCE.getInputPin());
			elements.put(OutputPin_3020, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(CallOperationAction_3010, UMLPackage.eINSTANCE.getCallOperationAction());
			elements.put(ActionInputPin_3021, UMLPackage.eINSTANCE.getActionInputPin());
			elements.put(ValuePin_3022, UMLPackage.eINSTANCE.getValuePin());
			elements.put(InputPin_3023, UMLPackage.eINSTANCE.getInputPin());
			elements.put(OutputPin_3024, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(ValuePin_3025, UMLPackage.eINSTANCE.getValuePin());
			elements.put(ActionInputPin_3026, UMLPackage.eINSTANCE.getActionInputPin());
			elements.put(InputPin_3027, UMLPackage.eINSTANCE.getInputPin());
			elements.put(DurationConstraint_3034, UMLPackage.eINSTANCE.getDurationConstraint());
			elements.put(DurationConstraint_3035, UMLPackage.eINSTANCE.getDurationConstraint());
			elements.put(TimeConstraint_3036, UMLPackage.eINSTANCE.getTimeConstraint());
			elements.put(TimeConstraint_3037, UMLPackage.eINSTANCE.getTimeConstraint());
			elements.put(IntervalConstraint_3032, UMLPackage.eINSTANCE.getIntervalConstraint());
			elements.put(IntervalConstraint_3033, UMLPackage.eINSTANCE.getIntervalConstraint());
			elements.put(Constraint_3011, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Constraint_3012, UMLPackage.eINSTANCE.getConstraint());
			elements.put(DecisionNode_3038, UMLPackage.eINSTANCE.getDecisionNode());
			elements.put(MergeNode_3039, UMLPackage.eINSTANCE.getMergeNode());
			elements.put(ForkNode_3040, UMLPackage.eINSTANCE.getForkNode());
			elements.put(JoinNode_3041, UMLPackage.eINSTANCE.getJoinNode());
			elements.put(DataStoreNode_3078, UMLPackage.eINSTANCE.getDataStoreNode());
			elements.put(SendObjectAction_3042, UMLPackage.eINSTANCE.getSendObjectAction());
			elements.put(ValuePin_3046, UMLPackage.eINSTANCE.getValuePin());
			elements.put(ActionInputPin_3047, UMLPackage.eINSTANCE.getActionInputPin());
			elements.put(InputPin_3048, UMLPackage.eINSTANCE.getInputPin());
			elements.put(ValuePin_3049, UMLPackage.eINSTANCE.getValuePin());
			elements.put(ActionInputPin_3050, UMLPackage.eINSTANCE.getActionInputPin());
			elements.put(InputPin_3051, UMLPackage.eINSTANCE.getInputPin());
			elements.put(SendSignalAction_3052, UMLPackage.eINSTANCE.getSendSignalAction());
			elements.put(ActionInputPin_3053, UMLPackage.eINSTANCE.getActionInputPin());
			elements.put(ValuePin_3054, UMLPackage.eINSTANCE.getValuePin());
			elements.put(InputPin_3055, UMLPackage.eINSTANCE.getInputPin());
			elements.put(ValuePin_3060, UMLPackage.eINSTANCE.getValuePin());
			elements.put(ActionInputPin_3061, UMLPackage.eINSTANCE.getActionInputPin());
			elements.put(InputPin_3062, UMLPackage.eINSTANCE.getInputPin());
			elements.put(ActivityParameterNode_3059, UMLPackage.eINSTANCE.getActivityParameterNode());
			elements.put(AcceptEventAction_3063, UMLPackage.eINSTANCE.getAcceptEventAction());
			elements.put(OutputPin_3064, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(ValueSpecificationAction_3076, UMLPackage.eINSTANCE.getValueSpecificationAction());
			elements.put(OutputPin_3077, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(ConditionalNode_3069, UMLPackage.eINSTANCE.getConditionalNode());
			elements.put(ExpansionRegion_3070, UMLPackage.eINSTANCE.getExpansionRegion());
			elements.put(ExpansionNode_3074, UMLPackage.eINSTANCE.getExpansionNode());
			elements.put(ExpansionNode_3075, UMLPackage.eINSTANCE.getExpansionNode());
			elements.put(LoopNode_3071, UMLPackage.eINSTANCE.getLoopNode());
			elements.put(OutputPin_3109, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(OutputPin_3110, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(OutputPin_3111, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(SequenceNode_3073, UMLPackage.eINSTANCE.getSequenceNode());
			elements.put(StructuredActivityNode_3065, UMLPackage.eINSTANCE.getStructuredActivityNode());
			elements.put(InputPin_3105, UMLPackage.eINSTANCE.getInputPin());
			elements.put(ActivityPartition_3067, UMLPackage.eINSTANCE.getActivityPartition());
			elements.put(InterruptibleActivityRegion_3068, UMLPackage.eINSTANCE.getInterruptibleActivityRegion());
			elements.put(Comment_3080, UMLPackage.eINSTANCE.getComment());
			elements.put(ReadSelfAction_3081, UMLPackage.eINSTANCE.getReadSelfAction());
			elements.put(OutputPin_3084, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(Activity_3083, UMLPackage.eINSTANCE.getActivity());
			elements.put(CreateObjectAction_3086, UMLPackage.eINSTANCE.getCreateObjectAction());
			elements.put(OutputPin_3087, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(NamedElement_3085, UMLPackage.eINSTANCE.getNamedElement());
			elements.put(ReadStructuralFeatureAction_3088, UMLPackage.eINSTANCE.getReadStructuralFeatureAction());
			elements.put(InputPin_3089, UMLPackage.eINSTANCE.getInputPin());
			elements.put(OutputPin_3090, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(AddStructuralFeatureValueAction_3091, UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction());
			elements.put(InputPin_3092, UMLPackage.eINSTANCE.getInputPin());
			elements.put(InputPin_3093, UMLPackage.eINSTANCE.getInputPin());
			elements.put(OutputPin_3094, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(DestroyObjectAction_3095, UMLPackage.eINSTANCE.getDestroyObjectAction());
			elements.put(InputPin_3096, UMLPackage.eINSTANCE.getInputPin());
			elements.put(ReadVariableAction_3097, UMLPackage.eINSTANCE.getReadVariableAction());
			elements.put(OutputPin_3098, UMLPackage.eINSTANCE.getOutputPin());
			elements.put(AddVariableValueAction_3099, UMLPackage.eINSTANCE.getAddVariableValueAction());
			elements.put(InputPin_3100, UMLPackage.eINSTANCE.getInputPin());
			elements.put(InputPin_3101, UMLPackage.eINSTANCE.getInputPin());
			elements.put(BroadcastSignalAction_3102, UMLPackage.eINSTANCE.getBroadcastSignalAction());
			elements.put(InputPin_3103, UMLPackage.eINSTANCE.getInputPin());
			elements.put(CentralBufferNode_3104, UMLPackage.eINSTANCE.getCentralBufferNode());
			elements.put(Constraint_3112, UMLPackage.eINSTANCE.getConstraint());
			elements.put(ActionLocalPrecondition_4001, UMLPackage.eINSTANCE.getAction_LocalPrecondition());
			elements.put(ActionLocalPostcondition_4002, UMLPackage.eINSTANCE.getAction_LocalPostcondition());
			elements.put(ObjectFlow_4003, UMLPackage.eINSTANCE.getObjectFlow());
			elements.put(ControlFlow_4004, UMLPackage.eINSTANCE.getControlFlow());
			elements.put(ExceptionHandler_4005, UMLPackage.eINSTANCE.getExceptionHandler());
			elements.put(CommentAnnotatedElement_4006, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
			elements.put(ConstraintConstrainedElement_4007, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
		}
		return (ENamedElement)elements.get(type);
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
	public static boolean isKnownElementType(IElementType elementType) {
		if(KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Activity_2001);
			KNOWN_ELEMENT_TYPES.add(Parameter_3001);
			KNOWN_ELEMENT_TYPES.add(Constraint_3002);
			KNOWN_ELEMENT_TYPES.add(Constraint_3003);
			KNOWN_ELEMENT_TYPES.add(InitialNode_3004);
			KNOWN_ELEMENT_TYPES.add(ActivityFinalNode_3005);
			KNOWN_ELEMENT_TYPES.add(FlowFinalNode_3006);
			KNOWN_ELEMENT_TYPES.add(OpaqueAction_3007);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3015);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3016);
			KNOWN_ELEMENT_TYPES.add(InputPin_3013);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3014);
			KNOWN_ELEMENT_TYPES.add(CallBehaviorAction_3008);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3017);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3018);
			KNOWN_ELEMENT_TYPES.add(InputPin_3019);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3020);
			KNOWN_ELEMENT_TYPES.add(CallOperationAction_3010);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3021);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3022);
			KNOWN_ELEMENT_TYPES.add(InputPin_3023);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3024);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3025);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3026);
			KNOWN_ELEMENT_TYPES.add(InputPin_3027);
			KNOWN_ELEMENT_TYPES.add(DurationConstraint_3034);
			KNOWN_ELEMENT_TYPES.add(DurationConstraint_3035);
			KNOWN_ELEMENT_TYPES.add(TimeConstraint_3036);
			KNOWN_ELEMENT_TYPES.add(TimeConstraint_3037);
			KNOWN_ELEMENT_TYPES.add(IntervalConstraint_3032);
			KNOWN_ELEMENT_TYPES.add(IntervalConstraint_3033);
			KNOWN_ELEMENT_TYPES.add(Constraint_3011);
			KNOWN_ELEMENT_TYPES.add(Constraint_3012);
			KNOWN_ELEMENT_TYPES.add(DecisionNode_3038);
			KNOWN_ELEMENT_TYPES.add(MergeNode_3039);
			KNOWN_ELEMENT_TYPES.add(ForkNode_3040);
			KNOWN_ELEMENT_TYPES.add(JoinNode_3041);
			KNOWN_ELEMENT_TYPES.add(DataStoreNode_3078);
			KNOWN_ELEMENT_TYPES.add(SendObjectAction_3042);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3046);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3047);
			KNOWN_ELEMENT_TYPES.add(InputPin_3048);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3049);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3050);
			KNOWN_ELEMENT_TYPES.add(InputPin_3051);
			KNOWN_ELEMENT_TYPES.add(SendSignalAction_3052);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3053);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3054);
			KNOWN_ELEMENT_TYPES.add(InputPin_3055);
			KNOWN_ELEMENT_TYPES.add(ValuePin_3060);
			KNOWN_ELEMENT_TYPES.add(ActionInputPin_3061);
			KNOWN_ELEMENT_TYPES.add(InputPin_3062);
			KNOWN_ELEMENT_TYPES.add(ActivityParameterNode_3059);
			KNOWN_ELEMENT_TYPES.add(AcceptEventAction_3063);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3064);
			KNOWN_ELEMENT_TYPES.add(ValueSpecificationAction_3076);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3077);
			KNOWN_ELEMENT_TYPES.add(ConditionalNode_3069);
			KNOWN_ELEMENT_TYPES.add(ExpansionRegion_3070);
			KNOWN_ELEMENT_TYPES.add(ExpansionNode_3074);
			KNOWN_ELEMENT_TYPES.add(ExpansionNode_3075);
			KNOWN_ELEMENT_TYPES.add(LoopNode_3071);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3109);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3110);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3111);
			KNOWN_ELEMENT_TYPES.add(SequenceNode_3073);
			KNOWN_ELEMENT_TYPES.add(StructuredActivityNode_3065);
			KNOWN_ELEMENT_TYPES.add(InputPin_3105);
			KNOWN_ELEMENT_TYPES.add(ActivityPartition_3067);
			KNOWN_ELEMENT_TYPES.add(InterruptibleActivityRegion_3068);
			KNOWN_ELEMENT_TYPES.add(Comment_3080);
			KNOWN_ELEMENT_TYPES.add(ReadSelfAction_3081);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3084);
			KNOWN_ELEMENT_TYPES.add(Activity_3083);
			KNOWN_ELEMENT_TYPES.add(CreateObjectAction_3086);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3087);
			KNOWN_ELEMENT_TYPES.add(NamedElement_3085);
			KNOWN_ELEMENT_TYPES.add(ReadStructuralFeatureAction_3088);
			KNOWN_ELEMENT_TYPES.add(InputPin_3089);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3090);
			KNOWN_ELEMENT_TYPES.add(AddStructuralFeatureValueAction_3091);
			KNOWN_ELEMENT_TYPES.add(InputPin_3092);
			KNOWN_ELEMENT_TYPES.add(InputPin_3093);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3094);
			KNOWN_ELEMENT_TYPES.add(DestroyObjectAction_3095);
			KNOWN_ELEMENT_TYPES.add(InputPin_3096);
			KNOWN_ELEMENT_TYPES.add(ReadVariableAction_3097);
			KNOWN_ELEMENT_TYPES.add(OutputPin_3098);
			KNOWN_ELEMENT_TYPES.add(AddVariableValueAction_3099);
			KNOWN_ELEMENT_TYPES.add(InputPin_3100);
			KNOWN_ELEMENT_TYPES.add(InputPin_3101);
			KNOWN_ELEMENT_TYPES.add(BroadcastSignalAction_3102);
			KNOWN_ELEMENT_TYPES.add(InputPin_3103);
			KNOWN_ELEMENT_TYPES.add(CentralBufferNode_3104);
			KNOWN_ELEMENT_TYPES.add(Constraint_3112);
			KNOWN_ELEMENT_TYPES.add(ActionLocalPrecondition_4001);
			KNOWN_ELEMENT_TYPES.add(ActionLocalPostcondition_4002);
			KNOWN_ELEMENT_TYPES.add(ObjectFlow_4003);
			KNOWN_ELEMENT_TYPES.add(ControlFlow_4004);
			KNOWN_ELEMENT_TYPES.add(ExceptionHandler_4005);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4006);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4007);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case ActivityDiagramEditPart.VISUAL_ID:
			return Package_1000;
		case ActivityEditPart.VISUAL_ID:
			return Activity_2001;
		case ParameterEditPart.VISUAL_ID:
			return Parameter_3001;
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return Constraint_3002;
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return Constraint_3003;
		case InitialNodeEditPart.VISUAL_ID:
			return InitialNode_3004;
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return ActivityFinalNode_3005;
		case FlowFinalNodeEditPart.VISUAL_ID:
			return FlowFinalNode_3006;
		case OpaqueActionEditPart.VISUAL_ID:
			return OpaqueAction_3007;
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			return ValuePin_3015;
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			return ActionInputPin_3016;
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			return InputPin_3013;
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			return OutputPin_3014;
		case CallBehaviorActionEditPart.VISUAL_ID:
			return CallBehaviorAction_3008;
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			return ValuePin_3017;
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			return ActionInputPin_3018;
		case InputPinInCallBeActEditPart.VISUAL_ID:
			return InputPin_3019;
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			return OutputPin_3020;
		case CallOperationActionEditPart.VISUAL_ID:
			return CallOperationAction_3010;
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			return ActionInputPin_3021;
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			return ValuePin_3022;
		case InputPinInCallOpActEditPart.VISUAL_ID:
			return InputPin_3023;
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return OutputPin_3024;
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			return ValuePin_3025;
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return ActionInputPin_3026;
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return InputPin_3027;
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return DurationConstraint_3034;
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return DurationConstraint_3035;
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return TimeConstraint_3036;
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return TimeConstraint_3037;
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return IntervalConstraint_3032;
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return IntervalConstraint_3033;
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return Constraint_3011;
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return Constraint_3012;
		case DecisionNodeEditPart.VISUAL_ID:
			return DecisionNode_3038;
		case MergeNodeEditPart.VISUAL_ID:
			return MergeNode_3039;
		case ForkNodeEditPart.VISUAL_ID:
			return ForkNode_3040;
		case JoinNodeEditPart.VISUAL_ID:
			return JoinNode_3041;
		case DataStoreNodeEditPart.VISUAL_ID:
			return DataStoreNode_3078;
		case SendObjectActionEditPart.VISUAL_ID:
			return SendObjectAction_3042;
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
			return ValuePin_3046;
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return ActionInputPin_3047;
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return InputPin_3048;
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
			return ValuePin_3049;
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return ActionInputPin_3050;
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return InputPin_3051;
		case SendSignalActionEditPart.VISUAL_ID:
			return SendSignalAction_3052;
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
			return ActionInputPin_3053;
		case ValuePinInSendSigActEditPart.VISUAL_ID:
			return ValuePin_3054;
		case InputPinInSendSigActEditPart.VISUAL_ID:
			return InputPin_3055;
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
			return ValuePin_3060;
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return ActionInputPin_3061;
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return InputPin_3062;
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return ActivityParameterNode_3059;
		case AcceptEventActionEditPart.VISUAL_ID:
			return AcceptEventAction_3063;
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
			return OutputPin_3064;
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return ValueSpecificationAction_3076;
		case OutputPinInValSpecActEditPart.VISUAL_ID:
			return OutputPin_3077;
		case ConditionalNodeEditPart.VISUAL_ID:
			return ConditionalNode_3069;
		case ExpansionRegionEditPart.VISUAL_ID:
			return ExpansionRegion_3070;
		case ExpansionNodeAsInEditPart.VISUAL_ID:
			return ExpansionNode_3074;
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
			return ExpansionNode_3075;
		case LoopNodeEditPart.VISUAL_ID:
			return LoopNode_3071;
		case OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID:
			return OutputPin_3109;
		case OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID:
			return OutputPin_3110;
		case OutputPinInLoopNodeAsResultEditPart.VISUAL_ID:
			return OutputPin_3111;
		case SequenceNodeEditPart.VISUAL_ID:
			return SequenceNode_3073;
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return StructuredActivityNode_3065;
		case InputPinInLoopNodeAsVariableEditPart.VISUAL_ID:
			return InputPin_3105;
		case ActivityPartitionEditPart.VISUAL_ID:
			return ActivityPartition_3067;
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			return InterruptibleActivityRegion_3068;
		case CommentEditPartCN.VISUAL_ID:
			return Comment_3080;
		case ReadSelfActionEditPart.VISUAL_ID:
			return ReadSelfAction_3081;
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
			return OutputPin_3084;
		case ActivityEditPartCN.VISUAL_ID:
			return Activity_3083;
		case CreateObjectActionEditPart.VISUAL_ID:
			return CreateObjectAction_3086;
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
			return OutputPin_3087;
		case ShapeNamedElementEditPart.VISUAL_ID:
			return NamedElement_3085;
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			return ReadStructuralFeatureAction_3088;
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
			return InputPin_3089;
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
			return OutputPin_3090;
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return AddStructuralFeatureValueAction_3091;
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
			return InputPin_3092;
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
			return InputPin_3093;
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
			return OutputPin_3094;
		case DestroyObjectActionEditPart.VISUAL_ID:
			return DestroyObjectAction_3095;
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
			return InputPin_3096;
		case ReadVariableActionEditPart.VISUAL_ID:
			return ReadVariableAction_3097;
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
			return OutputPin_3098;
		case AddVariableValueActionEditPart.VISUAL_ID:
			return AddVariableValueAction_3099;
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
			return InputPin_3100;
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
			return InputPin_3101;
		case BroadcastSignalActionEditPart.VISUAL_ID:
			return BroadcastSignalAction_3102;
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
			return InputPin_3103;
		case CentralBufferNodeEditPart.VISUAL_ID:
			return CentralBufferNode_3104;
		case ConstraintEditPartCN.VISUAL_ID:
			return Constraint_3112;
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return ActionLocalPrecondition_4001;
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return ActionLocalPostcondition_4002;
		case ObjectFlowEditPart.VISUAL_ID:
			return ObjectFlow_4003;
		case ControlFlowEditPart.VISUAL_ID:
			return ControlFlow_4004;
		case ExceptionHandlerEditPart.VISUAL_ID:
			return ExceptionHandler_4005;
		case CommentLinkEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4006;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4007;
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
		public boolean isKnownElementType(IElementType elementType) {
			return org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes.getElement(elementTypeAdapter);
		}
	};
}
