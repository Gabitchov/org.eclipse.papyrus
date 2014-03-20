/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.MultiDependencyLabelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be created for the corresponding
 * Diagram, Node, ChildNode or Link represented by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.papyrus.uml.diagram.deployment/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(DeploymentDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return DeploymentDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while(view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if(annotation != null) {
				return (String)annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View)view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if(Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		return DeploymentDiagramEditPart.VISUAL_ID;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!DeploymentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(DeploymentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = DeploymentDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case DeploymentDiagramEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())

			) {
				return DependencyNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNamedElement().isSuperTypeOf(domainElement.eClass())

			) {
				return DefaultNamedElementEditPart.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedDeviceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedNodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedArtifactNodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedArtifactNodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedDeviceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedNodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case DeviceCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeEditPartCN.VISUAL_ID;
			}
			break;
		case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			break;
		case NodeCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeEditPartCN.VISUAL_ID;
			}
			break;
		case ArtifactCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartACN.VISUAL_ID;
			}
			break;
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())

			) {
				return ModelEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedDeviceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedNodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedArtifactNodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedArtifactNodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedDeviceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NestedNodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			break;
		case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeEditPartCN.VISUAL_ID;
			}
			break;
		case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			break;
		case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getDevice().isSuperTypeOf(domainElement.eClass())

			) {
				return DeviceEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getExecutionEnvironment().isSuperTypeOf(domainElement.eClass())

			) {
				return ExecutionEnvironmentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getNode().isSuperTypeOf(domainElement.eClass())

			) {
				return NodeEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartCN.VISUAL_ID;
			}
			break;
		case ArtifactCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartACN.VISUAL_ID;
			}
			break;
		case ArtifactCompositeCompartmentEditPartACN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getArtifact().isSuperTypeOf(domainElement.eClass())

			) {
				return ArtifactEditPartACN.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!DeploymentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(DeploymentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = DeploymentDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case DeploymentDiagramEditPart.VISUAL_ID:
			if(DependencyNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DefaultNamedElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyNodeEditPart.VISUAL_ID:
			if(MultiDependencyLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPart.VISUAL_ID:
			if(ModelNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelPackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if(PackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackagePackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if(ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if(CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEnvironmentEditPart.VISUAL_ID:
			if(ExecutionEnvironmentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeviceEditPart.VISUAL_ID:
			if(DeviceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactEditPart.VISUAL_ID:
			if(ArtifactNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeEditPart.VISUAL_ID:
			if(NodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DefaultNamedElementEditPart.VISUAL_ID:
			if(DefaultNamedElementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPartCN.VISUAL_ID:
			if(ModelNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ModelPackageableElementCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPartCN.VISUAL_ID:
			if(PackageNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackagePackageableElementCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeviceEditPartCN.VISUAL_ID:
			if(DeviceNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NestedDeviceEditPartCN.VISUAL_ID:
			if(NestedDeviceNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
			if(ExecutionEnvironmentNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NestedExecutionEnvironmentEditPartCN.VISUAL_ID:
			if(NestedExecutionEnvironmentNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeEditPartCN.VISUAL_ID:
			if(NodeNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NestedNodeEditPartCN.VISUAL_ID:
			if(NestedNodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactEditPartCN.VISUAL_ID:
			if(ArtifactNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactEditPartACN.VISUAL_ID:
			if(ArtifactNameEditPartACN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactCompositeCompartmentEditPartACN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NestedArtifactNodeEditPartCN.VISUAL_ID:
			if(NestedArtifactNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPartCN.VISUAL_ID:
			if(CommentBodyEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPartCN.VISUAL_ID:
			if(ConstraintNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintSpecificationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDeviceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedNodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedArtifactNodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedArtifactNodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDeviceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedNodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeviceCompositeCompartmentEditPart.VISUAL_ID:
			if(ExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
			if(ExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeCompositeCompartmentEditPart.VISUAL_ID:
			if(DeviceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactCompositeCompartmentEditPart.VISUAL_ID:
			if(ArtifactEditPartACN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(ModelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDeviceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedNodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedArtifactNodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			if(PackageEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedArtifactNodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedDeviceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NestedNodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
			if(ExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeviceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
			if(DeviceEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ExecutionEnvironmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(NodeEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ArtifactEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactCompositeCompartmentEditPartCN.VISUAL_ID:
			if(ArtifactEditPartACN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArtifactCompositeCompartmentEditPartACN.VISUAL_ID:
			if(ArtifactEditPartACN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DeploymentEditPart.VISUAL_ID:
			if(DeploymentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DeploymentAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ManifestationEditPart.VISUAL_ID:
			if(ManifestationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ManifestationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationEditPart.VISUAL_ID:
			if(GeneralizationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyEditPart.VISUAL_ID:
			if(DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DependencyAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getDeployment().isSuperTypeOf(domainElement.eClass())

		) {
			return DeploymentEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getManifestation().isSuperTypeOf(domainElement.eClass())

		) {
			return ManifestationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())

		) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())

		) {
			return DependencyEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())

		) {
			return DependencyBranchEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * "User can change implementation of this method to handle some specific\n"
	 * "situations not covered by default logic.\n"
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if(candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch(visualID) {
		case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
		case DeviceCompositeCompartmentEditPart.VISUAL_ID:
		case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
		case NodeCompositeCompartmentEditPart.VISUAL_ID:
		case ArtifactCompositeCompartmentEditPart.VISUAL_ID:
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
		case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
		case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
		case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
		case ArtifactCompositeCompartmentEditPartCN.VISUAL_ID:
		case ArtifactCompositeCompartmentEditPartACN.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch(visualID) {
		case DeploymentDiagramEditPart.VISUAL_ID:
			return false;
		case DeviceEditPartCN.VISUAL_ID:
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
		case NodeEditPartCN.VISUAL_ID:
		case ArtifactEditPartCN.VISUAL_ID:
		case CommentEditPartCN.VISUAL_ID:
		case ConstraintEditPartCN.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case ConstraintEditPart.VISUAL_ID:
		case DependencyNodeEditPart.VISUAL_ID:
		case DefaultNamedElementEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {

		/**
		 * @generated
		 */

		public int getVisualID(View view) {
			return org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */

		public String getModelID(View view) {
			return org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */

		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */

		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
