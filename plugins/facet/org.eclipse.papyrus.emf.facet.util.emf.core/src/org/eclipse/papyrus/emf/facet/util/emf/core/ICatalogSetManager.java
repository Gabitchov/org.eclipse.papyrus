/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	 Gregoire Dupe (Mia-Software) - Bug 334000 Simple catalog manager
 *   Nicolas Guyomar (Mia-Software) - Bug 334000 Simple catalog manager
 *   Nicolas Guyomar (Mia-Software) - Bug 334529 ICatalogManager should be exposed in org.eclipse.emf.facet.common.core
 *   Nicolas Guyomar (Mia-Software) - Bug 338811 - A model registration method in the interface ICatalogSetManager
 *   Gregoire Dupe (Mia-Software) - Bug 362084 - Get the instance of a catalog manager
 *   Gregoire Dupe (Mia-Software) - Bug 362087 - [Deprecated] org.eclipse.emf.facet.util.emf.core.ICatalogSetManager
 */
package org.eclipse.emf.facet.util.emf.core;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.util.emf.catalog.Catalog;
import org.eclipse.emf.facet.util.emf.catalog.CatalogSet;
import org.eclipse.emf.facet.util.emf.core.exception.InvalidFacetSetException;
import org.eclipse.emf.facet.util.emf.core.internal.catalog.CatalogSetManager;
import org.osgi.framework.Bundle;

/**
 * @deprecated This interface has been replaced by {@link ICatalogSetManager2}
 */
@Deprecated
public interface ICatalogSetManager {

	/**
	 * This method returns the {@link CatalogSet} object which contains all the registered catalogs.
	 *
	 * @return the set of registered {@link Catalog}s
	 */
	public CatalogSet getCatalogSet();

	/**
	 * The singleton instance of this {@link ICatalogSetManager}.
	 */
	public static ICatalogSetManager INSTANCE = CatalogSetManager.INSTANCE;

	/**
	 * Return the bundle containing the file from which we have created the given resource.
	 *
	 * @param eResource
	 * @return the Bundle matching the given resource.
	 * @author Nicolas Guyomar
	 */
	public Bundle getBundleByResource(Resource eResource);

	/**
	 * This method takes a file to register it as a "modelDeclaration" extension in its containing
	 * plug-in.
	 *
	 * @param file
	 *            the file to be registered as a "modelDeclaration"
	 * @throws InvalidFacetSetException
	 */
	public void registerModelDeclaration(IFile file) throws InvalidFacetSetException;

}
