/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.editor;

import java.util.Collections;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gmf.runtime.common.ui.action.ActionManager;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;


/**
 * Initialize editing domain.
 * 
 * 
 */
public class EditingDomainService implements CommandStackListener, org.eclipse.emf.common.command.CommandStackListener {

	/**
	 * undo context.
	 */
	private IUndoContext undoContext;

	private BackboneContext defaultContext;


	private Set<CommandStackListener> commandStackListeners = Collections
			.synchronizedSet(new HashSet<CommandStackListener>());


	/**
	 * @param defaultContext
	 * @param commandStackListener
	 */
	public EditingDomainService(BackboneContext defaultContext) {
		this.defaultContext = defaultContext;
		configureDiagramEditDomain();
	}

	/**
	 * Returns the diagram edit domain.
	 * 
	 * @return The diagram edit domain.
	 */
	private DiagramEditDomain getDiagramEditDomain() {
		return defaultContext.getDiagramEditDomain();
	}

	/**
	 * Returns the edit domain.
	 * 
	 * @return The edit domain.
	 */
	public EditDomain getEditDomain() {
		return defaultContext.getDiagramEditDomain();
	}

	/**
	 * Returns the editing domain.
	 * 
	 * @return the editing domain.
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return defaultContext.getTransactionalEditingDomain();
	}

	/**
	 * TODO move it to GmfContext ?
	 */
	private ActionManager createActionManager() {
		return new ActionManager(createOperationHistory());
	}

	/**
	 * Gets the action manager for this diagram editor. The action manager's command manager is used by my edit domain's command stack when executing
	 * commands. This is the action manager that is
	 * returned when I am asked to adapt to an <code>ActionManager</code>.
	 * 
	 * @return the action manager
	 */
	private ActionManager getActionManager() {
		return getDiagramEditDomain().getActionManager();
	}

	/**
	 * Create my operation history.
	 * 
	 * @return my operation history
	 *         TODO move it to GmfContext ?
	 */
	private IOperationHistory createOperationHistory() {
		return OperationHistoryFactory.getOperationHistory();
	}

	/**
	 * Gets my undo context. Lazily initializes my undo context if it has not been set.
	 * 
	 * @return my undo context
	 *         TODO move it to GmfContext ?
	 */
	private IUndoContext getUndoContext() {

		if(undoContext == null) {
			TransactionalEditingDomain domain = defaultContext.getTransactionalEditingDomain();

			if(domain != null) {
				undoContext = new EditingDomainUndoContext(domain);

			} else {
				undoContext = new ObjectUndoContext(this);
			}
		}
		return undoContext;
	}

	/**
	 * Configures my diagram edit domain with its command stack.
	 * 
	 * TODO move it to GmfContext ?
	 */
	protected void configureDiagramEditDomain() {

		DiagramEditDomain editDomain = getDiagramEditDomain();

		if(editDomain != null) {
			CommandStack stack = editDomain.getCommandStack();

			if(stack != null) {
				stack.removeCommandStackListener(this);
				// dispose the old stack
				stack.dispose();
			}

			// create and assign the new stack
			DiagramCommandStack diagramStack = new DiagramCommandStack(getDiagramEditDomain());
			// editDomain.setActionManager(createActionManager());
			// diagramStack.setOperationHistory(getOperationHistory());
			editDomain.setCommandStack(diagramStack);

			diagramStack.addCommandStackListener(this);
			defaultContext.getTransactionalEditingDomain().getCommandStack().addCommandStackListener(this);

			// changes made on the stack can be undone from this editor
			diagramStack.setUndoContext(getUndoContext());

		}

	}

	/**
	 * Returns the operation history from my action manager.
	 * 
	 * @return the operation history
	 */
	private IOperationHistory getOperationHistory() {
		return getActionManager().getOperationHistory();
	}

	/**
	 * Add a command stack listener.
	 * Actual implementation only allows one listener. If we need more listener, change the implementation to allow it.
	 * 
	 * @param listener
	 */
	public void addCommandStackListener(CommandStackListener listener) {
		commandStackListeners.add(listener);
	}

	/**
	 * Remove the specified command stack listener.
	 * 
	 * @param listener
	 */
	public void removeCommandStackListener(CommandStackListener listener) {
		commandStackListeners.remove(listener);
	}

	/**
	 * Relay the event from the stack to the listeners.
	 * 
	 * @param event
	 */
	public void commandStackChanged(EventObject event) {
		for(CommandStackListener listener : commandStackListeners) {
			listener.commandStackChanged(event);
		}
	}


}
