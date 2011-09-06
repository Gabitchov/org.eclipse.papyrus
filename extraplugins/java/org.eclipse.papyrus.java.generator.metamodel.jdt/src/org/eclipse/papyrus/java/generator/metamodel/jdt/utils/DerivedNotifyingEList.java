/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.metamodel.jdt.utils;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.NotifyingList;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;


/**
 * A List derived from an original list.
 * 
 * <br>
 * Some code from org.eclipse.emf.common.util.AbstractEList
 * 
 * @author cedric dumoulin
 * 
 * @param E
 *        Expected type of this derived list's item. I.e. the type returned by this list get() method.
 * @param T
 *        Type of the original list elements'
 */
public abstract class DerivedNotifyingEList<E, T> extends AbstractSequentialList<E> implements EList<E>, NotifyingList<E> {


	/**
	 * The original List
	 */
	protected NotifyingList<T> backupList;

	/**
	 * Notifier used to notify changes in the list
	 */
	private Object notifier;

	/**
	 * Feature in the list that correspond to the list.
	 */
	private Object feature;

	/**
	 * Feature ID
	 */
	private int featureID;

	/**
	 * Listener on backuplist.
	 * TODO : use weakreference in order to enable garbage on this class.
	 */
	private Adapter backupListChangeListener = new AdapterImpl() {

		/**
		 * Event receive when the backupList is changed.
		 * 
		 * @param msg
		 */
		@Override
		public void notifyChanged(Notification msg) {

			// Retains only changes from the backuplist
			if(msg.getNotifier() != backupList.getNotifier() || msg.getFeature() != backupList.getFeature()) {
				return;
			}

			// create a new Notification and throw event to its Notifier
			NotificationImpl newNotification = createNotification(msg);
			newNotification.dispatch();

		}
	};

	/**
	 * Constructor.
	 * The backupList is used as notifier. Feature is set to null and featureID to 0.
	 * 
	 */
	public DerivedNotifyingEList(NotifyingList<T> backupList) {

		this(backupList, backupList.getNotifier(), null, 0);
	}

	/**
	 * Constructor.
	 * 
	 * @param backupList
	 * @param notifier
	 * @param feature
	 * @param featureID
	 */
	public DerivedNotifyingEList(NotifyingList<T> backupList, Object feature, int featureID) {

		this(backupList, backupList.getNotifier(), feature, featureID);
	}

	/**
	 * Final Constructor. <br>
	 * Feature and featureID should be different from the backupList.feature and backupList.featureID
	 * 
	 * @param backupList
	 * @param notifier
	 * @param feature
	 *        The feature in the notifier that represent this list.
	 * @param featureID
	 *        The feature ID
	 */
	public DerivedNotifyingEList(NotifyingList<T> backupList, Object notifier, Object feature, int featureID) {

		// Check values
		if(feature == backupList.getFeature() || featureID == backupList.getFeatureID()) {
			throw new IllegalArgumentException("Feature and featureID should be different from the backupList.feature and backupList.featureID. ["
					+ feature + "=="
					+ backupList.getFeature() + " - "
					+ featureID + "=="
					+ backupList.getFeatureID()
					+ "]");
		}

		// Set properties
		this.backupList = backupList;
		this.notifier = notifier;
		this.feature = feature;
		this.featureID = featureID;
		attachListener();
	}

	/**
	 * Listen to changes in backupList.
	 */
	protected void attachListener() {
		((Notifier)notifier).eAdapters().add(backupListChangeListener);
	}

	/**
	 * @see org.eclipse.emf.common.notify.NotifyingList#getNotifier()
	 * 
	 * @return
	 */
	public Object getNotifier() {
		return notifier;
	}

	/**
	 * @see org.eclipse.emf.common.notify.NotifyingList#getFeature()
	 * 
	 * @return
	 */
	public Object getFeature() {
		return feature;
	}

	/**
	 * @see org.eclipse.emf.common.notify.NotifyingList#getFeatureID()
	 * 
	 * @return
	 */
	public int getFeatureID() {
		return featureID;
	}

	/**
	 * Creates a notification.
	 * 
	 * @param eventType
	 *        the type of change that has occurred.
	 * @param oldObject
	 *        the value of the notifier's feature before the change occurred.
	 * @param newObject
	 *        the value of the notifier's feature after the change occurred.
	 * @param index
	 *        the position at which the change occurred.
	 * @return a new notification.
	 */
	protected NotificationImpl createNotification(Notification origNotification)
	{

		return new NotificationImpl(origNotification.getEventType(), origNotification.getOldValue(), origNotification.getNewValue(), origNotification.getPosition(), origNotification.wasSet())
		{

			@Override
			public Object getNotifier()
			{
				return DerivedNotifyingEList.this.getNotifier();
			}

			@Override
			public Object getFeature()
			{
				return DerivedNotifyingEList.this.getFeature();
			}

			@Override
			public int getFeatureID(Class<?> expectedClass)
			{
				return DerivedNotifyingEList.this.getFeatureID();
			}
		};
	}

	public NotifyingList<T> getBackupList() {
		return backupList;
	}

	/**
	 * Get the object at the specified index in the backup list.
	 * Subclass should override in order to return the proper object.
	 * 
	 * @param index
	 * @return
	 */
	abstract protected E doGet(int index);

	/**
	 * @see org.eclipse.emf.common.util.EList#move(int, java.lang.Object)
	 * 
	 * @param newPosition
	 * @param object
	 */
	public void move(int newPosition, E object) {
		move(newPosition, indexOf(object));
	}

	/**
	 * @see org.eclipse.emf.common.util.EList#move(int, int)
	 * 
	 * @param newPosition
	 * @param oldPosition
	 * @return
	 */
	public E move(int newPosition, int oldPosition) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see java.util.AbstractCollection#size()
	 * 
	 * @return
	 */
	@Override
	public int size() {
		return backupList.size();
	}

	/**
	 * @see java.util.AbstractSequentialList#listIterator(int)
	 * 
	 * @param index
	 * @return
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return new DerivedListIterator(index);
	}

	/**
	 * 
	 * 
	 * @param <E>
	 */
	public class DerivedListIterator implements ListIterator<E> {

		/**
		 * The current position of the iterator.
		 */
		protected int cursor = 0;

		/**
		 * The previous position of the iterator.
		 */
		protected int lastCursor = -1;

		/**
		 * The modification count of the containing list.
		 */
		protected int expectedModCount = modCount;


		/**
		 * Creates an instance advanced to the index.
		 * 
		 * @param index
		 *        the starting index.
		 */
		public DerivedListIterator(int index)
		{
			cursor = index;
		}

		/**
		 * Returns whether there are more objects.
		 * 
		 * @return whether there are more objects.
		 */
		public boolean hasNext()
		{
			return cursor != size();
		}

		/**
		 * Returns the next object and advances the iterator.
		 * This implementation delegates to {@link #doNext doNext}.
		 * 
		 * @return the next object.
		 * @exception NoSuchElementException
		 *            if the iterator is done.
		 */
		public E next()
		{
			try
			{
				E next = doGet(cursor);
				lastCursor = cursor++;
				return next;
			} catch (IndexOutOfBoundsException exception)
			{
				throw new NoSuchElementException();
			}
		}

		/**
		 * Returns whether there are more objects for {@link #previous}.
		 * Returns whether there are more objects.
		 */
		public boolean hasPrevious()
		{
			return cursor != 0;
		}

		/**
		 * Returns the previous object and advances the iterator.
		 * This implementation delegates to {@link #doPrevious doPrevious}.
		 * 
		 * @return the previous object.
		 * @exception NoSuchElementException
		 *            if the iterator is done.
		 */
		public E previous()
		{
			try
			{
				E previous = doGet(--cursor);
				lastCursor = cursor;
				return previous;
			} catch (IndexOutOfBoundsException exception)
			{
				throw new NoSuchElementException();
			}
		}

		/**
		 * Returns the index of the object that would be returned by calling {@link #next() next}.
		 * 
		 * @return the index of the object that would be returned by calling <code>next</code>.
		 */
		public int nextIndex()
		{
			return cursor;
		}

		/**
		 * Returns the index of the object that would be returned by calling {@link #previous previous}.
		 * 
		 * @return the index of the object that would be returned by calling <code>previous</code>.
		 */
		public int previousIndex()
		{
			return cursor - 1;
		}

		/**
		 * Sets the object at the index of the last call to {@link #next() next} or {@link #previous previous}.
		 * This implementation delegates to {@link AbstractEList#set set}.
		 * 
		 * @param object
		 *        the object to set.
		 * @exception IllegalStateException
		 *            if <code>next</code> or <code>previous</code> have not yet been called,
		 *            or {@link #remove(Object) remove} or {@link #add add} have already been called
		 *            after the last call to <code>next</code> or <code>previous</code>.
		 */
		public void set(E object)
		{
			throw new UnsupportedOperationException();
		}

		/**
		 * Adds the object at the {@link #next() next} index and advances the iterator past it.
		 * This implementation delegates to {@link #doAdd(Object) doAdd(E)}.
		 * 
		 * @param object
		 *        the object to add.
		 */
		public void add(E object)
		{
			throw new UnsupportedOperationException();
		}

		/**
		 * @see java.util.ListIterator#remove()
		 * 
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
