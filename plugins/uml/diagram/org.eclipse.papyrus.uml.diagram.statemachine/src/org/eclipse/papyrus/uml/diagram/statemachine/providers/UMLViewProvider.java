/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.providers;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintBodyEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintNameLabelEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.DoActivityStateBehaviorStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.EntryStateBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ExitStateBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.FinalStateNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.FinalStateStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.GeneralizationStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.InternalTransitionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateChoiceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateChoiceNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateChoiceStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateDeepHistoryEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateDeepHistoryNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateDeepHistoryStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateEntryPointEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateEntryPointNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateEntryPointStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateExitPointEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateExitPointNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateExitPointStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateForkEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateForkNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateForkStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateInitialEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateInitialNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateInitialStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJoinEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJoinNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJoinStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJunctionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJunctionNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJunctionStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateShallowHistoryEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateShallowHistoryNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateShallowHistoryStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateTerminateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateTerminateNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateTerminateStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionGuardEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractProvider implements IViewProvider {
	/**
	 * @generated
	 */
	public final boolean provides(IOperation operation) {
		if (operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation) operation);
		}
		assert operation instanceof CreateViewOperation;
		if (operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation) operation);
		} else if (operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation) operation);
		} else if (operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation) operation);
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
		// check Diagram Type should be the class diagram
		String modelID = UMLVisualIDRegistry.getModelID(op.getContainerView());
		if (!getDiagramProvidedId().equals(modelID)) {
			return false;
		}
		int visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
		if (Node.class.isAssignableFrom(op.getViewKind())) {
			return UMLVisualIDRegistry.canCreateNode(op.getContainerView(), visualID);
		}
		return true;
	}

	/**
	 * @generated
	 */
	protected String getDiagramProvidedId() {
		/*
		 * Indicates for which diagram this provider works for.
		 * <p>
		 * This method can be overloaded when diagram editor inherits from another one, but should never be <code>null</code>
		 * </p>
		 * 
		 * @return the unique identifier of the diagram for which views are provided.
		 */
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
		if (op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if (op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return false;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
			if (elementType != null) {
				if (elementType instanceof IExtendedHintedElementType) {
					IElementType closestNonExtendedType = ElementTypeUtils.getClosestDiagramType(elementType);
					if (!UMLElementTypes.isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof IHintedType))) {
						return false; // foreign element type.
					}
				} else {
					if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
						return false; // foreign element type
					}
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case StateMachineEditPart.VISUAL_ID:
				case RegionEditPart.VISUAL_ID:
				case FinalStateEditPart.VISUAL_ID:
				case StateEditPart.VISUAL_ID:
				case PseudostateInitialEditPart.VISUAL_ID:
				case PseudostateJoinEditPart.VISUAL_ID:
				case PseudostateForkEditPart.VISUAL_ID:
				case PseudostateChoiceEditPart.VISUAL_ID:
				case PseudostateJunctionEditPart.VISUAL_ID:
				case PseudostateShallowHistoryEditPart.VISUAL_ID:
				case PseudostateDeepHistoryEditPart.VISUAL_ID:
				case PseudostateTerminateEditPart.VISUAL_ID:
				case PseudostateEntryPointEditPart.VISUAL_ID:
				case PseudostateExitPointEditPart.VISUAL_ID:
				case ConnectionPointReferenceEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case EntryStateBehaviorEditPart.VISUAL_ID:
				case DoActivityStateBehaviorStateEditPart.VISUAL_ID:
				case ExitStateBehaviorEditPart.VISUAL_ID:
				case InternalTransitionEditPart.VISUAL_ID:
					if (domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return StateMachineEditPart.VISUAL_ID == visualID || RegionEditPart.VISUAL_ID == visualID || FinalStateEditPart.VISUAL_ID == visualID || StateEditPart.VISUAL_ID == visualID || PseudostateInitialEditPart.VISUAL_ID == visualID
				|| PseudostateJoinEditPart.VISUAL_ID == visualID || PseudostateForkEditPart.VISUAL_ID == visualID || PseudostateChoiceEditPart.VISUAL_ID == visualID || PseudostateJunctionEditPart.VISUAL_ID == visualID
				|| PseudostateShallowHistoryEditPart.VISUAL_ID == visualID || PseudostateDeepHistoryEditPart.VISUAL_ID == visualID || PseudostateTerminateEditPart.VISUAL_ID == visualID || PseudostateEntryPointEditPart.VISUAL_ID == visualID
				|| PseudostateExitPointEditPart.VISUAL_ID == visualID || ConnectionPointReferenceEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID || ConstraintEditPart.VISUAL_ID == visualID
				|| InternalTransitionEditPart.VISUAL_ID == visualID || EntryStateBehaviorEditPart.VISUAL_ID == visualID || DoActivityStateBehaviorStateEditPart.VISUAL_ID == visualID || ExitStateBehaviorEditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		//RS: add code for extended types creation
		if (elementType instanceof IExtendedHintedElementType) {
			IElementType closestNonExtendedType = ElementTypeUtils.getClosestDiagramType(elementType);
			if (!UMLElementTypes.isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof IHintedType))) {
				return false; // foreign element type.
			}
		} else {
			if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
				return false; // foreign element type
			}
		}
		//if (!org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
		//	return false; // foreign element type
		//}
		// END R.S.
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null && visualID != UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
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
		if (semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch (visualID) {
		case StateMachineEditPart.VISUAL_ID:
			return createStateMachine_2000(domainElement, containerView, index, persisted, preferencesHint);
		case RegionEditPart.VISUAL_ID:
			return createRegion_3000(domainElement, containerView, index, persisted, preferencesHint);
		case FinalStateEditPart.VISUAL_ID:
			return createFinalState_5000(domainElement, containerView, index, persisted, preferencesHint);
		case StateEditPart.VISUAL_ID:
			return createState_6000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateInitialEditPart.VISUAL_ID:
			return createPseudostate_8000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateJoinEditPart.VISUAL_ID:
			return createPseudostate_9000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateForkEditPart.VISUAL_ID:
			return createPseudostate_10000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateChoiceEditPart.VISUAL_ID:
			return createPseudostate_11000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateJunctionEditPart.VISUAL_ID:
			return createPseudostate_12000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateShallowHistoryEditPart.VISUAL_ID:
			return createPseudostate_13000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateDeepHistoryEditPart.VISUAL_ID:
			return createPseudostate_14000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateTerminateEditPart.VISUAL_ID:
			return createPseudostate_15000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateEntryPointEditPart.VISUAL_ID:
			return createPseudostate_16000(domainElement, containerView, index, persisted, preferencesHint);
		case PseudostateExitPointEditPart.VISUAL_ID:
			return createPseudostate_17000(domainElement, containerView, index, persisted, preferencesHint);
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return createConnectionPointReference_18000(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_666(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_668(domainElement, containerView, index, persisted, preferencesHint);
		case InternalTransitionEditPart.VISUAL_ID:
			return createTransition_680(domainElement, containerView, index, persisted, preferencesHint);
		case EntryStateBehaviorEditPart.VISUAL_ID:
			return createBehavior_690(domainElement, containerView, index, persisted, preferencesHint);
		case DoActivityStateBehaviorStateEditPart.VISUAL_ID:
			return createBehavior_691(domainElement, containerView, index, persisted, preferencesHint);
		case ExitStateBehaviorEditPart.VISUAL_ID:
			return createBehavior_692(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		switch (UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case TransitionEditPart.VISUAL_ID:
			return createTransition_7000(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_19000(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_667(containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_670(containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createStateMachine_2000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(StateMachineEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "StateMachine");
		Node label2001 = createLabel(node, UMLVisualIDRegistry.getType(StateMachineNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(StateMachineCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "StateMachine");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createRegion_3000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(RegionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Region");
		createCompartment(node, UMLVisualIDRegistry.getType(RegionCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Region");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createFinalState_5000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(FinalStateEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "FinalState");
		Node label5001 = createLabel(node, UMLVisualIDRegistry.getType(FinalStateNameEditPart.VISUAL_ID));
		label5001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5001 = (Location) label5001.getLayoutConstraint();
		location5001.setX(25);
		location5001.setY(3);
		Node label5002 = createLabel(node, UMLVisualIDRegistry.getType(FinalStateStereotypeEditPart.VISUAL_ID));
		label5002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5002 = (Location) label5002.getLayoutConstraint();
		location5002.setX(25);
		location5002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createState_6000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(StateEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "State");
		Node label6001 = createLabel(node, UMLVisualIDRegistry.getType(StateNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(StateCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "State");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_8000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateInitialEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label8001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateInitialNameEditPart.VISUAL_ID));
		label8001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location8001 = (Location) label8001.getLayoutConstraint();
		location8001.setX(25);
		location8001.setY(3);
		Node label8002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateInitialStereotypeEditPart.VISUAL_ID));
		label8002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location8002 = (Location) label8002.getLayoutConstraint();
		location8002.setX(25);
		location8002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_9000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateJoinEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label9001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateJoinNameEditPart.VISUAL_ID));
		label9001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location9001 = (Location) label9001.getLayoutConstraint();
		location9001.setX(25);
		location9001.setY(3);
		Node label9002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateJoinStereotypeEditPart.VISUAL_ID));
		label9002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location9002 = (Location) label9002.getLayoutConstraint();
		location9002.setX(25);
		location9002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_10000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateForkEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label10001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateForkNameEditPart.VISUAL_ID));
		label10001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location10001 = (Location) label10001.getLayoutConstraint();
		location10001.setX(25);
		location10001.setY(3);
		Node label10002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateForkStereotypeEditPart.VISUAL_ID));
		label10002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location10002 = (Location) label10002.getLayoutConstraint();
		location10002.setX(25);
		location10002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_11000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateChoiceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label11001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateChoiceNameEditPart.VISUAL_ID));
		label11001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location11001 = (Location) label11001.getLayoutConstraint();
		location11001.setX(25);
		location11001.setY(3);
		Node label11002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateChoiceStereotypeEditPart.VISUAL_ID));
		label11002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location11002 = (Location) label11002.getLayoutConstraint();
		location11002.setX(25);
		location11002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_12000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateJunctionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label12001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateJunctionNameEditPart.VISUAL_ID));
		label12001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location12001 = (Location) label12001.getLayoutConstraint();
		location12001.setX(25);
		location12001.setY(3);
		Node label12002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateJunctionStereotypeEditPart.VISUAL_ID));
		label12002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location12002 = (Location) label12002.getLayoutConstraint();
		location12002.setX(25);
		location12002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_13000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateShallowHistoryEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label13001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateShallowHistoryNameEditPart.VISUAL_ID));
		label13001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location13001 = (Location) label13001.getLayoutConstraint();
		location13001.setX(25);
		location13001.setY(3);
		Node label13002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateShallowHistoryStereotypeEditPart.VISUAL_ID));
		label13002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location13002 = (Location) label13002.getLayoutConstraint();
		location13002.setX(25);
		location13002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_14000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateDeepHistoryEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label14001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateDeepHistoryNameEditPart.VISUAL_ID));
		label14001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location14001 = (Location) label14001.getLayoutConstraint();
		location14001.setX(25);
		location14001.setY(3);
		Node label14002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateDeepHistoryStereotypeEditPart.VISUAL_ID));
		label14002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location14002 = (Location) label14002.getLayoutConstraint();
		location14002.setX(25);
		location14002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_15000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateTerminateEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label15001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateTerminateNameEditPart.VISUAL_ID));
		label15001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location15001 = (Location) label15001.getLayoutConstraint();
		location15001.setX(25);
		location15001.setY(3);
		Node label15002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateTerminateStereotypeEditPart.VISUAL_ID));
		label15002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location15002 = (Location) label15002.getLayoutConstraint();
		location15002.setX(25);
		location15002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_16000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateEntryPointEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label16001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateEntryPointNameEditPart.VISUAL_ID));
		label16001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location16001 = (Location) label16001.getLayoutConstraint();
		location16001.setX(25);
		location16001.setY(3);
		Node label16002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateEntryPointStereotypeEditPart.VISUAL_ID));
		label16002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location16002 = (Location) label16002.getLayoutConstraint();
		location16002.setX(25);
		location16002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPseudostate_17000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PseudostateExitPointEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Pseudostate");
		Node label17001 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateExitPointNameEditPart.VISUAL_ID));
		label17001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location17001 = (Location) label17001.getLayoutConstraint();
		location17001.setX(25);
		location17001.setY(3);
		Node label17002 = createLabel(node, UMLVisualIDRegistry.getType(PseudostateExitPointStereotypeEditPart.VISUAL_ID));
		label17002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location17002 = (Location) label17002.getLayoutConstraint();
		location17002.setX(25);
		location17002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConnectionPointReference_18000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConnectionPointReferenceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ConnectionPointReference");
		Node label18001 = createLabel(node, UMLVisualIDRegistry.getType(ConnectionPointReferenceNameEditPart.VISUAL_ID));
		label18001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location18001 = (Location) label18001.getLayoutConstraint();
		location18001.setX(25);
		location18001.setY(3);
		Node label18002 = createLabel(node, UMLVisualIDRegistry.getType(ConnectionPointReferenceStereotypeEditPart.VISUAL_ID));
		label18002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location18002 = (Location) label18002.getLayoutConstraint();
		location18002.setX(25);
		location18002.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_666(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");
		Node label6666 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_668(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		Node label6668 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameLabelEditPart.VISUAL_ID));
		Node label6669 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTransition_680(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(InternalTransitionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InternalTransition");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createBehavior_690(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(EntryStateBehaviorEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "EntryStateBehavior");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createBehavior_691(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(DoActivityStateBehaviorStateEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DoActivityStateBehavior");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createBehavior_692(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ExitStateBehaviorEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExitStateBehavior");
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createTransition_7000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(TransitionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Transition");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label7001 = createLabel(edge, UMLVisualIDRegistry.getType(TransitionNameEditPart.VISUAL_ID));
		label7001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Node label7002 = createLabel(edge, UMLVisualIDRegistry.getType(TransitionGuardEditPart.VISUAL_ID));
		label7002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Node label7003 = createLabel(edge, UMLVisualIDRegistry.getType(TransitionStereotypeEditPart.VISUAL_ID));
		label7003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location7003 = (Location) label7003.getLayoutConstraint();
		location7003.setX(0);
		location7003.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_19000(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Generalization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label19002 = createLabel(edge, UMLVisualIDRegistry.getType(GeneralizationStereotypeEditPart.VISUAL_ID));
		label19002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location19002 = (Location) label19002.getLayoutConstraint();
		location19002.setX(0);
		location19002.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_667(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_670(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		return edge;
	}

	/**
	 * @generated
	 */
	protected void stampShortcut(View containerView, Node target) {
		if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
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

	/**
	 * @generated
	 */
	protected Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		Node rv;
		if (canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		rv.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		if (hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			rv.getStyles().add(ts);
		}
		if (canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if (canFilter) {
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
		if (semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName)
	{
		String fontConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.FONT);
		String fontColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_FONT);
		FontStyle viewFontStyle = (FontStyle) view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (viewFontStyle != null)
		{
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
	private void initForegroundFromPrefs(View view, final IPreferenceStore store, String elementName)
	{
		String lineColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

	/**
	 * @generated
	 */
	private void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName)
	{
		String fillColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_FILL);
		String gradientColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.GRADIENT_POLICY);
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		FillStyle fillStyle = (FillStyle) view
				.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle
				.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());
		;
		if (store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(
					store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle
					.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}
}
