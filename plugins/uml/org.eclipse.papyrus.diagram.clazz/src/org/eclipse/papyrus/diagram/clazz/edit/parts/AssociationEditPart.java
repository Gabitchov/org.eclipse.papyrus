/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.AbstractAssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.figure.AssociationFigure;
import org.eclipse.papyrus.diagram.clazz.custom.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic.CustomAssociationItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.AssociationItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;

/**
 * @generated
 */
public class AssociationEditPart extends AbstractAssociationEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public AssociationEditPart(View view) {
		super(view);
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
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AppliedStereotypeAssociationEditPart) {
			((AppliedStereotypeAssociationEditPart) childEditPart).setLabel(getPrimaryShape()
					.getAppliedStereotypeAssociationLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName2EditPart) {
			((AssociationName2EditPart) childEditPart).setLabel(getPrimaryShape().getAssociationNameLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName3EditPart) {
			((AssociationName3EditPart) childEditPart).setLabel(getPrimaryShape().getRoleSourceLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName4EditPart) {
			((AssociationName4EditPart) childEditPart).setLabel(getPrimaryShape().getMultiplicitySourceLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName5EditPart) {
			((AssociationName5EditPart) childEditPart).setLabel(getPrimaryShape().getMultiplicityTargetLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName6EditPart) {
			((AssociationName6EditPart) childEditPart).setLabel(getPrimaryShape().getRoleTargetLabel());
			return true;
		}
		return false;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new AssociationFigure();
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AssociationItemSemanticEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY,
				new AppliedStereotypeLabelDisplayEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomAssociationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new CustomGraphicalNodeEditPolicy());
	}

	/**
	 * @generated
	 */
	public AssociationFigure getPrimaryShape() {
		return (AssociationFigure) getFigure();
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
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AppliedStereotypeAssociationEditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName2EditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName3EditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName4EditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName5EditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName6EditPart) {
			return true;
		}
		return false;
	}

}
