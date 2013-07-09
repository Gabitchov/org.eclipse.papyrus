package org.eclipse.papyrus.uml.nattable.handler;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.dialog.CommandCreationProgressMonitorDialog;
import org.eclipse.papyrus.infra.nattable.exception.ErrorInPastePreparationException;
import org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.IPasteInTableCommandProvider;
import org.eclipse.papyrus.infra.nattable.utils.PasteConfigurationUtil;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;
import org.eclipse.papyrus.infra.tools.util.ClipboardUtils;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.nattable.Activator;
import org.eclipse.swt.widgets.Display;

//FIXME : improve the handler declaration in the plugin.xml + the command visibility in the plugin.xml
public class RowPasteHandler extends AbstractTableHandler {

	//FIXME : move them in an upper plugin? 
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
		INattableModelManager manager = getCurrentNattableModelManager();
		final Table papyrusTable = manager.getTable();
		if(papyrusTable != null) {
			final String contents = getClipboard();
			if(this.useProgressMonitorDialog) {//we create the command using a progress monitor
				return executeWithProgressMonitorDialog(manager, papyrusTable, contents);
			} else {
				return executeWithoutProgressMonitorDialog(manager, papyrusTable, contents);
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(final Object evaluationContext) {
		final Table table = getCurrentNattableModelManager().getTable();
		IPasteConfiguration configuration = PasteConfigurationUtil.getRowPasteConfigurationDefinedInTableConfiguration(table);
		boolean baseEnabled = false;
		if(configuration != null) {
			String contents = getClipboard();
			String[] rows = TableClipboardUtils.getRows(contents);
			if(rows.length > 0) {
				String[] cells = TableClipboardUtils.getCells(rows[0]);
				if(cells.length == getCurrentNattableModelManager().getColumnCount()) {
					baseEnabled = getRowAxisManager().canPaste(configuration);
				}
			}
		}
		setBaseEnabled(baseEnabled);
	}

	protected Object executeWithProgressMonitorDialog(final INattableModelManager tableManager, final Table pTable, final String contents) {
		Command createdCommand;
		int returnCode = Window.OK;
		final TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)getContextEditingDomain();
		final CommandCreationProgressMonitorDialog commandCreationDialog = new CommandCreationProgressMonitorDialog(Display.getCurrent().getActiveShell());
		final ProgressMonitorDialog commandExecutionProgressMonitor = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		commandCreationDialog.getProgressMonitor().setTaskName("Paste command creation");
		try {
			commandCreationDialog.run(true, true, new IRunnableWithProgress() {

				public void run(final IProgressMonitor cancelProvider) throws InvocationTargetException, InterruptedException {
					ICommand cmd;
					try {
						cmd = RowPasteHandler.this.provider.getPasteFromFromStringCommand(editingDomain, tableManager.getTable(), cancelProvider, commandExecutionProgressMonitor, contents, tableManager);
						commandCreationDialog.setCreatedCommand(new GMFtoEMFCommandWrapper(cmd));
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
					getContextEditingDomain().getCommandStack().execute(createdCommand);
					manageCommandResult(createdCommand.getResult());
				} else {
					NotificationBuilder.createErrorPopup("The paste command can't be executed");
				}
			} else {
				//an error occured during the command creation, nothing to do
			}
			//we don't use dialogs to do the paste
		} else if(returnCode == Window.CANCEL) {
			NotificationBuilder.createInfoPopup("Paste Cancelled").run();
		}
		return null;
	}

	protected Object executeWithoutProgressMonitorDialog(final INattableModelManager tableManager, final Table pTable, final String clipboardContents) {
		ICommand createdCommand;
		try {
			createdCommand = this.provider.getPasteFromFromStringCommand((TransactionalEditingDomain)getContextEditingDomain(), pTable, null, null, clipboardContents, tableManager);
		} catch (ErrorInPastePreparationException e) {
			System.out.println(e.getMessage());//FIXME?
			return null;
		}

		getContextEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(createdCommand));
		//		manageCommandResult(createdCommand.getCommandResult());
		return null;
	}


	/**
	 * allows to define if we want use dialog to prevent the user that the command creation and the command execution can take a long time
	 * 
	 */
	public void setWithProgressMonitorDialog(final boolean useProgressMonitorDialog) {
		this.useProgressMonitorDialog = useProgressMonitorDialog;
	}

	//FIXME
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
	//FIXME
	private void manageCommandResult(final Collection<?> commandResult) {
		final Collection<IStatus> status = getInterestingIStatus(commandResult);
		for(IStatus iStatus : status) {
			final int severity = iStatus.getSeverity();
			if(severity == IStatus.ERROR || severity == IStatus.WARNING) {
				Activator.getDefault().getLog().log(iStatus);
			}
		}
	}

	protected String getClipboard() {
		return ClipboardUtils.getClipboardContents();
	}

}
