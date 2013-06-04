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

import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IFolder;
import org.eclipse.papyrus.infra.core.sasheditor.utils.IObservableList;
import org.eclipse.papyrus.infra.core.sasheditor.utils.ObservableList;


/**
 * This class maintain a list of {@link TabFolderPart} used inside the {@link SashWindowsContainer}.
 * <br>
 * The class listen to the {@link SashContainerFolderEventsProvider}, and add or remove folder to 
 * the list according to the events.
 * <br>
 * The list of {@link TabFolderPart} is an observable list. 
 * 
 * @author cedric dumoulin
 *
 */
public class TabFolderListManager implements ITabFolderPartLifeCycleEventsListener {

	/**
	 * Maintained list of {@link TabFolderPart}.
	 */
	private ObservableList<TabFolderPart> folderParts = new ObservableList<TabFolderPart>();

	/**
	 * @return the folderParts
	 */
	public ObservableList<TabFolderPart> getFolderParts() {
		return folderParts;
	}

	/**
	 * Get a List of IFolder.
	 * This method is part of the public API.
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IObservableList<IFolder> getFolderList() {
		return (IObservableList<IFolder>)(List)folderParts;
	}

	/**
	 * The {@link SashContainerFolderEventsProvider} sned an event. Add the new folder to the list.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.internal.ITabFolderPartLifeCycleEventsListener#folderCreated(org.eclipse.papyrus.infra.core.sasheditor.internal.TabFolderPart)
	 *
	 * @param folder The newly added folder
	 */
	public void folderCreated(TabFolderPart folder) {
		folderParts.add(folder);
		
	}

	/**
	 * The {@link SashContainerFolderEventsProvider} sned an event. Remove the folder from the list.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.internal.ITabFolderPartLifeCycleEventsListener#folderDisposed(org.eclipse.papyrus.infra.core.sasheditor.internal.TabFolderPart)
	 *
	 * @param folder The newly removed folder.
	 */
	public void folderDisposed(TabFolderPart folder) {
		folderParts.remove(folder);
	}
	
	
}
