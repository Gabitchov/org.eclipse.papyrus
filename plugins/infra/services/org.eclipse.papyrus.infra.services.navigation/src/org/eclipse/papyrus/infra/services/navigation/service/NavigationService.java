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

import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.widgets.editors.SelectionMenu;
import org.eclipse.swt.widgets.Control;

/**
 * A Service to navigate from an element.
 * The navigation is based on external contributions.
 * 
 * Examples:
 * - Navigate from a TypedElement to its Type declaration in the ModelExplorer
 * - ...
 * 
 * @author Camille Letavernier
 * 
 * @see NavigationContributor
 */
public interface NavigationService extends IService, NavigationContributor {

	public SelectionMenu createNavigationList(Object data, Control parent);

	public void navigate(NavigableElement navigableElement);
}
