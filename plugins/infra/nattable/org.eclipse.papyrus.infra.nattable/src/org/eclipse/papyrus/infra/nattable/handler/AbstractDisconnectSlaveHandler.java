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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.MasterObjectAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Abstract handler used to change the value of the property IMasterAxisProvider#disconnectSlave
 * 
 * @author vl222926
 * 
 */
public abstract class AbstractDisconnectSlaveHandler extends AbstractTableHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final AbstractAxisProvider axisProvider = getAxisProviderToEdit();
		if(axisProvider instanceof MasterObjectAxisProvider) {
			boolean newState = !HandlerUtil.toggleCommandState(event.getCommand());
			final TransactionalEditingDomain domain = (TransactionalEditingDomain)getTableEditingDomain();
			final IEditCommandRequest request = new SetRequest(domain, axisProvider, NattableaxisproviderPackage.eINSTANCE.getIMasterAxisProvider_DisconnectSlave(), newState);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(axisProvider);
			final ICommand cmd = provider.getEditCommand(request);
			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the axis provider to edit
	 */
	protected abstract AbstractAxisProvider getAxisProviderToEdit();

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(getAxisProviderToEdit() instanceof MasterObjectAxisProvider);
	}
}
