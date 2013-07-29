package org.eclipse.papyrus.sysml.diagram.parametric.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.policies.CustomParametricSemanticPolicy;

public class CustomConstraintBlockPropertyCompositeEditPart extends
		ConstraintBlockPropertyCompositeEditPart {

	public CustomConstraintBlockPropertyCompositeEditPart(View view) {
		super(view);
	}
	
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomParametricSemanticPolicy());
	}

}
