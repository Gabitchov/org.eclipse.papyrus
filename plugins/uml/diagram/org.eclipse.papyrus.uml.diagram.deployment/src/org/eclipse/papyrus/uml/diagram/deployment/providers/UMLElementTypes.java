/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.deployment.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
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
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.LinkDescriptorEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLElementTypes {

	/**
	 * @generated
	 */
	private UMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Package_1000 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Package_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_2011 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Dependency_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_2010 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Model_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_2009 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Package_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_2005 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Constraint_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_2001 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Comment_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExecutionEnvironment_2002 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.ExecutionEnvironment_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Device_2003 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Device_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Artifact_2006 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Artifact_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_2008 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Node_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedElement_2012 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.NamedElement_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_49 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Model_49"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Package_36 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Package_36"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Device_16 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Device_16"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Device_44 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Device_44"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExecutionEnvironment_21 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.ExecutionEnvironment_21"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExecutionEnvironment_46 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.ExecutionEnvironment_46"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_23 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Node_23"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Node_42 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Node_42"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Artifact_25 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Artifact_25"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Artifact_28 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Artifact_28"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Artifact_40 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Artifact_40"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_54 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Comment_54"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constraint_56 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Constraint_56"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Link_4005 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Link_4005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4008 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.CommentAnnotatedElement_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintConstrainedElement_4009 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.ConstraintConstrainedElement_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Deployment_4001 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Deployment_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Manifestation_4002 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Manifestation_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Generalization_4003 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Generalization_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4004 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Dependency_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4010 = getElementType("org.eclipse.papyrus.uml.diagram.deployment.Dependency_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static synchronized ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if(elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();
			elements.put(Package_1000, UMLPackage.eINSTANCE.getPackage());
			elements.put(Dependency_2011, UMLPackage.eINSTANCE.getDependency());
			elements.put(Model_2010, UMLPackage.eINSTANCE.getModel());
			elements.put(Package_2009, UMLPackage.eINSTANCE.getPackage());
			elements.put(Constraint_2005, UMLPackage.eINSTANCE.getConstraint());
			elements.put(Comment_2001, UMLPackage.eINSTANCE.getComment());
			elements.put(ExecutionEnvironment_2002, UMLPackage.eINSTANCE.getExecutionEnvironment());
			elements.put(Device_2003, UMLPackage.eINSTANCE.getDevice());
			elements.put(Artifact_2006, UMLPackage.eINSTANCE.getArtifact());
			elements.put(Node_2008, UMLPackage.eINSTANCE.getNode());
			elements.put(NamedElement_2012, UMLPackage.eINSTANCE.getNamedElement());
			elements.put(Model_49, UMLPackage.eINSTANCE.getModel());
			elements.put(Package_36, UMLPackage.eINSTANCE.getPackage());
			elements.put(Device_16, UMLPackage.eINSTANCE.getDevice());
			elements.put(Device_44, UMLPackage.eINSTANCE.getDevice());
			elements.put(ExecutionEnvironment_21, UMLPackage.eINSTANCE.getExecutionEnvironment());
			elements.put(ExecutionEnvironment_46, UMLPackage.eINSTANCE.getExecutionEnvironment());
			elements.put(Node_23, UMLPackage.eINSTANCE.getNode());
			elements.put(Node_42, UMLPackage.eINSTANCE.getNode());
			elements.put(Artifact_25, UMLPackage.eINSTANCE.getArtifact());
			elements.put(Artifact_28, UMLPackage.eINSTANCE.getArtifact());
			elements.put(Artifact_40, UMLPackage.eINSTANCE.getArtifact());
			elements.put(Comment_54, UMLPackage.eINSTANCE.getComment());
			elements.put(Constraint_56, UMLPackage.eINSTANCE.getConstraint());
			elements.put(CommentAnnotatedElement_4008, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
			elements.put(ConstraintConstrainedElement_4009, UMLPackage.eINSTANCE.getConstraint_ConstrainedElement());
			elements.put(Deployment_4001, UMLPackage.eINSTANCE.getDeployment());
			elements.put(Manifestation_4002, UMLPackage.eINSTANCE.getManifestation());
			elements.put(Generalization_4003, UMLPackage.eINSTANCE.getGeneralization());
			elements.put(Dependency_4004, UMLPackage.eINSTANCE.getDependency());
			elements.put(Dependency_4010, UMLPackage.eINSTANCE.getDependency());
		}
		return (ENamedElement)elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static synchronized boolean isKnownElementType(IElementType elementType) {
		if(KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Package_1000);
			KNOWN_ELEMENT_TYPES.add(Dependency_2011);
			KNOWN_ELEMENT_TYPES.add(Model_2010);
			KNOWN_ELEMENT_TYPES.add(Package_2009);
			KNOWN_ELEMENT_TYPES.add(Constraint_2005);
			KNOWN_ELEMENT_TYPES.add(Comment_2001);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_2002);
			KNOWN_ELEMENT_TYPES.add(Device_2003);
			KNOWN_ELEMENT_TYPES.add(Artifact_2006);
			KNOWN_ELEMENT_TYPES.add(Node_2008);
			KNOWN_ELEMENT_TYPES.add(NamedElement_2012);
			KNOWN_ELEMENT_TYPES.add(Model_49);
			KNOWN_ELEMENT_TYPES.add(Package_36);
			KNOWN_ELEMENT_TYPES.add(Device_16);
			KNOWN_ELEMENT_TYPES.add(Device_44);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_21);
			KNOWN_ELEMENT_TYPES.add(ExecutionEnvironment_46);
			KNOWN_ELEMENT_TYPES.add(Node_23);
			KNOWN_ELEMENT_TYPES.add(Node_42);
			KNOWN_ELEMENT_TYPES.add(Artifact_25);
			KNOWN_ELEMENT_TYPES.add(Artifact_28);
			KNOWN_ELEMENT_TYPES.add(Artifact_40);
			KNOWN_ELEMENT_TYPES.add(Comment_54);
			KNOWN_ELEMENT_TYPES.add(Constraint_56);
			KNOWN_ELEMENT_TYPES.add(Link_4005);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4008);
			KNOWN_ELEMENT_TYPES.add(ConstraintConstrainedElement_4009);
			KNOWN_ELEMENT_TYPES.add(Deployment_4001);
			KNOWN_ELEMENT_TYPES.add(Manifestation_4002);
			KNOWN_ELEMENT_TYPES.add(Generalization_4003);
			KNOWN_ELEMENT_TYPES.add(Dependency_4004);
			KNOWN_ELEMENT_TYPES.add(Dependency_4010);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case DeploymentDiagramEditPart.VISUAL_ID:
			return Package_1000;
		case DependencyNodeEditPart.VISUAL_ID:
			return Dependency_2011;
		case ModelEditPart.VISUAL_ID:
			return Model_2010;
		case PackageEditPart.VISUAL_ID:
			return Package_2009;
		case ConstraintEditPart.VISUAL_ID:
			return Constraint_2005;
		case CommentEditPart.VISUAL_ID:
			return Comment_2001;
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			return ExecutionEnvironment_2002;
		case DeviceEditPart.VISUAL_ID:
			return Device_2003;
		case ArtifactEditPart.VISUAL_ID:
			return Artifact_2006;
		case NodeEditPart.VISUAL_ID:
			return Node_2008;
		case DefaultNamedElementEditPart.VISUAL_ID:
			return NamedElement_2012;
		case ModelEditPartCN.VISUAL_ID:
			return Model_49;
		case PackageEditPartCN.VISUAL_ID:
			return Package_36;
		case DeviceEditPartCN.VISUAL_ID:
			return Device_16;
		case NestedDeviceEditPartCN.VISUAL_ID:
			return Device_44;
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
			return ExecutionEnvironment_21;
		case NestedExecutionEnvironmentEditPartCN.VISUAL_ID:
			return ExecutionEnvironment_46;
		case NodeEditPartCN.VISUAL_ID:
			return Node_23;
		case NestedNodeEditPartCN.VISUAL_ID:
			return Node_42;
		case ArtifactEditPartCN.VISUAL_ID:
			return Artifact_25;
		case ArtifactEditPartACN.VISUAL_ID:
			return Artifact_28;
		case NestedArtifactNodeEditPartCN.VISUAL_ID:
			return Artifact_40;
		case CommentEditPartCN.VISUAL_ID:
			return Comment_54;
		case ConstraintEditPartCN.VISUAL_ID:
			return Constraint_56;
		case LinkDescriptorEditPart.VISUAL_ID:
			return Link_4005;
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4008;
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return ConstraintConstrainedElement_4009;
		case DeploymentEditPart.VISUAL_ID:
			return Deployment_4001;
		case ManifestationEditPart.VISUAL_ID:
			return Manifestation_4002;
		case GeneralizationEditPart.VISUAL_ID:
			return Generalization_4003;
		case DependencyEditPart.VISUAL_ID:
			return Dependency_4004;
		case DependencyBranchEditPart.VISUAL_ID:
			return Dependency_4010;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes.getElement(elementTypeAdapter);
		}
	};
}
