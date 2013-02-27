/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.service.types.Activator;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;

/**
 * <pre>
 * 
 * This abstract command handler manages:
 * - current selection in order to build a list of the selected {@link EObject}
 * - execute the command (returned by children) in Papyrus {@link TransactionalEditingDomain}
 * - calculate the command enablement and visibility regarding the command executability
 * (the command is now shown in menu if not executable).
 * 
 * </pre>
 */
public abstract class AbstractCommandHandler extends AbstractHandler {

	/**
	 * <pre>
	 * 
	 * Returns the command to execute (to be implemented 
	 * in children implementing this class)
	 * 
	 * @return the command to execute
	 * 
	 * </pre>
	 */
	protected abstract Command getCommand();

	/**
	 * <pre>
	 * Parse current selection and extract the command context (can be null).
	 * 
	 * @return the command context based on current selection
	 * </pre>
	 */
	protected abstract ICommandContext getCommandContext();

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return null
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Command creationcommand = getCommand();
		getEditingDomain().getCommandStack().execute(creationcommand);
		return creationcommand.getResult();
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return true (enabled) when the command can be executed.
	 */
	@Override
	public boolean isEnabled() {
		return getCommand().canExecute();
	}

	/**
	 * 
	 * @return true (visible) when the command can be executed.
	 */
	public boolean isVisible() {
		return getCommand().canExecute();
	}

	protected TransactionalEditingDomain getEditingDomain() {
		ICommandContext cmdContext = getCommandContext();
		if(cmdContext != null) {
			try {
				return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(cmdContext.getContainer());
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}
		return null;
	}
}
