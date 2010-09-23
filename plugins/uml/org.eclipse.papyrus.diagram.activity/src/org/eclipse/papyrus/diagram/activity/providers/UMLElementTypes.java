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
package org.eclipse.papyrus.diagram.activity.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConditionalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionNodeAsInEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionNodeAsOutEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionRegionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InterruptibleActivityRegionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.LoopNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInAcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInValSpecActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SequenceNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ShapeNamedElementEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.StructuredActivityNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendObjActAsReqEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendObjActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValueSpecificationActionEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
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
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.diagram.activity.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Activity_2001 = getElementType("org.eclipse.papyrus.diagram.activity.Activity_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Parameter_3001 = getElementType("org.eclipse.papyrus.diagram.activity.Parameter_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3002 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3003 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InitialNode_3004 = getElementType("org.eclipse.papyrus.diagram.activity.InitialNode_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActivityFinalNode_3005 = getElementType("org.eclipse.papyrus.diagram.activity.ActivityFinalNode_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FlowFinalNode_3006 = getElementType("org.eclipse.papyrus.diagram.activity.FlowFinalNode_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OpaqueAction_3007 = getElementType("org.eclipse.papyrus.diagram.activity.OpaqueAction_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3015 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3016 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3013 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3014 = getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallBehaviorAction_3008 = getElementType("org.eclipse.papyrus.diagram.activity.CallBehaviorAction_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3017 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3018 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3019 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3020 = getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallOperationAction_3010 = getElementType("org.eclipse.papyrus.diagram.activity.CallOperationAction_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3021 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3022 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3023 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3024 = getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_3024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3025 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3026 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3027 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3011 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_3012 = getElementType("org.eclipse.papyrus.diagram.activity.Constraint_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DecisionNode_3038 = getElementType("org.eclipse.papyrus.diagram.activity.DecisionNode_3038"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MergeNode_3039 = getElementType("org.eclipse.papyrus.diagram.activity.MergeNode_3039"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForkNode_3040 = getElementType("org.eclipse.papyrus.diagram.activity.ForkNode_3040"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType JoinNode_3041 = getElementType("org.eclipse.papyrus.diagram.activity.JoinNode_3041"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SendObjectAction_3042 = getElementType("org.eclipse.papyrus.diagram.activity.SendObjectAction_3042"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3046 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3046"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3047 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3047"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3048 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3048"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3049 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3049"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3050 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3050"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3051 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3051"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SendSignalAction_3052 = getElementType("org.eclipse.papyrus.diagram.activity.SendSignalAction_3052"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3053 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3053"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3054 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3054"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3055 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3055"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValuePin_3060 = getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_3060"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionInputPin_3061 = getElementType("org.eclipse.papyrus.diagram.activity.ActionInputPin_3061"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPin_3062 = getElementType("org.eclipse.papyrus.diagram.activity.InputPin_3062"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActivityParameterNode_3059 = getElementType("org.eclipse.papyrus.diagram.activity.ActivityParameterNode_3059"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AcceptEventAction_3063 = getElementType("org.eclipse.papyrus.diagram.activity.AcceptEventAction_3063"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3064 = getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_3064"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StructuredActivityNode_3065 = getElementType("org.eclipse.papyrus.diagram.activity.StructuredActivityNode_3065"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActivityPartition_3067 = getElementType("org.eclipse.papyrus.diagram.activity.ActivityPartition_3067"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InterruptibleActivityRegion_3068 = getElementType("org.eclipse.papyrus.diagram.activity.InterruptibleActivityRegion_3068"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedElement_3079 = getElementType("org.eclipse.papyrus.diagram.activity.NamedElement_3079"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValueSpecificationAction_3076 = getElementType("org.eclipse.papyrus.diagram.activity.ValueSpecificationAction_3076"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPin_3077 = getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_3077"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataStoreNode_3078 = getElementType("org.eclipse.papyrus.diagram.activity.DataStoreNode_3078"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConditionalNode_3069 = getElementType("org.eclipse.papyrus.diagram.activity.ConditionalNode_3069"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExpansionRegion_3070 = getElementType("org.eclipse.papyrus.diagram.activity.ExpansionRegion_3070"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExpansionNode_3074 = getElementType("org.eclipse.papyrus.diagram.activity.ExpansionNode_3074"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExpansionNode_3075 = getElementType("org.eclipse.papyrus.diagram.activity.ExpansionNode_3075"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoopNode_3071 = getElementType("org.eclipse.papyrus.diagram.activity.LoopNode_3071"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SequenceNode_3073 = getElementType("org.eclipse.papyrus.diagram.activity.SequenceNode_3073"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IntervalConstraint_3032 = getElementType("org.eclipse.papyrus.diagram.activity.IntervalConstraint_3032"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IntervalConstraint_3033 = getElementType("org.eclipse.papyrus.diagram.activity.IntervalConstraint_3033"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_3034 = getElementType("org.eclipse.papyrus.diagram.activity.DurationConstraint_3034"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DurationConstraint_3035 = getElementType("org.eclipse.papyrus.diagram.activity.DurationConstraint_3035"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeConstraint_3036 = getElementType("org.eclipse.papyrus.diagram.activity.TimeConstraint_3036"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TimeConstraint_3037 = getElementType("org.eclipse.papyrus.diagram.activity.TimeConstraint_3037"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionLocalPrecondition_4001 = getElementType("org.eclipse.papyrus.diagram.activity.ActionLocalPrecondition_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActionLocalPostcondition_4002 = getElementType("org.eclipse.papyrus.diagram.activity.ActionLocalPostcondition_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ObjectFlow_4003 = getElementType("org.eclipse.papyrus.diagram.activity.ObjectFlow_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ControlFlow_4004 = getElementType("org.eclipse.papyrus.diagram.activity.ControlFlow_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExceptionHandler_4005 = getElementType("org.eclipse.papyrus.diagram.activity.ExceptionHandler_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if(imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if(element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature)element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if(eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if(eType instanceof EClass && !((EClass)eType).isAbstract()) {
				element = eType;
			}
		}
		if(element instanceof EClass) {
			EClass eClass = (EClass)element;
			if(!eClass.isAbstract()) {
				return UMLDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if(imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if(image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImage(element);
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

			elements.put(SequenceNode_3073, UMLPackage.eINSTANCE.getSequenceNode());

			elements.put(StructuredActivityNode_3065, UMLPackage.eINSTANCE.getStructuredActivityNode());

			elements.put(ActivityPartition_3067, UMLPackage.eINSTANCE.getActivityPartition());

			elements.put(InterruptibleActivityRegion_3068, UMLPackage.eINSTANCE.getInterruptibleActivityRegion());

			elements.put(NamedElement_3079, UMLPackage.eINSTANCE.getNamedElement());

			elements.put(ActionLocalPrecondition_4001, UMLPackage.eINSTANCE.getAction_LocalPrecondition());

			elements.put(ActionLocalPostcondition_4002, UMLPackage.eINSTANCE.getAction_LocalPostcondition());

			elements.put(ObjectFlow_4003, UMLPackage.eINSTANCE.getObjectFlow());

			elements.put(ControlFlow_4004, UMLPackage.eINSTANCE.getControlFlow());

			elements.put(ExceptionHandler_4005, UMLPackage.eINSTANCE.getExceptionHandler());
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
			KNOWN_ELEMENT_TYPES.add(SequenceNode_3073);
			KNOWN_ELEMENT_TYPES.add(StructuredActivityNode_3065);
			KNOWN_ELEMENT_TYPES.add(ActivityPartition_3067);
			KNOWN_ELEMENT_TYPES.add(InterruptibleActivityRegion_3068);
			KNOWN_ELEMENT_TYPES.add(NamedElement_3079);
			KNOWN_ELEMENT_TYPES.add(ActionLocalPrecondition_4001);
			KNOWN_ELEMENT_TYPES.add(ActionLocalPostcondition_4002);
			KNOWN_ELEMENT_TYPES.add(ObjectFlow_4003);
			KNOWN_ELEMENT_TYPES.add(ControlFlow_4004);
			KNOWN_ELEMENT_TYPES.add(ExceptionHandler_4005);
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
		case SequenceNodeEditPart.VISUAL_ID:
			return SequenceNode_3073;
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return StructuredActivityNode_3065;
		case ActivityPartitionEditPart.VISUAL_ID:
			return ActivityPartition_3067;
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			return InterruptibleActivityRegion_3068;
		case ShapeNamedElementEditPart.VISUAL_ID:
			return NamedElement_3079;
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
		}
		return null;
	}

}
