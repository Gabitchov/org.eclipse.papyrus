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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.provider;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.dialog.CommandCreationProgressMonitorDialog;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.PasteModeEnumeration;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.services.IDisposable;

/**
 * Paste command manager for the paste in the table
 * 
 * @author VL222926
 * 
 */

public class PasteEObjectAxisInTableCommandProvider implements IDisposable {

	private static final int MIN_AXIS_FOR_PROGRESS_MONITOR = 5;

	/**
	 * the containment feature to use
	 */
	private EStructuralFeature containmentFeature;

	/**
	 * the type to create
	 */
	private IElementType typeToCreate;

	/**
	 * the table manager
	 */
	private INattableModelManager tableManager;

	/**
	 * the paste mode
	 */
	private PasteModeEnumeration pasteMode;

	/**
	 * the copnverter map
	 */
	private Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param typeToCreate
	 *        the type to create
	 * @param containmentFeature
	 *        the containment feature
	 * @param pasteMode
	 *        the paste mode
	 */
	public PasteEObjectAxisInTableCommandProvider(final INattableModelManager tableManager, final PasteModeEnumeration pasteMode) {
		this.tableManager = tableManager;
		this.pasteMode = pasteMode;
		this.existingConverters = new HashMap<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter>();
		init();
	}

	/**
	 * inits the field of this class
	 */
	private void init() {
		if(pasteMode == PasteModeEnumeration.PASTE_EOBJECT_ROW_OR_COLUMN) {
			pasteMode = askWhichPasteModeDo();
		}
		Assert.isTrue(pasteMode != PasteModeEnumeration.CANT_PASTE, "The paste can't be done");
		PasteEObjectConfiguration configuration = null;
		switch(pasteMode) {
		case PASTE_EOBJECT_COLUMN:
			configuration = (PasteEObjectConfiguration)AxisConfigurationUtils.getIAxisConfigurationUsedInTable(this.tableManager.getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), true);
			break;
		case PASTE_EOBJECT_ROW:
			configuration = (PasteEObjectConfiguration)AxisConfigurationUtils.getIAxisConfigurationUsedInTable(this.tableManager.getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), false);
			break;
		default:
			break;
		}
		this.containmentFeature = configuration.getPasteElementContainementFeature();
		this.typeToCreate = ElementTypeRegistry.getInstance().getType(configuration.getPastedElementId());
	}

	/**
	 * 
	 * @param useProgressMonitor
	 *        boolean indicating that we must do the paste with a progress monitor
	 */
	public void executePasteFromStringCommand(final boolean useProgressMonitor) {
		Table table = this.tableManager.getTable();
		final TransactionalEditingDomain tableEditingDomain = TableEditingDomainUtils.getTableEditingDomain(table);
		final TransactionalEditingDomain contextEditingDomain = TableEditingDomainUtils.getTableContextEditingDomain(table);
		Command pasteCommand = null;
		//without progress monitor
		if(!useProgressMonitor) {
			pasteCommand = getPasteFromFromStringCommand(contextEditingDomain, tableEditingDomain, null, null);
		} else {
			//with progress monitor
			Command createdCommand;
			int returnCode = Window.OK;

			final CommandCreationProgressMonitorDialog commandCreationDialog = new CommandCreationProgressMonitorDialog(Display.getCurrent().getActiveShell());
			final ProgressMonitorDialog commandExecutionProgressMonitor = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			commandCreationDialog.getProgressMonitor().setTaskName("Paste Creation");
			try {
				commandCreationDialog.run(true, true, new IRunnableWithProgress() {

					public void run(final IProgressMonitor cancelProvider) throws InvocationTargetException, InterruptedException {
						Command cmd;
						try {
							cmd = getPasteFromFromStringCommand(contextEditingDomain, tableEditingDomain, cancelProvider, commandExecutionProgressMonitor);
							commandCreationDialog.setCreatedCommand(cmd);
						} catch (final Exception e) {
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
				NotificationBuilder.createErrorPopup(e.getMessage()).run();
			}

			returnCode = commandCreationDialog.getReturnCode();
			createdCommand = commandCreationDialog.getCreatedCommand();


			if(returnCode == Window.OK) {
				pasteCommand = createdCommand;
				//we don't use dialogs to do the paste
			} else if(returnCode == Window.CANCEL) {
				NotificationBuilder.createInfoPopup("Paste has been cancelled").run();
				return;
			}
		}
		//we execute the paste command
		if(pasteCommand.canExecute()) {
			contextEditingDomain.getCommandStack().execute(pasteCommand);
		} else {
			NotificationBuilder.createErrorPopup("Paste command can't be executed");
		}

	}

	/**
	 * 
	 * @param commandCreationCancelProvider
	 *        the creation command progress monitor
	 * @param commandExecutionProgressMonitor
	 *        the command execution progress monitor
	 * @return
	 */
	protected Command getPasteFromFromStringCommand(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor commandCreationCancelProvider, final ProgressMonitorDialog commandExecutionProgressMonitor) {
		final Table table = this.tableManager.getTable();
		final CompositeCommand cmd = new CompositeCommand("Paste from String Command");
		final EObject tableContext = table.getContext();

		final String[] axisToPaste;
		final List<Object> secondAxis;
		switch(pasteMode) {
		case PASTE_EOBJECT_COLUMN:
			axisToPaste = TableClipboardUtils.getColumnsFromClipboard();
			secondAxis = tableManager.getRowElementsList();
			break;
		case PASTE_EOBJECT_ROW:
			axisToPaste = TableClipboardUtils.getRowsFromClipboard();
			secondAxis = tableManager.getColumnElementsList();
			break;
		default:
			throw new UnsupportedOperationException();
		}

		//the list of the command creation
		final List<ICommand> createCommands = new ArrayList<ICommand>();

		//1. we launch the dialog used for the command creation
		if(commandCreationCancelProvider != null) {
			commandCreationCancelProvider.beginTask("Initialize Paste Action", axisToPaste.length + 1);
		}

		//2. we build the command itself
		final boolean useDialog = (commandExecutionProgressMonitor != null) && (axisToPaste.length > MIN_AXIS_FOR_PROGRESS_MONITOR);

		//2.1 create the command to open the progress monitor dialog during the command execution
		if(useDialog) {
			final AbstractTransactionalCommand beginMonitor = new AbstractTransactionalCommand(tableEditingDomain, "Launch Progress Monitor Dialog", Collections.emptyList()) {

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					commandExecutionProgressMonitor.open();
					commandExecutionProgressMonitor.getProgressMonitor().setTaskName("Pasting In Table");
					commandExecutionProgressMonitor.getProgressMonitor().beginTask("Pasting In Table", axisToPaste.length);
					return CommandResult.newOKCommandResult();
				}
			};
			cmd.add(beginMonitor);
		}

		//2.2 create the creation request and find the command provider
		final CreateElementRequest createRequest = new CreateElementRequest(contextEditingDomain, table.getContext(), this.typeToCreate, (EReference)this.containmentFeature);
		final IElementEditService tableContextCommandProvider = ElementEditServiceUtils.getCommandProvider(tableContext);

		//2.3 create the axis
		for(final String currentAxisAsString : axisToPaste) {
			if(useDialog) {
				commandCreationCancelProvider.worked(1);
			}
			if((commandCreationCancelProvider != null) && commandCreationCancelProvider.isCanceled()) {
				//the user click on the cancel button
				return null;
			}

			//2.3.1 we get the string values of the cells
			final String[] cells = TableClipboardUtils.getCells(currentAxisAsString);

			//2.3.2 : update the paste execution dialog
			if(useDialog) {
				final ICommand dialogCommand = new AbstractTransactionalCommand(tableEditingDomain, null, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						commandExecutionProgressMonitor.getProgressMonitor().subTask("Pasting : " + currentAxisAsString);
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.add(dialogCommand);
			}

			//2.3.3 we create the element itself
			final ICommand commandCreation = tableContextCommandProvider.getEditCommand(createRequest);
			//we add the creation command to the list of the creation command to be able to add the result of these command to the table
			createCommands.add(commandCreation);
			cmd.add(commandCreation);

			//2.3.4 we set these properties values
			for(int i = 0; i < secondAxis.size(); i++) {
				final Object currentAxis = secondAxis.get(i);
				final String valueAsString = cells[i];

				final AbstractTransactionalCommand setValuesCommand = new AbstractTransactionalCommand(contextEditingDomain, "Set Value Command", null) {

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						final EObject createdElement = (EObject)commandCreation.getCommandResult().getReturnValue();
						final Object columnObject;
						final Object rowObject;
						if(pasteMode == PasteModeEnumeration.PASTE_EOBJECT_COLUMN) {
							columnObject = createdElement;
							rowObject = currentAxis;
						} else {
							columnObject = currentAxis;
							rowObject = createdElement;
						}


						boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(columnObject, rowObject);

						if(isEditable) {
							final AbstractStringValueConverter converter = CellManagerFactory.INSTANCE.getOrCreateStringValueConverterClass(columnObject, rowObject, tableManager, existingConverters, TableClipboardUtils.MULTI_VALUE_SEPARATOR);
							final Command setValueCommand = CellManagerFactory.INSTANCE.getSetStringValueCommand(contextEditingDomain, columnObject, rowObject, valueAsString, converter, tableManager);
							if(setValueCommand != null && setValueCommand.canExecute()) {

								try {
									setValueCommand.execute();
								} catch (Exception e) {
									Activator.log.error(e);
								}
							}
						}
						return null;
					}
				};

				cmd.add(setValuesCommand);
			}

			//2.3.5 update the command paste dialog
			if(useDialog) {
				final ICommand dialogCommand = new AbstractTransactionalCommand(tableEditingDomain, null, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						commandExecutionProgressMonitor.getProgressMonitor().worked(1);
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.add(dialogCommand);
			}
		}

		//2.4 we add the created elements to the table
		final AbstractTransactionalCommand addToTableCommand = new AbstractTransactionalCommand(tableEditingDomain, "Add To Table After Paste Command", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				final Collection<Object> objectsToAdd = new ArrayList<Object>();
				for(final ICommand current : createCommands) {
					objectsToAdd.add(current.getCommandResult().getReturnValue());
				}
				Command cmd = null;
				if(pasteMode == PasteModeEnumeration.PASTE_EOBJECT_COLUMN) {
					cmd = tableManager.getAddColumnElementCommand(objectsToAdd);
				} else {
					cmd = tableManager.getAddRowElementCommand(objectsToAdd);
				}
				if(cmd != null) {//can be null
					cmd.execute();
				}
				return null;
			}
		};
		cmd.add(addToTableCommand);

		//2.5 close the dialog used during the paste command execution
		if(useDialog) {
			final AbstractTransactionalCommand endMonitor = new AbstractTransactionalCommand(tableEditingDomain, "Close Progress Monitor Dialog", Collections.emptyList()) { //$NON-NLS-1$

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					commandExecutionProgressMonitor.getProgressMonitor().done();
					commandExecutionProgressMonitor.close();
					return CommandResult.newOKCommandResult();
				}
			};
			cmd.add(endMonitor);
		}

		//2.6 we return the command
		return new GMFtoEMFCommandWrapper(cmd);
	}


	/**
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		this.tableManager = null;
		this.typeToCreate = null;
		this.containmentFeature = null;
		for(final AbstractStringValueConverter current : existingConverters.values()) {
			current.dispose();
		}
		this.existingConverters.clear();
	}

	/**
	 * 
	 * @return
	 *         the paste mode selected by the user
	 */
	protected PasteModeEnumeration askWhichPasteModeDo() {
		//TODO develop a dialog for that
		throw new UnsupportedOperationException();
	}

}
