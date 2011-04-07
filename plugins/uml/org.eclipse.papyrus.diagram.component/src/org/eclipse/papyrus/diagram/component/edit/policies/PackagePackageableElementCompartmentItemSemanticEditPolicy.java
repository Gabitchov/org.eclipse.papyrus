package org.eclipse.papyrus.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.component.edit.commands.CommentCreateCommandPCN;
import org.eclipse.papyrus.diagram.component.edit.commands.ComponentCreateCommandPCN;
import org.eclipse.papyrus.diagram.component.edit.commands.ConstraintCreateCommandPCN;
import org.eclipse.papyrus.diagram.component.edit.commands.InterfaceCreateCommandPCN;
import org.eclipse.papyrus.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class PackagePackageableElementCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackagePackageableElementCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_3200);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Interface_3072 == req.getElementType()) {
			return getGEFWrapper(new InterfaceCreateCommandPCN(req));
		}
		if(UMLElementTypes.Comment_3074 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandPCN(req));
		}
		if(UMLElementTypes.Constraint_3075 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommandPCN(req));
		}
		if(UMLElementTypes.Component_3071 == req.getElementType()) {
			return getGEFWrapper(new ComponentCreateCommandPCN(req));
		}
		return super.getCreateCommand(req);
	}

}
