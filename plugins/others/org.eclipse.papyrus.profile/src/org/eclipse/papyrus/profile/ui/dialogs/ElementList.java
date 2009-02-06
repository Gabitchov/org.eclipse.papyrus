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
package org.eclipse.papyrus.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class ElementList.
 * 
 * @author Remi Schnekenburger
 */
public class ElementList {

	/**
	 * The elements.
	 */
	private ArrayList elements = new ArrayList();
	
	/**
	 * The change listeners.
	 */
	private Set changeListeners = new HashSet();

	/**
	 * Constructor.
	 */
	public ElementList() {
		this.initData();
	}

	/**
	 * initialize the list of elements.
	 */
	protected void initData() {

	}

	/**
	 * Return the collection of tasks.
	 * 
	 * @return the elements
	 */
	public ArrayList getElements() {
		return elements;
	}

	/**
	 * Add a new element to the collection of selected elements.
	 * 
	 * @param element the element
	 */
	public void addElement(Object element) {
		elements.add(elements.size(), element);
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IListViewer) iterator.next()).addElement(element);
	}


	/**
	 * Removes the element.
	 * 
	 * @param element the element
	 */
	public void removeElement(Object element) {
		elements.remove(element);
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IListViewer) iterator.next()).removeElement(element);
	}

	/**
	 * Move element up.
	 * 
	 * @param element the element
	 */
	public void moveElementUp(Object element) {
		// remove element, then add it to Min(its last index -1, 0)
		int index = elements.indexOf(element);
		if(index > 0) {
			elements.remove(element);
			elements.add(index-1, element);
		}
		
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IListViewer) iterator.next()).updateElement(element);

	}
	
	/**
	 * Move element down.
	 * 
	 * @param element the element
	 */
	public void moveElementDown(Object element) {
		// remove element, then add it to Max(its last index +1, elements.size())
		int index = elements.indexOf(element);
		if(index >= 0 && index < elements.size()-1) {
			elements.remove(element);
			elements.add(index+1, element);
		}
		
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IListViewer) iterator.next()).updateElement(element);
	}


	/**
	 * Element changed.
	 * 
	 * @param element the element
	 */
	public void elementChanged(Object element) {
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IListViewer) iterator.next()).updateElement(element);
	}

	/**
	 * Contains.
	 * 
	 * @param element the element
	 * 
	 * @return true, if contains
	 */
	public boolean contains(Object element) {
		return elements.contains(element);
	}
	
	/**
	 * Removes the change listener.
	 * 
	 * @param viewer the viewer
	 */
	public void removeChangeListener(IListViewer viewer) {
		changeListeners.remove(viewer);
	}

	/**
	 * Adds the change listener.
	 * 
	 * @param viewer the viewer
	 */
	public void addChangeListener(IListViewer viewer) {
		changeListeners.add(viewer);
	}

}
