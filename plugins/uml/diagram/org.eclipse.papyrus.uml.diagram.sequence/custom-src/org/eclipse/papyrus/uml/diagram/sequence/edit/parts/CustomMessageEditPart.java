/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomMessageItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.MessageSync;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessageEditPart extends MessageEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomMessageEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomMessageItemSemanticEditPolicy());
	}

	/**
	 * Block message sort modification
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		SequenceUtil.handleMessageSortChange(getEditingDomain(), notification, (Message)resolveSemanticElement(), MessageSort.ASYNCH_CALL_LITERAL);
		super.handleNotificationEvent(notification);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart#createConnectionFigure()
	 * 
	 * @return
	 */
	@Override
	protected Connection createConnectionFigure() {
		return new MessageSync(getMapMode());
	}
}
