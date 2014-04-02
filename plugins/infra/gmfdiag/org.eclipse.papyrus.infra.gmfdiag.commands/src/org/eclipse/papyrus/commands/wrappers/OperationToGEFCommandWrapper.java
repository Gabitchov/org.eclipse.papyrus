/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 430701
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands.wrappers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.commands.INonDirtying;

/**
 * A GEF Command that wraps an undoable operation. Each method is redirected to the operation. <br>
 * In case the {@link IUndoableOperation} is a {@link ICommand}, you should use {@link org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy} instead of this implementation.
 * 
 * @author vhemery
 */
public class OperationToGEFCommandWrapper extends Command {

	/** the IUndoableOperation which calls are redirected to */
	private IUndoableOperation operation = null;

	/**
	 * Construct a new command wrapper
	 * 
	 * @param baseOperation
	 */
	public OperationToGEFCommandWrapper(IUndoableOperation baseOperation) {
		super(baseOperation.getLabel());
		operation = baseOperation;
		Assert.isNotNull(operation);
	}
	
	/**
	 * Wraps the given {@code operation}, accounting for possible non-dirty state.
	 * 
	 * @param operation
	 *        an operation to wrap
	 * @return the best wrapper for the {@code operation}
	 */
	public static Command wrap(IUndoableOperation operation) {
		if(operation instanceof INonDirtying) {
			return new NonDirtying(operation);
		}
		return new OperationToGEFCommandWrapper(operation);
	}

	/**
	 * Get the {@link IUndoableOperation} to which calls are redirected
	 * 
	 * @return operation
	 */
	public IUndoableOperation getOperation() {
		return operation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return operation.canExecute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canUndo() {
		return operation.canUndo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		operation.dispose();
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Activator.log.error(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		try {
			operation.redo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Activator.log.error(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		try {
			operation.undo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Activator.log.error(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLabel() {
		return operation.getLabel();
	}
	
	//
	// Nested types
	//
	
	/**
	 * A non-dirtying wrapper for non-dirtying commands.
	 */
	public static class NonDirtying extends OperationToGEFCommandWrapper implements INonDirtying {

		public NonDirtying(IUndoableOperation operation) {
			super(operation);

			if(!(operation instanceof INonDirtying)) {
				throw new IllegalArgumentException("Wrapped operation is not non-dirtying"); //$NON-NLS-1$
			}
		}
		
	}
}
