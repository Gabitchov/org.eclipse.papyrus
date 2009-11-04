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
package org.eclipse.papyrus.sasheditor.internal;

import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;

/**
 * Base class of the Part hierarchy. This class provides common methods for sashwindows Parts.
 * 
 * 
 * @author dumoulin
 */
public abstract class AbstractPart {

	/**
	 * Enumeration used when the parts are synchronized.
	 * <ul>
	 * <li>UNVISITED - The part not yet visited. This is the initial state when synchronizing. The
	 * part can stay in this state after synchronization if one of its parent is ORPHANED.</li>
	 * <li>ORPHANED - The part is orphaned from its direct parent.</li>
	 * <li>REPARENTED - The part parent has changed</li>
	 * <li>CREATED - The part is newly created</li>
	 * <li>UNCHANGED - The part is visited, and its parent is unchanged.</li>
	 * </ul>
	 */
	public enum GarbageState {
		UNVISITED, ORPHANED, REPARENTED, CREATED, UNCHANGED
	}

	/**
	 * The main container.
	 */
	protected SashWindowsContainer sashWindowsContainer;

	/** Garbage state used during refresh */
	protected GarbageState garbageState = GarbageState.CREATED;

	/**
	 * @param sashWindowsContainer
	 */
	public AbstractPart(SashWindowsContainer sashWindowsContainer) {
		this.sashWindowsContainer = sashWindowsContainer;
	}

	/**
	 * Get the {@link SashWindowsContainer}.
	 * 
	 * @return
	 */
	public SashWindowsContainer getSashWindowContainer() {
		return sashWindowsContainer;
	}

	/**
	 * Get the content provider of the sashwindows.
	 * 
	 * @return
	 */
	public ISashWindowsContentProvider getContentProvider() {
		return sashWindowsContainer.getContentProvider();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isOrphaned() {
		return GarbageState.ORPHANED.equals(garbageState);
	}

	/**
	 * Return true if the page state == {@link GarbageState#UNVISITED}.
	 * 
	 * @return
	 */
	public boolean isUnchecked() {

		return GarbageState.UNVISITED.equals(garbageState);
	}

	/**
	 * @return
	 */
	public GarbageState getGarbageState() {
		return garbageState;
	}

}
