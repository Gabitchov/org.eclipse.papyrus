/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CreationOnMessageEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.Message7ItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.MessageConnectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.MessageConnectionLineSegEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.MessageFound;

/**
 * @generated
 */
public class Message7EditPart extends AbstractMessageEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4009;

	/**
	 * @generated
	 */
	public Message7EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Message7ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationOnMessageEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new MessageConnectionEditPolicy());
		installEditPolicy(AppliedStereotypeLinkLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeLinkLabelDisplayEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new MessageConnectionLineSegEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof MessageName7EditPart) {
			((MessageName7EditPart)childEditPart).setLabel(getPrimaryShape().getMessageLabelFigure());
			return true;
		}
		if(childEditPart instanceof MessageFoundAppliedStereotypeEditPart) {
			((MessageFoundAppliedStereotypeEditPart)childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
			return true;
		}
		return false;
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
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof MessageName7EditPart) {
			return true;
		}
		if(childEditPart instanceof MessageFoundAppliedStereotypeEditPart) {
			return true;
		}
		return false;
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
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new MessageFound();
	}

	/**
	 * @generated
	 */
	public MessageFound getPrimaryShape() {
		return (MessageFound)getFigure();
	}
}
