package org.eclipse.papyrus.diagram.deployment.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.commands.DuplicateNamedElementCommand;
import org.eclipse.papyrus.diagram.deployment.edit.commands.ArtifactCreateCommand;
import org.eclipse.papyrus.diagram.deployment.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.diagram.deployment.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.diagram.deployment.edit.commands.DeviceCreateCommand;
import org.eclipse.papyrus.diagram.deployment.edit.commands.ExecutionEnvironmentCreateCommand;
import org.eclipse.papyrus.diagram.deployment.edit.commands.NodeCreateCommand;
import org.eclipse.papyrus.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class DeploymentDiagramItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DeploymentDiagramItemSemanticEditPolicy() {
		super(UMLElementTypes.Model_1000);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Comment_2001 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_2005 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if(UMLElementTypes.ExecutionEnvironment_2002 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEnvironmentCreateCommand(req));
		}
		if(UMLElementTypes.Device_2003 == req.getElementType()) {
			return getGEFWrapper(new DeviceCreateCommand(req));
		}
		if(UMLElementTypes.Artifact_2006 == req.getElementType()) {
			return getGEFWrapper(new ArtifactCreateCommand(req));
		}
		if(UMLElementTypes.Node_2008 == req.getElementType()) {
			return getGEFWrapper(new NodeCreateCommand(req));
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
