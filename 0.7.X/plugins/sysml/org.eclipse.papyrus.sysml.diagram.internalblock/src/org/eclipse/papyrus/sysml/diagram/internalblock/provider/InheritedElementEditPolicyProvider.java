/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.PropertyPartCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.PropertyPartEditPartCN;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.BlockCompositeCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.StereotypeNodeLabelDisplayEditPolicy;

public class InheritedElementEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		GraphicalEditPart gep = (GraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(!InternalBlockDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		if((gep instanceof ClassCompositeEditPart) || (gep instanceof ClassCompositeCompartmentEditPart) || (gep instanceof PropertyPartEditPartCN) || (gep instanceof PropertyPartCompartmentEditPartCN) || (gep instanceof PortEditPart)) {
			return true;
		}

		return false;
	}

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new StereotypeNodeLabelDisplayEditPolicy());
		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());

		if(editPart instanceof ClassCompositeCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockCompositeCompartmentItemSemanticEditPolicy());
		}
	}

}
