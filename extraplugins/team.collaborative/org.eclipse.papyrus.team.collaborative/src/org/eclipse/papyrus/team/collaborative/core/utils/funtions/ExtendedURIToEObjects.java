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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.utils.URIUtils;

import com.google.common.base.Function;


/**
 * The Class ExtendedURIToEObjects.
 * Function used to convert {@link ExtendedURI} to {@link java.util.List} of {@link EObject}
 */
public class ExtendedURIToEObjects implements Function<IExtendedURI, Collection<EObject>> {

	/** The resource set. */
	private ResourceSet resourceSet;

	/**
	 * Instantiates a new extended uri to e objects.
	 * 
	 * @param resourceSet
	 *        the resource set
	 */
	public ExtendedURIToEObjects(ResourceSet resourceSet) {
		super();
		this.resourceSet = resourceSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public Collection<EObject> apply(IExtendedURI from) {
		if(URIUtils.isEObject(from.getUri(), resourceSet)) {
			return Collections.singleton(resourceSet.getEObject(from.getUri(), false));
		} else if(URIUtils.isResourceURI(from.getUri(), resourceSet)) {
			Resource resource = resourceSet.getResource(from.getUri(), false);
			if(resource != null) {
				return resource.getContents();
			}
		}
		return Collections.emptyList();
	}



}
