package org.eclipse.papyrus.commands;

import java.util.EventObject;

import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;

public class CommandStackEventListenerProxy implements CommandStackListener {

	protected CommandStackEventListener listener;

	protected CommandStack gefStack;

	public CommandStackEventListenerProxy(CommandStack originalGefStack, CommandStackEventListener originalListener) {
		gefStack = originalGefStack;
		listener = originalListener;
	}

	public void commandStackChanged(EventObject event) {
		if(event instanceof CommandStackEvent) {
			listener.stackChanged((CommandStackEvent)event);
		} else {
			Activator.log.warn("Event received from command stack is not a CommandStackEvent : " + event.toString());
		}
	}

	public void commandStackChanged(int detail) {
		CommandStackEvent newEvent = new CommandStackEvent(gefStack, null, detail);
		commandStackChanged(newEvent);
	}
}
