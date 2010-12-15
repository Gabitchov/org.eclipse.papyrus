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
 * 		Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.handler;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.modelexplorer.filter.CommandFilter;

/**
 * Default handler for Create command used in the ModelExplorer contextual ("Create new child") menu.
 * 
 */
public abstract class CreateCommandHandler extends AbstractCommandHandler {

	protected abstract IElementType getElementTypeToCreate();

	/** Current createCommand for selection (updated in {@link CreateCommandHandler#isEnabled()}) */
	private Command createCommand;

	/**
	 * <pre>
	 * 
	 * Build the create command for an element creation in the selected container.
	 * The create command is given by the {@link IElementEditService} of selected 
	 * element.
	 * 
	 * @return the composite creation command for current selection
	 * 
	 * </pre>
	 */
	private Command buildCommand() {

		if(getSelectedElements().size() != 1) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject container = getSelectedElements().get(0);

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		// Retrieve create command from the Element Edit service
		CreateElementRequest createRequest = new CreateElementRequest(container, getElementTypeToCreate());
		ICommand createGMFCommand = provider.getEditCommand(createRequest);

		Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		return emfCommand;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return current command (only built here when the stored command is null)
	 */
	protected Command getCommand() {

		// Build the command in case it is not initialized.
		if(createCommand == null) {
			createCommand = buildCommand();
		}

		return createCommand;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.modelexplorer.handler.AbstractCommandHandler#isVisible()
	 * 
	 * @return
	 */
	@Override
	public boolean isVisible() {

		// Temporary (customizable implementation to be provided) filter to avoid all
		// creation command to be visible (avoid to large set of possible children).
		if(!CommandFilter.getVisibleCommands().contains(getElementTypeToCreate())) {
			return false;
		}

		return super.isVisible();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.modelexplorer.handler.AbstractCommandHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {

		// Prepare and store the delete command only when trying to find out 
		// whether the command is enabled or not.
		// This assumes the isEnabled() method is called each time the contextual menu
		// opens. 
		createCommand = buildCommand();

		// Temporary (customizable implementation to be provided) filter to avoid all
		// creation command to be visible (avoid to large set of possible children).
		if(!CommandFilter.getVisibleCommands().contains(getElementTypeToCreate())) {
			return false;
		}

		return super.isEnabled();
	}

}
