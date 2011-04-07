package org.eclipse.papyrus.diagram.component.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.commands.DuplicateNamedElementCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.ComponentCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.InterfaceCreateCommand;
import org.eclipse.papyrus.diagram.component.edit.commands.PackageCreateCommand;
import org.eclipse.papyrus.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class ComponentDiagramItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ComponentDiagramItemSemanticEditPolicy() {
		super(UMLElementTypes.Model_1000);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Component_2002 == req.getElementType()) {
			return getGEFWrapper(new ComponentCreateCommand(req));
		}
		if(UMLElementTypes.Interface_2003 == req.getElementType()) {
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if(UMLElementTypes.Package_3200 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommand(req));
		}
		if(UMLElementTypes.Comment_3201 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3199 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
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
