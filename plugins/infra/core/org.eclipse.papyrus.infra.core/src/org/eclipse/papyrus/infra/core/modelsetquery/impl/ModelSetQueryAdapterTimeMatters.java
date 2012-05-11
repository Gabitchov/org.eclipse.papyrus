/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.modelsetquery.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.papyrus.infra.core.modelsetquery.IFillableModelSetQueryAdapter;

/**
 * This cache creates a map associating EClasses to all the corresponding
 * This implementation takes more space but it is more performant for get and put methods
 * instances
 * 
 * @author Tristan Faure
 */
public class ModelSetQueryAdapterTimeMatters extends EContentAdapter implements IFillableModelSetQueryAdapter {

	/**
	 * The cache of elements
	 */
	private Map<EClassifier, Collection<EObject>> cache = Collections.synchronizedMap(new IdentityHashMap<EClassifier, Collection<EObject>>());

	public ModelSetQueryAdapterTimeMatters() {
		super();
	}

	protected void addAdapter(Notifier notifier) {
		super.addAdapter(notifier);
		if(notifier instanceof EObject) {
			EObject eobject = (EObject)notifier;
			addObjectInCache(eobject);
		}
	}

	@Override
	protected void removeAdapter(Notifier notifier) {
		super.removeAdapter(notifier);
		if(notifier instanceof EObject) {
			EObject eobject = (EObject)notifier;
			removeObjectFromCache(eobject);
		}
	}

	private void addObjectInCache(EObject newObj) {
		EClass eClass = newObj.eClass();
		putObjectInCache(eClass, newObj);
		for(EClass eSuperClass : eClass.getEAllSuperTypes()) {
			putObjectInCache(eSuperClass, newObj);
		}
	}

	private void putObjectInCache(EClassifier eClassifier, EObject newObj) {
		Collection<EObject> listOfClassifiers = cache.get(eClassifier);
		if (listOfClassifiers == null)
		{
			listOfClassifiers = new HashSet<EObject>();
			cache.put(eClassifier, listOfClassifiers);
		}
		if(listOfClassifiers != null) {
			listOfClassifiers.add(newObj);
		}
	}

	private void removeObjectFromCache(EObject newObj) {
		EClass eClass = newObj.eClass();
		removeObjectFromCache(eClass, newObj);
		for(EClass eSuperClass : eClass.getEAllSuperTypes()) {
			removeObjectFromCache(eSuperClass, newObj);
		}
	}

	private void removeObjectFromCache(EClassifier eClassifier, EObject newObj) {
		Collection<EObject> listOfClassifiers = cache.get(eClassifier);
		if(listOfClassifiers != null) {
			listOfClassifiers.remove(newObj);
		}
		if (listOfClassifiers.isEmpty())
		{
			cache.remove(eClassifier);
		}
	}

	public Collection<EObject> getReachableObjectsOfType(EObject object, EClassifier type) {
		if(!cache.containsKey(type)) {
			cache.put(type, new HashSet<EObject>(ItemPropertyDescriptor.getReachableObjectsOfType(object, type)));
		}
		return cache.get(type);
	}

	public void dispose() {
		cache.clear();
		cache = null;
	}

	/**
	 * This method provides a way for user to force first entries in the cache.
	 * The list of element must be a HashSet to optimize the performances
	 * 
	 * @param type
	 * @param list
	 */
	public void addEntriesInCache(EClassifier type, HashSet<EObject> list) {
		for (EObject e : list)
		{
			addObjectInCache(e);
		}
	}

	public boolean isAlreadyComputed(EClassifier type) {
		return cache.containsKey(type);
	}
}
