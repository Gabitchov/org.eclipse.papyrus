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

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.ContentChangedEventProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.CurrentFolderAndPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.DiContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.ICurrentFolderAndPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.PageManagerImpl;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.TransactionalDiContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.TransactionalPageManagerImpl;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.TransactionHelper;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;


/**
 * Class used as main entry point to access a sash model build on EMF / di
 * This class allows to get facade objects on the diSashModel.
 *
 * @author cedric dumoulin
 *
 */
public class DiSashModelManager {

	/** The EMF model used to store the sash windows structure and pages */
	protected SashWindowsMngr sashWindowMngr;

	/**
	 * Instance of the {@link PageManagerImpl}.
	 */
	private PageManagerImpl pageMngr = null;

	/**
	 * Instance of the DiContentProvider used to manipulate SashModel.
	 */
	private DiContentProvider contentProvider;

	private TransactionalDiContentProvider transDiContentProvider;

	/**
	 * Object used externally listen to model changes.
	 * The object is also used internally to control how events are fired (limit multiple events).
	 */
	protected ContentChangedEventProvider contentChangedEventProvider;

	/** The factory used to create IPageModel */
	//	private IPageModelFactory pageModelFactory;


	/**
	 *
	 * Constructor.
	 *
	 * @param pageModelFactory
	 * @param diResource
	 * @param currentFolderAndPageMngr
	 */
	public DiSashModelManager(IPageModelFactory pageModelFactory, final Resource diResource, TransactionalEditingDomain editingDomain, ICurrentFolderAndPageMngr currentFolderAndPageMngr) {
		//		this.pageModelFactory = pageModelFactory;

		// lookup the SashModel
		sashWindowMngr = lookupSashWindowMngr(diResource);
		// If no SashWindow structure is found, create a new one using a transaction.
		if(sashWindowMngr == null) {
			// Create a default model and attach it to resource.
			sashWindowMngr = createDefaultSashModel();
			// Create a command
			RecordingCommand cmd = new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					diResource.getContents().add(sashWindowMngr);
				}
			};
			// Execute command
			editingDomain.getCommandStack().execute(cmd);
		}

		contentProvider = new DiContentProvider(sashWindowMngr.getSashModel(), pageModelFactory, contentChangedEventProvider);
		// Create the TransactionalDiContentProvider
		transDiContentProvider = new TransactionalDiContentProvider(getDiContentProvider(), editingDomain);

		// Create the TransactionalPageMngrImpl
		pageMngr = new TransactionalPageManagerImpl(sashWindowMngr, contentChangedEventProvider, currentFolderAndPageMngr);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param pageModelFactory
	 * @param diResource
	 * @param currentFolderAndPageMngr
	 */
	public DiSashModelManager(IPageModelFactory pageModelFactory, final Resource diResource, TransactionalEditingDomain editingDomain) {

		// lookup the SashModel
		sashWindowMngr = lookupSashWindowMngr(diResource);
		// If no SashWindow structure is found, create a new one using a transaction.
		if(sashWindowMngr == null) {
			// Create a default model and attach it to resource.
			sashWindowMngr = createDefaultSashModel();

			try {
				TransactionHelper.run(editingDomain, new Runnable() {

					@Override
					public void run() {
						diResource.getContents().add(sashWindowMngr);

					};
				});
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		contentProvider = new DiContentProvider(sashWindowMngr.getSashModel(), pageModelFactory, getContentChangedEventProvider());
		// Create the TransactionalDiContentProvider
		transDiContentProvider = new TransactionalDiContentProvider(getDiContentProvider(), editingDomain);

		// Create the TransactionalPageMngrImpl
		pageMngr = new TransactionalPageManagerImpl(sashWindowMngr, getContentChangedEventProvider());

	}

	/**
	 *
	 * @param currentFolderAndPageMngr
	 */
	public void setCurrentFolderAndPageMngr(ICurrentFolderAndPageMngr currentFolderAndPageMngr) {
		pageMngr.setCurrentFolderAndPageMngr(currentFolderAndPageMngr);
	}

	/**
	 * Set the CurrentFolderAndPageManager as an instance of {@link CurrentFolderAndPageManager}
	 *
	 * @param currentFolderAndPageMngr
	 */
	public void setCurrentFolderAndPageMngr(ISashWindowsContainer sashWindowsContainer) {
		pageMngr.setCurrentFolderAndPageMngr(new CurrentFolderAndPageManager(sashWindowsContainer));
	}

	/**
	 *
	 * Constructor.
	 * Only create a {@link IPageMngr} impl. Do not create the DiContentProvider as there is no factory provided.
	 * Internal use.
	 *
	 * @param pageModelFactory
	 * @param diResource
	 */
	//	private DiSashModelManager(final Resource diResource, TransactionalEditingDomain editingDomain, ICurrentFolderAndPageMngr currentFolderAndPageMngr) {
	//		this(null, diResource, editingDomain, currentFolderAndPageMngr);
	//
	//	}


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
	protected DiContentProvider getDiContentProvider() {
		return contentProvider;
	}

	/**
	 * Return the internal implementation of ContentProvider.
	 * Create if if needed.
	 * This method should not be subclassed
	 *
	 * @return the contentProvider
	 */
	protected TransactionalDiContentProvider getTransactionalDiContentProvider() {
		return transDiContentProvider;
	}

	/**
	 * Return the internal implementation of PageMngr.
	 * Create if if needed.
	 * This method should not be subclassed
	 *
	 * @return the PageMngrImpl
	 */
	protected final PageManagerImpl getPageManagerImpl() {
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
	public IPageMngr getIPageMngr() {
		return getIPageManager();
	}

	/**
	 * Get the IPageManager providing basic methods to manage Pages in the sash model.
	 *
	 * @return
	 */
	public IPageManager getIPageManager() {
		return getPageManagerImpl();
	}

	/**
	 * Get the ContentProvider used by the SashWindows system.
	 * This class can also be used to accurately manage the sash model.
	 *
	 * @return
	 */
	public ISashWindowsContentProvider getISashWindowsContentProvider() {

		return getTransactionalDiContentProvider();

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
	//	public static IPageMngr createIPageMngr(Resource diResource) {
	//
	//		// Create an instance of the DiSashModelMngr with no factory.
	//		// The factory is not needed since we don't get the ISashWindowsContentProvider.
	//		return new DiSashModelManager(null, diResource).getIPageMngr();
	//
	//	}

}
