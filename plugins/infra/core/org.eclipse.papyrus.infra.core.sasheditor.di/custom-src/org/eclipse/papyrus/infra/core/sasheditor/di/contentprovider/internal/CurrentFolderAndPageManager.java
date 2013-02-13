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

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;


/**
 * This object is used to retrieve the current folder and to allow to set the active 
 * page.
 * <br>
 * This implementation is associated to the {@link ISashWindowsContainer}, and use it to
 * provide the desired behavior.
 * 
 * @author cedric dumoulin
 *
 */
public class CurrentFolderAndPageManager implements ICurrentFolderAndPageMngr {

	/**
	 * Associated {@link ISashWindowsContainer}
	 */
	protected ISashWindowsContainer sashWindowsContainer;
	/**
	 * Constructor.
	 *
	 */
	public CurrentFolderAndPageManager(ISashWindowsContainer sashWindowsContainer) {
		this.sashWindowsContainer =sashWindowsContainer;
	}

	/**
	 * Get the folder currently selected.
	 * <br>
	 * This implementation ask to the {@link ISashWindowsContainer}.
	 * <br>
	 * The current folder is usually the folder containing the currently active
	 * page.
	 * @return The current folder, or null if no folder is selected.
	 */
	public TabFolder getCurrentFolder() {
		
		ITabFolderModel folder = sashWindowsContainer.getSelectedTabFolderModel();
        // Our implementation is of type TabFolderModel
		return ((TabFolderModel)folder).getTabFolder();
	}
	
	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.ICurrentFolderAndPageMngr#setActivePage(java.lang.Object)
	 *
	 * @param pageIdentifier
	 */
	public void setActivePage( Object pageIdentifier) {
		IPage page = sashWindowsContainer.lookupModelPage(pageIdentifier);
		sashWindowsContainer.selectPage(page);
	}
}
