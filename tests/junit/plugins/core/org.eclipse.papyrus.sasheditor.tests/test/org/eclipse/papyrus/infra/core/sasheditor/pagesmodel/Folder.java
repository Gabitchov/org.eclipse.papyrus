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

import java.util.Arrays;
import java.util.List;

/**
 * This represent a Folder in the Checker query.
 * 
 * @author cedric dumoulin
 */
public class Folder extends PanelTerm implements IModelObject {

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
	 * @see org.eclipse.papyrus.infra.core.sasheditor.IModelObject.sashmodel.query.IQueryTerm#accept(IPagesModelVisitor, EObject)
	 *
	 * @param visitor
	 * @throws PagesModelException 
	 */
	public <M> void accept(IPagesModelVisitor<M> visitor, M modelObject) throws PagesModelException {
		
		visitor.walk(this, modelObject);
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
