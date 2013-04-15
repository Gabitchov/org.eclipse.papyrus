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

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Abstract class used to change label configuration
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractChangeLabelConfigurationValueHandler extends AbstractTableHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ILabelProviderConfiguration labelConf = getEditedLabelConfiguration();
		TransactionalEditingDomain domain = getEditingDomain();
		Command command = event.getCommand();
		boolean oldValue = HandlerUtil.toggleCommandState(command);
		final IEditCommandRequest request = new SetRequest(domain, labelConf, getEditedFeature(), !oldValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(labelConf);
		final ICommand cmd = provider.getEditCommand(request);
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		return null;
	}

	/**
	 * 
	 * @return
	 *         the edited label configuration
	 */
	protected abstract ILabelProviderConfiguration getEditedLabelConfiguration();

	/**
	 * 
	 * @return
	 *         the edited feature
	 */
	protected abstract EStructuralFeature getEditedFeature();

}
