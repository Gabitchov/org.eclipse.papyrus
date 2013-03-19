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
 * @author dumoulin
 *
 */
public class HSash extends AbstractSash {

	/**
	 * Constructor.
	 *
	 * @param leftup
	 * @param rightdown
	 */
	public HSash(PanelTerm up, PanelTerm down) {
		super(up, down);
	}

	/**
	 * Constructor.
	 *
	 * @param leftup
	 * @param rightdown
	 */
	public HSash(String name, PanelTerm up, PanelTerm down) {
		super(name, up, down);
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
		return "HSash";
	}


}
