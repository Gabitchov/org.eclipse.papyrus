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
package org.eclipse.papyrus.infra.nattable.actions;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * The abstract handler used to change the value of the boolean display label in the axis configuration
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractDisplayLabelHandler extends AbstractChangeHeaderStyleConfiguration {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final AbstractAxisConfiguration configuration = getAxisConfiguration();
		if(configuration instanceof DefaultAxisConfiguration) {
			Command command = event.getCommand();
			boolean oldValue = HandlerUtil.toggleCommandState(command);
			TransactionalEditingDomain domain = getEditingDomain();
			final IEditCommandRequest request = new SetRequest(domain, configuration, NattableaxisconfigurationPackage.eINSTANCE.getDefaultAxisConfiguration_DisplayLabel(), !oldValue);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(configuration);
			final ICommand cmd = provider.getEditCommand(request);
			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		}
		return null;
	}


}
