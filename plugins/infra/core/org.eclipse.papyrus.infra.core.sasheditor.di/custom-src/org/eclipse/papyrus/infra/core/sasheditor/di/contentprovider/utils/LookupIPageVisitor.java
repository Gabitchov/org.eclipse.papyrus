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

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IComponentPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IEditorPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageVisitor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;


/**
 * Visitor used to lookup an {@link IPage} in the {@link ISashWindowsContainer}.
 * 
 * The visitor walk all IPage of the container, and compare the "rawmodel" of the IPage with the identifier.
 * Take into account the fact the the identifier can be a 'Diagram', and that the Diagram type is available in
 * a {@link PageRef#getPageIdentifier()}
 * @author cedric dumoulin
 *
 */
public class LookupIPageVisitor implements IPageVisitor {

	
	/**
	 * Identifier to compare with specified page
	 */
	protected Object identifier;
	
	/**
	 * The found page.
	 */
	protected IPage result = null;
	/**
	 * Constructor.
	 *
	 * @param identifier
	 */
	public LookupIPageVisitor(Object identifier) {
		this.identifier = identifier;
	}

	
	/**
	 * @return the result
	 */
	public IPage getResult() {
		return result;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.IPageVisitor#accept(org.eclipse.papyrus.infra.core.sasheditor.editor.IComponentPage)
	 *
	 * @param page
	 */
	@Override
	public void accept(IComponentPage page) {
		
		if(result !=null) {
			return;
			
		}
		if(IPageUtils.getRawModel(page) == identifier) {
			result = page;
		}

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.IPageVisitor#accept(org.eclipse.papyrus.infra.core.sasheditor.editor.IEditorPage)
	 *
	 * @param page
	 */
	@Override
	public void accept(IEditorPage page) {
		
		if(result !=null) {
			return;
			
		}
		if(IPageUtils.getRawModel(page) == identifier) {
			result = page;
		}

	}

}
