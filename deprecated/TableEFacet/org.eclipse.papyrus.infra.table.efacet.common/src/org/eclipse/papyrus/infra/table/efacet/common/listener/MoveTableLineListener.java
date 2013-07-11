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

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/**
 * 
 * This listener allows to know when a line has been moved in the table
 * 
 */
public class MoveTableLineListener extends AbstractTableTriggerListener {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 */
	public MoveTableLineListener(final PapyrusTable table) {
		super(table);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractSynchronizedTableListener#isManagedNotification(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 * @return
	 */
	@Override
	protected boolean isManagedNotification(final Notification notification) {
		if(notification.getEventType() == Notification.MOVE && notification.getNotifier() == this.table.getTable() && notification.getFeature() == TablePackage.eINSTANCE.getTable_Rows()) {
			if(this.table.isUsingContextFeature()) {
				final EStructuralFeature feature = this.table.getContextFeature();
				if(feature != null && feature.isOrdered()) {
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractSynchronizedTableListener#getSynchronizationCommand(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param domain
	 * @param notification
	 * @return
	 */
	@Override
	public Command getSynchronizationCommand(final TransactionalEditingDomain domain, final Notification notification) {
		final EObject tableContext = this.table.getTable().getContext();
		final Object currentValue = tableContext.eGet(this.table.getContextFeature());
		final EObject movedValue = ((Row)notification.getNewValue()).getElement();
		if(currentValue instanceof List<?>) {
			final MoveCommand cmd = new MoveCommand(domain, tableContext, this.table.getContextFeature(), movedValue, notification.getPosition());
			cmd.setLabel(getCommandName(notification));
			return cmd;
		}
		return null;
	}

	@Override
	protected String getCommandName(final Notification notification) {
		return "Move Line Command (Update the Model)";
	}
}
