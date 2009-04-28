package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageItemSemanticEditPolicy() {
		super(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_79);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.DependencyCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationClassCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.AssociationCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.InstanceSpecificationCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ComponentCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.SignalCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.InterfaceCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ModelCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.EnumerationCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.PackageCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ClassCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.PrimitiveTypeCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.DataTypeCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.ConstraintCreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_1015 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.CommentCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
