package org.eclipse.papyrus.diagram.clazzBis.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
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
	public static List getSemanticChildren(View view) {
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_1005SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			return getSignal_1006SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			return getInterface_1007SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			return getModel_1008SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			return getPackage_1010SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_1011SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			return getDataType_1013SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponent_2012SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			return getSignal_2013SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			return getInterface_2014SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			return getModel_2015SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			return getPackage_2018SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			return getClass_2019SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			return getDataType_2025SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			return getAssociationClassAttributeCompartment_5001SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			return getInstanceSpecificationSlotCompartment_5002SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartmentEditPart.VISUAL_ID:
			return getComponentAttributeCompartment_5003SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartmentEditPart.VISUAL_ID:
			return getComponentOperationCompartment_5004SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getComponentNestedClassifierCompartment_5005SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			return getRedefinableTemplateSignatureTemplateParameterCompartment_5006SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartmentEditPart.VISUAL_ID:
			return getSignalAttributeCompartment_5007SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			return getInterfaceAttributeCompartment_5008SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID:
			return getInterfaceOperationCompartment_5009SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getInterfaceNestedClassifierCompartment_5010SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			return getModelPackageableElementCompartment_5011SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
			return getInstanceSpecificationSlotCompartment_5012SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartment2EditPart.VISUAL_ID:
			return getComponentAttributeCompartment_5013SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartment2EditPart.VISUAL_ID:
			return getComponentOperationCompartment_5014SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			return getComponentNestedClassifierCompartment_5015SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartment2EditPart.VISUAL_ID:
			return getSignalAttributeCompartment_5016SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			return getInterfaceAttributeCompartment_5017SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartment2EditPart.VISUAL_ID:
			return getInterfaceOperationCompartment_5018SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			return getInterfaceNestedClassifierCompartment_5019SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID:
			return getModelPackageableElementCompartment_5020SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			return getEnumerationEnumerationLiteralCompartment_5021SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_5022SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartmentEditPart.VISUAL_ID:
			return getClassAttributeCompartment_5023SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart.VISUAL_ID:
			return getClassOperationCompartment_5024SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getClassNestedClassifierCompartment_5025SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			return getDataTypeAttributeCompartment_5026SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartmentEditPart.VISUAL_ID:
			return getDataTypeOperationCompartment_5027SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			return getEnumerationEnumerationLiteralCompartment_5028SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_5029SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartment2EditPart.VISUAL_ID:
			return getClassAttributeCompartment_5030SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart.VISUAL_ID:
			return getClassOperationCompartment_5031SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			return getClassNestedClassifierCompartment_5032SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			return getDataTypeAttributeCompartment_5033SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartment2EditPart.VISUAL_ID:
			return getDataTypeOperationCompartment_5034SemanticChildren(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID:
			return getPackage_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponent_1005SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_1006SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_1007SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_1008SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1010SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_1011SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_1013SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2012SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_2013SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2014SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2015SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2018SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2019SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2025SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement.getOwnedTemplateSignature();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClassAttributeCompartment_5001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		AssociationClass modelElement = (AssociationClass) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecificationSlotCompartment_5002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		InstanceSpecification modelElement = (InstanceSpecification) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSlots().iterator(); it.hasNext();) {
			Slot childElement = (Slot) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentAttributeCompartment_5003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentOperationCompartment_5004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentNestedClassifierCompartment_5005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRedefinableTemplateSignatureTemplateParameterCompartment_5006SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getParameters().iterator(); it.hasNext();) {
			TemplateParameter childElement = (TemplateParameter) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignalAttributeCompartment_5007SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceAttributeCompartment_5008SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceOperationCompartment_5009SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceNestedClassifierCompartment_5010SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModelPackageableElementCompartment_5011SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecificationSlotCompartment_5012SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		InstanceSpecification modelElement = (InstanceSpecification) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSlots().iterator(); it.hasNext();) {
			Slot childElement = (Slot) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentAttributeCompartment_5013SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentOperationCompartment_5014SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentNestedClassifierCompartment_5015SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignalAttributeCompartment_5016SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceAttributeCompartment_5017SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceOperationCompartment_5018SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceNestedClassifierCompartment_5019SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModelPackageableElementCompartment_5020SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationEnumerationLiteralCompartment_5021SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartment_5022SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassAttributeCompartment_5023SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassOperationCompartment_5024SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedReceptions().iterator(); it.hasNext();) {
			Reception childElement = (Reception) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassNestedClassifierCompartment_5025SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataTypeAttributeCompartment_5026SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataTypeOperationCompartment_5027SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationEnumerationLiteralCompartment_5028SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartment_5029SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassAttributeCompartment_5030SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassOperationCompartment_5031SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedReceptions().iterator(); it.hasNext();) {
			Reception childElement = (Reception) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassNestedClassifierCompartment_5032SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataTypeAttributeCompartment_5033SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataTypeOperationCompartment_5034SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID:
			return getPackage_79ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_1001ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_1002ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_1003ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_1004ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_1005ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			return getSignal_1006ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			return getInterface_1007ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			return getModel_1008ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
			return getEnumeration_1009ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			return getPackage_1010ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_1011ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_1012ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			return getDataType_1013ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
			return getConstraint_1014ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			return getComment_1015ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
			return getProperty_2001ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
			return getSlot_2002ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_2003ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
			return getClass_2004ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_2005ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_2006ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
			return getProperty_2007ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
			return getProperty_2008ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
			return getOperation_2009ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
			return getClass_2010ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
			return getInstanceSpecification_2011ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponent_2012ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			return getSignal_2013ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			return getInterface_2014ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			return getModel_2015ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_2016ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_2017ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			return getPackage_2018ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			return getClass_2019ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
			return getReception_2020ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
			return getProperty_2021ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
			return getOperation_2022ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
			return getClass_2023ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
			return getPrimitiveType_2024ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			return getDataType_2025ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
			return getProperty_2026ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
			return getOperation_2027ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
			return getComment_2028ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
			return getConstraint_2029ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return getAssociationClass_3002ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_3003ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_3004ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_3005ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_3006ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_3007ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return getRealization_3008ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return getAbstraction_3009ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return getUsage_3010ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return getDependency_3011ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return getDependency_3012ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return getElementImport_3013ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return getPackageImport_3014ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_3015ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_3016ContainedLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return getTemplateBinding_3019ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_1001IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_1002IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_1003IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_1004IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_1005IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			return getSignal_1006IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			return getInterface_1007IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			return getModel_1008IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
			return getEnumeration_1009IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			return getPackage_1010IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_1011IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_1012IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			return getDataType_1013IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
			return getConstraint_1014IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			return getComment_1015IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
			return getProperty_2001IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
			return getSlot_2002IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_2003IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
			return getClass_2004IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_2005IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_2006IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
			return getProperty_2007IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
			return getProperty_2008IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
			return getOperation_2009IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
			return getClass_2010IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
			return getInstanceSpecification_2011IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponent_2012IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			return getSignal_2013IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			return getInterface_2014IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			return getModel_2015IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_2016IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_2017IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			return getPackage_2018IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			return getClass_2019IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
			return getReception_2020IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
			return getProperty_2021IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
			return getOperation_2022IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
			return getClass_2023IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
			return getPrimitiveType_2024IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			return getDataType_2025IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
			return getProperty_2026IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
			return getOperation_2027IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
			return getComment_2028IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
			return getConstraint_2029IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return getAssociationClass_3002IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_3003IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_3004IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_3005IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_3006IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_3007IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return getRealization_3008IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return getAbstraction_3009IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return getUsage_3010IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return getDependency_3011IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return getDependency_3012IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return getElementImport_3013IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return getPackageImport_3014IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_3015IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_3016IncomingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return getTemplateBinding_3019IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_1001OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
			return getAssociationClass_1002OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_1003OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_1004OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
			return getComponent_1005OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
			return getSignal_1006OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
			return getInterface_1007OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
			return getModel_1008OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
			return getEnumeration_1009OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
			return getPackage_1010OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_1011OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
			return getPrimitiveType_1012OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
			return getDataType_1013OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
			return getConstraint_1014OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			return getComment_1015OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID:
			return getProperty_2001OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID:
			return getSlot_2002OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_2003OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID:
			return getClass_2004OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_2005OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_2006OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID:
			return getProperty_2007OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID:
			return getProperty_2008OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID:
			return getOperation_2009OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID:
			return getClass_2010OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID:
			return getInstanceSpecification_2011OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID:
			return getComponent_2012OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID:
			return getSignal_2013OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID:
			return getInterface_2014OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID:
			return getModel_2015OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_2016OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_2017OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID:
			return getPackage_2018OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID:
			return getClass_2019OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID:
			return getReception_2020OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID:
			return getProperty_2021OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID:
			return getOperation_2022OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID:
			return getClass_2023OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID:
			return getPrimitiveType_2024OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID:
			return getDataType_2025OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID:
			return getProperty_2026OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID:
			return getOperation_2027OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID:
			return getComment_2028OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID:
			return getConstraint_2029OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID:
			return getAssociationClass_3002OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID:
			return getAssociation_3003OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID:
			return getAssociation_3004OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_3005OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_3006OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_3007OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID:
			return getRealization_3008OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID:
			return getAbstraction_3009OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID:
			return getUsage_3010OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID:
			return getDependency_3011OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID:
			return getDependency_3012OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID:
			return getElementImport_3013OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID:
			return getPackageImport_3014OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_3015OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_3016OutgoingLinks(view);
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID:
			return getTemplateBinding_3019OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_79ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_1002ContainedLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_1003ContainedLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_1004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponent_1005ContainedLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_1006ContainedLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_1007ContainedLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_1008ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_1009ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1010ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_1011ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_1012ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_1013ContainedLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1014ContainedLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1015ContainedLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2001ContainedLinks(View view) {
		Property modelElement = (Property) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSlot_2002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2003ContainedLinks(View view) {
		Operation modelElement = (Operation) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2004ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRedefinableTemplateSignature_2005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTemplateParameter_2006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2007ContainedLinks(View view) {
		Property modelElement = (Property) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2008ContainedLinks(View view) {
		Property modelElement = (Property) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2009ContainedLinks(View view) {
		Operation modelElement = (Operation) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2010ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_2011ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2012ContainedLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_2013ContainedLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2014ContainedLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2015ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2016ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_2017ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2018ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2019ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getReception_2020ContainedLinks(View view) {
		Reception modelElement = (Reception) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2021ContainedLinks(View view) {
		Property modelElement = (Property) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2022ContainedLinks(View view) {
		Operation modelElement = (Operation) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2023ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_2024ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2025ContainedLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2026ContainedLinks(View view) {
		Property modelElement = (Property) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2027ContainedLinks(View view) {
		Operation modelElement = (Operation) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2028ContainedLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2029ContainedLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_3002ContainedLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003ContainedLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3004ContainedLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceRealization_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSubstitution_3007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRealization_3008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_3009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUsage_3010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_3011ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_3012ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3013ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_3014ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_3015ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_3016ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTemplateBinding_3019ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_1001IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_1002IncomingLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_1003IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_1004IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_1005IncomingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_1006IncomingLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_1007IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_3006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_1008IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_3014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_3015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_1009IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1010IncomingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_3014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_3015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_1011IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_1012IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_1013IncomingLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1014IncomingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1015IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSlot_2002IncomingLinks(View view) {
		Slot modelElement = (Slot) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_2004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRedefinableTemplateSignature_2005IncomingLinks(View view) {
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTemplateParameter_2006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2007IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2008IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2009IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_2010IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_2011IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2012IncomingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_2013IncomingLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2014IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_3006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2015IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_3014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_3015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2016IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_2017IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2018IncomingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_3014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_3015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2019IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getReception_2020IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2021IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2022IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_2023IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_2024IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2025IncomingLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2026IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2027IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComment_2028IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2029IncomingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_3002IncomingLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3004IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_3002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_3005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_3007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_3005IncomingLinks(View view) {
		Generalization modelElement = (Generalization) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceRealization_3006IncomingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSubstitution_3007IncomingLinks(View view) {
		Substitution modelElement = (Substitution) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRealization_3008IncomingLinks(View view) {
		Realization modelElement = (Realization) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_3009IncomingLinks(View view) {
		Abstraction modelElement = (Abstraction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUsage_3010IncomingLinks(View view) {
		Usage modelElement = (Usage) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_3011IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_3012IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_3008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_3009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_3010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_3012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_3013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3013IncomingLinks(View view) {
		ElementImport modelElement = (ElementImport) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_3014IncomingLinks(View view) {
		PackageImport modelElement = (PackageImport) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_3015IncomingLinks(View view) {
		PackageMerge modelElement = (PackageMerge) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_3016IncomingLinks(View view) {
		ProfileApplication modelElement = (ProfileApplication) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTemplateBinding_3019IncomingLinks(View view) {
		TemplateBinding modelElement = (TemplateBinding) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_3019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_1001OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_1002OutgoingLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_1003OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_1004OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_1005OutgoingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_1006OutgoingLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_1007OutgoingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_1008OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_1009OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1010OutgoingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_1011OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_1012OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_1013OutgoingLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1014OutgoingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1015OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSlot_2002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_2004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRedefinableTemplateSignature_2005OutgoingLinks(View view) {
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTemplateParameter_2006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2007OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2008OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2009OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_2010OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_2011OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2012OutgoingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_2013OutgoingLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2014OutgoingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2015OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2016OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_2017OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2018OutgoingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_3015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_3016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2019OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getReception_2020OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2021OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2022OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_2023OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_2024OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2025OutgoingLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2026OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_2027OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComment_2028OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2029OutgoingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_3002OutgoingLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_3006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3004OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_3002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_3004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_3005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_3007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_3013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_3014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_3019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_3005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceRealization_3006OutgoingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSubstitution_3007OutgoingLinks(View view) {
		Substitution modelElement = (Substitution) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRealization_3008OutgoingLinks(View view) {
		Realization modelElement = (Realization) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_3009OutgoingLinks(View view) {
		Abstraction modelElement = (Abstraction) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUsage_3010OutgoingLinks(View view) {
		Usage modelElement = (Usage) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_3011OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_3012OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_3008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_3009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_3010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_3012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_3013OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_3014OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_3015OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_3016OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTemplateBinding_3019OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_AssociationClass_3002(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getEndTypes();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_3003(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getEndTypes();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_3004(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getEndTypes();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Generalization_3005(Classifier container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getGeneral();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_InterfaceRealization_3006(BehavioredClassifier container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getInterfaceRealizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Interface dst = link.getContract();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Substitution_3007(Classifier container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getSubstitutions().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getContract();
			Classifier src = link.getSubstitutingClassifier();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Realization_3008(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Realization) {
				continue;
			}
			Realization link = (Realization) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Abstraction_3009(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Usage_3010(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_3011(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_3012(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ElementImport_3013(Namespace container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getElementImports().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			PackageableElement dst = link.getImportedElement();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_PackageImport_3014(Namespace container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackageImports().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package dst = link.getImportedPackage();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_PackageMerge_3015(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackageMerges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package dst = link.getMergedPackage();
			Package src = link.getReceivingPackage();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageMerge_3015,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ProfileApplication_3016(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getProfileApplications().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ProfileApplication) {
				continue;
			}
			ProfileApplication link = (ProfileApplication) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Profile dst = link.getAppliedProfile();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ProfileApplication_3016,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_TemplateBinding_3019(TemplateableElement container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getTemplateBindings().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getTargets();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element) theTarget;
			TemplateableElement src = link.getBoundElement();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_AssociationClass_3002(Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_3003(Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_3004(Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Generalization_3005(Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Classifier) {
				continue;
			}
			Classifier container = (Classifier) link.eContainer();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_InterfaceRealization_3006(Interface target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInterfaceRealization_Contract() || false == setting.getEObject() instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof BehavioredClassifier) {
				continue;
			}
			BehavioredClassifier container = (BehavioredClassifier) link.eContainer();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, target, link,
					org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006, org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Substitution_3007(Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getSubstitution_Contract() || false == setting.getEObject() instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier src = link.getSubstitutingClassifier();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Realization_3008(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Realization) {
				continue;
			}
			Realization link = (Realization) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Abstraction_3009(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Usage_3010(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Usage) {
				continue;
			}
			Usage link = (Usage) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_3011(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_3012(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ElementImport_3013(PackageableElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElementImport_ImportedElement() || false == setting.getEObject() instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Namespace) {
				continue;
			}
			Namespace container = (Namespace) link.eContainer();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_PackageImport_3014(Package target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getPackageImport_ImportedPackage() || false == setting.getEObject() instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Namespace) {
				continue;
			}
			Namespace container = (Namespace) link.eContainer();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(container, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_PackageMerge_3015(Package target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getPackageMerge_MergedPackage() || false == setting.getEObject() instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package src = link.getReceivingPackage();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageMerge_3015,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(setting.getEObject(), target,
						org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017,
						org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(setting.getEObject(), target,
						org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018,
						org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_TemplateBinding_3019(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDirectedRelationship_Target() || false == setting.getEObject() instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding) setting.getEObject();
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			TemplateableElement src = link.getBoundElement();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, target, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_AssociationClass_3002(Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getEndTypes();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_3003(Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getEndTypes();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_3004(Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getEndTypes();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Substitution_3007(Classifier source) {
		Classifier container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Classifier) {
				container = (Classifier) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getSubstitutions().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getContract();
			Classifier src = link.getSubstitutingClassifier();
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Realization_3008(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Realization) {
				continue;
			}
			Realization link = (Realization) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Abstraction_3009(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Usage_3010(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_3011(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_3012(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_PackageMerge_3015(Package source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackageMerges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package dst = link.getMergedPackage();
			Package src = link.getReceivingPackage();
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageMerge_3015,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3017(Comment source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(source, destination,
					org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_3018(Constraint source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(source, destination,
					org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_TemplateBinding_3019(TemplateableElement source) {
		TemplateableElement container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof TemplateableElement) {
				container = (TemplateableElement) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getTemplateBindings().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding) linkObject;
			if (org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID != org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getTargets();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element) theTarget;
			TemplateableElement src = link.getBoundElement();
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor(src, dst, link, org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019,
					org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
		}
		return result;
	}

}
