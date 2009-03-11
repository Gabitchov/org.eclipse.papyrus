/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.*;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.view.factories.*;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (ModelEditPart.MODEL_ID.equals(diagramKind) && UMLVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return ModelViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				// - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint)
				// - generated ViewFactory.decorateView() for parent element
				if (!ModelEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case Dependency2EditPart.VISUAL_ID:
				case AssociationClassEditPart.VISUAL_ID:
				case AssociationNodeEditPart.VISUAL_ID:
				case InstanceSpecificationEditPart.VISUAL_ID:
				case ComponentEditPart.VISUAL_ID:
				case SignalEditPart.VISUAL_ID:
				case InterfaceEditPart.VISUAL_ID:
				case Model2EditPart.VISUAL_ID:
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
				case InstanceSpecification2EditPart.VISUAL_ID:
				case ComponentEditPartCN.VISUAL_ID:
				case SignalEditPartCN.VISUAL_ID:
				case InterfaceEditPartCN.VISUAL_ID:
				case Model3EditPart.VISUAL_ID:
				case Package2EditPart.VISUAL_ID:
				case ClassEditPartCN.VISUAL_ID:
				case Property4EditPart.VISUAL_ID:
				case Operation3EditPart.VISUAL_ID:
				case Class5EditPart.VISUAL_ID:
				case Property5EditPart.VISUAL_ID:
				case Operation4EditPart.VISUAL_ID:
					if (domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case AssociationClassName2EditPart.VISUAL_ID:
				case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
					if (AssociationClassEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeInstanceSpecificationEditPart.VISUAL_ID:
				case InstanceSpecificationName2EditPart.VISUAL_ID:
				case InstanceSpecificationQualifiedNameEditPart.VISUAL_ID:
				case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
					if (InstanceSpecificationEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ComponentNameEditPart.VISUAL_ID:
				case ComponentAttributeCompartmentEditPart.VISUAL_ID:
				case ComponentOperationCompartmentEditPart.VISUAL_ID:
				case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
					if (ComponentEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SignalNameEditPart.VISUAL_ID:
				case SignalAttributeCompartmentEditPart.VISUAL_ID:
					if (SignalEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InterfaceNameEditPart.VISUAL_ID:
				case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				case InterfaceOperationCompartmentEditPart.VISUAL_ID:
				case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
					if (InterfaceEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeModelEditPart.VISUAL_ID:
				case ModelName2EditPart.VISUAL_ID:
				case ModelQualifiedNameEditPart.VISUAL_ID:
				case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
					if (Model2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EnumerationNameEditPart.VISUAL_ID:
				case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
					if (EnumerationEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypePackageEditPart.VISUAL_ID:
				case PackageName2EditPart.VISUAL_ID:
				case PackageQualifiedNameEditPart.VISUAL_ID:
				case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
					if (PackageEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ClassNameEditPart.VISUAL_ID:
				case ClassAttributeCompartment2EditPart.VISUAL_ID:
				case ClassOperationCompartment2EditPart.VISUAL_ID:
				case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
					if (ClassEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PrimitiveTypeNameEditPart.VISUAL_ID:
					if (PrimitiveTypeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DataTypeNameEditPart.VISUAL_ID:
				case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
				case DataTypeOperationCompartmentEditPart.VISUAL_ID:
					if (DataTypeEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ConstraintNameEditPart.VISUAL_ID:
					if (ConstraintEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CommentBodyEditPart.VISUAL_ID:
					if (CommentEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
					if (RedefinableTemplateSignatureEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeChildNodeInstanceSpecificationEditPart.VISUAL_ID:
				case InstanceSpecificationName4EditPart.VISUAL_ID:
				case InstanceSpecificationQualifiedName2EditPart.VISUAL_ID:
				case InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
					if (InstanceSpecification2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ComponentNameEditPartCN.VISUAL_ID:
				case ComponentAttributeCompartment2EditPart.VISUAL_ID:
				case ComponentOperationCompartment2EditPart.VISUAL_ID:
				case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
					if (ComponentEditPartCN.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SignalNameEditPartCN.VISUAL_ID:
				case SignalAttributeCompartment2EditPart.VISUAL_ID:
					if (SignalEditPartCN.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case InterfaceNameEditPartCN.VISUAL_ID:
				case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
				case InterfaceOperationCompartment2EditPart.VISUAL_ID:
				case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
					if (InterfaceEditPartCN.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeChildNodeModelEditPart.VISUAL_ID:
				case ModelName4EditPart.VISUAL_ID:
				case ModelQualifiedName2EditPart.VISUAL_ID:
				case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
					if (Model3EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EnumerationNameEditPartCN.VISUAL_ID:
				case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
					if (EnumerationEditPartCN.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeChildNodePackageEditPart.VISUAL_ID:
				case PackageName4EditPart.VISUAL_ID:
				case PackageQualifiedName2EditPart.VISUAL_ID:
				case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
					if (Package2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ClassNameEditPartCN.VISUAL_ID:
				case ClassAttributeCompartmentEditPart.VISUAL_ID:
				case ClassOperationCompartmentEditPart.VISUAL_ID:
				case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
					if (ClassEditPartCN.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PrimitiveTypeNameEditPartCN.VISUAL_ID:
					if (PrimitiveTypeEditPartCN.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DataTypeNameEditPartCN.VISUAL_ID:
				case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
				case DataTypeOperationCompartment2EditPart.VISUAL_ID:
					if (DataTypeEditPartCN.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CommentBody2EditPart.VISUAL_ID:
					if (Comment2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ConstraintName2EditPart.VISUAL_ID:
					if (Constraint2EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeAssociationEditPart.VISUAL_ID:
				case AssociationName2EditPart.VISUAL_ID:
				case AssociationName3EditPart.VISUAL_ID:
				case AssociationName4EditPart.VISUAL_ID:
				case AssociationName5EditPart.VISUAL_ID:
				case AssociationName6EditPart.VISUAL_ID:
					if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotyperGeneralizationEditPart.VISUAL_ID:
					if (GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID:
				case InterfaceRealizationName2EditPart.VISUAL_ID:
					if (InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeSubstitutionEditPart.VISUAL_ID:
				case SubstitutionName2EditPart.VISUAL_ID:
					if (SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypeRealizationEditPart.VISUAL_ID:
				case RealizationName2EditPart.VISUAL_ID:
					if (RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AbstractionNameEditPart.VISUAL_ID:
				case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
					if (AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case UsageNameEditPart.VISUAL_ID:
				case AppliedStereotypeUsageEditPart.VISUAL_ID:
					if (UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DependencyNameEditPart.VISUAL_ID:
				case AppliedStereotypeDependencyEditPart.VISUAL_ID:
					if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DependencyName3EditPart.VISUAL_ID:
				case AppliedStereotypeDependency3EditPart.VISUAL_ID:
					if (Dependency3EditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ElementImportAliasEditPart.VISUAL_ID:
				case AppliedStereotypeElementImportEditPart.VISUAL_ID:
					if (ElementImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AppliedStereotypePackageImportEditPart.VISUAL_ID:
					if (PackageImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case WrappingLabelEditPart.VISUAL_ID:
					if (TemplateBindingEditPart.VISUAL_ID != UMLVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null || !UMLVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case Dependency2EditPart.VISUAL_ID:
			return Dependency2ViewFactory.class;
		case AssociationClassEditPart.VISUAL_ID:
			return AssociationClassViewFactory.class;
		case AssociationClassName2EditPart.VISUAL_ID:
			return AssociationClassName2ViewFactory.class;
		case AssociationNodeEditPart.VISUAL_ID:
			return AssociationNodeViewFactory.class;
		case InstanceSpecificationEditPart.VISUAL_ID:
			return InstanceSpecificationViewFactory.class;
		case AppliedStereotypeInstanceSpecificationEditPart.VISUAL_ID:
			return InstanceSpecificationNameViewFactory.class;
		case InstanceSpecificationName2EditPart.VISUAL_ID:
			return InstanceSpecificationName2ViewFactory.class;
		case InstanceSpecificationQualifiedNameEditPart.VISUAL_ID:
			return InstanceSpecificationQualifiedNameViewFactory.class;
		case ComponentEditPart.VISUAL_ID:
			return ComponentViewFactory.class;
		case ComponentNameEditPart.VISUAL_ID:
			return ComponentNameViewFactory.class;
		case SignalEditPart.VISUAL_ID:
			return SignalViewFactory.class;
		case SignalNameEditPart.VISUAL_ID:
			return SignalNameViewFactory.class;
		case InterfaceEditPart.VISUAL_ID:
			return InterfaceViewFactory.class;
		case InterfaceNameEditPart.VISUAL_ID:
			return InterfaceNameViewFactory.class;
		case Model2EditPart.VISUAL_ID:
			return Model2ViewFactory.class;
		case AppliedStereotypeModelEditPart.VISUAL_ID:
			return ModelNameViewFactory.class;
		case ModelName2EditPart.VISUAL_ID:
			return ModelName2ViewFactory.class;
		case ModelQualifiedNameEditPart.VISUAL_ID:
			return ModelQualifiedNameViewFactory.class;
		case EnumerationEditPart.VISUAL_ID:
			return EnumerationViewFactory.class;
		case EnumerationNameEditPart.VISUAL_ID:
			return EnumerationNameViewFactory.class;
		case PackageEditPart.VISUAL_ID:
			return PackageViewFactory.class;
		case AppliedStereotypePackageEditPart.VISUAL_ID:
			return PackageNameViewFactory.class;
		case PackageName2EditPart.VISUAL_ID:
			return PackageName2ViewFactory.class;
		case PackageQualifiedNameEditPart.VISUAL_ID:
			return PackageQualifiedNameViewFactory.class;
		case ClassEditPart.VISUAL_ID:
			return ClassViewFactory.class;
		case ClassNameEditPart.VISUAL_ID:
			return ClassNameViewFactory.class;
		case PrimitiveTypeEditPart.VISUAL_ID:
			return PrimitiveTypeViewFactory.class;
		case PrimitiveTypeNameEditPart.VISUAL_ID:
			return PrimitiveTypeNameViewFactory.class;
		case DataTypeEditPart.VISUAL_ID:
			return DataTypeViewFactory.class;
		case DataTypeNameEditPart.VISUAL_ID:
			return DataTypeNameViewFactory.class;
		case ConstraintEditPart.VISUAL_ID:
			return ConstraintViewFactory.class;
		case ConstraintNameEditPart.VISUAL_ID:
			return ConstraintNameViewFactory.class;
		case CommentEditPart.VISUAL_ID:
			return CommentViewFactory.class;
		case CommentBodyEditPart.VISUAL_ID:
			return CommentBodyViewFactory.class;
		case PropertyEditPart.VISUAL_ID:
			return PropertyViewFactory.class;
		case SlotEditPart.VISUAL_ID:
			return SlotViewFactory.class;
		case OperationEditPart.VISUAL_ID:
			return OperationViewFactory.class;
		case Class2EditPart.VISUAL_ID:
			return Class2ViewFactory.class;
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return RedefinableTemplateSignatureViewFactory.class;
		case TemplateParameterEditPart.VISUAL_ID:
			return TemplateParameterViewFactory.class;
		case Property2EditPart.VISUAL_ID:
			return Property2ViewFactory.class;
		case Property3EditPart.VISUAL_ID:
			return Property3ViewFactory.class;
		case Operation2EditPart.VISUAL_ID:
			return Operation2ViewFactory.class;
		case Class3EditPart.VISUAL_ID:
			return Class3ViewFactory.class;
		case InstanceSpecification2EditPart.VISUAL_ID:
			return InstanceSpecification2ViewFactory.class;
		case AppliedStereotypeChildNodeInstanceSpecificationEditPart.VISUAL_ID:
			return InstanceSpecificationName3ViewFactory.class;
		case InstanceSpecificationName4EditPart.VISUAL_ID:
			return InstanceSpecificationName4ViewFactory.class;
		case InstanceSpecificationQualifiedName2EditPart.VISUAL_ID:
			return InstanceSpecificationQualifiedName2ViewFactory.class;
		case ComponentEditPartCN.VISUAL_ID:
			return ComponentViewFactoryCN.class;
		case ComponentNameEditPartCN.VISUAL_ID:
			return ComponentNameViewFactoryCN.class;
		case SignalEditPartCN.VISUAL_ID:
			return SignalViewFactoryCN.class;
		case SignalNameEditPartCN.VISUAL_ID:
			return SignalNameViewFactoryCN.class;
		case InterfaceEditPartCN.VISUAL_ID:
			return InterfaceViewFactoryCN.class;
		case InterfaceNameEditPartCN.VISUAL_ID:
			return InterfaceNameViewFactoryCN.class;
		case Model3EditPart.VISUAL_ID:
			return Model3ViewFactory.class;
		case AppliedStereotypeChildNodeModelEditPart.VISUAL_ID:
			return ModelName3ViewFactory.class;
		case ModelName4EditPart.VISUAL_ID:
			return ModelName4ViewFactory.class;
		case ModelQualifiedName2EditPart.VISUAL_ID:
			return ModelQualifiedName2ViewFactory.class;
		case EnumerationEditPartCN.VISUAL_ID:
			return EnumerationViewFactoryCN.class;
		case EnumerationNameEditPartCN.VISUAL_ID:
			return EnumerationNameViewFactoryCN.class;
		case EnumerationLiteralEditPart.VISUAL_ID:
			return EnumerationLiteralViewFactory.class;
		case Package2EditPart.VISUAL_ID:
			return Package2ViewFactory.class;
		case AppliedStereotypeChildNodePackageEditPart.VISUAL_ID:
			return PackageName3ViewFactory.class;
		case PackageName4EditPart.VISUAL_ID:
			return PackageName4ViewFactory.class;
		case PackageQualifiedName2EditPart.VISUAL_ID:
			return PackageQualifiedName2ViewFactory.class;
		case ClassEditPartCN.VISUAL_ID:
			return ClassViewFactoryCN.class;
		case ClassNameEditPartCN.VISUAL_ID:
			return ClassNameViewFactoryCN.class;
		case ReceptionEditPart.VISUAL_ID:
			return ReceptionViewFactory.class;
		case Property4EditPart.VISUAL_ID:
			return Property4ViewFactory.class;
		case Operation3EditPart.VISUAL_ID:
			return Operation3ViewFactory.class;
		case Class5EditPart.VISUAL_ID:
			return Class5ViewFactory.class;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return PrimitiveTypeViewFactoryCN.class;
		case PrimitiveTypeNameEditPartCN.VISUAL_ID:
			return PrimitiveTypeNameViewFactoryCN.class;
		case DataTypeEditPartCN.VISUAL_ID:
			return DataTypeViewFactoryCN.class;
		case DataTypeNameEditPartCN.VISUAL_ID:
			return DataTypeNameViewFactoryCN.class;
		case Property5EditPart.VISUAL_ID:
			return Property5ViewFactory.class;
		case Operation4EditPart.VISUAL_ID:
			return Operation4ViewFactory.class;
		case Comment2EditPart.VISUAL_ID:
			return Comment2ViewFactory.class;
		case CommentBody2EditPart.VISUAL_ID:
			return CommentBody2ViewFactory.class;
		case Constraint2EditPart.VISUAL_ID:
			return Constraint2ViewFactory.class;
		case ConstraintName2EditPart.VISUAL_ID:
			return ConstraintName2ViewFactory.class;
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			return AssociationClassAttributeCompartmentViewFactory.class;
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			return InstanceSpecificationSlotCompartmentViewFactory.class;
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			return ComponentAttributeCompartmentViewFactory.class;
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			return ComponentOperationCompartmentViewFactory.class;
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			return ComponentNestedClassifierCompartmentViewFactory.class;
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			return RedefinableTemplateSignatureTemplateParameterCompartmentViewFactory.class;
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			return SignalAttributeCompartmentViewFactory.class;
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			return InterfaceAttributeCompartmentViewFactory.class;
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			return InterfaceOperationCompartmentViewFactory.class;
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			return InterfaceNestedClassifierCompartmentViewFactory.class;
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			return ModelPackageableElementCompartmentViewFactory.class;
		case InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
			return InstanceSpecificationSlotCompartment2ViewFactory.class;
		case ComponentAttributeCompartment2EditPart.VISUAL_ID:
			return ComponentAttributeCompartment2ViewFactory.class;
		case ComponentOperationCompartment2EditPart.VISUAL_ID:
			return ComponentOperationCompartment2ViewFactory.class;
		case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			return ComponentNestedClassifierCompartment2ViewFactory.class;
		case SignalAttributeCompartment2EditPart.VISUAL_ID:
			return SignalAttributeCompartment2ViewFactory.class;
		case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			return InterfaceAttributeCompartment2ViewFactory.class;
		case InterfaceOperationCompartment2EditPart.VISUAL_ID:
			return InterfaceOperationCompartment2ViewFactory.class;
		case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			return InterfaceNestedClassifierCompartment2ViewFactory.class;
		case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
			return ModelPackageableElementCompartment2ViewFactory.class;
		case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			return EnumerationEnumerationLiteralCompartment2ViewFactory.class;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return PackagePackageableElementCompartmentViewFactory.class;
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			return ClassAttributeCompartmentViewFactory.class;
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			return ClassOperationCompartmentViewFactory.class;
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			return ClassNestedClassifierCompartmentViewFactory.class;
		case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			return DataTypeAttributeCompartment2ViewFactory.class;
		case DataTypeOperationCompartment2EditPart.VISUAL_ID:
			return DataTypeOperationCompartment2ViewFactory.class;
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			return EnumerationEnumerationLiteralCompartmentViewFactory.class;
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			return PackagePackageableElementCompartment2ViewFactory.class;
		case ClassAttributeCompartment2EditPart.VISUAL_ID:
			return ClassAttributeCompartment2ViewFactory.class;
		case ClassOperationCompartment2EditPart.VISUAL_ID:
			return ClassOperationCompartment2ViewFactory.class;
		case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			return ClassNestedClassifierCompartment2ViewFactory.class;
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			return DataTypeAttributeCompartmentViewFactory.class;
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			return DataTypeOperationCompartmentViewFactory.class;
		case AppliedStereotypeAssociationEditPart.VISUAL_ID:
			return AssociationNameViewFactory.class;
		case AssociationName2EditPart.VISUAL_ID:
			return AssociationName2ViewFactory.class;
		case AssociationName3EditPart.VISUAL_ID:
			return AssociationName3ViewFactory.class;
		case AssociationName4EditPart.VISUAL_ID:
			return AssociationName4ViewFactory.class;
		case AssociationName5EditPart.VISUAL_ID:
			return AssociationName5ViewFactory.class;
		case AssociationName6EditPart.VISUAL_ID:
			return AssociationName6ViewFactory.class;
		case AppliedStereotyperGeneralizationEditPart.VISUAL_ID:
			return GeneralizationIsSubstitutableViewFactory.class;
		case AppliedStereotypeInterfaceRealizationEditPart.VISUAL_ID:
			return InterfaceRealizationNameViewFactory.class;
		case InterfaceRealizationName2EditPart.VISUAL_ID:
			return InterfaceRealizationName2ViewFactory.class;
		case AppliedStereotypeSubstitutionEditPart.VISUAL_ID:
			return SubstitutionNameViewFactory.class;
		case SubstitutionName2EditPart.VISUAL_ID:
			return SubstitutionName2ViewFactory.class;
		case AppliedStereotypeRealizationEditPart.VISUAL_ID:
			return RealizationNameViewFactory.class;
		case RealizationName2EditPart.VISUAL_ID:
			return RealizationName2ViewFactory.class;
		case AbstractionNameEditPart.VISUAL_ID:
			return AbstractionNameViewFactory.class;
		case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
			return AbstractionName2ViewFactory.class;
		case UsageNameEditPart.VISUAL_ID:
			return UsageNameViewFactory.class;
		case AppliedStereotypeUsageEditPart.VISUAL_ID:
			return UsageName2ViewFactory.class;
		case DependencyNameEditPart.VISUAL_ID:
			return DependencyNameViewFactory.class;
		case AppliedStereotypeDependencyEditPart.VISUAL_ID:
			return DependencyName2ViewFactory.class;
		case DependencyName3EditPart.VISUAL_ID:
			return DependencyName3ViewFactory.class;
		case AppliedStereotypeDependency3EditPart.VISUAL_ID:
			return DependencyName4ViewFactory.class;
		case ElementImportAliasEditPart.VISUAL_ID:
			return ElementImportAliasViewFactory.class;
		case AppliedStereotypeElementImportEditPart.VISUAL_ID:
			return ElementImportAlias2ViewFactory.class;
		case AppliedStereotypePackageImportEditPart.VISUAL_ID:
			return PackageImportVisibilityViewFactory.class;
		case WrappingLabelEditPart.VISUAL_ID:
			return WrappingLabelViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null && visualID != UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case CommentLinkDescriptorEditPart.VISUAL_ID:
			return CommentLinkDescriptorViewFactory.class;
		case AssociationClass2EditPart.VISUAL_ID:
			return AssociationClass2ViewFactory.class;
		case AssociationEditPart.VISUAL_ID:
			return AssociationViewFactory.class;
		case Association3EditPart.VISUAL_ID:
			return Association3ViewFactory.class;
		case GeneralizationEditPart.VISUAL_ID:
			return GeneralizationViewFactory.class;
		case InterfaceRealizationEditPart.VISUAL_ID:
			return InterfaceRealizationViewFactory.class;
		case SubstitutionEditPart.VISUAL_ID:
			return SubstitutionViewFactory.class;
		case RealizationEditPart.VISUAL_ID:
			return RealizationViewFactory.class;
		case AbstractionEditPart.VISUAL_ID:
			return AbstractionViewFactory.class;
		case UsageEditPart.VISUAL_ID:
			return UsageViewFactory.class;
		case DependencyEditPart.VISUAL_ID:
			return DependencyViewFactory.class;
		case Dependency3EditPart.VISUAL_ID:
			return Dependency3ViewFactory.class;
		case ElementImportEditPart.VISUAL_ID:
			return ElementImportViewFactory.class;
		case PackageImportEditPart.VISUAL_ID:
			return PackageImportViewFactory.class;
		case PackageMergeEditPart.VISUAL_ID:
			return PackageMergeViewFactory.class;
		case ProfileApplicationEditPart.VISUAL_ID:
			return ProfileApplicationViewFactory.class;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElementViewFactory.class;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElementViewFactory.class;
		case TemplateBindingEditPart.VISUAL_ID:
			return TemplateBindingViewFactory.class;
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
