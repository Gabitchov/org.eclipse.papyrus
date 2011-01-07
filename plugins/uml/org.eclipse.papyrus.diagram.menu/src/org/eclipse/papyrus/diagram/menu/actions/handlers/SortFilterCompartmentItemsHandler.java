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
package org.eclipse.papyrus.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.papyrus.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.diagram.menu.actions.SortFilterCompartmentItemsAction;

/**
 * Handler for the SortFilterCompartmentItemsAction
 * 
 * 
 * 
 */
public class SortFilterCompartmentItemsHandler extends GraphicalCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		SortFilterCompartmentItemsAction action = new SortFilterCompartmentItemsAction(getSelectedElements());
		Command cmd = action.getCommand();
		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}

}
