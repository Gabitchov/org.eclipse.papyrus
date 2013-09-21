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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.common.collect.ImmutableMap;


/**
 * A partial implementation of the object localizer.
 */
public abstract class AbstractObjectLocalizer implements IObjectLocalizer {

	public AbstractObjectLocalizer() {
		super();
	}

	@Override
	public Map<EObject, EObject> getLocalEObjects(ResourceSet localSet, Iterable<? extends EObject> remoteObjects) {
		ImmutableMap.Builder<EObject, EObject> result = ImmutableMap.builder();

		for(EObject next : remoteObjects) {
			result.put(next, getLocalEObject(localSet, next));
		}

		return result.build();
	}

	@Override
	public Map<Resource, Resource> getLocalResources(ResourceSet localSet, Iterable<? extends Resource> remoteResources) {
		ImmutableMap.Builder<Resource, Resource> result = ImmutableMap.builder();

		for(Resource next : remoteResources) {
			result.put(next, getLocalResource(localSet, next));
		}

		return result.build();
	}

	protected ResourceSet getResourceSet(EObject object) {
		Resource resource = null;

		// in CDO, resources are EObjects
		if(object instanceof Resource) {
			resource = (Resource)object;
		} else if(object != null) {
			resource = object.eResource();
		}

		return (resource == null) ? null : resource.getResourceSet();
	}
}
