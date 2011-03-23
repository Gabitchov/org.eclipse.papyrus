package org.eclipse.papyrus.diagram.deployment.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.deployment.edit.commands.ArtifactCreateCommandCN;
import org.eclipse.papyrus.diagram.deployment.edit.commands.DeviceCreateCommandCN;
import org.eclipse.papyrus.diagram.deployment.edit.commands.ExecutionEnvironmentCreateCommandCN;
import org.eclipse.papyrus.diagram.deployment.edit.commands.NodeCreateCommandCN;
import org.eclipse.papyrus.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class NodeCompositeCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public NodeCompositeCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Node_23);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Device_16 == req.getElementType()) {
			return getGEFWrapper(new DeviceCreateCommandCN(req));
		}
		if(UMLElementTypes.ExecutionEnvironment_21 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEnvironmentCreateCommandCN(req));
		}
		if(UMLElementTypes.Node_23 == req.getElementType()) {
			return getGEFWrapper(new NodeCreateCommandCN(req));
		}
		if(UMLElementTypes.Artifact_25 == req.getElementType()) {
			return getGEFWrapper(new ArtifactCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
