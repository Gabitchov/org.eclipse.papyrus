/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ModelItemSemanticEditPolicy;

/**
 * Edit Part for the SysML Requirement Diagram
 * 
 */
public class RequirementDiagramEditPart extends DiagramEditPart {

	/**
	 * SysML Requirement Diagram identifier
	 */
	public final static String DIAGRAM_ID = "RequirementDiagram"; //$NON-NLS-1$

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public RequirementDiagramEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		// This edit policy reuses the edit policy from Class Diagram, but in not perfectly
		// consistent with GMF Runtime as it tends to break the extensible type framework.
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ModelItemSemanticEditPolicy());
	}
}
