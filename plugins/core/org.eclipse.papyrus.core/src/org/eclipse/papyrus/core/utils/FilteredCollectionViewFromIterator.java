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
//Source file: H:\\temp\\generated\\modTransf\\util\\FilteredListView.java
package org.eclipse.papyrus.core.utils;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A unmodifiable view on a specified list from its iterator. The view filters the original list according to the provided filter.
 * 
 * @param <E>
 *            the type of objects in the filtered collection
 */
public class FilteredCollectionViewFromIterator<E> extends AbstractCollection<E> implements Collection<E> {

	/**
	 * The iterator provider linked to the backup list.
	 */
	private IteratorProvider<E> iter;

	/**
	 * 
	 */
	private IFilter filter;

	/**
	 * The cached size. Compute only once, so change in the underlying collection is not reflected
	 */
	private int size = -1;

	/**
	 * 
	 * 
	 * @param filter
	 * @param list 	 *
	 * @param iter
	 */
	public FilteredCollectionViewFromIterator(IteratorProvider<E> iter, IFilter filter) {
		this.iter = iter;
		this.filter = filter;
	}

	/**
	 * Sets the value of the list property.
	 * 
	 * @param iter
	 *            the new value of the list property
	 */
	public void setBackupCollection(IteratorProvider<E> iter) {
		this.iter = iter;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	Iterator<E> getBackupIterator() {
		return iter.iterator();
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
	 * Sets the value of the filter property.
	 * 
	 * @return the new value of the filter property
	 */
	public IFilter getFilter() {
		return filter;
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
			Iterator<E> i = iterator();
			while (i.hasNext()) {
				size++;
				i.next();
			}
		}
		return size;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation). More formally, removes an element <tt>e</tt> such that <tt>(o==null ? e==null :
	 * o.equals(e))</tt>, if the collection contains one or more such elements. Returns <tt>true</tt> if the collection contained the specified element (or equivalently, if the collection changed as a
	 * result of the call).
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
	 * Return the value to be returned by the iterator.next() method. This method can be overloaded by subclasses in order to return another value than the objects belonging to the underlying list.
	 * 
	 * @param ele
	 *            The iterated object. This is the object iterated inside the underlying list.
	 * 
	 * @return
	 */
	protected E returnedValue(E ele) {
		return ele;
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
	public Iterator<E> iterator() {
		return new FilteredIterator();
	}

	/**
	 * 
	 */
	private class FilteredIterator implements Iterator<E> {

		/**
		 * 
		 */
		E next;

		/**
		 * 
		 */
		Iterator<E> listIterator;

		/**
		 * 
		 */
		public FilteredIterator() {
			listIterator = getBackupIterator();
			next = nextFilteredObject();
		}

		/**
		 * remove.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * 
		 * @return
		 */
		protected E nextFilteredObject() {
			while (listIterator.hasNext()) {
				E ele = listIterator.next();
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
		public E next() {
			if (next == null) {
				throw new NoSuchElementException();
			}
			E ele = next;
			next = nextFilteredObject();
			return ele;
		}

	}

	/**
	 * Inner class. Provide an iterator used internally in the unmodifiable collection view..
	 */
	public interface IteratorProvider<E> {

		/**
		 * provide a new iterator over the list.
		 * 
		 * @return
		 */
		Iterator<E> iterator();
	}

}
