package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassAttributeCompartment2EditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.BlockPartCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.BlockReferenceCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.DefaultItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;

public class BlockReferenceCompartmentEditPart extends ClassAttributeCompartment2EditPart {

	public final static String COMPARTMENT_NAME = "BlockReferenceCompartment";

	public BlockReferenceCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockReferenceCompartmentItemSemanticEditPolicy());

	}

	@Override
	public String getCompartmentName() {
		return COMPARTMENT_NAME;
	}
}
