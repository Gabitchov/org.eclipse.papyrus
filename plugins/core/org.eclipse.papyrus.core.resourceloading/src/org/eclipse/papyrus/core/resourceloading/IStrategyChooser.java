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


/**
 * The Interface IStrategyChooser that provides the current loading strategy to the proxy manager.
 * Proxy manager load the resource if needed, according to the current strategy
 */
public interface IStrategyChooser {

	/**
	 * Gets the current strategy ID.
	 * Proxy manager load the resource if needed, according to the current strategy
	 * 
	 * @return the current strategy id
	 */
	int getCurrentStrategy();
}
