/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.providers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * A ContentProvider to adapt an IStaticContentProvider to an
 * IStructurecContentProvider Useful when you need to use a ContentProvider that
 * doesn't depend on its Input Object to return values in a JFace Viewer.
 * 
 * @author Camille Letavernier
 * 
 */
public class EncapsulatedContentProvider implements IStructuredContentProvider {

	/**
	 * The encapsulated static content provider
	 */
	private IStaticContentProvider encapsulated;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param encapsulated
	 *        The encapsulated static content provider
	 */
	public EncapsulatedContentProvider(IStaticContentProvider encapsulated) {
		this.encapsulated = encapsulated;
	}

	/**
	 * Sets the objects that should not be returned by this provider
	 * 
	 * @param filtered
	 */
	public void setFilteredElements(Object[] filtered) {
		filteredElements.clear();
		addFilteredElements(filtered);
	}

	/**
	 * Returns all elements known by this ContentProvider. This is the union of
	 * the objects returned by the wrapped StaticContentProvider and the temporary
	 * elements, which are not known by the wrapped provider.
	 * 
	 * @return
	 *         All elements known by this ContentProvider
	 */
	private Object[] getAllElements() {
		List<Object> result = new LinkedList<Object>();
		for(Object object : encapsulated.getElements()) {
			result.add(object);
		}
		result.addAll(temporaryElements);
		return result.toArray();
	}

	/**
	 * @return
	 *         all the elements that are not selected (Or all elements if the
	 *         selector is not marked as Unique)
	 */
	private Object[] getAllAvailableElements() {
		Object[] allElements = getAllElements();
		List<Object> availableElements = new LinkedList<Object>();
		for(Object element : allElements) {
			if(!filteredElements.contains(element)) {
				availableElements.add(element);
			}
		}

		return availableElements.toArray();
	}

	/**
	 * Adds elements that should not be returned by this provider
	 * 
	 * @param filtered
	 */
	public void addFilteredElements(Object[] filtered) {
		for(Object object : filtered) {
			filteredElements.add(object);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		encapsulated.inputChanged(viewer, oldInput, newInput);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		return getElements();
	}

	/**
	 * Gets the elements for this content provider
	 * 
	 * @return
	 *         all elements from the wrapped ContentProvider
	 */
	public Object[] getElements() {
		return getAllAvailableElements();
	}

	/**
	 * The set of elements that should not be returned by this provider
	 */
	private Set<Object> filteredElements = new HashSet<Object>();

	/**
	 * The set of temporaryElements, which are added from outside this ContentProvider
	 */
	private Set<Object> temporaryElements = new LinkedHashSet<Object>();

	/**
	 * Adds a Temporary element to this ContentProvider
	 * 
	 * @param newObject
	 *        The temporary element to be added
	 */
	public void addTemporaryElement(Object newObject) {
		temporaryElements.add(newObject);
	}

	/**
	 * Clears all temporary elements from this content provider
	 */
	public void clearTemporaryElements() {
		temporaryElements.clear();
	}

}
