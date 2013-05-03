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
package org.eclipse.papyrus.uml.nattable.menu.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.nattable.menu.messages.Messages;
import org.eclipse.papyrus.uml.nattable.menu.util.TableMenuUtils;
import org.eclipse.papyrus.uml.service.types.handlers.AbstractUmlCreateCommandHandler;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;

/**
 * Abstract handler for the creation commands of UML elements in the Nattable editor
 * 
 */
public abstract class AbstractUmlNattableCreateCommandHandler extends AbstractUmlCreateCommandHandler {

	@Override
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
	@Override
	protected Command buildCommand() {
		Command createCmd = super.buildCommand();

		final INattableModelManager nattableModelManager = TableMenuUtils.getTableManager(getActiveWorkbenchPart());
		if(nattableModelManager != null) {
			CompositeCommand cmd = new CompositeCommand(""); //$NON-NLS-1$
			cmd.add(new EMFtoGMFCommandWrapper(createCmd));

			final CreateElementRequest request = this.createRequest;
			//		depends on the synchronization of the axis manager
			cmd.add(new AbstractTransactionalCommand(getEditingDomain(), Messages.AbstractNattableCreateCommandHandler_AddElementCommand, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					EObject newElement = request.getNewElement();
					Collection<Object> toAdd = new ArrayList<Object>();
					toAdd.add(newElement);
					Command tmp = nattableModelManager.getAddRowElementCommand(toAdd);
					if(tmp != null) {
						tmp.execute();
					}
					return CommandResult.newOKCommandResult();
				}
			});
			return new org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper(cmd);

		}
		return UnexecutableCommand.INSTANCE;

	}

	@Override
	protected ICommandContext getCommandContext() {
		return TableMenuUtils.getTableCommandContext(TableMenuUtils.getTableManager(getActiveWorkbenchPart()));

	}

	@Override
	public void setEnabled(Object evaluationContext) {
		Command command = getCommand();
		boolean isEnabled = command.canExecute();
		if(isEnabled) {
			IElementType newElementType = getElementTypeToCreate();
			INattableModelManager tableManager = TableMenuUtils.getTableManager(getActiveWorkbenchPart());
			String id = newElementType.getId();
			Set<String> visibleCommands = getFilterIds();
			isEnabled = tableManager.canCreateRowElement(id);
			isEnabled &= visibleCommands.contains(id);
		}
		setBaseEnabled(isEnabled);
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
