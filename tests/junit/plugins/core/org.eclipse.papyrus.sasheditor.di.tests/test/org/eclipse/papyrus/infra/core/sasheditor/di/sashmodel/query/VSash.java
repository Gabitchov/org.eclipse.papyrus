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
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;

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
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryTerm#accept(IQueryVisitor, EObject)
	 *
	 * @param visitor
	 * @throws QueryException 
	 */
	public void accept(IQueryVisitor visitor, EObject modelObject) throws QueryException {
		// Check associated model type
		if(! (modelObject instanceof SashPanel) ) {
			throw new NoMatchException( "Model object type does not match to SashPanel" );
		}
		
		SashPanel sashModel = (SashPanel)modelObject;

		// Visit this
		if( visitor.isVisitingParentFirst() ) {
			visitor.visit(this, sashModel);
		}
		
		// Visit children
		leftup.accept(visitor, sashModel.getChildren().get(0));
		rightdown.accept(visitor, sashModel.getChildren().get(1));

		// Visit this
		if( !visitor.isVisitingParentFirst() ) {
			visitor.visit(this, sashModel);
		}
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
