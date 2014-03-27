/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.commands.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.papyrus.commands.INonDirtying;


/**
 * A utility class for tracking the dirty state of an operation history. It works in the
 * same fashion as the EMF {@link BasicCommandStack}, accounting for operations that {@linkplain INonDirtying do not dirty} the editor.
 */
public class OperationHistoryDirtyState {

	private static final Map<IUndoContext, OperationHistoryDirtyState> instances = new HashMap<IUndoContext, OperationHistoryDirtyState>();

	private final AtomicInteger refCount = new AtomicInteger(0);

	private final IUndoContext context;

	private final IOperationHistory history;

	private IOperationHistoryListener listener;

	private IUndoableOperation savepoint;

	private boolean forceDirty;

	private OperationHistoryDirtyState(IUndoContext context, IOperationHistory history) {
		this.context = context;
		this.history = history;

		history.addOperationHistoryListener(createOperationHistoryListener());
	}

	/**
	 * Obtains a new operation history dirty-state tracker. Every result of this call must eventually be {@linkplain #dispose() disposed},
	 * even if it is actually the same instance as returned by an earlier call, because instances are reference-counted.
	 */
	public static OperationHistoryDirtyState newInstance(IUndoContext context, IOperationHistory history) {
		OperationHistoryDirtyState result;

		synchronized(instances) {
			result = instances.get(context);
			if(result == null) {
				result = new OperationHistoryDirtyState(context, history);
				instances.put(context, result);
			}
		}

		result.retain();
		return result;
	}

	private IOperationHistoryListener createOperationHistoryListener() {
		this.listener = new IOperationHistoryListener() {

			public void historyNotification(OperationHistoryEvent event) {
				switch(event.getEventType()) {
				case OperationHistoryEvent.DONE:
				case OperationHistoryEvent.UNDONE:
				case OperationHistoryEvent.REDONE:
				case OperationHistoryEvent.OPERATION_CHANGED:
					// Check on our savepoint, if any
					if((savepoint != null) && !savepoint.hasContext(context)) {
						// Our savepoint has been removed from the context (our undo/redo stack), so it
						// is effectively lost
						savepoint = null;
					}
					break;
				case OperationHistoryEvent.OPERATION_REMOVED:
					IUndoableOperation removed = event.getOperation();
					if(removed != null) {
						if(removed == savepoint) {
							// the savepoint was removed, so now we can never return to it
							savepoint = null;
						} else if((savepoint == null) && removed.hasContext(context) && !OperationUtils.isNonDirtying(removed)) {
							// A dirtying operation has been lost from the history, so we will not now be able to return
							// to a state equivalent to the savepoint
							forceDirty = true;
						}
					}
					break;
				}
			}
		};

		return this.listener;
	}

	private OperationHistoryDirtyState retain() {
		refCount.incrementAndGet();
		return this;
	}

	private boolean release() {
		return refCount.decrementAndGet() == 0;
	}

	public void dispose() {
		synchronized(instances) {
			if(release()) {
				instances.remove(context);

				if(listener != null) {
					history.removeOperationHistoryListener(listener);
					listener = null;
				}

				savepoint = null;
			}
		}
	}

	public boolean isDirty() {
		return forceDirty || OperationUtils.isDirty(history.getUndoHistory(context), history.getRedoHistory(context), savepoint);
	}

	public void saved() {
		this.savepoint = history.getUndoOperation(context);
		this.forceDirty = false;
	}
}
