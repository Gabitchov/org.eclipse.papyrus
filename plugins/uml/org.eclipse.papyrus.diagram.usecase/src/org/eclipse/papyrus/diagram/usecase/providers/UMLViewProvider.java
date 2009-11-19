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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers;

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
import org.eclipse.papyrus.diagram.usecase.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorName4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypeAbstractionEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypePackageImportEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypePackageMergeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypeRealizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AppliedStereotypeUsageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBody2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Component2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecases2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecases3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecasesEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Constraint3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DiagramNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendsLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeLink_fixedEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageNameEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.RealizationNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UsageNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseExtensionpointsEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseName4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
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
		return UseCaseDiagramEditPart.MODEL_ID.equals(op.getSemanticHint())
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
				if (!UseCaseDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case ActorEditPart.VISUAL_ID:
				case UseCaseEditPart.VISUAL_ID:
				case ComponentEditPart.VISUAL_ID:
				case ShortCutDiagramEditPart.VISUAL_ID:
				case ExtensionPointEditPart.VISUAL_ID:
				case Comment2EditPart.VISUAL_ID:
				case Constraint2EditPart.VISUAL_ID:
				case Actor2EditPart.VISUAL_ID:
				case UseCase2EditPart.VISUAL_ID:
				case PackageEditPartTN.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case ExtensionPoint2EditPart.VISUAL_ID:
				case UseCase3EditPart.VISUAL_ID:
				case Component2EditPart.VISUAL_ID:
				case Actor4EditPart.VISUAL_ID:
				case Constraint3EditPart.VISUAL_ID:
				case Actor3EditPart.VISUAL_ID:
				case UseCase4EditPart.VISUAL_ID:
				case Component3EditPart.VISUAL_ID:
				case PackageEditPartCN.VISUAL_ID:
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
		return ActorEditPart.VISUAL_ID == visualID || Actor2EditPart.VISUAL_ID == visualID
				|| UseCaseEditPart.VISUAL_ID == visualID || UseCase2EditPart.VISUAL_ID == visualID
				|| ComponentEditPart.VISUAL_ID == visualID || PackageEditPartTN.VISUAL_ID == visualID
				|| ConstraintEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID
				|| ShortCutDiagramEditPart.VISUAL_ID == visualID || ExtensionPointEditPart.VISUAL_ID == visualID
				|| ExtensionPoint2EditPart.VISUAL_ID == visualID || UseCase3EditPart.VISUAL_ID == visualID
				|| Component2EditPart.VISUAL_ID == visualID || Comment2EditPart.VISUAL_ID == visualID
				|| Constraint2EditPart.VISUAL_ID == visualID || Actor4EditPart.VISUAL_ID == visualID
				|| Constraint3EditPart.VISUAL_ID == visualID || Actor3EditPart.VISUAL_ID == visualID
				|| UseCase4EditPart.VISUAL_ID == visualID || Component3EditPart.VISUAL_ID == visualID
				|| PackageEditPartCN.VISUAL_ID == visualID;
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
		diagram.setType(UseCaseDiagramEditPart.MODEL_ID);
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
		case ActorEditPart.VISUAL_ID:
			return createActor_2011(domainElement, containerView, index, persisted, preferencesHint);
		case Actor2EditPart.VISUAL_ID:
			return createActor_2012(domainElement, containerView, index, persisted, preferencesHint);
		case UseCaseEditPart.VISUAL_ID:
			return createUseCase_2013(domainElement, containerView, index, persisted, preferencesHint);
		case UseCase2EditPart.VISUAL_ID:
			return createUseCase_2014(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentEditPart.VISUAL_ID:
			return createComponent_2015(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPartTN.VISUAL_ID:
			return createPackage_2016(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_2017(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_2018(domainElement, containerView, index, persisted, preferencesHint);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return createDiagram_2019(domainElement, containerView, index, persisted, preferencesHint);
		case ExtensionPointEditPart.VISUAL_ID:
			return createExtensionPoint_3007(domainElement, containerView, index, persisted, preferencesHint);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return createExtensionPoint_3008(domainElement, containerView, index, persisted, preferencesHint);
		case UseCase3EditPart.VISUAL_ID:
			return createUseCase_3009(domainElement, containerView, index, persisted, preferencesHint);
		case Component2EditPart.VISUAL_ID:
			return createComponent_3016(domainElement, containerView, index, persisted, preferencesHint);
		case Comment2EditPart.VISUAL_ID:
			return createComment_3015(domainElement, containerView, index, persisted, preferencesHint);
		case Constraint2EditPart.VISUAL_ID:
			return createConstraint_3017(domainElement, containerView, index, persisted, preferencesHint);
		case Actor4EditPart.VISUAL_ID:
			return createActor_3018(domainElement, containerView, index, persisted, preferencesHint);
		case Constraint3EditPart.VISUAL_ID:
			return createConstraint_3010(domainElement, containerView, index, persisted, preferencesHint);
		case Actor3EditPart.VISUAL_ID:
			return createActor_3011(domainElement, containerView, index, persisted, preferencesHint);
		case UseCase4EditPart.VISUAL_ID:
			return createUseCase_3012(domainElement, containerView, index, persisted, preferencesHint);
		case Component3EditPart.VISUAL_ID:
			return createComponent_3013(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPartCN.VISUAL_ID:
			return createPackage_3014(domainElement, containerView, index, persisted, preferencesHint);
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
		case IncludeEditPart.VISUAL_ID:
			return createInclude_4008(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case ExtendEditPart.VISUAL_ID:
			return createExtend_4009(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_4010(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case AssociationEditPart.VISUAL_ID:
			return createAssociation_4011(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4012(containerView, index, persisted, preferencesHint);
		case DependencyEditPart.VISUAL_ID:
			return createDependency_4013(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4014(containerView, index, persisted, preferencesHint);
		case AbstractionEditPart.VISUAL_ID:
			return createAbstraction_4015(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case UsageEditPart.VISUAL_ID:
			return createUsage_4016(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case RealizationEditPart.VISUAL_ID:
			return createRealization_4017(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case PackageMergeEditPart.VISUAL_ID:
			return createPackageMerge_4018(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case PackageImportEditPart.VISUAL_ID:
			return createPackageImport_4019(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createActor_2011(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActorEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Actor");

		initFontStyleFromPrefs(node, prefStore, "Actor");

		initBackgroundFromPrefs(node, prefStore, "Actor");

		Node label5014 = createLabel(node, UMLVisualIDRegistry.getType(ActorNameEditPart.VISUAL_ID));
		label5014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5014 = (Location) label5014.getLayoutConstraint();
		location5014.setX(0);
		location5014.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActor_2012(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Actor");

		initFontStyleFromPrefs(node, prefStore, "Actor");

		initBackgroundFromPrefs(node, prefStore, "Actor");

		Node label5015 = createLabel(node, UMLVisualIDRegistry.getType(ActorName2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_2013(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "UseCase");

		initFontStyleFromPrefs(node, prefStore, "UseCase");

		initBackgroundFromPrefs(node, prefStore, "UseCase");

		Node label5016 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(UseCasePointsEditPart.VISUAL_ID), false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_2014(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "UseCase");

		initFontStyleFromPrefs(node, prefStore, "UseCase");

		initBackgroundFromPrefs(node, prefStore, "UseCase");

		Node label5017 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseName2EditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(UseCaseExtensionpointsEditPart.VISUAL_ID), true, true,
				true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_2015(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Component");

		initFontStyleFromPrefs(node, prefStore, "Component");

		Node label5019 = createLabel(node, UMLVisualIDRegistry.getType(ComponentNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentUsecasesEditPart.VISUAL_ID), false, false, false,
				false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2016(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Package");

		initFontStyleFromPrefs(node, prefStore, "Package");

		initBackgroundFromPrefs(node, prefStore, "Package");

		Node label5025 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPartTN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID),
				false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_2017(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(node, prefStore, "Constraint");

		Node label5026 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2018(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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

		initFontStyleFromPrefs(node, prefStore, "Comment");

		Node label5027 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDiagram_2019(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ShortCutDiagramEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "ShortCutDiagram");

		initFontStyleFromPrefs(node, prefStore, "ShortCutDiagram");

		initBackgroundFromPrefs(node, prefStore, "ShortCutDiagram");

		Node label5032 = createLabel(node, UMLVisualIDRegistry.getType(DiagramNameEditPart.VISUAL_ID));
		label5032.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5032 = (Location) label5032.getLayoutConstraint();
		location5032.setX(0);
		location5032.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExtensionPoint_3007(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExtensionPoint_3008(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ExtensionPoint2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_3009(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "UseCase");

		initBackgroundFromPrefs(node, prefStore, "UseCase");

		Node label5018 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseName3EditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(UseCasePoints2EditPart.VISUAL_ID), false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3016(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Component2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Component");

		Node label5030 = createLabel(node, UMLVisualIDRegistry.getType(ComponentName2EditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentUsecases2EditPart.VISUAL_ID), false, false, false,
				false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3015(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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
		Node label5028 = createLabel(node, UMLVisualIDRegistry.getType(CommentBody2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3017(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Constraint2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		Node label5029 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintName2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActor_3018(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Actor4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Actor");

		initBackgroundFromPrefs(node, prefStore, "Actor");

		Node label5031 = createLabel(node, UMLVisualIDRegistry.getType(ActorName4EditPart.VISUAL_ID));
		label5031.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5031 = (Location) label5031.getLayoutConstraint();
		location5031.setX(0);
		location5031.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3010(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Constraint3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		Node label5020 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintName3EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActor_3011(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Actor");

		initBackgroundFromPrefs(node, prefStore, "Actor");

		Node label5021 = createLabel(node, UMLVisualIDRegistry.getType(ActorName3EditPart.VISUAL_ID));
		label5021.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5021 = (Location) label5021.getLayoutConstraint();
		location5021.setX(0);
		location5021.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_3012(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "UseCase");

		initBackgroundFromPrefs(node, prefStore, "UseCase");

		Node label5022 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseName4EditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(UseCasePoints3EditPart.VISUAL_ID), false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3013(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Component3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Component");

		Node label5023 = createLabel(node, UMLVisualIDRegistry.getType(ComponentName3EditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentUsecases3EditPart.VISUAL_ID), false, false, false,
				false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_3014(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initForegroundFromPrefs(node, prefStore, "Package");

		initBackgroundFromPrefs(node, prefStore, "Package");

		Node label5024 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID),
				false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createInclude_4008(EObject domainElement, View containerView, int index, boolean persisted,
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
		edge.setType(UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(edge, prefStore, "Include");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(IncludeLink_fixedEditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location) label6006.getLayoutConstraint();
		location6006.setX(0);
		location6006.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createExtend_4009(EObject domainElement, View containerView, int index, boolean persisted,
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
		edge.setType(UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(edge, prefStore, "Extend");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(ExtendsLink_fixedEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location) label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4010(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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

		initForegroundFromPrefs(edge, prefStore, "Generalization");

		initFontStyleFromPrefs(edge, prefStore, "Generalization");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_4011(EObject domainElement, View containerView, int index, boolean persisted,
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
		edge.setType(UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		initFontStyleFromPrefs(edge, prefStore, "Association");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationNameEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location) label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4012(View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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
	public Edge createDependency_4013(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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

		initForegroundFromPrefs(edge, prefStore, "Dependency");

		initFontStyleFromPrefs(edge, prefStore, "Dependency");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6010 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		label6010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6010 = (Location) label6010.getLayoutConstraint();
		location6010.setX(0);
		location6010.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4014(View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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
	public Edge createAbstraction_4015(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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

		initForegroundFromPrefs(edge, prefStore, "Abstraction");

		initFontStyleFromPrefs(edge, prefStore, "Abstraction");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6011 = createLabel(edge, UMLVisualIDRegistry.getType(AbstractionNameEditPart.VISUAL_ID));
		label6011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6011 = (Location) label6011.getLayoutConstraint();
		location6011.setX(0);
		location6011.setY(40);
		Node label6014 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeAbstractionEditPart.VISUAL_ID));
		label6014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6014 = (Location) label6014.getLayoutConstraint();
		location6014.setX(0);
		location6014.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createUsage_4016(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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

		initForegroundFromPrefs(edge, prefStore, "Usage");

		initFontStyleFromPrefs(edge, prefStore, "Usage");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6012 = createLabel(edge, UMLVisualIDRegistry.getType(UsageNameEditPart.VISUAL_ID));
		label6012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6012 = (Location) label6012.getLayoutConstraint();
		location6012.setX(0);
		location6012.setY(40);
		Node label6013 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeUsageEditPart.VISUAL_ID));
		label6013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6013 = (Location) label6013.getLayoutConstraint();
		location6013.setX(0);
		location6013.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createRealization_4017(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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

		initForegroundFromPrefs(edge, prefStore, "Realization");

		initFontStyleFromPrefs(edge, prefStore, "Realization");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6015 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationNameEditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6015 = (Location) label6015.getLayoutConstraint();
		location6015.setX(0);
		location6015.setY(40);
		Node label6016 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeRealizationEditPart.VISUAL_ID));
		label6016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6016 = (Location) label6016.getLayoutConstraint();
		location6016.setX(0);
		location6016.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageMerge_4018(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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

		initForegroundFromPrefs(edge, prefStore, "PackageMerge");

		initFontStyleFromPrefs(edge, prefStore, "PackageMerge");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label0 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypePackageMergeEditPart.VISUAL_ID));
		label0.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location0 = (Location) label0.getLayoutConstraint();
		location0.setX(0);
		location0.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageImport_4019(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
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

		initForegroundFromPrefs(edge, prefStore, "PackageImport");

		initFontStyleFromPrefs(edge, prefStore, "PackageImport");

		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6017 = createLabel(edge, UMLVisualIDRegistry
				.getType(AppliedStereotypePackageImportEditPart.VISUAL_ID));
		label6017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6017 = (Location) label6017.getLayoutConstraint();
		location6017.setX(0);
		location6017.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
		if (!UseCaseDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", UseCaseDiagramEditPart.MODEL_ID); //$NON-NLS-1$
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
		rv.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());

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
