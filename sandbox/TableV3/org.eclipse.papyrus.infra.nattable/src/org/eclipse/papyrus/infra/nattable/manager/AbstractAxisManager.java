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
package org.eclipse.papyrus.infra.nattable.manager;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.swt.widgets.Display;


public abstract class AbstractAxisManager implements IAxisManager {

	/** the id of this manager */
	private String manager_id;

	/**
	 * the managed table
	 */
	private Table pTable; //FIXME : this field should be removed

	/**
	 * the represented axis provider
	 */
	private IAxisContentsProvider representedContentProvider;

	/**
	 * the global manager for the table
	 */
	private ILimitedNattableModelManager tableManager;

	/**
	 * the listener on the axis
	 */
	protected Adapter axisListener;

	/**
	 * 
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#init(org.eclipse.papyrus.infra.nattable.manager.INattableModelManager,
	 *      java.lang.String, org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider, boolean)
	 * 
	 * @param manager
	 *        the globale table manager
	 * @param managerId
	 *        the id of this manager
	 * @param table
	 *        //FIXME : this arg must be remove
	 *        the managed table
	 * @param provider
	 *        the represented axis provider
	 */
	public void init(final INattableModelManager manager, final String managerId, final Table table, final IAxisContentsProvider provider, boolean mustRefreshOnAxisChanges) {
		this.tableManager = manager;
		this.manager_id = managerId;
		this.pTable = table;
		this.representedContentProvider = provider;
		updateAxisContents();
		if(mustRefreshOnAxisChanges) {
			this.axisListener = new AdapterImpl() {

				@Override
				public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
					//FIXME : Here, this is a 2 asynExec... we must do refresh on the command stack event
					Display.getDefault().asyncExec(new Runnable() {

						public void run() {
							updateAxisContents();
						}
					});

					//FIXME this line must be removed when we will use GlazedList
					((NattableModelManager)getTableManager()).refreshNattable();

				};
			};
			this.representedContentProvider.eAdapters().add(this.axisListener);
		}
	}

	/**
	 * this methods must be used to update the contents of the rows or columns element
	 */
	public synchronized void updateAxisContents() {
		//must be overriden
		//code example :
		//		getTableManager().getColumnElementsList().add(anObject);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#canInsertAxis(java.util.Collection, int)
	 * 
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#canDropAxisElement(java.util.Collection)
	 * 
	 * @param objectsToAdd
	 * @return
	 */
	public boolean canDropAxisElement(Collection<Object> objectsToAdd) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 * 
	 */
	public void dispose() {
		if(this.axisListener != null) {
			this.representedContentProvider.eAdapters().remove(this.axisListener);
			this.axisListener = null;
		}
		this.pTable = null;
		this.representedContentProvider = null;
		this.tableManager = null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#getManagerId()
	 * 
	 * @return
	 */
	public String getManagerId() {
		return this.manager_id;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#canBeUsedAsRowManager()
	 * 
	 * @return
	 */
	public boolean canBeUsedAsRowManager() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#canBeUsedAsColumnManager()
	 * 
	 * @return
	 */
	public boolean canBeUsedAsColumnManager() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain, java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#getInsertAxisCommand(java.util.Collection, int)
	 * 
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	public Command getInsertAxisCommand(Collection<Object> objectsToAdd, int index) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#isComposite()
	 * 
	 * @return
	 */
	public boolean isComposite() {
		return false;
	}

	//FIXME must be protected
	public Table getTable() {
		return this.pTable;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#getRepresentedContentProvider()
	 * 
	 * @return
	 */
	public IAxisContentsProvider getRepresentedContentProvider() {
		return this.representedContentProvider;
	}

	//FIXME : must be protected
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#getTableManager()
	 * 
	 * @return
	 */
	public ILimitedNattableModelManager getTableManager() {
		return this.tableManager;
	}

	//FIXME?
	//	public final boolean isUsedVertically() {
	//		return getTable().getVerticalContentProvider() == getRepresentedContentProvider();
	//	}

	//	//FIXME?
	//	public final boolean isUsedHorizontally() {
	//		return getTable().getHorizontalContentProvider() == getRepresentedContentProvider();
	//	}
	//
	//	//FIXME?
	//	public Object getHeaderDataValue(final int columnIndex, final int rowIndex) {
	//		return null;
	//
	//	}

	//FIXME?
	public void setHeaderDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	//FIXME?
	public List<?> getAllCurrentPossibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	protected boolean hasDefaultConfiguration() {
		final TableEditorConfiguration configuration = getTable().getEditorConfiguration().getDefaultTableEditorConfiguration();
		return hasAxisConfiguration(configuration);
	}

	protected boolean hasLocalConfiguration() {
		final LocalTableEditorConfiguration configuration = getTable().getEditorConfiguration();
		return hasAxisConfiguration(configuration);
	}

	protected boolean hasAxisConfiguration(final TableEditorConfiguration configuration) {
		IAxisContentsProvider axisConfig = null;
		//we are working with the horizontal content provider
		if(getTable().getHorizontalContentProvider() == getRepresentedContentProvider()) {
			axisConfig = configuration.getDefaultHorizontalContentProvider();
		} else {//we are working with the 
			axisConfig = configuration.getDefaultVerticalContentProvider();
		}
		if(axisConfig != null) {
			return !axisConfig.getAxis().isEmpty();
		}
		return false;
	}

	protected boolean hasConfiguration() {
		return hasDefaultConfiguration() || hasLocalConfiguration();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.IAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return <code>true</code> if the object is not yet represented by an axis
	 */
	public boolean isAllowedContents(Object object) {
		return !getTableManager().getElementsList(getRepresentedContentProvider()).contains(object);
	}

	public boolean canReoderElements() {
		return true;
	}
}
