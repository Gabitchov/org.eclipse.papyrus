/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431109
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.util.WorkbenchPartHelper;
import org.eclipse.papyrus.uml.service.types.filter.ICommandFilter;
import org.eclipse.papyrus.uml.service.types.filter.UmlElementCommandFilter;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Abstract handler for commands regarding creation of elements
 * 
 */
public abstract class AbstractCreateCommandHandler extends AbstractCommandHandler {

	/** Current createCommand for selection (updated in {@link AbstractUmlCreateCommandHandler#isEnabled()}) */
	protected Command createCommand;

	protected CreateElementRequest createRequest;

	protected abstract IElementType getElementTypeToCreate();

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
	protected Command buildCommand() {
		ICommandContext commandContext = getCommandContext();
		if(commandContext == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject container = commandContext.getContainer();

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		ICommand createGMFCommand = provider.getEditCommand(createRequest);
		if(createGMFCommand != null) {
			Command emfCommand = org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper.wrap(createGMFCommand);
			return emfCommand;
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @return
	 *         the creation request to use in this handler
	 */
	protected CreateElementRequest buildRequest() {
		ICommandContext commandContext = getCommandContext();
		if(commandContext != null) {
			EObject container = commandContext.getContainer();
			EReference reference = commandContext.getReference();
			boolean nullReference = reference == null;
			return nullReference ? new CreateElementRequest(getEditingDomain(), container, getElementTypeToCreate()) : new CreateElementRequest(getEditingDomain(), container, getElementTypeToCreate(), reference);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.handlers.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return current command
	 */
	protected Command getCommand() {
		// In case we had one before, dispose it before replacing it
		disposeCommand();
		
		createRequest = buildRequest();
		createCommand = buildCommand();
		return createCommand;
	}

	protected IWorkbenchPart getActiveWorkbenchPart() {
		return WorkbenchPartHelper.getCurrentActiveWorkbenchPart();
	}


	/**
	 * This method is called by the commands service to validate if this particular handler is active.
	 * By default, the creation of UML handlers only verify that the element to be created is allowed by the applied filter (
	 * {@link UmlElementCommandFilter}, ...)
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.handlers.AbstractCommandHandler#setEnabled(java.lang.Object)
	 * 
	 * 
	 * @param evaluationContext
	 */
	public void setEnabled(Object evaluationContext) {
		IElementType newElementType = getElementTypeToCreate();
		boolean isEnabled = getCommandFilter().getVisibleCommands().contains(newElementType);

		if(isEnabled) {
			Command command = getCommand();
			isEnabled = command.canExecute();
		}
		setBaseEnabled(isEnabled);
	}

	/** returns the command filter to use for this handler */
	public abstract ICommandFilter getCommandFilter();
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object result;
		
		try {
			result = super.execute(event);
		} finally {
			// If execution succeeded, the command will be disposed later by the history.
			// If it failed, the history already disposed it.
			// Either way, we should not dispose it.
			createCommand = null;
			createRequest = null;
		}
		
		return result;
	}
	
	private void disposeCommand() {
		if(createCommand != null) {
			createCommand.dispose();
		}
		createRequest = null;
		createCommand = null;
	}
	
	@Override
	public void dispose() {
		disposeCommand();
		super.dispose();
	}
}
