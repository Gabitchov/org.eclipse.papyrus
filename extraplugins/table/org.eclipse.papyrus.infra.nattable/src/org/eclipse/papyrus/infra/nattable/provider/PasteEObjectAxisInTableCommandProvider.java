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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.PasteModeEnumeration;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;

/**
 * Paste command manager for the paste in the table
 * 
 * @author VL222926
 * 
 */

public class PasteEObjectAxisInTableCommandProvider {

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
		final String pasteJobName;
		if(pasteMode == PasteModeEnumeration.PASTE_EOBJECT_COLUMN) {
			pasteJobName = "Paste Columns";
		} else {
			pasteJobName = "Paste Rows";
		}
		Table table = tableManager.getTable();
		final TransactionalEditingDomain tableEditingDomain = TableEditingDomainUtils.getTableEditingDomain(table);
		final TransactionalEditingDomain contextEditingDomain = TableEditingDomainUtils.getTableContextEditingDomain(table);


		if(!useProgressMonitor) {
			final Command pasteCommand = getPasteFromFromStringCommand(contextEditingDomain, tableEditingDomain, new NullProgressMonitor());
			contextEditingDomain.getCommandStack().execute(pasteCommand);
		} else {
			//we create a job in order to don't freeze the UI
			final Job job = new Job(pasteJobName) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {

					final Command pasteCommand = getPasteFromFromStringCommand(contextEditingDomain, tableEditingDomain, monitor);
					if(pasteCommand == null) {
						return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "Command creation has been cancelled");
					}
					//we execute the paste command
					if(pasteCommand.canExecute()) {
						contextEditingDomain.getCommandStack().execute(pasteCommand);
						monitor.done();
						return Status.OK_STATUS;
					} else {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The Paste command can't be executed");
					}
				}
			};
			job.setUser(true);
			job.schedule();
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
	protected Command getPasteFromFromStringCommand(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor) {
		final Table table = this.tableManager.getTable();
		//		final CompositeCommand cmd = new CompositeCommand("Paste from String Command");
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

		//initialize the progress monitor
		final int nbActions = axisToPaste.length;
		progressMonitor.beginTask("Paste Action", nbActions);


		//2.2 create the creation request and find the command provider
		final Boolean initializeName = mustInitializeName();
		final CreateElementRequest createRequest = new CreateElementRequest(contextEditingDomain, table.getContext(), this.typeToCreate, (EReference)this.containmentFeature);
		final IElementEditService tableContextCommandProvider = ElementEditServiceUtils.getCommandProvider(tableContext);

		final ICommand pasteAllCommand = new AbstractTransactionalCommand(contextEditingDomain, "Paste Command", null) {


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
				for(int i = 0; i < axisToPaste.length; i++) {
					final String currentAxisAsString = axisToPaste[i];
					if(progressMonitor.isCanceled()) {
						progressMonitor.done();
						localDispose();
						return CommandResult.newCancelledCommandResult();
					}
					progressMonitor.subTask(NLS.bind("Creating {0} number {1}/{2}", new Object[]{ typeToCreate.getDisplayName(), i, axisToPaste.length }));
					final ICommand commandCreation = tableContextCommandProvider.getEditCommand(createRequest);
					if(commandCreation.canExecute()) {
						//1. we create the element
						commandCreation.execute(monitor, info);
						//we execute the creation command

						//2. we add it to the table
						final CommandResult res = commandCreation.getCommandResult();
						commandCreation.dispose();

						final Object createdElement = (EObject)res.getReturnValue();
						final Command addCommand;
						if(pasteMode == PasteModeEnumeration.PASTE_EOBJECT_COLUMN) {
							addCommand = tableManager.getAddColumnElementCommand(Collections.singleton(createdElement));
						} else {
							addCommand = tableManager.getAddRowElementCommand(Collections.singleton(createdElement));
						}
						if(addCommand != null) {//can be null
							addCommand.execute();
							addCommand.dispose();
						}

						//3. we set the values
						final String[] cells = TableClipboardUtils.getCells(currentAxisAsString);
						for(int j = 0; j < secondAxis.size(); j++) {
							final Object currentAxis = secondAxis.get(j);
							final String valueAsString = cells[j];
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
									setValueCommand.execute();
									setValueCommand.dispose();
								} else {
									//FIXME?
								}
							}
						}
						progressMonitor.worked(1);
					}


				}
				progressMonitor.done();
				localDispose();
				return CommandResult.newOKCommandResult();
			}
		};
		return new GMFtoEMFCommandWrapper(pasteAllCommand);
	}


	/**
	 * 
	 * @return
	 *         <code>true</code> if the name must be initialized
	 */
	//FIXME : not very nice must efficient
	private Boolean mustInitializeName() {
		final List<?> existingColumns;
		if(this.pasteMode == PasteModeEnumeration.PASTE_EOBJECT_COLUMN) {
			existingColumns = this.tableManager.getRowElementsList();
		} else {
			existingColumns = this.tableManager.getColumnElementsList();
		}
		for(Object object : existingColumns) {
			Object current = AxisUtils.getRepresentedElement(object);
			if(current instanceof EAttribute && ((EAttribute)current).getName().equals("name")) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
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

	private void localDispose() {
		this.tableManager = null;
		this.typeToCreate = null;
		this.containmentFeature = null;
		for(final AbstractStringValueConverter current : existingConverters.values()) {
			current.dispose();
		}
		this.existingConverters.clear();
	}

}
