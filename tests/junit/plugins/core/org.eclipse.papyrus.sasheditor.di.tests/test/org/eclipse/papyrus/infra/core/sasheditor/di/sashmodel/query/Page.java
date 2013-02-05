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
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;

/**
 * This represent a page in the Checker query.
 * 
 * @author cedric dumoulin
 *
 */
public class Page implements IQueryTerm {

	protected Object identifier;
	
	protected String name;

	/**
	 * Constructor.
	 *
	 */
	public Page() {
		
	}
	
	/**
	 * Constructor.
	 *
	 * @param identifier
	 */
	public Page(Object identifier) {
		this.identifier = identifier;
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * @param identifier
	 */
	public Page(String name) {
		this.name = name;
		this.identifier = name;
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * @param identifier
	 */
	public Page(String name, Object identifier) {
		this.name = name;
		this.identifier = identifier;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryTerm#accept(IQueryVisitor, EObject)
	 *
	 * @param visitor
	 * @throws QueryException 
	 */
	public void accept(IQueryVisitor visitor, EObject modelObject) throws QueryException {
		// Check associated model type
		if(! (modelObject instanceof PageRef) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to PageRef" );
		}
		PageRef pageRef = (PageRef)modelObject;
		visitor.visit(this, pageRef);
	}

	/**
	 * @return the identifier
	 */
	public Object getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(Object identifier) {
		this.identifier = identifier;
	}

	/**
	 * @see java.lang.Object#toString()
	 *
	 * @return
	 */
	@Override
	public String toString() {
		
		return "Page()";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
