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
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.controller;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.TransactionUtil;


/**
 * Controller for property editors, that manages EMFT-based models. This means that a transaction will be opened each time the model has to be
 * modified
 */
public abstract class EMFTPropertyEditorController extends EMFPropertyEditorController {

	/** Transactional editing domain used to write into the model */
	private TransactionalEditingDomain editingDomain;

	/** model handler to interact with the model for this controller */
	protected IEMFModelHandler modelHandler;

	/**
	 * Constructor.
	 */
	public EMFTPropertyEditorController() {
		super();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController#updateModel()
	 * 
	 */
	@Override
	public void updateModel() {
		CompositeCommand cc = new CompositeCommand("Set Value Command"); //$NON-NLS-1$
		Object valueToSet = getEditorValue();
		for(Object obj : this.objectToEdit) {
			EObject elementToEdit = (EObject)obj;
			//build the request
			SetRequest[] req = null;
			req = modelHandler.getSetRequest(getEditingDomain(), elementToEdit, valueToSet);
			if(req == null) {
				break;
			}
			org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(elementToEdit);
			if(provider != null) {

				ICommand editCommand = null;
				for(SetRequest current : req) {
					editCommand = provider.getEditCommand(current);

					if(editCommand != null && editCommand.canExecute()) {
						cc.add(editCommand);
					}
				}
			}

			if(cc.canExecute() && !(TransactionUtil.isReadTransactionInProgress(getEditingDomain(), true, true))) {
				getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(cc));
				return;
			}
		}

		/*
		 * req was null, or the command was unexecutable
		 * Currently, the handler for stereotype return always null!
		 */
		AbstractTransactionalCommand command = new EMFTControllerCommand();
		if(command.canExecute() && !(TransactionUtil.isReadTransactionInProgress(editingDomain, true, true))) {
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
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
			super(editingDomain, "Editing Property", getWorkspaceFiles(getObjectsToEdit())); //$NON-NLS-1$
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
