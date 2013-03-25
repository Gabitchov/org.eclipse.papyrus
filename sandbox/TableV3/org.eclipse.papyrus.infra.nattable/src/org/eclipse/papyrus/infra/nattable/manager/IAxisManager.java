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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.ui.services.IDisposable;

public interface IAxisManager extends IDisposable {

	/**
	 * 
	 * @return the id of the manager
	 */
	public String getManagerId();

	/**
	 * 
	 * @return <code>true</code> if the manager can be used horizontally
	 */
	public boolean canBeUsedAsRowManager();

	/**
	 * 
	 * @return <code>true</code> if the manager can be used vertically
	 */
	public boolean canBeUsedAsColumnManager();

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add
	 * @return the command to add an axis to the emf model
	 */
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add
	 * @return the complementary command, which is called by the master on the
	 *         slave to add required axis
	 */
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);

	public void init(final INattableModelManager manager, String managerId, final Table table, final AbstractAxisProvider provider, boolean mustRefreshOnAxisChanges);

	public void setHeaderDataValue(int columnIndex, int rowIndex, Object newValue);

	public boolean isComposite();

	public Table getTable();;

	public AbstractAxisProvider getRepresentedContentProvider();;

	public ILimitedNattableModelManager getTableManager();


	/**
	 * 
	 * @return
	 *         all the elements which can be used as axis according to the current table contents
	 */
	public List<?> getAllPossibleAxisForTheTableContents();

	/**
	 * 
	 * @return
	 *         all the existing axis managed by the axis manager
	 */
	public Collection<Object> getAllExistingAxis();
	
	// public boolean isUsedVertically();
	//
	// public boolean isUsedHorizontally();

	// public boolean isMaster();

	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index);

	public boolean canDropAxisElement(Collection<Object> objectsToAdd);

	public Command getInsertAxisCommand(Collection<Object> objectsToAdd, int index);

	public void updateAxisContents();

	public boolean isAllowedContents(final Object object);

	/**
	 * 
	 * @return <code>true</code> if we can reorder the elements on the axis
	 */
	public boolean canReoderElements();


	public IRestrictedContentProvider createDestroyColumnsContentProvider(boolean isRestricted);


	/**
	 * 
	 * @param alpabeticOrder
	 *        <code>true</code> if we sort the axis by alphabetic order, <code>false</code> if not
	 * @param iConfigRegistry
	 *        the config registry used to find the label provider
	 */
	public void sortAxisByName(final boolean alpabeticOrder, IConfigRegistry iConfigRegistry);

	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy);



}
