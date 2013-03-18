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

package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Folder;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.HSash;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IPagesModelVisitor;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.NoMatchException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Page;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.VSash;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.WindowTerm;


/**
 * @author cedric dumoulin
 *
 */
public class CheckVisitor extends SimpleContentProviderBaseVisitor implements IPagesModelVisitor<Object> {

	/**
	 * @return the isVisitingParentFirst
	 */
	@Override
	public boolean isVisitingParentFirst() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.WindowTerm, org.eclipse.papyrus.infra.core.sashwindows.di.Window)
	 *
	 * @param windowTerm
	 * @param windowModel
	 */
	@Override
	public void visit(WindowTerm windowTerm,  RootModel windowModel) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Folder)
	 *
	 * @param folder
	 */
	@Override
	public void visit(Folder folder, TabFolderModel folderModel) {
		// Check name
		
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.HSash)
	 *
	 * @param sash
	 */
	@Override
	public void visit(HSash sash, SashPanelModel sashModel) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.VSash)
	 *
	 * @param sash
	 */
	@Override
	public void visit(VSash sash , SashPanelModel sashModel) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Page)
	 *
	 * @param page
	 * @throws NoMatchException 
	 */
	@Override
	public void visit(Page page, IPageModel pageModel) throws PagesModelException {
		//check name
		if(page.getIdentifier() != null) {
			checkName(page.getIdentifier(), pageModel.getTabTitle()) ;
		}
		else if(page.getName() != null) {
			checkName(page.getName(), pageModel.getTabTitle()) ;
		}
	}


	protected void checkName( Object expectedName, Object foundName) throws NoMatchException {
		if( expectedName != foundName )
			throw new NoMatchException( "Names do not match (expected=" 
		             + expectedName + ", found="+ foundName );
	}
}
