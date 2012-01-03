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
package org.eclipse.papyrus.core.modelsetquery.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.papyrus.core.modelsetquery.IFillableModelSetQueryAdapter;
import org.eclipse.papyrus.core.modelsetquery.IModelSetQueryAdapter;

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

	/**
	 * This cache adapter is only used if the caller don't use correctly
	 * TypeCacheAdapter. With the simple cache adapter performance are not good
	 * but a result is still returned
	 */
	private static SimpleTypeCacheAdapter simpleCacheAdapter = new SimpleTypeCacheAdapter();

	public ModelSetQueryAdapterTimeMatters() {
		super();
	}

	/**
	 * Searches the adapter list of the given Notifier for a TypeCacheAdapter.
	 * If not found, returns null.
	 * 
	 * @param notifier
	 *        the notifier to search
	 * @return the TypeCacheAdapter if found or a simple ITypeCacheAdapter which
	 *         calls default method
	 */
	public static IModelSetQueryAdapter getExistingTypeCacheAdapter(Notifier notifier) {
		if(notifier == null) {
			return simpleCacheAdapter;
		}
		for(Adapter adapter : notifier.eAdapters()) {
			if(adapter instanceof ModelSetQueryAdapterSizeMatters) {
				return (ModelSetQueryAdapterSizeMatters)adapter;
			}
		}
		if(notifier instanceof EObject) {
			EObject object = (EObject)notifier;
			IModelSetQueryAdapter typeCacheAdapter = getExistingTypeCacheAdapter(object.eResource());
			if(typeCacheAdapter != null) {
				object.eAdapters().add((Adapter)typeCacheAdapter);
				return typeCacheAdapter;
			}
		} else if(notifier instanceof Resource) {
			Resource resource = (Resource)notifier;
			IModelSetQueryAdapter typeCacheAdapter = getExistingTypeCacheAdapter(resource.getResourceSet());
			if(typeCacheAdapter != null) {
				if(typeCacheAdapter instanceof Adapter) {
					resource.eAdapters().add((Adapter)typeCacheAdapter);
				}
				return typeCacheAdapter;
			}
		}
		return simpleCacheAdapter;
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

	public static IModelSetQueryAdapter getSimpleTypeCacheAdapter() {
		return simpleCacheAdapter;
	}

	/**
	 * This implementation uses ItemPropertyDescriptor class to resolve objects
	 * from type
	 * 
	 * @author tfaure
	 */
	private static class SimpleTypeCacheAdapter implements IModelSetQueryAdapter {

		public Collection<EObject> getReachableObjectsOfType(EObject object, EClassifier type) {
			return ItemPropertyDescriptor.getReachableObjectsOfType(object, type);
		}
	}

}
