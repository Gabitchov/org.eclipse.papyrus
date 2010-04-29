/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.PackageCompartmentItemSemanticEditPolicy;

public class EditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(epOperation.getEditPart() instanceof PackagePackageableElementCompartment2EditPart) {
			PackagePackageableElementCompartment2EditPart editPart = (PackagePackageableElementCompartment2EditPart)epOperation.getEditPart();
			String diagramType = editPart.getNotationView().getDiagram().getType();
			if(BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
				return true;
			}
		}

		return false;
	}

	public void createEditPolicies(EditPart editPart) {
		if(editPart instanceof PackagePackageableElementCompartment2EditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageCompartmentItemSemanticEditPolicy());
		}
		// else : no action.
	}
}
