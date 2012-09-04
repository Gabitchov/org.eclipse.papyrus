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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.common.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.ui.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractSynchronizedTableEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

//import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;

/**
 * 
 * the abstract class for the move line handler
 * 
 */
public abstract class AbstractMoveRowHandler extends AbstractHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public final Object execute(final ExecutionEvent event) throws ExecutionException {
		final Command cmd = getMoveRowCommand();
		if(cmd != null && cmd.canExecute()) {
			//we save the current row selection
			final List<EObject> selectedRows = getSelectedRowEObject();
			getEditingDomain().getCommandStack().execute(cmd);

			//we set the old row selection
			final ITableWidget widget = getTableWidget();
			widget.selectRows(selectedRows, true);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return (getSelectedRowEObject().size() == 1) && getMoveRowCommand().canExecute();

	}

	/**
	 * 
	 * @return
	 *         a list of the selected rows
	 */
	protected List<EObject> getSelectedRowEObject() {
		final ITableWidget widget = getTableWidget();
		return widget.getSelectedRowEObjects();
	}

	/**
	 * 
	 * @return
	 *         the current table editor
	 */
	protected AbstractSynchronizedTableEditor getCurrentTableEditor() {
		final IWorkbenchPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if(page instanceof CoreMultiDiagramEditor) {
			final IEditorPart activeEditor = ((CoreMultiDiagramEditor)page).getActiveEditor();
			if(activeEditor instanceof AbstractSynchronizedTableEditor) {
				return (AbstractSynchronizedTableEditor)activeEditor;
			}
		}
		return null;
	}


	/**
	 * 
	 * @return
	 *         the current nattable widget
	 */
	protected ITableWidget getTableWidget() {
		final AbstractSynchronizedTableEditor editor = getCurrentTableEditor();
		if(editor != null) {
			final ITableWidgetProvider provider = (ITableWidgetProvider)editor.getAdapter(ITableWidgetProvider.class);
			if(provider != null) {
				final Object widget = provider.getTableWidget();
				if(widget instanceof ITableWidget) {
					return (ITableWidget)widget;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @return the editing domain to use for the command
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return (TransactionalEditingDomain)getCurrentTableEditor().getEditingDomain();
	}

	/**
	 * 
	 * @return
	 *         the current table
	 */
	protected Table getTable() {
		return (Table)getCurrentTableEditor().getAdapter(Table.class);
	}

	/**
	 * 
	 * @return
	 *         the command to move the lines
	 */
	protected abstract Command getMoveRowCommand();
}
