/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.diagram.composite.custom.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.composite.custom.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.diagram.composite.edit.policies.PackageItemSemanticEditPolicy;

public class InternalBlockDiagramEditPart extends DiagramEditPart {

	public final static String DIAGRAM_ID = "InternalBlock"; //$NON-NLS-1$

	public InternalBlockDiagramEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new DuplicatePasteEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageItemSemanticEditPolicy());
		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy()); // FIXME : Create specific drop  !!!
	}
}
