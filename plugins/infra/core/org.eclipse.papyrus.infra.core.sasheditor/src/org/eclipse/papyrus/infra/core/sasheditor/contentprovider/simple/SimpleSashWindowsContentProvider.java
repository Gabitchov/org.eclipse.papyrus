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

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedListener.ContentEvent;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.swt.SWT;

/**
 * A simple implementation of providers allowing sashes and folders.
 * The tabs can be added and removed.
 * 
 * @author dumoulin
 * 
 */
public class SimpleSashWindowsContentProvider implements ISashWindowsContentProvider, IContentChangedProvider {

	/** The currently selected tab folder */
	private TabFolderModel currentTabFolder;

	/** The root model. */
	private RootModel rootModel;

	/** */
	private ContentChangeListenerManager contentChangedListenerManager = new ContentChangeListenerManager();

	/**
	 * Constructor.
	 */
	public SimpleSashWindowsContentProvider() {

		// Create a tree with one single folder
		currentTabFolder = new TabFolderModel(this);
		rootModel = new RootModel(currentTabFolder);
	}


	/**
	 * Add a listener listening on content changed. This listener will be
	 * notified each time the content change.
	 * 
	 * @param listener
	 */
	public void addListener(IContentChangedListener listener) {
		contentChangedListenerManager.addContentChangedListener(listener);
	}

	/**
	 * Add a listener listening on content changed. This listener will be
	 * notified each time the content change.
	 * 
	 * @param listener
	 */
	public void removeListener(IContentChangedListener listener) {
		contentChangedListenerManager.removeContentChangedListener(listener);
	}

	/**
	 * Add a listener listening on content changed. This listener will be
	 * notified each time the content change.
	 * 
	 * @param listener
	 */
	protected void firePropertyChanged(ContentEvent event) {
		contentChangedListenerManager.fireContentChanged(event);
	}

	/**
	 * Add the page which should be an IPageModel instance. {@inheritDoc}
	 */
	public void addPage(Object newModel) {
		addPage((IPageModel)newModel);
	}

	/**
	 * Add the page which should be an IPageModel instance. {@inheritDoc}
	 */
	public void addPage(Object newModel, int index) {
		addPage((IPageModel)newModel, index);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void addPage(IPageModel newModel) {
		currentTabFolder.doAddItem(newModel);
		firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, newModel));
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void addPage(int index, IPageModel newModel) {
		currentTabFolder.doAddItem(index, newModel);
		firePropertyChanged(new ContentEvent(ContentEvent.ADDED, this, newModel));
	}

	/**
	 * Move a Page inside the folder. {@inheritDoc}
	 */
	public void movePage(ITabFolderModel folderModel, int oldIndex, int newIndex) {
		org.eclipse.papyrus.infra.core.sasheditor.Activator.log.debug("movePage()");
		((TabFolderModel)folderModel).moveTab(oldIndex, newIndex);

	}

	/**
	 * Move a tab from folder to folder.
	 * The change event is sent only once after the complete operation is performed. {@inheritDoc}
	 */
	public void movePage(ITabFolderModel srcFolderModel, int sourceIndex, ITabFolderModel targetFolderModel, int targetIndex) {
		// This implementation use (TabFolderModel), so we can cast safely
		org.eclipse.papyrus.infra.core.sasheditor.Activator.log.debug("movePage()");
		if(sourceIndex == -1) {
			moveAllPages(srcFolderModel, targetFolderModel);
			return;
		}
		IPageModel movedTab = doMoveTab((TabFolderModel)srcFolderModel, sourceIndex, (TabFolderModel)targetFolderModel, targetIndex);
		removeEmptyFolder((TabFolderModel)srcFolderModel);
		doSetCurrentFolder((TabFolderModel)targetFolderModel);
		contentChangedListenerManager.fireContentChanged(new ContentEvent(ContentEvent.MOVED, this, movedTab));
	}

	/**
	 * Move all tabs from source to target
	 * 
	 * @param srcFolderModel
	 * @param targetFolderModel
	 */
	public void moveAllPages(ITabFolderModel srcFolderModel, ITabFolderModel targetFolderModel) {
		TabFolderModel srcFolder = (TabFolderModel)srcFolderModel;
		TabFolderModel targetFolder = (TabFolderModel)targetFolderModel;
		List<IPageModel> toMove = srcFolder.doRemoveAll();
		targetFolder.doAddAllTab(toMove);
		removeEmptyFolder((TabFolderModel)srcFolderModel);
		doSetCurrentFolder((TabFolderModel)targetFolderModel);
		contentChangedListenerManager.fireContentChanged(new ContentEvent(ContentEvent.MOVED, this, srcFolderModel));
	}

	/**
	 * Set the Current Folder to the newCurrentFolder.
	 * 
	 * @param targetFolderModel
	 */
	private void doSetCurrentFolder(TabFolderModel newCurrentFolder) {
		currentTabFolder = (TabFolderModel)newCurrentFolder;
	}

	/**
	 * Create a new folder and insert it at the specified side. Move the specified tab into the created Folder.
	 * 
	 * The change event is sent only once after the complete operation is performed. {@inheritDoc}
	 * 
	 * @param referenceFolder The folder used as reference to insert the newly created Folder. 
	 * @param side The side to which the created folder is inserted. Can be SWT.TOP, DOWN, LEFT, RIGHT.
	 */
	public void createFolder(ITabFolderModel sourceFolder, int tabIndex, ITabFolderModel referenceFolder, int side) {
		org.eclipse.papyrus.infra.core.sasheditor.Activator.log.debug("createFolder()");

		ITabFolderModel newFolder = doCreateFolder((TabFolderModel)sourceFolder, tabIndex, (TabFolderModel)referenceFolder, side);
		contentChangedListenerManager.fireContentChanged(new ContentEvent(ContentEvent.CHANGED, this, sourceFolder));
		//		return newFolder;
	}

	/**
	 * Create a new folder and insert it at the specified side of the reference folder.
	 * The change event is sent only once after the complete operation is performed. 
	 * 
	 * This method is not part of the {@link SashWindowsContainer} API. It is here to help writing junit tests.
	 * 
	 * @param referenceFolder The folder used as reference to insert the newly created Folder. 
	 * @param side The side to which the created folder is inserted. Can be SWT.TOP, DOWN, LEFT, RIGHT.
	 */
	public ITabFolderModel createFolder(ITabFolderModel referenceFolder, int side) {
		org.eclipse.papyrus.infra.core.sasheditor.Activator.log.debug("createFolder()");

		ITabFolderModel newFolder = doCreateFolder((TabFolderModel)referenceFolder, side);
		contentChangedListenerManager.fireContentChanged(new ContentEvent(ContentEvent.CHANGED, this, referenceFolder));
		return newFolder;
	}

	/**
	 * Move a tab from folder to folder.
	 * The change event is sent only once after the complete operation is performed.
	 * 
	 * @return The moved tab.
	 */
	private IPageModel doMoveTab(TabFolderModel srcFolderModel, int sourceIndex, TabFolderModel targetFolderModel, int targetIndex) {

		IPageModel tab = srcFolderModel.doRemoveTab(sourceIndex);
		targetFolderModel.doAddItem(targetIndex, tab);
		return tab;
	}

	/**
	 * Move a tab from folder to folder.
	 * The tab is added at the end of the target folder.
	 * The change event is sent only once after the complete operation is performed. {@inheritDoc}
	 */
	private void doMoveTab(TabFolderModel srcFolderModel, int sourceIndex, TabFolderModel targetFolderModel) {

		IPageModel tab = srcFolderModel.doRemoveTab(sourceIndex);
		targetFolderModel.doAddItem(tab);
	}

	/**
	 * Create a new folder and insert it at the specified side.
	 * 
	 */
	private TabFolderModel doCreateFolder(TabFolderModel tabFolder, int tabIndex, TabFolderModel targetFolder, int side) {

		// Create new folder. Parent will be set when inserted.
		TabFolderModel newFolder = new TabFolderModel(this);
		// Inset folder
		doInsertFolder(newFolder, targetFolder, side);
		// Move tab from folder to folder
		doMoveTab(tabFolder, tabIndex, newFolder);
		// Remove unused folder if necessary
		removeEmptyFolder(tabFolder);
		doSetCurrentFolder(targetFolder);

		return newFolder;
	}

	/**
	 * Create a new folder and insert it at the specified side.
	 * 
	 */
	private TabFolderModel doCreateFolder(TabFolderModel referenceFolder, int side) {

		// Create new folder. Parent will be set when inserted.
		TabFolderModel newFolder = new TabFolderModel(this);
		// Insert folder
		doInsertFolder(newFolder, referenceFolder, side);
		doSetCurrentFolder(referenceFolder);

		return newFolder;
	}

	/**
	 * Remove the folder if it is empty.
	 * 
	 * @param tabFolder
	 */
	private void removeEmptyFolder(TabFolderModel tabFolder) {
		// Check if empty
		if(tabFolder.getChildren().size() > 0)
			return;

		AbstractModel parent = tabFolder.getParent();
		// Forbid removing of the last folder
		if(parent == rootModel)
			return;

		// Parent is a sash. Ask it to remove the child and itself
		((SashPanelModel)parent).delete(tabFolder);
	}

	/**
	 * Insert the folderToInsert on the specified side of the refFolder. Create and insert the
	 * requested SashModel.
	 * 
	 * @param folderToInsert
	 * @param refFolder
	 * @param side
	 */
	private void doInsertFolder(TabFolderModel folderToInsert, TabFolderModel refFolder, int side) {
		// Get the parent under which the sash will be inserted
		AbstractModel refParent = refFolder.getParent();
		SashPanelModel newSash;

		int direction;
		// Compute sash direction
		if(side == SWT.LEFT || side == SWT.RIGHT)
			direction = SWT.HORIZONTAL;
		else
			direction = SWT.VERTICAL;
		// Create sash
		if(side == SWT.LEFT || side == SWT.UP) {
			newSash = new SashPanelModel(refParent, folderToInsert, refFolder, direction);
		} else {
			newSash = new SashPanelModel(refParent, refFolder, folderToInsert, direction);
		}

		// Change sash childs parent
		refFolder.setParent(newSash);
		folderToInsert.setParent(newSash);

		// Change sash parent
		refParent.replaceChild(refFolder, newSash);
	}

	/**
	 * Get the root used as root to be shown in the editor. {@inheritDoc}
	 */
	public IAbstractPanelModel getRootModel() {
		return rootModel.getChild();
	}

	/**
	 * Create the interface used to access the rootModel {@inheritDoc}
	 */
	public IAbstractPanelModel createChildSashModel(Object root) {
		// The root object should be of type IAbstractPanelModel.
		// This is normally the object returned by getRootPanel
		return (IAbstractPanelModel)root;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void removePage(int index) {
		currentTabFolder.removeTab(index);
	}

	/**
	 * Remove the specified page which should be an instance of IPageModel. {@inheritDoc}
	 */
	public void removePage(Object page) {

		removePage((IPageModel)page);
	}

	/**
	 * Remove the specified tab from its parent. {@inheritDoc}
	 */
	public void removePage(IPageModel tabItem) {

		TabFolderModel folder = lookupPageFolder(tabItem);
		if(folder != null)
			folder.removeTab(tabItem);
	}

	/**
	 * Remove the tab at the specified index.
	 * 
	 */
	public void removePage(ITabFolderModel parentFolder, int tabIndex) {
		TabFolderModel folder = (TabFolderModel)parentFolder;
		IPageModel removed = folder.doRemoveTab(tabIndex);
		removeEmptyFolder(folder);
		doSetCurrentFolder(lookupPageFolder());
		contentChangedListenerManager.fireContentChanged(new ContentEvent(ContentEvent.REMOVED, this, removed));
	}

	/**
	 * Lookup the folder containing the specified tabItem.
	 * 
	 * @param tabItem
	 *        Item for which a folder is looked for. If the item is null, return
	 *        the first folder encountered.
	 * @return The folder containing the item, or the first encountered folder if item is null.
	 */
	private TabFolderModel lookupPageFolder(IPageModel tabItem) {
		return rootModel.lookupTabFolder(tabItem);
	}

	/**
	 * Lookup for the first folder in the model.
	 * 
	 * @return The first encountered folder.
	 */
	private TabFolderModel lookupPageFolder() {
		return rootModel.lookupTabFolder(null);
	}

	/**
	 * Get the parent of the specified tabItem, or null
	 * 
	 * @param tabItem
	 * @return The parent tabFolder or null if not found.
	 */
	public ITabFolderModel getParentFolder(IPageModel tabItem) {
		return lookupPageFolder(tabItem);
	}

	/**
	 * Return the currently selected TabFolder.
	 * 
	 * @return
	 */
	public ITabFolderModel getCurrentTabFolder() {
		return currentTabFolder;
	}

	/**
	 * Set the the current Folder.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider#setCurrentFolder(java.lang.Object)
	 * 
	 * @param rawModel
	 *        Object identifying the current folder. In this implementation, the object is the FolderModel.
	 */
	public void setCurrentFolder(Object rawModel) {
		if(!(rawModel instanceof TabFolderModel)) {
			return;
		}
		doSetCurrentFolder((TabFolderModel)rawModel);
	}

	/**
	 * A class managing a list of listeners.
	 * 
	 * @author dumoulin
	 */
	protected class ContentChangeListenerManager {

		private List<IContentChangedListener> listeners;

		/**
		 * Add a listener listening on content changed. This listener will be
		 * notified each time the content change.
		 * 
		 * @param listener
		 */
		public void addContentChangedListener(IContentChangedListener listener) {
			if(listeners == null)
				createListeners();

			// Check if already exists.
			if(listeners.contains(listener))
				return;

			listeners.add(listener);
		}

		/**
		 * Add a listener listening on content changed. This listener will be
		 * notified each time the content change.
		 * 
		 * @param listener
		 */
		public void removeContentChangedListener(IContentChangedListener listener) {
			if(listeners == null)
				return;

			listeners.remove(listener);
		}

		/**
		 * Create the list of listeners.
		 */
		private void createListeners() {
			if(listeners == null)
				listeners = new ArrayList<IContentChangedListener>();

		}

		/**
		 * Fire the changed event.
		 * 
		 * @param event
		 */
		public void fireContentChanged(ContentEvent event) {
			if(listeners == null)
				return;

			for(IContentChangedListener listener : listeners) {
				listener.contentChanged(event);
			}
		}
	}

}
