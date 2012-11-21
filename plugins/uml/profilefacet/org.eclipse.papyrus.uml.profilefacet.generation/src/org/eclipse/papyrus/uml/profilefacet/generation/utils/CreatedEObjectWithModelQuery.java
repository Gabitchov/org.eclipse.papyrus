/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.generation.utils;

import java.util.Collection;

import org.eclipse.emf.facet.infra.query.ModelQuery;


public class CreatedEObjectWithModelQuery<T> {

	/**
	 * the created queries required by the created element
	 */
	private final Collection<ModelQuery> queries;

	/**
	 * the created element
	 */
	protected final T createdElement;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param createdElement
	 *        the created element
	 * @param queries
	 *        the list of created queries used to manipaluate the created element
	 */
	public CreatedEObjectWithModelQuery(final T createdElement, final Collection<ModelQuery> queries) {
		this.createdElement = createdElement;
		this.queries = queries;
	}

	/**
	 * 
	 * @return
	 *         the list of created ModelQuery to manipulate the created element
	 */
	public Collection<ModelQuery> getCreatedQueries() {
		return this.queries;
	}

	/**
	 * 
	 * @return
	 *         the created element
	 */
	public T getCreatedElement() {
		return this.createdElement;
	}
}
