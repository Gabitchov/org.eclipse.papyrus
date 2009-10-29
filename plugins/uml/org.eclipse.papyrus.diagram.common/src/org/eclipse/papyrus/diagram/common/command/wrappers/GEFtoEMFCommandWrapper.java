/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Mario Cervera Ubeda (Prodevelop)
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.command.wrappers;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.gef.commands.Command;

// TODO: Auto-generated Javadoc
/**
 * A EMF Command that wraps a GEF command. Each method is redirected to the GEF one.
 */
public class GEFtoEMFCommandWrapper extends AbstractCommand {

	/**
	 * The wrapped GEF Command. Package-level visibility so that the command stack wrapper can
	 * access the field.
	 */
	private final Command gefCommand;

	/**
	 * Constructor.
	 * 
	 * @param gefCommand
	 *            the gef command
	 */
	public GEFtoEMFCommandWrapper(Command gefCommand) {
		super(gefCommand.getLabel());
		this.gefCommand = gefCommand;
	}

	/**
	 * Returns the wrapped GEF command.
	 * 
	 * @return the GEF command
	 */
	// @unused
	public Command getGEFCommand() {
		return gefCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return gefCommand.canExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#dispose()
	 */
	@Override
	public void dispose() {
		gefCommand.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return gefCommand.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {

		gefCommand.execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {

		gefCommand.redo();
	}
}
