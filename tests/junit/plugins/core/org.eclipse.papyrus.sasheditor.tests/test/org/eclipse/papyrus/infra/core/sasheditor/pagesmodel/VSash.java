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

import org.eclipse.emf.ecore.EObject;

/**
 * Class for structure representing vertical sash in Checker
 * 
 * @author dumoulin
 *
 */
public class VSash extends AbstractSash {

	/**
	 * Constructor.
	 *
	 * @param leftup
	 * @param rightdown
	 */
	public VSash(PanelTerm left, PanelTerm right) {
		super(left, right);
	}
	
	/**
	 * Constructor.
	 *
	 * @param leftup
	 * @param rightdown
	 */
	public VSash(String name, PanelTerm left, PanelTerm right) {
		super(name, left, right);
	}
	
	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.IModelObject.sashmodel.query.IQueryTerm#accept(IPagesModelVisitor, EObject)
	 *
	 * @param visitor
	 * @throws PagesModelException 
	 */
	public <M> void accept(IPagesModelVisitor<M> visitor, M modelObject) throws PagesModelException {
		visitor.walk(this, modelObject);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.AbstractSash#getStringName()
	 *
	 * @return
	 */
	@Override
	protected String getStringName() {
		return "VSash";
	}

}
