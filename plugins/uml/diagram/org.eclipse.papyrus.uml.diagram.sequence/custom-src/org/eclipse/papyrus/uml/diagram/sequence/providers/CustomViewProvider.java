/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandGuardEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomViewProvider extends UMLViewProvider {

	protected boolean provides(CreateNodeViewOperation op) {
		if (op.getContainerView() == null) {
			return false;
		}
		int visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
		if (visualID == DurationConstraintEditPart.VISUAL_ID) { // avoid to
																// modify
																// UMLVisualIDRegistry.getNodeVisualID(View,
																// EObject)
			if (InteractionInteractionCompartmentEditPart.VISUAL_ID == UMLVisualIDRegistry
					.getVisualID(op.getContainerView()))
				return true;
		}
		return super.provides(op);
	}

	protected boolean provides(CreateViewForKindOperation op) {
		if (op.getContainerView() == null) {
			return false;
		}
		int visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
		if (visualID == DurationConstraintEditPart.VISUAL_ID) { // avoid to
																// modify
																// UMLVisualIDRegistry.getNodeVisualID(View,
																// EObject)
			if (InteractionInteractionCompartmentEditPart.VISUAL_ID == UMLVisualIDRegistry
					.getVisualID(op.getContainerView()))
				return true;
		}
		return super.provides(op);
	}

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = super.createEdge(semanticAdapter, containerView,
				semanticHint, index, persisted, preferencesHint);
		if (edge != null) {
			edge.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
			final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
					.getPreferenceStore();
			PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge,
					prefStore, "Message");
		}
		return edge;
	}

	public Node createTimeObservation_3020(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry
				.getType(TimeObservationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node,
				prefStore, "TimeObservation");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node,
				prefStore, "TimeObservation");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node,
				prefStore, "TimeObservation");
		Node label5010 = createLabel(node,
				UMLVisualIDRegistry
						.getType(TimeObservationLabelEditPart.VISUAL_ID), true);
		label5010.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location5010 = (Location) label5010.getLayoutConstraint();
		location5010.setX(0);
		location5010.setY(0);
		Node label5014 = createLabel(
				node,
				UMLVisualIDRegistry
						.getType(TimeObservationAppliedStereotypeEditPart.VISUAL_ID),
				true);
		label5014.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location5014 = (Location) label5014.getLayoutConstraint();
		location5014.setX(0);
		location5014.setY(0);
		return node;
	}

	protected Node createLabel(View owner, String hint,
			boolean isTimeObservationLable) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(hint);
		ViewUtil.insertChildView(owner, node, ViewUtil.APPEND, true);
		return node;
	}

	public Node createDurationConstraint_3021(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry
				.getType(DurationConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node,
				prefStore, "DurationConstraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node,
				prefStore, "DurationConstraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node,
				prefStore, "DurationConstraint");
		Node label5011 = createLabel(node,
				UMLVisualIDRegistry
						.getType(DurationConstraintLabelEditPart.VISUAL_ID));
		label5011.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location5011 = (Location) label5011.getLayoutConstraint();
		location5011.setX(25);
		location5011.setY(0);
		Node label5015 = createLabel(
				node,
				UMLVisualIDRegistry
						.getType(DurationConstraintAppliedStereotypeEditPart.VISUAL_ID));
		label5015.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location5015 = (Location) label5015.getLayoutConstraint();
		location5015.setX(0);
		location5015.setY(-22);
		return node;
	}

	public Node createCombinedFragment_3004(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry
				.getType(CombinedFragmentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node,
				prefStore, "CombinedFragment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node,
				prefStore, "CombinedFragment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node,
				prefStore, "CombinedFragment");
		Node compartment = createCompartment(
				node,
				UMLVisualIDRegistry
						.getType(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID),
				false, false, true, true);
		// Add by default InteractionOperand
		for (InteractionOperand interactionOperand : ((CombinedFragment) domainElement)
				.getOperands()) {
			createInteractionOperand_3005(interactionOperand, compartment, -1,
					true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		}
		// initialization for the compartment visibility
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(
				node, prefStore, "CombinedFragment");
		return node;
	}

	public Node createDurationConstraint_3023(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles()
				.add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry
				.getType(DurationConstraintInMessageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// custom layout for location
		Location location3023 = (Location) node.getLayoutConstraint();
		location3023.setX(0);
		location3023.setY(20);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node,
				prefStore, "DurationConstraint");
		Node label5018 = createLabel(
				node,
				UMLVisualIDRegistry
						.getType(DurationConstraintInMessageLabelEditPart.VISUAL_ID));
		Node label5019 = createLabel(
				node,
				UMLVisualIDRegistry
						.getType(DurationConstraintInMessageAppliedStereotypeEditPart.VISUAL_ID));
		label5019.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location5019 = (Location) label5019.getLayoutConstraint();
		location5019.setX(0);
		location5019.setY(-22);
		return node;
	}

	public Node createDurationObservation_3024(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles()
				.add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry
				.getType(DurationObservationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// custom layout for location
		Location location3024 = (Location) node.getLayoutConstraint();
		location3024.setX(0);
		location3024.setY(0);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node,
				prefStore, "DurationObservation");
		Node label5016 = createLabel(node,
				UMLVisualIDRegistry
						.getType(DurationObservationLabelEditPart.VISUAL_ID));
		Node label5017 = createLabel(
				node,
				UMLVisualIDRegistry
						.getType(DurationObservationAppliedStereotypeEditPart.VISUAL_ID));
		label5017.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		Location location5017 = (Location) label5017.getLayoutConstraint();
		location5017.setX(0);
		location5017.setY(0);
		return node;
	}

	public Node createConsiderIgnoreFragment_3007(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry
				.getType(ConsiderIgnoreFragmentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node,
				prefStore, "ConsiderIgnoreFragment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node,
				prefStore, "ConsiderIgnoreFragment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node,
				prefStore, "ConsiderIgnoreFragment");
		Node compartment = createCompartment(
				node,
				UMLVisualIDRegistry
						.getType(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID),
				false, false, true, true);
		// Add by default InteractionOperand
		for (InteractionOperand interactionOperand : ((CombinedFragment) domainElement)
				.getOperands()) {
			createInteractionOperand_3005(interactionOperand, compartment, -1,
					true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		}
		// initialization for the compartment visibility
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(
				node, prefStore, "ConsiderIgnoreFragment");
		return node;
	}

	public Edge createCommentAnnotatedElement_4010(View containerView,
			int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge(); // override
															// Connector
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE
				.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(
				2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry
				.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint
				.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge,
				prefStore, "Undefined");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge,
				prefStore, "Undefined");
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge,
				prefStore, "Undefined");
		return edge;
	}

	// Add Guard label support.
	@Override
	public Node createInteractionOperand_3005(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = super.createInteractionOperand_3005(domainElement,
				containerView, index, persisted, preferencesHint);
		DecorationNode guardNode = NotationFactory.eINSTANCE
				.createDecorationNode();
		Bounds b = NotationFactory.eINSTANCE.createBounds();
		b.setX(5);
		b.setY(5);
		guardNode.setLayoutConstraint(b);
		guardNode.setType(InteractionOperandGuardEditPart.GUARD_TYPE);
		guardNode.setElement(((InteractionOperand) domainElement).getGuard());
		ViewUtil.insertChildView(node, guardNode, ViewUtil.APPEND, true);
		return node;
	}

	@Override
	public Node createBehaviorExecutionSpecification_3003(
			EObject domainElement, View containerView, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		Node node = super
				.createBehaviorExecutionSpecification_3003(domainElement,
						containerView, index, persisted, preferencesHint);
		// Add a label for Behavior.
		Node label = createLabel(node,
				BehaviorExecutionSpecificationBehaviorEditPart.BEHAVIOR_TYPE);
		Location location = NotationFactory.eINSTANCE.createLocation();
		location.setX(18);
		location.setY(18);
		label.setLayoutConstraint(location);
		return node;
	}
}
