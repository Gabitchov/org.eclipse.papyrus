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
package org.eclipse.papyrus.uml.diagram.clazz.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002SemanticChildren(view);
		case SignalEditPart.VISUAL_ID:
			return getSignal_2003SemanticChildren(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2004SemanticChildren(view);
		case ModelEditPartTN.VISUAL_ID:
			return getModel_2005SemanticChildren(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2007SemanticChildren(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2008SemanticChildren(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2010SemanticChildren(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3021SemanticChildren(view);
		case SignalEditPartCN.VISUAL_ID:
			return getSignal_3022SemanticChildren(view);
		case InterfaceEditPartCN.VISUAL_ID:
			return getInterface_3023SemanticChildren(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_3024SemanticChildren(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3009SemanticChildren(view);
		case ClassEditPartCN.VISUAL_ID:
			return getClass_3010SemanticChildren(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027SemanticChildren(view);
		case ClassAttributeCompartmentEditPartCN.VISUAL_ID:
			return getClassAttributeCompartment_7011SemanticChildren(view);
		case ClassOperationCompartmentEditPartCN.VISUAL_ID:
			return getClassOperationCompartment_7012SemanticChildren(view);
		case ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			return getClassNestedClassifierCompartment_7013SemanticChildren(view);
		case ComponentAttributeCompartmentEditPartCN.VISUAL_ID:
			return getComponentAttributeCompartment_7023SemanticChildren(view);
		case ComponentOperationCompartmentEditPartCN.VISUAL_ID:
			return getComponentOperationCompartment_7024SemanticChildren(view);
		case ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			return getComponentNestedClassifierCompartment_7025SemanticChildren(view);
		case SignalAttributeCompartmentEditPartCN.VISUAL_ID:
			return getSignalAttributeCompartment_7026SemanticChildren(view);
		case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
			return getInterfaceAttributeCompartment_7027SemanticChildren(view);
		case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
			return getInterfaceOperationCompartment_7028SemanticChildren(view);
		case InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID:
			return getInterfaceNestedClassifierCompartment_7029SemanticChildren(view);
		case PrimitiveTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			return getPrimitiveTypeAttributeCompartment_7041SemanticChildren(view);
		case PrimitiveTypeOperationCompartmentEditPartCN.VISUAL_ID:
			return getPrimitiveTypeOperationCompartment_7042SemanticChildren(view);
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			return getDataTypeAttributeCompartment_7032SemanticChildren(view);
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			return getDataTypeOperationCompartment_7033SemanticChildren(view);
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getModelPackageableElementCompartment_7030SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getPackagePackageableElementCompartment_7010SemanticChildren(view);
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			return getEnumerationEnumerationLiteralCompartment_7031SemanticChildren(view);
		case InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID:
			return getInstanceSpecificationSlotCompartment_7035SemanticChildren(view);
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			return getClassAttributeCompartment_7017SemanticChildren(view);
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			return getClassOperationCompartment_7018SemanticChildren(view);
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getClassNestedClassifierCompartment_7019SemanticChildren(view);
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			return getComponentAttributeCompartment_7002SemanticChildren(view);
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			return getComponentOperationCompartment_7003SemanticChildren(view);
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getComponentNestedClassifierCompartment_7004SemanticChildren(view);
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			return getInterfaceAttributeCompartment_7006SemanticChildren(view);
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			return getInterfaceOperationCompartment_7007SemanticChildren(view);
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getInterfaceNestedClassifierCompartment_7008SemanticChildren(view);
		case PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID:
			return getPrimitiveTypeAttributeCompartment_7039SemanticChildren(view);
		case PrimitiveTypeOperationCompartmentEditPart.VISUAL_ID:
			return getPrimitiveTypeOperationCompartment_7040SemanticChildren(view);
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			return getDataTypeAttributeCompartment_7020SemanticChildren(view);
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			return getDataTypeOperationCompartment_7021SemanticChildren(view);
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			return getAssociationClassAttributeCompartment_7034SemanticChildren(view);
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			return getInstanceSpecificationSlotCompartment_7001SemanticChildren(view);
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			return getSignalAttributeCompartment_7005SemanticChildren(view);
		case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
			return getModelPackageableElementCompartment_7009SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7016SemanticChildren(view);
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			return getEnumerationEnumerationLiteralCompartment_7015SemanticChildren(view);
		case AssociationClassOperationCompartmentEditPart.VISUAL_ID:
			return getAssociationClassOperationCompartment_7036SemanticChildren(view);
		case AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getAssociationClassNestedClassifierCompartment_7037SemanticChildren(view);
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			return getRedefinableTemplateSignatureTemplateParameterCompartment_7014SemanticChildren(view);
		case TemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			return getTemplateSignatureTemplateParameterCompartment_7038SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackage_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DependencyNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AssociationClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AssociationNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InstanceSpecificationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DurationObservationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TimeObservationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DefaultNamedElementEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ShapeNamedElementEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		Resource resource = modelElement.eResource();
		for(Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator.hasNext();) {
			EObject childElement = (EObject)semanticIterator.next();
			if(childElement == modelElement) {
				continue;
			}
			if(UMLVisualIDRegistry.getNodeVisualID(view, childElement) == ShortCutDiagramEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, ShortCutDiagramEditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_2002SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSignal_2003SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterface_2004SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getModel_2005SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == TemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackage_2007SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == TemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClass_2008SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataType_2010SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_3021SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSignal_3022SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterface_3023SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getModel_3024SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == TemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackage_3009SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
			if(visualID == TemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClass_3010SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataType_3027SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassAttributeCompartment_7011SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassOperationCompartment_7012SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedReceptions().iterator(); it.hasNext();) {
			Reception childElement = (Reception)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ReceptionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassNestedClassifierCompartment_7013SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == NestedClassForClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentAttributeCompartment_7023SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentOperationCompartment_7024SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedReceptions().iterator(); it.hasNext();) {
			Reception childElement = (Reception)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ReceptionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentNestedClassifierCompartment_7025SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == NestedClassForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSignalAttributeCompartment_7026SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Signal modelElement = (Signal)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForSignalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterfaceAttributeCompartment_7027SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForInterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterfaceOperationCompartment_7028SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForInterfaceEditpart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedReceptions().iterator(); it.hasNext();) {
			Reception childElement = (Reception)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ReceptionInInterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterfaceNestedClassifierCompartment_7029SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == NestedClassForInterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPrimitiveTypeAttributeCompartment_7041SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		PrimitiveType modelElement = (PrimitiveType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyforPrimitiveTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPrimitiveTypeOperationCompartment_7042SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		PrimitiveType modelElement = (PrimitiveType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForPrimitiveTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	
	

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataTypeAttributeCompartment_7032SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		DataType modelElement = (DataType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyforDataTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataTypeOperationCompartment_7033SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		DataType modelElement = (DataType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForDataTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getModelPackageableElementCompartment_7030SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Model modelElement = (Model)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InstanceSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackagePackageableElementCompartment_7010SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Package modelElement = (Package)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InstanceSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getEnumerationEnumerationLiteralCompartment_7031SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Enumeration modelElement = (Enumeration)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInstanceSpecificationSlotCompartment_7035SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		InstanceSpecification modelElement = (InstanceSpecification)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getSlots().iterator(); it.hasNext();) {
			Slot childElement = (Slot)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == SlotEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassAttributeCompartment_7017SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassOperationCompartment_7018SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedReceptions().iterator(); it.hasNext();) {
			Reception childElement = (Reception)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ReceptionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassNestedClassifierCompartment_7019SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == NestedClassForClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedInterfaceForClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentAttributeCompartment_7002SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentOperationCompartment_7003SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedReceptions().iterator(); it.hasNext();) {
			Reception childElement = (Reception)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ReceptionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentNestedClassifierCompartment_7004SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == NestedClassForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedInterfaceForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterfaceAttributeCompartment_7006SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForInterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterfaceOperationCompartment_7007SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForInterfaceEditpart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedReceptions().iterator(); it.hasNext();) {
			Reception childElement = (Reception)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ReceptionInInterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterfaceNestedClassifierCompartment_7008SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == NestedClassForInterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedInterfaceForInterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPrimitiveTypeAttributeCompartment_7039SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		PrimitiveType modelElement = (PrimitiveType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyforPrimitiveTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPrimitiveTypeOperationCompartment_7040SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		PrimitiveType modelElement = (PrimitiveType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForPrimitiveTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataTypeAttributeCompartment_7020SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		DataType modelElement = (DataType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyforDataTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDataTypeOperationCompartment_7021SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		DataType modelElement = (DataType)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForDataTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getAssociationClassAttributeCompartment_7034SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		AssociationClass modelElement = (AssociationClass)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInstanceSpecificationSlotCompartment_7001SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		InstanceSpecification modelElement = (InstanceSpecification)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getSlots().iterator(); it.hasNext();) {
			Slot childElement = (Slot)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == SlotEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSignalAttributeCompartment_7005SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Signal modelElement = (Signal)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PropertyForSignalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getModelPackageableElementCompartment_7009SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Model modelElement = (Model)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InstanceSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackagePackageableElementCompartment_7016SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Package modelElement = (Package)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InstanceSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ClassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InformationItemEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getEnumerationEnumerationLiteralCompartment_7015SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Enumeration modelElement = (Enumeration)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getAssociationClassOperationCompartment_7036SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		AssociationClass modelElement = (AssociationClass)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getAssociationClassNestedClassifierCompartment_7037SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		AssociationClass modelElement = (AssociationClass)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == NestedClassForComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getRedefinableTemplateSignatureTemplateParameterCompartment_7014SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getParameters().iterator(); it.hasNext();) {
			TemplateParameter childElement = (TemplateParameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ClassifierTemplateParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConnectableElementTemplateParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OperationTemplateParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TemplateParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getTemplateSignatureTemplateParameterCompartment_7038SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		TemplateSignature modelElement = (TemplateSignature)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getParameters().iterator(); it.hasNext();) {
			TemplateParameter childElement = (TemplateParameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ClassifierTemplateParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == OperationTemplateParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == TemplateParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Iterator<EObject> getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2014ContainedLinks(view);
		case AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_2013ContainedLinks(view);
		case AssociationNodeEditPart.VISUAL_ID:
			return getAssociation_2015ContainedLinks(view);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_2001ContainedLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002ContainedLinks(view);
		case SignalEditPart.VISUAL_ID:
			return getSignal_2003ContainedLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2004ContainedLinks(view);
		case ModelEditPartTN.VISUAL_ID:
			return getModel_2005ContainedLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2006ContainedLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2007ContainedLinks(view);
		case InformationItemEditPart.VISUAL_ID:
			return getInformationItem_2099ContainedLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2008ContainedLinks(view);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_2009ContainedLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2010ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2012ContainedLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2016ContainedLinks(view);
		case DurationObservationEditPart.VISUAL_ID:
			return getDurationObservation_2095ContainedLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_2096ContainedLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2097ContainedLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2098ContainedLinks(view);
		case PropertyForClassEditPart.VISUAL_ID:
			return getProperty_3012ContainedLinks(view);
		case PropertyForComponentEditPart.VISUAL_ID:
			return getProperty_3002ContainedLinks(view);
		case PropertyForSignalEditPart.VISUAL_ID:
			return getProperty_3005ContainedLinks(view);
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return getProperty_3006ContainedLinks(view);
		case PropertyforPrimitiveTypeEditPart.VISUAL_ID:
			return getProperty_3041ContainedLinks(view);
		case PropertyforDataTypeEditPart.VISUAL_ID:
			return getProperty_3018ContainedLinks(view);
		case NestedClassForClassEditPart.VISUAL_ID:
			return getClass_3014ContainedLinks(view);
		case NestedClassForComponentEditPart.VISUAL_ID:
			return getClass_3004ContainedLinks(view);
		case NestedClassForInterfaceEditPart.VISUAL_ID:
			return getClass_3008ContainedLinks(view);
		case OperationForClassEditPart.VISUAL_ID:
			return getOperation_3013ContainedLinks(view);
		case OperationForComponentEditPart.VISUAL_ID:
			return getOperation_3003ContainedLinks(view);
		case OperationForInterfaceEditpart.VISUAL_ID:
			return getOperation_3007ContainedLinks(view);
		case OperationForPrimitiveTypeEditPart.VISUAL_ID:
			return getOperation_3042ContainedLinks(view);
		case OperationForDataTypeEditPart.VISUAL_ID:
			return getOperation_3019ContainedLinks(view);
		case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
			return getConnectableElementTemplateParameter_3034ContainedLinks(view);
		case OperationTemplateParameterEditPart.VISUAL_ID:
			return getOperationTemplateParameter_3035ContainedLinks(view);
		case ClassifierTemplateParameterEditPart.VISUAL_ID:
			return getClassifierTemplateParameter_3031ContainedLinks(view);
		case TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_3016ContainedLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017ContainedLinks(view);
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011ContainedLinks(view);
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return getReception_3039ContainedLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3030ContainedLinks(view);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_3015ContainedLinks(view);
		case TemplateSignatureEditPart.VISUAL_ID:
			return getTemplateSignature_3033ContainedLinks(view);
		case InstanceSpecificationEditPartCN.VISUAL_ID:
			return getInstanceSpecification_3020ContainedLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3021ContainedLinks(view);
		case SignalEditPartCN.VISUAL_ID:
			return getSignal_3022ContainedLinks(view);
		case InterfaceEditPartCN.VISUAL_ID:
			return getInterface_3023ContainedLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_3024ContainedLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3025ContainedLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3009ContainedLinks(view);
		case InformationItemEditPartCN.VISUAL_ID:
			return getInformationItem_3040ContainedLinks(view);
		case ClassEditPartCN.VISUAL_ID:
			return getClass_3010ContainedLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3026ContainedLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027ContainedLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3028ContainedLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3029ContainedLinks(view);
		case NestedInterfaceForClassEditPart.VISUAL_ID:
			return getInterface_3036ContainedLinks(view);
		case NestedInterfaceForComponentEditPart.VISUAL_ID:
			return getInterface_3037ContainedLinks(view);
		case NestedInterfaceForInterfaceEditPart.VISUAL_ID:
			return getInterface_3038ContainedLinks(view);
		case AssociationClassLinkEditPart.VISUAL_ID:
			return getAssociationClass_4017ContainedLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4001ContainedLinks(view);
		case AssociationBranchEditPart.VISUAL_ID:
			return getAssociation_4019ContainedLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4002ContainedLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4003ContainedLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4004ContainedLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4005ContainedLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4006ContainedLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4007ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4008ContainedLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4018ContainedLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_4009ContainedLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_4010ContainedLinks(view);
		case PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_4011ContainedLinks(view);
		case ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_4012ContainedLinks(view);
		case TemplateBindingEditPart.VISUAL_ID:
			return getTemplateBinding_4015ContainedLinks(view);
		case GeneralizationSetEditPart.VISUAL_ID:
			return getGeneralizationSet_4020ContainedLinks(view);
		case InstanceSpecificationLinkEditPart.VISUAL_ID:
			return getInstanceSpecification_4021ContainedLinks(view);
		case InformationFlowEditPart.VISUAL_ID:
			return getInformationFlow_4026ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2014IncomingLinks(view);
		case AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_2013IncomingLinks(view);
		case AssociationNodeEditPart.VISUAL_ID:
			return getAssociation_2015IncomingLinks(view);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_2001IncomingLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002IncomingLinks(view);
		case SignalEditPart.VISUAL_ID:
			return getSignal_2003IncomingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2004IncomingLinks(view);
		case ModelEditPartTN.VISUAL_ID:
			return getModel_2005IncomingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2006IncomingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2007IncomingLinks(view);
		case InformationItemEditPart.VISUAL_ID:
			return getInformationItem_2099IncomingLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2008IncomingLinks(view);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_2009IncomingLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2010IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2012IncomingLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2016IncomingLinks(view);
		case DurationObservationEditPart.VISUAL_ID:
			return getDurationObservation_2095IncomingLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_2096IncomingLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2097IncomingLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2098IncomingLinks(view);
		case PropertyForClassEditPart.VISUAL_ID:
			return getProperty_3012IncomingLinks(view);
		case PropertyForComponentEditPart.VISUAL_ID:
			return getProperty_3002IncomingLinks(view);
		case PropertyForSignalEditPart.VISUAL_ID:
			return getProperty_3005IncomingLinks(view);
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return getProperty_3006IncomingLinks(view);
		case PropertyforPrimitiveTypeEditPart.VISUAL_ID:
			return getProperty_3041IncomingLinks(view);
		case PropertyforDataTypeEditPart.VISUAL_ID:
			return getProperty_3018IncomingLinks(view);
		case NestedClassForClassEditPart.VISUAL_ID:
			return getClass_3014IncomingLinks(view);
		case NestedClassForComponentEditPart.VISUAL_ID:
			return getClass_3004IncomingLinks(view);
		case NestedClassForInterfaceEditPart.VISUAL_ID:
			return getClass_3008IncomingLinks(view);
		case OperationForClassEditPart.VISUAL_ID:
			return getOperation_3013IncomingLinks(view);
		case OperationForComponentEditPart.VISUAL_ID:
			return getOperation_3003IncomingLinks(view);
		case OperationForInterfaceEditpart.VISUAL_ID:
			return getOperation_3007IncomingLinks(view);
		case OperationForPrimitiveTypeEditPart.VISUAL_ID:
			return getOperation_3042IncomingLinks(view);
		case OperationForDataTypeEditPart.VISUAL_ID:
			return getOperation_3019IncomingLinks(view);
		case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
			return getConnectableElementTemplateParameter_3034IncomingLinks(view);
		case OperationTemplateParameterEditPart.VISUAL_ID:
			return getOperationTemplateParameter_3035IncomingLinks(view);
		case ClassifierTemplateParameterEditPart.VISUAL_ID:
			return getClassifierTemplateParameter_3031IncomingLinks(view);
		case TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_3016IncomingLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017IncomingLinks(view);
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011IncomingLinks(view);
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return getReception_3039IncomingLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3030IncomingLinks(view);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_3015IncomingLinks(view);
		case TemplateSignatureEditPart.VISUAL_ID:
			return getTemplateSignature_3033IncomingLinks(view);
		case InstanceSpecificationEditPartCN.VISUAL_ID:
			return getInstanceSpecification_3020IncomingLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3021IncomingLinks(view);
		case SignalEditPartCN.VISUAL_ID:
			return getSignal_3022IncomingLinks(view);
		case InterfaceEditPartCN.VISUAL_ID:
			return getInterface_3023IncomingLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_3024IncomingLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3025IncomingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3009IncomingLinks(view);
		case InformationItemEditPartCN.VISUAL_ID:
			return getInformationItem_3040IncomingLinks(view);
		case ClassEditPartCN.VISUAL_ID:
			return getClass_3010IncomingLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3026IncomingLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027IncomingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3028IncomingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3029IncomingLinks(view);
		case NestedInterfaceForClassEditPart.VISUAL_ID:
			return getInterface_3036IncomingLinks(view);
		case NestedInterfaceForComponentEditPart.VISUAL_ID:
			return getInterface_3037IncomingLinks(view);
		case NestedInterfaceForInterfaceEditPart.VISUAL_ID:
			return getInterface_3038IncomingLinks(view);
		case AssociationClassLinkEditPart.VISUAL_ID:
			return getAssociationClass_4017IncomingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4001IncomingLinks(view);
		case AssociationBranchEditPart.VISUAL_ID:
			return getAssociation_4019IncomingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4002IncomingLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4003IncomingLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4004IncomingLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4005IncomingLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4006IncomingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4007IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4008IncomingLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4018IncomingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_4009IncomingLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_4010IncomingLinks(view);
		case PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_4011IncomingLinks(view);
		case ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_4012IncomingLinks(view);
		case TemplateBindingEditPart.VISUAL_ID:
			return getTemplateBinding_4015IncomingLinks(view);
		case GeneralizationSetEditPart.VISUAL_ID:
			return getGeneralizationSet_4020IncomingLinks(view);
		case InstanceSpecificationLinkEditPart.VISUAL_ID:
			return getInstanceSpecification_4021IncomingLinks(view);
		case InformationFlowEditPart.VISUAL_ID:
			return getInformationFlow_4026IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2014OutgoingLinks(view);
		case AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_2013OutgoingLinks(view);
		case AssociationNodeEditPart.VISUAL_ID:
			return getAssociation_2015OutgoingLinks(view);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_2001OutgoingLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002OutgoingLinks(view);
		case SignalEditPart.VISUAL_ID:
			return getSignal_2003OutgoingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2004OutgoingLinks(view);
		case ModelEditPartTN.VISUAL_ID:
			return getModel_2005OutgoingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2006OutgoingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2007OutgoingLinks(view);
		case InformationItemEditPart.VISUAL_ID:
			return getInformationItem_2099OutgoingLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2008OutgoingLinks(view);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_2009OutgoingLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2010OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2011OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2012OutgoingLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2016OutgoingLinks(view);
		case DurationObservationEditPart.VISUAL_ID:
			return getDurationObservation_2095OutgoingLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_2096OutgoingLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2097OutgoingLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2098OutgoingLinks(view);
		case PropertyForClassEditPart.VISUAL_ID:
			return getProperty_3012OutgoingLinks(view);
		case PropertyForComponentEditPart.VISUAL_ID:
			return getProperty_3002OutgoingLinks(view);
		case PropertyForSignalEditPart.VISUAL_ID:
			return getProperty_3005OutgoingLinks(view);
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return getProperty_3006OutgoingLinks(view);
		case PropertyforPrimitiveTypeEditPart.VISUAL_ID:
			return getProperty_3041OutgoingLinks(view);
		case PropertyforDataTypeEditPart.VISUAL_ID:
			return getProperty_3018OutgoingLinks(view);
		case NestedClassForClassEditPart.VISUAL_ID:
			return getClass_3014OutgoingLinks(view);
		case NestedClassForComponentEditPart.VISUAL_ID:
			return getClass_3004OutgoingLinks(view);
		case NestedClassForInterfaceEditPart.VISUAL_ID:
			return getClass_3008OutgoingLinks(view);
		case OperationForClassEditPart.VISUAL_ID:
			return getOperation_3013OutgoingLinks(view);
		case OperationForComponentEditPart.VISUAL_ID:
			return getOperation_3003OutgoingLinks(view);
		case OperationForInterfaceEditpart.VISUAL_ID:
			return getOperation_3007OutgoingLinks(view);
		case OperationForPrimitiveTypeEditPart.VISUAL_ID:
			return getOperation_3042OutgoingLinks(view);
		case OperationForDataTypeEditPart.VISUAL_ID:
			return getOperation_3019OutgoingLinks(view);
		case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
			return getConnectableElementTemplateParameter_3034OutgoingLinks(view);
		case OperationTemplateParameterEditPart.VISUAL_ID:
			return getOperationTemplateParameter_3035OutgoingLinks(view);
		case ClassifierTemplateParameterEditPart.VISUAL_ID:
			return getClassifierTemplateParameter_3031OutgoingLinks(view);
		case TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_3016OutgoingLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017OutgoingLinks(view);
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011OutgoingLinks(view);
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return getReception_3039OutgoingLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3030OutgoingLinks(view);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_3015OutgoingLinks(view);
		case TemplateSignatureEditPart.VISUAL_ID:
			return getTemplateSignature_3033OutgoingLinks(view);
		case InstanceSpecificationEditPartCN.VISUAL_ID:
			return getInstanceSpecification_3020OutgoingLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3021OutgoingLinks(view);
		case SignalEditPartCN.VISUAL_ID:
			return getSignal_3022OutgoingLinks(view);
		case InterfaceEditPartCN.VISUAL_ID:
			return getInterface_3023OutgoingLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_3024OutgoingLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3025OutgoingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3009OutgoingLinks(view);
		case InformationItemEditPartCN.VISUAL_ID:
			return getInformationItem_3040OutgoingLinks(view);
		case ClassEditPartCN.VISUAL_ID:
			return getClass_3010OutgoingLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3026OutgoingLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027OutgoingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3028OutgoingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_3029OutgoingLinks(view);
		case NestedInterfaceForClassEditPart.VISUAL_ID:
			return getInterface_3036OutgoingLinks(view);
		case NestedInterfaceForComponentEditPart.VISUAL_ID:
			return getInterface_3037OutgoingLinks(view);
		case NestedInterfaceForInterfaceEditPart.VISUAL_ID:
			return getInterface_3038OutgoingLinks(view);
		case AssociationClassLinkEditPart.VISUAL_ID:
			return getAssociationClass_4017OutgoingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4001OutgoingLinks(view);
		case AssociationBranchEditPart.VISUAL_ID:
			return getAssociation_4019OutgoingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4002OutgoingLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4003OutgoingLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4004OutgoingLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4005OutgoingLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4006OutgoingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4007OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4008OutgoingLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4018OutgoingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_4009OutgoingLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_4010OutgoingLinks(view);
		case PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_4011OutgoingLinks(view);
		case ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_4012OutgoingLinks(view);
		case TemplateBindingEditPart.VISUAL_ID:
			return getTemplateBinding_4015OutgoingLinks(view);
		case GeneralizationSetEditPart.VISUAL_ID:
			return getGeneralizationSet_4020OutgoingLinks(view);
		case InstanceSpecificationLinkEditPart.VISUAL_ID:
			return getInstanceSpecification_4021OutgoingLinks(view);
		case InformationFlowEditPart.VISUAL_ID:
			return getInformationFlow_4026OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_GeneralizationSet_4020(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InstanceSpecification_4021(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_2014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociationClass_2013ContainedLinks(View view) {
		AssociationClass modelElement = (AssociationClass)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_2015ContainedLinks(View view) {
		Association modelElement = (Association)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_2003ContainedLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2004ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_2005ContainedLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_GeneralizationSet_4020(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InstanceSpecification_4021(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_2006ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_2007ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_GeneralizationSet_4020(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InstanceSpecification_4021(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_2099ContainedLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_2008ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_2009ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_2010ContainedLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2011ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2012ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDiagram_2016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationObservation_2095ContainedLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeObservation_2096ContainedLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2097ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2098ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3012ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3041ContainedLinks(View view) {
		return Collections.emptyList();
	}

	

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3018ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3014ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3004ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3008ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3013ContainedLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3003ContainedLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3007ContainedLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	
	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3042ContainedLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3019ContainedLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnectableElementTemplateParameter_3034ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperationTemplateParameter_3035ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClassifierTemplateParameter_3031ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateParameter_3016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumerationLiteral_3017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3011ContainedLinks(View view) {
		Reception modelElement = (Reception)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3039ContainedLinks(View view) {
		Reception modelElement = (Reception)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSlot_3030ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRedefinableTemplateSignature_3015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateSignature_3033ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_3020ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3021ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_3022ContainedLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3023ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_3024ContainedLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_GeneralizationSet_4020(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InstanceSpecification_4021(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3025ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3009ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_GeneralizationSet_4020(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InstanceSpecification_4021(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_3040ContainedLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3010ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3026ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3027ContainedLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3028ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3029ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3036ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3037ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3038ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociationClass_4017ContainedLinks(View view) {
		AssociationClass modelElement = (AssociationClass)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4001ContainedLinks(View view) {
		Association modelElement = (Association)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4019ContainedLinks(View view) {
		Association modelElement = (Association)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4018ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getElementImport_4009ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageImport_4010ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageMerge_4011ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProfileApplication_4012ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateBinding_4015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralizationSet_4020ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_4021ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationFlow_4026ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_2014IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociationClass_2013IncomingLinks(View view) {
		AssociationClass modelElement = (AssociationClass)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_2015IncomingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_2001IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_2003IncomingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2004IncomingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_2005IncomingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_2006IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_2007IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_2099IncomingLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_2008IncomingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_2009IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_2010IncomingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2011IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2012IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDiagram_2016IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationObservation_2095IncomingLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeObservation_2096IncomingLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2097IncomingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2098IncomingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3012IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3005IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3006IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3041IncomingLinks(View view) {
		return Collections.emptyList();
	}

	

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3018IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3014IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3008IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3013IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3003IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3042IncomingLinks(View view) {
		return Collections.emptyList();
	}

	

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3019IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnectableElementTemplateParameter_3034IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperationTemplateParameter_3035IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClassifierTemplateParameter_3031IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateParameter_3016IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumerationLiteral_3017IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3011IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3039IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSlot_3030IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRedefinableTemplateSignature_3015IncomingLinks(View view) {
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateSignature_3033IncomingLinks(View view) {
		TemplateSignature modelElement = (TemplateSignature)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_3020IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3021IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_3022IncomingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3023IncomingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_3024IncomingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3025IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3009IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_3040IncomingLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3010IncomingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3026IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3027IncomingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3028IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3029IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3036IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3037IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3038IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociationClass_4017IncomingLinks(View view) {
		AssociationClass modelElement = (AssociationClass)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4001IncomingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4019IncomingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4002IncomingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_GeneralizationSet_4020(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4003IncomingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4004IncomingLinks(View view) {
		Substitution modelElement = (Substitution)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4005IncomingLinks(View view) {
		Realization modelElement = (Realization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4006IncomingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4007IncomingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4008IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4018IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getElementImport_4009IncomingLinks(View view) {
		ElementImport modelElement = (ElementImport)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageImport_4010IncomingLinks(View view) {
		PackageImport modelElement = (PackageImport)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageMerge_4011IncomingLinks(View view) {
		PackageMerge modelElement = (PackageMerge)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProfileApplication_4012IncomingLinks(View view) {
		ProfileApplication modelElement = (ProfileApplication)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateBinding_4015IncomingLinks(View view) {
		TemplateBinding modelElement = (TemplateBinding)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralizationSet_4020IncomingLinks(View view) {
		GeneralizationSet modelElement = (GeneralizationSet)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_4021IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationFlow_4026IncomingLinks(View view) {
		InformationFlow modelElement = (InformationFlow)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InformationFlow_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_2014OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociationClass_2013OutgoingLinks(View view) {
		AssociationClass modelElement = (AssociationClass)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_2015OutgoingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_2001OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_2003OutgoingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2004OutgoingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_2005OutgoingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_2006OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_2007OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_2099OutgoingLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_2008OutgoingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_2009OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_2010OutgoingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2011OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2012OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDiagram_2016OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDurationObservation_2095OutgoingLinks(View view) {
		DurationObservation modelElement = (DurationObservation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4025(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTimeObservation_2096OutgoingLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4024(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2097OutgoingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2098OutgoingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3012OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3006OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3041OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_3018OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3014OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3013OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3042OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_3019OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConnectableElementTemplateParameter_3034OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperationTemplateParameter_3035OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClassifierTemplateParameter_3031OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateParameter_3016OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumerationLiteral_3017OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3011OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_3039OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSlot_3030OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRedefinableTemplateSignature_3015OutgoingLinks(View view) {
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateSignature_3033OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_3020OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3021OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSignal_3022OutgoingLinks(View view) {
		Signal modelElement = (Signal)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3023OutgoingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_3024OutgoingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getEnumeration_3025OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3009OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationItem_3040OutgoingLinks(View view) {
		InformationItem modelElement = (InformationItem)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClass_3010OutgoingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPrimitiveType_3026OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDataType_3027OutgoingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3028OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3029OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3036OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3037OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3038OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociationClass_4017OutgoingLinks(View view) {
		AssociationClass modelElement = (AssociationClass)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4001OutgoingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4019OutgoingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4002OutgoingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_GeneralizationSet_4020(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4003OutgoingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4004OutgoingLinks(View view) {
		Substitution modelElement = (Substitution)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4005OutgoingLinks(View view) {
		Realization modelElement = (Realization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4006OutgoingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4007OutgoingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4008OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4018OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getElementImport_4009OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageImport_4010OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageMerge_4011OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProfileApplication_4012OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getTemplateBinding_4015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralizationSet_4020OutgoingLinks(View view) {
		GeneralizationSet modelElement = (GeneralizationSet)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInstanceSpecification_4021OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInformationFlow_4026OutgoingLinks(View view) {
		InformationFlow modelElement = (InformationFlow)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InformationFlow_4026(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_AssociationClass_4017(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass)linkObject;
			if(AssociationClassLinkEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.AssociationClass_4017, AssociationClassLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Association_4001(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4001, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Association_4019(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4019, AssociationBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Generalization_4002(Classifier container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)linkObject;
			if(GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getGeneral();
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.Generalization_4002, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InterfaceRealization_4003(BehavioredClassifier container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getInterfaceRealizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)linkObject;
			if(InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Interface dst = link.getContract();
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.InterfaceRealization_4003, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Substitution_4004(Classifier container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getSubstitutions().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)linkObject;
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getContract();
			Classifier src = link.getSubstitutingClassifier();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Substitution_4004, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Realization_4005(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Realization) {
				continue;
			}
			Realization link = (Realization)linkObject;
			if(RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Realization_4005, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Abstraction_4006(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction)linkObject;
			if(AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4006, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Usage_4007(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage)linkObject;
			if(UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4007, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4008(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4008, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4018(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4018, DependencyBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_ElementImport_4009(Namespace container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getElementImports().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport)linkObject;
			if(ElementImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			PackageableElement dst = link.getImportedElement();
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.ElementImport_4009, ElementImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_PackageImport_4010(Namespace container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackageImports().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport)linkObject;
			if(PackageImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package dst = link.getImportedPackage();
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.PackageImport_4010, PackageImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_PackageMerge_4011(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackageMerges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge)linkObject;
			if(PackageMergeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package dst = link.getMergedPackage();
			Package src = link.getReceivingPackage();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.PackageMerge_4011, PackageMergeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_ProfileApplication_4012(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getProfileApplications().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ProfileApplication) {
				continue;
			}
			ProfileApplication link = (ProfileApplication)linkObject;
			if(ProfileApplicationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Profile dst = link.getAppliedProfile();
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.ProfileApplication_4012, ProfileApplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_TemplateBinding_4015(TemplateableElement container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getTemplateBindings().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding)linkObject;
			if(TemplateBindingEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			TemplateableElement dst = link.getBoundElement();
			TemplateableElement src = link.getBoundElement();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.TemplateBinding_4015, TemplateBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_GeneralizationSet_4020(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof GeneralizationSet) {
				continue;
			}
			GeneralizationSet link = (GeneralizationSet)linkObject;
			if(GeneralizationSetEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getGeneralizations();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Generalization) {
				continue;
			}
			Generalization dst = (Generalization)theTarget;
			List sources = link.getGeneralizations();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Generalization) {
				continue;
			}
			Generalization src = (Generalization)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.GeneralizationSet_4020, GeneralizationSetEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InstanceSpecification_4021(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InstanceSpecification) {
				continue;
			}
			InstanceSpecification link = (InstanceSpecification)linkObject;
			if(InstanceSpecificationLinkEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getSlots();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Slot) {
				continue;
			}
			Slot dst = (Slot)theTarget;
			List sources = link.getSlots();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Slot) {
				continue;
			}
			Slot src = (Slot)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InstanceSpecification_4021, InstanceSpecificationLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InformationFlow_4026(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InformationFlow) {
				continue;
			}
			InformationFlow link = (InformationFlow)linkObject;
			if(InformationFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getInformationTargets();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getInformationSources();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InformationFlow_4026, InformationFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_AssociationClass_4017(Type target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass)setting.getEObject();
			if(AssociationClassLinkEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.AssociationClass_4017, AssociationClassLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4001(Type target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association)setting.getEObject();
			if(AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Association_4001, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4019(Type target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association)setting.getEObject();
			if(AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Association_4019, AssociationBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Generalization_4002(Classifier target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)setting.getEObject();
			if(GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if(false == link.eContainer() instanceof Classifier) {
				continue;
			}
			Classifier container = (Classifier)link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.Generalization_4002, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_InterfaceRealization_4003(Interface target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInterfaceRealization_Contract() || false == setting.getEObject() instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)setting.getEObject();
			if(InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if(false == link.eContainer() instanceof BehavioredClassifier) {
				continue;
			}
			BehavioredClassifier container = (BehavioredClassifier)link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.InterfaceRealization_4003, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Substitution_4004(Classifier target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getSubstitution_Contract() || false == setting.getEObject() instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)setting.getEObject();
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier src = link.getSubstitutingClassifier();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Substitution_4004, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Realization_4005(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Realization) {
				continue;
			}
			Realization link = (Realization)setting.getEObject();
			if(RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Realization_4005, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Abstraction_4006(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction)setting.getEObject();
			if(AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Abstraction_4006, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Usage_4007(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Usage) {
				continue;
			}
			Usage link = (Usage)setting.getEObject();
			if(UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Usage_4007, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4008(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)setting.getEObject();
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4008, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4018(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)setting.getEObject();
			if(DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4018, DependencyBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_ElementImport_4009(PackageableElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElementImport_ImportedElement() || false == setting.getEObject() instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport)setting.getEObject();
			if(ElementImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if(false == link.eContainer() instanceof Namespace) {
				continue;
			}
			Namespace container = (Namespace)link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.ElementImport_4009, ElementImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_PackageImport_4010(Package target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getPackageImport_ImportedPackage() || false == setting.getEObject() instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport)setting.getEObject();
			if(PackageImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if(false == link.eContainer() instanceof Namespace) {
				continue;
			}
			Namespace container = (Namespace)link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.PackageImport_4010, PackageImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_PackageMerge_4011(Package target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getPackageMerge_MergedPackage() || false == setting.getEObject() instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge)setting.getEObject();
			if(PackageMergeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package src = link.getReceivingPackage();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.PackageMerge_4011, PackageMergeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4013, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4014, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_TemplateBinding_4015(TemplateableElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getTemplateBinding_BoundElement() || false == setting.getEObject() instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding)setting.getEObject();
			if(TemplateBindingEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			TemplateableElement src = link.getBoundElement();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.TemplateBinding_4015, TemplateBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_GeneralizationSet_4020(Generalization target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralizationSet_Generalization() || false == setting.getEObject() instanceof GeneralizationSet) {
				continue;
			}
			GeneralizationSet link = (GeneralizationSet)setting.getEObject();
			if(GeneralizationSetEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getGeneralizations();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Generalization) {
				continue;
			}
			Generalization src = (Generalization)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.GeneralizationSet_4020, GeneralizationSetEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_TimeObservation_Event_4024(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getTimeObservation_Event()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.TimeObservationEvent_4024, ConnectorTimeObservationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_DurationObservation_Event_4025(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getDurationObservation_Event()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.DurationObservationEvent_4025, ConnectorDurationObservationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_InformationFlow_4026(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInformationFlow_InformationTarget() || false == setting.getEObject() instanceof InformationFlow) {
				continue;
			}
			InformationFlow link = (InformationFlow)setting.getEObject();
			if(InformationFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getInformationSources();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.InformationFlow_4026, InformationFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_AssociationClass_4017(Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass)linkObject;
			if(AssociationClassLinkEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.AssociationClass_4017, AssociationClassLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4001(Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4001, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4019(Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4019, AssociationBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Substitution_4004(Classifier source) {
		Classifier container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Classifier) {
				container = (Classifier)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getSubstitutions().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)linkObject;
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getContract();
			Classifier src = link.getSubstitutingClassifier();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Substitution_4004, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Realization_4005(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Realization) {
				continue;
			}
			Realization link = (Realization)linkObject;
			if(RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Realization_4005, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Abstraction_4006(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction)linkObject;
			if(AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4006, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Usage_4007(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage)linkObject;
			if(UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4007, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4008(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4008, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4018(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4018, DependencyBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_PackageMerge_4011(Package source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackageMerges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge)linkObject;
			if(PackageMergeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package dst = link.getMergedPackage();
			Package src = link.getReceivingPackage();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.PackageMerge_4011, PackageMergeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(Comment source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4013, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(Constraint source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4014, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_TemplateBinding_4015(TemplateableElement source) {
		TemplateableElement container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof TemplateableElement) {
				container = (TemplateableElement)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getTemplateBindings().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding)linkObject;
			if(TemplateBindingEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			TemplateableElement dst = link.getBoundElement();
			TemplateableElement src = link.getBoundElement();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.TemplateBinding_4015, TemplateBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_GeneralizationSet_4020(Generalization source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof GeneralizationSet) {
				continue;
			}
			GeneralizationSet link = (GeneralizationSet)linkObject;
			if(GeneralizationSetEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			//Papyrus GenCode 
			List targets = link.getGeneralizations();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Generalization) {
				continue;
			}
			Generalization dst = (Generalization)theTarget;
			List sources = link.getGeneralizations();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof Generalization) {
				continue;
			}
			Generalization src = (Generalization)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.GeneralizationSet_4020, GeneralizationSetEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_TimeObservation_Event_4024(TimeObservation source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		NamedElement destination = source.getEvent();
		if(destination == null) {
			return result;
		}
		result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.TimeObservationEvent_4024, ConnectorTimeObservationEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_DurationObservation_Event_4025(DurationObservation source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getEvents().iterator(); destinations.hasNext();) {
			NamedElement destination = (NamedElement)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.DurationObservationEvent_4025, ConnectorDurationObservationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_InformationFlow_4026(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InformationFlow) {
				continue;
			}
			InformationFlow link = (InformationFlow)linkObject;
			if(InformationFlowEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getInformationTargets();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getInformationSources();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InformationFlow_4026, InformationFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {

		/**
		 * @generated
		 */
		public List<UMLNodeDescriptor> getSemanticChildren(View view) {
			return UMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getContainedLinks(View view) {
			return UMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getIncomingLinks(View view) {
			return UMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		public List<UMLLinkDescriptor> getOutgoingLinks(View view) {
			return UMLDiagramUpdater.getOutgoingLinks(view);
		}
	};
}
