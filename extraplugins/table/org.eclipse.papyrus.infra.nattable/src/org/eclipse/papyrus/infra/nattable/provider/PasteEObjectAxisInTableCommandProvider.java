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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.paste.PastePostActionRegistry;
import org.eclipse.papyrus.infra.nattable.paste.ReferenceValueSetter;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
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
	 * if true, we are pasting in detached mode
	 */
	private boolean detachedMode;

	/**
	 * the list of the post actions do do
	 */
	private List<String> postActions;

	/**
	 * the copnverter map
	 */
	private Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters;

	private static final String PASTE_ACTION_TASK_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteAction;

	private static final String PASTE_ROWS_JOB_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteRows;

	private static final String PASTE_COLUMNS_JOB_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteColumns;

	private static final String PASTE_COMMAND_HAS_BEEN_CANCELLED = Messages.PasteEObjectAxisInTableCommandProvider_CommandCreationHasBeenCancelled;

	private static final String PASTE_COMMAND_CANT_BE_EXECUTED = "The Paste command can't be executed"; //$NON-NLS-1$

	private static final String PASTE_COMMAND_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteFromStringCommand;

	private static final String CREATING_ELEMENT_A_NUMBER_X_Y = Messages.PasteEObjectAxisInTableCommandProvider_CreatingAnumberXonY;

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
		Assert.isTrue(pasteMode != PasteModeEnumeration.CANT_PASTE, "The paste can't be done"); //$NON-NLS-1$
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
		this.postActions = configuration.getPostActions();
		this.detachedMode = configuration.isDetachedMode();
	}

	/**
	 * 
	 * @param useProgressMonitor
	 *        boolean indicating that we must do the paste with a progress monitor
	 *        FIXME : post actions are not yet supported in the in the detached mode
	 */
	public void executePasteFromStringCommand(final boolean useProgressMonitor) {
		final String pasteJobName;
		if(pasteMode == PasteModeEnumeration.PASTE_EOBJECT_COLUMN) {
			pasteJobName = PASTE_COLUMNS_JOB_NAME;
		} else {
			pasteJobName = PASTE_ROWS_JOB_NAME;
		}
		if(this.detachedMode) {
			executePasteFromStringCommandInDetachedMode(useProgressMonitor, pasteJobName);
		} else {
			executePasteFromStringCommandInAttachedMode(useProgressMonitor, pasteJobName);
		}
	}

	/**
	 * 
	 * @param useProgressMonitor
	 *        boolean indicating that we must do the paste with a progress monitor
	 */
	protected void executePasteFromStringCommandInDetachedMode(final boolean useProgressMonitor, final String pasteJobName) {
		Table table = tableManager.getTable();
		final TransactionalEditingDomain tableEditingDomain = TableEditingDomainUtils.getTableEditingDomain(table);
		final TransactionalEditingDomain contextEditingDomain = TableEditingDomainUtils.getTableContextEditingDomain(table);

		//the map used to share objects between the paste action and the cell value managers
		final Map<Object, Object> sharedMap = new HashMap<Object, Object>();
		if(!useProgressMonitor) {
			final ICommand pasteCommand = getPasteFromFromStringCommandInDetachedMode(contextEditingDomain, tableEditingDomain, new NullProgressMonitor(), sharedMap);
			try {
				CheckedOperationHistory.getInstance().execute(pasteCommand, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator.log.error(e);
			}
			sharedMap.clear();
		} else {
			//we create a job in order to don't freeze the UI
			final Job job = new Job(pasteJobName) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {

					final ICommand pasteCommand = getPasteFromFromStringCommandInDetachedMode(contextEditingDomain, tableEditingDomain, monitor, sharedMap);
					if(pasteCommand == null) {
						return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, PASTE_COMMAND_HAS_BEEN_CANCELLED);
					}
					//we execute the paste command
					if(pasteCommand.canExecute()) {
						try {
							CheckedOperationHistory.getInstance().execute(pasteCommand, monitor, null);
						} catch (ExecutionException e) {
							return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occured during the paste", e); //$NON-NLS-1$
						} finally {
							sharedMap.clear();
						}
						monitor.done();
						return Status.OK_STATUS;
					} else {
						sharedMap.clear();
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, PASTE_COMMAND_CANT_BE_EXECUTED);
					}
				}
			};
			job.setUser(true);
			job.schedule();
		}
	}

	/**
	 * 
	 * @param useProgressMonitor
	 *        boolean indicating that we must do the paste with a progress monitor
	 */
	protected void executePasteFromStringCommandInAttachedMode(final boolean useProgressMonitor, final String pasteJobName) {
		Table table = tableManager.getTable();
		final TransactionalEditingDomain tableEditingDomain = TableEditingDomainUtils.getTableEditingDomain(table);
		final TransactionalEditingDomain contextEditingDomain = TableEditingDomainUtils.getTableContextEditingDomain(table);


		if(!useProgressMonitor) {
			final ICommand pasteCommand = getPasteFromFromStringCommand(contextEditingDomain, tableEditingDomain, new NullProgressMonitor());
			try {
				CheckedOperationHistory.getInstance().execute(pasteCommand, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator.log.error(e);
			}
		} else {
			//we create a job in order to don't freeze the UI
			final Job job = new Job(pasteJobName) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {

					final ICommand pasteCommand = getPasteFromFromStringCommand(contextEditingDomain, tableEditingDomain, monitor);
					if(pasteCommand == null) {
						return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, PASTE_COMMAND_HAS_BEEN_CANCELLED);
					}
					//we execute the paste command
					if(pasteCommand.canExecute()) {
						try {
							CheckedOperationHistory.getInstance().execute(pasteCommand, monitor, null);
						} catch (ExecutionException e) {
							return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occured during the paste", e); //$NON-NLS-1$
						}
						monitor.done();
						return Status.OK_STATUS;
					} else {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, PASTE_COMMAND_CANT_BE_EXECUTED);
					}
				}
			};
			job.setUser(true);
			job.schedule();
		}
	}

	/**
	 * 
	 * 
	 * @param commandCreationCancelProvider
	 *        the creation command progress monitor
	 * @param commandExecutionProgressMonitor
	 *        the command execution progress monitor
	 * @param sharedMap
	 *        a map used to share objects and informations during the paste between this class and the cell value manager
	 * 
	 * @return
	 *         the command to use to finish the paste (the main part of the paste is directly done here)
	 */
	protected ICommand getPasteFromFromStringCommandInDetachedMode(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor, final Map<Object, Object> sharedMap) {
		final Table table = this.tableManager.getTable();
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
		progressMonitor.beginTask(PASTE_ACTION_TASK_NAME, nbActions + 1);//+1 to add the created elements to the table
		//the list of the created elements
		final List<Object> createdElements = new ArrayList<Object>();

		//2.2 create the creation request and find the command provider
		final EClass eClassToCreate = this.typeToCreate.getEClass();
		final EFactory eFactory = eClassToCreate.getEPackage().getEFactoryInstance();
		//the map used to store useful information for the paste
		sharedMap.put(Constants.PASTED_ELEMENT_CONTAINER_KEY, tableContext);
		sharedMap.put(Constants.REFERENCES_TO_SET_KEY, new ArrayList<ReferenceValueSetter>());
		sharedMap.put(Constants.CELLS_TO_ADD_KEY, new ArrayList<Cell>());
		//2.3 create the axis
		int index = 1;
		int moduloForRefresh = 1;
		if(axisToPaste.length > 1000) {
			moduloForRefresh = 100;
		} else if(axisToPaste.length > 100) {
			moduloForRefresh = 10;
		}


		for(final String currentAxisAsString : axisToPaste) {
			if((progressMonitor != null) && progressMonitor.isCanceled()) {
				//the user click on the cancel button
				return null;
			}
			if(progressMonitor != null && index % moduloForRefresh == 0) {
				progressMonitor.subTask(NLS.bind(CREATING_ELEMENT_A_NUMBER_X_Y, new Object[]{ typeToCreate.getEClass().getName(), index, axisToPaste.length + 1 }));
			}
			index++;
			//2.3.1 we get the string values of the cells
			final String[] cells = TableClipboardUtils.getCells(currentAxisAsString);

			//2.3.3 we create the element itself
			final EObject createdElement = eFactory.create(eClassToCreate);

			createdElements.add(createdElement);

			for(final String currentPostActions : this.postActions) {
				PastePostActionRegistry.INSTANCE.doPostAction(this.tableManager, currentPostActions, tableContext, createdElement, sharedMap, currentAxisAsString);
			}

			//2.3.4 we set these properties values
			for(int i = 0; i < secondAxis.size(); i++) {
				final Object currentAxis = secondAxis.get(i);
				final String valueAsString = cells[i];
				final Object columnObject;
				final Object rowObject;
				if(pasteMode == PasteModeEnumeration.PASTE_EOBJECT_COLUMN) {
					columnObject = createdElement;
					rowObject = currentAxis;
				} else {
					columnObject = currentAxis;
					rowObject = createdElement;
				}


				boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(columnObject, rowObject, sharedMap);
				if(isEditable) {
					final AbstractStringValueConverter converter = CellManagerFactory.INSTANCE.getOrCreateStringValueConverterClass(columnObject, rowObject, tableManager, existingConverters, TableClipboardUtils.MULTI_VALUE_SEPARATOR);
					CellManagerFactory.INSTANCE.setStringValue(columnObject, rowObject, valueAsString, converter, tableManager, sharedMap);
				}
			}

			//we update the progress monitor
			if(progressMonitor != null && index % moduloForRefresh == 0) {
				progressMonitor.worked(moduloForRefresh);
			}
		}




		//2.4 we add the created elements to the table
		final AbstractTransactionalCommand pasteCommand = new AbstractTransactionalCommand(tableEditingDomain, PASTE_COMMAND_NAME, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				//initialize lists
				final Collection<String> postActions = getPostActions();
				final List<Cell> cells = (List<Cell>)sharedMap.get(Constants.CELLS_TO_ADD_KEY);
				final List<ReferenceValueSetter> referencesToSet = (List<ReferenceValueSetter>)sharedMap.get(Constants.REFERENCES_TO_SET_KEY);

				int nbTasks = 1; //to add created elements to the model
				nbTasks = nbTasks + 1; //to add createds elements to the table
				nbTasks = nbTasks + postActions.size();//to do post actions after the attachment to the model
				nbTasks = nbTasks + 1; //to attach the cells to the model
				nbTasks = nbTasks + referencesToSet.size(); //to set the references values

				if(progressMonitor != null) {
					if(progressMonitor.isCanceled()) {
						return CommandResult.newCancelledCommandResult();
					}
					progressMonitor.beginTask(Messages.PasteEObjectAxisInTableCommandProvider_FinishingThePaste, nbTasks);
				}

				//1. Add the elements to the context
				AddCommand.create(contextEditingDomain, tableContext, containmentFeature, createdElements).execute();

				if(progressMonitor != null) {
					if(progressMonitor.isCanceled()) {
						return CommandResult.newCancelledCommandResult();
					}
					progressMonitor.worked(1);
					progressMonitor.subTask(Messages.PasteEObjectAxisInTableCommandProvider_AddingElementToTheTable);
				}

				Command cmd = null;
				if(pasteMode == PasteModeEnumeration.PASTE_EOBJECT_COLUMN) {
					cmd = tableManager.getAddColumnElementCommand(createdElements);
				} else {
					cmd = tableManager.getAddRowElementCommand(createdElements);
				}
				if(cmd != null) {//could be null
					cmd.execute();
				}

				if(progressMonitor != null) {
					if(progressMonitor.isCanceled()) {
						return CommandResult.newCancelledCommandResult();
					}
					progressMonitor.worked(1);
					progressMonitor.subTask(Messages.PasteEObjectAxisInTableCommandProvider_DoingAdditionalActions);
				}


				for(final String currentPostActions : postActions) {
					PastePostActionRegistry.INSTANCE.doAfterAddPastedElementCommand(tableManager, currentPostActions, sharedMap);
					progressMonitor.worked(1);
				}

				if(progressMonitor != null) {
					if(progressMonitor.isCanceled()) {
						return CommandResult.newCancelledCommandResult();
					}
					progressMonitor.worked(1);
				}

				//add the created cells to the table
				AddCommand.create(tableEditingDomain, table, NattablePackage.eINSTANCE.getTable_Cells(), cells).execute();

				if(progressMonitor != null) {
					if(progressMonitor.isCanceled()) {
						return CommandResult.newCancelledCommandResult();
					}
					progressMonitor.worked(1);
					progressMonitor.subTask(Messages.PasteEObjectAxisInTableCommandProvider_LinkingReferencesToTheModel);
				}

				//we set the references

				if(referencesToSet.size() > 0) {
					for(final ReferenceValueSetter current : referencesToSet) {
						current.setReferenceValue(contextEditingDomain);
						if(progressMonitor != null) {
							if(progressMonitor.isCanceled()) {
								return CommandResult.newCancelledCommandResult();
							}
							progressMonitor.worked(1);
						}
					}
				}
				progressMonitor.done();
				localDispose();
				return CommandResult.newOKCommandResult();
			}
		};

		return pasteCommand;
	}

	/**
	 * 
	 * @param commandCreationCancelProvider
	 *        the creation command progress monitor
	 * @param commandExecutionProgressMonitor
	 *        the command execution progress monitor
	 * @return
	 */
	protected ICommand getPasteFromFromStringCommand(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor) {
		final Table table = this.tableManager.getTable();
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
		if(progressMonitor != null) {
			progressMonitor.beginTask(PASTE_ACTION_TASK_NAME, nbActions);
		}

		//2.2 create the creation request and find the command provider
		final CreateElementRequest createRequest = new CreateElementRequest(contextEditingDomain, table.getContext(), this.typeToCreate, (EReference)this.containmentFeature);
		final IElementEditService tableContextCommandProvider = ElementEditServiceUtils.getCommandProvider(tableContext);

		final ICommand pasteAllCommand = new AbstractTransactionalCommand(contextEditingDomain, PASTE_COMMAND_NAME, null) {


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
				int moduloForRefresh = 1;
				if(axisToPaste.length > 1000) {
					moduloForRefresh = 100;
				} else if(axisToPaste.length > 100) {
					moduloForRefresh = 10;
				}
				for(int i = 0; i < axisToPaste.length; i++) {
					final String currentAxisAsString = axisToPaste[i];
					if(progressMonitor != null && progressMonitor.isCanceled()) {
						progressMonitor.done();
						localDispose();
						return CommandResult.newCancelledCommandResult();
					}
					if(progressMonitor != null && i % moduloForRefresh == 0) {
						progressMonitor.subTask(NLS.bind(CREATING_ELEMENT_A_NUMBER_X_Y, new Object[]{ typeToCreate.getDisplayName(), i, axisToPaste.length }));
					}
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
								}
							}
						}
						//we update the progress monitor
						if(progressMonitor != null && i % moduloForRefresh == 0) {
							progressMonitor.worked(moduloForRefresh);
						}
					}

				}
				progressMonitor.done();
				localDispose();
				return CommandResult.newOKCommandResult();
			}
		};
		return pasteAllCommand;
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
			if(current instanceof EAttribute && ((EAttribute)current).getName().equals("name")) { //$NON-NLS-1$
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

	/**
	 * 
	 * @return
	 *         the list of the post actions to do
	 */
	private Collection<String> getPostActions() {
		return this.postActions;
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
