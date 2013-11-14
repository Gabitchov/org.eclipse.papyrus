/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Interface that all listeners to the resource load/unload state should implement. The {@link ModelSet} notifies all these listeners  
 */
public interface IResourceLoadStateListener {
	
	void notifyLoadStateChanged(Resource resource, boolean newState);
	
}
