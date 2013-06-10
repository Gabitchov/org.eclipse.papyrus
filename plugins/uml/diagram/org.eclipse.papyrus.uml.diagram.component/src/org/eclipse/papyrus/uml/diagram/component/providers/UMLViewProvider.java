/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Amine EL KOUHEN (CEA LIST/LIFL) & Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.providers;

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
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentBodyEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintSpecificationEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.LinkDescriptorEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.MultiDependencyLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;
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
	 * This method can be overloaded when diagram editor inherits from another one, but should never be <code>null</code>
	 * </p>
	 * 
	 * @return the unique identifier of the diagram for which views are
	 *         provided.
	 */
	protected String getDiagramProvidedId() {
		return ComponentDiagramEditPart.MODEL_ID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return ComponentDiagramEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
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
				if(!ComponentDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch(visualID) {
				case DependencyNodeEditPart.VISUAL_ID:
				case ComponentEditPart.VISUAL_ID:
				case ModelEditPart.VISUAL_ID:
				case PackageEditPart.VISUAL_ID:
				case InterfaceEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case DefaultNamedElementEditPart.VISUAL_ID:
				case PortEditPart.VISUAL_ID:
				case ModelEditPartCN.VISUAL_ID:
				case PackageEditPartCN.VISUAL_ID:
				case ComponentEditPartCN.VISUAL_ID:
				case ComponentEditPartPCN.VISUAL_ID:
				case InterfaceEditPartPCN.VISUAL_ID:
				case CommentEditPartPCN.VISUAL_ID:
				case ConstraintEditPartPCN.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return DependencyNodeEditPart.VISUAL_ID == visualID || ComponentEditPart.VISUAL_ID == visualID || ModelEditPart.VISUAL_ID == visualID || PackageEditPart.VISUAL_ID == visualID || InterfaceEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID || ConstraintEditPart.VISUAL_ID == visualID || DefaultNamedElementEditPart.VISUAL_ID == visualID || PortEditPart.VISUAL_ID == visualID || ModelEditPartCN.VISUAL_ID == visualID || PackageEditPartCN.VISUAL_ID == visualID || ComponentEditPartCN.VISUAL_ID == visualID || ComponentEditPartPCN.VISUAL_ID == visualID || InterfaceEditPartPCN.VISUAL_ID == visualID || CommentEditPartPCN.VISUAL_ID == visualID || ConstraintEditPartPCN.VISUAL_ID == visualID;
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
		//if (!org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
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
		diagram.setType(ComponentDiagramEditPart.MODEL_ID);
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
		case DependencyNodeEditPart.VISUAL_ID:
			return createDependency_3203(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentEditPart.VISUAL_ID:
			return createComponent_2002(domainElement, containerView, index, persisted, preferencesHint);
		case ModelEditPart.VISUAL_ID:
			return createModel_3202(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPart.VISUAL_ID:
			return createPackage_3200(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPart.VISUAL_ID:
			return createInterface_2003(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_3201(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_3199(domainElement, containerView, index, persisted, preferencesHint);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return createNamedElement_3204(domainElement, containerView, index, persisted, preferencesHint);
		case PortEditPart.VISUAL_ID:
			return createPort_3069(domainElement, containerView, index, persisted, preferencesHint);
		case ModelEditPartCN.VISUAL_ID:
			return createModel_3077(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPartCN.VISUAL_ID:
			return createPackage_3076(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentEditPartCN.VISUAL_ID:
			return createComponent_3070(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentEditPartPCN.VISUAL_ID:
			return createComponent_3071(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPartPCN.VISUAL_ID:
			return createInterface_3072(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPartPCN.VISUAL_ID:
			return createComment_3074(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPartPCN.VISUAL_ID:
			return createConstraint_3075(domainElement, containerView, index, persisted, preferencesHint);
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
		case UsageEditPart.VISUAL_ID:
			return createUsage_4001(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return createInterfaceRealization_4006(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_4003(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case SubstitutionEditPart.VISUAL_ID:
			return createSubstitution_4012(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ManifestationEditPart.VISUAL_ID:
			return createManifestation_4014(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ComponentRealizationEditPart.VISUAL_ID:
			return createComponentRealization_4007(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case AbstractionEditPart.VISUAL_ID:
			return createAbstraction_4013(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case LinkDescriptorEditPart.VISUAL_ID:
			return createLink_4016(containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4015(containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4009(containerView, index, persisted, preferencesHint);
		case DependencyEditPart.VISUAL_ID:
			return createDependency_4010(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DependencyBranchEditPart.VISUAL_ID:
			return createDependency_4017(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createDependency_3203(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DependencyNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DependencyNode");
		Node label5008 = createLabel(node, UMLVisualIDRegistry.getType(MultiDependencyLabelEditPart.VISUAL_ID));
		label5008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5008 = (Location)label5008.getLayoutConstraint();
		location5008.setX(0);
		location5008.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_2002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		Node label5004 = createLabel(node, UMLVisualIDRegistry.getType(ComponentNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_3202(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ModelEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Model");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Model");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Model");
		Node label5262 = createLabel(node, UMLVisualIDRegistry.getType(ModelNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ModelPackageableElementCompartmentEditPart.VISUAL_ID), false, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Model");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_2003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Interface");
		Node label5005 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
		label5005.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5005 = (Location)label5005.getLayoutConstraint();
		location5005.setX(0);
		location5005.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_3200(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Package");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Package");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Package");
		Node label5254 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID), false, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Package");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3201(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Comment");
		Node label5255 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3199(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");
		Node label5252 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		Node label5253 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintSpecificationEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNamedElement_3204(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DefaultNamedElementEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DefaultNamedElement");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DefaultNamedElement");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DefaultNamedElement");
		Node label5265 = createLabel(node, UMLVisualIDRegistry.getType(DefaultNamedElementNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPort_3069(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Port");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Port");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Port");
		Node label5006 = createLabel(node, UMLVisualIDRegistry.getType(PortNameEditPart.VISUAL_ID));
		label5006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5006 = (Location)label5006.getLayoutConstraint();
		location5006.setX(0);
		location5006.setY(5);
		Node label5007 = createLabel(node, UMLVisualIDRegistry.getType(PortAppliedStereotypeEditPart.VISUAL_ID));
		label5007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5007 = (Location)label5007.getLayoutConstraint();
		location5007.setX(25);
		location5007.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_3077(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ModelEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Model");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Model");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Model");
		Node label5264 = createLabel(node, UMLVisualIDRegistry.getType(ModelNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ModelPackageableElementCompartmentEditPartCN.VISUAL_ID), false, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Model");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_3076(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Package");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Package");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Package");
		Node label5261 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPartCN.VISUAL_ID), false, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Package");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3070(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		Node label5256 = createLabel(node, UMLVisualIDRegistry.getType(ComponentNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3071(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentEditPartPCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		Node label5257 = createLabel(node, UMLVisualIDRegistry.getType(ComponentNameEditPartPCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentCompositeCompartmentEditPartPCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3072(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InterfaceEditPartPCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Interface");
		Node label0 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPartPCN.VISUAL_ID));
		label0.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location0 = (Location)label0.getLayoutConstraint();
		location0.setX(0);
		location0.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3074(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPartPCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Comment");
		Node label5258 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPartPCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3075(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPartPCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Constraint");
		Node label5259 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPartPCN.VISUAL_ID));
		Node label5260 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintSpecificationEditPartPCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createUsage_4001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createInterfaceRealization_4006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "InterfaceRealization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "InterfaceRealization");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label2 = createLabel(edge, UMLVisualIDRegistry.getType(GeneralizationAppliedStereotypeEditPart.VISUAL_ID));
		label2.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location2 = (Location)label2.getLayoutConstraint();
		location2.setX(0);
		location2.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Generalization");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createSubstitution_4012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(SubstitutionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Substitution");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Substitution");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Substitution");
		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(SubstitutionNameEditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location)label6006.getLayoutConstraint();
		location6006.setX(0);
		location6006.setY(60);
		Node label6020 = createLabel(edge, UMLVisualIDRegistry.getType(SubstitutionAppliedStereotypeEditPart.VISUAL_ID));
		label6020.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6020 = (Location)label6020.getLayoutConstraint();
		location6020.setX(0);
		location6020.setY(30);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Substitution");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createManifestation_4014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ManifestationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Manifestation");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Manifestation");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Manifestation");
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(ManifestationNameEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location)label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(60);
		Node label6022 = createLabel(edge, UMLVisualIDRegistry.getType(ManifestationAppliedStereotypeEditPart.VISUAL_ID));
		label6022.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6022 = (Location)label6022.getLayoutConstraint();
		location6022.setX(0);
		location6022.setY(30);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Manifestation");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createComponentRealization_4007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ComponentRealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ComponentRealization");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ComponentRealization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ComponentRealization");
		Node label3 = createLabel(edge, UMLVisualIDRegistry.getType(ComponentRealizationNameEditPart.VISUAL_ID));
		label3.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location3 = (Location)label3.getLayoutConstraint();
		location3.setX(0);
		location3.setY(60);
		Node label4 = createLabel(edge, UMLVisualIDRegistry.getType(ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID));
		label4.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4 = (Location)label4.getLayoutConstraint();
		location4.setX(0);
		location4.setY(30);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "ComponentRealization");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAbstraction_4013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(AbstractionNameEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location)label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(60);
		Node label6021 = createLabel(edge, UMLVisualIDRegistry.getType(AbstractionAppliedStereotypeEditPart.VISUAL_ID));
		label6021.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6021 = (Location)label6021.getLayoutConstraint();
		location6021.setX(0);
		location6021.setY(30);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Abstraction");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createLink_4016(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(LinkDescriptorEditPart.VISUAL_ID));
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
	public Edge createCommentAnnotatedElement_4015(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "CommentAnnotatedElement");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "CommentAnnotatedElement");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "CommentAnnotatedElement");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4009(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ConstraintConstrainedElement");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ConstraintConstrainedElement");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ConstraintConstrainedElement");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "DependencyLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "DependencyLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "DependencyLink");
		Node label6009 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6009 = (Location)label6009.getLayoutConstraint();
		location6009.setX(0);
		location6009.setY(60);
		Node label6023 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyAppliedStereotypeEditPart.VISUAL_ID));
		label6023.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6023 = (Location)label6023.getLayoutConstraint();
		location6023.setX(0);
		location6023.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "DependencyLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyBranchEditPart.VISUAL_ID));
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
		return edge;
	}

	/**
	 * @generated
	 */
	protected void stampShortcut(View containerView, Node target) {
		if(!ComponentDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ComponentDiagramEditPart.MODEL_ID); //$NON-NLS-1$
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
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());;
		if(store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}
}
