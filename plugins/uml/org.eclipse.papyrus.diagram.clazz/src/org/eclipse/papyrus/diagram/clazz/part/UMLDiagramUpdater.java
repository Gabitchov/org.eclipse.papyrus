package org.eclipse.papyrus.diagram.clazz.part;

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
import org.eclipse.papyrus.diagram.clazz.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClass2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassAttributeCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassNestedClassifierCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassOperationCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentAttributeCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentNestedClassifierCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentOperationCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeAttributeCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeOperationCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceAttributeCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceOperationCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Operation2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Operation3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Operation4EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.OperationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ProfileApplicationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property4EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ReceptionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalAttributeCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateBindingEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateParameterEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
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
		switch (UMLVisualIDRegistry.getVisualID(view)) {
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
		case AssociationClassAttributeCompartmentEditPart.VISUAL_ID:
			return getAssociationClassAttributeCompartment_7034SemanticChildren(view);
		case InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID:
			return getInstanceSpecificationSlotCompartment_7001SemanticChildren(view);
		case ComponentAttributeCompartmentEditPart.VISUAL_ID:
			return getComponentAttributeCompartment_7002SemanticChildren(view);
		case ComponentOperationCompartmentEditPart.VISUAL_ID:
			return getComponentOperationCompartment_7003SemanticChildren(view);
		case ComponentNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getComponentNestedClassifierCompartment_7004SemanticChildren(view);
		case RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID:
			return getRedefinableTemplateSignatureTemplateParameterCompartment_7014SemanticChildren(view);
		case SignalAttributeCompartmentEditPart.VISUAL_ID:
			return getSignalAttributeCompartment_7005SemanticChildren(view);
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			return getInterfaceAttributeCompartment_7006SemanticChildren(view);
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			return getInterfaceOperationCompartment_7007SemanticChildren(view);
		case InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getInterfaceNestedClassifierCompartment_7008SemanticChildren(view);
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			return getModelPackageableElementCompartment_7009SemanticChildren(view);
		case InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID:
			return getInstanceSpecificationSlotCompartment_7022SemanticChildren(view);
		case ComponentAttributeCompartment2EditPart.VISUAL_ID:
			return getComponentAttributeCompartment_7023SemanticChildren(view);
		case ComponentOperationCompartment2EditPart.VISUAL_ID:
			return getComponentOperationCompartment_7024SemanticChildren(view);
		case ComponentNestedClassifierCompartment2EditPart.VISUAL_ID:
			return getComponentNestedClassifierCompartment_7025SemanticChildren(view);
		case SignalAttributeCompartment2EditPart.VISUAL_ID:
			return getSignalAttributeCompartment_7026SemanticChildren(view);
		case InterfaceAttributeCompartment2EditPart.VISUAL_ID:
			return getInterfaceAttributeCompartment_7027SemanticChildren(view);
		case InterfaceOperationCompartment2EditPart.VISUAL_ID:
			return getInterfaceOperationCompartment_7028SemanticChildren(view);
		case InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID:
			return getInterfaceNestedClassifierCompartment_7029SemanticChildren(view);
		case ModelPackageableElementCompartment2EditPart.VISUAL_ID:
			return getModelPackageableElementCompartment_7030SemanticChildren(view);
		case EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID:
			return getEnumerationEnumerationLiteralCompartment_7031SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7010SemanticChildren(view);
		case ClassAttributeCompartmentEditPart.VISUAL_ID:
			return getClassAttributeCompartment_7011SemanticChildren(view);
		case ClassOperationCompartmentEditPart.VISUAL_ID:
			return getClassOperationCompartment_7012SemanticChildren(view);
		case ClassNestedClassifierCompartmentEditPart.VISUAL_ID:
			return getClassNestedClassifierCompartment_7013SemanticChildren(view);
		case DataTypeAttributeCompartment2EditPart.VISUAL_ID:
			return getDataTypeAttributeCompartment_7032SemanticChildren(view);
		case DataTypeOperationCompartment2EditPart.VISUAL_ID:
			return getDataTypeOperationCompartment_7033SemanticChildren(view);
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			return getEnumerationEnumerationLiteralCompartment_7015SemanticChildren(view);
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7016SemanticChildren(view);
		case ClassAttributeCompartment2EditPart.VISUAL_ID:
			return getClassAttributeCompartment_7017SemanticChildren(view);
		case ClassOperationCompartment2EditPart.VISUAL_ID:
			return getClassOperationCompartment_7018SemanticChildren(view);
		case ClassNestedClassifierCompartment2EditPart.VISUAL_ID:
			return getClassNestedClassifierCompartment_7019SemanticChildren(view);
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			return getDataTypeAttributeCompartment_7020SemanticChildren(view);
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			return getDataTypeOperationCompartment_7021SemanticChildren(view);
		case ModelEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_2003SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2004SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2005SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2007SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2008SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2010SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3021SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_3022SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3023SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_3024SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_3009SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3010SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_3027SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		{
			TemplateSignature childElement = modelElement
					.getOwnedTemplateSignature();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RedefinableTemplateSignatureEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClassAttributeCompartment_7034SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		AssociationClass modelElement = (AssociationClass) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PropertyEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecificationSlotCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		InstanceSpecification modelElement = (InstanceSpecification) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSlots().iterator(); it.hasNext();) {
			Slot childElement = (Slot) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == SlotEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentAttributeCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PropertyEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentOperationCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it
				.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == OperationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentNestedClassifierCompartment_7004SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRedefinableTemplateSignatureTemplateParameterCompartment_7014SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getParameters().iterator(); it
				.hasNext();) {
			TemplateParameter childElement = (TemplateParameter) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == TemplateParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignalAttributeCompartment_7005SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Property2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceAttributeCompartment_7006SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Property3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceOperationCompartment_7007SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it
				.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Operation2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceNestedClassifierCompartment_7008SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Class3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModelPackageableElementCompartment_7009SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it
				.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InstanceSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it
				.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Comment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecificationSlotCompartment_7022SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		InstanceSpecification modelElement = (InstanceSpecification) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSlots().iterator(); it.hasNext();) {
			Slot childElement = (Slot) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == SlotEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentAttributeCompartment_7023SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PropertyEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentOperationCompartment_7024SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it
				.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == OperationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentNestedClassifierCompartment_7025SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignalAttributeCompartment_7026SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Signal modelElement = (Signal) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Property2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceAttributeCompartment_7027SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Property3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceOperationCompartment_7028SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it
				.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Operation2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceNestedClassifierCompartment_7029SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Class3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModelPackageableElementCompartment_7030SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it
				.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InstanceSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it
				.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Comment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationEnumerationLiteralCompartment_7031SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedLiterals().iterator(); it
				.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartment_7010SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it
				.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InstanceSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it
				.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Comment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassAttributeCompartment_7011SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Property4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassOperationCompartment_7012SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedReceptions().iterator(); it
				.hasNext();) {
			Reception childElement = (Reception) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ReceptionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it
				.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Operation3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassNestedClassifierCompartment_7013SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Class5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataTypeAttributeCompartment_7032SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Property5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataTypeOperationCompartment_7033SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it
				.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Operation4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationEnumerationLiteralCompartment_7015SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedLiterals().iterator(); it
				.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartment_7016SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it
				.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InstanceSpecificationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SignalEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PrimitiveTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it
				.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Comment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassAttributeCompartment_7017SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Property4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassOperationCompartment_7018SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedReceptions().iterator(); it
				.hasNext();) {
			Reception childElement = (Reception) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ReceptionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it
				.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Operation3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassNestedClassifierCompartment_7019SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Class5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataTypeAttributeCompartment_7020SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Property5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataTypeOperationCompartment_7021SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedOperations().iterator(); it
				.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Operation4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPackagedElements().iterator(); it
				.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Dependency2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AssociationClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AssociationNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InstanceSpecificationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SignalEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PrimitiveTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOwnedComments().iterator(); it
				.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CommentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case Dependency2EditPart.VISUAL_ID:
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
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3002ContainedLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3001ContainedLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3003ContainedLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3004ContainedLinks(view);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_3015ContainedLinks(view);
		case TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_3016ContainedLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3005ContainedLinks(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3006ContainedLinks(view);
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3007ContainedLinks(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_3008ContainedLinks(view);
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
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017ContainedLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3009ContainedLinks(view);
		case ClassEditPartCN.VISUAL_ID:
			return getClass_3010ContainedLinks(view);
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011ContainedLinks(view);
		case Property4EditPart.VISUAL_ID:
			return getProperty_3012ContainedLinks(view);
		case Operation3EditPart.VISUAL_ID:
			return getOperation_3013ContainedLinks(view);
		case Class5EditPart.VISUAL_ID:
			return getClass_3014ContainedLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3026ContainedLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027ContainedLinks(view);
		case Property5EditPart.VISUAL_ID:
			return getProperty_3018ContainedLinks(view);
		case Operation4EditPart.VISUAL_ID:
			return getOperation_3019ContainedLinks(view);
		case Comment2EditPart.VISUAL_ID:
			return getComment_3028ContainedLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3029ContainedLinks(view);
		case AssociationClass2EditPart.VISUAL_ID:
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
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case Dependency2EditPart.VISUAL_ID:
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
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3002IncomingLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3001IncomingLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3003IncomingLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3004IncomingLinks(view);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_3015IncomingLinks(view);
		case TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_3016IncomingLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3005IncomingLinks(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3006IncomingLinks(view);
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3007IncomingLinks(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_3008IncomingLinks(view);
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
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017IncomingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3009IncomingLinks(view);
		case ClassEditPartCN.VISUAL_ID:
			return getClass_3010IncomingLinks(view);
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011IncomingLinks(view);
		case Property4EditPart.VISUAL_ID:
			return getProperty_3012IncomingLinks(view);
		case Operation3EditPart.VISUAL_ID:
			return getOperation_3013IncomingLinks(view);
		case Class5EditPart.VISUAL_ID:
			return getClass_3014IncomingLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3026IncomingLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027IncomingLinks(view);
		case Property5EditPart.VISUAL_ID:
			return getProperty_3018IncomingLinks(view);
		case Operation4EditPart.VISUAL_ID:
			return getOperation_3019IncomingLinks(view);
		case Comment2EditPart.VISUAL_ID:
			return getComment_3028IncomingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3029IncomingLinks(view);
		case AssociationClass2EditPart.VISUAL_ID:
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
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case Dependency2EditPart.VISUAL_ID:
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
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3002OutgoingLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3001OutgoingLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3003OutgoingLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3004OutgoingLinks(view);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return getRedefinableTemplateSignature_3015OutgoingLinks(view);
		case TemplateParameterEditPart.VISUAL_ID:
			return getTemplateParameter_3016OutgoingLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3005OutgoingLinks(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3006OutgoingLinks(view);
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3007OutgoingLinks(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_3008OutgoingLinks(view);
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
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_3017OutgoingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3009OutgoingLinks(view);
		case ClassEditPartCN.VISUAL_ID:
			return getClass_3010OutgoingLinks(view);
		case ReceptionEditPart.VISUAL_ID:
			return getReception_3011OutgoingLinks(view);
		case Property4EditPart.VISUAL_ID:
			return getProperty_3012OutgoingLinks(view);
		case Operation3EditPart.VISUAL_ID:
			return getOperation_3013OutgoingLinks(view);
		case Class5EditPart.VISUAL_ID:
			return getClass_3014OutgoingLinks(view);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return getPrimitiveType_3026OutgoingLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027OutgoingLinks(view);
		case Property5EditPart.VISUAL_ID:
			return getProperty_3018OutgoingLinks(view);
		case Operation4EditPart.VISUAL_ID:
			return getOperation_3019OutgoingLinks(view);
		case Comment2EditPart.VISUAL_ID:
			return getComment_3028OutgoingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3029OutgoingLinks(view);
		case AssociationClass2EditPart.VISUAL_ID:
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
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_2014ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_2013ContainedLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_2015ContainedLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2002ContainedLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_2003ContainedLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2004ContainedLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2005ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2006ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2007ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2008ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_2009ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2010ContainedLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2011ContainedLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2012ContainedLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSlot_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3003ContainedLinks(View view) {
		Operation modelElement = (Operation) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3004ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRedefinableTemplateSignature_3015ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTemplateParameter_3016ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3007ContainedLinks(View view) {
		Operation modelElement = (Operation) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3008ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_3020ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3021ContainedLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_3022ContainedLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3023ContainedLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_3024ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3025ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_3017ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_3009ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3010ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getReception_3011ContainedLinks(View view) {
		Reception modelElement = (Reception) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3012ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3013ContainedLinks(View view) {
		Operation modelElement = (Operation) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3014ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_3026ContainedLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_3027ContainedLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3019ContainedLinks(View view) {
		Operation modelElement = (Operation) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3028ContainedLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3029ContainedLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_4017ContainedLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001ContainedLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4019ContainedLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceRealization_4003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSubstitution_4004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRealization_4005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_4006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUsage_4007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_4009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_4010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_4011ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_4012ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTemplateBinding_4015ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_2014IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_2013IncomingLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_2015IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_2001IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2002IncomingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_2003IncomingLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2004IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2005IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4010(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4011(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2006IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2007IncomingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4010(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4011(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2008IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_2009IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2010IncomingLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2011IncomingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2012IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSlot_3001IncomingLinks(View view) {
		Slot modelElement = (Slot) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRedefinableTemplateSignature_3015IncomingLinks(
			View view) {
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTemplateParameter_3016IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3007IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3008IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_3020IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3021IncomingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_3022IncomingLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3023IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_3024IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4010(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4011(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3025IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_3017IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_3009IncomingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4010(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4011(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3010IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getReception_3011IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3012IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3013IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3014IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_3026IncomingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_3027IncomingLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3018IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3019IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComment_3028IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3029IncomingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_4017IncomingLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4019IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_AssociationClass_4017(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4002IncomingLinks(View view) {
		Generalization modelElement = (Generalization) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceRealization_4003IncomingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSubstitution_4004IncomingLinks(View view) {
		Substitution modelElement = (Substitution) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRealization_4005IncomingLinks(View view) {
		Realization modelElement = (Realization) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_4006IncomingLinks(View view) {
		Abstraction modelElement = (Abstraction) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUsage_4007IncomingLinks(View view) {
		Usage modelElement = (Usage) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4008IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4018IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4005(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4007(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_4009(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_4009IncomingLinks(View view) {
		ElementImport modelElement = (ElementImport) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_4010IncomingLinks(View view) {
		PackageImport modelElement = (PackageImport) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_4011IncomingLinks(View view) {
		PackageMerge modelElement = (PackageMerge) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_4012IncomingLinks(View view) {
		ProfileApplication modelElement = (ProfileApplication) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTemplateBinding_4015IncomingLinks(View view) {
		TemplateBinding modelElement = (TemplateBinding) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
						modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TemplateBinding_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_2014OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_2013OutgoingLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_2015OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_2001OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2002OutgoingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_2003OutgoingLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_2004OutgoingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2005OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2006OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2007OutgoingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_2008OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_2009OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2010OutgoingLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2011OutgoingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2012OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSlot_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRedefinableTemplateSignature_3015OutgoingLinks(
			View view) {
		RedefinableTemplateSignature modelElement = (RedefinableTemplateSignature) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTemplateParameter_3016OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3007OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3008OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInstanceSpecification_3020OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3021OutgoingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSignal_3022OutgoingLinks(View view) {
		Signal modelElement = (Signal) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3023OutgoingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_3024OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3025OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_3017OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_3009OutgoingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProfileApplication_4012(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3010OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getReception_3011OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3012OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3013OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3014OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPrimitiveType_3026OutgoingLinks(View view) {
		PrimitiveType modelElement = (PrimitiveType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_3027OutgoingLinks(View view) {
		DataType modelElement = (DataType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3018OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3019OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getComment_3028OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3029OutgoingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociationClass_4017OutgoingLinks(View view) {
		AssociationClass modelElement = (AssociationClass) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4019OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_AssociationClass_4017(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Substitution_4004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ElementImport_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_PackageImport_4010(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_TemplateBinding_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceRealization_4003OutgoingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSubstitution_4004OutgoingLinks(View view) {
		Substitution modelElement = (Substitution) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRealization_4005OutgoingLinks(View view) {
		Realization modelElement = (Realization) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_4006OutgoingLinks(View view) {
		Abstraction modelElement = (Abstraction) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUsage_4007OutgoingLinks(View view) {
		Usage modelElement = (Usage) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4008OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4018OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Realization_4005(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_4009OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_4010OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_4011OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_4012OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTemplateBinding_4015OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_AssociationClass_4017(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass) linkObject;
			if (AssociationClass2EditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.AssociationClass_4017,
					AssociationClass2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4001(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Association_4001,
					AssociationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4019(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Association_4019,
					AssociationBranchEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Generalization_4002(
			Classifier container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getGeneralizations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) linkObject;
			if (GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Classifier dst = link.getGeneral();
			result.add(new UMLLinkDescriptor(container, dst, link,
					UMLElementTypes.Generalization_4002,
					GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_InterfaceRealization_4003(
			BehavioredClassifier container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getInterfaceRealizations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization) linkObject;
			if (InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Interface dst = link.getContract();
			result.add(new UMLLinkDescriptor(container, dst, link,
					UMLElementTypes.InterfaceRealization_4003,
					InterfaceRealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Substitution_4004(
			Classifier container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getSubstitutions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution) linkObject;
			if (SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Classifier dst = link.getContract();
			Classifier src = link.getSubstitutingClassifier();
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Substitution_4004,
					SubstitutionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Realization_4005(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Realization) {
				continue;
			}
			Realization link = (Realization) linkObject;
			if (RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Realization_4005,
					RealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Abstraction_4006(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction) linkObject;
			if (AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Abstraction_4006,
					AbstractionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Usage_4007(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage) linkObject;
			if (UsageEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Usage_4007, UsageEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_4008(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Dependency_4008,
					DependencyEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_4018(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Dependency_4018,
					DependencyBranchEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ElementImport_4009(
			Namespace container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getElementImports().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport) linkObject;
			if (ElementImportEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			PackageableElement dst = link.getImportedElement();
			result.add(new UMLLinkDescriptor(container, dst, link,
					UMLElementTypes.ElementImport_4009,
					ElementImportEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_PackageImport_4010(
			Namespace container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackageImports().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport) linkObject;
			if (PackageImportEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Package dst = link.getImportedPackage();
			result.add(new UMLLinkDescriptor(container, dst, link,
					UMLElementTypes.PackageImport_4010,
					PackageImportEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_PackageMerge_4011(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackageMerges().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge) linkObject;
			if (PackageMergeEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Package dst = link.getMergedPackage();
			Package src = link.getReceivingPackage();
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.PackageMerge_4011,
					PackageMergeEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ProfileApplication_4012(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getProfileApplications().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ProfileApplication) {
				continue;
			}
			ProfileApplication link = (ProfileApplication) linkObject;
			if (ProfileApplicationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Profile dst = link.getAppliedProfile();
			result.add(new UMLLinkDescriptor(container, dst, link,
					UMLElementTypes.ProfileApplication_4012,
					ProfileApplicationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_TemplateBinding_4015(
			TemplateableElement container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getTemplateBindings().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding) linkObject;
			if (TemplateBindingEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getTargets();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element) theTarget;
			TemplateableElement src = link.getBoundElement();
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.TemplateBinding_4015,
					TemplateBindingEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_AssociationClass_4017(
			Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getAssociation_EndType()
					|| false == setting.getEObject() instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass) setting.getEObject();
			if (AssociationClass2EditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.AssociationClass_4017,
					AssociationClass2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4001(
			Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getAssociation_EndType()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Association_4001,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4019(
			Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getAssociation_EndType()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Association_4019,
					AssociationBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Generalization_4002(
			Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getGeneralization_General()
					|| false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) setting.getEObject();
			if (GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Classifier) {
				continue;
			}
			Classifier container = (Classifier) link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link,
					UMLElementTypes.Generalization_4002,
					GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_InterfaceRealization_4003(
			Interface target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getInterfaceRealization_Contract()
					|| false == setting.getEObject() instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization) setting
					.getEObject();
			if (InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof BehavioredClassifier) {
				continue;
			}
			BehavioredClassifier container = (BehavioredClassifier) link
					.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link,
					UMLElementTypes.InterfaceRealization_4003,
					InterfaceRealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Substitution_4004(
			Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getSubstitution_Contract()
					|| false == setting.getEObject() instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution) setting.getEObject();
			if (SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier src = link.getSubstitutingClassifier();
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Substitution_4004,
					SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Realization_4005(
			NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDependency_Supplier()
					|| false == setting.getEObject() instanceof Realization) {
				continue;
			}
			Realization link = (Realization) setting.getEObject();
			if (RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Realization_4005,
					RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Abstraction_4006(
			NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDependency_Supplier()
					|| false == setting.getEObject() instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction) setting.getEObject();
			if (AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Abstraction_4006,
					AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Usage_4007(
			NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDependency_Supplier()
					|| false == setting.getEObject() instanceof Usage) {
				continue;
			}
			Usage link = (Usage) setting.getEObject();
			if (UsageEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Usage_4007, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_4008(
			NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDependency_Supplier()
					|| false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Dependency_4008,
					DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_4018(
			NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDependency_Supplier()
					|| false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Dependency_4018,
					DependencyBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ElementImport_4009(
			PackageableElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getElementImport_ImportedElement()
					|| false == setting.getEObject() instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport) setting.getEObject();
			if (ElementImportEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Namespace) {
				continue;
			}
			Namespace container = (Namespace) link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link,
					UMLElementTypes.ElementImport_4009,
					ElementImportEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_PackageImport_4010(
			Package target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getPackageImport_ImportedPackage()
					|| false == setting.getEObject() instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport) setting.getEObject();
			if (PackageImportEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Namespace) {
				continue;
			}
			Namespace container = (Namespace) link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link,
					UMLElementTypes.PackageImport_4010,
					PackageImportEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_PackageMerge_4011(
			Package target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getPackageMerge_MergedPackage()
					|| false == setting.getEObject() instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge) setting.getEObject();
			if (PackageMergeEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package src = link.getReceivingPackage();
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.PackageMerge_4011,
					PackageMergeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
			Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE
					.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target,
						UMLElementTypes.CommentAnnotatedElement_4013,
						CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
			Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE
					.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target,
						UMLElementTypes.ConstraintConstrainedElement_4014,
						ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_TemplateBinding_4015(
			Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDirectedRelationship_Target()
					|| false == setting.getEObject() instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding) setting.getEObject();
			if (TemplateBindingEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			TemplateableElement src = link.getBoundElement();
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.TemplateBinding_4015,
					TemplateBindingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_AssociationClass_4017(
			Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AssociationClass) {
				continue;
			}
			AssociationClass link = (AssociationClass) linkObject;
			if (AssociationClass2EditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.AssociationClass_4017,
					AssociationClass2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4001(
			Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Association_4001,
					AssociationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4019(
			Type source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if (false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type) theTarget;
			List sources = link.getEndTypes();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Association_4019,
					AssociationBranchEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Substitution_4004(
			Classifier source) {
		Classifier container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Classifier) {
				container = (Classifier) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getSubstitutions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution) linkObject;
			if (SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Classifier dst = link.getContract();
			Classifier src = link.getSubstitutingClassifier();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Substitution_4004,
					SubstitutionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Realization_4005(
			NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Realization) {
				continue;
			}
			Realization link = (Realization) linkObject;
			if (RealizationEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Realization_4005,
					RealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Abstraction_4006(
			NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Abstraction) {
				continue;
			}
			Abstraction link = (Abstraction) linkObject;
			if (AbstractionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Abstraction_4006,
					AbstractionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Usage_4007(
			NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage) linkObject;
			if (UsageEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Usage_4007, UsageEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_4008(
			NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Dependency_4008,
					DependencyEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_4018(
			NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Dependency_4018,
					DependencyBranchEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_PackageMerge_4011(
			Package source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackageMerges().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge) linkObject;
			if (PackageMergeEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}

			Package dst = link.getMergedPackage();
			Package src = link.getReceivingPackage();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.PackageMerge_4011,
					PackageMergeEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(
			Comment source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getAnnotatedElements().iterator(); destinations
				.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination,
					UMLElementTypes.CommentAnnotatedElement_4013,
					CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(
			Constraint source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getConstrainedElements().iterator(); destinations
				.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination,
					UMLElementTypes.ConstraintConstrainedElement_4014,
					ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_TemplateBinding_4015(
			TemplateableElement source) {
		TemplateableElement container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof TemplateableElement) {
				container = (TemplateableElement) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getTemplateBindings().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof TemplateBinding) {
				continue;
			}
			TemplateBinding link = (TemplateBinding) linkObject;
			if (TemplateBindingEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.TemplateBinding_4015,
					TemplateBindingEditPart.VISUAL_ID));

		}
		return result;
	}

}
