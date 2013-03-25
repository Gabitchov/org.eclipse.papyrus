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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RadioState;



public abstract class AbstractChangeIndexStyleHandler extends AbstractChangeHeaderStyleConfiguration {


	public Object execute(ExecutionEvent event) throws ExecutionException {
		final AbstractAxisConfiguration configuration = getAxisConfiguration();
		if(configuration instanceof DefaultAxisConfiguration) {

			if(HandlerUtil.matchesRadioState(event)) {
				return null; // we are already in the updated state - do nothing
			}
			String currentState = event.getParameter(RadioState.PARAMETER_ID);

			// do whatever having "currentState" implies
			TransactionalEditingDomain domain = getEditingDomain();
			AxisIndexStyle newStyle = AxisIndexStyle.get(currentState);
			final org.eclipse.emf.common.command.Command cmd = SetCommand.create(domain, configuration, NattableaxisconfigurationPackage.eINSTANCE.getDefaultAxisConfiguration_IndexStyle(), newStyle);
			domain.getCommandStack().execute(cmd);

			// and finally update the current state
			HandlerUtil.updateRadioState(event.getCommand(), currentState);

			return null;
		}


		return null;
	}

}
