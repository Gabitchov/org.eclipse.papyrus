/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.eclipse.papyrus.sysml.modelexplorer.filter.CommandFilter;
import org.eclipse.papyrus.views.modelexplorer.ICommandContext;
import org.eclipse.papyrus.views.modelexplorer.ICommandFilter;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;

/**
 * Default handler for Create command used in the ModelExplorer contextual ("Create new child") menu.
 * 
 */
public abstract class CreateCommandHandler extends AbstractCommandHandler {

	protected abstract IElementType getElementTypeToCreate();

	protected ICommandFilter filter = new CommandFilter();

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
	protected Command buildCommand() {

		ICommandContext commandContext = getCommandContext();
		if(commandContext == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject container = commandContext.getContainer();
		EReference reference = commandContext.getReference();

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		// Retrieve create command from the Element Edit service
		CreateElementRequest createRequest = null;
		if(reference == null) {
			createRequest = new CreateElementRequest(container, getElementTypeToCreate());
		} else {
			createRequest = new CreateElementRequest(container, getElementTypeToCreate(), reference);
		}

		ICommand createGMFCommand = provider.getEditCommand(createRequest);

		Command emfCommand = new org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper(createGMFCommand);
		return emfCommand;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return current command (only built here when the stored command is null)
	 */
	@Override
	protected Command getCommand() {

		// Build the command in case it is not initialized.
		if(createCommand == null) {
			createCommand = buildCommand();
		}

		return createCommand;
	}

	/**
	 * Add selection on new element after creation.
	 * 
	 * @see org.listerel.papyrus.sysml.modelexplorer.common.handler.AbstractCommandHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object result = super.execute(event);

		// Find newly created element
		EObject newElement = null;

		if(result instanceof Collection<?>) {
			Collection<?> results = (Collection<?>)result;
			if((!results.isEmpty()) && (results.toArray()[0] instanceof EObject)) {
				newElement = (EObject)results.toArray()[0];
			}
		}

		// Retrieve model explorer
		ModelExplorerView modelExplorerView = null;

		ModelExplorerPageBookView bookViewPart = (ModelExplorerPageBookView)NavigatorUtils.findViewPart("org.eclipse.papyrus.views.modelexplorer.modelexplorer"); //$NON-NLS-0$
		if(bookViewPart != null) {
			modelExplorerView = (ModelExplorerView)bookViewPart.getActiveView();
		}

		// Set selection on new element in the model explorer
		if((modelExplorerView != null) && (newElement != null)) {
			List<EObject> semanticElementList = new ArrayList<EObject>();
			semanticElementList.add(newElement);
			modelExplorerView.revealSemanticElement(semanticElementList);
		}

		return result;
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
		if(!filter.getVisibleCommands().contains(getElementTypeToCreate())) {
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
		if(!filter.getVisibleCommands().contains(getElementTypeToCreate())) {
			return false;
		}

		return super.isEnabled();
	}

}
