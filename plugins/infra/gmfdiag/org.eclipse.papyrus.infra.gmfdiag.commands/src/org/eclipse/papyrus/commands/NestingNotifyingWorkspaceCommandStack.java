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
package org.eclipse.papyrus.commands;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RollbackException;


public class NestingNotifyingWorkspaceCommandStack extends NotifyingWorkspaceCommandStack {

	private NestingNotifyingWorkspaceCommandStack childCommandStack;

	private final boolean nested;
	
	private boolean executing;
	
	protected IUndoContext defaultUndoContext;

	public NestingNotifyingWorkspaceCommandStack(IOperationHistory history) {
		this(false, history, null);
	}

	protected NestingNotifyingWorkspaceCommandStack(boolean nested, IOperationHistory history, IUndoContext defaultUndoContext) {
		super(history);
		this.nested = nested;
		this.defaultUndoContext = defaultUndoContext;
	}

	protected NestingNotifyingWorkspaceCommandStack(boolean nested, IOperationHistory history) {
		this(nested, history, computeNestedUndoContext());
	}

	private static IUndoContext computeNestedUndoContext() {
		return new IUndoContext() {

			public boolean matches(IUndoContext context) {
				return context == this;
			}

			public String getLabel() {
				return "Nested Undo Context";
			}
		};
	}

	@Override
	public IUndoContext getDefaultUndoContext() {
		if(defaultUndoContext == null) {
			return super.getDefaultUndoContext();
		}
		return defaultUndoContext;
	}

	protected NestingNotifyingWorkspaceCommandStack getTopMostCommandStack() {
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
			childCommandStack = createNestedCommandStack(getOperationHistory());
			childCommandStack.setEditingDomain(getDomain());

			childCommandStack.execute(command);
		}
	}

	protected NestingNotifyingWorkspaceCommandStack createNestedCommandStack(IOperationHistory history) {
		return new NestingNotifyingWorkspaceCommandStack(true, history);
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
			while (canUndo()) {
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
		if (nested && (exception instanceof RollbackException)) {
			//A nested transaction rolled back
			RollbackException rbe = (RollbackException) exception;
			if (rbe.getStatus().getSeverity() == IStatus.CANCEL) {
				// Propagate
				throw new OperationCanceledException();
			}
		}
		
		if (exception instanceof OperationCanceledException) {
			rollback();
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

}
