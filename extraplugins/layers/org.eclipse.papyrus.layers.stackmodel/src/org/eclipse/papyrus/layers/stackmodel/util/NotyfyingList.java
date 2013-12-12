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

package org.eclipse.papyrus.layers.stackmodel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

/**
 * A delegate list  notifying of events on the delegated list.
 * The following events are notified:
 * <ul>
 *   <li>elements added</li>
 *   <li>elements removed</li>
 *   <li></li>
 *   <li></li>
 * </ul>
 * @author cedric dumoulin
 *
 */
public class NotyfyingList<E> extends ForwardingList<E>{

	protected List<E> delegate;
	
	protected EventBus eventBus = new EventBus(NotyfyingList.class.getName());
	
	/**
	 * Constructor.
	 *
	 * @param delegate
	 */
	public NotyfyingList(List<E> delegate) {
		this.delegate = delegate;
	}

	@Override
	protected List<E> delegate() {
		return delegate;
	}

	/**
	 * @return the eventBus
	 */
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public boolean add(E element) {
		boolean isModified = delegate().add( element);
		if( isModified) {
			eventBus.post(new NotifyingListEvent(element));
		}

		return isModified;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> collection) {
		boolean isModified = delegate().addAll(collection);
		if( isModified) {
			eventBus.post(new NotifyingListEvent(collection));
		}
		
		return isModified;
	}
	
	@Override
	public void add(int index, E element) {
		delegate().add(index, element);
		eventBus.post(new NotifyingListEvent(element));
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends E> elements) {
		// TODO Auto-generated method stub
		boolean isModified = delegate().addAll(index, elements);
		if( isModified) {
			eventBus.post(new NotifyingListEvent(elements));
		}
		
		return isModified;
	}
	
	@Override
	public E remove(int index) {
		E removed = super.remove(index);
		getEventBus().post( new NotifyingListEvent(null, removed));
		
		return removed;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object object) {
		boolean isRemoved = super.remove(object);
		if( isRemoved ) {
		  getEventBus().post( new NotifyingListEvent(null, (E)object));
		}
		return isRemoved;
	}
	
	/**
	 * 
	 * @see com.google.common.collect.ForwardingCollection#removeAll(java.util.Collection)
	 *
	 * @param collection
	 * @return
	 */
	@Override
	public boolean removeAll(Collection<?> collection) {
		// Compute the removed elements (for the events)
		List<E> removedElements  = Lists.newArrayList(delegate());
		removedElements.retainAll(collection);
				
		// Do remove
		boolean isRemoved = super.removeAll(collection);
		if( isRemoved ) {
		  getEventBus().post( new NotifyingListEvent(null, (Collection<? extends E>) removedElements));
		}
		return isRemoved;
	}
	
	/**
	 * Reset the collection to the specified collection.
	 * Throw events containing the added and removed elements.
	 * 
	 * @param collection
	 * @return
	 */
	public boolean resetTo(Collection<? extends E> collection ) {
		
		// Compute removed and added
		Collection<E> elementsToRemove = new ArrayList<E>();
		Collection<E> elementsToAdd = new ArrayList<E>();
		
		// Cached list of attached elements
		Collection<? extends E> attachedElements = delegate();
		
		// Compute added and removed elements. Walk both list 2 times. 
		// This could certainly be improved.
		// TODO improve the algorithm

		// Compute added elements
		for( E o : collection ) {
			if( !attachedElements.contains(o)) {
				elementsToAdd.add(o);
				continue;
			}
		}
		
		// Compute removed elements
		for( E o : attachedElements ) {
			if( !collection.contains(o)) {
				elementsToRemove.add(o);
				continue;
			}
		}
		
		// Change the list
		delegate().clear();
		delegate().addAll(collection);
		
		// Fire event
		boolean isModified = !(elementsToAdd.isEmpty() && elementsToRemove.isEmpty() );
		if( isModified ) {
		  getEventBus().post( new NotifyingListEvent(elementsToAdd, elementsToRemove));
		}

		return isModified;
	}
	
	/**
	 * Event used to specify that the list is changed
	 * @author cedric dumoulin
	 *
	 */
	public class NotifyingListEvent {
		
		Collection<? extends E> addedElements = Collections.emptyList();
		Collection<? extends E> removedElements = Collections.emptyList();
		
		/**
		 * 
		 * Constructor.
		 *
		 */
		public NotifyingListEvent() {
			this.addedElements = Collections.emptyList();
			this.removedElements = Collections.emptyList();
		}
		
		/**
		 * 
		 * Constructor.
		 *
		 */
		public NotifyingListEvent(Collection<? extends E> addedElements) {
			if( addedElements!=null ) {
				this.addedElements = addedElements;
			}
			else {
				this.addedElements = Collections.emptyList();
			}
			
			this.removedElements = Collections.emptyList();
		}
		
		/**
		 * Constructor.
		 *
		 * @param addedElements added elements or null
		 * @param removedElements removed elements or null
		 */
		public NotifyingListEvent(Collection<? extends E> addedElements, Collection<? extends E> removedElements) {
			if( addedElements!=null ) {
				this.addedElements = addedElements;
			}
			else {
				this.addedElements = Collections.emptyList();
			}
			
			if( removedElements != null ) {
				this.removedElements = removedElements;
			}
			else {
				this.removedElements = Collections.emptyList();
			}
		}

		/**
		 * 
		 * Constructor.
		 *
		 * @param addedElement An element added or null;
		 * @param removedElement An element added or null
		 */
		public NotifyingListEvent( E addedElement, E removedElement) {
			
			if( addedElement!=null ) {
				addedElements = Collections.singletonList(addedElement);
			}
			else {
				addedElements = Collections.emptyList();
			}
			
			if( removedElement != null ) {
				removedElements = Collections.singletonList(removedElement);
			}
			else {
				removedElements = Collections.emptyList();
			}
		}

		/**
		 * 
		 * Constructor.
		 *
		 * @param addedElement An element added or null;
		 */
		public NotifyingListEvent( E addedElement) {

			if( addedElement!=null ) {
				addedElements = Collections.singletonList(addedElement);
			}
			else {
				addedElements = Collections.emptyList();
			}
			removedElements = Collections.emptyList();
		}

		/**
		 * @return the addedElements
		 */
		public Collection<? extends E> getAddedElements() {
			return addedElements;
		}

//		/**
//		 * @param addedElements the addedElements to set
//		 */
//		public void setAddedElements(List<E> addedElements) {
//			this.addedElements = addedElements;
//		}
//
//		/**
//		 * @param addedElements the addedElements to set
//		 */
//		public void setAddedElements(E addedElement) {
//			this.addedElements = Collections.singletonList(addedElement);
//		}

		/**
		 * @return the removedElements
		 */
		public Collection<? extends E> getRemovedElements() {
			return removedElements;
		}

//		/**
//		 * @param removedElements the removedElements to set
//		 */
//		public void setRemovedElements(List<E> removedElements) {
//			this.removedElements = removedElements;
//		}
//		
//		/**
//		 * @param removedElements the removedElements to set
//		 */
//		public void setRemovedElements(E removedElement) {
//			this.removedElements = Collections.singletonList(removedElement);
//		}
	}
}
