/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.handler;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.modelexplorer.messages.Messages;
import org.eclipse.swt.widgets.Display;

/**
 * This handler provides the method to rename a Diagram
 * 
 * 
 * 
 */
public class RenameDiagramHandler extends AbstractCommandHandler {


	/**
	 * 
	 * @see org.eclipse.papyrus.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<Diagram> diagrams = getSelectedDiagrams();
		if(editingDomain != null && diagrams.size() == 1) {

			final Diagram diag = diagrams.get(0);
			final String currentName = diag.getName();
			if(currentName != null) {

				AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "RenameCommand", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), Messages.RenameDiagramHandler_rename_an_existing_diagram, Messages.RenameDiagramHandler_new_name, currentName, null);
						if(dialog.open() == Window.OK) {
							final String name = dialog.getValue();
							if(name != null && name.length() > 0) {
								diag.setName(name);
							}
							return CommandResult.newOKCommandResult();
						} else {
							return CommandResult.newCancelledCommandResult();
						}
					}
				};
				return new GMFtoEMFCommandWrapper(cmd);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
}
