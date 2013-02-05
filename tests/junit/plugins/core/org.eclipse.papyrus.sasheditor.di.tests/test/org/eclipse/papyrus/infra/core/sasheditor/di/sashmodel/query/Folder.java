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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;

/**
 * This represent a Folder in the Checker query.
 * 
 * @author cedric dumoulin
 */
public class Folder extends PanelTerm implements IQueryTerm {

	protected List<Page> pages;
	
	/**
	 * Constructor.
	 *
	 */
	public Folder(Page ... pages) {	
		this.pages = Arrays.asList(pages);
	}
	
	/**
	 * Constructor.
	 *
	 */
	public Folder(String name, Page ... pages) {	
		super(name);
		this.pages = Arrays.asList(pages);
	}
	
	/**
	 * @return the pages
	 */
	public List<Page> getPages() {
		return pages;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryTerm#accept(IQueryVisitor, EObject)
	 *
	 * @param visitor
	 * @throws QueryException 
	 */
	public void accept(IQueryVisitor visitor, EObject modelObject) throws QueryException {
		
		// Check associated model type
		if(! (modelObject instanceof TabFolder) ) {
			throw new NoMatchException( this.toString() + " - Model object type does not match to FolderQueryPart" );
		}
		TabFolder folderModel = (TabFolder)modelObject;
		
		// Visit this
		if( visitor.isVisitingParentFirst() ) {
			visitor.visit(this, folderModel);
		}

		// visit children
		Iterator<PageRef> pageRefs = folderModel.getChildren().iterator();
		Iterator<Page> pageQueries = pages.iterator();
		while (pageRefs.hasNext() && pageQueries.hasNext() ) {
			PageRef pageRef = pageRefs.next();
			Page query = pageQueries.next();
			
			query.accept(visitor, pageRef);
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
		if( ! visitor.isVisitingParentFirst() ) {
			visitor.visit(this, folderModel);
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 *
	 * @return
	 */
	@Override
	public String toString() {
		
		StringBuffer buff = new StringBuffer("Folder(");
		
		for(Page page : pages ) {
			buff.append(page.toString()).append(", ");
		}
		// Remove extra ,
		int length = buff.length();
		if(buff.charAt(length-1) == ' ') {
			buff.delete(length-2, length );
		}
		buff.append(")");
		
		return buff.toString();
	}
}
