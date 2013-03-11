/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.navigation.service;

import java.util.List;

/**
 * A NavigationContributor is used to contribute navigation actions
 * to the navigation service. Each contributor can be enabled/disabled
 * from the preferences. It is used to group related NavigableElements
 * 
 * @author Camille Letavernier
 */
public interface NavigationContributor {

	public List<NavigableElement> getNavigableElements(Object fromElement);
}
