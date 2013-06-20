/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.componentdef.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.robotml.diagram.componentdef.edit.part.ComponentdefDiagramEditPart;
import org.eclipse.papyrus.robotml.diagram.componentdef.edit.policy.ComponentdefDiagramDragDropEditPolicy;

public class ComponentdefDiagramEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		GraphicalEditPart gep = (GraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(!ComponentdefDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartCompartmentEditPartCN) {
			return true;
		}

		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintEditPartCN) {
			return true;
		}

		return false;
	}

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ComponentdefDiagramDragDropEditPolicy());
	}

}
