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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.modelexplorer.messages.Messages;

/**
 * This handler provides the duplicate action for the tables
 * 
 * 
 * 
 */
public class DuplicateTableHandler extends AbstractTableModelExplorerHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		final IPageManager pageManager = getPageManager();
		List<PapyrusTableInstance> tables = getSelectedTables();

		if(editingDomain != null && pageManager != null && !tables.isEmpty()) {
			CompoundCommand command = new CompoundCommand();
			for(PapyrusTableInstance table : tables) {

				// Clone the current table
				final PapyrusTableInstance newTable = EcoreUtil.copy(table);

				// Give a new name
				newTable.setName(Messages.DuplicateTableHandler_CopyOf + newTable.getName());

				//we duplicate parameters and rename the new table!


				Command addGmfDiagramCmd = new AddCommand(editingDomain, table.eResource().getContents(), newTable);
				//				EMFCommandOperation operation = new EMFCommandOperation(editingDomain, addGmfDiagramCmd);

				Command sashOpenCmd = new RecordingCommand(editingDomain, "Open duplicated table") {

					@Override
					protected void doExecute() {
						pageManager.openPage(newTable);
					}
				};
				//
				//				// TODO : synchronize with Cedric
				//				command.append(operation.getCommand());
				command.append(addGmfDiagramCmd);
				command.append(sashOpenCmd);
			}
			return command.isEmpty() ? UnexecutableCommand.INSTANCE : command;
		}
		return UnexecutableCommand.INSTANCE;
	}
}
