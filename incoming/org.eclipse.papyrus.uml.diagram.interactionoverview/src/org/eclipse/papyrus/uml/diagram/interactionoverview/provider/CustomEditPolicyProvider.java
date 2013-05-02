/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityCNContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionRegionStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SequenceNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.ActivityContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomActivityCNContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomInterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomLoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomSequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomStructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy;

public class CustomEditPolicyProvider extends InteractionOverviewDiagramEditPolicyProvider {

	@Override
	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof IGraphicalEditPart)) {
			return false;
		}

		// Make sure this concern Internal Block Diagram only
		IGraphicalEditPart gep = (IGraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		if(gep instanceof ActivityActivityContentCompartmentEditPart) {
			return true;
		}

		if(gep instanceof ActivityCNContentCompartmentEditPart) {
			return true;
		}

		if(gep instanceof ActivityPartitionActivityPartitionContentCompartmentEditPart) {
			return true;
		}

		if(gep instanceof ConditionalNodeStructuredActivityNodeContentCompartmentEditPart) {
			return true;
		}

		if(gep instanceof ExpansionRegionStructuredActivityNodeContentCompartmentEditPart) {
			return true;
		}

		if(gep instanceof InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart) {
			return true;
		}

		if(gep instanceof LoopNodeStructuredActivityNodeContentCompartmentEditPart) {
			return true;
		}

		if(gep instanceof SequenceNodeStructuredActivityNodeContentCompartmentEditPart) {
			return true;
		}

		if(gep instanceof StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart) {
			return true;
		}

		return super.provides(operation);
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		super.createEditPolicies(editPart);

		if(editPart instanceof ActivityActivityContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ActivityContentCompartmentItemSemanticEditPolicy());
		}

		if(editPart instanceof ActivityCNContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomActivityCNContentCompartmentItemSemanticEditPolicy());
		}

		if(editPart instanceof ActivityPartitionActivityPartitionContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy());
		}

		if(editPart instanceof ConditionalNodeStructuredActivityNodeContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy());
		}

		if(editPart instanceof ExpansionRegionStructuredActivityNodeContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy());
		}

		if(editPart instanceof InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy());
		}

		if(editPart instanceof LoopNodeStructuredActivityNodeContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomLoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy());
		}

		if(editPart instanceof SequenceNodeStructuredActivityNodeContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomSequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy());
		}

		if(editPart instanceof StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomStructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy());
		}
	}

}
