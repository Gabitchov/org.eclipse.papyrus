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
package org.eclipse.papyrus.infra.nattable.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.nebula.widgets.nattable.sort.SortDirectionEnum;
import org.eclipse.papyrus.infra.nattable.comparator.RowComparator;
import org.eclipse.papyrus.infra.nattable.manager.axis.ICompositeAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.tools.comparator.CompositeComparator;


public class ColumnSortModel implements IPapyrusSortModel {


	/**
	 * the list of the sorted columns, in the order of the sort
	 */
	private final List<Object> sortedColumns = new ArrayList<Object>();

	/**
	 * the sorted columns associated to their direction
	 */
	private final Map<Object, SortDirectionEnum> sortedColumnsAndDirection = new HashMap<Object, SortDirectionEnum>();

	/**
	 * the table manager
	 */
	private INattableModelManager tableManager;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tableManager
	 *        the table manager to use
	 */
	public ColumnSortModel(final INattableModelManager tableManager) {
		this.tableManager = tableManager;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.sort.ISortModel#getSortedColumnIndexes()
	 * 
	 * @return
	 */
	@Override
	public List<Integer> getSortedColumnIndexes() {
		final List<Integer> sortedColumnsIndex = new ArrayList<Integer>();
		for(final Object current : sortedColumns) {
			sortedColumnsIndex.add(getColumnIndex(current));
		}
		return sortedColumnsIndex;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.sort.ISortModel#isColumnIndexSorted(int)
	 * 
	 * @param columnIndex
	 * @return
	 */
	@Override
	public boolean isColumnIndexSorted(int columnIndex) {
		return sortedColumns.contains(getObject(columnIndex));
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.sort.ISortModel#getSortDirection(int)
	 * 
	 * @param columnIndex
	 * @return
	 */
	@Override
	public SortDirectionEnum getSortDirection(int columnIndex) {
		Object object = getObject(columnIndex);
		SortDirectionEnum direction = sortedColumnsAndDirection.get(object);
		if(direction == null) {
			direction = SortDirectionEnum.NONE;
		}
		return direction;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.sort.ISortModel#getSortOrder(int)
	 * 
	 * @param columnIndex
	 * @return
	 */
	@Override
	public int getSortOrder(int columnIndex) {
		final Object obj = getObject(columnIndex);
		return this.sortedColumns.indexOf(obj);
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.sort.ISortModel#getComparatorsForColumnIndex(int)
	 * 
	 * @param columnIndex
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<Comparator> getComparatorsForColumnIndex(int columnIndex) {
		Comparator comp = new RowComparator(getObject(columnIndex), sortedColumnsAndDirection.get(getObject(columnIndex)), tableManager);
		return Collections.singletonList(comp);
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.sort.ISortModel#sort(int, org.eclipse.nebula.widgets.nattable.sort.SortDirectionEnum, boolean)
	 * 
	 * @param columnIndex
	 * @param sortDirection
	 * @param accumulate
	 */
	@Override
	public void sort(int columnIndex, SortDirectionEnum sortDirection, boolean accumulate) {
		final Object columnElement = getObject(columnIndex);

		if(!accumulate) {
			clear();
		}

		this.sortedColumns.remove(columnElement);
		this.sortedColumnsAndDirection.remove(columnElement);
		if(sortDirection != SortDirectionEnum.NONE) {
			this.sortedColumnsAndDirection.put(columnElement, sortDirection);
			this.sortedColumns.add(0, columnElement);
		}
		List<Comparator<Object>> comparators = new ArrayList<Comparator<Object>>();
		for(final Object current : sortedColumns) {
			Comparator<Object> newOne = new RowComparator(current, this.sortedColumnsAndDirection.get(current), tableManager);
			comparators.add(newOne);
		}
		setAxisComparator();
	}

	/**
	 * set the axis comparator (the sort is done by the manager when we change its comparator)
	 */
	protected void setAxisComparator() {
		final Comparator<Object> comp = createComparator();
		final ICompositeAxisManager manager = (ICompositeAxisManager)tableManager.getRowAxisManager();
		manager.setAxisComparator(comp);//the sort is done by the manager when we change its comparator
	}

	/**
	 * 
	 * @return
	 *         the created axis comparator to use or <code>null</code>
	 */
	protected final Comparator<Object> createComparator() {
		List<Comparator<Object>> comparators = new ArrayList<Comparator<Object>>();
		for(final Object current : sortedColumns) {
			Comparator<Object> newOne = new RowComparator(current, this.sortedColumnsAndDirection.get(current), tableManager);
			comparators.add(newOne);
		}

		final Comparator<Object> comp;
		if(comparators.isEmpty()) {
			comp = null;
		} else {
			comp = new CompositeComparator<Object>(comparators);
		}
		return comp;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.sort.ISortModel#clear()
	 * 
	 */
	@Override
	public void clear() {
		sortedColumns.clear();
		sortedColumnsAndDirection.clear();
	}

	/**
	 * 
	 * @param columnIndex
	 * @return
	 */
	private Object getObject(int columnIndex) {
		return tableManager.getColumnElement(columnIndex);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	private int getColumnIndex(final Object object) {
		return tableManager.getColumnElementsList().indexOf(object);
	}

	/**
	 * clear the comparator list, according to the removed columns
	 */
	public void updateSort() {
		final ListIterator<Object> iterator = this.sortedColumns.listIterator();
		while(iterator.hasNext()) {
			final Object current = iterator.next();
			if(-1 == tableManager.getColumnElementsList().indexOf(current)) {
				iterator.remove();
				this.sortedColumnsAndDirection.remove(current);
				this.sortedColumns.remove(current);
			}
		}
		setAxisComparator();
	}

}
