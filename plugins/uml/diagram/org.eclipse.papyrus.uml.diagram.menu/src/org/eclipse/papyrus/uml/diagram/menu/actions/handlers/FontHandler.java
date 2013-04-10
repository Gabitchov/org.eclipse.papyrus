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
package org.eclipse.papyrus.uml.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.papyrus.uml.diagram.menu.actions.FontAction;

/**
 * 
 * Handler for the FontAction
 * 
 */
public class FontHandler extends AbstractGraphicalCommandHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public FontHandler() {
		super(null);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		FontAction action = new FontAction(getSelectedElements());
		if(action.isEnabled()) {
			return action.getCommand();
		}
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		FontAction action = new FontAction(getSelectedElements());
		setBaseEnabled(action.isEnabled());
	}
}
