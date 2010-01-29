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
package org.eclipse.papyrus.diagram.usecase.part;

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
import org.eclipse.papyrus.diagram.usecase.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Component2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Component3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecases2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecases3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecasesEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Constraint3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseExtensionpointsEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsEditPart;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case UseCasePointsEditPart.VISUAL_ID:
			return getUseCasePoints_7009SemanticChildren(view);
		case UseCaseExtensionpointsEditPart.VISUAL_ID:
			return getUseCaseExtensionpoints_7010SemanticChildren(view);
		case ComponentUsecasesEditPart.VISUAL_ID:
			return getComponentUsecases_7011SemanticChildren(view);
		case UseCasePoints2EditPart.VISUAL_ID:
			return getUseCasePoints_7012SemanticChildren(view);
		case ComponentUsecases2EditPart.VISUAL_ID:
			return getComponentUsecases_7017SemanticChildren(view);
		case UseCasePoints3EditPart.VISUAL_ID:
			return getUseCasePoints_7014SemanticChildren(view);
		case ComponentUsecases3EditPart.VISUAL_ID:
			return getComponentUsecases_7015SemanticChildren(view);
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7016SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7013SemanticChildren(view);
		case UseCaseDiagramEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCasePoints_7009SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCase modelElement = (UseCase)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExtensionPointEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCaseExtensionpoints_7010SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCase modelElement = (UseCase)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExtensionPoint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentUsecases_7011SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getUseCases().iterator(); it.hasNext();) {
			UseCase childElement = (UseCase)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == UseCase3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Component2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Comment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Actor4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCasePoints_7012SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCase modelElement = (UseCase)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExtensionPointEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentUsecases_7017SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getUseCases().iterator(); it.hasNext();) {
			UseCase childElement = (UseCase)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == UseCase3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Component2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Comment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Actor4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartment_7013SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Constraint3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Actor3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCase4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Component3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getNestedPackages().iterator(); it.hasNext();) {
			Package childElement = (Package)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Comment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCasePoints_7014SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		UseCase modelElement = (UseCase)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExtensionPointEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponentUsecases_7015SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getUseCases().iterator(); it.hasNext();) {
			UseCase childElement = (UseCase)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == UseCase3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Component2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Comment2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Actor4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartment_7016SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Constraint3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Actor3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCase4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Component3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getNestedPackages().iterator(); it.hasNext();) {
			Package childElement = (Package)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Comment2EditPart.VISUAL_ID) {
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
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActorEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Actor2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCase2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PackageEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
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
	private static Iterator getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case UseCaseDiagramEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2011ContainedLinks(view);
		case Actor2EditPart.VISUAL_ID:
			return getActor_2012ContainedLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2013ContainedLinks(view);
		case UseCase2EditPart.VISUAL_ID:
			return getUseCase_2014ContainedLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2015ContainedLinks(view);
		case PackageEditPartTN.VISUAL_ID:
			return getPackage_2016ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2017ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2018ContainedLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2019ContainedLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3007ContainedLinks(view);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3008ContainedLinks(view);
		case UseCase3EditPart.VISUAL_ID:
			return getUseCase_3009ContainedLinks(view);
		case Component2EditPart.VISUAL_ID:
			return getComponent_3016ContainedLinks(view);
		case Comment2EditPart.VISUAL_ID:
			return getComment_3015ContainedLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3017ContainedLinks(view);
		case Actor4EditPart.VISUAL_ID:
			return getActor_3018ContainedLinks(view);
		case Constraint3EditPart.VISUAL_ID:
			return getConstraint_3010ContainedLinks(view);
		case Actor3EditPart.VISUAL_ID:
			return getActor_3011ContainedLinks(view);
		case UseCase4EditPart.VISUAL_ID:
			return getUseCase_3012ContainedLinks(view);
		case Component3EditPart.VISUAL_ID:
			return getComponent_3013ContainedLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3014ContainedLinks(view);
		case IncludeEditPart.VISUAL_ID:
			return getInclude_4008ContainedLinks(view);
		case ExtendEditPart.VISUAL_ID:
			return getExtend_4009ContainedLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4010ContainedLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4013ContainedLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4015ContainedLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4016ContainedLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4017ContainedLinks(view);
		case PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_4018ContainedLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_4019ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActorEditPart.VISUAL_ID:
			return getActor_2011IncomingLinks(view);
		case Actor2EditPart.VISUAL_ID:
			return getActor_2012IncomingLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2013IncomingLinks(view);
		case UseCase2EditPart.VISUAL_ID:
			return getUseCase_2014IncomingLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2015IncomingLinks(view);
		case PackageEditPartTN.VISUAL_ID:
			return getPackage_2016IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2017IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2018IncomingLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2019IncomingLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3007IncomingLinks(view);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3008IncomingLinks(view);
		case UseCase3EditPart.VISUAL_ID:
			return getUseCase_3009IncomingLinks(view);
		case Component2EditPart.VISUAL_ID:
			return getComponent_3016IncomingLinks(view);
		case Comment2EditPart.VISUAL_ID:
			return getComment_3015IncomingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3017IncomingLinks(view);
		case Actor4EditPart.VISUAL_ID:
			return getActor_3018IncomingLinks(view);
		case Constraint3EditPart.VISUAL_ID:
			return getConstraint_3010IncomingLinks(view);
		case Actor3EditPart.VISUAL_ID:
			return getActor_3011IncomingLinks(view);
		case UseCase4EditPart.VISUAL_ID:
			return getUseCase_3012IncomingLinks(view);
		case Component3EditPart.VISUAL_ID:
			return getComponent_3013IncomingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3014IncomingLinks(view);
		case IncludeEditPart.VISUAL_ID:
			return getInclude_4008IncomingLinks(view);
		case ExtendEditPart.VISUAL_ID:
			return getExtend_4009IncomingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4010IncomingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4013IncomingLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4015IncomingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4016IncomingLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4017IncomingLinks(view);
		case PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_4018IncomingLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_4019IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActorEditPart.VISUAL_ID:
			return getActor_2011OutgoingLinks(view);
		case Actor2EditPart.VISUAL_ID:
			return getActor_2012OutgoingLinks(view);
		case UseCaseEditPart.VISUAL_ID:
			return getUseCase_2013OutgoingLinks(view);
		case UseCase2EditPart.VISUAL_ID:
			return getUseCase_2014OutgoingLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2015OutgoingLinks(view);
		case PackageEditPartTN.VISUAL_ID:
			return getPackage_2016OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2017OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2018OutgoingLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2019OutgoingLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3007OutgoingLinks(view);
		case ExtensionPoint2EditPart.VISUAL_ID:
			return getExtensionPoint_3008OutgoingLinks(view);
		case UseCase3EditPart.VISUAL_ID:
			return getUseCase_3009OutgoingLinks(view);
		case Component2EditPart.VISUAL_ID:
			return getComponent_3016OutgoingLinks(view);
		case Comment2EditPart.VISUAL_ID:
			return getComment_3015OutgoingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3017OutgoingLinks(view);
		case Actor4EditPart.VISUAL_ID:
			return getActor_3018OutgoingLinks(view);
		case Constraint3EditPart.VISUAL_ID:
			return getConstraint_3010OutgoingLinks(view);
		case Actor3EditPart.VISUAL_ID:
			return getActor_3011OutgoingLinks(view);
		case UseCase4EditPart.VISUAL_ID:
			return getUseCase_3012OutgoingLinks(view);
		case Component3EditPart.VISUAL_ID:
			return getComponent_3013OutgoingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3014OutgoingLinks(view);
		case IncludeEditPart.VISUAL_ID:
			return getInclude_4008OutgoingLinks(view);
		case ExtendEditPart.VISUAL_ID:
			return getExtend_4009OutgoingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4010OutgoingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4013OutgoingLinks(view);
		case AbstractionEditPart.VISUAL_ID:
			return getAbstraction_4015OutgoingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4016OutgoingLinks(view);
		case RealizationEditPart.VISUAL_ID:
			return getRealization_4017OutgoingLinks(view);
		case PackageMergeEditPart.VISUAL_ID:
			return getPackageMerge_4018OutgoingLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_4019OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2011ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2012ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2013ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2014ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2015ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2016ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2017ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2018ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDiagram_2019ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3009ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3016ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3015ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3017ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3018ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3010ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3011ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3012ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3013ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_3014ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageMerge_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInclude_4008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtend_4009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4011ContainedLinks(View view) {
		Association modelElement = (Association)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4013ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_4015ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUsage_4016ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRealization_4017ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_4018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_4019ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActor_2011IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2012IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2013IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2014IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2015IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2016IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2017IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2018IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDiagram_2019IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3007IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3008IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3009IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3016IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3015IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3017IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3018IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3010IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3011IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3012IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3013IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_3014IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInclude_4008IncomingLinks(View view) {
		Include modelElement = (Include)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtend_4009IncomingLinks(View view) {
		Extend modelElement = (Extend)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4010IncomingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4011IncomingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4013IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_4015IncomingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUsage_4016IncomingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRealization_4017IncomingLinks(View view) {
		Realization modelElement = (Realization)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_4018IncomingLinks(View view) {
		PackageMerge modelElement = (PackageMerge)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_4019IncomingLinks(View view) {
		PackageImport modelElement = (PackageImport)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2011OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_2012OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2013OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_2014OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_2015OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2016OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_2017OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2018OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDiagram_2019OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3007OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getExtensionPoint_3008OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3009OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3016OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3015OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3017OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3018OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3010OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActor_3011OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUseCase_3012OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComponent_3013OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_3014OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageMerge_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInclude_4008OutgoingLinks(View view) {
		Include modelElement = (Include)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtend_4009OutgoingLinks(View view) {
		Extend modelElement = (Extend)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4010OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4011OutgoingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4013OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAbstraction_4015OutgoingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getUsage_4016OutgoingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRealization_4017OutgoingLinks(View view) {
		Realization modelElement = (Realization)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageMerge_4018OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_4019OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Include_4008(UseCase container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getIncludes().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Include) {
				continue;
			}
			Include link = (Include)linkObject;
			if(IncludeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			UseCase dst = link.getAddition();
			UseCase src = link.getIncludingCase();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Include_4008, IncludeEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Extend_4009(UseCase container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getExtends().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Extend) {
				continue;
			}
			Extend link = (Extend)linkObject;
			if(ExtendEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			UseCase dst = link.getExtendedCase();
			UseCase src = link.getExtension();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Extend_4009, ExtendEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Generalization_4010(Classifier container) {
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
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Generalization_4010, GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4011(Package container) {
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

			// Papyrus GenCode
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4011, AssociationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_4013(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4013, DependencyEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Abstraction_4015(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4015, AbstractionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Usage_4016(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4016, UsageEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Realization_4017(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Realization_4017, RealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_PackageMerge_4018(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.PackageMerge_4018, PackageMergeEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_PackageImport_4019(Namespace container) {
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
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.PackageImport_4019, PackageImportEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Include_4008(UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInclude_Addition() || false == setting.getEObject() instanceof Include) {
				continue;
			}
			Include link = (Include)setting.getEObject();
			if(IncludeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			UseCase src = link.getIncludingCase();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Include_4008, IncludeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Extend_4009(UseCase target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getExtend_ExtendedCase() || false == setting.getEObject() instanceof Extend) {
				continue;
			}
			Extend link = (Extend)setting.getEObject();
			if(ExtendEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			UseCase src = link.getExtension();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Extend_4009, ExtendEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Generalization_4010(Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)setting.getEObject();
			if(GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Generalization_4010, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4011(Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Association_4011, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4012, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_4013(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4013, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4014, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Abstraction_4015(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Abstraction_4015, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Usage_4016(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Usage_4016, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Realization_4017(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Realization_4017, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_PackageMerge_4018(Package target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getPackageMerge_MergedPackage() || false == setting.getEObject() instanceof PackageMerge) {
				continue;
			}
			PackageMerge link = (PackageMerge)setting.getEObject();
			if(PackageMergeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package src = link.getReceivingPackage();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.PackageMerge_4018, PackageMergeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_PackageImport_4019(Package target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
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
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.PackageImport_4019, PackageImportEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Include_4008(UseCase source) {
		UseCase container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof UseCase) {
				container = (UseCase)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getIncludes().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Include) {
				continue;
			}
			Include link = (Include)linkObject;
			if(IncludeEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			UseCase dst = link.getAddition();
			UseCase src = link.getIncludingCase();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Include_4008, IncludeEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Extend_4009(UseCase source) {
		UseCase container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof UseCase) {
				container = (UseCase)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getExtends().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Extend) {
				continue;
			}
			Extend link = (Extend)linkObject;
			if(ExtendEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			UseCase dst = link.getExtendedCase();
			UseCase src = link.getExtension();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Extend_4009, ExtendEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Generalization_4010(Classifier source) {
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
			return Collections.EMPTY_LIST;
		}
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
			Classifier src = link.getSpecific();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Generalization_4010, GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4011(Type source) {
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
			return Collections.EMPTY_LIST;
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

			// Papyrus GenCode
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4011, AssociationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(Constraint source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4012, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_4013(NamedElement source) {
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
			return Collections.EMPTY_LIST;
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4013, DependencyEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(Comment source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4014, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Abstraction_4015(NamedElement source) {
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
			return Collections.EMPTY_LIST;
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4015, AbstractionEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Usage_4016(NamedElement source) {
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
			return Collections.EMPTY_LIST;
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4016, UsageEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Realization_4017(NamedElement source) {
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
			return Collections.EMPTY_LIST;
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Realization_4017, RealizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_PackageMerge_4018(Package source) {
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
			return Collections.EMPTY_LIST;
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.PackageMerge_4018, PackageMergeEditPart.VISUAL_ID));

		}
		return result;
	}

}
