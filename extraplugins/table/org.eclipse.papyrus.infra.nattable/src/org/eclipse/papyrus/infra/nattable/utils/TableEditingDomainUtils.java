/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * 
 * Utils class to get the best editing domain to use
 * 
 */
public class TableEditingDomainUtils {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private TableEditingDomainUtils() {
		//to prevent instanciation
	}

	/**
	 * Returns the EditingDomain associated to the table
	 * 
	 * @return
	 *         the EditingDomain associated to the table
	 */
	public static final TransactionalEditingDomain getTableEditingDomain(final Table table) {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(table);
			return (TransactionalEditingDomain)registry.getService(TransactionalEditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}
		return null;

	}

	/**
	 * Returns the EditingDomain associated to the context
	 * 
	 * @return
	 *         the EditingDomain associated to the context
	 */
	public static final TransactionalEditingDomain getTableContextEditingDomain(final Table table) {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(table.getContext());
			return (TransactionalEditingDomain)registry.getService(TransactionalEditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}
		return null;
	}
}
