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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * 
 * Thios class provides methods for EMF Resource
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
			String scheme = uri.scheme();
			if("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) { //$NON-NLS-1$ //$NON-NLS-2$
				StringBuffer platformResourcePath = new StringBuffer();
				for(int j = 1, size = uri.segmentCount(); j < size; ++j) {
					platformResourcePath.append('/');
					platformResourcePath.append(uri.segment(j));
				}
				return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourcePath.toString()));
			}
		}
		return null;
	}
}
