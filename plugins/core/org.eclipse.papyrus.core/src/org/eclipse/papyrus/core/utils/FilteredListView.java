/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.utils;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A unmodifiable view on a specified list. The view filters the original list according to the
 * provided filter.
 */
// @unused
public class FilteredListView extends AbstractSequentialList<Object> implements List<Object> {

	/**
	 * 
	 */
	private List<Object> list;

	/**
	 * 
	 */
	private IFilter filter;

	/**
	 * The cached size. Copute only once, so change in the underlying collection is not reflected
	 */
	private int size = -1;

	/**
	 * 
	 * 
	 * @param filter
	 * @param list
	 */
	public FilteredListView(List<Object> list, IFilter filter) {
		this.list = list;
		this.filter = filter;
	}

	/**
	 * Sets the value of the list property.
	 * 
	 * @param aList
	 *            the new value of the list property
	 */
	public void setBackupList(List aList) {
		list = aList;
	}

	/**
	 * Sets the value of the filter property.
	 * 
	 * @param aFilter
	 *            the new value of the filter property
	 */
	public void setFilter(IFilter aFilter) {
		filter = aFilter;
	}

	/**
	 * size.
	 * 
	 * @return int
	 */
	@Override
	public int size() {
		if (size == -1) { // compute the size
			size = 0;
			Iterator<Object> i = iterator();
			while (i.hasNext()) {
				size++;
				i.next();
			}
		}
		return size;
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. More formally,
	 * returns <tt>true</tt> if and only if this collection contains at least one element <tt>e</tt>
	 * such that <tt>(o==null ? e==null : o.equals(e))</tt>.
	 * <p>
	 * 
	 * @param o
	 *            object to be checked for containment in this collection.
	 * 
	 * @return <tt>true</tt> if this collection contains the specified element.
	 */
	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present
	 * (optional operation). More formally, removes an element <tt>e</tt> such that
	 * <tt>(o==null ? e==null :
	 * o.equals(e))</tt>, if the collection contains one or more such elements. Returns
	 * <tt>true</tt> if the collection contained the specified element (or equivalently, if the
	 * collection changed as a result of the call).
	 * <p>
	 * 
	 * This implementation call the remove method on the underlying collection.
	 * <p>
	 * 
	 * @param o
	 *            element to be removed from this collection, if present.
	 * 
	 * @return <tt>true</tt> if the collection contained the specified element.
	 * 
	 * @throws UnsupportedOperationException
	 *             if the <tt>remove</tt> method is not supported by this collection.
	 */
	@Override
	public boolean remove(Object o) {
		// return list.remove(o);
		throw new UnsupportedOperationException();
	}

	/**
	 * listIterator.
	 * 
	 * @param index
	 *            int
	 * 
	 * @return ListIterator
	 */
	@Override
	public ListIterator<Object> listIterator(int index) {
		return new FilteredListIterator(index);
	}

	/**
	 * 
	 */
	private class FilteredListIterator implements ListIterator<Object> {

		/**
		 * 
		 */
		Object current;

		/**
		 * 
		 */
		Object next;

		/**
		 * 
		 */
		Object previous;

		/**
		 * Index of the current element (last returned) in the backup list.
		 */
		int currentIndex;

		/**
		 * 
		 */
		int previousIndex;

		/**
		 * 
		 */
		int nextIndex;

		/**
		 * Index of the last returned element.
		 */
		int eleIndex = -1;

		/**
		 * Index of the boundary.
		 */
		int index = 0;

		/**
		 * 
		 */
		ListIterator<Object> listIterator;

		/**
		 * 
		 * 
		 * @param index
		 */
		FilteredListIterator(int index) {
			listIterator = list.listIterator(0);
			nextIndex = -1;
			next = nextFilteredObject();

			previous = null;
			previousIndex = -1;
			current = next;
			currentIndex = 0;

			// Go to the specified index
			while (hasNext() && (nextIndex() < index)) {
				next();
			}
		}

		/**
		 * 
		 * 
		 * @return
		 */
		protected Object nextFilteredObject() {
			while (listIterator.hasNext()) {

				int curIndex = listIterator.nextIndex(); // This is the current
				// index in the list
				Object ele = listIterator.next();
				if (filter.isAllowed(ele) && (curIndex > nextIndex)) {
					nextIndex = curIndex;
					return ele;
				}
			} // end loop
			return null;
		}

		/**
		 * 
		 * 
		 * @return
		 */
		protected Object previousFilteredObject() {
			while (listIterator.hasPrevious()) {
				int curIndex = listIterator.previousIndex(); // This is the
				// current index
				// in the list
				Object ele = listIterator.previous();
				if (filter.isAllowed(ele) && (curIndex < previousIndex)) {
					previousIndex = curIndex;
					return ele;
				}
			} // end loop
			return null;
		}

		/**
		 * /** nextIndex.
		 * 
		 * @return int
		 */
		public int nextIndex() {
			return index;
		}

		/**
		 * previousIndex.
		 * 
		 * @return int
		 */
		public int previousIndex() {
			return index - 1;
		}

		/**
		 * remove.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/**
		 * hasNext.
		 * 
		 * @return boolean
		 */
		public boolean hasNext() {
			return next != null;
		}

		/**
		 * hasPrevious.
		 * 
		 * @return boolean
		 */
		public boolean hasPrevious() {
			return previous != null;
		}

		/**
		 * next.
		 * 
		 * @return Object
		 */
		public Object next() {
			if (next == null) {
				throw new NoSuchElementException();
			}

			if (index > eleIndex) { // previous was up, continue
				previous = current;
				previousIndex = currentIndex;
				current = next;
				currentIndex = nextIndex;
				next = nextFilteredObject();

				index++;
				eleIndex++;
				return current;
			} else { // previous was down, turn back
				index++;
				return current;
			}
		}

		/**
		 * previous.
		 * 
		 * @return Object
		 */
		public Object previous() {
			if (previous == null) {
				throw new NoSuchElementException();
			}

			if (index > eleIndex) { // previous was up, turn back
				index--;
				return current;
			} else { // previuos was done, continue
				next = current;
				nextIndex = currentIndex;
				current = previous;
				currentIndex = previousIndex;
				previous = previousFilteredObject();

				index--;
				eleIndex--;
				return current;

			}

		}

		/**
		 * add.
		 * 
		 * @param o
		 *            Object
		 */
		public void add(Object o) {
			throw new UnsupportedOperationException();
		}

		/**
		 * set.
		 * 
		 * @param o
		 *            Object
		 */
		public void set(Object o) {
			throw new UnsupportedOperationException();
		}

	}

}
