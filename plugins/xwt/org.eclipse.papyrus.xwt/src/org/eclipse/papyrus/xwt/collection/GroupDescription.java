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
 * Provides an abstract base class for types that describe how to divide the items in a collection into groups.
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class GroupDescription {

	public static GroupDescription[] EMPTY_ARRAY = new GroupDescription[0];

	/**
	 * Gets the collection of names that are used to initialize a group with a set of subgroups with the given names.
	 */
	protected String[] groupNames;

	/**
	 * 
	 * @return
	 */
	public String[] getGroupNames() {
		return groupNames;
	}

	/**
	 * 
	 * @param groupNames
	 */
	public void setGroupNames(String[] groupNames) {
		this.groupNames = groupNames;
	}
}
