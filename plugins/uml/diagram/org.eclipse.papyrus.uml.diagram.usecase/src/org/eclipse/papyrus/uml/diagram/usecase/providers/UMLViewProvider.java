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
package org.eclipse.papyrus.uml.diagram.usecase.providers;

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
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAppliedStereotypeEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorQualifiedNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorQualifiedNameInCEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorQualifiedNameInPEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AppliedStereotypeAbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AppliedStereotypePackageMergeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AppliedStereotypeUsageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AssociationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AssociationNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentBodyEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInComponentNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInPackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentUsecases2EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentUsecases3EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintBodyEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintBodyInCEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintBodyInPEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInComponentNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInPackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DefaultNamedElementEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DefaultNamedElementNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DiagramNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtendAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtendsLink_fixedEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtensionPointInRectangleEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.IncludeAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.IncludeLink_fixedEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageImportAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.RealizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.RealizationNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShapeNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShapeNamedElementNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectComponentUsecasesEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UsageNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseAsRectangleNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInPackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseNameEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsInRectangleEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLVisualIDRegistry;
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
		return UseCaseDiagramEditPart.MODEL_ID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return UseCaseDiagramEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
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
				if(!UseCaseDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch(visualID) {
				case ActorEditPartTN.VISUAL_ID:
				case UseCaseEditPartTN.VISUAL_ID:
				case SubjectClassifierEditPartTN.VISUAL_ID:
				case DefaultNamedElementEditPartTN.VISUAL_ID:
				case ShapeNamedElementEditPart.VISUAL_ID:
				case ShortCutDiagramEditPart.VISUAL_ID:
				case ExtensionPointEditPart.VISUAL_ID:
				case CommentEditPartCN.VISUAL_ID:
				case ConstraintInComponentEditPart.VISUAL_ID:
				case ActorAsRectangleEditPartTN.VISUAL_ID:
				case UseCaseAsRectangleEditPartTN.VISUAL_ID:
				case PackageEditPartTN.VISUAL_ID:
				case ConstraintEditPartTN.VISUAL_ID:
				case CommentEditPartTN.VISUAL_ID:
				case ExtensionPointInRectangleEditPart.VISUAL_ID:
				case UseCaseInComponentEditPart.VISUAL_ID:
				case ComponentInComponentEditPart.VISUAL_ID:
				case ActorInComponentEditPart.VISUAL_ID:
				case ConstraintInPackageEditPart.VISUAL_ID:
				case ActorInPackageEditPart.VISUAL_ID:
				case UseCaseInPackageEditPart.VISUAL_ID:
				case ComponentInPackageEditPart.VISUAL_ID:
				case PackageEditPartCN.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return ActorEditPartTN.VISUAL_ID == visualID || ActorAsRectangleEditPartTN.VISUAL_ID == visualID || UseCaseEditPartTN.VISUAL_ID == visualID || UseCaseAsRectangleEditPartTN.VISUAL_ID == visualID || SubjectClassifierEditPartTN.VISUAL_ID == visualID || PackageEditPartTN.VISUAL_ID == visualID || ConstraintEditPartTN.VISUAL_ID == visualID || CommentEditPartTN.VISUAL_ID == visualID || DefaultNamedElementEditPartTN.VISUAL_ID == visualID || ShapeNamedElementEditPart.VISUAL_ID == visualID || ShortCutDiagramEditPart.VISUAL_ID == visualID || ExtensionPointEditPart.VISUAL_ID == visualID || ExtensionPointInRectangleEditPart.VISUAL_ID == visualID || UseCaseInComponentEditPart.VISUAL_ID == visualID || ComponentInComponentEditPart.VISUAL_ID == visualID || CommentEditPartCN.VISUAL_ID == visualID || ConstraintInComponentEditPart.VISUAL_ID == visualID || ActorInComponentEditPart.VISUAL_ID == visualID || ConstraintInPackageEditPart.VISUAL_ID == visualID || ActorInPackageEditPart.VISUAL_ID == visualID || UseCaseInPackageEditPart.VISUAL_ID == visualID || ComponentInPackageEditPart.VISUAL_ID == visualID || PackageEditPartCN.VISUAL_ID == visualID;
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
		//if (!org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
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
		diagram.setType(UseCaseDiagramEditPart.MODEL_ID);
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
		case ActorEditPartTN.VISUAL_ID:
			return createActor_2011(domainElement, containerView, index, persisted, preferencesHint);
		case ActorAsRectangleEditPartTN.VISUAL_ID:
			return createActor_2012(domainElement, containerView, index, persisted, preferencesHint);
		case UseCaseEditPartTN.VISUAL_ID:
			return createUseCase_2013(domainElement, containerView, index, persisted, preferencesHint);
		case UseCaseAsRectangleEditPartTN.VISUAL_ID:
			return createUseCase_2014(domainElement, containerView, index, persisted, preferencesHint);
		case SubjectClassifierEditPartTN.VISUAL_ID:
			return createClassifier_2015(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPartTN.VISUAL_ID:
			return createPackage_2016(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPartTN.VISUAL_ID:
			return createConstraint_2017(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPartTN.VISUAL_ID:
			return createComment_2018(domainElement, containerView, index, persisted, preferencesHint);
		case DefaultNamedElementEditPartTN.VISUAL_ID:
			return createNamedElement_2022(domainElement, containerView, index, persisted, preferencesHint);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return createNamedElement_2023(domainElement, containerView, index, persisted, preferencesHint);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return createDiagram_2019(domainElement, containerView, index, persisted, preferencesHint);
		case ExtensionPointEditPart.VISUAL_ID:
			return createExtensionPoint_3007(domainElement, containerView, index, persisted, preferencesHint);
		case ExtensionPointInRectangleEditPart.VISUAL_ID:
			return createExtensionPoint_3008(domainElement, containerView, index, persisted, preferencesHint);
		case UseCaseInComponentEditPart.VISUAL_ID:
			return createUseCase_3009(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentInComponentEditPart.VISUAL_ID:
			return createComponent_3016(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPartCN.VISUAL_ID:
			return createComment_3015(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintInComponentEditPart.VISUAL_ID:
			return createConstraint_3017(domainElement, containerView, index, persisted, preferencesHint);
		case ActorInComponentEditPart.VISUAL_ID:
			return createActor_3018(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintInPackageEditPart.VISUAL_ID:
			return createConstraint_3010(domainElement, containerView, index, persisted, preferencesHint);
		case ActorInPackageEditPart.VISUAL_ID:
			return createActor_3011(domainElement, containerView, index, persisted, preferencesHint);
		case UseCaseInPackageEditPart.VISUAL_ID:
			return createUseCase_3012(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentInPackageEditPart.VISUAL_ID:
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
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		switch(UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case IncludeEditPart.VISUAL_ID:
			return createInclude_4008(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ExtendEditPart.VISUAL_ID:
			return createExtend_4009(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_4010(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case AssociationEditPart.VISUAL_ID:
			return createAssociation_4011(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4012(containerView, index, persisted, preferencesHint);
		case DependencyEditPart.VISUAL_ID:
			return createDependency_4013(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4014(containerView, index, persisted, preferencesHint);
		case AbstractionEditPart.VISUAL_ID:
			return createAbstraction_4015(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case UsageEditPart.VISUAL_ID:
			return createUsage_4016(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case RealizationEditPart.VISUAL_ID:
			return createRealization_4017(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case PackageMergeEditPart.VISUAL_ID:
			return createPackageMerge_4018(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case PackageImportEditPart.VISUAL_ID:
			return createPackageImport_4019(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createActor_2011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Actor");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Actor");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Actor");
		Node label5014 = createLabel(node, UMLVisualIDRegistry.getType(ActorNameEditPartTN.VISUAL_ID));
		label5014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5014 = (Location)label5014.getLayoutConstraint();
		location5014.setX(20);
		location5014.setY(60);
		Node label6029 = createLabel(node, UMLVisualIDRegistry.getType(ActorAppliedStereotypeEditPartTN.VISUAL_ID));
		label6029.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6029 = (Location)label6029.getLayoutConstraint();
		location6029.setX(20);
		location6029.setY(100);
		Node label6037 = createLabel(node, UMLVisualIDRegistry.getType(ActorQualifiedNameEditPartTN.VISUAL_ID));
		label6037.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6037 = (Location)label6037.getLayoutConstraint();
		location6037.setX(20);
		location6037.setY(80);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActor_2012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Actor");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Actor");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Actor");
		Node label5015 = createLabel(node, UMLVisualIDRegistry.getType(ActorAsRectangleNameEditPartTN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_2013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "UseCase");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "UseCase");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "UseCase");
		Node label5016 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseNameEditPartTN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(UseCasePointsEditPartTN.VISUAL_ID), false, false, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "UseCase");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_2014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "UseCase");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "UseCase");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "UseCase");
		Node label5017 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseAsRectangleNameEditPartTN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(UseCasePointsInRectangleEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "UseCase");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClassifier_2015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SubjectClassifierEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Classifier");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Classifier");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Classifier");
		Node label5019 = createLabel(node, UMLVisualIDRegistry.getType(SubjectClassifierNameEditPartTN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(SubjectComponentUsecasesEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Classifier");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Package");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Package");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Package");
		Node label5025 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPartTN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Package");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_2017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");
		Node label5026 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPartTN.VISUAL_ID));
		Node label6042 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Comment");
		Node label5027 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPartTN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDiagram_2019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ShortCutDiagramEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ShortCutDiagram");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ShortCutDiagram");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ShortCutDiagram");
		Node label5032 = createLabel(node, UMLVisualIDRegistry.getType(DiagramNameEditPart.VISUAL_ID));
		label5032.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5032 = (Location)label5032.getLayoutConstraint();
		location5032.setX(0);
		location5032.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNamedElement_2022(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DefaultNamedElementEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DefaultNamedElement");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DefaultNamedElement");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DefaultNamedElement");
		Node label6039 = createLabel(node, UMLVisualIDRegistry.getType(DefaultNamedElementNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNamedElement_2023(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ShapeNamedElementEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "NamedElement");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "NamedElement");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "NamedElement");
		Node label6038 = createLabel(node, UMLVisualIDRegistry.getType(ShapeNamedElementNameEditPart.VISUAL_ID));
		label6038.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6038 = (Location)label6038.getLayoutConstraint();
		location6038.setX(0);
		location6038.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExtensionPoint_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExtensionPoint");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ExtensionPoint");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExtensionPoint_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExtensionPoint");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ExtensionPoint");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_3009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "UseCase");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "UseCase");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "UseCase");
		Node label5018 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseInComponentNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(UseCasePointsInComponentEditPart.VISUAL_ID), false, false, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "UseCase");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Component");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		Node label5030 = createLabel(node, UMLVisualIDRegistry.getType(ComponentInComponentNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentUsecases2EditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Comment");
		Node label5028 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");
		Node label5029 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintInComponentNameEditPart.VISUAL_ID));
		Node label6043 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintBodyInCEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActor_3018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Actor");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Actor");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Actor");
		Node label5031 = createLabel(node, UMLVisualIDRegistry.getType(ActorInComponentNameEditPart.VISUAL_ID));
		label5031.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5031 = (Location)label5031.getLayoutConstraint();
		location5031.setX(20);
		location5031.setY(60);
		Node label6027 = createLabel(node, UMLVisualIDRegistry.getType(ActorInComponentAppliedStereotypeEditPart.VISUAL_ID));
		label6027.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6027 = (Location)label6027.getLayoutConstraint();
		location6027.setX(20);
		location6027.setY(100);
		Node label6041 = createLabel(node, UMLVisualIDRegistry.getType(ActorQualifiedNameInCEditPart.VISUAL_ID));
		label6041.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6041 = (Location)label6041.getLayoutConstraint();
		location6041.setX(20);
		location6041.setY(80);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");
		Node label5020 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintInPackageNameEditPart.VISUAL_ID));
		Node label6044 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintBodyInPEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActor_3011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Actor");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Actor");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Actor");
		Node label5021 = createLabel(node, UMLVisualIDRegistry.getType(ActorInPackageNameEditPart.VISUAL_ID));
		label5021.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5021 = (Location)label5021.getLayoutConstraint();
		location5021.setX(20);
		location5021.setY(60);
		Node label6028 = createLabel(node, UMLVisualIDRegistry.getType(ActorInPackageAppliedStereotypeEditPart.VISUAL_ID));
		label6028.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6028 = (Location)label6028.getLayoutConstraint();
		location6028.setX(20);
		location6028.setY(100);
		Node label6040 = createLabel(node, UMLVisualIDRegistry.getType(ActorQualifiedNameInPEditPart.VISUAL_ID));
		label6040.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6040 = (Location)label6040.getLayoutConstraint();
		location6040.setX(20);
		location6040.setY(80);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_3012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "UseCase");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "UseCase");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "UseCase");
		Node label5022 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseInPackageNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(UseCasePointsInPackageEditPart.VISUAL_ID), false, false, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "UseCase");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Component");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		Node label5023 = createLabel(node, UMLVisualIDRegistry.getType(ComponentInPackageNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentUsecases3EditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_3014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Package");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Package");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Package");
		Node label5024 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID), false, false, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Package");
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createInclude_4008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Include");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Include");
		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(IncludeLink_fixedEditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location)label6006.getLayoutConstraint();
		location6006.setX(0);
		location6006.setY(20);
		Node label6030 = createLabel(edge, UMLVisualIDRegistry.getType(IncludeAppliedStereotypeEditPart.VISUAL_ID));
		label6030.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6030 = (Location)label6030.getLayoutConstraint();
		location6030.setX(0);
		location6030.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Include");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createExtend_4009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Extend");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Extend");
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(ExtendsLink_fixedEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location)label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(20);
		Node label6031 = createLabel(edge, UMLVisualIDRegistry.getType(ExtendAppliedStereotypeEditPart.VISUAL_ID));
		label6031.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6031 = (Location)label6031.getLayoutConstraint();
		location6031.setX(0);
		location6031.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Extend");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Generalization");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Generalization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Generalization");
		Node label6032 = createLabel(edge, UMLVisualIDRegistry.getType(GeneralizationAppliedStereotypeEditPart.VISUAL_ID));
		label6032.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6032 = (Location)label6032.getLayoutConstraint();
		location6032.setX(0);
		location6032.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Generalization");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_4011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Association");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Association");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Association");
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationNameEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location)label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(40);
		Node label6033 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationAppliedStereotypeEditPart.VISUAL_ID));
		label6033.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6033 = (Location)label6033.getLayoutConstraint();
		location6033.setX(0);
		location6033.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Association");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4012(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
	public Edge createDependency_4013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Dependency");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Dependency");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Dependency");
		Node label6010 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		label6010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6010 = (Location)label6010.getLayoutConstraint();
		location6010.setX(0);
		location6010.setY(40);
		Node label6034 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyAppliedStereotypeEditPart.VISUAL_ID));
		label6034.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6034 = (Location)label6034.getLayoutConstraint();
		location6034.setX(0);
		location6034.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Dependency");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4014(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAbstraction_4015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Abstraction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Abstraction");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Abstraction");
		Node label6011 = createLabel(edge, UMLVisualIDRegistry.getType(AbstractionNameEditPart.VISUAL_ID));
		label6011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6011 = (Location)label6011.getLayoutConstraint();
		location6011.setX(0);
		location6011.setY(40);
		Node label6014 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeAbstractionEditPart.VISUAL_ID));
		label6014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6014 = (Location)label6014.getLayoutConstraint();
		location6014.setX(0);
		location6014.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Abstraction");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createUsage_4016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Usage");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Usage");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Usage");
		Node label6012 = createLabel(edge, UMLVisualIDRegistry.getType(UsageNameEditPart.VISUAL_ID));
		label6012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6012 = (Location)label6012.getLayoutConstraint();
		location6012.setX(0);
		location6012.setY(40);
		Node label6013 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeUsageEditPart.VISUAL_ID));
		label6013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6013 = (Location)label6013.getLayoutConstraint();
		location6013.setX(0);
		location6013.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Usage");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createRealization_4017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Realization");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Realization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Realization");
		Node label6015 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationNameEditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6015 = (Location)label6015.getLayoutConstraint();
		location6015.setX(0);
		location6015.setY(40);
		Node label6035 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationAppliedStereotypeEditPart.VISUAL_ID));
		label6035.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6035 = (Location)label6035.getLayoutConstraint();
		location6035.setX(0);
		location6035.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Realization");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageMerge_4018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "PackageMerge");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "PackageMerge");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "PackageMerge");
		Node label0 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypePackageMergeEditPart.VISUAL_ID));
		label0.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location0 = (Location)label0.getLayoutConstraint();
		location0.setX(0);
		location0.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "PackageMerge");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageImport_4019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "PackageImport");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "PackageImport");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "PackageImport");
		Node label6036 = createLabel(edge, UMLVisualIDRegistry.getType(PackageImportAppliedStereotypeEditPart.VISUAL_ID));
		label6036.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6036 = (Location)label6036.getLayoutConstraint();
		location6036.setX(0);
		location6036.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "PackageImport");
		return edge;
	}

	/**
	 * @generated
	 */
	protected void stampShortcut(View containerView, Node target) {
		if(!UseCaseDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", UseCaseDiagramEditPart.MODEL_ID); //$NON-NLS-1$
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
