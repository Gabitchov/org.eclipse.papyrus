/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.NavigationEditPolicy;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.BlockCompositeCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.StereotypeNodeLabelDisplayEditPolicy;

public class CustomEditPolicyProvider extends InternalBlockDiagramEditPolicyProvider {

	public void createEditPolicies(EditPart editPart) {
		super.createEditPolicies(editPart);
		editPart.installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new StereotypeNodeLabelDisplayEditPolicy());
		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());
		editPart.installEditPolicy(NavigationEditPolicy.NAVIGATION_POLICY, new NavigationEditPolicy());

		if(editPart instanceof ClassCompositeCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockCompositeCompartmentItemSemanticEditPolicy());
		}
	}

}
