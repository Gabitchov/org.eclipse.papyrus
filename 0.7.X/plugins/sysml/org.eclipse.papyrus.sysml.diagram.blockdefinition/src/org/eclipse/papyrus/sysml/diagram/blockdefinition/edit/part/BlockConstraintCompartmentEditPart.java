/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassAttributeCompartment2EditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.BlockConstraintCompartmentItemSemanticEditPolicy;

public class BlockConstraintCompartmentEditPart extends ClassAttributeCompartment2EditPart {

	public final static String COMPARTMENT_NAME = "BlockConstraintCompartment";

	public BlockConstraintCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockConstraintCompartmentItemSemanticEditPolicy());
	}

	@Override
	public String getCompartmentName() {
		return COMPARTMENT_NAME;
	}
}
