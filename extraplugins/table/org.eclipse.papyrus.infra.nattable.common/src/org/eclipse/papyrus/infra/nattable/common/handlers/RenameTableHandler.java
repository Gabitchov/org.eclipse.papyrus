/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForIEvaluationContext;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;

/**
 * This handler allows to rename a Papyrus Table. The handler is activated when
 * the active editor is a Papyrus NatTableEditor.
 * 
 * @author Camille Letavernier
 * 
 */
public class RenameTableHandler extends AbstractHandler {

	public static String RenameTableHandler_NewName = "New name:";

	public static String RenameTableHandler_RenameAnExistingTable = "Rename an existing table";

	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * @param event
	 * @return
	 * @throws ExecutionException
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		executeTransaction(event);

		return null;
	}

	/**
	 * Execute as transaction
	 * 
	 * @param event
	 */
	private void executeTransaction(ExecutionEvent event) {

		// Get requested objects
		final Table tableElement;
		TransactionalEditingDomain editingDomain;
		try {
			IEvaluationContext context = getIEvaluationContext(event);
			tableElement = lookupTable(context);
			editingDomain = lookupTransactionalEditingDomain(context);
		} catch (ServiceException e) {
			// silently fails
			return;
		}

		if(tableElement == null) {
			return;
		}

		// Open the dialog to ask the new name
		String currentName = tableElement.getName();
		String newName = null;
		InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), RenameTableHandler_RenameAnExistingTable, RenameTableHandler_NewName, currentName, null);
		if(dialog.open() == Window.OK) {
			newName = dialog.getValue();
			if(newName == null || newName.length() <= 0) {
				return;
			}
		} else {
			// cancelled
			return;
		}

		final String name = newName;
		Command cmd = new RecordingCommand(editingDomain, getCommandName()) {

			@Override
			protected void doExecute() {
				// Rename the table !
				tableElement.setName(name);
			}

		};

		editingDomain.getCommandStack().execute(cmd);
	}

	/**
	 * Get the name used in the {@link RecordingCommand}. This name will be
	 * visible in undo/redo.
	 * 
	 * @return The command name to show.
	 */
	public String getCommandName() {
		return "Rename Table";
	}

	protected IEvaluationContext getIEvaluationContext(ExecutionEvent event) {
		if(event.getApplicationContext() instanceof IEvaluationContext) {
			return (IEvaluationContext)event.getApplicationContext();
		}
		return null;

	}

	/**
	 * Get the Table model element. This method can be used from {@link #execute(ExecutionEvent)} or {@link #setEnabled(Object)}.
	 * 
	 * @return The current table
	 * @throws ServiceException
	 */
	protected Table lookupTable(IEvaluationContext context) throws ServiceException {
		IEditorPart editor = ServiceUtilsForIEvaluationContext.getInstance().getNestedActiveIEditorPart(context);

		if(!(editor instanceof NatTableEditor)) {
			return null;
		}
		NatTableEditor tableEditor = (NatTableEditor)editor;

		Table table = ((INattableModelManager)tableEditor.getAdapter(INattableModelManager.class)).getTable();

		// Return a new instance of the Helper
		return table;
	}

	/**
	 * Try to lookup the TransactionalEditingDomain.
	 * 
	 * @return
	 * @throws ServiceException
	 *         If the Editing domain can't be found.
	 */
	protected TransactionalEditingDomain lookupTransactionalEditingDomain(IEvaluationContext context) throws ServiceException {

		// Get page from the event !
		// IWorkbenchPage page =
		// HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();

		return ServiceUtilsForIEvaluationContext.getInstance().getTransactionalEditingDomain(context);
	}

	/**
	 * Called by framework. Need to set the enabled flag.
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		if(!(evaluationContext instanceof IEvaluationContext)) {
			setBaseEnabled(false);
			return;
		}

		IEvaluationContext context = (IEvaluationContext)evaluationContext;

		try {
			// Try to get the Table
			setBaseEnabled(lookupTable(context) != null);
			return;
		} catch (ServiceException e) {
			// Can't find ServiceRegistry: disable
		}

		//In all other cases
		setBaseEnabled(false);
	}
}
