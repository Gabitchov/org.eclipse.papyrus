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

import java.util.Iterator;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.AbstractPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.RootModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SashPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.TabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Folder;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.HSash;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IPagesModelVisitor;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.NoMatchException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Page;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.VSash;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.WindowTerm;
import org.eclipse.swt.SWT;

/**
 * A base implementation of {@link IPagesModelVisitor} to visit conjointly SashPagesModel and 
 * SimpleContentProvider.
 * 
 * This implementation separate the navigation part (walk(term, contentProviderModel)) and 
 * the visit part (visit(term, contentProviderModel)). It implements the navigation part.
 * <br>
 * The visit part should be implemented by subclasses.
 * 
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class SimpleContentProviderBaseVisitor implements IPagesModelVisitor<Object> {

	/**
	 * @return the isVisitingParentFirst
	 */
	public boolean isVisitingParentFirst() {
		return true;
	}

	/**
	 * Visit the model. Actually, there is no counterpart for {@link SashPagesModel} in {@link SimpleContentProvider}.
	 *
	 * @param windowTerm
	 * @param windowModel
	 * @throws PagesModelException 
	 */
	public void walk(SashPagesModel pagesModel, Object contentProviderModel) throws PagesModelException {
		// Check associated model type
		if(! (contentProviderModel instanceof SimpleSashWindowsContentProvider) ) {
			throw new NoMatchException( "ContentProvider type ("+ contentProviderModel.getClass().getName()+ ") does not match to WindowTerm" );
		}
		
		SimpleSashWindowsContentProvider contentProvider = (SimpleSashWindowsContentProvider)contentProviderModel;

		if( isVisitingParentFirst() ) {
			visit(pagesModel, contentProvider);
		}
		// visit children
		for( WindowTerm windowTerm : pagesModel.getWindows() ) {
			// Only one window
			RootModel windowModel = (RootModel) ((AbstractPanelModel)contentProvider.getRootModel()).getParent();
			windowTerm.getPanel().accept(this, windowModel);
		}
		if( ! isVisitingParentFirst() ) {
			visit(pagesModel, contentProvider);
		}
	}

	/**
	 * Walk the WindowTerm and its child.
	 * @param windowTerm
	 * @param windowModel
	 * @throws PagesModelException 
	 */
	public void walk(WindowTerm windowTerm, Object windowModel) throws PagesModelException {
		// Check associated model type
		if(! (windowModel instanceof RootModel) ) {
			throw new NoMatchException( "ContentProvider type ("+ windowModel.getClass().getName()+ ") does not match to WindowTerm" );
		}
		
		RootModel window = (RootModel)windowModel;

		if( isVisitingParentFirst() ) {
			visit(windowTerm, window);
		}
		// visit children
		windowTerm.getPanel().accept(this, window.getChild());
		
		if( ! isVisitingParentFirst() ) {
			visit(windowTerm, window);
		}
	}

	/**
	 * Walk folder and its children.
	 *
	 * @param folder
	 * @param folderModel
	 * @throws PagesModelException 
	 */
	public void walk(Folder folder, Object model) throws PagesModelException {
		// Check associated model type
		if(! (model instanceof TabFolderModel) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to FolderQueryPart" );
		}
		TabFolderModel folderModel = (TabFolderModel)model;
		
		// Visit this
		if( isVisitingParentFirst() ) {
			visit(folder, folderModel);
		}

		// visit children
		Iterator<IPageModel> pageRefs = folderModel.getChildren().iterator();
		Iterator<Page> pageQueries = folder.getPages().iterator();
		while (pageRefs.hasNext() && pageQueries.hasNext() ) {
			IPageModel pageRef = pageRefs.next();
			Page query = pageQueries.next();
			
			query.accept(this, pageRef);
		}
		if (pageRefs.hasNext()) {
			// some page left
			throw new NoMatchException( "Folder matching - "
			       + this.toString() 
			       +" folder model have more pages than folder query." );
		} else if (pageQueries.hasNext() ) {
			// some queries left
			throw new NoMatchException( "Folder matching - "
				       + this.toString() 
				       +" folder query have more page than folder model." );
		}
		
		// Visit this
		if( ! isVisitingParentFirst() ) {
			visit(folder, folderModel);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IPagesModelVisitor#walk(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.HSash, java.lang.Object)
	 *
	 * @param sash
	 * @param sashModel
	 * @throws PagesModelException 
	 */
	public void walk(HSash sash, Object model) throws PagesModelException {
		// Check associated model type
		if(! (model instanceof SashPanelModel) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to SashPanel (found "
					+ model.getClass() 
					+ " )");
		}
		
		SashPanelModel sashModel = (SashPanelModel)model;

		// Check orientation
		if( sashModel.getSashDirection() != SWT.HORIZONTAL) {
			throw new NoMatchException( this.toString() + " - SashOrientation does not match 'HORIZONTAL'" );
		}
		// Visit this
		if( isVisitingParentFirst() ) {
			visit(sash, sashModel);
		}

		// Visit children
		sash.getLeftup().accept(this, sashModel.getChildren().get(0));
		sash.getRightdown().accept(this, sashModel.getChildren().get(1));

		if( !isVisitingParentFirst() ) {
			visit(sash, sashModel);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IPagesModelVisitor#walk(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.VSash, java.lang.Object)
	 *
	 * @param sash
	 * @param sashModel
	 * @throws PagesModelException 
	 */
	public void walk(VSash sash, Object model) throws PagesModelException {
		// Check associated model type
		if(! (model instanceof SashPanelModel) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to SashPanel (found "
					+ model.getClass() 
					+ " )");
		}
		
		SashPanelModel sashModel = (SashPanelModel)model;

		// Check orientation
		if( sashModel.getSashDirection() != SWT.VERTICAL) {
			throw new NoMatchException( this.toString() + " - SashOrientation does not match 'VERTICAL'" );
		}
		// Visit this
		if( isVisitingParentFirst() ) {
			visit(sash, sashModel);
		}

		// Visit children
		sash.getLeftup().accept(this, sashModel.getChildren().get(0));
		sash.getRightdown().accept(this, sashModel.getChildren().get(1));

		if( !isVisitingParentFirst() ) {
			visit(sash, sashModel);
		}
	}

	/**
	 * Walk the page. Simply call the corresponding {@link SimpleContentProviderBaseVisitor#visit(Page, IPageModel)} method.
	 * @param page
	 * @param pageModel
	 * @throws PagesModelException
	 */
	public void walk(Page page, Object model) throws PagesModelException {
		// Check associated model type
		if(! (model instanceof IPageModel) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to PageRef" );
		}
		IPageModel pageModel = (IPageModel)model;
		visit(page, pageModel);
	}

	
	/**
	 * Visit the model. Actually, there is no counterpart for {@link SashPagesModel} in {@link SimpleContentProvider}.
	 *
	 * @param windowTerm
	 * @param windowModel
	 * @throws PagesModelException 
	 */
	public void visit(SashPagesModel pagesModel, Object windowModel) throws PagesModelException {

	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 *
	 * @param windowTerm
	 * @param windowModel
	 */
	public void visit(WindowTerm windowTerm, RootModel windowModel) throws PagesModelException {
		// To be implemented by subclass.
	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 * @param folder
	 * @param folderModel
	 */
	public void visit(Folder folder, TabFolderModel folderModel) throws PagesModelException{

	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 * @param sashQuery
	 * @param sashModel
	 */
	public void visit(HSash sashQuery, SashPanelModel sashModel) throws PagesModelException {
		
	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 *
	 * @param sash
	 * @param sashModel
	 */
	public void visit(VSash sashQuery, SashPanelModel sashModel) throws PagesModelException{
	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 *
	 * @param page
	 * @param pageModel
	 */
	public void visit(Page page, IPageModel pageModel) throws PagesModelException {

	}

}
