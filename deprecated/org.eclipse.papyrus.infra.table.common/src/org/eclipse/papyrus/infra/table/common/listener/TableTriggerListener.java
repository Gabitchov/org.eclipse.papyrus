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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;

/**
 * 
 * This trigger returns a command when the following table features are modified :
 * <ul>
 * <li>PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED</li>
 * <li>PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES</li>
 * <li></li>
 * </ul>
 * 
 */
public class TableTriggerListener extends AbstractSynchronizedTableTriggerListener {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the table
	 * @param provider
	 *        the nattable widget provider
	 */
	public TableTriggerListener(PapyrusTableInstance table, INatTableWidgetProvider provider) {
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
	 */
	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {
		Object notifier = notification.getNotifier();
		if(notifier instanceof PapyrusTableInstance) {
			Object feature = notification.getFeature();
			if(feature instanceof EStructuralFeature) {
				int featureID = ((EStructuralFeature)feature).getFeatureID();
				switch(featureID) {
				case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
					if(notification.getNewBooleanValue()) {
						return getSynchronizationCommand(domain);
					}
					break;
				case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES:
					if(this.table.isIsSynchronized()) {
						switch(notification.getEventType()) {
						case Notification.ADD_MANY:
						case Notification.ADD:
						case Notification.REMOVE: //we remove the elements that the removed query brought
							return getSynchronizationCommand(domain);
						default:
							//nothing to do
							break;
						}
					}
				}
			}
		}
		return null;
	}
}
