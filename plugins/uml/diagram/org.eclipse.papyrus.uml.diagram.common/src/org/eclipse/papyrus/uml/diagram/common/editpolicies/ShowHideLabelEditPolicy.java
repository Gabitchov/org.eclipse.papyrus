/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionLabelsEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideLabelsRequest;

/**
 * This EditPolicy is used to show or hide only one Label View for a connection.
 * The EditPolicy {@link ConnectionLabelsEditPolicy} provided by GMF allows only
 * show or hide all the labels for a connection (or an affixed child node!)and
 * not only some of them This EditPolicy replaces it!
 * 
 * 
 */
public class ShowHideLabelEditPolicy extends ConnectionLabelsEditPolicy {

	/** key for this editpolicy */
	public static final String SHOW_HIDE_LABEL_ROLE = EditPolicyRoles.CONNECTION_LABELS_ROLE;

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionLabelsEditPolicy#understandsRequest(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public boolean understandsRequest(Request request) {
		if(ShowHideLabelsRequest.SHOW_HIDE_LABELS_REQUEST_TYPE.equals(request.getType())) {
			return true;
		}
		return super.understandsRequest(request);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionLabelsEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public Command getCommand(Request request) {
		if(ShowHideLabelsRequest.SHOW_HIDE_LABELS_REQUEST_TYPE.equals(request.getType())) {
			SetPropertyCommand cmd = new SetPropertyCommand(getEditingDomain(), new EObjectAdapter(((ShowHideLabelsRequest)request).getView()), Properties.ID_ISVISIBLE, DiagramUIMessages.Command_hideLabel_Label, Boolean.valueOf(((ShowHideLabelsRequest)request).showConnectionLabel()));
			if(cmd.canExecute()) {
				return new ICommandProxy(cmd);
			}
		} else {
			return super.getCommand(request);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionLabelsEditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		// nothing to do here!
		return super.getTargetEditPart(request);
	}

}
