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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.papyrus.uml.diagram.common.Messages;

/**
 * Command that pops up a dialog to ask which values you want.
 */
public class SetDynamicValueCommand extends EditElementCommand implements IUndoableOperation {

	/** request that configures this command */
	protected AbstractEditCommandRequest request;

	/** list of properties to edit */
	protected List<String> propertiesToEdit;

	/** title for the dialog */
	private String title = Messages.SetDynamicValueCommand_DialogTile;

	/** message for the dialog */
	private String message = Messages.SetDynamicValueCommand_DialogMessage;

	/**
	 * Constructor.
	 * 
	 * @param label
	 * @param elementToEdit
	 * @param request
	 */
	protected SetDynamicValueCommand(DynamicConfigureRequest request) {
		super(request.getLabel(), request.getElementToEdit(), request);
		this.propertiesToEdit = request.getPropertiesToDefine();
		this.request = request;
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// we edit meta-element properties
		DefinedPropertiesAtRuntimeDialog dialog = new DefinedPropertiesAtRuntimeDialog(DisplayUtils.getDefaultShell(), title, message, propertiesToEdit, getElementToEdit());
		dialog.open();

		return CommandResult.newOKCommandResult();
	}

	/**
	 * Checks that the feature is a modifiable feature of the element whose
	 * value will be set by this command. Also checks that the new value is of
	 * the correct type for the feature.
	 */
	public boolean canExecute() {
		EObject elementToEdit = getElementToEdit();
		if(elementToEdit == null || !super.canExecute()) {
			return false;
		}
		return true;
	}
}
