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

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * A ContentProvider to adapt an IStaticContentProvider to an
 * IStructurecContentProvider Useful when you need to use a ContentProvider that
 * doesn't depend on its Input Object to return values in a JFace Viewer.
 * This content provider also supports temporary elements, which are added
 * to the list of static elements returned by the encapsulated provider.
 * 
 * @author Camille Letavernier
 * 
 */
public class EncapsulatedContentProvider implements IHierarchicContentProvider {

	/**
	 * The encapsulated static content provider
	 */
	protected IStaticContentProvider encapsulated;

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
	 * {@inheritDoc}
	 */
	public void dispose() {
		//Nothing
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
		return getAllElements();
	}

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

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		if(encapsulated instanceof ITreeContentProvider) {
			return ((ITreeContentProvider)encapsulated).getChildren(parentElement);
		} else {
			return new Object[0];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		if(encapsulated instanceof ITreeContentProvider) {
			return ((ITreeContentProvider)encapsulated).getParent(element);
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		if(encapsulated instanceof ITreeContentProvider) {
			return ((ITreeContentProvider)encapsulated).hasChildren(element);
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isValidValue(Object element) {
		if(encapsulated instanceof IHierarchicContentProvider) {
			return ((IHierarchicContentProvider)encapsulated).isValidValue(element);
		} else {
			return true;
		}
	}

}
