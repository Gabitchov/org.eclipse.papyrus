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
package org.eclipse.papyrus.editors.providers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * A ContentProvider to adapt an IStaticContentProvider to an IStructurecContentProvider
 * Useful when you need to use a ContentProvider that doesn't depend on its Input Object
 * to return values in a JFace Viewer.
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
	 */
	public Object[] getElements() {
		Object[] allElements = encapsulated.getElements();
		Set<Object> result = new LinkedHashSet<Object>();
		for(Object element : allElements) {
			if(!filteredElements.contains(element)) {
				result.add(element);
			}
		}
		return result.toArray();
	}

	/**
	 * The set of elements that should not be returned by this provider
	 */
	private Set<Object> filteredElements = new HashSet<Object>();

}
