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
package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.factory.AxisManagerFactory;
import org.eclipse.papyrus.infra.nattable.common.messages.Messages;
import org.eclipse.papyrus.infra.nattable.common.solver.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class NattableModelManager implements INattableModelManager {

	/**
	 * the column manager
	 */
	private IAxisManager columnManager;

	/**
	 * the line manager
	 */
	private IAxisManager rowManager;

	/**
	 * the model of the table on which we are working
	 */
	private final Table pTable;

	private List<Object> verticalElements;

	private List<Object> horizontalElements;

	private Adapter invertAxisListener;

	private IAxisContentsProvider rowProvider;

	private IAxisContentsProvider columnProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param rawModel
	 * 
	 *        the model of the managed table
	 */
	public NattableModelManager(final Table rawModel) {
		this.pTable = rawModel;
		this.rowProvider = rawModel.getHorizontalContentProvider();
		this.columnProvider = rawModel.getVerticalContentProvider();
		this.verticalElements = new ArrayList<Object>();
		this.horizontalElements = new ArrayList<Object>();
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
	}

	public void invertJavaObject() {
		IAxisContentsProvider newColumProvider = rowProvider;
		IAxisContentsProvider newRowProvider = columnProvider;
		List<Object> newVerticalElementList = horizontalElements;
		List<Object> newHorizontalElementList = verticalElements;
		IAxisManager newRowManager = columnManager;
		IAxisManager newColumnManager = rowManager;

		NattableModelManager.this.columnProvider = newColumProvider;
		NattableModelManager.this.rowProvider = newRowProvider;

		NattableModelManager.this.verticalElements = newVerticalElementList;
		NattableModelManager.this.horizontalElements = newHorizontalElementList;

		NattableModelManager.this.rowManager = newRowManager;
		NattableModelManager.this.columnManager = newColumnManager;
		refreshNattable();
	}

	/**
	 * create the line and the columns managers
	 */
	protected void init() {
		final List<String> verticalContentProviderIds = getVerticalContentProviderIds();
		assert !verticalContentProviderIds.isEmpty();
		this.columnManager = createAxisManager(verticalContentProviderIds, this.pTable.getVerticalContentProvider());

		final List<String> horizontalContentProviderIds = getHorizontalContentProviderIds();
		assert !horizontalContentProviderIds.isEmpty();
		this.rowManager = createAxisManager(horizontalContentProviderIds, this.pTable.getHorizontalContentProvider());
	}

	/**
	 * 
	 * @param ids
	 *        the ids of the axis manager to use
	 * @param contentProvider
	 *        the content provider in the model
	 * @return
	 *         the created axis manager to use to manage the {@link IAxisContentsProvider}
	 */
	protected IAxisManager createAxisManager(final List<String> ids, final IAxisContentsProvider contentProvider) {
		final List<IAxisManager> managers = new ArrayList<IAxisManager>();
		for(final String id : ids) {
			final IAxisManager manager = AxisManagerFactory.INSTANCE.getAxisManager(this, id, this.pTable, contentProvider, ids.size() == 1);
			assert manager != null;
			managers.add(manager);
		}
		IAxisManager manager = null;
		if(managers.size() > 1) {
			manager = new CompositeAxisManager();
			manager.init(this, "", this.pTable, contentProvider, true); //$NON-NLS-1$
			((CompositeAxisManager)manager).setAxisManager(managers);
		} else {
			manager = managers.get(0);
		}
		return manager;
	}

	/**
	 * 
	 * @return
	 *         the list of the ids of the axis manager to use for the vertical axis
	 */
	protected List<String> getVerticalContentProviderIds() {
		return this.pTable.getVerticalContentProvider().getJavaContentProviderIds();
	}

	/**
	 * 
	 * @return
	 *         the list of the ids of the axis manager to use for the horizontal axis
	 */

	protected List<String> getHorizontalContentProviderIds() {
		return this.pTable.getHorizontalContentProvider().getJavaContentProviderIds();
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
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#addRows(java.util.Collection)
	 * 
	 * @param objectToAdd
	 *        the list of the objects to add in rows
	 */
	@Override
	public void addRows(final Collection<Object> objectToAdd) {
		final EditingDomain domain = getEditingDomain(this.pTable);
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

	//FIXME : this method should never be called, we should find another way to do the refresh
	private NatTable getNatTable() {
		final IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		return (NatTable)part.getAdapter(NatTable.class);
	}

	/**
	 * called when the manager is used vertically
	 */
	@Override
	public int getColumnCount() {
		return this.getColumnElementsList().size();
	}

	/**
	 * called when the manager is used horizontally
	 */

	@Override
	public int getRowCount() {
		return this.getRowElementsList().size();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#addColumns(java.util.Collection)
	 * 
	 * @param objectToAdd
	 *        the list of the objects to add in columns
	 */
	@Override
	public void addColumns(final Collection<Object> objectToAdd) {
		final EditingDomain domain = getEditingDomain(this.pTable);
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
	 * @return
	 *         the editing domain to use
	 */
	private EditingDomain getEditingDomain(final EObject obj) {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForResource.getInstance().getServiceRegistry(obj.eResource());
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_ServiceRegistryNotFound, e);
		}
		try {
			return registry.getService(TransactionalEditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error(Messages.NattableModelManager_EditingDomainNotFound, e);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#getBodyDataProvider()
	 * 
	 * @return
	 *         the data provider for the body of the table
	 */
	@Override
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
	 * @return
	 *         the contents to display in the cell localted to columnIndex and rowIndex
	 */
	@Override
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		final Object obj1 = this.verticalElements.get(columnIndex);
		final Object obj2 = this.horizontalElements.get(rowIndex);
		return CellManagerFactory.INSTANCE.getCrossValue(obj1, obj2);
	}

	@Override
	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		final Object obj1 = this.verticalElements.get(columnIndex);
		final Object obj2 = this.horizontalElements.get(rowIndex);
		CellManagerFactory.INSTANCE.setCellValue(getEditingDomain(pTable), obj1, obj2, newValue);
	}

	/**
	 * this method returns the column data provider and is able to manage inversion in the axis
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#getColumnDataProvider()
	 * 
	 * @return
	 *         the column data provider
	 */
	@Override
	public IAxisManager getColumnDataProvider() {
		return this.columnManager;
	}

	/**
	 * this method returns the row data provider and is able to manage inversion in the axis
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#getLineDataProvider()
	 * 
	 * @return
	 *         the row data provider
	 */
	@Override
	public IAxisManager getLineDataProvider() {
		return this.rowManager;
	}


	public void refreshNattable() {
		final NatTable table = getNatTable();
		if(table != null) {
			table.setConfigRegistry(new ConfigRegistry());
			table.setUiBindingRegistry(new UiBindingRegistry(table));
			table.configure();
			if(table != null && !table.isDisposed()) {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						table.refresh();
					}
				});
				table.refresh();
			}
		}
	}

	@Override
	public List<Object> getColumnElementsList() {
		return this.verticalElements;
	}

	@Override
	public List<Object> getRowElementsList() {
		return this.horizontalElements;
	}

	@Override
	public boolean canInsertRow(Collection<Object> objectsToAdd, int index) {
		return this.rowManager.canInsertAxis(objectsToAdd, index);
	}

	@Override
	public boolean canInsertColumns(Collection<Object> objectsToAdd, int index) {
		return this.columnManager.canInsertAxis(objectsToAdd, index);
	}

	@Override
	public boolean canDropColumnsElement(Collection<Object> objectsToAdd) {
		return this.columnManager.canDropAxisElement(objectsToAdd);
	}

	@Override
	public boolean canDropRowElement(Collection<Object> objectsToAdd) {
		return this.rowManager.canDropAxisElement(objectsToAdd);
	}

	@Override
	public void insertRows(Collection<Object> objectsToAdd, int index) {
		this.rowManager.getInsertAxisCommand(objectsToAdd, index);

	}

	@Override
	public void insertColumns(Collection<Object> objectsToAdd, int index) {
		this.columnManager.getInsertAxisCommand(objectsToAdd, index);
	}

	@Override
	public Object getColumnElement(int index) {
		return this.verticalElements.get(index);
	}

	@Override
	public Object getRowElement(int index) {
		return this.horizontalElements.get(index);
	}

	@Override
	public List<Object> getElementsList(IAxisContentsProvider axisProvider) {
		if(axisProvider == this.columnProvider) {
			return this.verticalElements;
		} else if(axisProvider == this.rowProvider) {
			return this.horizontalElements;
		}
		return null;
	}

	@Override
	public boolean canReoderRows() {
		return this.rowManager.canReoderElements();
	}

	@Override
	public boolean canReorderColumns() {
		return this.columnManager.canReoderElements();
	}

	public void reorderColumnsElements(final IAxis axisToMove, final int newIndex) {
		final EditingDomain domain = getEditingDomain(axisToMove);
		final Command cmd = MoveCommand.create(getEditingDomain(axisToMove), this.columnProvider, NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis(), axisToMove, newIndex);
		domain.getCommandStack().execute(cmd);
	}

	//not tested
	public void reorderRowElements(final IAxis axisToMove, final int newIndex) {
		final EditingDomain domain = getEditingDomain(axisToMove);
		final Command cmd = MoveCommand.create(getEditingDomain(axisToMove), this.rowProvider, NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis(), axisToMove, newIndex);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#invertAxis()
	 * 
	 */
	public void invertAxis() {
		final CompoundCommand cmd = new CompoundCommand(Messages.NattableModelManager_SwitchLinesAndColumns);
		final EditingDomain domain = getEditingDomain(this.pTable);
		boolean oldValue = this.pTable.isInvertAxis();
		if(canInvertAxis()) {
			Command tmp = new SetCommand(domain, this.pTable, NattablePackage.eINSTANCE.getTable_InvertAxis(), !oldValue);
			cmd.append(tmp);
			domain.getCommandStack().execute(cmd);
		}
	}

	public boolean canInvertAxis() {
		return columnManager.canBeUsedAsRowManager() && rowManager.canBeUsedAsColumnManager();
	}


	public boolean declareEditorsOnColumns() {
		return true;
	}

	public boolean declareEditorsOnRows() {
		return false;
	}

	@Override
	public Table getTable() {
		return pTable;
	}

	public ITableAxisElementProvider getTableAxisElementProvider() {//FIXME : must be renamed?
		return this;
	}
}
