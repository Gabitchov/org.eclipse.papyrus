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
package org.eclipse.papyrus.infra.nattable.manager.axis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;

public abstract class AbstractAxisManager implements IAxisManager {

	/**
	 * the represented axis manager
	 */
	protected AxisManagerRepresentation representedAxisManager;

	/**
	 * the represented axis provider
	 */
	private AbstractAxisProvider representedContentProvider;

	/**
	 * the global manager for the table
	 */
	protected INattableModelManager tableManager;

	/**
	 * the listener on the axis
	 */
	protected Adapter axisListener;

	/**
	 * 
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#init(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager,
	 *      java.lang.String, org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider)
	 * 
	 * @param manager
	 *        the globale table manager
	 * @param provider
	 *        the represented axis provider
	 * @param managerId
	 *        the id of this manager
	 */
	public void init(final INattableModelManager manager, final AxisManagerRepresentation rep, final AbstractAxisProvider provider) {
		this.tableManager = manager;
		this.representedAxisManager = rep;
		this.representedContentProvider = provider;

		this.axisListener = new AdapterImpl() {

			@Override
			public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
				getTableManager().updateAxisContents(getRepresentedContentProvider());
			}
		};
		this.representedContentProvider.eAdapters().add(this.axisListener);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getTableManager()
	 * 
	 * @return
	 */
	public NattableModelManager getTableManager() {
		return (NattableModelManager)this.tableManager;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canInsertAxis(java.util.Collection, int)
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDropAxisElement(java.util.Collection)
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
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canBeUsedAsRowManager()
	 * 
	 * @return
	 */
	public boolean canBeUsedAsRowManager() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canBeUsedAsColumnManager()
	 * 
	 * @return
	 */
	public boolean canBeUsedAsColumnManager() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getInsertAxisCommand(java.util.Collection, int)
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getRepresentedContentProvider()
	 * 
	 * @return
	 */
	public AbstractAxisProvider getRepresentedContentProvider() {
		return this.representedContentProvider;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#setHeaderDataValue(int, int, java.lang.Object)
	 * 
	 * @param columnIndex
	 * @param rowIndex
	 * @param newValue
	 */
	public void setHeaderDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return <code>true</code> if the object is not yet represented by an axis
	 */
	public boolean isAllowedContents(Object object) {
		return !getTableManager().getElementsList(getRepresentedContentProvider()).contains(object);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canReoderElements()
	 * 
	 * @return
	 */
	public boolean canReoderElements() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#createDestroyColumnsContentProvider(boolean)
	 * 
	 * @param isRestricted
	 * @return
	 */
	public IRestrictedContentProvider createDestroyColumnsContentProvider(boolean isRestricted) {
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToDestroy
	 * @return
	 */
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy) {
		return null;
	}


	/**
	 * 
	 * @return
	 *         the context of the managed table
	 */
	protected final EObject getTableContext() {
		return getTableManager().getTable().getContext();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAllManagedAxis()
	 * 
	 * @return
	 */
	public Collection<Object> getAllManagedAxis() {
		Set<Object> eObjects = new HashSet<Object>();
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			if(current.getManager() == this.representedAxisManager) {
				eObjects.add(current.getElement());
			}
		}
		return eObjects;
	}
}
