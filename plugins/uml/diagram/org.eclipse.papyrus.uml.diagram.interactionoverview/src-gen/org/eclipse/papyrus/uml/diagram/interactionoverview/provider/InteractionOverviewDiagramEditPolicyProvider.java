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
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies.CustomInteractionOverviewDiagramDragAndDropEditPolicy;

public class InteractionOverviewDiagramEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(final IOperation operation) {

		final CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		final GraphicalEditPart gep = (GraphicalEditPart)epOperation.getEditPart();
		final String diagramType = gep.getNotationView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityFinalNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.CommentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeStructuredActivityNodeContentCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.DecisionNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.FlowFinalNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ForkNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.InitialNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.JoinNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeStructuredActivityNodeContentCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.MergeNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ShapeNamedElementEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.SequenceNodeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.SequenceNodeStructuredActivityNodeContentCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConstraintEditPartCN) {
			return true;
		}

		return false;
	}

	public void createEditPolicies(final EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomInteractionOverviewDiagramDragAndDropEditPolicy());
	}

}
