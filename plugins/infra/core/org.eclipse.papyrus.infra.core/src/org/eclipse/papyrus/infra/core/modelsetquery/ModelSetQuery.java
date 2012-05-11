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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.modelsetquery;


import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.modelsetquery.impl.ModelSetQueryAdapterSimple;

/**
 * The Class ModelSetQuery provides service to get objects of specified type
 * using cache mechanism
 */
public class ModelSetQuery {

	/**
	 * Return all the objects of specified type
	 * 
	 * @param eobjectInModelSet
	 *        , the object from which to search starts
	 * @param type
	 *        , the searched type
	 * @return the list of the instance of specified type
	 */
	public static Collection<EObject> getObjectsOfType(EObject eobjectInModelSet, EClassifier type) {
		IModelSetQueryAdapter adapter = getExistingTypeCacheAdapter(eobjectInModelSet);
		return adapter.getReachableObjectsOfType(eobjectInModelSet, type);
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
			return ModelSetQueryAdapterSimple.getSimpleTypeCacheAdapter();
		}
		for(Adapter adapter : notifier.eAdapters()) {
			if(adapter instanceof IModelSetQueryAdapter) {
				return (IModelSetQueryAdapter)adapter;
			}
		}
		if(notifier instanceof EObject) {
			EObject object = (EObject)notifier;
			IModelSetQueryAdapter typeCacheAdapter = getExistingTypeCacheAdapter(object.eResource());
			if(typeCacheAdapter instanceof Adapter) {
				object.eAdapters().add((Adapter)typeCacheAdapter);
			}
			if (typeCacheAdapter != null) {
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
		return ModelSetQueryAdapterSimple.getSimpleTypeCacheAdapter();
	}

}
