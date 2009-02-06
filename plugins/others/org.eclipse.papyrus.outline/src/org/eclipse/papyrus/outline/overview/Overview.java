/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 * 
 * $Id$
 **********************************************************************/
package org.eclipse.papyrus.outline.overview;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;

/**
 * This view provides an overview of a given editor
 * 
 * @author Jacques Lescot
 */
public class Overview extends PageBookView {

	/** ID of the Documentation view */
	public static final String VIEW_ID = "org.eclipse.emf.ecoretools.overview.internal.Overview";

	/**
	 * The Constructor
	 */
	public Overview() {
		super();
	}

	/**
	 * Creates and returns the default page for this view.
	 */
	@Override
	protected IPage createDefaultPage(PageBook book) {
		MessagePage page = new MessagePage();
		initPage(page);
		page.createControl(book);
		page.setMessage("No Overview is available");
		return page;
	}

	/**
	 * Creates a new page in the pagebook for a particular part. This page will
	 * be made visible whenever the part is active, and will be destroyed with a
	 * call to <code>doDestroyPage</code>.
	 */
	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		IOverviewPage page = (IOverviewPage) part
				.getAdapter(IOverviewPage.class);
		if (page == null) {
			page = (IOverviewPage) Platform.getAdapterManager().loadAdapter(
					part, IOverviewPage.class.getName());
		}
		if (page != null) {
			initPage(page);
			page.createControl(getPageBook());
			return new PageRec(part, page);
		}

		// Use the default page
		return null;
	}

	/**
	 * Destroys a page in the pagebook for a particular part. This page was
	 * returned as a result from <code>doCreatePage</code>.
	 */
	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		IOverviewPage page = (IOverviewPage) pageRecord.page;
		page.dispose();
		pageRecord.dispose();
	}

	/**
	 * Returns the active, important workbench part for this view.
	 */
	@Override
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
		if (page != null) {
			return page.getActiveEditor();
		}
		return null;
	}

	/**
	 * Returns whether the given part should be added to this view.
	 */
	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		return part instanceof IEditorPart;
	}

	/**
	 * The <code>PageBookView</code> implementation of this
	 * <code>IPartListener</code> method shows the page when the given part is
	 * activated.
	 */
	public void partActivated(IWorkbenchPart part) {
		IContributedContentsView view = (IContributedContentsView) part
				.getAdapter(IContributedContentsView.class);
		IWorkbenchPart source = null;
		if (view != null) {
			source = view.getContributingPart();
		}
		if (source != null) {
			super.partActivated(source);
		} else {
			super.partActivated(part);
		}
	}
}
