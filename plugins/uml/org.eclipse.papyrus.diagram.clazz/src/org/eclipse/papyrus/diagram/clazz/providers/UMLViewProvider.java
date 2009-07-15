/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.providers;

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
import org.eclipse.papyrus.diagram.clazz.edit.parts.*;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.preferences.IPapyrusPreferencesConstant;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractProvider implements IViewProvider {

	/**
	 * @generated
	 */
	public Edge createAbstraction_4006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ABSTRACTION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ABSTRACTION_PREF_FONT, IPapyrusPreferencesConstant.ABSTRACTION_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6014 = createLabel(edge, UMLVisualIDRegistry.getType(AbstractionNameEditPart.VISUAL_ID));
		label6014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6014 = (Location) label6014.getLayoutConstraint();
		location6014.setX(0);
		location6014.setY(40);
		Node label6015 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeAbstractionEditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6015 = (Location) label6015.getLayoutConstraint();
		location6015.setX(0);
		location6015.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createAssociation_2015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AssociationNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ASSOCIATION_PREF_FONT, IPapyrusPreferencesConstant.ASSOCIATION_PREF_FONT_COLOR);

		return node;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_4001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ASSOCIATION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ASSOCIATION_PREF_FONT, IPapyrusPreferencesConstant.ASSOCIATION_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6001 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeAssociationEditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location) label6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(-20);
		Node label6002 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName2EditPart.VISUAL_ID));
		label6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location) label6002.getLayoutConstraint();
		location6002.setX(0);
		location6002.setY(20);
		Node label6003 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName3EditPart.VISUAL_ID));
		label6003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6003 = (Location) label6003.getLayoutConstraint();
		location6003.setX(0);
		location6003.setY(-20);
		Node label6004 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName4EditPart.VISUAL_ID));
		label6004.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6004 = (Location) label6004.getLayoutConstraint();
		location6004.setX(0);
		location6004.setY(20);
		Node label6005 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName5EditPart.VISUAL_ID));
		label6005.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6005 = (Location) label6005.getLayoutConstraint();
		location6005.setX(0);
		location6005.setY(20);
		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName6EditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location) label6006.getLayoutConstraint();
		location6006.setX(0);
		location6006.setY(-20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_4019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AssociationBranchEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ASSOCIATION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ASSOCIATION_PREF_FONT, IPapyrusPreferencesConstant.ASSOCIATION_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6024 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationBranchRoleEditPart.VISUAL_ID));
		label6024.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6024 = (Location) label6024.getLayoutConstraint();
		location6024.setX(0);
		location6024.setY(-20);
		Node label6025 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationBranchMultEditPart.VISUAL_ID));
		label6025.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6025 = (Location) label6025.getLayoutConstraint();
		location6025.setX(0);
		location6025.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createAssociationClass_2013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AssociationClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ASSOCIATIONCLASS_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ASSOCIATIONCLASS_PREF_FONT, IPapyrusPreferencesConstant.ASSOCIATIONCLASS_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ASSOCIATIONCLASS_PREF_FILL_COLOR, IPapyrusPreferencesConstant.ASSOCIATIONCLASS_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.ASSOCIATIONCLASS_PREF_GRADIENT_POLICY);

		Node label5066 = createLabel(node, UMLVisualIDRegistry.getType(AssociationClassName2EditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(AssociationClassAttributeCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createAssociationClass_4017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(AssociationClass2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ASSOCIATIONCLASS_PREF_FONT, IPapyrusPreferencesConstant.ASSOCIATIONCLASS_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createClass_2008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.CLASS_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.CLASS_PREF_FONT, IPapyrusPreferencesConstant.CLASS_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.CLASS_PREF_FILL_COLOR, IPapyrusPreferencesConstant.CLASS_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.CLASS_PREF_GRADIENT_POLICY);

		Node label5029 = createLabel(node, UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ClassAttributeCompartment2EditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassOperationCompartment2EditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassNestedClassifierCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ClassEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.CLASS_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.CLASS_PREF_FILL_COLOR, IPapyrusPreferencesConstant.CLASS_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.CLASS_PREF_GRADIENT_POLICY);

		Node label5014 = createLabel(node, UMLVisualIDRegistry.getType(ClassNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ClassAttributeCompartmentEditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Class5EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.COMMENT_PREF_FONT, IPapyrusPreferencesConstant.COMMENT_PREF_FONT_COLOR);

		Node label5038 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3028(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Comment2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		Node label5063 = createLabel(node, UMLVisualIDRegistry.getType(CommentBody2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4013(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
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
	public Node createComponent_2002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.COMPONENT_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.COMPONENT_PREF_FONT, IPapyrusPreferencesConstant.COMPONENT_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.COMPONENT_PREF_FILL_COLOR, IPapyrusPreferencesConstant.COMPONENT_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.COMPONENT_PREF_GRADIENT_POLICY);

		Node label5005 = createLabel(node, UMLVisualIDRegistry.getType(ComponentNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentAttributeCompartmentEditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentOperationCompartmentEditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentNestedClassifierCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3021(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.COMPONENT_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.COMPONENT_PREF_FILL_COLOR, IPapyrusPreferencesConstant.COMPONENT_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.COMPONENT_PREF_GRADIENT_POLICY);

		Node label5043 = createLabel(node, UMLVisualIDRegistry.getType(ComponentNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentAttributeCompartment2EditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentOperationCompartment2EditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentNestedClassifierCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_2011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.CONSTRAINT_PREF_FONT, IPapyrusPreferencesConstant.CONSTRAINT_PREF_FONT_COLOR);

		Node label5037 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3029(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Constraint2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		Node label5064 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintName2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4014(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createDataType_2010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.DATATYPE_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.DATATYPE_PREF_FONT, IPapyrusPreferencesConstant.DATATYPE_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.DATATYPE_PREF_FILL_COLOR, IPapyrusPreferencesConstant.DATATYPE_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.DATATYPE_PREF_GRADIENT_POLICY);

		Node label5035 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeAttributeCompartmentEditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeOperationCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_3027(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataTypeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.DATATYPE_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.DATATYPE_PREF_FILL_COLOR, IPapyrusPreferencesConstant.DATATYPE_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.DATATYPE_PREF_GRADIENT_POLICY);

		Node label5061 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeAttributeCompartment2EditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeOperationCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDependency_2014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Dependency2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.DEPENDENCY_PREF_FONT, IPapyrusPreferencesConstant.DEPENDENCY_PREF_FONT_COLOR);

		return node;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.DEPENDENCY_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.DEPENDENCY_PREF_FONT, IPapyrusPreferencesConstant.DEPENDENCY_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6026 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		label6026.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6026 = (Location) label6026.getLayoutConstraint();
		location6026.setX(0);
		location6026.setY(40);
		Node label6027 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeDependencyEditPart.VISUAL_ID));
		label6027.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6027 = (Location) label6027.getLayoutConstraint();
		location6027.setX(0);
		location6027.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyBranchEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.DEPENDENCY_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.DEPENDENCY_PREF_FONT, IPapyrusPreferencesConstant.DEPENDENCY_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6028 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyName3EditPart.VISUAL_ID));
		label6028.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6028 = (Location) label6028.getLayoutConstraint();
		location6028.setX(0);
		location6028.setY(40);
		Node label6029 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeDependency3EditPart.VISUAL_ID));
		label6029.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6029 = (Location) label6029.getLayoutConstraint();
		location6029.setX(0);
		location6029.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		diagram.setType(ModelEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	 * @generated
	 */
	public Node createDiagram_2016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ShortCutDiagramEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.SHORTCUTDIAGRAM_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.SHORTCUTDIAGRAM_PREF_FONT, IPapyrusPreferencesConstant.SHORTCUTDIAGRAM_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.SHORTCUTDIAGRAM_PREF_FILL_COLOR, IPapyrusPreferencesConstant.SHORTCUTDIAGRAM_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.SHORTCUTDIAGRAM_PREF_GRADIENT_POLICY);

		Node label0 = createLabel(node, UMLVisualIDRegistry.getType(DiagramNameEditPart.VISUAL_ID));
		label0.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location0 = (Location) label0.getLayoutConstraint();
		location0.setX(0);
		location0.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		switch (UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case CommentLinkDescriptorEditPart.VISUAL_ID:
			return createLink_4016(containerView, index, persisted, preferencesHint);
		case AssociationClass2EditPart.VISUAL_ID:
			return createAssociationClass_4017(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case AssociationEditPart.VISUAL_ID:
			return createAssociation_4001(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case AssociationBranchEditPart.VISUAL_ID:
			return createAssociation_4019(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_4002(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return createInterfaceRealization_4003(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case SubstitutionEditPart.VISUAL_ID:
			return createSubstitution_4004(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case RealizationEditPart.VISUAL_ID:
			return createRealization_4005(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case AbstractionEditPart.VISUAL_ID:
			return createAbstraction_4006(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case UsageEditPart.VISUAL_ID:
			return createUsage_4007(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DependencyEditPart.VISUAL_ID:
			return createDependency_4008(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DependencyBranchEditPart.VISUAL_ID:
			return createDependency_4018(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ElementImportEditPart.VISUAL_ID:
			return createElementImport_4009(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case PackageImportEditPart.VISUAL_ID:
			return createPackageImport_4010(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case PackageMergeEditPart.VISUAL_ID:
			return createPackageMerge_4011(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ProfileApplicationEditPart.VISUAL_ID:
			return createProfileApplication_4012(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4013(containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4014(containerView, index, persisted, preferencesHint);
		case TemplateBindingEditPart.VISUAL_ID:
			return createTemplateBinding_4015(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case GeneralizationSetEditPart.VISUAL_ID:
			return createGeneralizationSet_4020(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createElementImport_4009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ElementImportEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ELEMENTIMPORT_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.ELEMENTIMPORT_PREF_FONT, IPapyrusPreferencesConstant.ELEMENTIMPORT_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6020 = createLabel(edge, UMLVisualIDRegistry.getType(ElementImportAliasEditPart.VISUAL_ID));
		label6020.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6020 = (Location) label6020.getLayoutConstraint();
		location6020.setX(0);
		location6020.setY(40);
		Node label6021 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeElementImportEditPart.VISUAL_ID));
		label6021.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6021 = (Location) label6021.getLayoutConstraint();
		location6021.setX(0);
		location6021.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_2006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(EnumerationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ENUMERATION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ENUMERATION_PREF_FONT, IPapyrusPreferencesConstant.ENUMERATION_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ENUMERATION_PREF_FILL_COLOR, IPapyrusPreferencesConstant.ENUMERATION_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.ENUMERATION_PREF_GRADIENT_POLICY);

		Node label5023 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_3025(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(EnumerationEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ENUMERATION_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.ENUMERATION_PREF_FILL_COLOR, IPapyrusPreferencesConstant.ENUMERATION_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.ENUMERATION_PREF_GRADIENT_POLICY);

		Node label5055 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumerationLiteral_3017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(EnumerationLiteralEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.GENERALIZATION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.GENERALIZATION_PREF_FONT, IPapyrusPreferencesConstant.GENERALIZATION_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotyperGeneralizationEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location) label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralizationSet_4020(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationSetEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.GENERALIZATIONSET_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.GENERALIZATIONSET_PREF_FONT, IPapyrusPreferencesConstant.GENERALIZATIONSET_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label5067 = createLabel(edge, UMLVisualIDRegistry.getType(ConstraintLabelEditPart.VISUAL_ID));
		label5067.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5067 = (Location) label5067.getLayoutConstraint();
		location5067.setX(0);
		location5067.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_2001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InstanceSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_FONT, IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_FILL_COLOR, IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_GRADIENT_POLICY);

		Node label5002 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_3020(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InstanceSpecificationEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_FILL_COLOR, IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.INSTANCESPECIFICATION_PREF_GRADIENT_POLICY);

		Node label5040 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_2004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INTERFACE_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INTERFACE_PREF_FONT, IPapyrusPreferencesConstant.INTERFACE_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INTERFACE_PREF_FILL_COLOR, IPapyrusPreferencesConstant.INTERFACE_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.INTERFACE_PREF_GRADIENT_POLICY);

		Node label5011 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceAttributeCompartmentEditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceOperationCompartmentEditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3023(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InterfaceEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INTERFACE_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.INTERFACE_PREF_FILL_COLOR, IPapyrusPreferencesConstant.INTERFACE_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.INTERFACE_PREF_GRADIENT_POLICY);

		Node label5049 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceAttributeCompartment2EditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceOperationCompartment2EditPart.VISUAL_ID), true, false, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createInterfaceRealization_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.INTERFACEREALIZATION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.INTERFACEREALIZATION_PREF_FONT, IPapyrusPreferencesConstant.INTERFACEREALIZATION_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location) label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(40);
		Node label6009 = createLabel(edge, UMLVisualIDRegistry.getType(InterfaceRealizationName2EditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6009 = (Location) label6009.getLayoutConstraint();
		location6009.setX(0);
		location6009.setY(60);
		return edge;
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
	public Edge createLink_4016(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentLinkDescriptorEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createModel_2005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ModelEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.MODEL_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.MODEL_PREF_FONT, IPapyrusPreferencesConstant.MODEL_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.MODEL_PREF_FILL_COLOR, IPapyrusPreferencesConstant.MODEL_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.MODEL_PREF_GRADIENT_POLICY);

		Node label5020 = createLabel(node, UMLVisualIDRegistry.getType(ModelNameEditPartTN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ModelPackageableElementCompartmentEditPart.VISUAL_ID), false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_3024(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ModelEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.MODEL_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.MODEL_PREF_FILL_COLOR, IPapyrusPreferencesConstant.MODEL_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.MODEL_PREF_GRADIENT_POLICY);

		Node label5052 = createLabel(node, UMLVisualIDRegistry.getType(ModelNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ModelPackageableElementCompartment2EditPart.VISUAL_ID), false, false, false, false);
		return node;
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
		case Dependency2EditPart.VISUAL_ID:
			return createDependency_2014(domainElement, containerView, index, persisted, preferencesHint);
		case AssociationClassEditPart.VISUAL_ID:
			return createAssociationClass_2013(domainElement, containerView, index, persisted, preferencesHint);
		case AssociationNodeEditPart.VISUAL_ID:
			return createAssociation_2015(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return createInstanceSpecification_2001(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentEditPart.VISUAL_ID:
			return createComponent_2002(domainElement, containerView, index, persisted, preferencesHint);
		case SignalEditPart.VISUAL_ID:
			return createSignal_2003(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPart.VISUAL_ID:
			return createInterface_2004(domainElement, containerView, index, persisted, preferencesHint);
		case ModelEditPartTN.VISUAL_ID:
			return createModel_2005(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationEditPart.VISUAL_ID:
			return createEnumeration_2006(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPart.VISUAL_ID:
			return createPackage_2007(domainElement, containerView, index, persisted, preferencesHint);
		case ClassEditPart.VISUAL_ID:
			return createClass_2008(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return createPrimitiveType_2009(domainElement, containerView, index, persisted, preferencesHint);
		case DataTypeEditPart.VISUAL_ID:
			return createDataType_2010(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_2011(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_2012(domainElement, containerView, index, persisted, preferencesHint);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return createDiagram_2016(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyEditPart.VISUAL_ID:
			return createProperty_3002(domainElement, containerView, index, persisted, preferencesHint);
		case SlotEditPart.VISUAL_ID:
			return createSlot_3001(domainElement, containerView, index, persisted, preferencesHint);
		case OperationEditPart.VISUAL_ID:
			return createOperation_3003(domainElement, containerView, index, persisted, preferencesHint);
		case Class2EditPart.VISUAL_ID:
			return createClass_3004(domainElement, containerView, index, persisted, preferencesHint);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return createRedefinableTemplateSignature_3015(domainElement, containerView, index, persisted, preferencesHint);
		case TemplateParameterEditPart.VISUAL_ID:
			return createTemplateParameter_3016(domainElement, containerView, index, persisted, preferencesHint);
		case Property2EditPart.VISUAL_ID:
			return createProperty_3005(domainElement, containerView, index, persisted, preferencesHint);
		case Property3EditPart.VISUAL_ID:
			return createProperty_3006(domainElement, containerView, index, persisted, preferencesHint);
		case Operation2EditPart.VISUAL_ID:
			return createOperation_3007(domainElement, containerView, index, persisted, preferencesHint);
		case Class3EditPart.VISUAL_ID:
			return createClass_3008(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceSpecificationEditPartCN.VISUAL_ID:
			return createInstanceSpecification_3020(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentEditPartCN.VISUAL_ID:
			return createComponent_3021(domainElement, containerView, index, persisted, preferencesHint);
		case SignalEditPartCN.VISUAL_ID:
			return createSignal_3022(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPartCN.VISUAL_ID:
			return createInterface_3023(domainElement, containerView, index, persisted, preferencesHint);
		case ModelEditPartCN.VISUAL_ID:
			return createModel_3024(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationEditPartCN.VISUAL_ID:
			return createEnumeration_3025(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return createEnumerationLiteral_3017(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPartCN.VISUAL_ID:
			return createPackage_3009(domainElement, containerView, index, persisted, preferencesHint);
		case ClassEditPartCN.VISUAL_ID:
			return createClass_3010(domainElement, containerView, index, persisted, preferencesHint);
		case ReceptionEditPart.VISUAL_ID:
			return createReception_3011(domainElement, containerView, index, persisted, preferencesHint);
		case Property4EditPart.VISUAL_ID:
			return createProperty_3012(domainElement, containerView, index, persisted, preferencesHint);
		case Operation3EditPart.VISUAL_ID:
			return createOperation_3013(domainElement, containerView, index, persisted, preferencesHint);
		case Class5EditPart.VISUAL_ID:
			return createClass_3014(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return createPrimitiveType_3026(domainElement, containerView, index, persisted, preferencesHint);
		case DataTypeEditPartCN.VISUAL_ID:
			return createDataType_3027(domainElement, containerView, index, persisted, preferencesHint);
		case Property5EditPart.VISUAL_ID:
			return createProperty_3018(domainElement, containerView, index, persisted, preferencesHint);
		case Operation4EditPart.VISUAL_ID:
			return createOperation_3019(domainElement, containerView, index, persisted, preferencesHint);
		case Comment2EditPart.VISUAL_ID:
			return createComment_3028(domainElement, containerView, index, persisted, preferencesHint);
		case Constraint2EditPart.VISUAL_ID:
			return createConstraint_3029(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Operation2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Operation3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Operation4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PACKAGE_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PACKAGE_PREF_FONT, IPapyrusPreferencesConstant.PACKAGE_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PACKAGE_PREF_FILL_COLOR, IPapyrusPreferencesConstant.PACKAGE_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.PACKAGE_PREF_GRADIENT_POLICY);

		Node label5026 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID), false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_3009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PACKAGE_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PACKAGE_PREF_FILL_COLOR, IPapyrusPreferencesConstant.PACKAGE_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.PACKAGE_PREF_GRADIENT_POLICY);

		Node label5017 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID), false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createPackageImport_4010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.PACKAGEIMPORT_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.PACKAGEIMPORT_PREF_FONT, IPapyrusPreferencesConstant.PACKAGEIMPORT_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6022 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypePackageImportEditPart.VISUAL_ID));
		label6022.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6022 = (Location) label6022.getLayoutConstraint();
		location6022.setX(0);
		location6022.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageMerge_4011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_FONT, IPapyrusPreferencesConstant.PACKAGEMERGE_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_2009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_FONT, IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_FILL_COLOR, IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_GRADIENT_POLICY);

		Node label5032 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_3026(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveTypeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_FILL_COLOR, IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.PRIMITIVETYPE_PREF_GRADIENT_POLICY);

		Node label5058 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeNameEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createProfileApplication_4012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ProfileApplicationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.PROFILEAPPLICATION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.PROFILEAPPLICATION_PREF_FONT, IPapyrusPreferencesConstant.PROFILEAPPLICATION_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property5EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createRealization_4005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.REALIZATION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.REALIZATION_PREF_FONT, IPapyrusPreferencesConstant.REALIZATION_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6012 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeRealizationEditPart.VISUAL_ID));
		label6012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6012 = (Location) label6012.getLayoutConstraint();
		location6012.setX(0);
		location6012.setY(40);
		Node label6013 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationName2EditPart.VISUAL_ID));
		label6013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6013 = (Location) label6013.getLayoutConstraint();
		location6013.setX(0);
		location6013.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createReception_3011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ReceptionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createRedefinableTemplateSignature_3015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(RedefinableTemplateSignatureEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		createCompartment(node, UMLVisualIDRegistry.getType(RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID), false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignal_2003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SignalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.SIGNAL_PREF_LINE_COLOR);

		initFontStyleFromPrefs(node, prefStore, IPapyrusPreferencesConstant.SIGNAL_PREF_FONT, IPapyrusPreferencesConstant.SIGNAL_PREF_FONT_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.SIGNAL_PREF_FILL_COLOR, IPapyrusPreferencesConstant.SIGNAL_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.SIGNAL_PREF_GRADIENT_POLICY);

		Node label5008 = createLabel(node, UMLVisualIDRegistry.getType(SignalNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(SignalAttributeCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignal_3022(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SignalEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.SIGNAL_PREF_LINE_COLOR);

		initBackgroundFromPrefs(node, prefStore, IPapyrusPreferencesConstant.SIGNAL_PREF_FILL_COLOR, IPapyrusPreferencesConstant.SIGNAL_PREF_GRADIENT_COLOR,
				IPapyrusPreferencesConstant.SIGNAL_PREF_GRADIENT_POLICY);

		Node label5046 = createLabel(node, UMLVisualIDRegistry.getType(SignalNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(SignalAttributeCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSlot_3001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SlotEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		return node;
	}

	/**
	 * @generated
	 */
	public Edge createSubstitution_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(SubstitutionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.SUBSTITUTION_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.SUBSTITUTION_PREF_FONT, IPapyrusPreferencesConstant.SUBSTITUTION_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6010 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeSubstitutionEditPart.VISUAL_ID));
		label6010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6010 = (Location) label6010.getLayoutConstraint();
		location6010.setX(0);
		location6010.setY(40);
		Node label6011 = createLabel(edge, UMLVisualIDRegistry.getType(SubstitutionName2EditPart.VISUAL_ID));
		label6011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6011 = (Location) label6011.getLayoutConstraint();
		location6011.setX(0);
		location6011.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createTemplateBinding_4015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(TemplateBindingEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_FONT, IPapyrusPreferencesConstant.TEMPLATEBINDING_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6023 = createLabel(edge, UMLVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		label6023.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6023 = (Location) label6023.getLayoutConstraint();
		location6023.setX(0);
		location6023.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Node createTemplateParameter_3016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(TemplateParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createUsage_4007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.USAGE_PREF_LINE_COLOR);

		initFontStyleFromPrefs(edge, prefStore, IPapyrusPreferencesConstant.USAGE_PREF_FONT, IPapyrusPreferencesConstant.USAGE_PREF_FONT_COLOR);

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6016 = createLabel(edge, UMLVisualIDRegistry.getType(UsageNameEditPart.VISUAL_ID));
		label6016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6016 = (Location) label6016.getLayoutConstraint();
		location6016.setX(0);
		location6016.setY(40);
		Node label6017 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeUsageEditPart.VISUAL_ID));
		label6017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6017 = (Location) label6017.getLayoutConstraint();
		location6017.setX(0);
		location6017.setY(60);
		return edge;
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
	private void initBackgroundFromPrefs(View view, final IPreferenceStore store, String fillColorConstant, String gradientColorConstant, String gradientPolicyConstant) {
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));

		FillStyle fillStyle = (FillStyle) view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());

		;
		if (store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}

	/**
	 * @generated
	 */
	private void initFontStyleFromPrefs(View view, final IPreferenceStore store, String fontConstant, String fontColorConstant) {
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
	private void initForegroundFromPrefs(View view, final IPreferenceStore store, String lineColorConstant) {
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return ModelEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
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
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if (!ModelEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case Dependency2EditPart.VISUAL_ID:
				case AssociationClassEditPart.VISUAL_ID:
				case AssociationNodeEditPart.VISUAL_ID:
				case InstanceSpecificationEditPart.VISUAL_ID:
				case ComponentEditPart.VISUAL_ID:
				case SignalEditPart.VISUAL_ID:
				case InterfaceEditPart.VISUAL_ID:
				case ModelEditPartTN.VISUAL_ID:
				case ShortCutDiagramEditPart.VISUAL_ID:
				case PropertyEditPart.VISUAL_ID:
				case SlotEditPart.VISUAL_ID:
				case OperationEditPart.VISUAL_ID:
				case Class2EditPart.VISUAL_ID:
				case RedefinableTemplateSignatureEditPart.VISUAL_ID:
				case TemplateParameterEditPart.VISUAL_ID:
				case EnumerationEditPartCN.VISUAL_ID:
				case EnumerationLiteralEditPart.VISUAL_ID:
				case ReceptionEditPart.VISUAL_ID:
				case PrimitiveTypeEditPartCN.VISUAL_ID:
				case DataTypeEditPartCN.VISUAL_ID:
				case Comment2EditPart.VISUAL_ID:
				case Constraint2EditPart.VISUAL_ID:
				case EnumerationEditPart.VISUAL_ID:
				case PackageEditPart.VISUAL_ID:
				case ClassEditPart.VISUAL_ID:
				case PrimitiveTypeEditPart.VISUAL_ID:
				case DataTypeEditPart.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case Property2EditPart.VISUAL_ID:
				case Property3EditPart.VISUAL_ID:
				case Operation2EditPart.VISUAL_ID:
				case Class3EditPart.VISUAL_ID:
				case InstanceSpecificationEditPartCN.VISUAL_ID:
				case ComponentEditPartCN.VISUAL_ID:
				case SignalEditPartCN.VISUAL_ID:
				case InterfaceEditPartCN.VISUAL_ID:
				case ModelEditPartCN.VISUAL_ID:
				case PackageEditPartCN.VISUAL_ID:
				case ClassEditPartCN.VISUAL_ID:
				case Property4EditPart.VISUAL_ID:
				case Operation3EditPart.VISUAL_ID:
				case Class5EditPart.VISUAL_ID:
				case Property5EditPart.VISUAL_ID:
				case Operation4EditPart.VISUAL_ID:
					if (domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return Dependency2EditPart.VISUAL_ID == visualID || AssociationClassEditPart.VISUAL_ID == visualID || AssociationNodeEditPart.VISUAL_ID == visualID
				|| InstanceSpecificationEditPart.VISUAL_ID == visualID || ComponentEditPart.VISUAL_ID == visualID || SignalEditPart.VISUAL_ID == visualID || InterfaceEditPart.VISUAL_ID == visualID
				|| ModelEditPartTN.VISUAL_ID == visualID || EnumerationEditPart.VISUAL_ID == visualID || PackageEditPart.VISUAL_ID == visualID || ClassEditPart.VISUAL_ID == visualID
				|| PrimitiveTypeEditPart.VISUAL_ID == visualID || DataTypeEditPart.VISUAL_ID == visualID || ConstraintEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID
				|| ShortCutDiagramEditPart.VISUAL_ID == visualID || PropertyEditPart.VISUAL_ID == visualID || SlotEditPart.VISUAL_ID == visualID || OperationEditPart.VISUAL_ID == visualID
				|| Class2EditPart.VISUAL_ID == visualID || RedefinableTemplateSignatureEditPart.VISUAL_ID == visualID || TemplateParameterEditPart.VISUAL_ID == visualID
				|| Property2EditPart.VISUAL_ID == visualID || Property3EditPart.VISUAL_ID == visualID || Operation2EditPart.VISUAL_ID == visualID || Class3EditPart.VISUAL_ID == visualID
				|| InstanceSpecificationEditPartCN.VISUAL_ID == visualID || ComponentEditPartCN.VISUAL_ID == visualID || SignalEditPartCN.VISUAL_ID == visualID
				|| InterfaceEditPartCN.VISUAL_ID == visualID || ModelEditPartCN.VISUAL_ID == visualID || EnumerationEditPartCN.VISUAL_ID == visualID
				|| EnumerationLiteralEditPart.VISUAL_ID == visualID || PackageEditPartCN.VISUAL_ID == visualID || ClassEditPartCN.VISUAL_ID == visualID || ReceptionEditPart.VISUAL_ID == visualID
				|| Property4EditPart.VISUAL_ID == visualID || Operation3EditPart.VISUAL_ID == visualID || Class5EditPart.VISUAL_ID == visualID || PrimitiveTypeEditPartCN.VISUAL_ID == visualID
				|| DataTypeEditPartCN.VISUAL_ID == visualID || Property5EditPart.VISUAL_ID == visualID || Operation4EditPart.VISUAL_ID == visualID || Comment2EditPart.VISUAL_ID == visualID
				|| Constraint2EditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		/*
		 * if (op.getViewKind() == Node.class) return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null; if (op.getViewKind() == Edge.class) return
		 * getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 */
		return true;
	}

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
	private void stampShortcut(View containerView, Node target) {
		if (!ModelEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ModelEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
