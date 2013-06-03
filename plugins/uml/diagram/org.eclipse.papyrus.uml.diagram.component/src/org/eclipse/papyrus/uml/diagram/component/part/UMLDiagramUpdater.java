package org.eclipse.papyrus.uml.diagram.component.part;

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
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Substitution;
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
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002SemanticChildren(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3070SemanticChildren(view);
		case ComponentEditPartPCN.VISUAL_ID:
			return getComponent_3071SemanticChildren(view);
		case ComponentCompositeCompartmentEditPart.VISUAL_ID:
			return getComponentCompositeCompartment_7001SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7002SemanticChildren(view);
		case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
			return getComponentCompositeCompartmentCN_7003SemanticChildren(view);
		case ComponentCompositeCompartmentEditPartPCN.VISUAL_ID:
			return getComponentCompositeCompartmentPCN_7004SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackage_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedTypes().iterator(); it
				.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getPackagedElements().iterator(); it
				.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOwnedComments().iterator(); it
				.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CommentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOwnedRules().iterator(); it
				.hasNext();) {
			Constraint childElement = (Constraint) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_2002SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_3070SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_3071SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it
				.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentCompositeCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component) containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackagePackageableElementCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Package modelElement = (Package) containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPackagedElements().iterator(); it
				.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InterfaceEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComponentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOwnedComments().iterator(); it
				.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CommentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOwnedRules().iterator(); it
				.hasNext();) {
			Constraint childElement = (Constraint) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ConstraintEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentCompositeCompartmentCN_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component) containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentCompositeCompartmentPCN_7004SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component) containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002ContainedLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2003ContainedLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_3200ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3201ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3199ContainedLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069ContainedLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3070ContainedLinks(view);
		case ComponentEditPartPCN.VISUAL_ID:
			return getComponent_3071ContainedLinks(view);
		case InterfaceEditPartPCN.VISUAL_ID:
			return getInterface_3072ContainedLinks(view);
		case CommentEditPartPCN.VISUAL_ID:
			return getComment_3074ContainedLinks(view);
		case ConstraintEditPartPCN.VISUAL_ID:
			return getConstraint_3075ContainedLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4001ContainedLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4006ContainedLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003ContainedLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4012ContainedLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4014ContainedLinks(view);
		case ComponentRealizationEditPart.VISUAL_ID:
			return getComponentRealization_4007ContainedLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4013ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4010ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002IncomingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2003IncomingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_3200IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3201IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3199IncomingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069IncomingLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3070IncomingLinks(view);
		case ComponentEditPartPCN.VISUAL_ID:
			return getComponent_3071IncomingLinks(view);
		case InterfaceEditPartPCN.VISUAL_ID:
			return getInterface_3072IncomingLinks(view);
		case CommentEditPartPCN.VISUAL_ID:
			return getComment_3074IncomingLinks(view);
		case ConstraintEditPartPCN.VISUAL_ID:
			return getConstraint_3075IncomingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4001IncomingLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4006IncomingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003IncomingLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4012IncomingLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4014IncomingLinks(view);
		case ComponentRealizationEditPart.VISUAL_ID:
			return getComponentRealization_4007IncomingLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4013IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4010IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002OutgoingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2003OutgoingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_3200OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3201OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3199OutgoingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069OutgoingLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3070OutgoingLinks(view);
		case ComponentEditPartPCN.VISUAL_ID:
			return getComponent_3071OutgoingLinks(view);
		case InterfaceEditPartPCN.VISUAL_ID:
			return getInterface_3072OutgoingLinks(view);
		case CommentEditPartPCN.VISUAL_ID:
			return getComment_3074OutgoingLinks(view);
		case ConstraintEditPartPCN.VISUAL_ID:
			return getConstraint_3075OutgoingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4001OutgoingLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4006OutgoingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003OutgoingLinks(view);
		case SubstitutionEditPart.VISUAL_ID:
			return getSubstitution_4012OutgoingLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4014OutgoingLinks(view);
		case ComponentRealizationEditPart.VISUAL_ID:
			return getComponentRealization_4007OutgoingLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4013OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4010OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_1000ContainedLinks(
			View view) {
		Package modelElement = (Package) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002ContainedLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2003ContainedLinks(
			View view) {
		Interface modelElement = (Interface) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3200ContainedLinks(
			View view) {
		Package modelElement = (Package) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3201ContainedLinks(
			View view) {
		Comment modelElement = (Comment) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3199ContainedLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPort_3069ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3070ContainedLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3071ContainedLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3072ContainedLinks(
			View view) {
		Interface modelElement = (Interface) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3074ContainedLinks(
			View view) {
		Comment modelElement = (Comment) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3075ContainedLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4006ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4012ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4014ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4007ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002IncomingLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2003IncomingLinks(
			View view) {
		Interface modelElement = (Interface) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3200IncomingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3201IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3199IncomingLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPort_3069IncomingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3070IncomingLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3071IncomingLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3072IncomingLinks(
			View view) {
		Interface modelElement = (Interface) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3074IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3075IncomingLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4001IncomingLinks(View view) {
		Usage modelElement = (Usage) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4006IncomingLinks(
			View view) {
		InterfaceRealization modelElement = (InterfaceRealization) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4003IncomingLinks(
			View view) {
		Generalization modelElement = (Generalization) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4012IncomingLinks(
			View view) {
		Substitution modelElement = (Substitution) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4014IncomingLinks(
			View view) {
		Manifestation modelElement = (Manifestation) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4007IncomingLinks(
			View view) {
		ComponentRealization modelElement = (ComponentRealization) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4013IncomingLinks(
			View view) {
		Abstraction modelElement = (Abstraction) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010IncomingLinks(
			View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002OutgoingLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_2003OutgoingLinks(
			View view) {
		Interface modelElement = (Interface) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3200OutgoingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3201OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3199OutgoingLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPort_3069OutgoingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3070OutgoingLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3071OutgoingLinks(
			View view) {
		Component modelElement = (Component) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3072OutgoingLinks(
			View view) {
		Interface modelElement = (Interface) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3074OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3075OutgoingLinks(
			View view) {
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4001OutgoingLinks(View view) {
		Usage modelElement = (Usage) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4006OutgoingLinks(
			View view) {
		InterfaceRealization modelElement = (InterfaceRealization) view
				.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4012OutgoingLinks(
			View view) {
		Substitution modelElement = (Substitution) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4014OutgoingLinks(
			View view) {
		Manifestation modelElement = (Manifestation) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4007OutgoingLinks(
			View view) {
		ComponentRealization modelElement = (ComponentRealization) view
				.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4013OutgoingLinks(
			View view) {
		Abstraction modelElement = (Abstraction) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010OutgoingLinks(
			View view) {
		Dependency modelElement = (Dependency) view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Usage_4001(
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
					UMLElementTypes.Usage_4001, UsageEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InterfaceRealization_4006(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
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
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.InterfaceRealization_4006,
					InterfaceRealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Generalization_4003(
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
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Generalization_4003,
					GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Substitution_4012(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
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
					UMLElementTypes.Substitution_4012,
					SubstitutionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Manifestation_4014(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation) linkObject;
			if (ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry
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
					UMLElementTypes.Manifestation_4014,
					ManifestationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_ComponentRealization_4007(
			Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization) linkObject;
			if (ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry
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
					UMLElementTypes.ComponentRealization_4007,
					ComponentRealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Abstraction_4013(
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
					UMLElementTypes.Abstraction_4013,
					AbstractionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4010(
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
					UMLElementTypes.Dependency_4010,
					DependencyEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Usage_4001(
			NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
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
					UMLElementTypes.Usage_4001, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_InterfaceRealization_4006(
			Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
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
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.InterfaceRealization_4006,
					InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Generalization_4003(
			Classifier target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
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
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, target, link,
					UMLElementTypes.Generalization_4003,
					GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Substitution_4012(
			NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDependency_Supplier()
					|| false == setting.getEObject() instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution) setting.getEObject();
			if (SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry
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
					UMLElementTypes.Substitution_4012,
					SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Manifestation_4014(
			NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDependency_Supplier()
					|| false == setting.getEObject() instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation) setting.getEObject();
			if (ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry
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
					UMLElementTypes.Manifestation_4014,
					ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_ComponentRealization_4007(
			NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getDependency_Supplier()
					|| false == setting.getEObject() instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization) setting
					.getEObject();
			if (ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry
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
					UMLElementTypes.ComponentRealization_4007,
					ComponentRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Abstraction_4013(
			NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
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
					UMLElementTypes.Abstraction_4013,
					AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
			Element target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE
					.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target,
						UMLElementTypes.CommentAnnotatedElement_4015,
						CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
			Element target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE
					.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target,
						UMLElementTypes.ConstraintConstrainedElement_4009,
						ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4010(
			NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
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
					UMLElementTypes.Dependency_4010,
					DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Usage_4001(
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
			return Collections.emptyList();
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
					UMLElementTypes.Usage_4001, UsageEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(
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
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
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
					UMLElementTypes.InterfaceRealization_4006,
					InterfaceRealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Generalization_4003(
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
			return Collections.emptyList();
		}
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
			Classifier src = link.getSpecific();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link,
					UMLElementTypes.Generalization_4003,
					GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Substitution_4012(
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
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
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
					UMLElementTypes.Substitution_4012,
					SubstitutionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Manifestation_4014(
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
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation) linkObject;
			if (ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry
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
					UMLElementTypes.Manifestation_4014,
					ManifestationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_ComponentRealization_4007(
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
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization) linkObject;
			if (ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry
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
					UMLElementTypes.ComponentRealization_4007,
					ComponentRealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Abstraction_4013(
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
			return Collections.emptyList();
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
					UMLElementTypes.Abstraction_4013,
					AbstractionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(
			Comment source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (Iterator<?> destinations = source.getAnnotatedElements()
				.iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination,
					UMLElementTypes.CommentAnnotatedElement_4015,
					CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(
			Constraint source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (Iterator<?> destinations = source.getConstrainedElements()
				.iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination,
					UMLElementTypes.ConstraintConstrainedElement_4009,
					ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4010(
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
			return Collections.emptyList();
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
					UMLElementTypes.Dependency_4010,
					DependencyEditPart.VISUAL_ID));

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
