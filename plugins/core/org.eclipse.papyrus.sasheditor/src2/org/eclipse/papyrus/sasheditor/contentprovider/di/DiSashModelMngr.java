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

package org.eclipse.papyrus.sasheditor.contentprovider.di;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.di.internal.DiContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.di.internal.PageMngrImpl;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.sashwindows.di.util.DiUtils;


/**
 * Class used as main entry point to access a sash model build on EMF / di
 * 
 * @author cedric dumoulin
 */
public class DiSashModelMngr {

	/** The EMF model used to store the sash windows structure and pages */
	private SashWindowsMngr diSashModel;
	
	/** The factory used to create IPageModel */
	private IPageModelFactory pageModelFactory;
	
	/**
	 * Instance of the pageMngr.
	 */
	private PageMngrImpl pageMngr = null;

	/**
	 * Instance of the DiContentProvider. 
	 */
	private DiContentProvider contentProvider;
	
	
	/**
	 * Constructor.
	 * Create a DiSashModelMngr with the specified factory. A SashModel is created but not attached to a resource.
	 * 
	 * @param pageModelFactory
	 */
	public DiSashModelMngr(IPageModelFactory pageModelFactory) {
		this.pageModelFactory = pageModelFactory;
		// Create a SashModel
		diSashModel = createDefaultSashModel();
	}

	/**
	 * Constructor.
	 * Create a DiSashModelMngr with the specified factory. The SashModel is searched in the Resource. If not found, 
	 * create one in the resource.
	 * 
	 * @param pageModelFactory
	 * @param diResource
	 */
	public DiSashModelMngr(IPageModelFactory pageModelFactory, Resource diResource) {
		this.pageModelFactory = pageModelFactory;
		
		// lookup the SashModel
		diSashModel = lookupSashModel(diResource);
		if(diSashModel == null)
		{
			// Create a default model and attach it to resource.
			diSashModel = createDefaultSashModel();
			diResource.getContents().add(diSashModel);
		}
	}

	/**
	 * Constructor.
	 * Create a DiSashModelMngr with the specified factory and sashModel.
	 * 
	 * @param pageModelFactory
	 * @param sashModel
	 */
	public DiSashModelMngr(IPageModelFactory pageModelFactory, SashWindowsMngr sashModel) {
		this.pageModelFactory = pageModelFactory;
		this.diSashModel = sashModel;
	}

	/**
	 * @return the diSashModel
	 */
	public SashWindowsMngr getDiSashWindowsMngr() {
		return diSashModel;
	}

	/**
	 * Get the IPageMngr providing basic methods to manage Pages in the sash model.
	 * @return
	 */
	public IPageMngr getIPageMngr() {
		
		if(pageMngr == null)
		{
			pageMngr = new PageMngrImpl(diSashModel);
		}
		
		return pageMngr;
	}
	
	/**
	 * Get the ContentProvider used by the SashWindows system.
	 * This class can also be used to accurately manage the sash model.
	 *  
	 * @return
	 */
	public ISashWindowsContentProvider getISashWindowsContentProvider()
	{
		if(contentProvider == null)
		{
			contentProvider = new DiContentProvider(diSashModel.getSashModel(), pageModelFactory);
		}
		
		return contentProvider;
		
	}
	
	/**
	 * Create a default model with one window and one folder.
	 * @param diResource
	 * @return
	 */
	private SashWindowsMngr createDefaultSashModel() {
		return DiUtils.createDefaultSashWindowsMngr();
	}

	/**
	 * Lookup for the SashModel object in the resource
	 * @param diResource
	 * @return
	 */
	private SashWindowsMngr lookupSashModel(Resource diResource) {
		
		return DiUtils.lookupSashModel(diResource);
	}


}
