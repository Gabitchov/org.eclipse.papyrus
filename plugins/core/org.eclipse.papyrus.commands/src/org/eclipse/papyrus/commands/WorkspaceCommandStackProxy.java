/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.OperationToGEFCommandWrapper;

/**
 * This GEF command stack delegates everything to a WorkspaceCommandStackImpl. It should be used to avoid having to manage several command stacks.
 * 
 * @author vhemery
 */
public class WorkspaceCommandStackProxy extends DiagramCommandStack {

	/** The actual stack used for everything */
	protected WorkspaceCommandStackImpl stack;

	/** map with registered listeners and the corresponding proxy registered to actual map */
	protected Map<CommandStackEventListener, CommandStackListener> proxyEventListeners = new HashMap<CommandStackEventListener, CommandStackListener>();

	/** map with registered listeners and the corresponding proxy registered to actual map */
	protected Map<org.eclipse.gef.commands.CommandStackListener, CommandStackListener> proxyListeners = new HashMap<org.eclipse.gef.commands.CommandStackListener, CommandStackListener>();

	/** when converting from gef to gmf keep the correspondence so it can be retrieved easily */
	protected Map<ICommand, Command> gmfToGefCommands = new HashMap<ICommand, Command>();

	/**
	 * Construct a new command stack proxy.
	 * Should be initialized with diagram edit domain and redirection stack.
	 * 
	 * @param editDomain
	 *        the editing domain assoicated with this stack
	 * @param actualCommandStack
	 *        the command stack to which all actions will be redirected
	 */
	public WorkspaceCommandStackProxy(IDiagramEditDomain editDomain, WorkspaceCommandStackImpl actualCommandStack) {
		super(editDomain);
		stack = actualCommandStack;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCommandStackEventListener(final CommandStackEventListener listener) {
		if(listener != null && proxyEventListeners.get(listener) == null) {
			CommandStackEventListenerProxy proxy = new CommandStackEventListenerProxy(this, listener);
			stack.addCommandStackListener(proxy);
			proxyEventListeners.put(listener, proxy);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addCommandStackListener(final org.eclipse.gef.commands.CommandStackListener listener) {
		if(listener != null && proxyEventListeners.get(listener) == null) {
			CommandStackListener proxy = new CommandStackListener() {

				public void commandStackChanged(EventObject event) {
					listener.commandStackChanged(event);
				}
			};
			stack.addCommandStackListener(proxy);
			proxyListeners.put(listener, proxy);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canRedo() {
		return stack.canRedo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canUndo() {
		return stack.canUndo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		for(CommandStackListener listener : proxyEventListeners.values()) {
			if(listener != null) {
				stack.removeCommandStackListener(listener);
			}
		}
		proxyEventListeners.clear();
		for(CommandStackListener listener : proxyListeners.values()) {
			if(listener != null) {
				stack.removeCommandStackListener(listener);
			}
		}
		proxyListeners.clear();
		// do not dispose Workspace command stack which is still used
		//stack.dispose();
		stack = null;
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Command command) {
		// convert into a GMF command because
		// file approvers works with it
		ICommand iCommand = getICommand(command);
		gmfToGefCommands.put(iCommand, command);
		execute(iCommand);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated progress monitor is unused, use {@link #execute(Command)} instead
	 */
	@Override
	public void execute(Command command, IProgressMonitor progressMonitor) {
		execute(command);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void execute(ICommand command) {
		GMFtoEMFCommandWrapper proxy = null;
		if(command != null) {
			proxy = new GMFtoEMFCommandWrapper(command);
		}
		stack.execute(proxy);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated progress monitor is unused, use {@link #execute(ICommand)} instead
	 */
	@Override
	protected void execute(ICommand command, IProgressMonitor progressMonitor) {
		execute(command);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void flush() {
		stack.flush();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getCommands() {
		IOperationHistory history = stack.getOperationHistory();
		IUndoableOperation[] undos = history.getUndoHistory(stack.getDefaultUndoContext());
		IUndoableOperation[] redos = history.getRedoHistory(stack.getDefaultUndoContext());

		List<Command> commands = new ArrayList<Command>(undos.length + redos.length);
		for(IUndoableOperation undo : undos) {
			if(undo instanceof ICommand) {
				commands.add(new ICommandProxy((ICommand)undo));
			} else if(undo != null) {
				commands.add(new OperationToGEFCommandWrapper(undo));
			} else {
				commands.add(null);
			}
		}
		for(int i = redos.length - 1; i >= 0; i--) {
			IUndoableOperation redo = redos[i];
			if(redo instanceof ICommand) {
				commands.add(new ICommandProxy((ICommand)redo));
			} else if(redo != null) {
				commands.add(new OperationToGEFCommandWrapper(redo));
			} else {
				commands.add(null);
			}
		}
		return commands.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getMostRecentCommand() {
		return unwrap(stack.getMostRecentCommand());
	}

	/**
	 * Unwrap the command if it has been wrap by this CommandStack,
	 * return a wrapper otherwise.
	 * 
	 * @param cmd
	 * @return
	 */
	protected Command unwrap(org.eclipse.emf.common.command.Command cmd) {
		if(cmd != null) {
			if(cmd instanceof GMFtoEMFCommandWrapper) {
				ICommand gmfCommand = ((GMFtoEMFCommandWrapper)cmd).getGMFCommand();
				Command correspondingCommand = gmfToGefCommands.get(gmfCommand);
				if(correspondingCommand != null) {
					return correspondingCommand;
				}
			}

			return new EMFtoGEFCommandWrapper(cmd);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IOperationHistory getOperationHistory() {
		return stack.getOperationHistory();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getRedoCommand() {
		return unwrap(stack.getRedoCommand());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getUndoCommand() {
		return unwrap(stack.getUndoCommand());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IUndoContext getUndoContext() {
		return stack.getDefaultUndoContext();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getUndoLimit() {
		return stack.getOperationHistory().getLimit(stack.getDefaultUndoContext());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		return stack.isSaveNeeded();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void markSaveLocation() {
		stack.saveIsDone();
	}

	/**
	 * Sends notification to all {@link CommandStackListener}s.
	 * 
	 * @deprecated
	 */
	protected void notifyListeners() {
		EventObject event = new EventObject(this);
		for(org.eclipse.gef.commands.CommandStackListener listener : proxyListeners.keySet()) {
			listener.commandStackChanged(event);
		}
	}

	/**
	 * Notifies command stack event listeners that the command stack has changed
	 * to the specified state.
	 * 
	 * @param command
	 *        the command
	 * @param state
	 *        the current stack state
	 */
	protected void notifyListeners(Command command, int state) {
		CommandStackEvent event = new CommandStackEvent(this, command, state);
		for(CommandStackEventListener eventListener : proxyEventListeners.keySet()) {
			eventListener.stackChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		stack.redo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCommandStackEventListener(CommandStackEventListener listener) {
		if(listener != null) {
			CommandStackListener proxy = proxyEventListeners.remove(listener);
			if(proxy != null) {
				stack.removeCommandStackListener(proxy);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeCommandStackListener(org.eclipse.gef.commands.CommandStackListener listener) {
		if(listener != null) {
			CommandStackListener proxy = proxyListeners.remove(listener);
			if(proxy != null) {
				stack.removeCommandStackListener(proxy);
			}
		}
	}

	/**
	 * This method has no effect since the emf stack does not support history change.
	 * 
	 * @param operationHistory
	 *        my operation history delegate
	 */
	@Override
	public void setOperationHistory(IOperationHistory operationHistory) {
		//do nothing
	}

	/**
	 * This method has no effect since the emf stack does not support history change.
	 * 
	 * @param undoContext
	 *        my undo context
	 */
	@Override
	public void setUndoContext(IUndoContext undoContext) {
		//do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUndoLimit(int undoLimit) {
		stack.getOperationHistory().setLimit(stack.getDefaultUndoContext(), undoLimit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		stack.undo();
	}

}
