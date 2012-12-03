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
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.AddVariableValueAction;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BroadcastSignalAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.CentralBufferNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.DestroyObjectAction;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.ReadVariableAction;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecificationAction;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityDiagramEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2001SemanticChildren(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3007SemanticChildren(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3008SemanticChildren(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3010SemanticChildren(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_3042SemanticChildren(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_3052SemanticChildren(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3063SemanticChildren(view);
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return getValueSpecificationAction_3076SemanticChildren(view);
		case ExpansionRegionEditPart.VISUAL_ID:
			return getExpansionRegion_3070SemanticChildren(view);
		case LoopNodeEditPart.VISUAL_ID:
			return getLoopNode_3071SemanticChildren(view);
		case ReadSelfActionEditPart.VISUAL_ID:
			return getReadSelfAction_3081SemanticChildren(view);
		case ActivityEditPartCN.VISUAL_ID:
			return getActivity_3083SemanticChildren(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3086SemanticChildren(view);
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			return getReadStructuralFeatureAction_3088SemanticChildren(view);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3091SemanticChildren(view);
		case DestroyObjectActionEditPart.VISUAL_ID:
			return getDestroyObjectAction_3095SemanticChildren(view);
		case ReadVariableActionEditPart.VISUAL_ID:
			return getReadVariableAction_3097SemanticChildren(view);
		case AddVariableValueActionEditPart.VISUAL_ID:
			return getAddVariableValueAction_3099SemanticChildren(view);
		case BroadcastSignalActionEditPart.VISUAL_ID:
			return getBroadcastSignalAction_3102SemanticChildren(view);
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
			return getActivityActivityFigureParameterCompartment_7001SemanticChildren(view);
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
			return getActivityActivityFigurePreconditionCompartment_7002SemanticChildren(view);
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
			return getActivityActivityFigurePostCondtionCompartment_7003SemanticChildren(view);
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
			return getActivityActivityFigureContentCompartment_7004SemanticChildren(view);
		case ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			return getConditionalNodeStructuredActivityNodeContentCompartment_7008SemanticChildren(view);
		case ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			return getExpansionRegionStructuredActivityNodeContentCompartment_7009SemanticChildren(view);
		case LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			return getLoopNodeStructuredActivityNodeContentCompartment_7010SemanticChildren(view);
		case SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			return getSequenceNodeStructuredActivityNodeContentCompartment_7012SemanticChildren(view);
		case StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
			return getStructuredActivityNodeStructuredActivityNodeContentCompartment_7005SemanticChildren(view);
		case ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID:
			return getActivityPartitionActivityPartitionContentCompartment_7006SemanticChildren(view);
		case InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID:
			return getInterruptibleActivityRegionInterruptibleActivityRegionContentCompartment_7007SemanticChildren(view);
		case ActivityCNParametersCompartmentEditPart.VISUAL_ID:
			return getActivityActivityFigureParameterCompartment_7014SemanticChildren(view);
		case ActivityCNPreConditionsCompartmentEditPart.VISUAL_ID:
			return getActivityActivityFigurePreconditionCompartment_7015SemanticChildren(view);
		case ActivityCNPostConditionsCompartmentEditPart.VISUAL_ID:
			return getActivityActivityFigurePostCondtionCompartment_7016SemanticChildren(view);
		case ActivityCNContentCompartmentEditPart.VISUAL_ID:
			return getActivityActivityFigureContentCompartment_7013SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getActivity_2001SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityParameterNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getOpaqueAction_3007SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		OpaqueAction modelElement = (OpaqueAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getInputValues().iterator(); it.hasNext();) {
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
		for(Iterator<?> it = modelElement.getOutputValues().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getCallBehaviorAction_3008SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CallBehaviorAction modelElement = (CallBehaviorAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getArguments().iterator(); it.hasNext();) {
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
		for(Iterator<?> it = modelElement.getResults().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getCallOperationAction_3010SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CallOperationAction modelElement = (CallOperationAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getArguments().iterator(); it.hasNext();) {
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
		for(Iterator<?> it = modelElement.getResults().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getSendObjectAction_3042SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		SendObjectAction modelElement = (SendObjectAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			InputPin childElement = modelElement.getRequest();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ValuePinInSendObjActAsReqEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == InputPinInSendObjActAsReqEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			InputPin childElement = modelElement.getTarget();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ValuePinInSendObjActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == InputPinInSendObjActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSendSignalAction_3052SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		SendSignalAction modelElement = (SendSignalAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getArguments().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActionInputPinInSendSigActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValuePinInSendSigActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InputPinInSendSigActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			InputPin childElement = modelElement.getTarget();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ValuePinInSendSigActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == InputPinInSendSigActAsTargetEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getAcceptEventAction_3063SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		AcceptEventAction modelElement = (AcceptEventAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getResults().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInAcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getExpansionRegion_3070SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ExpansionRegion modelElement = (ExpansionRegion)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getInputElements().iterator(); it.hasNext();) {
			ExpansionNode childElement = (ExpansionNode)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExpansionNodeAsInEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOutputElements().iterator(); it.hasNext();) {
			ExpansionNode childElement = (ExpansionNode)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExpansionNodeAsOutEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getLoopNode_3071SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		LoopNode modelElement = (LoopNode)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getLoopVariableInputs().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InputPinInLoopNodeAsVariableEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getResults().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInLoopNodeAsResultEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getBodyOutputs().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getLoopVariables().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getReadSelfAction_3081SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ReadSelfAction modelElement = (ReadSelfAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			OutputPin childElement = modelElement.getResult();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ReadSelfActionOutputPinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * pb to solve with output pin 3082
	 * 
	 * @generated NOT
	 */
	public static List<UMLNodeDescriptor> getOutputPin_3082SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		//		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
		//			ActivityNode childElement = (ActivityNode) it.next();
		//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
		//					childElement);
		//			if (visualID == ActivityParameterNodeEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getActivity_3083SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityParameterNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getCreateObjectAction_3086SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CreateObjectAction modelElement = (CreateObjectAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			OutputPin childElement = modelElement.getResult();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getReadStructuralFeatureAction_3088SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ReadStructuralFeatureAction modelElement = (ReadStructuralFeatureAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			InputPin childElement = modelElement.getObject();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			OutputPin childElement = modelElement.getResult();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getAddStructuralFeatureValueAction_3091SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		AddStructuralFeatureValueAction modelElement = (AddStructuralFeatureValueAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			InputPin childElement = modelElement.getObject();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			InputPin childElement = modelElement.getValue();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			OutputPin childElement = modelElement.getResult();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDestroyObjectAction_3095SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DestroyObjectAction modelElement = (DestroyObjectAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			InputPin childElement = modelElement.getTarget();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InputPinInDestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getReadVariableAction_3097SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ReadVariableAction modelElement = (ReadVariableAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			OutputPin childElement = modelElement.getResult();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getAddVariableValueAction_3099SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		AddVariableValueAction modelElement = (AddVariableValueAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			InputPin childElement = modelElement.getInsertAt();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			InputPin childElement = modelElement.getValue();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getBroadcastSignalAction_3102SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		BroadcastSignalAction modelElement = (BroadcastSignalAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getArguments().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InputPinInBroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getActivityActivityFigureParameterCompartment_7001SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getActivityActivityFigurePreconditionCompartment_7002SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPreconditions().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getActivityActivityFigurePostCondtionCompartment_7003SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPostconditions().iterator(); it.hasNext();) {
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
	 * (update at each gmf change) add children actions' local conditions
	 * 
	 * @generated NOT
	 */
	public static List<UMLNodeDescriptor> getActivityActivityFigureContentCompartment_7004SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadSelfActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		//		for (Iterator<?> it = modelElement.getLocalPreconditions().iterator(); it
		//				.hasNext();) {
		//			Constraint childElement = (Constraint) it.next();
		//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
		//					childElement);
		//			if (visualID == DurationConstraintAsLocalPrecondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == TimeConstraintAsLocalPrecondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == ConstraintAsLocalPrecondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//		}
		//		for (Iterator<?> it = modelElement.getLocalPostconditions().iterator(); it
		//				.hasNext();) {
		//			Constraint childElement = (Constraint) it.next();
		//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
		//					childElement);
		//			if (visualID == DurationConstraintAsLocalPostcondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == TimeConstraintAsLocalPostcondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == ConstraintAsLocalPostcondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//		}
		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			ActivityGroup childElement = (ActivityGroup)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActivityPartitionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterruptibleActivityRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedBehaviors().iterator(); it.hasNext();) {
			Behavior childElement = (Behavior)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getValueSpecificationAction_3076SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ValueSpecificationAction modelElement = (ValueSpecificationAction)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			OutputPin childElement = modelElement.getResult();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OutputPinInValSpecActEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * (update at each gmf change) add children actions' local conditions
	 * 
	 * @generated NOT
	 */
	public static List<UMLNodeDescriptor> getActivityActivityContentCompartment_7004SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			//add children actions' local conditions (2 blocks removed)
		}
		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			ActivityGroup childElement = (ActivityGroup)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActivityPartitionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterruptibleActivityRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (update at each gmf change) add children actions' local conditions, add structured activity group as nodes
	 */
	public static List<UMLNodeDescriptor> getConditionalNodeStructuredActivityNodeContentCompartment_7008SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ConditionalNode modelElement = (ConditionalNode)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			//add children actions' local conditions (2 blocks removed)
			//add structured activity group as nodes
			//		}
			//		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			//			ActivityGroup childElement = (ActivityGroup)it.next();
			//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (update at each gmf change) add children actions' local conditions
	 */
	public static List<UMLNodeDescriptor> getExpansionRegionStructuredActivityNodeContentCompartment_7009SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ExpansionRegion modelElement = (ExpansionRegion)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			//add children actions' local conditions (2 blocks removed)
			//add structured activity group as nodes
			//		}
			//		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			//			ActivityGroup childElement = (ActivityGroup)it.next();
			//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (update at each gmf change) add children actions' local conditions, add structured activity group as nodes
	 */
	public static List<UMLNodeDescriptor> getLoopNodeStructuredActivityNodeContentCompartment_7010SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		LoopNode modelElement = (LoopNode)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			//add children actions' local conditions (2 blocks removed)
			//add structured activity group as nodes
			//		}
			//		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			//			ActivityGroup childElement = (ActivityGroup)it.next();
			//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (update at each gmf change) add children actions' local conditions, add structured activity group as nodes
	 */
	public static List<UMLNodeDescriptor> getSequenceNodeStructuredActivityNodeContentCompartment_7012SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		SequenceNode modelElement = (SequenceNode)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			//add children actions' local conditions (2 blocks removed)
			//add structured activity group as nodes
			//		}
			//		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			//			ActivityGroup childElement = (ActivityGroup)it.next();
			//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (update at each gmf change) add children actions' local conditions, add structured activity group as nodes
	 */
	public static List<UMLNodeDescriptor> getStructuredActivityNodeStructuredActivityNodeContentCompartment_7005SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		StructuredActivityNode modelElement = (StructuredActivityNode)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			//add children actions' local conditions (2 blocks removed)
			//add structured activity group as nodes
			//		}
			//		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			//			ActivityGroup childElement = (ActivityGroup)it.next();
			//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (update at each gmf change) add children actions' local conditions, add structured activity group as nodes
	 */
	public static List<UMLNodeDescriptor> getActivityPartitionActivityPartitionContentCompartment_7006SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ActivityPartition modelElement = (ActivityPartition)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			//add children actions' local conditions (2 blocks removed)
			//add structured activity group as nodes
			//		}
			//		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			//			ActivityGroup childElement = (ActivityGroup)it.next();
			//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActivityPartitionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (update at each gmf change) add children actions' local conditions, add structured activity group as nodes
	 */
	public static List<UMLNodeDescriptor> getInterruptibleActivityRegionInterruptibleActivityRegionContentCompartment_7007SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		InterruptibleActivityRegion modelElement = (InterruptibleActivityRegion)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			//add children actions' local conditions
			if(childElement instanceof Action) {
				result.addAll(getActionLocalConditionsDescriptors((Action)childElement, view));
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			//add children actions' local conditions (2 blocks removed)
			//add structured activity group as nodes
			//		}
			//		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			//			ActivityGroup childElement = (ActivityGroup)it.next();
			//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getActivityActivityFigureParameterCompartment_7014SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getActivityActivityFigurePreconditionCompartment_7015SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPreconditions().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getActivityActivityFigurePostCondtionCompartment_7016SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPostconditions().iterator(); it.hasNext();) {
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
	 * (update at each gmf change) add children actions' local conditions
	 * 
	 * @generated NOT
	 */
	public static List<UMLNodeDescriptor> getActivityActivityFigureContentCompartment_7013SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Activity modelElement = (Activity)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
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
			if(visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadStructuralFeatureActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddStructuralFeatureValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DestroyObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AddVariableValueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadVariableActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == BroadcastSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ValueSpecificationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ReadSelfActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CentralBufferNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		//		for (Iterator<?> it = modelElement.getLocalPreconditions().iterator(); it
		//				.hasNext();) {
		//			Constraint childElement = (Constraint) it.next();
		//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
		//					childElement);
		//			if (visualID == DurationConstraintAsLocalPrecondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == TimeConstraintAsLocalPrecondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == ConstraintAsLocalPrecondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//		}
		//		for (Iterator<?> it = modelElement.getLocalPostconditions().iterator(); it
		//				.hasNext();) {
		//			Constraint childElement = (Constraint) it.next();
		//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
		//					childElement);
		//			if (visualID == DurationConstraintAsLocalPostcondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == TimeConstraintAsLocalPostcondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//			if (visualID == ConstraintAsLocalPostcondEditPart.VISUAL_ID) {
		//				result.add(new UMLNodeDescriptor(childElement, visualID));
		//				continue;
		//			}
		//		}
		for(Iterator<?> it = modelElement.getGroups().iterator(); it.hasNext();) {
			ActivityGroup childElement = (ActivityGroup)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConditionalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExpansionRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == LoopNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SequenceNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == StructuredActivityNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActivityPartitionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterruptibleActivityRegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedBehaviors().iterator(); it.hasNext();) {
			Behavior childElement = (Behavior)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedElements().iterator(); it.hasNext();) {
			Element childElement = (Element)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ShapeNamedElementEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
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
	public static List<UMLNodeDescriptor> getPackage_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
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
	public static List<UMLLinkDescriptor> getContainedLinks(View view) {
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
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getIntervalConstraint_3032ContainedLinks(view);
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getIntervalConstraint_3033ContainedLinks(view);
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getConstraint_3011ContainedLinks(view);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getConstraint_3012ContainedLinks(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_3038ContainedLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3039ContainedLinks(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_3040ContainedLinks(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_3041ContainedLinks(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_3078ContainedLinks(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_3042ContainedLinks(view);
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
			return getValuePin_3046ContainedLinks(view);
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getActionInputPin_3047ContainedLinks(view);
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getInputPin_3048ContainedLinks(view);
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3049ContainedLinks(view);
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3050ContainedLinks(view);
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3051ContainedLinks(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_3052ContainedLinks(view);
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
			return getActionInputPin_3053ContainedLinks(view);
		case ValuePinInSendSigActEditPart.VISUAL_ID:
			return getValuePin_3054ContainedLinks(view);
		case InputPinInSendSigActEditPart.VISUAL_ID:
			return getInputPin_3055ContainedLinks(view);
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3060ContainedLinks(view);
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3061ContainedLinks(view);
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3062ContainedLinks(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_3059ContainedLinks(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3063ContainedLinks(view);
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
			return getOutputPin_3064ContainedLinks(view);
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return getValueSpecificationAction_3076ContainedLinks(view);
		case OutputPinInValSpecActEditPart.VISUAL_ID:
			return getOutputPin_3077ContainedLinks(view);
		case ConditionalNodeEditPart.VISUAL_ID:
			return getConditionalNode_3069ContainedLinks(view);
		case ExpansionRegionEditPart.VISUAL_ID:
			return getExpansionRegion_3070ContainedLinks(view);
		case ExpansionNodeAsInEditPart.VISUAL_ID:
			return getExpansionNode_3074ContainedLinks(view);
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
			return getExpansionNode_3075ContainedLinks(view);
		case LoopNodeEditPart.VISUAL_ID:
			return getLoopNode_3071ContainedLinks(view);
		case OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID:
			return getOutputPin_3109ContainedLinks(view);
		case OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID:
			return getOutputPin_3110ContainedLinks(view);
		case OutputPinInLoopNodeAsResultEditPart.VISUAL_ID:
			return getOutputPin_3111ContainedLinks(view);
		case SequenceNodeEditPart.VISUAL_ID:
			return getSequenceNode_3073ContainedLinks(view);
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3065ContainedLinks(view);
		case InputPinInLoopNodeAsVariableEditPart.VISUAL_ID:
			return getInputPin_3105ContainedLinks(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_3067ContainedLinks(view);
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			return getInterruptibleActivityRegion_3068ContainedLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3080ContainedLinks(view);
		case ReadSelfActionEditPart.VISUAL_ID:
			return getReadSelfAction_3081ContainedLinks(view);
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
			return getOutputPin_3084ContainedLinks(view);
		case ActivityEditPartCN.VISUAL_ID:
			return getActivity_3083ContainedLinks(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3086ContainedLinks(view);
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3087ContainedLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_3085ContainedLinks(view);
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			return getReadStructuralFeatureAction_3088ContainedLinks(view);
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
			return getInputPin_3089ContainedLinks(view);
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
			return getOutputPin_3090ContainedLinks(view);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3091ContainedLinks(view);
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
			return getInputPin_3092ContainedLinks(view);
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
			return getInputPin_3093ContainedLinks(view);
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3094ContainedLinks(view);
		case DestroyObjectActionEditPart.VISUAL_ID:
			return getDestroyObjectAction_3095ContainedLinks(view);
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
			return getInputPin_3096ContainedLinks(view);
		case ReadVariableActionEditPart.VISUAL_ID:
			return getReadVariableAction_3097ContainedLinks(view);
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3098ContainedLinks(view);
		case AddVariableValueActionEditPart.VISUAL_ID:
			return getAddVariableValueAction_3099ContainedLinks(view);
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
			return getInputPin_3100ContainedLinks(view);
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
			return getInputPin_3101ContainedLinks(view);
		case BroadcastSignalActionEditPart.VISUAL_ID:
			return getBroadcastSignalAction_3102ContainedLinks(view);
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
			return getInputPin_3103ContainedLinks(view);
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getCentralBufferNode_3104ContainedLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3112ContainedLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4003ContainedLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4004ContainedLinks(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_4005ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIncomingLinks(View view) {
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
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getIntervalConstraint_3032IncomingLinks(view);
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getIntervalConstraint_3033IncomingLinks(view);
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getConstraint_3011IncomingLinks(view);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getConstraint_3012IncomingLinks(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_3038IncomingLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3039IncomingLinks(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_3040IncomingLinks(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_3041IncomingLinks(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_3078IncomingLinks(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_3042IncomingLinks(view);
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
			return getValuePin_3046IncomingLinks(view);
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getActionInputPin_3047IncomingLinks(view);
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getInputPin_3048IncomingLinks(view);
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3049IncomingLinks(view);
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3050IncomingLinks(view);
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3051IncomingLinks(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_3052IncomingLinks(view);
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
			return getActionInputPin_3053IncomingLinks(view);
		case ValuePinInSendSigActEditPart.VISUAL_ID:
			return getValuePin_3054IncomingLinks(view);
		case InputPinInSendSigActEditPart.VISUAL_ID:
			return getInputPin_3055IncomingLinks(view);
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3060IncomingLinks(view);
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3061IncomingLinks(view);
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3062IncomingLinks(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_3059IncomingLinks(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3063IncomingLinks(view);
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
			return getOutputPin_3064IncomingLinks(view);
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return getValueSpecificationAction_3076IncomingLinks(view);
		case OutputPinInValSpecActEditPart.VISUAL_ID:
			return getOutputPin_3077IncomingLinks(view);
		case ConditionalNodeEditPart.VISUAL_ID:
			return getConditionalNode_3069IncomingLinks(view);
		case ExpansionRegionEditPart.VISUAL_ID:
			return getExpansionRegion_3070IncomingLinks(view);
		case ExpansionNodeAsInEditPart.VISUAL_ID:
			return getExpansionNode_3074IncomingLinks(view);
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
			return getExpansionNode_3075IncomingLinks(view);
		case LoopNodeEditPart.VISUAL_ID:
			return getLoopNode_3071IncomingLinks(view);
		case OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID:
			return getOutputPin_3109IncomingLinks(view);
		case OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID:
			return getOutputPin_3110IncomingLinks(view);
		case OutputPinInLoopNodeAsResultEditPart.VISUAL_ID:
			return getOutputPin_3111IncomingLinks(view);
		case SequenceNodeEditPart.VISUAL_ID:
			return getSequenceNode_3073IncomingLinks(view);
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3065IncomingLinks(view);
		case InputPinInLoopNodeAsVariableEditPart.VISUAL_ID:
			return getInputPin_3105IncomingLinks(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_3067IncomingLinks(view);
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			return getInterruptibleActivityRegion_3068IncomingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3080IncomingLinks(view);
		case ReadSelfActionEditPart.VISUAL_ID:
			return getReadSelfAction_3081IncomingLinks(view);
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
			return getOutputPin_3084IncomingLinks(view);
		case ActivityEditPartCN.VISUAL_ID:
			return getActivity_3083IncomingLinks(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3086IncomingLinks(view);
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3087IncomingLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_3085IncomingLinks(view);
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			return getReadStructuralFeatureAction_3088IncomingLinks(view);
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
			return getInputPin_3089IncomingLinks(view);
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
			return getOutputPin_3090IncomingLinks(view);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3091IncomingLinks(view);
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
			return getInputPin_3092IncomingLinks(view);
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
			return getInputPin_3093IncomingLinks(view);
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3094IncomingLinks(view);
		case DestroyObjectActionEditPart.VISUAL_ID:
			return getDestroyObjectAction_3095IncomingLinks(view);
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
			return getInputPin_3096IncomingLinks(view);
		case ReadVariableActionEditPart.VISUAL_ID:
			return getReadVariableAction_3097IncomingLinks(view);
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3098IncomingLinks(view);
		case AddVariableValueActionEditPart.VISUAL_ID:
			return getAddVariableValueAction_3099IncomingLinks(view);
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
			return getInputPin_3100IncomingLinks(view);
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
			return getInputPin_3101IncomingLinks(view);
		case BroadcastSignalActionEditPart.VISUAL_ID:
			return getBroadcastSignalAction_3102IncomingLinks(view);
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
			return getInputPin_3103IncomingLinks(view);
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getCentralBufferNode_3104IncomingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3112IncomingLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4003IncomingLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4004IncomingLinks(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_4005IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutgoingLinks(View view) {
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
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getIntervalConstraint_3032OutgoingLinks(view);
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getIntervalConstraint_3033OutgoingLinks(view);
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return getConstraint_3011OutgoingLinks(view);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return getConstraint_3012OutgoingLinks(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_3038OutgoingLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3039OutgoingLinks(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_3040OutgoingLinks(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_3041OutgoingLinks(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_3078OutgoingLinks(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_3042OutgoingLinks(view);
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
			return getValuePin_3046OutgoingLinks(view);
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getActionInputPin_3047OutgoingLinks(view);
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return getInputPin_3048OutgoingLinks(view);
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3049OutgoingLinks(view);
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3050OutgoingLinks(view);
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3051OutgoingLinks(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_3052OutgoingLinks(view);
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
			return getActionInputPin_3053OutgoingLinks(view);
		case ValuePinInSendSigActEditPart.VISUAL_ID:
			return getValuePin_3054OutgoingLinks(view);
		case InputPinInSendSigActEditPart.VISUAL_ID:
			return getInputPin_3055OutgoingLinks(view);
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getValuePin_3060OutgoingLinks(view);
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getActionInputPin_3061OutgoingLinks(view);
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return getInputPin_3062OutgoingLinks(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_3059OutgoingLinks(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3063OutgoingLinks(view);
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
			return getOutputPin_3064OutgoingLinks(view);
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return getValueSpecificationAction_3076OutgoingLinks(view);
		case OutputPinInValSpecActEditPart.VISUAL_ID:
			return getOutputPin_3077OutgoingLinks(view);
		case ConditionalNodeEditPart.VISUAL_ID:
			return getConditionalNode_3069OutgoingLinks(view);
		case ExpansionRegionEditPart.VISUAL_ID:
			return getExpansionRegion_3070OutgoingLinks(view);
		case ExpansionNodeAsInEditPart.VISUAL_ID:
			return getExpansionNode_3074OutgoingLinks(view);
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
			return getExpansionNode_3075OutgoingLinks(view);
		case LoopNodeEditPart.VISUAL_ID:
			return getLoopNode_3071OutgoingLinks(view);
		case OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID:
			return getOutputPin_3109OutgoingLinks(view);
		case OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID:
			return getOutputPin_3110OutgoingLinks(view);
		case OutputPinInLoopNodeAsResultEditPart.VISUAL_ID:
			return getOutputPin_3111OutgoingLinks(view);
		case SequenceNodeEditPart.VISUAL_ID:
			return getSequenceNode_3073OutgoingLinks(view);
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3065OutgoingLinks(view);
		case InputPinInLoopNodeAsVariableEditPart.VISUAL_ID:
			return getInputPin_3105OutgoingLinks(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_3067OutgoingLinks(view);
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			return getInterruptibleActivityRegion_3068OutgoingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3080OutgoingLinks(view);
		case ReadSelfActionEditPart.VISUAL_ID:
			return getReadSelfAction_3081OutgoingLinks(view);
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
			return getOutputPin_3084OutgoingLinks(view);
		case ActivityEditPartCN.VISUAL_ID:
			return getActivity_3083OutgoingLinks(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3086OutgoingLinks(view);
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3087OutgoingLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_3085OutgoingLinks(view);
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			return getReadStructuralFeatureAction_3088OutgoingLinks(view);
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
			return getInputPin_3089OutgoingLinks(view);
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
			return getOutputPin_3090OutgoingLinks(view);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3091OutgoingLinks(view);
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
			return getInputPin_3092OutgoingLinks(view);
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
			return getInputPin_3093OutgoingLinks(view);
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3094OutgoingLinks(view);
		case DestroyObjectActionEditPart.VISUAL_ID:
			return getDestroyObjectAction_3095OutgoingLinks(view);
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
			return getInputPin_3096OutgoingLinks(view);
		case ReadVariableActionEditPart.VISUAL_ID:
			return getReadVariableAction_3097OutgoingLinks(view);
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
			return getOutputPin_3098OutgoingLinks(view);
		case AddVariableValueActionEditPart.VISUAL_ID:
			return getAddVariableValueAction_3099OutgoingLinks(view);
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
			return getInputPin_3100OutgoingLinks(view);
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
			return getInputPin_3101OutgoingLinks(view);
		case BroadcastSignalActionEditPart.VISUAL_ID:
			return getBroadcastSignalAction_3102OutgoingLinks(view);
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
			return getInputPin_3103OutgoingLinks(view);
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getCentralBufferNode_3104OutgoingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3112OutgoingLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4003OutgoingLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4004OutgoingLinks(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_4005OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_2001ContainedLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getParameter_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3002ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3003ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInitialNode_3004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityFinalNode_3005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFlowFinalNode_3006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueAction_3007ContainedLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallBehaviorAction_3008ContainedLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3018ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3019ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3020ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallOperationAction_3010ContainedLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3021ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3022ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3023ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3024ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3025ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3026ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3027ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3011ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3012ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDecisionNode_3038ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getMergeNode_3039ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getForkNode_3040ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getJoinNode_3041ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSendObjectAction_3042ContainedLinks(View view) {
		SendObjectAction modelElement = (SendObjectAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3046ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3047ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3048ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3049ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3050ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3051ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSendSignalAction_3052ContainedLinks(View view) {
		SendSignalAction modelElement = (SendSignalAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3053ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3054ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3055ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3060ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3061ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3062ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityParameterNode_3059ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAcceptEventAction_3063ContainedLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3064ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStructuredActivityNode_3065ContainedLinks(View view) {
		StructuredActivityNode modelElement = (StructuredActivityNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3105ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityPartition_3067ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterruptibleActivityRegion_3068ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3080ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadSelfAction_3081ContainedLinks(View view) {
		ReadSelfAction modelElement = (ReadSelfAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3084ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3083ContainedLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_3085ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCreateObjectAction_3086ContainedLinks(View view) {
		CreateObjectAction modelElement = (CreateObjectAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3087ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadStructuralFeatureAction_3088ContainedLinks(View view) {
		ReadStructuralFeatureAction modelElement = (ReadStructuralFeatureAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3089ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3090ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAddStructuralFeatureValueAction_3091ContainedLinks(View view) {
		AddStructuralFeatureValueAction modelElement = (AddStructuralFeatureValueAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3092ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3093ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3094ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDestroyObjectAction_3095ContainedLinks(View view) {
		DestroyObjectAction modelElement = (DestroyObjectAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3096ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadVariableAction_3097ContainedLinks(View view) {
		ReadVariableAction modelElement = (ReadVariableAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3098ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAddVariableValueAction_3099ContainedLinks(View view) {
		AddVariableValueAction modelElement = (AddVariableValueAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3100ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3101ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getBroadcastSignalAction_3102ContainedLinks(View view) {
		BroadcastSignalAction modelElement = (BroadcastSignalAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3103ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCentralBufferNode_3104ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3112ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValueSpecificationAction_3076ContainedLinks(View view) {
		ValueSpecificationAction modelElement = (ValueSpecificationAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3077ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataStoreNode_3078ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConditionalNode_3069ContainedLinks(View view) {
		ConditionalNode modelElement = (ConditionalNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionRegion_3070ContainedLinks(View view) {
		ExpansionRegion modelElement = (ExpansionRegion)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionNode_3074ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionNode_3075ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLoopNode_3071ContainedLinks(View view) {
		LoopNode modelElement = (LoopNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3109ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3110ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3111ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSequenceNode_3073ContainedLinks(View view) {
		SequenceNode modelElement = (SequenceNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3032ContainedLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3033ContainedLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3034ContainedLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3035ContainedLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3036ContainedLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3037ContainedLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getObjectFlow_4003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getControlFlow_4004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExceptionHandler_4005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_2001IncomingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getParameter_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInitialNode_3004IncomingLinks(View view) {
		InitialNode modelElement = (InitialNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityFinalNode_3005IncomingLinks(View view) {
		ActivityFinalNode modelElement = (ActivityFinalNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFlowFinalNode_3006IncomingLinks(View view) {
		FlowFinalNode modelElement = (FlowFinalNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueAction_3007IncomingLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3015IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3016IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3013IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3014IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallBehaviorAction_3008IncomingLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3017IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3018IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3019IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3020IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallOperationAction_3010IncomingLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3021IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3022IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3023IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3024IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3025IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3026IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3027IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3011IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3012IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDecisionNode_3038IncomingLinks(View view) {
		DecisionNode modelElement = (DecisionNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getMergeNode_3039IncomingLinks(View view) {
		MergeNode modelElement = (MergeNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getForkNode_3040IncomingLinks(View view) {
		ForkNode modelElement = (ForkNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getJoinNode_3041IncomingLinks(View view) {
		JoinNode modelElement = (JoinNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSendObjectAction_3042IncomingLinks(View view) {
		SendObjectAction modelElement = (SendObjectAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3046IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3047IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3048IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3049IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3050IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3051IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSendSignalAction_3052IncomingLinks(View view) {
		SendSignalAction modelElement = (SendSignalAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3053IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3054IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3055IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3060IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3061IncomingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3062IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityParameterNode_3059IncomingLinks(View view) {
		ActivityParameterNode modelElement = (ActivityParameterNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAcceptEventAction_3063IncomingLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3064IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStructuredActivityNode_3065IncomingLinks(View view) {
		StructuredActivityNode modelElement = (StructuredActivityNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3105IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityPartition_3067IncomingLinks(View view) {
		ActivityPartition modelElement = (ActivityPartition)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterruptibleActivityRegion_3068IncomingLinks(View view) {
		InterruptibleActivityRegion modelElement = (InterruptibleActivityRegion)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3080IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadSelfAction_3081IncomingLinks(View view) {
		ReadSelfAction modelElement = (ReadSelfAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3084IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3083IncomingLinks(View view) {
		Activity modelElement = (Activity)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_3085IncomingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCreateObjectAction_3086IncomingLinks(View view) {
		CreateObjectAction modelElement = (CreateObjectAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3087IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadStructuralFeatureAction_3088IncomingLinks(View view) {
		ReadStructuralFeatureAction modelElement = (ReadStructuralFeatureAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3089IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3090IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAddStructuralFeatureValueAction_3091IncomingLinks(View view) {
		AddStructuralFeatureValueAction modelElement = (AddStructuralFeatureValueAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3092IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3093IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3094IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDestroyObjectAction_3095IncomingLinks(View view) {
		DestroyObjectAction modelElement = (DestroyObjectAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3096IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadVariableAction_3097IncomingLinks(View view) {
		ReadVariableAction modelElement = (ReadVariableAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3098IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAddVariableValueAction_3099IncomingLinks(View view) {
		AddVariableValueAction modelElement = (AddVariableValueAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3100IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3101IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getBroadcastSignalAction_3102IncomingLinks(View view) {
		BroadcastSignalAction modelElement = (BroadcastSignalAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3103IncomingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCentralBufferNode_3104IncomingLinks(View view) {
		CentralBufferNode modelElement = (CentralBufferNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3112IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValueSpecificationAction_3076IncomingLinks(View view) {
		ValueSpecificationAction modelElement = (ValueSpecificationAction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3077IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataStoreNode_3078IncomingLinks(View view) {
		DataStoreNode modelElement = (DataStoreNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConditionalNode_3069IncomingLinks(View view) {
		ConditionalNode modelElement = (ConditionalNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionRegion_3070IncomingLinks(View view) {
		ExpansionRegion modelElement = (ExpansionRegion)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionNode_3074IncomingLinks(View view) {
		ExpansionNode modelElement = (ExpansionNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionNode_3075IncomingLinks(View view) {
		ExpansionNode modelElement = (ExpansionNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLoopNode_3071IncomingLinks(View view) {
		LoopNode modelElement = (LoopNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3109IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3110IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3111IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_4005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSequenceNode_3073IncomingLinks(View view) {
		SequenceNode modelElement = (SequenceNode)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3032IncomingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3033IncomingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3034IncomingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3035IncomingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3036IncomingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3037IncomingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getObjectFlow_4003IncomingLinks(View view) {
		ObjectFlow modelElement = (ObjectFlow)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getControlFlow_4004IncomingLinks(View view) {
		ControlFlow modelElement = (ControlFlow)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExceptionHandler_4005IncomingLinks(View view) {
		ExceptionHandler modelElement = (ExceptionHandler)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getParameter_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInitialNode_3004OutgoingLinks(View view) {
		InitialNode modelElement = (InitialNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityFinalNode_3005OutgoingLinks(View view) {
		ActivityFinalNode modelElement = (ActivityFinalNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getFlowFinalNode_3006OutgoingLinks(View view) {
		FlowFinalNode modelElement = (FlowFinalNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOpaqueAction_3007OutgoingLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3015OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3016OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3013OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3014OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallBehaviorAction_3008OutgoingLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3017OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3018OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3019OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3020OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCallOperationAction_3010OutgoingLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3021OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3022OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3023OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3024OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3025OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3026OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3027OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3011OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3012OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDecisionNode_3038OutgoingLinks(View view) {
		DecisionNode modelElement = (DecisionNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getMergeNode_3039OutgoingLinks(View view) {
		MergeNode modelElement = (MergeNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getForkNode_3040OutgoingLinks(View view) {
		ForkNode modelElement = (ForkNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getJoinNode_3041OutgoingLinks(View view) {
		JoinNode modelElement = (JoinNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSendObjectAction_3042OutgoingLinks(View view) {
		SendObjectAction modelElement = (SendObjectAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3046OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3047OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3048OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3049OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3050OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3051OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSendSignalAction_3052OutgoingLinks(View view) {
		SendSignalAction modelElement = (SendSignalAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3053OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3054OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3055OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValuePin_3060OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActionInputPin_3061OutgoingLinks(View view) {
		ActionInputPin modelElement = (ActionInputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3062OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityParameterNode_3059OutgoingLinks(View view) {
		ActivityParameterNode modelElement = (ActivityParameterNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAcceptEventAction_3063OutgoingLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3064OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getStructuredActivityNode_3065OutgoingLinks(View view) {
		StructuredActivityNode modelElement = (StructuredActivityNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3105OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivityPartition_3067OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterruptibleActivityRegion_3068OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3080OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadSelfAction_3081OutgoingLinks(View view) {
		ReadSelfAction modelElement = (ReadSelfAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3084OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActivity_3083OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_3085OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCreateObjectAction_3086OutgoingLinks(View view) {
		CreateObjectAction modelElement = (CreateObjectAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3087OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadStructuralFeatureAction_3088OutgoingLinks(View view) {
		ReadStructuralFeatureAction modelElement = (ReadStructuralFeatureAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3089OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3090OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAddStructuralFeatureValueAction_3091OutgoingLinks(View view) {
		AddStructuralFeatureValueAction modelElement = (AddStructuralFeatureValueAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3092OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3093OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3094OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDestroyObjectAction_3095OutgoingLinks(View view) {
		DestroyObjectAction modelElement = (DestroyObjectAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3096OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReadVariableAction_3097OutgoingLinks(View view) {
		ReadVariableAction modelElement = (ReadVariableAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3098OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAddVariableValueAction_3099OutgoingLinks(View view) {
		AddVariableValueAction modelElement = (AddVariableValueAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3100OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3101OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getBroadcastSignalAction_3102OutgoingLinks(View view) {
		BroadcastSignalAction modelElement = (BroadcastSignalAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInputPin_3103OutgoingLinks(View view) {
		InputPin modelElement = (InputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getCentralBufferNode_3104OutgoingLinks(View view) {
		CentralBufferNode modelElement = (CentralBufferNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3112OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getValueSpecificationAction_3076OutgoingLinks(View view) {
		ValueSpecificationAction modelElement = (ValueSpecificationAction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3077OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataStoreNode_3078OutgoingLinks(View view) {
		DataStoreNode modelElement = (DataStoreNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConditionalNode_3069OutgoingLinks(View view) {
		ConditionalNode modelElement = (ConditionalNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionRegion_3070OutgoingLinks(View view) {
		ExpansionRegion modelElement = (ExpansionRegion)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionNode_3074OutgoingLinks(View view) {
		ExpansionNode modelElement = (ExpansionNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExpansionNode_3075OutgoingLinks(View view) {
		ExpansionNode modelElement = (ExpansionNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getLoopNode_3071OutgoingLinks(View view) {
		LoopNode modelElement = (LoopNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3109OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3110OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutputPin_3111OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSequenceNode_3073OutgoingLinks(View view) {
		SequenceNode modelElement = (SequenceNode)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3032OutgoingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIntervalConstraint_3033OutgoingLinks(View view) {
		IntervalConstraint modelElement = (IntervalConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3034OutgoingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationConstraint_3035OutgoingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3036OutgoingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeConstraint_3037OutgoingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getObjectFlow_4003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getControlFlow_4004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExceptionHandler_4005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_ObjectFlow_4003(Activity container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_ControlFlow_4004(Activity container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_ExceptionHandler_4005(ExecutableNode container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getHandlers().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ExceptionHandler) {
				continue;
			}
			ExceptionHandler link = (ExceptionHandler)linkObject;
			if(ExceptionHandlerEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ObjectNode dst = link.getExceptionInput();
			ExecutableNode src = link.getProtectedNode();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ExceptionHandler_4005, ExceptionHandlerEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Action_LocalPrecondition_4001(Constraint target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getAction_LocalPrecondition()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ActionLocalPrecondition_4001, ActionLocalPreconditionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Action_LocalPostcondition_4002(Constraint target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getAction_LocalPostcondition()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ActionLocalPostcondition_4002, ActionLocalPostconditionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_ObjectFlow_4003(ActivityNode target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
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
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_ControlFlow_4004(ActivityNode target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
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
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_ExceptionHandler_4005(ObjectNode target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getExceptionHandler_ExceptionInput() || false == setting.getEObject() instanceof ExceptionHandler) {
				continue;
			}
			ExceptionHandler link = (ExceptionHandler)setting.getEObject();
			if(ExceptionHandlerEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ExecutableNode src = link.getProtectedNode();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.ExceptionHandler_4005, ExceptionHandlerEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4006, CommentLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4007, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Action_LocalPrecondition_4001(Action source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getLocalPreconditions().iterator(); destinations.hasNext();) {
			Constraint destination = (Constraint)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ActionLocalPrecondition_4001, ActionLocalPreconditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Action_LocalPostcondition_4002(Action source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getLocalPostconditions().iterator(); destinations.hasNext();) {
			Constraint destination = (Constraint)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ActionLocalPostcondition_4002, ActionLocalPostconditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_ObjectFlow_4003(ActivityNode source) {
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
			return Collections.emptyList();
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
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_ControlFlow_4004(ActivityNode source) {
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
			return Collections.emptyList();
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

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_ExceptionHandler_4005(ExecutableNode source) {
		ExecutableNode container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof ExecutableNode) {
				container = (ExecutableNode)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getHandlers().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ExceptionHandler) {
				continue;
			}
			ExceptionHandler link = (ExceptionHandler)linkObject;
			if(ExceptionHandlerEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ObjectNode dst = link.getExceptionInput();
			ExecutableNode src = link.getProtectedNode();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ExceptionHandler_4005, ExceptionHandlerEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4006(Comment source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4006, CommentLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4007(Constraint source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4007, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {

		/**
		 * @generated
		 */
		public List<UMLNodeDescriptor> getSemanticChildren(View view) {
			return UMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getContainedLinks(View view) {
			return UMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getIncomingLinks(View view) {
			return UMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getOutgoingLinks(View view) {
			return UMLDiagramUpdater.getOutgoingLinks(view);
		}
	};
}
