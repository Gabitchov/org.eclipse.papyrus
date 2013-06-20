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
package org.eclipse.papyrus.robotml.diagram.interfacedef.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.robotml.diagram.interfacedef.edit.part.InterfaceDefEditPart;
import org.eclipse.papyrus.robotml.diagram.interfacedef.edit.policy.InterfaceDefDragDropEditPolicy;

public class InterfaceDefEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		GraphicalEditPart gep = (GraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(!InterfaceDefEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ShortCutDiagramEditPart) {
			return true;
		}

		return false;
	}

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new InterfaceDefDragDropEditPolicy());
	}

}
