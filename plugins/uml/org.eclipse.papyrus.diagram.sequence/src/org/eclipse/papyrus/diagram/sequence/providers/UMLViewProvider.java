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
package org.eclipse.papyrus.diagram.sequence.providers;

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
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageName2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.UMLFactory;

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
		 * if (op.getViewKind() == Node.class) return getNodeViewClass(op.getSemanticAdapter(),
		 * op.getContainerView(), op.getSemanticHint()) != null; if (op.getViewKind() == Edge.class)
		 * return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(),
		 * op.getSemanticHint()) != null;
		 */
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return PackageEditPart.MODEL_ID.equals(op.getSemanticHint())
				&& UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
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
				if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in
					// element type
				}
				if (domainElement != null
						&& visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element
					// type
				}
			} else {
				if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case InteractionEditPart.VISUAL_ID:
				case LifelineEditPart.VISUAL_ID:
				case ActionExecutionSpecificationEditPart.VISUAL_ID:
				case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
				case InteractionUseEditPart.VISUAL_ID:
				case CombinedFragmentEditPart.VISUAL_ID:
				case InteractionOperandEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for
						// domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return InteractionEditPart.VISUAL_ID == visualID || LifelineEditPart.VISUAL_ID == visualID
				|| ActionExecutionSpecificationEditPart.VISUAL_ID == visualID
				|| BehaviorExecutionSpecificationEditPart.VISUAL_ID == visualID
				|| InteractionUseEditPart.VISUAL_ID == visualID || CombinedFragmentEditPart.VISUAL_ID == visualID
				|| InteractionOperandEditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same
			// as in element type
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
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if (semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch (visualID) {
		case InteractionEditPart.VISUAL_ID:
			return createInteraction_2001(domainElement, containerView, index, persisted, preferencesHint);
		case LifelineEditPart.VISUAL_ID:
			return createLifeline_3001(domainElement, containerView, index, persisted, preferencesHint);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return createActionExecutionSpecification_3006(domainElement, containerView, index, persisted,
					preferencesHint);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return createBehaviorExecutionSpecification_3003(domainElement, containerView, index, persisted,
					preferencesHint);
		case InteractionUseEditPart.VISUAL_ID:
			return createInteractionUse_3002(domainElement, containerView, index, persisted, preferencesHint);
		case CombinedFragmentEditPart.VISUAL_ID:
			return createCombinedFragment_3004(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionOperandEditPart.VISUAL_ID:
			return createInteractionOperand_3005(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		switch (UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case MessageEditPart.VISUAL_ID:
			return createMessage_4003(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case Message2EditPart.VISUAL_ID:
			return createMessage_4004(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createInteraction_2001(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Interaction");

		initFontStyleFromPrefs(node, prefStore, "Interaction");

		initBackgroundFromPrefs(node, prefStore, "Interaction");

		Node label5001 = createLabel(node, UMLVisualIDRegistry.getType(InteractionNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID),
				false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLifeline_3001(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(LifelineEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Lifeline");

		initBackgroundFromPrefs(node, prefStore, "Lifeline");

		Node label5002 = createLabel(node, UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createBehaviorExecutionSpecification_3003(EObject domainElement, View containerView, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(BehaviorExecutionSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "BehaviorExecutionSpecification");

		initBackgroundFromPrefs(node, prefStore, "BehaviorExecutionSpecification");

		return node;
	}

	/**
	 * @generated
	 */
	public Node createActionExecutionSpecification_3006(EObject domainElement, View containerView, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActionExecutionSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "ActionExecutionSpecification");

		initBackgroundFromPrefs(node, prefStore, "ActionExecutionSpecification");

		Node label5005 = createLabel(node, UMLVisualIDRegistry
				.getType(ActionExecutionSpecificationNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteractionUse_3002(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionUseEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "InteractionUse");

		initBackgroundFromPrefs(node, prefStore, "InteractionUse");

		Node label5003 = createLabel(node, UMLVisualIDRegistry.getType(InteractionUseNameEditPart.VISUAL_ID));
		Node label5004 = createLabel(node, UMLVisualIDRegistry.getType(InteractionUseName2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * Generated not for always have an InteractionOperand on a CombinedFragment
	 * 
	 * @generated NOT
	 */
	public Node createCombinedFragment_3004(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CombinedFragmentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "CombinedFragment");

		initBackgroundFromPrefs(node, prefStore, "CombinedFragment");

		Node compartment = createCompartment(node, UMLVisualIDRegistry
				.getType(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID), false, false, true, true);

		// Add by default an InteractionOperand
		InteractionOperand createInteractionOperand = UMLFactory.eINSTANCE.createInteractionOperand();
		((CombinedFragment) domainElement).getOperands().add(createInteractionOperand);
		createInteractionOperand_3005(createInteractionOperand, compartment, -1, true,
				UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteractionOperand_3005(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionOperandEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "InteractionOperand");

		initBackgroundFromPrefs(node, prefStore, "InteractionOperand");

		return node;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4003(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(edge, prefStore, "Message");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6001 = createLabel(edge, UMLVisualIDRegistry.getType(MessageNameEditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location) label6001.getLayoutConstraint();
		location6001.setX(1);
		location6001.setY(-13);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createMessage_4004(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(Message2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(edge, prefStore, "Message");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6002 = createLabel(edge, UMLVisualIDRegistry.getType(MessageName2EditPart.VISUAL_ID));
		label6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location) label6002.getLayoutConstraint();
		location6002.setX(1);
		location6002.setY(-13);
		return edge;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
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
	private Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort,
			boolean canFilter) {
		// SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		// rv.setShowTitle(showTitle);
		// rv.setCollapsed(isCollapsed);
		Node rv;
		if (canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		if (hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			ts.setShowTitle(true);
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
	private EObject getSemanticElement(IAdaptable semanticAdapter) {
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
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fontConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.FONT);
		String fontColorConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.COLOR_FONT);

		FontStyle viewFontStyle = (FontStyle) view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (viewFontStyle != null) {
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
		String lineColorConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities
				.RGBToInteger(lineRGB));
	}

	/**
	 * @generated
	 */
	private void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fillColorConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.COLOR_FILL);
		String gradientColorConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.GRADIENT_POLICY);

		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities
				.RGBToInteger(fillRGB));

		FillStyle fillStyle = (FillStyle) view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());

		;
		if (store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store
					.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}

}
