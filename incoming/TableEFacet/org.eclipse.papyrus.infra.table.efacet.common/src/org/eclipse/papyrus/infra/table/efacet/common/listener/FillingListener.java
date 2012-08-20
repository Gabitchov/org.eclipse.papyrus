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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/**
 * 
 * This listener provides the command to synchronize the table when something changes in the uml file OR when the table is opened
 * 
 */
public class FillingListener extends AbstractSynchronizedTableListener {


	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the table to fill
	 * @param natTableWidget
	 */
	public FillingListener(final PapyrusTable table) {
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
		final Object notifier = notification.getNotifier();
		if(!this.table.isUsingUser() && notifier instanceof EObject) {
			final EObject eobject = (EObject)notifier;
			if(notifier instanceof TabFolder) {//to synchronized an opening table
				final Object newValue = notification.getNewValue();
				PageRef ref = null;
				if(newValue instanceof PageRef) {
					ref = (PageRef)newValue;
				}
				if(ref != null && ref.getEmfPageIdentifier() == this.table) {
					return true;
				}
			} else if(eobject.eResource() != null && eobject.eResource().getURI().fileExtension().equals("uml")) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}
}
