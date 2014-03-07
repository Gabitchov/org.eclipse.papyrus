/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - adapted for self-nesting behaviour
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.eclipse.emf.transaction.util.ConditionalRedoCommand;


public class NestingTransactionalCommandStack extends TransactionalCommandStackImpl {

	private NestingTransactionalCommandStack childCommandStack;

	private final boolean nested;

	private boolean executing;

	public NestingTransactionalCommandStack() {
		this(false);
	}

	protected NestingTransactionalCommandStack(boolean nested) {
		this.nested = nested;
	}

	protected NestingTransactionalCommandStack getTopMostCommandStack() {
		if(childCommandStack == null) {
			return this;
		}
		return childCommandStack.getTopMostCommandStack();
	}

	protected void startNestedTransaction(Command command) {
		if(childCommandStack != null) {
			//Forwards to the current stack
			childCommandStack.startNestedTransaction(command);
		} else {
			//Start a new nested transaction in a new nested Stack
			childCommandStack = new NestingTransactionalCommandStack(true);
			childCommandStack.setEditingDomain(getDomain());

			childCommandStack.execute(command);
		}
	}

	public void commit() {
		if(childCommandStack != null) {
			disposeLastCommandStack();
		}
	}

	private boolean disposeLastCommandStack() {
		if(childCommandStack == null) {
			//I'm the last command stack
			dispose();
			return true;
		}

		//Propagates
		if(childCommandStack.disposeLastCommandStack()) {
			childCommandStack = null;
		}

		return false;
	}

	public void rollback() {
		if(childCommandStack != null) {
			while(canUndo()) {
				undo();
			}
			disposeLastCommandStack();
		}
	}

	@Override
	public void execute(Command command) {
		if(childCommandStack == null) {
			if(!executing) {
				executing = true;

				try {
					super.execute(command);
				} finally {
					executing = false;
				}
			} else {
				// Re-entrant command execution goes on a nested stack
				try {
					startNestedTransaction(command);
					commit();
				} catch (OperationCanceledException e) {
					rollback();
					// Propagate
					throw e;
				}
			}
		} else {
			childCommandStack.execute(command);
		}
	}

	@Override
	protected void handleError(Exception exception) {
		if(nested && (exception instanceof RollbackException)) {
			//A nested transaction rolled back
			RollbackException rbe = (RollbackException)exception;
			if(rbe.getStatus().getSeverity() == IStatus.CANCEL) {
				// Propagate
				throw new OperationCanceledException();
			}
		}

		if(exception instanceof OperationCanceledException) {
			rollback();
			// Propagate
			throw (OperationCanceledException)exception;
		} else {
			super.handleError(exception);
		}
	}

	@Override
	public Command getMostRecentCommand() {
		if(childCommandStack == null) {
			return super.getMostRecentCommand();
		} else {
			return childCommandStack.getMostRecentCommand();
		}
	}

	@Override
	public Command getRedoCommand() {
		if(childCommandStack == null) {
			return super.getRedoCommand();
		} else {
			return childCommandStack.getRedoCommand();
		}
	}

	@Override
	public Command getUndoCommand() {
		if(childCommandStack == null) {
			return super.getUndoCommand();
		} else {
			return childCommandStack.getUndoCommand();
		}
	}

	@Override
	public void undo() {
		if(childCommandStack == null) {
			super.undo();
		} else {
			childCommandStack.undo();
		}
	}

	@Override
	public boolean canUndo() {
		if(childCommandStack == null) {
			return super.canUndo();
		} else {
			return childCommandStack.canUndo();
		}
	}

	@Override
	public boolean canRedo() {
		if(childCommandStack == null) {
			return super.canRedo();
		} else {
			return childCommandStack.canRedo();
		}
	}

	@Override
	public void redo() {
		if(childCommandStack == null) {
			super.redo();
		} else {
			childCommandStack.redo();
		}
	}

	@Override
	protected void doExecute(Command command, Map<?, ?> options) throws InterruptedException, RollbackException {
		InternalTransaction tx = createTransaction(command, options);
		boolean completed = false;

		try {
			basicExecute(command);

			// new in EMF 2.4:  AbortExecutionException can cause the
			// command not to be added to the undo stack
			completed = mostRecentCommand == command;

			// commit the transaction now
			tx.commit();
		} catch (OperationCanceledException e) {
			// snuff the exception, because this is expected (user asked to
			//    cancel the model change).  We will rollback, below
			if(nested) {
				// Propagate to the nesting context
				throw e;
			}
		} finally {
			if((tx != null) && (tx.isActive())) {
				// roll back (some exception, possibly being thrown now or
				//    an operation cancel, has occurred)
				rollback(tx);
				handleRollback(command, null);
			} else {
				// the transaction has already incorporated the triggers
				//    into its change description, so the recording command
				//    doesn't need them again
				if(!(command instanceof RecordingCommand) && completed) {
					Command triggerCommand = tx.getTriggers();

					if(triggerCommand != null) {
						// replace the executed command by a compound of the
						//    original and the trigger commands
						CompoundCommand compound = new ConditionalRedoCommand.Compound();
						compound.append(mostRecentCommand);
						compound.append(triggerCommand);
						mostRecentCommand = compound;
						commandList.set(top, mostRecentCommand);
					}
				}
			}
		}
	}

	@Override
	protected void basicExecute(Command command) {
		try {
			super.basicExecute(command);
		} catch (OperationCanceledException e) {
			// Ensure disposal of the command (when handleException() propagates a cancel, we will miss the chance)
			command.dispose();
			throw e;
		}
	}
}
