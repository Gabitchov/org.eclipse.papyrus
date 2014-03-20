/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos, CEA, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos) - Initial API and implementation
 *  Arthur Daussy (Atos) - 363826: [Model Explorer] Drag and drop and undo, incorrect behavior
 *  Christian W. Damus (CEA) - 404220: Add contexts for tracking objects changed by operations (CDO)
 *  Christian W. Damus (CEA) - bug 402525
 *  Christian W. Damus (CEA) - bug 430648
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands;

import static org.eclipse.papyrus.commands.util.OperationUtils.anyDirtying;
import static org.eclipse.papyrus.commands.util.OperationUtils.anyDirtyingAfter;

import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.UndoContext;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.impl.AbstractTransactionalCommandStack;
import org.eclipse.emf.transaction.impl.EMFCommandTransaction;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TriggerCommandTransaction;
import org.eclipse.emf.transaction.util.TriggerCommand;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.emf.workspace.IResourceUndoContextPolicy;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.emf.workspace.impl.EMFOperationTransaction;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;
import org.eclipse.emf.workspace.internal.EMFWorkspacePlugin;
import org.eclipse.emf.workspace.internal.EMFWorkspaceStatusCodes;
import org.eclipse.emf.workspace.internal.Tracing;
import org.eclipse.emf.workspace.internal.l10n.Messages;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.util.NonDirtyingUtils;

/**
 * Copied from WorkspaceCommandStackImpl but modify in order to change the
 * IUndoContext. We want to make it point the the TransactionalEditingDomain. To
 * see what really change in this class from original implementation look for
 * "HAS CHANGE FROM ORIGINAL IMPLEMENTATION" in Java Doc.
 * 
 */
public class NotifyingWorkspaceCommandStack extends AbstractTransactionalCommandStack// AbstractTransactionalCommandStack
implements IWorkspaceCommandStack {

	private final IOperationHistory history;

	private DomainListener domainListener;

	private IResourceUndoContextPolicy undoContextPolicy = IResourceUndoContextPolicy.DEFAULT;

	private IUndoableOperation currentOperation;

	private Set<Resource> historyAffectedResources;

	/**
	 * HAS CHANGE FROM ORIGINAL IMPLEMENTATION TO USE {@link EditingDomainUndoContext}
	 */
	private IUndoContext defaultContext = null;

	private IUndoContext savedContext = null;

	private IUndoableOperation mostRecentOperation;

	/**
	 * Initializes me with the operation history to which I delegate command
	 * execution.
	 * 
	 * @param history
	 *        my operation history
	 */
	public NotifyingWorkspaceCommandStack(IOperationHistory history) {
		super();
		this.history = history;
		domainListener = new DomainListener();
		defaultContext = new UndoContext() {

			@Override
			public String getLabel() {
				return getDefaultUndoContextLabel();
			}

			@Override
			public String toString() {
				return getLabel();
			}
		};
	}

	/**
	 * map with registered listeners and the corresponding proxy registered to
	 * actual map
	 */
	private Map<CommandStackListener, IOperationHistoryListener> proxyOperationListeners = new HashMap<CommandStackListener, IOperationHistoryListener>();

	@Override
	public void addCommandStackListener(final CommandStackListener listener) {
		removeCommandStackListener(listener);
		IOperationHistoryListener proxy = new IOperationHistoryListener() {

			public void historyNotification(OperationHistoryEvent event) {
				int type = event.getEventType();
				// emf stack only needs to be notified when an operation is
				// finished
				if(OperationHistoryEvent.DONE == type || OperationHistoryEvent.REDONE == type || OperationHistoryEvent.UNDONE == type) {
					listener.commandStackChanged(new EventObject(NotifyingWorkspaceCommandStack.this));
				}
			}
		};
		getOperationHistory().addOperationHistoryListener(proxy);
		proxyOperationListeners.put(listener, proxy);
	}

	@Override
	public void removeCommandStackListener(CommandStackListener listener) {
		IOperationHistoryListener proxy = proxyOperationListeners.remove(listener);
		if(proxy != null) {
			getOperationHistory().removeOperationHistoryListener(proxy);
		}
	}

	/**
	 * Extends the superclass implementation to add/remove listeners on the
	 * editing domain. HAS CHANGE FROM ORIGINAL IMPLEMENTATION TO USE {@link EditingDomainUndoContext}
	 */
	@Override
	public void setEditingDomain(InternalTransactionalEditingDomain domain) {
		InternalTransactionalEditingDomain oldDomain = getDomain();
		if(oldDomain != null) {
			oldDomain.removeResourceSetListener(domainListener);
			history.removeOperationHistoryListener(domainListener);
		}
		super.setEditingDomain(domain);
		/*
		 * HAS CHANGE FROM ORIGINAL IMPLEMENTATION TO USE {@link
		 * EditingDomainUndoContext}
		 */
		if(getDomain() != null) {
			boolean domainHasChanged = oldDomain == null || !oldDomain.equals(getDomain());
			if(domainHasChanged) {
				defaultContext = new EditingDomainUndoContext(domain, getDefaultUndoContextLabel());
			}
		}
		if(domain != null) {
			history.addOperationHistoryListener(domainListener);
			domain.addResourceSetListener(domainListener);
		}
	}

	// Documentation copied from the method specification
	public final IOperationHistory getOperationHistory() {
		return history;
	}

	// Documentation copied from the method specification
	public IUndoContext getDefaultUndoContext() {
		return defaultContext;
	}

	/**
	 * Obtains the label to display for the default undo context that I apply to
	 * operations executed through me as {@link Command}s. Subclasses may
	 * override to customize the label.
	 * 
	 * @return my default undo context label
	 * 
	 * @since 1.2
	 */
	protected String getDefaultUndoContextLabel() {
		String domainID = (getDomain() == null) ? null : getDomain().getID();
		if(domainID == null) {
			domainID = String.valueOf(domainID); // guaranteed to be safe
		}
		return NLS.bind(Messages.cmdStkCtxLabel, domainID);
	}

	private final IUndoContext getSavedContext() {
		if(savedContext == null) {
			savedContext = new UndoContext() {

				@Override
				public String getLabel() {
					return getSavepointUndoContextLabel();
				}

				@Override
				public String toString() {
					return getLabel();
				}
			};
		}
		return savedContext;
	}

	/**
	 * Obtains the label to display for the save-point undo context that I apply
	 * to the last operation in my {@linkplain #getDefaultUndoContext() default
	 * undo context} that was executed at the time save was performed (as
	 * indicated by invocation of the {@link #saveIsDone()} method). Subclasses
	 * may override to customize the label.
	 * 
	 * @return my save-point undo context label
	 * 
	 * @since 1.2
	 */
	protected String getSavepointUndoContextLabel() {
		String domainID = (getDomain() == null) ? null : getDomain().getID();
		if(domainID == null) {
			domainID = String.valueOf(domainID); // guaranteed to be safe
		}
		return NLS.bind(Messages.cmdStkSaveCtxLabel, domainID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 1.1
	 */
	@Override
	protected void doExecute(Command command, Map<?, ?> options) throws InterruptedException, RollbackException {
		IUndoableOperation oper = NonDirtyingUtils.wrap(getDomain(), command, options);
		// add the appropriate context
		oper.addContext(getDefaultUndoContext());
		try {
			IStatus status = history.execute(oper, new NullProgressMonitor(), null);
			if(status.getSeverity() >= IStatus.ERROR) {
				// the transaction must have rolled back if the status was
				// error or worse
				RollbackException exc = new RollbackException(status);
				Tracing.throwing(WorkspaceCommandStackImpl.class, "execute", exc); //$NON-NLS-1$
				throw exc;
			}
			notifyListeners();
		} catch (ExecutionException e) {
			Tracing.catching(WorkspaceCommandStackImpl.class, "execute", e); //$NON-NLS-1$
			command.dispose();
			if(e.getCause() instanceof RollbackException) {
				// throw the rollback
				RollbackException exc = (RollbackException)e.getCause();
				Tracing.throwing(WorkspaceCommandStackImpl.class, "execute", exc); //$NON-NLS-1$
				throw exc;
			} else if(e.getCause() instanceof RuntimeException) {
				// throw the programming error
				RuntimeException exc = (RuntimeException)e.getCause();
				Tracing.throwing(WorkspaceCommandStackImpl.class, "execute", exc); //$NON-NLS-1$
				throw exc;
			} else {
				// log the problem. We can't rethrow whatever it was
				handleError(e);
			}
		}
	}

	/**
	 * Queries whether we can undo my default undo context in my operation
	 * history.
	 */
	@Override
	public boolean canUndo() {
		return getOperationHistory().canUndo(getDefaultUndoContext());
	}

	/**
	 * Undoes my default undo context in my operation history.
	 */
	@Override
	public void undo() {
		try {
			getOperationHistory().undo(getDefaultUndoContext(), new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Tracing.catching(WorkspaceCommandStackImpl.class, "undo", e); //$NON-NLS-1$
			// can't throw anything from this method
			handleError(e);
		} finally {
			// notify even if there was an error; clients should check to see
			// that the command stack is flushed
			notifyListeners();
		}
	}

	/**
	 * Queries whether we can redo my default undo context in my operation
	 * history.
	 */
	@Override
	public boolean canRedo() {
		return getOperationHistory().canRedo(getDefaultUndoContext());
	}

	/**
	 * Redoes my default undo context in my operation history.
	 */
	@Override
	public void redo() {
		try {
			getOperationHistory().redo(getDefaultUndoContext(), new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Tracing.catching(WorkspaceCommandStackImpl.class, "redo", e); //$NON-NLS-1$
			// can't throw anything from this method
			handleError(e);
		} finally {
			// notify even if there was an error; clients should check to see
			// that the command stack is flushed
			notifyListeners();
		}
	}

	/**
	 * Disposes my default undo context in my operation history.
	 */
	@Override
	public void flush() {
		getOperationHistory().dispose(getDefaultUndoContext(), true, true, true);
		if(savedContext != null) {
			getOperationHistory().dispose(getSavedContext(), true, true, true);
			savedContext = null;
		}
	}

	/**
	 * Gets the command from the most recently executed, done, or redone
	 * operation.
	 */
	@Override
	public Command getMostRecentCommand() {
		Command result = null;
		if(mostRecentOperation instanceof EMFCommandOperation) {
			result = ((EMFCommandOperation)mostRecentOperation).getCommand();
		}
		return result;
	}

	/**
	 * Gets the command from the top of the undo history, if any.
	 */
	@Override
	public Command getUndoCommand() {
		Command result = null;
		IUndoableOperation topOperation = getOperationHistory().getUndoOperation(getDefaultUndoContext());
		if(topOperation instanceof EMFCommandOperation) {
			result = ((EMFCommandOperation)topOperation).getCommand();
		}
		return result;
	}

	/**
	 * Gets the command from the top of the redo history, if any.
	 */
	@Override
	public Command getRedoCommand() {
		Command result = null;
		IUndoableOperation topOperation = getOperationHistory().getRedoOperation(getDefaultUndoContext());
		if(topOperation instanceof EMFCommandOperation) {
			result = ((EMFCommandOperation)topOperation).getCommand();
		}
		return result;
	}

	// Documentation copied from the method specification
	public EMFCommandTransaction createTransaction(Command command, Map<?, ?> options) throws InterruptedException {
		EMFCommandTransaction result;
		if(command instanceof TriggerCommand) {
			result = new TriggerCommandTransaction((TriggerCommand)command, getDomain(), options);
		} else {
			result = new EMFOperationTransaction(command, getDomain(), options);
		}
		result.start();
		return result;
	}

	// Documentation copied from the method specification
	public void executeTriggers(Command command, List<Command> triggers, Map<?, ?> options) throws InterruptedException, RollbackException {
		if(!triggers.isEmpty()) {
			TriggerCommand trigger = (command == null) ? new TriggerCommand(triggers) : new TriggerCommand(command, triggers);
			InternalTransaction tx = createTransaction(trigger, makeTriggerTransactionOptions(options));
			try {
				trigger.execute();
				InternalTransaction parent = (InternalTransaction)tx.getParent();
				// shouldn't be null if we're executing triggers!
				if(parent != null) {
					parent.addTriggers(trigger);
				}
				// commit the transaction now
				tx.commit();
			} catch (RuntimeException e) {
				Tracing.catching(WorkspaceCommandStackImpl.class, "executeTriggers", e); //$NON-NLS-1$
				IStatus status;
				if(e instanceof OperationCanceledException) {
					status = Status.CANCEL_STATUS;
				} else {
					status = new Status(IStatus.ERROR, EMFWorkspacePlugin.getPluginId(), EMFWorkspaceStatusCodes.PRECOMMIT_FAILED, Messages.precommitFailed, e);
				}
				RollbackException rbe = new RollbackException(status);
				Tracing.throwing(WorkspaceCommandStackImpl.class, "executeTriggers", rbe); //$NON-NLS-1$
				throw rbe;
			} finally {
				if((tx != null) && (tx.isActive())) {
					// roll back because an uncaught exception occurred
					rollback(tx);
				}
			}
		}
	}

	// Documentation copied from the method specification
	public void dispose() {
		setEditingDomain(null); // remove listeners
		domainListener = null;
		historyAffectedResources = null;
		mostRecentOperation = null;

		// remove listeners registered in opertationHistory
		Collection<IOperationHistoryListener> values = proxyOperationListeners.values();
		for(IOperationHistoryListener proxy : values) {
			getOperationHistory().removeOperationHistoryListener(proxy);
		}
		proxyOperationListeners.clear();

	}

	/**
	 * Obtains my resource undo-context policy.
	 * 
	 * @return my resource undo-context policy
	 * 
	 * @since 1.3
	 */
	public IResourceUndoContextPolicy getResourceUndoContextPolicy() {
		return undoContextPolicy;
	}

	/**
	 * Sets my resource undo-context policy.
	 * 
	 * @param policy
	 *        my new policy, or <code>null</code> to restore the default
	 * 
	 * @since 1.3
	 */
	public void setResourceUndoContextPolicy(IResourceUndoContextPolicy policy) {
		this.undoContextPolicy = policy;
	}

	/**
	 * A listener on the editing domain and operation history that tracks which
	 * resources are changed by an operation and attaches the appropriate {@link ResourceUndoContext} to it when it completes.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class DomainListener extends ResourceSetListenerImpl implements IOperationHistoryListener {

		public void historyNotification(OperationHistoryEvent event) {
			final IUndoableOperation operation = event.getOperation();
			switch(event.getEventType()) {
			case OperationHistoryEvent.ABOUT_TO_EXECUTE:
				// set up to remember affected resources in case we make EMF
				// changes
				currentOperation = operation;
				historyAffectedResources = new java.util.HashSet<Resource>();
				break;
			case OperationHistoryEvent.DONE:
				if((historyAffectedResources != null) && !historyAffectedResources.isEmpty()) {
					// add my undo context to the operation that has
					// completed, but only if the operation actually changed
					// any of my resources (in case this history is shared
					// with other domains)
					for(Resource next : historyAffectedResources) {
						operation.addContext(new ResourceUndoContext(getDomain(), next));
					}
				}
				currentOperation = null;
				historyAffectedResources = null;
				if(operation.hasContext(getDefaultUndoContext())) {
					mostRecentOperation = operation;
				}
				break;
			case OperationHistoryEvent.OPERATION_NOT_OK:
				// just forget about the context because this operation
				// failed
				currentOperation = null;
				historyAffectedResources = null;
				break;
			case OperationHistoryEvent.UNDONE:
			case OperationHistoryEvent.REDONE:
				if(operation.hasContext(getDefaultUndoContext())) {
					mostRecentOperation = operation;
				}
				break;
			case OperationHistoryEvent.OPERATION_REMOVED:
				if(operation == mostRecentOperation) {
					mostRecentOperation = null;
				}
				break;
			}
		}

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			IUndoableOperation operation = null;
			Set<Resource> unloaded = getUnloadedResources(event.getNotifications());
			if(unloaded != null) {
				// dispose their undo contexts
				for(Resource next : unloaded) {
					getOperationHistory().dispose(new ResourceUndoContext(getDomain(), next), true, true, true);
				}
			}
			Transaction tx = event.getTransaction();
			if(tx != null) {
				operation = (IUndoableOperation)tx.getOptions().get(EMFWorkspacePlugin.OPTION_OWNING_OPERATION);
			}
			if(operation == null) {
				operation = currentOperation;
			}
			if(operation != null) {
				Set<Resource> affectedResources = getResourceUndoContextPolicy().getContextResources(operation, event.getNotifications());
				if(unloaded != null) {
					// don't add these resources to the operation
					affectedResources.removeAll(unloaded);
				}
				if(!affectedResources.isEmpty()) {
					// add any resource undo contexts to this operation that are
					// not already applied
					for(Resource next : affectedResources) {
						ResourceUndoContext ctx = new ResourceUndoContext(getDomain(), next);
						if(!operation.hasContext(ctx)) {
							operation.addContext(ctx);
						}
					}
				}
				if(historyAffectedResources != null) {
					// there is an operation executing on our history that is
					// affecting my editing domain. Remember the affected
					// resources.
					historyAffectedResources.addAll(affectedResources);
				}
				
				hookUndoContexts(operation, event);
			}
		}

		/**
		 * Finds resources that have sent unload notifications.
		 * 
		 * @param notifications
		 *        notifications received from a transaction
		 * @return a set of resources that the notifications indicate have been
		 *         unloaded, or <code>null</code> if none
		 */
		private Set<Resource> getUnloadedResources(Collection<Notification> notifications) {
			Set<Resource> result = null;
			for(Notification next : notifications) {
				if(NotificationFilter.RESOURCE_UNLOADED.matches(next)) {
					if(result == null) {
						result = new java.util.HashSet<Resource>();
					}
					result.add((Resource)next.getNotifier());
				}
			}
			return result;
		}

		@Override
		public boolean isPostcommitOnly() {
			// only interested in post-commit "resourceSetChanged" event
			return true;
		}
	}
	
	/**
	 * A hook for subclasses to attach additional undo-contexts to an {@code operation} based on changes
	 * in the resource set.
	 * 
	 * @param operation
	 *        an operation that has been executed (never {@code null})
	 * @param event
	 *        the description of changes made by the {@code operation} in the resource set
	 */
	protected void hookUndoContexts(IUndoableOperation operation, ResourceSetChangeEvent event) {
		// pass
	}


	@Override
	public boolean isSaveNeeded() {
		// This class inherits from AbstractTransactionalCommandStack which in turn inherits from BasicCommandStack.
		
		// The operation isSaveNeeded is defined in BasicCommandStack. In order to work, it requires an update of the
		// variables "saveIndex" and "top" which is done in BasicCommandStack::execute. However, this operation is overridden
		// in method AbstractTransactionalCommandStack::execute which never calls the superclass method BasicCommandStack::execute.
		// Thus, we cannot rely on the super class method of isSaveNeeded (although it seems to work in some cases).
		// => so we have to implement the isSaveNeeded method here.
		IUndoableOperation nextUndoableOperation = history.getUndoOperation(getDefaultUndoContext());
		if(nextUndoableOperation == null) {
			// this is the last undoable operation. But the document might have been save
			// CAVEAT: will trigger 410310, if the model has been saved before => use superclass method in this case.
			// return savedContext != null;
			return super.isSaveNeeded();
		}
		return savedContext != null ? !nextUndoableOperation.hasContext(getSavedContext()) && anyDirtyingAfter(history.getUndoHistory(getDefaultUndoContext()), history.getUndoOperation(savedContext)) : anyDirtying(history.getUndoHistory(getDefaultUndoContext()));
	}

	@Override
	public void saveIsDone() {
		// See comment for isSaveNeeded
		if(savedContext != null) {
			// The save context is only stored on one operation. We must
			// remove it from any other operation that may have contained it
			// before.
			IUndoableOperation[] undoableOperations = history.getUndoHistory(getSavedContext());
			for(int i = 0; i < undoableOperations.length; i++) {
				undoableOperations[i].removeContext(getSavedContext());
			}
			IUndoableOperation[] redoableOperations = history.getRedoHistory(getSavedContext());
			for(int i = 0; i < redoableOperations.length; i++) {
				redoableOperations[i].removeContext(getSavedContext());
			}
		}
		IUndoableOperation nextUndoableOperation = history.getUndoOperation(getDefaultUndoContext());
		if(nextUndoableOperation == null) {
			return;
		}
		nextUndoableOperation.addContext(getSavedContext());
	}
}
