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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsSelectionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsTransformationNameEditPart;
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
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowWeightEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCBActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCOActAsTargetLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOActLabelEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowNameEditPart;
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
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Package;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.activity/debug/visualID"; //$NON-NLS-1$

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
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return ActionInputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())

			) {
				return ValuePinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return InputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return OutputPinInCallOpActEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())

			) {
				return ValuePinInCallOpActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActionInputPin().isSuperTypeOf(domainElement.eClass())

			) {
				return ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())

			) {
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
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass()) && isConstraint_3011(containerView, (Constraint)domainElement)) {
				return ConstraintAsLocalPrecondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass()) && isConstraint_3012(containerView, (Constraint)domainElement)) {
				return ConstraintAsLocalPostcondEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityAsSelectionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityAsTransformationEditPart.VISUAL_ID;
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
		case ActivityAsSelectionEditPart.VISUAL_ID:
			if(ActivityAsSelectionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityAsTransformationEditPart.VISUAL_ID:
			if(ActivityAsTransformationNameEditPart.VISUAL_ID == nodeVisualID) {
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
			if(ConstraintAsLocalPrecondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintAsLocalPostcondEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityAsSelectionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityAsTransformationEditPart.VISUAL_ID == nodeVisualID) {
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
			break;
		case ControlFlowEditPart.VISUAL_ID:
			if(ControlFlowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ControlFlowWeightEditPart.VISUAL_ID == nodeVisualID) {
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


		viewInfo = new BaseViewInfo(4005, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4006, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4003, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6002, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4004, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6003, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6004, ViewInfo.Label, "", null, viewInfo);
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


		viewInfo = new BaseViewInfo(3011, ViewInfo.Node, "Constraint");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3012, ViewInfo.Node, "Constraint");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3028, ViewInfo.Node, "Activity");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3029, ViewInfo.Node, "Activity");

		root.addNode(7004, viewInfo);

		return root;
	}

}
