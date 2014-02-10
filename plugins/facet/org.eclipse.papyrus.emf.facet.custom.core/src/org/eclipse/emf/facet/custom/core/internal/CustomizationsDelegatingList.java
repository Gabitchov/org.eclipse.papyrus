/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 374758 - [Table] repair the table
 *    Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *    Thomas Cicognani (Soft-Maint) - Bug 420192 - UnsupportedOperationException in a usefull method 
 *******************************************************************************/
package org.eclipse.emf.facet.custom.core.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

/** Represents a list of {@link Customization}s that exists as a subset of a delegate list of {@link FacetSet}s. */
public class CustomizationsDelegatingList implements List<Customization> {
	private final List<FacetSet> delegate;

	public CustomizationsDelegatingList(final List<FacetSet> delegate) {
		this.delegate = delegate;
	}

	public int size() {
		return this.delegate.size();
	}

	public boolean isEmpty() {
		return this.delegate.isEmpty();
	}

	public boolean contains(final Object element) {
		return element instanceof Customization && this.delegate.contains(element);
	}

	public Iterator<Customization> iterator() {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public Object[] toArray() {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public <T> T[] toArray(final T[] a) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public boolean add(final Customization o) {
		return this.delegate.add(o);
	}

	public boolean remove(final Object element) {
		return this.delegate.remove(element);
	}

	public boolean containsAll(final Collection<?> c) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public boolean addAll(final Collection<? extends Customization> c) {
		return this.delegate.addAll(c);
	}

	public boolean addAll(final int index, final Collection<? extends Customization> c) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public boolean removeAll(final Collection<?> c) {
		return this.delegate.removeAll(c);
	}

	public boolean retainAll(final Collection<?> c) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public void clear() {
		final ListIterator<FacetSet> listIterator = this.delegate.listIterator();
		while (listIterator.hasNext()) {
			final FacetSet facetSet = listIterator.next();
			if (facetSet instanceof Customization) {
				listIterator.remove();
			}
		}
	}

	public Customization get(final int index) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public Customization set(final int index, final Customization element) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public void add(final int index, final Customization element) {
		if (index == 0) {
			this.delegate.add(0, element);
		} else {
			// FIXME implement
			throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
		}
	}

	public Customization remove(final int index) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public int indexOf(final Object element) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public int lastIndexOf(final Object element) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public ListIterator<Customization> listIterator() {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public ListIterator<Customization> listIterator(final int index) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}

	public List<Customization> subList(final int fromIndex, final int toIndex) {
		// FIXME implement
		throw new UnsupportedOperationException("not implemented"); //$NON-NLS-1$
	}
}
