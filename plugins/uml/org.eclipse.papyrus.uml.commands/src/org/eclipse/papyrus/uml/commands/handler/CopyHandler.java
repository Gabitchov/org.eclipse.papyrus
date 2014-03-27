/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.commands.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.commands.Activator;
import org.eclipse.papyrus.uml.commands.command.PutInClipboardCommand;

/**
 * Handler for the Copy Action
 */
@Deprecated // use org.eclipse.papyrus.views.modelexplorer.handler.CopyHandler
public class CopyHandler extends AbstractEMFCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.AbstractEMFCommandHandler.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand(ServicesRegistry registry) {
		if(registry != null) {
			final TransactionalEditingDomain editingDomain;
			try {
				editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
			} catch (ServiceException ex) {
				Activator.log.error(ex);
				return UnexecutableCommand.INSTANCE;
			}

			Collection<EObject> selection = getSelectedElements();
			
			List<Object> objectList = new ArrayList<Object>();
			objectList.addAll(selection);
			if(editingDomain != null && !selection.isEmpty()) {
				return new PutInClipboardCommand(editingDomain, objectList);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}




}
