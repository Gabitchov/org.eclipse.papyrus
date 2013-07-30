/******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation
 *    CEA LIST - Adaptation to support a different hint for SnapBack location storage.
 *    
 ****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;


/**
 * <pre>
 * EditPolicy which support the RequestConstants.REQ_SNAP_BACK request type.
 * 
 * Returns a command to position a label's offset to it default set at creation.
 * 
 * This edit policy is a copy of LabelSnapBackEditPolicy, which does not only use the label view type
 * to find the snap back position (also takes into account the diagram and parent view type).
 * 
 * @see org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.LabelSnapBackEditPolicy
 * </pre>
 */
@SuppressWarnings("restriction")
public class DefaultSnapBackEditPolicy extends GraphicalNodeEditPolicy {


	/**
	 * Understands RequestConstants.REQ_SNAP_BACK request types
	 * 
	 * @param request
	 * @return boolean
	 */
	public boolean understandsRequest(Request request) {
		return RequestConstants.REQ_SNAP_BACK.equals(request.getType());
	}

	/**
	 * Returns a <code>Command</code> which sets the label's offset to its
	 * original position.
	 * 
	 * @param request
	 *        the request
	 * @return the command
	 */
	public Command getCommand(Request request) {
		if(RequestConstants.REQ_SNAP_BACK.equals(request.getType())) {
			View view = (View)getHost().getModel();

			// YT - Use a snap back hint that takes into account the diagram 
			// and parent view type.
			String hint = getSnapBackHint(view);

			Point offset = LabelEditPart.getSnapBackPosition(hint);
			if(offset == null)
				return null;

			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();

			ICommand moveCommand = new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(view), offset);
			return new ICommandProxy(moveCommand);
		}
		return null;
	}

	public EditPart getTargetEditPart(Request request) {
		if(understandsRequest(request))
			return getHost();
		return super.getTargetEditPart(request);
	}

	/**
	 * Get the snap back hint for the view.
	 * 
	 * @param view
	 *        the view to snap back.
	 * @return the snap back hint.
	 */
	private String getSnapBackHint(View view) {

		String diagramType = view.getDiagram().getType();
		String parentType = ViewUtil.getViewContainer(view).getType();
		String labelType = view.getType();

		return diagramType + "_" + parentType + "-" + labelType;
	}
}
