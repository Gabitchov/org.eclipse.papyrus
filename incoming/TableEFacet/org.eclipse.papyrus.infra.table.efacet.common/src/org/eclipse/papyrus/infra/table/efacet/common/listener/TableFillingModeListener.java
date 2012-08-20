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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;

/**
 * 
 * this listener provides the command to synchronized the table when the filling mode used to fill the table change
 * 
 */
public class TableFillingModeListener extends AbstractSynchronizedTableListener {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the table on which we are working
	 * @param controller
	 */
	public TableFillingModeListener(final PapyrusTable table) {
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
		if(notification.getNotifier() == this.table && notification.getFeature() == PapyrustablePackage.eINSTANCE.getPapyrusTable_FillingMode() && !(notification.getNewValue() == FillingMode.USER)) {
			return false;
			//TODO
			//			return true;
		}
		return false;
	}
}
