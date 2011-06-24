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

import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.controlmode.history.HistoryModel;
import org.eclipse.papyrus.controlmode.history.utils.HistoryUtils;
import org.eclipse.papyrus.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.resource.ModelSet;

/**
 * This manager navigates in the history to access to controlled resources
 * 
 * @author tfaure
 * 
 */
public class HistoryRoutingManager {

	private ControledResourceAdapter adapter;

	private final IProxyManager proxyManager;

	public HistoryRoutingManager(IProxyManager proxyManager) {
		this.proxyManager = proxyManager;
	}

	/**
	 * Returns the eobject navigating through the history
	 * 
	 * @param modelSet
	 * @param resourceURI
	 * @param fragment
	 * @return
	 */
	public EObject getEObject(ModelSet modelSet, String resourceURI, String fragment) {
		adapter = HistoryRoutingUtils.getControledResourceAdapter(modelSet);
		EObject result = null;
		HistoryModel historyModel = HistoryUtils.getHistoryModel(modelSet);
		if(historyModel != null) {
			List<ControledResource> res = adapter.getControledResource(resourceURI);
			if(res != null) {
				for(ControledResource controled : res) {
					for(ControledResource child : controled.getChildren()) {
						URI locationURI = URI.createURI(child.getResourceURL());
						URI toGet = locationURI.resolve(HistoryUtils.getURIFullPath(child.eResource().getURI()));
						Resource resource = modelSet.getResource(toGet, proxyManager.loadResource(locationURI));
						if(resource != null) {
							result = resource.getEObject(fragment);
							if(result != null) {
								break;
							} else {
								result = getEObject(modelSet, child.getResourceURL(), fragment);
								if(result != null) {
									break;
								}
							}
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * Unload the routing manager dropping the ControledResourceAdapter
	 */
	public void unload() {
		if(adapter != null) {
			Notifier resSet = adapter.getTarget();
			resSet.eAdapters().remove(adapter);
			adapter = null;
		}
	}

}
