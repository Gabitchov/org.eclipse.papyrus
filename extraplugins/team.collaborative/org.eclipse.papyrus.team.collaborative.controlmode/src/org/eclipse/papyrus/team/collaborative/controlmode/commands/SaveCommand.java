/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.controlmode.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.ui.ISaveablePart;


/**
 * The Class SaveCommand.
 * Command to save an editor
 */
public class SaveCommand extends AbstractTransactionalCommand {

	/** The editor. */
	private ISaveablePart editor;

	/**
	 * Instantiates a new save command.
	 * 
	 * @param domain
	 *        the domain
	 * @param editor
	 *        the editor
	 */
	public SaveCommand(TransactionalEditingDomain domain, ISaveablePart editor) {
		//Set list command to null the save command is secure with read only
		super(domain, "Save command", null);
		this.editor = editor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			editor.doSave(monitor);
		} catch (Exception e) {
			return CommandResult.newErrorCommandResult(e);
		}
		return CommandResult.newOKCommandResult();
	}

}
