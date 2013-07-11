/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.table.efacet.modelexplorer.handlers;

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
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.modelexplorer.messages.Messages;
import org.eclipse.swt.widgets.Display;

/**
 * This handler provides the method to rename a Table
 * 
 * 
 * 
 */
public class RenameTableEFacetHandler extends AbstractTableEFacetHandler {


	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		final TransactionalEditingDomain editingDomain = getEditingDomain();
		final List<PapyrusTable> tables = getSelectedTables();
		if(editingDomain != null && tables.size() == 1) {

			final PapyrusTable table = tables.get(0);
			final String currentName = table.getName();

			if(currentName != null) {

				final AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "Rename EFacetTable", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) {
						final InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), Messages.RenameTableEFacetHandler_RenameAnExistingTable, Messages.RenameTableEFacetHandler_NewName, currentName, null);
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
