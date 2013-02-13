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

package org.eclipse.papyrus.infra.core.sasheditor.internal;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;

/**
 * This class is used as a delegate to the external implementation of the 
 * {@link ISashWindowsContentProvider}.
 * All methods from the {@link SashWindowsContainer} and its tree of classes call the delegate
 * which in turn call the external implementation.
 * <br>
 * This allows to have a central point performing calls to the external implementation.
 * 
 * @author cedric dumoulin
 *
 */
public class DelegateContentProvider implements ISashWindowsContentProvider {

	private ISashWindowsContentProvider contentProvider;
	
	/**
	 * Constructor.
	 *
	 * @param contentProvider
	 */
	public DelegateContentProvider(ISashWindowsContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#getRootModel()
	 *
	 * @return
	 */
	public Object getRootModel() {
		return contentProvider.getRootModel();
	}


	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#createChildSashModel(java.lang.Object)
	 *
	 * @param root
	 * @return
	 */
	public IAbstractPanelModel createChildSashModel(Object root) {
		return contentProvider.createChildSashModel(root);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#addPage(java.lang.Object)
	 *
	 * @param page
	 */
	public void addPage(Object page) {
		contentProvider.addPage(page);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#addPage(java.lang.Object, int)
	 *
	 * @param page
	 * @param index
	 */
	public void addPage(Object page, int index) {
		contentProvider.addPage(page, index);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#movePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int, int)
	 *
	 * @param folderModel
	 * @param oldIndex
	 * @param newIndex
	 */
	public void movePage(ITabFolderModel folderModel, int oldIndex, int newIndex) {
		contentProvider.movePage(folderModel, oldIndex, newIndex);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#movePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int, org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int)
	 *
	 * @param srcFolderModel
	 * @param sourceIndex
	 * @param targetFolderModel
	 * @param targetIndex
	 */
	public void movePage(ITabFolderModel srcFolderModel, int sourceIndex, ITabFolderModel targetFolderModel, int targetIndex) {
		contentProvider.movePage(srcFolderModel, sourceIndex, targetFolderModel, targetIndex);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(int)
	 *
	 * @param index
	 */
	public void removePage(int index) {
		contentProvider.removePage(index);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(java.lang.Object)
	 *
	 * @param page
	 */
	public void removePage(Object page) {
		contentProvider.removePage(page);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#removePage(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int)
	 *
	 * @param parentFolder
	 * @param tabIndex
	 */
	public void removePage(ITabFolderModel parentFolder, int tabIndex) {
		contentProvider.removePage(parentFolder, tabIndex);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#createFolder(org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int, org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel, int)
	 *
	 * @param tabFolder
	 * @param tabIndex
	 * @param targetFolder
	 * @param side
	 */
	public void createFolder(ITabFolderModel tabFolder, int tabIndex, ITabFolderModel targetFolder, int side) {
		contentProvider.createFolder(tabFolder, tabIndex, targetFolder, side);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#setCurrentFolder(java.lang.Object)
	 *
	 * @param rawModel
	 */
	public void setCurrentFolder(Object rawModel) {
		contentProvider.setCurrentFolder(rawModel);

	}

}
