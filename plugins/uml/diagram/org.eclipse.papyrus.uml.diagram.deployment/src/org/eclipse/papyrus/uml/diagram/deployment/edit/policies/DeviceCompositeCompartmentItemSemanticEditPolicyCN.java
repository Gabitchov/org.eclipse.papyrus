/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.DeviceCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ExecutionEnvironmentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.NodeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class DeviceCompositeCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DeviceCompositeCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Device_16);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.ExecutionEnvironment_21 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEnvironmentCreateCommandCN(req));
		}
		if(UMLElementTypes.Device_16 == req.getElementType()) {
			return getGEFWrapper(new DeviceCreateCommandCN(req));
		}
		if(UMLElementTypes.Node_23 == req.getElementType()) {
			return getGEFWrapper(new NodeCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
