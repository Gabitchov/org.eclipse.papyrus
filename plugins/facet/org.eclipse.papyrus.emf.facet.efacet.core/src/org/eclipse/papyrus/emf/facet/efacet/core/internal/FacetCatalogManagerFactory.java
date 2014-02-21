/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning 
 */
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetSetCatalogManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.util.emf.core.ICatalogSetManagerFactory;

public class FacetCatalogManagerFactory implements IFacetSetCatalogManagerFactory {

	public IFacetSetCatalogManager getOrCreateFacetSetCatalogManager(
			final ResourceSet resourceSet) {
		return ICatalogSetManagerFactory.DEFAULT
				.createICatalogSetManager(resourceSet)
				.getCatalogManagerByType(IFacetSetCatalogManager.class)
				.get(0);
	}

}
