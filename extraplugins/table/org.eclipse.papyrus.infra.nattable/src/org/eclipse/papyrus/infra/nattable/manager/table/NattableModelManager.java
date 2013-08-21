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
package org.eclipse.papyrus.infra.nattable.manager.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.State;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.command.CommandIds;
import org.eclipse.papyrus.infra.nattable.dialog.DisplayedAxisSelectorDialog;
import org.eclipse.papyrus.infra.nattable.manager.axis.AxisManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.axis.CompositeAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.axis.ICompositeAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.ISlaveAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.CellMapKey;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.nattable.utils.StringComparator;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.providers.FlattenableRestrictedFilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class NattableModelManager extends AbstractNattableWidgetManager implements INattableModelManager, IAdaptable {

	/**
	 * the column manager
	 */
	private ICompositeAxisManager columnManager;

	/**
	 * the line manager
	 */
	private ICompositeAxisManager rowManager;

	/**
	 * the model of the table on which we are working
	 */
	private List<Object> verticalElements;

	private List<Object> horizontalElements;

	private Adapter invertAxisListener;

	private AbstractAxisProvider rowProvider;

	private AbstractAxisProvider columnProvider;

	/**
	 * this listener listen the stack events and refresh nattable
	 */
	private CommandStackListener refreshListener;

	/**
	 * the focus listener
	 */
	private FocusListener focusListener;

	/**
	 * we need to keep it to be able to remove listener (required when we destroy the context of the table)
	 */
	private TransactionalEditingDomain contextEditingDomain;

	private Adapter changeAxisProvider;

	private AdapterImpl changeAxisProviderHistory;

	/**
	 * the listener on the table cells
	 */
	private Adapter tableCellsListener;

	private BiMap<CellMapKey, Cell> cellsMap;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param rawModel
	 * 
	 *        the model of the managed table
	 */
	public NattableModelManager(final Table rawModel) {
		super(rawModel);
		this.rowProvider = rawModel.getCurrentRowAxisProvider();
		this.columnProvider = rawModel.getCurrentColumnAxisProvider();
		this.verticalElements = Collections.synchronizedList(new ArrayList<Object>());
		this.horizontalElements = Collections.synchronizedList(new ArrayList<Object>());
		this.cellsMap = HashBiMap.create();

		this.invertAxisListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getEventType() == Notification.SET) {
					final Object oldValue = msg.getOldValue();
					final Object newValue = msg.getNewValue();
					if(oldValue != null && newValue != null) {
						if(msg.getFeature() == NattablePackage.eINSTANCE.getTable_InvertAxis()) {
							invertJavaObject();

						}
					}
				}
			}
		};

		rawModel.eAdapters().add(this.invertAxisListener);
		init();
		if(rawModel.isInvertAxis()) {
			invertJavaObject();
		}

		changeAxisProvider = new AdapterImpl() {

			public void notifyChanged(final Notification msg) {
				if(msg.getFeature() == NattablePackage.eINSTANCE.getTable_CurrentColumnAxisProvider() || msg.getFeature() == NattablePackage.eINSTANCE.getTable_CurrentRowAxisProvider()) {

					Display.getCurrent().asyncExec(new Runnable() {

						@Override
						public void run() {
							init();
							refreshNatTable();
						}
					});
				}
			}

		};

		changeAxisProviderHistory = new AdapterImpl() {

			public void notifyChanged(final Notification msg) {
				if(msg.getFeature() == NattablePackage.eINSTANCE.getTable_ColumnAxisProvidersHistory() || msg.getFeature() == NattablePackage.eINSTANCE.getTable_RowAxisProvidersHistory()) {

					Display.getCurrent().asyncExec(new Runnable() {

						@Override
						public void run() {
							init();
						}
					});
				}
			}

		};

		rawModel.eAdapters().add(changeAxisProvider);
		tableCellsListener = new AdapterImpl() {

			@Override
			public void notifyChanged(final Notification msg) {
				if(msg.getFeature() == NattablePackage.eINSTANCE.getTable_Cells()) {
					updateCellMap(msg);
				}
			}
		};
		rawModel.eAdapters().add(tableCellsListener);
	}


	@Override
	public NatTable createNattable(Composite parent, int style, IWorkbenchPartSite site) {
		updateCellMap(null);
		final NatTable nattable = super.createNattable(parent, style, site);
		this.refreshListener = new CommandStackListener() {

			/**
			 * 
			 * @see org.eclipse.emf.common.command.CommandStackListener#commandStackChanged(java.util.EventObject)
			 * 
			 * @param event
			 */
			public void commandStackChanged(EventObject event) {
				//we refresh the table after each command, only when it is visible
				//its allows to refresh the text and the appearance of the table
				//this refresh doesn't manage the add/remove axis
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						if(nattable != null && !nattable.isDisposed() && nattable.isVisible()) {
							nattable.refresh();
						}
					}
				});

			}
		};

		getContextEditingDomain().getCommandStack().addCommandStackListener(this.refreshListener);

		this.focusListener = new FocusListener() {

			public void focusLost(FocusEvent e) {
				//nothing to do
			}

			public void focusGained(FocusEvent e) {
				updateToggleActionState();
			}
		};
		nattable.addFocusListener(this.focusListener);
		updateToggleActionState();//required, because the focus listener is not notified just after the creation of the widget
		return nattable;
	}

	/**
	 * this command update the status of the toggle actions
	 */
	protected void updateToggleActionState() {
		final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		if(commandService != null) {

			final AbstractHeaderAxisConfiguration columnAxisConfiguration = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisUsedInTable(getTable());
			final AbstractHeaderAxisConfiguration rowAxisConfiguration = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisUsedInTable(getTable());
			//update the header configuration
			org.eclipse.core.commands.Command command = commandService.getCommand(CommandIds.COMMAND_COLUMN_DISPLAY_INDEX_ID);
			updateToggleCommandState(command, columnAxisConfiguration.isDisplayIndex());

			command = commandService.getCommand(CommandIds.COMMAND_COLUMN_DISPLAY_LABEL_ID);
			updateToggleCommandState(command, columnAxisConfiguration.isDisplayLabel());

			command = commandService.getCommand(CommandIds.COMMAND_COLUMN_DISPLAY_INDEX_STYLE_ID);
			updateRadioCommandState(command, columnAxisConfiguration.getIndexStyle().getLiteral());

			command = commandService.getCommand(CommandIds.COMMAND_ROW_DISPLAY_INDEX_ID);
			updateToggleCommandState(command, rowAxisConfiguration.isDisplayIndex());

			command = commandService.getCommand(CommandIds.COMMAND_ROW_DISPLAY_LABEL_ID);
			updateToggleCommandState(command, rowAxisConfiguration.isDisplayLabel());

			command = commandService.getCommand(CommandIds.COMMAND_ROW_DISPLAY_INDEX_STYLE_ID);
			updateRadioCommandState(command, rowAxisConfiguration.getIndexStyle().getLiteral());


			//update the label header configuration
			final List<ILabelProviderConfiguration> columnLabelConfigurations = columnAxisConfiguration.getOwnedLabelConfigurations();
			final List<ILabelProviderConfiguration> rowLabelConfigurations = rowAxisConfiguration.getOwnedLabelConfigurations();
			for(final ILabelProviderConfiguration current : columnLabelConfigurations) {
				if(current instanceof ObjectLabelProviderConfiguration) {
					final ObjectLabelProviderConfiguration labelConfig = (ObjectLabelProviderConfiguration)current;
					command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_DISPLAY_ICON);
					updateToggleCommandState(command, labelConfig.isDisplayIcon());

					command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_DISPLAY_LABEL);
					updateToggleCommandState(command, labelConfig.isDisplayLabel());

					if(labelConfig instanceof FeatureLabelProviderConfiguration) {
						final FeatureLabelProviderConfiguration labelFeatureConf = (FeatureLabelProviderConfiguration)labelConfig;
						command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_IS_DERIVED);
						updateToggleCommandState(command, labelFeatureConf.isDisplayIsDerived());

						command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_MULTIPLICITY);
						updateToggleCommandState(command, labelFeatureConf.isDisplayMultiplicity());

						command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_TYPE);
						updateToggleCommandState(command, labelFeatureConf.isDisplayType());


						command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_NAME);
						updateToggleCommandState(command, labelFeatureConf.isDisplayName());
					}
				}
			}

			for(final ILabelProviderConfiguration current : rowLabelConfigurations) {
				if(current instanceof ObjectLabelProviderConfiguration) {
					final ObjectLabelProviderConfiguration labelConfig = (ObjectLabelProviderConfiguration)current;

					command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_DISPLAY_ICON);
					updateToggleCommandState(command, labelConfig.isDisplayIcon());

					command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_DISPLAY_LABEL);
					updateToggleCommandState(command, labelConfig.isDisplayLabel());

					if(labelConfig instanceof FeatureLabelProviderConfiguration) {
						final FeatureLabelProviderConfiguration labelFeatureConf = (FeatureLabelProviderConfiguration)labelConfig;
						command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_FEATURE_DISPLAY_IS_DERIVED);
						updateToggleCommandState(command, labelFeatureConf.isDisplayIsDerived());

						command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_FEATURE_DISPLAY_MULTIPLICITY);
						updateToggleCommandState(command, labelFeatureConf.isDisplayMultiplicity());

						command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_FEATURE_DISPLAY_TYPE);
						updateToggleCommandState(command, labelFeatureConf.isDisplayType());

						command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_FEATURE_DISPLAY_NAME);
						updateToggleCommandState(command, labelFeatureConf.isDisplayName());
					}
				}
			}

			//update the property IMasterObjectAxisProvider#disconnectslave
			if(columnProvider instanceof ISlaveAxisProvider) {
				command = commandService.getCommand(CommandIds.COMMAND_ROW_DISCONNECT_SLAVE);
				updateToggleCommandState(command, ((IMasterAxisProvider)rowProvider).isDisconnectSlave());
			}

			if(rowProvider instanceof ISlaveAxisProvider) {
				command = commandService.getCommand(CommandIds.COMMAND_COLUMN_DISCONNECT_SLAVE);
				updateToggleCommandState(command, ((IMasterAxisProvider)columnProvider).isDisconnectSlave());
			}

			//we update the state for the invert axis command
			command = commandService.getCommand(CommandIds.COMMAND_INVERT_AXIS);
			updateToggleCommandState(command, getTable().isInvertAxis());

		} else {
			throw new RuntimeException(String.format("The Eclipse service {0} has not been found", ICommandService.class)); //$NON-NLS-1$
		}

	}

	/**
	 * 
	 * @param command
	 *        an eclipse command
	 * @param newValue
	 *        the new boolean value to set to the state of this command
	 */
	private void updateToggleCommandState(final org.eclipse.core.commands.Command command, final boolean newValue) {
		if(command != null) {
			final State state = command.getState(CommandIds.TOGGLE_STATE);
			if(state != null) {
				state.setValue(newValue);
			}
		}
	}

	/**
	 * 
	 * @param command
	 *        an eclispe command
	 * @param newValue
	 *        the new value to set to the state of this command
	 */
	private void updateRadioCommandState(final org.eclipse.core.commands.Command command, final Object newValue) {
		if(command != null) {
			final State state = command.getState(CommandIds.RADIO_STATE);
			if(state != null) {
				state.setValue(newValue);
			}
		}
	}

	public void invertJavaObject() {
		getRowSortModel().clear();//we clear the sort model
		this.rowManager.setAxisComparator(null);
		AbstractAxisProvider newColumProvider = this.rowProvider;
		AbstractAxisProvider newRowProvider = this.columnProvider;
		List<Object> newVerticalElementList = this.horizontalElements;
		List<Object> newHorizontalElementList = this.verticalElements;
		ICompositeAxisManager newRowManager = this.columnManager;
		ICompositeAxisManager newColumnManager = this.rowManager;

		NattableModelManager.this.columnProvider = newColumProvider;
		NattableModelManager.this.rowProvider = newRowProvider;

		NattableModelManager.this.verticalElements = newVerticalElementList;
		NattableModelManager.this.horizontalElements = newHorizontalElementList;

		NattableModelManager.this.rowManager = newRowManager;
		NattableModelManager.this.columnManager = newColumnManager;
		updateToggleActionState();
		configureNatTable();
		refreshNatTable();
	}

	/**
	 * create the line and the columns managers
	 */
	protected void init() {
		if(this.columnManager != null) {
			this.columnManager.dispose();
		}
		if(this.rowManager != null) {
			this.rowManager.dispose();
		}
		this.columnProvider = getTable().getCurrentColumnAxisProvider();
		this.rowProvider = getTable().getCurrentRowAxisProvider();
		this.columnManager = createAxisManager(getTable().getTableConfiguration().getColumnHeaderAxisConfiguration().getAxisManagers(), getTable().getCurrentColumnAxisProvider());
		this.rowManager = createAxisManager(getTable().getTableConfiguration().getRowHeaderAxisConfiguration().getAxisManagers(), getTable().getCurrentRowAxisProvider());

		boolean allIsSlave = this.columnManager.isSlave() && this.rowManager.isSlave();
		Assert.isTrue(!allIsSlave, Messages.NattableModelManager_AtLeastOfOneTheAxisManagerMustBeAMaster);
	}

	/**
	 * 
	 * @param ids
	 *        the ids of the axis manager to use
	 * @param contentProvider
	 *        the content provider in the model
	 * @return the created axis manager to use to manage the {@link IAxisContentsProvider}
	 */
	protected ICompositeAxisManager createAxisManager(final List<AxisManagerRepresentation> representations, final AbstractAxisProvider contentProvider) {
		final List<IAxisManager> managers = new ArrayList<IAxisManager>();
		for(AxisManagerRepresentation current : representations) {
			final IAxisManager manager = AxisManagerFactory.INSTANCE.getAxisManager(current);
			assert manager != null;
			manager.init(this, current, contentProvider);
			managers.add(manager);
		}
		final ICompositeAxisManager compositeAxisManager = new CompositeAxisManager();
		compositeAxisManager.init(this, null, contentProvider);
		compositeAxisManager.setSubAxisManager(managers);
		return compositeAxisManager;
	}


	/**
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		getContextEditingDomain().getCommandStack().removeCommandStackListener(this.refreshListener);
		this.columnManager.dispose();
		this.rowManager.dispose();
		Table table = getTable();
		if(table != null && this.tableCellsListener != null) {
			table.eAdapters().remove(this.tableCellsListener);
		}
		if(this.cellsMap != null) {
			this.cellsMap.clear();
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#addRows(java.util.Collection)
	 * 
	 * @param objectsToAdd
	 *        the list of the objects to add in rows
	 */
	public void addRows(final Collection<Object> objectsToAdd) {
		final TransactionalEditingDomain domain = getContextEditingDomain();
		final Command cmd = getAddRowElementCommand(objectsToAdd);
		if(cmd != null && cmd.canExecute()) {
			domain.getCommandStack().execute(cmd);
		}
	}

	/**
	 * called when the manager is used vertically
	 */
	public int getColumnCount() {
		return this.getColumnElementsList().size();
	}

	/**
	 * called when the manager is used horizontally
	 */

	public int getRowCount() {
		return this.getRowElementsList().size();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#addColumns(java.util.Collection)
	 * 
	 * @param objectsToAdd
	 *        the list of the objects to add in columns
	 */
	public void addColumns(final Collection<Object> objectsToAdd) {
		final TransactionalEditingDomain domain = getContextEditingDomain();
		final Command cmd = getAddColumnElementCommand(objectsToAdd);
		if(cmd != null && cmd.canExecute()) {
			domain.getCommandStack().execute(cmd);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#removeColumns(java.util.Collection)
	 * 
	 * @param objetsToRemove
	 */
	@Override
	public void removeColumns(Collection<Object> objetsToRemove) {
		final TransactionalEditingDomain domain = getContextEditingDomain();
		final Command cmd = getDestroyColumnElementCommand(objetsToRemove);
		if(cmd != null && cmd.canExecute()) {
			domain.getCommandStack().execute(cmd);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#removeRows(java.util.Collection)
	 * 
	 * @param objectsToRemove
	 */
	@Override
	public void removeRows(Collection<Object> objectsToRemove) {
		final TransactionalEditingDomain domain = getContextEditingDomain();
		final Command cmd = getDestroyRowElementCommand(objectsToRemove);
		if(cmd != null && cmd.canExecute()) {
			domain.getCommandStack().execute(cmd);
		}
	}



	/**
	 * Returns the EditingDomain associated to the table
	 * 
	 * @return
	 */
	private TransactionalEditingDomain getTableEditingDomain() {
		return TableEditingDomainUtils.getTableContextEditingDomain(getTable());
	}

	/**
	 * Returns the EditingDomain associated to the context
	 * 
	 * @return
	 */
	private TransactionalEditingDomain getContextEditingDomain() {
		return TableEditingDomainUtils.getTableContextEditingDomain(getTable());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getBodyDataProvider()
	 * 
	 * @return the data provider for the body of the table
	 */
	public IDataProvider getBodyDataProvider() {
		return this;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.IDataProvider#getDataValue(int, int)
	 * 
	 * @param columnIndex
	 *        the index of the column
	 * @param rowIndex
	 *        the index of the row
	 * @return the contents to display in the cell localted to columnIndex and
	 *         rowIndex
	 */
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		final Object row;
		final Object column;
		final Object obj1 = this.verticalElements.get(columnIndex);
		final Object obj2 = this.horizontalElements.get(rowIndex);
		if(getTable().isInvertAxis()) {
			column = obj2;
			row = obj1;
		} else {
			row = obj2;
			column = obj1;
		}
		return CellManagerFactory.INSTANCE.getCrossValue(column, row, this);
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		final Object row;
		final Object column;
		final Object obj1 = this.verticalElements.get(columnIndex);
		final Object obj2 = this.horizontalElements.get(rowIndex);
		if(getTable().isInvertAxis()) {
			column = obj2;
			row = obj1;
		} else {
			row = obj2;
			column = obj1;
		}
		CellManagerFactory.INSTANCE.setCellValue((TransactionalEditingDomain)getContextEditingDomain(), column, row, newValue, this);
	}

	/**
	 * refresh NatTable (asyncExec)
	 */
	public void refreshNatTable() {
		if(this.natTable != null && !this.natTable.isDisposed()) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					NattableModelManager.this.natTable.refresh();
				}
			});
		}
	}


	/**
	 * 
	 * @param axis
	 *        the axis for which must refresh the contents
	 */
	public void updateAxisContents(final AbstractAxisProvider axis) {

		try {
			getContextEditingDomain().runExclusive(new Runnable() {

				@Override
				public void run() {
					Display.getDefault().syncExec(new Runnable() {

						@Override
						public void run() {
							if(NattableModelManager.this.natTable != null && !NattableModelManager.this.natTable.isDisposed()) {
								if(axis == NattableModelManager.this.columnProvider) {
									updateColumnContents();
									NattableModelManager.this.getRowSortModel().updateSort();
								} else {
									updateRowContents();
								}
							}
						}
					});

				}

			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * refresh the row contents
	 */
	private void updateRowContents() {
		NattableModelManager.this.rowManager.updateAxisContents();
		CellEditorDeclaration declaration = getCellEditorDeclarationToUse(getTable());
		if(declaration.equals(CellEditorDeclaration.ROW)) {
			configureNatTable();
			refreshNatTable();
		} else {
			refreshNatTable();
		}
	}



	/**
	 * refresh the column contents
	 */
	private void updateColumnContents() {
		NattableModelManager.this.columnManager.updateAxisContents();
		CellEditorDeclaration declaration = getCellEditorDeclarationToUse(getTable());
		if(declaration.equals(CellEditorDeclaration.COLUMN)) {
			configureNatTable();
			refreshNatTable();
		} else {
			refreshNatTable();
		}
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @return
	 *         the celleditor declaration to use according to the table configuration and {@link Table#isInvertAxis()}
	 */
	private CellEditorDeclaration getCellEditorDeclarationToUse(final Table table) {
		CellEditorDeclaration declaration = table.getTableConfiguration().getCellEditorDeclaration();
		if(getTable().isInvertAxis()) {
			if(declaration.equals(CellEditorDeclaration.COLUMN)) {
				declaration = CellEditorDeclaration.ROW;
			} else if(declaration.equals(CellEditorDeclaration.ROW)) {
				declaration = CellEditorDeclaration.COLUMN;
			}
		}
		return declaration;
	}

	public List<Object> getColumnElementsList() {
		return this.verticalElements;
	}

	public List<Object> getRowElementsList() {
		return this.horizontalElements;
	}

	public boolean canInsertRow(Collection<Object> objectsToAdd, int index) {
		return this.rowManager.canInsertAxis(objectsToAdd, index);
	}

	public boolean canInsertColumns(Collection<Object> objectsToAdd, int index) {
		return this.columnManager.canInsertAxis(objectsToAdd, index);
	}

	public boolean canDropColumnsElement(Collection<Object> objectsToAdd) {
		return this.columnManager.canDropAxisElement(objectsToAdd);
	}

	public boolean canDropRowElement(Collection<Object> objectsToAdd) {
		return this.rowManager.canDropAxisElement(objectsToAdd);
	}

	public void insertRows(Collection<Object> objectsToAdd, int index) {
		this.rowManager.getInsertAxisCommand(objectsToAdd, index);

	}

	public void insertColumns(Collection<Object> objectsToAdd, int index) {
		this.columnManager.getInsertAxisCommand(objectsToAdd, index);
	}

	public Object getColumnElement(int index) {
		if(index < 0 || index > this.verticalElements.size()) {
			return null;
		}
		return this.verticalElements.get(index);
	}

	public Object getRowElement(int index) {
		if(index < 0 || index > this.horizontalElements.size()) {
			return null;
		}
		return this.horizontalElements.get(index);
	}

	public List<Object> getElementsList(AbstractAxisProvider axisProvider) {
		if(axisProvider == this.columnProvider) {
			return this.verticalElements;
		} else if(axisProvider == this.rowProvider) {
			return this.horizontalElements;
		}
		return null;
	}

	public boolean canMoveRows() {
		return this.rowManager.canMoveAxis();
	}

	public boolean canMoveColumns() {
		return this.columnManager.canMoveAxis();
	}

	public void moveColumnElement(final Object axisToMove, final int newIndex) {
		this.columnManager.moveAxis(axisToMove, newIndex);
	}

	// not tested
	public void moveRowElement(final Object axisToMove, final int newIndex) {
		this.rowManager.moveAxis(axisToMove, newIndex);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#invertAxis()
	 * 
	 */
	public void invertAxis() {
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_SwitchLinesAndColumns);
		final TransactionalEditingDomain domain = getContextEditingDomain();
		boolean oldValue = getTable().isInvertAxis();
		if(canInvertAxis()) {
			Command tmp = new SetCommand(domain, getTable(), NattablePackage.eINSTANCE.getTable_InvertAxis(), !oldValue);
			cmd.append(tmp);
			domain.getCommandStack().execute(cmd);
		}
	}

	public boolean canInvertAxis() {
		return this.columnManager.canBeUsedAsRowManager() && this.rowManager.canBeUsedAsColumnManager();
	}

	public boolean canCreateRowElement(String elementType) {
		return this.rowManager.canCreateAxisElement(elementType);
	}

	public boolean canCreateColumnElement(String elementType) {
		// TODO Auto-generated method stub
		return true;
	}

	public Command getAddRowElementCommand(Collection<Object> objectsToAdd) {
		final TransactionalEditingDomain domain = getContextEditingDomain();
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_AddRowCommand);
		Command tmp = this.rowManager.getAddAxisCommand(domain, objectsToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		final AbstractAxisProvider rowsProvider = AxisUtils.getAxisProviderUsedForRows(this);
		final AbstractAxisProvider columnsProvider = AxisUtils.getAxisProviderUsedForColumns(this);
		boolean addComplementaryAxis = rowsProvider instanceof IMasterAxisProvider && columnsProvider instanceof ISlaveAxisProvider && !((IMasterAxisProvider)rowsProvider).isDisconnectSlave();
		if(addComplementaryAxis) {
			tmp = this.columnManager.getComplementaryAddAxisCommand(domain, objectsToAdd);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		return cmd;
	}

	public Command getAddColumnElementCommand(Collection<Object> objectsToAdd) {
		final TransactionalEditingDomain domain = getContextEditingDomain();
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_AddColumnCommand);
		Command tmp = this.columnManager.getAddAxisCommand(domain, objectsToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		final AbstractAxisProvider rowsProvider = AxisUtils.getAxisProviderUsedForRows(this);
		final AbstractAxisProvider columnsProvider = AxisUtils.getAxisProviderUsedForColumns(this);
		boolean addComplementaryAxis = columnsProvider instanceof IMasterAxisProvider && rowsProvider instanceof ISlaveAxisProvider && !((IMasterAxisProvider)columnsProvider).isDisconnectSlave();
		if(addComplementaryAxis) {
			tmp = this.rowManager.getComplementaryAddAxisCommand(domain, objectsToAdd);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		return cmd;
	}

	public Command getDestroyColumnElementCommand(Collection<Object> objectsToDestroy) {
		final TransactionalEditingDomain domain = getContextEditingDomain();
		final Command cmd = this.columnManager.getDestroyAxisCommand(domain, objectsToDestroy);
		return cmd;
	}

	public Command getDestroyRowElementCommand(Collection<Object> objectsToDestroy) {
		final TransactionalEditingDomain domain = getContextEditingDomain();
		final Command cmd = this.rowManager.getDestroyAxisCommand(domain, objectsToDestroy);
		return cmd;
	}


	public boolean declareEditorsOnColumns() {
		return true;//FIXME : used?
	}

	public boolean declareEditorsOnRows() {
		return false;//FIXME : used?
	}

	public ITableAxisElementProvider getTableAxisElementProvider() {// FIXME :
																	// must be
																	// renamed?
		return this;
	}




	/**
	 * When the axis manager is dynamic, we can't destroy axis
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#canCreateDestroyColumnsAxis()
	 * 
	 * @return
	 */
	@Override
	public boolean canCreateDestroyColumnsAxis() {
		return !this.columnManager.isDynamic() && this.columnManager.createPossibleAxisContentProvider(true) != null;
	}

	/**
	 * When the axis manager is dynamic, we can't destroy axis
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#canCreateDestroyRowsAxis()
	 * 
	 * @return
	 */
	@Override
	public boolean canCreateDestroyRowsAxis() {
		return !this.rowManager.isDynamic() && this.rowManager.createPossibleAxisContentProvider(true) != null;
	}

	/**
	 * 
	 * @param serv
	 *        the label provider service
	 * @param editedAxisManager
	 *        the manager used for the edited axis
	 * @param secondAxisManager
	 *        the manager used for the other axis
	 * @param isEditingColumns
	 *        boolean indicating if we are editing columns or rows
	 */
	private final void openCreateDestroyAxisManagerDialog(boolean isEditingColumns) {
		final String dialogTitle;
		final String dialogCheckBoxTootip;
		final String dialogQuestion;

		final IAxisManager editedAxisManager;
		final IAxisManager secondAxisManager;
		final String checkBoxMessage = Messages.NattableModelManager_DisconnectThisAxisManager;
		if(isEditingColumns) {
			dialogTitle = Messages.NattableModelManager_SelectColumns;
			dialogCheckBoxTootip = Messages.NattableModelManager_DisableTheAutomaticAdditionOfColumnsWhenARowIsAdded;
			dialogQuestion = String.format(Messages.NattableModelManager_TheCheckBoxHasNotBeenCheckedToAvoidAutomaticColumnAddition, checkBoxMessage);

			editedAxisManager = columnManager;
			secondAxisManager = rowManager;
		} else {
			dialogTitle = Messages.NattableModelManager_SelectRows;
			dialogCheckBoxTootip = Messages.NattableModelManager_DisableTheAutomaticAdditionOfRowsWhenAColumnIsAdded;
			dialogQuestion = String.format(Messages.NattableModelManager_TheCheckBoxHasNotBeenCheckedToAvoidAutomaticRowAddition, checkBoxMessage);

			editedAxisManager = rowManager;
			secondAxisManager = columnManager;
		}
		final LabelProviderService serv = this.natTable.getConfigRegistry().getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		final ILabelProvider labelProvider = serv.getLabelProvider();
		final AbstractAxisProvider editedAxisProvider = editedAxisManager.getRepresentedContentProvider();
		final AbstractAxisProvider secondAxisProvider = secondAxisManager.getRepresentedContentProvider();
		ReferenceSelector selector = new ReferenceSelector(true) {

			@Override
			public void createControls(Composite parent) {
				super.createControls(parent);
				this.treeViewer.setComparator(new ViewerComparator(new StringComparator()));//should always be string element
			}
		};
		selector.setLabelProvider(labelProvider);

		IStaticContentProvider provider = editedAxisManager.createPossibleAxisContentProvider(true);
		if(provider != null) {
			selector.setContentProvider(new FlattenableRestrictedFilteredContentProvider((IRestrictedContentProvider)provider, selector));

			final DisplayedAxisSelectorDialog dialog = new DisplayedAxisSelectorDialog(Display.getDefault().getActiveShell(), selector, dialogTitle, true, false, -1);
			boolean displayCheckBox = editedAxisProvider instanceof ISlaveAxisProvider;
			dialog.setDisplayCheckBox(displayCheckBox);
			boolean checkboxValue = secondAxisProvider instanceof IMasterAxisProvider && ((IMasterAxisProvider)secondAxisProvider).isDisconnectSlave();
			if(displayCheckBox) {
				dialog.setCheckBoxValues(checkBoxMessage, dialogCheckBoxTootip, checkboxValue);
			}

			dialog.setInformationDialogValues(Messages.NattableModelManager_DisconnectAxisManagerInformationDialogTitle, dialogQuestion);
			dialog.setLabelProvider(labelProvider);
			dialog.setInitialElementSelections(new ArrayList<Object>(editedAxisManager.getAllManagedAxis()));

			int open = dialog.open();
			if(open == Window.OK) {
				Collection<Object> existingColumns = editedAxisManager.getAllManagedAxis();
				ArrayList<Object> checkedColumns = new ArrayList<Object>();
				checkedColumns.addAll(Arrays.asList(dialog.getResult()));

				ArrayList<Object> columnsToAdd = new ArrayList<Object>(checkedColumns);
				columnsToAdd.removeAll(existingColumns);
				CompoundCommand compoundCommand = new CompoundCommand("Update Existing Axis Command"); //$NON-NLS-1$
				if(columnsToAdd.size() > 0) {
					Command addAxisElementCommand = null;
					if(isEditingColumns) {
						addAxisElementCommand = getAddColumnElementCommand(columnsToAdd);
					} else {
						addAxisElementCommand = getAddRowElementCommand(columnsToAdd);
					}
					compoundCommand.append(addAxisElementCommand);
				}

				ArrayList<Object> axisToDestroy = new ArrayList<Object>(existingColumns);
				axisToDestroy.removeAll(checkedColumns);
				if(axisToDestroy.size() > 0) {
					Command destroyAxisElementCommand = null;
					if(isEditingColumns) {
						destroyAxisElementCommand = getDestroyColumnElementCommand(axisToDestroy);
					} else {
						destroyAxisElementCommand = getDestroyRowElementCommand(axisToDestroy);
					}
					compoundCommand.append(destroyAxisElementCommand);
				}

				final boolean newState = dialog.isChecked();
				if(displayCheckBox && checkboxValue != newState) {
					final TransactionalEditingDomain domain = (TransactionalEditingDomain)getTableEditingDomain();
					final IEditCommandRequest request = new SetRequest(domain, secondAxisProvider, NattableaxisproviderPackage.eINSTANCE.getIMasterAxisProvider_DisconnectSlave(), newState);
					final IElementEditService commandProvider = ElementEditServiceUtils.getCommandProvider(secondAxisProvider);
					compoundCommand.append(new GMFtoEMFCommandWrapper(commandProvider.getEditCommand(request)));
				}

				if(!compoundCommand.isEmpty()) {
					getContextEditingDomain().getCommandStack().execute(compoundCommand);
					updateToggleActionState();
				}
			}
		} else {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), Messages.NattableModelManager_CreateDestroyAxis, Messages.NattableModelManager_ActionNotYetSupported);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#openCreateDestroyRowsManagerDialog()
	 * 
	 */
	@Override
	public void openCreateDestroyRowsManagerDialog() {
		openCreateDestroyAxisManagerDialog(false);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#openCreateDestroyColumnsManagerDialog()
	 * 
	 */
	public void openCreateDestroyColumnsManagerDialog() {
		openCreateDestroyAxisManagerDialog(true);
	}

	public void sortColumnsByName(final boolean alphabeticOrder) {
		this.columnManager.sortAxisByName(alphabeticOrder, this.natTable.getConfigRegistry());
	}


	public void sortRowsByName(final boolean alphabeticOrder) {
		this.rowManager.sortAxisByName(alphabeticOrder, this.natTable.getConfigRegistry());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getVerticalAxisProvider()
	 * 
	 * @return
	 */
	public AbstractAxisProvider getVerticalAxisProvider() {
		if(getTable().isInvertAxis()) {
			return getTable().getCurrentRowAxisProvider();
		} else {
			return getTable().getCurrentColumnAxisProvider();
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getHorizontalAxisProvider()
	 * 
	 * @return
	 */
	public AbstractAxisProvider getHorizontalAxisProvider() {
		if(getTable().isInvertAxis()) {
			return getTable().getCurrentColumnAxisProvider();
		} else {
			return getTable().getCurrentRowAxisProvider();
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#canEditColumnHeader(int)
	 * 
	 * @param evaluationContext
	 * @return
	 */
	public boolean canEditColumnHeader(final NatEventData evaluationContext) {
		return this.columnManager.canEditAxisHeader(evaluationContext);
	}

	/***
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#canEditRowHeader(org.eclipse.nebula.widgets.nattable.ui.NatEventData)
	 * 
	 * @param eventData
	 * @return
	 */
	@Override
	public boolean canEditRowHeader(NatEventData evaluationContext) {
		return this.rowManager.canEditAxisHeader(evaluationContext);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#openEditRowAliasDialog(org.eclipse.nebula.widgets.nattable.ui.NatEventData)
	 * 
	 * @param event
	 */
	public void openEditRowAliasDialog(NatEventData event) {
		this.rowManager.openEditAxisAliasDialog(event, event.getNatTable().getRowIndexByPosition(event.getRowPosition()));
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#openEditColumnAliasDialog(org.eclipse.nebula.widgets.nattable.ui.NatEventData)
	 * 
	 * @param event
	 */
	public void openEditColumnAliasDialog(NatEventData event) {
		this.columnManager.openEditAxisAliasDialog(event, event.getNatTable().getColumnIndexByPosition(event.getColumnPosition()));
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getColumnAxisManager()
	 * 
	 * @return
	 */
	@Override
	public IAxisManager getColumnAxisManager() {
		return this.columnManager;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getRowAxisManager()
	 * 
	 * @return
	 */
	@Override
	public IAxisManager getRowAxisManager() {
		return this.rowManager;
	}


	public void setTableName(String name) {
		SetRequest setNameRequest = new SetRequest(getTable(), NattableconfigurationPackage.eINSTANCE.getTableNamedElement_Name(), name);
		IElementEditService editService = ElementEditServiceUtils.getCommandProvider(getTable());
		ICommand setNameCommand = editService.getEditCommand(setNameRequest);
		getTableEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(setNameCommand));
	}


	public String getTableName() {
		return getTable().getName();
	}


	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if(adapter == NatTable.class) {
			return this.natTable;
		}
		return null;
	}

	private void updateCellMap(final Notification notification) {
		Job job = new Job("Update cells") { //$NON-NLS-1$

			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				if(notification == null) {
					cellsMap.clear();
					for(final Cell current : getTable().getCells()) {
						final CellMapKey key = createCellMapKeyWaitingCellAxis(current);
						cellsMap.put(key, current);
					}
				} else {
					int eventType = notification.getEventType();
					if(eventType == Notification.ADD) {
						final Object object = notification.getNewValue();
						if(object instanceof Cell) {
							final Cell cell = (Cell)object;
							final CellMapKey key = createCellMapKeyWaitingCellAxis(cell);
							cellsMap.put(key, cell);
						}
					} else if(eventType == Notification.ADD_MANY) {
						final Object coll = notification.getNewValue();

						if(coll instanceof Collection<?>) {
							final Iterator<?> iter = ((Collection<?>)coll).iterator();
							while(iter.hasNext()) {
								Object object = iter.next();
								if(object instanceof Cell) {
									final Cell cell = (Cell)object;
									final CellMapKey key = createCellMapKeyWaitingCellAxis(cell);
									cellsMap.put(key, cell);
								}
							}
						}
					} else if(eventType == Notification.REMOVE) {
						Object oldCell = notification.getOldValue();
						if(oldCell instanceof Cell) {
							CellMapKey key = cellsMap.inverse().get(oldCell);
							cellsMap.remove(key);
						}
					} else if(eventType == Notification.REMOVE_MANY) {
						final Object coll = notification.getOldValue();

						if(coll instanceof Collection<?>) {
							final Iterator<?> iter = ((Collection<?>)coll).iterator();
							while(iter.hasNext()) {
								Object object = iter.next();
								if(object instanceof Cell) {
									final CellMapKey key = cellsMap.inverse().get(object);
									cellsMap.remove(key);
								}
							}
						}
					}
				}

				return Status.OK_STATUS;
			}
		};
		job.setUser(false);
		job.setSystem(true);
		job.addJobChangeListener(new JobChangeAdapter() {

			@Override
			public void done(IJobChangeEvent event) {
				refreshNatTable();
			}

		});
		job.schedule();


	}



	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getCell(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	public Cell getCell(final Object columnElement, final Object rowElement) {
		final CellMapKey key = new CellMapKey(columnElement, rowElement);
		return this.cellsMap.get(key);
	}

	/**
	 * This method allows to create a CellMapKey object waiting that required fields in the cell have been initialized
	 * 
	 * @param cell
	 *        a cell
	 */
	private CellMapKey createCellMapKeyWaitingCellAxis(final Cell cell) {
		while(cell.getColumnWrapper() == null || cell.getRowWrapper() == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Activator.log.error(e);
			}
		}
		while(cell.getColumnWrapper().getElement() == null || cell.getRowWrapper().getElement() == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Activator.log.error(e);
			}
		}
		return new CellMapKey(cell.getColumnWrapper().getElement(), cell.getRowWrapper().getElement());
	}

}
