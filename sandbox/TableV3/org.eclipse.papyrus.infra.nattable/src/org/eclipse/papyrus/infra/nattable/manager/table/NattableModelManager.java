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
import java.util.List;

import org.eclipse.core.commands.State;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.command.CommandIds;
import org.eclipse.papyrus.infra.nattable.manager.axis.AxisManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.axis.CompositeAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.axis.ICompositeAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.nattable.utils.StringComparator;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
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

public class NattableModelManager extends AbstractNattableWidgetManager implements INattableModelManager {

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
	}


	@Override
	public NatTable createNattable(Composite parent, int style, IWorkbenchPartSite site) {
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
				if(nattable != null && !nattable.isDisposed() && nattable.isVisible()) {
					nattable.refresh();
				}
			}
		};

		getEditingDomain(getTableContext()).getCommandStack().addCommandStackListener(this.refreshListener);

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
			if(command != null) {
				final State state = command.getState(CommandIds.TOGGLE_STATE);
				if(state != null) {
					state.setValue(columnAxisConfiguration.isDisplayIndex());
				}
			}
			command = commandService.getCommand(CommandIds.COMMAND_COLUMN_DISPLAY_LABEL_ID);
			if(command != null) {
				final State state = command.getState(CommandIds.TOGGLE_STATE);
				if(state != null) {
					state.setValue(columnAxisConfiguration.isDisplayLabel());
				}
			}
			command = commandService.getCommand(CommandIds.COMMAND_COLUMN_DISPLAY_INDEX_STYLE_ID);
			if(command != null) {
				final State state = command.getState(CommandIds.RADIO_STATE);
				if(state != null) {
					state.setValue(columnAxisConfiguration.getIndexStyle().getLiteral());
				}
			}

			command = commandService.getCommand(CommandIds.COMMAND_ROW_DISPLAY_INDEX_ID);
			if(command != null) {
				final State state = command.getState(CommandIds.TOGGLE_STATE);
				if(state != null) {
					state.setValue(rowAxisConfiguration.isDisplayIndex());
				}
			}
			command = commandService.getCommand(CommandIds.COMMAND_ROW_DISPLAY_LABEL_ID);
			if(command != null) {
				final State state = command.getState(CommandIds.TOGGLE_STATE);
				if(state != null) {
					state.setValue(rowAxisConfiguration.isDisplayLabel());
				}
			}
			command = commandService.getCommand(CommandIds.COMMAND_ROW_DISPLAY_INDEX_STYLE_ID);
			if(command != null) {
				final State state = command.getState(CommandIds.RADIO_STATE);
				if(state != null) {
					state.setValue(rowAxisConfiguration.getIndexStyle().getLiteral());
				}
			}

			//update the label header configuration
			final List<ILabelProviderConfiguration> columnLabelConfigurations = columnAxisConfiguration.getOwnedLabelConfigurations();
			final List<ILabelProviderConfiguration> rowLabelConfigurations = rowAxisConfiguration.getOwnedLabelConfigurations();
			for(final ILabelProviderConfiguration current : columnLabelConfigurations) {
				if(current instanceof ObjectLabelProviderConfiguration) {
					final ObjectLabelProviderConfiguration labelConfig = (ObjectLabelProviderConfiguration)current;
					command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_DISPLAY_ICON);
					if(command != null) {
						final State state = command.getState(CommandIds.TOGGLE_STATE);
						if(state != null) {
							state.setValue(labelConfig.isDisplayIcon());
						}
					}

					command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_DISPLAY_LABEL);
					if(command != null) {
						final State state = command.getState(CommandIds.TOGGLE_STATE);
						if(state != null) {
							state.setValue(labelConfig.isDisplayLabel());
						}
					}
					if(labelConfig instanceof FeatureLabelProviderConfiguration) {
						final FeatureLabelProviderConfiguration labelFeatureConf = (FeatureLabelProviderConfiguration)labelConfig;
						command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_IS_DERIVED);
						if(command != null) {
							final State state = command.getState(CommandIds.TOGGLE_STATE);
							if(state != null) {
								state.setValue(labelFeatureConf.isDisplayIsDerived());
							}
						}
						command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_MULTIPLICITY);
						if(command != null) {
							final State state = command.getState(CommandIds.TOGGLE_STATE);
							if(state != null) {
								state.setValue(labelFeatureConf.isDisplayMultiplicity());
							}
						}
						command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_TYPE);
						if(command != null) {
							final State state = command.getState(CommandIds.TOGGLE_STATE);
							if(state != null) {
								state.setValue(labelFeatureConf.isDisplayType());
							}
						}

						command = commandService.getCommand(CommandIds.COMMAND_COLUMN_LABEL_FEATURE_DISPLAY_NAME);
						if(command != null) {
							final State state = command.getState(CommandIds.TOGGLE_STATE);
							if(state != null) {
								state.setValue(labelFeatureConf.isDisplayName());
							}
						}
					}
				}
			}

			for(final ILabelProviderConfiguration current : rowLabelConfigurations) {
				if(current instanceof ObjectLabelProviderConfiguration) {
					final ObjectLabelProviderConfiguration labelConfig = (ObjectLabelProviderConfiguration)current;
					command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_DISPLAY_ICON);
					if(command != null) {
						final State state = command.getState(CommandIds.TOGGLE_STATE);
						if(state != null) {
							state.setValue(labelConfig.isDisplayIcon());
						}
					}

					command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_DISPLAY_LABEL);
					if(command != null) {
						final State state = command.getState(CommandIds.TOGGLE_STATE);
						if(state != null) {
							state.setValue(labelConfig.isDisplayLabel());
						}
					}
					if(labelConfig instanceof FeatureLabelProviderConfiguration) {
						final FeatureLabelProviderConfiguration labelFeatureConf = (FeatureLabelProviderConfiguration)labelConfig;
						command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_FEATURE_DISPLAY_IS_DERIVED);
						if(command != null) {
							final State state = command.getState(CommandIds.TOGGLE_STATE);
							if(state != null) {
								state.setValue(labelFeatureConf.isDisplayIsDerived());
							}
						}
						command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_FEATURE_DISPLAY_MULTIPLICITY);
						if(command != null) {
							final State state = command.getState(CommandIds.TOGGLE_STATE);
							if(state != null) {
								state.setValue(labelFeatureConf.isDisplayMultiplicity());
							}
						}
						command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_FEATURE_DISPLAY_TYPE);
						if(command != null) {
							final State state = command.getState(CommandIds.TOGGLE_STATE);
							if(state != null) {
								state.setValue(labelFeatureConf.isDisplayType());
							}
						}

						command = commandService.getCommand(CommandIds.COMMAND_ROW_LABEL_FEATURE_DISPLAY_NAME);
						if(command != null) {
							final State state = command.getState(CommandIds.TOGGLE_STATE);
							if(state != null) {
								state.setValue(labelFeatureConf.isDisplayName());
							}
						}
					}
				}
			}

		} else {
			throw new RuntimeException(String.format("The Eclipse service {0} has not been found", ICommandService.class)); //$NON-NLS-1$
		}

	}

	public void invertJavaObject() {
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
		this.columnManager.dispose();
		this.rowManager.dispose();
		getEditingDomain(getTableContext()).getCommandStack().removeCommandStackListener(this.refreshListener);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#addRows(java.util.Collection)
	 * 
	 * @param objectToAdd
	 *        the list of the objects to add in rows
	 */
	public void addRows(final Collection<Object> objectToAdd) {
		final EditingDomain domain = getEditingDomain(getTableContext());
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_AddRowCommand);
		Command tmp = this.rowManager.getAddAxisCommand(domain, objectToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		tmp = this.columnManager.getComplementaryAddAxisCommand(domain, objectToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		if(!cmd.isEmpty()) {
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
	 * @param objectToAdd
	 *        the list of the objects to add in columns
	 */
	public void addColumns(final Collection<Object> objectToAdd) {
		final EditingDomain domain = getEditingDomain(getTableContext());
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_AddColumnCommand);
		Command tmp = this.columnManager.getAddAxisCommand(domain, objectToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		tmp = this.rowManager.getComplementaryAddAxisCommand(domain, objectToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		if(!cmd.isEmpty()) {
			domain.getCommandStack().execute(cmd);
		}
	}

	/**
	 * 
	 * @param obj
	 *        an eobject linked to the model
	 * @return the editing domain to use
	 * 
	 * @deprecated Use getTableEditingDomain() or getContextEditingDomain() instead
	 */
	//FIXME Use either getTableEditingDomain() or getContextEditingDomain()
	@Deprecated
	private EditingDomain getEditingDomain(EObject eobject) {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(eobject);
			return registry.getService(EditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}

		return null;
	}

	/**
	 * Returns the EditingDomain associated to the table
	 * 
	 * @return
	 */
	private EditingDomain getTableEditingDomain() {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(getTable());
			return registry.getService(EditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}

		return null;
	}

	/**
	 * Returns the EditingDomain associated to the context
	 * 
	 * @return
	 */
	private EditingDomain getContextEditingDomain() {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(getTableContext());
			return registry.getService(EditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}

		return null;
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
		final Object obj1 = this.verticalElements.get(columnIndex);
		final Object obj2 = this.horizontalElements.get(rowIndex);
		return CellManagerFactory.INSTANCE.getCrossValue(obj1, obj2);
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		final Object obj1 = this.verticalElements.get(columnIndex);
		final Object obj2 = this.horizontalElements.get(rowIndex);
		CellManagerFactory.INSTANCE.setCellValue(getEditingDomain(getTableContext()), obj1, obj2, newValue);
	}

	/**
	 * this method returns the column data provider and is able to manage
	 * inversion in the axis
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getColumnDataProvider()
	 * 
	 * @return the column data provider
	 */
	public IAxisManager getColumnDataProvider() {
		return this.columnManager;
	}

	/**
	 * this method returns the row data provider and is able to manage inversion
	 * in the axis
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getLineDataProvider()
	 * 
	 * @return the row data provider
	 */
	public IAxisManager getLineDataProvider() {
		return this.rowManager;
	}

	/**
	 * refresh NatTable (asyncExec)
	 */
	public void refreshNatTable() {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				NattableModelManager.this.natTable.refresh();
			}
		});
	}


	/**
	 * 
	 * @param axis
	 *        the axis for which must refresh the contents
	 */
	public void updateAxisContents(final AbstractAxisProvider axis) {
		Display.getDefault().asyncExec(new Runnable() {//required, because we get the event before the changes

			public void run() {
				if(NattableModelManager.this.natTable != null && !NattableModelManager.this.natTable.isDisposed()) {
					if(axis == NattableModelManager.this.columnProvider) {
						updateColumnContents();
					} else {
						updateRowContents();
					}
				}
			}
		});
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
		return this.verticalElements.get(index);
	}

	public Object getRowElement(int index) {
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

	public boolean canReoderRows() {
		return this.rowManager.canReoderElements();
	}

	public boolean canReorderColumns() {
		return this.columnManager.canReoderElements();
	}

	public void reorderColumnsElements(final IAxis axisToMove, final int newIndex) {
		final EditingDomain domain = getEditingDomain(getTableContext());
		//FIXME
		//		final Command cmd = MoveCommand.create(getEditingDomain(getTable().getContext()), this.columnProvider, NattableaxisproviderPackage.eINSTANCE.getDefaultAxisProvider_Axis(), axisToMove, newIndex);
		//		domain.getCommandStack().execute(cmd);
	}

	// not tested
	public void reorderRowElements(final IAxis axisToMove, final int newIndex) {
		final EditingDomain domain = getEditingDomain(getTableContext());
		//		final Command cmd = MoveCommand.create(getEditingDomain(getTable().getContext()), this.rowProvider, NattableaxisproviderPackage.eINSTANCE.getDefaultAxisProvider_Axis(), axisToMove, newIndex);
		//		domain.getCommandStack().execute(cmd);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#invertAxis()
	 * 
	 */
	public void invertAxis() {
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_SwitchLinesAndColumns);
		final EditingDomain domain = getEditingDomain(getTableContext());
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
		// TODO Auto-generated method stub
		return true;
	}

	public boolean canCreateColumnElement(String elementType) {
		// TODO Auto-generated method stub
		return true;
	}

	public Command getAddRowElementCommand(Collection<Object> objectsToAdd) {
		final EditingDomain domain = getEditingDomain(getTableContext());
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_AddRowCommand);
		Command tmp = this.rowManager.getAddAxisCommand(domain, objectsToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		tmp = this.columnManager.getComplementaryAddAxisCommand(domain, objectsToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		return cmd;
	}

	public Command getAddColumnElementCommand(Collection<Object> objectsToAdd) {
		final EditingDomain domain = getEditingDomain(getTableContext());
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_AddColumnCommand);
		Command tmp = this.columnManager.getAddAxisCommand(domain, objectsToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		tmp = this.rowManager.getComplementaryAddAxisCommand(domain, objectsToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		return cmd;
	}

	public Command getDestroyColumnElementCommand(Collection<Object> objectsToDestroy) {
		final EditingDomain domain = getEditingDomain(getTableContext());
		final Command cmd = this.columnManager.getDestroyAxisCommand(domain, objectsToDestroy);
		return cmd;
	}

	public boolean declareEditorsOnColumns() {
		return true;
	}

	public boolean declareEditorsOnRows() {
		return false;
	}

	public ITableAxisElementProvider getTableAxisElementProvider() {// FIXME :
																	// must be
																	// renamed?
		return this;
	}


	public void openColumnsManagerDialog() {

		final LabelProviderService serv = this.natTable.getConfigRegistry().getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		final ILabelProvider labelProvider = serv.getLabelProvider();

		ReferenceSelector selector = new ReferenceSelector(true) {

			@Override
			public void createControls(Composite parent) {
				super.createControls(parent);
				this.treeViewer.setComparator(new ViewerComparator(new StringComparator()));//should always be string element
			}
		};
		selector.setLabelProvider(labelProvider);

		IStaticContentProvider provider = this.columnManager.createDestroyColumnsContentProvider(true);
		if(provider != null) {//FIXME : the action must be hidden when it is not possible to select the columns
			selector.setContentProvider(new FlattenableRestrictedFilteredContentProvider((IRestrictedContentProvider)provider, selector));

			MultipleValueSelectorDialog dialog = new MultipleValueSelectorDialog(Display.getDefault().getActiveShell(), selector, Messages.NattableModelManager_SelectColumns, true, false, -1);
			dialog.setLabelProvider(serv.getLabelProvider());
			dialog.setInitialElementSelections(new ArrayList<Object>(this.columnManager.getAllManagedAxis()));

			int open = dialog.open();
			if(open == Window.OK) {
				Collection<Object> existingColumns = this.columnManager.getAllManagedAxis();
				ArrayList<Object> checkedColumns = new ArrayList<Object>();
				checkedColumns.addAll(Arrays.asList(dialog.getResult()));
				CommandStack commandStack = getEditingDomain(getTableContext()).getCommandStack();

				ArrayList<Object> columnsToAdd = new ArrayList<Object>(checkedColumns);
				columnsToAdd.removeAll(existingColumns);
				CompoundCommand compoundCommand = new CompoundCommand("Update Existing Axis Command"); //$NON-NLS-1$
				if(columnsToAdd.size() > 0) {
					Command addColumnElementCommand = getAddColumnElementCommand(columnsToAdd);
					compoundCommand.append(addColumnElementCommand);
				}


				ArrayList<Object> columnsToDelete = new ArrayList<Object>(existingColumns);
				columnsToDelete.removeAll(checkedColumns);
				if(columnsToDelete.size() > 0) {
					Command destroyColumnElementCommand = getDestroyColumnElementCommand(columnsToDelete);
					compoundCommand.append(destroyColumnElementCommand);
				}
				if(!compoundCommand.isEmpty()) {
					commandStack.execute(compoundCommand);
				}
			}
		} else {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), Messages.NattableModelManager_CreateDestroyAxis, Messages.NattableModelManager_ActionNotYetSupported);
		}

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
}
