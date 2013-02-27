/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.providers;

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
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
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
		return ModelEditPart.MODEL_ID;
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
				if(!ModelEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch(visualID) {
				case ContainmentCircleEditPart.VISUAL_ID:
					break; // pure design element
				case DependencyNodeEditPart.VISUAL_ID:
				case AssociationClassEditPart.VISUAL_ID:
				case AssociationNodeEditPart.VISUAL_ID:
				case InstanceSpecificationEditPart.VISUAL_ID:
				case ComponentEditPart.VISUAL_ID:
				case SignalEditPart.VISUAL_ID:
				case InterfaceEditPart.VISUAL_ID:
				case ModelEditPartTN.VISUAL_ID:
				case InformationItemEditPart.VISUAL_ID:
				case ShortCutDiagramEditPart.VISUAL_ID:
				case DurationObservationEditPart.VISUAL_ID:
				case TimeObservationEditPart.VISUAL_ID:
				case DefaultNamedElementEditPart.VISUAL_ID:
				case ShapeNamedElementEditPart.VISUAL_ID:
				case PropertyForComponentEditPart.VISUAL_ID:
				case NestedClassForComponentEditPart.VISUAL_ID:
				case OperationForComponentEditPart.VISUAL_ID:
				case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
				case OperationTemplateParameterEditPart.VISUAL_ID:
				case ClassifierTemplateParameterEditPart.VISUAL_ID:
				case TemplateParameterEditPart.VISUAL_ID:
				case EnumerationLiteralEditPart.VISUAL_ID:
				case ReceptionEditPart.VISUAL_ID:
				case ReceptionInInterfaceEditPart.VISUAL_ID:
				case SlotEditPart.VISUAL_ID:
				case RedefinableTemplateSignatureEditPart.VISUAL_ID:
				case TemplateSignatureEditPart.VISUAL_ID:
				case EnumerationEditPartCN.VISUAL_ID:
				case InformationItemEditPartCN.VISUAL_ID:
				case PrimitiveTypeEditPartCN.VISUAL_ID:
				case DataTypeEditPartCN.VISUAL_ID:
				case CommentEditPartCN.VISUAL_ID:
				case ConstraintEditPartCN.VISUAL_ID:
				case NestedInterfaceForComponentEditPart.VISUAL_ID:
				case EnumerationEditPart.VISUAL_ID:
				case PackageEditPart.VISUAL_ID:
				case ClassEditPart.VISUAL_ID:
				case PrimitiveTypeEditPart.VISUAL_ID:
				case DataTypeEditPart.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case PropertyForClassEditPart.VISUAL_ID:
				case PropertyForSignalEditPart.VISUAL_ID:
				case PropertyForInterfaceEditPart.VISUAL_ID:
				case PropertyforPrimitiveTypeEditPart.VISUAL_ID:
				case PropertyforDataTypeEditPart.VISUAL_ID:
				case NestedClassForClassEditPart.VISUAL_ID:
				case NestedClassForInterfaceEditPart.VISUAL_ID:
				case OperationForClassEditPart.VISUAL_ID:
				case OperationForInterfaceEditpart.VISUAL_ID:
				case OperationForPrimitiveTypeEditPart.VISUAL_ID:
				case OperationForDataTypeEditPart.VISUAL_ID:
				case InstanceSpecificationEditPartCN.VISUAL_ID:
				case ComponentEditPartCN.VISUAL_ID:
				case SignalEditPartCN.VISUAL_ID:
				case InterfaceEditPartCN.VISUAL_ID:
				case ModelEditPartCN.VISUAL_ID:
				case PackageEditPartCN.VISUAL_ID:
				case ClassEditPartCN.VISUAL_ID:
				case NestedInterfaceForClassEditPart.VISUAL_ID:
				case NestedInterfaceForInterfaceEditPart.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return DependencyNodeEditPart.VISUAL_ID == visualID || AssociationClassEditPart.VISUAL_ID == visualID || AssociationNodeEditPart.VISUAL_ID == visualID || InstanceSpecificationEditPart.VISUAL_ID == visualID || ComponentEditPart.VISUAL_ID == visualID || SignalEditPart.VISUAL_ID == visualID || InterfaceEditPart.VISUAL_ID == visualID || ModelEditPartTN.VISUAL_ID == visualID || EnumerationEditPart.VISUAL_ID == visualID || PackageEditPart.VISUAL_ID == visualID || InformationItemEditPart.VISUAL_ID == visualID || ClassEditPart.VISUAL_ID == visualID || PrimitiveTypeEditPart.VISUAL_ID == visualID || DataTypeEditPart.VISUAL_ID == visualID || ConstraintEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID || ShortCutDiagramEditPart.VISUAL_ID == visualID || DurationObservationEditPart.VISUAL_ID == visualID || TimeObservationEditPart.VISUAL_ID == visualID || DefaultNamedElementEditPart.VISUAL_ID == visualID || ShapeNamedElementEditPart.VISUAL_ID == visualID || PropertyForClassEditPart.VISUAL_ID == visualID || PropertyForComponentEditPart.VISUAL_ID == visualID || PropertyForSignalEditPart.VISUAL_ID == visualID || PropertyForInterfaceEditPart.VISUAL_ID == visualID || PropertyforPrimitiveTypeEditPart.VISUAL_ID == visualID || PropertyforDataTypeEditPart.VISUAL_ID == visualID || NestedClassForClassEditPart.VISUAL_ID == visualID || NestedClassForComponentEditPart.VISUAL_ID == visualID || NestedClassForInterfaceEditPart.VISUAL_ID == visualID || OperationForClassEditPart.VISUAL_ID == visualID || OperationForComponentEditPart.VISUAL_ID == visualID || OperationForInterfaceEditpart.VISUAL_ID == visualID || OperationForPrimitiveTypeEditPart.VISUAL_ID == visualID || OperationForDataTypeEditPart.VISUAL_ID == visualID || ConnectableElementTemplateParameterEditPart.VISUAL_ID == visualID || OperationTemplateParameterEditPart.VISUAL_ID == visualID || ClassifierTemplateParameterEditPart.VISUAL_ID == visualID || TemplateParameterEditPart.VISUAL_ID == visualID || EnumerationLiteralEditPart.VISUAL_ID == visualID || ReceptionEditPart.VISUAL_ID == visualID || ReceptionInInterfaceEditPart.VISUAL_ID == visualID || SlotEditPart.VISUAL_ID == visualID || RedefinableTemplateSignatureEditPart.VISUAL_ID == visualID || ContainmentCircleEditPart.VISUAL_ID == visualID || TemplateSignatureEditPart.VISUAL_ID == visualID || InstanceSpecificationEditPartCN.VISUAL_ID == visualID || ComponentEditPartCN.VISUAL_ID == visualID || SignalEditPartCN.VISUAL_ID == visualID || InterfaceEditPartCN.VISUAL_ID == visualID || ModelEditPartCN.VISUAL_ID == visualID || EnumerationEditPartCN.VISUAL_ID == visualID || PackageEditPartCN.VISUAL_ID == visualID || InformationItemEditPartCN.VISUAL_ID == visualID || ClassEditPartCN.VISUAL_ID == visualID || PrimitiveTypeEditPartCN.VISUAL_ID == visualID || DataTypeEditPartCN.VISUAL_ID == visualID || CommentEditPartCN.VISUAL_ID == visualID || ConstraintEditPartCN.VISUAL_ID == visualID || NestedInterfaceForClassEditPart.VISUAL_ID == visualID || NestedInterfaceForComponentEditPart.VISUAL_ID == visualID || NestedInterfaceForInterfaceEditPart.VISUAL_ID == visualID;
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
		//if (!org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
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
		diagram.setType(ModelEditPart.MODEL_ID);
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
		case InformationItemEditPart.VISUAL_ID:
			return createInformationItem_2099(domainElement, containerView, index, persisted, preferencesHint);
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
		case DurationObservationEditPart.VISUAL_ID:
			return createDurationObservation_2095(domainElement, containerView, index, persisted, preferencesHint);
		case TimeObservationEditPart.VISUAL_ID:
			return createTimeObservation_2096(domainElement, containerView, index, persisted, preferencesHint);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return createNamedElement_2097(domainElement, containerView, index, persisted, preferencesHint);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return createNamedElement_2098(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyForClassEditPart.VISUAL_ID:
			return createProperty_3012(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyForComponentEditPart.VISUAL_ID:
			return createProperty_3002(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyForSignalEditPart.VISUAL_ID:
			return createProperty_3005(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return createProperty_3006(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyforPrimitiveTypeEditPart.VISUAL_ID:
			return createProperty_3041(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyforDataTypeEditPart.VISUAL_ID:
			return createProperty_3018(domainElement, containerView, index, persisted, preferencesHint);
		case NestedClassForClassEditPart.VISUAL_ID:
			return createClass_3014(domainElement, containerView, index, persisted, preferencesHint);
		case NestedClassForComponentEditPart.VISUAL_ID:
			return createClass_3004(domainElement, containerView, index, persisted, preferencesHint);
		case NestedClassForInterfaceEditPart.VISUAL_ID:
			return createClass_3008(domainElement, containerView, index, persisted, preferencesHint);
		case OperationForClassEditPart.VISUAL_ID:
			return createOperation_3013(domainElement, containerView, index, persisted, preferencesHint);
		case OperationForComponentEditPart.VISUAL_ID:
			return createOperation_3003(domainElement, containerView, index, persisted, preferencesHint);
		case OperationForInterfaceEditpart.VISUAL_ID:
			return createOperation_3007(domainElement, containerView, index, persisted, preferencesHint);
		case OperationForPrimitiveTypeEditPart.VISUAL_ID:
			return createOperation_3042(domainElement, containerView, index, persisted, preferencesHint);
		case OperationForDataTypeEditPart.VISUAL_ID:
			return createOperation_3019(domainElement, containerView, index, persisted, preferencesHint);
		case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
			return createConnectableElementTemplateParameter_3034(domainElement, containerView, index, persisted, preferencesHint);
		case OperationTemplateParameterEditPart.VISUAL_ID:
			return createOperationTemplateParameter_3035(domainElement, containerView, index, persisted, preferencesHint);
		case ClassifierTemplateParameterEditPart.VISUAL_ID:
			return createClassifierTemplateParameter_3031(domainElement, containerView, index, persisted, preferencesHint);
		case TemplateParameterEditPart.VISUAL_ID:
			return createTemplateParameter_3016(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return createEnumerationLiteral_3017(domainElement, containerView, index, persisted, preferencesHint);
		case ReceptionEditPart.VISUAL_ID:
			return createReception_3011(domainElement, containerView, index, persisted, preferencesHint);
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return createReception_3039(domainElement, containerView, index, persisted, preferencesHint);
		case SlotEditPart.VISUAL_ID:
			return createSlot_3030(domainElement, containerView, index, persisted, preferencesHint);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return createRedefinableTemplateSignature_3015(domainElement, containerView, index, persisted, preferencesHint);
		case ContainmentCircleEditPart.VISUAL_ID:
			return createNode_3032(domainElement, containerView, index, persisted, preferencesHint);
		case TemplateSignatureEditPart.VISUAL_ID:
			return createTemplateSignature_3033(domainElement, containerView, index, persisted, preferencesHint);
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
		case PackageEditPartCN.VISUAL_ID:
			return createPackage_3009(domainElement, containerView, index, persisted, preferencesHint);
		case InformationItemEditPartCN.VISUAL_ID:
			return createInformationItem_3040(domainElement, containerView, index, persisted, preferencesHint);
		case ClassEditPartCN.VISUAL_ID:
			return createClass_3010(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return createPrimitiveType_3026(domainElement, containerView, index, persisted, preferencesHint);
		case DataTypeEditPartCN.VISUAL_ID:
			return createDataType_3027(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPartCN.VISUAL_ID:
			return createComment_3028(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPartCN.VISUAL_ID:
			return createConstraint_3029(domainElement, containerView, index, persisted, preferencesHint);
		case NestedInterfaceForClassEditPart.VISUAL_ID:
			return createInterface_3036(domainElement, containerView, index, persisted, preferencesHint);
		case NestedInterfaceForComponentEditPart.VISUAL_ID:
			return createInterface_3037(domainElement, containerView, index, persisted, preferencesHint);
		case NestedInterfaceForInterfaceEditPart.VISUAL_ID:
			return createInterface_3038(domainElement, containerView, index, persisted, preferencesHint);
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
		case AssociationClassDashedLinkEditPart.VISUAL_ID:
			return createLink_4016(containerView, index, persisted, preferencesHint);
		case AssociationClassLinkEditPart.VISUAL_ID:
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
		case InstanceSpecificationLinkEditPart.VISUAL_ID:
			return createInstanceSpecification_4021(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ContainmentSubLinkEditPart.VISUAL_ID:
			return createLink_4022(containerView, index, persisted, preferencesHint);
		case ContainmentLinkEditPart.VISUAL_ID:
			return createLink_4023(containerView, index, persisted, preferencesHint);
		case ConnectorTimeObservationEditPart.VISUAL_ID:
			return createTimeObservationEvent_4024(containerView, index, persisted, preferencesHint);
		case ConnectorDurationObservationEditPart.VISUAL_ID:
			return createDurationObservationEvent_4025(containerView, index, persisted, preferencesHint);
		case InformationFlowEditPart.VISUAL_ID:
			return createInformationFlow_4026(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createDependency_2014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label1 = createLabel(node, UMLVisualIDRegistry.getType(MultiDependencyLabelEditPart.VISUAL_ID));
		label1.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location1 = (Location)label1.getLayoutConstraint();
		location1.setX(0);
		location1.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAssociationClass_2013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AssociationClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "AssociationClass");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "AssociationClass");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "AssociationClass");
		Node label5066 = createLabel(node, UMLVisualIDRegistry.getType(AssociationClassNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(AssociationClassAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(AssociationClassOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "AssociationClass");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAssociation_2015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AssociationNodeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "AssociationNode");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_2001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InstanceSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InstanceSpecification");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InstanceSpecification");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InstanceSpecification");
		Node label5002 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "InstanceSpecification");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_2002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Component");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Component");
		Node label5005 = createLabel(node, UMLVisualIDRegistry.getType(ComponentNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentNestedClassifierCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignal_2003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SignalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Signal");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Signal");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Signal");
		Node label5008 = createLabel(node, UMLVisualIDRegistry.getType(SignalNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(SignalAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Signal");
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
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Interface");
		Node label5011 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Interface");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_2005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ModelEditPartTN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Model");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Model");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Model");
		Node label5020 = createLabel(node, UMLVisualIDRegistry.getType(ModelNameEditPartTN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ModelPackageableElementCompartmentEditPartTN.VISUAL_ID), false, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Model");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_2006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(EnumerationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Enumeration");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Enumeration");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Enumeration");
		Node label5023 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Enumeration");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label5026 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID), false, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Package");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInformationItem_2099(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InformationItemEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InformationItem");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InformationItem");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InformationItem");
		Node label5161 = createLabel(node, UMLVisualIDRegistry.getType(InformationItemNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_2008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Class");
		Node label5029 = createLabel(node, UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ClassAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Class");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_2009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "PrimitiveType");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "PrimitiveType");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "PrimitiveType");
		Node label5032 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(PrimitiveTypeOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "PrimitiveType");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_2010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DataType");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DataType");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DataType");
		Node label5035 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "DataType");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_2011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label5037 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		Node label5159 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label5038 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		return node;
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
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ShortCutDiagram");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ShortCutDiagram");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ShortCutDiagram");
		Node label0 = createLabel(node, UMLVisualIDRegistry.getType(DiagramNameEditPart.VISUAL_ID));
		label0.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location0 = (Location)label0.getLayoutConstraint();
		location0.setX(0);
		location0.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationObservation_2095(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DurationObservation");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DurationObservation");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DurationObservation");
		Node label5155 = createLabel(node, UMLVisualIDRegistry.getType(DurationObservationNameEditPart.VISUAL_ID));
		label5155.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5155 = (Location)label5155.getLayoutConstraint();
		location5155.setX(25);
		location5155.setY(3);
		Node label5156 = createLabel(node, UMLVisualIDRegistry.getType(DurationObservationStereotypeLabelEditPart.VISUAL_ID));
		label5156.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5156 = (Location)label5156.getLayoutConstraint();
		location5156.setX(25);
		location5156.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeObservation_2096(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "TimeObservation");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeObservation");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "TimeObservation");
		Node label5153 = createLabel(node, UMLVisualIDRegistry.getType(TimeObservationNameEditPart.VISUAL_ID));
		label5153.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5153 = (Location)label5153.getLayoutConstraint();
		location5153.setX(25);
		location5153.setY(3);
		Node label5154 = createLabel(node, UMLVisualIDRegistry.getType(TimeObservationStereotypeLabelEditPart.VISUAL_ID));
		label5154.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5154 = (Location)label5154.getLayoutConstraint();
		location5154.setX(25);
		location5154.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNamedElement_2097(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label5157 = createLabel(node, UMLVisualIDRegistry.getType(DefaultNamedElementNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNamedElement_2098(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ShapeNamedElementEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ShapeNamedElement");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ShapeNamedElement");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ShapeNamedElement");
		Node label5158 = createLabel(node, UMLVisualIDRegistry.getType(ShapeNamedElementNameEditPart.VISUAL_ID));
		label5158.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5158 = (Location)label5158.getLayoutConstraint();
		location5158.setX(25);
		location5158.setY(3);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyForClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Property");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Property");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyForComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Property");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Property");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyForSignalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Property");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Property");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyForInterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Property");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Property");
		return node;
	}


	/**
	 * @generated
	 */
	public Node createProperty_3041(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyforPrimitiveTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Property");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Property");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyforDataTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Property");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Property");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(NestedClassForClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Class");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(NestedClassForComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Class");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(NestedClassForInterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Class");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationForClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Operation");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Operation");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationForComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Operation");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Operation");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationForInterfaceEditpart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Operation");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Operation");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3042(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationForPrimitiveTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Operation");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Operation");
		return node;
	}


	/**
	 * @generated
	 */
	public Node createOperation_3019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationForDataTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Operation");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Operation");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConnectableElementTemplateParameter_3034(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ConnectableElementTemplateParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ConnectableElementTemplateParameter");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ConnectableElementTemplateParameter");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperationTemplateParameter_3035(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationTemplateParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OperationTemplateParameter");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OperationTemplateParameter");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClassifierTemplateParameter_3031(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ClassifierTemplateParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ClassifierTemplateParameter");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ClassifierTemplateParameter");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTemplateParameter_3016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(TemplateParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TemplateParameter");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "TemplateParameter");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumerationLiteral_3017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(EnumerationLiteralEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "EnumerationLiteral");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "EnumerationLiteral");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createReception_3011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ReceptionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Reception");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Reception");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createReception_3039(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ReceptionInInterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Reception");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Reception");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSlot_3030(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(SlotEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Slot");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Slot");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createRedefinableTemplateSignature_3015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(RedefinableTemplateSignatureEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "RedefinableTemplateSignature");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "RedefinableTemplateSignature");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "RedefinableTemplateSignature");
		createCompartment(node, UMLVisualIDRegistry.getType(RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID), false, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "RedefinableTemplateSignature");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_3032(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ContainmentCircleEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "ContainmentCircle");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ContainmentCircle");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "ContainmentCircle");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTemplateSignature_3033(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TemplateSignatureEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "TemplateSignature");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TemplateSignature");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "TemplateSignature");
		createCompartment(node, UMLVisualIDRegistry.getType(TemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID), false, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "TemplateSignature");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_3020(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InstanceSpecificationEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InstanceSpecification");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InstanceSpecification");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InstanceSpecification");
		Node label5040 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "InstanceSpecification");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3021(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Component");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Component");
		Node label5043 = createLabel(node, UMLVisualIDRegistry.getType(ComponentNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentAttributeCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentOperationCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignal_3022(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SignalEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Signal");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Signal");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Signal");
		Node label5046 = createLabel(node, UMLVisualIDRegistry.getType(SignalNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(SignalAttributeCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Signal");
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
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Interface");
		Node label5049 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceAttributeCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceOperationCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Interface");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_3024(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label5052 = createLabel(node, UMLVisualIDRegistry.getType(ModelNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ModelPackageableElementCompartmentEditPartCN.VISUAL_ID), false, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Model");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_3025(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(EnumerationEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Enumeration");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Enumeration");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Enumeration");
		Node label5055 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Enumeration");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_3009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label5017 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPartCN.VISUAL_ID), false, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Package");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInformationItem_3040(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InformationItemEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "InformationItem");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InformationItem");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "InformationItem");
		Node label5162 = createLabel(node, UMLVisualIDRegistry.getType(InformationItemNameEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ClassEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Class");
		Node label5014 = createLabel(node, UMLVisualIDRegistry.getType(ClassNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ClassAttributeCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Class");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_3026(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveTypeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "PrimitiveType");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "PrimitiveType");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "PrimitiveType");
		Node label5058 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(PrimitiveTypeAttributeCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(PrimitiveTypeOperationCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "PrimitiveType");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_3027(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataTypeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "DataType");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DataType");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "DataType");
		Node label5061 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeNameEditPartCN.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeAttributeCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeOperationCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "DataType");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3028(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label5063 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3029(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label5064 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPartCN.VISUAL_ID));
		Node label5160 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintBodyEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3036(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(NestedInterfaceForClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Interface");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3037(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(NestedInterfaceForComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Interface");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3038(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(NestedInterfaceForInterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Interface");
		return node;
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
		edge.setType(UMLVisualIDRegistry.getType(AssociationClassDashedLinkEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "AssociationClassDashedLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "AssociationClassDashedLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "AssociationClassDashedLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociationClass_4017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AssociationClassLinkEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "AssociationClassLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "AssociationClassLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "AssociationClassLink");
		Node label6031 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationClassRoleSourceEditPart.VISUAL_ID));
		label6031.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6031 = (Location)label6031.getLayoutConstraint();
		location6031.setX(0);
		location6031.setY(-20);
		Node label6032 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationClassRoleTargetEditPart.VISUAL_ID));
		label6032.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6032 = (Location)label6032.getLayoutConstraint();
		location6032.setX(0);
		location6032.setY(20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "AssociationClassLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_4001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "AssociationLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "AssociationLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "AssociationLink");
		Node label6001 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeAssociationEditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location)label6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(-20);
		Node label6002 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationNameEditPart.VISUAL_ID));
		label6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location)label6002.getLayoutConstraint();
		location6002.setX(0);
		location6002.setY(20);
		Node label6003 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationTargetNameEditPart.VISUAL_ID));
		label6003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6003 = (Location)label6003.getLayoutConstraint();
		location6003.setX(0);
		location6003.setY(-20);
		Node label6005 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationSourceNameEditPart.VISUAL_ID));
		label6005.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6005 = (Location)label6005.getLayoutConstraint();
		location6005.setX(0);
		location6005.setY(20);
		Node label6033 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationMultiplicitySourceEditPart.VISUAL_ID));
		label6033.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6033 = (Location)label6033.getLayoutConstraint();
		location6033.setX(0);
		location6033.setY(20);
		Node label6034 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationMultiplicityTargetEditPart.VISUAL_ID));
		label6034.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6034 = (Location)label6034.getLayoutConstraint();
		location6034.setX(0);
		location6034.setY(-20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "AssociationLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_4019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AssociationBranchEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "AssociationBranchLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "AssociationBranchLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "AssociationBranchLink");
		Node label6024 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationBranchRoleEditPart.VISUAL_ID));
		label6024.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6024 = (Location)label6024.getLayoutConstraint();
		location6024.setX(0);
		location6024.setY(-20);
		Node label6035 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationBranchMutliplicityEditPart.VISUAL_ID));
		label6035.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6035 = (Location)label6035.getLayoutConstraint();
		location6035.setX(0);
		location6035.setY(20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "AssociationBranchLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotyperGeneralizationEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location)label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(40);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Generalization");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createInterfaceRealization_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "InterfaceRealization");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "InterfaceRealization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "InterfaceRealization");
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location)label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(40);
		Node label6009 = createLabel(edge, UMLVisualIDRegistry.getType(InterfaceRealizationNameEditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6009 = (Location)label6009.getLayoutConstraint();
		location6009.setX(0);
		location6009.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "InterfaceRealization");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createSubstitution_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6010 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeSubstitutionEditPart.VISUAL_ID));
		label6010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6010 = (Location)label6010.getLayoutConstraint();
		location6010.setX(0);
		location6010.setY(40);
		Node label6011 = createLabel(edge, UMLVisualIDRegistry.getType(SubstitutionNameEditPart.VISUAL_ID));
		label6011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6011 = (Location)label6011.getLayoutConstraint();
		location6011.setX(0);
		location6011.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Substitution");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createRealization_4005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6012 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeRealizationEditPart.VISUAL_ID));
		label6012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6012 = (Location)label6012.getLayoutConstraint();
		location6012.setX(0);
		location6012.setY(40);
		Node label6013 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationNameEditPart.VISUAL_ID));
		label6013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6013 = (Location)label6013.getLayoutConstraint();
		location6013.setX(0);
		location6013.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Realization");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAbstraction_4006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6014 = createLabel(edge, UMLVisualIDRegistry.getType(AbstractionNameEditPart.VISUAL_ID));
		label6014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6014 = (Location)label6014.getLayoutConstraint();
		location6014.setX(0);
		location6014.setY(40);
		Node label6015 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeAbstractionEditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6015 = (Location)label6015.getLayoutConstraint();
		location6015.setX(0);
		location6015.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Abstraction");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createUsage_4007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6016 = createLabel(edge, UMLVisualIDRegistry.getType(UsageNameEditPart.VISUAL_ID));
		label6016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6016 = (Location)label6016.getLayoutConstraint();
		location6016.setX(0);
		location6016.setY(40);
		Node label6017 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeUsageEditPart.VISUAL_ID));
		label6017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6017 = (Location)label6017.getLayoutConstraint();
		location6017.setX(0);
		location6017.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "Usage");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6026 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		label6026.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6026 = (Location)label6026.getLayoutConstraint();
		location6026.setX(0);
		location6026.setY(40);
		Node label6027 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeDependencyEditPart.VISUAL_ID));
		label6027.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6027 = (Location)label6027.getLayoutConstraint();
		location6027.setX(0);
		location6027.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "DependencyLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "DependencyBranchLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "DependencyBranchLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "DependencyBranchLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createElementImport_4009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ElementImportEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ElementImport");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ElementImport");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ElementImport");
		Node label6020 = createLabel(edge, UMLVisualIDRegistry.getType(ElementImportAliasEditPart.VISUAL_ID));
		label6020.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6020 = (Location)label6020.getLayoutConstraint();
		location6020.setX(0);
		location6020.setY(40);
		Node label6021 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeElementImportEditPart.VISUAL_ID));
		label6021.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6021 = (Location)label6021.getLayoutConstraint();
		location6021.setX(0);
		location6021.setY(60);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "ElementImport");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageImport_4010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6022 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypePackageImportEditPart.VISUAL_ID));
		label6022.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6022 = (Location)label6022.getLayoutConstraint();
		location6022.setX(0);
		location6022.setY(40);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "PackageImport");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageMerge_4011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		Node label6030 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypePackageMergeEditPart.VISUAL_ID));
		label6030.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6030 = (Location)label6030.getLayoutConstraint();
		location6030.setX(0);
		location6030.setY(40);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "PackageMerge");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createProfileApplication_4012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ProfileApplicationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ProfileApplication");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ProfileApplication");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ProfileApplication");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4013(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
	public Edge createConstraintConstrainedElement_4014(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
	public Edge createTemplateBinding_4015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(TemplateBindingEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "TemplateBinding");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "TemplateBinding");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "TemplateBinding");
		Node label6023 = createLabel(edge, UMLVisualIDRegistry.getType(BindingSubstitutionEditPart.VISUAL_ID));
		label6023.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6023 = (Location)label6023.getLayoutConstraint();
		location6023.setX(0);
		location6023.setY(40);
		Node label6036 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeTemplateBindingEditPart.VISUAL_ID));
		label6036.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6036 = (Location)label6036.getLayoutConstraint();
		location6036.setX(0);
		location6036.setY(20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "TemplateBinding");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralizationSet_4020(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationSetEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "GeneralizationSet");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "GeneralizationSet");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "GeneralizationSet");
		Node label5067 = createLabel(edge, UMLVisualIDRegistry.getType(ConstraintLabelEditPart.VISUAL_ID));
		label5067.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5067 = (Location)label5067.getLayoutConstraint();
		location5067.setX(0);
		location5067.setY(20);
		Node label6037 = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeGeneralizationSetLabelEditPart.VISUAL_ID));
		label6037.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6037 = (Location)label6037.getLayoutConstraint();
		location6037.setX(0);
		location6037.setY(40);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "GeneralizationSet");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createInstanceSpecification_4021(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(InstanceSpecificationLinkEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "InstanceSpecificationLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "InstanceSpecificationLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "InstanceSpecificationLink");
		Node label6039 = createLabel(edge, UMLVisualIDRegistry.getType(SourceISLinkLabelEditPart.VISUAL_ID));
		label6039.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6039 = (Location)label6039.getLayoutConstraint();
		location6039.setX(0);
		location6039.setY(20);
		Node label6038 = createLabel(edge, UMLVisualIDRegistry.getType(TargetISLinkLabelEditPart.VISUAL_ID));
		label6038.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6038 = (Location)label6038.getLayoutConstraint();
		location6038.setX(0);
		location6038.setY(20);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "InstanceSpecificationLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createLink_4022(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ContainmentSubLinkEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ContainmentSubLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ContainmentSubLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ContainmentSubLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createLink_4023(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ContainmentLinkEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "ContainmentLink");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ContainmentLink");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "ContainmentLink");
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createTimeObservationEvent_4024(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConnectorTimeObservationEditPart.VISUAL_ID));
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
	public Edge createDurationObservationEvent_4025(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConnectorDurationObservationEditPart.VISUAL_ID));
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
	public Edge createInformationFlow_4026(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(InformationFlowEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "InformationFlow");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "InformationFlow");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "InformationFlow");
		Node label6040 = createLabel(edge, UMLVisualIDRegistry.getType(InformationFlowConveyedLabelEditPart.VISUAL_ID));
		label6040.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6040 = (Location)label6040.getLayoutConstraint();
		location6040.setX(0);
		location6040.setY(30);
		Node label6041 = createLabel(edge, UMLVisualIDRegistry.getType(InformationFlowAppliedStereotypeEditPart.VISUAL_ID));
		label6041.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6041 = (Location)label6041.getLayoutConstraint();
		location6041.setX(0);
		location6041.setY(15);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(edge, prefStore, "InformationFlow");
		return edge;
	}

	/**
	 * @generated
	 */
	protected void stampShortcut(View containerView, Node target) {
		if(!ModelEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ModelEditPart.MODEL_ID); //$NON-NLS-1$
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
