/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Amine EL KOUHEN (CEA LIST/LIFL) & Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
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
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceOperationCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.OperationForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PropertyForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ReceptionInInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPartCN;
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
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
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
		switch(UMLVisualIDRegistry.getVisualID(view)) {
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
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			return getModelModelElementCompartment_7006SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_7002SemanticChildren(view);
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getModelModelElementCompartment_7007SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getPackagePackageableElementCompartment_7005SemanticChildren(view);
		case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
			return getComponentCompositeCompartmentCN_7003SemanticChildren(view);
		case ComponentCompositeCompartmentEditPartPCN.VISUAL_ID:
			return getComponentCompositeCompartmentPCN_7004SemanticChildren(view);
		case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			return getInterfaceAttributeCompartment_7008SemanticChildren(view);
		case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			return getInterfaceOperationCompartment_7009SemanticChildren(view);
		case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
			return getInterfaceAttributeCompartment_7010SemanticChildren(view);
		case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
			return getInterfaceOperationCompartment_7011SemanticChildren(view);
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
			if(visualID == ModelEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == RectangleInterfaceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DefaultNamedElementEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ComponentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPart.VISUAL_ID) {
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
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
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
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_3070SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponent_3071SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PortEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentCompositeCompartment_7001SemanticChildren(View view) {
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
			if(visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getModelModelElementCompartment_7006SemanticChildren(View view) {
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
			if(visualID == RectangleInterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackagePackageableElementCompartment_7002SemanticChildren(View view) {
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
			if(visualID == RectangleInterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getModelModelElementCompartment_7007SemanticChildren(View view) {
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
			if(visualID == RectangleInterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackagePackageableElementCompartment_7005SemanticChildren(View view) {
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
			if(visualID == RectangleInterfaceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ComponentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InterfaceEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPartPCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentCompositeCompartmentCN_7003SemanticChildren(View view) {
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
			if(visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getComponentCompositeCompartmentPCN_7004SemanticChildren(View view) {
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
			if(visualID == ComponentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getInterfaceAttributeCompartment_7008SemanticChildren(View view) {
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
	public static List<UMLNodeDescriptor> getInterfaceOperationCompartment_7009SemanticChildren(View view) {
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
			if(visualID == OperationForInterfaceEditPart.VISUAL_ID) {
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
	public static List<UMLNodeDescriptor> getInterfaceAttributeCompartment_7010SemanticChildren(View view) {
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
	public static List<UMLNodeDescriptor> getInterfaceOperationCompartment_7011SemanticChildren(View view) {
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
			if(visualID == OperationForInterfaceEditPart.VISUAL_ID) {
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
	public static List<UMLLinkDescriptor> getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_3203ContainedLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002ContainedLinks(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_3202ContainedLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_3200ContainedLinks(view);
		case RectangleInterfaceEditPart.VISUAL_ID:
			return getInterface_3205ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3201ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3199ContainedLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_3204ContainedLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getNamedElement_2003ContainedLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069ContainedLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_3077ContainedLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3076ContainedLinks(view);
		case RectangleInterfaceEditPartCN.VISUAL_ID:
			return getInterface_3078ContainedLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3070ContainedLinks(view);
		case ComponentEditPartPCN.VISUAL_ID:
			return getComponent_3071ContainedLinks(view);
		case CommentEditPartPCN.VISUAL_ID:
			return getComment_3074ContainedLinks(view);
		case ConstraintEditPartPCN.VISUAL_ID:
			return getConstraint_3075ContainedLinks(view);
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return getProperty_1ContainedLinks(view);
		case OperationForInterfaceEditPart.VISUAL_ID:
			return getOperation_5ContainedLinks(view);
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return getReception_6ContainedLinks(view);
		case InterfaceEditPartPCN.VISUAL_ID:
			return getInterface_3072ContainedLinks(view);
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
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4017ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_3203IncomingLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002IncomingLinks(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_3202IncomingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_3200IncomingLinks(view);
		case RectangleInterfaceEditPart.VISUAL_ID:
			return getInterface_3205IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3201IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3199IncomingLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_3204IncomingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getNamedElement_2003IncomingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069IncomingLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_3077IncomingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3076IncomingLinks(view);
		case RectangleInterfaceEditPartCN.VISUAL_ID:
			return getInterface_3078IncomingLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3070IncomingLinks(view);
		case ComponentEditPartPCN.VISUAL_ID:
			return getComponent_3071IncomingLinks(view);
		case CommentEditPartPCN.VISUAL_ID:
			return getComment_3074IncomingLinks(view);
		case ConstraintEditPartPCN.VISUAL_ID:
			return getConstraint_3075IncomingLinks(view);
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return getProperty_1IncomingLinks(view);
		case OperationForInterfaceEditPart.VISUAL_ID:
			return getOperation_5IncomingLinks(view);
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return getReception_6IncomingLinks(view);
		case InterfaceEditPartPCN.VISUAL_ID:
			return getInterface_3072IncomingLinks(view);
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
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4017IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_3203OutgoingLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2002OutgoingLinks(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_3202OutgoingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_3200OutgoingLinks(view);
		case RectangleInterfaceEditPart.VISUAL_ID:
			return getInterface_3205OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3201OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3199OutgoingLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_3204OutgoingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getNamedElement_2003OutgoingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3069OutgoingLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_3077OutgoingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_3076OutgoingLinks(view);
		case RectangleInterfaceEditPartCN.VISUAL_ID:
			return getInterface_3078OutgoingLinks(view);
		case ComponentEditPartCN.VISUAL_ID:
			return getComponent_3070OutgoingLinks(view);
		case ComponentEditPartPCN.VISUAL_ID:
			return getComponent_3071OutgoingLinks(view);
		case CommentEditPartPCN.VISUAL_ID:
			return getComment_3074OutgoingLinks(view);
		case ConstraintEditPartPCN.VISUAL_ID:
			return getConstraint_3075OutgoingLinks(view);
		case PropertyForInterfaceEditPart.VISUAL_ID:
			return getProperty_1OutgoingLinks(view);
		case OperationForInterfaceEditPart.VISUAL_ID:
			return getOperation_5OutgoingLinks(view);
		case ReceptionInInterfaceEditPart.VISUAL_ID:
			return getReception_6OutgoingLinks(view);
		case InterfaceEditPartPCN.VISUAL_ID:
			return getInterface_3072OutgoingLinks(view);
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
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4017OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_3203ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_3202ContainedLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3200ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3201ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3199ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3205ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_3204ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2003ContainedLinks(View view) {
		return Collections.emptyList();
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
	public static List<UMLLinkDescriptor> getModel_3077ContainedLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3076ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3078ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3070ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3071ContainedLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3072ContainedLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3074ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3075ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_1ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_5ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_6ContainedLinks(View view) {
		return Collections.emptyList();
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
	public static List<UMLLinkDescriptor> getInterfaceRealization_4006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4012ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_3203IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_3202IncomingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3200IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3201IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3199IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3205IncomingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_3204IncomingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2003IncomingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPort_3069IncomingLinks(View view) {
		Port modelElement = (Port)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_3077IncomingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3076IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3078IncomingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3070IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3071IncomingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3072IncomingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3074IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3075IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_1IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_5IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_6IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4001IncomingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4006IncomingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4003IncomingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4012IncomingLinks(View view) {
		Substitution modelElement = (Substitution)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4014IncomingLinks(View view) {
		Manifestation modelElement = (Manifestation)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4007IncomingLinks(View view) {
		ComponentRealization modelElement = (ComponentRealization)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4013IncomingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4017IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Substitution_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ComponentRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Abstraction_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_3203OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_2002OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_3202OutgoingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3200OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3201OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3199OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3205OutgoingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_3204OutgoingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2003OutgoingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPort_3069OutgoingLinks(View view) {
		Port modelElement = (Port)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_3077OutgoingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_3076OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3078OutgoingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3070OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponent_3071OutgoingLinks(View view) {
		Component modelElement = (Component)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterface_3072OutgoingLinks(View view) {
		Interface modelElement = (Interface)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_3074OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_3075OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getProperty_1OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOperation_5OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getReception_6OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getUsage_4001OutgoingLinks(View view) {
		Usage modelElement = (Usage)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getInterfaceRealization_4006OutgoingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getSubstitution_4012OutgoingLinks(View view) {
		Substitution modelElement = (Substitution)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4014OutgoingLinks(View view) {
		Manifestation modelElement = (Manifestation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComponentRealization_4007OutgoingLinks(View view) {
		ComponentRealization modelElement = (ComponentRealization)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getAbstraction_4013OutgoingLinks(View view) {
		Abstraction modelElement = (Abstraction)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4017OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Substitution_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ComponentRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Abstraction_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Usage_4001(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4001, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InterfaceRealization_4006(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)linkObject;
			if(InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Interface dst = link.getContract();
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InterfaceRealization_4006, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Generalization_4003(Classifier container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Generalization_4003, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Substitution_4012(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)linkObject;
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Substitution_4012, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Manifestation_4014(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation)linkObject;
			if(ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Manifestation_4014, ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_ComponentRealization_4007(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization)linkObject;
			if(ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ComponentRealization_4007, ComponentRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Abstraction_4013(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4013, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4010(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4010, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4017(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4017, DependencyBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Usage_4001(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Usage_4001, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_InterfaceRealization_4006(Interface target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.InterfaceRealization_4006, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Generalization_4003(Classifier target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
			Classifier src = link.getSpecific();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Generalization_4003, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Substitution_4012(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)setting.getEObject();
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Substitution_4012, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Manifestation_4014(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation)setting.getEObject();
			if(ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Manifestation_4014, ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_ComponentRealization_4007(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization)setting.getEObject();
			if(ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.ComponentRealization_4007, ComponentRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Abstraction_4013(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Abstraction_4013, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4015, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4009, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4010(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4010, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4017(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4017, DependencyBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Usage_4001(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4001, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_InterfaceRealization_4006(NamedElement source) {
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
			if(false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)linkObject;
			if(InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Interface dst = link.getContract();
			List sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.InterfaceRealization_4006, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Generalization_4003(Classifier source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Generalization_4003, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Substitution_4012(NamedElement source) {
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
			if(false == linkObject instanceof Substitution) {
				continue;
			}
			Substitution link = (Substitution)linkObject;
			if(SubstitutionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Substitution_4012, SubstitutionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Manifestation_4014(NamedElement source) {
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
			if(false == linkObject instanceof Manifestation) {
				continue;
			}
			Manifestation link = (Manifestation)linkObject;
			if(ManifestationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Manifestation_4014, ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_ComponentRealization_4007(NamedElement source) {
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
			if(false == linkObject instanceof ComponentRealization) {
				continue;
			}
			ComponentRealization link = (ComponentRealization)linkObject;
			if(ComponentRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ComponentRealization_4007, ComponentRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Abstraction_4013(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Abstraction_4013, AbstractionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4015(Comment source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4015, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(Constraint source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4009, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4010(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4010, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4017(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4017, DependencyBranchEditPart.VISUAL_ID));
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
