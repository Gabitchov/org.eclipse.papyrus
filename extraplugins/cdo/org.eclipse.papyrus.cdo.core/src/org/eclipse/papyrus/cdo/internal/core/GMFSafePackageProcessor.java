/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core;

import java.util.Collections;

import org.eclipse.emf.cdo.common.model.EMFUtil;
import org.eclipse.emf.cdo.spi.common.model.InternalCDOPackageRegistry.PackageProcessor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;


/**
 * A package processor that ensures the contextual {@linkplain TransactionalEditingDomain GMF editing domain} (if any) is writable.
 */
class GMFSafePackageProcessor implements PackageProcessor {

	private final Object NOT_PROCESSED_TOKEN = new Object();

	private final PackageProcessor delegate;

	public GMFSafePackageProcessor(PackageProcessor processor) {
		super();

		this.delegate = processor;
	}

	public Object processPackage(Object value) {
		Object result = NOT_PROCESSED_TOKEN;

		if(EMFUtil.isDynamicEPackage(value)) {
			EPackage ePackage = (EPackage)value;
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ePackage);
			if(domain != null) {
				InternalTransactionalEditingDomain internalDomain = (InternalTransactionalEditingDomain)domain;
				Transaction transaction = null;

				try {
					transaction = internalDomain.startTransaction(false, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
					result = delegate.processPackage(value);
					transaction.commit();
				} catch (RollbackException e) {
					Activator.log.error("Failed to commit processed package.", e); //$NON-NLS-1$
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in processing package.", e); //$NON-NLS-1$
					transaction.rollback();
				}
			}
		}

		if(result == NOT_PROCESSED_TOKEN) {
			// just delegate
			result = delegate.processPackage(value);
		}

		return result;
	}

}
