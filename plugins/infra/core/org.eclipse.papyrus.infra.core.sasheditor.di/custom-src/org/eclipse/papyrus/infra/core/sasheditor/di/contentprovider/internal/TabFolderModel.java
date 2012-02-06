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

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;


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
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel#getChildren()
	 * 
	 * @return
	 */
	public List<?> getChildren() {
		return tabFolder.getChildren();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel#createChildSashModel(java.lang.Object)
	 * 
	 * @param child
	 *        The child object returned by {@link TabFolderModel#getChildren}
	 * @return
	 */
	public IPageModel createChildSashModel(Object child) {

		PageRef pageRef = (PageRef)child;

		Object pageIdentifier = pageRef.getPageIdentifier();
		if(pageIdentifier != null) {
			return pageModelFactory.createIPageModel(pageIdentifier);
		} else {
			return null;
	}
	}

	/**
	 * @return the tabFolder
	 */
	public TabFolder getTabFolder() {
		return tabFolder;
	}

}
