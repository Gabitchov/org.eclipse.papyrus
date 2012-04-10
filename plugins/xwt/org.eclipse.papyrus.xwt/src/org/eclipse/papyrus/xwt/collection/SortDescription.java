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

/**
 * Defines the direction and the property name to be used as the criteria for sorting a collection.
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class SortDescription {

	public static SortDescription[] EMPTY_ARRAY = new SortDescription[0];

	/**
	 * Gets or sets a value that indicates whether to sort in ascending or descending order.
	 */
	private ListSortDirection direction = ListSortDirection.Ascending;

	/**
	 * Gets or sets the property name being used as the sorting criteria.
	 */
	private String propertyName;

	public ListSortDirection getDirection() {
		return direction;
	}

	public void setDirection(ListSortDirection direction) {
		this.direction = direction;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}
