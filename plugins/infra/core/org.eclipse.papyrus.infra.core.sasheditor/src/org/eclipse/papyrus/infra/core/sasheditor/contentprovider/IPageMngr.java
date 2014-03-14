/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL
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

package org.eclipse.papyrus.infra.core.sasheditor.contentprovider;

import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer;


/**
 * Interface providing method to manage pages in the Sash Windows system.
 * This interface can be provided by ContentProvider whishing to provide a standard
 * way to manage pages. This interface is not mandatory for the Sasheditor.
 * This interface provide basic access to the Sash Windows system.
 * It is intended to be used from the application in order to interact with the ContentProvider. Then,
 * the {@link SashWindowsContainer} will refresh its views.
 * 
 * 
 * @author dumoulin
 * 
 * @deprecated Use IPageManager instead
 */
@Deprecated
public interface IPageMngr {

	/**
	 * Add a Page identifier to the list of pages, do not open it.
	 * 
	 * @param page
	 *        The object identifying the page to add. This object will be passed to the {@link IPageModelFactory#createIPageModel(EObject)}. This
	 *        identifier is stored in the sash model.
	 *        It should be a reference on a EMF object identifying the page.
	 * @deprecated The pages are now computed dynamically
	 */
	@Deprecated
	public void addPage(Object pageIdentifier);

	/**
	 * Remove the page from the SashWindows system and from the list of page.
	 * The page will not be available anymore.
	 * 
	 * @param pageIdentifier
	 *        The object identifying the page
	 * 
	 * @deprecated The pages are now computed dynamically. Use {@link IPageManager#closeAllOpenedPages(Object)} instead
	 */
	@Deprecated
	public void removePage(Object pageIdentifier);

	/**
	 * Close the page corresponding to the identifier.
	 * The identifier is removed from the Sash Windows, but not from the list of pages.
	 * 
	 * @param pageIdentifier
	 *        The object identifying the page
	 */
	public void closePage(Object pageIdentifier);


	/**
	 * Close all opened pages.
	 * 
	 */
	public void closeAllOpenedPages();

	/**
	 * Close all opened pages except the one provided as parameter.
	 * 
	 * @param pageIdentifier
	 */
	public void closeOtherPages(Object pageIdentifier);

	/**
	 * Open a Page corresponding to the identifier. If the page is not in the list of pages, add it.
	 * The identifier is first added to the current folder model. Then the Sash Windows should react and
	 * ask the {@link IPageModelFactory} to create the IPageModel. This later is then used to create the
	 * SWT page.
	 * If
	 * 
	 * @param page
	 *        The object identifying the page to add. This object will be passed to the {@link IPageModelFactory#createIPageModel(EObject)}. This
	 *        identifier is stored in the sash model.
	 *        It should be a reference on a EMF object identifying the page.
	 */
	public void openPage(Object pageIdentifier);

	/**
	 * Return all available page identifiers (open and closed pages).
	 * 
	 * @return List of registered page identifiers.
	 */
	public List<Object> allPages();

	/**
	 * Return true if a page is open for the specified pageIdentifier.
	 * 
	 * @param diagram
	 * @return
	 */
	public boolean isOpen(Object pageIdentifier);

}
