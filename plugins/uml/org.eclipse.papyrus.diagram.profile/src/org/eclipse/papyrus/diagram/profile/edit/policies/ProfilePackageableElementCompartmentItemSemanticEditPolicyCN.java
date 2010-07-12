package org.eclipse.papyrus.diagram.profile.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.profile.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.edit.commands.DataTypeCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.edit.commands.EnumerationCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.edit.commands.MetaclassCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.edit.commands.ModelCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.edit.commands.PackageCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.edit.commands.ProfileCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.edit.commands.StereotypeCreateCommandCN;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class ProfilePackageableElementCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ProfilePackageableElementCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Profile_1024);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Stereotype_1023 == req.getElementType()) {
			return getGEFWrapper(new StereotypeCreateCommandCN(req));
		}
		if(UMLElementTypes.Model_1027 == req.getElementType()) {
			return getGEFWrapper(new ModelCreateCommandCN(req));
		}
		if(UMLElementTypes.Profile_1024 == req.getElementType()) {
			return getGEFWrapper(new ProfileCreateCommandCN(req));
		}
		if(UMLElementTypes.Package_1012 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommandCN(req));
		}
		if(UMLElementTypes.Constraint_1028 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommandCN(req));
		}
		if(UMLElementTypes.Enumeration_3025 == req.getElementType()) {
			return getGEFWrapper(new EnumerationCreateCommandCN(req));
		}
		if(UMLElementTypes.DataType_3027 == req.getElementType()) {
			return getGEFWrapper(new DataTypeCreateCommandCN(req));
		}
		if(UMLElementTypes.Comment_1007 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		if(UMLElementTypes.Class_3028 == req.getElementType()) {
			return getGEFWrapper(new MetaclassCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
