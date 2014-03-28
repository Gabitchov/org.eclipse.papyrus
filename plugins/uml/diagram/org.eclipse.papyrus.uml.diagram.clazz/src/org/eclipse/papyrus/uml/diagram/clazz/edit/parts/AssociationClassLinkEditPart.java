/*
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.AbstractAssociationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.custom.figure.AssociationFigure;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomAssociationClassLinkItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.AssociationClassLinkItemSemanticEditPolicy;

/**
 * @generated
 */
public class AssociationClassLinkEditPart extends AbstractAssociationEditPart
		implements ITreeBranchEditPart
{

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4017;

	/**
	 * @generated
	 */
	public AssociationClassLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AssociationClassLinkItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new CustomGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomAssociationClassLinkItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssociationClassRoleSourceEditPart) {
			((AssociationClassRoleSourceEditPart) childEditPart).setLabel(
					getPrimaryShape().getRoleSourceLabel());
		}
		if (childEditPart instanceof AssociationClassRoleTargetEditPart) {
			((AssociationClassRoleTargetEditPart) childEditPart).setLabel(
					getPrimaryShape().getRoleTargetLabel());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssociationClassRoleSourceEditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationClassRoleTargetEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new AssociationFigure();
	}

	/**
	 * @generated
	 */
	public AssociationFigure getPrimaryShape() {
		return (AssociationFigure) getFigure();
	}

}
