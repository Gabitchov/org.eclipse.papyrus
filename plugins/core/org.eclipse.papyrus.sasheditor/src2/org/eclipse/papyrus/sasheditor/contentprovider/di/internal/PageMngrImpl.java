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

package org.eclipse.papyrus.sasheditor.contentprovider.di.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.papyrus.sashwindows.di.DiFactory;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;


/**
 * Implementation of the page manager.
 * The page manager provides basic methods to access the DiSashModel and its PageList.
 * 
 * @author cedric dumoulin
 */
public class PageMngrImpl implements IPageMngr {

	/** Internal EMF model */
	private SashWindowsMngr diSashModel;
	
	public PageMngrImpl(SashWindowsMngr diSashModel) {
		this.diSashModel = diSashModel;
	}

	/**
	 * Add a page to the PageList. Do not open the corresponding editor.
	 * The page will be visible in the list.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#addEditor(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	public void addPage(EObject pageIdentifier) {
		
		PageRef pageRef = DiFactory.eINSTANCE.createPageRef();
		pageRef.setPageIdentifier(pageIdentifier);
		
		diSashModel.getPageList().getAvailablePage().add(pageRef);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#allPages()
	 *
	 * @return
	 */
	public List<Object> allPages() {
		
		// TODO : use and return a shadow list ?
		List<Object> list = new ArrayList<Object>();
		for( PageRef pageRef : diSashModel.getPageList().getAvailablePage() )
		{

			list.add(pageRef.getPageIdentifier());
		}
		
		return list;
	}

	/**
	 * Remove the page from the SashModel
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	public void closePage(EObject pageIdentifier) {
		diSashModel.getSashModel().removePage(pageIdentifier);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#openPage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	public void openPage(EObject pageIdentifier) {
		// Add the page to the SashModel and to the PageList
		addPage(pageIdentifier);
		diSashModel.getSashModel().addPage(pageIdentifier);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#removePage(org.eclipse.emf.ecore.EObject)
	 *
	 * @param pageIdentifier
	 */
	public void removePage(EObject pageIdentifier) {
		// remove from pageList and from SashModel
		diSashModel.getPageList().addPage(pageIdentifier);
		diSashModel.getSashModel().removePage(pageIdentifier);
		
	}

}
