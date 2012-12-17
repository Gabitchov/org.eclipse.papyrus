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
 *   Vincent Lorenzo - vincent.lorenzo@cea.fr - CEA - LIST
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

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
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseName2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;

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
		return PackageEditPart.MODEL_ID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return PackageEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
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
				if(!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch(visualID) {
				case InteractionEditPart.VISUAL_ID:
				case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
				case CombinedFragmentEditPart.VISUAL_ID:
				case InteractionOperandEditPart.VISUAL_ID:
				case InteractionUseEditPart.VISUAL_ID:
				case ContinuationEditPart.VISUAL_ID:
				case LifelineEditPart.VISUAL_ID:
				case ActionExecutionSpecificationEditPart.VISUAL_ID:
				case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
				case StateInvariantEditPart.VISUAL_ID:
				case TimeConstraintEditPart.VISUAL_ID:
				case TimeObservationEditPart.VISUAL_ID:
				case DurationConstraintEditPart.VISUAL_ID:
				case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case DurationObservationEditPart.VISUAL_ID:
				case CombinedFragment2EditPart.VISUAL_ID:
				case DurationConstraintInMessageEditPart.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return InteractionEditPart.VISUAL_ID == visualID || ConsiderIgnoreFragmentEditPart.VISUAL_ID == visualID || CombinedFragmentEditPart.VISUAL_ID == visualID || InteractionOperandEditPart.VISUAL_ID == visualID || InteractionUseEditPart.VISUAL_ID == visualID || ContinuationEditPart.VISUAL_ID == visualID || LifelineEditPart.VISUAL_ID == visualID || ActionExecutionSpecificationEditPart.VISUAL_ID == visualID || BehaviorExecutionSpecificationEditPart.VISUAL_ID == visualID || StateInvariantEditPart.VISUAL_ID == visualID || CombinedFragment2EditPart.VISUAL_ID == visualID || TimeConstraintEditPart.VISUAL_ID == visualID || TimeObservationEditPart.VISUAL_ID == visualID || DurationConstraintEditPart.VISUAL_ID == visualID || DestructionOccurrenceSpecificationEditPart.VISUAL_ID == visualID || ConstraintEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID || DurationConstraintInMessageEditPart.VISUAL_ID == visualID || DurationObservationEditPart.VISUAL_ID == visualID;
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
		diagram.setType(PackageEditPart.MODEL_ID);
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
		case InteractionEditPart.VISUAL_ID:
			return createInteraction_2001(domainElement, containerView, index, persisted, preferencesHint);
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return createConsiderIgnoreFragment_3007(domainElement, containerView, index, persisted, preferencesHint);
		case CombinedFragmentEditPart.VISUAL_ID:
			return createCombinedFragment_3004(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionOperandEditPart.VISUAL_ID:
			return createInteractionOperand_3005(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionUseEditPart.VISUAL_ID:
			return createInteractionUse_3002(domainElement, containerView, index, persisted, preferencesHint);
		case ContinuationEditPart.VISUAL_ID:
			return createContinuation_3016(domainElement, containerView, index, persisted, preferencesHint);
		case LifelineEditPart.VISUAL_ID:
			return createLifeline_3001(domainElement, containerView, index, persisted, preferencesHint);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return createActionExecutionSpecification_3006(domainElement, containerView, index, persisted, preferencesHint);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return createBehaviorExecutionSpecification_3003(domainElement, containerView, index, persisted, preferencesHint);
		case StateInvariantEditPart.VISUAL_ID:
			return createStateInvariant_3017(domainElement, containerView, index, persisted, preferencesHint);
		case CombinedFragment2EditPart.VISUAL_ID:
			return createCombinedFragment_3018(domainElement, containerView, index, persisted, preferencesHint);
		case TimeConstraintEditPart.VISUAL_ID:
			return createTimeConstraint_3019(domainElement, containerView, index, persisted, preferencesHint);
		case TimeObservationEditPart.VISUAL_ID:
			return createTimeObservation_3020(domainElement, containerView, index, persisted, preferencesHint);
		case DurationConstraintEditPart.VISUAL_ID:
			return createDurationConstraint_3021(domainElement, containerView, index, persisted, preferencesHint);
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
			return createDestructionOccurrenceSpecification_3022(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_3008(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_3009(domainElement, containerView, index, persisted, preferencesHint);
		case DurationConstraintInMessageEditPart.VISUAL_ID:
			return createDurationConstraint_3023(domainElement, containerView, index, persisted, preferencesHint);
		case DurationObservationEditPart.VISUAL_ID:
			return createDurationObservation_3024(domainElement, containerView, index, persisted, preferencesHint);
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
		case MessageEditPart.VISUAL_ID:
			return createMessage_4003(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Message2EditPart.VISUAL_ID:
			return createMessage_4004(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Message3EditPart.VISUAL_ID:
			return createMessage_4005(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Message4EditPart.VISUAL_ID:
			return createMessage_4006(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Message5EditPart.VISUAL_ID:
			return createMessage_4007(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Message6EditPart.VISUAL_ID:
			return createMessage_4008(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Message7EditPart.VISUAL_ID:
			return createMessage_4009(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4010(containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4011(containerView, index, persisted, preferencesHint);
		case GeneralOrderingEditPart.VISUAL_ID:
			return createGeneralOrdering_4012(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createInteraction_2001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Interaction");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interaction");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Interaction");

		Node label5001 = createLabel(node, UMLVisualIDRegistry.getType(InteractionNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID), false, false, false, false);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Interaction");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createLifeline_3001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Lifeline");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Lifeline");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Lifeline");

		Node label5002 = createLabel(node, UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createBehaviorExecutionSpecification_3003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "BehaviorExecutionSpecification");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "BehaviorExecutionSpecification");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "BehaviorExecutionSpecification");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createStateInvariant_3017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(StateInvariantEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "StateInvariant");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "StateInvariant");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "StateInvariant");

		Node label5008 = createLabel(node, UMLVisualIDRegistry.getType(StateInvariantNameEditPart.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createCombinedFragment_3018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CombinedFragment2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "CombinedFragment");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CombinedFragment");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "CombinedFragment");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeConstraint_3019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "TimeConstraint");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeConstraint");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "TimeConstraint");

		Node label5009 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintLabelEditPart.VISUAL_ID));
		label5009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5009 = (Location)label5009.getLayoutConstraint();
		location5009.setX(22);
		location5009.setY(-7);
		Node label5013 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintAppliedStereotypeEditPart.VISUAL_ID));
		label5013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5013 = (Location)label5013.getLayoutConstraint();
		location5013.setX(0);
		location5013.setY(-22);

		return node;
	}

	/**
	 * @generated NOT
	 */
	public Node createTimeObservation_3020(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "TimeObservation");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeObservation");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "TimeObservation");

		Node label5010 = createLabel(node, UMLVisualIDRegistry.getType(TimeObservationLabelEditPart.VISUAL_ID),true);
		label5010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5010 = (Location)label5010.getLayoutConstraint();
		location5010.setX(0);
		location5010.setY(0);
		Node label5014 = createLabel(node, UMLVisualIDRegistry.getType(TimeObservationAppliedStereotypeEditPart.VISUAL_ID),true);
		label5014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5014 = (Location)label5014.getLayoutConstraint();
		location5014.setX(0);
		location5014.setY(0);

		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationConstraint_3021(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DurationConstraint");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DurationConstraint");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DurationConstraint");

		Node label5011 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintLabelEditPart.VISUAL_ID));
		label5011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5011 = (Location)label5011.getLayoutConstraint();
		location5011.setX(25);
		location5011.setY(0);
		Node label5015 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintAppliedStereotypeEditPart.VISUAL_ID));
		label5015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5015 = (Location)label5015.getLayoutConstraint();
		location5015.setX(0);
		location5015.setY(-22);

		return node;
	}

	/**
	 * @generated
	 */
	public Node createDestructionOccurrenceSpecification_3022(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DestructionOccurrenceSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DestructionOccurrenceSpecification");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DestructionOccurrenceSpecification");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DestructionOccurrenceSpecification");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionExecutionSpecification_3006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ActionExecutionSpecification");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ActionExecutionSpecification");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ActionExecutionSpecification");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteractionUse_3002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InteractionUse");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InteractionUse");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InteractionUse");

		Node label5003 = createLabel(node, UMLVisualIDRegistry.getType(InteractionUseNameEditPart.VISUAL_ID));
		Node label5004 = createLabel(node, UMLVisualIDRegistry.getType(InteractionUseName2EditPart.VISUAL_ID));

		return node;
	}

	/**
	 * Generated not for always have an InteractionOperand on a CombinedFragment
	 * 
	 * @generated NOT
	 */
	public Node createCombinedFragment_3004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "CombinedFragment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CombinedFragment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "CombinedFragment");

		Node compartment = createCompartment(node, UMLVisualIDRegistry.getType(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID), false, false, true, true);

		// Add by default InteractionOperand
		for(InteractionOperand interactionOperand : ((CombinedFragment)domainElement).getOperands()) {
			createInteractionOperand_3005(interactionOperand, compartment, -1, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		}
		//initialization for the compartment visibility
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "CombinedFragment");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteractionOperand_3005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InteractionOperand");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InteractionOperand");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InteractionOperand");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createContinuation_3016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ContinuationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Continuation");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Continuation");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Continuation");

		Node label5007 = createLabel(node, UMLVisualIDRegistry.getType(ContinuationNameEditPart.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");

		Node label5005 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		Node label5012 = createLabel(node, UMLVisualIDRegistry.getType(Constraint2EditPart.VISUAL_ID));

		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Comment");

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Comment");

		Node label5006 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));

		return node;
	}

	/**
	 * @generated NOT custom layout for location
	 */
	public Node createDurationConstraint_3023(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// custom layout for location
		Location location3023 = (Location)node.getLayoutConstraint();
		location3023.setX(0);
		location3023.setY(20);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DurationConstraint");

		Node label5018 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintInMessageLabelEditPart.VISUAL_ID));
		Node label5019 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintInMessageAppliedStereotypeEditPart.VISUAL_ID));
		label5019.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5019 = (Location)label5019.getLayoutConstraint();
		location5019.setX(0);
		location5019.setY(-22);
		return node;
	}

	/**
	 * @generated NOT custom layout for location
	 */
	public Node createDurationObservation_3024(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// custom layout for location
		Location location3024 = (Location)node.getLayoutConstraint();
		location3024.setX(0);
		location3024.setY(0);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DurationObservation");

		Node label5016 = createLabel(node, UMLVisualIDRegistry.getType(DurationObservationLabelEditPart.VISUAL_ID));
		Node label5017 = createLabel(node, UMLVisualIDRegistry.getType(DurationObservationAppliedStereotypeEditPart.VISUAL_ID));
		label5017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());

		Location location5017 = (Location)label5017.getLayoutConstraint();
		location5017.setX(0);
		location5017.setY(0);
		return node;
	}

	/**
	 * @generated NOT
	 */
	public Node createConsiderIgnoreFragment_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ConsiderIgnoreFragment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ConsiderIgnoreFragment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ConsiderIgnoreFragment");

		Node compartment = createCompartment(node, UMLVisualIDRegistry.getType(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID), false, false, true, true);

		// Add by default InteractionOperand
		for(InteractionOperand interactionOperand : ((CombinedFragment)domainElement).getOperands()) {
			createInteractionOperand_3005(interactionOperand, compartment, -1, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		}

		//initialization for the compartment visibility
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ConsiderIgnoreFragment");
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Message");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Message");

		Node label6001 = createLabel(edge, UMLVisualIDRegistry.getType(MessageNameEditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location)label6001.getLayoutConstraint();
		location6001.setX(1);
		location6001.setY(-13);
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(MessageSyncAppliedStereotypeEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location)label6008.getLayoutConstraint();
		location6008.setX(1);
		location6008.setY(-33);
		
		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Message");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Message");

		Node label6002 = createLabel(edge, UMLVisualIDRegistry.getType(MessageName2EditPart.VISUAL_ID));
		label6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location)label6002.getLayoutConstraint();
		location6002.setX(1);
		location6002.setY(-13);
		Node label6009 = createLabel(edge, UMLVisualIDRegistry.getType(MessageAsyncAppliedStereotypeEditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6009 = (Location)label6009.getLayoutConstraint();
		location6009.setX(1);
		location6009.setY(-33);

		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");
		
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(Message3EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Message");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Message");

		Node label6003 = createLabel(edge, UMLVisualIDRegistry.getType(MessageName3EditPart.VISUAL_ID));
		label6003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6003 = (Location)label6003.getLayoutConstraint();
		location6003.setX(1);
		location6003.setY(-13);
		Node label6010 = createLabel(edge, UMLVisualIDRegistry.getType(MessageReplyAppliedStereotypeEditPart.VISUAL_ID));
		label6010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6010 = (Location)label6010.getLayoutConstraint();
		location6010.setX(1);
		location6010.setY(-33);

		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(Message4EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Message");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Message");

		Node label6004 = createLabel(edge, UMLVisualIDRegistry.getType(MessageName4EditPart.VISUAL_ID));
		label6004.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6004 = (Location)label6004.getLayoutConstraint();
		location6004.setX(1);
		location6004.setY(-13);
		Node label6011 = createLabel(edge, UMLVisualIDRegistry.getType(MessageCreateAppliedStereotypeEditPart.VISUAL_ID));
		label6011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6011 = (Location)label6011.getLayoutConstraint();
		location6011.setX(1);
		location6011.setY(-33);
		
		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(Message5EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Message");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Message");

		Node label6005 = createLabel(edge, UMLVisualIDRegistry.getType(MessageName5EditPart.VISUAL_ID));
		label6005.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6005 = (Location)label6005.getLayoutConstraint();
		location6005.setX(1);
		location6005.setY(-13);
		Node label6012 = createLabel(edge, UMLVisualIDRegistry.getType(MessageDeleteAppliedStereotypeEditPart.VISUAL_ID));
		label6012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6012 = (Location)label6012.getLayoutConstraint();
		location6012.setX(1);
		location6012.setY(-33);

		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");
		
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(Message6EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Message");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Message");

		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(MessageName6EditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location)label6006.getLayoutConstraint();
		location6006.setX(1);
		location6006.setY(-13);
		Node label6013 = createLabel(edge, UMLVisualIDRegistry.getType(MessageLostAppliedStereotypeEditPart.VISUAL_ID));
		label6013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6013 = (Location)label6013.getLayoutConstraint();
		location6013.setX(1);
		location6013.setY(-33);
		
		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(Message7EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Message");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Message");

		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(MessageName7EditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location)label6007.getLayoutConstraint();
		location6007.setX(1);
		location6007.setY(-13);
		Node label6014 = createLabel(edge, UMLVisualIDRegistry.getType(MessageFoundAppliedStereotypeEditPart.VISUAL_ID));
		label6014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6014 = (Location)label6014.getLayoutConstraint();
		location6014.setX(1);
		location6014.setY(-33);
		
		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4010(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
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
		
		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4011(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		
		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message");

		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralOrdering_4012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(GeneralOrderingEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();

		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "GeneralOrdering");

		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}

		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "GeneralOrdering");

		Node label6015 = createLabel(edge, UMLVisualIDRegistry.getType(GeneralOrderingAppliedStereotypeEditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6015 = (Location)label6015.getLayoutConstraint();
		location6015.setX(1);
		location6015.setY(-33);

		edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "GeneralOrdering");
		return edge;
	}

	/**
	 * @generated
	 */
	protected void stampShortcut(View containerView, Node target) {
		if(!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", PackageEditPart.MODEL_ID); //$NON-NLS-1$
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
	
	protected Node createLabel(View owner, String hint, boolean isTimeObservationLable) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(hint);
		ViewUtil.insertChildView(owner, node, ViewUtil.APPEND, true);
		return node;
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
