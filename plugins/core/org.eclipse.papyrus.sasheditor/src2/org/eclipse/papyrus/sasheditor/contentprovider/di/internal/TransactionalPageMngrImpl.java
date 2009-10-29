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

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;

/**
 * A PageMngr based on EMF di and using Transactions. This implementation is a wrapper on
 * {@link PageMngrImpl}. Each method is wrapped in a {@link RecordingCommand}.
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
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#addPage(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 */
	public void addPage(final Object pageIdentifier) {
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();

		RecordingCommand command = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				pageMngr.addPage(pageIdentifier);

			}
		};

		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#allPages()
	 * 
	 * @return
	 */
	public List<Object> allPages() {
		return pageMngr.allPages();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#closePage(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 */
	public void closePage(final Object pageIdentifier) {
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();

		RecordingCommand command = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				pageMngr.closePage(pageIdentifier);

			}
		};

		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#openPage(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 */
	public void openPage(final Object pageIdentifier) {
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();

		RecordingCommand command = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				pageMngr.openPage(pageIdentifier);

			}
		};

		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#removePage(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 */
	public void removePage(final Object pageIdentifier) {
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();

		RecordingCommand command = new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				pageMngr.removePage(pageIdentifier);

			}
		};

		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr#isOpen(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public boolean isOpen(Object pageIdentifier) {
		return pageMngr.isOpen(pageIdentifier);
	}

}
