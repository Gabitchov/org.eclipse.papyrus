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
 *  Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 */
package org.eclipse.papyrus.emf.facet.efacet.core.internal.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.emf.facet.efacet.Query;
import org.eclipse.papyrus.emf.facet.efacet.QuerySet;
import org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryUtils;
import org.eclipse.papyrus.emf.facet.util.emf.core.ICatalogSetManager;
import org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog;

/**
 * @deprecated This class manipulated the old facet metamodel. With the new eFacet2 metamodel, there
 *             are no QuerySets anymore. Queries are used only in Facets.
 */
@Deprecated
public class QueryUtilsImpl implements IQueryUtils {

	public Query searchQuery(final String querySetName, final String queryName) {
		List<QuerySetCatalog> querySetCatalogs = new ArrayList<QuerySetCatalog>();
		List<Catalog> catalogs = ICatalogSetManager.INSTANCE.getCatalogSet()
				.getCatalogs();
		for (Catalog catalog : catalogs) {
			if (catalog instanceof QuerySetCatalog) {
				querySetCatalogs.add((QuerySetCatalog) catalog);
			}
		}
		
		QuerySet searchedQuerySet = null;
		for (QuerySetCatalog querySetCatalog : querySetCatalogs) {
			List<QuerySet> querySets = querySetCatalog.getInstalledQuerySets();
			for (QuerySet querySet : querySets) {
				if (querySet.getName() != null
						&& querySet.getName().equals(querySetName)) {
					searchedQuerySet = querySet;
				}
			}
		}
		Query searchedQuery = null;
		if (searchedQuerySet != null) {
			for (Query query : searchedQuerySet.getQueries()) {
				if (query.getName() != null
						&& query.getName().equals(queryName)) {
					searchedQuery = query;
				}
			}
		}
		return searchedQuery;
	}

}
