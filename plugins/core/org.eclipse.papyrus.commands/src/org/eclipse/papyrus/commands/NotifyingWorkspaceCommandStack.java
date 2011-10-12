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
 *  Mathieu Velten (Atos) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.commands;

import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;

public class NotifyingWorkspaceCommandStack extends WorkspaceCommandStackImpl {

	/**
	 * map with registered listeners and the corresponding proxy registered to
	 * actual map
	 */
	private Map<CommandStackListener, IOperationHistoryListener> proxyOperationListeners = new HashMap<CommandStackListener, IOperationHistoryListener>();

	public NotifyingWorkspaceCommandStack(IOperationHistory history) {
		super(history);
	}

	@Override
	public void addCommandStackListener(final CommandStackListener listener) {
		removeCommandStackListener(listener);
		IOperationHistoryListener proxy = new IOperationHistoryListener() {

			public void historyNotification(OperationHistoryEvent event) {
				int type = event.getEventType();

				// emf stack only needs to be notified when an operation is finished
				if(OperationHistoryEvent.DONE == type || OperationHistoryEvent.REDONE == type || OperationHistoryEvent.UNDONE == type) {
					listener.commandStackChanged(new EventObject(this));
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
}
