/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

/**
 * 
 * The SnapBack action allows to reset label to their initial position in the diagram
 * 
 */
public class SnapBackAction {

	/**
	 * The selected edit part to do the action
	 */
	private List<IGraphicalEditPart> selectedElement;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedElement
	 *        the selected edit part to do the action
	 */
	public SnapBackAction(final List<IGraphicalEditPart> selectedElement) {
		this.selectedElement = selectedElement;
	}

	/**
	 * 
	 * @return
	 *         the command to do the action
	 */
	public Command getCommand() {
		Request request = new Request(RequestConstants.REQ_SNAP_BACK);
		return getBuildedCommand("Snap Back Command", request); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param commandName
	 *        a name for this command
	 * @param request
	 *        the request used to get this command
	 * @return
	 */
	public Command getBuildedCommand(final String commandName, final Request request) {
		CompoundCommand command = new CompoundCommand(commandName);
		for(IGraphicalEditPart current : selectedElement) {
			Command cmd = current.getCommand(request);
			if(cmd != null) {
				command.add(cmd);
			}
		}
		return command;
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if the action can be executed
	 */
	public boolean isEnabled() {
		return getCommand().canExecute();
	}
}
