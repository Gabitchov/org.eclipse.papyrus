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
package org.eclipse.papyrus.infra.table.modelexplorer.handlers;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.modelexplorer.messages.Messages;
import org.eclipse.swt.widgets.Display;

/**
 * This handler provides the method to rename a Table
 * 
 * 
 * 
 */
public class RenameTableHandler extends AbstractTableModelExplorerHandler {


	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<PapyrusTableInstance> tables = getSelectedTables();
		if(editingDomain != null && tables.size() == 1) {

			final PapyrusTableInstance table = tables.get(0);
			final String currentName = table.getName();

			if(currentName != null) {

				AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "RenameTableCommand", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) {
						InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), Messages.RenameTableHandler_RenameAnExistingTable_Title, Messages.RenameTableHandler_NewNameMessage, currentName, null);
						if(dialog.open() == Window.OK) {
							final String name = dialog.getValue();
							if(name != null && name.length() > 0) {
								table.setName(name);
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
