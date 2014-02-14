/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.emf.facet.efacet.ui.internal.exported.view;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.ui.internal.view.NavigationViewFactory;

/**
 * This interface allows to get an instance of the {@link INavigationView} interface
 * 
 * @author Gregoire Dupe
 * 
 */
public interface INavigationViewFactory {

	/**
	 * This is the default instance of this interface.
	 */
	INavigationViewFactory DEFAULT = new NavigationViewFactory();

	/**
	 * This method is the only way to open and access the navigation view.
	 * @param editingDomain 
	 * 
	 * @return an instance of {@link INavigationView}
	 */
	INavigationView openNavigationView(EditingDomain editingDomain);

}
