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
package org.eclipse.papyrus.team.collaborative.utils.funtions;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.utils.URIUtils;

import com.google.common.base.Function;


/**
 * The Class ExtendedURIToIResource.
 * Function used to convert {@link ExtendedURI} to {@link IResource}
 */
public class ExtendedURIToIResource implements Function<IExtendedURI, IResource> {

	/** The resource set. */
	private ResourceSet resourceSet;

	/**
	 * Instantiates a new extended uri to i resource.
	 * 
	 * @param resourceSet
	 *        the resource set
	 */
	public ExtendedURIToIResource(ResourceSet resourceSet) {
		super();
		this.resourceSet = resourceSet;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public IResource apply(IExtendedURI from) {
		URI uri = from.getUri();
		IResource result = null;
		if(URIUtils.isEObject(from.getUri(), resourceSet)) {
			result = WorkspaceSynchronizer.getFile(resourceSet.getEObject(uri, false).eResource());
		} else if(URIUtils.isResourceURI(from.getUri(), resourceSet)) {
			Resource resource = resourceSet.getResource(from.getUri(), false);
			result = WorkspaceSynchronizer.getFile(resource);
		} else {
			result = URIUtils.getFile(uri);
			if(result == null) {
				result = URIUtils.getFolder(uri);
			}
		}
		return result;
	}

}
