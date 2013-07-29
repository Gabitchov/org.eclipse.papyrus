package org.eclipse.papyrus.sysml.diagram.parametric.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.commands.CustomBindingConnectorCreateCommand;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomBlockCompositeEditPartTN;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.policy.DiagramSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConstraintParameterAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.uml2.uml.UMLPackage;

public class CustomParametricSemanticPolicy extends DiagramSemanticEditPolicy {

	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (req.getElementType().getEClass() == UMLPackage.eINSTANCE.getConnector()) {
			if (getHost() instanceof CustomBlockCompositeEditPartTN) {
				return UnexecutableCommand.INSTANCE;
			}
			if (getHost() instanceof ConstraintBlockPropertyCompositeEditPart) {
				return UnexecutableCommand.INSTANCE;			
			}
			if (getHost() instanceof ConstraintParameterAffixedNodeEditPart) {
				return getGEFWrapper(new CustomBindingConnectorCreateCommand(req));			
			}
			if (getHost() instanceof PortAffixedNodeEditPart) {
				return getGEFWrapper(new CustomBindingConnectorCreateCommand(req));				
			}
			if (getHost() instanceof BlockPropertyCompositeEditPart) {
				return getGEFWrapper(new CustomBindingConnectorCreateCommand(req));				
			}
		}
		return super.getCreateRelationshipCommand(req);
	}
}
