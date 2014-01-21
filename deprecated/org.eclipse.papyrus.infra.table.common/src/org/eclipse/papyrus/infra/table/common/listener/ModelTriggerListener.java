/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.listener;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.table.common.util.FillingQueriesUtil;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;

/**
 * 
 * This listener allows to synchronized the table with its context, listening the changes on the model (listen the change in the uml file.
 * 
 */
public class ModelTriggerListener extends AbstractSynchronizedTableTriggerListener {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the table
	 * @param provider
	 *        the nattable widget provider
	 */
	public ModelTriggerListener(final PapyrusTableInstance table, final INatTableWidgetProvider provider) {
		super(table, provider);
	}

	/**
	 * 
	 * @see org.eclipse.emf.transaction.TriggerListener#trigger(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param domain
	 * @param notification
	 * @return
	 *         the command to add and remove elements from the table when the table is synchronized
	 */
	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {
		if(this.table.isIsSynchronized()) {
			Object notifier = notification.getNotifier();
			int eventType = notification.getEventType();
			if(notifier instanceof PapyrusTableInstance) {
				if(this.table.isIsSynchronized()) {
					switch(eventType) {
					case FillingQueriesUtil.OPEN_TABLE:
						return getSynchronizationCommand(domain);
					default:
						break;
					}
				}
			} else if(notifier instanceof org.eclipse.uml2.uml.Element) { //we only listen the modification on the UML model
				//we can't do a test on the element which provide the notification, because each action on the model can change the result of the query
				switch(eventType) {
				//I think that only Set and Unset are required to get all changes in the model
				case Notification.SET:
				case Notification.UNSET:
				case Notification.ADD:
				case Notification.REMOVE:
				case Notification.ADD_MANY:
				case Notification.REMOVE_MANY:
					return getSynchronizationCommand(domain);
				default:
					break;
				//nothing to do
				}
			}
		}
		return null;
	}

}
