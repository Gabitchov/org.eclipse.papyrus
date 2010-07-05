/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassAttributeCompartment2EditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.DefaultItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;

public class BlockPartCompartmentEditPart extends ClassAttributeCompartment2EditPart {

	public final static String COMPARTMENT_NAME = "BlockPartCompartment";

	public BlockPartCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultItemSemanticEditPolicy(BlockDefinitionDiagramElementTypes.BLOCK));
	}

	@Override
	public String getCompartmentName() {
		return COMPARTMENT_NAME;
	}
}
