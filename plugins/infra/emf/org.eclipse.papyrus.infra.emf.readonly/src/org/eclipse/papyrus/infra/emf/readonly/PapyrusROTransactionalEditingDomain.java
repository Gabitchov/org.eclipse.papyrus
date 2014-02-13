/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - Support object-level read/write controls (CDO)
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.TransactionChangeRecorder;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.papyrus.infra.core.resource.IRollbackStatus;
import org.eclipse.papyrus.infra.core.resource.RollbackStatus;


public class PapyrusROTransactionalEditingDomain extends TransactionalEditingDomainImpl {

	public PapyrusROTransactionalEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack, ResourceSet resourceSet) {
		super(adapterFactory, stack, resourceSet);
	}

	@Override
	public boolean isReadOnly(Resource resource) {
		if(resource != null && resource.getURI() != null) {
			return ReadOnlyManager.getReadOnlyHandler(this).anyReadOnly(new URI[]{ resource.getURI() }).get();
		}
		return false;
	}

	public boolean isReadOnly(EObject eObject) {
		return ReadOnlyManager.getReadOnlyHandler(this).isReadOnly(eObject).get();
	}
	
	@Override
	protected TransactionChangeRecorder createChangeRecorder(ResourceSet rset) {
		return new TransactionChangeRecorder(this, rset) {
			@Override
			protected void appendNotification(Notification notification) {
				// Append to the transaction first
				super.appendNotification(notification);
				
				if (!NotificationFilter.READ.matches(notification)) {
					// Check whether we are modifying a read-only object
					assertNotReadOnly(notification.getNotifier());
				}
			}
		};
	}

	protected void assertNotReadOnly(Object object) {
		InternalTransaction tx = getActiveTransaction();

		// If there's no transaction, then there will be nothing to roll back
		if(tx != null) {
			boolean readOnly;

			// Check for Resource first because CDO resources *are* EObjects
			if(object instanceof Resource) {
				Resource.Internal resource = (Resource.Internal)object;
				if(resource.isLoading()) {
					// We must be able to modify read-only resources in order to load them
					return;
				}
				readOnly = isReadOnly(resource);
			} else if(object instanceof EObject) {
				readOnly = isReadOnly((EObject)object);
			} else {
				// If it's not an EMF-managed object, we don't care
				readOnly = false;
			}

			if(readOnly) {
				String message = "Attempt to modify object(s) in a read-only model."; //$NON-NLS-1$
				Collection<?> offenders = Collections.singleton(object);
				tx.abort(new RollbackStatus(Activator.PLUGIN_ID, IRollbackStatus.READ_ONLY_OBJECT, message, offenders));
			}
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		resourceSet = null;
		adapterFactory = null;
		ReadOnlyManager.roHandlers.remove(this);
	}
}
