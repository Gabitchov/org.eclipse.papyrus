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

import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.modelexplorer.handler.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.table.modelexplorer.messages.Messages;
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
	 * @see org.eclipse.papyrus.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<TableInstance> tables = getSelectedTables();
		if(editingDomain != null && tables.size() == 1) {

			final TableInstance table = tables.get(0);

			final Object param = table.getParameter();
			if(param instanceof Map<?, ?>) {
				final String currentName = (String)((Map<?, ?>)param).get(AbstractNattableEditor.NAME_KEY); //$NON-NLS-1$

				if(currentName != null) {

					AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "RenameTableCommand", null) { //$NON-NLS-1$

						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), Messages.RenameTableHandler_RenameAnExistingTable_Title, Messages.RenameTableHandler_NewNameMessage, currentName, null);
							if(dialog.open() == Window.OK) {
								final String name = dialog.getValue();
								if(name != null && name.length() > 0) {
									((Map<String, Object>)param).put(AbstractNattableEditor.NAME_KEY, name); //$NON-NLS-1$
									IPageMngr mngr = getPageManager();
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
		}
		return UnexecutableCommand.INSTANCE;
	}
}
