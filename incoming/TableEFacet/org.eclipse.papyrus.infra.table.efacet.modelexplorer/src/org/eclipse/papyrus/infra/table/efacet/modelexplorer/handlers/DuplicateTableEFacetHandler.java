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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.modelexplorer.messages.Messages;

/**
 * This handler provides the duplicate action for the tables
 * 
 * 
 * 
 */
public class DuplicateTableEFacetHandler extends AbstractTableEFacetHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		final TransactionalEditingDomain editingDomain = getEditingDomain();
		final IPageMngr pageManager = getPageManager();
		final List<PapyrusTable> tables = getSelectedTables();

		if(editingDomain != null && pageManager != null && !tables.isEmpty()) {
			final CompoundCommand command = new CompoundCommand();
			for(final PapyrusTable table : tables) {

				// Clone the current diagram
				final PapyrusTable newTable = EcoreUtil.copy(table);
				// Give a new name
				newTable.setName(NLS.bind(Messages.DuplicateTableEFacetHandler_CopyOf, table.getName()));
				final Command addGmfDiagramCmd = new AddCommand(editingDomain, table.eResource().getContents(), newTable);
				// EMFCommandOperation operation = new
				// EMFCommandOperation(editingDomain,
				// addGmfDiagramCmd);

				final Command sashOpenComd = new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						pageManager.openPage(newTable);
					}
				};

				// TODO : synchronize with Cedric
				// command.append(operation.getCommand());
				command.append(addGmfDiagramCmd);
				command.append(sashOpenComd);
			}
			return command.isEmpty() ? UnexecutableCommand.INSTANCE : command;
		}
		return UnexecutableCommand.INSTANCE;
	}
}
