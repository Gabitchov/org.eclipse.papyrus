/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.table.common.util;


/**
 * This class is used to represent the queries used to fill the table.
 * 
 * 
 * 
 */
public class QueryRepresentation {

	/**
	 * the query set name
	 */
	private String querySetName;

	/**
	 * the query name
	 */
	private String queryName;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param querySetName
	 *        the querySet name
	 * @param queryName
	 *        the query name
	 */
	public QueryRepresentation(String querySetName, String queryName) {
		this.querySetName = querySetName;
		this.queryName = queryName;
	}

	/**
	 * Getter for {@link #querySetName}
	 * 
	 * @return
	 *         this{@link #querySetName}
	 */
	public String getQuerySetName() {
		return querySetName;
	}

	/**
	 * Getter for {@link #queryName}
	 * 
	 * @return
	 *         this {@link #queryName}
	 */
	public String getQueryName() {
		return queryName;
	}

}
