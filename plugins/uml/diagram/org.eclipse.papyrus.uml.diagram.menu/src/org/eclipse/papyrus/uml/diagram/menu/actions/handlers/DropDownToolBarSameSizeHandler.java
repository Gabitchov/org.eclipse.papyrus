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
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.SizeAction;


/**
 * 
 * The default action for the Size ToolBar is the Make Same Size Action
 * 
 */
public class DropDownToolBarSameSizeHandler extends GraphicalCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() {
		SizeAction action = new SizeAction(SizeAction.PARAMETER_BOTH, getSelectedElements());
		return action.getCommand();
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return always true
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}


}
