/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop) - can create ActivityParamenterNodes by clicking in
 *  	the ActivitySubvertices compartment
 */
package org.eclipse.papyrus.diagram.activity.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventAction2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartition2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionActivityPartitionCompartment2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionActivityPartitionCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivitySubverticesEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin5EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin6EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName5EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinName6EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueAction2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinName4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinName2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ZigZagLabelEditPart;
import org.eclipse.papyrus.diagram.activity.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.activity.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * This registry is used to determine which type of visual object should be created for the corresponding Diagram, Node, ChildNode or Link represented by a domain model object.
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
	private static UMLAbstractExpression AcceptEventAction_2007_Constraint;

	/**
	 * @generated
	 */
	private static UMLAbstractExpression AcceptEventAction_2033_Constraint;

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
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
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
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
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}

		if (UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass()) && isDiagram((Activity) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}

		return -1;
	}

	/**
	 * Modified to check ValuePin before InputPin in OpaqueAction.
	 * 
	 * @generated NOT
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID) && !"UMLActivity".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ActivityEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivityParameterNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityParameterNodeEditPart.VISUAL_ID;
			}
			break;
		case SendObjectActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())) {
				return ValuePinEditPart.VISUAL_ID;
			}
			break;
		case SendSignalActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin3EditPart.VISUAL_ID;
			}
			break;
		case AcceptEventActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinEditPart.VISUAL_ID;
			}
			break;
		case OpaqueActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin2EditPart.VISUAL_ID;
			}
			// fjcano :: modified to check ValuePin before InputPint.
			if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())) {
				return ValuePin2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin4EditPart.VISUAL_ID;
			}
			break;
		case CreateObjectActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin3EditPart.VISUAL_ID;
			}
			break;
		case CallBehaviorActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin5EditPart.VISUAL_ID;
			}
			break;
		case CallOperationActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin6EditPart.VISUAL_ID;
			}
			break;
		case OpaqueAction2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())) {
				return ValuePin2EditPart.VISUAL_ID;
			}
			break;
		case AcceptEventAction2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinEditPart.VISUAL_ID;
			}
			break;
		case ActivitySubverticesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartitionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2007((AcceptEventAction) domainElement)) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			break;
		case ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartition2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2033((AcceptEventAction) domainElement)) {
				return AcceptEventAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			break;
		case ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartition2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2033((AcceptEventAction) domainElement)) {
				return AcceptEventAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())) {
				return ActivityEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID) && !"UMLActivity".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ActivityEditPart.VISUAL_ID:
			if (ActivityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivitySubverticesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivityParameterNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if (CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendObjectActionEditPart.VISUAL_ID:
			if (SendObjectActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendObjectActionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPin2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValuePinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPinEditPart.VISUAL_ID:
			if (InputPinNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPin2EditPart.VISUAL_ID:
			if (InputPinName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePinEditPart.VISUAL_ID:
			if (ValuePinNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendSignalActionEditPart.VISUAL_ID:
			if (SendSignalActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendSignalActionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPin3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPin3EditPart.VISUAL_ID:
			if (InputPinName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AcceptEventActionEditPart.VISUAL_ID:
			if (AcceptEventActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcceptEventActionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPinEditPart.VISUAL_ID:
			if (OutputPinNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityFinalNodeEditPart.VISUAL_ID:
			if (ActivityFinalNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DecisionNodeEditPart.VISUAL_ID:
			if (DecisionNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MergeNodeEditPart.VISUAL_ID:
			if (MergeNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InitialNodeEditPart.VISUAL_ID:
			if (InitialNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataStoreNodeEditPart.VISUAL_ID:
			if (DataStoreNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueActionEditPart.VISUAL_ID:
			if (OpaqueActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OpaqueActionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPin2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPin4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValuePin2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPin2EditPart.VISUAL_ID:
			if (OutputPinName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPin4EditPart.VISUAL_ID:
			if (InputPinName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValuePin2EditPart.VISUAL_ID:
			if (ValuePinName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FlowFinalNodeEditPart.VISUAL_ID:
			if (FlowFinalNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PinEditPart.VISUAL_ID:
			if (PinNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CreateObjectActionEditPart.VISUAL_ID:
			if (CreateObjectActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CreateObjectActionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPin3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPin3EditPart.VISUAL_ID:
			if (OutputPinName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallBehaviorActionEditPart.VISUAL_ID:
			if (CallBehaviorActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallBehaviorActionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPin4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPin5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPin4EditPart.VISUAL_ID:
			if (OutputPinName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPin5EditPart.VISUAL_ID:
			if (InputPinName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallOperationActionEditPart.VISUAL_ID:
			if (CallOperationActionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallOperationActionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPin4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPin5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPin6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPin6EditPart.VISUAL_ID:
			if (InputPinName6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityParameterNodeEditPart.VISUAL_ID:
			if (ActivityParameterNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityPartitionEditPart.VISUAL_ID:
			if (ActivityPartitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityPartition2EditPart.VISUAL_ID:
			if (ActivityPartitionName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueAction2EditPart.VISUAL_ID:
			if (OpaqueActionName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OpaqueActionName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPin2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPin4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValuePin2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AcceptEventAction2EditPart.VISUAL_ID:
			if (AcceptEventActionName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcceptEventActionName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivitySubverticesEditPart.VISUAL_ID:
			if (SendObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcceptEventActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivityFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DecisionNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MergeNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InitialNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OpaqueActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FlowFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (JoinNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallBehaviorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallOperationActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivityPartitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID:
			if (ActivityPartition2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OpaqueAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcceptEventAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivityFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DecisionNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MergeNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InitialNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FlowFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (JoinNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallBehaviorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallOperationActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID:
			if (ActivityPartition2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OpaqueAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendSignalActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AcceptEventAction2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivityFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DecisionNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MergeNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InitialNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FlowFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForkNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (JoinNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallBehaviorActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallOperationActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (ActivityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ControlFlowEditPart.VISUAL_ID:
			if (ControlFlowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ObjectFlowEditPart.VISUAL_ID:
			if (ObjectFlowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExceptionHandlerEditPart.VISUAL_ID:
			if (ZigZagLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	// /**
	// * @generated NOT
	// */
	// public static int getNodeVisualID(View containerView, EObject
	// domainElement) {
	// if (domainElement == null) {
	// return -1;
	// }
	// String containerModelID =
	// org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry
	// .getModelID(containerView);
	// if (!PackageEditPart.MODEL_ID.equals(containerModelID)
	//				&& !"UMLActivity".equals(containerModelID)) { //$NON-NLS-1$
	// return -1;
	// }
	// int containerVisualID;
	// if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
	// containerVisualID =
	// org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry
	// .getVisualID(containerView);
	// } else {
	// if (containerView instanceof Diagram) {
	// containerVisualID = PackageEditPart.VISUAL_ID;
	// } else {
	// return -1;
	// }
	// }
	// switch (containerVisualID) {
	// case ActivityEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getActivityParameterNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ActivityParameterNodeEditPart.VISUAL_ID;
	// }
	// break;
	// case SendObjectActionEditPart.VISUAL_ID:
	// //compare if it's a ValuePin before than a InputPin
	// if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ValuePinEditPart.VISUAL_ID;
	// }
	// //end
	// if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// if (domainElement instanceof InputPin
	// && domainElement.eContainer() instanceof SendObjectAction
	// && ((SendObjectAction) domainElement.eContainer())
	// .getTarget() == domainElement)
	// return InputPinEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// if (domainElement instanceof InputPin
	// && domainElement.eContainer() instanceof SendObjectAction
	// && ((SendObjectAction) domainElement.eContainer())
	// .getRequest() == domainElement)
	// return InputPin2EditPart.VISUAL_ID;
	// }
	// break;
	// case SendSignalActionEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return InputPin3EditPart.VISUAL_ID;
	// }
	// break;
	// case AcceptEventActionEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OutputPinEditPart.VISUAL_ID;
	// }
	// break;
	// case OpaqueActionEditPart.VISUAL_ID:
	// //compare if it's a ValuePin before than a InputPin
	// if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ValuePin2EditPart.VISUAL_ID;
	// }
	// //end
	// if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return InputPin4EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OutputPin2EditPart.VISUAL_ID;
	// }
	// break;
	// case CreateObjectActionEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OutputPin3EditPart.VISUAL_ID;
	// }
	// break;
	// case CallBehaviorActionEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OutputPin4EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return InputPin5EditPart.VISUAL_ID;
	// }
	// break;
	// case CallOperationActionEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OutputPin4EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// if (domainElement instanceof InputPin
	// && domainElement.eContainer() instanceof CallOperationAction
	// && ((CallOperationAction) domainElement.eContainer())
	// .getArguments().contains(domainElement))
	// return InputPin5EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// if (domainElement instanceof InputPin
	// && domainElement.eContainer() instanceof CallOperationAction
	// && ((CallOperationAction) domainElement.eContainer())
	// .getTarget() == domainElement)
	// return InputPin6EditPart.VISUAL_ID;
	// }
	// break;
	// case OpaqueAction2EditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OutputPin2EditPart.VISUAL_ID;
	// }
	// //compare if it's a ValuePin before than a InputPin
	// if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ValuePin2EditPart.VISUAL_ID;
	// }
	// //end
	// if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return InputPin4EditPart.VISUAL_ID;
	// }
	// break;
	// case AcceptEventAction2EditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OutputPinEditPart.VISUAL_ID;
	// }
	// break;
	// case ActivitySubverticesEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return SendObjectActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return SendSignalActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(
	// domainElement.eClass())
	// && evaluate(AcceptEventAction_2007_Constraint,
	// domainElement)) {
	// return AcceptEventActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ActivityFinalNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return DecisionNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return MergeNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return InitialNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return DataStoreNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OpaqueActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return FlowFinalNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ForkNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return JoinNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return PinEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CreateObjectActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CallBehaviorActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CallOperationActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ActivityPartitionEditPart.VISUAL_ID;
	// }
	// break;
	// case ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ActivityPartition2EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OpaqueAction2EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return SendObjectActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return SendSignalActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(
	// domainElement.eClass())
	// && evaluate(AcceptEventAction_2033_Constraint,
	// domainElement)) {
	// return AcceptEventAction2EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ActivityFinalNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return DecisionNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return MergeNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return InitialNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return DataStoreNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return FlowFinalNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ForkNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return JoinNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return PinEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CreateObjectActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CallBehaviorActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CallOperationActionEditPart.VISUAL_ID;
	// }
	// break;
	// case ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ActivityPartition2EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return OpaqueAction2EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return SendObjectActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return SendSignalActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(
	// domainElement.eClass())
	// && evaluate(AcceptEventAction_2033_Constraint,
	// domainElement)) {
	// return AcceptEventAction2EditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ActivityFinalNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return DecisionNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return MergeNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return InitialNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return DataStoreNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return FlowFinalNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ForkNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(
	// domainElement.eClass())) {
	// return JoinNodeEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(
	// domainElement.eClass())) {
	// return PinEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CreateObjectActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CallBehaviorActionEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CallOperationActionEditPart.VISUAL_ID;
	// }
	// break;
	// case PackageEditPart.VISUAL_ID:
	// if (UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(
	// domainElement.eClass())) {
	// return ActivityEditPart.VISUAL_ID;
	// }
	// if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(
	// domainElement.eClass())) {
	// return CommentEditPart.VISUAL_ID;
	// }
	// break;
	// }
	// return -1;
	// }

	// /**
	// * @generated not
	// */
	// public static boolean canCreateNode(View containerView, int nodeVisualID)
	// {
	// String containerModelID =
	// org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry
	// .getModelID(containerView);
	// if (!PackageEditPart.MODEL_ID.equals(containerModelID)
	//				&& !"UMLActivity".equals(containerModelID)) { //$NON-NLS-1$
	// return false;
	// }
	// int containerVisualID;
	// if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
	// containerVisualID =
	// org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry
	// .getVisualID(containerView);
	// } else {
	// if (containerView instanceof Diagram) {
	// containerVisualID = PackageEditPart.VISUAL_ID;
	// } else {
	// return false;
	// }
	// }
	// switch (containerVisualID) {
	// case CommentEditPart.VISUAL_ID:
	// if (CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ActivityEditPart.VISUAL_ID:
	// if (ActivityNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ActivitySubverticesEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ActivityParameterNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case SendObjectActionEditPart.VISUAL_ID:
	// if (SendObjectActionNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (SendObjectActionName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InputPinEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InputPin2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ValuePinEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case InputPinEditPart.VISUAL_ID:
	// if (InputPinNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case InputPin2EditPart.VISUAL_ID:
	// if (InputPinName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ValuePinEditPart.VISUAL_ID:
	// if (ValuePinNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case SendSignalActionEditPart.VISUAL_ID:
	// if (SendSignalActionNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (SendSignalActionName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InputPin3EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case InputPin3EditPart.VISUAL_ID:
	// if (InputPinName3EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case AcceptEventActionEditPart.VISUAL_ID:
	// if (AcceptEventActionNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (AcceptEventActionName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OutputPinEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case OutputPinEditPart.VISUAL_ID:
	// if (OutputPinNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ActivityFinalNodeEditPart.VISUAL_ID:
	// if (ActivityFinalNodeNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case DecisionNodeEditPart.VISUAL_ID:
	// if (DecisionNodeNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case MergeNodeEditPart.VISUAL_ID:
	// if (MergeNodeNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case InitialNodeEditPart.VISUAL_ID:
	// if (InitialNodeNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case DataStoreNodeEditPart.VISUAL_ID:
	// if (DataStoreNodeNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case OpaqueActionEditPart.VISUAL_ID:
	// if (OpaqueActionNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OpaqueActionName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OutputPin2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InputPin4EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ValuePin2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case OutputPin2EditPart.VISUAL_ID:
	// if (OutputPinName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case InputPin4EditPart.VISUAL_ID:
	// if (InputPinName4EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ValuePin2EditPart.VISUAL_ID:
	// if (ValuePinName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case FlowFinalNodeEditPart.VISUAL_ID:
	// if (FlowFinalNodeNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case PinEditPart.VISUAL_ID:
	// if (PinNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case CreateObjectActionEditPart.VISUAL_ID:
	// if (CreateObjectActionNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CreateObjectActionName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OutputPin3EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case OutputPin3EditPart.VISUAL_ID:
	// if (OutputPinName3EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case CallBehaviorActionEditPart.VISUAL_ID:
	// if (CallBehaviorActionNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CallBehaviorActionName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OutputPin4EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InputPin5EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case OutputPin4EditPart.VISUAL_ID:
	// if (OutputPinName4EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case InputPin5EditPart.VISUAL_ID:
	// if (InputPinName5EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case CallOperationActionEditPart.VISUAL_ID:
	// if (CallOperationActionNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CallOperationActionName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OutputPin4EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InputPin5EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InputPin6EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case InputPin6EditPart.VISUAL_ID:
	// if (InputPinName6EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ActivityParameterNodeEditPart.VISUAL_ID:
	// if (ActivityParameterNodeNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ActivityPartitionEditPart.VISUAL_ID:
	// if (ActivityPartitionNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID ==
	// nodeVisualID) {
	// return true;
	// }
	// break;
	// case ActivityPartition2EditPart.VISUAL_ID:
	// if (ActivityPartitionName2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID ==
	// nodeVisualID) {
	// return true;
	// }
	// break;
	// case OpaqueAction2EditPart.VISUAL_ID:
	// if (OpaqueActionName3EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OpaqueActionName4EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OutputPin2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InputPin4EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ValuePin2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case AcceptEventAction2EditPart.VISUAL_ID:
	// if (AcceptEventActionName3EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (AcceptEventActionName4EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OutputPinEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ActivitySubverticesEditPart.VISUAL_ID:
	// if (ActivityParameterNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (SendObjectActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (SendSignalActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (AcceptEventActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ActivityFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (DecisionNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (MergeNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InitialNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OpaqueActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (FlowFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ForkNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (JoinNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (PinEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CallBehaviorActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CallOperationActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ActivityPartitionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID:
	// if (ActivityPartition2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OpaqueAction2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (SendObjectActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (SendSignalActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (AcceptEventAction2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ActivityFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (DecisionNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (MergeNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InitialNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (FlowFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ForkNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (JoinNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (PinEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CallBehaviorActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CallOperationActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID:
	// if (ActivityPartition2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (OpaqueAction2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (SendObjectActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (SendSignalActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (AcceptEventAction2EditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ActivityFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (DecisionNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (MergeNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (InitialNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (DataStoreNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (FlowFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (ForkNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (JoinNodeEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (PinEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CreateObjectActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CallBehaviorActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CallOperationActionEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case PackageEditPart.VISUAL_ID:
	// if (ActivityEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// if (CommentEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ControlFlowEditPart.VISUAL_ID:
	// if (ControlFlowNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ObjectFlowEditPart.VISUAL_ID:
	// if (ObjectFlowNameEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// case ExceptionHandlerEditPart.VISUAL_ID:
	// if (ZigZagLabelEditPart.VISUAL_ID == nodeVisualID) {
	// return true;
	// }
	// break;
	// }
	// return false;
	// }

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getControlFlow().isSuperTypeOf(domainElement.eClass())) {
			return ControlFlowEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getObjectFlow().isSuperTypeOf(domainElement.eClass())) {
			return ObjectFlowEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getExceptionHandler().isSuperTypeOf(domainElement.eClass())) {
			return ExceptionHandlerEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isDiagram(Activity element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isAcceptEventAction_2007(AcceptEventAction domainElement) {
		if (AcceptEventAction_2007_Constraint == null) { // lazy initialization
			AcceptEventAction_2007_Constraint = UMLOCLFactory.getExpression(
					"self.trigger->isEmpty() or (not self.trigger->forAll(tr | tr.event.oclIsKindOf(uml::TimeEvent)))", UMLPackage.eINSTANCE.getAcceptEventAction()); //$NON-NLS-1$
		}
		Object result = AcceptEventAction_2007_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isAcceptEventAction_2033(AcceptEventAction domainElement) {
		if (AcceptEventAction_2033_Constraint == null) { // lazy initialization
			AcceptEventAction_2033_Constraint = UMLOCLFactory.getExpression(
					"self.trigger->isEmpty() or (not self.trigger->forAll(tr | tr.event.oclIsKindOf(uml::TimeEvent)))", UMLPackage.eINSTANCE.getAcceptEventAction()); //$NON-NLS-1$
		}
		Object result = AcceptEventAction_2033_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	protected static boolean hasViewChild(View containerView, EObject domainElement, int visualId) {
		if (domainElement == null) {
			return false;
		}
		for (Object next : containerView.getChildren()) {
			View nextView = (View) next;
			if (domainElement.equals(nextView.getElement()) && getType(visualId).equals(nextView.getType())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getChildDescriptorVisualID(UMLNodeDescriptor container, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		switch (container.getVisualID()) {
		case ActivityEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivityParameterNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityParameterNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2007((AcceptEventAction) domainElement)) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartitionEditPart.VISUAL_ID;
			}
			break;
		case SendObjectActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())) {
				return ValuePinEditPart.VISUAL_ID;
			}
			break;
		case SendSignalActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin3EditPart.VISUAL_ID;
			}
			break;
		case AcceptEventActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinEditPart.VISUAL_ID;
			}
			break;
		case OpaqueActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())) {
				return ValuePin2EditPart.VISUAL_ID;
			}
			break;
		case CreateObjectActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin3EditPart.VISUAL_ID;
			}
			break;
		case CallBehaviorActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin5EditPart.VISUAL_ID;
			}
			break;
		case CallOperationActionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin6EditPart.VISUAL_ID;
			}
			break;
		case ActivityPartitionEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartition2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2033((AcceptEventAction) domainElement)) {
				return AcceptEventAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			break;
		case ActivityPartition2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartition2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2033((AcceptEventAction) domainElement)) {
				return AcceptEventAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			break;
		case OpaqueAction2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPin2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInputPin().isSuperTypeOf(domainElement.eClass())) {
				return InputPin4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getValuePin().isSuperTypeOf(domainElement.eClass())) {
				return ValuePin2EditPart.VISUAL_ID;
			}
			break;
		case AcceptEventAction2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getOutputPin().isSuperTypeOf(domainElement.eClass())) {
				return OutputPinEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())) {
				return ActivityEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
				return CommentEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2007((AcceptEventAction) domainElement)) {
				return AcceptEventActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartitionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartition2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2033((AcceptEventAction) domainElement)) {
				return AcceptEventAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityPartition().isSuperTypeOf(domainElement.eClass())) {
				return ActivityPartition2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getOpaqueAction().isSuperTypeOf(domainElement.eClass())) {
				return OpaqueAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return SendObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getSendSignalAction().isSuperTypeOf(domainElement.eClass())) {
				return SendSignalActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getAcceptEventAction().isSuperTypeOf(domainElement.eClass()) && isAcceptEventAction_2033((AcceptEventAction) domainElement)) {
				return AcceptEventAction2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDecisionNode().isSuperTypeOf(domainElement.eClass())) {
				return DecisionNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getDataStoreNode().isSuperTypeOf(domainElement.eClass())) {
				return DataStoreNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getForkNode().isSuperTypeOf(domainElement.eClass())) {
				return ForkNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getJoinNode().isSuperTypeOf(domainElement.eClass())) {
				return JoinNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPin().isSuperTypeOf(domainElement.eClass())) {
				return PinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCreateObjectAction().isSuperTypeOf(domainElement.eClass())) {
				return CreateObjectActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallBehaviorAction().isSuperTypeOf(domainElement.eClass())) {
				return CallBehaviorActionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getCallOperationAction().isSuperTypeOf(domainElement.eClass())) {
				return CallOperationActionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	private static ViewInfo diagramViewInfo = null;

	/**
	 * @generated
	 */
	public static ViewInfo getDiagramViewInfo() {
		if (diagramViewInfo == null) {
			diagramViewInfo = getPackage_79ViewInfo();
		}
		return diagramViewInfo;
	}

	/**
	 * @generated
	 */
	protected static ViewInfo getPackage_79ViewInfo() {
		ViewInfo root = new BaseViewInfo(79, ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		ViewInfo labelInfo = null;

		viewInfo = new BaseViewInfo(1001, ViewInfo.Node, "Activity");
		root.addNode(79, viewInfo);

		viewInfo = new BaseViewInfo(2034, ViewInfo.Node, "Comment");
		root.addNode(79, viewInfo);

		viewInfo = new BaseViewInfo(3001, ViewInfo.Edge, "ControlFlow");
		root.addNode(79, viewInfo);

		labelInfo = new BaseViewInfo(4043, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(3002, ViewInfo.Edge, "ObjectFlow");
		root.addNode(79, viewInfo);

		labelInfo = new BaseViewInfo(4044, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(3003, ViewInfo.Edge, "");
		root.addNode(79, viewInfo);

		viewInfo = new BaseViewInfo(3004, ViewInfo.Edge, "ExceptionHandler");
		root.addNode(79, viewInfo);

		labelInfo = new BaseViewInfo(4045, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(3005, ViewInfo.Edge, "");
		root.addNode(79, viewInfo);

		viewInfo = new BaseViewInfo(3006, ViewInfo.Edge, "");
		root.addNode(79, viewInfo);

		viewInfo = new BaseViewInfo(2001, ViewInfo.Node, "SendObjectAction");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2002, ViewInfo.Node, "InputPin");

		root.addNode(2001, viewInfo);

		viewInfo = new BaseViewInfo(2003, ViewInfo.Node, "InputPin");

		root.addNode(2001, viewInfo);

		viewInfo = new BaseViewInfo(2004, ViewInfo.Node, "ValuePin");

		root.addNode(2001, viewInfo);

		viewInfo = new BaseViewInfo(2005, ViewInfo.Node, "SendSignalAction");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2006, ViewInfo.Node, "InputPin");

		root.addNode(2005, viewInfo);

		viewInfo = new BaseViewInfo(2007, ViewInfo.Node, "AcceptEventAction");

		root.addNode(1001, viewInfo);

		viewInfo = new BaseViewInfo(2008, ViewInfo.Node, "OutputPin");

		root.addNode(2007, viewInfo);

		root.addNode(2033, viewInfo);

		viewInfo = new BaseViewInfo(2009, ViewInfo.Node, "ActivityFinalNode");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2010, ViewInfo.Node, "DecisionNode");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2011, ViewInfo.Node, "MergeNode");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2012, ViewInfo.Node, "InitialNode");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2013, ViewInfo.Node, "DataStoreNode");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2014, ViewInfo.Node, "OpaqueAction");

		root.addNode(1001, viewInfo);

		viewInfo = new BaseViewInfo(2015, ViewInfo.Node, "OutputPin");

		root.addNode(2014, viewInfo);

		root.addNode(2032, viewInfo);

		viewInfo = new BaseViewInfo(2016, ViewInfo.Node, "InputPin");

		root.addNode(2014, viewInfo);

		root.addNode(2032, viewInfo);

		viewInfo = new BaseViewInfo(2017, ViewInfo.Node, "ValuePin");

		root.addNode(2014, viewInfo);

		root.addNode(2032, viewInfo);

		viewInfo = new BaseViewInfo(2018, ViewInfo.Node, "FlowFinalNode");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2019, ViewInfo.Node, "ForkNode");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2020, ViewInfo.Node, "JoinNode");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2021, ViewInfo.Node, "Pin");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2022, ViewInfo.Node, "CreateObjectAction");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2023, ViewInfo.Node, "OutputPin");

		root.addNode(2022, viewInfo);

		viewInfo = new BaseViewInfo(2024, ViewInfo.Node, "CallBehaviorAction");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2025, ViewInfo.Node, "OutputPin");

		root.addNode(2024, viewInfo);

		root.addNode(2027, viewInfo);

		viewInfo = new BaseViewInfo(2026, ViewInfo.Node, "InputPin");

		root.addNode(2024, viewInfo);

		root.addNode(2027, viewInfo);

		viewInfo = new BaseViewInfo(2027, ViewInfo.Node, "CallOperationAction");

		root.addNode(1001, viewInfo);

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2028, ViewInfo.Node, "InputPin");

		root.addNode(2027, viewInfo);

		viewInfo = new BaseViewInfo(2029, ViewInfo.Node, "ActivityParameterNode");

		root.addNode(1001, viewInfo);

		viewInfo = new BaseViewInfo(2030, ViewInfo.Node, "ActivityPartition");

		root.addNode(1001, viewInfo);

		viewInfo = new BaseViewInfo(2031, ViewInfo.Node, "ActivityPartition");

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2032, ViewInfo.Node, "OpaqueAction");

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		viewInfo = new BaseViewInfo(2033, ViewInfo.Node, "AcceptEventAction");

		root.addNode(2031, viewInfo);

		root.addNode(2030, viewInfo);

		return root;
	}

}
