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
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;

/**
 * A term representing a Window in the query
 * 
 * @author cedric dumoulin
 *
 */
public class WindowTerm implements IQueryTerm {

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
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryTerm#accept(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor, org.eclipse.emf.ecore.EObject)
	 *
	 * @param visitor
	 * @param panel
	 * @throws QueryException
	 */
	public void accept(IQueryVisitor visitor, EObject model) throws QueryException {

		// Check associated model type
		if(! (model instanceof Window) ) {
			throw new NoMatchException( "Model object type does not match to Window" );
		}
		
		Window window = (Window)model;

		if( visitor.isVisitingParentFirst() ) {
			visitor.visit(this, window);
		}
		// visit children
		panel.accept(visitor, window.getPanel());
		
		if( ! visitor.isVisitingParentFirst() ) {
			visitor.visit(this, window);
		}

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
