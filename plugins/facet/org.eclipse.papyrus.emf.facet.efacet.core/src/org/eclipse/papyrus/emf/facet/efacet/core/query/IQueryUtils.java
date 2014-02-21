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
package org.eclipse.papyrus.emf.facet.efacet.core.query;

import org.eclipse.papyrus.emf.facet.efacet.Query;
import org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.query.QueryUtilsImpl;

/**
 * Utility methods for manipulating queries.
 *
 * @deprecated This class manipulated the old facet metamodel. With the new eFacet2 metamodel, there
 *             are no QuerySets anymore. Queries are used only in Facets. (https://bugs.eclipse.org/bugs/show_bug.cgi?id=381230)
 */
@Deprecated
public interface IQueryUtils {

	/** The singleton {@link IQueryUtils} */
	IQueryUtils INSTANCE = new QueryUtilsImpl();

	/**
	 * This method searches a query in all registered {@link QuerySetCatalog}s.
	 *
	 * @param querySetName
	 *            the name of the querySet to search into.
	 * @param queryName
	 *            the name of the query to search for.
	 * @return the query if found; <code>null</code> otherwise
	 * @deprecated there are no QuerySets anymore. Queries are now a second-level concept only
	 *             defined in Facets. An equivalent is to search for an attribute or operation on a
	 *             Facet : see {@link IFacetUtils}
	 */
	@Deprecated
	public Query searchQuery(String querySetName, String queryName);
}
