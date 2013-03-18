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
 * A term representing a Window in the query
 * 
 * @author cedric dumoulin
 *
 */
public class WindowTerm implements IModelExp {

	/**
	 * A window have only one panel.
	 */
	protected PanelTerm panel;

	protected String name;
	
	/**
	 * Constructor.
	 *
	 * @param panel
	 */
	public WindowTerm(PanelTerm panel) {
		this.panel = panel;
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * @param panel
	 */
	public WindowTerm(String name, PanelTerm panel) {
		this.name = name;
		this.panel = panel;
	}


	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.IModelObject.sashmodel.query.IQueryTerm#accept(org.eclipse.papyrus.infra.core.sasheditor.IPagesModelVisitor.sashmodel.query.IQueryVisitor, org.eclipse.emf.ecore.EObject)
	 *
	 * @param visitor
	 * @param panel
	 * @throws PagesModelException
	 */
	public <M> void accept(IPagesModelVisitor<M> visitor, M windowModel) throws PagesModelException {

		visitor.walk(this, windowModel);

	}


	/**
	 * @return the panel
	 */
	public PanelTerm getPanel() {
		return panel;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
