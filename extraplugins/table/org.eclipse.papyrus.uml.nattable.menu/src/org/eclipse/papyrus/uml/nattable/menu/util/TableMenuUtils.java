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
package org.eclipse.papyrus.uml.nattable.menu.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.uml.nattable.menu.messages.Messages;
import org.eclipse.papyrus.uml.service.types.utils.CommandContext;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Utilities for the creation of contextual menus from the Nattable editor
 */
public class TableMenuUtils {

	/**
	 * FIXME move me in an upper plugin
	 * 
	 * @param tableManager
	 *        the table manager
	 * @return
	 *         the command context to use to create new elements in the table
	 */
	public static ICommandContext getTableCommandContext(INattableModelManager tableManager) {
		INattableModelManager manager = tableManager;
		if(manager != null) {
			final EObject container = manager.getTable().getContext();
			ICommandContext context = null;
			if(container != null) {
				context = new CommandContext(container);
			}
			return context;
		}
		return null;
	}

	/**
	 * FIXME move me in an upper plugin
	 * 
	 * @param activeWorkbenchPart
	 * @return
	 *         the table manager from the workbench part
	 */
	public static INattableModelManager getTableManager(IWorkbenchPart activeWorkbenchPart) {
		IWorkbenchPart activePart = activeWorkbenchPart;
		if(activePart instanceof AbstractMultiPageSashEditor) {
			activePart = ((AbstractMultiPageSashEditor)activePart).getActiveEditor();
			if(activePart != null) {
				return (INattableModelManager)activePart.getAdapter(INattableModelManager.class);
			}

		}
		return null;
	}

	public static Command buildNattableCreationCommand(Command createCmd, final CreateElementRequest createElementRequest) {
		final INattableModelManager nattableModelManager = getTableManager(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart());
		if(nattableModelManager != null) {
			CompositeCommand cmd = new CompositeCommand(""); //$NON-NLS-1$
			cmd.add(new EMFtoGMFCommandWrapper(createCmd));

			//		depends on the synchronization of the axis manager
			cmd.add(new AbstractTransactionalCommand(createElementRequest.getEditingDomain(), Messages.AbstractNattableCreateCommandHandler_AddElementCommand, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					EObject newElement = createElementRequest.getNewElement();
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

}
