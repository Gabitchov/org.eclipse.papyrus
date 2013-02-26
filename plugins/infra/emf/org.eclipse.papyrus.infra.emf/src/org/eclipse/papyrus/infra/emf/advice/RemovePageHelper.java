/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;


public class RemovePageHelper {

	public static ICommand getRemovePageCommand(final TransactionalEditingDomain editingDomain, final EObject elementToDestroy) {
		try {
			final IPageManager pageManager = ServiceUtilsForEObject.getInstance().getIPageManager(elementToDestroy);
			if(pageManager.allPages().contains(elementToDestroy)) {
				return new AbstractTransactionalCommand(editingDomain, "Delete page", null) {

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						pageManager.removePage(elementToDestroy);
						return CommandResult.newOKCommandResult();
					}
				};
			}
		} catch (ServiceException ex) {
			//Ignore
		} catch (Exception ex) {
			//Ignore
		}

		return null;
	}
}
