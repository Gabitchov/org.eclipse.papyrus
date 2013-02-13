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

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;


/**
 * This class provide high level method to manage the Sash pages through its DI 
 * implementation.

 * @author cedric dumoulin
 *
 */
public class PageManagerImpl extends PageMngrImpl implements IPageMngr {

	
	
	/**
	 * Constructor.
	 * Use a default {@link ICurrentFolderAndPageMngr} that alwayrs use the first
	 * folder as the current folder. Futhermore, the default implementation doesn't 
	 * allow to set the active folder.
	 * <br>
	 * Suitable for tests
	 *
	 * @param diSashModel The model onto which operation of this class act.
	 * @param contentChangedEventProvider A class listening on changes on the internal model and delivering events to registered listeners. This implementation 
	 * need the class in order to deactivate event triggering  during the operations.
	 * 
	 */
	public PageManagerImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider) {
		super(diSashModel, contentChangedEventProvider);
	}

	/**
	 * Constructor.
	 *
	 * @param diSashModel
	 * @param contentChangedEventProvider
	 * @param folderAndPageMngr
	 */
	public PageManagerImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider, ICurrentFolderAndPageMngr folderAndPageMngr) {
		super(diSashModel, contentChangedEventProvider, folderAndPageMngr);
	}


	/**
	 * Remove all pages used to render the specified pageIndentifier.
	 * If the pageIdentifier hasmore than one page rendering it, each of these
	 * pages are closed.
	 * 
	 * 
	 * @param pageIdentifier
	 */
	public void closeAllOpenedPages(Object pageIdentifier) {
		
		// TODO
		throw new UnsupportedOperationException("Not yet implemented.");

	}


	/**
	 * Select the first page used to render the specified pageIdentifier.
	 * Do nothing if this page identifier is not rendered.
	 * 
	 * @param pageIdentifier
	 */
	public void selectPage( Object pageIdentifier) {
		
		folderAndPageMngr.setActivePage(pageIdentifier);
	}

	public void setCurrentFolderAndPageMngr(ICurrentFolderAndPageMngr currentFolderAndPageMngr) {
		this.folderAndPageMngr = currentFolderAndPageMngr;
		
	}
}
