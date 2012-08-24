/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.common.listener;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;



public abstract class AbstractTableTriggerListener extends TriggerListener {

	/** The table. */
	protected final PapyrusTable table;

	/**
	 * Instantiates a new abstract table trigger listener.
	 * 
	 * @param papyrusTable
	 *        the papyrus table
	 */
	public AbstractTableTriggerListener(final PapyrusTable papyrusTable) {
		this.table = papyrusTable;
	}

	/**
	 * @see org.eclipse.emf.transaction.TriggerListener#trigger(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param domain
	 * @param notification
	 * @return
	 */

	@Override
	protected final Command trigger(final TransactionalEditingDomain domain, final Notification notification) {
		if(isManagedNotification(notification)) {
			return getSynchronizationCommand(domain, notification);
		}
		return null;
	}

	/**
	 * Gets the synchronization command.
	 * 
	 * @param domain
	 *        the domain
	 * @param notification
	 *        the notification
	 * @return the synchronization command
	 */
	protected Command getSynchronizationCommand(final TransactionalEditingDomain domain, final Notification notification) {
		return null;
	}

	/**
	 * Checks if is managed notification.
	 * 
	 * @param notification
	 *        the notification
	 * @return true, if is managed notification
	 */
	protected abstract boolean isManagedNotification(Notification notification);

	/**
	 * Gets the command name.
	 * 
	 * @param notification
	 *        the notification
	 * @return the command name
	 */
	protected abstract String getCommandName(final Notification notification);
}
