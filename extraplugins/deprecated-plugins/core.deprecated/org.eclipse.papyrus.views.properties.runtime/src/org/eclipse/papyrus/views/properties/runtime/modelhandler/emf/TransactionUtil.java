/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;


/**
 * Utility class for transactions
 */
public class TransactionUtil {

	/**
	 * Checks if the current active transaction is a Write transaction or not
	 * unprotected transaction are not considered write transaction
	 * 
	 * @param internalEditingDomain
	 *        the current internal editing domain, on which transaction are run
	 * @param includeUnprotected
	 *        <code>boolean</code> value that if <code>true</code> will consider unprotected
	 *        transactions when determining if a write transaction is in progress.
	 * @param otherThread
	 *        <code>boolean</code> value that if <code>true</code>, will verify whether there is
	 *        an active transaction only when on a different thread then the caller. This is useful to determine if a
	 *        deadlock scenario will occur.
	 * @return <code>true</code> if the current active transaction is a write transaction
	 */
	public static boolean isReadTransactionInProgress(TransactionalEditingDomain internalEditingDomain, boolean includeUnprotected, boolean otherThread) {
		if(!(internalEditingDomain instanceof InternalTransactionalEditingDomain)) {
			return false;
		}

		InternalTransaction transaction = ((InternalTransactionalEditingDomain)internalEditingDomain).getActiveTransaction();
		if(transaction != null && transaction.isReadOnly()) {
			if(includeUnprotected) {
				Object unprotectedMode = transaction.getOptions().get(Transaction.OPTION_UNPROTECTED);
				if(Boolean.FALSE.equals(unprotectedMode)) {
					return false;
				}
			}

			if(otherThread && Thread.currentThread() != transaction.getOwner())
				return true;
			else if(!otherThread) {
				return true;
			}
			return true;
		}
		return false;
	}
}
