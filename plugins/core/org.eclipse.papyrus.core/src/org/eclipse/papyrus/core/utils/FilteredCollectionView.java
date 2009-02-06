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

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A unmodifiable view on a specified list. The view filters the original list according to the provided filter.
 */
public class FilteredCollectionView<T> extends AbstractCollection<T> implements Collection<T> {

	/** The original collection */
	private Collection<T> list;

	/** The filter for the view */
	private IFilter filter;

	/**
	 * The cached size. Compute only once, so change in the underlying collection is not reflected
	 */
	private int size = -1;

	/**
	 * Creates a new FilteredCollectionView.
	 * 
	 * @param list
	 *            the list to filter
	 * @param filter
	 *            the filter for the view
	 */
	public FilteredCollectionView(Collection<T> list, IFilter filter) {
		this.list = list;
		this.filter = filter;
	}

	/**
	 * Sets the value of the list property.
	 * 
	 * @param aList
	 *            the new value of the list property
	 */
	public void setBackupCollection(Collection<T> aList) {
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
	 * Returns the value of the filter property.
	 * 
	 * @return the new value of the filter property
	 */
	public IFilter getFilter() {
		return filter;
	}

	/**
	 * The size of the filtered list.
	 * 
	 * @return the number of elements in the filtered list
	 */
	@Override
	public int size() {
		if (size == -1) { // compute the size
			size = 0;
			Iterator<T> i = iterator();
			while (i.hasNext()) {
				size++;
				i.next();
			}
		}
		return size;
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. More formally, returns <tt>true</tt> if and only if this collection contains at least one element <tt>e</tt> such that
	 * <tt>(o==null ? e==null : o.equals(e))</tt>.
	 * <p>
	 * 
	 * @param o
	 *            object to be checked for containment in this collection.
	 * @return <tt>true</tt> if this collection contains the specified element.
	 */
	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation). More formally, removes an element <tt>e</tt> such that <tt>(o==null ? e==null :
	 * o.equals(e))</tt>, if the collection contains one or more such elements. Returns <tt>true</tt> if the collection contained the specified element (or equivalently, if the collection changed as a
	 * result of the call).
	 * <p>
	 * This implementation call the remove method on the underlying collection.
	 * <p>
	 * 
	 * @param o
	 *            element to be removed from this collection, if present.
	 * @return <tt>true</tt> if the collection contained the specified element.
	 * @throws UnsupportedOperationException
	 *             if the <tt>remove</tt> method is not supported by this collection.
	 */
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Return the value to be returned by the iterator.next() method. This method can be overloaded by subclasses in order to return another value than the objects belonging to the underlying list.
	 * 
	 * @param ele
	 *            The iterated object. This is the object iterated inside the underlying list.
	 * @return
	 */
	protected T returnedValue(T ele) {
		return ele;
	}

	/**
	 * listIterator.
	 * 
	 * @return ListIterator
	 */
	@Override
	public Iterator<T> iterator() {
		return new FilteredIterator();
	}

	/**
	 * Iterator other the filtered collection
	 */
	private class FilteredIterator implements Iterator<T> {

		/** the next object */
		T next;

		/** The original list iterator */
		Iterator<T> listIterator;

		/**
		 * Creates a new FilteredIterator
		 */
		public FilteredIterator() {
			listIterator = list.iterator();
			next = nextFilteredObject();
		}

		/**
		 * Unsupported operation, as this is just a view of a list.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/**
		 * Returns the next object of the list, when filter is applied
		 * 
		 * @return
		 */
		protected T nextFilteredObject() {
			while (listIterator.hasNext()) {
				T ele = listIterator.next();
				if (filter.isAllowed(ele)) {
					return returnedValue(ele);
				}
			} // end loop
			return null;
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
		 * Compute the next field (null or next value), and return the previous value of the next field.
		 * 
		 * @return Object
		 */
		public T next() {
			if (next == null) {
				throw new NoSuchElementException();
			}
			T ele = next;
			next = nextFilteredObject();
			return ele;
		}

	}

}
