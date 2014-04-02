/*****************************************************************************
 * Copyright (c) 2009, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 410909
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentUsecases2EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentUsecases3EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DefaultNamedElementEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtensionPointInRectangleEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShapeNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectComponentUsecasesEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCasePointsInRectangleEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
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
	public static List<UMLNodeDescriptor> getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case UseCaseDiagramEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		case UseCasePointsEditPartTN.VISUAL_ID:
			return getUseCasePoints_7009SemanticChildren(view);
		case UseCasePointsInRectangleEditPart.VISUAL_ID:
			return getUseCasePoints_7010SemanticChildren(view);
		case SubjectComponentUsecasesEditPart.VISUAL_ID:
			return getClassifierUsecases_7011SemanticChildren(view);
		case UseCasePointsInComponentEditPart.VISUAL_ID:
			return getUseCasePoints_7012SemanticChildren(view);
		case ComponentUsecases2EditPart.VISUAL_ID:
			return getComponentUsecases_7017SemanticChildren(view);
		case UseCasePointsInPackageEditPart.VISUAL_ID:
			return getUseCasePoints_7014SemanticChildren(view);
		case ComponentUsecases3EditPart.VISUAL_ID:
			return getComponentUsecases_7015SemanticChildren(view);
		case PackagePackageableElementCompartment2EditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7016SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7013SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getUseCasePoints_7009SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		UseCase modelElement = (UseCase)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getUseCasePoints_7010SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		UseCase modelElement = (UseCase)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
			ExtensionPoint childElement = (ExtensionPoint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExtensionPointInRectangleEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getClassifierUsecases_7011SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Classifier modelElement = (Classifier)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getUseCases().iterator(); it.hasNext();) {
			UseCase childElement = (UseCase)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == UseCaseInComponentEditPart.VISUAL_ID) {
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
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintInComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getUseCasePoints_7012SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		UseCase modelElement = (UseCase)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getComponentUsecases_7017SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getUseCases().iterator(); it.hasNext();) {
			UseCase childElement = (UseCase)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == UseCaseInComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ComponentInComponentEditPart.VISUAL_ID) {
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
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintInComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActorInComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackagePackageableElementCompartment_7013SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Package modelElement = (Package)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintInPackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActorInPackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseInPackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentInPackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedPackages().iterator(); it.hasNext();) {
			Package childElement = (Package)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PackageEditPartCN.VISUAL_ID) {
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
	public static List<UMLNodeDescriptor> getUseCasePoints_7014SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		UseCase modelElement = (UseCase)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getExtensionPoints().iterator(); it.hasNext();) {
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
	public static List<UMLNodeDescriptor> getComponentUsecases_7015SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Component modelElement = (Component)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getUseCases().iterator(); it.hasNext();) {
			UseCase childElement = (UseCase)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == UseCaseInComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ComponentInComponentEditPart.VISUAL_ID) {
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
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintInComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActorInComponentEditPart.VISUAL_ID) {
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
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintInPackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActorInPackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseInPackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentInPackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedPackages().iterator(); it.hasNext();) {
			Package childElement = (Package)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PackageEditPartCN.VISUAL_ID) {
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
	public static List<UMLNodeDescriptor> getPackage_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActorEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActorAsRectangleEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == UseCaseAsRectangleEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == SubjectClassifierEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PackageEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DefaultNamedElementEditPartTN.VISUAL_ID) {
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
			if(visualID == CommentEditPartTN.VISUAL_ID) {
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
	private static Iterator<EObject> getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case UseCaseDiagramEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case ActorEditPartTN.VISUAL_ID:
			return getActor_2011ContainedLinks(view);
		case ActorAsRectangleEditPartTN.VISUAL_ID:
			return getActor_2012ContainedLinks(view);
		case UseCaseEditPartTN.VISUAL_ID:
			return getUseCase_2013ContainedLinks(view);
		case UseCaseAsRectangleEditPartTN.VISUAL_ID:
			return getUseCase_2014ContainedLinks(view);
		case SubjectClassifierEditPartTN.VISUAL_ID:
			return getClassifier_2015ContainedLinks(view);
		case PackageEditPartTN.VISUAL_ID:
			return getPackage_2016ContainedLinks(view);
		case ConstraintEditPartTN.VISUAL_ID:
			return getConstraint_2017ContainedLinks(view);
		case CommentEditPartTN.VISUAL_ID:
			return getComment_2018ContainedLinks(view);
		case DefaultNamedElementEditPartTN.VISUAL_ID:
			return getNamedElement_2022ContainedLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2023ContainedLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2019ContainedLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3007ContainedLinks(view);
		case ExtensionPointInRectangleEditPart.VISUAL_ID:
			return getExtensionPoint_3008ContainedLinks(view);
		case UseCaseInComponentEditPart.VISUAL_ID:
			return getUseCase_3009ContainedLinks(view);
		case ComponentInComponentEditPart.VISUAL_ID:
			return getComponent_3016ContainedLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3015ContainedLinks(view);
		case ConstraintInComponentEditPart.VISUAL_ID:
			return getConstraint_3017ContainedLinks(view);
		case ActorInComponentEditPart.VISUAL_ID:
			return getActor_3018ContainedLinks(view);
		case ConstraintInPackageEditPart.VISUAL_ID:
			return getConstraint_3010ContainedLinks(view);
		case ActorInPackageEditPart.VISUAL_ID:
			return getActor_3011ContainedLinks(view);
		case UseCaseInPackageEditPart.VISUAL_ID:
			return getUseCase_3012ContainedLinks(view);
		case ComponentInPackageEditPart.VISUAL_ID:
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
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActorEditPartTN.VISUAL_ID:
			return getActor_2011IncomingLinks(view);
		case ActorAsRectangleEditPartTN.VISUAL_ID:
			return getActor_2012IncomingLinks(view);
		case UseCaseEditPartTN.VISUAL_ID:
			return getUseCase_2013IncomingLinks(view);
		case UseCaseAsRectangleEditPartTN.VISUAL_ID:
			return getUseCase_2014IncomingLinks(view);
		case SubjectClassifierEditPartTN.VISUAL_ID:
			return getClassifier_2015IncomingLinks(view);
		case PackageEditPartTN.VISUAL_ID:
			return getPackage_2016IncomingLinks(view);
		case ConstraintEditPartTN.VISUAL_ID:
			return getConstraint_2017IncomingLinks(view);
		case CommentEditPartTN.VISUAL_ID:
			return getComment_2018IncomingLinks(view);
		case DefaultNamedElementEditPartTN.VISUAL_ID:
			return getNamedElement_2022IncomingLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2023IncomingLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2019IncomingLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3007IncomingLinks(view);
		case ExtensionPointInRectangleEditPart.VISUAL_ID:
			return getExtensionPoint_3008IncomingLinks(view);
		case UseCaseInComponentEditPart.VISUAL_ID:
			return getUseCase_3009IncomingLinks(view);
		case ComponentInComponentEditPart.VISUAL_ID:
			return getComponent_3016IncomingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3015IncomingLinks(view);
		case ConstraintInComponentEditPart.VISUAL_ID:
			return getConstraint_3017IncomingLinks(view);
		case ActorInComponentEditPart.VISUAL_ID:
			return getActor_3018IncomingLinks(view);
		case ConstraintInPackageEditPart.VISUAL_ID:
			return getConstraint_3010IncomingLinks(view);
		case ActorInPackageEditPart.VISUAL_ID:
			return getActor_3011IncomingLinks(view);
		case UseCaseInPackageEditPart.VISUAL_ID:
			return getUseCase_3012IncomingLinks(view);
		case ComponentInPackageEditPart.VISUAL_ID:
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
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActorEditPartTN.VISUAL_ID:
			return getActor_2011OutgoingLinks(view);
		case ActorAsRectangleEditPartTN.VISUAL_ID:
			return getActor_2012OutgoingLinks(view);
		case UseCaseEditPartTN.VISUAL_ID:
			return getUseCase_2013OutgoingLinks(view);
		case UseCaseAsRectangleEditPartTN.VISUAL_ID:
			return getUseCase_2014OutgoingLinks(view);
		case SubjectClassifierEditPartTN.VISUAL_ID:
			return getClassifier_2015OutgoingLinks(view);
		case PackageEditPartTN.VISUAL_ID:
			return getPackage_2016OutgoingLinks(view);
		case ConstraintEditPartTN.VISUAL_ID:
			return getConstraint_2017OutgoingLinks(view);
		case CommentEditPartTN.VISUAL_ID:
			return getComment_2018OutgoingLinks(view);
		case DefaultNamedElementEditPartTN.VISUAL_ID:
			return getNamedElement_2022OutgoingLinks(view);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2023OutgoingLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2019OutgoingLinks(view);
		case ExtensionPointEditPart.VISUAL_ID:
			return getExtensionPoint_3007OutgoingLinks(view);
		case ExtensionPointInRectangleEditPart.VISUAL_ID:
			return getExtensionPoint_3008OutgoingLinks(view);
		case UseCaseInComponentEditPart.VISUAL_ID:
			return getUseCase_3009OutgoingLinks(view);
		case ComponentInComponentEditPart.VISUAL_ID:
			return getComponent_3016OutgoingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_3015OutgoingLinks(view);
		case ConstraintInComponentEditPart.VISUAL_ID:
			return getConstraint_3017OutgoingLinks(view);
		case ActorInComponentEditPart.VISUAL_ID:
			return getActor_3018OutgoingLinks(view);
		case ConstraintInPackageEditPart.VISUAL_ID:
			return getConstraint_3010OutgoingLinks(view);
		case ActorInPackageEditPart.VISUAL_ID:
			return getActor_3011OutgoingLinks(view);
		case UseCaseInPackageEditPart.VISUAL_ID:
			return getUseCase_3012OutgoingLinks(view);
		case ComponentInPackageEditPart.VISUAL_ID:
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
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getActor_2011ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_2012ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_2013ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_2014ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClassifier_2015ContainedLinks(View view) {
		Classifier modelElement = (Classifier)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_2016ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getConstraint_2017ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2018ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDiagram_2019ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2022ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2023ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtensionPoint_3007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtensionPoint_3008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_3009ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3016ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3015ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3017ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_3018ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3010ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_3011ContainedLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_3012ContainedLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Include_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Extend_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3013ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3014ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getInclude_4008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtend_4009ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4010ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4011ContainedLinks(View view) {
		Association modelElement = (Association)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4016ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageMerge_4018ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageImport_4019ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_2011IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_2012IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_2013IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4008(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_2014IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4008(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getClassifier_2015IncomingLinks(View view) {
		Classifier modelElement = (Classifier)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_2016IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4018(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4019(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2017IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2018IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDiagram_2019IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2022IncomingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2023IncomingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtensionPoint_3007IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtensionPoint_3008IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_3009IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4008(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3016IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3015IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3017IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_3018IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3010IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_3011IncomingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_3012IncomingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Include_4008(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Extend_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3013IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3014IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_PackageMerge_4018(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_4019(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInclude_4008IncomingLinks(View view) {
		Include modelElement = (Include)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtend_4009IncomingLinks(View view) {
		Extend modelElement = (Extend)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4010IncomingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4011IncomingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4010(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4013IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4015IncomingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4016IncomingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4017IncomingLinks(View view) {
		Realization modelElement = (Realization)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4013(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4015(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4016(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Realization_4017(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageMerge_4018IncomingLinks(View view) {
		PackageMerge modelElement = (PackageMerge)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageImport_4019IncomingLinks(View view) {
		PackageImport modelElement = (PackageImport)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getActor_2011OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getActor_2012OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getUseCase_2013OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getUseCase_2014OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getClassifier_2015OutgoingLinks(View view) {
		Classifier modelElement = (Classifier)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getPackage_2016OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getConstraint_2017OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getComment_2018OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDiagram_2019OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2022OutgoingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2023OutgoingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtensionPoint_3007OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtensionPoint_3008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUseCase_3009OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getComponent_3016OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getComment_3015OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3017OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getActor_3018OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getConstraint_3010OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getActor_3011OutgoingLinks(View view) {
		Actor modelElement = (Actor)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getUseCase_3012OutgoingLinks(View view) {
		UseCase modelElement = (UseCase)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getComponent_3013OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getPackage_3014OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getInclude_4008OutgoingLinks(View view) {
		Include modelElement = (Include)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExtend_4009OutgoingLinks(View view) {
		Extend modelElement = (Extend)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4010OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAssociation_4011OutgoingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
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
	public static List<UMLLinkDescriptor> getDependency_4013OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4015OutgoingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4016OutgoingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getRealization_4017OutgoingLinks(View view) {
		Realization modelElement = (Realization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Realization_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageMerge_4018OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackageImport_4019OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Include_4008(UseCase container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Extend_4009(UseCase container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Generalization_4010(Classifier container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Association_4011(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4011, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4013(Package container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Abstraction_4015(Package container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Usage_4016(Package container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Realization_4017(Package container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_PackageMerge_4018(Package container) {
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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_PackageImport_4019(Namespace container) {
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
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Include_4008(UseCase target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for(EStructuralFeature.Setting setting : settings) {
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
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Extend_4009(UseCase target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for(EStructuralFeature.Setting setting : settings) {
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
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Generalization_4010(Classifier target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for(EStructuralFeature.Setting setting : settings) {
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
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4011(Type target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Association_4011, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(Element target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4012, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4013(NamedElement target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4013, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(Element target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4014, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Abstraction_4015(NamedElement target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Abstraction_4015, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Usage_4016(NamedElement target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Usage_4016, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Realization_4017(NamedElement target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Realization_4017, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_PackageMerge_4018(Package target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for(EStructuralFeature.Setting setting : settings) {
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
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_PackageImport_4019(Package target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.PackageImport_4019, PackageImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Include_4008(UseCase source) {
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
			return Collections.emptyList();
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
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Extend_4009(UseCase source) {
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
			return Collections.emptyList();
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
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Generalization_4010(Classifier source) {
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
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4011(Type source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4011, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(Constraint source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4012, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4013(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4013, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4014(Comment source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4014, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Abstraction_4015(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4015, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Usage_4016(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4016, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Realization_4017(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Realization_4017, RealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_PackageMerge_4018(Package source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.PackageMerge_4018, PackageMergeEditPart.VISUAL_ID));
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
