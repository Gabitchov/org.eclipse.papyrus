/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * 
 * This class provides methods for EMF Resource
 * 
 */
public class ResourceUtils {

	private ResourceUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param resource
	 *        an EMF resource
	 * @return
	 *         the IFile corresponding to this resource, or <code>null</code> if not found
	 */
	public static IFile getFile(final Resource resource) {
		if(resource != null) {
			URI uri = resource.getURI();
			uri = resource.getResourceSet().getURIConverter().normalize(uri);
			if(uri.isPlatformResource()) { 
				String uriPlatformString = uri.toPlatformString(true) ;
				return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uriPlatformString));
			}
		}
		return null;
	}

	/**
	 * 
	 * 
	 * @param resource
	 *        a resource
	 * @return
	 *         a collection with all existing id in the resource
	 * 
	 */
	public static Collection<String> getAllResourceIds(final XMIResource resource) {
		final Set<String> ids = new HashSet<String>();
		final Iterator<EObject> iterator = resource.getAllContents();
		while(iterator.hasNext()) {
			final EObject current = iterator.next();
			final String id = resource.getID(current);
			Assert.isNotNull(id);
			Assert.isTrue(!ids.contains(id));
			ids.add(id);
		}
		return ids;
	}
}
