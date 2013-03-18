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

package org.eclipse.papyrus.infra.core.sasheditor.pagesmodel;


/**
 *  Common ancestor of Panel (Folder and Sash) in queries structure.
 *  <br>
 *  This class can also be used a starting point of query expression (and so Folder, VSash and HSash).
 * 
 * @author cedric dumoulin
 *
 */
public abstract class PanelTerm implements IModelExp {

	protected String name;
	
	
	/**
	 * Constructor.
	 *
	 */
	public PanelTerm() {
	}
	
	/**
	 * Constructor.
	 *
	 * @param name
	 */
	public PanelTerm(String name) {
		this.name = name;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.IModelObject.sashmodel.query.IQueryTerm#accept(org.eclipse.papyrus.infra.core.sasheditor.IPagesModelVisitor.sashmodel.query.IQueryVisitor, org.eclipse.emf.ecore.EObject)
	 *
	 * @param visitor
	 * @param panel
	 * @throws PagesModelException
	 */
	public <M> void accept(IPagesModelVisitor<M> visitor, M panel)
			throws PagesModelException {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
