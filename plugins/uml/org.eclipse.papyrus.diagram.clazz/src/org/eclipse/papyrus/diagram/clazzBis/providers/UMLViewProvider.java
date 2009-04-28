package org.eclipse.papyrus.diagram.clazzBis.providers;

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
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(op.getSemanticHint())
				&& org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
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
			visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
			if (elementType != null) {
				if (!org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if (!org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
					if (domainElement == null || visualID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID == visualID || org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID == visualID
				|| org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (!org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null && visualID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
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
		diagram.setType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID);
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
			visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch (visualID) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
			return createDependency_1001(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
			return createAssociationClass_1002(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
			return createAssociation_1003(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
			return createInstanceSpecification_1004(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			return createComponent_1005(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			return createSignal_1006(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			return createInterface_1007(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			return createModel_1008(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
			return createEnumeration_1009(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			return createPackage_1010(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			return createClass_1011(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
			return createPrimitiveType_1012(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			return createDataType_1013(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
			return createConstraint_1014(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			return createComment_1015(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
			return createProperty_2001(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
			return createSlot_2002(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
			return createOperation_2003(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
			return createClass_2004(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return createRedefinableTemplateSignature_2005(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
			return createTemplateParameter_2006(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
			return createProperty_2007(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
			return createProperty_2008(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
			return createOperation_2009(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
			return createClass_2010(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
			return createInstanceSpecification_2011(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			return createComponent_2012(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			return createSignal_2013(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			return createInterface_2014(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			return createModel_2015(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
			return createEnumeration_2016(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
			return createEnumerationLiteral_2017(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			return createPackage_2018(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			return createClass_2019(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
			return createReception_2020(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
			return createProperty_2021(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
			return createOperation_2022(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
			return createClass_2023(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
			return createPrimitiveType_2024(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			return createDataType_2025(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
			return createProperty_2026(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
			return createOperation_2027(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
			return createComment_2028(domainElement, containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
			return createConstraint_2029(domainElement, containerView, index, persisted, preferencesHint);
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
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID:
			return createLink_3001(containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return createAssociationClass_3002(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return createAssociation_3003(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return createAssociation_3004(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_3005(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return createInterfaceRealization_3006(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return createSubstitution_3007(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return createRealization_3008(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return createAbstraction_3009(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return createUsage_3010(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return createDependency_3011(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return createDependency_3012(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return createElementImport_3013(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return createPackageImport_3014(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID:
			return createPackageMerge_3015(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID:
			return createProfileApplication_3016(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_3017(containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_3018(containerView, index, persisted, preferencesHint);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return createTemplateBinding_3019(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createDependency_1001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAssociationClass_1002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node AssociationClassName_4001 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassNameEditPart.VISUAL_ID));
		Node AssociationClassName_4002 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassName2EditPart.VISUAL_ID));
		Node AssociationClassQualifiedName_4003 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassAttributeCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAssociation_1003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_1004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node InstanceSpecificationName_4004 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationNameEditPart.VISUAL_ID));
		Node InstanceSpecificationName_4005 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName2EditPart.VISUAL_ID));
		Node InstanceSpecificationQualifiedName_4006 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_1005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ComponentName_4007 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNameEditPart.VISUAL_ID));
		Node ComponentName_4008 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName2EditPart.VISUAL_ID));
		Node ComponentQualifiedName_4009 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignal_1006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node SignalName_4010 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalNameEditPart.VISUAL_ID));
		Node SignalName_4011 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName2EditPart.VISUAL_ID));
		Node SignalQualifiedName_4012 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_1007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node InterfaceName_4013 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart.VISUAL_ID));
		Node InterfaceName_4014 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName2EditPart.VISUAL_ID));
		Node InterfaceQualifiedName_4015 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_1008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ModelName_4048 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelNameEditPart.VISUAL_ID));
		Node ModelName_4049 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName2EditPart.VISUAL_ID));
		Node ModelQualifiedName_4050 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID), false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_1009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node EnumerationName_4051 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationNameEditPart.VISUAL_ID));
		Node EnumerationName_4052 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName2EditPart.VISUAL_ID));
		Node EnumerationQualifiedName_4053 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_1010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node PackageName_4054 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageNameEditPart.VISUAL_ID));
		Node PackageName_4055 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName2EditPart.VISUAL_ID));
		Node PackageQualifiedName_4056 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID), false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_1011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ClassName_4057 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNameEditPart.VISUAL_ID));
		Node ClassName_4058 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName2EditPart.VISUAL_ID));
		Node ClassQualifiedName_4059 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartment2EditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_1012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node PrimitiveTypeName_4060 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeNameEditPart.VISUAL_ID));
		Node PrimitiveTypeName_4061 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName2EditPart.VISUAL_ID));
		Node PrimitiveTypeQualifiedName_4062 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_1013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node DataTypeName_4063 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeNameEditPart.VISUAL_ID));
		Node DataTypeName_4064 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName2EditPart.VISUAL_ID));
		Node DataTypeQualifiedName_4065 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedNameEditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartment2EditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartment2EditPart.VISUAL_ID),
				true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_1014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ConstraintName_4066 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintNameEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_1015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node CommentBody_4067 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_2001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSlot_2002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_2003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_2004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createRedefinableTemplateSignature_2005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID), false, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTemplateParameter_2006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_2007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_2008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_2009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_2010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_2011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node InstanceSpecificationName_4016 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName3EditPart.VISUAL_ID));
		Node InstanceSpecificationName_4017 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationName4EditPart.VISUAL_ID));
		Node InstanceSpecificationQualifiedName_4018 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_2012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ComponentName_4019 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName3EditPart.VISUAL_ID));
		Node ComponentName_4020 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentName4EditPart.VISUAL_ID));
		Node ComponentQualifiedName_4021 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node,
				org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartment2EditPart.VISUAL_ID), true, false,
				true, true);
		createCompartment(node,
				org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartment2EditPart.VISUAL_ID), true, false,
				true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignal_2013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node SignalName_4022 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName3EditPart.VISUAL_ID));
		Node SignalName_4023 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalName4EditPart.VISUAL_ID));
		Node SignalQualifiedName_4024 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartment2EditPart.VISUAL_ID),
				true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_2014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node InterfaceName_4025 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName3EditPart.VISUAL_ID));
		Node InterfaceName_4026 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName4EditPart.VISUAL_ID));
		Node InterfaceQualifiedName_4027 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node,
				org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartment2EditPart.VISUAL_ID), true, false,
				true, true);
		createCompartment(node,
				org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartment2EditPart.VISUAL_ID), true, false,
				true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createModel_2015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ModelName_4045 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName3EditPart.VISUAL_ID));
		Node ModelName_4046 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelName4EditPart.VISUAL_ID));
		Node ModelQualifiedName_4047 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID), false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_2016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node EnumerationName_4028 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName3EditPart.VISUAL_ID));
		Node EnumerationName_4029 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationName4EditPart.VISUAL_ID));
		Node EnumerationQualifiedName_4030 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumerationLiteral_2017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node PackageName_4042 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName3EditPart.VISUAL_ID));
		Node PackageName_4043 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageName4EditPart.VISUAL_ID));
		Node PackageQualifiedName_4044 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID), false, false, false, false);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_2019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ClassName_4031 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName3EditPart.VISUAL_ID));
		Node ClassName_4032 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassName4EditPart.VISUAL_ID));
		Node ClassQualifiedName_4033 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartmentEditPart.VISUAL_ID), true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createReception_2020(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_2021(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_2022(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_2023(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_2024(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node PrimitiveTypeName_4034 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName3EditPart.VISUAL_ID));
		Node PrimitiveTypeName_4035 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeName4EditPart.VISUAL_ID));
		Node PrimitiveTypeQualifiedName_4036 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeQualifiedName2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_2025(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node DataTypeName_4037 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName3EditPart.VISUAL_ID));
		Node DataTypeName_4038 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeName4EditPart.VISUAL_ID));
		Node DataTypeQualifiedName_4039 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeQualifiedName2EditPart.VISUAL_ID));
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_2026(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_2027(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2028(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node CommentBody_4040 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentBody2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_2029(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ConstraintName_4041 = createLabel(node, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintName2EditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createLink_3001(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociationClass_3002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_3003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node AssociationName_4068 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart.VISUAL_ID));
		AssociationName_4068.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4068 = (Location) AssociationName_4068.getLayoutConstraint();
		location4068.setX(0);
		location4068.setY(40);
		Node AssociationName_4069 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName2EditPart.VISUAL_ID));
		AssociationName_4069.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4069 = (Location) AssociationName_4069.getLayoutConstraint();
		location4069.setX(0);
		location4069.setY(60);
		Node AssociationName_4070 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName3EditPart.VISUAL_ID));
		AssociationName_4070.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4070 = (Location) AssociationName_4070.getLayoutConstraint();
		location4070.setX(0);
		location4070.setY(80);
		Node AssociationName_4071 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName4EditPart.VISUAL_ID));
		AssociationName_4071.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4071 = (Location) AssociationName_4071.getLayoutConstraint();
		location4071.setX(0);
		location4071.setY(100);
		Node AssociationName_4072 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName5EditPart.VISUAL_ID));
		AssociationName_4072.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4072 = (Location) AssociationName_4072.getLayoutConstraint();
		location4072.setX(0);
		location4072.setY(120);
		Node AssociationName_4073 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName6EditPart.VISUAL_ID));
		AssociationName_4073.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4073 = (Location) AssociationName_4073.getLayoutConstraint();
		location4073.setX(0);
		location4073.setY(140);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_3004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_3005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node GeneralizationIsSubstitutable_4074 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationIsSubstitutableEditPart.VISUAL_ID));
		GeneralizationIsSubstitutable_4074.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4074 = (Location) GeneralizationIsSubstitutable_4074.getLayoutConstraint();
		location4074.setX(0);
		location4074.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createInterfaceRealization_3006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node InterfaceRealizationName_4075 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationNameEditPart.VISUAL_ID));
		InterfaceRealizationName_4075.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4075 = (Location) InterfaceRealizationName_4075.getLayoutConstraint();
		location4075.setX(0);
		location4075.setY(40);
		Node InterfaceRealizationName_4076 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationName2EditPart.VISUAL_ID));
		InterfaceRealizationName_4076.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4076 = (Location) InterfaceRealizationName_4076.getLayoutConstraint();
		location4076.setX(0);
		location4076.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createSubstitution_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node SubstitutionName_4077 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionNameEditPart.VISUAL_ID));
		SubstitutionName_4077.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4077 = (Location) SubstitutionName_4077.getLayoutConstraint();
		location4077.setX(0);
		location4077.setY(40);
		Node SubstitutionName_4078 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionName2EditPart.VISUAL_ID));
		SubstitutionName_4078.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4078 = (Location) SubstitutionName_4078.getLayoutConstraint();
		location4078.setX(0);
		location4078.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createRealization_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node RealizationName_4079 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationNameEditPart.VISUAL_ID));
		RealizationName_4079.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4079 = (Location) RealizationName_4079.getLayoutConstraint();
		location4079.setX(0);
		location4079.setY(40);
		Node RealizationName_4080 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationName2EditPart.VISUAL_ID));
		RealizationName_4080.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4080 = (Location) RealizationName_4080.getLayoutConstraint();
		location4080.setX(0);
		location4080.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAbstraction_3009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node AbstractionName_4081 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionNameEditPart.VISUAL_ID));
		AbstractionName_4081.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4081 = (Location) AbstractionName_4081.getLayoutConstraint();
		location4081.setX(0);
		location4081.setY(40);
		Node AbstractionName_4082 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionName2EditPart.VISUAL_ID));
		AbstractionName_4082.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4082 = (Location) AbstractionName_4082.getLayoutConstraint();
		location4082.setX(0);
		location4082.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createUsage_3010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node UsageName_4083 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageNameEditPart.VISUAL_ID));
		UsageName_4083.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4083 = (Location) UsageName_4083.getLayoutConstraint();
		location4083.setX(0);
		location4083.setY(40);
		Node UsageName_4084 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageName2EditPart.VISUAL_ID));
		UsageName_4084.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4084 = (Location) UsageName_4084.getLayoutConstraint();
		location4084.setX(0);
		location4084.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_3011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node DependencyName_4085 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyNameEditPart.VISUAL_ID));
		DependencyName_4085.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4085 = (Location) DependencyName_4085.getLayoutConstraint();
		location4085.setX(0);
		location4085.setY(40);
		Node DependencyName_4086 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName2EditPart.VISUAL_ID));
		DependencyName_4086.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4086 = (Location) DependencyName_4086.getLayoutConstraint();
		location4086.setX(0);
		location4086.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_3012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node DependencyName_4087 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName3EditPart.VISUAL_ID));
		DependencyName_4087.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4087 = (Location) DependencyName_4087.getLayoutConstraint();
		location4087.setX(0);
		location4087.setY(40);
		Node DependencyName_4088 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyName4EditPart.VISUAL_ID));
		DependencyName_4088.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4088 = (Location) DependencyName_4088.getLayoutConstraint();
		location4088.setX(0);
		location4088.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createElementImport_3013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node ElementImportAlias_4089 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAliasEditPart.VISUAL_ID));
		ElementImportAlias_4089.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4089 = (Location) ElementImportAlias_4089.getLayoutConstraint();
		location4089.setX(0);
		location4089.setY(40);
		Node ElementImportAlias_4090 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportAlias2EditPart.VISUAL_ID));
		ElementImportAlias_4090.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4090 = (Location) ElementImportAlias_4090.getLayoutConstraint();
		location4090.setX(0);
		location4090.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageImport_3014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node PackageImportVisibility_4091 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportVisibilityEditPart.VISUAL_ID));
		PackageImportVisibility_4091.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4091 = (Location) PackageImportVisibility_4091.getLayoutConstraint();
		location4091.setX(0);
		location4091.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPackageMerge_3015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createProfileApplication_3016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_3017(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_3018(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList points = new ArrayList(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createTemplateBinding_3019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
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
		edge.setType(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node TemplateBindingLabel_4092 = createLabel(edge, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
				.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.WrappingLabelEditPart.VISUAL_ID));
		TemplateBindingLabel_4092.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location4092 = (Location) TemplateBindingLabel_4092.getLayoutConstraint();
		location4092.setX(0);
		location4092.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
		if (!org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID); //$NON-NLS-1$
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
	private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
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
}
