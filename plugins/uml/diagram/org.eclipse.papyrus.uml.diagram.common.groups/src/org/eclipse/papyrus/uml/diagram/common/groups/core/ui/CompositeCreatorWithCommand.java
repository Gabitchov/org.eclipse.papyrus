/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.groups.core.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.IContext;

/**
 * The CompositeCreator with command is an abstract implementation of ICompositeCreator which take cares of storing a command which evolves with the
 * decisions the user takes in the built notification.
 * 
 * @author vhemery
 */
public abstract class CompositeCreatorWithCommand implements ICompositeCreator {

	/** the commands to execute at notification close */
	private Map<Object, Command> commandsMap = new HashMap<Object, Command>();

	/**
	 * Add a command which will be executed as result of the notification. If a command already exist for that key, it will be replaced.
	 * If cmd is null, any existing command for the given key is removed.
	 * 
	 * @param key
	 *        the object to use as a key for the command (may be null)
	 * @param cmd
	 *        the command to store
	 */
	protected void addResultingCommandForObject(Object key, Command cmd) {
		if(cmd != null) {
			commandsMap.put(key, cmd);
		} else {
			commandsMap.remove(key);
		}
	}

	/**
	 * Get the command to execute as result of the notification
	 * 
	 * @return command to execute
	 */
	public Command getResultingCommand() {
		if(!commandsMap.isEmpty()) {
			return new CompoundCommand(new ArrayList<Command>(commandsMap.values()));
		} else {
			return null;
		}
	}

	/**
	 * Get the runnable action to run the resulting command.
	 * In case of an asynchronous action, a command will be executed.
	 * In case of a synchronous action, the command is not executed yet and must be recovered with {@link #getResultingCommand()}.
	 * 
	 * @param isAsynchronous
	 *        true if the action is asynchronous
	 * 
	 * @return notification runnable
	 */
	public NotificationRunnable getCommandRunner(final boolean isAsynchronous) {
		return new NotificationRunnable() {

			/**
			 * Run the stored resulting commands
			 * 
			 * @see org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable#run(org.eclipse.papyrus.ui.toolbox.notification.builders.IContext)
			 * @param context
			 *        running context
			 */
			public void run(IContext context) {
				if(isAsynchronous) {
					Command cmd = getResultingCommand();
					if(cmd != null && cmd.canExecute()) {
						cmd.execute();
					}
				}
				removeNotification();
			}

			/**
			 * Get the action label
			 * 
			 * @see org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable#getLabel()
			 * @return stirng label
			 */
			public String getLabel() {
				return getRunLabel();
			}
		};
	}

	/**
	 * Remove the notification using {@link PendingGroupNotificationsManager} and the appropriate key
	 */
	abstract protected void removeNotification();

	/**
	 * Get the run action label
	 * 
	 * @return string label
	 */
	abstract protected String getRunLabel();

}
