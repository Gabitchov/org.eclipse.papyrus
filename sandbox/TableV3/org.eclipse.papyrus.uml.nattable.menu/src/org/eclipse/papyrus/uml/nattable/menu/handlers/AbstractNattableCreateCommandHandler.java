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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.nattable.menu.messages.Messages;
import org.eclipse.papyrus.uml.service.types.handlers.AbstractCreateCommandHandler;
import org.eclipse.papyrus.uml.service.types.utils.CommandContext;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;
import org.eclipse.ui.IWorkbenchPart;



/**
 * Default handler for Create command used in the ModelExplorer contextual ("Create new child") menu.
 * 
 */
public abstract class AbstractNattableCreateCommandHandler extends AbstractCreateCommandHandler {

	protected abstract IElementType getElementTypeToCreate();

	/** Current createCommand for selection (updated in {@link AbstractNattableCreateCommandHandler#isEnabled()}) */
	protected INattableModelManager getTableManager() {
		IWorkbenchPart activePart = getActiveWorkbenchPart();
		if(activePart instanceof AbstractMultiPageSashEditor) {
			activePart = ((AbstractMultiPageSashEditor)activePart).getActiveEditor();
			if(activePart != null) {
				return (INattableModelManager)activePart.getAdapter(INattableModelManager.class);
			}

		}
		return null;
	}

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
		Command createCmd = super.buildCommand();

		final INattableModelManager natTable = getTableManager();
		if(natTable != null) {
			CompositeCommand cmd = new CompositeCommand(""); //$NON-NLS-1$
			cmd.add(new EMFtoGMFCommandWrapper(createCmd));

			final CreateElementRequest request = createRequest;
			//		depends on the synchronization of the axis manager
			cmd.add(new AbstractTransactionalCommand(getEditingDomain(), Messages.AbstractNattableCreateCommandHandler_AddElementCommand, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					EObject newElement = request.getNewElement();
					Collection<Object> toAdd = new ArrayList<Object>();
					toAdd.add(newElement);
					Command tmp = natTable.getAddRowElementCommand(toAdd);
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
		INattableModelManager manager = getTableManager();
		if(manager != null) {
			final EObject container = manager.getTable().getContext();
			EReference reference = null;
			ICommandContext context = null;
			if(container != null) {
				if(reference != null) {
					context = new CommandContext(container, reference);
				} else {
					context = new CommandContext(container);
				}
			}

			return context;
		}
		return null;

	}

}
