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
package org.eclipse.papyrus.uml.table.efacet.common.handler;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.dialog.CommandCreationProgressMonitorDialog;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractTableEditor;
import org.eclipse.papyrus.infra.table.efacet.common.exceptions.ErrorInPastePreparationException;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.table.efacet.common.Activator;
import org.eclipse.papyrus.uml.table.efacet.common.messages.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.statushandlers.StatusManager;

public class PasteInTableHandler extends AbstractHandler {

	/**
	 * this field is used to determine if we want open a dialog to prevent the user that the command creation and the command execution can take a
	 * long time
	 */
	private boolean useProgressMonitorDialog = true;

	private final IPasteInTableCommandProvider provider = new PasteInPapyrusTableCommandProvider();


	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final PapyrusTable papyrusTable = getPapyrusTable();
		if(papyrusTable != null) {
			final String contents = getClipboardContents();
			if(this.useProgressMonitorDialog) {//we create the command using a progress monitor
				return executeWithProgressMonitorDialog(papyrusTable, contents);
			} else {
				return executeWithoutProgressMonitorDialog(papyrusTable, contents);
			}
		}
		return null;
	}

	protected Object executeWithProgressMonitorDialog(final PapyrusTable pTable, final String contents) {
		Command createdCommand;
		int returnCode = Window.OK;

		final CommandCreationProgressMonitorDialog commandCreationDialog = new CommandCreationProgressMonitorDialog(Display.getCurrent().getActiveShell());
		final ProgressMonitorDialog commandExecutionProgressMonitor = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		commandCreationDialog.getProgressMonitor().setTaskName(Messages.PasteInTableHandler_PasteCreation);
		try {
			commandCreationDialog.run(true, true, new IRunnableWithProgress() {

				public void run(final IProgressMonitor cancelProvider) throws InvocationTargetException, InterruptedException {
					Command cmd;
					try {
						cmd = PasteInTableHandler.this.provider.getPasteFromFromStringCommand(pTable, cancelProvider, commandExecutionProgressMonitor, contents, getITableWidget());
					} catch (ErrorInPastePreparationException e) {
						NotificationBuilder.createErrorPopup(e.getMessage());
						commandCreationDialog.setCreatedCommand(null);
						return;
					}
					commandCreationDialog.setCreatedCommand(cmd);
				}
			});
		} catch (final InvocationTargetException e) {
			Activator.log.error(e);
		} catch (final InterruptedException e) {
			Activator.log.error(e);

		}
		returnCode = commandCreationDialog.getReturnCode();
		createdCommand = commandCreationDialog.getCreatedCommand();


		if(returnCode == Window.OK) {
			if(createdCommand != null) {
				if(createdCommand.canExecute()) {
					getEditingDomain().getCommandStack().execute(createdCommand);
					manageCommandResult(createdCommand.getResult());
				} else {
					NotificationBuilder.createErrorPopup(Messages.PasteInTableHandler_ThePasteCommandCantBeExecuted);
				}
			} else {
				//an error occured during the command creation, nothing to do
			}
			//we don't use dialogs to do the paste
		} else if(returnCode == Window.CANCEL) {
			NotificationBuilder.createInfoPopup(Messages.PasteInTableHandler_PasteCancelled).run();
		}
		return null;
	}

	protected Object executeWithoutProgressMonitorDialog(final PapyrusTable pTable, final String clipboardContents) {
		Command createdCommand;
		try {
			createdCommand = this.provider.getPasteFromFromStringCommand(pTable, null, null, clipboardContents, getITableWidget());
		} catch (ErrorInPastePreparationException e) {
			System.out.println(e.getMessage());
			return null;
		}

		getEditingDomain().getCommandStack().execute(createdCommand);
		manageCommandResult(createdCommand.getResult());
		return null;
	}

	/**
	 * 
	 * @return
	 *         the PapyrusTable for the current nested active editor or <code>null</code> if not found
	 */
	private PapyrusTable getPapyrusTable() {
		ISashWindowsContainer container = null;
		try {
			container = ServiceUtilsForActionHandlers.getInstance().getISashWindowsContainer();
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		if(container != null) {
			final IEditorPart activeEditor = container.getActiveEditor();
			if(activeEditor instanceof AbstractTableEditor) {
				return (PapyrusTable)activeEditor.getAdapter(PapyrusTable.class);
			}
		}
		return null;
	}

	private ITableWidget getITableWidget() {
		ISashWindowsContainer container = null;
		try {
			container = ServiceUtilsForActionHandlers.getInstance().getISashWindowsContainer();
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		if(container != null) {
			final IEditorPart activeEditor = container.getActiveEditor();
			if(activeEditor instanceof AbstractTableEditor) {
				return ((ITableWidgetProvider)activeEditor.getAdapter(ITableWidgetProvider.class)).getTableWidget();
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the clipboard contents used to build the command
	 */
	private String getClipboardContents() {
		// examine system clipboard
		String bufferSystem = null;

		//using AWT
		final DataFlavor[] dataFlavors = Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		for(final DataFlavor dataFlavor : dataFlavors) {
			try {
				if(dataFlavor.isFlavorTextType() && dataFlavor.isMimeTypeEqual(DataFlavor.stringFlavor)) {
					bufferSystem = Toolkit.getDefaultToolkit().getSystemClipboard().getData(dataFlavor).toString();
				}
			} catch (final Exception e) {
				Activator.log.error(e);
			}
		}
		//using SWT
		//		final Display display = Display.getCurrent();
		//		final Clipboard cb = new Clipboard(display);
		//		//we use the text transfert
		//		final TextTransfer transfer = TextTransfer.getInstance();
		//
		//		final Clipboard cb = new Clipboard(clipboard);
		//		final String contents = (String)cb.getContents(transfer);


		return bufferSystem;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return this.provider.isPasteEnabled(getPapyrusTable(), getClipboardContents(), getITableWidget());
	}

	/**
	 * 
	 * @return
	 *         the editing domain to use to execute the command
	 */
	private TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain domain = null;
		ServicesRegistry serviceRegistry = null;
		try {
			serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
		} catch (final ServiceException e) {
			Activator.log.error("ServicesRegistry not found", e); //$NON-NLS-1$
		}
		try {
			domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);
		} catch (final ServiceException e) {
			Activator.log.error("Editing Domain not found", e); //$NON-NLS-1$
		}
		return domain;
	}

	/**
	 * allows to define if we want use dialog to prevent the user that the command creation and the command execution can take a long time
	 * 
	 */
	public void setWithProgressMonitorDialog(final boolean useProgressMonitorDialog) {
		this.useProgressMonitorDialog = useProgressMonitorDialog;
	}

	private Collection<IStatus> getInterestingIStatus(final Collection<?> result) {
		final Collection<IStatus> status = new ArrayList<IStatus>();
		for(final Object current : result) {
			if(current instanceof IStatus) {
				status.add((IStatus)current);
			}
		}
		return status;
	}

	/**
	 * 
	 * @param commandResult
	 *        the result of the executed command
	 */
	private void manageCommandResult(final Collection<?> commandResult) {
		final Collection<IStatus> status = getInterestingIStatus(commandResult);
		for(IStatus iStatus : status) {
			final int severity = iStatus.getSeverity();
			if(severity == IStatus.ERROR || severity == IStatus.WARNING) {
				Activator.getDefault().getLog().log(iStatus);
			}
		}
	}
}
