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
package org.eclipse.papyrus.table.modelexplorer.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.table.modelexplorer.messages.Messages;

/**
 * This handler provides the duplicate action for the tables
 * 
 * 
 * 
 */
public class DuplicateTableHandler extends AbstractTableModelExplorerHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		final IPageMngr pageManager = getPageManager();
		List<TableInstance> tables = getSelectedTables();

		if(editingDomain != null && pageManager != null && !tables.isEmpty()) {
			CompoundCommand command = new CompoundCommand();
			for(TableInstance table : tables) {

				// Clone the current table
				final TableInstance newTable = EcoreUtil.copy(table);
				// Give a new name

				//we duplicate parameters and rename the new table!
				Object param = newTable.getParameter();
				if(param instanceof Map<?, ?>) {
					Map<String, Object> paramCopy = new HashMap((Map<?, ?>)param);
					String copyName = (String)((Map)param).get(AbstractNattableEditor.NAME_KEY); //$NON-NLS-1$
					copyName = new String(Messages.DuplicateTableHandler_CopyOf + copyName);
					paramCopy.put(AbstractNattableEditor.NAME_KEY, copyName); //$NON-NLS-1$
					newTable.setParameter(paramCopy);
				}

				Command addGmfDiagramCmd = new AddCommand(editingDomain, table.eResource().getContents(), newTable);
				// EMFCommandOperation operation = new
				// EMFCommandOperation(editingDomain,
				// addGmfDiagramCmd);

				Command sashOpenComd = new RecordingCommand(editingDomain) {

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

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}
}
