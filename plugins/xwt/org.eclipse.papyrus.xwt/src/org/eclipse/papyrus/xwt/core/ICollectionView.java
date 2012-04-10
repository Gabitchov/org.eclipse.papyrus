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
package org.eclipse.papyrus.xwt.core;

import java.util.Collection;
import java.util.Locale;

import org.eclipse.papyrus.xwt.collection.GroupDescription;
import org.eclipse.papyrus.xwt.collection.SortDescription;

/**
 * The interface is implemented by the CollectionView class, which is the base class for Collection
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public interface ICollectionView<T> {

	/**
	 * Gets a value that indicates whether this view supports filtering via the Filter property.
	 * 
	 * @return
	 */
	boolean canFilter();

	/**
	 * Gets a value that indicates whether this view supports grouping via the GroupDescriptions property.
	 * 
	 * @return
	 */
	boolean canGroup();


	/**
	 * Gets a value that indicates whether this view supports sorting via the SortDescriptions property.
	 * 
	 * @return
	 */
	boolean canSort();

	/**
	 * Gets the current item in the view.
	 * 
	 * @return
	 */
	T getCurrentItem();

	/**
	 * Gets the ordinal position of the CurrentItem within the view.
	 * 
	 * @return
	 */
	int getCurrentPosition();


	/**
	 * Returns a value that indicates whether the resulting view is empty.
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * Source collection
	 * 
	 * @return
	 */
	Collection<T> getSourceCollection();

	/**
	 * Gets a collection of GroupDescription objects that describe how the items in the collection are grouped in the view.
	 * 
	 * @return
	 */
	GroupDescription[] getGroupDescription();

	/**
	 * Gets a collection of SortDescription objects that describe how the items in the collection are sorted in the view.
	 * 
	 * @return
	 */
	SortDescription[] getSortDescription();

	/**
	 * Gets the top-level groups.
	 * 
	 * @return
	 */
	Collection<T> getGroups();

	/**
	 * Gets or sets the cultural info for any operations of the view that may differ by culture, such as sorting.
	 * 
	 * @return
	 */
	Locale getLocale();
}
