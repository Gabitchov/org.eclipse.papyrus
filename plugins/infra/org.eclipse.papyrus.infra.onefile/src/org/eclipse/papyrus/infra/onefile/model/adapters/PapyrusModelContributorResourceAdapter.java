/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.model.adapters;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.ide.IContributorResourceAdapter2;


/**
 * Another Adapter
 * 
 * @author tfaure
 * 
 */
public class PapyrusModelContributorResourceAdapter implements IContributorResourceAdapter2 {

	public IResource getAdaptedResource(IAdaptable adaptable) {
		IResource res = (IResource)adaptable.getAdapter(IResource.class);
		return res;
	}

	public ResourceMapping getAdaptedResourceMapping(IAdaptable adaptable) {
		ResourceMapping res = (ResourceMapping)adaptable.getAdapter(ResourceMapping.class);
		return res;
	}

}
