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

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;

/**
 * A PageMngr based on EMF di and using Transactions. This implementation is a
 * wrapper on {@link PageMngrImpl}. Each method is wrapped in a {@link RecordingCommand}.
 * 
 * @author cedric dumoulin
 */
public class TransactionalPageMngrImpl implements IPageMngr {

	/**
	 * wrapped ContentProvider. All commands will use this provider.
	 */
	private PageMngrImpl pageMngr;

	private TransactionalEditingDomain editingDomain;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diContentProvider
	 */
	public TransactionalPageMngrImpl(PageMngrImpl pageMngr, TransactionalEditingDomain editingDomain) {
		this.pageMngr = pageMngr;
		this.editingDomain = editingDomain;
	}

	/**
	 * Get the editing domain used to perform transactions.
	 * 
	 * @return
	 */
	private TransactionalEditingDomain getTransactionalEditingDomain() {
		return editingDomain;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#addPage(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 */
	public void addPage(final Object pageIdentifier) {

		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.addPage(pageIdentifier);
			}
		}.run();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#allPages()
	 * 
	 * @return
	 */
	public List<Object> allPages() {
		return pageMngr.allPages();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#closePage(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 */
	public void closePage(final Object pageIdentifier) {

		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.closePage(pageIdentifier);
			}
		}.run();
	}

	/**
	 * Remove all pages from the SashModel. Left only the top level folder
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	public void closeAllOpenedPages() {

		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.closeAllOpenedPages();
			}
		}.run();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#closePage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param pageIdentifier
	 */
	public void closeOtherPages(final Object pageIdentifier) {

		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.closeOtherPages(pageIdentifier);
			}
		}.run();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#openPage(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 */
	public void openPage(final Object pageIdentifier) {

		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.openPage(pageIdentifier);
			}
		}.run();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#removePage(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 */
	public void removePage(final Object pageIdentifier) {

		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.removePage(pageIdentifier);
			}
		}.run();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#isOpen(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public boolean isOpen(Object pageIdentifier) {
		return pageMngr.isOpen(pageIdentifier);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#openPrevious()
	 * 
	 */
	public void openPrevious() {

		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.openPrevious();
			}
		}.run();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr#openNext()
	 * 
	 */
	public void openNext() {

		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.openNext();
			}
		}.run();
	}

	public void pageChanged(final IPage page) {
		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.pageChanged(page);
			}
		}.run();

	}

	/**
	 * class runnable to encapsulate a command
	 * 
	 * @author aradouan
	 * 
	 */
	public abstract class TransactionPageMngrRunnable implements Runnable {

		public void run() {
			TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();
			RecordingCommand command = new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					doRun();
				}
			};
			editingDomain.getCommandStack().execute(command);
		}

		public abstract void doRun();

	}

	public void pageOpened(final IPage page) {
		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.pageOpened(page);
			}
		}.run();
	}

	public void pageClosed(final IPage page) {
		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.pageClosed(page);
			}
		}.run();
	}

	public void pageActivated(final IPage page) {
		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.pageActivated(page);
			}
		}.run();
	}

	public void pageDeactivated(final IPage page) {
		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.pageDeactivated(page);
			}
		}.run();
	}

	public void pageAboutToBeOpened(final IPage page) {
		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.pageAboutToBeOpened(page);
			}
		}.run();
	}

	public void pageAboutToBeClosed(final IPage page) {
		new TransactionPageMngrRunnable() {

			@Override
			public void doRun() {
				pageMngr.pageAboutToBeClosed(page);
			}
		}.run();
	}

	public boolean hasPreviousHistory() {
		return pageMngr.hasPreviousHistory();
	}

	public boolean hasNextHistory() {
		return pageMngr.hasNextHistory();
	}

	public int isInHsitory(Object pageIdentifier) {
		return pageMngr.isInHsitory(pageIdentifier);
	}

}
