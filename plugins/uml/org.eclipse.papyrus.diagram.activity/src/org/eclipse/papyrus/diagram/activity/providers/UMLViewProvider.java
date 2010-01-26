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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
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
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

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
		 * if (op.getViewKind() == Node.class)
		 * return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 * if (op.getViewKind() == Edge.class)
		 * return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
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
	 * @generated NOT case ActivityAsTransformationEditPart
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
				case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case ActivityAsSelectionEditPart.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				/*
				 * ActivityAsTransformationEditPart can not be distinguished from ActivityAsSelectionEditPart, since it can sometime be both at the
				 * same time.
				 * This leads to getting ActivityAsSelectionEditPart.VISUAL_ID as result instead of ActivityAsTransformationEditPart.VISUAL_ID
				 */
				case ActivityAsTransformationEditPart.VISUAL_ID:
					if(domainElement == null || ActivityAsSelectionEditPart.VISUAL_ID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return ActivityEditPart.VISUAL_ID == visualID || ParameterEditPart.VISUAL_ID == visualID || ConstraintInActivityAsPrecondEditPart.VISUAL_ID == visualID || ConstraintInActivityAsPostcondEditPart.VISUAL_ID == visualID || InitialNodeEditPart.VISUAL_ID == visualID || ActivityFinalNodeEditPart.VISUAL_ID == visualID || FlowFinalNodeEditPart.VISUAL_ID == visualID || OpaqueActionEditPart.VISUAL_ID == visualID || ValuePinInOpaqueActEditPart.VISUAL_ID == visualID || ActionInputPinInOpaqueActEditPart.VISUAL_ID == visualID || InputPinInOpaqueActEditPart.VISUAL_ID == visualID || OutputPinInOpaqueActEditPart.VISUAL_ID == visualID || CallBehaviorActionEditPart.VISUAL_ID == visualID || ValuePinInCallBeActEditPart.VISUAL_ID == visualID || ActionInputPinInCallBeActEditPart.VISUAL_ID == visualID || InputPinInCallBeActEditPart.VISUAL_ID == visualID || OutputPinInCallBeActEditPart.VISUAL_ID == visualID || CallOperationActionEditPart.VISUAL_ID == visualID || ActionInputPinInCallOpActEditPart.VISUAL_ID == visualID || ValuePinInCallOpActEditPart.VISUAL_ID == visualID || InputPinInCallOpActEditPart.VISUAL_ID == visualID || OutputPinInCallOpActEditPart.VISUAL_ID == visualID || ValuePinInCallOpActAsTargetEditPart.VISUAL_ID == visualID || ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID == visualID || InputPinInCallOpActAsTargetEditPart.VISUAL_ID == visualID || ConstraintAsLocalPrecondEditPart.VISUAL_ID == visualID || ConstraintAsLocalPostcondEditPart.VISUAL_ID == visualID || ActivityAsSelectionEditPart.VISUAL_ID == visualID || ActivityAsTransformationEditPart.VISUAL_ID == visualID;
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
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
			return createConstraint_3011(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
			return createConstraint_3012(domainElement, containerView, index, persisted, preferencesHint);
		case ActivityAsSelectionEditPart.VISUAL_ID:
			return createActivity_3028(domainElement, containerView, index, persisted, preferencesHint);
		case ActivityAsTransformationEditPart.VISUAL_ID:
			return createActivity_3029(domainElement, containerView, index, persisted, preferencesHint);
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
		case ObjectFlowSelectionEditPart.VISUAL_ID:
			return createObjectFlowSelection_4005(containerView, index, persisted, preferencesHint);
		case ObjectFlowTransformationEditPart.VISUAL_ID:
			return createObjectFlowTransformation_4006(containerView, index, persisted, preferencesHint);
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
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initBackgroundFromPrefs(node, prefStore, "InitialNode");

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
	 * @generated
	 */
	public Node createOpaqueAction_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "OpaqueAction");



		initBackgroundFromPrefs(node, prefStore, "OpaqueAction");

		Node label5003 = createLabel(node, UMLVisualIDRegistry.getType(OpaqueActionNameEditPart.VISUAL_ID));
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
	 * @generated
	 */
	public Node createCallBehaviorAction_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CallBehaviorActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "CallBehaviorAction");



		initBackgroundFromPrefs(node, prefStore, "CallBehaviorAction");

		Node label5004 = createLabel(node, UMLVisualIDRegistry.getType(CallBehaviorActionNameEditPart.VISUAL_ID));
		return node;
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
	 * @generated
	 */
	public Node createCallOperationAction_3010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CallOperationActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "CallOperationAction");



		initBackgroundFromPrefs(node, prefStore, "CallOperationAction");

		Node label5006 = createLabel(node, UMLVisualIDRegistry.getType(CallOperationActionNameEditPart.VISUAL_ID));
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
	public Node createActivity_3028(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityAsSelectionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "Activity");

		Node label5032 = createLabel(node, UMLVisualIDRegistry.getType(ActivityAsSelectionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActivity_3029(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityAsTransformationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();


		initForegroundFromPrefs(node, prefStore, "Activity");

		Node label5033 = createLabel(node, UMLVisualIDRegistry.getType(ActivityAsTransformationNameEditPart.VISUAL_ID));
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

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createObjectFlowSelection_4005(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ObjectFlowSelectionEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();



		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if(routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createObjectFlowTransformation_4006(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ObjectFlowTransformationEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();



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
