/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;


/**
 * Specialized resource factory that delegates the custom Papyrus CDO Text resource
 * URI scheme to registrations by extension.
 */
public class CDOTextDelegatingResourceFactory implements Factory {

	private final Resource.Factory.Registry registry;

	public CDOTextDelegatingResourceFactory(Resource.Factory.Registry registry) {
		super();

		this.registry = registry;
	}

	public Resource createResource(URI uri) {
		Resource.Factory delegate = ResourceFactoryRegistryImpl.convert(registry.getExtensionToFactoryMap().get(uri.fileExtension()));
		return (delegate != null) ? delegate.createResource(uri) : null;
	}

}
