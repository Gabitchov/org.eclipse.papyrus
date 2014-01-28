/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.participants;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.utils.URIUtils;

import com.google.common.base.Function;


/**
 * The Class AbstractExtendedURIBuilder.
 * Abstract class for all element that implement {@link IExtendedURISuperSet}
 */
public abstract class AbstractExtendedURIBuilder implements IExtendedURISuperSet {

	/** The uris. */
	private Set<IExtendedURI> uris;

	/** The resource set. */
	private ResourceSet resourceSet;

	/** The uri to handle. */
	private Set<IExtendedURI> uriToHandle;

	/** The to resouce function. */
	private Function<URI, Resource> toResouceFunction = null;


	/**
	 * Instantiates a new abstract extended uri builder.
	 * 
	 * @param uris
	 *        the uris
	 * @param resourceSet
	 *        the resource set
	 */
	public AbstractExtendedURIBuilder(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		this.uris = uris;
		this.resourceSet = resourceSet;
		this.toResouceFunction = new Function<URI, Resource>() {

			@Override
			public Resource apply(URI from) {
				return getResourceSet().getResource(from, false);
			}
		};
		uriToHandle = doBuild();

	}


	/**
	 * Do build.
	 * 
	 * @return the sets the
	 */
	protected abstract Set<IExtendedURI> doBuild();

	/**
	 * Gets the uris.
	 * 
	 * @return the uris
	 */
	protected Set<IExtendedURI> getUris() {
		return uris;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.participants.IExtendedURISuperSet#getResourceSet()
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.participants.IExtendedURISuperSet#getExtendedSet()
	 */
	public Set<IExtendedURI> getExtendedSet() {
		if(uriToHandle == null) {
			uriToHandle = new HashSet<IExtendedURI>();
		}
		return uriToHandle;
	}

	/**
	 * Gets the target resources.
	 * 
	 * @return the target resources
	 */
	protected Set<Resource> getTargetResources() {
		Set<Resource> resourcesTolock = new HashSet<Resource>();
		for(IExtendedURI toLock : getExtendedSet()) {
			Resource resource = getResourceSet().getResource(toLock.getUri(), false);
			if(resource != null) {
				resourcesTolock.add(resource);
			}
		}
		return resourcesTolock;
	}

	/**
	 * To resource.
	 * 
	 * @param uri
	 *        the uri
	 * @return the resource
	 */
	protected Resource toResource(URI uri) {
		if(uri != null) {
			return toResouceFunction.apply(uri);
		}
		return null;

	}



	/**
	 * Gets the resource uri.
	 * 
	 * @param extendedURI
	 *        the extended uri
	 * @return the resource uri
	 */
	protected IExtendedURI getResourceURI(IExtendedURI extendedURI) {
		URI uri = extendedURI.getUri();
		IExtendedURI resourceURI = null;
		if(URIUtils.isResourceURI(uri, getResourceSet())) {
			resourceURI = extendedURI;
		} else if(URIUtils.isEObject(uri, getResourceSet())) {
			resourceURI = new ExtendedURI(uri.trimFragment()).setContainment(extendedURI.isContainment());
		}
		return resourceURI;
	}





}
