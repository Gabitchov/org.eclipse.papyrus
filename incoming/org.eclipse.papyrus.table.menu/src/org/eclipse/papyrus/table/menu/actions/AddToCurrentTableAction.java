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
package org.eclipse.papyrus.table.menu.actions;


import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.nattable.api.INatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.api.INatTableWidgetProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.table.common.editor.AbstractNattableEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This action allows to add selected elements in the model explorer in the last opened table
 * 
 * 
 * @deprecated : the drop action should be provided by the model explorer
 */
@Deprecated
public class AddToCurrentTableAction {

	/**
	 * The selected elements
	 */
	private List<EObject> selectedElements;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedElements
	 *        the selected elements
	 */
	public AddToCurrentTableAction(List<EObject> selectedElements) {
		this.selectedElements = selectedElements;
	}

	/**
	 * 
	 * @return
	 *         the builded command
	 */
	protected Command getBuildedCommand() {
		return new ICommandProxy(new MyAddCommand(getEditingDomain()));
	}

	/**
	 * The command to add selected elements into the table
	 * 
	 * 
	 * 
	 */
	public class MyAddCommand extends AbstractTransactionalCommand {

		/**
		 * 
		 * Constructor.
		 * 
		 * @param domain
		 *        the domain for this command
		 */
		public MyAddCommand(TransactionalEditingDomain domain) {
			super(domain, "", null); //$NON-NLS-1$
		}

		/**
		 * 
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 * 
		 * @param monitor
		 * @param info
		 * @return
		 * @throws ExecutionException
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			//we add the rows to the widget, which owns the Table!
			AbstractNattableEditor editor = getCurrentTableEditor();
			INatTableWidgetProvider provider = (INatTableWidgetProvider)editor.getAdapter(INatTableWidgetProvider.class);
			if(provider != null) {
				INatTableWidget natTableWidget = provider.getNatTableWidget();

				natTableWidget.addRows(getSelection());
			}
			return CommandResult.newOKCommandResult();
		}

	}

	/**
	 * 
	 * @return
	 */
	public Command getCommand() {
		if(isEnabled()) {
			return getBuildedCommand();
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected boolean isEnabled() {
		if(getSelection().isEmpty() || getCurrentTableEditor() == null) {
			return false;
		}
		return true;
	}

	private List<EObject> getSelection() {
		//		for(EObject current : selectedElements) {
		//			AbstractNattableEditor editor = getCurrentTableEditor();
		//			NatTableWidget natTableWidget = editor.getNatTableWidget();
		//			//TODO : managed with the query!
		//			boolean accept = natTableWidget.acceptsElement(current);
		//			int dummy = 0;
		//			dummy++;
		//		}
		return this.selectedElements;
	}

	/**
	 * 
	 * @return
	 *         the current table editor
	 */
	protected AbstractNattableEditor getCurrentTableEditor() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage activePage = workbenchWindow.getActivePage();
			if(activePage != null) {
				IEditorPart activeEditor = activePage.getActiveEditor();
				ISashWindowsContainer container = (ISashWindowsContainer)activeEditor.getAdapter(ISashWindowsContainer.class);
				if(container != null) {
					IEditorPart currentEditor = container.getActiveEditor();
					if(currentEditor instanceof AbstractNattableEditor) {
						return (AbstractNattableEditor)currentEditor;
					}
				}
			}
		}


		return null;
	}

	/**
	 * 
	 * @return
	 */
	protected ISashWindowsContainer getISashWindowsContainer() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage activePage = workbenchWindow.getActivePage();
			if(activePage != null) {
				IEditorPart activeEditor = activePage.getActiveEditor();
				return (ISashWindowsContainer)activeEditor.getAdapter(ISashWindowsContainer.class);
			}
		}
		return null;
	}

	/**
	 * Retrieves the TransactionalEditingDomain
	 * 
	 * @return the editing domain (can be null)
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = null;
		editingDomain = (TransactionalEditingDomain)getCurrentTableEditor().getEditingDomain();
		return editingDomain;
	}
}
