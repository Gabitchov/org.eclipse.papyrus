/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.navigation.provider;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;


/**
 * 
 * A Provider to retrieve an implementation of a NavigationTarget from a ServicesRegistry.
 * Implementations can retrieve e.g. the current ModelExplorer view, the Nested active editor, etc.
 * 
 * @author Camille Letavernier
 * 
 */
public interface NavigationTargetProvider {

	/**
	 * 
	 * Returns an implementation of a NavigationTarget from the given context
	 * 
	 * @param registry
	 * @return
	 *         A NavigationTarget, or null if it is not available
	 */
	public NavigationTarget getNavigationTarget(ServicesRegistry registry);
}
