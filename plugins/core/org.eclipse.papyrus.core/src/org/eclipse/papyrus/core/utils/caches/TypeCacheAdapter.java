/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE    tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.utils.caches;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

/**
 * This cache creates a map associating EClasses to all the corresponding instances
 * 
 * @author Tristan Faure
 */
public class TypeCacheAdapter implements ITypeCacheAdapter, Adapter.Internal {

	/**
	 * The cache of elements
	 */
	private Map<EClassifier, Collection<EObject>> cache = Collections.synchronizedMap(new HashMap<EClassifier, Collection<EObject>>());

	/**
	 * This cache adapter is only used if the caller don't use correctly TypeCacheAdapter.
	 * With the simple cache adapter performance are not good but a result is still returned
	 */
	private static SimpleTypeCacheAdapter simpleCacheAdapter = new SimpleTypeCacheAdapter();

	protected Set<Resource> unloadedResources = new HashSet<Resource>();

	protected Set<URI> alreadyLoadedURIs = new HashSet<URI>();

	protected Map<EObject, Resource> unloadedEObjects = new HashMap<EObject, Resource>();

	public TypeCacheAdapter() {
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
	public static ITypeCacheAdapter getExistingTypeCacheAdapter(Notifier notifier) {
		if(notifier == null) {
			return simpleCacheAdapter;
		}
		for(Adapter adapter : notifier.eAdapters()) {
			if(adapter instanceof TypeCacheAdapter) {
				return (TypeCacheAdapter)adapter;
			}
		}
		if(notifier instanceof EObject) {
			EObject object = (EObject)notifier;
			ITypeCacheAdapter typeCacheAdapter = getExistingTypeCacheAdapter(object.eResource());
			if(typeCacheAdapter != null) {
				object.eAdapters().add((Adapter)typeCacheAdapter);
				return typeCacheAdapter;
			}
		} else if(notifier instanceof Resource) {
			Resource resource = (Resource)notifier;
			ITypeCacheAdapter typeCacheAdapter = getExistingTypeCacheAdapter(resource.getResourceSet());
			if(typeCacheAdapter != null) {
				resource.eAdapters().add((Adapter)typeCacheAdapter);
				return typeCacheAdapter;
			}
		}
		return simpleCacheAdapter;
	}

	protected void addAdapter(Notifier notifier) {
		if(notifier instanceof EObject) {
			EObject eobject = (EObject)notifier;
			addObjectInCache(eobject);
		}
		List<Adapter> eAdapters = notifier.eAdapters();
		if(!eAdapters.contains(this)) {
			eAdapters.add(this);
		}
	}


	protected void handleContainment(Notification notification) {
		Object notifier = notification.getNotifier();
		// synchronize cache on ADD and REMOVE notifications
		if(notifier instanceof EObject) {
			caseEobject(notification);
		} else if(notifier instanceof ResourceSet) {
			switch(notification.getEventType()) {
			case Notification.ADD:
			{
				if(notification.getNewValue() instanceof Resource) {
					Resource r = (Resource)notification.getNewValue();
					if(!r.eAdapters().contains(this)) {
						r.eAdapters().add(this);
					}
				}
			}
			case Notification.RESOLVE:
			{
				if(notification.getNewValue() instanceof Resource) {
					Resource r = (Resource)notification.getNewValue();
					for(Iterator<EObject> i = r.getAllContents(); i.hasNext();) {
						EObject next = i.next();
						addObjectInCache(next);
					}
				}
			}
			case Notification.REMOVE:
			{
				// MAYBE TODO
			}
			}
		}
	}

	private void caseEobject(Notification notification) {
		switch(notification.getEventType()) {
		case Notification.ADD:
		{
			Object newValue = notification.getNewValue();
			if(newValue != null && (newValue instanceof EObject)) {
				addObjectInCache((EObject)newValue);
			}
			break;
		}
		case Notification.ADD_MANY:
		{
			for(Object newValue : (Collection<?>)notification.getNewValue()) {
				if(newValue != null && (newValue instanceof EObject)) {
					addObjectInCache((EObject)newValue);
				}
			}
			break;
		}
		case Notification.REMOVE:
		{
			Object oldValue = notification.getOldValue();
			if(oldValue != null && (oldValue instanceof EObject)) {
				removeObjectFromCache((EObject)oldValue);
			}
			break;
		}
		case Notification.REMOVE_MANY:
		{
			for(Object oldValue : (Collection<?>)notification.getOldValue()) {
				if(oldValue != null && (oldValue instanceof EObject)) {
					removeObjectFromCache((EObject)oldValue);
				}
			}
			break;
		}
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
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object type) {
		return TypeCacheAdapter.class.equals(type);
	}

	public Collection<EObject> getReachableObjectsOfType(EObject object, EClassifier type) {
		if(!cache.containsKey(type)) {
			cache.put(type, new HashSet<EObject>(ItemPropertyDescriptor.getReachableObjectsOfType(object, type)));
		}
		return cache.get(type);
	}

	public void dispose() {
		cache.clear();
		unloadedEObjects.clear();
		unloadedResources.clear();
		cache = null;
	}

	/**
	 * Handles a notification by calling {@link #selfAdapt selfAdapter}.
	 */
	public void notifyChanged(Notification notification) {
		selfAdapt(notification);
	}

	/**
	 * Handles a notification by calling {@link #handleContainment
	 * handleContainment} for any containment-based notification.
	 */
	protected void selfAdapt(Notification notification) {
		Object notifier = notification.getNotifier();
		if(notifier instanceof EObject) {
			Object feature = notification.getFeature();
			if(feature instanceof EReference) {
				EReference reference = (EReference)feature;
				if(reference.isContainment()) {
					handleContainment(notification);
				}
			}
		} else if(notifier instanceof Resource) {
			switch(notification.getFeatureID(Resource.class)) {
			case Resource.RESOURCE__CONTENTS:
			{
				if(!unloadedResources.contains(notifier)) {
					switch(notification.getEventType()) {
					case Notification.REMOVE:
					{
						Resource resource = (Resource)notifier;
						if(!resource.isLoaded()) {
							EObject eObject = (EObject)notification.getOldValue();
							unloadedEObjects.put(eObject, resource);
							for(Iterator<EObject> i = EcoreUtil.getAllProperContents(eObject, false); i.hasNext();) {
								unloadedEObjects.put(i.next(), resource);
							}
						}
						break;
					}
					case Notification.REMOVE_MANY:
					{
						Resource resource = (Resource)notifier;
						if(!resource.isLoaded()) {
							@SuppressWarnings("unchecked")
							List<EObject> eObjects = (List<EObject>)notification.getOldValue();
							for(Iterator<EObject> i = EcoreUtil.getAllProperContents(eObjects, false); i.hasNext();) {
								unloadedEObjects.put(i.next(), resource);
							}
						}
						break;
					}
					default:
					{
						handleContainment(notification);
						break;
					}
					}
				}
				break;
			}
			case Resource.RESOURCE__IS_LOADED:
			{
				if(notification.getNewBooleanValue()) {
					unloadedResources.remove(notifier);
					for(Notifier child : ((Resource)notifier).getContents()) {
						addAdapter(child);
					}
				} else {
					unloadedResources.add((Resource)notifier);
				}
				break;
			}
			}
		} else if(notifier instanceof ResourceSet) {
			if(notification.getFeatureID(ResourceSet.class) == ResourceSet.RESOURCE_SET__RESOURCES) {
				handleContainment(notification);
			}
		}
	}

	/**
	 * Handles installation of the adapter by adding the adapter to each of the
	 * directly contained objects.
	 */
	public void setTarget(Notifier target) {
		if(target instanceof EObject) {
			setTarget((EObject)target);
		} else if(target instanceof Resource) {
			setTarget((Resource)target);
		} else if(target instanceof ResourceSet) {
			setTarget((ResourceSet)target);
		}
	}

	/**
	 * Handles installation of the adapter on an EObject by adding the adapter
	 * to each of the directly contained objects.
	 */
	protected void setTarget(EObject target) {
		for(@SuppressWarnings("unchecked")
		Iterator<EObject> i = resolve() ? target.eContents().iterator() : (Iterator<EObject>)((InternalEList<?>)target.eContents()).basicIterator(); i.hasNext();) {
			Notifier notifier = i.next();
			addAdapter(notifier);
		}
	}

	/**
	 * Handles installation of the adapter on a Resource by adding the adapter
	 * to each of the directly contained objects.
	 */
	protected void setTarget(Resource target) {
		if(!target.isLoaded()) {
			unloadedResources.add(target);
		}
		List<EObject> contents = target.getContents();
		for(int i = 0, size = contents.size(); i < size; ++i) {
			Notifier notifier = contents.get(i);
			addAdapter(notifier);
		}
	}

	/**
	 * Handles installation of the adapter on a ResourceSet by adding the
	 * adapter to each of the directly contained objects.
	 */
	protected void setTarget(ResourceSet target) {
		List<Resource> resources = target.getResources();
		for(int i = 0; i < resources.size(); ++i) {
			Notifier notifier = resources.get(i);
			addAdapter(notifier);
		}
	}

	/**
	 * Handles undoing the installation of the adapter by removing the adapter
	 * to each of the directly contained objects.
	 */
	public void unsetTarget(Notifier target) {
		if(target instanceof EObject) {
			unsetTarget((EObject)target);
		} else if(target instanceof Resource) {
			unsetTarget((Resource)target);
		} else if(target instanceof ResourceSet) {
			unsetTarget((ResourceSet)target);
		}
	}

	/**
	 * Handles undoing the installation of the adapter from an EObject by
	 * removing the adapter to each of the directly contained objects.
	 */
	protected void unsetTarget(EObject target) {
		for(@SuppressWarnings("unchecked")
		Iterator<InternalEObject> i = resolve() ? (Iterator<InternalEObject>)(Iterator<?>)target.eContents().iterator() : (Iterator<InternalEObject>)((InternalEList<?>)target.eContents()).basicIterator(); i.hasNext();) {
			// Don't remove the adapter if the object is in a different resource
			// and that resource (and hence all its contents) are being cross
			// referenced.
			//
			InternalEObject internalEObject = i.next();
			Resource eDirectResource = internalEObject.eDirectResource();
			if(eDirectResource == null || !eDirectResource.eAdapters().contains(this)) {
				removeAdapter(internalEObject);
			}
		}
	}

	/**
	 * Handles undoing the installation of the adapter from a Resource by
	 * removing the adapter to each of the directly contained objects.
	 */
	protected void unsetTarget(Resource target) {
		List<EObject> contents = target.getContents();
		for(int i = 0, size = contents.size(); i < size; ++i) {
			Notifier notifier = contents.get(i);
			removeAdapter(notifier);
		}
	}

	/**
	 * Handles undoing the installation of the adapter from a ResourceSet by
	 * removing the adapter to each of the directly contained objects.
	 */
	protected void unsetTarget(ResourceSet target) {
		List<Resource> resources = target.getResources();
		for(int i = 0; i < resources.size(); ++i) {
			Notifier notifier = resources.get(i);
			removeAdapter(notifier);
		}
	}

	protected void removeAdapter(Notifier notifier) {
		notifier.eAdapters().remove(this);
	}

	public Notifier getTarget() {
		return null;
	}

	protected boolean resolve() {
		return true;
	}

	/**
	 * This method provides a way for user to force first entries in the cache. The list of element must be a HashSet to optimize the performances
	 * 
	 * @param type
	 * @param list
	 */
	public void fillFirstEntryCache(EClassifier type, HashSet<EObject> list) {
		cache.put(type, list);
	}

	public boolean isAlreadyComputed(EClassifier type) {
		return cache.containsKey(type);
	}


	public static ITypeCacheAdapter getSimpleTypeCacheAdapter() {
		return simpleCacheAdapter;
	}

	/**
	 * This implementation uses ItemPropertyDescriptor class to resolve objects from type
	 * 
	 * @author tfaure
	 */
	private static class SimpleTypeCacheAdapter implements ITypeCacheAdapter {

		public Collection<EObject> getReachableObjectsOfType(EObject object, EClassifier type) {
			return ItemPropertyDescriptor.getReachableObjectsOfType(object, type);
		}
	}

}
