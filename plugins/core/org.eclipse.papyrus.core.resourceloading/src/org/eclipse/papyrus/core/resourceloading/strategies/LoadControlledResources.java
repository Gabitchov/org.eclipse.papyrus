/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.strategies;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.core.resourceloading.ILoadingStrategy;
import org.eclipse.papyrus.resource.ModelSet;


public class LoadControlledResources implements ILoadingStrategy {

	/**
	 * {@inheritDoc} 
	 * Loads additional resources (types, profiles, etc) 
	 * The controlled resources from the current one are loaded
	 * Other resources used from references are not loaded
	 */
	public boolean loadResource(ModelSet modelSet, URI uri) {
		return (!uri.isPlatform() && !uri.isFile());
		// use cache adapter, find references.
		// Load the current resource, for each proxy search if in the historic and load it
	}

}
