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

import org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel;

/**
 * Interface used by SashWindows package to access the underlying model describing the sash windows.
 * 
 * @TODO Move TilePart model intreface in this interface ?
 */
public interface ISashWindowsModelManager {

	/**
	 * Add the specified listener to the model. The listener should be call each time the model is changed, but at the end of the transaction.
	 */
	public void addChangeListener(ISashWindowModelChangeListener listener);

	/**
	 * Remove the specified listener to the model.
	 */
	public void removeChangeListener(ISashWindowModelChangeListener listener);

	/**
	 * Ask the model for the root of SashWindows.
	 * 
	 * @return The root object.
	 */
	public Object getModelRoot();

	/**
	 * Factory used to create a model wrapper for the specified model node. The wrapper will be used by SashWindowsContainer's parts
	 */
	public ITilePart.ITilePartNodeModel createTilePartModel(Object model);

	/**
	 * Ask the model to move the specified tab inside the same folder. No events should be thrown until the complete move is perform. This method is called by the the SashTileContainer when the user
	 * have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param srcFolder
	 * @param srcsrcTabIndex
	 * @param targetTabIndex
	 *            Index where the tab will be placed. Other tabs are moved upward.
	 */
	public void moveTab(ITabFolderModel srcFolder, int srcIndex, int targetIndex);

	/**
	 * Ask the model to move the specified tab inside the same folder. No events should be thrown until the complete move is perform. This method is called by the the SashTileContainer when the user
	 * have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param srcFolder
	 * @param srcsrcTabIndex
	 * @param targetTabIndex
	 *            Index where the tab will be placed. Other tabs are moved upward.
	 */
	public void createFolder(ITabFolderModel srcFolder, int srcTabIndex, ITabFolderModel targetFolder, int side);

	/**
	 * Ask the model to move the specified tab to the specified destination. No events should be thrown until the complete move is perform. This method is called by the the SashTileContainer when the
	 * user have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param srcFolder
	 *            The Diagram node containing the tabs
	 * @param srcTabIndex
	 * @param targetFolder
	 * @param targetTabIndex
	 */
	public void moveTab(ITabFolderModel srcFolder, int srcTabIndex, ITabFolderModel targetFolder, int targetIndex);

	/**
	 * Ask the model to move the specified tab to the specified destination. No events should be thrown until the complete move is perform. This method is called by the the SashTileContainer when the
	 * user have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param srcFolder
	 *            The Diagram node containing the tabs
	 * @param srcTabIndex
	 * @param targetFolder
	 * @param targetTabIndex
	 */
	// public void moveTab(Object srcfolder, int srcTabIndex, Object targetFolder, int targetTabIndex);
	/**
	 * Ask the model to move the specified tab inside the same folder. No events should be thrown until the complete move is perform. This method is called by the the SashTileContainer when the user
	 * have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param srcFolder
	 * @param srcsrcTabIndex
	 * @param targetTabIndex
	 *            Index where the tab will be placed. Other tabs are moved upward.
	 */
	// public void moveTab(Object srcfolder, int srcTabIndex, int targetTabIndex);
	/**
	 * Ask the model to move the specified tab inside the same folder. No events should be thrown until the complete move is perform. This method is called by the the SashTileContainer when the user
	 * have drag a tab in a correct place. The SashTileContainer has not change is presentation yet. This will be done when the corresponding event will occur.
	 * 
	 * @param srcFolder
	 * @param srcsrcTabIndex
	 * @param targetTabIndex
	 *            Index where the tab will be placed. Other tabs are moved upward.
	 */
	// public void createTab(Object srcfolder, int srcTabIndex, Object targetfolder, int position);
}