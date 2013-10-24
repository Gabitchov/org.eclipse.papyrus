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
package org.eclipse.papyrus.sysml.diagram.parametric.edit.part;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultContainerNodeEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultCreationEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultXYLayoutEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.policy.DiagramSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.parametric.policies.CustomParametricSemanticPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy;

public class ParametricDiagramEditPart extends DiagramEditPart {

	public ParametricDiagramEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DiagramSemanticEditPolicy());			
		installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new DuplicatePasteEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DefaultXYLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultContainerNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomParametricSemanticPolicy());			
	}
}
