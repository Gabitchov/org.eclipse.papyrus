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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.dnd.IDropTarget;

/**
 * Part used as root. This is the one with no parent and no model. This class is intended for local use only.
 * 
 * @author dumoulin
 * 
 */
public class RootPart implements ITilePart {

	/** The SWT container used as parent of all */
	protected Composite rootContainer;

	/** The model used by this node */
	protected ISashWindowsModelManager model;

	/** Factory used to create Part */
	protected ITilePartFactory tilePartfactory;

	/**
	 * The first SWT controled part;
	 */
	protected ITilePart child;

	/**
	 * Constructor.
	 */
	public RootPart(ITilePartFactory tilePartfactory, ISashWindowsModelManager model) {
		this.model = model;
		this.tilePartfactory = tilePartfactory;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		this.rootContainer = parent;
		Object realModel = model.getModelRoot();
		child = getTilePartFactory().createTilePart(this, realModel);
		child.createPartControl(rootContainer);
	}

	/**
	 * Do nothing, as there is no control associated to this part.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		// Do nothing, as there is no control associated to this part.

	}

	/**
	 * Return true if the TilePart is for the specified real model. Return false otherwise.
	 * 
	 * @param model
	 * @return
	 */
	public boolean isTilePartFor(Object realModel) {
		return model.getModelRoot() == realModel;
	}

	/**
	 * Synchronize the
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#synchronize2(org.eclipse.papyrus.sasheditor.sash.PartMap)
	 */
	public void synchronize2(PartMap partMap) {

		// Synchronize locally the child
		synchronizeChild(partMap);
		// Synchronize recursively subchilds.
		child.synchronize2(partMap);

	}

	/**
	 * Synchronize locally the child
	 * 
	 * @param partMap
	 */
	private void synchronizeChild(PartMap partMap) {
		Object newModel = model.getModelRoot();

		// Check if old child exist
		// If exist, check if the current part is associated to the checked model
		// 
		if (child != null) {
			// If the tile is already for the model, there is nothing to do.
			if (child.isTilePartFor(newModel))
				return;
			// The current tile is not for the model: mark it as orphan
			child.orphan();
		}

		// The child tile need to be updated. Do it.
		// First check if already exist in the map
		ITilePart newTile = partMap.findTilePart(newModel);
		if (newTile != null) {
			// Reparent the tile
			newTile.reparent(this, getChildParent());
		} else {
			// create the tile and its control
			newTile = getTilePartFactory().createTilePart(this, newModel);
			newTile.createControl(getChildParent());
		}

		// Now, put the tile on the right side
		setChild(newTile);
	}

	/**
	 * Set the child. If a child already exist at the specified index, it is lost.
	 * 
	 * @param newTile
	 */
	private void setChild(ITilePart newTile) {
		child = newTile;
	}

	/**
	 * Get the Composite used as parent for childs.
	 * 
	 * @return
	 */
	private Composite getChildParent() {
		// This is the rootContainer
		return rootContainer;
	}

	/**
	 * @return
	 */
	private ITilePartFactory getTilePartFactory() {
		return tilePartfactory;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#dispose()
	 */
	public void dispose(boolean isRecursive) {

		if (isRecursive)
			child.dispose(true);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#fillPartMap(org.eclipse.papyrus.sasheditor.sash.PartMap)
	 */
	public void fillPartMap(PartMap partMap) {
		child.fillPartMap(partMap);

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(org.eclipse.swt.graphics.Point)
	 */
	public ITilePart findPart(Point toFind) {
		return child.findPart(toFind);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(java.lang.Object)
	 */
	public ITilePart findPart(Object control) {
		return child.findPart(control);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getActiveEditor()
	 */
	public IEditorPart getActiveEditor() {
		return child.getActiveEditor();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getControl()
	 */
	public Composite getControl() {
		return rootContainer;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getDropTarget(java.lang.Object, org.eclipse.papyrus.sasheditor.sash.TabFolderPart, org.eclipse.swt.graphics.Point)
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart sourcePart, Point position) {
		return child.getDropTarget(draggedObject, sourcePart, position);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#isDirty()
	 */
	public boolean isDirty() {
		return child.isDirty();
	}

	/**
	 * Do nothing. This node can't be orphaned
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#orphan()
	 */
	public void orphan() {
		// Do nothing. This node can't be orphaned
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#isOrphaned()
	 */
	public boolean isOrphaned() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#refreshTabs()
	 */
	public void refreshTabs() {
		child.refreshTabs();

	}

	/**
	 * Do nothing. This node can't be reparented
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#reparent(org.eclipse.papyrus.sasheditor.sash.ITilePart)
	 */
	public void reparent(ITilePart newParent, Composite compositeParent) {
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#setFocus()
	 */
	public void setFocus() {
		child.setFocus();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#setParentPartContainer(org.eclipse.papyrus.sasheditor.sash.TilePartContainer)
	 */
	public void setParentPartContainer(TilePartContainer rootContainer) {

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getGarbageState()
	 */
	public GarbageState getGarbageState() {
		return GarbageState.UNCHANGED;
	}

}
