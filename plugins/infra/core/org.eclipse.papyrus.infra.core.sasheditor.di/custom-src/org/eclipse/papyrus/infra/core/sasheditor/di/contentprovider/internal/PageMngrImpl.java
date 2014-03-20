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

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;


/**
 * Implementation of the page manager.
 * The page manager provides basic methods to access the DiSashModel and its PageList.
 * This is the users interface to add, open, close and remove pages.
 *
 * @author cedric dumoulin
 */
public class PageMngrImpl implements IPageMngr {

	/** Internal EMF model */
	protected SashWindowsMngr diSashModel;

	/**
	 * An object used to get the current folder, or to ask to set the
	 * active page.
	 * This is usually backuped by the SashWindowContainer. <br>
	 */
	protected ICurrentFolderAndPageMngr folderAndPageMngr;

	private ContentChangedEventProvider contentChangedEventProvider;

	protected PageMngrImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider) {
		this.diSashModel = diSashModel;
		this.contentChangedEventProvider = contentChangedEventProvider;
		folderAndPageMngr = new DefaultCurrentFolderAndPageMngr(diSashModel);
	}

	protected PageMngrImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider, ICurrentFolderAndPageMngr folderAndPageMngr) {
		this.diSashModel = diSashModel;
		this.contentChangedEventProvider = contentChangedEventProvider;
		this.folderAndPageMngr = folderAndPageMngr;
	}

	/**
	 * Add a page to the PageList. Do not open the corresponding editor.
	 * The page will be visible in the list.
	 *
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#addEditor(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	@Override
	@Deprecated
	public void addPage(Object pageIdentifier) {

		// We do not need to disable event delivering,
		// as addition to pageList doesn't fire events.

		diSashModel.getPageList().addPage(pageIdentifier);
	}

	/**
	 * Get the folder model {@link TabFolder} of the current folder.
	 *
	 * @return
	 */
	protected TabFolder getCurrentFolder() {
		return folderAndPageMngr.getCurrentFolder();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#allPages()
	 *
	 * @return
	 */
	@Override
	public List<Object> allPages() {
		// TODO : use and return a shadow list ?
		List<Object> list = new ArrayList<Object>();
		for(PageRef pageRef : diSashModel.getPageList().getAvailablePage()) {

			list.add(pageRef.getPageIdentifier());
		}
		return list;
	}

	/**
	 * Remove the page from the SashModel
	 *
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	@Override
	public void closePage(Object pageIdentifier) {

		contentChangedEventProvider.setDeliver(false);
		diSashModel.getSashModel().removePageAndEmptyFolder(pageIdentifier);
		contentChangedEventProvider.setDeliver(true);
	}

	/**
	 * Remove all pages from the SashModel. Left only the top level folder
	 *
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	@Override
	public void closeAllOpenedPages() {

		contentChangedEventProvider.setDeliver(false);
		diSashModel.getSashModel().removeAllPages();
		contentChangedEventProvider.setDeliver(true);

	}

	/**
	 * Remove all pages from the SashModel. Left only the top level folder
	 *
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	@Override
	public void closeOtherPages(Object pageIdentifier) {
		contentChangedEventProvider.setDeliver(false);
		diSashModel.getSashModel().removeOtherPages(pageIdentifier);
		contentChangedEventProvider.setDeliver(true);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#openPage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	@Override
	public void openPage(Object pageIdentifier) {
		// Add the page to the SashModel and to the PageList

		// We do not need to disable event delivering as the operation already fired
		// one single event.

		Iterator<PageRef> iterator = diSashModel.getPageList().getAvailablePage().iterator();
		boolean found = false;
		while(iterator.hasNext() && found == false) {
			// Bug #288806 : the test should be inversed
			if(pageIdentifier.equals(iterator.next().getPageIdentifier())) {
				found = true;
			}
		}
		if(!found) {
			diSashModel.getPageList().addPage(pageIdentifier);
		}
		diSashModel.getSashModel().addPage(getCurrentFolder(), pageIdentifier);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#removePage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	@Override
	@Deprecated
	public void removePage(Object pageIdentifier) {
		// remove from pageList and from SashModel
		diSashModel.getPageList().removePage(pageIdentifier);

		contentChangedEventProvider.setDeliver(false);
		diSashModel.getSashModel().removePageAndEmptyFolder(pageIdentifier);
		contentChangedEventProvider.setDeliver(true);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#isOpen(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 *
	 */
	@Override
	public boolean isOpen(Object pageIdentifier) {
		return diSashModel.getSashModel().lookupPage(pageIdentifier) != null;
	}

}
