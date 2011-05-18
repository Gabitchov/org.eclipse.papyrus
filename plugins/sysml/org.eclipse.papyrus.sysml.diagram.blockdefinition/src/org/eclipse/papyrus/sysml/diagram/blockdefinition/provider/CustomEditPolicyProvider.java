/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.common.editparts.ResizeableListCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.NavigationEditPolicy;
//import org.eclipse.papyrus.diagram.common.editpolicies.NavigationEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.PackageCompartmentSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;

/**
 * Edit policy provider for the Block definition diagram (install or remove policies on edit part creation).
 */
public class CustomEditPolicyProvider extends BlockDefinitionDiagramEditPolicyProvider {

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

		if(gep instanceof AbstractElementEditPart) {
			return true;
		}

		if(gep instanceof ResizeableListCompartmentEditPart) {
			return true;
		}

		return super.provides(operation);
	}

	public void createEditPolicies(EditPart editPart) {
		super.createEditPolicies(editPart);

		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
		editPart.installEditPolicy(NavigationEditPolicy.NAVIGATION_POLICY, new NavigationEditPolicy());
		
		if((editPart instanceof PackagePackageableElementCompartmentEditPartCN) || (editPart instanceof PackagePackageableElementCompartmentEditPart)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageCompartmentSemanticEditPolicy());
		}

		if((editPart instanceof ModelPackageableElementCompartmentEditPartCN) || (editPart instanceof ModelPackageableElementCompartmentEditPartTN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageCompartmentSemanticEditPolicy());
		}
	}
}
