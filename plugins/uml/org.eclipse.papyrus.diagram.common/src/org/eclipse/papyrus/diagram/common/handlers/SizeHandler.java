/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.handlers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.papyrus.diagram.common.actions.SizeAction;


/**
 * The Class SizeHandler.
 */
public class SizeHandler extends ParametricAndListeningHandler {

	/** the SizeAction */
	SizeAction action;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public SizeHandler() {
		super("org.eclipse.papyrus.diagram.common.commandSizeParameter"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.handlers.ParametricAndListeningHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		super.getCommand();
		this.action = new SizeAction(this.parameter, getSelectedElements());
		Command cmd = action.getCommand();
		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}
}
