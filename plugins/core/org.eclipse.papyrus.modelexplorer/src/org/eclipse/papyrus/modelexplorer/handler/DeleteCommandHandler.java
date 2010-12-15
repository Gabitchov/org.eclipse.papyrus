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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.handler;

import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

/**
 * Default handler for Delete command used in the ModelExplorer contextual menu.
 * 
 */
public class DeleteCommandHandler extends AbstractCommandHandler implements IHandler {

	/** Current deleteCommand for selection (updated in {@link DeleteCommandHandler#isEnabled()}) */
	private Command deleteCommand;

	/**
	 * <pre>
	 * 
	 * Build the delete command for a set of EObject selected in the ModelExplorer.
	 * The delete command is given by the {@link IElementEditService} of selected 
	 * elements.
	 * 
	 * @return the composite deletion command for current selection
	 * 
	 * @TODO : Manage possible Diagrams listed in the selection
	 * 
	 * </pre>
	 */
	private Command buildCommand() {

		ICommand gmfCommand = null;
		for(EObject selectedEObject : getSelectedElements()) {

			if(selectedEObject == null) {
				continue;
			}

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
			if(provider == null) {
				continue;
			}

			// Retrieve delete command from the Element Edit service
			DestroyElementRequest request = new DestroyElementRequest(selectedEObject, false);
			ICommand deleteCommand = provider.getEditCommand(request);

			// Add current EObject destroy command to the global command
			gmfCommand = CompositeCommand.compose(gmfCommand, deleteCommand);
		}

		if(gmfCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}

		Command emfCommand = new GMFtoEMFCommandWrapper(gmfCommand.reduce());
		return emfCommand;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return current command (only built here when the stored command is null)
	 */
	protected Command getCommand() {

		// Build the delete command in case it is not initialized.
		if(deleteCommand == null) {
			deleteCommand = buildCommand();
		}

		return deleteCommand;
	}

	/**
	 * <pre>
	 * 
	 * Calculates whether the handler is enabled or not. The command is re-built on the
	 * basis of current selection before any attempt to test if current command can be executed.
	 * 
	 * @see org.eclipse.papyrus.modelexplorer.handler.AbstractCommandHandler#isEnabled()
	 * 
	 * @return true if the command can be executed
	 * 
	 * </pre>
	 */
	public boolean isEnabled() {

		// Prepare and store the delete command only when trying to find out 
		// whether the command is enabled or not.
		// This assumes the isEnabled() method is called each time the contextual menu
		// opens. 
		deleteCommand = buildCommand();

		return super.isEnabled();
	}
}
