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

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import java.util.Iterator;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Folder;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.HSash;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IPagesModelVisitor;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.NoMatchException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Page;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.VSash;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.WindowTerm;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;
import org.eclipse.swt.SWT;

/**
 * A base implementation of {@link IPagesModelVisitor} to visit conjointly SashPagesModel and 
 * {@link DiContentProvider}.
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
public class DiContentProviderBaseVisitor implements IPagesModelVisitor<Object> {

	/**
	 * @return the isVisitingParentFirst
	 */
	public boolean isVisitingParentFirst() {
		return true;
	}

	/**
	 * Visit the model. 
	 * The second argument should be a SashModel, or one of its container (ex: DiContentProvider).
	 * 
	 * @param pagesModel
	 * @param diPagesModel
	 * @throws PagesModelException 
	 */
	public void walk(SashPagesModel pagesModel, Object diPagesModel) throws PagesModelException {
		// Check associated model type
		// It can be of different type: DiContentProvider or SashModel
		//
		SashModel sashModel = null;
		if( diPagesModel instanceof SashModel) {
			sashModel = (SashModel)diPagesModel;
		}
		else if(diPagesModel instanceof DiContentProvider) {
			sashModel = ((DiContentProvider)diPagesModel).getDiSashModel();
		}
		else  {
			throw new NoMatchException( "ContentProvider type ("+ diPagesModel.getClass().getName()+ ") does not match to SashModel or one of its container" );
		}
		

		if( isVisitingParentFirst() ) {
			visit(pagesModel, sashModel);
		}
		// visit children
		for( WindowTerm windowTerm : pagesModel.getWindows() ) {
			// Only one window
			Window windowModel = sashModel.getWindows().get(0);
			windowTerm.getPanel().accept(this, windowModel);
		}
		if( ! isVisitingParentFirst() ) {
			visit(pagesModel, sashModel);
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
		if(! (windowModel instanceof Window) ) {
			throw new NoMatchException( "ContentProvider type ("+ windowModel.getClass().getName()+ ") does not match to Window" );
		}
		
		Window window = (Window)windowModel;

		if( isVisitingParentFirst() ) {
			visit(windowTerm, window);
		}
		// visit children
		for( AbstractPanel panel : window.getChildren())
		windowTerm.getPanel().accept(this, panel);
		
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
		if(! (model instanceof TabFolder) ) {
			throw new NoMatchException( this.toString() 
					+ "\n" + folder
					+ "\n - Model object type does not match to FolderQueryPart."
					+ " Expected TabFolder, found '" + model.getClass().getSimpleName() + "'."
		            + " (" + folder.getName() +")" );
		}
		TabFolder folderModel = (TabFolder)model;
		
		// Visit this
		if( isVisitingParentFirst() ) {
			visit(folder, folderModel);
		}

		// visit children
		Iterator<PageRef> pageRefs = folderModel.getChildren().iterator();
		Iterator<Page> pageQueries = folder.getPages().iterator();
		while (pageRefs.hasNext() && pageQueries.hasNext() ) {
			PageRef pageRef = pageRefs.next();
			Page query = pageQueries.next();
			
			query.accept(this, pageRef);
		}
		if (pageRefs.hasNext()) {
			// some page left
			throw new NoMatchException( "Folder matching - "
			       + this.toString() 
			       +" folder model have more pages than folder query. ("+folder.getName()+")" );
		} else if (pageQueries.hasNext() ) {
			// some queries left
			throw new NoMatchException( "Folder matching - "
				       + this.toString() 
				       +" folder query have more page than folder model. ("+folder.getName()+")"  );
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
		if(! (model instanceof SashPanel) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to SashPanel (found "
					+ model.getClass() 
					+ " )");
		}
		
		SashPanel sashModel = (SashPanel)model;

//		// Check orientation
//		if( sashModel.getDirection() != SWT.HORIZONTAL) {
//			throw new NoMatchException( this.toString() + " - SashOrientation does not match 'HORIZONTAL'" );
//		}
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
		if(! (model instanceof SashPanel) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to SashPanel (found "
					+ model.getClass() 
					+ " )");
		}
		
		SashPanel sashModel = (SashPanel)model;

//		// Check orientation
//		if( sashModel.getDirection() != SWT.VERTICAL) {
//			throw new NoMatchException( this.toString() + " - SashOrientation does not match 'VERTICAL'" );
//		}
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
	 * Walk the page. Simply call the corresponding {@link DiContentProviderBaseVisitor#visit(Page, IPageModel)} method.
	 * @param page
	 * @param pageModel
	 * @throws PagesModelException
	 */
	public void walk(Page page, Object model) throws PagesModelException {
		// Check associated model type
		if(! (model instanceof PageRef) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to PageRef" );
		}
		PageRef pageModel = (PageRef)model;
		visit(page, pageModel);
	}

	
	/**
	 * Visit the model. Actually, there is no counterpart for {@link SashPagesModel} in {@link SimpleContentProvider}.
	 *
	 * @param windowTerm
	 * @param windowModel
	 * @throws PagesModelException 
	 */
	public void visit(SashPagesModel pagesModel, SashModel windowModel) throws PagesModelException {

	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 *
	 * @param windowTerm
	 * @param windowModel
	 */
	public void visit(WindowTerm windowTerm, Window windowModel) throws PagesModelException {
		// To be implemented by subclass.
	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 * @param folder
	 * @param folderModel
	 */
	public void visit(Folder folder, TabFolder folderModel) throws PagesModelException{

	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 * @param sashQuery
	 * @param sashModel
	 */
	public void visit(HSash sashQuery, SashPanel sashModel) throws PagesModelException {
		
	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 *
	 * @param sash
	 * @param sashModel
	 */
	public void visit(VSash sashQuery, SashPanel sashModel) throws PagesModelException{
	}

	/**
	 * Visit the corresponding node.
	 * To be implemented by subclass.
	 * 
	 *
	 * @param page
	 * @param pageModel
	 */
	public void visit(Page page, PageRef pageModel) throws PagesModelException {

	}

}
