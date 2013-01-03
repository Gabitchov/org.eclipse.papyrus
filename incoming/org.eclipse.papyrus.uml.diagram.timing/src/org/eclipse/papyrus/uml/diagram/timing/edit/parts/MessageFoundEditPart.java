/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.MessageFoundFigure;
import org.eclipse.papyrus.uml.diagram.timing.edit.policies.MessageFoundItemSemanticEditPolicy;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class MessageFoundEditPart extends ConnectionEditPart

implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 53;

	/**
	 * @generated
	 */
	public MessageFoundEditPart(final View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new MessageFoundItemSemanticEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeLinkLabelDisplayEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(final EditPart childEditPart) {
		if (childEditPart instanceof MessageFoundNameLabelEditPart) {
			((MessageFoundNameLabelEditPart) childEditPart).setLabel(getPrimaryShape().getMessageLabel());
			return true;
		}
		if (childEditPart instanceof MessageFoundAppliedStereotypeEditPart) {
			((MessageFoundAppliedStereotypeEditPart) childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(final EditPart childEditPart, final int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(final EditPart childEditPart) {
		if (childEditPart instanceof MessageFoundNameLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof MessageFoundAppliedStereotypeEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChildVisual(final EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove <i>generated</i> tag
	 * and modify it.
	 * 
	 * @generated
	 */
	@Override
	protected Connection createConnectionFigure() {
		return new MessageFoundFigure();
	}

	/**
	 * @generated
	 */
	public MessageFoundFigure getPrimaryShape() {
		return (MessageFoundFigure) getFigure();
	}

}
