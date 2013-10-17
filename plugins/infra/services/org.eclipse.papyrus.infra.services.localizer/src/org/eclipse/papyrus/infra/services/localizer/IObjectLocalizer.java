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


/**
 * <p>
 * An object localizer provides the instances of {@link EObject}s and {@link Resource}s in a {@link ResourceSet} (the "local" set) corresponding to
 * instances residing in another resource set (the "remote" set).
 * </p>
 * <p>
 * This accounts for systems such as the CDO model repository in which there are peculiar considerations like:
 * </p>
 * <ul>
 * <li>resources are {@code EObject}s, but treating them as such is not necessarily appropriate to the situation</li>
 * <li>some {@code EObject}s represent text or binary documents (CLOB/BLOB resources) that should not be retrieved by attempting to load their
 * {@link EObject#eResource() eResource} and asking it for the object</li>
 * </ul>
 */
public interface IObjectLocalizer {

	/**
	 * Finds and returns (loading it, if necessary) the local correspondent of the specified remote {@link EObject}.
	 * 
	 * @param localSet
	 *        the local resource set in which to find the object
	 * @param remoteObject
	 *        the remote object to localize
	 * @return the local instance of the {@code remoteObject}, or {@code null} if it is not available locally. This could
	 *         just be the original {@code remoteObject} if the remote resource set is the local set
	 */
	EObject getLocalEObject(ResourceSet localSet, EObject remoteObject);

	/**
	 * Finds and returns (without loading it, though it may have been loaded previously) the local correspondent of the specified remote
	 * {@link Resource}.
	 * 
	 * @param localSet
	 *        the local resource set in which to find the resource
	 * @param remoteResource
	 *        the remote resource to localize
	 * @return the local instance of the {@code remoteResource}, or {@code null} if it is not available locally. This could
	 *         just be the original {@code remoteResource} if the remote resource set is the local set
	 */
	Resource getLocalResource(ResourceSet localSet, Resource remoteResource);

	/**
	 * Finds and returns (loading them, if necessary) the local correspondents of the specified remote {@link EObject}s.
	 * 
	 * @param localSet
	 *        the local resource set in which to find the objects
	 * @param remoteObjects
	 *        the remote objects to localize
	 * @return a mapping of the local instances of the {@code remoteObjects}, keyed by the remotes. For any object, its mapping may be {@code null} if
	 *         it is not available locally or could
	 *         just be the original remote if the remote resource set is the local set. The map must be assumed by callers to be immutable
	 */
	Map<EObject, EObject> getLocalEObjects(ResourceSet localSet, Iterable<? extends EObject> remoteObjects);

	/**
	 * Finds and returns (without loading them, though they may have been loaded previously) the local correspondents of the specified remote
	 * {@link Resource}s.
	 * 
	 * @param localSet
	 *        the local resource set in which to find the resources
	 * @param remoteResources
	 *        the remote resources to localize
	 * @return a mapping of the local instances of the {@code remoteResources}, keyed by the remotes. For any resource, its mapping may be
	 *         {@code null} if it is not available locally or could
	 *         just be the original remote if the remote resource set is the local set. The map must be assumed by callers to be immutable
	 */
	Map<Resource, Resource> getLocalResources(ResourceSet localSet, Iterable<? extends Resource> remoteResources);
}
