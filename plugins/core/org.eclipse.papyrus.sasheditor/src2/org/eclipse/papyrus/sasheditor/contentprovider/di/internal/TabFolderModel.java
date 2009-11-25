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

import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.TabFolder;


/**
 * @author dumoulin
 */
public class TabFolderModel implements ITabFolderModel {

	/**
	 * The di Model.
	 */
	private TabFolder tabFolder;

	private IPageModelFactory pageModelFactory;

	/**
	 * 
	 * @param root
	 */
	public TabFolderModel(TabFolder tabFolder, IPageModelFactory pageModelFactory) {
		this.tabFolder = tabFolder;
		this.pageModelFactory = pageModelFactory;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel#getChildren()
	 * 
	 * @return
	 */
	public List<?> getChildren() {
		return tabFolder.getChildren();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel#createChildSashModel(java.lang.Object)
	 * 
	 * @param child
	 *        The child object returned by {@link TabFolderModel#getChildren}
	 * @return
	 */
	public IPageModel createChildSashModel(Object child) {

		PageRef pageRef = (PageRef)child;

		return pageModelFactory.createIPageModel(pageRef.getPageIdentifier());
	}


	/**
	 * @return the tabFolder
	 */
	public TabFolder getTabFolder() {
		return tabFolder;
	}

}
