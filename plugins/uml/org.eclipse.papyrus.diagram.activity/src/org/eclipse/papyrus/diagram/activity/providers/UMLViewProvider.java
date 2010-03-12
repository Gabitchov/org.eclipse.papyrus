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
package org.eclipse.papyrus.diagram.activity.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.diagram.activity.locator.PinPositionLocator;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ValuePin;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractProvider implements IViewProvider {

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation)operation);
		}
		assert operation instanceof CreateViewOperation;
		if(operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation)operation);
		} else if(operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation)operation);
		} else if(operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation)operation);
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		/*
		 if (op.getViewKind() == Node.class)
		 return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 if (op.getViewKind() == Edge.class)
		 return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 */
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return ActivityDiagramEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateNodeViewOperation op) {
		if(op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if(op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if(elementType != null || domainElement == null) {
				return false;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
			if(elementType != null) {
				if(!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
				if(!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if(domainElement != null && visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if(!ActivityDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch(visualID) {
				case ActivityEditPart.VISUAL_ID:
				case ParameterEditPart.VISUAL_ID:
				case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
				case InitialNodeEditPart.VISUAL_ID:
				case ActivityFinalNodeEditPart.VISUAL_ID:
				case FlowFinalNodeEditPart.VISUAL_ID:
				case OpaqueActionEditPart.VISUAL_ID:
				case ValuePinInOpaqueActEditPart.VISUAL_ID:
				case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
				case InputPinInOpaqueActEditPart.VISUAL_ID:
				case OutputPinInOpaqueActEditPart.VISUAL_ID:
				case CallBehaviorActionEditPart.VISUAL_ID:
				case CallOperationActionEditPart.VISUAL_ID:
				case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case DecisionNodeEditPart.VISUAL_ID:
				case MergeNodeEditPart.VISUAL_ID:
				case ForkNodeEditPart.VISUAL_ID:
				case JoinNodeEditPart.VISUAL_ID:
				case SendObjectActionEditPart.VISUAL_ID:
				case SendSignalActionEditPart.VISUAL_ID:
				case ActivityParameterNodeEditPart.VISUAL_ID:
				case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
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
				case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
				case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
				case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
				case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
				case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
				case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
				case ActionInputPinInSendSigActEditPart.VISUAL_ID:
				case ValuePinInSendSigActEditPart.VISUAL_ID:
				case InputPinInSendSigActEditPart.VISUAL_ID:
				case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
				case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
				case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return ActivityEditPart.VISUAL_ID == visualID || ParameterEditPart.VISUAL_ID == visualID || ConstraintInActivityAsPrecondEditPart.VISUAL_ID == visualID || ConstraintInActivityAsPostcondEditPart.VISUAL_ID == visualID || InitialNodeEditPart.VISUAL_ID == visualID || ActivityFinalNodeEditPart.VISUAL_ID == visualID || FlowFinalNodeEditPart.VISUAL_ID == visualID || OpaqueActionEditPart.VISUAL_ID == visualID || ValuePinInOpaqueActEditPart.VISUAL_ID == visualID || ActionInputPinInOpaqueActEditPart.VISUAL_ID == visualID || InputPinInOpaqueActEditPart.VISUAL_ID == visualID || OutputPinInOpaqueActEditPart.VISUAL_ID == visualID || CallBehaviorActionEditPart.VISUAL_ID == visualID || ValuePinInCallBeActEditPart.VISUAL_ID == visualID || ActionInputPinInCallBeActEditPart.VISUAL_ID == visualID || InputPinInCallBeActEditPart.VISUAL_ID == visualID || OutputPinInCallBeActEditPart.VISUAL_ID == visualID || CallOperationActionEditPart.VISUAL_ID == visualID || ActionInputPinInCallOpActEditPart.VISUAL_ID == visualID || ValuePinInCallOpActEditPart.VISUAL_ID == visualID || InputPinInCallOpActEditPart.VISUAL_ID == visualID || OutputPinInCallOpActEditPart.VISUAL_ID == visualID || ValuePinInCallOpActAsTargetEditPart.VISUAL_ID == visualID || ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID == visualID || InputPinInCallOpActAsTargetEditPart.VISUAL_ID == visualID || DurationConstraintAsLocalPrecondEditPart.VISUAL_ID == visualID || DurationConstraintAsLocalPostcondEditPart.VISUAL_ID == visualID || TimeConstraintAsLocalPrecondEditPart.VISUAL_ID == visualID || TimeConstraintAsLocalPostcondEditPart.VISUAL_ID == visualID || InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID == visualID || InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID == visualID || IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID == visualID || IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID == visualID || ConstraintAsLocalPrecondEditPart.VISUAL_ID == visualID || ConstraintAsLocalPostcondEditPart.VISUAL_ID == visualID || DecisionNodeEditPart.VISUAL_ID == visualID || MergeNodeEditPart.VISUAL_ID == visualID || ForkNodeEditPart.VISUAL_ID == visualID || JoinNodeEditPart.VISUAL_ID == visualID || SendObjectActionEditPart.VISUAL_ID == visualID || ValuePinInSendObjActAsReqEditPart.VISUAL_ID == visualID || ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID == visualID || InputPinInSendObjActAsReqEditPart.VISUAL_ID == visualID || ValuePinInSendObjActAsTargetEditPart.VISUAL_ID == visualID || ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID == visualID || InputPinInSendObjActAsTargetEditPart.VISUAL_ID == visualID || SendSignalActionEditPart.VISUAL_ID == visualID || ActionInputPinInSendSigActEditPart.VISUAL_ID == visualID || ValuePinInSendSigActEditPart.VISUAL_ID == visualID || InputPinInSendSigActEditPart.VISUAL_ID == visualID || ValuePinInSendSigActAsTargetEditPart.VISUAL_ID == visualID || ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID == visualID || InputPinInSendSigActAsTargetEditPart.VISUAL_ID == visualID || ActivityParameterNodeEditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		if(elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if(domainElement != null && visualID != UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true;
	}

	/**
	 * @generated
	 */
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		diagram.setType(ActivityDiagramEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	 * @generated
	 */
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if(semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch(visualID) {
		case ActivityEditPart.VISUAL_ID:
			return createActivity_2001(domainElement, containerView, index, persisted, preferencesHint);
		case ParameterEditPart.VISUAL_ID:
			return createParameter_3001(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
			return createConstraint_3002(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
			return createConstraint_3003(domainElement, containerView, index, persisted, preferencesHint);
		case InitialNodeEditPart.VISUAL_ID:
			return createInitialNode_3004(domainElement, containerView, index, persisted, preferencesHint);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return createActivityFinalNode_3005(domainElement, containerView, index, persisted, preferencesHint);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return createFlowFinalNode_3006(domainElement, containerView, index, persisted, preferencesHint);
		case OpaqueActionEditPart.VISUAL_ID:
			return createOpaqueAction_3007(domainElement, containerView, index, persisted, preferencesHint);
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
			return createValuePin_3015(domainElement, containerView, index, persisted, preferencesHint);
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
			return createActionInputPin_3016(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInOpaqueActEditPart.VISUAL_ID:
			return createInputPin_3013(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
			return createOutputPin_3014(domainElement, containerView, index, persisted, preferencesHint);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return createCallBehaviorAction_3008(domainElement, containerView, index, persisted, preferencesHint);
		case ValuePinInCallBeActEditPart.VISUAL_ID:
			return createValuePin_3017(domainElement, containerView, index, persisted, preferencesHint);
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
			return createActionInputPin_3018(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInCallBeActEditPart.VISUAL_ID:
			return createInputPin_3019(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInCallBeActEditPart.VISUAL_ID:
			return createOutputPin_3020(domainElement, containerView, index, persisted, preferencesHint);
		case CallOperationActionEditPart.VISUAL_ID:
			return createCallOperationAction_3010(domainElement, containerView, index, persisted, preferencesHint);
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
			return createActionInputPin_3021(domainElement, containerView, index, persisted, preferencesHint);
		case ValuePinInCallOpActEditPart.VISUAL_ID:
			return createValuePin_3022(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInCallOpActEditPart.VISUAL_ID:
			return createInputPin_3023(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return createOutputPin_3024(domainElement, containerView, index, persisted, preferencesHint);
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
			return createValuePin_3025(domainElement, containerView, index, persisted, preferencesHint);
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return createActionInputPin_3026(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
			return createInputPin_3027(domainElement, containerView, index, persisted, preferencesHint);
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return createDurationConstraint_3034(domainElement, containerView, index, persisted, preferencesHint);
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return createDurationConstraint_3035(domainElement, containerView, index, persisted, preferencesHint);
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return createTimeConstraint_3036(domainElement, containerView, index, persisted, preferencesHint);
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return createTimeConstraint_3037(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return createInteractionConstraint_3030(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return createInteractionConstraint_3031(domainElement, containerView, index, persisted, preferencesHint);
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return createIntervalConstraint_3032(domainElement, containerView, index, persisted, preferencesHint);
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return createIntervalConstraint_3033(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return createConstraint_3011(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return createConstraint_3012(domainElement, containerView, index, persisted, preferencesHint);
		case DecisionNodeEditPart.VISUAL_ID:
			return createDecisionNode_3038(domainElement, containerView, index, persisted, preferencesHint);
		case MergeNodeEditPart.VISUAL_ID:
			return createMergeNode_3039(domainElement, containerView, index, persisted, preferencesHint);
		case ForkNodeEditPart.VISUAL_ID:
			return createForkNode_3040(domainElement, containerView, index, persisted, preferencesHint);
		case JoinNodeEditPart.VISUAL_ID:
			return createJoinNode_3041(domainElement, containerView, index, persisted, preferencesHint);
		case SendObjectActionEditPart.VISUAL_ID:
			return createSendObjectAction_3042(domainElement, containerView, index, persisted, preferencesHint);
		case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
			return createValuePin_3046(domainElement, containerView, index, persisted, preferencesHint);
		case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return createActionInputPin_3047(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
			return createInputPin_3048(domainElement, containerView, index, persisted, preferencesHint);
		case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
			return createValuePin_3049(domainElement, containerView, index, persisted, preferencesHint);
		case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return createActionInputPin_3050(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
			return createInputPin_3051(domainElement, containerView, index, persisted, preferencesHint);
		case SendSignalActionEditPart.VISUAL_ID:
			return createSendSignalAction_3052(domainElement, containerView, index, persisted, preferencesHint);
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
			return createActionInputPin_3053(domainElement, containerView, index, persisted, preferencesHint);
		case ValuePinInSendSigActEditPart.VISUAL_ID:
			return createValuePin_3054(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInSendSigActEditPart.VISUAL_ID:
			return createInputPin_3055(domainElement, containerView, index, persisted, preferencesHint);
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
			return createValuePin_3060(domainElement, containerView, index, persisted, preferencesHint);
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return createActionInputPin_3061(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			return createInputPin_3062(domainElement, containerView, index, persisted, preferencesHint);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return createActivityParameterNode_3059(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		switch(UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return createActionLocalPrecondition_4001(containerView, index, persisted, preferencesHint);
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return createActionLocalPostcondition_4002(containerView, index, persisted, preferencesHint);
		case ObjectFlowEditPart.VISUAL_ID:
			return createObjectFlow_4003(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ControlFlowEditPart.VISUAL_ID:
			return createControlFlow_4004(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createActivity_2001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "Activity");


		initFontStyleFromPrefs(node, prefStore, "Activity");



		initBackgroundFromPrefs(node, prefStore, "Activity");

		Node label5001 = createLabel(node, UMLVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID));
		Node label5002 = createLabel(node, UMLVisualIDRegistry.getType(ActivityIsSingleExecutionEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityActivityParametersCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createParameter_3001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ConstraintInActivityAsPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ConstraintInActivityAsPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInitialNode_3004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InitialNode");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createActivityFinalNode_3005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initBackgroundFromPrefs(node, prefStore, "ActivityFinalNode");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createFlowFinalNode_3006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(FlowFinalNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "FlowFinalNode");



		initBackgroundFromPrefs(node, prefStore, "FlowFinalNode");

		return node;
	}

	/**
	 * @generated NOT addition of pins initialization and height adaptation to pins
	 */
	public Node createOpaqueAction_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		// adapt the height to contained pins
		Bounds boundsConstraint = NotationFactory.eINSTANCE.createBounds();
		PinPositionLocator.adaptActionHeight(boundsConstraint, domainElement);
		node.setLayoutConstraint(boundsConstraint);
		node.setType(UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "OpaqueAction");

		initBackgroundFromPrefs(node, prefStore, "OpaqueAction");

		Node label5003 = createLabel(node, UMLVisualIDRegistry.getType(OpaqueActionNameEditPart.VISUAL_ID));
		// Add pins
		createPins(domainElement, node, persisted, preferencesHint);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createValuePin_3015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValuePinInOpaqueActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ValuePin");



		initBackgroundFromPrefs(node, prefStore, "ValuePin");

		Node label5011 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInOActLabelEditPart.VISUAL_ID));
		label5011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5011 = (Location)label5011.getLayoutConstraint();
		location5011.setX(0);
		location5011.setY(5);
		Node label5024 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInOActValueEditPart.VISUAL_ID));
		label5024.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5024 = (Location)label5024.getLayoutConstraint();
		location5024.setX(0);
		location5024.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionInputPin_3016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionInputPinInOpaqueActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActionInputPin");



		initBackgroundFromPrefs(node, prefStore, "ActionInputPin");

		Node label5012 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInOActLabelEditPart.VISUAL_ID));
		label5012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5012 = (Location)label5012.getLayoutConstraint();
		location5012.setX(0);
		location5012.setY(5);
		Node label5025 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInOActValueEditPart.VISUAL_ID));
		label5025.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5025 = (Location)label5025.getLayoutConstraint();
		location5025.setX(0);
		location5025.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInOpaqueActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InputPin");



		initBackgroundFromPrefs(node, prefStore, "InputPin");

		Node label5009 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInOActLabelEditPart.VISUAL_ID));
		label5009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5009 = (Location)label5009.getLayoutConstraint();
		location5009.setX(0);
		location5009.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInOpaqueActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "OutputPin");



		initBackgroundFromPrefs(node, prefStore, "OutputPin");

		Node label5010 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInOActLabelEditPart.VISUAL_ID));
		label5010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5010 = (Location)label5010.getLayoutConstraint();
		location5010.setX(0);
		location5010.setY(5);
		return node;
	}

	/**
	 * @generated NOT addition of pins initialization and height adaptation to pins
	 */
	public Node createCallBehaviorAction_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		// adapt the height to contained pins
		Bounds boundsConstraint = NotationFactory.eINSTANCE.createBounds();
		PinPositionLocator.adaptActionHeight(boundsConstraint, domainElement);
		node.setLayoutConstraint(boundsConstraint);
		node.setType(UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "CallBehaviorAction");

		initBackgroundFromPrefs(node, prefStore, "CallBehaviorAction");

		Node label5004 = createLabel(node, UMLVisualIDRegistry.getType(CallBehaviorActionNameEditPart.VISUAL_ID));
		// Add pins
		createPins(domainElement, node, persisted, preferencesHint);
		return node;
	}

	/**
	 * Create pins in an action's node
	 * 
	 * @param domainElement
	 *        the model action
	 * @param node
	 *        the action node
	 * @param persisted
	 *        the persisted property of views to create
	 * @param preferencesHint
	 *        the preference hint
	 * @generated NOT
	 */
	private void createPins(EObject domainElement, Shape node, boolean persisted, PreferencesHint preferencesHint) {
		if(domainElement instanceof OpaqueAction) {
			// pins of an opaque action : input values and output values
			int index = 0;
			for(InputPin pin : ((OpaqueAction)domainElement).getInputValues()) {
				if(pin instanceof ValuePin) {
					createValuePin_3015(pin, node, index, persisted, preferencesHint);
				} else if(pin instanceof ActionInputPin) {
					createActionInputPin_3016(pin, node, index, persisted, preferencesHint);
				} else {
					createInputPin_3013(pin, node, index, persisted, preferencesHint);
				}
				index++;
			}
			index = 0;
			for(OutputPin pin : ((OpaqueAction)domainElement).getOutputValues()) {
				createOutputPin_3014(pin, node, index, persisted, preferencesHint);
			}
		} else if(domainElement instanceof CallBehaviorAction) {
			// pins of a call behavior action : arguments and results
			int index = 0;
			for(InputPin pin : ((CallBehaviorAction)domainElement).getArguments()) {
				if(pin instanceof ValuePin) {
					createValuePin_3017(pin, node, index, persisted, preferencesHint);
				} else if(pin instanceof ActionInputPin) {
					createActionInputPin_3018(pin, node, index, persisted, preferencesHint);
				} else {
					createInputPin_3019(pin, node, index, persisted, preferencesHint);
				}
				index++;
			}
			index = 0;
			for(OutputPin pin : ((CallBehaviorAction)domainElement).getResults()) {
				createOutputPin_3020(pin, node, index, persisted, preferencesHint);
			}
		} else if(domainElement instanceof CallOperationAction) {
			// pins of a call operation action : arguments, target and results
			int index = 0;
			for(InputPin pin : ((CallOperationAction)domainElement).getArguments()) {
				if(pin instanceof ValuePin) {
					createValuePin_3022(pin, node, index, persisted, preferencesHint);
				} else if(pin instanceof ActionInputPin) {
					createActionInputPin_3021(pin, node, index, persisted, preferencesHint);
				} else {
					createInputPin_3023(pin, node, index, persisted, preferencesHint);
				}
				index++;
			}
			InputPin target = ((CallOperationAction)domainElement).getTarget();
			if(target instanceof ValuePin) {
				createValuePin_3025(target, node, index, persisted, preferencesHint);
			} else if(target instanceof ActionInputPin) {
				createActionInputPin_3026(target, node, index, persisted, preferencesHint);
			} else if(target != null) {
				createInputPin_3027(target, node, index, persisted, preferencesHint);
			}
			index = 0;
			for(OutputPin pin : ((CallOperationAction)domainElement).getResults()) {
				createOutputPin_3024(pin, node, index, persisted, preferencesHint);
			}
		}
	}

	/**
	 * @generated
	 */
	public Node createValuePin_3017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValuePinInCallBeActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ValuePin");



		initBackgroundFromPrefs(node, prefStore, "ValuePin");

		Node label5013 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCBActLabelEditPart.VISUAL_ID));
		label5013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5013 = (Location)label5013.getLayoutConstraint();
		location5013.setX(0);
		location5013.setY(5);
		Node label5026 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCBActValueEditPart.VISUAL_ID));
		label5026.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5026 = (Location)label5026.getLayoutConstraint();
		location5026.setX(0);
		location5026.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionInputPin_3018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionInputPinInCallBeActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActionInputPin");



		initBackgroundFromPrefs(node, prefStore, "ActionInputPin");

		Node label5014 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCBActLabelEditPart.VISUAL_ID));
		label5014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5014 = (Location)label5014.getLayoutConstraint();
		location5014.setX(0);
		location5014.setY(5);
		Node label5027 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCBActValueEditPart.VISUAL_ID));
		label5027.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5027 = (Location)label5027.getLayoutConstraint();
		location5027.setX(0);
		location5027.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInCallBeActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InputPin");



		initBackgroundFromPrefs(node, prefStore, "InputPin");

		Node label5015 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCBActLabelEditPart.VISUAL_ID));
		label5015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5015 = (Location)label5015.getLayoutConstraint();
		location5015.setX(0);
		location5015.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3020(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInCallBeActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "OutputPin");



		initBackgroundFromPrefs(node, prefStore, "OutputPin");

		Node label5016 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInCBActLabelEditPart.VISUAL_ID));
		label5016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5016 = (Location)label5016.getLayoutConstraint();
		location5016.setX(0);
		location5016.setY(5);
		return node;
	}

	/**
	 * @generated NOT addition of pins initialization and height adaptation to pins
	 */
	public Node createCallOperationAction_3010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		// adapt the height to contained pins
		Bounds boundsConstraint = NotationFactory.eINSTANCE.createBounds();
		PinPositionLocator.adaptActionHeight(boundsConstraint, domainElement);
		node.setLayoutConstraint(boundsConstraint);
		node.setType(UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "CallOperationAction");

		initBackgroundFromPrefs(node, prefStore, "CallOperationAction");

		Node label5006 = createLabel(node, UMLVisualIDRegistry.getType(CallOperationActionNameEditPart.VISUAL_ID));
		// Add pins
		createPins(domainElement, node, persisted, preferencesHint);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionInputPin_3021(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionInputPinInCallOpActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActionInputPin");



		initBackgroundFromPrefs(node, prefStore, "ActionInputPin");

		Node label5017 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCOActLabelEditPart.VISUAL_ID));
		label5017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5017 = (Location)label5017.getLayoutConstraint();
		location5017.setX(0);
		location5017.setY(5);
		Node label5028 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCOActValueEditPart.VISUAL_ID));
		label5028.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5028 = (Location)label5028.getLayoutConstraint();
		location5028.setX(0);
		location5028.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createValuePin_3022(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValuePinInCallOpActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ValuePin");



		initBackgroundFromPrefs(node, prefStore, "ValuePin");

		Node label5018 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCOActLabelEditPart.VISUAL_ID));
		label5018.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5018 = (Location)label5018.getLayoutConstraint();
		location5018.setX(0);
		location5018.setY(5);
		Node label5029 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCOActValueEditPart.VISUAL_ID));
		label5029.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5029 = (Location)label5029.getLayoutConstraint();
		location5029.setX(0);
		location5029.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3023(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInCallOpActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InputPin");



		initBackgroundFromPrefs(node, prefStore, "InputPin");

		Node label5019 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCOActLabelEditPart.VISUAL_ID));
		label5019.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5019 = (Location)label5019.getLayoutConstraint();
		location5019.setX(0);
		location5019.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3024(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInCallOpActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "OutputPin");



		initBackgroundFromPrefs(node, prefStore, "OutputPin");

		Node label5020 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInCOActLabelEditPart.VISUAL_ID));
		label5020.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5020 = (Location)label5020.getLayoutConstraint();
		location5020.setX(0);
		location5020.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createValuePin_3025(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValuePinInCallOpActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ValuePin");



		initBackgroundFromPrefs(node, prefStore, "ValuePin");

		Node label5021 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCOActAsTargetLabelEditPart.VISUAL_ID));
		label5021.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5021 = (Location)label5021.getLayoutConstraint();
		location5021.setX(0);
		location5021.setY(5);
		Node label5030 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCOActAsTargetValueEditPart.VISUAL_ID));
		label5030.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5030 = (Location)label5030.getLayoutConstraint();
		location5030.setX(0);
		location5030.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionInputPin_3026(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActionInputPin");



		initBackgroundFromPrefs(node, prefStore, "ActionInputPin");

		Node label5022 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCOActAsTargetLabelEditPart.VISUAL_ID));
		label5022.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5022 = (Location)label5022.getLayoutConstraint();
		location5022.setX(0);
		location5022.setY(5);
		Node label5031 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCOActAsTargetValueEditPart.VISUAL_ID));
		label5031.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5031 = (Location)label5031.getLayoutConstraint();
		location5031.setX(0);
		location5031.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3027(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInCallOpActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InputPin");



		initBackgroundFromPrefs(node, prefStore, "InputPin");

		Node label5023 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCOActAsTargetLabelEditPart.VISUAL_ID));
		label5023.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5023 = (Location)label5023.getLayoutConstraint();
		location5023.setX(0);
		location5023.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "Constraint");

		Node label5007 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "Constraint");

		Node label5008 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDecisionNode_3038(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DecisionNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "DecisionNode");



		initBackgroundFromPrefs(node, prefStore, "DecisionNode");

		Node label5043 = createLabel(node, UMLVisualIDRegistry.getType(DecisionInputEditPart.VISUAL_ID));
		label5043.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5043 = (Location)label5043.getLayoutConstraint();
		location5043.setX(0);
		location5043.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createMergeNode_3039(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(MergeNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "MergeNode");



		initBackgroundFromPrefs(node, prefStore, "MergeNode");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createForkNode_3040(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ForkNode");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createJoinNode_3041(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "JoinNode");

		Node label5042 = createLabel(node, UMLVisualIDRegistry.getType(JoinSpecEditPart.VISUAL_ID));
		label5042.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5042 = (Location)label5042.getLayoutConstraint();
		location5042.setX(0);
		location5042.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSendObjectAction_3042(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SendObjectActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "SendObjectAction");



		initBackgroundFromPrefs(node, prefStore, "SendObjectAction");

		Node label5059 = createLabel(node, UMLVisualIDRegistry.getType(SendObjectActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createValuePin_3046(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ValuePin");



		initBackgroundFromPrefs(node, prefStore, "ValuePin");

		Node label5049 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqLabelEditPart.VISUAL_ID));
		label5049.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5049 = (Location)label5049.getLayoutConstraint();
		location5049.setX(0);
		location5049.setY(5);
		Node label5050 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqValueEditPart.VISUAL_ID));
		label5050.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5050 = (Location)label5050.getLayoutConstraint();
		location5050.setX(0);
		location5050.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionInputPin_3047(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActionInputPin");



		initBackgroundFromPrefs(node, prefStore, "ActionInputPin");

		Node label5051 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqLabelEditPart.VISUAL_ID));
		label5051.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5051 = (Location)label5051.getLayoutConstraint();
		location5051.setX(0);
		location5051.setY(5);
		Node label5052 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqValueEditPart.VISUAL_ID));
		label5052.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5052 = (Location)label5052.getLayoutConstraint();
		location5052.setX(0);
		location5052.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3048(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InputPin");



		initBackgroundFromPrefs(node, prefStore, "InputPin");

		Node label5053 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqLabelEditPart.VISUAL_ID));
		label5053.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5053 = (Location)label5053.getLayoutConstraint();
		location5053.setX(0);
		location5053.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createValuePin_3049(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ValuePin");



		initBackgroundFromPrefs(node, prefStore, "ValuePin");

		Node label5054 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetLabelEditPart.VISUAL_ID));
		label5054.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5054 = (Location)label5054.getLayoutConstraint();
		location5054.setX(0);
		location5054.setY(5);
		Node label5055 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetValueEditPart.VISUAL_ID));
		label5055.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5055 = (Location)label5055.getLayoutConstraint();
		location5055.setX(0);
		location5055.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionInputPin_3050(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActionInputPin");



		initBackgroundFromPrefs(node, prefStore, "ActionInputPin");

		Node label5056 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID));
		label5056.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5056 = (Location)label5056.getLayoutConstraint();
		location5056.setX(0);
		location5056.setY(5);
		Node label5057 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetValueEditPart.VISUAL_ID));
		label5057.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5057 = (Location)label5057.getLayoutConstraint();
		location5057.setX(0);
		location5057.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3051(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InputPin");



		initBackgroundFromPrefs(node, prefStore, "InputPin");

		Node label5058 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID));
		label5058.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5058 = (Location)label5058.getLayoutConstraint();
		location5058.setX(0);
		location5058.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSendSignalAction_3052(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SendSignalActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "SendSignalAction");



		initBackgroundFromPrefs(node, prefStore, "SendSignalAction");

		Node label5060 = createLabel(node, UMLVisualIDRegistry.getType(SendSignalActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionInputPin_3053(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionInputPinInSendSigActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActionInputPin");



		initBackgroundFromPrefs(node, prefStore, "ActionInputPin");

		Node label5061 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendSigActLabelEditPart.VISUAL_ID));
		label5061.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5061 = (Location)label5061.getLayoutConstraint();
		location5061.setX(0);
		location5061.setY(5);
		Node label5062 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendSigActValueEditPart.VISUAL_ID));
		label5062.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5062 = (Location)label5062.getLayoutConstraint();
		location5062.setX(0);
		location5062.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createValuePin_3054(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValuePinInSendSigActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ValuePin");



		initBackgroundFromPrefs(node, prefStore, "ValuePin");

		Node label5063 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendSigActLabelEditPart.VISUAL_ID));
		label5063.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5063 = (Location)label5063.getLayoutConstraint();
		location5063.setX(0);
		location5063.setY(5);
		Node label5064 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendSigActValueEditPart.VISUAL_ID));
		label5064.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5064 = (Location)label5064.getLayoutConstraint();
		location5064.setX(0);
		location5064.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3055(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInSendSigActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InputPin");



		initBackgroundFromPrefs(node, prefStore, "InputPin");

		Node label5065 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendSigActLabelEditPart.VISUAL_ID));
		label5065.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5065 = (Location)label5065.getLayoutConstraint();
		location5065.setX(0);
		location5065.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createValuePin_3060(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ValuePin");



		initBackgroundFromPrefs(node, prefStore, "ValuePin");

		Node label5072 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetLabelEditPart.VISUAL_ID));
		label5072.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5072 = (Location)label5072.getLayoutConstraint();
		location5072.setX(0);
		location5072.setY(5);
		Node label5073 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetValueEditPart.VISUAL_ID));
		label5073.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5073 = (Location)label5073.getLayoutConstraint();
		location5073.setX(0);
		location5073.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionInputPin_3061(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActionInputPin");



		initBackgroundFromPrefs(node, prefStore, "ActionInputPin");

		Node label5074 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID));
		label5074.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5074 = (Location)label5074.getLayoutConstraint();
		location5074.setX(0);
		location5074.setY(5);
		Node label5075 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetValueEditPart.VISUAL_ID));
		label5075.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5075 = (Location)label5075.getLayoutConstraint();
		location5075.setX(0);
		location5075.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3062(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InputPin");



		initBackgroundFromPrefs(node, prefStore, "InputPin");

		Node label5076 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID));
		label5076.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5076 = (Location)label5076.getLayoutConstraint();
		location5076.setX(0);
		location5076.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActivityParameterNode_3059(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityParameterNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "ActivityParameterNode");



		initBackgroundFromPrefs(node, prefStore, "ActivityParameterNode");

		Node label5071 = createLabel(node, UMLVisualIDRegistry.getType(CenteredWrappedLabelEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteractionConstraint_3030(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InteractionConstraint");

		Node label5034 = createLabel(node, UMLVisualIDRegistry.getType(InteractionConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteractionConstraint_3031(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "InteractionConstraint");

		Node label5035 = createLabel(node, UMLVisualIDRegistry.getType(InteractionConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createIntervalConstraint_3032(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "IntervalConstraint");

		Node label5036 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createIntervalConstraint_3033(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "IntervalConstraint");

		Node label5037 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationConstraint_3034(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "DurationConstraint");

		Node label5038 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationConstraint_3035(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "DurationConstraint");

		Node label5039 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeConstraint_3036(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "TimeConstraint");

		Node label5040 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeConstraint_3037(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "TimeConstraint");

		Node label5041 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createActionLocalPrecondition_4001(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(edge, prefStore, "Undefined");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createActionLocalPostcondition_4002(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(edge, prefStore, "Undefined");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createObjectFlow_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(edge, prefStore, "ObjectFlow");


		initFontStyleFromPrefs(edge, prefStore, "ObjectFlow");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6001 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowNameEditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location)label6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(40);
		Node label6002 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowWeightEditPart.VISUAL_ID));
		label6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location)label6002.getLayoutConstraint();
		location6002.setX(0);
		location6002.setY(60);
		Node label6005 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowSelectionEditPart.VISUAL_ID));
		label6005.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6005 = (Location)label6005.getLayoutConstraint();
		location6005.setX(0);
		location6005.setY(80);
		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowTransformationEditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location)label6006.getLayoutConstraint();
		location6006.setX(0);
		location6006.setY(100);
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(DecisionInputFlowEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location)label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(120);
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowGuardEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location)label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(140);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createControlFlow_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(edge, prefStore, "ControlFlow");


		initFontStyleFromPrefs(edge, prefStore, "ControlFlow");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6003 = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowNameEditPart.VISUAL_ID));
		label6003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6003 = (Location)label6003.getLayoutConstraint();
		location6003.setX(0);
		location6003.setY(40);
		Node label6004 = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowWeightEditPart.VISUAL_ID));
		label6004.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6004 = (Location)label6004.getLayoutConstraint();
		location6004.setX(0);
		location6004.setY(60);
		Node label6009 = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowGuardEditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6009 = (Location)label6009.getLayoutConstraint();
		location6009.setX(0);
		location6009.setY(80);
		return edge;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
		if(!ActivityDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ActivityDiagramEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	 * @generated
	 */
	private Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		Node rv;
		if(canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		rv.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());

		if(hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			ts.setShowTitle(true);
			rv.getStyles().add(ts);
		}
		if(canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if(canFilter) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		}
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private EObject getSemanticElement(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject)semanticAdapter.getAdapter(EObject.class);
		if(eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		return (IElementType)semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fontConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.FONT);
		String fontColorConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_FONT);

		FontStyle viewFontStyle = (FontStyle)view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if(viewFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(store, fontConstant);
			viewFontStyle.setFontName(fontData.getName());
			viewFontStyle.setFontHeight(fontData.getHeight());
			viewFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			viewFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);

			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(store, fontColorConstant);
			viewFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	}

	/**
	 * @generated
	 */
	private void initForegroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String lineColorConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

	/**
	 * @generated
	 */
	private void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fillColorConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_FILL);
		String gradientColorConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.GRADIENT_POLICY);


		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));


		FillStyle fillStyle = (FillStyle)view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());

		;
		if(store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}

}
