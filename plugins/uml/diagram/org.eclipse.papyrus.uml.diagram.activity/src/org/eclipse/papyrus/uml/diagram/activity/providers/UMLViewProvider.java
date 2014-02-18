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
package org.eclipse.papyrus.uml.diagram.activity.providers;

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
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.activity.locator.PinPositionLocator;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
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
	public final boolean provides(IOperation operation) {
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
		// check Diagram Type should be the class diagram
		String modelID = UMLVisualIDRegistry.getModelID(op.getContainerView());
		if(!getDiagramProvidedId().equals(modelID)) {
			return false;
		}
		int visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
		if(Node.class.isAssignableFrom(op.getViewKind())) {
			return UMLVisualIDRegistry.canCreateNode(op.getContainerView(), visualID);
		}
		return true;
	}

	/**
	 * Indicates for which diagram this provider works for.
	 * <p>
	 * This method can be overloaded when diagram editor inherits from another one
	 * </p>
	 * 
	 * @return the unique identifier of the diagram for which views are provided.
	 */
	protected String getDiagramProvidedId() {
		return ActivityDiagramEditPart.MODEL_ID;
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
				if(elementType instanceof IExtendedHintedElementType) {
					IElementType closestNonExtendedType = ElementTypeUtils.getClosestDiagramType(elementType);
					if(!UMLElementTypes.isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof IHintedType))) {
						return false; // foreign element type.
					}
				} else {
					if(!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
						return false; // foreign element type
					}
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
				case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
				case InitialNodeEditPart.VISUAL_ID:
				case ActivityFinalNodeEditPart.VISUAL_ID:
				case FlowFinalNodeEditPart.VISUAL_ID:
				case OpaqueActionEditPart.VISUAL_ID:
				case ValuePinInOpaqueActEditPart.VISUAL_ID:
				case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
				case InputPinInOpaqueActEditPart.VISUAL_ID:
				case OutputPinInOpaqueActEditPart.VISUAL_ID:
				case CallBehaviorActionEditPart.VISUAL_ID:
				case ValuePinInCallBeActEditPart.VISUAL_ID:
				case ActionInputPinInCallBeActEditPart.VISUAL_ID:
				case InputPinInCallBeActEditPart.VISUAL_ID:
				case OutputPinInCallBeActEditPart.VISUAL_ID:
				case CallOperationActionEditPart.VISUAL_ID:
				case ActionInputPinInCallOpActEditPart.VISUAL_ID:
				case ValuePinInCallOpActEditPart.VISUAL_ID:
				case InputPinInCallOpActEditPart.VISUAL_ID:
				case OutputPinInCallOpActEditPart.VISUAL_ID:
				case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
				case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
				case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
				case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
				case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
				case DecisionNodeEditPart.VISUAL_ID:
				case MergeNodeEditPart.VISUAL_ID:
				case ForkNodeEditPart.VISUAL_ID:
				case JoinNodeEditPart.VISUAL_ID:
				case DataStoreNodeEditPart.VISUAL_ID:
				case SendObjectActionEditPart.VISUAL_ID:
				case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
				case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
				case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
				case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
				case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
				case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
				case SendSignalActionEditPart.VISUAL_ID:
				case ActionInputPinInSendSigActEditPart.VISUAL_ID:
				case ValuePinInSendSigActEditPart.VISUAL_ID:
				case InputPinInSendSigActEditPart.VISUAL_ID:
				case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
				case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
				case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
				case ActivityParameterNodeEditPart.VISUAL_ID:
				case AcceptEventActionEditPart.VISUAL_ID:
				case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
				case ValueSpecificationActionEditPart.VISUAL_ID:
				case OutputPinInValSpecActEditPart.VISUAL_ID:
				case ConditionalNodeEditPart.VISUAL_ID:
				case ExpansionRegionEditPart.VISUAL_ID:
				case ExpansionNodeAsInEditPart.VISUAL_ID:
				case ExpansionNodeAsOutEditPart.VISUAL_ID:
				case LoopNodeEditPart.VISUAL_ID:
				case OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID:
				case OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID:
				case OutputPinInLoopNodeAsResultEditPart.VISUAL_ID:
				case SequenceNodeEditPart.VISUAL_ID:
				case StructuredActivityNodeEditPart.VISUAL_ID:
				case InputPinInLoopNodeAsVariableEditPart.VISUAL_ID:
				case ActivityPartitionEditPart.VISUAL_ID:
				case InterruptibleActivityRegionEditPart.VISUAL_ID:
				case CommentEditPartCN.VISUAL_ID:
				case ReadSelfActionEditPart.VISUAL_ID:
				case ReadSelfActionOutputPinEditPart.VISUAL_ID:
				case ActivityEditPartCN.VISUAL_ID:
				case CreateObjectActionEditPart.VISUAL_ID:
				case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
				case ShapeNamedElementEditPart.VISUAL_ID:
				case ReadStructuralFeatureActionEditPart.VISUAL_ID:
				case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
				case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
				case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
				case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
				case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
				case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
				case DestroyObjectActionEditPart.VISUAL_ID:
				case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
				case ReadVariableActionEditPart.VISUAL_ID:
				case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
				case AddVariableValueActionEditPart.VISUAL_ID:
				case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
				case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
				case BroadcastSignalActionEditPart.VISUAL_ID:
				case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
				case CentralBufferNodeEditPart.VISUAL_ID:
				case ConstraintEditPartCN.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return UMLVisualIDRegistry.canCreateNode(op.getContainerView(), visualID);
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		//RS: add code for extended types creation
		if(elementType instanceof IExtendedHintedElementType) {
			IElementType closestNonExtendedType = ElementTypeUtils.getClosestDiagramType(elementType);
			if(!UMLElementTypes.isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof IHintedType))) {
				return false; // foreign element type.
			}
		} else {
			if(!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
				return false; // foreign element type
			}
		}
		//if (!org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
		//	return false; // foreign element type
		//}
		// END R.S.
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
		case DataStoreNodeEditPart.VISUAL_ID:
			return createDataStoreNode_3078(domainElement, containerView, index, persisted, preferencesHint);
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
		case AcceptEventActionEditPart.VISUAL_ID:
			return createAcceptEventAction_3063(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
			return createOutputPin_3064(domainElement, containerView, index, persisted, preferencesHint);
		case ValueSpecificationActionEditPart.VISUAL_ID:
			return createValueSpecificationAction_3076(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInValSpecActEditPart.VISUAL_ID:
			return createOutputPin_3077(domainElement, containerView, index, persisted, preferencesHint);
		case ConditionalNodeEditPart.VISUAL_ID:
			return createConditionalNode_3069(domainElement, containerView, index, persisted, preferencesHint);
		case ExpansionRegionEditPart.VISUAL_ID:
			return createExpansionRegion_3070(domainElement, containerView, index, persisted, preferencesHint);
		case ExpansionNodeAsInEditPart.VISUAL_ID:
			return createExpansionNode_3074(domainElement, containerView, index, persisted, preferencesHint);
		case ExpansionNodeAsOutEditPart.VISUAL_ID:
			return createExpansionNode_3075(domainElement, containerView, index, persisted, preferencesHint);
		case LoopNodeEditPart.VISUAL_ID:
			return createLoopNode_3071(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID:
			return createOutputPin_3109(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID:
			return createOutputPin_3110(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInLoopNodeAsResultEditPart.VISUAL_ID:
			return createOutputPin_3111(domainElement, containerView, index, persisted, preferencesHint);
		case SequenceNodeEditPart.VISUAL_ID:
			return createSequenceNode_3073(domainElement, containerView, index, persisted, preferencesHint);
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return createStructuredActivityNode_3065(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInLoopNodeAsVariableEditPart.VISUAL_ID:
			return createInputPin_3105(domainElement, containerView, index, persisted, preferencesHint);
		case ActivityPartitionEditPart.VISUAL_ID:
			return createActivityPartition_3067(domainElement, containerView, index, persisted, preferencesHint);
		case InterruptibleActivityRegionEditPart.VISUAL_ID:
			return createInterruptibleActivityRegion_3068(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPartCN.VISUAL_ID:
			return createComment_3080(domainElement, containerView, index, persisted, preferencesHint);
		case ReadSelfActionEditPart.VISUAL_ID:
			return createReadSelfAction_3081(domainElement, containerView, index, persisted, preferencesHint);
		case ReadSelfActionOutputPinEditPart.VISUAL_ID:
			return createOutputPin_3084(domainElement, containerView, index, persisted, preferencesHint);
		case ActivityEditPartCN.VISUAL_ID:
			return createActivity_3083(domainElement, containerView, index, persisted, preferencesHint);
		case CreateObjectActionEditPart.VISUAL_ID:
			return createCreateObjectAction_3086(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID:
			return createOutputPin_3087(domainElement, containerView, index, persisted, preferencesHint);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return createNamedElement_3085(domainElement, containerView, index, persisted, preferencesHint);
		case ReadStructuralFeatureActionEditPart.VISUAL_ID:
			return createReadStructuralFeatureAction_3088(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID:
			return createInputPin_3089(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID:
			return createOutputPin_3090(domainElement, containerView, index, persisted, preferencesHint);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return createAddStructuralFeatureValueAction_3091(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID:
			return createInputPin_3092(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID:
			return createInputPin_3093(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID:
			return createOutputPin_3094(domainElement, containerView, index, persisted, preferencesHint);
		case DestroyObjectActionEditPart.VISUAL_ID:
			return createDestroyObjectAction_3095(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInDestroyObjectActionEditPart.VISUAL_ID:
			return createInputPin_3096(domainElement, containerView, index, persisted, preferencesHint);
		case ReadVariableActionEditPart.VISUAL_ID:
			return createReadVariableAction_3097(domainElement, containerView, index, persisted, preferencesHint);
		case OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID:
			return createOutputPin_3098(domainElement, containerView, index, persisted, preferencesHint);
		case AddVariableValueActionEditPart.VISUAL_ID:
			return createAddVariableValueAction_3099(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID:
			return createInputPin_3100(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID:
			return createInputPin_3101(domainElement, containerView, index, persisted, preferencesHint);
		case BroadcastSignalActionEditPart.VISUAL_ID:
			return createBroadcastSignalAction_3102(domainElement, containerView, index, persisted, preferencesHint);
		case InputPinInBroadcastSignalActionEditPart.VISUAL_ID:
			return createInputPin_3103(domainElement, containerView, index, persisted, preferencesHint);
		case CentralBufferNodeEditPart.VISUAL_ID:
			return createCentralBufferNode_3104(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPartCN.VISUAL_ID:
			return createConstraint_3112(domainElement, containerView, index, persisted, preferencesHint);
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
		case ExceptionHandlerEditPart.VISUAL_ID:
			return createExceptionHandler_4005(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case CommentLinkEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4006(containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4007(containerView, index, persisted, preferencesHint);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Activity");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Activity");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Activity");
		Node label5001 = createLabel(node, UMLVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID));
		Node label5002 = createLabel(node, UMLVisualIDRegistry.getType(ActivityIsSingleExecutionEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityActivityParametersCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityActivityContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Activity");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createParameter_3001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Parameter");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Parameter");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ConstraintInActivityAsPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ConstraintInActivityAsPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInitialNode_3004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InitialNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InitialNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InitialNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InitialNode");
		Node label5080 = createLabel(node, UMLVisualIDRegistry.getType(InitialNodeAppliedStereotypeEditPart.VISUAL_ID));
		label5080.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5080 = (Location)label5080.getLayoutConstraint();
		location5080.setX(0);
		location5080.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActivityFinalNode_3005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityFinalNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActivityFinalNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActivityFinalNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActivityFinalNode");
		Node label5081 = createLabel(node, UMLVisualIDRegistry.getType(ActivityFinalNodeAppliedStereotypeEditPart.VISUAL_ID));
		label5081.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5081 = (Location)label5081.getLayoutConstraint();
		location5081.setX(0);
		location5081.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "FlowFinalNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "FlowFinalNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "FlowFinalNode");
		Node label5082 = createLabel(node, UMLVisualIDRegistry.getType(FlowFinalNodeAppliedStereotypeEditPart.VISUAL_ID));
		label5082.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5082 = (Location)label5082.getLayoutConstraint();
		location5082.setX(0);
		location5082.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OpaqueAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OpaqueAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OpaqueAction");
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValuePin");
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
		Node label5083 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInOActAppliedStereotypeEditPart.VISUAL_ID));
		label5083.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5083 = (Location)label5083.getLayoutConstraint();
		location5083.setX(0);
		location5083.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionInputPin");
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
		Node label5084 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInOActAppliedStereotypeEditPart.VISUAL_ID));
		label5084.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5084 = (Location)label5084.getLayoutConstraint();
		location5084.setX(0);
		location5084.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5009 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInOActLabelEditPart.VISUAL_ID));
		label5009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5009 = (Location)label5009.getLayoutConstraint();
		location5009.setX(0);
		location5009.setY(5);
		Node label5085 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInOActAppliedStereotypeEditPart.VISUAL_ID));
		label5085.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5085 = (Location)label5085.getLayoutConstraint();
		location5085.setX(0);
		location5085.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5010 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInOActLabelEditPart.VISUAL_ID));
		label5010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5010 = (Location)label5010.getLayoutConstraint();
		location5010.setX(0);
		location5010.setY(5);
		Node label5086 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInOActAppliedStereotypeEditPart.VISUAL_ID));
		label5086.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5086 = (Location)label5086.getLayoutConstraint();
		location5086.setX(0);
		location5086.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "CallBehaviorAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CallBehaviorAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "CallBehaviorAction");
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValuePin");
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
		Node label5087 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCBActAppliedStereotypeEditPart.VISUAL_ID));
		label5087.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5087 = (Location)label5087.getLayoutConstraint();
		location5087.setX(0);
		location5087.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionInputPin");
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
		Node label5088 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCBActAppliedStereotypeEditPart.VISUAL_ID));
		label5088.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5088 = (Location)label5088.getLayoutConstraint();
		location5088.setX(0);
		location5088.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5015 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCBActLabelEditPart.VISUAL_ID));
		label5015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5015 = (Location)label5015.getLayoutConstraint();
		location5015.setX(0);
		location5015.setY(5);
		Node label5089 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCBActAppliedStereotypeEditPart.VISUAL_ID));
		label5089.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5089 = (Location)label5089.getLayoutConstraint();
		location5089.setX(0);
		location5089.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5016 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInCBActLabelEditPart.VISUAL_ID));
		label5016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5016 = (Location)label5016.getLayoutConstraint();
		location5016.setX(0);
		location5016.setY(5);
		Node label5090 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInCBActAppliedStereotypeEditPart.VISUAL_ID));
		label5090.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5090 = (Location)label5090.getLayoutConstraint();
		location5090.setX(0);
		location5090.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "CallOperationAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CallOperationAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "CallOperationAction");
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionInputPin");
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
		Node label5091 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCOActAppliedStereotypeEditPart.VISUAL_ID));
		label5091.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5091 = (Location)label5091.getLayoutConstraint();
		location5091.setX(0);
		location5091.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValuePin");
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
		Node label5092 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCOActAppliedStereotypeEditPart.VISUAL_ID));
		label5092.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5092 = (Location)label5092.getLayoutConstraint();
		location5092.setX(0);
		location5092.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5019 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCOActLabelEditPart.VISUAL_ID));
		label5019.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5019 = (Location)label5019.getLayoutConstraint();
		location5019.setX(0);
		location5019.setY(5);
		Node label5093 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCOActAppliedStereotypeEditPart.VISUAL_ID));
		label5093.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5093 = (Location)label5093.getLayoutConstraint();
		location5093.setX(0);
		location5093.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5020 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInCOActLabelEditPart.VISUAL_ID));
		label5020.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5020 = (Location)label5020.getLayoutConstraint();
		location5020.setX(0);
		location5020.setY(5);
		Node label5094 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInCOActAppliedStereotypeEditPart.VISUAL_ID));
		label5094.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5094 = (Location)label5094.getLayoutConstraint();
		location5094.setX(0);
		location5094.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValuePin");
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
		Node label5095 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5095.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5095 = (Location)label5095.getLayoutConstraint();
		location5095.setX(0);
		location5095.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionInputPin");
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
		Node label5096 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5096.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5096 = (Location)label5096.getLayoutConstraint();
		location5096.setX(0);
		location5096.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5023 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCOActAsTargetLabelEditPart.VISUAL_ID));
		label5023.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5023 = (Location)label5023.getLayoutConstraint();
		location5023.setX(0);
		location5023.setY(5);
		Node label5097 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5097.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5097 = (Location)label5097.getLayoutConstraint();
		location5097.setX(0);
		location5097.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");
		Node label5007 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		Node label5136 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintAsLocalPrecondBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");
		Node label5008 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		Node label5137 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintAsLocalPostcondBodyEditPart.VISUAL_ID));
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DecisionNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DecisionNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DecisionNode");
		Node label5043 = createLabel(node, UMLVisualIDRegistry.getType(DecisionInputEditPart.VISUAL_ID));
		label5043.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5043 = (Location)label5043.getLayoutConstraint();
		location5043.setX(0);
		location5043.setY(5);
		Node label5098 = createLabel(node, UMLVisualIDRegistry.getType(DecisionNodeAppliedStereotypeEditPart.VISUAL_ID));
		label5098.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5098 = (Location)label5098.getLayoutConstraint();
		location5098.setX(0);
		location5098.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "MergeNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "MergeNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "MergeNode");
		Node label5099 = createLabel(node, UMLVisualIDRegistry.getType(MergeNodeAppliedStereotypeEditPart.VISUAL_ID));
		label5099.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5099 = (Location)label5099.getLayoutConstraint();
		location5099.setX(0);
		location5099.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createForkNode_3040(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ForkNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ForkNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ForkNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ForkNode");
		Node label5100 = createLabel(node, UMLVisualIDRegistry.getType(ForkNodeAppliedStereotypeEditPart.VISUAL_ID));
		label5100.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5100 = (Location)label5100.getLayoutConstraint();
		location5100.setX(0);
		location5100.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createJoinNode_3041(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(JoinNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "JoinNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "JoinNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "JoinNode");
		Node label5042 = createLabel(node, UMLVisualIDRegistry.getType(JoinSpecEditPart.VISUAL_ID));
		label5042.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5042 = (Location)label5042.getLayoutConstraint();
		location5042.setX(0);
		location5042.setY(5);
		Node label5101 = createLabel(node, UMLVisualIDRegistry.getType(JoinNodeAppliedStereotypeEditPart.VISUAL_ID));
		label5101.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5101 = (Location)label5101.getLayoutConstraint();
		location5101.setX(0);
		location5101.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "SendObjectAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "SendObjectAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "SendObjectAction");
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValuePin");
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
		Node label5102 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID));
		label5102.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5102 = (Location)label5102.getLayoutConstraint();
		location5102.setX(0);
		location5102.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionInputPin");
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
		Node label5103 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID));
		label5103.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5103 = (Location)label5103.getLayoutConstraint();
		location5103.setX(0);
		location5103.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5053 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqLabelEditPart.VISUAL_ID));
		label5053.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5053 = (Location)label5053.getLayoutConstraint();
		location5053.setX(0);
		location5053.setY(5);
		Node label5104 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID));
		label5104.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5104 = (Location)label5104.getLayoutConstraint();
		location5104.setX(0);
		location5104.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValuePin");
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
		Node label5105 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5105.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5105 = (Location)label5105.getLayoutConstraint();
		location5105.setX(0);
		location5105.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionInputPin");
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
		Node label5106 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5106.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5106 = (Location)label5106.getLayoutConstraint();
		location5106.setX(0);
		location5106.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5058 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID));
		label5058.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5058 = (Location)label5058.getLayoutConstraint();
		location5058.setX(0);
		location5058.setY(5);
		Node label5107 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5107.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5107 = (Location)label5107.getLayoutConstraint();
		location5107.setX(0);
		location5107.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "SendSignalAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "SendSignalAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "SendSignalAction");
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionInputPin");
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
		Node label5108 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAppliedStereotypeEditPart.VISUAL_ID));
		label5108.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5108 = (Location)label5108.getLayoutConstraint();
		location5108.setX(0);
		location5108.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValuePin");
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
		Node label5109 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendSigActAppliedStereotypeEditPart.VISUAL_ID));
		label5109.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5109 = (Location)label5109.getLayoutConstraint();
		location5109.setX(0);
		location5109.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5065 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendSigActLabelEditPart.VISUAL_ID));
		label5065.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5065 = (Location)label5065.getLayoutConstraint();
		location5065.setX(0);
		location5065.setY(5);
		Node label5110 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendSigActAppliedStereotypeEditPart.VISUAL_ID));
		label5110.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5110 = (Location)label5110.getLayoutConstraint();
		location5110.setX(0);
		location5110.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValuePin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValuePin");
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
		Node label5111 = createLabel(node, UMLVisualIDRegistry.getType(ValuePinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5111.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5111 = (Location)label5111.getLayoutConstraint();
		location5111.setX(0);
		location5111.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionInputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionInputPin");
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
		Node label5112 = createLabel(node, UMLVisualIDRegistry.getType(ActionInputPinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5112.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5112 = (Location)label5112.getLayoutConstraint();
		location5112.setX(0);
		location5112.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5076 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID));
		label5076.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5076 = (Location)label5076.getLayoutConstraint();
		location5076.setX(0);
		location5076.setY(5);
		Node label5113 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID));
		label5113.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5113 = (Location)label5113.getLayoutConstraint();
		location5113.setX(0);
		location5113.setY(5);
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActivityParameterNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActivityParameterNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActivityParameterNode");
		Node label5071 = createLabel(node, UMLVisualIDRegistry.getType(ParameterNodeNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAcceptEventAction_3063(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AcceptEventActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "AcceptEventAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "AcceptEventAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "AcceptEventAction");
		Node label5078 = createLabel(node, UMLVisualIDRegistry.getType(AcceptEventActionLabelEditPart.VISUAL_ID));
		Node label5079 = createLabel(node, UMLVisualIDRegistry.getType(AcceptTimeEventActionLabelEditPart.VISUAL_ID));
		label5079.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5079 = (Location)label5079.getLayoutConstraint();
		location5079.setX(0);
		location5079.setY(5);
		Node label5115 = createLabel(node, UMLVisualIDRegistry.getType(AcceptTimeEventActionAppliedStereotypeEditPart.VISUAL_ID));
		label5115.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5115 = (Location)label5115.getLayoutConstraint();
		location5115.setX(0);
		location5115.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3064(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5077 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionLabelEditPart.VISUAL_ID));
		label5077.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5077 = (Location)label5077.getLayoutConstraint();
		location5077.setX(0);
		location5077.setY(5);
		Node label5114 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInAcceptEventActionAppliedStereotypeEditPart.VISUAL_ID));
		label5114.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5114 = (Location)label5114.getLayoutConstraint();
		location5114.setX(0);
		location5114.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createStructuredActivityNode_3065(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(StructuredActivityNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "StructuredActivityNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "StructuredActivityNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "StructuredActivityNode");
		Node label5117 = createLabel(node, UMLVisualIDRegistry.getType(StructuredActivityNodeKeywordEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "StructuredActivityNode");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3105(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInLoopNodeAsVariableEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5178 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInLoopNodeAsVariableLabelEditPart.VISUAL_ID));
		label5178.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5178 = (Location)label5178.getLayoutConstraint();
		location5178.setX(0);
		location5178.setY(5);
		Node label5179 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInStructuredActivityNodeAppliedStereotypeEditPart.VISUAL_ID));
		label5179.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5179 = (Location)label5179.getLayoutConstraint();
		location5179.setX(0);
		location5179.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActivityPartition_3067(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityPartitionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActivityPartition");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActivityPartition");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActivityPartition");
		Node label5118 = createLabel(node, UMLVisualIDRegistry.getType(ActivityPartitionNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ActivityPartition");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterruptibleActivityRegion_3068(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InterruptibleActivityRegionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InterruptibleActivityRegion");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InterruptibleActivityRegion");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InterruptibleActivityRegion");
		createCompartment(node, UMLVisualIDRegistry.getType(InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "InterruptibleActivityRegion");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3080(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Comment");
		Node label5138 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyLabelEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createReadSelfAction_3081(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ReadSelfActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ReadSelfAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ReadSelfAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ReadSelfAction");
		Node label5139 = createLabel(node, UMLVisualIDRegistry.getType(ReadSelfActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3084(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ReadSelfActionOutputPinEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5144 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInReadSelfActionLabelEditPart.VISUAL_ID));
		label5144.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5144 = (Location)label5144.getLayoutConstraint();
		location5144.setX(0);
		location5144.setY(5);
		Node label5145 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInReadSelfActionAppliedStereotypeEditPart.VISUAL_ID));
		label5145.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5145 = (Location)label5145.getLayoutConstraint();
		location5145.setX(0);
		location5145.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActivity_3083(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Activity");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Activity");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Activity");
		Node label5142 = createLabel(node, UMLVisualIDRegistry.getType(ActivityNameEditPartCN.VISUAL_ID));
		Node label5143 = createLabel(node, UMLVisualIDRegistry.getType(ActivityIsSingleExecutionCNEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityCNParametersCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityCNPreConditionsCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityCNPostConditionsCompartmentEditPart.VISUAL_ID), false, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityCNContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Activity");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNamedElement_3085(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ShapeNamedElementEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ShapeNamedElement");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ShapeNamedElement");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ShapeNamedElement");
		Node label5129 = createLabel(node, UMLVisualIDRegistry.getType(ShapeNamedElementNameEditPart.VISUAL_ID));
		label5129.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5129 = (Location)label5129.getLayoutConstraint();
		location5129.setX(25);
		location5129.setY(3);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCreateObjectAction_3086(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CreateObjectActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "CreateObjectAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CreateObjectAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "CreateObjectAction");
		Node label5148 = createLabel(node, UMLVisualIDRegistry.getType(CreateObjectActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3087(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5146 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultLabelEditPart.VISUAL_ID));
		label5146.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5146 = (Location)label5146.getLayoutConstraint();
		location5146.setX(0);
		location5146.setY(5);
		Node label5147 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInCreateObjectActionAsResultAppliedStereotypeWrappingLabelEditPart.VISUAL_ID));
		label5147.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5147 = (Location)label5147.getLayoutConstraint();
		location5147.setX(0);
		location5147.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createReadStructuralFeatureAction_3088(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ReadStructuralFeatureActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ReadStructuralFeatureAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ReadStructuralFeatureAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ReadStructuralFeatureAction");
		Node label5153 = createLabel(node, UMLVisualIDRegistry.getType(ReadStructuralFeatureActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3089(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5149 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectLabelEditPart.VISUAL_ID));
		label5149.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5149 = (Location)label5149.getLayoutConstraint();
		location5149.setX(0);
		location5149.setY(5);
		Node label5150 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsObjectAppliedStereotypeWrappingLabelEditPart.VISUAL_ID));
		label5150.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5150 = (Location)label5150.getLayoutConstraint();
		location5150.setX(0);
		location5150.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3090(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5151 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInReadStructuralFeatureAsResultLabelEditPart.VISUAL_ID));
		label5151.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5151 = (Location)label5151.getLayoutConstraint();
		location5151.setX(0);
		location5151.setY(5);
		Node label5152 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInReadStructuralFeatureAsResultWrappingLabelEditPart.VISUAL_ID));
		label5152.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5152 = (Location)label5152.getLayoutConstraint();
		location5152.setX(0);
		location5152.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAddStructuralFeatureValueAction_3091(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "AddStructuralFeatureValueAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "AddStructuralFeatureValueAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "AddStructuralFeatureValueAction");
		Node label5160 = createLabel(node, UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3092(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5154 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectLabelEditPart.VISUAL_ID));
		label5154.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5154 = (Location)label5154.getLayoutConstraint();
		location5154.setX(0);
		location5154.setY(5);
		Node label5155 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsObjectAppliedStereotypeWrappingLabelEditPart.VISUAL_ID));
		label5155.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5155 = (Location)label5155.getLayoutConstraint();
		location5155.setX(0);
		location5155.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3093(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5156 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueLabel2EditPart.VISUAL_ID));
		label5156.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5156 = (Location)label5156.getLayoutConstraint();
		location5156.setX(0);
		location5156.setY(5);
		Node label5157 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInAddStructuralFeatureValueActionAsValueAppliedStereotypeWrappingLabel2EditPart.VISUAL_ID));
		label5157.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5157 = (Location)label5157.getLayoutConstraint();
		location5157.setX(0);
		location5157.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3094(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5158 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultLabel3EditPart.VISUAL_ID));
		label5158.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5158 = (Location)label5158.getLayoutConstraint();
		location5158.setX(0);
		location5158.setY(5);
		Node label5159 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInAddStructuralFeatureValueActionAsResultAppliedStereotypeWrappingLabel3EditPart.VISUAL_ID));
		label5159.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5159 = (Location)label5159.getLayoutConstraint();
		location5159.setX(0);
		location5159.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDestroyObjectAction_3095(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DestroyObjectActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DestroyObjectAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DestroyObjectAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DestroyObjectAction");
		Node label5163 = createLabel(node, UMLVisualIDRegistry.getType(DestroyObjectActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3096(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5161 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionLabelEditPart.VISUAL_ID));
		label5161.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5161 = (Location)label5161.getLayoutConstraint();
		location5161.setX(0);
		location5161.setY(5);
		Node label5162 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInDestroyObjectActionAppliedStereotypeWrappingLabelEditPart.VISUAL_ID));
		label5162.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5162 = (Location)label5162.getLayoutConstraint();
		location5162.setX(0);
		location5162.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createReadVariableAction_3097(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ReadVariableActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ReadVariableAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ReadVariableAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ReadVariableAction");
		Node label5166 = createLabel(node, UMLVisualIDRegistry.getType(ReadVariableActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3098(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5164 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultLabelEditPart.VISUAL_ID));
		label5164.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5164 = (Location)label5164.getLayoutConstraint();
		location5164.setX(0);
		location5164.setY(5);
		Node label5165 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInReadVariableActionAsResultAppliedStereotypeWrappingLabelEditPart.VISUAL_ID));
		label5165.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5165 = (Location)label5165.getLayoutConstraint();
		location5165.setX(0);
		location5165.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAddVariableValueAction_3099(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AddVariableValueActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "AddVariableValueAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "AddVariableValueAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "AddVariableValueAction");
		Node label5171 = createLabel(node, UMLVisualIDRegistry.getType(AddVariableValueActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3100(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5167 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtLabelEditPart.VISUAL_ID));
		label5167.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5167 = (Location)label5167.getLayoutConstraint();
		location5167.setX(0);
		location5167.setY(5);
		Node label5168 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsInsertAtAppliedStereotypeWrappingLabelEditPart.VISUAL_ID));
		label5168.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5168 = (Location)label5168.getLayoutConstraint();
		location5168.setX(0);
		location5168.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3101(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5169 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueLabelEditPart.VISUAL_ID));
		label5169.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5169 = (Location)label5169.getLayoutConstraint();
		location5169.setX(0);
		location5169.setY(5);
		Node label5170 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInAddVariableValueActionAsValueAppliedStereotypeWrappingLabelEditPart.VISUAL_ID));
		label5170.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5170 = (Location)label5170.getLayoutConstraint();
		location5170.setX(0);
		location5170.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createBroadcastSignalAction_3102(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(BroadcastSignalActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "BroadcastSignalAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "BroadcastSignalAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "BroadcastSignalAction");
		Node label5175 = createLabel(node, UMLVisualIDRegistry.getType(BroadcastSignalActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInputPin_3103(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InputPin");
		Node label5172 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionLabelEditPart.VISUAL_ID));
		label5172.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5172 = (Location)label5172.getLayoutConstraint();
		location5172.setX(0);
		location5172.setY(5);
		Node label5173 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionValueLabelEditPart.VISUAL_ID));
		label5173.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5173 = (Location)label5173.getLayoutConstraint();
		location5173.setX(0);
		location5173.setY(5);
		Node label5174 = createLabel(node, UMLVisualIDRegistry.getType(InputPinInBroadcastSignalActionAppliedStereotypeWrappingLabelEditPart.VISUAL_ID));
		label5174.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5174 = (Location)label5174.getLayoutConstraint();
		location5174.setX(0);
		location5174.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCentralBufferNode_3104(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CentralBufferNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "CentralBufferNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CentralBufferNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "CentralBufferNode");
		Node label5176 = createLabel(node, UMLVisualIDRegistry.getType(CentralBufferNodeLabelEditPart.VISUAL_ID));
		Node label5177 = createLabel(node, UMLVisualIDRegistry.getType(CentralBufferNodeSelectionEditPart.VISUAL_ID));
		label5177.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5177 = (Location)label5177.getLayoutConstraint();
		location5177.setX(0);
		location5177.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3112(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");
		Node label5189 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPartCN.VISUAL_ID));
		Node label5190 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintBodyEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createValueSpecificationAction_3076(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ValueSpecificationActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ValueSpecificationAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ValueSpecificationAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ValueSpecificationAction");
		Node label5126 = createLabel(node, UMLVisualIDRegistry.getType(ValueSpecificationActionNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3077(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInValSpecActEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5124 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInValSpecActLabelEditPart.VISUAL_ID));
		label5124.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5124 = (Location)label5124.getLayoutConstraint();
		location5124.setX(0);
		location5124.setY(5);
		Node label5125 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInValSpecActAppliedStereotypeEditPart.VISUAL_ID));
		label5125.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5125 = (Location)label5125.getLayoutConstraint();
		location5125.setX(0);
		location5125.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataStoreNode_3078(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataStoreNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DataStoreNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DataStoreNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DataStoreNode");
		Node label5127 = createLabel(node, UMLVisualIDRegistry.getType(DataStoreNodeLabelEditPart.VISUAL_ID));
		Node label5128 = createLabel(node, UMLVisualIDRegistry.getType(DataStoreSelectionEditPart.VISUAL_ID));
		label5128.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5128 = (Location)label5128.getLayoutConstraint();
		location5128.setX(0);
		location5128.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConditionalNode_3069(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConditionalNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ConditionalNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ConditionalNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ConditionalNode");
		Node label5119 = createLabel(node, UMLVisualIDRegistry.getType(ConditionalNodeKeywordEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ConditionalNode");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExpansionRegion_3070(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExpansionRegionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ExpansionRegion");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExpansionRegion");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ExpansionRegion");
		Node label5120 = createLabel(node, UMLVisualIDRegistry.getType(ExpansionRegionKeywordEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ExpansionRegion");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExpansionNode_3074(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExpansionNodeAsInEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ExpansionNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExpansionNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ExpansionNode");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExpansionNode_3075(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExpansionNodeAsOutEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ExpansionNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExpansionNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ExpansionNode");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLoopNode_3071(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(LoopNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "LoopNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "LoopNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "LoopNode");
		Node label5121 = createLabel(node, UMLVisualIDRegistry.getType(LoopNodeKeywordEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "LoopNode");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3109(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsBodyOutputEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5184 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsBodyOutputLabelEditPart.VISUAL_ID));
		label5184.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5184 = (Location)label5184.getLayoutConstraint();
		location5184.setX(0);
		location5184.setY(5);
		Node label5185 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsBodyOutputAppliedStereotypeEditPart.VISUAL_ID));
		label5185.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5185 = (Location)label5185.getLayoutConstraint();
		location5185.setX(0);
		location5185.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3110(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsLoopVariableEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5186 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsLoopVariableLabelEditPart.VISUAL_ID));
		label5186.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5186 = (Location)label5186.getLayoutConstraint();
		location5186.setX(0);
		location5186.setY(5);
		Node label5183 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsLoopVariableAppliedStereotypeEditPart.VISUAL_ID));
		label5183.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5183 = (Location)label5183.getLayoutConstraint();
		location5183.setX(0);
		location5183.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOutputPin_3111(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsResultEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OutputPin");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OutputPin");
		Node label5187 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsResultLabelEditPart.VISUAL_ID));
		label5187.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5187 = (Location)label5187.getLayoutConstraint();
		location5187.setX(0);
		location5187.setY(5);
		Node label5188 = createLabel(node, UMLVisualIDRegistry.getType(OutputPinInLoopNodeAsResultAppliedStereotypeEditPart.VISUAL_ID));
		label5188.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5188 = (Location)label5188.getLayoutConstraint();
		location5188.setX(0);
		location5188.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSequenceNode_3073(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SequenceNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "SequenceNode");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "SequenceNode");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "SequenceNode");
		Node label5123 = createLabel(node, UMLVisualIDRegistry.getType(SequenceNodeKeywordEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "SequenceNode");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createIntervalConstraint_3032(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "IntervalConstraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "IntervalConstraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "IntervalConstraint");
		Node label5036 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		Node label5134 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPrecondBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createIntervalConstraint_3033(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "IntervalConstraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "IntervalConstraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "IntervalConstraint");
		Node label5037 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		Node label5135 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintAsLocalPostcondBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationConstraint_3034(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DurationConstraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DurationConstraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DurationConstraint");
		Node label5038 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		Node label5130 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPrecondBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationConstraint_3035(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DurationConstraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DurationConstraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DurationConstraint");
		Node label5039 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		Node label5131 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintAsLocalPostcondBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeConstraint_3036(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "TimeConstraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeConstraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "TimeConstraint");
		Node label5040 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondNameEditPart.VISUAL_ID));
		Node label5132 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPrecondBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeConstraint_3037(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "TimeConstraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeConstraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "TimeConstraint");
		Node label5041 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondNameEditPart.VISUAL_ID));
		Node label5133 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintAsLocalPostcondBodyEditPart.VISUAL_ID));
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
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ActionLocalPreconditionEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Undefined");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Undefined");
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
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ActionLocalPostconditionEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Undefined");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Undefined");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createObjectFlow_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ObjectFlowEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ObjectFlow");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ObjectFlow");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ObjectFlow");
		Node label6001 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowNameEditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location)label6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(20);
		Node label6002 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowWeightEditPart.VISUAL_ID));
		label6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location)label6002.getLayoutConstraint();
		location6002.setX(0);
		location6002.setY(20);
		Node label6005 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowSelectionEditPart.VISUAL_ID));
		label6005.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6005 = (Location)label6005.getLayoutConstraint();
		location6005.setX(20);
		location6005.setY(40);
		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowTransformationEditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location)label6006.getLayoutConstraint();
		location6006.setX(-20);
		location6006.setY(-60);
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(DecisionInputFlowEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location)label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(-20);
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowGuardEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location)label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(20);
		Node label6010 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowAppliedStereotypeEditPart.VISUAL_ID));
		label6010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6010 = (Location)label6010.getLayoutConstraint();
		location6010.setX(0);
		location6010.setY(-20);
		Node label6014 = createLabel(edge, UMLVisualIDRegistry.getType(ObjectFlowInterruptibleIconEditPart.VISUAL_ID));
		label6014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "ObjectFlow");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createControlFlow_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ControlFlowEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ControlFlow");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ControlFlow");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ControlFlow");
		Node label6003 = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowNameEditPart.VISUAL_ID));
		label6003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6003 = (Location)label6003.getLayoutConstraint();
		location6003.setX(0);
		location6003.setY(20);
		Node label6004 = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowWeightEditPart.VISUAL_ID));
		label6004.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6004 = (Location)label6004.getLayoutConstraint();
		location6004.setX(0);
		location6004.setY(20);
		Node label6009 = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowGuardEditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6009 = (Location)label6009.getLayoutConstraint();
		location6009.setX(0);
		location6009.setY(20);
		Node label6011 = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowAppliedStereotypeEditPart.VISUAL_ID));
		label6011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6011 = (Location)label6011.getLayoutConstraint();
		location6011.setX(0);
		location6011.setY(-20);
		Node label6013 = createLabel(edge, UMLVisualIDRegistry.getType(ControlFlowInterruptibleIconEditPart.VISUAL_ID));
		label6013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "ControlFlow");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createExceptionHandler_4005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ExceptionHandlerEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ExceptionHandler");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ExceptionHandler");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ExceptionHandler");
		Node label6012 = createLabel(edge, UMLVisualIDRegistry.getType(ExceptionHandlerTypeEditPart.VISUAL_ID));
		label6012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6012 = (Location)label6012.getLayoutConstraint();
		location6012.setX(0);
		location6012.setY(40);
		Node label6015 = createLabel(edge, UMLVisualIDRegistry.getType(ExceptionHandlerIconEditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4006(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentLinkEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Undefined");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Undefined");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Undefined");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4007(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Undefined");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Undefined");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Undefined");
		return edge;
	}

	/**
	 * @generated
	 */
	protected void stampShortcut(View containerView, Node target) {
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
	protected Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	protected Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
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
	protected EObject getSemanticElement(IAdaptable semanticAdapter) {
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
	protected IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		return (IElementType)semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fontConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.FONT);
		String fontColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_FONT);
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
		String lineColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

	/**
	 * @generated
	 */
	private void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fillColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_FILL);
		String gradientColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.GRADIENT_POLICY);
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		FillStyle fillStyle = (FillStyle)view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());;
		if(store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}
}
