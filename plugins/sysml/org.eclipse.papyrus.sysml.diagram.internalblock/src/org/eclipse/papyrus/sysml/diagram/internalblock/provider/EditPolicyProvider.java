package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.ClassCompositeItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.StereotypeNodeLabelDisplayEditPolicy;



public class EditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	/** Test : ClassCompositeEditPart + IBD */
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(epOperation.getEditPart() instanceof ClassCompositeEditPart) {
			ClassCompositeEditPart classCompEditPart = (ClassCompositeEditPart)epOperation.getEditPart();
			String diagramType = classCompEditPart.getNotationView().getDiagram().getType();
			if(InternalBlockDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
				return true;
			}
		}

		return false;
	}

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ClassCompositeItemSemanticEditPolicy());
		editPart.installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new StereotypeNodeLabelDisplayEditPolicy());
	}

}
