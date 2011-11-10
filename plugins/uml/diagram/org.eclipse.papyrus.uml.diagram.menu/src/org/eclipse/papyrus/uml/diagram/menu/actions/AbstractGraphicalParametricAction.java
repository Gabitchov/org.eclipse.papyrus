/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.uml.diagram.common.Activator;


public abstract class AbstractGraphicalParametricAction extends AbstractParametricAction {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        parameter for the action
	 * @param selectedEditPart
	 *        the selectedEditPart for the action
	 */
	public AbstractGraphicalParametricAction(String parameter, List<IGraphicalEditPart> selectedEditPart) {
		super(parameter, selectedEditPart);
	}

	/**
	 * Returns the command for this action
	 * 
	 * @return
	 *         the command for this action
	 */
	public Command getCommand() {
		if(isEnabled()) {
			Command cmd = getBuildedCommand();
			if(cmd != null && cmd.canExecute()) {
				return cmd;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @return
	 *         the command for this action
	 */
	protected abstract Command getBuildedCommand();

	/**
	 * Returns the {@link TransactionalEditingDomain}
	 * 
	 * @return the {@link TransactionalEditingDomain} or <code>null</code> if it can not be found
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = null;
		try {
			editingDomain = ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return editingDomain;
	}
}
