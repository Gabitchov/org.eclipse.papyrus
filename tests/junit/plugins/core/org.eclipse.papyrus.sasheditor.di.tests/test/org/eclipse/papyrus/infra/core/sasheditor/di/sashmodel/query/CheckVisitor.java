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

import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;


/**
 * @author cedric dumoulin
 *
 */
public class CheckVisitor implements IQueryVisitor {

	/**
	 * @return the isVisitingParentFirst
	 */
	public boolean isVisitingParentFirst() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.WindowTerm, org.eclipse.papyrus.infra.core.sashwindows.di.Window)
	 *
	 * @param windowTerm
	 * @param windowModel
	 */
	public void visit(WindowTerm windowTerm,  org.eclipse.papyrus.infra.core.sashwindows.di.Window windowModel) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Folder)
	 *
	 * @param folder
	 */
	public void visit(Folder folder, TabFolder folderModel) {
		// Check name
		
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.HSash)
	 *
	 * @param sash
	 */
	public void visit(HSash sash, SashPanel sashModel) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.VSash)
	 *
	 * @param sash
	 */
	public void visit(VSash sash , SashPanel sashModel) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Page)
	 *
	 * @param page
	 * @throws NoMatchException 
	 */
	public void visit(Page page, PageRef pageModel) throws QueryException {
		//check name
		if(page.getIdentifier() != null) {
			checkName(page.getIdentifier(), pageModel.getPageIdentifier()) ;
		}
		else if(page.getName() != null) {
			checkName(page.getName(), pageModel.getPageIdentifier()) ;
		}
	}


	protected void checkName( Object expectedName, Object foundName) throws NoMatchException {
		if( expectedName != foundName )
			throw new NoMatchException( "Names do not match (expected=" 
		             + expectedName + ", found="+ foundName );
	}
}
