/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.localizer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * The default object localizer simply assumes that resources and objects can be loaded in the local resource set in the usual way.
 */
public class DefaultObjectLocalizer extends AbstractObjectLocalizer {

	public static final DefaultObjectLocalizer INSTANCE = new DefaultObjectLocalizer();
	
	public DefaultObjectLocalizer() {
		super();
	}

	@Override
	public EObject getLocalEObject(ResourceSet localSet, EObject remoteObject) {
		EObject result = null;

		if(getResourceSet(remoteObject) == localSet) {
			result = remoteObject;
		} else {
			URI uri = EcoreUtil.getURI(remoteObject);
			if(uri != null) {
				result = localSet.getEObject(uri, true);
			}
		}

		return result;
	}

	@Override
	public Resource getLocalResource(ResourceSet localSet, Resource remoteResource) {
		Resource result = null;

		if(remoteResource != null) {
			if(remoteResource.getResourceSet() == localSet) {
				result = remoteResource;
			} else {
				result = localSet.getResource(remoteResource.getURI(), false);
				if(result == null) {
					// create but don't load
					result = localSet.createResource(remoteResource.getURI(), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
				}
			}
		}

		return result;
	}

}
