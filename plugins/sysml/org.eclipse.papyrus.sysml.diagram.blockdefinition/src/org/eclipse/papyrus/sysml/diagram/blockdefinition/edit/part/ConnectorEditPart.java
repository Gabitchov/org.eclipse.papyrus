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

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editparts.UMLConnectionNodeEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.ConnectorItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.figure.ConnectorFigure;

/**
 * @generated
 */
public class ConnectorEditPart extends UMLConnectionNodeEditPart implements ITreeBranchEditPart {

	public ConnectorEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConnectorItemSemanticEditPolicy());
		installEditPolicy(AppliedStereotypeLinkLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeLinkLabelDisplayEditPolicy());
	}

//	protected boolean addFixedChild(EditPart childEditPart) {
//		if(childEditPart instanceof ConnectorAppliedStereotypeEditPart) {
//			((ConnectorAppliedStereotypeEditPart)childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
//			return true;
//		}
//		return false;
//	}
//
//	protected void addChildVisual(EditPart childEditPart, int index) {
//		if(addFixedChild(childEditPart)) {
//			return;
//		}
//		super.addChildVisual(childEditPart, -1);
//	}
//
//	protected boolean removeFixedChild(EditPart childEditPart) {
//		if(childEditPart instanceof ConnectorAppliedStereotypeEditPart) {
//			return true;
//		}
//		return false;
//	}
//
//	protected void removeChildVisual(EditPart childEditPart) {
//		if(removeFixedChild(childEditPart)) {
//			return;
//		}
//		super.removeChildVisual(childEditPart);
//	}

	protected Connection createConnectionFigure() {
		return new ConnectorFigure();
	}

	public ConnectorFigure getPrimaryShape() {
		return (ConnectorFigure)getFigure();
	}

}
