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
 * Base class of the Part hierarchy.
 * This class provides common methods for sashwindows Parts.
 * 
 * 
 * @author dumoulin
 */
public abstract class AbstractPart {

	/**
	 * Enumeration used when the parts are synchronized.
	 */
	public enum GarbageState {
		UNCHANGED, ORPHANED, REPARENTED, CREATED
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
	 * @return
	 */
	public SashWindowsContainer getSashWindowContainer() {
		return sashWindowsContainer;
	}


	/**
	 * Get the content provider of the sashwindows.
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
		return garbageState == GarbageState.ORPHANED;
	}

	/**
	 * @return
	 */
	public GarbageState getGarbageState() {
		return garbageState;
	}


}
