/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.common.commands.DuplicateNamedElementCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ArtifactCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.DefaultNamedElementCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.DependencyNodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.DeviceCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ExecutionEnvironmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ModelCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.NodeCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.PackageCreateCommand;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class DeploymentDiagramItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DeploymentDiagramItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if(requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if(baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType)requestElementType);
				isExtendedType = true;
			}
		}
		if(UMLElementTypes.Dependency_2011 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DependencyNodeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Model_2010 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ModelCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Package_2009 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new PackageCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Constraint_2005 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Comment_2001 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CommentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.ExecutionEnvironment_2002 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ExecutionEnvironmentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Device_2003 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DeviceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Artifact_2006 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ArtifactCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Node_2008 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new NodeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.NamedElement_2012 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DefaultNamedElementCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		Diagram currentDiagram = null;
		if(getHost() instanceof IGraphicalEditPart) {
			currentDiagram = ((IGraphicalEditPart)getHost()).getNotationView().getDiagram();
		}
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req, currentDiagram));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateNamedElementCommand {

		/**
		 * @generated
		 */
		private Diagram diagram;

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req, Diagram currentDiagram) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap(), currentDiagram);
			this.diagram = currentDiagram;
		}
	}
}
