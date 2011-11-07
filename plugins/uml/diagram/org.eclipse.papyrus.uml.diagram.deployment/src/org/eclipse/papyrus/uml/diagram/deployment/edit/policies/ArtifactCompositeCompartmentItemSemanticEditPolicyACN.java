/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ArtifactCreateCommandACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class ArtifactCompositeCompartmentItemSemanticEditPolicyACN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ArtifactCompositeCompartmentItemSemanticEditPolicyACN() {
		super(UMLElementTypes.Artifact_28);
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
