/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.undocontext;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;


/**
 * Service Factory used to create the {@link IUndoContext} used by all editors and views associated to
 * a model (or {@link ServicesRegistry}).
 * The {@link IUndoContext} can be retrieved from the {@link ServicesRegistry}.
 * 
 * @author Cedric Dumoulin
 * 
 */
//TODO: Refactor 0.10: To be moved out of infra.core
public class UndoContextServiceFactory implements IServiceFactory {

	/**
	 * Undo context used to have the same undo context in all Papyrus related views and editors.
	 */
	private IUndoContext undoContext;

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 * 
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {

		// Lookup TransactionalEditingDomain
		TransactionalEditingDomain transactionalEditingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(servicesRegistry);
		// Create the undoContext
		undoContext = new EditingDomainUndoContext(transactionalEditingDomain);
	}

	/**
	 * Do nothing
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 * 
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
	}

	/**
	 * Do nothing
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 * 
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IServiceFactory#createServiceInstance()
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Object createServiceInstance() throws ServiceException {
		return undoContext;
	}


}
