/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Mario Cervera Ubeda (Prodevelop)
 * 
 * 
 * 
 * <pre>
 * @TODO : This class is copied as is from oep.diagram.common to avoid adding 
 * 	an undesired dependency between the model explorer plug-in and oep.diagram.common.
 *  oep.diagram.common should probably be split, moving general utility classes
 *  like this wrapper in a separate plug-in.
 * </pre>
 * 
 ******************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.handler;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;

/**
 * A EMF Command that wraps a GMF command. Each method is redirected to the GMF one.
 */
public class GMFtoEMFCommandWrapper extends AbstractCommand {

	/**
	 * The wrapped GMF Command. Package-level visibility so that the command stack wrapper can
	 * access the field.
	 */
	private final ICommand gmfCommand;

	/**
	 * Constructor.
	 * 
	 * @param gmfCommand
	 *        the gmf command
	 */
	public GMFtoEMFCommandWrapper(ICommand gmfCommand) {
		super(gmfCommand.getLabel());
		this.gmfCommand = gmfCommand;
	}

	/**
	 * Returns the wrapped GMF command.
	 * 
	 * @return the GMF command
	 */
	// @unused
	public ICommand getGMFCommand() {
		return gmfCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return gmfCommand.canExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#dispose()
	 */
	@Override
	public void dispose() {
		gmfCommand.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return gmfCommand.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
		try {
			gmfCommand.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		try {
			gmfCommand.redo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		try {
			gmfCommand.undo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}

	}

}
