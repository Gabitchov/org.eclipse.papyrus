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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.utils.wrappinglist;

import java.util.Collection;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.papyrus.facade.utils.RepresentingElement;
import org.eclipse.uml2.uml.Element;


public class WrappingEObjectWithInverseEList<E extends RepresentingElement> extends EObjectWithInverseEList<E> implements WrappingList<E> {

	public static class WrappingManyInverse<E> extends WrappingEObjectWithInverseEList {

		private static final long serialVersionUID = 1L;

		public WrappingManyInverse(Class<?> dataClass, InternalEObject owner, int featureID, int inverseFeatureID, Collection<Element> representedElementList) {
			super(dataClass, owner, featureID, inverseFeatureID, representedElementList);
		}

		@Override
		protected boolean hasManyInverse() {
			return true;
		}
	}

	protected Collection<Element> representedElementList;

	public WrappingEObjectWithInverseEList(Class<?> dataClass, InternalEObject owner, int featureID, int inverseFeatureID, Collection<Element> representedElementList) {
		super(dataClass, owner, featureID, inverseFeatureID);
		this.representedElementList = representedElementList;
	}

	@Override
	public boolean add(E object) {

		if(!representedElementList.contains(((E)object).get__Represented())) {
			representedElementList.add((Element)((E)object).get__Represented());
		}

		if(isUnique() && contains(object)) {
			return false;
		} else {
			super.doAddUnique(object);

			return true;
		}

	}

	@Override
	public void add(int index, E e) {
		if(!representedElementList.contains((e).get__Represented())) {
			representedElementList.add((Element)(e).get__Represented());
		}

		super.doAddUnique(index, e);
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		for(E e : collection) {
			if(!representedElementList.contains(e.get__Represented())) {
				representedElementList.add((Element)e.get__Represented());
			}
		}

		if(collection.isEmpty()) {
			return false;
		} else {
			for(E e : collection) {
				super.doAddUnique(e);
			}
			return true;
		}

	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		for(E e : collection) {
			if(!representedElementList.contains(e.get__Represented())) {
				representedElementList.add((Element)e.get__Represented());
			}
		}

		if(collection.isEmpty()) {
			return false;
		} else {
			super.doAddAllUnique(index, collection);
			return true;
		}
	}


	@Override
	public boolean remove(Object object) {
		Object representedElement = ((RepresentingElement)object).get__Represented();
		representedElementList.remove(representedElement);

		if(this.contains(object)) {
			E oldObject = doRemove(indexOf(object));
			return true;
		} else {
			return false;
		}

	}

	@Override
	public E remove(int index) {
		Object representedElement = ((RepresentingElement)this.get(index)).get__Represented();
		representedElementList.remove(representedElement);


		E oldObject = doRemove(index);

		return oldObject;
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		for(Object object : collection) {
			Object representedElement = ((RepresentingElement)object).get__Represented();
			representedElementList.remove(representedElement);
		}

		boolean result = false;

		for(Object object : collection) {
			if(this.contains(object)) {
				E oldObject = doRemove(indexOf(object));
				result = true;
			}
		}
		return result;
	}

	@Override
	public void clear() {

		representedElementList.clear();

		for(Object object : this) {
			if(this.contains(object)) {
				E oldObject = doRemove(indexOf(object));

			}
		}
	}

	@Override
	public void notWrappingAdd(E object) {
		doAddUnique(object);
	}

	@Override
	public E notWrappingRemove(E object) {
		return doRemove(indexOf(object));
	}

	@Override
	public void silentAdd(int index, E object) {
		super.doAddUnique(index, object);
	}


	@Override
	public E silentRemove(int index) {
		return super.doRemove(index);
	}

}
