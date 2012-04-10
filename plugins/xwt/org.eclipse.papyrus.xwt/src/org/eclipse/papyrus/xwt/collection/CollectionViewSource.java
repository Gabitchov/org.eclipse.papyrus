/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.papyrus.xwt.XWT;

/**
 * The proxy of a CollectionView class.
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class CollectionViewSource {

	/**
	 * Gets or sets the collection object from which to create this view. This is a dependency property.
	 */
	private Object source;

	/**
	 * Gets the view object that is currently associated with this instance of CollectionViewSource. This is a dependency property.
	 * 
	 */
	private IObservableCollection view;

	private GroupDescription[] groupDescription = GroupDescription.EMPTY_ARRAY;

	private SortDescription[] sortDescription = SortDescription.EMPTY_ARRAY;

	private Locale locale = Locale.getDefault();

	/**
	 * Gets or sets the desired view type.
	 */
	private Class<?> collectionViewType = Object.class;

	public Object getSource() {
		if(source == null) {
			source = new ArrayList<Object>();
		}
		return source;
	}

	public void setSource(Object source) {
		if(this.source == source) {
			return;
		}
		view = null;
		this.source = source;
	}

	public IObservableCollection getView() {
		if(view == null) {
			Object source = getSource();
			if(!(source instanceof IObservableCollection)) {
				Class<?> elementType = getCollectionViewType();
				if(source.getClass().isArray()) {
					Object[] array = (Object[])source;
					elementType = source.getClass().getComponentType();
					source = Arrays.asList(array);
				}
				if(source instanceof List<?>) {
					view = new WritableList(XWT.getRealm(), (List<?>)source, elementType);
				} else if(source instanceof Set<?>) {
					view = new WritableSet(XWT.getRealm(), (List<?>)source, elementType);
				}
			}
		}
		return view;
	}

	public GroupDescription[] getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(GroupDescription[] groupDescription) {
		this.groupDescription = groupDescription;
	}

	public SortDescription[] getSortDescription() {
		return sortDescription;
	}

	public void setSortDescription(SortDescription[] sortDescription) {
		this.sortDescription = sortDescription;
	}

	public Class<?> getCollectionViewType() {
		return collectionViewType;
	}

	public void setCollectionViewType(Class<?> collectionViewType) {
		this.collectionViewType = collectionViewType;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
