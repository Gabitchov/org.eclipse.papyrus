/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.table.efacet.common.handler;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.uml.table.efacet.common.Activator;



/**
 *
 * Abstract class for PasteInTableCommandProvider
 *
 */
public abstract class AbstractPasteInTableCommandProvider implements IPasteInTableCommandProvider {

	/**
	 * the error message for the command
	 */
	protected String pasteErrorMessage = null;


	/**
	 *
	 * @see org.eclipse.papyrus.sysml.table.efacet.flowport.provider.internal.provider.IPasteInTableCommandProvider#getPasteErrorMessage()
	 *
	 * @return
	 */
	public final String getPasteErrorMessage() {
		return this.pasteErrorMessage;
	}

	/**
	 *
	 * @param papyrusTable
	 *        the papyrus table
	 * @return
	 *         the editing domain to use for the PapyrusTable
	 */
	protected TransactionalEditingDomain getEditingDomain(final PapyrusTable papyrusTable) {
		TransactionalEditingDomain domain = null;
		ServicesRegistry serviceRegistry = null;
		try {
			serviceRegistry = ServiceUtilsForResource.getInstance().getServiceRegistry(papyrusTable.eResource());
		} catch (final ServiceException e) {
			Activator.log.error("ServicesRegistry not found", e);
		}
		try {
			domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);
		} catch (final ServiceException e) {
			Activator.log.error("EdtingDomain not found", e);
		}
		return domain;
	}
}
