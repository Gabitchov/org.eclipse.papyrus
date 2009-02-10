/*******************************************************************************
 * Copyright (c) 2008 
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
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
import org.eclipse.papyrus.diagram.activity.edit.parts.CommentAnnotatedElementEditPart;
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
import org.eclipse.papyrus.diagram.activity.edit.parts.ElementOwnedCommentEditPart;
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
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectNodeSelectionEditPart;
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
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.view.factories.AcceptEventAction2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.AcceptEventActionName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.AcceptEventActionName3ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.AcceptEventActionName4ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.AcceptEventActionNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.AcceptEventActionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityFinalNodeNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityFinalNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityParameterNodeNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityParameterNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityPartition2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityPartitionActivityPartitionCompartment2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityPartitionActivityPartitionCompartmentViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityPartitionName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityPartitionNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityPartitionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivitySubverticesViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ActivityViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CallBehaviorActionName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CallBehaviorActionNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CallBehaviorActionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CallOperationActionName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CallOperationActionNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CallOperationActionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CommentAnnotatedElementViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CommentBodyViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CommentViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ControlFlowNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ControlFlowViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CreateObjectActionName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CreateObjectActionNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.CreateObjectActionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.DataStoreNodeNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.DataStoreNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.DecisionNodeNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.DecisionNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ElementOwnedCommentViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ExceptionHandlerViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.FlowFinalNodeNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.FlowFinalNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ForkNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InitialNodeNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InitialNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPin2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPin3ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPin4ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPin5ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPin6ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPinName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPinName3ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPinName4ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPinName5ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPinName6ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPinNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.InputPinViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.JoinNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.MergeNodeNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.MergeNodeViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ObjectFlowNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ObjectFlowViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ObjectNodeSelectionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OpaqueAction2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OpaqueActionName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OpaqueActionName3ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OpaqueActionName4ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OpaqueActionNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OpaqueActionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OutputPin2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OutputPin3ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OutputPin4ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OutputPinName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OutputPinName3ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OutputPinName4ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OutputPinNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.OutputPinViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.PackageViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.PinNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.PinViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.SendObjectActionName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.SendObjectActionNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.SendObjectActionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.SendSignalActionName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.SendSignalActionNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.SendSignalActionViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ValuePin2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ValuePinName2ViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ValuePinNameViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ValuePinViewFactory;
import org.eclipse.papyrus.diagram.activity.view.factories.ZigZagLabelViewFactory;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	@Override
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (PackageEditPart.MODEL_ID.equals(diagramKind) && UMLVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return PackageViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present.
				// This method is called with EObjectAdapter as parameter from:
				// - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint)
				// - generated ViewFactory.decorateView() for parent element
				if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case ActivityEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case SendObjectActionEditPart.VISUAL_ID:
				case InputPinEditPart.VISUAL_ID:
				case InputPin2EditPart.VISUAL_ID:
				case ValuePinEditPart.VISUAL_ID:
				case SendSignalActionEditPart.VISUAL_ID:
				case InputPin3EditPart.VISUAL_ID:
				case AcceptEventActionEditPart.VISUAL_ID:
				case OutputPinEditPart.VISUAL_ID:
				case ActivityFinalNodeEditPart.VISUAL_ID:
				case DecisionNodeEditPart.VISUAL_ID:
				case MergeNodeEditPart.VISUAL_ID:
				case InitialNodeEditPart.VISUAL_ID:
				case DataStoreNodeEditPart.VISUAL_ID:
				case OpaqueActionEditPart.VISUAL_ID:
				case OutputPin2EditPart.VISUAL_ID:
				case InputPin4EditPart.VISUAL_ID:
				case ValuePin2EditPart.VISUAL_ID:
				case FlowFinalNodeEditPart.VISUAL_ID:
				case ForkNodeEditPart.VISUAL_ID:
				case JoinNodeEditPart.VISUAL_ID:
				case PinEditPart.VISUAL_ID:
				case CreateObjectActionEditPart.VISUAL_ID:
				case OutputPin3EditPart.VISUAL_ID:
				case CallBehaviorActionEditPart.VISUAL_ID:
				case OutputPin4EditPart.VISUAL_ID:
				case InputPin5EditPart.VISUAL_ID:
				case CallOperationActionEditPart.VISUAL_ID:
				case InputPin6EditPart.VISUAL_ID:
				case ActivityParameterNodeEditPart.VISUAL_ID:
				case ActivityPartitionEditPart.VISUAL_ID:
				case ActivityPartition2EditPart.VISUAL_ID:
				case OpaqueAction2EditPart.VISUAL_ID:
				case AcceptEventAction2EditPart.VISUAL_ID:
					if (domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case ActivityNameEditPart.VISUAL_ID:
				case ActivitySubverticesEditPart.VISUAL_ID:
					if (ActivityEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CommentBodyEditPart.VISUAL_ID:
					if (CommentEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SendObjectActionNameEditPart.VISUAL_ID:
				case SendObjectActionName2EditPart.VISUAL_ID:
					if (SendObjectActionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InputPinNameEditPart.VISUAL_ID:
					if (InputPinEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InputPinName2EditPart.VISUAL_ID:
					if (InputPin2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ValuePinNameEditPart.VISUAL_ID:
					if (ValuePinEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SendSignalActionNameEditPart.VISUAL_ID:
				case SendSignalActionName2EditPart.VISUAL_ID:
					if (SendSignalActionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InputPinName3EditPart.VISUAL_ID:
					if (InputPin3EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AcceptEventActionNameEditPart.VISUAL_ID:
				case AcceptEventActionName2EditPart.VISUAL_ID:
					if (AcceptEventActionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OutputPinNameEditPart.VISUAL_ID:
					if (OutputPinEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ActivityFinalNodeNameEditPart.VISUAL_ID:
					if (ActivityFinalNodeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DecisionNodeNameEditPart.VISUAL_ID:
					if (DecisionNodeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case MergeNodeNameEditPart.VISUAL_ID:
					if (MergeNodeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InitialNodeNameEditPart.VISUAL_ID:
					if (InitialNodeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DataStoreNodeNameEditPart.VISUAL_ID:
					if (DataStoreNodeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OpaqueActionNameEditPart.VISUAL_ID:
				case OpaqueActionName2EditPart.VISUAL_ID:
					if (OpaqueActionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OutputPinName2EditPart.VISUAL_ID:
					if (OutputPin2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InputPinName4EditPart.VISUAL_ID:
					if (InputPin4EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ValuePinName2EditPart.VISUAL_ID:
					if (ValuePin2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case FlowFinalNodeNameEditPart.VISUAL_ID:
					if (FlowFinalNodeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PinNameEditPart.VISUAL_ID:
					if (PinEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CreateObjectActionNameEditPart.VISUAL_ID:
				case CreateObjectActionName2EditPart.VISUAL_ID:
					if (CreateObjectActionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OutputPinName3EditPart.VISUAL_ID:
					if (OutputPin3EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CallBehaviorActionNameEditPart.VISUAL_ID:
				case CallBehaviorActionName2EditPart.VISUAL_ID:
					if (CallBehaviorActionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OutputPinName4EditPart.VISUAL_ID:
					if (OutputPin4EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InputPinName5EditPart.VISUAL_ID:
					if (InputPin5EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CallOperationActionNameEditPart.VISUAL_ID:
				case CallOperationActionName2EditPart.VISUAL_ID:
					if (CallOperationActionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InputPinName6EditPart.VISUAL_ID:
					if (InputPin6EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ActivityParameterNodeNameEditPart.VISUAL_ID:
					if (ActivityParameterNodeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ActivityPartitionNameEditPart.VISUAL_ID:
				case ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID:
					if (ActivityPartitionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ActivityPartitionName2EditPart.VISUAL_ID:
				case ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID:
					if (ActivityPartition2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OpaqueActionName3EditPart.VISUAL_ID:
				case OpaqueActionName4EditPart.VISUAL_ID:
					if (OpaqueAction2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AcceptEventActionName3EditPart.VISUAL_ID:
				case AcceptEventActionName4EditPart.VISUAL_ID:
					if (AcceptEventAction2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ControlFlowNameEditPart.VISUAL_ID:
					if (ControlFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ObjectFlowNameEditPart.VISUAL_ID:
					if (ObjectFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ZigZagLabelEditPart.VISUAL_ID:
					if (ExceptionHandlerEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null || !UMLVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case ActivityEditPart.VISUAL_ID:
			return ActivityViewFactory.class;
		case ActivityNameEditPart.VISUAL_ID:
			return ActivityNameViewFactory.class;
		case CommentEditPart.VISUAL_ID:
			return CommentViewFactory.class;
		case CommentBodyEditPart.VISUAL_ID:
			return CommentBodyViewFactory.class;
		case SendObjectActionEditPart.VISUAL_ID:
			return SendObjectActionViewFactory.class;
		case SendObjectActionNameEditPart.VISUAL_ID:
			return SendObjectActionNameViewFactory.class;
		case SendObjectActionName2EditPart.VISUAL_ID:
			return SendObjectActionName2ViewFactory.class;
		case InputPinEditPart.VISUAL_ID:
			return InputPinViewFactory.class;
		case InputPinNameEditPart.VISUAL_ID:
			return InputPinNameViewFactory.class;
		case InputPin2EditPart.VISUAL_ID:
			return InputPin2ViewFactory.class;
		case InputPinName2EditPart.VISUAL_ID:
			return InputPinName2ViewFactory.class;
		case ValuePinEditPart.VISUAL_ID:
			return ValuePinViewFactory.class;
		case ValuePinNameEditPart.VISUAL_ID:
			return ValuePinNameViewFactory.class;
		case SendSignalActionEditPart.VISUAL_ID:
			return SendSignalActionViewFactory.class;
		case SendSignalActionNameEditPart.VISUAL_ID:
			return SendSignalActionNameViewFactory.class;
		case SendSignalActionName2EditPart.VISUAL_ID:
			return SendSignalActionName2ViewFactory.class;
		case InputPin3EditPart.VISUAL_ID:
			return InputPin3ViewFactory.class;
		case InputPinName3EditPart.VISUAL_ID:
			return InputPinName3ViewFactory.class;
		case AcceptEventActionEditPart.VISUAL_ID:
			return AcceptEventActionViewFactory.class;
		case AcceptEventActionNameEditPart.VISUAL_ID:
			return AcceptEventActionNameViewFactory.class;
		case AcceptEventActionName2EditPart.VISUAL_ID:
			return AcceptEventActionName2ViewFactory.class;
		case OutputPinEditPart.VISUAL_ID:
			return OutputPinViewFactory.class;
		case OutputPinNameEditPart.VISUAL_ID:
			return OutputPinNameViewFactory.class;
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return ActivityFinalNodeViewFactory.class;
		case ActivityFinalNodeNameEditPart.VISUAL_ID:
			return ActivityFinalNodeNameViewFactory.class;
		case DecisionNodeEditPart.VISUAL_ID:
			return DecisionNodeViewFactory.class;
		case DecisionNodeNameEditPart.VISUAL_ID:
			return DecisionNodeNameViewFactory.class;
		case MergeNodeEditPart.VISUAL_ID:
			return MergeNodeViewFactory.class;
		case MergeNodeNameEditPart.VISUAL_ID:
			return MergeNodeNameViewFactory.class;
		case InitialNodeEditPart.VISUAL_ID:
			return InitialNodeViewFactory.class;
		case InitialNodeNameEditPart.VISUAL_ID:
			return InitialNodeNameViewFactory.class;
		case DataStoreNodeEditPart.VISUAL_ID:
			return DataStoreNodeViewFactory.class;
		case DataStoreNodeNameEditPart.VISUAL_ID:
			return DataStoreNodeNameViewFactory.class;
		case OpaqueActionEditPart.VISUAL_ID:
			return OpaqueActionViewFactory.class;
		case OpaqueActionNameEditPart.VISUAL_ID:
			return OpaqueActionNameViewFactory.class;
		case OpaqueActionName2EditPart.VISUAL_ID:
			return OpaqueActionName2ViewFactory.class;
		case OutputPin2EditPart.VISUAL_ID:
			return OutputPin2ViewFactory.class;
		case OutputPinName2EditPart.VISUAL_ID:
			return OutputPinName2ViewFactory.class;
		case InputPin4EditPart.VISUAL_ID:
			return InputPin4ViewFactory.class;
		case InputPinName4EditPart.VISUAL_ID:
			return InputPinName4ViewFactory.class;
		case ValuePin2EditPart.VISUAL_ID:
			return ValuePin2ViewFactory.class;
		case ValuePinName2EditPart.VISUAL_ID:
			return ValuePinName2ViewFactory.class;
		case FlowFinalNodeEditPart.VISUAL_ID:
			return FlowFinalNodeViewFactory.class;
		case FlowFinalNodeNameEditPart.VISUAL_ID:
			return FlowFinalNodeNameViewFactory.class;
		case ForkNodeEditPart.VISUAL_ID:
			return ForkNodeViewFactory.class;
		case JoinNodeEditPart.VISUAL_ID:
			return JoinNodeViewFactory.class;
		case PinEditPart.VISUAL_ID:
			return PinViewFactory.class;
		case PinNameEditPart.VISUAL_ID:
			return PinNameViewFactory.class;
		case CreateObjectActionEditPart.VISUAL_ID:
			return CreateObjectActionViewFactory.class;
		case CreateObjectActionNameEditPart.VISUAL_ID:
			return CreateObjectActionNameViewFactory.class;
		case CreateObjectActionName2EditPart.VISUAL_ID:
			return CreateObjectActionName2ViewFactory.class;
		case OutputPin3EditPart.VISUAL_ID:
			return OutputPin3ViewFactory.class;
		case OutputPinName3EditPart.VISUAL_ID:
			return OutputPinName3ViewFactory.class;
		case CallBehaviorActionEditPart.VISUAL_ID:
			return CallBehaviorActionViewFactory.class;
		case CallBehaviorActionNameEditPart.VISUAL_ID:
			return CallBehaviorActionNameViewFactory.class;
		case CallBehaviorActionName2EditPart.VISUAL_ID:
			return CallBehaviorActionName2ViewFactory.class;
		case OutputPin4EditPart.VISUAL_ID:
			return OutputPin4ViewFactory.class;
		case OutputPinName4EditPart.VISUAL_ID:
			return OutputPinName4ViewFactory.class;
		case InputPin5EditPart.VISUAL_ID:
			return InputPin5ViewFactory.class;
		case InputPinName5EditPart.VISUAL_ID:
			return InputPinName5ViewFactory.class;
		case CallOperationActionEditPart.VISUAL_ID:
			return CallOperationActionViewFactory.class;
		case CallOperationActionNameEditPart.VISUAL_ID:
			return CallOperationActionNameViewFactory.class;
		case CallOperationActionName2EditPart.VISUAL_ID:
			return CallOperationActionName2ViewFactory.class;
		case InputPin6EditPart.VISUAL_ID:
			return InputPin6ViewFactory.class;
		case InputPinName6EditPart.VISUAL_ID:
			return InputPinName6ViewFactory.class;
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return ActivityParameterNodeViewFactory.class;
		case ActivityParameterNodeNameEditPart.VISUAL_ID:
			return ActivityParameterNodeNameViewFactory.class;
		case ActivityPartitionEditPart.VISUAL_ID:
			return ActivityPartitionViewFactory.class;
		case ActivityPartitionNameEditPart.VISUAL_ID:
			return ActivityPartitionNameViewFactory.class;
		case ActivityPartition2EditPart.VISUAL_ID:
			return ActivityPartition2ViewFactory.class;
		case ActivityPartitionName2EditPart.VISUAL_ID:
			return ActivityPartitionName2ViewFactory.class;
		case OpaqueAction2EditPart.VISUAL_ID:
			return OpaqueAction2ViewFactory.class;
		case OpaqueActionName3EditPart.VISUAL_ID:
			return OpaqueActionName3ViewFactory.class;
		case OpaqueActionName4EditPart.VISUAL_ID:
			return OpaqueActionName4ViewFactory.class;
		case AcceptEventAction2EditPart.VISUAL_ID:
			return AcceptEventAction2ViewFactory.class;
		case AcceptEventActionName3EditPart.VISUAL_ID:
			return AcceptEventActionName3ViewFactory.class;
		case AcceptEventActionName4EditPart.VISUAL_ID:
			return AcceptEventActionName4ViewFactory.class;
		case ActivitySubverticesEditPart.VISUAL_ID:
			return ActivitySubverticesViewFactory.class;
		case ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID:
			return ActivityPartitionActivityPartitionCompartmentViewFactory.class;
		case ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID:
			return ActivityPartitionActivityPartitionCompartment2ViewFactory.class;
		case ControlFlowNameEditPart.VISUAL_ID:
			return ControlFlowNameViewFactory.class;
		case ObjectFlowNameEditPart.VISUAL_ID:
			return ObjectFlowNameViewFactory.class;
		case ZigZagLabelEditPart.VISUAL_ID:
			return ZigZagLabelViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null && visualID != UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case ControlFlowEditPart.VISUAL_ID:
			return ControlFlowViewFactory.class;
		case ObjectFlowEditPart.VISUAL_ID:
			return ObjectFlowViewFactory.class;
		case ObjectNodeSelectionEditPart.VISUAL_ID:
			return ObjectNodeSelectionViewFactory.class;
		case ExceptionHandlerEditPart.VISUAL_ID:
			return ExceptionHandlerViewFactory.class;
		case ElementOwnedCommentEditPart.VISUAL_ID:
			return ElementOwnedCommentViewFactory.class;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElementViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

}
