/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils;

import java.util.Collections;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;

/**
 * This helper can be used to run (safe) transactions outside the CommandStack
 * 
 * @author Camille Letavernier
 * 
 */
public class TransactionHelper {

	public static void run(EditingDomain domain, Runnable writeOperation) throws InterruptedException, RollbackException {
		if(domain instanceof TransactionalEditingDomain) {
			run((TransactionalEditingDomain)domain, writeOperation);
		} else {
			writeOperation.run();
		}
	}

	public static void run(TransactionalEditingDomain domain, final Runnable writeOperation) throws InterruptedException, RollbackException {
		if(domain instanceof InternalTransactionalEditingDomain) {
			run((InternalTransactionalEditingDomain)domain, writeOperation);
		} else {
			//Shouldn't happen, as all TransactionalEditingDomain implementations should also implement InternalTransactionalEditingDomain
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					writeOperation.run();
				}
			});
		}
	}

	public static void run(InternalTransactionalEditingDomain domain, Runnable writeOperation) throws InterruptedException, RollbackException {
		Transaction transaction = domain.startTransaction(false, Collections.emptyMap());
		try {
			writeOperation.run();
		} finally {
			transaction.commit();
		}
	}

}
