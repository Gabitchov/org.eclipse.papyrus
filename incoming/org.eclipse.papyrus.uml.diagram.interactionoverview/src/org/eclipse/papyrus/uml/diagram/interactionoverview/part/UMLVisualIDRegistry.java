/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPartCN;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConstraintInActivityAsPostcondEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConstraintInActivityAsPrecondEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionRegionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInLoopNodeAsVariableEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InterruptibleActivityRegionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInLoopNodeAsBodyOutputEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInLoopNodeAsLoopVariableEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInLoopNodeAsResultEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SequenceNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CallBehaviorActionAsInteractionEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.InteractionOverviewDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLVisualIDRegistry extends org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry {

	public UMLVisualIDRegistry() {
		super();
	}

	public static int customGetNodeVisualID(final View containerView, final EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		final String containerModelID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!InteractionOverviewDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(InteractionOverviewDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = InteractionOverviewDiagramEditPart.VISUAL_ID;
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
		case ActivityEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivityParameterNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityParameterNodeEditPart.VISUAL_ID;
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
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass()) && isInteractionUse_3008(containerView, (CallBehaviorAction)domainElement)) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass()) && isInteraction_5000(containerView, (CallBehaviorAction)domainElement)) {
				return CallBehaviorActionAsInteractionEditPart.VISUAL_ID;
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
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())) {
				return ActivityEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	private static boolean isInteractionUse_3008(final View containerView, final CallBehaviorAction domainElement) {

		return CallBehaviorUtil.getCallBehaviorType(domainElement) == CallBehaviorUtil.CallBehaviorActionType.use;
	}

	/**
	 * @generated
	 */

	private static boolean isInteraction_5000(final View containerView, final CallBehaviorAction domainElement) {

		return CallBehaviorUtil.getCallBehaviorType(domainElement) == CallBehaviorUtil.CallBehaviorActionType.snapshot;
	}
}
