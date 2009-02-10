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

import org.eclipse.swt.widgets.Composite;

/**
 * Base class of Tile Part.
 */
public abstract class TilePart implements ITilePart {

	/** Root Container of the Parts */
	protected TilePartContainer parentPartContainer;

	/** The parent of this ITilePart */
	protected ITilePart parent;

	/** Garbage state used during refresh */
	protected GarbageState garbageState;

	/**
	 * Constructor.
	 */
	public TilePart(TilePartContainer tileContainer, ITilePart parent) {
		this.parentPartContainer = tileContainer;
		this.parent = parent;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#setParentPartContainer(org.eclipse.papyrus.sasheditor.sash.TilePartContainer) TODO Remove this method.
	 */
	public void setParentPartContainer(TilePartContainer rootContainer) {
		this.parentPartContainer = rootContainer;

	}

	/**
	 * @return the parentPartContainer
	 */
	public TilePartContainer getParentPartContainer() {
		return parentPartContainer;
	}

	/**
	 * Return the parent of this ITilePart.
	 * 
	 * @return the parent
	 */
	public ITilePart getParent() {
		return parent;
	}

	/**
	 * Orphan this node. The parent is set to null, but control is left unchanged. The node can be reattached with reparent().
	 * 
	 * @see
	 * @return the parent
	 */
	public void orphan() {

		// orphan only if we are in UNCHANGED state
		if (garbageState == ITilePart.GarbageState.UNCHANGED) {
			garbageState = ITilePart.GarbageState.ORPHANED;
			parent = null;
		}
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getGarbageState()
	 */
	public GarbageState getGarbageState() {
		return garbageState;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#isOrphaned()
	 */
	public boolean isOrphaned() {
		return garbageState == ITilePart.GarbageState.ORPHANED;
	}

	/**
	 * Change the parent of this method.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#reparent(org.eclipse.papyrus.sasheditor.sash.ITilePart)
	 */
	public void reparent(ITilePart newParent) {
		parent = newParent;
		// Create control if needed
		// This can happen if the TilePart is just created after a refresh
		if (getControl() == null) {
			// createControl();
		}
		// Reparent the control
		getControl().setParent(newParent.getControl());
	}

	/**
	 * Get the factory used to create TilePart.
	 */
	public ITilePartFactory getTilePartFactory() {
		return parentPartContainer.getTilePartFactory();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createPartControl(org.eclipse.swt.widgets.Control)
	 */
	public abstract void createPartControl(Composite parent);

}
