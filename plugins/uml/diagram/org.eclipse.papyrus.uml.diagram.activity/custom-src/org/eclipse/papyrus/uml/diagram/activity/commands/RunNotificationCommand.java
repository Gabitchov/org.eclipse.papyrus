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
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.INotification;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;

import com.google.common.collect.Lists;

/**
 * Command used to launch a notification
 * 
 * @author arthur daussy
 * 
 */
public class RunNotificationCommand extends AbstractTransactionalCommand {

	private NotificationBuilder notification;

	private static List<INotification> notifs = Lists.newArrayList();

	public RunNotificationCommand(TransactionalEditingDomain domain, String label, List affectedFiles, NotificationBuilder notification) {
		super(domain, label, affectedFiles);
		this.notification = notification;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		/**
		 * Clear old notif
		 */
		clearOldNotif();
		addNotif(notification.run());
		return CommandResult.newOKCommandResult();
	}

	private synchronized void addNotif(INotification notif) {
		notifs.add(notif);
	}

	private synchronized void clearOldNotif() {
		for(INotification notif : notifs) {
			notif.delete();
		}
		notifs.clear();
	}
}
