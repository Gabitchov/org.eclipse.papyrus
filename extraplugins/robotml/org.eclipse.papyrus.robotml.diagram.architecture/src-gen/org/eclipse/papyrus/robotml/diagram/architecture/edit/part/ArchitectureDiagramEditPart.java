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
package org.eclipse.papyrus.robotml.diagram.architecture.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.composite.edit.policies.CompositeStructureDiagramItemSemanticEditPolicy;
import org.eclipse.papyrus.robotml.diagram.architecture.edit.policy.ArchitectureDiagramDragDropEditPolicy;

public class ArchitectureDiagramEditPart extends DiagramEditPart {

	public final static String DIAGRAM_ID = "architecture"; //$NON-NLS-1$

	public ArchitectureDiagramEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new DuplicatePasteEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CompositeStructureDiagramItemSemanticEditPolicy());
		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ArchitectureDiagramDragDropEditPolicy());
	}
}
