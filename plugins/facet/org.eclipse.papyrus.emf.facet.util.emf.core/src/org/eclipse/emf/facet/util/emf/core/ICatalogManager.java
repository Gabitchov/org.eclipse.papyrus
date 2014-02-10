/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	  Gregoire Dupe (Mia-Software) - Bug 334000 Simple catalog manager
 *    Nicolas Guyomar (Mia-Software) - Bug 334000 Simple catalog manager
 */
package org.eclipse.emf.facet.util.emf.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.util.emf.catalog.CatalogSet;
import org.eclipse.emf.facet.util.emf.core.internal.catalog.CatalogSetManager;

/**
 * Manager for catalogs containing registered elements defined in models.
 *
 * @since 0.2
 * @noextend This interface is not intended to be extended by clients.
 */
public interface ICatalogManager {

	/**
	 * Return <code>true</code> if the eObject can be managed as a catalog entry.
	 *
	 * @param root
	 *            the root element of a catalog
	 * @return whether the given element is of the right type to be a catalog root
	 */
	public boolean canBeManaged(EObject root);

	/**
	 * This method is called by {@link CatalogSetManager} when a model registration that can be
	 * managed (according to {@link ICatalogManager#canBeManaged(EObject) canBeManaged}) is detected
	 * while loading. This method adds the given root model element to the catalog.
	 *
	 * @param root
	 *            a root element of a model that should be added to the catalog
	 */
	public void manage(EObject root);

	/**
	 * This method is called by the {@link CatalogSetManager} after the instantiation of this
	 * {@link ICatalogManager}. This method must attach the catalog(s) managed by this
	 * {@link ICatalogManager} to the given <code>catalogSet</code>.
	 *
	 * @param catalogSet
	 *            the {@link CatalogSet} to which the catalog managed by this
	 *            {@link ICatalogManager} should be attached
	 */
	public void setCatalogSet(CatalogSet catalogSet);

}
