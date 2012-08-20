/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.common.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractTableEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

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

			final List<EObject> toSelect = new ArrayList<EObject>();

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
		final List<Row> rows = new ArrayList<Row>();
		final ITableWidget widget = getTableWidget();
		if(widget instanceof org.eclipse.emf.facet.widgets.table.ui.ITableWidget) {
			return ((org.eclipse.emf.facet.widgets.table.ui.ITableWidget)widget).getSelectedRowEObjects();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * 
	 * @return
	 *         the current table editor
	 */
	protected AbstractTableEditor getCurrentTableEditor() {
		final IWorkbenchPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if(page instanceof CoreMultiDiagramEditor) {
			final IEditorPart activeEditor = ((CoreMultiDiagramEditor)page).getActiveEditor();
			if(activeEditor instanceof AbstractTableEditor) {
				return (AbstractTableEditor)activeEditor;
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
		final AbstractTableEditor editor = getCurrentTableEditor();
		if(editor != null) {
			final ITableWidgetProvider provider = (ITableWidgetProvider)editor.getAdapter(ITableWidgetProvider.class);
			if(provider != null) {
				return provider.getTableWidget();
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
