/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.Activator;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.TransactionHelper;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;

/**
 * Transactional implementation of the PageManager.
 * 
 * It runs all commands in write transactions on the editing domain, without using the CommandStack
 * 
 * @author Camille Letavernier
 *
 */
public class TransactionalPageManagerImpl extends PageManagerImpl {

	protected EditingDomain editingDomain;

	public TransactionalPageManagerImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider) {
		super(diSashModel, contentChangedEventProvider);
	}

	public TransactionalPageManagerImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider, ICurrentFolderAndPageMngr folderAndPageMngr) {
		super(diSashModel, contentChangedEventProvider, folderAndPageMngr);
	}

	protected EditingDomain getEditingDomain() {
		if(editingDomain == null) {
			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(diSashModel);
		}

		return editingDomain;
	}

	@Override
	public void removePage(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.removePage(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void closePage(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.closePage(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void closeAllOpenedPages() {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.closeAllOpenedPages();
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void closeOtherPages(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.closeOtherPages(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void openPage(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.openPage(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void closeAllOpenedPages(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.closeAllOpenedPages(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

}
