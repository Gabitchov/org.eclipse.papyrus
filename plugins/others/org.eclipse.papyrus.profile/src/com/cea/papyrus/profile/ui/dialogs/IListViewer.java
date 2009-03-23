/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package com.cea.papyrus.profile.ui.dialogs;


// TODO: Auto-generated Javadoc
/**
 * The Interface IListViewer.
 */
public interface IListViewer {
	
	/**
	 * Update the view to reflect the fact that an element was added
	 * to the element list.
	 * 
	 * @param element element to add
	 */
	public void addElement(Object element);
	
	/**
	 * Update the view to reflect the fact that an element was removed
	 * from the element list.
	 * 
	 * @param element the element to remove from the list
	 */
	public void removeElement(Object element);
	
	/**
	 * Update the view to reflect the fact that one of the element
	 * was modified.
	 * 
	 * @param element the element that was modified
	 */
	public void updateElement(Object element);
}
