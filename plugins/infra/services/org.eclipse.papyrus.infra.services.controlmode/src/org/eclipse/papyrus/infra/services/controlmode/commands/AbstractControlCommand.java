/*****************************************************************************
 * Copyright (c) 2013 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.commands;

import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;


/**
 * Abstract Command used for base command for all command that use {@link ControlModeRequest}
 * 
 * @author adaussy
 * 
 */
public abstract class AbstractControlCommand extends AbstractTransactionalCommand {

	/**
	 * {@link ControlModeRequest} used to compute the command
	 */
	protected ControlModeRequest request;

	@SuppressWarnings("rawtypes")
	public AbstractControlCommand(String label, List affectedFiles, ControlModeRequest request) {
		super(request.getEditingDomain(), label, affectedFiles);
		this.request = request;
	}

	/**
	 * @return {@link AbstractControlCommand#request}
	 */
	protected ControlModeRequest getRequest() {
		return request;
	}

	/**
	 * Utils method used to create error during command
	 * 
	 * @param message
	 * @return
	 */
	protected CommandResult createNewControlCommandError(String message) {
		return CommandResult.newErrorCommandResult(message);
	}
}
