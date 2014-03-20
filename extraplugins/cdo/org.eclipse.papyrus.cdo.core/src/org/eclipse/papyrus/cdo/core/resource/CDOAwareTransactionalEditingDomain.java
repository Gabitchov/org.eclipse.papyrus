/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 323802
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.resource;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.cdo.dawn.transaction.DawnTransactionChangeRecorder;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.impl.TransactionChangeRecorder;
import org.eclipse.emf.transaction.impl.TransactionImpl;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.infra.emf.readonly.PapyrusROTransactionalEditingDomain;

/**
 * This is the CDOAwareTransactionalEditingDomain type. Enjoy.
 */
public class CDOAwareTransactionalEditingDomain extends PapyrusROTransactionalEditingDomain {

	public CDOAwareTransactionalEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack, ResourceSet resourceSet) {
		super(adapterFactory, stack, resourceSet);
	}

	@Override
	protected TransactionChangeRecorder doCreateChangeRecorder(ResourceSet rset) {
		return new DawnTransactionChangeRecorder(this, rset) {

			@Override
			protected void appendNotification(Notification notification) {
				// Append to the transaction first
				super.appendNotification(notification);

				if(!NotificationFilter.READ.matches(notification)) {
					// Check whether we are modifying a read-only object
					assertNotReadOnly(notification.getNotifier());
				}
			}
		};
	}

	protected void fireResourceSetChanged(CDOViewInvalidationEvent event) {
		final ResourceSetListener[] listeners = getPostcommitListeners();
		final Transaction transaction = new TransactionImpl(this, false, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));

		// TODO: Compute notifications from the revision deltas? Model Explorer
		// doesn't need any, and this is here primarily to kick the explorer.
		final List<Notification> notifications = Collections.emptyList();

		CDOUtils.notify(this, new Runnable() {

			@Override
			public void run() {
				for(ResourceSetListener element : listeners) {
					try {
						element.resourceSetChanged(new ResourceSetChangeEvent(CDOAwareTransactionalEditingDomain.this, transaction, notifications));
					} catch (Exception e) {
						Activator.log.error("Uncaught exception in resource set change listener.", //$NON-NLS-1$
							e);
					}
				}
			}
		});
	}
}
