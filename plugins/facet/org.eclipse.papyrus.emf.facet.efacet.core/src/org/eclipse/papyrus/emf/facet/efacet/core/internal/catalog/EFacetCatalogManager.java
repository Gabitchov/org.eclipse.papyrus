/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Gregoire Dupe (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 *  Nicolas Guyomar (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 *  Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 */
package org.eclipse.emf.facet.efacet.core.internal.catalog;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.QuerySet;
import org.eclipse.emf.facet.efacet.catalog.efacetcatalog.EfacetcatalogFactory;
import org.eclipse.emf.facet.efacet.catalog.efacetcatalog.FacetSetCatalog;
import org.eclipse.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog;
import org.eclipse.emf.facet.efacet.core.internal.Messages;
import org.eclipse.emf.facet.util.emf.catalog.CatalogSet;
import org.eclipse.emf.facet.util.emf.core.ICatalogManager;

/** @deprecated replaced by {@link EFacetCatalogManager2} for the new eFacet2 metamodel */
@Deprecated
public class EFacetCatalogManager implements ICatalogManager {

	private final FacetSetCatalog facetSetCatalog;
	private final QuerySetCatalog querySetCatalog;

	public EFacetCatalogManager() {
		this.facetSetCatalog = EfacetcatalogFactory.eINSTANCE.createFacetSetCatalog();
		this.facetSetCatalog.setName(Messages.EFacetCatalogManager_FacetSetCatalogName);
		this.querySetCatalog = EfacetcatalogFactory.eINSTANCE.createQuerySetCatalog();
		this.querySetCatalog.setName(Messages.EFacetCatalogManager_QuerySetCatalogName);
	}

	public boolean canBeManaged(final EObject root) {
		return root instanceof QuerySet || root instanceof FacetSet;
	}

	public void manage(final EObject root) {
		if (root instanceof FacetSet) {
			FacetSet facetSet = (FacetSet) root;
			this.facetSetCatalog.getInstalledEntries().add(facetSet);
		} else if (root instanceof QuerySet) {
			QuerySet querySet = (QuerySet) root;
			this.querySetCatalog.getInstalledEntries().add(querySet);
		}
	}

	public void setCatalogSet(final CatalogSet catalogSet) {
		catalogSet.getCatalogs().add(this.facetSetCatalog);
		catalogSet.getCatalogs().add(this.querySetCatalog);
	}
}
