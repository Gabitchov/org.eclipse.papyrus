/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.strategy;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.dnd.Activator;

/**
 * An abstract implementation for TransactionalDropStrategies. Extenders do not
 * need to implement their commands' #undo and #redo methods.
 * 
 * @author Camille Letavernier
 */
public abstract class TransactionalDropStrategy extends AbstractDropStrategy {

	public final Command getCommand(Request request, EditPart targetEditPart) {

		final Command command = doGetCommand(request, targetEditPart);

		if(command == null) {
			return null;
		}

		String label = command.getLabel();
		if(label == null || "".equals(label)) {
			label = getLabel();
		}

		AbstractTransactionalCommand transactionalCommand = new AbstractTransactionalCommand(getTransactionalEditingDomain(targetEditPart), label, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				try {
					command.execute();
					return CommandResult.newOKCommandResult();
				} catch (Exception ex) {
					Activator.log.error(ex);
					return CommandResult.newErrorCommandResult(ex);
				}
			}
		};

		return new ICommandProxy(transactionalCommand);
	}

	protected boolean isTransactional(EditPart targetEditPart) {
		return getTransactionalEditingDomain(targetEditPart) != null;
	}

	protected TransactionalEditingDomain getTransactionalEditingDomain(EditPart targetEditPart) {
		EditingDomain domain = getEditingDomain(targetEditPart);
		if(domain instanceof TransactionalEditingDomain) {
			return (TransactionalEditingDomain)domain;
		}
		return null;
	}

	protected EditingDomain getEditingDomain(EditPart targetEditPart) {
		return EMFHelper.resolveEditingDomain(targetEditPart);
	}

	/**
	 * The command to be executed when the strategy is applied.
	 * Should return null if the strategy cannot handle the request.
	 * 
	 * @param request
	 *        The drop request
	 * @param targetEditPart
	 *        The target edit part
	 * @return
	 *         A command, or null if the strategy cannot handle the request
	 */
	protected abstract Command doGetCommand(Request request, EditPart targetEditPart);
}
