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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RadioState;


/**
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractChangeIndexStyleHandler extends AbstractTableHandler {

	/**
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final AbstractHeaderAxisConfiguration configuration = getAxisConfiguration();

		if(HandlerUtil.matchesRadioState(event)) {
			return null; // we are already in the updated state - do nothing
		}
		String currentState = event.getParameter(RadioState.PARAMETER_ID);

		TransactionalEditingDomain domain = getEditingDomain();
		AxisIndexStyle newStyle = AxisIndexStyle.get(currentState);
		final IEditCommandRequest request = new SetRequest(domain, configuration, NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_IndexStyle(), newStyle);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(configuration);
		final ICommand cmd = provider.getEditCommand(request);
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));

		// and finally update the current state
		HandlerUtil.updateRadioState(event.getCommand(), currentState);
		return null;
	}

	/**
	 * 
	 * @return
	 *         the axis configuration to edit
	 */
	protected abstract AbstractHeaderAxisConfiguration getAxisConfiguration();

}
