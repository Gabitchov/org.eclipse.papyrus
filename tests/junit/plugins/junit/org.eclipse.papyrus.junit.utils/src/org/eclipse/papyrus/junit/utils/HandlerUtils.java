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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.Assert;

/**
 * 
 * Useful methods for the handlers and the Eclipse commands
 * 
 */
public class HandlerUtils {

	/**
	 * Warning : you should be sure that the correct Editor/partView... has the focus to test the enablement if the handler!
	 * 
	 * @param commandId
	 *        the command id
	 * @return
	 *         the current handler for this command
	 */
	public static final IHandler getActiveHandlerFor(final String commandId) {
		return HandlerUtils.getCommand(commandId).getHandler();
	}

	/**
	 * 
	 * @param commandId
	 *        the commandId
	 * @return
	 *         the real handler for the command
	 */
	public static final IHandler getRealHandlerFor(final String commandId) {
		//commented because it works only on Eclipse4
		//imports to add : 
		//			- org.eclipse.e4.ui.model.application.MApplication;
		//			- org.eclipse.e4.core.contexts.IEclipseContext
		//			- org.eclipse.e4.core.commands.internal.HandlerServiceImpl
		//			- org.eclipse.ui.internal.handlers.E4HandlerProxy
		//		MApplication appl = (MApplication)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(MApplication.class);
		//		IEclipseContext context = appl.getContext();
		//		E4HandlerProxy handler = HandlerServiceImpl.lookUpHandler(context, commandId);
		//		return handler.getHandler();
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param commandId
	 *        the command id
	 * @return
	 *         the command object for this command id
	 */
	public static final Command getCommand(final String commandId) {
		final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		commandService.refreshElements(commandId, null);
		Assert.assertNotNull("CommandService can't be found", commandService);
		Command cmd = commandService.getCommand(commandId);
		Assert.assertNotNull("Command can't be found", cmd);
		return cmd;
	}

	/**
	 * Execute the command
	 * 
	 * @param cmd
	 *        a command
	 */
	public static final void executeCommand(final Command cmd) throws Exception {
		IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench().getService(IHandlerService.class);
		Assert.assertNotNull("Impossible to find handler service", handlerService);
		final ParameterizedCommand parameterizedCommand = new ParameterizedCommand(cmd, null);
		Assert.assertEquals("Command is not executable as expected", cmd.isEnabled(), true);
		//execute the command
		handlerService.executeCommand(parameterizedCommand, null);
	}

}
