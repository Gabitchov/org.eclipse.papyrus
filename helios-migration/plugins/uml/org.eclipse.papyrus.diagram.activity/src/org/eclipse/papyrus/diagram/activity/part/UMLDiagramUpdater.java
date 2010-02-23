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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityAsTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintInActivityAsPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3007SemanticChildren(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3008SemanticChildren(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3010SemanticChildren(view);
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
			return getActivityActivityParametersCompartment_7001SemanticChildren(view);
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
			return getActivityActivityPreConditionsCompartment_7002SemanticChildren(view);
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
			return getActivityActivityPostConditionsCompartment_7003SemanticChildren(view);
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
			return getActivityActivityContentCompartment_7004SemanticChildren(view);
		case ActivityDiagramEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_3007SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		OpaqueAction modelElement = (OpaqueAction)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getInputValues().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ValuePinInOpaqueActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActionInputPinInOpaqueActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InputPinInOpaqueActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOutputValues().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInOpaqueActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallBehaviorAction_3008SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CallBehaviorAction modelElement = (CallBehaviorAction)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getArguments().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ValuePinInCallBeActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActionInputPinInCallBeActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InputPinInCallBeActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getResults().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInCallBeActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallOperationAction_3010SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CallOperationAction modelElement = (CallOperationAction)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getArguments().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActionInputPinInCallOpActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValuePinInCallOpActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InputPinInCallOpActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getResults().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInCallOpActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			InputPin childElement = modelElement.getTarget();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ValuePinInCallOpActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == InputPinInCallOpActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityActivityParametersCompartment_7001SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
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
	public static List getActivityActivityPreConditionsCompartment_7002SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPreconditions().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintInActivityAsPrecondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityActivityPostConditionsCompartment_7003SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPostconditions().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintInActivityAsPostcondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (add children actions' local conditions and object flows' specification)
	 */
	public static List getActivityActivityContentCompartment_7004SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
			}
			//add children objectflows' specification
			if(childElement instanceof ObjectFlow) {
				result.addAll(getObjectFlowSpecificationDescriptors((ObjectFlow)childElement, view));
			}
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InitialNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActivityFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FlowFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OpaqueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CallBehaviorActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CallOperationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * Get the node descriptors corresponding to transformation and selection of an Object Flow.
	 * These nodes are children of ActivityContentCompartment_7004.
	 * 
	 * @param objectFlowElement
	 *        the object flow being specified
	 * @param parentView
	 *        the parent activity content compartment view
	 * @return the list of semantic children (node descriptors)
	 * @generated NOT
	 */
	private static List<UMLNodeDescriptor> getObjectFlowSpecificationDescriptors(ObjectFlow objectFlowElement, View parentView) {
		/*
		 * Called above by customized code (instead of generated code with errors) :
		 * //add children actions' local conditions
		 * if(childElement instanceof Action) {
		 * result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
		 * }
		 */
		List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		Behavior childElement = objectFlowElement.getSelection();
		if(childElement != null) {
			int visualID = UMLVisualIDRegistry.getNodeVisualID(parentView, childElement);
			// there is no way to distinguish VISUAL_ID of a selection from a transformation, since the element can be both at the same time
			if(ActivityAsSelectionEditPart.VISUAL_ID == visualID || ActivityAsTransformationEditPart.VISUAL_ID == visualID) {
				result.add(new UMLNodeDescriptor(childElement, ActivityAsSelectionEditPart.VISUAL_ID));
			}
		}
		childElement = objectFlowElement.getTransformation();
		if(childElement != null) {
			int visualID = UMLVisualIDRegistry.getNodeVisualID(parentView, childElement);
			// there is no way to distinguish VISUAL_ID of a selection from a transformation, since the element can be both at the same time
			if(ActivityAsSelectionEditPart.VISUAL_ID == visualID || ActivityAsTransformationEditPart.VISUAL_ID == visualID) {
				result.add(new UMLNodeDescriptor(childElement, ActivityAsTransformationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * Get the node descriptors corresponding to local pre and post conditions of an action.
	 * These nodes are children of ActivityContentCompartment_7004.
	 * 
	 * @param actionElement
	 *        the action containing conditions
	 * @param parentView
	 *        the parent activity content compartment view
	 * @return the list of semantic children (node descriptors)
	 * @generated NOT
	 */
	private static List<UMLNodeDescriptor> getActionLocalConditionsDescriptors(Action actionElement, View parentView) {
		/*
		 * Called above by customized code (instead of generated code with errors) :
		 * //add children actions' local conditions
		 * if(childElement instanceof Action) {
		 * result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
		 * }
		 */
		List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Constraint childElement : actionElement.getLocalPreconditions()) {
			int visualID = UMLVisualIDRegistry.getNodeVisualID(parentView, childElement);
			if(visualID == ConstraintAsLocalPrecondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DurationConstraintAsLocalPrecondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintAsLocalPrecondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Constraint childElement : actionElement.getLocalPostconditions()) {
			int visualID = UMLVisualIDRegistry.getNodeVisualID(parentView, childElement);
			if(visualID == ConstraintAsLocalPostcondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DurationConstraintAsLocalPostcondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeConstraintAsLocalPostcondEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityDiagramEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2001ContainedLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001ContainedLinks(view);
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return getConstraint_3002ContainedLinks(view);
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return getConstraint_3003ContainedLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3004ContainedLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3005ContainedLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3006ContainedLinks(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3007ContainedLinks(view);
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			return getValuePin_3015ContainedLinks(view);
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			return getActionInputPin_3016ContainedLinks(view);
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			return getInputPin_3013ContainedLinks(view);
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			return getOutputPin_3014ContainedLinks(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3008ContainedLinks(view);
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			return getValuePin_3017ContainedLinks(view);
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			return getActionInputPin_3018ContainedLinks(view);
		case InputPinInCallBeActEditPart.VISUAL_ID:
			return getInputPin_3019ContainedLinks(view);
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			return getOutputPin_3020ContainedLinks(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3010ContainedLinks(view);
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			return getActionInputPin_3021ContainedLinks(view);
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			return getValuePin_3022ContainedLinks(view);
		case InputPinInCallOpActEditPart.VISUAL_ID:
			return getInputPin_3023ContainedLinks(view);
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return getOutputPin_3024ContainedLinks(view);
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3025ContainedLinks(view);
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3026ContainedLinks(view);
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3027ContainedLinks(view);
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getDurationConstraint_3034ContainedLinks(view);
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getDurationConstraint_3035ContainedLinks(view);
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getTimeConstraint_3036ContainedLinks(view);
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getTimeConstraint_3037ContainedLinks(view);
		case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getInteractionConstraint_3030ContainedLinks(view);
		case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getInteractionConstraint_3031ContainedLinks(view);
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getIntervalConstraint_3032ContainedLinks(view);
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getIntervalConstraint_3033ContainedLinks(view);
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getConstraint_3011ContainedLinks(view);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getConstraint_3012ContainedLinks(view);
		case ActivityAsSelectionEditPart.VISUAL_ID:
			return getActivity_3028ContainedLinks(view);
		case ActivityAsTransformationEditPart.VISUAL_ID:
			return getActivity_3029ContainedLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4003ContainedLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4004ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2001IncomingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001IncomingLinks(view);
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return getConstraint_3002IncomingLinks(view);
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return getConstraint_3003IncomingLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3004IncomingLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3005IncomingLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3006IncomingLinks(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3007IncomingLinks(view);
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			return getValuePin_3015IncomingLinks(view);
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			return getActionInputPin_3016IncomingLinks(view);
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			return getInputPin_3013IncomingLinks(view);
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			return getOutputPin_3014IncomingLinks(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3008IncomingLinks(view);
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			return getValuePin_3017IncomingLinks(view);
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			return getActionInputPin_3018IncomingLinks(view);
		case InputPinInCallBeActEditPart.VISUAL_ID:
			return getInputPin_3019IncomingLinks(view);
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			return getOutputPin_3020IncomingLinks(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3010IncomingLinks(view);
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			return getActionInputPin_3021IncomingLinks(view);
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			return getValuePin_3022IncomingLinks(view);
		case InputPinInCallOpActEditPart.VISUAL_ID:
			return getInputPin_3023IncomingLinks(view);
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return getOutputPin_3024IncomingLinks(view);
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3025IncomingLinks(view);
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3026IncomingLinks(view);
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3027IncomingLinks(view);
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getDurationConstraint_3034IncomingLinks(view);
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getDurationConstraint_3035IncomingLinks(view);
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getTimeConstraint_3036IncomingLinks(view);
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getTimeConstraint_3037IncomingLinks(view);
		case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getInteractionConstraint_3030IncomingLinks(view);
		case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getInteractionConstraint_3031IncomingLinks(view);
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getIntervalConstraint_3032IncomingLinks(view);
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getIntervalConstraint_3033IncomingLinks(view);
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getConstraint_3011IncomingLinks(view);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getConstraint_3012IncomingLinks(view);
		case ActivityAsSelectionEditPart.VISUAL_ID:
			return getActivity_3028IncomingLinks(view);
		case ActivityAsTransformationEditPart.VISUAL_ID:
			return getActivity_3029IncomingLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4003IncomingLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4004IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2001OutgoingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001OutgoingLinks(view);
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return getConstraint_3002OutgoingLinks(view);
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return getConstraint_3003OutgoingLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3004OutgoingLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3005OutgoingLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3006OutgoingLinks(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3007OutgoingLinks(view);
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			return getValuePin_3015OutgoingLinks(view);
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			return getActionInputPin_3016OutgoingLinks(view);
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			return getInputPin_3013OutgoingLinks(view);
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			return getOutputPin_3014OutgoingLinks(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3008OutgoingLinks(view);
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			return getValuePin_3017OutgoingLinks(view);
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			return getActionInputPin_3018OutgoingLinks(view);
		case InputPinInCallBeActEditPart.VISUAL_ID:
			return getInputPin_3019OutgoingLinks(view);
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			return getOutputPin_3020OutgoingLinks(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3010OutgoingLinks(view);
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			return getActionInputPin_3021OutgoingLinks(view);
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			return getValuePin_3022OutgoingLinks(view);
		case InputPinInCallOpActEditPart.VISUAL_ID:
			return getInputPin_3023OutgoingLinks(view);
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return getOutputPin_3024OutgoingLinks(view);
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3025OutgoingLinks(view);
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3026OutgoingLinks(view);
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3027OutgoingLinks(view);
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getDurationConstraint_3034OutgoingLinks(view);
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getDurationConstraint_3035OutgoingLinks(view);
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getTimeConstraint_3036OutgoingLinks(view);
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getTimeConstraint_3037OutgoingLinks(view);
		case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getInteractionConstraint_3030OutgoingLinks(view);
		case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getInteractionConstraint_3031OutgoingLinks(view);
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getIntervalConstraint_3032OutgoingLinks(view);
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getIntervalConstraint_3033OutgoingLinks(view);
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getConstraint_3011OutgoingLinks(view);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getConstraint_3012OutgoingLinks(view);
		case ActivityAsSelectionEditPart.VISUAL_ID:
			return getActivity_3028OutgoingLinks(view);
		case ActivityAsTransformationEditPart.VISUAL_ID:
			return getActivity_3029OutgoingLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4003OutgoingLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4004OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2001ContainedLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getParameter_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_3007ContainedLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3015ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3016ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3013ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3014ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCallBehaviorAction_3008ContainedLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3017ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3019ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3020ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCallOperationAction_3010ContainedLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3021ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3022ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3023ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3024ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3025ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3026ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3027ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3011ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3012ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_3028ContainedLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivity_3029ContainedLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteractionConstraint_3030ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteractionConstraint_3031ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIntervalConstraint_3032ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIntervalConstraint_3033ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3034ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3035ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3036ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3037ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getObjectFlow_4003ContainedLinks(View view) {
		ObjectFlow modelElement = (ObjectFlow)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectFlow_Selection_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectFlow_Transformation_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getControlFlow_4004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2001IncomingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_ObjectFlow_Selection_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ObjectFlow_Transformation_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getParameter_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_3004IncomingLinks(View view) {
		InitialNode modelElement = (InitialNode)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_3005IncomingLinks(View view) {
		ActivityFinalNode modelElement = (ActivityFinalNode)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_3006IncomingLinks(View view) {
		FlowFinalNode modelElement = (FlowFinalNode)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_3007IncomingLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3015IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3016IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3013IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3014IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallBehaviorAction_3008IncomingLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3017IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3018IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3019IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3020IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallOperationAction_3010IncomingLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3021IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3022IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3023IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3024IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3025IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3026IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3027IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3011IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3012IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivity_3028IncomingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_ObjectFlow_Selection_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ObjectFlow_Transformation_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivity_3029IncomingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_ObjectFlow_Selection_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ObjectFlow_Transformation_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteractionConstraint_3030IncomingLinks(View view) {
		InteractionConstraint modelElement = (InteractionConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteractionConstraint_3031IncomingLinks(View view) {
		InteractionConstraint modelElement = (InteractionConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIntervalConstraint_3032IncomingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIntervalConstraint_3033IncomingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3034IncomingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3035IncomingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3036IncomingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3037IncomingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getObjectFlow_4003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getControlFlow_4004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getParameter_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_3004OutgoingLinks(View view) {
		InitialNode modelElement = (InitialNode)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_3005OutgoingLinks(View view) {
		ActivityFinalNode modelElement = (ActivityFinalNode)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_3006OutgoingLinks(View view) {
		FlowFinalNode modelElement = (FlowFinalNode)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_3007OutgoingLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3015OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3016OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3013OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3014OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallBehaviorAction_3008OutgoingLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3017OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3018OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3019OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3020OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallOperationAction_3010OutgoingLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3021OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3022OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3023OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_3024OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_3025OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionInputPin_3026OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_3027OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3011OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3012OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_3028OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_3029OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteractionConstraint_3030OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteractionConstraint_3031OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIntervalConstraint_3032OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIntervalConstraint_3033OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3034OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3035OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3036OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3037OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getObjectFlow_4003OutgoingLinks(View view) {
		ObjectFlow modelElement = (ObjectFlow)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectFlow_Selection_4005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectFlow_Transformation_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getControlFlow_4004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ObjectFlow_4003(Activity container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ObjectFlow) {
				continue;
			}
			ObjectFlow link = (ObjectFlow)linkObject;
			if(ObjectFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			ActivityNode dst = link.getTarget();
			ActivityNode src = link.getSource();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ObjectFlow_4003, ObjectFlowEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ControlFlow_4004(Activity container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ControlFlow) {
				continue;
			}
			ControlFlow link = (ControlFlow)linkObject;
			if(ControlFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			ActivityNode dst = link.getTarget();
			ActivityNode src = link.getSource();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ControlFlow_4004, ControlFlowEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(Constraint target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getAction_LocalPrecondition()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ActionLocalPrecondition_4001, ActionLocalPreconditionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(Constraint target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getAction_LocalPostcondition()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ActionLocalPostcondition_4002, ActionLocalPostconditionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_ObjectFlow_Selection_4005(Behavior target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getObjectFlow_Selection()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ObjectFlowSelection_4005, ObjectFlowSelectionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_ObjectFlow_Transformation_4006(Behavior target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getObjectFlow_Transformation()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ObjectFlowTransformation_4006, ObjectFlowTransformationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ObjectFlow_4003(ActivityNode target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getActivityEdge_Target() || false == setting.getEObject() instanceof ObjectFlow) {
				continue;
			}
			ObjectFlow link = (ObjectFlow)setting.getEObject();
			if(ObjectFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityNode src = link.getSource();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.ObjectFlow_4003, ObjectFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ControlFlow_4004(ActivityNode target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getActivityEdge_Target() || false == setting.getEObject() instanceof ControlFlow) {
				continue;
			}
			ControlFlow link = (ControlFlow)setting.getEObject();
			if(ControlFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityNode src = link.getSource();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.ControlFlow_4004, ControlFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(Action source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getLocalPreconditions().iterator(); destinations.hasNext();) {
			Constraint destination = (Constraint)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ActionLocalPrecondition_4001, ActionLocalPreconditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(Action source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getLocalPostconditions().iterator(); destinations.hasNext();) {
			Constraint destination = (Constraint)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ActionLocalPostcondition_4002, ActionLocalPostconditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_ObjectFlow_Selection_4005(ObjectFlow source) {
		Collection result = new LinkedList();
		Behavior destination = source.getSelection();
		if(destination == null) {
			return result;
		}
		result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ObjectFlowSelection_4005, ObjectFlowSelectionEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_ObjectFlow_Transformation_4006(ObjectFlow source) {
		Collection result = new LinkedList();
		Behavior destination = source.getTransformation();
		if(destination == null) {
			return result;
		}
		result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ObjectFlowTransformation_4006, ObjectFlowTransformationEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ObjectFlow_4003(ActivityNode source) {
		Activity container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Activity) {
				container = (Activity)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ObjectFlow) {
				continue;
			}
			ObjectFlow link = (ObjectFlow)linkObject;
			if(ObjectFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			ActivityNode dst = link.getTarget();
			ActivityNode src = link.getSource();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ObjectFlow_4003, ObjectFlowEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ControlFlow_4004(ActivityNode source) {
		Activity container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Activity) {
				container = (Activity)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ControlFlow) {
				continue;
			}
			ControlFlow link = (ControlFlow)linkObject;
			if(ControlFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			ActivityNode dst = link.getTarget();
			ActivityNode src = link.getSource();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ControlFlow_4004, ControlFlowEditPart.VISUAL_ID));

		}
		return result;
	}

}
