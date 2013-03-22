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
package org.eclipse.papyrus.uml.diagram.activity.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.activity.expressions.UMLOCLFactory;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.OutputPin;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.uml.diagram.activity/debug/visualID"; //$NON-NLS-1$

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
		return org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
		String containerModelID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ActivityDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case ActivityDiagramEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())) {
				return ActivityEditPart.VISUAL_ID;
			}
			break;
		case ActivityEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivityParameterNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityParameterNodeEditPart.VISUAL_ID;
			}
			break;
		case OpaqueActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())) {
				return ValuePinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass())) {
				return ActionInputPinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPinInOpaqueActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInOpaqueActEditPart.VISUAL_ID;
			}
			break;
		case CallBehaviorActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())) {
				return ValuePinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass())) {
				return ActionInputPinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPinInCallBeActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
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
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
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
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInAcceptEventActionEditPart.VISUAL_ID;
			}
			break;
		case ValueSpecificationActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInValSpecActEditPart.VISUAL_ID;
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
		case LoopNodeEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPinInLoopNodeAsVariableEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInLoopNodeAsResultEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID;
			}
			break;
		case ReadSelfActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionOutputPinEditPart.VISUAL_ID;
			}
			break;
		case ActivityEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivityParameterNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityParameterNodeEditPart.VISUAL_ID;
			}
			break;
		case CreateObjectActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID;
			}
			break;
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID;
			}
			break;
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3092(containerView, (InputPin)domainElement)) {
				return InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3093(containerView, (InputPin)domainElement)) {
				return InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID;
			}
			break;
		case DestroyObjectActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3096(containerView, (InputPin)domainElement)) {
				return InputPinInDestroyObjectActionEditPart.VISUAL_ID;
			}
			break;
		case ReadVariableActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass()) && isOutputPin_3098(containerView, (OutputPin)domainElement)) {
				return OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID;
			}
			break;
		case AddVariableValueActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3100(containerView, (InputPin)domainElement)) {
				return InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3101(containerView, (InputPin)domainElement)) {
				return InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID;
			}
			break;
		case BroadcastSignalActionEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass()) && isInputPin_3103(containerView, (InputPin)domainElement)) {
				return InputPinInBroadcastSignalActionEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getParameter().isSuperTypeOf(domainElement.eClass())) {
				return ParameterEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintInActivityAsPrecondEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintInActivityAsPostcondEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
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
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartitionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterruptibleActivityRegion().isSuperTypeOf(domainElement.eClass())) {
				return InterruptibleActivityRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())) {
				return ActivityEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBroadcastSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return BroadcastSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
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
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
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
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBroadcastSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return BroadcastSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
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
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBroadcastSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return BroadcastSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
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
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBroadcastSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return BroadcastSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
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
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBroadcastSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return BroadcastSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartitionEditPart.VISUAL_ID;
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
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBroadcastSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return BroadcastSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
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
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBroadcastSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return BroadcastSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case ActivityCNParametersCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getParameter().isSuperTypeOf(domainElement.eClass())) {
				return ParameterEditPart.VISUAL_ID;
			}
			break;
		case ActivityCNPreConditionsCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintInActivityAsPrecondEditPart.VISUAL_ID;
			}
			break;
		case ActivityCNPostConditionsCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintInActivityAsPostcondEditPart.VISUAL_ID;
			}
			break;
		case ActivityCNContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
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
			if(UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass())) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValueSpecificationAction().isSuperTypeOf(domainElement.eClass())) {
				return ValueSpecificationActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConditionalNode().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExpansionRegion().isSuperTypeOf(domainElement.eClass())) {
				return ExpansionRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getLoopNode().isSuperTypeOf(domainElement.eClass())) {
				return LoopNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getSequenceNode().isSuperTypeOf(domainElement.eClass())) {
				return SequenceNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getStructuredActivityNode().isSuperTypeOf(domainElement.eClass())) {
				return StructuredActivityNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartitionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterruptibleActivityRegion().isSuperTypeOf(domainElement.eClass())) {
				return InterruptibleActivityRegionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadSelfAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadSelfActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())) {
				return ActivityEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadStructuralFeatureAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadStructuralFeatureActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddStructuralFeatureValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDestroyObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return DestroyObjectActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getReadVariableAction().isSuperTypeOf(domainElement.eClass())) {
				return ReadVariableActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getAddVariableValueAction().isSuperTypeOf(domainElement.eClass())) {
				return AddVariableValueActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getBroadcastSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return BroadcastSignalActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCentralBufferNode().isSuperTypeOf(domainElement.eClass())) {
				return CentralBufferNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityParameterNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityParameterNodeEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
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
			if(DurationConstraintAsLocalPrecondBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(DurationConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationConstraintAsLocalPostcondBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			if(TimeConstraintAsLocalPrecondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintAsLocalPrecondBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(TimeConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeConstraintAsLocalPostcondBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			if(IntervalConstraintAsLocalPrecondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(IntervalConstraintAsLocalPrecondBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(IntervalConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(IntervalConstraintAsLocalPostcondBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			if(ConstraintAsLocalPrecondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintAsLocalPrecondBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			if(ConstraintAsLocalPostcondNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintAsLocalPostcondBodyEditPart.VISUAL_ID == nodeVisualID) {
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
		case DataStoreNodeEditPart.VISUAL_ID:
			if(DataStoreNodeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DataStoreSelectionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ParameterNodeNameEditPart.VISUAL_ID == nodeVisualID) {
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
		case ValueSpecificationActionEditPart.VISUAL_ID:
			if(ValueSpecificationActionNameEditPart.VISUAL_ID == nodeVisualID) {
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
			if(InputPinInLoopNodeAsVariableEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInLoopNodeAsResultEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID:
			if(OutputPinInLoopNodeAsBodyOutputLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInLoopNodeAsBodyOutputAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID:
			if(OutputPinInLoopNodeAsLoopVariableLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInLoopNodeAsLoopVariableAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInLoopNodeAsResultEditPart.VISUAL_ID:
			if(OutputPinInLoopNodeAsResultLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInLoopNodeAsResultAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
		case InputPinInLoopNodeAsVariableEditPart.VISUAL_ID:
			if(InputPinInLoopNodeAsVariableLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInStructuredActivityNodeAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
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
		case CommentEditPartCN.VISUAL_ID:
			if(CommentBodyLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReadSelfActionEditPart.VISUAL_ID:
			if(ReadSelfActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadSelfActionOutputPinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
			if(OutputPinInReadSelfActionLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInReadSelfActionAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityEditPartCN.VISUAL_ID:
			if(ActivityNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityIsSingleExecutionCNEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCNParametersCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCNPreConditionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCNPostConditionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityCNContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityParameterNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CreateObjectActionEditPart.VISUAL_ID:
			if(CreateObjectActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
			if(OutputPinInCreateObjectActionAsResultLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInCreateObjectActionAsResultAppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ShapeNamedElementEditPart.VISUAL_ID:
			if(ShapeNamedElementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			if(ReadStructuralFeatureActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
			if(InputPinInReadStructuralFeatureAsObjectLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInReadStructuralFeatureAsObjectAppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
			if(OutputPinInReadStructuralFeatureAsResultLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInReadStructuralFeatureAsResultWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			if(AddStructuralFeatureValueActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
			if(InputPinInAddStructuralFeatureValueActionAsObjectLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInAddStructuralFeatureValueActionAsObjectAppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
			if(InputPinInAddStructuralFeatureValueActionAsValueLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInAddStructuralFeatureValueActionAsValueAppliedStereotypeWrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
			if(OutputPinInAddStructuralFeatureValueActionAsResultLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInAddStructuralFeatureValueActionAsResultAppliedStereotypeWrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DestroyObjectActionEditPart.VISUAL_ID:
			if(DestroyObjectActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInDestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
			if(InputPinInDestroyObjectActionLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInDestroyObjectActionAppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReadVariableActionEditPart.VISUAL_ID:
			if(ReadVariableActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
			if(OutputPinInReadVariableActionAsResultLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(OutputPinInReadVariableActionAsResultAppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AddVariableValueActionEditPart.VISUAL_ID:
			if(AddVariableValueActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
			if(InputPinInAddVariableValueActionAsInsertAtLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInAddVariableValueActionAsInsertAtAppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
			if(InputPinInAddVariableValueActionAsValueLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInAddVariableValueActionAsValueAppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BroadcastSignalActionEditPart.VISUAL_ID:
			if(BroadcastSignalActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInBroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
			if(InputPinInBroadcastSignalActionLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInBroadcastSignalActionValueLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InputPinInBroadcastSignalActionAppliedStereotypeWrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CentralBufferNodeEditPart.VISUAL_ID:
			if(CentralBufferNodeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeSelectionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID:
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityPartitionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID:
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityCNParametersCompartmentEditPart.VISUAL_ID:
			if(ParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityCNPreConditionsCompartmentEditPart.VISUAL_ID:
			if(ConstraintInActivityAsPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityCNPostConditionsCompartmentEditPart.VISUAL_ID:
			if(ConstraintInActivityAsPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityCNContentCompartmentEditPart.VISUAL_ID:
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
			if(DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ValueSpecificationActionEditPart.VISUAL_ID == nodeVisualID) {
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
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadSelfActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadStructuralFeatureActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddStructuralFeatureValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DestroyObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ReadVariableActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AddVariableValueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BroadcastSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CentralBufferNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityParameterNodeEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ObjectFlowInterruptibleIconEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ControlFlowInterruptibleIconEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExceptionHandlerEditPart.VISUAL_ID:
			if(ExceptionHandlerTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExceptionHandlerIconEditPart.VISUAL_ID == nodeVisualID) {
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
		if(UMLPackage.eINSTANCE.getObjectFlow().isSuperTypeOf(domainElement.eClass())) {
			return ObjectFlowEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getControlFlow().isSuperTypeOf(domainElement.eClass())) {
			return ControlFlowEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getExceptionHandler().isSuperTypeOf(domainElement.eClass())) {
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
		Object result = UMLOCLFactory.getExpression(12, UMLPackage.eINSTANCE.getConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isConstraint_3012(Constraint domainElement) {
		Object result = UMLOCLFactory.getExpression(13, UMLPackage.eINSTANCE.getConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3046(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(14, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3047(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(15, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3048(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(16, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3049(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(17, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3050(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(18, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3051(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(19, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3053(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(20, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3054(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(21, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3055(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(22, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3060(ValuePin domainElement) {
		Object result = UMLOCLFactory.getExpression(23, UMLPackage.eINSTANCE.getValuePin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3061(ActionInputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(24, UMLPackage.eINSTANCE.getActionInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3062(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(25, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isExpansionNode_3074(ExpansionNode domainElement) {
		Object result = UMLOCLFactory.getExpression(26, UMLPackage.eINSTANCE.getExpansionNode(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isExpansionNode_3075(ExpansionNode domainElement) {
		Object result = UMLOCLFactory.getExpression(27, UMLPackage.eINSTANCE.getExpansionNode(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * Redirect call to defined method
	 * 
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3092(View containerView, InputPin domainElement) {
		return isInputPin_3092(domainElement);
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3092(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(29, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3093(View containerView, InputPin domainElement) {
		return isInputPin_3093(domainElement);
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3093(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(30, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3096(View containerView, InputPin domainElement) {
		return isInputPin_3096(domainElement);
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3096(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(31, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isOutputPin_3098(View containerView, OutputPin domainElement) {
		return isOutputPin_3098(domainElement);
	}

	/**
	 * @generated
	 */
	private static boolean isOutputPin_3098(OutputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(32, UMLPackage.eINSTANCE.getOutputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3100(View containerView, InputPin domainElement) {
		return isInputPin_3100(domainElement);
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3100(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(33, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3101(View containerView, InputPin domainElement) {
		return isInputPin_3101(domainElement);
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3101(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(34, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated NOT (method generation is missing or generated calls are incorrect)
	 */
	private static boolean isInputPin_3103(View containerView, InputPin domainElement) {
		return isInputPin_3103(domainElement);
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3103(InputPin domainElement) {
		Object result = UMLOCLFactory.getExpression(35, UMLPackage.eINSTANCE.getInputPin(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
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
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
		case ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
		case ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
		case LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
		case SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
		case StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
		case ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID:
		case InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID:
		case ActivityCNParametersCompartmentEditPart.VISUAL_ID:
		case ActivityCNPreConditionsCompartmentEditPart.VISUAL_ID:
		case ActivityCNPostConditionsCompartmentEditPart.VISUAL_ID:
		case ActivityCNContentCompartmentEditPart.VISUAL_ID:
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
		case ActivityDiagramEditPart.VISUAL_ID:
			return false;
		case ParameterEditPart.VISUAL_ID:
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
		case InitialNodeEditPart.VISUAL_ID:
		case ActivityFinalNodeEditPart.VISUAL_ID:
		case FlowFinalNodeEditPart.VISUAL_ID:
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case InputPinInOpaqueActEditPart.VISUAL_ID:
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
		case ValuePinInCallBeActEditPart.VISUAL_ID:
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
		case InputPinInCallBeActEditPart.VISUAL_ID:
		case OutputPinInCallBeActEditPart.VISUAL_ID:
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
		case ValuePinInCallOpActEditPart.VISUAL_ID:
		case InputPinInCallOpActEditPart.VISUAL_ID:
		case OutputPinInCallOpActEditPart.VISUAL_ID:
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case DecisionNodeEditPart.VISUAL_ID:
		case MergeNodeEditPart.VISUAL_ID:
		case ForkNodeEditPart.VISUAL_ID:
		case JoinNodeEditPart.VISUAL_ID:
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
		case ValuePinInSendSigActEditPart.VISUAL_ID:
		case InputPinInSendSigActEditPart.VISUAL_ID:
		case ActivityParameterNodeEditPart.VISUAL_ID:
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
		case ExpansionNodeAsInEditPart.VISUAL_ID:
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
		case OutputPinInValSpecActEditPart.VISUAL_ID:
		case DataStoreNodeEditPart.VISUAL_ID:
		case CommentEditPartCN.VISUAL_ID:
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
		case ShapeNamedElementEditPart.VISUAL_ID:
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
		case CentralBufferNodeEditPart.VISUAL_ID:
		case InputPinInLoopNodeAsVariableEditPart.VISUAL_ID:
		case OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID:
		case OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID:
		case OutputPinInLoopNodeAsResultEditPart.VISUAL_ID:
		case ConstraintEditPartCN.VISUAL_ID:
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
			return org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		public String getModelID(View view) {
			return org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

	/**
	 * @generated
	 */
	private static boolean isIntervalConstraint_3032(IntervalConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(10, UMLPackage.eINSTANCE.getIntervalConstraint(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isIntervalConstraint_3033(IntervalConstraint domainElement) {
		Object result = UMLOCLFactory.getExpression(11, UMLPackage.eINSTANCE.getIntervalConstraint(), null).evaluate(domainElement);
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
}
