package org.eclipse.papyrus.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
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
		OperationHistoryListenerProxy proxy = new OperationHistoryListenerProxy(listener);
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
