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
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.ui.services.IDisposable;

public interface IAxisManager extends IDisposable {

	/**
	 * 
	 * @return
	 *         the id of the manager
	 */
	public String getManagerId();

	/**
	 * 
	 * @return
	 *         <code>true</code> if the manager can be used horizontally
	 */
	public boolean canBeUsedAsRowManager();

	/**
	 * 
	 * @return
	 *         <code>true</code> if the manager can be used vertically
	 */
	public boolean canBeUsedAsColumnManager();

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add
	 * @return
	 *         the command to add an axis to the emf model
	 */
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add
	 * @return
	 *         the complementary command, which is called by the master on the slave to add required axis
	 */
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);


	public void init(final INattableModelManager manager, String managerId, final Table table, final IAxisContentsProvider provider, boolean mustRefreshOnAxisChanges);

	//	public Object getHeaderDataValue(int columnIndex, int rowIndex);

	//	public int getHeaderColumnCount();
	//
	//	public int getHeaderRowCount();

	public void setHeaderDataValue(int columnIndex, int rowIndex, Object newValue);

	public boolean isComposite();

	public Table getTable();;

	public IAxisContentsProvider getRepresentedContentProvider();;

	public ILimitedNattableModelManager getTableManager();





	//	public List<?> getAllVisibleAxis();

	public List<?> getAllCurrentPossibleAxis();

	//	public List<?> getAllExistingAxis();


	//	public IContentProvider getFlatContentProvider();
	//
	//	public IContentProvider getHierarchicalContentProvider();

	//	public boolean isUsedVertically();
	//
	//	public boolean isUsedHorizontally();

	//	public boolean isMaster();

	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index);


	public boolean canDropAxisElement(Collection<Object> objectsToAdd);


	public Command getInsertAxisCommand(Collection<Object> objectsToAdd, int index);

	public void updateAxisContents();

	//	public int getHeaderColumnCount() {
	//		// TODO Auto-generated method stub
	//		return 0;
	//	}
	//
	//	public int getHeaderRowCount() {
	//		// TODO Auto-generated method stub
	//		return 0;
	//	}

	//	public List<?> getAllVisibleAxis() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//	public List<?> getAllExistingAxis() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

	public boolean isAllowedContents(final Object object);

	/**
	 * 
	 * @return
	 *         <code>true</code> if we can reorder the elements on the axis
	 */
	public boolean canReoderElements();
}
