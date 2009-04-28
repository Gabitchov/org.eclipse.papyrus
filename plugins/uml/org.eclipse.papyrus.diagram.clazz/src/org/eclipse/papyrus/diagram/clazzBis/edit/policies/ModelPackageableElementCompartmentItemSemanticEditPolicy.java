package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ModelPackageableElementCompartmentItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.clazzBis.edit.policies.UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelPackageableElementCompartmentItemSemanticEditPolicy() {
		super(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.InstanceSpecification2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Component2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Signal2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Interface2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Model2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Enumeration2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Package2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Class4CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.PrimitiveType2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.DataType2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Comment2CreateCommand(req));
		}
		if (org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.clazzBis.edit.commands.Constraint2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
