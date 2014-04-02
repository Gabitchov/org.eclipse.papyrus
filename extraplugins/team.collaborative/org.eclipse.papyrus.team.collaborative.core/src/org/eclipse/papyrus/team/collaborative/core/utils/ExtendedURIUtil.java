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
package org.eclipse.papyrus.team.collaborative.core.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;


public class ExtendedURIUtil {


	/**
	 * Return true if all
	 * 
	 * @param input
	 * @param resourceExtendedURI
	 * @param resourceSet
	 * @return
	 */
	protected static boolean isEObjectContainedResourceExtendedURI(EObject input, IExtendedURI resourceExtendedURI, ResourceSet resourceSet) {
		URI uri = resourceExtendedURI.getUri();
		if(resourceExtendedURI.isContainment()) {
			Resource resource = resourceSet.getResource(uri, false);
			for(EObject rootObject : resource.getContents()) {
				if(EcoreUtil.isAncestor(rootObject, input)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isIncluded(EObject input, IExtendedURI extendedURI) {
		if(input != null) {
			Resource eResource = input.eResource();
			if(eResource != null) {
				ResourceSet resourceSet = eResource.getResourceSet();
				URI uri = extendedURI.getUri();
				//If same URI ok
				if(uri.equals(input.eResource().getURI())) {
					return true;
				}
				if(URIUtils.isResourceURI(uri, resourceSet)) {
					//If resource
					return ExtendedURIUtil.isEObjectContainedResourceExtendedURI(input, extendedURI, resourceSet);
				} else if(URIUtils.isEObject(uri, resourceSet)) {
					//If EObject
					if(extendedURI.isContainment()) {
						EObject eObject = resourceSet.getEObject(uri, false);
						if(EcoreUtil.isAncestor(eObject, input)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
