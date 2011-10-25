/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.menu.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IEditableEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ZOrderRequest;

/**
 * The ZOrder action
 * A part of this code comes from {@link org.eclipse.gmf.runtime.diagram.ui.actions.internal.ZOrderAction}
 * 
 * 
 */
public class ZOrderAction extends AbstractGraphicalParametricAction {

	/**
	 * the possible values for the parameter
	 */
	public static final String BRING_TO_FRONT = "bringToFront"; //$NON-NLS-1$

	public static final String SEND_TO_BACK = "sendToBack"; //$NON-NLS-1$

	public static final String BRING_FORWARD = "bringForward"; //$NON-NLS-1$

	public static final String SEND_BACKWARD = "sendBackward"; //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 */
	public ZOrderAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		super(parameter, selectedElements);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.AbstractParametricAction#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		if(getSelection().isEmpty()) {
			return false;
		}
		// Get the first selected editpart
		EditPart editPart = getSelection().get(0);

		// Get the parent of the first selected editpart
		GraphicalEditPart parentEditPart = (GraphicalEditPart)editPart.getParent();

		if(parentEditPart == null) {
			return false;
		}

		// bugzilla 156733: disable this action if the parent is not editable
		if((parentEditPart instanceof IEditableEditPart) && !((IEditableEditPart)parentEditPart).isEditModeEnabled()) {
			return false;
		}

		// disable this action if the parent doesn't have an XYLayout
		if(!(parentEditPart.getContentPane().getLayoutManager() instanceof XYLayout)) {
			return false;
		}

		// Iterate over all the selected edit parts
		for(Iterator<IGraphicalEditPart> iter = getSelection().iterator(); iter.hasNext();) {

			// Get the next selected editpart
			EditPart selectedEditPart = iter.next();

			// Verify that the editparts share the same parent
			if(parentEditPart != selectedEditPart.getParent()) {
				return false;
			}

			// bugzilla 156733: disable this action if the selected edit part is not editable
			if((selectedEditPart instanceof IEditableEditPart) && !((IEditableEditPart)selectedEditPart).isEditModeEnabled()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.AbstractParametricAction#getBuildedCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getBuildedCommand() {
		Command cmd = null;
		ZOrderRequest request = null;
		if(BRING_FORWARD.equals(getParameter())) {
			request = new ZOrderRequest(ZOrderRequest.REQ_BRING_FORWARD);
		} else if(BRING_TO_FRONT.equals(getParameter())) {
			request = new ZOrderRequest(ZOrderRequest.REQ_BRING_TO_FRONT);
		} else if(SEND_BACKWARD.equals(getParameter())) {
			request = new ZOrderRequest(ZOrderRequest.REQ_SEND_BACKWARD);
		} else if(SEND_TO_BACK.equals(getParameter())) {
			request = new ZOrderRequest(ZOrderRequest.REQ_SEND_TO_BACK);
		}
		request.setPartsToOrder(getSelection());
		cmd = getSelection().get(0).getParent().getCommand(request);

		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}
}
