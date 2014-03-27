/*
 * Copyright (c) 2011, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 410909
 *   
 */
package org.eclipse.papyrus.uml.diagram.deployment.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentTarget;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DeploymentDiagramEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			return getModelModelCompartment_51SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_38SemanticChildren(view);
		case DeviceCompositeCompartmentEditPart.VISUAL_ID:
			return getDeviceDeviceCompositeCompartment_17SemanticChildren(view);
		case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
			return getExecutionEnvironmentExecutionEnvironmentCompositeCompartment_18SemanticChildren(view);
		case NodeCompositeCompartmentEditPart.VISUAL_ID:
			return getNodeCompositeCompartment_19SemanticChildren(view);
		case ArtifactCompositeCompartmentEditPart.VISUAL_ID:
			return getArtifactArtifactCompositeCompartment_26SemanticChildren(view);
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getModelModelCompartment_52SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getPackagePackageableElementCompartment_39SemanticChildren(view);
		case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
			return getDeviceDeviceCompositeCompartment_30SemanticChildren(view);
		case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
			return getExecutionEnvironmentExecutionEnvironmentCompositeCompartment_31SemanticChildren(view);
		case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
			return getNodeCompositeCompartment_32SemanticChildren(view);
		case ArtifactCompositeCompartmentEditPartCN.VISUAL_ID:
			return getArtifactArtifactCompositeCompartment_33SemanticChildren(view);
		case ArtifactCompositeCompartmentEditPartACN.VISUAL_ID:
			return getArtifactArtifactCompositeCompartment_34SemanticChildren(view);
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
			if(visualID == ExecutionEnvironmentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ArtifactEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DefaultNamedElementEditPart.VISUAL_ID) {
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
		for(Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getModelModelCompartment_51SemanticChildren(View view) {
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
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedDeviceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedNodeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedArtifactNodeEditPartCN.VISUAL_ID) {
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
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackagePackageableElementCompartment_38SemanticChildren(View view) {
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
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedArtifactNodeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedDeviceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedNodeEditPartCN.VISUAL_ID) {
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
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDeviceDeviceCompositeCompartment_17SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Device modelElement = (Device)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedNodes().iterator(); it.hasNext();) {
			Node childElement = (Node)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getExecutionEnvironmentExecutionEnvironmentCompositeCompartment_18SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ExecutionEnvironment modelElement = (ExecutionEnvironment)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedNodes().iterator(); it.hasNext();) {
			Node childElement = (Node)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getNodeCompositeCompartment_19SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Node modelElement = (Node)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedNodes().iterator(); it.hasNext();) {
			Node childElement = (Node)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DeviceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getArtifactArtifactCompositeCompartment_26SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Artifact modelElement = (Artifact)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedArtifacts().iterator(); it.hasNext();) {
			Artifact childElement = (Artifact)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ArtifactEditPartACN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getModelModelCompartment_52SemanticChildren(View view) {
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
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedDeviceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedNodeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedArtifactNodeEditPartCN.VISUAL_ID) {
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
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getPackagePackageableElementCompartment_39SemanticChildren(View view) {
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
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedArtifactNodeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedDeviceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NestedNodeEditPartCN.VISUAL_ID) {
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
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getDeviceDeviceCompositeCompartment_30SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Device modelElement = (Device)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedNodes().iterator(); it.hasNext();) {
			Node childElement = (Node)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DeviceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getExecutionEnvironmentExecutionEnvironmentCompositeCompartment_31SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ExecutionEnvironment modelElement = (ExecutionEnvironment)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedNodes().iterator(); it.hasNext();) {
			Node childElement = (Node)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getNodeCompositeCompartment_32SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Node modelElement = (Node)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedNodes().iterator(); it.hasNext();) {
			Node childElement = (Node)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DeviceEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ExecutionEnvironmentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == NodeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ArtifactEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getArtifactArtifactCompositeCompartment_33SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Artifact modelElement = (Artifact)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedArtifacts().iterator(); it.hasNext();) {
			Artifact childElement = (Artifact)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ArtifactEditPartACN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLNodeDescriptor> getArtifactArtifactCompositeCompartment_34SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Artifact modelElement = (Artifact)containerView.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for(Iterator<?> it = modelElement.getNestedArtifacts().iterator(); it.hasNext();) {
			Artifact childElement = (Artifact)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ArtifactEditPartACN.VISUAL_ID) {
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
		case DeploymentDiagramEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2011ContainedLinks(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_2010ContainedLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2009ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2005ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2001ContainedLinks(view);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return getExecutionEnvironment_2002ContainedLinks(view);
		case DeviceEditPart.VISUAL_ID:
			return getDevice_2003ContainedLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_2006ContainedLinks(view);
		case NodeEditPart.VISUAL_ID:
			return getNode_2008ContainedLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2012ContainedLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_49ContainedLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_36ContainedLinks(view);
		case DeviceEditPartCN.VISUAL_ID:
			return getDevice_16ContainedLinks(view);
		case NestedDeviceEditPartCN.VISUAL_ID:
			return getDevice_44ContainedLinks(view);
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_21ContainedLinks(view);
		case NestedExecutionEnvironmentEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_46ContainedLinks(view);
		case NodeEditPartCN.VISUAL_ID:
			return getNode_23ContainedLinks(view);
		case NestedNodeEditPartCN.VISUAL_ID:
			return getNode_42ContainedLinks(view);
		case ArtifactEditPartCN.VISUAL_ID:
			return getArtifact_25ContainedLinks(view);
		case ArtifactEditPartACN.VISUAL_ID:
			return getArtifact_28ContainedLinks(view);
		case NestedArtifactNodeEditPartCN.VISUAL_ID:
			return getArtifact_40ContainedLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_54ContainedLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_56ContainedLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4001ContainedLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4002ContainedLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4004ContainedLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4010ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2011IncomingLinks(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_2010IncomingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2009IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2005IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2001IncomingLinks(view);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return getExecutionEnvironment_2002IncomingLinks(view);
		case DeviceEditPart.VISUAL_ID:
			return getDevice_2003IncomingLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_2006IncomingLinks(view);
		case NodeEditPart.VISUAL_ID:
			return getNode_2008IncomingLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2012IncomingLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_49IncomingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_36IncomingLinks(view);
		case DeviceEditPartCN.VISUAL_ID:
			return getDevice_16IncomingLinks(view);
		case NestedDeviceEditPartCN.VISUAL_ID:
			return getDevice_44IncomingLinks(view);
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_21IncomingLinks(view);
		case NestedExecutionEnvironmentEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_46IncomingLinks(view);
		case NodeEditPartCN.VISUAL_ID:
			return getNode_23IncomingLinks(view);
		case NestedNodeEditPartCN.VISUAL_ID:
			return getNode_42IncomingLinks(view);
		case ArtifactEditPartCN.VISUAL_ID:
			return getArtifact_25IncomingLinks(view);
		case ArtifactEditPartACN.VISUAL_ID:
			return getArtifact_28IncomingLinks(view);
		case NestedArtifactNodeEditPartCN.VISUAL_ID:
			return getArtifact_40IncomingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_54IncomingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_56IncomingLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4001IncomingLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4002IncomingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4004IncomingLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4010IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2011OutgoingLinks(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_2010OutgoingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2009OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2005OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2001OutgoingLinks(view);
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return getExecutionEnvironment_2002OutgoingLinks(view);
		case DeviceEditPart.VISUAL_ID:
			return getDevice_2003OutgoingLinks(view);
		case ArtifactEditPart.VISUAL_ID:
			return getArtifact_2006OutgoingLinks(view);
		case NodeEditPart.VISUAL_ID:
			return getNode_2008OutgoingLinks(view);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return getNamedElement_2012OutgoingLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_49OutgoingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_36OutgoingLinks(view);
		case DeviceEditPartCN.VISUAL_ID:
			return getDevice_16OutgoingLinks(view);
		case NestedDeviceEditPartCN.VISUAL_ID:
			return getDevice_44OutgoingLinks(view);
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_21OutgoingLinks(view);
		case NestedExecutionEnvironmentEditPartCN.VISUAL_ID:
			return getExecutionEnvironment_46OutgoingLinks(view);
		case NodeEditPartCN.VISUAL_ID:
			return getNode_23OutgoingLinks(view);
		case NestedNodeEditPartCN.VISUAL_ID:
			return getNode_42OutgoingLinks(view);
		case ArtifactEditPartCN.VISUAL_ID:
			return getArtifact_25OutgoingLinks(view);
		case ArtifactEditPartACN.VISUAL_ID:
			return getArtifact_28OutgoingLinks(view);
		case NestedArtifactNodeEditPartCN.VISUAL_ID:
			return getArtifact_40OutgoingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_54OutgoingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_56OutgoingLinks(view);
		case DeploymentEditPart.VISUAL_ID:
			return getDeployment_4001OutgoingLinks(view);
		case ManifestationEditPart.VISUAL_ID:
			return getManifestation_4002OutgoingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4003OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4004OutgoingLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4010OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_2011ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_2010ContainedLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_2009ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2001ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2005ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_2002ContainedLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_2003ContainedLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_2006ContainedLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_2008ContainedLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2012ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_49ContainedLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_36ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_23ContainedLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_42ContainedLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_16ContainedLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_44ContainedLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_21ContainedLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_46ContainedLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_25ContainedLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_28ContainedLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_40ContainedLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_54ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_56ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeployment_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4002ContainedLinks(View view) {
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
	public static List<UMLLinkDescriptor> getDependency_4004ContainedLinks(View view) {
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
	public static List<UMLLinkDescriptor> getDependency_2011IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_2010IncomingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_2009IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2001IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2005IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_2002IncomingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_2003IncomingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_2006IncomingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_2008IncomingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2012IncomingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_49IncomingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_36IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_23IncomingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_42IncomingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_16IncomingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_44IncomingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_21IncomingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_46IncomingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_25IncomingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_28IncomingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_40IncomingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4003(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_54IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_56IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeployment_4001IncomingLinks(View view) {
		Deployment modelElement = (Deployment)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4002IncomingLinks(View view) {
		Manifestation modelElement = (Manifestation)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getGeneralization_4003IncomingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4004IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		CrossReferenceAdapter crossReferencer = CrossReferenceAdapter.getCrossReferenceAdapter(view.eResource().getResourceSet());
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement, crossReferencer));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Deployment_4001(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Manifestation_4002(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferencer));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4010(modelElement, crossReferencer));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_2011OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_2010OutgoingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_2009OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_2001OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_2005OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_2002OutgoingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_2003OutgoingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_2006OutgoingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_2008OutgoingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNamedElement_2012OutgoingLinks(View view) {
		NamedElement modelElement = (NamedElement)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getModel_49OutgoingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getPackage_36OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_23OutgoingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getNode_42OutgoingLinks(View view) {
		Node modelElement = (Node)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_16OutgoingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDevice_44OutgoingLinks(View view) {
		Device modelElement = (Device)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_21OutgoingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getExecutionEnvironment_46OutgoingLinks(View view) {
		ExecutionEnvironment modelElement = (ExecutionEnvironment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_25OutgoingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_28OutgoingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getArtifact_40OutgoingLinks(View view) {
		Artifact modelElement = (Artifact)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Generalization_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getComment_54OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getConstraint_56OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDeployment_4001OutgoingLinks(View view) {
		Deployment modelElement = (Deployment)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getManifestation_4002OutgoingLinks(View view) {
		Manifestation modelElement = (Manifestation)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
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
	public static List<UMLLinkDescriptor> getDependency_4004OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<UMLLinkDescriptor> getDependency_4010OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Deployment_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Manifestation_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Deployment_4001(DeploymentTarget container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getDeployments().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment)linkObject;
			if(DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Deployment_4001, DeploymentEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Manifestation_4002(Artifact container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getManifestations().iterator(); links.hasNext();) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Manifestation_4002, ManifestationEditPart.VISUAL_ID));

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
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4004(Package container) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4004, DependencyEditPart.VISUAL_ID));

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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4010, DependencyBranchEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(Element target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4008, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4009(Element target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Deployment_4001(NamedElement target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment)setting.getEObject();
			if(DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();

			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Deployment_4001, DeploymentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Manifestation_4002(NamedElement target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Manifestation_4002, ManifestationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Generalization_4003(Classifier target, CrossReferenceAdapter crossReferencer) {
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Generalization_4003, GeneralizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4004(NamedElement target, CrossReferenceAdapter crossReferencer) {
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4004, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4010(NamedElement target, CrossReferenceAdapter crossReferencer) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
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
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4010, DependencyBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4008(Comment source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4008, CommentAnnotatedElementEditPart.VISUAL_ID));
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
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Deployment_4001(NamedElement source) {
		DeploymentTarget container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof DeploymentTarget) {
				container = (DeploymentTarget)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getDeployments().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Deployment) {
				continue;
			}
			Deployment link = (Deployment)linkObject;
			if(DeploymentEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Deployment_4001, DeploymentEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Manifestation_4002(NamedElement source) {
		Artifact container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Artifact) {
				container = (Artifact)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getManifestations().iterator(); links.hasNext();) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Manifestation_4002, ManifestationEditPart.VISUAL_ID));

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
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4004(NamedElement source) {
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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4004, DependencyEditPart.VISUAL_ID));

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
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4010, DependencyBranchEditPart.VISUAL_ID));

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
