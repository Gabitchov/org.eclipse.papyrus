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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCBActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCOActAsTargetLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCOActAsTargetValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCOActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityIsSingleExecutionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowGuardEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowWeightEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionInputEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionInputFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCOActAsTargetLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinSpecEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowGuardEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowWeightEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCBActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCOActAsTargetLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCOActAsTargetValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCOActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOActValueEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.activity.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationConstraint;
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
	private static UMLAbstractExpression ActionInputPin_3021_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression ValuePin_3022_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression InputPin_3023_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression ValuePin_3025_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression ActionInputPin_3026_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression InputPin_3027_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Constraint_3011_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression Constraint_3012_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression InteractionConstraint_3030_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression InteractionConstraint_3031_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression IntervalConstraint_3032_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression IntervalConstraint_3033_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression DurationConstraint_3034_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression DurationConstraint_3035_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression TimeConstraint_3036_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression TimeConstraint_3037_Constraint;

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
			break;
		case ActivityDiagramEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityEditPart.VISUAL_ID;
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
			break;
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			if(ActionInputPinInOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInOActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			if(InputPinInOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			if(OutputPinInOActLabelEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			if(ActionInputPinInCBActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCBActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInCallBeActEditPart.VISUAL_ID:
			if(InputPinInCBActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			if(OutputPinInCBActLabelEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			if(ValuePinInCOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ValuePinInCOActValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInCallOpActEditPart.VISUAL_ID:
			if(InputPinInCOActLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			if(OutputPinInCOActLabelEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			if(ActionInputPinInCOActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActionInputPinInCOActAsTargetValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			if(InputPinInCOActAsTargetLabelEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case JoinNodeEditPart.VISUAL_ID:
			if(JoinSpecEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case ActivityDiagramEditPart.VISUAL_ID:
			if(ActivityEditPart.VISUAL_ID == nodeVisualID) {
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
		if(ActionInputPin_3021_Constraint == null) { // lazy initialization
			ActionInputPin_3021_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).argument->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getActionInputPin()); //$NON-NLS-1$
		}
		Object result = ActionInputPin_3021_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3022(ValuePin domainElement) {
		if(ValuePin_3022_Constraint == null) { // lazy initialization
			ValuePin_3022_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).argument->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getValuePin()); //$NON-NLS-1$
		}
		Object result = ValuePin_3022_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3023(InputPin domainElement) {
		if(InputPin_3023_Constraint == null) { // lazy initialization
			InputPin_3023_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).argument->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getInputPin()); //$NON-NLS-1$
		}
		Object result = InputPin_3023_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isValuePin_3025(ValuePin domainElement) {
		if(ValuePin_3025_Constraint == null) { // lazy initialization
			ValuePin_3025_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).target = self\r\nelse false endif", UMLPackage.eINSTANCE.getValuePin()); //$NON-NLS-1$
		}
		Object result = ValuePin_3025_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isActionInputPin_3026(ActionInputPin domainElement) {
		if(ActionInputPin_3026_Constraint == null) { // lazy initialization
			ActionInputPin_3026_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).target = self\r\nelse false endif", UMLPackage.eINSTANCE.getActionInputPin()); //$NON-NLS-1$
		}
		Object result = ActionInputPin_3026_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInputPin_3027(InputPin domainElement) {
		if(InputPin_3027_Constraint == null) { // lazy initialization
			InputPin_3027_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).target = self\r\nelse false endif", UMLPackage.eINSTANCE.getInputPin()); //$NON-NLS-1$
		}
		Object result = InputPin_3027_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isConstraint_3011(Constraint domainElement) {
		if(Constraint_3011_Constraint == null) { // lazy initialization
			Constraint_3011_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getConstraint()); //$NON-NLS-1$
		}
		Object result = Constraint_3011_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isConstraint_3012(Constraint domainElement) {
		if(Constraint_3012_Constraint == null) { // lazy initialization
			Constraint_3012_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getConstraint()); //$NON-NLS-1$
		}
		Object result = Constraint_3012_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInteractionConstraint_3030(InteractionConstraint domainElement) {
		if(InteractionConstraint_3030_Constraint == null) { // lazy initialization
			InteractionConstraint_3030_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getInteractionConstraint()); //$NON-NLS-1$
		}
		Object result = InteractionConstraint_3030_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInteractionConstraint_3031(InteractionConstraint domainElement) {
		if(InteractionConstraint_3031_Constraint == null) { // lazy initialization
			InteractionConstraint_3031_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getInteractionConstraint()); //$NON-NLS-1$
		}
		Object result = InteractionConstraint_3031_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isIntervalConstraint_3032(IntervalConstraint domainElement) {
		if(IntervalConstraint_3032_Constraint == null) { // lazy initialization
			IntervalConstraint_3032_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getIntervalConstraint()); //$NON-NLS-1$
		}
		Object result = IntervalConstraint_3032_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isIntervalConstraint_3033(IntervalConstraint domainElement) {
		if(IntervalConstraint_3033_Constraint == null) { // lazy initialization
			IntervalConstraint_3033_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getIntervalConstraint()); //$NON-NLS-1$
		}
		Object result = IntervalConstraint_3033_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDurationConstraint_3034(DurationConstraint domainElement) {
		if(DurationConstraint_3034_Constraint == null) { // lazy initialization
			DurationConstraint_3034_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getDurationConstraint()); //$NON-NLS-1$
		}
		Object result = DurationConstraint_3034_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isDurationConstraint_3035(DurationConstraint domainElement) {
		if(DurationConstraint_3035_Constraint == null) { // lazy initialization
			DurationConstraint_3035_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getDurationConstraint()); //$NON-NLS-1$
		}
		Object result = DurationConstraint_3035_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isTimeConstraint_3036(TimeConstraint domainElement) {
		if(TimeConstraint_3036_Constraint == null) { // lazy initialization
			TimeConstraint_3036_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getTimeConstraint()); //$NON-NLS-1$
		}
		Object result = TimeConstraint_3036_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isTimeConstraint_3037(TimeConstraint domainElement) {
		if(TimeConstraint_3037_Constraint == null) { // lazy initialization
			TimeConstraint_3037_Constraint = UMLOCLFactory.getExpression("if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", UMLPackage.eINSTANCE.getTimeConstraint()); //$NON-NLS-1$
		}
		Object result = TimeConstraint_3037_Constraint.evaluate(domainElement);
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

		viewInfo = new BaseViewInfo(4004, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6003, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6004, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6009, ViewInfo.Label, "", null, viewInfo);
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

		viewInfo = new BaseViewInfo(3016, ViewInfo.Node, "ActionInputPin");

		root.addNode(3007, viewInfo);

		viewInfo = new BaseViewInfo(3013, ViewInfo.Node, "InputPin");

		root.addNode(3007, viewInfo);

		viewInfo = new BaseViewInfo(3014, ViewInfo.Node, "OutputPin");

		root.addNode(3007, viewInfo);

		viewInfo = new BaseViewInfo(3008, ViewInfo.Node, "CallBehaviorAction");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3017, ViewInfo.Node, "ValuePin");

		root.addNode(3008, viewInfo);

		viewInfo = new BaseViewInfo(3018, ViewInfo.Node, "ActionInputPin");

		root.addNode(3008, viewInfo);

		viewInfo = new BaseViewInfo(3019, ViewInfo.Node, "InputPin");

		root.addNode(3008, viewInfo);

		viewInfo = new BaseViewInfo(3020, ViewInfo.Node, "OutputPin");

		root.addNode(3008, viewInfo);

		viewInfo = new BaseViewInfo(3010, ViewInfo.Node, "CallOperationAction");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3021, ViewInfo.Node, "ActionInputPin");

		root.addNode(3010, viewInfo);

		viewInfo = new BaseViewInfo(3022, ViewInfo.Node, "ValuePin");

		root.addNode(3010, viewInfo);

		viewInfo = new BaseViewInfo(3023, ViewInfo.Node, "InputPin");

		root.addNode(3010, viewInfo);

		viewInfo = new BaseViewInfo(3024, ViewInfo.Node, "OutputPin");

		root.addNode(3010, viewInfo);

		viewInfo = new BaseViewInfo(3025, ViewInfo.Node, "ValuePin");

		root.addNode(3010, viewInfo);

		viewInfo = new BaseViewInfo(3026, ViewInfo.Node, "ActionInputPin");

		root.addNode(3010, viewInfo);

		viewInfo = new BaseViewInfo(3027, ViewInfo.Node, "InputPin");

		root.addNode(3010, viewInfo);

		viewInfo = new BaseViewInfo(3034, ViewInfo.Node, "DurationConstraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3035, ViewInfo.Node, "DurationConstraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3036, ViewInfo.Node, "TimeConstraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3037, ViewInfo.Node, "TimeConstraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3030, ViewInfo.Node, "InteractionConstraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3031, ViewInfo.Node, "InteractionConstraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3032, ViewInfo.Node, "IntervalConstraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3033, ViewInfo.Node, "IntervalConstraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3011, ViewInfo.Node, "Constraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3012, ViewInfo.Node, "Constraint");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3038, ViewInfo.Node, "DecisionNode");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3039, ViewInfo.Node, "MergeNode");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3040, ViewInfo.Node, "ForkNode");

		root.addNode(7004, viewInfo);

		viewInfo = new BaseViewInfo(3041, ViewInfo.Node, "JoinNode");

		root.addNode(7004, viewInfo);

		return root;
	}

}
