package org.eclipse.papyrus.diagram.deployment.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.deployment.edit.commands.ArtifactCreateCommandACN;
import org.eclipse.papyrus.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class ArtifactCompositeCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ArtifactCompositeCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Artifact_2006);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Artifact_28 == req.getElementType()) {
			return getGEFWrapper(new ArtifactCreateCommandACN(req));
		}
		return super.getCreateCommand(req);
	}

}
