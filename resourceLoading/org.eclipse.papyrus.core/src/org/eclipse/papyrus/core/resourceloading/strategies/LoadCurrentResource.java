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
import org.eclipse.papyrus.core.utils.DiResourceSet;


public class LoadCurrentResource implements ILoadingStrategy {

	/**
	 * {@inheritDoc} 
	 * Only loads additional resources (types, profiles, etc) and the current opened resource
	 * Controlled resources from the current one are not loaded
	 */
	public boolean loadResource(DiResourceSet diResourceSet, URI uri) {
		return (!uri.isPlatform() && !uri.isFile());
	}

}
