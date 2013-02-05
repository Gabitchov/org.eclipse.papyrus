/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query;

import org.eclipse.emf.ecore.EObject;

/**
 * A Query term is a part of a Query expression.
 * All term that can be used in a query should implement this interface.
 * 
 * @author cedric dumoulin
 *
 */
public interface IQueryTerm {

	/**
	 * Visit the query.
	 * @param visitor
	 * @throws QueryException 
	 */
	public void accept(IQueryVisitor visitor, EObject panel) throws QueryException;
	
	/**
	 * Get the name associated to the query part.
	 * Can return null;
	 */
	public String getName();
}
