package org.eclipse.papyrus.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Actor3CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Comment2CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Component3CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.Constraint3CreateCommand;
import org.eclipse.papyrus.diagram.usecase.edit.commands.PackageCreateCommandCN;
import org.eclipse.papyrus.diagram.usecase.edit.commands.UseCase4CreateCommand;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class PackagePackageableElementCompartment2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackagePackageableElementCompartment2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_3014);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Constraint_3010 == req.getElementType()) {
			return getGEFWrapper(new Constraint3CreateCommand(req));
		}
		if(UMLElementTypes.Actor_3011 == req.getElementType()) {
			return getGEFWrapper(new Actor3CreateCommand(req));
		}
		if(UMLElementTypes.UseCase_3012 == req.getElementType()) {
			return getGEFWrapper(new UseCase4CreateCommand(req));
		}
		if(UMLElementTypes.Component_3013 == req.getElementType()) {
			return getGEFWrapper(new Component3CreateCommand(req));
		}
		if(UMLElementTypes.Package_3014 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommandCN(req));
		}
		if(UMLElementTypes.Comment_3015 == req.getElementType()) {
			return getGEFWrapper(new Comment2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
