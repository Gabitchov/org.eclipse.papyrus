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
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.singlefolder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedListener.ContentEvent;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;

/**
 * Basic implementation allowing to add item to be shown.
 * 
 * @author dumoulin
 * 
 */
public class SingleFolderModel implements ITabFolderModel {

	/**
	 * List of items to be shown
	 */
	private List<IPageModel> itemModels = new ArrayList<IPageModel>();

	/**
	 * The root of the sash models
	 */
	private SingleFolderContentProvider contentProvider;

	/**
	 * Constructor.
	 */
	public SingleFolderModel(SingleFolderContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	/**
	 * 
	 */
	public List<?> getChildren() {
		return itemModels;
	}

	/**
	 * This default implementation return directly the child which is already of the appropriate type.
	 */
	public IPageModel createChildSashModel(Object child) {
		// In this default implementation, the child is already of the appropriate type.
		return (IPageModel)child;
	}

	/**
	 * Add a new model.
	 * 
	 * @param newModel
	 */
	public void addItem(IPageModel newModel) {
		itemModels.add(newModel);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, newModel));
	}

	/**
	 * Add a model at the specified position.
	 * 
	 * @param index
	 * @param newModel
	 */
	public void addItem(int index, IPageModel newModel) {
		itemModels.add(index, newModel);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, newModel));
	}

	/**
	 * Remove the specified tab.
	 * 
	 * @param index
	 * @return
	 */
	public IPageModel removeTab(int index) {
		IPageModel removed = itemModels.remove(index);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, removed));
		return removed;

	}

	/**
	 * Remove the specified tab.
	 * 
	 * @param tabItem
	 */
	public void removeTab(IPageModel tabItem) {
		itemModels.remove(tabItem);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, tabItem));
	}

	/**
	 * Move a tab inside the folder.
	 * Moves the tab from the old position to the new position.
	 * 
	 * @param oldIndex
	 *        the position of the tab before the move.
	 * @param newIndex
	 *        the position of the tab after the move.
	 */
	public void moveTab(int oldIndex, int newIndex) {

		int listSize = itemModels.size();
		if(newIndex >= listSize) {
			newIndex = listSize - 1;
		}
		if(newIndex < 0) {
			newIndex = 0;
		}

		if(oldIndex == newIndex)
			return;

		if(listSize == 0)
			return;


		// Move
		IPageModel toMove = itemModels.remove(oldIndex);
		itemModels.add(newIndex, toMove);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.MOVED, this, toMove));
	}
}
