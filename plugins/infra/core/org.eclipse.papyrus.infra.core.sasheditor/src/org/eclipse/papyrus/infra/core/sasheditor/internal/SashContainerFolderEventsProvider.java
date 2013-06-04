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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IFolder;


/**
 * A class managing Folder events of the {@link SashWindowsContainer}.
 * This class dispatch folder events fired by the {@link SashWindowsContainer} to any folder listeners
 * implementing {@link SashContainerFolderEventsProvider}.
 * 
 * @author cedric dumoulin
 *
 */
public class SashContainerFolderEventsProvider {

	/** List of listeners */
	private List<ITabFolderPartLifeCycleEventsListener> listeners = new ArrayList<ITabFolderPartLifeCycleEventsListener>();

	protected List<IFolder> folders;
	protected List<TabFolderPart> tabFolderParts;
	
	public List<IFolder> getFolders() {
		return (List<IFolder>)(List)tabFolderParts;
	}
	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void addListener(ITabFolderPartLifeCycleEventsListener listener) {
		// no duplicate
		if(listeners.contains(listener))
			return;
		listeners.add(listener);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void removeListener(ITabFolderPartLifeCycleEventsListener listener) {
		listeners.remove(listener);
	}


	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void fireFolderCreatedEvent(TabFolderPart folder) {
		// Fire events to internal listeners
		for(ITabFolderPartLifeCycleEventsListener listener : listeners) {
			listener.folderCreated(folder);
		}
	}

	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void fireFolderDisposedEvent(TabFolderPart folder) {
		// Fire events to internal listeners
		for(ITabFolderPartLifeCycleEventsListener listener : listeners) {
			listener.folderDisposed(folder);
		}
	}

}
