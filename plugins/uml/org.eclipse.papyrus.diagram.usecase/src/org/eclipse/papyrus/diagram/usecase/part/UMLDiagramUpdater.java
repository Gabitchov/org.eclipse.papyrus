/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
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
package org.eclipse.papyrus.diagram.usecase.part;

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
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecasesEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Package3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseExtensionpointsEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsEditPart;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case UseCasePointsEditPart.VISUAL_ID:
			return getUseCasePoints_7002SemanticChildren(view);
		case UseCaseExtensionpointsEditPart.VISUAL_ID:
			return getUseCaseExtensionpoints_7003SemanticChildren(view);
		case ComponentUsecasesEditPart.VISUAL_ID:
			return getComponentUsecases_7004SemanticChildren(view);
		case UseCasePoints2EditPart.VISUAL_ID:
			return getUseCasePoints_7005SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7008SemanticChildren(view);
		case UseCasePoints3EditPart.VISUAL_ID:
			return getUseCasePoints_7007SemanticChildren(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCasePoints_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCase modelElement = (UseCase) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ExtensionPointEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCaseExtensionpoints_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCase modelElement = (UseCase) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ExtensionPoint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentUsecases_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getUseCases().iterator(); it.hasNext();) {
			UseCase childElement = (UseCase) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == UseCase3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCasePoints_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCase modelElement = (UseCase) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ExtensionPointEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartment_7008SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Actor3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == UseCase4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCasePoints_7007SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCase modelElement = (UseCase) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ExtensionPointEditPart.VISUAL_ID) {
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
		for (Iterator it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ActorEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Actor2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == UseCaseEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == UseCase2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Package3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
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
	public static List getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2002ContainedLinks(view);
		case Actor2EditPart.VISUAL_ID:
			return getActor_2003ContainedLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2004ContainedLinks(view);
		case UseCase2EditPart.VISUAL_ID:
			return getUseCase_2005ContainedLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2006ContainedLinks(view);
		case Package3EditPart.VISUAL_ID:
			return getPackage_2009ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2008ContainedLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3002ContainedLinks(view);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3003ContainedLinks(view);
		case UseCase3EditPart.VISUAL_ID:
			return getUseCase_3004ContainedLinks(view);
		case Actor3EditPart.VISUAL_ID:
			return getActor_3005ContainedLinks(view);
		case UseCase4EditPart.VISUAL_ID:
			return getUseCase_3006ContainedLinks(view);
		case IncludeEditPart.VISUAL_ID:
			return getInclude_4001ContainedLinks(view);
		case ExtendEditPart.VISUAL_ID:
			return getExtend_4002ContainedLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003ContainedLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4004ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4006ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ActorEditPart.VISUAL_ID:
			return getActor_2002IncomingLinks(view);
		case Actor2EditPart.VISUAL_ID:
			return getActor_2003IncomingLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2004IncomingLinks(view);
		case UseCase2EditPart.VISUAL_ID:
			return getUseCase_2005IncomingLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2006IncomingLinks(view);
		case Package3EditPart.VISUAL_ID:
			return getPackage_2009IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2008IncomingLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3002IncomingLinks(view);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3003IncomingLinks(view);
		case UseCase3EditPart.VISUAL_ID:
			return getUseCase_3004IncomingLinks(view);
		case Actor3EditPart.VISUAL_ID:
			return getActor_3005IncomingLinks(view);
		case UseCase4EditPart.VISUAL_ID:
			return getUseCase_3006IncomingLinks(view);
		case IncludeEditPart.VISUAL_ID:
			return getInclude_4001IncomingLinks(view);
		case ExtendEditPart.VISUAL_ID:
			return getExtend_4002IncomingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003IncomingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4004IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4006IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ActorEditPart.VISUAL_ID:
			return getActor_2002OutgoingLinks(view);
		case Actor2EditPart.VISUAL_ID:
			return getActor_2003OutgoingLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2004OutgoingLinks(view);
		case UseCase2EditPart.VISUAL_ID:
			return getUseCase_2005OutgoingLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2006OutgoingLinks(view);
		case Package3EditPart.VISUAL_ID:
			return getPackage_2009OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2008OutgoingLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3002OutgoingLinks(view);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3003OutgoingLinks(view);
		case UseCase3EditPart.VISUAL_ID:
			return getUseCase_3004OutgoingLinks(view);
		case Actor3EditPart.VISUAL_ID:
			return getActor_3005OutgoingLinks(view);
		case UseCase4EditPart.VISUAL_ID:
			return getUseCase_3006OutgoingLinks(view);
		case IncludeEditPart.VISUAL_ID:
			return getInclude_4001OutgoingLinks(view);
		case ExtendEditPart.VISUAL_ID:
			return getExtend_4002OutgoingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003OutgoingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4004OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4006OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2002ContainedLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2003ContainedLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2004ContainedLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Include_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2005ContainedLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Include_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2006ContainedLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2009ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2008ContainedLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3004ContainedLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Include_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3005ContainedLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3006ContainedLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Include_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInclude_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtend_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4004ContainedLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_2002IncomingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2003IncomingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2004IncomingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2005IncomingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2006IncomingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2009IncomingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2008IncomingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3002IncomingLinks(View view) {
		ExtensionPoint modelElement = (ExtensionPoint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3003IncomingLinks(View view) {
		ExtensionPoint modelElement = (ExtensionPoint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3004IncomingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3005IncomingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3006IncomingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInclude_4001IncomingLinks(View view) {
		Include modelElement = (Include) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtend_4002IncomingLinks(View view) {
		Extend modelElement = (Extend) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4003IncomingLinks(View view) {
		Generalization modelElement = (Generalization) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4004IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4004(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4006IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2002OutgoingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2003OutgoingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2004OutgoingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Include_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extend_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2005OutgoingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Include_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extend_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2006OutgoingLinks(View view) {
		Component modelElement = (Component) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2009OutgoingLinks(View view) {
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2008OutgoingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3002OutgoingLinks(View view) {
		ExtensionPoint modelElement = (ExtensionPoint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3003OutgoingLinks(View view) {
		ExtensionPoint modelElement = (ExtensionPoint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3004OutgoingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Include_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extend_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3005OutgoingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3006OutgoingLinks(View view) {
		UseCase modelElement = (UseCase) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Include_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extend_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInclude_4001OutgoingLinks(View view) {
		Include modelElement = (Include) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtend_4002OutgoingLinks(View view) {
		Extend modelElement = (Extend) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4004OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4006OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Include_4001(UseCase container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getIncludes().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Include) {
				continue;
			}
			Include link = (Include) linkObject;
			if (IncludeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			UseCase dst = link.getAddition();
			UseCase src = link.getIncludingCase();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Include_4001, IncludeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Extend_4002(UseCase container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getExtends().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Extend) {
				continue;
			}
			Extend link = (Extend) linkObject;
			if (ExtendEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			UseCase dst = link.getExtendedCase();
			UseCase src = link.getExtension();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Extend_4002, ExtendEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Generalization_4003(Classifier container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) linkObject;
			if (GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getGeneral();
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Generalization_4003, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4004(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (link.isBinary()) {
				Property sourceEnd = AssociationEndConvention.getSourceEnd(link);
				Property targetEnd = AssociationEndConvention.getTargetEnd(link);
				EObject gmfSource = sourceEnd.getType();
				EObject gmfTarget = targetEnd.getType();
				result.add(new UMLLinkDescriptor(gmfSource, gmfTarget, link, UMLElementTypes.Association_4004, AssociationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_4006(Package container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4006, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Include_4001(UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInclude_Addition() || false == setting.getEObject() instanceof Include) {
				continue;
			}
			Include link = (Include) setting.getEObject();
			if (IncludeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			UseCase src = link.getIncludingCase();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Include_4001, IncludeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Extend_4002(UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getExtend_ExtendedCase() || false == setting.getEObject() instanceof Extend) {
				continue;
			}
			Extend link = (Extend) setting.getEObject();
			if (ExtendEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			UseCase src = link.getExtension();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Extend_4002, ExtendEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Generalization_4003(Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) setting.getEObject();
			if (GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Generalization_4003, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4004(Type target, Map crossReferences) {
		return findRelatedAssociations(target, false);
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4005, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_4006(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4006, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Include_4001(UseCase source) {
		UseCase container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof UseCase) {
				container = (UseCase) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getIncludes().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Include) {
				continue;
			}
			Include link = (Include) linkObject;
			if (IncludeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			UseCase dst = link.getAddition();
			UseCase src = link.getIncludingCase();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Include_4001, IncludeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Extend_4002(UseCase source) {
		UseCase container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof UseCase) {
				container = (UseCase) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getExtends().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Extend) {
				continue;
			}
			Extend link = (Extend) linkObject;
			if (ExtendEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			UseCase dst = link.getExtendedCase();
			UseCase src = link.getExtension();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Extend_4002, ExtendEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Generalization_4003(Classifier source) {
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
		for (Iterator links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization) linkObject;
			if (GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier dst = link.getGeneral();
			Classifier src = link.getSpecific();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Generalization_4003, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4004(Type source) {
		return findRelatedAssociations(source, false);
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4005(Constraint source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4005, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_4006(NamedElement source) {
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
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4006, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection findRelatedAssociations(Type type, boolean sourceNotTarget) {
		Package container = type.getNearestPackage();
		if (container == null) {
			return Collections.emptyList();
		}

		List<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (PackageableElement next : container.getPackagedElements()) {
			if (false == next instanceof Association) {
				continue;
			}
			if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(next)) {
				continue;
			}
			Association link = (Association) next;
			Property sourceEnd = AssociationEndConvention.getSourceEnd(link);
			Property targetEnd = AssociationEndConvention.getTargetEnd(link);

			if (sourceEnd == null || targetEnd == null) {
				continue;
			}

			Property subjectEnd = sourceNotTarget ? sourceEnd : targetEnd;
			if (!type.equals(subjectEnd.getType())) {
				continue;
			}

			EObject gmfSource = sourceEnd.getType();
			EObject gmfTarget = targetEnd.getType();
			result.add(new UMLLinkDescriptor(gmfSource, gmfTarget, link, UMLElementTypes.Association_4004, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

}
