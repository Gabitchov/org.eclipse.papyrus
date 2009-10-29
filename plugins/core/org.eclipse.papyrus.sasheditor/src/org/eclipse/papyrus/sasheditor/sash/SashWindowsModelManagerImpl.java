/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.sasheditor.sash;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel;

/**
 * Base implementation of SashWindow model manager. This implementation provides fireEvent methods
 * calling registered listeners. It also unwrap calls taking a ITabFolderModel as parameter.
 * 
 * @param T
 *            Common ancestor for the model provided for the sash windows by the application. This
 *            is the type used externally by the application. Sash implementation don't use this
 *            type, it just carry it to ask for the appropriate wrapper. Concrete implementation can
 *            specify a type.
 */
public abstract class SashWindowsModelManagerImpl<T> implements ISashWindowsModelManager<T> {

	/** list of listeners on model change */
	private final List<ISashWindowModelChangeListener> modelChangeListeners = new ArrayList<ISashWindowModelChangeListener>();

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#addChangeListener(org.eclipse.papyrus.sasheditor.sash.ISashWindowModelChangeListener)
	 */
	public void addChangeListener(ISashWindowModelChangeListener listener) {
		modelChangeListeners.add(listener);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#removeChangeListener(org.eclipse.papyrus.sasheditor.sash.ISashWindowModelChangeListener)
	 */
	public void removeChangeListener(ISashWindowModelChangeListener listener) {
		modelChangeListeners.remove(listener);
	}

	/**
	 * Fire the specified event to all listeners.
	 */
	public void firePropertyChangeEvent(ChangeEvent event) {
		for (ISashWindowModelChangeListener cur : modelChangeListeners) {
			cur.notifyChanged(event);
		}
	}

	/**
	 * Fire an event indicating to refresh all.
	 */
	// @unused
	public void fireModelChangedEvent() {
		ChangeEvent event = new ChangeEvent();
		firePropertyChangeEvent(event);
	}

	/**
	 * Fire the specified event to all listeners. Fire an event indicating that a folder has been
	 * inserted on the side of the specified relativeFolder.
	 * 
	 */
	// @unused
	public void fireFolderInsertedEvent(Object insertedFolder, int side, Object relativeFolder) {
		FolderInsertedEvent event = new FolderInsertedEvent(insertedFolder, side, relativeFolder);
		firePropertyChangeEvent(event);
	}

	/**
	 * Fire the specified event to all listeners. Fire an event indicating that a tab has been
	 * moved. specified relativeFolder.
	 * 
	 */
	// @unused
	public void fireTabMovedEvent(Object srcFolder, int srcTabIndex, Object targetFolder, int targetIndex) {
		TabMovedEvent event = new TabMovedEvent(srcFolder, srcTabIndex, targetFolder, targetIndex);
		firePropertyChangeEvent(event);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#createFolder(org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel,
	 *      int, org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel, int)
	 */
	public void createFolder(ITabFolderModel<T> srcFolder, int srcTabIndex, ITabFolderModel<T> targetFolder, int side) {

		createFolder(srcFolder.getNodeModel(), srcTabIndex, targetFolder.getNodeModel(), side);
	}

	/**
	 * 
	 */
	abstract public void createFolder(Object nodeModel, int srcTabIndex, Object nodeModel2, int side);

	/**
	 * Remove the specified tab from the folder. Also remove the tab if it is empty.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#removeTab(org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel,
	 *      int)
	 * @param srcFolder
	 * @param srcIndex
	 * 
	 */
	public void removeTab(ITabFolderModel<T> srcFolder, int srcIndex) {
		removeTab(srcFolder.getNodeModel(), srcIndex);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#moveTab(org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel,
	 *      int, int)
	 */
	public void moveTab(ITabFolderModel<T> srcFolder, int srcIndex, int targetIndex) {
		moveTab(srcFolder.getNodeModel(), srcIndex, targetIndex);

	}

	/**
	 * Ask the model to remove the specified tab inside the same folder. No events should be thrown
	 * until the complete remove is perform. This method is called by the the SashTileContainer when
	 * the user click the close cross on a tab.. The SashTileContainer has not change is
	 * presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param nodeModel
	 *            The external model representing a folder.
	 * @param srcIndex
	 */
	abstract public void removeTab(T nodeModel, int srcIndex);

	/**
	 * Ask the model to move the specified tab inside the same folder. No events should be thrown
	 * until the complete move is perform. This method is called by the the SashTileContainer when
	 * the user have drag a tab in a correct place. The SashTileContainer has not change is
	 * presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param nodeModel
	 *            The external model representing a folder.
	 * @param srcIndex
	 * @param targetIndex
	 */
	abstract public void moveTab(T nodeModel, int srcIndex, int targetIndex);

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#moveTab(org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel,
	 *      int, org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel, int)
	 */
	public void moveTab(ITabFolderModel<T> srcFolder, int srcTabIndex, ITabFolderModel<T> targetFolder, int targetIndex) {
		moveTab(srcFolder.getNodeModel(), srcTabIndex, targetFolder.getNodeModel(), targetIndex);

	}

	/**
	 * Ask the model to move the specified tab to the specified destination. No events should be
	 * thrown until the complete move is perform. This method is called by the the SashTileContainer
	 * when the user have drag a tab in a correct place. The SashTileContainer has not change is
	 * presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param nodeModel
	 *            The external model representing a folder.
	 * @param srcIndex
	 * @param nodeModel
	 *            The external model representing a folder.
	 * @param targetIndex
	 */
	abstract public void moveTab(T nodeModel, int srcTabIndex, T nodeModel2, int targetIndex);

}
