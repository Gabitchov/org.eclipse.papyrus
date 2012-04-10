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

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import org.eclipse.papyrus.xwt.core.ICollectionView;

/**
 * Represents a view for grouping, sorting, filtering, and navigating a data
 * collection.`
 * 
 * @author yyang
 */
public class CollectionView<T> implements ICollectionView<T> {

	private T currentItem;

	private int currentPosition = 0;

	private Collection<T> sourceCollection = Collections.emptyList();

	private GroupDescription[] groupDescription = GroupDescription.EMPTY_ARRAY;

	private Collection<T> groups = Collections.emptyList();

	private Locale locale = Locale.getDefault();

	private SortDescription[] sortDescription = SortDescription.EMPTY_ARRAY;

	public GroupDescription[] getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(GroupDescription[] groupDescription) {
		this.groupDescription = groupDescription;
	}

	public Collection<T> getGroups() {
		return groups;
	}

	public void setGroups(Collection<T> groups) {
		this.groups = groups;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public SortDescription[] getSortDescription() {
		return sortDescription;
	}

	public void setSortDescription(SortDescription[] sortDescription) {
		this.sortDescription = sortDescription;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public void setSourceCollection(Collection<T> sourceCollection) {
		this.sourceCollection = sourceCollection;
	}

	public boolean canFilter() {
		return false;
	}

	public boolean canGroup() {
		return groupDescription.length > 0;
	}

	public boolean canSort() {
		return sortDescription.length > 0;
	}

	public T getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(T currentItem) {
		this.currentItem = currentItem;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public Collection<T> getSourceCollection() {
		return sourceCollection;
	}

	public boolean isEmpty() {
		if(canGroup()) {
			return groups.isEmpty();
		}
		return sourceCollection.isEmpty();
	}
}
