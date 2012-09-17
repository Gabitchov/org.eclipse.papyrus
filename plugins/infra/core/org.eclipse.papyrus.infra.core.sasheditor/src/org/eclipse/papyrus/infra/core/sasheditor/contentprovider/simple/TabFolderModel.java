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
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

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
public class TabFolderModel extends AbstractPanelModel implements ITabFolderModel {

	/**
	 * List of items to be shown
	 */
	private List<IPageModel> children = new ArrayList<IPageModel>();

	/**
	 * The root of the sash models
	 */
	private SimpleSashWindowsContentProvider contentProvider;

	/**
	 * Constructor.
	 */
	public TabFolderModel(SimpleSashWindowsContentProvider contentProvider) {
		// Parent should be set later.
		super(null);
		this.contentProvider = contentProvider;
	}

	/**
	 * 
	 */
	public List<?> getChildren() {
		return children;
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
	private void addItem(IPageModel newModel) {
		doAddItem(newModel);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, newModel));
	}

	/**
	 * Add a model at the specified position.
	 * 
	 * @param index
	 * @param newModel
	 */
	private void addItem(int index, IPageModel newModel) {
		doAddItem(index, newModel);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, newModel));
	}

	/**
	 * Remove the specified tab.
	 * 
	 * @param index
	 * @return
	 */
	public IPageModel removeTab(int index) {
		IPageModel removed = doRemoveTab(index);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.REMOVED, this, removed));
		return removed;

	}

	/**
	 * Remove the specified tab.
	 * 
	 * @param tabItem
	 */
	public void removeTab(IPageModel tabItem) {
		doRemoveTab(tabItem);
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
		int listSize = children.size();
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
		IPageModel toMove = children.remove(oldIndex);
		children.add(newIndex, toMove);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.MOVED, this, toMove));
	}

	/**
	 * Add a new model.
	 * Do not fire change Event
	 * 
	 * @param newModel
	 */
	protected void doAddItem(IPageModel newModel) {
		children.add(newModel);
	}

	/**
	 * Add a model at the specified position.
	 * Do not fire change Event
	 * 
	 * @param index
	 * @param newModel
	 */
	protected void doAddItem(int index, IPageModel newModel) {
		if(index > children.size() || index < 0)
			children.add(newModel);
		else
			children.add(index, newModel);
	}

	/**
	 * Remove the specified tab.
	 * Do not fire change Event
	 * 
	 * @param index
	 * @return
	 */
	protected IPageModel doRemoveTab(int index) {
		IPageModel removed = children.remove(index);
		return removed;

	}

	/**
	 * Remove all tabs from the folder.
	 * 
	 * @return A list of removed tabs.
	 */
	protected List<IPageModel> doRemoveAll() {
		List<IPageModel> removed = new ArrayList<IPageModel>(children);
		children.clear();
		return removed;
	}

	/**
	 * Add all tabs to the folder.
	 * 
	 * @param newTabs
	 */
	protected void doAddAllTab(List<IPageModel> newTabs) {
		children.addAll(newTabs);
	}

	/**
	 * Remove the specified tab.
	 * Do not fire change Event
	 * 
	 * @param tabItem
	 */
	protected void doRemoveTab(IPageModel tabItem) {
		children.remove(tabItem);
		contentProvider.firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, tabItem));
	}

	/**
	 * Do nothing as this method should never be called on this class. {@inheritDoc}
	 */
	@Override
	public void replaceChild(AbstractPanelModel oldChild, AbstractPanelModel newChild) {
		throw new UnsupportedOperationException("This method should not be called on this class.");
	}

	/**
	 * Get a folder by one of its tab.
	 * 
	 * @param tabItem
	 *        Item for which a folder is looked for. If the item is null, return
	 *        the first folder encountered.
	 * @return The folder if it contains the item, or if item is null.
	 */
	@Override
	protected TabFolderModel lookupTabFolder(IPageModel tabItem) {

		if(tabItem == null)
			return this;

		if(children.contains(tabItem))
			return this;
		// not found
		return null;
	}

}
