/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.modelexplorer;

import org.eclipse.papyrus.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.core.ui.pagebookview.ViewPartPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * A Page Book containing one {@link ModelExplorerView} for each opened Papyrus Editor.
 * 
 * @author cedric dumoulin
 * 
 */
public class ModelExplorerPageBookView extends MultiViewPageBookView implements ITabbedPropertySheetPageContributor {

	/**
	 * Create the page handling the View for the specified part.
	 * 
	 * @see org.eclipse.ui.part.PageBookView#doCreatePage(org.eclipse.ui.IWorkbenchPart)
	 * 
	 * @param part
	 * @return
	 */
	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {

		// part is of type IMultiDiagramEditor (because of isImportant() )

		ViewPartPage page = new ModelExplorerPage();

		// Init the page, and so the View
		initPage(page, part);
		page.createControl(getPageBook());
		return new PageRec(part, page);
	}


	/**
	 * @see org.eclipse.ui.part.PageBookView#getAdapter(java.lang.Class)
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {

		if(IPropertySheetPage.class == adapter) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when necessary
			return new TabbedPropertySheetPage(this);
		}

		return super.getAdapter(adapter);
	}

	/**
	 * Overrides getContributorId.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor#getContributorId()
	 */
	public String getContributorId() {
		// return Activator.PLUGIN_ID;
		return "TreeOutlinePage";

	}


}
