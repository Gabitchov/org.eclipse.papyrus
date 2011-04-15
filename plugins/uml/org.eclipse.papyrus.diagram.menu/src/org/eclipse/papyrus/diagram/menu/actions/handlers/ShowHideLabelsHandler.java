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
package org.eclipse.papyrus.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.diagram.menu.actions.ShowHideLabelsAction;

/**
 * Handler for the {@link ShowHideLabelsAction}
 * 
 * 
 * 
 */
public class ShowHideLabelsHandler extends AbstractGraphicalCommandHandler {

	/**
	 * parameter ID for this action
	 */
	public static final String parameterID = "show_hide_link_label_parameter"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameterID
	 */
	public ShowHideLabelsHandler() {
		super(parameterID);
	}

	/**
	 * 
	 * @param parameter
	 *        the value of the parameter for the handler
	 */
	public ShowHideLabelsHandler(String parameter) {
		super(parameterID, parameter);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.handlers.AbstractGraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		ShowHideLabelsAction action = new ShowHideLabelsAction(this.parameter, getSelectedElements());
		return action.getCommand();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.handlers.AbstractGraphicalCommandHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		if(this.parameter.equals(ShowHideLabelsAction.MANAGE_PARAMETER)) {
			//we test if the action can be executed with an other parameter (because getCommand() for this parameter open a dialog
			ShowHideLabelsAction action = new ShowHideLabelsAction(ShowHideLabelsAction.SHOW_PARAMETER, getSelectedElements());
			return action.getCommand().canExecute();

		} else {
			return super.isEnabled();
		}
	}
}
