/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *     Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.core;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.core.internal.FacetManagerFactory;

/**
 * Factory for {@link IFacetManager}.
 *
 * @since 0.2
 */
public interface IFacetManagerFactory {

	/**
	 * The singleton instance of the factory.
	 */
	IFacetManagerFactory DEFAULT = new FacetManagerFactory();

	/**
	 * Create an {@link IFacetManager}.
	 *
	 * @param resource
	 *            the {@link Resource} in which virtual {@link EStructuralFeature}s are serialized.
	 *            Can be null if no EStructuralFeature provided a Facet are used.
	 */
	IFacetManager getOrCreateFacetManager(Resource resource);

	/**
	 * Create an {@link IFacetManager}.
	 * 
	 * @param resourceSet
	 *            the resourceSet which will be used to manage the facet models.
	 * 
	 */
	IFacetManager getOrCreateFacetManager(ResourceSet resourceSet);
}
