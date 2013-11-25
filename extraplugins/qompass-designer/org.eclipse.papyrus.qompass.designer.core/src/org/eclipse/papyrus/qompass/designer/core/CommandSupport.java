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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;

/**
 * Utility function. Allow execution of commands on a transactional command stack
 * 
 * @author ansgar
 * 
 */
public class CommandSupport {

	/**
	 * Execute the passed Runnable within a command
	 * 
	 * @param label
	 * @param command
	 */
	public static void exec(String label, ExecutionEvent event, final Runnable command) {
		ServiceUtilsForHandlers serviceUtils = ServiceUtilsForHandlers.getInstance();
		try {
			exec(serviceUtils.getTransactionalEditingDomain(event), label, command);
		} catch (ServiceException e) {
			Log.log(Status.ERROR, Log.UTILS, Messages.CommandSupport_NoEditingDomain, e);
		}
	}

	/**
	 * Execute the passed Runnable with result within a command
	 * 
	 * @param label
	 * @param command
	 */
	public static void exec(String label, ExecutionEvent event, final RunnableWithResult command) {
		// ServiceUtilsForActionHandlers serviceUtils = ServiceUtilsForActionHandlers.getInstance();
		ServiceUtilsForHandlers serviceUtils = ServiceUtilsForHandlers.getInstance();
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		try {
			history.execute(new AbstractTransactionalCommand(serviceUtils.getTransactionalEditingDomain(event),
				label, Collections.EMPTY_LIST) {

				public CommandResult doExecuteWithResult(IProgressMonitor dummy, IAdaptable info) {
					return command.run();
				}
			}, null, null);
		} catch (ExecutionException e) {
			Log.log(Status.ERROR, Log.UTILS, Messages.CommandSupport_ErrorDuringCmdExec, e);
		} catch (ServiceException e) {
			Log.log(Status.ERROR, Log.UTILS, Messages.CommandSupport_NoEditingDomain, e);
		}
	}

	/**
	 * Execute the passed Runnable within a command
	 * 
	 * @param label
	 * @param command
	 */
	public static void exec(TransactionalEditingDomain domain, String label, final Runnable command) {
		if(domain == null) {
			command.run();
		}
		else {
			IOperationHistory history = OperationHistoryFactory.getOperationHistory();
			try {
				history.execute(new AbstractTransactionalCommand(domain, label, Collections.EMPTY_LIST) {

					public CommandResult doExecuteWithResult(IProgressMonitor dummy, IAdaptable info) {
						command.run();
						return CommandResult.newOKCommandResult();
					}
				}, null, null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	public static void exec(TransactionalEditingDomain domain, IUndoableOperation command) {
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		try {
			history.execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
}
