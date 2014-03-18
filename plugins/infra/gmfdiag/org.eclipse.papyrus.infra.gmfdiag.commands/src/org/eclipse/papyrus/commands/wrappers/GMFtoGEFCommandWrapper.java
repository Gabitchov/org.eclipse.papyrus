/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi  benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands.wrappers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;

/**
 * A GEF Command that wraps a GMF command. Each method is redirected to the GMF one.
 */
public class GMFtoGEFCommandWrapper extends Command {

	/**
	 * The wrapped GMF Command. Package-level visibility so that the command stack wrapper can
	 * access the field.
	 */
	private final ICommand gmfCommand;

	
	/**
	 * Constructor.
	 * 
	 * @param command
	 *        the wrapped EMF command
	 */
	public GMFtoGEFCommandWrapper(final ICommand command) {
		super(command.getLabel());
		gmfCommand = command;
	}

	/**
	 * Returns the wrapped GMF command.
	 * 
	 * @return the GMF command
	 */
	public ICommand getGMFCommand() {
		return gmfCommand;
	}

	/**
	 * Dispose.
	 * 
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		gmfCommand.dispose();
	}

	/**
	 * Can execute.
	 * 
	 * @return true, if can execute
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return gmfCommand.canExecute();
	}

	/**
	 * Can undo.
	 * 
	 * @return true, if can undo
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return gmfCommand.canUndo();
	}

	/**
	 * Execute.
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		try {
			gmfCommand.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	/**
	 * Redo.
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		try {
			gmfCommand.redo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	/**
	 * Undo.
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		try {
			gmfCommand.undo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}
}
