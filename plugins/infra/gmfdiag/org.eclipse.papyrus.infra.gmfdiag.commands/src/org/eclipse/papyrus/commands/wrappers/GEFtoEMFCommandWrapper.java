/***************************************************************************
 * Copyright (c) 2007, 2014 Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana, CEA, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Mario Cervera Ubeda (Prodevelop)
 *    Christian W. Damus (CEA) - bug 430701
 *
 ******************************************************************************/
package org.eclipse.papyrus.commands.wrappers;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.commands.INonDirtying;

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
	 *        the gef command
	 */
	public GEFtoEMFCommandWrapper(Command gefCommand) {
		super(gefCommand.getLabel());
		this.gefCommand = gefCommand;
	}
	
	/**
	 * Wraps the given {@code command}, accounting for possible non-dirty state.
	 * 
	 * @param command
	 *        a command to wrap
	 * @return the best wrapper for the {@code command}
	 */
	public static org.eclipse.emf.common.command.Command wrap(Command command) {
		if(command instanceof INonDirtying) {
			return new NonDirtying(command);
		}
		return new GEFtoEMFCommandWrapper(command);
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

	/**
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 * 
	 */
	@Override
	public void undo() {
		gefCommand.undo();
	}
	
	//
	// Nested types
	//
	
	/**
	 * A non-dirtying wrapper for non-dirtying commands.
	 */
	public static class NonDirtying extends GEFtoEMFCommandWrapper implements AbstractCommand.NonDirtying {

		public NonDirtying(Command command) {
			super(command);

			if(!(command instanceof INonDirtying)) {
				throw new IllegalArgumentException("Wrapped command is not non-dirtying"); //$NON-NLS-1$
			}
		}
		
	}
}
