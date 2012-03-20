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
 *  Anass Radouani (Atos) - add history management 
 *
 *****************************************************************************/

package org.eclipse.papyrus.sasheditor.contentprovider.di.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

/**
 * Implementation of the page manager. The page manager provides basic methods
 * to access the DiSashModel and its PageList. This is the users interface to
 * add, open, close and remove pages.
 * 
 * @author cedric dumoulin
 */
public class PageMngrImpl implements IPageMngr {

	/** Internal EMF model */
	private SashWindowsMngr diSashModel;

	/** Contains the current page and previously opened pages */
	private Stack<Object> previousStack = new Stack<Object>();

	private Stack<Object> nextStack = new Stack<Object>();

	/**
	 * true when an update is currently performed to not add a page two times to
	 * the stack
	 */
	private boolean updating = false;

	/** true when a page closing is currently performed */
	private boolean closingPage = false;

	ContentChangedEventProvider contentChangedEventProvider;

	/**
	 * @return the updating
	 */
	public boolean isUpdating() {
		return updating;
	}

	/**
	 * @param updating
	 *        the boolean to set
	 */
	public void setUpdating(boolean updating) {
		this.updating = updating;
	}

	/**
	 * @return the closingPage
	 */
	public boolean isClosingPage() {
		return closingPage;
	}

	/**
	 * @param closingPage
	 *        the boolean to set
	 */
	public void setClosingPage(boolean closingPage) {
		this.closingPage = closingPage;
	}

	public PageMngrImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider) {
		this.diSashModel = diSashModel;
		this.contentChangedEventProvider = contentChangedEventProvider;
		if(diSashModel.getSashModel() != null && diSashModel.getSashModel().getCurrentSelection() != null && !diSashModel.getSashModel().getCurrentSelection().getChildren().isEmpty()) {
			addToPreviousStack(diSashModel.getSashModel().getCurrentSelection().getChildren().get(0).getPageIdentifier());
		}
	}

	/**
	 * Add a page to the PageList. Do not open the corresponding editor. The
	 * page will be visible in the list.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#addEditor(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	public void addPage(Object pageIdentifier) {

		// We do not need to disable event delivering,
		// as addition to pageList doesn't fire events.
		diSashModel.getPageList().addPage(pageIdentifier);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#allPages()
	 * 
	 * @return
	 */
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
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	public void closePage(Object pageIdentifier) {

		contentChangedEventProvider.setDeliver(false);
		diSashModel.getSashModel().removePageAndEmptyFolder(pageIdentifier);
		contentChangedEventProvider.setDeliver(true);
	}

	/**
	 * Remove all pages from the SashModel. Left only the top level folder
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	public void closeAllOpenedPages() {

		contentChangedEventProvider.setDeliver(false);
		diSashModel.getSashModel().removeAllPages();
		contentChangedEventProvider.setDeliver(true);

	}

	/**
	 * Remove all pages from the SashModel. Left only the top level folder
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	public void closeOtherPages(Object pageIdentifier) {
		contentChangedEventProvider.setDeliver(false);
		diSashModel.getSashModel().removeOtherPages(pageIdentifier);
		contentChangedEventProvider.setDeliver(true);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#openPage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	public void openPage(Object pageIdentifier) {
		// Add the page to the SashModel and to the PageList

		// We do not need to disable event delivering as the operation already
		// fired
		// one single event.

		addToPreviousStack(pageIdentifier);

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
		diSashModel.getSashModel().addPage(pageIdentifier);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#openPage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	private void openPageWithoutStack(Object pageIdentifier) {
		// Add the page to the SashModel and to the PageList

		// We do not need to disable event delivering as the operation already
		// fired
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
		diSashModel.getSashModel().addPage(pageIdentifier);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#removePage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	public void removePage(Object pageIdentifier) {
		// remove from pageList and from SashModel
		diSashModel.getPageList().removePage(pageIdentifier);

		contentChangedEventProvider.setDeliver(false);
		diSashModel.getSashModel().removePageAndEmptyFolder(pageIdentifier);
		contentChangedEventProvider.setDeliver(true);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#isOpen(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public boolean isOpen(Object pageIdentifier) {
		return diSashModel.getSashModel().lookupPage(pageIdentifier) != null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#openPrevious()
	 * 
	 */
	public void openPrevious() {

		setUpdating(true);

		if(previousStack.size() > 1) {
			nextStack.push(previousStack.pop());
			Object pageIdentifier = previousStack.peek();
			if(isOpen(pageIdentifier)) {

				closePage(pageIdentifier);
			}
			openPageWithoutStack(pageIdentifier);
		}

		setUpdating(false);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#openNext()
	 * 
	 */
	public void openNext() {
		setUpdating(true);
		if(!nextStack.isEmpty()) {
			Object pageIdentifier = nextStack.pop();
			previousStack.push(pageIdentifier);
			if(isOpen(pageIdentifier)) {
				closePage(pageIdentifier);
			}
			openPageWithoutStack(pageIdentifier);
		}
		setUpdating(false);
	}

	/**
	 * Add a page to the previous Stack
	 * 
	 * @param page
	 *        the page to add
	 */
	private void addToPreviousStack(Object page) {
		if(previousStack.isEmpty() || previousStack.peek() != page) {
			if(!nextStack.isEmpty()) {
				nextStack.clear();
			}
			previousStack.push(page);
		}
	}

	public void pageChanged(IPage newPage) {
		if(newPage != null) {
			if(!isUpdating() && !isClosingPage()) {
				Object md = newPage.getRawModel();
				if(md instanceof PageRef) {
					Object page = ((PageRef)md).getPageIdentifier();// .getEmfPageIdentifier();
					addToPreviousStack(page);
				}
			} else if(!isUpdating() && isClosingPage()) {
				setClosingPage(false);
				Object md = newPage.getRawModel();
				if(md instanceof PageRef) {
					Object page = ((PageRef)md).getPageIdentifier();
					if(!previousStack.isEmpty()) {
						previousStack.pop();
					}
					addToPreviousStack(page);
				}
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#hasPreviousHistory()
	 * 
	 */
	public boolean hasPreviousHistory() {
		return previousStack.size() > 1;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#hasNextHistory()
	 * 
	 */
	public boolean hasNextHistory() {
		return !nextStack.isEmpty();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr#isInHsitory()
	 * 
	 */
	public int isInHsitory(Object pageIdentifier) {
		return previousStack.lastIndexOf(pageIdentifier);
	}

	public void pageOpened(IPage page) {
		setClosingPage(false);
	}

	public void pageClosed(IPage page) {
		setClosingPage(true);
	}

	public void pageActivated(IPage page) {
	}

	public void pageDeactivated(IPage page) {
	}

	public void pageAboutToBeOpened(IPage page) {
	}

	public void pageAboutToBeClosed(IPage page) {
	}

}
