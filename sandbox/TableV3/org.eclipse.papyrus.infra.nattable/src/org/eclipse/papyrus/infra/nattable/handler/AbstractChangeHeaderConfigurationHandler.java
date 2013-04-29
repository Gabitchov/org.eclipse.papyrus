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
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Abstract class to edit the header cofniguration
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractChangeHeaderConfigurationHandler extends AbstractTableHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		AbstractHeaderAxisConfiguration configuration = getEditedAxisConfiguration();
		final CompositeCommand cmd = new CompositeCommand("ChangeHeaderConfigurationCommand"); //$NON-NLS-1$
		TransactionalEditingDomain domain = getEditingDomain();
		if(configuration instanceof TableHeaderAxisConfiguration) {
			//we can't edit it, because it's comes from the initial configuration
			configuration = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration((TableHeaderAxisConfiguration)configuration);
			final Table table = getCurrentNattableModelManager().getTable();
			final IEditCommandRequest request = new SetRequest(domain, table, getLocalHeaderAxisConfigurationFeature(), configuration);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(table);
			cmd.add(provider.getEditCommand(request));
		}
		Command command = event.getCommand();
		boolean oldValue = HandlerUtil.toggleCommandState(command);
		final IEditCommandRequest request = new SetRequest(domain, configuration, getEditedFeature(), !oldValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(configuration);
		cmd.add(provider.getEditCommand(request));
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		return null;
	}

	/**
	 * 
	 * @return
	 * 
	 */
	protected abstract EStructuralFeature getLocalHeaderAxisConfigurationFeature();

	/**
	 * 
	 * @return
	 *         the edited feature
	 */
	protected abstract EStructuralFeature getEditedFeature();

	/**
	 * 
	 * @return
	 *         the edited axis configuration
	 */
	protected abstract AbstractHeaderAxisConfiguration getEditedAxisConfiguration();
}
