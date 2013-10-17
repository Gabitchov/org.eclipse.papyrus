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
import org.eclipse.papyrus.uml.diagram.common.handlers.ParametricAndListeningHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.RouteAction;

public class RoutingHandler extends ParametricAndListeningHandler {

	/** the action executed by this handler */
	protected RouteAction action = null;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public RoutingHandler() {
		super("org.eclipse.papyrus.uml.diagram.menu.commandRoutingParameter"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() {
		super.getCommand();
		this.action = new RouteAction(this.parameter, this.getSelectedElements());
		Command cmd = action.getCommand();
		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}
}
