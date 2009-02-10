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

import org.eclipse.papyrus.sasheditor.sash.ITilePart.ITilePartNodeModel;
import org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel;

/**
 * Base implemntation of SashWindow model manager. This implementation provides fireEvent methods calling registered listeners. It also unwrap calls taking a ITabFolderModel as parameter.
 */
public abstract class SashWindowsModelManagerImpl implements ISashWindowsModelManager {

	/** list of listeners on model change */
	private List<ISashWindowModelChangeListener> modelChangeListeners = new ArrayList<ISashWindowModelChangeListener>();

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
	public void fireModelChangedEvent() {
		ChangeEvent event = new ChangeEvent();
		firePropertyChangeEvent(event);
	}

	/**
	 * Fire the specified event to all listeners. Fire an event indicating that a folder has been inserted on the side of the specified relativeFolder.
	 * 
	 */
	public void fireFolderInsertedEvent(Object insertedFolder, int side, Object relativeFolder) {
		FolderInsertedEvent event = new FolderInsertedEvent(insertedFolder, side, relativeFolder);
		firePropertyChangeEvent(event);
	}

	/**
	 * Fire the specified event to all listeners. Fire an event indicating that a tab has been moved. specified relativeFolder.
	 * 
	 */
	public void fireTabMovedEvent(Object srcFolder, int srcTabIndex, Object targetFolder, int targetIndex) {
		TabMovedEvent event = new TabMovedEvent(srcFolder, srcTabIndex, targetFolder, targetIndex);
		firePropertyChangeEvent(event);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#createFolder(org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel, int,
	 *      org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel, int)
	 */
	public void createFolder(ITabFolderModel srcFolder, int srcTabIndex, ITabFolderModel targetFolder, int side) {

		createFolder(srcFolder.getNodeModel(), srcTabIndex, targetFolder.getNodeModel(), side);
	}

	/**
	 * 
	 */
	abstract public void createFolder(Object nodeModel, int srcTabIndex, Object nodeModel2, int side);

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#moveTab(org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel, int, int)
	 */
	public void moveTab(ITabFolderModel srcFolder, int srcIndex, int targetIndex) {
		moveTab(srcFolder.getNodeModel(), srcIndex, targetIndex);

	}

	/**
	 * 
	 */
	abstract public void moveTab(Object nodeModel, int srcIndex, int targetIndex);

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#moveTab(org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel, int,
	 *      org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel, int)
	 */
	public void moveTab(ITabFolderModel srcFolder, int srcTabIndex, ITabFolderModel targetFolder, int targetIndex) {
		moveTab(srcFolder.getNodeModel(), srcTabIndex, targetFolder.getNodeModel(), targetIndex);

	}

	/**
	 * 
	 */
	abstract public void moveTab(Object nodeModel, int srcTabIndex, Object nodeModel2, int targetIndex);

}
