/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.controller;

import static org.eclipse.papyrus.properties.runtime.Activator.log;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;


/**
 * Controller for property editors, that manages EMFT-based models. This means that a transaction will be opened each time the model has to be
 * modified
 */
public abstract class EMFTPropertyEditorController extends EMFPropertyEditorController {

	/** Transactional editing domain used to wirte into the model */
	private TransactionalEditingDomain editingDomain;

	/**
	 * Constructor.
	 */
	public EMFTPropertyEditorController() {
		super();
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void updateModel() {
		AbstractTransactionalCommand command = new EMFTControllerCommand();
		if(command.canExecute()) {
			try {
				OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				log.error(e);
			}
		}
	}

	/**
	 * Returns the editing domain that manages modifications to the model
	 * 
	 * @return the editing domain that manages modifications to the model
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * Sets the editingDomain for this controller
	 * 
	 * @param editingDomain
	 *        the editingDomain to set
	 */
	public void setEditingDomain(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * Command to modify the model, using the property editors
	 */
	protected class EMFTControllerCommand extends AbstractTransactionalCommand {

		/**
		 * Creates the new EMFTControllerCommand.
		 */
		public EMFTControllerCommand() {
			super(editingDomain, "Editing Property", getWorkspaceFiles(getObjectsToEdit()));
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			setValueInModel(getEditorValue());
			return CommandResult.newOKCommandResult(getObjectsToEdit());
		}
	}

}
