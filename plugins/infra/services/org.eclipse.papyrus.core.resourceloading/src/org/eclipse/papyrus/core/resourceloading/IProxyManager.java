/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;


/**
 * Interface providing services to load resources and resolves Proxies
 * 
 * @author tfaure
 * 
 */
public interface IProxyManager {

	/**
	 * Release the different resources to free memory
	 */
	void dispose();

	/**
	 * Returns an eobject from a strategy, the implementation manages itself its resources
	 * 
	 * @param uri
	 * @return
	 */
	EObject getEObjectFromStrategy(URI uri);

	/**
	 * Returns true if the proxy manager will load the resource located at the URI
	 * 
	 * @param uri
	 * @return
	 */
	boolean loadResource(URI uri);

}
