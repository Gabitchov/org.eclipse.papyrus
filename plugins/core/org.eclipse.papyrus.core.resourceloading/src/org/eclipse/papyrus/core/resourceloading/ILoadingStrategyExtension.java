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
package org.eclipse.papyrus.core.resourceloading;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.resource.ModelSet;

/**
 * The Interface ILoadingStrategyExtension.
 */
public interface ILoadingStrategyExtension {

	/**
	 * Check if the resource from the uri need to be loaded, no matter which strategy is set.
	 *
	 * @param modelSet the model set
	 * @param uri the uri of the eObject
	 * @return true if resource must be loaded irrespective of strategy, return false otherwise
	 */
	boolean loadResource(ModelSet modelSet, URI uri);
}
