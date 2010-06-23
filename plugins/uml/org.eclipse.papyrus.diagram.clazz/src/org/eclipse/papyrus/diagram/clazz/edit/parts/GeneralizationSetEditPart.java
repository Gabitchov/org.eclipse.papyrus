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
import org.eclipse.papyrus.diagram.clazz.custom.figure.GeneralizationSet;
import org.eclipse.papyrus.diagram.clazz.custom.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.diagram.clazz.custom.policies.GeneralizationSetLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.GeneralizationSetItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.common.editparts.UMLConnectionNodeEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;

/**
 * @generated
 */
public class GeneralizationSetEditPart extends UMLConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4020;

	/**
	 * @generated
	 */
	public GeneralizationSetEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ConstraintLabelEditPart) {
			((ConstraintLabelEditPart)childEditPart).setLabel(getPrimaryShape().getConstraintLabel());
			return true;
		}
		return false;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new GeneralizationSet();
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GeneralizationSetItemSemanticEditPolicy());
		installEditPolicy("CustomDisplay", new GeneralizationSetLabelDisplayEditPolicy()); //$NON-NLS-1$
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeLinkLabelDisplayEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new CustomGraphicalNodeEditPolicy());
	}

	/**
	 * @generated
	 */
	public GeneralizationSet getPrimaryShape() {
		return (GeneralizationSet)getFigure();
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ConstraintLabelEditPart) {
			return true;
		}
		return false;
	}

}
