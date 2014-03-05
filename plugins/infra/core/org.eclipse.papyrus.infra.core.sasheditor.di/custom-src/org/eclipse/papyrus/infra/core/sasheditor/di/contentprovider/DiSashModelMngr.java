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

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.ContentChangedEventProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.DiContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.PageManagerImpl;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.TransactionalPageManagerImpl;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;


/**
 * Class used as main entry point to access a sash model build on EMF / di
 * 
 * @author cedric dumoulin
 */
public class DiSashModelMngr {

	/** The EMF model used to store the sash windows structure and pages */
	protected SashWindowsMngr sashWindowMngr;

	/**
	 * Instance of the pageMngr.
	 */
	private PageManagerImpl pageMngr = null;

	/**
	 * Instance of the DiContentProvider used to manipulate SashModel.
	 */
	private DiContentProvider contentProvider;

	/**
	 * Object used externally listen to model changes.
	 * The object is also used internally to control how events are fired (limit multiple events).
	 */
	protected ContentChangedEventProvider contentChangedEventProvider;

	/** The factory used to create IPageModel */
	private IPageModelFactory pageModelFactory;


	/**
	 * Constructor.
	 * Create a DiSashModelMngr with the specified factory. A SashModel is created but not attached to a resource.
	 * This constructor is for subclasses. The subclasses should initialize the sashWindowMngr
	 *
	 * @param pageModelFactory
	 * @param createDefaultSashModel
	 *        If true, create the default SashModel by calling {@link #createDefaultSashModel()}
	 */
	protected DiSashModelMngr(IPageModelFactory pageModelFactory, boolean createDefaultSashModel) {
		this.pageModelFactory = pageModelFactory;
		// Create a SashModel
		if(createDefaultSashModel) {
			sashWindowMngr = createDefaultSashModel();
		}
	}

	/**
	 * Constructor.
	 * Create a DiSashModelMngr with the specified factory. A SashModel is created but not attached to a resource.
	 * 
	 * @param pageModelFactory
	 */
	public DiSashModelMngr(IPageModelFactory pageModelFactory) {
		this.pageModelFactory = pageModelFactory;
		// Create a SashModel
		sashWindowMngr = createDefaultSashModel();
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
		sashWindowMngr = lookupSashWindowMngr(diResource);
		if(sashWindowMngr == null) {
			// Create a default model and attach it to resource.
			sashWindowMngr = createDefaultSashModel();
			diResource.getContents().add(sashWindowMngr);
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
		this.sashWindowMngr = sashModel;
	}

	/**
	 * Get the internal EMF implementation.
	 * Intended to be used by tests.
	 * 
	 * @return the sashWindowMngr
	 */
	protected SashWindowsMngr getDiSashWindowsMngr() {
		return sashWindowMngr;
	}


	/**
	 * Return the internal implementation of ContentProvider.
	 * Create if if needed.
	 * This method should not be subclassed
	 * 
	 * @return the contentProvider
	 */
	protected final DiContentProvider getDiContentProvider() {
		if(contentProvider == null) {
			contentProvider = new DiContentProvider(sashWindowMngr.getSashModel(), pageModelFactory, getContentChangedEventProvider());
		}
		return contentProvider;
	}

	/**
	 * Return the internal implementation of PageMngr.
	 * Create if if needed.
	 * This method should not be subclassed
	 * 
	 * @return the PageMngrImpl
	 */
	protected final PageManagerImpl getPageMngrImpl() {
		if(pageMngr == null) {
			pageMngr = new TransactionalPageManagerImpl(sashWindowMngr, getContentChangedEventProvider());
		}

		return pageMngr;
	}

	/**
	 * Return the internal implementation of ContentChangedEventProvider.
	 * Create if if needed.
	 * This method should not be subclassed
	 * 
	 * @return the PageMngrImpl
	 */
	protected final ContentChangedEventProvider getContentChangedEventProvider() {
		if(contentChangedEventProvider == null) {
			contentChangedEventProvider = new ContentChangedEventProvider(sashWindowMngr);
		}

		return contentChangedEventProvider;
	}

	/**
	 * Get the IPageMngr providing basic methods to manage Pages in the sash model.
	 * 
	 * @return
	 */
	public IPageManager getIPageMngr() {
		return getPageMngrImpl();
	}

	/**
	 * Get the ContentProvider used by the SashWindows system.
	 * This class can also be used to accurately manage the sash model.
	 * 
	 * @return
	 */
	public ISashWindowsContentProvider getISashWindowsContentProvider() {

		return getDiContentProvider();

	}

	/**
	 * Get the ContentChangedProvider for the SashModel
	 * 
	 * @return
	 */
	public IContentChangedProvider getSashModelContentChangedProvider() {
		return getContentChangedEventProvider();
	}

	/**
	 * Create a default model with one window and one folder.
	 * 
	 * @param diResource
	 * @return
	 */
	protected SashWindowsMngr createDefaultSashModel() {
		return DiUtils.createDefaultSashWindowsMngr();
	}

	/**
	 * Lookup for the SashModel object in the resource
	 * 
	 * @param diResource
	 * @return
	 */
	protected SashWindowsMngr lookupSashWindowMngr(Resource diResource) {

		return DiUtils.lookupSashWindowsMngr(diResource);
	}

	/**
	 * Create an instance of IPageMngr acting on the provided resource.
	 * This instance is suitable to add, remove, close or open diagrams.
	 * 
	 * @param diResource
	 * @return The non transactional version of the IPageMngr
	 */
	public static IPageManager createIPageMngr(Resource diResource) {

		// Create an instance of the DiSashModelMngr with no factory.
		// The factory is not needed since we don't get the ISashWindowsContentProvider.
		return new DiSashModelMngr(null, diResource).getIPageMngr();

	}


}
