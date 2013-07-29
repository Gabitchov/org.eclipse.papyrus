package org.eclipse.papyrus.sysml.diagram.parametric.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.parametric.policies.CustomParametricSemanticPolicy;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;

public class CustomPortAffixedNodeEditPart extends PortAffixedNodeEditPart {

	public CustomPortAffixedNodeEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomParametricSemanticPolicy());
	}

}
