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
package org.eclipse.papyrus.diagram.activity.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.diagram.activity.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;

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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.activity/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(ActivityDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return ActivityDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
			return ActivityDiagramEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ActivityDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case ActivityDiagramEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityEditPart.VISUAL_ID;
			}
			break;
		case ActivityEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivityParameterNode().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityParameterNodeEditPart.VISUAL_ID;
			}
			break;
		case OpaqueActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())

			) {
				return ValuePinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return ActionInputPinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return InputPinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInOpaqueActEditPart.VISUAL_ID;
			}
			break;
		case CallBehaviorActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())

			) {
				return ValuePinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return ActionInputPinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return InputPinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInCallBeActEditPart.VISUAL_ID;
			}
			break;
		case CallOperationActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3021(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3022(containerView, (ValuePin)domainElement)) {
				return ValuePinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3023(containerView, (InputPin)domainElement)) {
				return InputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3025(containerView, (ValuePin)domainElement)) {
				return ValuePinInCallOpActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3026(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3027(containerView, (InputPin)domainElement)) {
				return InputPinInCallOpActAsTargetEditPart.VISUAL_ID;
			}
			break;
		case SendObjectActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3046(containerView, (ValuePin)domainElement)) {
				return ValuePinInSendObjActAsReqEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3047(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3048(containerView, (InputPin)domainElement)) {
				return InputPinInSendObjActAsReqEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3049(containerView, (ValuePin)domainElement)) {
				return ValuePinInSendObjActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3050(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3051(containerView, (InputPin)domainElement)) {
				return InputPinInSendObjActAsTargetEditPart.VISUAL_ID;
			}
			break;
		case SendSignalActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3053(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInSendSigActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3054(containerView, (ValuePin)domainElement)) {
				return ValuePinInSendSigActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3055(containerView, (InputPin)domainElement)) {
				return InputPinInSendSigActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3060(containerView, (ValuePin)domainElement)) {
				return ValuePinInSendSigActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3061(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3062(containerView, (InputPin)domainElement)) {
				return InputPinInSendSigActAsTargetEditPart.VISUAL_ID;
			}
			break;
		case AcceptEventActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInAcceptEventActionEditPart.VISUAL_ID;
			}
			break;
		case ExpansionRegionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getExpansionNode().isSuperTypeOf(domainElement.eClass()) && isExpansionNode_3074(containerView, (ExpansionNode)domainElement)) {
				return ExpansionNodeAsInEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionNode().isSuperTypeOf(domainElement.eClass()) && isExpansionNode_3075(containerView, (ExpansionNode)domainElement)) {
				return ExpansionNodeAsOutEditPart.VISUAL_ID;
			}
			break;
		case OpaqueActionInIAREditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())

			) {
				return ValuePinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return ActionInputPinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return InputPinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInOpaqueActEditPart.VISUAL_ID;
			}
			break;
		case CallBehaviorActionInIAREditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())

			) {
				return ValuePinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return ActionInputPinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return InputPinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInCallBeActEditPart.VISUAL_ID;
			}
			break;
		case CallOperationActionInIAREditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3021(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3022(containerView, (ValuePin)domainElement)) {
				return ValuePinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3023(containerView, (InputPin)domainElement)) {
				return InputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3025(containerView, (ValuePin)domainElement)) {
				return ValuePinInCallOpActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3026(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3027(containerView, (InputPin)domainElement)) {
				return InputPinInCallOpActAsTargetEditPart.VISUAL_ID;
			}
			break;
		case SendObjectActionInIAREditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3046(containerView, (ValuePin)domainElement)) {
				return ValuePinInSendObjActAsReqEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3047(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3048(containerView, (InputPin)domainElement)) {
				return InputPinInSendObjActAsReqEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3049(containerView, (ValuePin)domainElement)) {
				return ValuePinInSendObjActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3050(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3051(containerView, (InputPin)domainElement)) {
				return InputPinInSendObjActAsTargetEditPart.VISUAL_ID;
			}
			break;
		case SendSignalActionInIAREditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3053(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInSendSigActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3054(containerView, (ValuePin)domainElement)) {
				return ValuePinInSendSigActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3055(containerView, (InputPin)domainElement)) {
				return InputPinInSendSigActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass()) && isValuePin_3060(containerView, (ValuePin)domainElement)) {
				return ValuePinInSendSigActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass()) && isActionInputPin_3061(containerView, (ActionInputPin)domainElement)) {
				return ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3062(containerView, (InputPin)domainElement)) {
				return InputPinInSendSigActAsTargetEditPart.VISUAL_ID;
			}
			break;
		case AcceptEventActionInIAREditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInAcceptEventActionEditPart.VISUAL_ID;
			}
			break;
		case ValueSpecificationActionInIAREditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInValSpecActEditPart.VISUAL_ID;
			}
			break;
		case ValueSpecificationActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInValSpecActEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getParameter().isSuperTypeOf(domainElement.eClass())

			) {
				return ParameterEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintInActivityAsPrecondEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintInActivityAsPostcondEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())

			) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())

			) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())

			) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())

			) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationConstraint().isSuperTypeOf(domainElement.eClass()) && isDurationConstraint_3034(containerView, (DurationConstraint)domainElement)) {
				return DurationConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationConstraint().isSuperTypeOf(domainElement.eClass()) && isDurationConstraint_3035(containerView, (DurationConstraint)domainElement)) {
				return DurationConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeConstraint().isSuperTypeOf(domainElement.eClass()) && isTimeConstraint_3036(containerView, (TimeConstraint)domainElement)) {
				return TimeConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeConstraint().isSuperTypeOf(domainElement.eClass()) && isTimeConstraint_3037(containerView, (TimeConstraint)domainElement)) {
				return TimeConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteractionConstraint().isSuperTypeOf(domainElement.eClass()) && isInteractionConstraint_3030(containerView, (InteractionConstraint)domainElement)) {
				return InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteractionConstraint().isSuperTypeOf(domainElement.eClass()) && isInteractionConstraint_3031(containerView, (InteractionConstraint)domainElement)) {
				return InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getIntervalConstraint().isSuperTypeOf(domainElement.eClass()) && isIntervalConstraint_3032(containerView, (IntervalConstraint)domainElement)) {
				return IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getIntervalConstraint().isSuperTypeOf(domainElement.eClass()) && isIntervalConstraint_3033(containerView, (IntervalConstraint)domainElement)) {
				return IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass()) && isConstraint_3011(containerView, (Constraint)domainElement)) {
				return ConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass()) && isConstraint_3012(containerView, (Constraint)domainElement)) {
				return ConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())

			) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())

			) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())

			) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())

			) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())

			) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())

			) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())

			) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())

			) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())

			) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())

			) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())

			) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())

			) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityPartitionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterruptibleActivityRegion().isSuperTypeOf(domainElement.eClass())

			) {
				return InterruptibleActivityRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())

			) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())

			) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			break;
		case InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())

			) {
				return InitialNodeInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityFinalNodeInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())

			) {
				return FlowFinalNodeInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass()) && isConstraint_3011(containerView, (Constraint)domainElement)) {
				return ConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass()) && isConstraint_3012(containerView, (Constraint)domainElement)) {
				return ConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationConstraint().isSuperTypeOf(domainElement.eClass()) && isDurationConstraint_3034(containerView, (DurationConstraint)domainElement)) {
				return DurationConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationConstraint().isSuperTypeOf(domainElement.eClass()) && isDurationConstraint_3035(containerView, (DurationConstraint)domainElement)) {
				return DurationConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteractionConstraint().isSuperTypeOf(domainElement.eClass()) && isInteractionConstraint_3030(containerView, (InteractionConstraint)domainElement)) {
				return InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInteractionConstraint().isSuperTypeOf(domainElement.eClass()) && isInteractionConstraint_3031(containerView, (InteractionConstraint)domainElement)) {
				return InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getIntervalConstraint().isSuperTypeOf(domainElement.eClass()) && isIntervalConstraint_3032(containerView, (IntervalConstraint)domainElement)) {
				return IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getIntervalConstraint().isSuperTypeOf(domainElement.eClass()) && isIntervalConstraint_3033(containerView, (IntervalConstraint)domainElement)) {
				return IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeConstraint().isSuperTypeOf(domainElement.eClass()) && isTimeConstraint_3036(containerView, (TimeConstraint)domainElement)) {
				return TimeConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeConstraint().isSuperTypeOf(domainElement.eClass()) && isTimeConstraint_3037(containerView, (TimeConstraint)domainElement)) {
				return TimeConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())

			) {
				return OpaqueActionInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())

			) {
				return CallBehaviorActionInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())

			) {
				return CallOperationActionInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())

			) {
				return SendObjectActionInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())

			) {
				return SendSignalActionInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())

			) {
				return AcceptEventActionInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())

			) {
				return ValueSpecificationActionInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())

			) {
				return DecisionNodeInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())

			) {
				return MergeNodeInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())

			) {
				return ForkNodeInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())

			) {
				return JoinNodeInIAREditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())

			) {
				return DataStoreNodeInIAREditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isExpansionNode_3075(View containerView, ExpansionNode domainElement) {
		return isExpansionNode_3075(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isExpansionNode_3074(View containerView, ExpansionNode domainElement) {
		return isExpansionNode_3074(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isValuePin_3022(View containerView, ValuePin domainElement) {
		return isValuePin_3022(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isValuePin_3025(View containerView, ValuePin domainElement) {
		return isValuePin_3025(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isValuePin_3046(View containerView, ValuePin domainElement) {
		return isValuePin_3046(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isValuePin_3049(View containerView, ValuePin domainElement) {
		return isValuePin_3049(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isValuePin_3054(View containerView, ValuePin domainElement) {
		return isValuePin_3054(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isValuePin_3060(View containerView, ValuePin domainElement) {
		return isValuePin_3060(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3023(View containerView, InputPin domainElement) {
		return isInputPin_3023(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3027(View containerView, InputPin domainElement) {
		return isInputPin_3027(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3048(View containerView, InputPin domainElement) {
		return isInputPin_3048(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3051(View containerView, InputPin domainElement) {
		return isInputPin_3051(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3055(View containerView, InputPin domainElement) {
		return isInputPin_3055(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3062(View containerView, InputPin domainElement) {
		return isInputPin_3062(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isActionInputPin_3026(View containerView, ActionInputPin domainElement) {
		return isActionInputPin_3026(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isActionInputPin_3021(View containerView, ActionInputPin domainElement) {
		return isActionInputPin_3021(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isActionInputPin_3047(View containerView, ActionInputPin domainElement) {
		return isActionInputPin_3047(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isActionInputPin_3050(View containerView, ActionInputPin domainElement) {
		return isActionInputPin_3050(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isActionInputPin_3053(View containerView, ActionInputPin domainElement) {
		return isActionInputPin_3053(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isActionInputPin_3061(View containerView, ActionInputPin domainElement) {
		return isActionInputPin_3061(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isConstraint_3011(View containerView, Constraint domainElement) {
		return isConstraint_3011(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isConstraint_3012(View containerView, Constraint domainElement) {
		return isConstraint_3012(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInteractionConstraint_3030(View containerView, InteractionConstraint domainElement) {
		return isInteractionConstraint_3030(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInteractionConstraint_3031(View containerView, InteractionConstraint domainElement) {
		return isInteractionConstraint_3031(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isIntervalConstraint_3032(View containerView, IntervalConstraint domainElement) {
		return isIntervalConstraint_3032(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isIntervalConstraint_3033(View containerView, IntervalConstraint domainElement) {
		return isIntervalConstraint_3033(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isDurationConstraint_3034(View containerView, DurationConstraint domainElement) {
		return isDurationConstraint_3034(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isDurationConstraint_3035(View containerView, DurationConstraint domainElement) {
		return isDurationConstraint_3035(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isTimeConstraint_3036(View containerView, TimeConstraint domainElement) {
		return isTimeConstraint_3036(domainElement);
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isTimeConstraint_3037(View containerView, TimeConstraint domainElement) {
		return isTimeConstraint_3037(domainElement);
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ActivityDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case ActivityDiagramEditPart.VISUAL_ID:
			if(ActivityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityEditPart.VISUAL_ID:
			if(ActivityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityIsSingleExecutionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityActivityParametersCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityActivityContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityParameterNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InitialNodeEditPart.VISUAL_ID:
			if(InitialNodeAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityFinalNodeEditPart.VISUAL_ID:
			if(ActivityFinalNodeAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FlowFinalNodeEditPart.VISUAL_ID:
			if(FlowFinalNodeAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueActionEditPart.VISUAL_ID:
			if(OpaqueActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInOpaqueActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInOpaqueActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInOpaqueActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInOpaqueActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			if(ValuePinInOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInOActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInOActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			if(ActionInputPinInOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInOActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInOActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			if(InputPinInOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInOActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			if(OutputPinInOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInOActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallBehaviorActionEditPart.VISUAL_ID:
			if(CallBehaviorActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCallBeActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCallBeActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCallBeActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInCallBeActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			if(ValuePinInCBActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCBActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCBActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			if(ActionInputPinInCBActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCBActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCBActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInCallBeActEditPart.VISUAL_ID:
			if(InputPinInCBActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCBActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			if(OutputPinInCBActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInCBActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallOperationActionEditPart.VISUAL_ID:
			if(CallOperationActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCallOpActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCallOpActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCallOpActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInCallOpActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCallOpActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			if(ActionInputPinInCOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCOActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCOActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			if(ValuePinInCOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCOActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCOActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInCallOpActEditPart.VISUAL_ID:
			if(InputPinInCOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCOActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			if(OutputPinInCOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInCOActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			if(ValuePinInCOActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCOActAsTargetValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			if(ActionInputPinInCOActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCOActAsTargetValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			if(InputPinInCOActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
			if(DurationConstraintAsLocalPrecondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(DurationConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			if(TimeConstraintAsLocalPrecondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(TimeConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
			if(InteractionConstraintAsLocalPrecondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(InteractionConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			if(IntervalConstraintAsLocalPrecondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(IntervalConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			if(ConstraintAsLocalPrecondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(ConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DecisionNodeEditPart.VISUAL_ID:
			if(DecisionInputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DecisionNodeAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MergeNodeEditPart.VISUAL_ID:
			if(MergeNodeAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkNodeEditPart.VISUAL_ID:
			if(ForkNodeAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case JoinNodeEditPart.VISUAL_ID:
			if(JoinSpecEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(JoinNodeAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendObjectActionEditPart.VISUAL_ID:
			if(SendObjectActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendObjActAsReqEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendObjActAsReqEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendObjActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
			if(ValuePinInSendObjActAsReqLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendObjActAsReqValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
			if(ActionInputPinInSendObjActAsReqLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendObjActAsReqValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
			if(InputPinInSendObjActAsReqLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
			if(ValuePinInSendObjActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendObjActAsTargetValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			if(ActionInputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendObjActAsTargetValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			if(InputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendSignalActionEditPart.VISUAL_ID:
			if(SendSignalActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendSigActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendSigActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendSigActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendSigActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
			if(ActionInputPinInSendSigActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendSigActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendSigActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinInSendSigActEditPart.VISUAL_ID:
			if(ValuePinInSendSigActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendSigActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendSigActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInSendSigActEditPart.VISUAL_ID:
			if(InputPinInSendSigActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendSigActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
			if(ValuePinInSendSigActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendSigActAsTargetValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			if(ActionInputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendSigActAsTargetValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			if(InputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityParameterNodeEditPart.VISUAL_ID:
			if(CenteredWrappedLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AcceptEventActionEditPart.VISUAL_ID:
			if(AcceptEventActionLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AcceptTimeEventActionLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AcceptTimeEventActionAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInAcceptEventActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
			if(OutputPinInAcceptEventActionLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInAcceptEventActionAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConditionalNodeEditPart.VISUAL_ID:
			if(ConditionalNodeKeywordEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExpansionRegionEditPart.VISUAL_ID:
			if(ExpansionRegionKeywordEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExpansionNodeAsInEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExpansionNodeAsOutEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoopNodeEditPart.VISUAL_ID:
			if(LoopNodeKeywordEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SequenceNodeEditPart.VISUAL_ID:
			if(SequenceNodeKeywordEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StructuredActivityNodeEditPart.VISUAL_ID:
			if(StructuredActivityNodeKeywordEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityPartitionEditPart.VISUAL_ID:
			if(ActivityPartitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			if(InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InitialNodeInIAREditPart.VISUAL_ID:
			if(AppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityFinalNodeInIAREditPart.VISUAL_ID:
			if(ActivityFinalNodeInIARAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FlowFinalNodeInIAREditPart.VISUAL_ID:
			if(FlowFinalNodeInIARAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueActionInIAREditPart.VISUAL_ID:
			if(OpaqueActionInIARNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInOpaqueActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInOpaqueActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInOpaqueActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInOpaqueActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallBehaviorActionInIAREditPart.VISUAL_ID:
			if(CallBehaviorActionInIARNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCallBeActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCallBeActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCallBeActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInCallBeActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallOperationActionInIAREditPart.VISUAL_ID:
			if(CallOperationActionInIARNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCallOpActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCallOpActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCallOpActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInCallOpActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInCallOpActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendObjectActionInIAREditPart.VISUAL_ID:
			if(SendObjectActionInIARNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendObjActAsReqEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendObjActAsReqEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendObjActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendSignalActionInIAREditPart.VISUAL_ID:
			if(SendSignalActionInIARNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendSigActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendSigActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendSigActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInSendSigActAsTargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AcceptEventActionInIAREditPart.VISUAL_ID:
			if(AcceptEventActionInIARLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AcceptTimeEventActionInIARLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AcceptTimeEventActionInIARAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInAcceptEventActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValueSpecificationActionInIAREditPart.VISUAL_ID:
			if(ValueSpecificationActionInIARNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInValSpecActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInValSpecActEditPart.VISUAL_ID:
			if(OutputPinInValSpecActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInValSpecActAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DecisionNodeInIAREditPart.VISUAL_ID:
			if(DecisionInputInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DecisionNodeInIARAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MergeNodeInIAREditPart.VISUAL_ID:
			if(MergeNodeInIARAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForkNodeInIAREditPart.VISUAL_ID:
			if(ForkNodeInIARAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case JoinNodeInIAREditPart.VISUAL_ID:
			if(JoinSpecInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(JoinNodeInIARAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataStoreNodeInIAREditPart.VISUAL_ID:
			if(DataStoreNodeInIARLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataStoreInIARSelectionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValueSpecificationActionEditPart.VISUAL_ID:
			if(ValueSpecificationActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInValSpecActEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataStoreNodeEditPart.VISUAL_ID:
			if(DataStoreNodeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataStoreSelectionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
			if(ParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
			if(ConstraintInActivityAsPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
			if(ConstraintInActivityAsPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
			if(InitialNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FlowFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CallBehaviorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CallOperationActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DecisionNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MergeNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ForkNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(JoinNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SendObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SendSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AcceptEventActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConditionalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExpansionRegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(LoopNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SequenceNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(StructuredActivityNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityPartitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterruptibleActivityRegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID:
			if(InitialNodeInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityFinalNodeInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FlowFinalNodeInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OpaqueActionInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CallBehaviorActionInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CallOperationActionInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SendObjectActionInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SendSignalActionInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AcceptEventActionInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValueSpecificationActionInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DecisionNodeInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(MergeNodeInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ForkNodeInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(JoinNodeInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataStoreNodeInIAREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ObjectFlowEditPart.VISUAL_ID:
			if(ObjectFlowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ObjectFlowWeightEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ObjectFlowSelectionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ObjectFlowTransformationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DecisionInputFlowEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ObjectFlowGuardEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ObjectFlowAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ControlFlowEditPart.VISUAL_ID:
			if(ControlFlowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ControlFlowWeightEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ControlFlowGuardEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ControlFlowAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExceptionHandlerEditPart.VISUAL_ID:
			if(ExceptionHandlerTypeEditPart.VISUAL_ID == nodeVisualID) {
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
		if(UMLPackage.eINSTANCE.getObjectFlow().isSuperTypeOf(domainElement.eClass())



		) {
			return ObjectFlowEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getControlFlow().isSuperTypeOf(domainElement.eClass())



		) {
			return ControlFlowEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getExceptionHandler().isSuperTypeOf(domainElement.eClass())



		) {
			return ExceptionHandlerEditPart.VISUAL_ID;
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
	private static boolean isActionInputPin_3021(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3022(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(1, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3023(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(2, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3025(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(3, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3026(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(4, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3027(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(5, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isConstraint_3011(Constraint domainElement) {
		Object result = UMLOCLFactory.getExpression(14, UMLPackage.eINSTANCE.getConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isConstraint_3012(Constraint domainElement) {
		Object result = UMLOCLFactory.getExpression(15, UMLPackage.eINSTANCE.getConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3046(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(16, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3047(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(17, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3048(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(18, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3049(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(19, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3050(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(20, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3051(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(21, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3053(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(22, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3054(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(23, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3055(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(24, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3060(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(25, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3061(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(26, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3062(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(27, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isExpansionNode_3074(ExpansionNode domainElement) {
		Object result = UMLOCLFactory.getExpression(28, UMLPackage.eINSTANCE.getExpansionNode(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isExpansionNode_3075(ExpansionNode domainElement) {
		Object result = UMLOCLFactory.getExpression(29, UMLPackage.eINSTANCE.getExpansionNode(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInteractionConstraint_3030(InteractionConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(10, UMLPackage.eINSTANCE.getInteractionConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInteractionConstraint_3031(InteractionConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(11, UMLPackage.eINSTANCE.getInteractionConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isIntervalConstraint_3032(IntervalConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(12, UMLPackage.eINSTANCE.getIntervalConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isIntervalConstraint_3033(IntervalConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(13, UMLPackage.eINSTANCE.getIntervalConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDurationConstraint_3034(DurationConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(6, UMLPackage.eINSTANCE.getDurationConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDurationConstraint_3035(DurationConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(7, UMLPackage.eINSTANCE.getDurationConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isTimeConstraint_3036(TimeConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(8, UMLPackage.eINSTANCE.getTimeConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isTimeConstraint_3037(TimeConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(9, UMLPackage.eINSTANCE.getTimeConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
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

		viewInfo = new BaseViewInfo(2001, ViewInfo.Node, "Activity");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4001, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4002, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4003, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6002, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6005, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6006, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6007, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6008, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6010, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4004, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6003, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6004, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6009, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6011, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4005, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6012, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(3001, ViewInfo.Node, "Parameter");

		root.addNode(7001, viewInfo);


		viewInfo = new BaseViewInfo(3002, ViewInfo.Node, "Constraint");

		root.addNode(7002, viewInfo);


		viewInfo = new BaseViewInfo(3003, ViewInfo.Node, "Constraint");

		root.addNode(7003, viewInfo);


		viewInfo = new BaseViewInfo(3004, ViewInfo.Node, "InitialNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3005, ViewInfo.Node, "ActivityFinalNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3006, ViewInfo.Node, "FlowFinalNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3007, ViewInfo.Node, "OpaqueAction");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3015, ViewInfo.Node, "ValuePin");

		root.addNode(3007, viewInfo);

		root.addNode(3082, viewInfo);


		viewInfo = new BaseViewInfo(3016, ViewInfo.Node, "ActionInputPin");

		root.addNode(3007, viewInfo);

		root.addNode(3082, viewInfo);


		viewInfo = new BaseViewInfo(3013, ViewInfo.Node, "InputPin");

		root.addNode(3007, viewInfo);

		root.addNode(3082, viewInfo);


		viewInfo = new BaseViewInfo(3014, ViewInfo.Node, "OutputPin");

		root.addNode(3007, viewInfo);

		root.addNode(3082, viewInfo);


		viewInfo = new BaseViewInfo(3008, ViewInfo.Node, "CallBehaviorAction");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3017, ViewInfo.Node, "ValuePin");

		root.addNode(3008, viewInfo);

		root.addNode(3083, viewInfo);


		viewInfo = new BaseViewInfo(3018, ViewInfo.Node, "ActionInputPin");

		root.addNode(3008, viewInfo);

		root.addNode(3083, viewInfo);


		viewInfo = new BaseViewInfo(3019, ViewInfo.Node, "InputPin");

		root.addNode(3008, viewInfo);

		root.addNode(3083, viewInfo);


		viewInfo = new BaseViewInfo(3020, ViewInfo.Node, "OutputPin");

		root.addNode(3008, viewInfo);

		root.addNode(3083, viewInfo);


		viewInfo = new BaseViewInfo(3010, ViewInfo.Node, "CallOperationAction");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3021, ViewInfo.Node, "ActionInputPin");

		root.addNode(3010, viewInfo);

		root.addNode(3084, viewInfo);


		viewInfo = new BaseViewInfo(3022, ViewInfo.Node, "ValuePin");

		root.addNode(3010, viewInfo);

		root.addNode(3084, viewInfo);


		viewInfo = new BaseViewInfo(3023, ViewInfo.Node, "InputPin");

		root.addNode(3010, viewInfo);

		root.addNode(3084, viewInfo);


		viewInfo = new BaseViewInfo(3024, ViewInfo.Node, "OutputPin");

		root.addNode(3010, viewInfo);

		root.addNode(3084, viewInfo);


		viewInfo = new BaseViewInfo(3025, ViewInfo.Node, "ValuePin");

		root.addNode(3010, viewInfo);

		root.addNode(3084, viewInfo);


		viewInfo = new BaseViewInfo(3026, ViewInfo.Node, "ActionInputPin");

		root.addNode(3010, viewInfo);

		root.addNode(3084, viewInfo);


		viewInfo = new BaseViewInfo(3027, ViewInfo.Node, "InputPin");

		root.addNode(3010, viewInfo);

		root.addNode(3084, viewInfo);


		viewInfo = new BaseViewInfo(3034, ViewInfo.Node, "DurationConstraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3035, ViewInfo.Node, "DurationConstraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3036, ViewInfo.Node, "TimeConstraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3037, ViewInfo.Node, "TimeConstraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3030, ViewInfo.Node, "InteractionConstraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3031, ViewInfo.Node, "InteractionConstraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3032, ViewInfo.Node, "IntervalConstraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3033, ViewInfo.Node, "IntervalConstraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3011, ViewInfo.Node, "Constraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3012, ViewInfo.Node, "Constraint");

		root.addNode(7004, viewInfo);

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3038, ViewInfo.Node, "DecisionNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3039, ViewInfo.Node, "MergeNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3040, ViewInfo.Node, "ForkNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3041, ViewInfo.Node, "JoinNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3042, ViewInfo.Node, "SendObjectAction");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3046, ViewInfo.Node, "ValuePin");

		root.addNode(3042, viewInfo);

		root.addNode(3085, viewInfo);


		viewInfo = new BaseViewInfo(3047, ViewInfo.Node, "ActionInputPin");

		root.addNode(3042, viewInfo);

		root.addNode(3085, viewInfo);


		viewInfo = new BaseViewInfo(3048, ViewInfo.Node, "InputPin");

		root.addNode(3042, viewInfo);

		root.addNode(3085, viewInfo);


		viewInfo = new BaseViewInfo(3049, ViewInfo.Node, "ValuePin");

		root.addNode(3042, viewInfo);

		root.addNode(3085, viewInfo);


		viewInfo = new BaseViewInfo(3050, ViewInfo.Node, "ActionInputPin");

		root.addNode(3042, viewInfo);

		root.addNode(3085, viewInfo);


		viewInfo = new BaseViewInfo(3051, ViewInfo.Node, "InputPin");

		root.addNode(3042, viewInfo);

		root.addNode(3085, viewInfo);


		viewInfo = new BaseViewInfo(3052, ViewInfo.Node, "SendSignalAction");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3053, ViewInfo.Node, "ActionInputPin");

		root.addNode(3052, viewInfo);

		root.addNode(3086, viewInfo);


		viewInfo = new BaseViewInfo(3054, ViewInfo.Node, "ValuePin");

		root.addNode(3052, viewInfo);

		root.addNode(3086, viewInfo);


		viewInfo = new BaseViewInfo(3055, ViewInfo.Node, "InputPin");

		root.addNode(3052, viewInfo);

		root.addNode(3086, viewInfo);


		viewInfo = new BaseViewInfo(3060, ViewInfo.Node, "ValuePin");

		root.addNode(3052, viewInfo);

		root.addNode(3086, viewInfo);


		viewInfo = new BaseViewInfo(3061, ViewInfo.Node, "ActionInputPin");

		root.addNode(3052, viewInfo);

		root.addNode(3086, viewInfo);


		viewInfo = new BaseViewInfo(3062, ViewInfo.Node, "InputPin");

		root.addNode(3052, viewInfo);

		root.addNode(3086, viewInfo);


		viewInfo = new BaseViewInfo(3059, ViewInfo.Node, "ActivityParameterNode");

		root.addNode(2001, viewInfo);


		viewInfo = new BaseViewInfo(3063, ViewInfo.Node, "AcceptEventAction");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3064, ViewInfo.Node, "OutputPin");

		root.addNode(3063, viewInfo);

		root.addNode(3087, viewInfo);


		viewInfo = new BaseViewInfo(3069, ViewInfo.Node, "ConditionalNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3070, ViewInfo.Node, "ExpansionRegion");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3074, ViewInfo.Node, "ExpansionNode");

		root.addNode(3070, viewInfo);


		viewInfo = new BaseViewInfo(3075, ViewInfo.Node, "ExpansionNode");

		root.addNode(3070, viewInfo);


		viewInfo = new BaseViewInfo(3071, ViewInfo.Node, "LoopNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3073, ViewInfo.Node, "SequenceNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3065, ViewInfo.Node, "StructuredActivityNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3067, ViewInfo.Node, "ActivityPartition");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3068, ViewInfo.Node, "InterruptibleActivityRegion");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3079, ViewInfo.Node, "InitialNode");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3080, ViewInfo.Node, "ActivityFinalNode");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3081, ViewInfo.Node, "FlowFinalNode");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3082, ViewInfo.Node, "OpaqueAction");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3083, ViewInfo.Node, "CallBehaviorAction");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3084, ViewInfo.Node, "CallOperationAction");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3085, ViewInfo.Node, "SendObjectAction");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3086, ViewInfo.Node, "SendSignalAction");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3087, ViewInfo.Node, "AcceptEventAction");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3076, ViewInfo.Node, "ValueSpecificationAction");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3077, ViewInfo.Node, "OutputPin");

		root.addNode(3076, viewInfo);

		root.addNode(3088, viewInfo);


		viewInfo = new BaseViewInfo(3089, ViewInfo.Node, "DecisionNode");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3090, ViewInfo.Node, "MergeNode");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3091, ViewInfo.Node, "ForkNode");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3092, ViewInfo.Node, "JoinNode");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3078, ViewInfo.Node, "DataStoreNode");

		root.addNode(7007, viewInfo);


		viewInfo = new BaseViewInfo(3088, ViewInfo.Node, "ValueSpecificationAction");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3093, ViewInfo.Node, "DataStoreNode");

		root.addNode(7004, viewInfo);

		return root;
	}

}
