/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.PlatformUI;


/**
 * Helper methods for the .notation related resources
 * 
 * @author Laurent Wouters
 */
public class NotationUtils {

	/**
	 * Gets the roots of the notations resources related to the given object
	 * 
	 * @param element
	 *            The object from which to retrieve the notation resources
	 * @return An iterator of notation resources' roots, or <code>null</code> if none cannot be resolved
	 */
	public static Iterator<EObject> getNotationRoots(EObject element) {
		Iterator<Resource> notations = getNotationResources(element);
		if (notations == null)
			return null;
		return new RootsIterator(notations);
	}

	/**
	 * Represents an iterator on all the roots of the notations resources of a ResourceSet
	 * 
	 * @author Laurent Wouters
	 */
	private static class RootsIterator implements Iterator<EObject> {
		private Iterator<Resource> notations;
		private Iterator<EObject> inner;

		public RootsIterator(Iterator<Resource> notations) {
			this.notations = notations;
			if (notations.hasNext())
				inner = notations.next().getAllContents();
		}

		public boolean hasNext() {
			if (inner == null)
				return false;
			if (inner.hasNext())
				return true;
			while (notations.hasNext()) {
				inner = notations.next().getAllContents();
				if (inner.hasNext())
					return true;
			}
			inner = null;
			return false;
		}

		public EObject next() {
			if (inner == null)
				return null;
			if (inner.hasNext())
				return inner.next();
			while (notations.hasNext()) {
				inner = notations.next().getAllContents();
				if (inner.hasNext())
					return inner.next();
			}
			inner = null;
			return null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	/**
	 * Gets the notation resources related to the given object
	 * 
	 * @param element
	 *            The object from which to retrieve the notation resources
	 * @return An iterator of notation resources, or <code>null</code> if none cannot be resolved
	 */
	public static Iterator<Resource> getNotationResources(EObject element) {
		Iterator<Resource> result = tryGetNotationResources(element);
		if (result != null)
			return result;
		IAdaptable input = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getInput();
		if (input != null) {
			EObject obj = (EObject) input.getAdapter(EObject.class);
			return tryGetNotationResources(obj);
		}
		return null;
	}

	/**
	 * Tries to get the notation resources related to the given object
	 * 
	 * @param element
	 *            The object from which to retrieve the notation resources
	 * @return An iterator of notation resources, or <code>null</code> if none cannot be resolved
	 */
	private static Iterator<Resource> tryGetNotationResources(EObject element) {
		if (element == null)
			return null;
		if (element.eResource() == null)
			return null;
		return new NotationsIterator(element.eResource().getResourceSet());
	}


	/**
	 * Represents an iterator over the notation resources of a ResourceSet
	 * 
	 * @author Laurent Wouters
	 */
	private static class NotationsIterator implements Iterator<Resource> {
		private Iterator<Resource> inner;
		private Resource next;

		public NotationsIterator(ResourceSet set) {
			inner = set.getResources().iterator();
			next = getNextNotation();
		}

		private Resource getNextNotation() {
			while (inner.hasNext()) {
				Resource resource = inner.next();
				String uri = resource.getURI().toString();
				if (uri.endsWith(".notation"))
					return resource;
			}
			return null;
		}

		public boolean hasNext() {
			return (next != null);
		}

		public Resource next() {
			Resource result = next;
			next = getNextNotation();
			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
