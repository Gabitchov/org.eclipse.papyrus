/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.sasheditor.SashModel;

/**
 * This adapter maintains a map linking url and the corresponding ControledResource
 * 
 * @author tfaure
 * 
 */
public class ControledResourceAdapter implements Adapter.Internal {

	/**
	 * The map accesed
	 */
	private Map<String, List<ControledResource>> resources = new HashMap<String, List<ControledResource>>();

	private ModelSet modelSet = null;

	public ControledResourceAdapter(ModelSet modelSet) {
		this.modelSet = modelSet;
		manageAllControledResources();
		modelSet.eAdapters().add(this);
	}

	protected void put(ControledResource controled) {
		List<ControledResource> list = resources.get(controled.getResourceURL());
		if(list == null) {
			list = new LinkedList<ControledResource>();
			resources.put(controled.getResourceURL(), list);
			addAdapter(controled);
		}
		list.add(controled);
	}

	public void manageAllControledResources() {
		for(Resource r : modelSet.getResources()) {
			addResource(r);
		}
	}

	protected void addResource(Resource r) {
		if(SashModel.MODEL_FILE_EXTENSION.equals(r.getURI().fileExtension())) {
			for(EObject e : r.getContents()) {
				if(e instanceof ControledResource) {
					ControledResource root = (ControledResource)e;
					if(root != null) {
						put(root);
						for(Iterator<EObject> i = root.eAllContents(); i.hasNext();) {
							EObject eobject = i.next();
							if(eobject instanceof ControledResource) {
								put((ControledResource)eobject);
							}
						}
					}

				}
			}
			if(!r.eAdapters().contains(this)) {
				r.eAdapters().add(this);
			}
		}
	}

	public List<ControledResource> getControledResource(String locationURL) {
		List<ControledResource> list = resources.get(locationURL);
		if(list == null) {
			return Collections.emptyList();
		}
		return list;
	}


	public void notifyChanged(Notification notification) {
		Notifier aNotifier = (Notifier)notification.getNotifier();
		if(aNotifier instanceof EObject) {
			switch(notification.getEventType()) {
			case Notification.ADD:
				addControledResource(notification.getNewValue());
				break;
			case Notification.ADD_MANY:
				List<?> list = (List<?>)notification.getNewValue();
				for(Object o : list) {
					addControledResource(o);
				}
				break;
			case Notification.REMOVE:
				removeControledResource(notification.getOldValue());
				break;
			case Notification.REMOVE_MANY:
				List<?> list2 = (List<?>)notification.getOldValue();
				for(Object o : list2) {
					removeControledResource(o);
				}
				break;
			default:
				break;
			}
		} else if(aNotifier instanceof Resource) {
			switch(notification.getFeatureID(Resource.class)) {
			case Resource.RESOURCE__IS_LOADED:
				addResource((Resource)aNotifier);
				break;
			}

		} else if(aNotifier instanceof ModelSet) {
			if(notification.getNewValue() instanceof Resource) {
				Resource r = ((Resource)notification.getNewValue());
				if(!r.eAdapters().contains(this)) {
					r.eAdapters().add(this);
				}
				setTarget((Resource)notification.getNewValue());
			}
		}
	}

	protected void addControledResource(Object o) {
		if(o instanceof ControledResource) {
			ControledResource o2 = (ControledResource)o;
			put(o2);
		}
	}

	protected void removeControledResource(Object o) {
		if(o instanceof ControledResource) {
			ControledResource res = (ControledResource)o;
			List<ControledResource> list = resources.get(res.getResourceURL());
			if (list != null)
			{
				list.remove(res);
			}
			if(list.isEmpty()) {
				resources.remove(res.getResourceURL());
			}
		}

	}

	public Notifier getTarget() {
		return modelSet;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	/**
	 * Handles installation of the adapter on an EObject by adding the adapter
	 * to each of the directly contained objects.
	 */
	protected void setTarget(EObject target) {
		for(@SuppressWarnings("unchecked")
		Iterator<EObject> i = (Iterator<EObject>)((InternalEList<?>)target.eContents()).basicIterator(); i.hasNext();) {
			Notifier notifier = i.next();
			addAdapter(notifier);
		}
	}

	protected void addAdapter(Notifier notifier) {
		List<Adapter> eAdapters = notifier.eAdapters();
		if(!eAdapters.contains(this)) {
			eAdapters.add(this);
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
	 * Handles installation of the adapter on a Resource by adding the adapter
	 * to each of the directly contained objects.
	 */
	protected void setTarget(Resource target) {
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
		Iterator<InternalEObject> i = (Iterator<InternalEObject>)((InternalEList<?>)target.eContents()).basicIterator(); i.hasNext();) {
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

	protected void removeAdapter(Notifier notifier) {
		notifier.eAdapters().remove(this);
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
}
