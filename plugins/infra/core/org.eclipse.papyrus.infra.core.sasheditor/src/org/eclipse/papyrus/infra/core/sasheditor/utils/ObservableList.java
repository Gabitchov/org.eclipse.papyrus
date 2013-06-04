/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.sasheditor.utils;

import java.util.ArrayList;
import java.util.List;


/**
 * A generic list that can be observed.
 * 
 * @author cedric dumoulin
 *
 */
public class ObservableList<T> extends ArrayList<T> implements IObservableList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** List of listeners */
	private List<IObservableListListener<T>> listeners = new ArrayList<IObservableListListener<T>>();

	/**
	 * Constructor.
	 *
	 */
	public ObservableList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param initialCapacity
	 */
	public ObservableList(int initialCapacity) {
		super(initialCapacity);
	}

	
	/**
	 * For testing purpose.
	 * @return the listeners
	 */
	protected List<IObservableListListener<T>> getListeners() {
		return listeners;
	}

	/**
	 * Add a listener on list change event event.
	 * @see org.eclipse.papyrus.infra.core.sasheditor.utils.IObservableList#addListener(org.eclipse.papyrus.infra.core.sasheditor.utils.IObservableListListener)
	 * 
	 * @param listener
	 */
	public void addListener(IObservableListListener<T> listener) {
		// no duplicate
		if(listeners.contains(listener))
			return;
		listeners.add(listener);
	}

	/**
	 * Remove a listener on the list.
	 * @see org.eclipse.papyrus.infra.core.sasheditor.utils.IObservableList#removeListener(org.eclipse.papyrus.infra.core.sasheditor.utils.IObservableListListener)
	 * 
	 * @param listener
	 */
	public void removeListener(IObservableListListener<T> listener) {
		listeners.remove(listener);
	}


	/**
	 * Notify all listener with event.
	 * @param element The newly added element
	 */
	public void fireElementAddedEvent(T element) {
		// Fire events to internal listeners
		for(IObservableListListener<T> listener : listeners) {
			listener.elementAdded(element);
		}
	}

	/**
	 * Notify all listener with event.
	 * @param element The removed element.
	 */
	public void fireElementRemovedEvent(T element) {
		// Fire events to internal listeners
		for(IObservableListListener<T> listener : listeners) {
			listener.elementRemoved(element);
		}
	}

	/**
	 * Add the element, and fire the appropriate event.
	 * @see java.util.ArrayList#add(java.lang.Object)
	 *
	 * @param e
	 * @return
	 */
	@Override
	public boolean add(T e) {
		boolean res = super.add(e);
		fireElementAddedEvent(e);
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		boolean res = super.remove(o);
		fireElementRemovedEvent((T)o);
		return res;
	}
}
