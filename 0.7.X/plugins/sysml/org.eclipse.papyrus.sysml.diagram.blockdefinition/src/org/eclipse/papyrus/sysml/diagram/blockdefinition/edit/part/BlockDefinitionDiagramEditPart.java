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

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.BlockDefinitionDiagramItemSemanticEditPolicy;

public class BlockDefinitionDiagramEditPart extends DiagramEditPart {

	public final static String DIAGRAM_ID = "BlockDefinition"; //$NON-NLS-1$

	public BlockDefinitionDiagramEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		// This edit policy is reuses the edit policy from Class Diagram, but in not perfectly
		// consistent with GMF Runtime as it tends to break the extensible type framework.
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockDefinitionDiagramItemSemanticEditPolicy());
	}
}
