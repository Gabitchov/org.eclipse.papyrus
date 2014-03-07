/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.nattable.provider;

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
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.Command;
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
import org.eclipse.papyrus.infra.nattable.parsers.CSVParser;
import org.eclipse.papyrus.infra.nattable.parsers.CellIterator;
import org.eclipse.papyrus.infra.nattable.parsers.RowIterator;
import org.eclipse.papyrus.infra.nattable.paste.IValueSetter;
import org.eclipse.papyrus.infra.nattable.paste.PastePostActionRegistry;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.CSVPasteHelper;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
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

public class PasteEObjectAxisInNattableCommandProvider {

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
	//	private PasteEnablementStatus pasteMode;

	/**
	 * if true, we are pasting in detached mode
	 */
	private boolean detachedMode;

	/**
	 * the list of the post actions do do
	 */
	private List<String> postActions;

	/**
	 * the list of the axis to paste
	 */
	//	private final String[] axisToPaste;

	/**
	 * the paste helper
	 */
	private final CSVPasteHelper pasteHelper;

	/**
	 * the converter map
	 */
	private Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters;

	private static final String PASTE_ACTION_TASK_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteAction;

	private static final String PASTE_ROWS_JOB_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteRows;

	private static final String PASTE_COLUMNS_JOB_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteColumns;

	private static final String PASTE_COMMAND_HAS_BEEN_CANCELLED = Messages.PasteEObjectAxisInTableCommandProvider_CommandCreationHasBeenCancelled;

	private static final String PASTE_COMMAND_CANT_BE_EXECUTED = "The Paste command can't be executed"; //$NON-NLS-1$

	private static final String PASTE_COMMAND_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteFromStringCommand;

	private static final String CREATING_ELEMENT_A_NUMBER_X_Y = Messages.PasteEObjectAxisInTableCommandProvider_CreatingAnumberXonY;

	protected final boolean pasteColumn;

	private final int nbOperationsToDo;


	//we refresh the dialog each X read char 
	private int refreshEachReadChar = 1000;

	/**
	 * if <code>true</code> the command can't be created and executed
	 */
	private boolean isDisposed = false;

	/**
	 * the reader to parse
	 */
	private final Reader reader;

	/**
	 * the parser to use
	 */
	private CSVParser parser;

	int factor;

	private Table table;

	final TransactionalEditingDomain tableEditingDomain;

	final TransactionalEditingDomain contextEditingDomain;

	final EObject tableContext;

	List<Object> secondAxis;

	public PasteEObjectAxisInNattableCommandProvider(INattableModelManager tableManager, boolean pasteColumn, Reader reader, CSVPasteHelper pasteHelper2, long totalSize) {
		this.tableManager = tableManager;
		//		this.pasteMode = status;
		this.existingConverters = new HashMap<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter>();
		this.pasteHelper = pasteHelper2;
		this.reader = reader;
		this.pasteColumn = pasteColumn;
		this.table = tableManager.getTable();
		this.tableContext = table.getContext();
		tableEditingDomain = TableEditingDomainUtils.getTableEditingDomain(table);
		contextEditingDomain = TableEditingDomainUtils.getTableContextEditingDomain(table);
		//TODO improve refresh and progress monitor...
		long div = -1;
		if(totalSize > Integer.MAX_VALUE) {
			div = totalSize / Integer.MAX_VALUE;
			if(div > Integer.MAX_VALUE) {
				div = 2 * div;
			}
			this.factor = (int)div;
			this.nbOperationsToDo = (int)(totalSize / div);
		} else {
			this.factor = 1;
			this.nbOperationsToDo = (int)totalSize;
		}
		parser = this.pasteHelper.createParser(reader);
		init();
	}

	/**
	 * inits the field of this class
	 */
	private void init() {
		PasteEObjectConfiguration configuration = null;
		if(this.pasteColumn) {
			configuration = (PasteEObjectConfiguration)AxisConfigurationUtils.getIAxisConfigurationUsedInTable(this.table, NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), true);
			this.secondAxis = tableManager.getRowElementsList();
		} else {

			configuration = (PasteEObjectConfiguration)AxisConfigurationUtils.getIAxisConfigurationUsedInTable(this.table, NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), false);
			this.secondAxis = tableManager.getColumnElementsList();
		}
		if(configuration != null) {
			this.containmentFeature = configuration.getPasteElementContainementFeature();
			this.typeToCreate = ElementTypeRegistry.getInstance().getType(configuration.getPastedElementId());
			this.postActions = configuration.getPostActions();
			this.detachedMode = configuration.isDetachedMode();
		}
	}

	/**
	 * 
	 * @param useProgressMonitor
	 *        boolean indicating that we must do the paste with a progress monitor
	 *        TODO : post actions are not yet supported in the in the detached mode
	 */
	public void executePasteFromStringCommand(final boolean useProgressMonitor) {
		if(this.pasteColumn) {//not yet supported
			return;
		}
		if(this.isDisposed) {
			throw new RuntimeException("The command provider is disposed");
		}
		final String pasteJobName;
		if(this.pasteColumn) {
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
	private void executePasteFromStringCommandInDetachedMode(final boolean useProgressMonitor, final String pasteJobName) {
		//the map used to share objects between the paste action and the cell value managers
		final Map<Object, Object> sharedMap = new HashMap<Object, Object>();
		//the map used to store useful information for the paste
		sharedMap.put(Constants.PASTED_ELEMENT_CONTAINER_KEY, tableContext);
		sharedMap.put(Constants.REFERENCES_TO_SET_KEY, new ArrayList<IValueSetter>());
		sharedMap.put(Constants.CELLS_TO_ADD_KEY, new ArrayList<Cell>());

		if(!useProgressMonitor) {
			final ICommand pasteCommand = getPasteFromStringCommandInDetachedMode(contextEditingDomain, tableEditingDomain, new NullProgressMonitor(), sharedMap);
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

					final ICommand pasteCommand = getPasteFromStringCommandInDetachedMode(contextEditingDomain, tableEditingDomain, monitor, sharedMap);
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
	private void executePasteFromStringCommandInAttachedMode(final boolean useProgressMonitor, final String pasteJobName) {
		if(!useProgressMonitor) {
			final ICommand pasteCommand = getPasteFromStringCommandInAttachedMode(contextEditingDomain, tableEditingDomain, new NullProgressMonitor());
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

					final ICommand pasteCommand = getPasteFromStringCommandInAttachedMode(contextEditingDomain, tableEditingDomain, monitor);
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

	private ICommand getPasteRowFromStringCommandInDetachedMode(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor, final Map<Object, Object> sharedMap) {
		if(progressMonitor != null) {
			progressMonitor.beginTask(PASTE_ACTION_TASK_NAME, this.nbOperationsToDo);//+1 to add the created elements to the table
		}
		//the list of the created elements
		final List<Object> createdElements = new ArrayList<Object>();

		//2.2 create the creation request and find the command provider
		final EClass eClassToCreate = this.typeToCreate.getEClass();
		final EFactory eFactory = eClassToCreate.getEPackage().getEFactoryInstance();

		//2.3 create the axis
		int nbCreatedElements = 0;

		//we refresh the dialog each X read char 
		long readChar = 0;
		long previousreadChar = 0;
		final RowIterator rowIter = this.parser.parse();
		while(rowIter.hasNext()) {
			final CellIterator cellIter = rowIter.next();
			if(!cellIter.hasNext()) {
				continue;//to avoid blank line
			}
			if((progressMonitor != null) && progressMonitor.isCanceled()) {
				//the user click on the cancel button
				return null;
			}

			readChar = readChar + (parser.getReadCharacters() - previousreadChar);
			previousreadChar = parser.getReadCharacters();


			if(progressMonitor != null && readChar > refreshEachReadChar) {
				readChar = 0;
				progressMonitor.subTask(NLS.bind("{0} {1} have been created.", new Object[]{ nbCreatedElements, typeToCreate.getEClass().getName() }));
				progressMonitor.worked(refreshEachReadChar);
			}
			nbCreatedElements++;

			//2.3.3 we create the element itself
			final EObject createdElement = eFactory.create(eClassToCreate);

			createdElements.add(createdElement);
			nbCreatedElements++;
			for(final String currentPostActions : this.postActions) {
				PastePostActionRegistry.INSTANCE.doPostAction(this.tableManager, currentPostActions, tableContext, createdElement, sharedMap, null);//TODO : remove this parameter
			}

			//2.3.4 we set these properties values
			final Iterator<Object> secondAxisIterator = secondAxis.iterator();
			while(secondAxisIterator.hasNext() && cellIter.hasNext()) {
				final Object currentAxis = secondAxisIterator.next();
				final String valueAsString = cellIter.next();
				final Object columnObject;
				final Object rowObject;
				if(this.pasteColumn) {
					columnObject = createdElement;
					rowObject = currentAxis;
				} else {
					columnObject = currentAxis;
					rowObject = createdElement;
				}


				boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(columnObject, rowObject, sharedMap);
				if(isEditable) {
					final AbstractStringValueConverter converter = CellManagerFactory.INSTANCE.getOrCreateStringValueConverterClass(columnObject, rowObject, tableManager, existingConverters, this.pasteHelper.getMultiValueSeparator());
					CellManagerFactory.INSTANCE.setStringValue(columnObject, rowObject, valueAsString, converter, tableManager, sharedMap);
				}
			}

			//TODO : do something to say that the number of cell is not correct!
			while(cellIter.hasNext()) {
				cellIter.next();//required!
			}
		}

		//2.4 we add the created elements to the table
		final AbstractTransactionalCommand pasteCommand = new AbstractTransactionalCommand(tableEditingDomain, PASTE_COMMAND_NAME, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				//initialize lists
				final Collection<String> postActions = getPostActions();
				@SuppressWarnings("unchecked")
				final List<Cell> cells = (List<Cell>)sharedMap.get(Constants.CELLS_TO_ADD_KEY);
				@SuppressWarnings("unchecked")
				final List<IValueSetter> valueToSet = (List<IValueSetter>)sharedMap.get(Constants.REFERENCES_TO_SET_KEY);

				int nbTasks = 1; //to add created elements to the model
				nbTasks = nbTasks + 1; //to add createds elements to the table
				nbTasks = nbTasks + postActions.size();//to do post actions after the attachment to the model
				nbTasks = nbTasks + 1; //to attach the cells to the model
				nbTasks = nbTasks + valueToSet.size(); //to set the references values

				if(progressMonitor != null) {
					if(progressMonitor.isCanceled()) {
						localDispose();
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
				if(pasteColumn) {
					cmd = tableManager.getAddColumnElementCommand(createdElements); //TODO remove one of these 2 lines
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
					PastePostActionRegistry.INSTANCE.concludePostAction(tableManager, currentPostActions, sharedMap);
					progressMonitor.worked(1);
				}


				if(progressMonitor != null) {
					if(progressMonitor.isCanceled()) {
						return CommandResult.newCancelledCommandResult();
					}
					progressMonitor.worked(1);
					progressMonitor.subTask(Messages.PasteEObjectAxisInTableCommandProvider_LinkingReferencesToTheModel);
				}

				//we set the references

				if(valueToSet.size() > 0) {
					for(final IValueSetter current : valueToSet) {
						current.doSetValue(contextEditingDomain);
						if(progressMonitor != null) {
							if(progressMonitor.isCanceled()) {
								return CommandResult.newCancelledCommandResult();
							}
							progressMonitor.worked(1);
						}
					}
				}

				//the cells must be attached at the end (in order to update properly the cell map in the table manager
				if(progressMonitor != null) {
					if(progressMonitor.isCanceled()) {
						return CommandResult.newCancelledCommandResult();
					}
					progressMonitor.worked(1);
				}

				//add the created cells to the table
				AddCommand.create(tableEditingDomain, table, NattablePackage.eINSTANCE.getTable_Cells(), cells).execute();

				if(progressMonitor != null) {
					progressMonitor.done();
				}
				localDispose();
				return CommandResult.newOKCommandResult();
			}
		};

		return pasteCommand;
	}


	/**
	 * 
	 * 
	 * @param sharedMap
	 *        a map used to share objects and informations during the paste between this class and the cell value manager
	 * @param commandCreationCancelProvider
	 *        the creation command progress monitor
	 * @param commandExecutionProgressMonitor
	 *        the command execution progress monitor
	 * @return
	 *         the command to use to finish the paste (the main part of the paste is directly done here)
	 */
	private ICommand getPasteFromStringCommandInDetachedMode(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor, final Map<Object, Object> sharedMap) {
		if(!this.pasteColumn) {
			return getPasteRowFromStringCommandInDetachedMode(contextEditingDomain, tableEditingDomain, progressMonitor, sharedMap);
		} else {
			//			return getPasteColumnFromStringCommandInDetachedMode(contextEditingDomain, tableEditingDomain, progressMonitor, sharedMap);
		}
		return null;
	}



	/**
	 * 
	 * @param commandCreationCancelProvider
	 *        the creation command progress monitor
	 * @param commandExecutionProgressMonitor
	 *        the command execution progress monitor
	 * @return
	 */
	private ICommand getPasteColumnFromStringInAttachedModeCommand(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor) {
		//initialize the progress monitor
		if(progressMonitor != null) {
			progressMonitor.beginTask(PASTE_ACTION_TASK_NAME, this.nbOperationsToDo);
		}

		//2.2 create the creation request and find the command provider
		final CreateElementRequest createRequest = new CreateElementRequest(contextEditingDomain, this.tableContext, this.typeToCreate, (EReference)this.containmentFeature);
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
				long readChar = 0;
				long previousreadChar = 0;

				final RowIterator rowIter = parser.parse();
				int nbCreatedElements = 0;
				while(rowIter.hasNext()) {
					final CellIterator cellIter = rowIter.next();
					if(!cellIter.hasNext()) {
						continue;//to avoid blank line
					}
					if(progressMonitor != null && progressMonitor.isCanceled()) {
						progressMonitor.done();
						localDispose();
						return CommandResult.newCancelledCommandResult();
					}
					readChar = readChar + (parser.getReadCharacters() - previousreadChar);
					previousreadChar = parser.getReadCharacters();
					if(progressMonitor != null && readChar > refreshEachReadChar) {
						readChar = 0;
						progressMonitor.subTask(NLS.bind("{0} {1} have been created.", new Object[]{ typeToCreate.getEClass().getName(), nbCreatedElements }));
						progressMonitor.worked(refreshEachReadChar);
					}
					nbCreatedElements++;
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
						if(pasteColumn) {
							addCommand = tableManager.getAddColumnElementCommand(Collections.singleton(createdElement));
						} else {
							addCommand = tableManager.getAddRowElementCommand(Collections.singleton(createdElement));
						}
						if(addCommand != null) {//can be null
							addCommand.execute();
							addCommand.dispose();
						}

						//3. we set the values
						final Iterator<?> secondAxisIterator = secondAxis.iterator();
						while(secondAxisIterator.hasNext() && cellIter.hasNext()) {
							final Object currentAxis = secondAxisIterator.next();
							final String valueAsString = cellIter.next();
							final Object columnObject;
							final Object rowObject;
							if(pasteColumn) {
								columnObject = createdElement;
								rowObject = currentAxis;
							} else {
								columnObject = currentAxis;
								rowObject = createdElement;
							}


							boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(columnObject, rowObject);

							if(isEditable) {
								final AbstractStringValueConverter converter = CellManagerFactory.INSTANCE.getOrCreateStringValueConverterClass(columnObject, rowObject, tableManager, existingConverters, pasteHelper.getMultiValueSeparator());
								final Command setValueCommand = CellManagerFactory.INSTANCE.getSetStringValueCommand(contextEditingDomain, columnObject, rowObject, valueAsString, converter, tableManager);
								if(setValueCommand != null && setValueCommand.canExecute()) {
									setValueCommand.execute();
									setValueCommand.dispose();
								}
							}
						}
						//TODO inform the user
						while(cellIter.hasNext()) {
							cellIter.next();//required
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
	 * @param commandCreationCancelProvider
	 *        the creation command progress monitor
	 * @param commandExecutionProgressMonitor
	 *        the command execution progress monitor
	 * @return
	 */
	private ICommand getPasteRowFromStringInAttachedModeCommand(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor) {
		//initialize the progress monitor
		if(progressMonitor != null) {
			progressMonitor.beginTask(PASTE_ACTION_TASK_NAME, this.nbOperationsToDo);
		}

		//2.2 create the creation request and find the command provider
		final CreateElementRequest createRequest = new CreateElementRequest(contextEditingDomain, this.tableContext, this.typeToCreate, (EReference)this.containmentFeature);
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
				long readChar = 0;
				long previousreadChar = 0;

				final RowIterator rowIter = parser.parse();
				int nbCreatedElements = 0;
				while(rowIter.hasNext()) {
					final CellIterator cellIter = rowIter.next();
					if(!cellIter.hasNext()) {
						continue;//to avoid blank line
					}
					if(progressMonitor != null && progressMonitor.isCanceled()) {
						progressMonitor.done();
						localDispose();
						return CommandResult.newCancelledCommandResult();
					}
					readChar = readChar + (parser.getReadCharacters() - previousreadChar);
					previousreadChar = parser.getReadCharacters();
					if(progressMonitor != null && readChar > refreshEachReadChar) {
						readChar = 0;
						progressMonitor.subTask(NLS.bind("{0} {1} have been created.", new Object[]{ typeToCreate.getEClass().getName(), nbCreatedElements }));
						progressMonitor.worked(refreshEachReadChar);
					}
					nbCreatedElements++;
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
						if(pasteColumn) {
							addCommand = tableManager.getAddColumnElementCommand(Collections.singleton(createdElement));
						} else {
							addCommand = tableManager.getAddRowElementCommand(Collections.singleton(createdElement));
						}
						if(addCommand != null) {//can be null
							addCommand.execute();
							addCommand.dispose();
						}

						//3. we set the values
						final Iterator<?> secondAxisIterator = secondAxis.iterator();
						while(secondAxisIterator.hasNext() && cellIter.hasNext()) {
							final Object currentAxis = secondAxisIterator.next();
							final String valueAsString = cellIter.next();
							final Object columnObject;
							final Object rowObject;
							if(pasteColumn) {
								columnObject = createdElement;
								rowObject = currentAxis;
							} else {
								columnObject = currentAxis;
								rowObject = createdElement;
							}


							boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(columnObject, rowObject);

							if(isEditable) {
								final AbstractStringValueConverter converter = CellManagerFactory.INSTANCE.getOrCreateStringValueConverterClass(columnObject, rowObject, tableManager, existingConverters, pasteHelper.getMultiValueSeparator());
								final Command setValueCommand = CellManagerFactory.INSTANCE.getSetStringValueCommand(contextEditingDomain, columnObject, rowObject, valueAsString, converter, tableManager);
								if(setValueCommand != null && setValueCommand.canExecute()) {
									setValueCommand.execute();
									setValueCommand.dispose();
								}
							}
						}
						//TODO inform the user
						while(cellIter.hasNext()) {
							cellIter.next();//required
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
	 * @param commandCreationCancelProvider
	 *        the creation command progress monitor
	 * @param commandExecutionProgressMonitor
	 *        the command execution progress monitor
	 * @return
	 */
	private ICommand getPasteFromStringCommandInAttachedMode(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor) {
		if(this.pasteColumn) {
			//			return getPasteCFromStringInAttachedModeCommand(contextEditingDomain, tableEditingDomain, progressMonitor);
		} else {
			return getPasteRowFromStringInAttachedModeCommand(contextEditingDomain, tableEditingDomain, progressMonitor);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the list of the post actions to do
	 */
	private Collection<String> getPostActions() {
		return this.postActions;
	}

	/**
	 * dispose fields of the class
	 */
	private void localDispose() {
		this.isDisposed = true;
		this.tableManager = null;
		this.typeToCreate = null;
		this.containmentFeature = null;
		for(final AbstractStringValueConverter current : existingConverters.values()) {
			current.dispose();
		}
		this.existingConverters.clear();
		try {
			this.reader.close();
		} catch (IOException e) {
			Activator.log.error(e);
		}
	}

}
