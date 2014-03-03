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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
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
	private SashWindowsMngr diSashModel;

	/**
	 * An object used to get the current folder, or to ask to set the
	 * active page.
	 * This is usually backuped by the SashWindowContainer. <br>
	 */
	protected ICurrentFolderAndPageMngr folderAndPageMngr;

	private ContentChangedEventProvider contentChangedEventProvider;

	public PageMngrImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider) {
		this.diSashModel = diSashModel;
		this.contentChangedEventProvider = contentChangedEventProvider;
		folderAndPageMngr = new DefaultCurrentFolderAndPageMngr(diSashModel);
	}

	public PageMngrImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider, ICurrentFolderAndPageMngr folderAndPageMngr) {
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
		//Nothing to do. The list of pages is now computed dynamically
	}

	/**
	 * Get the folder model {@link TabFolder} of the current folder.
	 *
	 * @return
	 */
	private TabFolder getCurrentFolder() {
		return folderAndPageMngr.getCurrentFolder();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#allPages()
	 *
	 * @return
	 */
	@Override
	public List<Object> allPages() {
		//FIXME: Temporary, naive code. Need to implement a mechanism to contribute page providers
		List<Object> result = new LinkedList<Object>();
		for(Resource resource : diSashModel.eResource().getResourceSet().getResources()) {
			if(resource != null && resource.isLoaded()) {
				if("notation".equals(resource.getURI().fileExtension())) {
					result.addAll(resource.getContents());
				}
			}
		}
		return result;
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
		diSashModel.getSashModel().addPage(getCurrentFolder(), pageIdentifier);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#removePage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	@Override
	public void removePage(Object pageIdentifier) {
		// remove from SashModel

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
