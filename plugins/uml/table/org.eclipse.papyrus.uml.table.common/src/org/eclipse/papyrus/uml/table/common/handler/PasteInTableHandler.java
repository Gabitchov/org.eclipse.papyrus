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
package org.eclipse.papyrus.uml.table.common.handler;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidget;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.dialog.CommandCreationProgressMonitorDialog;
import org.eclipse.papyrus.infra.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.infra.table.common.exceptions.ErrorInPastePreparationException;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.table.common.Activator;
import org.eclipse.papyrus.uml.table.common.messages.Messages;
import org.eclipse.papyrus.uml.table.common.provider.IPasteInTableCommandProvider;
import org.eclipse.papyrus.uml.table.common.provider.PasteInPapyrusTableCommandProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public class PasteInTableHandler extends AbstractHandler {

	/**
	 * this field is used to determine if we want open a dialog to prevent the user that the command creation and the command execution can take a
	 * long time
	 */
	private boolean useProgressMonitorDialog = true;

	private final IPasteInTableCommandProvider provider = new PasteInPapyrusTableCommandProvider();

	private NatTableWidget widget = null;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		widget = (NatTableWidget)getITableWidget();
		final PapyrusTableInstance papyrusTable = getPapyrusTable();
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

	protected Object executeWithProgressMonitorDialog(final PapyrusTableInstance pTable, final String contents) {
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
						cmd = PasteInTableHandler.this.provider.getPasteFromFromStringCommand(pTable, cancelProvider, commandExecutionProgressMonitor, contents, widget);
						commandCreationDialog.setCreatedCommand(cmd);
					} catch (ErrorInPastePreparationException e) {
						commandCreationDialog.setCaughtException(e);
						commandCreationDialog.setCreatedCommand(null);
					}
				}
			});
		} catch (final InvocationTargetException e) {
			Activator.log.error(e);
		} catch (final InterruptedException e) {
			Activator.log.error(e);
		}
		final Exception e = commandCreationDialog.getCaughtException();
		if(e != null) {
			if(e instanceof ErrorInPastePreparationException)
				NotificationBuilder.createErrorPopup(e.getMessage()).run();
			return null;
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

	protected Object executeWithoutProgressMonitorDialog(final PapyrusTableInstance pTable, final String clipboardContents) {
		Command createdCommand;
		try {
			createdCommand = this.provider.getPasteFromFromStringCommand(pTable, null, null, clipboardContents, this.widget);
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
	 *         the current table editor, or <code>null</code> if not found
	 */
	private AbstractNattableEditor getCurrentTableEditor() {
		/*
		final IStructuredSelection selection = (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		final Object current = selection.getFirstElement();
		if (current instanceof EObject) {

			IEditorPart part = null;
			try {
				part = ServiceUtilsForResource.getInstance().getNestedActiveIEditorPart(((EObject)current).eResource());
			} catch (final ServiceException e) {
				Activator.log.error(e);
			}
			if(part instanceof AbstractNattableEditor) {
				return (AbstractNattableEditor)part;
			}

		} else*/ {//there is not select when click on a gray part of the table
			IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
			if (part instanceof IMultiDiagramEditor) {
				part = ((IMultiDiagramEditor)part).getActiveEditor();
			}
			if (part instanceof AbstractNattableEditor) {
				return (AbstractNattableEditor)part;
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the papyrus table
	 */
	protected PapyrusTableInstance getPapyrusTable() {
		final IEditorPart part = getCurrentTableEditor();
		if(part != null) {
			return (PapyrusTableInstance)part.getAdapter(PapyrusTableInstance.class);
		}
		return null;
	}

	private INatTableWidget getITableWidget() {
		final IAdaptable editor = getCurrentTableEditor();
		if(editor != null) {
			final INatTableWidgetProvider provider = (INatTableWidgetProvider)editor.getAdapter(INatTableWidgetProvider.class);
			if(provider != null) {
				return provider.getNatTableWidget();
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
		/*
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
		*/
		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			try {
				bufferSystem = clipboard.getData(DataFlavor.stringFlavor).toString();
			} catch (UnsupportedFlavorException e) {
				Activator.log.error(e);
			} catch (IOException e) {
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
