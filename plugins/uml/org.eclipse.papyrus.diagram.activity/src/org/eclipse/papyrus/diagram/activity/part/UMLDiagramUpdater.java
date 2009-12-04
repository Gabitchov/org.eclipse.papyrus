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
 *  Marc Gil Sendra (Prodevelop)
 */
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
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventAction2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartition2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionActivityPartitionCompartment2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionActivityPartitionCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivitySubverticesEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin5EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin6EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectNodeSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueAction2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinEditPart;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.util.BasicEcoreSwitch;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * @generated
 */
@SuppressWarnings("unchecked")
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_1001SemanticChildren(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_2001SemanticChildren(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_2005SemanticChildren(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_2007SemanticChildren(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_2014SemanticChildren(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_2022SemanticChildren(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_2024SemanticChildren(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_2027SemanticChildren(view);
		case OpaqueAction2EditPart.VISUAL_ID:
			return getOpaqueAction_2032SemanticChildren(view);
		case AcceptEventAction2EditPart.VISUAL_ID:
			return getAcceptEventAction_2033SemanticChildren(view);
		case ActivitySubverticesEditPart.VISUAL_ID:
			return getActivitySubvertices_5001SemanticChildren(view);
		case ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID:
			return getActivityPartitionActivityPartitionCompartment_5002SemanticChildren(view);
		case ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID:
			return getActivityPartitionActivityPartitionCompartment_5003SemanticChildren(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 * 
	 *            Modified to handle an Activity as canvas element.
	 */
	public static List getActivity_1001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ActivityParameterNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * Modified to add the request pin as a child whether it is a pin or a valuepin.
	 * 
	 * @generated NOT
	 */
	public static List getSendObjectAction_2001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		SendObjectAction modelElement = (SendObjectAction) view.getElement();
		List result = new LinkedList();
		{
			InputPin childElement = modelElement.getTarget();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputPinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		{
			InputPin childElement = modelElement.getRequest();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputPinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if (visualID == InputPin2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if (visualID == ValuePinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSendSignalAction_2005SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		SendSignalAction modelElement = (SendSignalAction) view.getElement();
		List result = new LinkedList();
		{
			InputPin childElement = modelElement.getTarget();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputPin3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAcceptEventAction_2007SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		AcceptEventAction modelElement = (AcceptEventAction) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getResults().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutputPinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_2014SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		OpaqueAction modelElement = (OpaqueAction) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOutputValues().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutputPin2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getInputValues().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputPin4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValuePin2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCreateObjectAction_2022SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CreateObjectAction modelElement = (CreateObjectAction) view.getElement();
		List result = new LinkedList();
		{
			OutputPin childElement = modelElement.getResult();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutputPin3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallBehaviorAction_2024SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CallBehaviorAction modelElement = (CallBehaviorAction) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getResults().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutputPin4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getArguments().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputPin5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated not
	 */
	public static List getCallOperationAction_2027SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CallOperationAction modelElement = (CallOperationAction) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getResults().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutputPin4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getArguments().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputPin5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			InputPin childElement = modelElement.getTarget();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputPin5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if (visualID == InputPin6EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_2032SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		OpaqueAction modelElement = (OpaqueAction) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOutputValues().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutputPin2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getInputValues().iterator(); it.hasNext();) {
			InputPin childElement = (InputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InputPin4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValuePin2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAcceptEventAction_2033SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		AcceptEventAction modelElement = (AcceptEventAction) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getResults().iterator(); it.hasNext();) {
			OutputPin childElement = (OutputPin) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OutputPinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivitySubvertices_5001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AcceptEventActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ActivityFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InitialNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OpaqueActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FlowFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallBehaviorActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallOperationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getGroups().iterator(); it.hasNext();) {
			ActivityGroup childElement = (ActivityGroup) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ActivityPartitionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityPartitionActivityPartitionCompartment_5002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ActivityPartition modelElement = (ActivityPartition) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSubpartitions().iterator(); it.hasNext();) {
			ActivityPartition childElement = (ActivityPartition) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ActivityPartition2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OpaqueAction2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AcceptEventAction2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ActivityFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InitialNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FlowFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallBehaviorActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallOperationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityPartitionActivityPartitionCompartment_5003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ActivityPartition modelElement = (ActivityPartition) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSubpartitions().iterator(); it.hasNext();) {
			ActivityPartition childElement = (ActivityPartition) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ActivityPartition2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OpaqueAction2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AcceptEventAction2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SendObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendSignalActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ActivityFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DecisionNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InitialNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataStoreNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FlowFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForkNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == JoinNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PinEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CreateObjectActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallBehaviorActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallOperationActionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT modified to handle an Activity as a canvas element.
	 */
	static class ThisDiagramUpdaterSwitch extends BasicEcoreSwitch<List<UMLNodeDescriptor>, View> {

		@Override
		public List<UMLNodeDescriptor> doSwitch(EObject modelElement) {

			final View view = getInfo();
			if (view == null) {
				return Collections.EMPTY_LIST;
			}

			UMLSwitch<List<UMLNodeDescriptor>> aSwitch = new UMLSwitch<List<UMLNodeDescriptor>>() {

				@Override
				public List<UMLNodeDescriptor> casePackage(Package modelElement) {
					List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
					for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
						PackageableElement childElement = (PackageableElement) it.next();
						int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
						if (visualID == ActivityEditPart.VISUAL_ID) {
							result.add(new UMLNodeDescriptor(childElement, visualID));
							continue;
						}
					}
					for (Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
						Comment childElement = (Comment) it.next();
						int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
						if (visualID == CommentEditPart.VISUAL_ID) {
							result.add(new UMLNodeDescriptor(childElement, visualID));
							continue;
						}
					}
					return result;
				}

				@Override
				public List<UMLNodeDescriptor> caseActivity(Activity modelElement) {
					List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
					for (Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
						Comment childElement = (Comment) it.next();
						int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
						if (visualID == CommentEditPart.VISUAL_ID) {
							result.add(new UMLNodeDescriptor(childElement, visualID));
							continue;
						}
					}
					result.add(new UMLNodeDescriptor(modelElement, ActivityEditPart.VISUAL_ID));
					return result;
				}

			};
			return aSwitch.doSwitch(modelElement);
		}
	}

	/**
	 * @generated
	 */
	private static ThisDiagramUpdaterSwitch aSwitch = new ThisDiagramUpdaterSwitch();

	/**
	 * @generated
	 */
	public static List getPackage_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EObject modelElement = (EObject) view.getElement();
		aSwitch.setInfo(view);
		List<UMLNodeDescriptor> result = aSwitch.doSwitch(modelElement);
		if (result == null || result.size() <= 0) {
			return Collections.EMPTY_LIST;
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_79ContainedLinks(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_1001ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2034ContainedLinks(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_2001ContainedLinks(view);
		case InputPinEditPart.VISUAL_ID:
			return getInputPin_2002ContainedLinks(view);
		case InputPin2EditPart.VISUAL_ID:
			return getInputPin_2003ContainedLinks(view);
		case ValuePinEditPart.VISUAL_ID:
			return getValuePin_2004ContainedLinks(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_2005ContainedLinks(view);
		case InputPin3EditPart.VISUAL_ID:
			return getInputPin_2006ContainedLinks(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_2007ContainedLinks(view);
		case OutputPinEditPart.VISUAL_ID:
			return getOutputPin_2008ContainedLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_2009ContainedLinks(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_2010ContainedLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_2011ContainedLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_2012ContainedLinks(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_2013ContainedLinks(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_2014ContainedLinks(view);
		case OutputPin2EditPart.VISUAL_ID:
			return getOutputPin_2015ContainedLinks(view);
		case InputPin4EditPart.VISUAL_ID:
			return getInputPin_2016ContainedLinks(view);
		case ValuePin2EditPart.VISUAL_ID:
			return getValuePin_2017ContainedLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_2018ContainedLinks(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_2019ContainedLinks(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_2020ContainedLinks(view);
		case PinEditPart.VISUAL_ID:
			return getPin_2021ContainedLinks(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_2022ContainedLinks(view);
		case OutputPin3EditPart.VISUAL_ID:
			return getOutputPin_2023ContainedLinks(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_2024ContainedLinks(view);
		case OutputPin4EditPart.VISUAL_ID:
			return getOutputPin_2025ContainedLinks(view);
		case InputPin5EditPart.VISUAL_ID:
			return getInputPin_2026ContainedLinks(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_2027ContainedLinks(view);
		case InputPin6EditPart.VISUAL_ID:
			return getInputPin_2028ContainedLinks(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_2029ContainedLinks(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_2030ContainedLinks(view);
		case ActivityPartition2EditPart.VISUAL_ID:
			return getActivityPartition_2031ContainedLinks(view);
		case OpaqueAction2EditPart.VISUAL_ID:
			return getOpaqueAction_2032ContainedLinks(view);
		case AcceptEventAction2EditPart.VISUAL_ID:
			return getAcceptEventAction_2033ContainedLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_3001ContainedLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_3002ContainedLinks(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_3004ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_1001IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2034IncomingLinks(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_2001IncomingLinks(view);
		case InputPinEditPart.VISUAL_ID:
			return getInputPin_2002IncomingLinks(view);
		case InputPin2EditPart.VISUAL_ID:
			return getInputPin_2003IncomingLinks(view);
		case ValuePinEditPart.VISUAL_ID:
			return getValuePin_2004IncomingLinks(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_2005IncomingLinks(view);
		case InputPin3EditPart.VISUAL_ID:
			return getInputPin_2006IncomingLinks(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_2007IncomingLinks(view);
		case OutputPinEditPart.VISUAL_ID:
			return getOutputPin_2008IncomingLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_2009IncomingLinks(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_2010IncomingLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_2011IncomingLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_2012IncomingLinks(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_2013IncomingLinks(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_2014IncomingLinks(view);
		case OutputPin2EditPart.VISUAL_ID:
			return getOutputPin_2015IncomingLinks(view);
		case InputPin4EditPart.VISUAL_ID:
			return getInputPin_2016IncomingLinks(view);
		case ValuePin2EditPart.VISUAL_ID:
			return getValuePin_2017IncomingLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_2018IncomingLinks(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_2019IncomingLinks(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_2020IncomingLinks(view);
		case PinEditPart.VISUAL_ID:
			return getPin_2021IncomingLinks(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_2022IncomingLinks(view);
		case OutputPin3EditPart.VISUAL_ID:
			return getOutputPin_2023IncomingLinks(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_2024IncomingLinks(view);
		case OutputPin4EditPart.VISUAL_ID:
			return getOutputPin_2025IncomingLinks(view);
		case InputPin5EditPart.VISUAL_ID:
			return getInputPin_2026IncomingLinks(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_2027IncomingLinks(view);
		case InputPin6EditPart.VISUAL_ID:
			return getInputPin_2028IncomingLinks(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_2029IncomingLinks(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_2030IncomingLinks(view);
		case ActivityPartition2EditPart.VISUAL_ID:
			return getActivityPartition_2031IncomingLinks(view);
		case OpaqueAction2EditPart.VISUAL_ID:
			return getOpaqueAction_2032IncomingLinks(view);
		case AcceptEventAction2EditPart.VISUAL_ID:
			return getAcceptEventAction_2033IncomingLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_3001IncomingLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_3002IncomingLinks(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_3004IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_1001OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2034OutgoingLinks(view);
		case SendObjectActionEditPart.VISUAL_ID:
			return getSendObjectAction_2001OutgoingLinks(view);
		case InputPinEditPart.VISUAL_ID:
			return getInputPin_2002OutgoingLinks(view);
		case InputPin2EditPart.VISUAL_ID:
			return getInputPin_2003OutgoingLinks(view);
		case ValuePinEditPart.VISUAL_ID:
			return getValuePin_2004OutgoingLinks(view);
		case SendSignalActionEditPart.VISUAL_ID:
			return getSendSignalAction_2005OutgoingLinks(view);
		case InputPin3EditPart.VISUAL_ID:
			return getInputPin_2006OutgoingLinks(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_2007OutgoingLinks(view);
		case OutputPinEditPart.VISUAL_ID:
			return getOutputPin_2008OutgoingLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_2009OutgoingLinks(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_2010OutgoingLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_2011OutgoingLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_2012OutgoingLinks(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_2013OutgoingLinks(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_2014OutgoingLinks(view);
		case OutputPin2EditPart.VISUAL_ID:
			return getOutputPin_2015OutgoingLinks(view);
		case InputPin4EditPart.VISUAL_ID:
			return getInputPin_2016OutgoingLinks(view);
		case ValuePin2EditPart.VISUAL_ID:
			return getValuePin_2017OutgoingLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_2018OutgoingLinks(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_2019OutgoingLinks(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_2020OutgoingLinks(view);
		case PinEditPart.VISUAL_ID:
			return getPin_2021OutgoingLinks(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_2022OutgoingLinks(view);
		case OutputPin3EditPart.VISUAL_ID:
			return getOutputPin_2023OutgoingLinks(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_2024OutgoingLinks(view);
		case OutputPin4EditPart.VISUAL_ID:
			return getOutputPin_2025OutgoingLinks(view);
		case InputPin5EditPart.VISUAL_ID:
			return getInputPin_2026OutgoingLinks(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_2027OutgoingLinks(view);
		case InputPin6EditPart.VISUAL_ID:
			return getInputPin_2028OutgoingLinks(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_2029OutgoingLinks(view);
		case ActivityPartitionEditPart.VISUAL_ID:
			return getActivityPartition_2030OutgoingLinks(view);
		case ActivityPartition2EditPart.VISUAL_ID:
			return getActivityPartition_2031OutgoingLinks(view);
		case OpaqueAction2EditPart.VISUAL_ID:
			return getOpaqueAction_2032OutgoingLinks(view);
		case AcceptEventAction2EditPart.VISUAL_ID:
			return getAcceptEventAction_2033OutgoingLinks(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_3001OutgoingLinks(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_3002OutgoingLinks(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_3004OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 * 
	 *            Modified to handle an Activiy as a canvas element.
	 */
	public static List getPackage_79ContainedLinks(View view) {
		EObject modelElement = view.getElement();
		if (modelElement instanceof Element) {
			List result = new LinkedList();
			result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005((Element) modelElement));
			return result;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_1001ContainedLinks(View view) {
		Activity modelElement = (Activity) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSendObjectAction_2001ContainedLinks(View view) {
		SendObjectAction modelElement = (SendObjectAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2002ContainedLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2003ContainedLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_2004ContainedLinks(View view) {
		ValuePin modelElement = (ValuePin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSendSignalAction_2005ContainedLinks(View view) {
		SendSignalAction modelElement = (SendSignalAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2006ContainedLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAcceptEventAction_2007ContainedLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2008ContainedLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_2009ContainedLinks(View view) {
		ActivityFinalNode modelElement = (ActivityFinalNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDecisionNode_2010ContainedLinks(View view) {
		DecisionNode modelElement = (DecisionNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMergeNode_2011ContainedLinks(View view) {
		MergeNode modelElement = (MergeNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_2012ContainedLinks(View view) {
		InitialNode modelElement = (InitialNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataStoreNode_2013ContainedLinks(View view) {
		DataStoreNode modelElement = (DataStoreNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_2014ContainedLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2015ContainedLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2016ContainedLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_2017ContainedLinks(View view) {
		ValuePin modelElement = (ValuePin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_2018ContainedLinks(View view) {
		FlowFinalNode modelElement = (FlowFinalNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getForkNode_2019ContainedLinks(View view) {
		ForkNode modelElement = (ForkNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getJoinNode_2020ContainedLinks(View view) {
		JoinNode modelElement = (JoinNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPin_2021ContainedLinks(View view) {
		Pin modelElement = (Pin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCreateObjectAction_2022ContainedLinks(View view) {
		CreateObjectAction modelElement = (CreateObjectAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2023ContainedLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallBehaviorAction_2024ContainedLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2025ContainedLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2026ContainedLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallOperationAction_2027ContainedLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2028ContainedLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityParameterNode_2029ContainedLinks(View view) {
		ActivityParameterNode modelElement = (ActivityParameterNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityPartition_2030ContainedLinks(View view) {
		ActivityPartition modelElement = (ActivityPartition) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityPartition_2031ContainedLinks(View view) {
		ActivityPartition modelElement = (ActivityPartition) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_2032ContainedLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAcceptEventAction_2033ContainedLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2034ContainedLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getControlFlow_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getObjectFlow_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExceptionHandler_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_1001IncomingLinks(View view) {
		Activity modelElement = (Activity) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSendObjectAction_2001IncomingLinks(View view) {
		SendObjectAction modelElement = (SendObjectAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2002IncomingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2003IncomingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_2004IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSendSignalAction_2005IncomingLinks(View view) {
		SendSignalAction modelElement = (SendSignalAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2006IncomingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAcceptEventAction_2007IncomingLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2008IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_2009IncomingLinks(View view) {
		ActivityFinalNode modelElement = (ActivityFinalNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDecisionNode_2010IncomingLinks(View view) {
		DecisionNode modelElement = (DecisionNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMergeNode_2011IncomingLinks(View view) {
		MergeNode modelElement = (MergeNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_2012IncomingLinks(View view) {
		InitialNode modelElement = (InitialNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataStoreNode_2013IncomingLinks(View view) {
		DataStoreNode modelElement = (DataStoreNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_2014IncomingLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2015IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2016IncomingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_2017IncomingLinks(View view) {
		ValuePin modelElement = (ValuePin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_2018IncomingLinks(View view) {
		FlowFinalNode modelElement = (FlowFinalNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getForkNode_2019IncomingLinks(View view) {
		ForkNode modelElement = (ForkNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getJoinNode_2020IncomingLinks(View view) {
		JoinNode modelElement = (JoinNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPin_2021IncomingLinks(View view) {
		Pin modelElement = (Pin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCreateObjectAction_2022IncomingLinks(View view) {
		CreateObjectAction modelElement = (CreateObjectAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2023IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallBehaviorAction_2024IncomingLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2025IncomingLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2026IncomingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallOperationAction_2027IncomingLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2028IncomingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityParameterNode_2029IncomingLinks(View view) {
		ActivityParameterNode modelElement = (ActivityParameterNode) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityPartition_2030IncomingLinks(View view) {
		ActivityPartition modelElement = (ActivityPartition) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityPartition_2031IncomingLinks(View view) {
		ActivityPartition modelElement = (ActivityPartition) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_2032IncomingLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAcceptEventAction_2033IncomingLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ControlFlow_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ObjectFlow_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ExceptionHandler_3004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2034IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getControlFlow_3001IncomingLinks(View view) {
		ControlFlow modelElement = (ControlFlow) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getObjectFlow_3002IncomingLinks(View view) {
		ObjectFlow modelElement = (ObjectFlow) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExceptionHandler_3004IncomingLinks(View view) {
		ExceptionHandler modelElement = (ExceptionHandler) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivity_1001OutgoingLinks(View view) {
		Activity modelElement = (Activity) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSendObjectAction_2001OutgoingLinks(View view) {
		SendObjectAction modelElement = (SendObjectAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2002OutgoingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2003OutgoingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_2004OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSendSignalAction_2005OutgoingLinks(View view) {
		SendSignalAction modelElement = (SendSignalAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2006OutgoingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAcceptEventAction_2007OutgoingLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2008OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_2009OutgoingLinks(View view) {
		ActivityFinalNode modelElement = (ActivityFinalNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDecisionNode_2010OutgoingLinks(View view) {
		DecisionNode modelElement = (DecisionNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMergeNode_2011OutgoingLinks(View view) {
		MergeNode modelElement = (MergeNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_2012OutgoingLinks(View view) {
		InitialNode modelElement = (InitialNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataStoreNode_2013OutgoingLinks(View view) {
		DataStoreNode modelElement = (DataStoreNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_2014OutgoingLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2015OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2016OutgoingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getValuePin_2017OutgoingLinks(View view) {
		ValuePin modelElement = (ValuePin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_2018OutgoingLinks(View view) {
		FlowFinalNode modelElement = (FlowFinalNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getForkNode_2019OutgoingLinks(View view) {
		ForkNode modelElement = (ForkNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getJoinNode_2020OutgoingLinks(View view) {
		JoinNode modelElement = (JoinNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPin_2021OutgoingLinks(View view) {
		Pin modelElement = (Pin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCreateObjectAction_2022OutgoingLinks(View view) {
		CreateObjectAction modelElement = (CreateObjectAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2023OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallBehaviorAction_2024OutgoingLinks(View view) {
		CallBehaviorAction modelElement = (CallBehaviorAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOutputPin_2025OutgoingLinks(View view) {
		OutputPin modelElement = (OutputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2026OutgoingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCallOperationAction_2027OutgoingLinks(View view) {
		CallOperationAction modelElement = (CallOperationAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInputPin_2028OutgoingLinks(View view) {
		InputPin modelElement = (InputPin) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityParameterNode_2029OutgoingLinks(View view) {
		ActivityParameterNode modelElement = (ActivityParameterNode) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityPartition_2030OutgoingLinks(View view) {
		ActivityPartition modelElement = (ActivityPartition) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityPartition_2031OutgoingLinks(View view) {
		ActivityPartition modelElement = (ActivityPartition) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOpaqueAction_2032OutgoingLinks(View view) {
		OpaqueAction modelElement = (OpaqueAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAcceptEventAction_2033OutgoingLinks(View view) {
		AcceptEventAction modelElement = (AcceptEventAction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ControlFlow_3001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ObjectFlow_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2034OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getControlFlow_3001OutgoingLinks(View view) {
		ControlFlow modelElement = (ControlFlow) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getObjectFlow_3002OutgoingLinks(View view) {
		ObjectFlow modelElement = (ObjectFlow) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExceptionHandler_3004OutgoingLinks(View view) {
		ExceptionHandler modelElement = (ExceptionHandler) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ControlFlow_3001(Activity container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ControlFlow) {
				continue;
			}
			ControlFlow link = (ControlFlow) linkObject;
			if (ControlFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityNode dst = link.getTarget();
			ActivityNode src = link.getSource();
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.ControlFlow_3001, ControlFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ObjectFlow_3002(Activity container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ObjectFlow) {
				continue;
			}
			ObjectFlow link = (ObjectFlow) linkObject;
			if (ObjectFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityNode dst = link.getTarget();
			ActivityNode src = link.getSource();
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.ObjectFlow_3002, ObjectFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ExceptionHandler_3004(ExecutableNode container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getHandlers().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ExceptionHandler) {
				continue;
			}
			ExceptionHandler link = (ExceptionHandler) linkObject;
			if (ExceptionHandlerEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ExecutableNode dst = link.getHandlerBody();
			ExecutableNode src = link.getProtectedNode();
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.ExceptionHandler_3004, ExceptionHandlerEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ControlFlow_3001(ActivityNode target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getActivityEdge_Target() || false == setting.getEObject() instanceof ControlFlow) {
				continue;
			}
			ControlFlow link = (ControlFlow) setting.getEObject();
			if (ControlFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityNode src = link.getSource();
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, target, link, UMLElementTypes.ControlFlow_3001, ControlFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ObjectFlow_3002(ActivityNode target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getActivityEdge_Target() || false == setting.getEObject() instanceof ObjectFlow) {
				continue;
			}
			ObjectFlow link = (ObjectFlow) setting.getEObject();
			if (ObjectFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityNode src = link.getSource();
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, target, link, UMLElementTypes.ObjectFlow_3002, ObjectFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_ObjectNode_Selection_3003(Behavior target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getObjectNode_Selection()) {
				result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ObjectNodeSelection_3003,
						ObjectNodeSelectionEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ExceptionHandler_3004(ExecutableNode target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getExceptionHandler_HandlerBody() || false == setting.getEObject() instanceof ExceptionHandler) {
				continue;
			}
			ExceptionHandler link = (ExceptionHandler) setting.getEObject();
			if (ExceptionHandlerEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ExecutableNode src = link.getProtectedNode();
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, target, link, UMLElementTypes.ExceptionHandler_3004, ExceptionHandlerEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Element_OwnedComment_3005(Comment target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getElement_OwnedComment()) {
				result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ElementOwnedComment_3005,
						ElementOwnedCommentEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_3006,
						CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ControlFlow_3001(ActivityNode source) {
		Activity container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Activity) {
				container = (Activity) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ControlFlow) {
				continue;
			}
			ControlFlow link = (ControlFlow) linkObject;
			if (ControlFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityNode dst = link.getTarget();
			ActivityNode src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.ControlFlow_3001, ControlFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ObjectFlow_3002(ActivityNode source) {
		Activity container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Activity) {
				container = (Activity) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ObjectFlow) {
				continue;
			}
			ObjectFlow link = (ObjectFlow) linkObject;
			if (ObjectFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ActivityNode dst = link.getTarget();
			ActivityNode src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.ObjectFlow_3002, ObjectFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Modified to prevent creation of LinkDescriptor when there's no source
	 * 
	 * @generated NOT
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_ObjectNode_Selection_3003(ObjectNode source) {
		Collection result = new LinkedList();
		Behavior destination = source.getSelection();
		if (destination != null) {
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(source, destination, UMLElementTypes.ObjectNodeSelection_3003, ObjectNodeSelectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ExceptionHandler_3004(ExecutableNode source) {
		ExecutableNode container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof ExecutableNode) {
				container = (ExecutableNode) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getHandlers().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ExceptionHandler) {
				continue;
			}
			ExceptionHandler link = (ExceptionHandler) linkObject;
			if (ExceptionHandlerEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ExecutableNode dst = link.getHandlerBody();
			ExecutableNode src = link.getProtectedNode();
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.ExceptionHandler_3004, ExceptionHandlerEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated not
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3005(Element source) {
		return new LinkedList();
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3006(Comment source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_3006, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Modified to implement.
	 * 
	 * @generated NOT
	 */
	public static UMLLinkDescriptor createLinkDescriptorFromModelElement(EObject eObject) {
		int linkID = UMLVisualIDRegistry.getLinkWithClassVisualID(eObject);
		switch (linkID) {
		case ObjectFlowEditPart.VISUAL_ID:
			return createLinkDescriptorFromObjectFlow((ObjectFlow) eObject);
		case ControlFlowEditPart.VISUAL_ID:
			return createLinkDescriptorFromContorlFlow((ControlFlow) eObject);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return createLinkDescriptorFromExceptionHandler((ExceptionHandler) eObject);
		default:
			return null;
		}
	}

	private static UMLLinkDescriptor createLinkDescriptorFromContorlFlow(ControlFlow controlFlow) {
		ActivityNode src = controlFlow.getSource();
		ActivityNode target = controlFlow.getTarget();
		return new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, target, controlFlow, UMLElementTypes.ControlFlow_3001, ControlFlowEditPart.VISUAL_ID);
	}

	private static UMLLinkDescriptor createLinkDescriptorFromObjectFlow(ObjectFlow objectFlow) {
		ActivityNode src = objectFlow.getSource();
		ActivityNode target = objectFlow.getTarget();
		return new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, target, objectFlow, UMLElementTypes.ObjectFlow_3002, ObjectFlowEditPart.VISUAL_ID);
	}

	private static UMLLinkDescriptor createLinkDescriptorFromExceptionHandler(ExceptionHandler exceptionHandler) {
		ExecutableNode src = exceptionHandler.getProtectedNode();
		ExecutableNode target = exceptionHandler.getHandlerBody();
		return new org.eclipse.papyrus.diagram.activity.part.UMLLinkDescriptor(src, target, exceptionHandler, UMLElementTypes.ExceptionHandler_3004, ExceptionHandlerEditPart.VISUAL_ID);
	}
}
