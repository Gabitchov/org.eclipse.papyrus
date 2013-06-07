/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN;
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
import org.eclipse.papyrus.uml.diagram.deployment.part.Messages;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof DeploymentDiagramEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(10);
			types.add(UMLElementTypes.Dependency_2011);
			types.add(UMLElementTypes.Model_2010);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2005);
			types.add(UMLElementTypes.Comment_2001);
			types.add(UMLElementTypes.ExecutionEnvironment_2002);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.Node_2008);
			types.add(UMLElementTypes.NamedElement_2012);
			return types;
		}
		if(editPart instanceof ModelPackageableElementCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Comment_54);
			types.add(UMLElementTypes.Constraint_56);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Comment_54);
			types.add(UMLElementTypes.Constraint_56);
			return types;
		}
		if(editPart instanceof DeviceCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Node_23);
			return types;
		}
		if(editPart instanceof ExecutionEnvironmentCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			return types;
		}
		if(editPart instanceof NodeCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.Node_23);
			return types;
		}
		if(editPart instanceof ArtifactCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Artifact_28);
			return types;
		}
		if(editPart instanceof ModelPackageableElementCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(UMLElementTypes.Model_49);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Comment_54);
			types.add(UMLElementTypes.Constraint_56);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(7);
			types.add(UMLElementTypes.Package_36);
			types.add(UMLElementTypes.Artifact_40);
			types.add(UMLElementTypes.Device_44);
			types.add(UMLElementTypes.ExecutionEnvironment_46);
			types.add(UMLElementTypes.Node_42);
			types.add(UMLElementTypes.Comment_54);
			types.add(UMLElementTypes.Constraint_56);
			return types;
		}
		if(editPart instanceof DeviceCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.Node_23);
			return types;
		}
		if(editPart instanceof ExecutionEnvironmentCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Artifact_25);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			return types;
		}
		if(editPart instanceof NodeCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(UMLElementTypes.Device_16);
			types.add(UMLElementTypes.ExecutionEnvironment_21);
			types.add(UMLElementTypes.Node_23);
			types.add(UMLElementTypes.Artifact_25);
			return types;
		}
		if(editPart instanceof ArtifactCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Artifact_28);
			return types;
		}
		if(editPart instanceof ArtifactCompositeCompartmentEditPartACN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Artifact_28);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof NodeEditPart) {
			return ((NodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DeviceEditPartCN) {
			return ((DeviceEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof NestedDeviceEditPartCN) {
			return ((NestedDeviceEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ExecutionEnvironmentEditPartCN) {
			return ((ExecutionEnvironmentEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			return ((NestedExecutionEnvironmentEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof NodeEditPartCN) {
			return ((NodeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof NestedNodeEditPartCN) {
			return ((NestedNodeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ArtifactEditPartACN) {
			return ((ArtifactEditPartACN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof NestedArtifactNodeEditPartCN) {
			return ((NestedArtifactNodeEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof NodeEditPart) {
			return ((NodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			return ((DeviceEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof NestedDeviceEditPartCN) {
			return ((NestedDeviceEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			return ((ExecutionEnvironmentEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			return ((NestedExecutionEnvironmentEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			return ((NodeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof NestedNodeEditPartCN) {
			return ((NestedNodeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			return ((ArtifactEditPartACN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof NestedArtifactNodeEditPartCN) {
			return ((NestedArtifactNodeEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof NodeEditPart) {
			return ((NodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DeviceEditPartCN) {
			return ((DeviceEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof NestedDeviceEditPartCN) {
			return ((NestedDeviceEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ExecutionEnvironmentEditPartCN) {
			return ((ExecutionEnvironmentEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			return ((NestedExecutionEnvironmentEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof NodeEditPartCN) {
			return ((NodeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof NestedNodeEditPartCN) {
			return ((NestedNodeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ArtifactEditPartACN) {
			return ((ArtifactEditPartACN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof NestedArtifactNodeEditPartCN) {
			return ((NestedArtifactNodeEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof NodeEditPart) {
			return ((NodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DeviceEditPartCN) {
			return ((DeviceEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof NestedDeviceEditPartCN) {
			return ((NestedDeviceEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ExecutionEnvironmentEditPartCN) {
			return ((ExecutionEnvironmentEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			return ((NestedExecutionEnvironmentEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof NodeEditPartCN) {
			return ((NodeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof NestedNodeEditPartCN) {
			return ((NestedNodeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ArtifactEditPartACN) {
			return ((ArtifactEditPartACN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof NestedArtifactNodeEditPartCN) {
			return ((NestedArtifactNodeEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ExecutionEnvironmentEditPart) {
			return ((ExecutionEnvironmentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DeviceEditPart) {
			return ((DeviceEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ArtifactEditPart) {
			return ((ArtifactEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof NodeEditPart) {
			return ((NodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DeviceEditPartCN) {
			return ((DeviceEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof NestedDeviceEditPartCN) {
			return ((NestedDeviceEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ExecutionEnvironmentEditPartCN) {
			return ((ExecutionEnvironmentEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof NestedExecutionEnvironmentEditPartCN) {
			return ((NestedExecutionEnvironmentEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof NodeEditPartCN) {
			return ((NodeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof NestedNodeEditPartCN) {
			return ((NestedNodeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ArtifactEditPartCN) {
			return ((ArtifactEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ArtifactEditPartACN) {
			return ((ArtifactEditPartACN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof NestedArtifactNodeEditPartCN) {
			return ((NestedArtifactNodeEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPartCN) {
			return ((ConstraintEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if(types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram)editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for(Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = it.next();
			if(isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if(elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[])elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if(dialog.open() == Window.OK) {
			selected = (EObject)dialog.getFirstResult();
		}
		return selected;
	}
}
