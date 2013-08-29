/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.query;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;


/**
 * A pluggable provider of query implementations for URIs in different domains (workspace, CDO repositories, etc.).
 * Providers are registered with a priority ordering. The first provider that returns a query for a given URI wins;
 * lower-priority providers are not consulted.
 */
public interface IPapyrusQueryProvider {

	/**
	 * Asks whether this provider can query a resource (or resources) identified by the given {@code scope} URI.
	 * This method is used to partition the overall search scope by query provider.
	 * 
	 * @param scope
	 *        a URI identifying one or more model resources in the workspace or elsewhere
	 * 
	 * @return whether I can provide a query on this scope. If I can, I had better be prepared to supply one
	 *         {@linkplain #createSimpleSearchQuery(String, boolean, boolean, boolean, Collection) when asked}
	 *         
	 * @see #createSimpleSearchQuery(String, boolean, boolean, boolean, Collection)
	 * @see #createAdvancedSearchQuery(String, boolean, boolean, Collection, Collection)
	 */
	boolean canProvideFor(URI scope);

	/**
	 * Creates a simple text-based search query.
	 * 
	 * @param queryInfo
	 *        the query parameters
	 * 
	 * @return the simple (for the user!) search query
	 */
	AbstractPapyrusQuery createSimpleSearchQuery(QueryInfo queryInfo);

	/**
	 * Creates an advanced text-based search query.
	 * 
	 * @param queryInfo
	 *        the query parameters
	 * 
	 * @return the advanced (for the user!) search query
	 */
	AbstractPapyrusQuery createAdvancedSearchQuery(QueryInfo queryInfo);
	
	//
	// Nested types
	//

}
