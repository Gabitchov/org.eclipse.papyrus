/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;

// TODO: Auto-generated Javadoc
/**
 * The Class GMFToEMFCommand.
 */
public class GMFToEMFCommand implements Command {

	/** The GMF command. */
	private ICommand GMFCommand = null;

	/**
	 * Instantiates a new gMF to emf command.
	 * 
	 * @param gmfCommand
	 *            the gmf command
	 */
	public GMFToEMFCommand(ICommand gmfCommand) {
		GMFCommand = gmfCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#canExecute()
	 */
	public boolean canExecute() {
		return GMFCommand != null && GMFCommand.canExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#canUndo()
	 */
	public boolean canUndo() {
		return GMFCommand != null && GMFCommand.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#chain(org.eclipse.emf.common.command.Command)
	 */
	public Command chain(Command command) {
		throw new UnsupportedOperationException("Cannot compose GMF command with EMF command");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#dispose()
	 */
	public void dispose() {
		if (GMFCommand != null) {
			GMFCommand.dispose();
		}
		GMFCommand = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
		if (GMFCommand != null) {
			try {
				GMFCommand.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException ex) {
				return;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#getAffectedObjects()
	 */
	public Collection<?> getAffectedObjects() {
		if (GMFCommand != null) {
			return GMFCommand.getAffectedFiles();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#getDescription()
	 */
	public String getDescription() {
		if (GMFCommand != null) {
			return GMFCommand.getLabel();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#getLabel()
	 */
	public String getLabel() {
		if (GMFCommand != null) {
			return GMFCommand.getLabel();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#getResult()
	 */
	public Collection<?> getResult() {
		if (GMFCommand != null) {
			CommandResult result = GMFCommand.getCommandResult();
			Object returnValue = result.getReturnValue();
			if (result.getStatus().equals(IStatus.OK) && returnValue != null) {
				java.util.List results = new ArrayList();
				results.add(returnValue);
				return results;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		if (GMFCommand != null) {
			try {
				GMFCommand.redo(new NullProgressMonitor(), null);
			} catch (ExecutionException ex) {
				return;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#undo()
	 */
	public void undo() {
		if (GMFCommand != null) {
			try {
				GMFCommand.undo(new NullProgressMonitor(), null);
			} catch (ExecutionException ex) {
				return;
			}
		}
	}

}
