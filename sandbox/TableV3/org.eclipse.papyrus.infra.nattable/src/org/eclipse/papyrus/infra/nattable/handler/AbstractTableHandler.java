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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * The abstract handler to use for the table actions
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractTableHandler extends AbstractHandler {

	/**
	 * 
	 * @return
	 *         the current active part
	 */
	protected IWorkbenchPart getActivePart() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
	}

	/**
	 * 
	 * @return
	 *         the current table manager or <code>null</code> if not found
	 */
	protected INattableModelManager getCurrentNattableModelManager() {
		final IWorkbenchPart currentPart = getActivePart();
		if(currentPart != null) {
			final INattableModelManager manager = (INattableModelManager)currentPart.getAdapter(INattableModelManager.class);
			return manager;
		}
		return null;
	}


	/**
	 * Returns the EditingDomain associated to the table
	 * 
	 * @return
	 */
	protected EditingDomain getTableEditingDomain() {//duplicated code from NattableModelManager
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(getCurrentNattableModelManager().getTable());
			return registry.getService(EditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}
		return null;
	}

	/**
	 * Returns the EditingDomain associated to the context
	 * 
	 * @return
	 */
	protected EditingDomain getContextEditingDomain() {//duplicated code from NattableModelManager
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(getCurrentNattableModelManager().getTable());
			return registry.getService(EditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}

		return null;
	}

}
