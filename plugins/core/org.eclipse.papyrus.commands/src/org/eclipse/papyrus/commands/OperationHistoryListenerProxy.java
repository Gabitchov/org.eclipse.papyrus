package org.eclipse.papyrus.commands;

import java.util.EventObject;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.gef.commands.CommandStack;

public class OperationHistoryListenerProxy implements IOperationHistoryListener {

	protected CommandStackListener listener;

	public OperationHistoryListenerProxy(CommandStackListener originalEMFListener) {
		listener = originalEMFListener;
	}

	public void historyNotification(OperationHistoryEvent event) {
		int type = event.getEventType();
		if(listener instanceof CommandStackEventListenerProxy) {
			CommandStackEventListenerProxy proxyListener = (CommandStackEventListenerProxy)listener;

			int detail = 0;
			switch(type) {
			case OperationHistoryEvent.ABOUT_TO_EXECUTE:
				detail = CommandStack.PRE_EXECUTE;
				break;
			case OperationHistoryEvent.ABOUT_TO_REDO:
				detail = CommandStack.PRE_REDO;
				break;
			case OperationHistoryEvent.ABOUT_TO_UNDO:
				detail = CommandStack.PRE_UNDO;
				break;
			case OperationHistoryEvent.DONE:
				detail = CommandStack.POST_EXECUTE;
				break;
			case OperationHistoryEvent.REDONE:
				detail = CommandStack.POST_REDO;
				break;
			case OperationHistoryEvent.UNDONE:
				detail = CommandStack.POST_UNDO;
				break;
			default:
				break;
			}

			if(detail != 0) {
				proxyListener.commandStackChanged(detail);
			}
		} else {
			// emf stack only needs to be notified when an operation is finished
			if(OperationHistoryEvent.DONE == type || OperationHistoryEvent.REDONE == type || OperationHistoryEvent.UNDONE == type) {
				listener.commandStackChanged(new EventObject(this));
			}
		}
	}
}
