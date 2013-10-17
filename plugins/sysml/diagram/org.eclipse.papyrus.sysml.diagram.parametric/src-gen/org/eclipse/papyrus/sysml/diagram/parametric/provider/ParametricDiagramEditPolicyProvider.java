/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;

public class ParametricDiagramEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		GraphicalEditPart gep = (GraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintEditPart) {
			return true;
		}	
		if(gep instanceof PortAffixedNodeEditPart) {
			return true;
		}	
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.UseCaseEditPartCN) {
			return true;
		}	
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentEditPart) {
			return true;
		}	
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.InteractionConstraintEditPartCN) {
			return true;
		}	

		return false;
	}

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());
	}

}
